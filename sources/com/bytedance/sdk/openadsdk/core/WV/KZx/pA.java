package com.bytedance.sdk.openadsdk.core.WV.KZx;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class pA {
    public static final Set<String> pA = new HashSet<String>() { // from class: com.bytedance.sdk.openadsdk.core.WV.KZx.pA.1
        {
            add("image/jpeg");
            add("image/png");
            add("image/bmp");
            add("image/gif");
            add("image/jpg");
        }
    };
    public static Set<String> Og = new HashSet<String>() { // from class: com.bytedance.sdk.openadsdk.core.WV.KZx.pA.2
        {
            add("application/x-javascript");
        }
    };

    public enum Og {
        HTML_RESOURCE,
        STATIC_RESOURCE,
        IFRAME_RESOURCE
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.WV.KZx.pA$pA, reason: collision with other inner class name */
    public enum EnumC0233pA {
        NONE,
        IMAGE,
        JAVASCRIPT
    }

    public static Point pA(Context context, int i, int i2, Og og) {
        if (context == null) {
            context = aBv.pA();
        }
        Point point = new Point(i, i2);
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        int width = defaultDisplay.getWidth();
        int height = defaultDisplay.getHeight();
        int iKZx = Vgu.KZx(context, i);
        int iKZx2 = Vgu.KZx(context, i2);
        if (iKZx <= width && iKZx2 <= height) {
            return point;
        }
        Point point2 = new Point();
        if (Og.HTML_RESOURCE == og) {
            point2.x = Math.min(width, iKZx);
            point2.y = Math.min(height, iKZx2);
        } else {
            float f = iKZx;
            float f2 = f / width;
            float f3 = iKZx2;
            float f4 = f3 / height;
            if (f2 >= f4) {
                point2.x = width;
                point2.y = (int) (f3 / f2);
            } else {
                point2.x = (int) (f / f4);
                point2.y = height;
            }
        }
        if (point2.x < 0 || point2.y < 0) {
            return point;
        }
        point2.x = Vgu.ZZv(context, point2.x);
        point2.y = Vgu.ZZv(context, point2.y);
        return point2;
    }
}
