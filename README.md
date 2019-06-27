# wdogs
Following environment parameters expected:
- DOGS_DATABASE_HOST - database host
- DOGS_DATABASE_PORT - database port
- DOGS_DATABASE_USER - database user
- DOGS_DATABASE_PWD  - database password

Building project: mvn clean install. This will create docker image.

Using maven in dogs module directory:
mvn -DDOGS_DATABASE_HOST=<host> -DDOGS_DATABASE_PORT=<port> -DDOGS_DATABASE_USER=<user> -DDOGS_DATABASE_PWD=<pwd> spring-boot:run

Using docker
docker run --env DOGS_DATABASE_HOST=<host> --env DOGS_DATABASE_PORT=<port> --env DOGS_DATABASE_USER=<user> --env DOGS_DATABASE_PWD=<pwd> tsi/dogs

