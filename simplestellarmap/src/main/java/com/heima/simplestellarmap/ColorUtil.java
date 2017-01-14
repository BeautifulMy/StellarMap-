package com.heima.simplestellarmap;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;

import java.util.Random;

/**
 * Created by Administrator on 2017/1/13.
 */

public class ColorUtil {
    private static Random random = new Random();
    public static int getColor(){
        int red =50+random.nextInt(160);
        int green = 50+random.nextInt(160);
        int blue = 50+random.nextInt(160);
        return Color.rgb(red,green,blue);

    }
    public static Drawable getStateDrawerList(){
        GradientDrawable gradientDrawable = new GradientDrawable();
        //设置随机颜色
        gradientDrawable.setColor(getColor());
       //设置圆角
        gradientDrawable.setCornerRadius(6);
        GradientDrawable gradientDrawablePress = new GradientDrawable();
        //设置随机颜色
        gradientDrawablePress.setColor(getColor());
       //设置圆角
        gradientDrawablePress.setCornerRadius(6);
        StateListDrawable listDrawable = new StateListDrawable();
        listDrawable.addState(new int[]{android.R.attr.state_pressed},gradientDrawablePress);
        listDrawable.addState(new int[]{},gradientDrawable);
        return listDrawable;

    }
}
