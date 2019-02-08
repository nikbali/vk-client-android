package com.example.nibali.constraint_examples.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.example.nibali.constraint_examples.databinding.PostItemBinding;
import com.example.nibali.constraint_examples.entity.Post;

public class PostHolder extends RecyclerView.ViewHolder  {

    private PostItemBinding postItemBinding;

    PostHolder(@NonNull PostItemBinding postItemBinding) {
        super(postItemBinding.getRoot());
        this.postItemBinding = postItemBinding;
    }

    public void binding(Post post){
        postItemBinding.setPost(post);
        postItemBinding.executePendingBindings();
    }
}
