package com.storage.kaktusv6.storage.interfaces;

import com.storage.kaktusv6.storage.structure.GithubUser;
import com.storage.kaktusv6.storage.structure.Item;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitApiInterface {
    @GET("/users/{username}")
    Call<GithubUser> getUser(@Path("username") String username);

    @GET("list")
    Call<ArrayList<Item>> getJSON();
}