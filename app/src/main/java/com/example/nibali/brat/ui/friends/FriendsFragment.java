package com.example.nibali.brat.ui.friends;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.nibali.brat.BratApplication;
import com.example.nibali.brat.R;
import com.example.nibali.brat.ui.base.AbstractBaseFragment;
import com.example.nibali.brat.data.entity.User;
import com.example.nibali.brat.data.network.repository.IUsersRepository;
import com.example.nibali.brat.ui.main.MainActivity;

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
        ((BratApplication) getActivity().getApplication()).getUserComponent().inject(this);
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
        ((MainActivity) getActivity()).setActionBarTitle("Friends");
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
    public void onClickUser(User user) {

    }
    private void initRecyclerView() {
        recyclerView = mainView.findViewById(R.id.recycler_view_friends);
        userAdapter = new UserAdapter( this);
        recyclerView.setAdapter(userAdapter);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

}
