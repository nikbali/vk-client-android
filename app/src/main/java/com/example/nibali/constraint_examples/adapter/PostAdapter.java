package com.example.nibali.constraint_examples.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.nibali.constraint_examples.R;
import com.example.nibali.constraint_examples.databinding.PostItemBinding;
import com.example.nibali.constraint_examples.entity.Post;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostHolder>  {

    private List<Post> posts;

    public PostAdapter(List<Post> posts) {
        this.posts = posts;
    }

    public void setData(List<Post> data) {
        posts.clear();
        posts.addAll(data);
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        PostItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.post_item, viewGroup, false);
        return new PostHolder(binding);
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
