package com.example.nibali.constraint_examples.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.nibali.constraint_examples.R;
import com.example.nibali.constraint_examples.adapter.PostAdapter;
import com.example.nibali.constraint_examples.repository.IPostsRepository;
import com.example.nibali.constraint_examples.repository.impl.PostsRepository;

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
