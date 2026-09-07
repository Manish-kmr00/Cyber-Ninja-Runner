package com.bytedance.adsdk.Og.Og;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.adsdk.Og.KZx;
import com.bytedance.adsdk.Og.KZx.SD;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class pA {
    private KZx ML;
    private final AssetManager ZZv;
    private final SD<String> pA = new SD<>();
    private final Map<SD<String>, Typeface> Og = new HashMap();
    private final Map<String, Typeface> KZx = new HashMap();
    private String JG = ".ttf";

    public pA(Drawable.Callback callback, KZx kZx) {
        this.ML = kZx;
        if (!(callback instanceof View)) {
            this.ZZv = null;
        } else {
            this.ZZv = ((View) callback).getContext().getAssets();
        }
    }

    public void pA(KZx kZx) {
        this.ML = kZx;
    }

    public void pA(String str) {
        this.JG = str;
    }

    public Typeface pA(com.bytedance.adsdk.Og.KZx.KZx kZx) {
        this.pA.pA(kZx.pA(), kZx.KZx());
        Typeface typeface = this.Og.get(this.pA);
        if (typeface != null) {
            return typeface;
        }
        Typeface typefacePA = pA(Og(kZx), kZx.KZx());
        this.Og.put(this.pA, typefacePA);
        return typefacePA;
    }

    private Typeface Og(com.bytedance.adsdk.Og.KZx.KZx kZx) {
        Typeface typefaceCreateFromAsset;
        String strPA = kZx.pA();
        Typeface typeface = this.KZx.get(strPA);
        if (typeface != null) {
            return typeface;
        }
        String strKZx = kZx.KZx();
        String strOg = kZx.Og();
        KZx kZx2 = this.ML;
        if (kZx2 != null) {
            typefaceCreateFromAsset = kZx2.pA(strPA, strKZx, strOg);
            if (typefaceCreateFromAsset == null) {
                typefaceCreateFromAsset = this.ML.pA(strPA);
            }
        } else {
            typefaceCreateFromAsset = null;
        }
        KZx kZx3 = this.ML;
        if (kZx3 != null && typefaceCreateFromAsset == null) {
            String strOg2 = kZx3.Og(strPA, strKZx, strOg);
            if (strOg2 == null) {
                strOg2 = this.ML.Og(strPA);
            }
            if (strOg2 != null) {
                try {
                    typefaceCreateFromAsset = Typeface.createFromAsset(this.ZZv, strOg2);
                } catch (Throwable unused) {
                    typefaceCreateFromAsset = Typeface.DEFAULT;
                }
            }
        }
        if (kZx.ZZv() != null) {
            return kZx.ZZv();
        }
        if (typefaceCreateFromAsset == null) {
            try {
                typefaceCreateFromAsset = Typeface.createFromAsset(this.ZZv, "fonts/" + strPA + this.JG);
            } catch (Throwable unused2) {
                typefaceCreateFromAsset = Typeface.DEFAULT;
            }
        }
        this.KZx.put(strPA, typefaceCreateFromAsset);
        return typefaceCreateFromAsset;
    }

    private Typeface pA(Typeface typeface, String str) {
        int i;
        boolean zContains = str.contains("Italic");
        boolean zContains2 = str.contains("Bold");
        if (zContains && zContains2) {
            i = 3;
        } else if (zContains) {
            i = 2;
        } else {
            i = zContains2 ? 1 : 0;
        }
        return typeface.getStyle() == i ? typeface : Typeface.create(typeface, i);
    }
}
