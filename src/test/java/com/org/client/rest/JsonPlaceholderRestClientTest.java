package com.org.client.rest;

import com.org.pojo.response.GetPosts;
import org.junit.Test;

import static com.org.client.rest.JsonPlaceholderRestClient.getPostsEntity;
import static com.org.client.rest.JsonPlaceholderRestClient.getPostsResponse;

public class JsonPlaceholderRestClientTest {

    @Test
    public void testJsonPlaceholderRestClient() {
        System.out.println("Entity: \n" + getPostsEntity(1));

        getPostsResponse(1).as(GetPosts.class);
    }
}
