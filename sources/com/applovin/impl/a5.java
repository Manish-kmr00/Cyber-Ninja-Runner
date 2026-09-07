package com.applovin.impl;

import com.applovin.mediation.MaxError;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes6.dex */
public class a5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b5 f322a;
    private final String b;
    private final String c;
    private final String d;
    private final MaxError e;
    private final long f;
    private final long g;
    private final boolean h;

    public interface a {
        void a(a5 a5Var);
    }

    private a5(b5 b5Var, com.applovin.impl.mediation.h hVar, String str, MaxError maxError, long j, long j2) {
        this(b5Var, str, maxError, j, j2, hVar != null ? hVar.i() : null, hVar != null ? hVar.b() : null, false);
    }

    public static a5 a(b5 b5Var, com.applovin.impl.mediation.h hVar, String str, long j, long j2) {
        if (b5Var == null) {
            throw new IllegalArgumentException("No spec specified");
        }
        if (hVar != null) {
            return new a5(b5Var, hVar, str, null, j, j2);
        }
        throw new IllegalArgumentException("No adapterWrapper specified");
    }

    public long b() {
        return this.g;
    }

    public MaxError c() {
        return this.e;
    }

    public String d() {
        return this.b;
    }

    public String e() {
        return this.d;
    }

    public b5 f() {
        return this.f322a;
    }

    public boolean g() {
        return this.h;
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder("SignalCollectionResult{mSignalProviderSpec=").append(this.f322a).append(", mSdkVersion='").append(this.b).append("', mAdapterVersion='").append(this.c).append("', mSignalDataLength='");
        String str = this.d;
        StringBuilder sbAppend2 = sbAppend.append(str != null ? str.length() : 0).append("', mErrorMessage=");
        MaxError maxError = this.e;
        return sbAppend2.append(maxError != null ? maxError.getMessage() : "").append(AbstractJsonLexerKt.END_OBJ).toString();
    }

    private a5(b5 b5Var, String str, MaxError maxError, long j, long j2, String str2, String str3, boolean z) {
        this.f322a = b5Var;
        this.d = str;
        this.e = maxError;
        this.f = j;
        this.g = j2;
        this.b = str2;
        this.c = str3;
        this.h = z;
    }

    public static a5 a(b5 b5Var, MaxError maxError) {
        return a(b5Var, (com.applovin.impl.mediation.h) null, maxError, -1L, -1L);
    }

    public static a5 a(b5 b5Var, com.applovin.impl.mediation.h hVar, MaxError maxError, long j, long j2) {
        if (b5Var != null) {
            return new a5(b5Var, hVar, null, maxError, j, j2);
        }
        throw new IllegalArgumentException("No spec specified");
    }

    public static a5 a(a5 a5Var) {
        return new a5(a5Var.f(), a5Var.e(), a5Var.c(), a5Var.f, a5Var.g, a5Var.d(), a5Var.a(), true);
    }

    public String a() {
        return this.c;
    }
}
