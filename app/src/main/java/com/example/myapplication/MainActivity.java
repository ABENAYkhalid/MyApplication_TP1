package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Spinner s1,s2;
    EditText t1,t2;
    Button b1;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s2 = findViewById(R.id.tospiner);
        t1 = findViewById(R.id.montantxt);
        b1 = findViewById(R.id.convbutton);
        t2 = findViewById(R.id.txtconvert);



        String[] to = {"EURO","USD"};
        ArrayAdapter a2 = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,to);
        s2.setAdapter(a2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double total;

                Double montant = Double.parseDouble(t1.getText().toString());
                if(s1.getSelectedItem().toString() == "MAD"){
                    switch(s2.getSelectedItem().toString()) {
                        case "EURO":
                            total = montant * 0.09;
                            t2.setText(total +" euro");
                            break;
                        case "USD":
                            total = montant * 0.014;
                            t2.setText(total + "$");
                            break;
                        case "YEN":
                            total = montant * 12.9;
                            t2.setText(total + "yen");
                            break;
                        default:
                            break;
                    }
                }
            }
        });
    }

}