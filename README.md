# caching-notes
Demo project with notes that implements caching 

# What is caching
- Caching is used to reduce the load in database and network call because it will first check in cache if the same data is requested instead of multiple call in database and network call. Thus reducing the database and network calls which is a slow.

## In memory caching
- Data is stored in RAM.
- Redis is widely known with this type of caching

## Database Caching
- Hibernate has first level caching by default

## Annotations
- `@Cacheable`: = Get
- `@CacheEvict`: = Delete
- `@CachePut`: = Put
- `@Caching`: grouper like @Mappings in mapstruct

# To use caching
1. Annotate your applivation with @EnableCaching
2. Annotate your methods with appropriate Caching Annotations.

# Useful Links
[Hibernate 2nd level caching 1](https://medium.com/@shahto/scaling-spring-boot-with-hibernate-2nd-level-cache-on-redis-54d588fc8b06#:~:text=Level%202%20Cache%3A%20is%20a,is%20therefore%20disabled%20by%20default.)
[Hibernate 2nd level caching 2](https://medium.com/@dennisholee/hibernate-level-2-cache-3dc284bdd416)
[Service level caching 1](https://medium.com/vedity/spring-boot-caching-mechanism-8ef901147e60)  
[Service level caching 2](https://medium.com/javajams/how-to-supercharge-your-spring-boot-app-with-3-proven-optimization-techniques-95e00aaf22e2)  
