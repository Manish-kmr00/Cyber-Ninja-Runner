package com.bytedance.sdk.openadsdk.utils;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes3.dex */
public class DX {

    public interface pA {
        void pA();

        void pA(com.bytedance.sdk.openadsdk.aBv.pA.Og og);
    }

    public static void pA(com.bytedance.sdk.openadsdk.aBv.pA pAVar, int i, int i2, pA pAVar2, String str) {
        pA(pAVar, i, i2, pAVar2, str, 0);
    }

    public static void pA(com.bytedance.sdk.openadsdk.aBv.pA pAVar, int i, int i2, final pA pAVar2, String str, int i3) {
        com.bytedance.sdk.component.utils.WV.pA("splashLoadAd", " getImageBytes url ".concat(String.valueOf(pAVar)));
        com.bytedance.sdk.openadsdk.aBv.KZx.pA().KZx().pA(pAVar, new com.bytedance.sdk.openadsdk.aBv.pA.pA.InterfaceC0220pA() { // from class: com.bytedance.sdk.openadsdk.utils.DX.1
            @Override // com.bytedance.sdk.openadsdk.aBv.pA.pA.InterfaceC0220pA
            public void pA(String str2, com.bytedance.sdk.openadsdk.aBv.pA.Og og) {
                pA pAVar3;
                if (og.ZZv() && (pAVar3 = pAVar2) != null) {
                    pAVar3.pA(og);
                    return;
                }
                pA pAVar4 = pAVar2;
                if (pAVar4 != null) {
                    pAVar4.pA();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.aBv.pA.pA.InterfaceC0220pA
            public void pA(int i4, String str2, Throwable th) {
                pA pAVar3 = pAVar2;
                if (pAVar3 != null) {
                    pAVar3.pA();
                }
            }
        }, i, i2, ImageView.ScaleType.CENTER_INSIDE, str, i3, null);
    }

    public static Drawable pA(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= 0) {
            return new ColorDrawable(0);
        }
        try {
            return new BitmapDrawable(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
        } catch (Throwable unused) {
            return new ColorDrawable(0);
        }
    }
}
