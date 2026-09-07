package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes5.dex */
public final class p52 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f9896a;
    public final String b;
    public final t52.a c;
    public final int d;
    public final byte[] e;

    public p52(boolean z, String str, int i, byte[] bArr, int i2, int i3, byte[] bArr2) {
        hg.a((bArr2 == null) ^ (i == 0));
        this.f9896a = z;
        this.b = str;
        this.d = i;
        this.e = bArr2;
        this.c = new t52.a(a(str), i2, i3, bArr);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static int a(String str) {
        if (str == null) {
            return 1;
        }
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case 3046605:
                if (str.equals("cbc1")) {
                    b = 0;
                }
                break;
            case 3046671:
                if (str.equals("cbcs")) {
                    b = 1;
                }
                break;
            case 3049879:
                if (str.equals("cenc")) {
                    b = 2;
                }
                break;
            case 3049895:
                if (str.equals("cens")) {
                    b = 3;
                }
                break;
        }
        switch (b) {
            case 0:
            case 1:
                return 2;
            default:
                at0.d("TrackEncryptionBox", "Unsupported protection scheme type '" + str + "'. Assuming AES-CTR crypto mode.");
            case 2:
            case 3:
                return 1;
        }
    }
}
