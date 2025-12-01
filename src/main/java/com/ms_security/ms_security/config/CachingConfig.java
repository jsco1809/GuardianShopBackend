package com.ms_security.ms_security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate7.Hibernate7Module;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

@Configuration
public class CachingConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new Hibernate7Module());
        mapper.findAndRegisterModules();
        return mapper;
    }

    @Bean
    public RedisCacheManager redisCacheManager(RedisConnectionFactory connectionFactory) {
        RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.json()))
                .entryTtl(Duration.ofMinutes(15))
                .disableCachingNullValues();

        return RedisCacheManager.builder(connectionFactory)
                .cacheDefaults(cacheConfiguration)
                .build();
    }

    @Bean
    public CacheManager cacheManager() {
        ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager() {
            @Override
            protected Cache createConcurrentMapCache(String name) {
                return new ConcurrentMapCache(name, true);
            }
        };

        List<String> cacheNames = Arrays.asList(
                "ContactFormFindById",
                "ContactFormFindAll",
                "ContactFormFindByEmail",
                "PermissionFindById",
                "PermissionFindAll",
                "PermissionFindByName",
                "PermissionFindByRoleId",
                "RoleFindById",
                "RoleFindAll",
                "RoleFindByName",
                "RoleFindRoleWithPermissionById",
                "ServicesFindById",
                "ServicesFindByAll",
                "ServicesFindByCode",
                "ServicesFindByName",
                "ServiceFindByCategoryId",
                "ServiceFindByCodeAndCategoryId",
                "UserFindById",
                "UserFindByAll",
                "UserFindByUserName",
                "UserFindUserWithRolesById",
                "UserFindByEmail",
                "InventoryFindById",
                "InventoryFindAll",
                "InventoryFindByCode",
                "InventoryFindAllByIds",
                "InventoryFindAllByServiceId",
                "CategoryFindById",
                "CategoryFindAll",
                "CategoryFindByName",
                "CartFindById",
                "CartFindAll",
                "CartFindByUserName",
                "OrderFindById",
                "OrderFindAll",
                "OrderMaxNumber",
                "OrderFindByOrderNumber",
                "OrderFindAllByStatus",
                "OrderFindByOrderNumberWithItems",
                "OrderItemFindById",
                "OrderItemFindAll",
                "OrderItemFindByProductAndCart",
                "OrderItemFindByOrderId",
                "OrderItemFindByCartAndUser",
                "OrderItemFindByCartIdPage",
                "OrderItemFindByCartId",
                "EntriesFindById",
                "EntriesFindAll",
                "EntriesFindByInvoiceNumber",
                "EntriesConsecutive",
                "ExitsFindById",
                "ExitsFindAll",
                "ExitsConsecutive",
                "ParametersFindById",
                "ParametersFindAll",
                "ParametersFindByCode"
        );

        cacheManager.setCacheNames(cacheNames);
        return cacheManager;
    }
}
