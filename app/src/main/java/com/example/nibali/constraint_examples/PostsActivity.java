package com.example.nibali.constraint_examples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.example.nibali.constraint_examples.adapters.PostAdapter;
import com.example.nibali.constraint_examples.pojo.Post;
import com.example.nibali.constraint_examples.pojo.User;
import com.example.nibali.constraint_examples.repository.IPostsRepository;
import com.example.nibali.constraint_examples.repository.impl.PostsRepository;

import java.util.Arrays;
import java.util.List;

public class PostsActivity extends AppCompatActivity {

    private  RecyclerView recyclerView;
    private PostAdapter postAdapter;
    private IPostsRepository postsRepository = new PostsRepository();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        postAdapter = new PostAdapter(postsRepository.getPosts());
        recyclerView = findViewById(R.id.recycler_view_posts);
        recyclerView.setAdapter(postAdapter);
    }

}
