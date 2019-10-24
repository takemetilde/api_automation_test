package com.org.client.rest;

import org.junit.Test;

import static com.org.client.rest.JsonPlaceholderRestClient.getPostsEntity;
import static com.org.client.rest.JsonPlaceholderRestClient.getPostsResponse;

public class JsonPlaceholderRestClientTest {

    @Test
    public void testJsonPlaceholderRestClient() {
        System.out.println(getPostsEntity(1));
        getPostsResponse(1);
    }
}
