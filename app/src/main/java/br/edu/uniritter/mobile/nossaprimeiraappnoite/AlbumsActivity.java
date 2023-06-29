package br.edu.uniritter.mobile.nossaprimeiraappnoite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import java.util.List;
import br.edu.uniritter.mobile.nossaprimeiraappnoite.adapter.AlbumsAdapter;
import br.edu.uniritter.mobile.nossaprimeiraappnoite.model.Album;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);

        Api api = ApiClient.getClient().create(Api.class);
        Call<List<Album>> call = api.getAlbums();
        call.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(@NonNull Call<List<Album>> call, @NonNull Response<List<Album>> response) {
                if (response.body() == null) {
                    return;
                }

                fillList(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<Album>> call, @NonNull Throwable t) {
                Log.e("Evandro", "Falha ao obter albums.");
            }
        });
    }

    public void fillList(List<Album> list) {
        RecyclerView rv = findViewById(R.id.rvAlbums);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        AlbumsAdapter albumsAdapter = new AlbumsAdapter(list);
        rv.setAdapter(albumsAdapter);
    }

}