package com.example.home.vrticcoa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.home.vrticcoa.main.Card;
import com.example.home.vrticcoa.main.CardAdapter;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MvpView.View {
    private RecyclerView recyclerView;
    private CardAdapter adapter;
    public interface onImageClick{
        void OnImageClick();
    }


    @Inject BasePresenter<MvpView> mBasePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        ImageView imageView=(ImageView)findViewById(R.id.backdrop);
        ImageView thumbnail=(ImageView)findViewById(R.id.thumbnail);



        recyclerView=(RecyclerView)findViewById(R.id.recycler_view);

        adapter=new CardAdapter(this, new CardAdapter.onImageClick() {
            @Override
            public void OnImageClick() {
                //TODO ovde prezenter
            }
        });

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);



        imageView.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                mBasePresenter.OnCardClick();
            }
        });

            mBasePresenter.attach

    }



    @Override
    public void displayMessage() {
        Toast.makeText(this,"kliknuo",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void displayCards(List<Card> cards) {
        adapter.setCards(cards);
    }


}
