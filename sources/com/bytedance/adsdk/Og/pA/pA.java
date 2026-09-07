package com.bytedance.adsdk.Og.pA;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.os.LocaleList;
import androidx.core.view.ViewCompat;
import com.bytedance.adsdk.Og.JG.ML;

/* JADX INFO: loaded from: classes6.dex */
public class pA extends Paint {
    @Override // android.graphics.Paint
    public void setTextLocales(LocaleList localeList) {
    }

    public pA() {
    }

    public pA(int i) {
        super(i);
    }

    public pA(PorterDuff.Mode mode) {
        setXfermode(new PorterDuffXfermode(mode));
    }

    public pA(int i, PorterDuff.Mode mode) {
        super(i);
        setXfermode(new PorterDuffXfermode(mode));
    }

    @Override // android.graphics.Paint
    public void setAlpha(int i) {
        if (Build.VERSION.SDK_INT < 29) {
            setColor((ML.pA(i, 0, 255) << 24) | (getColor() & ViewCompat.MEASURED_SIZE_MASK));
        } else {
            super.setAlpha(ML.pA(i, 0, 255));
        }
    }
}
