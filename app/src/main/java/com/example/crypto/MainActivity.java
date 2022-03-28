package com.example.crypto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigInteger;

public class MainActivity extends AppCompatActivity {

    private void UpdateBlockCount() throws InterruptedException {
        try {
            Ethereum ethereum = Ethereum.getInstance();
            TextView introText = findViewById(R.id.introText);
            TextView priceETH = findViewById(R.id.priceETH);
            Button getBlock=findViewById(R.id.getBlock);

            getBlock.setEnabled(false);
            String blockCount = ethereum.getBlockCount();
            BigInteger price = ethereum.getEthereumETHToUSD();
            System.out.println("price "+blockCount);
            System.out.println("price "+price);
            introText.setText(blockCount);
            priceETH.setText(price.toString());
            getBlock.setEnabled(true);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //hide title bar and actionbar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        //load main activity
        setContentView(R.layout.activity_main);

        Button getBlock=findViewById(R.id.getBlock);
        Button viewList=findViewById(R.id.viewList);


        getBlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    UpdateBlockCount();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        viewList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,ListCoinActivity.class);
                MainActivity.this.startActivity(i);
            }
        });


    }
}