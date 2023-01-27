## Study project to create a server based on webflux throughout its processing cycle.
### Through the docker-compose file, it is possible to initialize two replicas of the application where they will be exposed on port 8080 and 8081 of your machine.
### The applications are identical, with the exception of the APPLICATION_SPECIFICATIONS_QUERY_PARAM parameter, which creates a query with a filter in the database.
### Before running `docker-compose up --build` you need to run mvn `clean install` command