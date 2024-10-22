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

# Caching annotation attributes
- value: specify a name for the cache
- key: defines how each entry of cache will be define uniquely.
- condition: defines a predicate based on method argument if true it will be cached else will not be cache.
- unless: defines a predicate based on method returned value if true will be not cached else will be cache.
- keyGenerator defines a user define key generator instead of using the spring default key generator which is the method parameter will be used as key.
- allEntries if sets to true all entries with the same name will be deleted.

# Difference between spring cache and hibernate L2 cache
## Hibernate L2 Cache
- Its mainly works in repository layer. caching the Model layer, the database operations accross SessionFactory. 
Why its called L2 cache because the L1 cache by hibernate is enabled by default and cannot be disabled its caching the current session only transaction after that when you create another session it the cached will not be accessible. 
Here's when L2 caching comes in, what L2 caching do is caching the database operation in SessionFactory level which means that all cache are accessible between different sessions. 

## Spring caching
- Its mainly works in service layer. caching the DTO layer, and uses the 4 cache annotation above.

# When to implement caching
- To the models that has high read and low write ratio, meaning that caching best performs when the model is frequently access and rarely changing data. Why?
its because saving, update and deleting data in cache is such a mess many things can happen and many aspect you should consider thats why its best use is reading.

  
# Useful Links
[Hibernate 2nd level caching 1](https://medium.com/@shahto/scaling-spring-boot-with-hibernate-2nd-level-cache-on-redis-54d588fc8b06#:~:text=Level%202%20Cache%3A%20is%20a,is%20therefore%20disabled%20by%20default.)  
[Hibernate 2nd level caching 2](https://medium.com/@dennisholee/hibernate-level-2-cache-3dc284bdd416)  
[Service level caching 1](https://medium.com/vedity/spring-boot-caching-mechanism-8ef901147e60)  
[Service level caching 2](https://medium.com/javajams/how-to-supercharge-your-spring-boot-app-with-3-proven-optimization-techniques-95e00aaf22e2)  
[Redis installation](https://redis.io/docs/latest/operate/oss_and_stack/install/install-redis/install-redis-on-linux/)  
