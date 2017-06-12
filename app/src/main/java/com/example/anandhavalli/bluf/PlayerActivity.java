package com.example.anandhavalli.bluf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PlayerActivity extends AppCompatActivity {

    @BindView(R.id.etPlayer1)
    EditText name1;

    @BindView(R.id.etPlayer2)
    EditText name2;

    @BindView(R.id.etPlayer3)
    EditText name3;

    @BindView(R.id.etPlayer4)
    EditText name4;

    @BindView(R.id.etPlayer5)
    EditText name5;

    int numberOfPlayers;
    String playerNameArray[];

    @OnClick(R.id.btNext)
    public void nextAction() {
        int index = 0;
        if(numberOfPlayers == 1){
            playerNameArray[index] = name1.getText().toString();
        } else if (numberOfPlayers == 2) {
            playerNameArray[index++] = name1.getText().toString();
            playerNameArray[index++] = name2.getText().toString();
        } else if (numberOfPlayers == 3) {
            playerNameArray[index++] = name1.getText().toString();
            playerNameArray[index++] = name2.getText().toString();
            playerNameArray[index++] = name3.getText().toString();
        } else if(numberOfPlayers == 4){
            playerNameArray[index++] = name1.getText().toString();
            playerNameArray[index++] = name2.getText().toString();
            playerNameArray[index++] = name3.getText().toString();
            playerNameArray[index++] = name4.getText().toString();
        } else if(numberOfPlayers == 5){
            playerNameArray[index++] = name1.getText().toString();
            playerNameArray[index++] = name2.getText().toString();
            playerNameArray[index++] = name3.getText().toString();
            playerNameArray[index++] = name4.getText().toString();
            playerNameArray[index++] = name5.getText().toString();
        }

        Bundle bundle = new Bundle();
        bundle.putStringArray(ApplicationConstants.PLAYER_NAME_ARRAY , playerNameArray);
        Intent intent = new Intent(PlayerActivity.this, TotalActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        ButterKnife.bind(this);

        numberOfPlayers = getIntent().getIntExtra(ApplicationConstants.NUMBER_OF_PLAYERS, 0);
        Log.i("PA.oC.numberOfPlayers", String.valueOf(numberOfPlayers));
        playerNameArray = new String[numberOfPlayers];

        if (numberOfPlayers == 4) {
            name5.setVisibility(View.GONE);
        }else if (numberOfPlayers == 3){
            name5.setVisibility(View.GONE);
            name4.setVisibility(View.GONE);
        }else if (numberOfPlayers == 2){
            name5.setVisibility(View.GONE);
            name4.setVisibility(View.GONE);
            name3.setVisibility(View.GONE);
        }else if (numberOfPlayers == 1){
            name5.setVisibility(View.GONE);
            name4.setVisibility(View.GONE);
            name3.setVisibility(View.GONE);
            name2.setVisibility(View.GONE);
        }
    }
}



