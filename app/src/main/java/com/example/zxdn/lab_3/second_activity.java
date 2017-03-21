package com.example.zxdn.lab_3;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by zxdn on 2016/10/25.
 */
public class second_activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        final  ListView information=(ListView)findViewById(R.id.contact_names);
        final String[] info= new String[] {"编辑联系人","分享联系人", "加入黑名单","删除联系人"};
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,R.layout.item_for_second,R.id.info_item,info);
        information.setAdapter(arrayAdapter);

        final TextView name= (TextView)findViewById(R.id.Name);
        final TextView phonenum= (TextView)findViewById(R.id.phone);
        final TextView location= (TextView)findViewById(R.id.location);
        final RelativeLayout top= (RelativeLayout)findViewById(R.id.background);
        final ImageView star= (ImageView)findViewById(R.id.star);
        final ImageView back= (ImageView)findViewById(R.id.back);

        Intent intent = this.getIntent();
        name.setText(intent.getStringExtra("name"));
        phonenum.setText(intent.getStringExtra("phone"));
        location.setText("手机  "+intent.getStringExtra("location"));
        top.setBackgroundColor(Color.parseColor("#"+intent.getStringExtra("color")));


        star.setTag(1);
        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (star.getTag().toString().equals("1")) {
                    star.setImageResource(R.mipmap.full_star);
                    star.setTag(0);
                } else {
                    star.setImageResource(R.mipmap.empty_star);
                    star.setTag(1);
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                second_activity.this.finish();
            }
        });
    }
}