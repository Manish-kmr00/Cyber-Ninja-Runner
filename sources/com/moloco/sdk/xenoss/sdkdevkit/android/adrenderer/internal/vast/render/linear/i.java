package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.r;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UInt;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f7098a = 1000;

    public static final boolean b(Job job) {
        return job == null || job.isCancelled() || job.isCompleted();
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d.a b(int i) {
        return i == 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d.a.C0682a.b : new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d.a.b(i, null);
    }

    public static final g a(Boolean bool, int i, r rVar) {
        if (Intrinsics.areEqual(bool, Boolean.FALSE)) {
            rVar = null;
        } else if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            rVar = new r.b(((long) i) * 1000);
        } else if (bool != null) {
            throw new NoWhenBranchMatchedException();
        }
        return new h(rVar);
    }

    public static final int b(IntRange intRange, int i) {
        return UnsignedKt.doubleToUInt(RangesKt.coerceAtLeast((((double) (RangesKt.coerceAtLeast(intRange.getLast() - intRange.getFirst(), 0) * i)) / 100.0d) / ((double) 1000), 0.0d));
    }

    public static final long b(long j) {
        return j / 1000;
    }

    public static final int a(LongRange longRange) {
        return UInt.m8001constructorimpl((int) RangesKt.coerceAtLeast((longRange.getLast() - longRange.getFirst()) / ((long) 1000), 0L));
    }
}
