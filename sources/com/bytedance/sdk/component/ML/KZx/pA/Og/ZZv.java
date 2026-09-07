package com.bytedance.sdk.component.ML.KZx.pA.Og;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.ML.XT;

/* JADX INFO: loaded from: classes13.dex */
public class ZZv implements XT {
    private final com.bytedance.sdk.component.ML.KZx.pA.Og Og;
    private final XT pA;

    public ZZv(XT xt) {
        this(xt, null);
    }

    public ZZv(XT xt, com.bytedance.sdk.component.ML.KZx.pA.Og og) {
        this.pA = xt;
        this.Og = og;
    }

    @Override // com.bytedance.sdk.component.ML.pA
    public boolean pA(String str, Bitmap bitmap) {
        boolean zPA = this.pA.pA(str, bitmap);
        if (this.Og != null) {
            Boolean.valueOf(zPA);
        }
        return zPA;
    }

    @Override // com.bytedance.sdk.component.ML.pA
    public Bitmap pA(String str) {
        return this.pA.pA(str);
    }

    @Override // com.bytedance.sdk.component.ML.pA
    public boolean Og(String str) {
        return this.pA.Og(str);
    }
}
