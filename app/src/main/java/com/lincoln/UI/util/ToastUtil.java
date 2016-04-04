package com.lincoln.UI.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by lincoln on 16/4/3.
 */
public class ToastUtil {

    private static Toast mToast;
    private ToastUtil(Context context) {
        if (mToast == null) {
            mToast = new Toast(context);
        }
    }

    public static void ShowLong(Context context, String content) {
        mToast.makeText(context, content, mToast.LENGTH_LONG).show();
    }

    public static void ShowShort(Context context, String content) {
        mToast.makeText(context, content, mToast.LENGTH_SHORT).show();
    }

    public static void ShowLong(Context context, int resId) {
        String content = context.getResources().getString(resId);
        ShowLong(context, content);
    }

    public static void ShowShort(Context context, int resId) {
        String content = context.getResources().getString(resId);
        ShowShort(context, content);
    }

}
