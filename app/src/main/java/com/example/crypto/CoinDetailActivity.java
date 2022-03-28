package com.example.crypto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import org.w3c.dom.Text;
import org.web3j.tuples.generated.Tuple5;
import org.web3j.tuples.generated.Tuple6;

import java.io.IOException;
import java.math.BigInteger;

public class CoinDetailActivity extends AppCompatActivity {

    private void updateCoinStats(Coin coin){
        try {
            Ethereum ethereum = Ethereum.getInstance();
            Tuple6<BigInteger,BigInteger,BigInteger,BigInteger,BigInteger,BigInteger> stats=ethereum.getCoinToUSD(coin.getCoinCode());

            coin.setRoundID(stats.component1());
            coin.setPrice(stats.component2());
            coin.setStartedAt(stats.component3());
            coin.setUpdatedAt(stats.component4());
            coin.setAnsweredInRound(stats.component5());
            coin.setDecimal(stats.component6());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.coin_detail);


    }

    @Override
    protected void onStart() {
        super.onStart();
        TextView coinName=findViewById(R.id.coin_name);
        TextView roundID=findViewById(R.id.roundID);
        TextView price=findViewById(R.id.price);
        TextView startedAt=findViewById(R.id.startedAt);
        TextView updatedAt=findViewById(R.id.updatedAt);
        TextView answeredInRound=findViewById(R.id.answeredInRound);


        //ethereum fetch task
        Coin coin =(Coin) getIntent().getSerializableExtra("coin");

        updateCoinStats(coin);
        BigInteger ten=new BigInteger("10");
        BigInteger priceNumber=coin.getPrice().divide(ten.pow(coin.getDecimal().intValue()));

        coinName.setText(coin.getCoinName());
        roundID.setText(coin.getRoundID().toString());
        price.setText("$ "+priceNumber.toString());
        startedAt.setText(coin.getStartedAt().toString());
        updatedAt.setText(coin.getUpdatedAt().toString());
        answeredInRound.setText(coin.getAnsweredInRound().toString());
    }



}