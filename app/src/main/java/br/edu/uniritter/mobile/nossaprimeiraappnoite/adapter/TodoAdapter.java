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
import br.edu.uniritter.mobile.nossaprimeiraappnoite.model.Todo;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {

    private final List<Todo> listTodos;

    public static class TodoViewHolder extends RecyclerView.ViewHolder {
        public View viewTodo;
        public TodoViewHolder(@NonNull View itemView) {
            super(itemView);
            this.viewTodo = itemView;
        }
    }

    public TodoAdapter(List<Todo> todos) { this.listTodos = todos; }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_detalhe_todo, parent, false);
        return new TodoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        Todo obj = this.listTodos.get(position);
        TextView tv = holder.viewTodo.findViewById(R.id.tvId);
        tv.setText(String.valueOf(obj.getId()));
        tv = holder.viewTodo.findViewById(R.id.tvIdUser);
        tv.setText(String.valueOf(obj.getUserId()));
        tv = holder.viewTodo.findViewById(R.id.tvTitle);
        tv.setText(obj.getTitle());
        CheckBox cb = holder.viewTodo.findViewById(R.id.cbCompleted);
        cb.setChecked(obj.isCompleted());
    }

    @Override
    public int getItemCount() { return this.listTodos.size(); }

}