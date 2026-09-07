package io.appmetrica.analytics.impl;

import android.location.Location;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.internal.CounterConfiguration;
import io.appmetrica.analytics.networktasks.internal.ArgumentsMerger;
import java.util.Map;
import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes13.dex */
public final class F4 implements ArgumentsMerger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11134a;
    public final Boolean b;
    public final Location c;
    public final Boolean d;
    public final Integer e;
    public final Integer f;
    public final Integer g;
    public final Boolean h;
    public final Boolean i;
    public final Map<String, String> j;
    public final Integer k;
    public final Boolean l;
    public final Boolean m;
    public final Boolean n;

    public F4(String str, Boolean bool, Location location, Boolean bool2, Integer num, Integer num2, Integer num3, Boolean bool3, Boolean bool4, Map map, Integer num4, Boolean bool5, Boolean bool6, Boolean bool7) {
        this.f11134a = str;
        this.b = bool;
        this.c = location;
        this.d = bool2;
        this.e = num;
        this.f = num2;
        this.g = num3;
        this.h = bool3;
        this.i = bool4;
        this.j = map;
        this.k = num4;
        this.l = bool5;
        this.m = bool6;
        this.n = bool7;
    }

    public final boolean a(F4 f4) {
        return equals(f4);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ArgumentsMerger
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final F4 mergeFrom(F4 f4) {
        return new F4((String) WrapUtils.getOrDefaultNullable(this.f11134a, f4.f11134a), (Boolean) WrapUtils.getOrDefaultNullable(this.b, f4.b), (Location) WrapUtils.getOrDefaultNullable(this.c, f4.c), (Boolean) WrapUtils.getOrDefaultNullable(this.d, f4.d), (Integer) WrapUtils.getOrDefaultNullable(this.e, f4.e), (Integer) WrapUtils.getOrDefaultNullable(this.f, f4.f), (Integer) WrapUtils.getOrDefaultNullable(this.g, f4.g), (Boolean) WrapUtils.getOrDefaultNullable(this.h, f4.h), (Boolean) WrapUtils.getOrDefaultNullable(this.i, f4.i), (Map) WrapUtils.getOrDefaultNullable(this.j, f4.j), (Integer) WrapUtils.getOrDefaultNullable(this.k, f4.k), (Boolean) WrapUtils.getOrDefaultNullable(this.l, f4.l), (Boolean) WrapUtils.getOrDefaultNullable(this.m, f4.m), (Boolean) WrapUtils.getOrDefaultNullable(this.n, f4.n));
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ArgumentsMerger
    public final boolean compareWithOtherArguments(Object obj) {
        return equals((F4) obj);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || F4.class != obj.getClass()) {
            return false;
        }
        F4 f4 = (F4) obj;
        return Objects.equals(this.f11134a, f4.f11134a) && Objects.equals(this.b, f4.b) && Objects.equals(this.c, f4.c) && Objects.equals(this.d, f4.d) && Objects.equals(this.e, f4.e) && Objects.equals(this.f, f4.f) && Objects.equals(this.g, f4.g) && Objects.equals(this.h, f4.h) && Objects.equals(this.i, f4.i) && Objects.equals(this.j, f4.j) && Objects.equals(this.k, f4.k) && Objects.equals(this.l, f4.l) && Objects.equals(this.m, f4.m) && Objects.equals(this.n, f4.n);
    }

    public final int hashCode() {
        return Objects.hashCode(this.n) + ((Objects.hashCode(this.m) + ((Objects.hashCode(this.l) + ((Objects.hashCode(this.k) + ((Objects.hashCode(this.j) + ((Objects.hashCode(this.i) + ((Objects.hashCode(this.h) + ((Objects.hashCode(this.g) + ((Objects.hashCode(this.f) + ((Objects.hashCode(this.e) + ((Objects.hashCode(this.d) + ((Objects.hashCode(this.c) + ((Objects.hashCode(this.b) + (Objects.hashCode(this.f11134a) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "ReporterArguments{apiKey='" + this.f11134a + "', locationTracking=" + this.b + ", manualLocation=" + this.c + ", firstActivationAsUpdate=" + this.d + ", sessionTimeout=" + this.e + ", maxReportsCount=" + this.f + ", dispatchPeriod=" + this.g + ", logEnabled=" + this.h + ", dataSendingEnabled=" + this.i + ", clidsFromClient=" + this.j + ", maxReportsInDbCount=" + this.k + ", nativeCrashesEnabled=" + this.l + ", revenueAutoTrackingEnabled=" + this.m + ", advIdentifiersTrackingEnabled=" + this.n + AbstractJsonLexerKt.END_OBJ;
    }

    public F4(CounterConfiguration counterConfiguration, Map<String, String> map) {
        this(counterConfiguration.getApiKey(), counterConfiguration.isLocationTrackingEnabled(), counterConfiguration.getManualLocation(), counterConfiguration.isFirstActivationAsUpdate(), counterConfiguration.getSessionTimeout(), counterConfiguration.getMaxReportsCount(), counterConfiguration.getDispatchPeriod(), counterConfiguration.isLogEnabled(), counterConfiguration.getDataSendingEnabled(), map, counterConfiguration.getMaxReportsInDbCount(), counterConfiguration.getReportNativeCrashesEnabled(), counterConfiguration.isRevenueAutoTrackingEnabled(), counterConfiguration.isAdvIdentifiersTrackingEnabled());
    }

    public F4() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }
}
