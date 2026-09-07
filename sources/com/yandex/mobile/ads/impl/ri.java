package com.yandex.mobile.ads.impl;

import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ri {
    public static String a(RectF viewRect, uj0 imageValue) {
        ti tiVarA;
        c02 c02VarB;
        float fWidth;
        int iC;
        Intrinsics.checkNotNullParameter(viewRect, "viewRect");
        Intrinsics.checkNotNullParameter(imageValue, "imageValue");
        k02 k02VarE = imageValue.e();
        if (k02VarE == null || (tiVarA = k02VarE.a()) == null || (c02VarB = imageValue.e().b()) == null) {
            return null;
        }
        float fWidth2 = viewRect.width();
        float fHeight = viewRect.height();
        float fG = imageValue.g();
        float fA = imageValue.a();
        float fC = c02VarB.c();
        float fB = c02VarB.b();
        if (fWidth2 == 0.0f || fHeight == 0.0f || fG == 0.0f || fA == 0.0f || fC == 0.0f || fB == 0.0f) {
            return null;
        }
        if (viewRect.width() / viewRect.height() > c02VarB.c() / c02VarB.b()) {
            fWidth = viewRect.height();
            iC = c02VarB.b();
        } else {
            fWidth = viewRect.width();
            iC = c02VarB.c();
        }
        if (fWidth / iC <= 1.0f) {
            if (fWidth2 / fHeight > fC / fB) {
                if (Intrinsics.areEqual(tiVarA.c(), tiVarA.b())) {
                    return tiVarA.c();
                }
                return null;
            }
            if (Intrinsics.areEqual(tiVarA.d(), tiVarA.a())) {
                return tiVarA.d();
            }
            return null;
        }
        if (fWidth2 / fHeight > fG / fA) {
            if (Intrinsics.areEqual(tiVarA.c(), tiVarA.b())) {
                return tiVarA.c();
            }
            return null;
        }
        if (Intrinsics.areEqual(tiVarA.d(), tiVarA.a())) {
            return tiVarA.d();
        }
        return null;
    }
}
