package com.example.nibali.brat.ui.friends;

import com.example.nibali.brat.data.network.repository.IUsersRepository;

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
