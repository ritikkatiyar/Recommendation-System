package com.fitness.activityservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserValidationService {

    private final WebClient.Builder webClientBuilder;

    public boolean validateUser(String userId) {
        log.info("Calling User Validation API for userId: {}", userId);

        try {
            return webClientBuilder
                    .baseUrl("http://USER-SERVICE") // must match Eureka
                    .build()
                    .get()
                    .uri("/api/users/{userId}/validate", userId)
                    .retrieve()
                    .bodyToMono(Boolean.class)
                    .block();
        } catch (WebClientResponseException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND)
                throw new RuntimeException("User Not Found: " + userId);
            else if (e.getStatusCode() == HttpStatus.BAD_REQUEST)
                throw new RuntimeException("Invalid Request: " + userId);
        }
        return false;
    }
}
