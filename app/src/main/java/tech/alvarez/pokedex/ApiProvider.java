package tech.alvarez.pokedex;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import tech.alvarez.pokedex.pokeapi.UserApi;

public class ApiProvider {

    protected static UserApi mService;

    public static UserApi getApi() {
        return mService;
    }

    public static Retrofit getRetrofitInstance(String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .build();
    }

}
