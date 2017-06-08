package com.example.home.vrticcoa;

import com.example.home.vrticcoa.main.Card;

import java.util.List;

/**
 * Base interface that any class that wants to act as a View in the MVP (Model View Presenter)
 * pattern must implement. Generally this interface will be extended by a more specific interface
 * that then usually will be implemented by an Activity or Fragment.
 */
public interface MvpView {

    interface View {
        void displayMessage();
        void displayCards(List<Card> cards);
    }

    interface BasePresenter {
        void OnCardClick();
    }
}