package com.yandex.mobile.ads.impl;

import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: loaded from: classes11.dex */
public final class yh0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f10735a;
    public static final int b;

    static {
        Duration.Companion companion = Duration.INSTANCE;
        DurationUnit durationUnit = DurationUnit.SECONDS;
        long duration = DurationKt.toDuration(10, durationUnit);
        DurationUnit durationUnit2 = DurationUnit.MILLISECONDS;
        f10735a = Duration.m9276toIntimpl(duration, durationUnit2);
        b = Duration.m9276toIntimpl(DurationKt.toDuration(30, durationUnit), durationUnit2);
        Duration.m9276toIntimpl(DurationKt.toDuration(3, durationUnit), durationUnit2);
    }

    public static int a() {
        return f10735a;
    }
}
