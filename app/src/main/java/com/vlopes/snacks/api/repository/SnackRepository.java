package com.vlopes.snacks.api.repository;

import java.util.List;

import rx.Observable;
import com.vlopes.snacks.models.Snack;

public interface SnackRepository {

    Observable<List<Snack>> getSnacks();

}
