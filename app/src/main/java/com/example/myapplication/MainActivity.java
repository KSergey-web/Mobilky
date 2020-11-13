package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickSum(View view) {
        EditText num1 = (EditText) findViewById(R.id.num1);
        EditText num2 = (EditText) findViewById(R.id.num2);
        String res_str = Operations.sum(num1.getText().toString(), num2.getText().toString());
        TextView res_view = (TextView) findViewById(R.id.result);
        res_view.setText(res_str);
        Toast.makeText(MainActivity.this, res_str ,Toast.LENGTH_SHORT).show();
    }

    public void onClickCallActivity(View view) {
        Intent intent = new Intent(this, ActivitywithIntent.class);
        startActivity(intent);
    }
}