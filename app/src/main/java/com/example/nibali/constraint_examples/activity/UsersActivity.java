package com.example.nibali.constraint_examples.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.nibali.constraint_examples.R;
import com.example.nibali.constraint_examples.adapter.UserAdapter;
import com.example.nibali.constraint_examples.repository.IUsersRepository;
import com.example.nibali.constraint_examples.repository.impl.UsersRepository;

public class UsersActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private IUsersRepository iUsersRepository = new UsersRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);
        initRecyclerView();
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view_users);

        userAdapter = new UserAdapter(iUsersRepository.getUsers(),
                user -> Toast.makeText(this, user.toString(), Toast.LENGTH_SHORT).show());

        recyclerView.setAdapter(userAdapter);
    }
}
