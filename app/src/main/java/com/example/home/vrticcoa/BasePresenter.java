package com.example.home.vrticcoa;

import com.example.home.vrticcoa.main.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Base class that implements the Presenter interface and provides a base implementation for
 * attachView() and detachView(). It also handles keeping a reference to the mvpView that
 * can be accessed from the children classes by calling getMvpView().
 */
public class BasePresenter<R extends MvpView> implements MvpView.BasePresenter {

    private final MvpView.View mView;
    private List<Card>cards;


    public BasePresenter(MvpView.View mView) {
        this.mView = mView;
    }




    @Override
    public void OnCardClick() {
        mView.displayMessage();
        mView.displayCards(cards);

    }

    public void loadCards(){
        createCards();

    }


    private void createCards(){
        cards=new ArrayList<>();

        int[] covers = new int[]{
                com.example.home.vrticcoa.R.drawable.kerpng,
                com.example.home.vrticcoa.R.drawable.kerpng,
                com.example.home.vrticcoa.R.drawable.kerpng,
                com.example.home.vrticcoa.R.drawable.kerpng,
                com.example.home.vrticcoa.R.drawable.kerpng,
                com.example.home.vrticcoa.R.drawable.kerpng,
                com.example.home.vrticcoa.R.drawable.kerpng,
                com.example.home.vrticcoa.R.drawable.kerpng,
                com.example.home.vrticcoa.R.drawable.kerpng,
                com.example.home.vrticcoa.R.drawable.kerpng,
                com.example.home.vrticcoa.R.drawable.kerpng};

        Card a = new Card("Maroon5", covers[0]);
        cards.add(a);

        a = new Card("Sugar Ray", covers[1]);
        cards.add(a);

        a = new Card("Bon Jovi",covers[2]);
        cards.add(a);

        a = new Card("The Corrs", covers[3]);
        cards.add(a);

        a = new Card("The Cranberries", covers[4]);
        cards.add(a);

        a = new Card("Westlife", covers[5]);
        cards.add(a);

        a = new Card("Black Eyed Peas", covers[6]);
        cards.add(a);

        a = new Card("VivaLaVida", covers[7]);
        cards.add(a);

        a = new Card("The Cardigans", covers[8]);
        cards.add(a);

        a = new Card("Pussycat Dolls", covers[9]);
        cards.add(a);


    }


}

