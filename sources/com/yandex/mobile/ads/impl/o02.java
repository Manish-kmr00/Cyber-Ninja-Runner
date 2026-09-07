package com.yandex.mobile.ads.impl;

import java.io.IOException;

/* JADX INFO: loaded from: classes9.dex */
final class o02 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wf1 f9768a = new wf1(8);
    private int b;

    private long a(tz tzVar) throws IOException {
        int i = 0;
        tzVar.b(this.f9768a.c(), 0, 1, false);
        int i2 = this.f9768a.c()[0] & 255;
        if (i2 == 0) {
            return Long.MIN_VALUE;
        }
        int i3 = 128;
        int i4 = 0;
        while ((i2 & i3) == 0) {
            i3 >>= 1;
            i4++;
        }
        int i5 = i2 & (~i3);
        tzVar.b(this.f9768a.c(), 1, i4, false);
        while (i < i4) {
            i++;
            i5 = (this.f9768a.c()[i] & 255) + (i5 << 8);
        }
        this.b = i4 + 1 + this.b;
        return i5;
    }

    public final boolean b(tz tzVar) throws IOException {
        long jB = tzVar.b();
        long j = 1024;
        if (jB != -1 && jB <= 1024) {
            j = jB;
        }
        int i = (int) j;
        tzVar.b(this.f9768a.c(), 0, 4, false);
        long jV = this.f9768a.v();
        this.b = 4;
        while (jV != 440786851) {
            int i2 = this.b + 1;
            this.b = i2;
            if (i2 == i) {
                return false;
            }
            tzVar.b(this.f9768a.c(), 0, 1, false);
            jV = ((jV << 8) & (-256)) | ((long) (this.f9768a.c()[0] & 255));
        }
        long jA = a(tzVar);
        long j2 = this.b;
        if (jA == Long.MIN_VALUE) {
            return false;
        }
        if (jB != -1 && j2 + jA >= jB) {
            return false;
        }
        while (true) {
            long j3 = this.b;
            long j4 = j2 + jA;
            if (j3 >= j4) {
                return j3 == j4;
            }
            if (a(tzVar) == Long.MIN_VALUE) {
                return false;
            }
            long jA2 = a(tzVar);
            if (jA2 < 0 || jA2 > 2147483647L) {
                return false;
            }
            if (jA2 != 0) {
                int i3 = (int) jA2;
                tzVar.a(false, i3);
                this.b += i3;
            }
        }
    }
}
