package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class n22 {
    @JvmStatic
    public static final ws a(Context context, int i) {
        ij srVar;
        ij srVar2;
        Intrinsics.checkNotNullParameter(context, "context");
        int i2 = iw1.l;
        cu1 cu1VarA = iw1.a.a().a(context);
        oj.a aVar = oj.c;
        oj bannerSizeCalculationType = null;
        String strM = cu1VarA != null ? cu1VarA.m() : null;
        aVar.getClass();
        for (oj ojVar : oj.values()) {
            if (Intrinsics.areEqual(ojVar.a(), strM)) {
                bannerSizeCalculationType = ojVar;
                break;
            }
        }
        if (bannerSizeCalculationType == null) {
            bannerSizeCalculationType = oj.d;
        }
        gf1 gf1Var = gf1.d;
        Intrinsics.checkNotNullParameter(bannerSizeCalculationType, "bannerSizeCalculationType");
        int iOrdinal = bannerSizeCalculationType.ordinal();
        if (iOrdinal == 0) {
            srVar = new sr();
        } else if (iOrdinal == 1) {
            srVar = new kn1();
        } else if (iOrdinal == 2) {
            srVar = new it1();
        } else if (iOrdinal == 3) {
            srVar = new jt1();
        } else {
            if (iOrdinal != 4) {
                throw new NoWhenBranchMatchedException();
            }
            srVar = new cz0();
        }
        int iA = srVar.a(context, i, gf1Var);
        zy1.a aVar2 = zy1.a.e;
        ob0 ob0Var = new ob0(i, iA, aVar2);
        gf1 gf1Var2 = gf1.c;
        Intrinsics.checkNotNullParameter(bannerSizeCalculationType, "bannerSizeCalculationType");
        int iOrdinal2 = bannerSizeCalculationType.ordinal();
        if (iOrdinal2 == 0) {
            srVar2 = new sr();
        } else if (iOrdinal2 == 1) {
            srVar2 = new kn1();
        } else if (iOrdinal2 == 2) {
            srVar2 = new it1();
        } else if (iOrdinal2 == 3) {
            srVar2 = new jt1();
        } else {
            if (iOrdinal2 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            srVar2 = new cz0();
        }
        ob0 ob0Var2 = new ob0(i, srVar2.a(context, i, gf1Var2), aVar2);
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext);
        return new ws(new lf1(applicationContext, ob0Var, ob0Var2));
    }
}
