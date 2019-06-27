package com.tsi.prototype.wdogs.dogs.dao;

import com.tsi.prototype.wdogs.dogs.model.Dog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DogsRepository extends CrudRepository<Dog, UUID> {

    List<Dog> findByName(String name);
}
