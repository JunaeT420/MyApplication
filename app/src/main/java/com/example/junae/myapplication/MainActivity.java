package com.example.junae.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

import com.bakerj.infinitecards.InfiniteCardView;
import com.bakerj.infinitecards.transformer.DefaultCommonTransformer;
import com.bakerj.infinitecards.transformer.DefaultTransformerToBack;
import com.bakerj.infinitecards.transformer.DefaultTransformerToFront;
import com.bakerj.infinitecards.transformer.DefaultZIndexTransformerCommon;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
Button pri,pro;
    CardAdapter cardAdapter;
    InfiniteCardView infiniteCardView;
    List<Integer> imges=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pri= (Button) findViewById(R.id.pre);
        pro= (Button) findViewById(R.id.pro);
        infiniteCardView= (InfiniteCardView) findViewById(R.id.view);

        imges.add(R.drawable.item_1);
        imges.add(R.drawable.item_1);
        imges.add(R.drawable.item_1);

        cardAdapter=new CardAdapter(this,imges);
        infiniteCardView.setClickable(true);
        infiniteCardView.setAnimType(InfiniteCardView.ANIM_TYPE_FRONT);
        infiniteCardView.setAnimInterpolator(new LinearInterpolator());
        infiniteCardView.setTransformerToFront(new DefaultTransformerToFront());
        infiniteCardView.setTransformerToBack(new DefaultTransformerToBack());
infiniteCardView.setZIndexTransformerCommon(new DefaultZIndexTransformerCommon());
        infiniteCardView.setAdapter(cardAdapter);

        pri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infiniteCardView.bringCardToFront(1);
            }
        });

        pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infiniteCardView.bringCardToFront(cardAdapter.getCount()-1);
            }
        });
    }
}
