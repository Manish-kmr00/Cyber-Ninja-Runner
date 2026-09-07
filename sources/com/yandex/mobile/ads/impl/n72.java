package com.yandex.mobile.ads.impl;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import java.util.ArrayDeque;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
final class n72 {
    public static void a(SpannableStringBuilder spannableStringBuilder, int i, int i2, o72 o72Var, l72 l72Var, Map map, int i3) {
        l72 l72Var2;
        if (o72Var.k() != -1) {
            spannableStringBuilder.setSpan(new StyleSpan(o72Var.k()), i, i2, 33);
        }
        if (o72Var.q()) {
            spannableStringBuilder.setSpan(new StrikethroughSpan(), i, i2, 33);
        }
        if (o72Var.r()) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i, i2, 33);
        }
        if (o72Var.p()) {
            h12.a(spannableStringBuilder, new ForegroundColorSpan(o72Var.b()), i, i2);
        }
        if (o72Var.o()) {
            h12.a(spannableStringBuilder, new BackgroundColorSpan(o72Var.a()), i, i2);
        }
        if (o72Var.c() != null) {
            h12.a(spannableStringBuilder, new TypefaceSpan(o72Var.c()), i, i2);
        }
        if (o72Var.n() != null) {
            k42 k42VarN = o72Var.n();
            k42VarN.getClass();
            int i4 = k42VarN.f9378a;
            h12.a(spannableStringBuilder, new l42(), i, i2);
        }
        int i5 = o72Var.i();
        if (i5 == 2) {
            while (true) {
                l72Var2 = null;
                if (l72Var == null) {
                    l72Var = null;
                    break;
                }
                o72 o72VarA = a(l72Var.f, l72Var.c(), map);
                if (o72VarA != null && o72VarA.i() == 1) {
                    break;
                } else {
                    l72Var = l72Var.j;
                }
            }
            if (l72Var != null) {
                ArrayDeque arrayDeque = new ArrayDeque();
                arrayDeque.push(l72Var);
                while (!arrayDeque.isEmpty()) {
                    l72 l72Var3 = (l72) arrayDeque.pop();
                    o72 o72VarA2 = a(l72Var3.f, l72Var3.c(), map);
                    if (o72VarA2 != null && o72VarA2.i() == 3) {
                        l72Var2 = l72Var3;
                        break;
                    }
                    for (int iA = l72Var3.a() - 1; iA >= 0; iA--) {
                        arrayDeque.push(l72Var3.a(iA));
                    }
                }
                if (l72Var2 != null) {
                    if (l72Var2.a() != 1 || l72Var2.a(0).b == null) {
                        at0.c("TtmlRenderUtil", "Skipping rubyText node without exactly one text child.");
                    } else {
                        String str = l72Var2.a(0).b;
                        int i6 = x82.f10629a;
                        o72 o72VarA3 = a(l72Var2.f, l72Var2.c(), map);
                        if (o72VarA3 == null || o72VarA3.h() == -1) {
                            a(l72Var.f, l72Var.c(), map);
                        }
                        spannableStringBuilder.setSpan(new ss1(), i, i2, 33);
                    }
                }
            }
        } else if (i5 == 3 || i5 == 4) {
            spannableStringBuilder.setSpan(new w00(), i, i2, 33);
        }
        if (o72Var.m()) {
            h12.a(spannableStringBuilder, new vf0(), i, i2);
        }
        int iE = o72Var.e();
        if (iE == 1) {
            h12.a(spannableStringBuilder, new AbsoluteSizeSpan((int) o72Var.d(), true), i, i2);
        } else if (iE == 2) {
            h12.a(spannableStringBuilder, new RelativeSizeSpan(o72Var.d()), i, i2);
        } else {
            if (iE != 3) {
                return;
            }
            h12.a(spannableStringBuilder, new RelativeSizeSpan(o72Var.d() / 100.0f), i, i2);
        }
    }

    public static o72 a(o72 o72Var, String[] strArr, Map<String, o72> map) {
        int i = 0;
        if (o72Var == null) {
            if (strArr == null) {
                return null;
            }
            if (strArr.length == 1) {
                return map.get(strArr[0]);
            }
            if (strArr.length > 1) {
                o72 o72Var2 = new o72();
                int length = strArr.length;
                while (i < length) {
                    o72Var2.a(map.get(strArr[i]));
                    i++;
                }
                return o72Var2;
            }
        } else {
            if (strArr != null && strArr.length == 1) {
                return o72Var.a(map.get(strArr[0]));
            }
            if (strArr != null && strArr.length > 1) {
                int length2 = strArr.length;
                while (i < length2) {
                    o72Var.a(map.get(strArr[i]));
                    i++;
                }
            }
        }
        return o72Var;
    }
}
