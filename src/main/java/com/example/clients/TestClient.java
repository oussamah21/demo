package com.example.clients;


import io.github.resilience4j.micronaut.annotation.CircuitBreaker;
import io.micronaut.context.annotation.Executable;
import io.micronaut.http.HttpRequest;


import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.rxjava3.http.client.Rx3HttpClient;
import io.reactivex.rxjava3.core.Single;
import jakarta.inject.Singleton;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;


@Singleton
@Slf4j
public class TestClient {

    @Getter
    @Setter
    private Rx3HttpClient rxHttpClient;

    public TestClient(@Client("${alert.client.url}") Rx3HttpClient httpClient) {
        this.rxHttpClient = httpClient;
    }

    @CircuitBreaker(name = "test", fallbackMethod = "getSharedAlertsClientFallback")
    @Get
    public Single<String> getProfile() {
        HttpRequest<?> req = HttpRequest.GET("/test");
        return rxHttpClient.retrieve(req).firstOrError();
    }

    @Executable
    public Single<String> getSharedAlertsClientFallback() {
        log.warn("Circuit breaker {} is activated", "test");

        log.warn("using fallback...");
        return Single.error(new Exception("test circuit breaker"));
    }
}
