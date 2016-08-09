package me.android.utils.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;


/**
 * Created by m on 2016/8/9.
 */
public class Utils {

    private static Utils instance;

    public static synchronized Utils getInstance(){
        if(instance == null){
            instance = new Utils();
        }
        return instance;
    }

    private  int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public Utils setStatusBarTranslucent(Activity activity, int statusBarColor){
        /** Set up translucent status bar */
        if (Build.VERSION.SDK_INT >= 19) {
            activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            activity.getWindow().setStatusBarColor(statusBarColor);
        }
        return this;
    }

    public Utils setStatusBarHeight(View view,Context context){
        view.getLayoutParams().height = getStatusBarHeight(context);
        return this;
    }

    public Utils setNavigationBarColor(Activity activity,int color,boolean flag){
        if (Build.VERSION.SDK_INT >= 21&&flag) {
            activity.getWindow().setNavigationBarColor(activity.getResources().getColor(color));
        }
        return this;
    }

}
