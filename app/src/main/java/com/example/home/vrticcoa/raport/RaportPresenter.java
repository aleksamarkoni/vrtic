package com.example.home.vrticcoa.raport;

import com.example.home.vrticcoa.BasePresenter;
import com.example.home.vrticcoa.MvpView;

/**
 * Created by home on 6/8/2017.
 */

public class RaportPresenter extends BasePresenter<RaportMvp>{

    private final RaportMvp.view v;

    public RaportPresenter(MvpView.View View, RaportMvp.view v) {
        super(View);
        this.v = v;
    }



}
