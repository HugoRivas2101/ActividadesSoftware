package io.collective;

import java.time.Clock;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class SimpleAgedCache {
    private final Map<String, CacheEntry> cache;
    private final Clock clock;

    public SimpleAgedCache() {
        this.cache = new HashMap<>();
        this.clock = Clock.systemDefaultZone();
    }

    public SimpleAgedCache(Clock clock) {
        this.cache = new HashMap<>();
        this.clock = clock;
    }

    private static class CacheEntry {
        private final Object value;
        private final Instant expirationTime;

        public CacheEntry(Object value, Instant expirationTime) {
            this.value = value;
            this.expirationTime = expirationTime;
        }

        public boolean isExpired(Instant currentTime) {
            return currentTime.isAfter(expirationTime);
        }
    }

    public void put(String key, Object value, long durationMillis) {
        Instant expirationTime = clock.instant().plusMillis(durationMillis);
        cache.put(key, new CacheEntry(value, expirationTime));
    }

    public Object get(String key) {
        CacheEntry entry = cache.get(key);
        if (entry != null && !entry.isExpired(clock.instant())) {
            return entry.value;
        } else {
            cache.remove(key);
            return null;
        }
    }

    public boolean isEmpty() {
        return cache.isEmpty();
    }

    public int size() {
        return cache.size();
    }

}
