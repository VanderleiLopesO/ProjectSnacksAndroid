package tech.alvarez.pokedex;

import java.util.List;

import retrofit2.Call;
import tech.alvarez.pokedex.models.Snack;

public interface SnackRepository {

    Call<List<Snack>> getSnacks();

}
