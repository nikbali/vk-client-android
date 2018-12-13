package com.example.nibali.constraint_examples.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nibali.constraint_examples.R;
import com.example.nibali.constraint_examples.pojo.Post;
import com.squareup.picasso.Picasso;

public class PostHolder extends RecyclerView.ViewHolder  {

    private ImageView userImageView;
    private TextView nameTextView;
    private TextView nickNameTextView;
    private TextView creationDateTextView;
    private TextView contentTextView;
    private ImageView postImageView;
    private TextView retweetTextView;
    private TextView likeTextView;

    PostHolder(@NonNull View itemView) {
        super(itemView);
        userImageView = itemView.findViewById(R.id.userImageView);
        nameTextView = itemView.findViewById(R.id.nameTextView);
        nickNameTextView = itemView.findViewById(R.id.nickNameTextView);
        creationDateTextView = itemView.findViewById(R.id.creationDateTextView);
        contentTextView = itemView.findViewById(R.id.contentTextView);
        postImageView = itemView.findViewById(R.id.postImageView);
        retweetTextView = itemView.findViewById(R.id.retweetTextView);
        likeTextView = itemView.findViewById(R.id.likeTextView);
    }

    public void binding(Post post){
        nameTextView.setText(post.getUser().getName());
        nickNameTextView.setText(post.getUser().getNick());
        contentTextView.setText(post.getText());
        retweetTextView.setText(String.valueOf(post.getRetweetCount()));
        likeTextView.setText(String.valueOf(post.getFavouriteCount()));
        creationDateTextView.setText(post.getCreationDate());

        Picasso.get().load(post.getUser().getImageUrl()).into(userImageView);

        String tweetPhotoUrl = post.getImageUrl();
        Picasso.get().load(tweetPhotoUrl).into(postImageView);

        postImageView.setVisibility(tweetPhotoUrl != null ? View.VISIBLE : View.GONE);
    }
}
