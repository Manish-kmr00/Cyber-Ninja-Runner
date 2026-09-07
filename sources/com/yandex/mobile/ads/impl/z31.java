package com.yandex.mobile.ads.impl;

import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;

/* JADX INFO: loaded from: classes13.dex */
final class z31 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10786a;
    private boolean b;
    private boolean c;
    public byte[] d;
    public int e;

    public z31(int i) {
        this.f10786a = i;
        byte[] bArr = new byte[Sdk.SDKError.Reason.MRAID_JS_WRITE_FAILED_VALUE];
        this.d = bArr;
        bArr[2] = 1;
    }

    public final void b() {
        this.b = false;
        this.c = false;
    }

    public final void a(byte[] bArr, int i, int i2) {
        if (this.b) {
            int i3 = i2 - i;
            byte[] bArr2 = this.d;
            int length = bArr2.length;
            int i4 = this.e + i3;
            if (length < i4) {
                this.d = Arrays.copyOf(bArr2, i4 * 2);
            }
            System.arraycopy(bArr, i, this.d, this.e, i3);
            this.e += i3;
        }
    }

    public final void b(int i) {
        if (!this.b) {
            boolean z = i == this.f10786a;
            this.b = z;
            if (z) {
                this.e = 3;
                this.c = false;
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    public final boolean a(int i) {
        if (!this.b) {
            return false;
        }
        this.e -= i;
        this.b = false;
        this.c = true;
        return true;
    }

    public final boolean a() {
        return this.c;
    }
}
