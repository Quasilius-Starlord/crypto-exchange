package com.example.crypto;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.io.Serializable;
import java.util.ArrayList;

public class ListCoinAdapter extends ArrayAdapter<Coin> {
    public ListCoinAdapter(Context context, ArrayList<Coin> coinArrayList){
        super(context,R.layout.crypto_item,coinArrayList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Coin coin = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.crypto_item,parent,false);
        }


        TextView coinName = convertView.findViewById(R.id.coinName);
//        Button viewPrice = convertView.findViewById(R.id.viewPrice);

        coinName.setText(coin.getCoinName());

//        viewPrice.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Coin coin = (Coin) getItem(position);
//
//                Intent i = new Intent(getContext(),CoinDetailActivity.class);
//                i.putExtra("coin", (Serializable) coin);
//                getContext().startActivity(i);
//
//            }
//        });

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Coin coin = (Coin) getItem(position);
                Toast.makeText(view.getContext(), coin.getCoinName(), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getContext(), CoinDetailActivity.class);
                i.putExtra("coin", (Serializable) coin);
                getContext().startActivity(i);
            }
        });

        return convertView;
    }
}
