package com.example.nibali.constraint_examples.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nibali.constraint_examples.R;
import com.example.nibali.constraint_examples.adapter.listeners.UserClickListener;
import com.example.nibali.constraint_examples.entity.User;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {
    private List<User> users;
    private UserClickListener userClickListener;

    public UserAdapter(final UserClickListener userClickListener) {
        this.users = new ArrayList<>();
        this.userClickListener = userClickListener;
    }

    public void changeDataSet(@NonNull List<User> users) {
        this.users.clear();
        this.users.addAll(users);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View viewItem = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_item,viewGroup, false );
        return new UserHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder userHolder, int i) {
        userHolder.binding(users.get(i));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public void setUsers(List<User> users){
        users.addAll(users);
        notifyDataSetChanged();
    }
    public void clearUsers(){
        users.clear();
        notifyDataSetChanged();
    }



    class UserHolder extends RecyclerView.ViewHolder {

        private ImageView userImageView;
        private TextView nameTextView;
        private TextView nickNameTextView;

        public UserHolder(@NonNull final View itemView) {
            super(itemView);
            userImageView       = itemView.findViewById(R.id.userImageView);
            nameTextView        = itemView.findViewById(R.id.nameTextView);
            nickNameTextView    = itemView.findViewById(R.id.nickNameTextView);
            itemView.setOnClickListener(user -> userClickListener.onClickUser(users.get(getLayoutPosition())));
        }

        public void binding(final User user){
            nameTextView.setText(user.getName());
            nickNameTextView.setText(user.getName());
            Picasso.get().load(user.getPhoto()).into(userImageView);
        }

    }
}
