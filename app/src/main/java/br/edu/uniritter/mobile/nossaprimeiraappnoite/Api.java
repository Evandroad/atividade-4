package br.edu.uniritter.mobile.nossaprimeiraappnoite;

import java.util.List;

import br.edu.uniritter.mobile.nossaprimeiraappnoite.model.Album;
import br.edu.uniritter.mobile.nossaprimeiraappnoite.model.Post;
import br.edu.uniritter.mobile.nossaprimeiraappnoite.model.Todo;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("/todos")
    Call<List<Todo>> getTodos();

    @GET("/albums")
    Call<List<Album>> getAlbums();

    @GET("/posts")
    Call<List<Post>> getPosts();

}