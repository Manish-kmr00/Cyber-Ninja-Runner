package com.bytedance.sdk.component.ML.ZZv;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.ML.XT;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes8.dex */
public class SGo extends pA {
    @Override // com.bytedance.sdk.component.ML.ZZv.Bzk
    public void pA(com.bytedance.sdk.component.ML.KZx.KZx kZx) {
        Bitmap bitmapOg;
        int iWV = kZx.WV();
        if (iWV != 2 && iWV != 1) {
            bitmapOg = null;
        } else if (kZx.Sd() || kZx.vZF().JG()) {
            bitmapOg = Og(kZx);
        } else {
            bitmapOg = KZx(kZx);
        }
        if (bitmapOg == null) {
            kZx.pA(new WV());
        } else {
            kZx.pA(new Wx(bitmapOg, null, false));
        }
    }

    @Override // com.bytedance.sdk.component.ML.ZZv.Bzk
    public String pA() {
        return "memory_cache";
    }

    private Bitmap Og(com.bytedance.sdk.component.ML.KZx.KZx kZx) {
        Collection<XT> collectionPA = kZx.yFO().pA();
        Bitmap bitmapPA = null;
        if (collectionPA == null) {
            return null;
        }
        Iterator<XT> it = collectionPA.iterator();
        while (it.hasNext() && (bitmapPA = it.next().pA(kZx.ML())) == null) {
        }
        return bitmapPA;
    }

    private Bitmap KZx(com.bytedance.sdk.component.ML.KZx.KZx kZx) {
        return kZx.yFO().pA(kZx.vZF()).pA(kZx.ML());
    }
}
