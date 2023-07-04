package com.example.safeteenbackend.domain.refresh;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash
@AllArgsConstructor
@Builder
@Getter
public class RefreshToken {
    @Id
    private String token;

    @Indexed
    private String email;

    @TimeToLive
    private Long expiration;
}
