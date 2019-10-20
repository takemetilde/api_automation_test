package com.org.client.rest;

import com.org.pojo.response.GetPosts;
import com.org.pojo.response.GetPostsList;

import java.net.URI;
import java.net.URISyntaxException;

import static io.restassured.RestAssured.given;

/**
 * Convenience methods for returning Posts entities.
 */
public class JsonPlaceholderRestClient {

    public static final String baseURL = "https://jsonplaceholder.typicode.com/posts/";
    public static URI baseURI;

    static {
        try {
            baseURI = new URI(baseURL);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public GetPosts getPostsEntity(int id) {
        return given().
                    contentType("application/json").
                    pathParam("id", id).
                when().
                    get(baseURL + "{id}").
                    as(GetPosts.class);
    }

    public GetPostsList getPostsListEntity() {
        return given().
                    contentType("application/json").
                when().
                    get(baseURL).
                    as(GetPostsList.class);
    }

}
