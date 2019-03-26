package com.vlopes.snacks.api.repository;

import java.util.List;

import rx.Observable;

import com.vlopes.snacks.api.ApiProvider;
import com.vlopes.snacks.models.Snack;
import com.vlopes.snacks.api.UserApi;

public class SnackRepositoryImpl implements SnackRepository {

    protected UserApi mApi;

    public SnackRepositoryImpl() {
        mApi = ApiProvider.getApi();
    }

    public SnackRepositoryImpl(UserApi api) {
        mApi = api;
    }

    @Override
    public Observable<List<Snack>> getSnacks() {
        return mApi.getSnacks();
    }
}
