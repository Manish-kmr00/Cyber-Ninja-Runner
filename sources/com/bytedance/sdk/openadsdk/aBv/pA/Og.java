package com.bytedance.sdk.openadsdk.aBv.pA;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.component.utils.ZZv;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public class Og {
    private Map<String, String> JG;
    private Bitmap KZx;
    private List<Object> ML;
    private byte[] Og;
    private Bitmap ZZv;
    int pA;

    public Og(byte[] bArr, int i) {
        this.KZx = null;
        this.ZZv = null;
        this.ML = null;
        this.JG = null;
        this.Og = bArr;
        this.pA = i;
    }

    public Og(Bitmap bitmap, Bitmap bitmap2, int i) {
        this.Og = null;
        this.ML = null;
        this.JG = null;
        this.ZZv = bitmap2;
        this.KZx = bitmap;
        this.pA = i;
    }

    public Bitmap pA() {
        return this.KZx;
    }

    public Bitmap Og() {
        return this.ZZv;
    }

    public byte[] KZx() {
        try {
            if (this.Og == null) {
                this.Og = ZZv.pA(this.KZx);
            }
        } catch (OutOfMemoryError e) {
            WV.pA("GifRequestResult", e.getMessage());
        }
        return this.Og;
    }

    public boolean ZZv() {
        if (this.KZx != null) {
            return true;
        }
        byte[] bArr = this.Og;
        return bArr != null && bArr.length > 0;
    }
}
