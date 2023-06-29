package br.edu.uniritter.mobile.nossaprimeiraappnoite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import java.util.List;
import br.edu.uniritter.mobile.nossaprimeiraappnoite.adapter.PostsAdapter;
import br.edu.uniritter.mobile.nossaprimeiraappnoite.model.Post;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        Api api = ApiClient.getClient().create(Api.class);
        Call<List<Post>> call = api.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(@NonNull Call<List<Post>> call, @NonNull Response<List<Post>> response) {
                if (response.body() == null) {
                    return;
                }

                fillList(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<Post>> call, @NonNull Throwable t) {
                Log.e("Evandro", "Falha ao obter posts.");
            }
        });
    }

    public void fillList(List<Post> list) {
        RecyclerView rv = findViewById(R.id.rvPosts);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        PostsAdapter postsAdapter = new PostsAdapter(list);
        rv.setAdapter(postsAdapter);
    }

}