package com.fyber.inneractive.sdk.network.timeouts;

import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes7.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1932a = 0;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public int f = 0;
    public boolean g = false;

    public final int a() {
        int iMax;
        int i = this.c;
        int i2 = this.d;
        if (i2 <= 0) {
            IAlog.f("%s Unable resolve retries because of invalid ILAT: %d, will set retries to 0", IAlog.a(com.fyber.inneractive.sdk.network.timeouts.content.a.class), Integer.valueOf(i2));
            iMax = 0;
        } else {
            int i3 = i / i2;
            int i4 = i3 - 1;
            if (i4 > 3) {
                i4 = i3 - 2;
            }
            iMax = Math.max(i4, 0);
        }
        int i5 = this.c;
        int i6 = this.d;
        int i7 = this.e;
        int i8 = this.f;
        int iMax2 = Math.max(0, i5);
        int iMax3 = Math.max(0, i6);
        int iMax4 = Math.max(0, iMax);
        int iMax5 = Math.max(0, (iMax2 - (Math.max(0, i7) * iMax4)) - (Math.max(0, i8) * iMax4));
        int iMax6 = Math.max(0, iMax3);
        if (iMax4 > 0) {
            iMax5 %= iMax6;
        }
        int iMax7 = Math.max(iMax5, 0);
        if (iMax7 == 0 && iMax > 2) {
            iMax--;
            iMax7 = this.d;
        }
        int i9 = iMax + 1;
        int iMax8 = Math.max(0, iMax7);
        if (i9 > 0) {
            iMax8 /= i9;
        }
        this.b = iMax8;
        return Math.max(0, a(this.c, this.d, iMax8, 0) - 1);
    }

    public static int a(int i, int i2, int i3, int i4) {
        int iMax = Math.max(0, i);
        if (i2 <= 0) {
            i2 = iMax;
        }
        int iMax2 = Math.max(0, i3);
        int iMax3 = Math.max(0, i4);
        int i5 = iMax3 + 1;
        int i6 = iMax - ((iMax2 * iMax3) + i2);
        if (i6 < 0) {
            return Math.max(iMax3, 0);
        }
        if (i6 == 0) {
            return Math.max(i5, 0);
        }
        return a(i6, i2, iMax2, i5);
    }
}
