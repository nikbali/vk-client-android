package com.example.nibali.brat.ui.friends;

import com.example.nibali.brat.data.network.repository.IUsersRepository;

import javax.inject.Inject;

public class FriendsPresenter {

    private final FriendsView view;
    private final IUsersRepository usersRepository;

    @Inject
    public FriendsPresenter(FriendsView view, IUsersRepository usersRepository) {
        this.view = view;
        this.usersRepository = usersRepository;
    }

    public void init() {
        usersRepository.getFriends()
                .doOnSubscribe((r) -> view.showLoading())
                .doAfterTerminate(view::hideLoading)
                .subscribe(view::showFriends,
                            throwable -> view.onError(throwable.fillInStackTrace().toString()));
    }
}
