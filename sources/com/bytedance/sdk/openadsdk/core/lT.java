package com.bytedance.sdk.openadsdk.core;

import android.graphics.Rect;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.Vgu;

/* JADX INFO: loaded from: classes13.dex */
public class lT {
    private static boolean pA(View view, int i) {
        float fPA = pA(view);
        return fPA > 0.0f && fPA >= ((float) i) / 100.0f;
    }

    public static float pA(View view) {
        if (view != null) {
            try {
                if (view.getVisibility() == 0 && view.getParent() != null) {
                    Rect rect = new Rect();
                    if (!view.getGlobalVisibleRect(rect)) {
                        return -1.0f;
                    }
                    long jHeight = ((long) rect.height()) * ((long) rect.width());
                    long height = ((long) view.getHeight()) * ((long) view.getWidth());
                    if (height <= 0) {
                        return -1.0f;
                    }
                    return jHeight / height;
                }
            } catch (Throwable unused) {
            }
        }
        return -1.0f;
    }

    private static boolean Og(View view) {
        return view != null && view.isShown();
    }

    private static boolean Og(View view, int i) {
        return view.getWidth() >= KZx(view, i) && view.getHeight() >= ZZv(view, i);
    }

    private static int KZx(View view, int i) {
        if (i == 3) {
            return (int) (((double) Vgu.KZx(view.getContext().getApplicationContext())) * 0.7d);
        }
        return 20;
    }

    private static int ZZv(View view, int i) {
        if (i == 3) {
            return Vgu.ZZv(view.getContext().getApplicationContext()) / 2;
        }
        return 20;
    }

    private static int Og(View view, int i, int i2) throws Throwable {
        if (view.getWindowVisibility() != 0) {
            return 4;
        }
        if (!Og(view)) {
            return 1;
        }
        if (Og(view, i2)) {
            return !pA(view, i) ? 3 : 0;
        }
        return 6;
    }

    public static boolean pA(View view, int i, int i2) {
        if (i2 == 1) {
            while (view != null) {
                try {
                    if (view.getVisibility() != 0) {
                        return false;
                    }
                    if ((view instanceof com.bytedance.sdk.openadsdk.core.omh.yFO) || (view instanceof com.bytedance.sdk.openadsdk.core.KZx.KZx)) {
                        break;
                    }
                    view = (View) view.getParent();
                } catch (Throwable unused) {
                }
            }
        }
        return Og(view, i, i2) == 0;
    }
}
