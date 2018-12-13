package com.example.nibali.constraint_examples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.example.nibali.constraint_examples.adapters.PostAdapter;
import com.example.nibali.constraint_examples.pojo.Post;
import com.example.nibali.constraint_examples.pojo.User;

import java.util.Arrays;
import java.util.List;

public class PostsActivity extends AppCompatActivity {

    private  RecyclerView recyclerView;
    private PostAdapter postAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        postAdapter = new PostAdapter(getPosts());
        recyclerView = findViewById(R.id.recycler_view_posts);
        recyclerView.setAdapter(postAdapter);
    }

    /** заглушка для списка постов**/
    private List<Post> getPosts(){
        return Arrays.asList(
                new Post(getUser(), 1L, "Dec 13", "Очень длинное описание твита 1",
                        4L, 4L, "https://www.w3schools.com/w3css/img_fjords.jpg"),

                new Post(getUser(), 2L, "Dec 12", "Очень длинное описание твита 2",
                        5L, 5L, "https://www.w3schools.com/w3images/lights.jpg"),

                new Post(getUser(), 3L, "Dec 11", "Очень длинное описание твита 3",
                        6L, 6L, "https://www.w3schools.com/css/img_mountains.jpg")
        );
    }
    /** заглушка для юзера**/
    private User getUser() {
        return new User(
                1L,
                "http://i.imgur.com/DvpvklR.png",
                "DevColibri",
                "devcolibri",
                "Sample description",
                "USA",
                42,
                42
        );
    }
}
