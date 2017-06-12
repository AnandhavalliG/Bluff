package com.anandhavalli.bluff;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TotalActivity extends AppCompatActivity {

    @BindView(R.id.tvDetails1)
    TextView detail1;

    @BindView(R.id.tvDetails2)
    TextView detail2;

    @BindView(R.id.tvDetails3)
    TextView detail3;

    @BindView(R.id.tvDetails4)
    TextView detail4;

    @BindView(R.id.tvDetails5)
    TextView detail5;

    @BindView(R.id.tvTotal1)
    TextView total1;

    @BindView(R.id.tvTotal2)
    TextView total2;

    @BindView(R.id.tvTotal3)
    TextView total3;

    @BindView(R.id.tvTotal4)
    TextView total4;

    @BindView(R.id.tvTotal5)
    TextView total5;

    @BindView(R.id.etScore1)
    EditText score1;

    @BindView(R.id.etScore2)
    EditText score2;

    @BindView(R.id.etScore3)
    EditText score3;

    @BindView(R.id.etScore4)
    EditText score4;

    @BindView(R.id.etScore5)
    EditText score5;

    @BindView(R.id.layoutPlayer1)
    View layoutPlayer1;

    @BindView(R.id.layoutPlayer2)
    View layoutPlayer2;

    @BindView(R.id.layoutPlayer3)
    View layoutPlayer3;

    @BindView(R.id.layoutPlayer4)
    View layoutPlayer4;

    @BindView(R.id.layoutPlayer5)
    View layoutPlayer5;

    String playerNameArray[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);
        ButterKnife.bind(this);
        setupViews();
        hideSoftKeyboard();
    }

    private void setupViews() {
        Bundle b = this.getIntent().getExtras();
        playerNameArray = b.getStringArray(ApplicationConstants.PLAYER_NAME_ARRAY);
        Log.i("TA.oC.playerNameArray", String.valueOf(playerNameArray.length));
        int index = 0;
        int playerIndex = 0;
        if (playerNameArray.length == 4) {
            layoutPlayer5.setVisibility(View.GONE);
            detail1.setText(playerNameArray[index++]);
            detail2.setText(playerNameArray[index++]);
            detail3.setText(playerNameArray[index++]);
            detail4.setText(playerNameArray[index++]);

            score1.setHint(playerNameArray[playerIndex++] + " Score");
            score2.setHint(playerNameArray[playerIndex++] + " Score");
            score3.setHint(playerNameArray[playerIndex++] + " Score");
            score4.setHint(playerNameArray[playerIndex++] + " Score");
        } else if (playerNameArray.length == 3) {
            layoutPlayer5.setVisibility(View.GONE);
            layoutPlayer4.setVisibility(View.GONE);
            detail1.setText(playerNameArray[index++]);
            detail2.setText(playerNameArray[index++]);
            detail3.setText(playerNameArray[index++]);

            score1.setHint(playerNameArray[playerIndex++] + " Score");
            score2.setHint(playerNameArray[playerIndex++] + " Score");
            score3.setHint(playerNameArray[playerIndex++] + " Score");
        } else if (playerNameArray.length == 2) {
            layoutPlayer5.setVisibility(View.GONE);
            layoutPlayer4.setVisibility(View.GONE);
            layoutPlayer3.setVisibility(View.GONE);
            detail1.setText(playerNameArray[index++]);
            detail2.setText(playerNameArray[index++]);

            score1.setHint(playerNameArray[playerIndex++] + " Score");
            score2.setHint(playerNameArray[playerIndex++] + " Score");
        } else if (playerNameArray.length == 1) {
            layoutPlayer5.setVisibility(View.GONE);
            layoutPlayer4.setVisibility(View.GONE);
            layoutPlayer3.setVisibility(View.GONE);
            layoutPlayer2.setVisibility(View.GONE);
            detail1.setText(playerNameArray[index++]);

            score1.setHint(playerNameArray[playerIndex++] + " Score");
        } else {
            detail1.setText(playerNameArray[index++]);
            detail2.setText(playerNameArray[index++]);
            detail3.setText(playerNameArray[index++]);
            detail4.setText(playerNameArray[index++]);
            detail5.setText(playerNameArray[index++]);

            score1.setHint(playerNameArray[playerIndex++] + " Score");
            score2.setHint(playerNameArray[playerIndex++] + " Score");
            score3.setHint(playerNameArray[playerIndex++] + " Score");
            score4.setHint(playerNameArray[playerIndex++] + " Score");
            score5.setHint(playerNameArray[playerIndex++] + " Score");
        }
    }

    @OnClick(R.id.btRestart)
    public void restartAction() {
        startActivity(new Intent(TotalActivity.this, MainActivity.class));
        finish();
    }

    @OnClick(R.id.btUpdate)
    public void updateAction() {
        if (playerNameArray.length == 1) {
            total1.setText(String.valueOf(Integer.parseInt(total1.getText().toString()) + ((!score1.getText().toString().equalsIgnoreCase("")) ? Integer.parseInt(score1.getText().toString()) : 0)));
            score1.setText("");
        } else if (playerNameArray.length == 2) {
            total1.setText(String.valueOf(Integer.parseInt(total1.getText().toString()) + ((!score1.getText().toString().equalsIgnoreCase("")) ? Integer.parseInt(score1.getText().toString()) : 0)));
            total2.setText(String.valueOf(Integer.parseInt(total2.getText().toString()) + ((!score2.getText().toString().equalsIgnoreCase("")) ? Integer.parseInt(score2.getText().toString()) : 0)));
            score1.setText("");
            score2.setText("");
        }else if (playerNameArray.length == 3){
            total1.setText(String.valueOf(Integer.parseInt(total1.getText().toString()) + ((!score1.getText().toString().equalsIgnoreCase("")) ? Integer.parseInt(score1.getText().toString()) : 0)));
            total2.setText(String.valueOf(Integer.parseInt(total2.getText().toString()) + ((!score2.getText().toString().equalsIgnoreCase("")) ? Integer.parseInt(score2.getText().toString()) : 0)));
            total3.setText(String.valueOf(Integer.parseInt(total3.getText().toString()) + ((!score3.getText().toString().equalsIgnoreCase("")) ? Integer.parseInt(score3.getText().toString()) : 0)));
            score1.setText("");
            score2.setText("");
            score3.setText("");
        } else if (playerNameArray.length == 4){
            total1.setText(String.valueOf(Integer.parseInt(total1.getText().toString()) + ((!score1.getText().toString().equalsIgnoreCase("")) ? Integer.parseInt(score1.getText().toString()) : 0)));
            total2.setText(String.valueOf(Integer.parseInt(total2.getText().toString()) + ((!score2.getText().toString().equalsIgnoreCase("")) ? Integer.parseInt(score2.getText().toString()) : 0)));
            total3.setText(String.valueOf(Integer.parseInt(total3.getText().toString()) + ((!score3.getText().toString().equalsIgnoreCase("")) ? Integer.parseInt(score3.getText().toString()) : 0)));
            total4.setText(String.valueOf(Integer.parseInt(total4.getText().toString()) + ((!score4.getText().toString().equalsIgnoreCase("")) ? Integer.parseInt(score4.getText().toString()) : 0)));
            score1.setText("");
            score2.setText("");
            score3.setText("");
            score4.setText("");
        }else if (playerNameArray.length == 5){
            total1.setText(String.valueOf(Integer.parseInt(total1.getText().toString()) + ((!score1.getText().toString().equalsIgnoreCase("")) ? Integer.parseInt(score1.getText().toString()) : 0)));
            total2.setText(String.valueOf(Integer.parseInt(total2.getText().toString()) + ((!score2.getText().toString().equalsIgnoreCase("")) ? Integer.parseInt(score2.getText().toString()) : 0)));
            total3.setText(String.valueOf(Integer.parseInt(total3.getText().toString()) + ((!score3.getText().toString().equalsIgnoreCase("")) ? Integer.parseInt(score3.getText().toString()) : 0)));
            total4.setText(String.valueOf(Integer.parseInt(total4.getText().toString()) + ((!score4.getText().toString().equalsIgnoreCase("")) ? Integer.parseInt(score4.getText().toString()) : 0)));
            total5.setText(String.valueOf(Integer.parseInt(total5.getText().toString()) + ((!score5.getText().toString().equalsIgnoreCase("")) ? Integer.parseInt(score5.getText().toString()) : 0)));
            score1.setText("");
            score2.setText("");
            score3.setText("");
            score4.setText("");
            score5.setText("");
        }
        score1.requestFocus();
    }

    public void hideSoftKeyboard() {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }
}
