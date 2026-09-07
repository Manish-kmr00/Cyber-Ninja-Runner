package com.yandex.mobile.ads.impl;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.common.base.Ascii;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public final class q72 extends ny1 {
    private final wf1 m = new wf1();
    private final boolean n;
    private final int o;
    private final int p;
    private final String q;
    private final float r;
    private final int s;

    public q72(List<byte[]> list) {
        if (list.size() == 1 && (list.get(0).length == 48 || list.get(0).length == 53)) {
            byte[] bArr = list.get(0);
            this.o = bArr[24];
            this.p = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
            this.q = "Serif".equals(x82.a(bArr, 43, bArr.length - 43)) ? "serif" : "sans-serif";
            int i = bArr[25] * Ascii.DC4;
            this.s = i;
            boolean z = (bArr[0] & 32) != 0;
            this.n = z;
            if (z) {
                this.r = x82.a(((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / i);
                return;
            } else {
                this.r = 0.85f;
                return;
            }
        }
        this.o = 0;
        this.p = -1;
        this.q = "sans-serif";
        this.n = false;
        this.r = 0.85f;
        this.s = -1;
    }

    private static void a(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            int i6 = i5 | 33;
            boolean z = (i & 1) != 0;
            boolean z2 = (i & 2) != 0;
            if (z) {
                if (z2) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i3, i4, i6);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i3, i4, i6);
                }
            } else if (z2) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i3, i4, i6);
            }
            boolean z3 = (i & 4) != 0;
            if (z3) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i3, i4, i6);
            }
            if (z3 || z || z2) {
                return;
            }
            spannableStringBuilder.setSpan(new StyleSpan(0), i3, i4, i6);
        }
    }

    @Override // com.yandex.mobile.ads.impl.ny1
    protected final g32 a(byte[] bArr, int i, boolean z) throws i32 {
        String strA;
        char cF;
        int i2;
        int i3;
        this.m.a(i, bArr);
        wf1 wf1Var = this.m;
        int i4 = 2;
        if (wf1Var.a() >= 2) {
            int iZ = wf1Var.z();
            if (iZ == 0) {
                strA = "";
            } else if (wf1Var.a() >= 2 && ((cF = wf1Var.f()) == 65279 || cF == 65534)) {
                strA = wf1Var.a(iZ, ko.e);
            } else {
                strA = wf1Var.a(iZ, ko.c);
            }
            if (strA.isEmpty()) {
                return r72.c;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strA);
            a(spannableStringBuilder, this.o, 0, 0, spannableStringBuilder.length(), 16711680);
            int i5 = this.p;
            int length = spannableStringBuilder.length();
            int i6 = 8;
            int i7 = 0;
            if (i5 != -1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan((i5 >>> 8) | ((i5 & 255) << 24)), 0, length, 16711713);
            }
            String str = this.q;
            int length2 = spannableStringBuilder.length();
            if (str != "sans-serif") {
                spannableStringBuilder.setSpan(new TypefaceSpan(str), 0, length2, 16711713);
            }
            float fMax = this.r;
            while (this.m.a() >= i6) {
                int iD = this.m.d();
                int iH = this.m.h();
                int iH2 = this.m.h();
                if (iH2 == 1937013100) {
                    if (this.m.a() >= i4) {
                        int iZ2 = this.m.z();
                        int i8 = i7;
                        while (i8 < iZ2) {
                            wf1 wf1Var2 = this.m;
                            if (wf1Var2.a() >= 12) {
                                int iZ3 = wf1Var2.z();
                                int iZ4 = wf1Var2.z();
                                wf1Var2.f(i4);
                                int iT = wf1Var2.t();
                                wf1Var2.f(1);
                                int iH3 = wf1Var2.h();
                                if (iZ4 > spannableStringBuilder.length()) {
                                    at0.d("Tx3gDecoder", "Truncating styl end (" + iZ4 + ") to cueText.length() (" + spannableStringBuilder.length() + ").");
                                    iZ4 = spannableStringBuilder.length();
                                }
                                int i9 = iZ4;
                                if (iZ3 >= i9) {
                                    at0.d("Tx3gDecoder", "Ignoring styl with start (" + iZ3 + ") >= end (" + i9 + ").");
                                    i3 = i8;
                                    i2 = iZ2;
                                } else {
                                    i2 = iZ2;
                                    i3 = i8;
                                    a(spannableStringBuilder, iT, this.o, iZ3, i9, 0);
                                    if (iH3 != this.p) {
                                        spannableStringBuilder.setSpan(new ForegroundColorSpan(((iH3 & 255) << 24) | (iH3 >>> 8)), iZ3, i9, 33);
                                    }
                                }
                                i8 = i3 + 1;
                                iZ2 = i2;
                                i4 = 2;
                            } else {
                                throw new i32("Unexpected subtitle format.");
                            }
                        }
                    } else {
                        throw new i32("Unexpected subtitle format.");
                    }
                } else if (iH2 == 1952608120 && this.n) {
                    i4 = 2;
                    if (this.m.a() >= 2) {
                        float fZ = this.m.z() / this.s;
                        int i10 = x82.f10629a;
                        fMax = Math.max(0.0f, Math.min(fZ, 0.95f));
                    } else {
                        throw new i32("Unexpected subtitle format.");
                    }
                } else {
                    i4 = 2;
                }
                this.m.e(iD + iH);
                i6 = 8;
                i7 = 0;
            }
            return new r72(new ev.a().a(spannableStringBuilder).a(0, fMax).a(0).a());
        }
        throw new i32("Unexpected subtitle format.");
    }
}
