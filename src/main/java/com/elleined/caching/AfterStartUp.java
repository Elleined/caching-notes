package com.elleined.caching;

import com.elleined.caching.populator.PersonPopulator;
import com.elleined.caching.repository.PersonRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class AfterStartUp {

    private final CacheManager cacheManager;

    private final PersonRepository personRepository;
    private final PersonPopulator personPopulator;

    @PostConstruct
    void init() {
        System.out.println("Clearing cache... Please wait");
        cacheManager.getCacheNames()
                .parallelStream()
                .forEach(cacheName -> Objects.requireNonNull(cacheManager.getCache(cacheName)).clear());
        System.out.println("Clearing cache... Done");

        if (personRepository.existsById(1)) {
            System.out.println("Returning because the pre-defined persons are already been saved...");
            return;
        }
        System.out.println("Saving pre-defined persons... Please wait!");
        personPopulator.populate();
        System.out.println("Saving pre-defined persons... Success!");
    }
}
