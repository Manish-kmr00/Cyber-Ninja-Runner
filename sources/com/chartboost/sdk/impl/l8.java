package com.chartboost.sdk.impl;

import com.chartboost.sdk.privacy.model.COPPA;
import com.chartboost.sdk.privacy.model.DataUseConsent;
import com.chartboost.sdk.privacy.model.GDPR;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class l8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r8 f1069a;
    public final j5 b;
    public final w8 c;
    public final k5 d;
    public final l5 e;
    public final y9 f;
    public final i5 g;
    public final String h;
    public o9.b i;

    public m8 g() {
        return new m8(Integer.valueOf(a()), f(), Integer.valueOf(c()), b(), e(), d(), this.f.a(), this.g.b(), this.g.a());
    }

    public l8(r8 r8Var, j5 j5Var, w8 w8Var, k5 k5Var, l5 l5Var, y9 y9Var, i5 i5Var, String str) {
        this.f1069a = r8Var;
        this.b = j5Var;
        this.c = w8Var;
        this.d = k5Var;
        this.e = l5Var;
        this.f = y9Var;
        this.g = i5Var;
        this.h = str;
    }

    public JSONObject e() {
        List<DataUseConsent> listF = f();
        k5 k5Var = this.d;
        if (k5Var == null || listF == null) {
            return null;
        }
        return k5Var.a(listF);
    }

    public List<DataUseConsent> f() {
        o9.b bVar;
        l5 l5Var = this.e;
        if (l5Var == null || (bVar = this.i) == null) {
            return null;
        }
        return l5Var.a(bVar);
    }

    public String d() {
        DataUseConsent dataUseConsentA = this.b.a("gdpr");
        if (dataUseConsentA == null) {
            return "-1";
        }
        return (String) dataUseConsentA.getConsent();
    }

    public int a() {
        return d().equals(GDPR.GDPR_CONSENT.BEHAVIORAL.getValue()) ? 1 : 0;
    }

    public int c() {
        return !d().equals("-1") ? 1 : 0;
    }

    public Integer b() {
        COPPA coppa = (COPPA) a("coppa");
        if (coppa == null) {
            return null;
        }
        if (coppa.getConsent().booleanValue()) {
            return 1;
        }
        return 0;
    }

    public DataUseConsent a(String str) {
        j5 j5Var = this.b;
        if (j5Var != null) {
            return j5Var.a(str);
        }
        return null;
    }

    public void b(String str) {
        w8 w8Var = this.c;
        if (w8Var != null) {
            w8Var.a(str);
        }
    }

    public void a(DataUseConsent dataUseConsent) {
        r8 r8Var = this.f1069a;
        if (r8Var != null) {
            r8Var.a(dataUseConsent);
        }
    }

    public void a(o9.b bVar) {
        this.i = bVar;
    }
}
