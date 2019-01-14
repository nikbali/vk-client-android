package com.example.nibali.constraint_examples.fragment;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nibali.constraint_examples.Application;
import com.example.nibali.constraint_examples.R;
import com.example.nibali.constraint_examples.adapter.PostAdapter;
import com.example.nibali.constraint_examples.base.AbstractBaseFragment;
import com.example.nibali.constraint_examples.databinding.FragmentNewsBinding;
import com.example.nibali.constraint_examples.repository.IPostsRepository;
import com.example.nibali.constraint_examples.repository.impl.PostsRepository;

import javax.annotation.Nullable;

public class NewsfeedFragment extends AbstractBaseFragment {
    private FragmentNewsBinding fragmentNewsBinding;

    private RecyclerView recyclerView;
    private PostAdapter postAdapter;
    private IPostsRepository postsRepository = new PostsRepository();


    @Override
    protected void inject() {
        ((Application) getActivity().getApplication()).getUserComponent().inject(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        postAdapter = new PostAdapter(postsRepository.getPosts());
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
        return fragmentNewsBinding.getRoot();
    }
}
