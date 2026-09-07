package com.bytedance.adsdk.Og.Og;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.bytedance.adsdk.Og.JG.JG;
import com.bytedance.adsdk.Og.SGo;
import com.bytedance.adsdk.Og.ZZv;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public class Og {
    private static final Object pA = new Object();
    private final String KZx;
    private final Map<String, SGo> ML;
    private final Context Og;
    private ZZv ZZv;

    public Og(Drawable.Callback callback, String str, ZZv zZv, Map<String, SGo> map) {
        if (!TextUtils.isEmpty(str) && str.charAt(str.length() - 1) != '/') {
            this.KZx = str + '/';
        } else {
            this.KZx = str;
        }
        this.ML = map;
        pA(zZv);
        if (!(callback instanceof View)) {
            this.Og = null;
        } else {
            this.Og = ((View) callback).getContext().getApplicationContext();
        }
    }

    public void pA(ZZv zZv) {
        this.ZZv = zZv;
    }

    public Bitmap pA(String str, Bitmap bitmap) {
        if (bitmap == null) {
            SGo sGo = this.ML.get(str);
            Bitmap bitmapBSW = sGo.BSW();
            sGo.pA(null);
            return bitmapBSW;
        }
        return this.ML.get(str).BSW();
    }

    public Bitmap pA(String str) {
        SGo sGo = this.ML.get(str);
        if (sGo == null) {
            return null;
        }
        Bitmap bitmapBSW = sGo.BSW();
        if (bitmapBSW != null) {
            return bitmapBSW;
        }
        ZZv zZv = this.ZZv;
        if (zZv != null) {
            return zZv.pA(sGo);
        }
        Context context = this.Og;
        if (context == null) {
            return null;
        }
        String strBzk = sGo.Bzk();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (strBzk.startsWith("data:") && strBzk.indexOf("base64,") > 0) {
            try {
                byte[] bArrDecode = Base64.decode(strBzk.substring(strBzk.indexOf(44) + 1), 0);
                return Og(str, BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        try {
            if (TextUtils.isEmpty(this.KZx)) {
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(context.getAssets().open(this.KZx + strBzk), null, options);
                if (bitmapDecodeStream == null) {
                    return null;
                }
                return Og(str, JG.pA(bitmapDecodeStream, sGo.pA(), sGo.Og()));
            } catch (IllegalArgumentException unused2) {
                return null;
            }
        } catch (IOException unused3) {
            return null;
        }
    }

    public boolean pA(Context context) {
        return (context == null && this.Og == null) || this.Og.equals(context);
    }

    private Bitmap Og(String str, Bitmap bitmap) {
        synchronized (pA) {
        }
        return bitmap;
    }
}
