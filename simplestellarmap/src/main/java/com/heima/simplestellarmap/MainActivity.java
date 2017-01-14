package com.heima.simplestellarmap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ArrayList<ArrayList<String>> groups;
    private StellarMap stellarMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        stellarMap = new StellarMap(this);
        ArrayList<String> group0 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            group0.add("嘿嘿" + i);

        }
        ArrayList<String> group1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            group1.add("哈哈" + i);

        }
        ArrayList<String> group2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            group2.add("呵呵" + i);


        }
        groups = new ArrayList<>();
        groups.add(group0);
        groups.add(group1);
        groups.add(group2);

        //设置X,Y轴上显示的个数
        stellarMap.setRegularity(15,15);
        //设置内容上的缩进
        stellarMap.setInnerPadding(10,10,10,10);
        stellarMap.setAdapter(adapter);
        setContentView(stellarMap);

    }

    public StellarMap.Adapter adapter= new StellarMap.Adapter(){
        @Override
        //组数
        public int getGroupCount() {
            return groups.size();
        }
        //stellarmap通过 指定下标获取 组元素的个数
        @Override
        public int getCount(int group) {
            ArrayList<String> list = groups.get(group);
            return list.size();
        }
        //stellarMap获取元素
        @Override
        public View getView(int group, int position, View convertView) {
            TextView textView = new TextView(stellarMap.getContext());
            textView.setTextSize(12+new Random().nextInt(6));
            textView.setTextColor(ColorUtil.getColor());
            ArrayList<String> list = groups.get(group);
            String item = list.get(position);
            textView.setText(item);


            return textView;
        }
        //决定数组的切换顺序
        @Override
        public int getNextGroupOnZoom(int group, boolean isZoomIn) {
            ++group;
            group=group%getGroupCount();
            return group;
        }
    };
}