package com.yandex.mobile.ads.impl;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes12.dex */
final class xd1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final yd1 f10645a = new yd1();
    private final wf1 b = new wf1(0, new byte[65025]);
    private int c = -1;
    private int d;
    private boolean e;

    xd1() {
    }

    public final void c() {
        yd1 yd1Var = this.f10645a;
        yd1Var.f10727a = 0;
        yd1Var.b = 0L;
        yd1Var.c = 0;
        yd1Var.d = 0;
        yd1Var.e = 0;
        this.b.c(0);
        this.c = -1;
        this.e = false;
    }

    public final yd1 a() {
        return this.f10645a;
    }

    public final boolean a(tz tzVar) throws IOException {
        int i;
        int i2;
        int i3;
        if (this.e) {
            this.e = false;
            this.b.c(0);
        }
        while (true) {
            if (this.e) {
                return true;
            }
            if (this.c < 0) {
                if (this.f10645a.a(tzVar, -1L) && this.f10645a.a(tzVar, true)) {
                    yd1 yd1Var = this.f10645a;
                    int i4 = yd1Var.d;
                    if ((yd1Var.f10727a & 1) == 1 && this.b.e() == 0) {
                        this.d = 0;
                        int i5 = 0;
                        do {
                            int i6 = this.d;
                            yd1 yd1Var2 = this.f10645a;
                            if (i6 >= yd1Var2.c) {
                                break;
                            }
                            int[] iArr = yd1Var2.f;
                            this.d = i6 + 1;
                            i3 = iArr[i6];
                            i5 += i3;
                        } while (i3 == 255);
                        i4 += i5;
                        i2 = this.d;
                    } else {
                        i2 = 0;
                    }
                    try {
                        tzVar.a(i4);
                        this.c = i2;
                    } catch (EOFException unused) {
                    }
                }
                return false;
            }
            int i7 = this.c;
            this.d = 0;
            int i8 = 0;
            do {
                int i9 = this.d;
                int i10 = i7 + i9;
                yd1 yd1Var3 = this.f10645a;
                if (i10 >= yd1Var3.c) {
                    break;
                }
                int[] iArr2 = yd1Var3.f;
                this.d = i9 + 1;
                i = iArr2[i10];
                i8 += i;
            } while (i == 255);
            int i11 = this.c + this.d;
            if (i8 > 0) {
                wf1 wf1Var = this.b;
                wf1Var.a(wf1Var.e() + i8);
                try {
                    tzVar.a(this.b.c(), this.b.e(), i8, false);
                    wf1 wf1Var2 = this.b;
                    wf1Var2.d(wf1Var2.e() + i8);
                    this.e = this.f10645a.f[i11 + (-1)] != 255;
                } catch (EOFException unused2) {
                    return false;
                }
            }
            if (i11 == this.f10645a.c) {
                i11 = -1;
            }
            this.c = i11;
        }
    }

    public final wf1 b() {
        return this.b;
    }

    public final void d() {
        if (this.b.c().length == 65025) {
            return;
        }
        wf1 wf1Var = this.b;
        wf1Var.a(this.b.e(), Arrays.copyOf(wf1Var.c(), Math.max(65025, this.b.e())));
    }
}
