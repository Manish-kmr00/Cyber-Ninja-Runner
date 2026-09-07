package io.appmetrica.analytics.impl;

import com.yandex.div.core.DivActionHandler;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.KotlinVersion;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes.dex */
public final class Qg implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        TimePassedChecker timePassedChecker = new TimePassedChecker();
        SystemTimeProvider systemTimeProvider = new SystemTimeProvider();
        Oe oeX = C4486ua.E.x();
        if (timePassedChecker.didTimePassMillis(oeX.f(), TimeUnit.DAYS.toMillis(1L), "[ReportKotlinVersionTask]")) {
            KotlinVersion kotlinVersion = KotlinVersion.CURRENT;
            Map mapMapOf = MapsKt.mapOf(TuplesKt.to("major", Integer.valueOf(kotlinVersion.getMajor())), TuplesKt.to("minor", Integer.valueOf(kotlinVersion.getMinor())), TuplesKt.to(DivActionHandler.DivActionReason.PATCH, Integer.valueOf(kotlinVersion.getPatch())), TuplesKt.to("version", new StringBuilder().append(kotlinVersion.getMajor()).append('.').append(kotlinVersion.getMinor()).append('.').append(kotlinVersion.getPatch()).toString()));
            Fj fj = AbstractC4097ej.f11536a;
            fj.getClass();
            fj.a(new Ej("kotlin_version", mapMapOf));
            oeX.c(systemTimeProvider.currentTimeMillis()).b();
        }
    }
}
