package com.example.dsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText _edtlogin,_edtmdp;
    Button _btnCon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _edtlogin=(EditText) findViewById(R.id.edtlogin);
        _edtmdp=(EditText)findViewById(R.id.edtmdp);
        _btnCon=(Button)findViewById(R.id.btnCon);
        _btnCon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (_edtlogin.getText().toString().equals("Guerngar") && _edtmdp.getText().toString().equals("123456")){
                    Intent _Con=new Intent(getApplicationContext(),MainActivity2.class);
                    _Con.putExtra("nom",_edtlogin.getText().toString());
                    startActivity(_Con);
                }
                else {
                    Toast.makeText(MainActivity.this,"Mauvais Mot de passe ou login",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}