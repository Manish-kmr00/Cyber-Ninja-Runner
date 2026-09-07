package com.yandex.mobile.ads.impl;

import com.amazon.device.ads.DtbConstants;
import com.google.common.primitives.SignedBytes;
import com.json.mediationsdk.utils.IronSourceConstants;

/* JADX INFO: loaded from: classes8.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f10521a = {2002, 2000, 1920, IronSourceConstants.RV_OPERATIONAL_LOAD_SUCCESS, IronSourceConstants.RV_OPERATIONAL_LOAD_AD, 1001, 1000, 960, 800, 800, DtbConstants.DEFAULT_PLAYER_HEIGHT, 400, 400, 2048};

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f10522a;
        public final int b;
        public final int c;

        private a(int i, int i2, int i3) {
            this.f10522a = i;
            this.b = i2;
            this.c = i3;
        }
    }

    public static void a(int i, wf1 wf1Var) {
        wf1Var.c(7);
        byte[] bArrC = wf1Var.c();
        bArrC[0] = -84;
        bArrC[1] = SignedBytes.MAX_POWER_OF_TWO;
        bArrC[2] = -1;
        bArrC[3] = -1;
        bArrC[4] = (byte) ((i >> 16) & 255);
        bArrC[5] = (byte) ((i >> 8) & 255);
        bArrC[6] = (byte) (i & 255);
    }

    /* JADX WARN: Code duplicated, block: B:44:0x008b  */
    /* JADX WARN: Code duplicated, block: B:47:0x0090  */
    /* JADX WARN: Code duplicated, block: B:48:0x0092  */
    /* JADX WARN: Code duplicated, block: B:49:0x0095  */
    public static a a(vf1 vf1Var) {
        int i;
        int i2;
        int iB = vf1Var.b(16);
        int iB2 = vf1Var.b(16);
        if (iB2 == 65535) {
            iB2 = vf1Var.b(24);
            i = 7;
        } else {
            i = 4;
        }
        int i3 = iB2 + i;
        if (iB == 44097) {
            i3 += 2;
        }
        if (vf1Var.b(2) == 3) {
            do {
                vf1Var.b(2);
            } while (vf1Var.f());
        }
        int iB3 = vf1Var.b(10);
        if (vf1Var.f() && vf1Var.b(3) > 0) {
            vf1Var.d(2);
        }
        int i4 = vf1Var.f() ? 48000 : 44100;
        int iB4 = vf1Var.b(4);
        if (i4 == 44100 && iB4 == 13) {
            i2 = f10521a[iB4];
        } else if (i4 == 48000) {
            int[] iArr = f10521a;
            if (iB4 < 14) {
                int i5 = iArr[iB4];
                int i6 = iB3 % 5;
                if (i6 == 1) {
                    if (iB4 != 3 || iB4 == 8) {
                        i2 = i5 + 1;
                    } else {
                        i2 = i5;
                    }
                } else if (i6 != 2) {
                    if (i6 == 3) {
                        if (iB4 != 3) {
                        }
                        i2 = i5 + 1;
                    } else if (i6 == 4 && (iB4 == 3 || iB4 == 8 || iB4 == 11)) {
                        i2 = i5 + 1;
                    } else {
                        i2 = i5;
                    }
                } else if (iB4 == 8 || iB4 == 11) {
                    i2 = i5 + 1;
                } else {
                    i2 = i5;
                }
            } else {
                i2 = 0;
            }
        } else {
            i2 = 0;
        }
        return new a(i4, i3, i2);
    }
}
