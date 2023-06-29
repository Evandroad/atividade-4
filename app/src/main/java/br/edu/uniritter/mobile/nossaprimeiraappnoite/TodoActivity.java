package br.edu.uniritter.mobile.nossaprimeiraappnoite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import java.util.List;

import br.edu.uniritter.mobile.nossaprimeiraappnoite.adapter.TodoAdapter;
import br.edu.uniritter.mobile.nossaprimeiraappnoite.model.Todo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TodoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        Api api = ApiClient.getClient().create(Api.class);
        Call<List<Todo>> call = api.getTodos();
        call.enqueue(new Callback<List<Todo>>() {
            @Override
            public void onResponse(@NonNull Call<List<Todo>> call, @NonNull Response<List<Todo>> response) {
                if (response.body() == null) {
                    return;
                }

                fillList(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<Todo>> call, @NonNull Throwable t) {
                Log.e("Evandro", "Falha ao obter todos.");
            }
        });
    }

    public void fillList(List<Todo> list) {
        RecyclerView rv = findViewById(R.id.rvTodos);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        TodoAdapter todoAdapter = new TodoAdapter(list);
        rv.setAdapter(todoAdapter);
    }

}