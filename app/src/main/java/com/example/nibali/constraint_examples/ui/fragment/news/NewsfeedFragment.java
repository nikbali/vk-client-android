package com.example.nibali.constraint_examples.ui.fragment.news;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.nibali.constraint_examples.Application;
import com.example.nibali.constraint_examples.R;
import com.example.nibali.constraint_examples.adapter.PostAdapter;
import com.example.nibali.constraint_examples.base.AbstractBaseFragment;
import com.example.nibali.constraint_examples.entity.Post;
import com.example.nibali.constraint_examples.repository.IPostsRepository;
import com.example.nibali.constraint_examples.ui.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Inject;

public class NewsfeedFragment extends AbstractBaseFragment implements SwipeRefreshLayout.OnRefreshListener{

    @Inject
    IPostsRepository postsRepository;

    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private PostAdapter postAdapter;
    private List<Post> posts = new ArrayList<>();


    @Override
    protected void inject() {
        ((Application) getActivity().getApplication()).getUserComponent().inject(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        postsRepository.getPosts().subscribe(listUser -> posts.addAll(listUser),
                throwable -> Toast.makeText(getContext(), throwable.fillInStackTrace().toString(), Toast.LENGTH_LONG).show());
        postAdapter = new PostAdapter(posts);
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
        postsRepository.getPosts().subscribe(listUser -> postAdapter.setData(listUser),
                throwable -> Toast.makeText(getContext(), throwable.fillInStackTrace().toString(), Toast.LENGTH_LONG).show());
        swipeRefreshLayout.setRefreshing(false);
    }
}
