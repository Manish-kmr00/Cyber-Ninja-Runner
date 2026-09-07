package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes9.dex */
public class KZx {
    public static void pA(ViewGroup viewGroup, com.bytedance.sdk.openadsdk.core.model.yFO yfo) {
        if (viewGroup == null || yfo == null || TextUtils.isEmpty(yfo.ZL())) {
            return;
        }
        try {
            if (viewGroup.getTag(Sn.ged) != null) {
                return;
            }
            int i = Sn.ged;
            viewGroup.setTag(i, Integer.valueOf(i));
            Drawable drawablePA = pA(viewGroup.getResources(), yfo);
            if (drawablePA == null) {
                return;
            }
            viewGroup.setForeground(drawablePA);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("add overlay fail", th.getMessage());
        }
    }

    public static void pA(Activity activity, com.bytedance.sdk.openadsdk.core.model.yFO yfo) {
        if (activity == null || yfo == null || TextUtils.isEmpty(yfo.ZL())) {
            return;
        }
        try {
            if (activity.getWindow().getDecorView().getTag(Sn.ged) != null) {
                return;
            }
            View decorView = activity.getWindow().getDecorView();
            int i = Sn.ged;
            decorView.setTag(i, Integer.valueOf(i));
            Drawable drawablePA = pA(activity.getResources(), yfo);
            if (drawablePA == null) {
                return;
            }
            activity.getWindow().getDecorView().setForeground(drawablePA);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("add overlay fail", th.getMessage());
        }
    }

    private static Drawable pA(Resources resources, com.bytedance.sdk.openadsdk.core.model.yFO yfo) {
        try {
            String strZL = yfo.ZL();
            if (TextUtils.isEmpty(strZL)) {
                return null;
            }
            byte[] bArrDecode = Base64.decode(strZL, 0);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(resources, BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            bitmapDrawable.setTileModeXY(tileMode, tileMode);
            bitmapDrawable.setTargetDensity(resources.getDisplayMetrics());
            return bitmapDrawable;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static class pA implements View.OnLayoutChangeListener {
        private int KZx;
        private int Og;
        private final Drawable pA;

        public pA(Drawable drawable) {
            this.pA = drawable;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            int i9 = i3 - i;
            int i10 = i4 - i2;
            if (i9 == this.Og && i10 == this.KZx) {
                return;
            }
            this.Og = i9;
            this.KZx = i10;
            this.pA.setBounds(0, 0, i9, i10);
        }
    }
}
