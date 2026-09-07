package com.yandex.mobile.ads.impl;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class k92 {
    public static final void a(j92 j92Var, hp1 report) {
        String strA;
        Set<Long> setEmptySet;
        Intrinsics.checkNotNullParameter(j92Var, "<this>");
        Intrinsics.checkNotNullParameter(report, "report");
        try {
            f fVarA = report.a();
            if (fVarA == null || (strA = fVarA.a()) == null) {
                strA = "";
            }
            f fVarA2 = report.a();
            if (fVarA2 == null || (setEmptySet = fVarA2.b()) == null) {
                setEmptySet = SetsKt.emptySet();
            }
            j92Var.setExperiments(strA);
            j92Var.setTriggeredTestIds(setEmptySet);
            String str = "reportAbExperiments, experiments = " + strA + ", triggeredTestIds = " + setEmptySet;
            op0.a(new Object[0]);
        } catch (Throwable th) {
            String str2 = "Couldn't parse varioqub data: " + th;
            op0.b(new Object[0]);
        }
    }
}
