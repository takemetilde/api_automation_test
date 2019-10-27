package com.org.client.rest;

import com.org.pojo.response.GetPosts;
import org.testng.annotations.Test;

import static com.org.client.rest.JsonPlaceholderRestClient.*;

public class JsonPlaceholderRestClientTest {

    @Test
    public void testJsonPlaceholderRestClient() {
        System.out.println("Entity: \n" + getPostsEntity(1));
        getPostsListEntity();
    }
}
