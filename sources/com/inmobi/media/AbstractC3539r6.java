package com.inmobi.media;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.r6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractC3539r6 {
    public static void a(final C3382g6 dao, final long j, final int i) {
        Intrinsics.checkNotNullParameter(dao, "dao");
        if (AbstractC3554s6.d.getAndSet(true)) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.inmobi.media.r6$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC3539r6.b(dao, j, i);
            }
        };
        ScheduledExecutorService scheduledExecutorService = Ec.f3062a;
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        Ec.f3062a.schedule(runnable, 10000L, TimeUnit.MILLISECONDS);
    }

    public static final void b(C3382g6 dao, long j, int i) {
        Intrinsics.checkNotNullParameter(dao, "$dao");
        dao.getClass();
        for (C3368f6 c3368f6 : D1.a(dao, "id NOT IN (SELECT id FROM ( SELECT id FROM logs_v2 WHERE saveTimestamp > " + j + " ORDER BY saveTimestamp DESC LIMIT " + i + ") AS foo);", null, null, null, null, null, 62)) {
            if (c3368f6 != null) {
                AbstractC3568t6.a(c3368f6.f3312a);
                dao.a(c3368f6);
            }
        }
        AbstractC3554s6.d.set(false);
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0036 */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0041, code lost:
    
        return kotlin.Result.m7904constructorimpl(kotlin.ResultKt.createFailure(r1));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Object a(kotlin.jvm.functions.Function0 r1) {
        /*
            java.lang.String r0 = "run"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L36
            java.util.concurrent.Semaphore r0 = com.inmobi.media.AbstractC3554s6.c     // Catch: java.lang.Throwable -> L10 java.lang.Exception -> L12
            r0.acquire()     // Catch: java.lang.Throwable -> L10 java.lang.Exception -> L12
            r1.invoke()     // Catch: java.lang.Throwable -> L10 java.lang.Exception -> L12
            goto L26
        L10:
            r1 = move-exception
            goto L30
        L12:
            r1 = move-exception
            com.inmobi.media.d5 r0 = com.inmobi.media.C3339d5.f3292a     // Catch: java.lang.Throwable -> L10
            com.inmobi.media.P1 r0 = new com.inmobi.media.P1     // Catch: java.lang.Throwable -> L10
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L10
            java.lang.String r1 = "event"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)     // Catch: java.lang.Throwable -> L10
            com.inmobi.media.M5 r1 = com.inmobi.media.C3339d5.c     // Catch: java.lang.Throwable -> L10
            r1.a(r0)     // Catch: java.lang.Throwable -> L10
            java.util.concurrent.Semaphore r0 = com.inmobi.media.AbstractC3554s6.c     // Catch: java.lang.Throwable -> L36
        L26:
            r0.release()     // Catch: java.lang.Throwable -> L36
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L36
            java.lang.Object r1 = kotlin.Result.m7904constructorimpl(r1)     // Catch: java.lang.Throwable -> L36
            goto L41
        L30:
            java.util.concurrent.Semaphore r0 = com.inmobi.media.AbstractC3554s6.c     // Catch: java.lang.Throwable -> L36
            r0.release()     // Catch: java.lang.Throwable -> L36
            throw r1     // Catch: java.lang.Throwable -> L36
        L36:
            r1 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE
            java.lang.Object r1 = kotlin.ResultKt.createFailure(r1)
            java.lang.Object r1 = kotlin.Result.m7904constructorimpl(r1)
        L41:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.AbstractC3539r6.a(kotlin.jvm.functions.Function0):java.lang.Object");
    }
}
