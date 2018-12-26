package com.example.nibali.constraint_examples.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nibali.constraint_examples.R;
import com.example.nibali.constraint_examples.pojo.Post;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostHolder>  {

    private List<Post> posts = new ArrayList<>();

    public PostAdapter(List<Post> posts) {
        this.posts = posts;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View viewItem = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.post_item_view,viewGroup, false );
        return new PostHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder postHolder, int i) {
        postHolder.binding(posts.get(i));
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }
}
