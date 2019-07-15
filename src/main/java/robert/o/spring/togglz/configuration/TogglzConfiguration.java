package robert.o.spring.togglz.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.togglz.core.manager.EnumBasedFeatureProvider;
import org.togglz.core.repository.StateRepository;
import org.togglz.core.spi.FeatureProvider;
import org.togglz.redis.RedisStateRepository;
import redis.clients.jedis.JedisPool;
import robert.o.spring.togglz.feature.TogglzFeature;

@Configuration
public class TogglzConfiguration {

    @Bean
    public FeatureProvider featureProvider() {

        return new EnumBasedFeatureProvider(TogglzFeature.class);
    }

    @Bean
    public StateRepository redisStateRepository(@Value("${redis.server.host}") String redisHost) {

        return new RedisStateRepository.Builder()
                .jedisPool(new JedisPool(redisHost))
                .build();
    }
}
