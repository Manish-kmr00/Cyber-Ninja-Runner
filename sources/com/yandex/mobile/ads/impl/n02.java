package com.yandex.mobile.ads.impl;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;

/* JADX INFO: loaded from: classes11.dex */
final class n02 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f9685a = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    public static boolean a(tz tzVar) throws IOException {
        return a(tzVar, true, false);
    }

    private static boolean a(x70 x70Var, boolean z, boolean z2) throws IOException {
        boolean z3;
        boolean z4;
        boolean z5;
        int i;
        boolean z6;
        long jB = x70Var.b();
        long j = -1;
        int i2 = (jB > (-1L) ? 1 : (jB == (-1L) ? 0 : -1));
        long j2 = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        if (i2 != 0 && jB <= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            j2 = jB;
        }
        int i3 = (int) j2;
        wf1 wf1Var = new wf1(64);
        boolean z7 = false;
        int i4 = 0;
        boolean z8 = false;
        while (true) {
            if (i4 < i3) {
                wf1Var.c(8);
                if (x70Var.b(wf1Var.c(), z7 ? 1 : 0, 8, true)) {
                    long jV = wf1Var.v();
                    int iH = wf1Var.h();
                    if (jV == 1) {
                        x70Var.a(wf1Var.c(), 8, 8);
                        wf1Var.d(16);
                        i = 16;
                        jV = wf1Var.p();
                    } else {
                        if (jV == 0) {
                            long jB2 = x70Var.b();
                            if (jB2 != j) {
                                jV = (jB2 - x70Var.d()) + ((long) 8);
                            }
                        }
                        i = 8;
                    }
                    long j3 = i;
                    if (jV < j3) {
                        return z7;
                    }
                    i4 += i;
                    if (iH == 1836019574) {
                        i3 += (int) jV;
                        if (i2 != 0 && i3 > jB) {
                            i3 = (int) jB;
                        }
                    } else if (iH == 1836019558 || iH == 1836475768) {
                        z3 = z7 ? 1 : 0;
                        z4 = true;
                        z5 = true;
                    } else {
                        int i5 = i2;
                        if ((((long) i4) + jV) - j3 >= i3) {
                            z3 = false;
                            z4 = true;
                            z5 = z3 ? 1 : 0;
                        } else {
                            int i6 = (int) (jV - j3);
                            i4 += i6;
                            if (iH != 1718909296) {
                                z6 = false;
                                if (i6 != 0) {
                                    z8 = z8;
                                    x70Var.b(i6);
                                    z8 = z8;
                                }
                            } else {
                                if (i6 < 8) {
                                    return false;
                                }
                                wf1Var.c(i6);
                                x70Var.a(wf1Var.c(), 0, i6);
                                int i7 = i6 / 4;
                                for (int i8 = 0; i8 < i7; i8++) {
                                    if (i8 == 1) {
                                        wf1Var.f(4);
                                    } else {
                                        int iH2 = wf1Var.h();
                                        if ((iH2 >>> 8) != 3368816 && (iH2 != 1751476579 || !z2)) {
                                            int[] iArr = f9685a;
                                            int i9 = 0;
                                            while (true) {
                                                if (i9 >= 29) {
                                                    continue;
                                                } else if (iArr[i9] != iH2) {
                                                    i9++;
                                                }
                                            }
                                        }
                                        z8 = true;
                                        break;
                                    }
                                }
                                z6 = false;
                                z8 = z8;
                                if (!z8) {
                                    return false;
                                }
                            }
                            z8 = z8;
                            z7 = z6;
                            i2 = i5;
                        }
                    }
                    j = -1;
                    z8 = z8;
                }
                return (z8 || z != z5) ? z3 : z4;
            }
            z3 = z7 ? 1 : 0;
            z4 = true;
            z5 = z3 ? 1 : 0;
            if (z8) {
            }
        }
    }

    public static boolean a(x70 x70Var, boolean z) throws IOException {
        return a(x70Var, false, z);
    }
}
