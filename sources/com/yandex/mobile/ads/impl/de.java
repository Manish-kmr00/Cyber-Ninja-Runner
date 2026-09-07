package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes13.dex */
public final class de {
    public static void a(Context context, lp1 reporter) {
        ce ceVar;
        CoroutineDispatcher coroutineContext = Dispatchers.getIO();
        CoroutineScope coroutineScope = CoroutineScopeKt.CoroutineScope(coroutineContext);
        ae anrChecker = new ae(coroutineContext, new Handler(Looper.getMainLooper()));
        be anrReporter = new be(reporter);
        r42 threadUtils = new r42();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(anrChecker, "anrChecker");
        Intrinsics.checkNotNullParameter(anrReporter, "anrReporter");
        Intrinsics.checkNotNullParameter(threadUtils, "threadUtils");
        int i = iw1.l;
        cu1 cu1VarA = iw1.a.a().a(context);
        if (cu1VarA == null || !cu1VarA.h()) {
            return;
        }
        Long lI = cu1VarA.i();
        long jLongValue = lI != null ? lI.longValue() : 1000L;
        Long lJ = cu1VarA.j();
        long jLongValue2 = lJ != null ? lJ.longValue() : 3500L;
        Set<b60> setQ = cu1VarA.q();
        if (setQ == null) {
            setQ = SetsKt.emptySet();
        }
        Set<b60> crashStackTraceExclusionRules = setQ;
        int i2 = ce.k;
        Intrinsics.checkNotNullParameter(crashStackTraceExclusionRules, "crashStackTraceExclusionRules");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(anrChecker, "anrChecker");
        Intrinsics.checkNotNullParameter(anrReporter, "anrReporter");
        Intrinsics.checkNotNullParameter(threadUtils, "threadUtils");
        ce ceVar2 = ce.j;
        if (ceVar2 == null) {
            synchronized (ce.i) {
                ceVar = ce.j;
                if (ceVar == null) {
                    ceVar = new ce(jLongValue, jLongValue2, crashStackTraceExclusionRules, coroutineScope, anrChecker, anrReporter, threadUtils, 0);
                    ce.j = ceVar;
                }
            }
            ceVar2 = ceVar;
        }
        ceVar2.c();
    }

    private de() {
    }
}
