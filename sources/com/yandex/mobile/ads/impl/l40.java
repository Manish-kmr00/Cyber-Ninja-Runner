package com.yandex.mobile.ads.impl;

import com.json.mediationsdk.utils.IronSourceConstants;
import java.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public final class l40 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f9476a = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] b = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};
    private static final int[] c = {64, 112, 128, 192, 224, 256, 384, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, IronSourceConstants.IS_AD_UNIT_CAPPED, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    public static gc0 a(byte[] bArr, String str, String str2) {
        vf1 vf1Var;
        if (bArr[0] == 127) {
            vf1Var = new vf1(bArr.length, bArr);
        } else {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
            byte b2 = bArrCopyOf[0];
            if (b2 == -2 || b2 == -1) {
                for (int i = 0; i < bArrCopyOf.length - 1; i += 2) {
                    byte b3 = bArrCopyOf[i];
                    int i2 = i + 1;
                    bArrCopyOf[i] = bArrCopyOf[i2];
                    bArrCopyOf[i2] = b3;
                }
            }
            vf1Var = new vf1(bArrCopyOf.length, bArrCopyOf);
            if (bArrCopyOf[0] == 31) {
                vf1 vf1Var2 = new vf1(bArrCopyOf.length, bArrCopyOf);
                while (vf1Var2.b() >= 16) {
                    vf1Var2.d(2);
                    vf1Var.a(vf1Var2.b(14));
                }
            }
            vf1Var.a(bArrCopyOf.length, bArrCopyOf);
        }
        vf1Var.d(60);
        int i3 = f9476a[vf1Var.b(6)];
        int i4 = b[vf1Var.b(4)];
        int iB = vf1Var.b(5);
        int i5 = iB < 29 ? (c[iB] * 1000) / 2 : -1;
        vf1Var.d(10);
        return new gc0.a().b(str).e("audio/vnd.dts").b(i5).c(i3 + (vf1Var.b(2) > 0 ? 1 : 0)).l(i4).a((c40) null).d(str2).a();
    }
}
