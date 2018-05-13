package tech.alvarez.pokedex;

import java.util.List;

import retrofit2.Call;
import tech.alvarez.pokedex.models.Snack;
import tech.alvarez.pokedex.pokeapi.UserApi;

public class SnackRepositoryImpl implements SnackRepository {

    protected UserApi mApi;

    public SnackRepositoryImpl() {
        mApi = ApiProvider.getApi();
    }

    public SnackRepositoryImpl(UserApi api) {
        mApi = api;
    }

    @Override
    public Call<List<Snack>> getSnacks() {
        return mApi.getSnacks();
    }
}
