package com.ukg.http;

import java.io.IOException;
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
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            //print all response details
            var body = response.body();
            System.out.println(body);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class HTTPClientGet {
    public static void main(String[] args) {
        var todoService = new TodoService();
        todoService.getAllTodos();
    }
}
