package com.bytedance.sdk.component.ML.KZx.pA.Og;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.ML.XT;

/* JADX INFO: loaded from: classes.dex */
public class Og implements XT {
    private com.bytedance.sdk.component.ML.KZx.pA.KZx<String, Bitmap> KZx;
    private int Og;
    private int pA;

    public Og(int i, int i2) {
        this.Og = i;
        this.pA = i2;
        this.KZx = new com.bytedance.sdk.component.ML.KZx.pA.KZx<String, Bitmap>(i) { // from class: com.bytedance.sdk.component.ML.KZx.pA.Og.Og.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.sdk.component.ML.KZx.pA.KZx
            /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
            public int Og(String str, Bitmap bitmap) {
                if (bitmap == null) {
                    return 0;
                }
                return Og.pA(bitmap);
            }
        };
    }

    @Override // com.bytedance.sdk.component.ML.pA
    public boolean pA(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            return false;
        }
        this.KZx.pA(str, bitmap);
        return true;
    }

    @Override // com.bytedance.sdk.component.ML.pA
    public Bitmap pA(String str) {
        return this.KZx.pA(str);
    }

    @Override // com.bytedance.sdk.component.ML.pA
    public boolean Og(String str) {
        return this.KZx.pA(str) != null;
    }

    public static int pA(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getAllocationByteCount();
    }
}
