package com.anandhavalli.bluff;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.etnumber)
    EditText username;

    @BindView(R.id.tvError)
    TextView error;

    String result;
    int resultIntValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        hideSoftKeyboard();
    }

    @OnClick(R.id.btOk)
    public void okAction(View view) {
        result = username.getText().toString();
        resultIntValue = !result.equalsIgnoreCase("") ? Integer.parseInt(result) : 0;
        if (resultIntValue < 2 || resultIntValue > 5) {
            error.setText("Minimum 2 and Maximum 5 Players Allowed");
        } else {
            Intent intent = new Intent(MainActivity.this, PlayerActivity.class);
            intent.putExtra(ApplicationConstants.NUMBER_OF_PLAYERS , resultIntValue);
            startActivity(intent);
            finish();
        }
    }

    public void hideSoftKeyboard() {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }
}
