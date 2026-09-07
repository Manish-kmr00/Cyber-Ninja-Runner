package com.inmobi.media;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public abstract class Ra {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set f3184a;

    static {
        Intrinsics.checkNotNullExpressionValue("Ra", "getSimpleName(...)");
        Set setNewSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
        Intrinsics.checkNotNullExpressionValue(setNewSetFromMap, "newSetFromMap(...)");
        f3184a = setNewSetFromMap;
    }

    public static void a(Pa pa, long j) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        int iOrdinal = pa.f.ordinal();
        if (iOrdinal == 0) {
            scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) S3.c.getValue();
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) S3.b.getValue();
        }
        scheduledThreadPoolExecutor.schedule(new Sa(pa, Qa.f3176a), j, TimeUnit.MILLISECONDS);
    }
}
