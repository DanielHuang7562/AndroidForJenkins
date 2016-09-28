package com.example.daniel2_huang.androidforjenkins;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView accountNameTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        accountNameTv = (TextView) findViewById(R.id.accountName) ;
        Intent intent = getIntent();
        String account = "";
        if(intent != null){
            Bundle bundle = intent.getExtras();
            account = bundle.getString("ACCOUNT");
        }

        if(!"".equals(account)){
            accountNameTv.setText(account);
        }
    }
}
