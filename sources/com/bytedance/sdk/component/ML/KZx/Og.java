package com.bytedance.sdk.component.ML.KZx;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.component.ML.DX;
import com.bytedance.sdk.component.ML.SGo;
import com.bytedance.sdk.component.ML.Wx;
import com.bytedance.sdk.component.ML.yFO;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes13.dex */
public class Og implements DX {
    private volatile JG pA;

    private Og() {
    }

    public static DX pA(Context context, Wx wx) {
        Og og = new Og();
        og.Og(context, wx);
        return og;
    }

    private void Og(Context context, Wx wx) {
        if (this.pA != null) {
            Log.w("ImageLoader", "already init!");
        }
        if (wx == null) {
            wx = ML.pA(context);
        }
        this.pA = new JG(context, wx);
    }

    @Override // com.bytedance.sdk.component.ML.DX
    public SGo pA(String str) {
        return new KZx.Og(this.pA).KZx(str);
    }

    @Override // com.bytedance.sdk.component.ML.DX
    public InputStream pA(String str, String str2) {
        if (this.pA != null) {
            if (TextUtils.isEmpty(str2)) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                str2 = com.bytedance.sdk.component.ML.KZx.KZx.KZx.pA(str);
            }
            Collection<yFO> collectionOg = this.pA.Og();
            if (collectionOg != null) {
                Iterator<yFO> it = collectionOg.iterator();
                while (it.hasNext()) {
                    byte[] bArrPA = it.next().pA(str2);
                    if (bArrPA != null) {
                        return new ByteArrayInputStream(bArrPA);
                    }
                }
            }
            Collection<com.bytedance.sdk.component.ML.KZx> collectionKZx = this.pA.KZx();
            if (collectionKZx != null) {
                Iterator<com.bytedance.sdk.component.ML.KZx> it2 = collectionKZx.iterator();
                while (it2.hasNext()) {
                    InputStream inputStreamPA = it2.next().pA(str2);
                    if (inputStreamPA != null) {
                        return inputStreamPA;
                    }
                }
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.ML.DX
    public boolean pA(String str, String str2, String str3) {
        if (this.pA == null || TextUtils.isEmpty(str3)) {
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            str2 = com.bytedance.sdk.component.ML.KZx.KZx.KZx.pA(str);
        }
        com.bytedance.sdk.component.ML.KZx kZxPA = this.pA.pA(str3);
        if (kZxPA != null) {
            return kZxPA.Og(str2);
        }
        return false;
    }
}
