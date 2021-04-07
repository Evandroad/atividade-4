package br.edu.uniritter.mobile.nossaprimeiraappnoite.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import br.edu.uniritter.mobile.nossaprimeiraappnoite.R;
import br.edu.uniritter.mobile.nossaprimeiraappnoite.model.Posts;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsViewHolder>{

    private final List<Posts> listaPosts;

    public static class PostsViewHolder extends RecyclerView.ViewHolder {
        public View viewPosts;
        public PostsViewHolder(@NonNull View itemView) {
            super(itemView);
            this.viewPosts = itemView;
        }
    }

    public PostsAdapter(List<Posts> posts) {
        this.listaPosts = posts;
    }


    @NonNull
    @Override
    public PostsAdapter.PostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_detalhe_posts, parent, false);
        return new PostsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PostsAdapter.PostsViewHolder holder, int position) {
        Posts obj = this.listaPosts.get(position);
        TextView tv = holder.viewPosts.findViewById(R.id.tvId);
        tv.setText(obj.getId()+"");
        tv = holder.viewPosts.findViewById(R.id.tvIdUser);
        tv.setText(obj.getUserId()+"");
        tv = holder.viewPosts.findViewById(R.id.tvTitle);
        tv.setText(obj.getTitle());
        tv = holder.viewPosts.findViewById(R.id.tvBody);
        tv.setText(obj.getBody());

    }

    @Override
    public int getItemCount() {
        return this.listaPosts.size();
    }
}
