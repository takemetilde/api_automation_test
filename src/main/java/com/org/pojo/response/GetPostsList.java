package com.org.pojo.response;

import java.util.ArrayList;
import java.util.List;

public class GetPostsList {

    List<GetPosts> postsList = new ArrayList<GetPosts>();

    public GetPostsList() {
    }

    public GetPostsList(List<GetPosts> postsList) {
        this.postsList = postsList;
    }

    public List<GetPosts> getPostsList() {
        return postsList;
    }

    public void setPostsList(List<GetPosts> getPosts) {
        postsList = getPosts;
    }

    @Override
    public String toString() {
        return "PostsList{" +
                "postsList=" + postsList +
                '}';
    }
}
