package com.example.nibali.constraint_examples.ui.fragment.friends;

import com.example.nibali.constraint_examples.entity.User;
import com.example.nibali.constraint_examples.repository.IPostsRepository;
import com.example.nibali.constraint_examples.repository.IUsersRepository;

import java.util.List;

import javax.inject.Inject;

public class FriendsPresenter {

    FriendsView view;
    IUsersRepository usersRepository;

    @Inject
    public FriendsPresenter(FriendsView view, IUsersRepository usersRepository) {
        this.view = view;
        this.usersRepository = usersRepository;
    }

    public void init() {
        usersRepository.getFriends()
                .doOnSubscribe((r) -> view.showLoadingIndicator())
                .doAfterTerminate(() -> view.hideLoadingIndicator())
                .subscribe(listUser -> view.showFriends(listUser),
                            throwable -> view.showError(throwable.fillInStackTrace().toString()));
    }
}
