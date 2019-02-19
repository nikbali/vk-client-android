package com.example.nibali.constraint_examples.ui.fragment.news;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.nibali.constraint_examples.Application;
import com.example.nibali.constraint_examples.R;
import com.example.nibali.constraint_examples.adapter.PostAdapter;
import com.example.nibali.constraint_examples.base.AbstractBaseFragment;
import com.example.nibali.constraint_examples.databinding.FragmentNewsBinding;
import com.example.nibali.constraint_examples.entity.Post;
import com.example.nibali.constraint_examples.repository.IPostsRepository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Inject;

public class NewsfeedFragment extends AbstractBaseFragment implements SwipeRefreshLayout.OnRefreshListener{


    @Inject
    IPostsRepository postsRepository;

    private FragmentNewsBinding fragmentNewsBinding;
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
        fragmentNewsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_news, container, false);
        fragmentNewsBinding.recyclerViewPosts.setAdapter(postAdapter);
        fragmentNewsBinding.swipeContainer.setOnRefreshListener(this);
        fragmentNewsBinding.swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        return fragmentNewsBinding.getRoot();
    }

    @Override
    public void onRefresh() {
        postsRepository.getPosts().subscribe(listUser -> postAdapter.setData(listUser),
                throwable -> Toast.makeText(getContext(), throwable.fillInStackTrace().toString(), Toast.LENGTH_LONG).show());
        fragmentNewsBinding.swipeContainer.setRefreshing(false);
    }
}
