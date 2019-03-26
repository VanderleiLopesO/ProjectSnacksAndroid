package com.vlopes.snacks.api;

import java.util.List;

import retrofit2.http.GET;

import com.vlopes.snacks.models.Snack;

import static com.vlopes.snacks.utiils.Constants.SNACK_ENDPOINT;

public interface UserApi {
    @GET(SNACK_ENDPOINT)
    rx.Observable<List<Snack>> getSnacks();
}
