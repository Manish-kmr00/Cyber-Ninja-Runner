package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yandex.mobile.ads.impl.if, reason: invalid class name */
/* JADX INFO: loaded from: classes2.dex */
public final class Cif {
    private static final String c = "Incorrect AppMetrica Integration. The minimum supported version of AppMetrica SDK is 7.7.2 (inclusive) and the maximum supported version is 8.0.0 (exclusive). Please, check your AppMetrica integration.";
    private static final String d = "Incorrect AppMetrica Version. The minimum supported version of AppMetrica SDK is 7.7.2 (inclusive) and the maximum supported version is 8.0.0 (exclusive). And the current version of AppMetrica SDK is ";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ab2 f9209a;
    private final ue b;

    public /* synthetic */ Cif() {
        this(new ab2(), ve.a());
    }

    public Cif(ab2 versionNameParser, ue appMetricaAdapter) {
        Intrinsics.checkNotNullParameter(versionNameParser, "versionNameParser");
        Intrinsics.checkNotNullParameter(appMetricaAdapter, "appMetricaAdapter");
        this.f9209a = versionNameParser;
        this.b = appMetricaAdapter;
    }

    public final void a() throws xo0 {
        String strA = this.b.a();
        if (strA != null) {
            this.f9209a.getClass();
            za2 za2VarA = ab2.a("7.7.2");
            if (za2VarA == null) {
                return;
            }
            this.f9209a.getClass();
            za2 za2VarA2 = ab2.a("8.0.0");
            if (za2VarA2 == null) {
                return;
            }
            this.f9209a.getClass();
            za2 za2VarA3 = ab2.a(strA);
            if (za2VarA3 == null || za2VarA3.compareTo(za2VarA) < 0 || za2VarA3.compareTo(za2VarA2) >= 0) {
                String strA2 = a(strA);
                throw new xo0(strA2, strA2);
            }
            return;
        }
        String str = c;
        throw new xo0(str, str);
    }

    private static String a(String str) {
        return d + str;
    }
}
