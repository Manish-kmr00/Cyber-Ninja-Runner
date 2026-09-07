package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.h4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C4157h4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11579a;
    public final String b;
    public final Integer c;
    public final String d;
    public final CounterConfigurationReporterType e;

    public C4157h4(String str, String str2, Integer num, String str3, CounterConfigurationReporterType counterConfigurationReporterType) {
        this.f11579a = str;
        this.b = str2;
        this.c = num;
        this.d = str3;
        this.e = counterConfigurationReporterType;
    }

    public static C4157h4 a(C4007b4 c4007b4) {
        return new C4157h4(c4007b4.b.getApiKey(), c4007b4.f11474a.f11723a.getAsString("PROCESS_CFG_PACKAGE_NAME"), c4007b4.f11474a.f11723a.getAsInteger("PROCESS_CFG_PROCESS_ID"), c4007b4.f11474a.f11723a.getAsString("PROCESS_CFG_PROCESS_SESSION_ID"), c4007b4.b.getReporterType());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C4157h4.class != obj.getClass()) {
            return false;
        }
        C4157h4 c4157h4 = (C4157h4) obj;
        String str = this.f11579a;
        if (str == null ? c4157h4.f11579a != null : !str.equals(c4157h4.f11579a)) {
            return false;
        }
        if (!this.b.equals(c4157h4.b)) {
            return false;
        }
        Integer num = this.c;
        if (num == null ? c4157h4.c != null : !num.equals(c4157h4.c)) {
            return false;
        }
        String str2 = this.d;
        if (str2 == null ? c4157h4.d == null : str2.equals(c4157h4.d)) {
            return this.e == c4157h4.e;
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f11579a;
        int iHashCode = (this.b.hashCode() + ((str != null ? str.hashCode() : 0) * 31)) * 31;
        Integer num = this.c;
        int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 31;
        String str2 = this.d;
        return this.e.hashCode() + ((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        return "ClientDescription{mApiKey='" + this.f11579a + "', mPackageName='" + this.b + "', mProcessID=" + this.c + ", mProcessSessionID='" + this.d + "', mReporterType=" + this.e + AbstractJsonLexerKt.END_OBJ;
    }
}
