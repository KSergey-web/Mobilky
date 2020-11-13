package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ActivitywithIntent extends AppCompatActivity {
    public static final String EXTRA_TEXT = "message";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitywith_intent);
        Intent intent = getIntent();
        String messageText = intent.getStringExtra(EXTRA_TEXT);
        EditText link = (EditText) findViewById(R.id.input_str);
        link.setText(messageText);
    }

    public void onClickOpenLink(View view) {
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        EditText link = (EditText) findViewById(R.id.input_str);
        intent.putExtra(SearchManager.QUERY, link.getText().toString());
        startActivity(intent);
    }
    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitywith_intent);
    }

    public void onClickOpenLink(View view) {
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        EditText link = (EditText) findViewById(R.id.input_str);
        intent.putExtra(SearchManager.QUERY, link.getText().toString());
        startActivity(intent);
    }*/
}