package com.example.nibali.constraint_examples.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nibali.constraint_examples.R;
import com.example.nibali.constraint_examples.entity.Post;
import com.example.nibali.constraint_examples.utils.AppUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder>  {

    private List<Post> posts;

    public PostAdapter(List<Post> posts) {
        this.posts = posts;
    }

    public void setData(List<Post> data) {
        posts.clear();
        posts.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View viewItem = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.post_item,viewGroup, false );
        return new PostAdapter.PostHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder postHolder, int i) {
        postHolder.binding(posts.get(i));
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }




    class PostHolder extends RecyclerView.ViewHolder  {
        private ImageView ownerAvatarImageView;
        private TextView ownerNameTextView;
        private TextView timeTextView;
        private ImageView postMainImageView;
        private TextView titleTextView;


        PostHolder(@NonNull final View itemView) {
            super(itemView);
            ownerAvatarImageView       = itemView.findViewById(R.id.item_post_avatar);
            ownerNameTextView    =      itemView.findViewById(R.id.item_post_owner_name);
            timeTextView = itemView.findViewById(R.id.item_post_time);
            postMainImageView = itemView.findViewById(R.id.img_main);
            titleTextView = itemView.findViewById(R.id.title);


        }

        public void binding(Post post){
            Picasso.get().load(post.getOwner().getPhoto()).into(ownerAvatarImageView);
            ownerNameTextView.setText(post.getOwner().getName());
            timeTextView.setText(AppUtils.getDateFromUnixTime(post.getDate().getTime()));
            Picasso.get().load(post.getMainPhoto()).into(postMainImageView);
            titleTextView.setText(post.getText());

        }
    }
}
