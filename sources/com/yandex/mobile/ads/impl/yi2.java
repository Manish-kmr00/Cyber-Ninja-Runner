package com.yandex.mobile.ads.impl;

import android.util.Base64;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public final class yi2 {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String[] f10740a;

        public a(String[] strArr) {
            this.f10740a = strArr;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f10741a;

        public b(boolean z) {
            this.f10741a = z;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f10742a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final byte[] g;

        public c(int i, int i2, int i3, int i4, int i5, int i6, byte[] bArr) {
            this.f10742a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
            this.g = bArr;
        }
    }

    public static a a(wf1 wf1Var, boolean z, boolean z2) throws ag1 {
        if (z) {
            a(3, wf1Var, false);
        }
        wf1Var.a((int) wf1Var.n(), ko.c);
        long jN = wf1Var.n();
        String[] strArr = new String[(int) jN];
        for (int i = 0; i < jN; i++) {
            strArr[i] = wf1Var.a((int) wf1Var.n(), ko.c);
        }
        if (z2 && (wf1Var.t() & 1) == 0) {
            throw ag1.a("framing bit expected to be set", (Exception) null);
        }
        return new a(strArr);
    }

    public static c a(wf1 wf1Var) throws ag1 {
        a(1, wf1Var, false);
        int iK = wf1Var.k();
        if (iK >= 0) {
            int iT = wf1Var.t();
            int iK2 = wf1Var.k();
            if (iK2 >= 0) {
                int iK3 = wf1Var.k();
                int i = iK3 <= 0 ? -1 : iK3;
                int iK4 = wf1Var.k();
                int i2 = iK4 <= 0 ? -1 : iK4;
                wf1Var.k();
                int iT2 = wf1Var.t();
                int iPow = (int) Math.pow(2.0d, iT2 & 15);
                int iPow2 = (int) Math.pow(2.0d, (iT2 & 240) >> 4);
                wf1Var.t();
                return new c(iT, iK2, i, i2, iPow, iPow2, Arrays.copyOf(wf1Var.c(), wf1Var.e()));
            }
            throw new IllegalStateException(oe.a("Top bit not zero: ", iK2));
        }
        throw new IllegalStateException(oe.a("Top bit not zero: ", iK));
    }

    public static boolean a(int i, wf1 wf1Var, boolean z) throws ag1 {
        if (wf1Var.a() < 7) {
            if (z) {
                return false;
            }
            throw ag1.a("too short header: " + wf1Var.a(), (Exception) null);
        }
        if (wf1Var.t() != i) {
            if (z) {
                return false;
            }
            throw ag1.a("expected header type " + Integer.toHexString(i), (Exception) null);
        }
        if (wf1Var.t() == 118 && wf1Var.t() == 111 && wf1Var.t() == 114 && wf1Var.t() == 98 && wf1Var.t() == 105 && wf1Var.t() == 115) {
            return true;
        }
        if (z) {
            return false;
        }
        throw ag1.a("expected characters 'vorbis'", (Exception) null);
    }

    public static g01 a(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            int i2 = x82.f10629a;
            String[] strArrSplit = str.split("=", 2);
            if (strArrSplit.length != 2) {
                at0.d("VorbisUtil", "Failed to parse Vorbis comment: ".concat(str));
            } else if (strArrSplit[0].equals("METADATA_BLOCK_PICTURE")) {
                try {
                    wf1 wf1Var = new wf1(Base64.decode(strArrSplit[1], 0));
                    int iH = wf1Var.h();
                    String strA = wf1Var.a(wf1Var.h(), ko.f9439a);
                    String strA2 = wf1Var.a(wf1Var.h(), ko.c);
                    int iH2 = wf1Var.h();
                    int iH3 = wf1Var.h();
                    int iH4 = wf1Var.h();
                    int iH5 = wf1Var.h();
                    int iH6 = wf1Var.h();
                    byte[] bArr = new byte[iH6];
                    wf1Var.a(bArr, 0, iH6);
                    arrayList.add(new fh1(iH, strA, strA2, iH2, iH3, iH4, iH5, bArr));
                } catch (RuntimeException e) {
                    at0.b("VorbisUtil", "Failed to parse vorbis picture", e);
                }
            } else {
                arrayList.add(new wi2(strArrSplit[0], strArrSplit[1]));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new g01(arrayList);
    }
}
