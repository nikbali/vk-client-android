package com.example.nibali.brat.ui.news;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.nibali.brat.BratApplication;
import com.example.nibali.brat.R;
import com.example.nibali.brat.ui.base.AbstractBaseFragment;
import com.example.nibali.brat.data.entity.Post;
import com.example.nibali.brat.data.network.repository.IPostsRepository;
import com.example.nibali.brat.ui.main.MainActivity;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Inject;

public class NewsfeedFragment extends AbstractBaseFragment implements SwipeRefreshLayout.OnRefreshListener, NewsfeedView{

    @Inject
    NewsfeedPresenter<NewsfeedView> presenter;

    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private PostAdapter postAdapter;


    @Override
    protected void inject() {
        ((BratApplication) getActivity().getApplication()).getUserComponent().inject(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        postAdapter = new PostAdapter();
        presenter.onAttach(this);
    }


    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_posts);
        recyclerView.setAdapter(postAdapter);
        presenter.showPosts();
        swipeRefreshLayout = view.findViewById(R.id.swipe_container);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        ((MainActivity) getActivity()).setActionBarTitle("News");
        return view;
    }

    @Override
    public void onRefresh() {
        presenter.showPosts();
        swipeRefreshLayout.setRefreshing(false);
    }


    @Override
    public void setPosts(List<Post> postList) {
        postAdapter.setData(postList);
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
