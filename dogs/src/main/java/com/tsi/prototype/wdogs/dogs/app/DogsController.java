package com.tsi.prototype.wdogs.dogs.app;

import com.tsi.prototype.wdogs.dogs.dao.DogsRepository;
import com.tsi.prototype.wdogs.dogs.model.Dog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Controller
@RequestMapping(path="/dogs")
public class DogsController {
    private final static Logger LOG = LoggerFactory.getLogger(DogsController.class);

    @Autowired
    private DogsRepository dogsRepository;

    @GetMapping(produces = "application/json")
    public @ResponseBody
    Iterable<Dog> getDogs(@RequestParam String name) {
        if (Objects.isNull(name)) {
            return dogsRepository.findAll();
        } else {
            return dogsRepository.findByName(name);
        }
    }

    @GetMapping(value = "/{name}", produces = "application/json")
    public @ResponseBody ResponseEntity<Dog> getPerName(@PathVariable String name) {
        List<Dog> dogs = dogsRepository.findByName(name);
        if (dogs.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(dogs.iterator().next());
    }


    @PostMapping()
    public @ResponseBody ResponseEntity addDog(Dog newDog) {
        UUID id = UUID.randomUUID();
        newDog.setId(id.toString());
        try {
            dogsRepository.save(newDog);
        } catch (Throwable e) {
            LOG.error("Exception occured saving dog", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").build(id);
        return ResponseEntity.status(HttpStatus.CREATED).header("Location",uri.toString()).build();
    }
}
