package com.example.home.vrticcoa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.home.vrticcoa.raport.RaportMvp;
import com.example.home.vrticcoa.raport.RaportPresenter;

import javax.inject.Inject;

public class Second3Activity extends MainActivity implements RaportMvp.view {

    @Inject
    RaportPresenter mRaportPresenter;

    TextView editText;
    Button button4;
    TextView textView,textView2,textView3,textView4;
    static Spinner spinnerDropdown;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.raport_main);
        getWindow().setAllowEnterTransitionOverlap(false);

        spinnerDropdown=(Spinner) findViewById(R.id.spinner2);
        button4=(Button) findViewById(R.id.button4);
        textView=(TextView) findViewById(R.id.textView);
        textView2=(TextView) findViewById(R.id.textView2);
        textView3=(TextView) findViewById(R.id.textView3);
        textView4=(TextView) findViewById(R.id.textView4);
        editText=(TextView) findViewById(R.id.editText);


        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subject = editText.getText().toString();
                String to=spinnerDropdown.getSelectedItem().toString();

                Intent intent= new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                intent.putExtra(Intent.EXTRA_SUBJECT,subject);
                intent.putExtra(Intent.EXTRA_TEXT, getBody());

                intent.setType("message/rfc822");

                startActivity(Intent.createChooser(intent,"Select Email App"));
            }
        });
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(Second3Activity.this,android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.spinner_options));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDropdown.setAdapter(adapter);


    }


    @Override
    public String getBody() {
        StringBuilder body = new StringBuilder();
        body.append(textView.getText()).append("\n\n");
        body.append(textView2.getText()).append("\n\n");
        body.append(textView3.getText()).append("\n\n");
        body.append(textView4.getText()).append("\n\n");

        return body.toString();
    }


}
