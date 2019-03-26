package com.vlopes.snacks.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Retrofit;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import com.vlopes.snacks.R;
import com.vlopes.snacks.api.ApiProvider;
import com.vlopes.snacks.models.Snack;
import com.vlopes.snacks.api.UserApi;

import static com.vlopes.snacks.utiils.Constants.BASE_URL;

public class MainActivity extends AppCompatActivity {

    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofit = ApiProvider.getRetrofitInstance(BASE_URL);
        UserApi service = retrofit.create(UserApi.class);

        rx.Observable<List<Snack>> observable = service.getSnacks();
        observable.subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new MainSubscriber());
    }

    protected class MainSubscriber extends Subscriber {

        @Override
        public void onCompleted() {
            Toast.makeText(MainActivity.this, "Carregado com sucesso", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(Throwable e) {
            Toast.makeText(MainActivity.this, "Passou no onError", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNext(Object o) {
            Toast.makeText(MainActivity.this, "Passou no onNext", Toast.LENGTH_SHORT).show();
        }
    }

}
