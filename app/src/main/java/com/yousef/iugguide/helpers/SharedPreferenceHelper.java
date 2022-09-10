package com.yousef.iugguide.helpers;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceHelper {

    public static int getIconsColor(Context context) {
        SharedPreferences pref = context.getSharedPreferences("MySharedPref", MODE_PRIVATE);
        return pref.getInt("icons_color", 0);
    }

    public static void setIconsColor(Context context, int color) {
        SharedPreferences pref = context.getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("icons_color", color);
        editor.apply();
    }

    public static int getBackgroundColor(Context context) {
        SharedPreferences pref = context.getSharedPreferences("MySharedPref", MODE_PRIVATE);
        return pref.getInt("background_color", 0);
    }

    public static void setBackgroundColor(Context context, int color) {
        SharedPreferences pref = context.getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("background_color", color);
        editor.apply();
    }

    public static int getFontColor(Context context) {
        SharedPreferences pref = context.getSharedPreferences("MySharedPref", MODE_PRIVATE);
        return pref.getInt("font_color", 0);
    }

    public static void setFontColor(Context context, int color) {
        SharedPreferences pref = context.getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("font_color", color);
        editor.apply();
    }

    public static void resetSharedPreferences(Context context) {
        SharedPreferences pref = context.getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear().apply();
    }
}
