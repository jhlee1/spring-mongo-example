# spring-mongo-example
It is an example of how to connect to mongoDB on Spring Boot project


for applicaiton.xml files I did not put it here because I don't want my atlas credential is exposed.

Change the profile using ActiveProfiles in run configuration to `local` or `prod`

applicaiton-local.yml
```yml
spring:
  data:
    mongodb:
      uri: mongodb://boot_user:boot@localhost:27017/spring-mongo-example
```

application-prod.yml
```yml
spring:
  data:
    mongodb:
      uri: mongodb+srv://boot-user:boot@springbootexample-nysvl.mongodb.net/spring-mongo-example?retryWrites=true&w=majority
```
