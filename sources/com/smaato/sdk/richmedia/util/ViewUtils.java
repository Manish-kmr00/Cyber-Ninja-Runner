package com.smaato.sdk.richmedia.util;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;

/* JADX INFO: loaded from: classes13.dex */
public final class ViewUtils {
    public static View getRootView(View view) {
        View rootViewOfActivity = getRootViewOfActivity(view.getContext());
        return rootViewOfActivity == null ? getRootViewOfView(view) : rootViewOfActivity;
    }

    private static View getRootViewOfActivity(Context context) {
        Window window;
        if ((context instanceof Activity) && (window = ((Activity) context).getWindow()) != null) {
            return window.getDecorView().findViewById(R.id.content);
        }
        return null;
    }

    private static View getRootViewOfView(View view) {
        if (!isAttachedToWindow(view)) {
            Log.d("SmaatoSDK", "Attempting to call View#getRootView() on an unattached View.");
        }
        View rootView = view.getRootView();
        if (rootView == null) {
            return null;
        }
        View viewFindViewById = rootView.findViewById(R.id.content);
        return viewFindViewById == null ? rootView : viewFindViewById;
    }

    public static ViewGroup getParent(View view) {
        ViewParent parent = view.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            return (ViewGroup) parent;
        }
        return null;
    }

    public static void removeFromParent(View view) {
        ViewGroup parent = getParent(view);
        if (parent != null) {
            parent.removeView(view);
        }
    }

    private static boolean isAttachedToWindow(View view) {
        return view.isAttachedToWindow();
    }
}
