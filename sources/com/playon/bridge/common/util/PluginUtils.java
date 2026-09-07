package com.playon.bridge.common.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.PopupWindow;
import androidx.core.content.ContextCompat;
import com.playon.bridge.common.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public class PluginUtils {
    protected static final String TAG = Log.makeTag("RemoteConfig");

    public static int densityPixelsToPixels(float f, int i) {
        return (int) ((i * f) + 0.5f);
    }

    public static float lerp(float f, float f2, float f3) {
        return f + ((f2 - f) * f3);
    }

    public static float getDeviceDensityPixelScale(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static float convertPixelsToDp(float f) {
        return f / Resources.getSystem().getDisplayMetrics().density;
    }

    public static int manipulateColor(int i, float f) {
        return Color.argb(Color.alpha(i), Math.min(Math.round(Color.red(i) * f), 255), Math.min(Math.round(Color.green(i) * f), 255), Math.min(Math.round(Color.blue(i) * f), 255));
    }

    public static float convertDpToPixel(float f) {
        return f * Resources.getSystem().getDisplayMetrics().density;
    }

    public static void setPopUpWindowLayoutType(PopupWindow popupWindow, int i) {
        try {
            Method declaredMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(popupWindow, Integer.valueOf(i));
        } catch (IllegalAccessException e) {
            android.util.Log.w(TAG, String.format("Unable to set popUpWindow window layout type: %s", e.getLocalizedMessage()));
        } catch (NoSuchMethodException e2) {
            android.util.Log.w(TAG, String.format("Unable to set popUpWindow window layout type: %s", e2.getLocalizedMessage()));
        } catch (InvocationTargetException e3) {
            android.util.Log.d(TAG, String.format("Unable to set popUpWindow window layout type: %s", e3.getLocalizedMessage()));
        }
    }

    public static boolean isPermissionGranted(Context context, String str) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(str);
        try {
            return ContextCompat.checkSelfPermission(context, str) == 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
