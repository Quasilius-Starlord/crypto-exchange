package com.example.crypto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

public class ListCoinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.crypto_list);

        ArrayList<Coin> coinArrayList = new ArrayList<Coin>();
        coinArrayList.add(new Coin("Ethereum",Ethereum.CoinCode.ETHEREUM));
        coinArrayList.add(new Coin("Binance",Ethereum.CoinCode.BINANCE));
        coinArrayList.add(new Coin("Bit Coin",Ethereum.CoinCode.BITCOIN));
        coinArrayList.add(new Coin("Dai Coin",Ethereum.CoinCode.DAICOIN));
        coinArrayList.add(new Coin("Link Coin",Ethereum.CoinCode.LINKCOIN));
        coinArrayList.add(new Coin("Lite Coin",Ethereum.CoinCode.LITECOIN));
        coinArrayList.add(new Coin("Swiss Franc",Ethereum.CoinCode.SWISS_FRANC));
        coinArrayList.add(new Coin("Compound Coin",Ethereum.CoinCode.COMPOUND));
        coinArrayList.add(new Coin("Tron Token",Ethereum.CoinCode.TRON));
        coinArrayList.add(new Coin("Uniswap Token",Ethereum.CoinCode.UNISWAP));
        coinArrayList.add(new Coin("Velo Token",Ethereum.CoinCode.VELO));

        ListCoinAdapter listCoinAdapter = new ListCoinAdapter(this,coinArrayList);
        ListView listView = (ListView) findViewById(R.id.cryptoList);
        listView.setAdapter(listCoinAdapter);
    }
}