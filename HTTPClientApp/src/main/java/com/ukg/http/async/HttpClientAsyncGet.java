package com.ukg.http.async;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.net.http.HttpClient.Redirect.NORMAL;
import static java.net.http.HttpClient.Version.HTTP_1_1;
import static java.time.Duration.ofSeconds;

class TodoService {
    HttpClient httpClient;

    public TodoService() {
        httpClient = HttpClient
                .newBuilder()
                .version(HTTP_1_1)
                .followRedirects(NORMAL)
                .connectTimeout(ofSeconds(20))
                .build();
    }

    public void getAllTodos() {
        var url = "https://jsonplaceholder.typicode.com/todos";
        var request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        //async pattern
//        CompletableFuture<HttpResponse<String>> response = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        var response = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(res -> {
                    System.out.println(Thread.currentThread().getName());
                    return res.body();
                })
                .thenAccept(System.out::println)
                .join();

    }
}

public class HttpClientAsyncGet {
    public static void main(String[] args) {
        var todoService = new TodoService();
        System.out.println("starts : " + Thread.currentThread().getName());
        todoService.getAllTodos();
        System.out.println("Ends : " + Thread.currentThread().getName());

    }
}
