package com.example.dsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    Button _btnValider1,_btnValider2,_btnAppel1,_btnAppel2;
    EditText numTel,_editTextNumber2,_editTextNumber3,_edtRecharge1;
    TextView txtView,_txt14,_textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        numTel=(EditText) findViewById(R.id.edtNum);
        _editTextNumber2=(EditText) findViewById(R.id.editTextNumber2);
        _editTextNumber3=(EditText) findViewById(R.id.editTextNumber3);
        _edtRecharge1=(EditText)findViewById(R.id.edtRecharge1);

        _textView=(TextView) findViewById(R.id.textView);
        Bundle extra =getIntent().getExtras();
        _textView.setText(extra.getString("nom"));

        txtView=(TextView) findViewById(R.id.txtOrange);
        _txt14=(TextView) findViewById(R.id.txt14);

        _btnValider2=(Button)findViewById(R.id.btnValider2);
        _btnValider1=(Button) findViewById(R.id.btnValider1);
        _btnAppel1=(Button) findViewById(R.id.btnAppel1);
        _btnAppel2=(Button) findViewById(R.id.button2);

        _btnValider1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num=numTel.getText().toString();
                String[] tab=num.split("");
                if (tab.length==8){
                    if ((Integer.parseInt(tab[0])==3)&&(Integer.parseInt(tab[1])==1)){
                        txtView.setTextColor(Color.parseColor("#ff8000"));
                        txtView.setText("Votre ligne est orange");
                        _txt14.setText("Entrer votre code de recharge (14 chiffres)");
                        _editTextNumber2.setBackgroundColor(Color.parseColor("#ff8000"));
                        _editTextNumber3.setBackgroundColor(Color.parseColor("#ff8000"));
                        _btnValider2.setBackgroundColor(Color.parseColor("#ff8000"));
                        _btnValider1.setBackgroundColor(Color.parseColor("#ff8000"));
                        _btnValider2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String num2=_edtRecharge1.getText().toString();
                                String[] tab1=num2.split("");
                                if(tab1.length==14){
                                    _editTextNumber2.setText("*100*"+num2+"#");
                                    _editTextNumber3.setText("*111#");
                                }
                                else{
                                    Toast.makeText(MainActivity2.this,"Le code de recharge doit comporter 14 chiffres",Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                    }
                    else if ((Integer.parseInt(tab[0])==2)&&(Integer.parseInt(tab[1])==3)) {
                        txtView.setTextColor(Color.parseColor("#f00020"));
                        txtView.setText("Votre ligne est Ooredoo");
                        _txt14.setText("Entrer votre code de recharge (14 chiffres)");
                        _editTextNumber2.setBackgroundColor(Color.parseColor("#f00020"));
                        _editTextNumber3.setBackgroundColor(Color.parseColor("#f00020"));
                        _btnValider2.setBackgroundColor(Color.parseColor("#f00020"));
                        _btnValider1.setBackgroundColor(Color.parseColor("#f00020"));
                        _btnValider2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String num2=_edtRecharge1.getText().toString();
                                String[] tab1=num2.split("");
                                if(tab1.length==14){
                                    _editTextNumber2.setText("*101*"+num2+"#");
                                    _editTextNumber3.setText("*100#");
                                }
                                else{
                                    Toast.makeText(MainActivity2.this,"Le code de recharge doit comporter 14 chiffres",Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                    }
                    else if ((Integer.parseInt(tab[0])==9)&&(Integer.parseInt(tab[1])==7)) {
                        txtView.setTextColor(Color.parseColor("#0080ff"));
                        txtView.setText("Votre ligne est Telecom");
                        _txt14.setText("Entrer votre code de recharge (13 chiffres)");
                        _editTextNumber2.setBackgroundColor(Color.parseColor("#0080ff"));
                        _editTextNumber3.setBackgroundColor(Color.parseColor("#0080ff"));
                        _btnValider2.setBackgroundColor(Color.parseColor("#0080ff"));
                        _btnValider1.setBackgroundColor(Color.parseColor("#0080ff"));
                        _btnValider2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String num2=_edtRecharge1.getText().toString();
                                String[] tab1=num2.split("");
                                if(tab1.length==13){
                                    _editTextNumber2.setText("*123*"+num2+"#");
                                    _editTextNumber3.setText("*122#");
                                }
                                else{
                                    Toast.makeText(MainActivity2.this,"Le code de recharge doit comporter 13 chiffres",Toast.LENGTH_LONG).show();
                                }
                            }
                        });

                    }
                    else{
                        Toast.makeText(MainActivity2.this,"Opérateur inconnu",Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    //txtView.setTextColor(Color.parseColor("#ff8000"));
                    //txtView.setText("Numero invalide!!");
                    Toast.makeText(MainActivity2.this,"Numero invalide!!",Toast.LENGTH_LONG).show();
                }
            }
        });
        _btnAppel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+_editTextNumber2.getText().toString()));
                startActivity(i);
            }
        });
        _btnAppel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+_editTextNumber3.getText().toString()));
                startActivity(i2);
            }
        });

    }
}