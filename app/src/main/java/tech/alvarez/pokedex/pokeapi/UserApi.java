package tech.alvarez.pokedex.pokeapi;

import java.util.List;
import java.util.Observable;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import tech.alvarez.pokedex.models.Snack;
import tech.alvarez.pokedex.models.SnackResponse;

import static tech.alvarez.pokedex.Constants.SNACK_ENDPOINT;

public interface UserApi {

    @GET(SNACK_ENDPOINT)
    rx.Observable<List<Snack>> getSnacks();

}
