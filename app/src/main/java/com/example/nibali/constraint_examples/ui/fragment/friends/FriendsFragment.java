package com.example.nibali.constraint_examples.ui.fragment.friends;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.nibali.constraint_examples.Application;
import com.example.nibali.constraint_examples.R;
import com.example.nibali.constraint_examples.adapter.PostAdapter;
import com.example.nibali.constraint_examples.adapter.UserAdapter;
import com.example.nibali.constraint_examples.adapter.listeners.UserClickListener;
import com.example.nibali.constraint_examples.base.AbstractBaseFragment;
import com.example.nibali.constraint_examples.entity.User;
import com.example.nibali.constraint_examples.repository.IUsersRepository;
import com.example.nibali.constraint_examples.ui.activity.LoginActivity;

import java.util.List;

import javax.inject.Inject;

public class FriendsFragment extends AbstractBaseFragment implements FriendsView, UserClickListener {

    private UserAdapter userAdapter;
    private FriendsPresenter presenter;

    @Inject
    IUsersRepository usersRepository;

    RecyclerView recyclerView;
    View mainView;

    @Override
    protected void inject() {
        ((Application) getActivity().getApplication()).getUserComponent().inject(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mainView = inflater.inflate(R.layout.fragment_friends, container, false);
        initRecyclerView();
        presenter = new FriendsPresenter(this, usersRepository);
        presenter.init();
        return mainView;
    }

    @Override
    public void showFriends(@NonNull List<User> movies) {
        userAdapter.changeDataSet(movies);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(String s) {
        Toast.makeText(getContext(), s, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLoadingIndicator() {
        Toast.makeText(getContext(), "load", Toast.LENGTH_LONG).show();
    }

    @Override
    public void hideLoadingIndicator() {
        Toast.makeText(getContext(), "end load", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClickUser(User user) {

    }
    private void initRecyclerView() {
        recyclerView = mainView.findViewById(R.id.recycler_view_friends);
        userAdapter = new UserAdapter( this);
        recyclerView.setAdapter(userAdapter);
    }
}
