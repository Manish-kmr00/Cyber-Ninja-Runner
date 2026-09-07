package com.yandex.mobile.ads.impl;

import io.appmetrica.analytics.AppMetricaLibraryAdapter;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class fd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final fd f8884a = new fd();
    private static final String b = "ads_sdk";

    public static void a(je report) {
        Object objM7904constructorimpl;
        Intrinsics.checkNotNullParameter(report, "report");
        try {
            Result.Companion companion = Result.INSTANCE;
            AppMetricaLibraryAdapter.reportEvent(b, report.a(), report.b());
            objM7904constructorimpl = Result.m7904constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7907exceptionOrNullimpl(objM7904constructorimpl) != null) {
            op0.b(new Object[0]);
        }
    }

    private fd() {
    }
}
