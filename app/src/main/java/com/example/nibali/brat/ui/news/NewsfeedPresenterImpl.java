package com.example.nibali.brat.ui.news;

import android.widget.Toast;

import com.example.nibali.brat.data.network.repository.IPostsRepository;
import com.example.nibali.brat.data.network.repository.IUsersRepository;
import com.example.nibali.brat.ui.friends.FriendsView;

import javax.inject.Inject;

public class NewsfeedPresenterImpl<V extends NewsfeedView> implements NewsfeedPresenter<V>{

    private V view;
    private final IPostsRepository postsRepository;

    @Inject
    public NewsfeedPresenterImpl(IPostsRepository usersRepository) {
        this.postsRepository = usersRepository;
    }

    @Override
    public void onAttach(V mvpView) {
        this.view = mvpView;
    }

    @Override
    public void onDetach() {
        this.view = null;
    }

    @Override
    public void setUserAsLoggedOut() {

    }

    @Override
    public void showPosts() {
        postsRepository.getPosts().subscribe(listPosts -> view.setPosts(listPosts),
                                    throwable -> view.onError("Ошибка загрузки данных!"));

    }
}
