package br.edu.uniritter.mobile.nossaprimeiraappnoite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Button todo = findViewById(R.id.btTodo);
        Button posts = findViewById(R.id.btPosts);
        Button albums = findViewById(R.id.btAlbums);

        todo.setOnClickListener(v -> goTo(TodoActivity.class));
        posts.setOnClickListener(v -> goTo(PostsActivity.class));
        albums.setOnClickListener(v -> goTo(AlbumsActivity.class));
    }

    public void goTo(Class<?> activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }

}