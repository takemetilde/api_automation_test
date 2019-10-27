package com.org.client.rest;

import com.org.pojo.response.GetPosts;
import com.org.pojo.response.GetPostsList;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;

import static io.restassured.RestAssured.given;

/**
 * Convenience methods for returning Posts entities.
 */
public class JsonPlaceholderRestClient {

    private static final String baseURL = "https://jsonplaceholder.typicode.com";
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

    private static RequestSpecification spec = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .setBaseUri(baseURI)
            .addFilter(new ResponseLoggingFilter())
            .addFilter(new RequestLoggingFilter())
            .build();

    public static Response getPostsResponse(int id) {
        return given()
                    .spec(spec)
                    .contentType(ContentType.JSON)
                    .pathParam("id", id).
                when()
                    .get("/posts/{id}");
    }

    public static GetPosts getPostsEntity(int id) {
        return getPostsResponse(id)
                .then()
                    .statusCode(200)
                .extract()
                    .as(GetPosts.class);
    }

    public static Response getPostListsResponse() {
        return given()
                    .spec(spec)
                    .contentType(ContentType.JSON)
                .when()
                    .get("/posts");
    }

    public static GetPostsList getPostsListEntity() {
        return getPostListsResponse()
                .then()
                    .statusCode(200)
                .extract()
                    .as(GetPostsList.class);
    }

}
