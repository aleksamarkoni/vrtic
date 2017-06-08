package com.example.home.vrticcoa.raport;

import com.example.home.vrticcoa.MvpView;

/**
 * Created by home on 6/8/2017.
 */

public interface RaportMvp extends MvpView{
        interface view{
            String getBody();

        }

    interface RaportPresenter {
        void OnButtonClick();
    }
}
