package com.org.client.rest;

import com.org.pojo.response.GetPosts;
import com.org.pojo.response.GetPostsList;
import io.restassured.RestAssured;

/**
 *
 */
public class RestClient {

    public static final String baseURL = "https://jsonplaceholder.typicode.com/posts/";

    public GetPosts getPostsEntity(int id) {
        return RestAssured.get(baseURL + id).as(GetPosts.class);
    }

    public GetPostsList getPostsListEntity() {
        return RestAssured.get(baseURL).as(GetPostsList.class);
    }

}
