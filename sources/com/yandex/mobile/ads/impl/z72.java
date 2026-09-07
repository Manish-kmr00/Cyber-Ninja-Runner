package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class z72 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f10797a;
    private static final Object b = new Object();
    public static final /* synthetic */ int c = 0;

    public static void a(Context context, lp1 reporter) {
        r42 threadUtils = new r42();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(threadUtils, "threadUtils");
        if (f10797a) {
            return;
        }
        synchronized (b) {
            if (!f10797a) {
                int i = iw1.l;
                cu1 cu1VarA = iw1.a.a().a(context);
                if (cu1VarA != null && cu1VarA.r()) {
                    y72 handler = new y72(reporter, Thread.getDefaultUncaughtExceptionHandler(), cu1VarA);
                    Intrinsics.checkNotNullParameter(handler, "handler");
                    Thread.setDefaultUncaughtExceptionHandler(handler);
                    f10797a = true;
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private z72() {
    }
}
