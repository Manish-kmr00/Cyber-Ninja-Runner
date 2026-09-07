package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public class hy0 implements b80 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f9148a;
    private final dx1 b;

    @Override // com.yandex.mobile.ads.impl.b80
    public Map<String, Object> a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        v7 v7VarA = this.f9148a.a();
        if (v7VarA != null) {
            Map<String, String> mapH = v7VarA.h();
            if (mapH != null) {
                linkedHashMap.putAll(mapH);
            }
            String strB = v7VarA.b();
            if (strB != null) {
                linkedHashMap.put("age", strB);
            }
            List<String> listD = v7VarA.d();
            if (listD != null) {
                linkedHashMap.put("context_tags", listD);
            }
            String strE = v7VarA.e();
            if (strE != null) {
                linkedHashMap.put("gender", strE);
            }
            int i = iw1.l;
            Boolean boolF = iw1.a.a().f();
            if (boolF != null) {
                linkedHashMap.put("age_restricted_user", boolF);
            }
            cu1 cu1VarA = iw1.a.a().a(context);
            Boolean boolN0 = cu1VarA != null ? cu1VarA.n0() : null;
            if (boolN0 != null) {
                linkedHashMap.put("user_consent", boolN0);
            }
        }
        lc lcVarA = this.f9148a.e().a();
        boolean zB = this.b.b(context);
        if (lcVarA != null) {
            boolean zB2 = lcVarA.b();
            String strA = lcVarA.a();
            if (!zB && !zB2 && strA != null) {
                linkedHashMap.put("google_aid", strA);
            }
        }
        linkedHashMap.put("gms_available", Boolean.valueOf(this.f9148a.k().c()));
        return linkedHashMap;
    }

    public /* synthetic */ hy0(o3 o3Var) {
        this(o3Var, new dx1());
    }

    public hy0(o3 adConfiguration, dx1 sensitiveModeChecker) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(sensitiveModeChecker, "sensitiveModeChecker");
        this.f9148a = adConfiguration;
        this.b = sensitiveModeChecker;
    }

    @Override // com.yandex.mobile.ads.impl.b80
    public final Map<String, String> a(hz0 mediationNetwork) {
        Intrinsics.checkNotNullParameter(mediationNetwork, "mediationNetwork");
        return mediationNetwork.i();
    }

    protected final o3 a() {
        return this.f9148a;
    }
}
