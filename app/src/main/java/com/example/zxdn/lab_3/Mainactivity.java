package com.example.zxdn.lab_3;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zxdn on 2016/10/15.
 */

public class  Mainactivity  extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        final List<Map<String,Object>> data= new ArrayList<>();
        final String[] names = new String[] {"Aaron", "Elvis", "David", "Edwin",
                         "Frank", "Joshua", "Ivan", "Mark", "Joseph", "Phoebe"};
        final String[] letter= new String[] {"A", "E", "D", "E", "F", "J", "I", "M", "J", "P"};
        final String[] location= new String[] {"江苏苏州电信", "广东揭阳移动", "江苏无锡移动", "山东青岛移动", "安徽合肥移动",
                          "江苏苏州移动", "山东烟台联通", "广东珠海电信", "河北石家庄电信", "山东东营移动"};
        final String[] backgroundcolor= new String[] {"BB4C3B", "c48d30", "4469b0", "20A17B", "BB4C3B", "c48d30", "4469b0", "20A17B",
                          "BB4C3B", "c48d30"};
        final String[] phone= new String[] {"17715523654", "18825653224", "15052116654", "18854211875", "13955188541",
                          "13621574410", "15684122771", "17765213579", "13315466578", "17895466428"};
        for (int i= 0; i< 10; i++ ) {
            Map<String, Object> temp= new LinkedHashMap<>();
            temp.put("big", letter[i]);
            temp.put("person", names[i]);
            temp.put("lotion", location[i]);
            temp.put("color", backgroundcolor[i]);
            temp.put("num",phone[i]);
            data.add(temp);
        }
        ListView listview = (ListView) findViewById(R.id.contacts_list);
        final SimpleAdapter simpleAdapter = new SimpleAdapter(this, data, R.layout.item,
                new String[]{"big", "person"}, new int[] {R.id.big, R.id.person});
        listview.setAdapter(simpleAdapter);

        final AlertDialog.Builder alertDialog= new AlertDialog.Builder(this);

        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int t= i;
                alertDialog.setTitle("删除联系人").setMessage("确定删除联系人"+ data.get(i).get("person").toString()+"?").setPositiveButton("确定",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                data.remove(t);
                                simpleAdapter.notifyDataSetChanged();
                            }
                        }).setNegativeButton("取消",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //do nothing
                            }
                        }).create();
                alertDialog.show();
                return false;
            }
        });

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent= new Intent();
                intent.setClass(Mainactivity.this, second_activity.class);
                intent.putExtra("name", data.get(i).get("person").toString());
                intent.putExtra("phone", data.get(i).get("num").toString());
                intent.putExtra("location", data.get(i).get("lotion").toString());
                intent.putExtra("color",data.get(i).get("color").toString());
                startActivity(intent);
            }
        });
    }
}
