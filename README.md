# wdogs
Following environment parameters expected:
- DOGS_DATABASE_HOST - database host
- DOGS_DATABASE_PORT - database port
- DOGS_DATABASE_USER - database user
- DOGS_DATABASE_PWD  - database password

Using maven in dogs module directory:
mvn -DDOGS_DATABASE_HOST=<host> -DDOGS_DATABASE_PORT=<port> -DDOGS_DATABASE_USER=<user> -DDOGS_DATABASE_PWD=<pwd> spring-boot:run
