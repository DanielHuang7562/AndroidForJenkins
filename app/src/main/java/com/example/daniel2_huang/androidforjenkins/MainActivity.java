package com.example.daniel2_huang.androidforjenkins;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText accountEt;
    private EditText passwordEt;
    private Button confirmBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        accountEt = (EditText) findViewById(R.id.editText);
        passwordEt = (EditText) findViewById(R.id.editText2);
        confirmBtn = (Button) findViewById(R.id.confimButton);

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if("daniel2_huang".equals(accountEt.getText().toString().trim()) && "11111111".equals(passwordEt.getText().toString().trim())){
                    Intent it = new Intent();
                    it.setClass(MainActivity.this, Main2Activity.class);
                    Bundle bundle=new Bundle();
                    bundle.putString("ACCOUNT", "Daniel2_Huang");
                    it.putExtras(bundle);
                    startActivity(it);
                }else{
                    Toast.makeText(view.getContext(), "登入失敗", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
