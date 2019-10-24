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

    private static final String baseURL = "https://jsonplaceholder.typicode.com/posts/";
    private static URI baseURI = checkURI(baseURL);

    public static URI checkURI(String uri) {
        URI returnURI = null;
        try {
            returnURI = new URI(uri);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return returnURI;
    }

    public static GetPosts getPostsEntity(int id) {
        return given().
                    contentType("application/json").
                    pathParam("id", id).
                when().
                    get(baseURL + "{id}").
                    as(GetPosts.class);
    }

    public static String getPostsResponse(int id) {
        return given().
                contentType("application/json").
                pathParam("id", id).
                when().
                get(baseURL + "{id}").
                prettyPrint();
    }

    public static GetPostsList getPostsListEntity() {
        return given().
                    contentType("application/json").
                when().
                    get(baseURL).
                    as(GetPostsList.class);
    }

}
