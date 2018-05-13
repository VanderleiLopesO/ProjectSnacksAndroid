package tech.alvarez.pokedex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.internal.operators.OnSubscribeConcatMap;
import rx.schedulers.Schedulers;
import tech.alvarez.pokedex.models.Snack;
import tech.alvarez.pokedex.pokeapi.UserApi;

import static tech.alvarez.pokedex.Constants.BASE_URL;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "POKEDEX";

    private Retrofit retrofit;

    private RecyclerView recyclerView;
    private MainAdapter listaPokemonAdapter;

    private int offset;

    private boolean aptoParaCargar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       /* recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        listaPokemonAdapter = new MainAdapter(this);
        recyclerView.setAdapter(listaPokemonAdapter);
        recyclerView.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy > 0) {
                    int visibleItemCount = layoutManager.getChildCount();
                    int totalItemCount = layoutManager.getItemCount();
                    int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();

                    if (aptoParaCargar) {
                        if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                            Log.i(TAG, " Llegamos al final.");

                            aptoParaCargar = false;
                            offset += 20;
                            obtenerDatos(offset);
                        }
                    }
                }
            }
        });*/


        retrofit = ApiProvider.getRetrofitInstance(BASE_URL);
        UserApi service = retrofit.create(UserApi.class);

        rx.Observable<List<Snack>> observable = service.getSnacks();
        observable.subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
        observable.subscribe(new MainSubscriber());

        callback.enqueue(new Callback<List<Snack>>() {
            @Override
            public void onResponse(Call<List<Snack>> call, Response<List<Snack>> response) {
                Toast.makeText(MainActivity.this, "DEU BOM", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Snack>> call, Throwable t) {
                Log.e("xerere", t.getMessage());
                Toast.makeText(MainActivity.this, "Deu ruim", Toast.LENGTH_SHORT).show();
            }
        });

    }

    protected class MainSubscriber extends Subscriber {

        @Override
        public void onCompleted() {
            Toast.makeText(MainActivity.this, "Carregado com sucesso", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(Object o) {
            Toast.makeText(MainActivity.this, "Deu bom", Toast.LENGTH_SHORT).show();
            List<Snack> pokemonRespuesta = o.body();
            ArrayList<Snack> listaPokemon = (ArrayList<Snack>) pokemonRespuesta;

            listaPokemonAdapter.adicionarListaPokemon(listaPokemon);
        }
    }

}
