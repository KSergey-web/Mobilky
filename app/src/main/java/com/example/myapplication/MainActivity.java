package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText view_num1;
    private EditText view_num2;
    private TextView view_result;
    private Button button_mult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view_num1 = (EditText) findViewById(R.id.num1);
        view_num2 = (EditText) findViewById(R.id.num2);
        view_result = (TextView) findViewById(R.id.result);
        if (savedInstanceState != null) {
            String str_result  = savedInstanceState.getString("str_res");
            view_result.setText(str_result);
        }
        New_functional_fragment frag = (New_functional_fragment) getFragmentManager().findFragmentById(R.id.mult_frag);
        button_mult = frag.getView().findViewById(R.id.button_mult);
        button_mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                New_functional_fragment frag = (New_functional_fragment) getFragmentManager().findFragmentById(R.id.mult_frag);
                frag.onClickMult();
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("str_res", view_result.getText().toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.action_timer:
                intent = new Intent(this, ActivityTimer.class);
                startActivity(intent);
                return true;
            case R.id.action_open_link:
                intent = new Intent(this, ActivitywithIntent.class);
                startActivity(intent);
                return true;
            case R.id.action_list:
                intent = new Intent(this, ListActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onClickSum(View view) {
        String res_str = Operations.sum(view_num1.getText().toString(), view_num2.getText().toString());
        res_str = getString(R.string.value_result)+res_str;
        view_result.setText(res_str);
        Toast.makeText(MainActivity.this, res_str ,Toast.LENGTH_SHORT).show();
    }
}