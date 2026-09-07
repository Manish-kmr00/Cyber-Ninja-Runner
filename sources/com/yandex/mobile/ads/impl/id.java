package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class id {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9202a;
    private final le b;
    private final kp1 c;

    public final void a(hp1.b reportType, Map<String, ? extends Object> reportData, String str, t4 t4Var) {
        Intrinsics.checkNotNullParameter(reportType, "reportType");
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        int i = iw1.l;
        iw1 iw1VarA = iw1.a.a();
        cu1 cu1VarA = iw1VarA.a(this.f9202a);
        if (iw1VarA.g()) {
            if (cu1VarA == null || cu1VarA.k()) {
                this.c.getClass();
                je jeVarA = kp1.a(reportType, reportData, str, t4Var);
                if (jeVarA != null) {
                    this.b.a(jeVarA);
                }
            }
        }
    }

    public /* synthetic */ id(Context context) {
        this(context, jd.a(), new kp1());
    }

    public id(Context context, le reporter, kp1 mapper) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        this.f9202a = context;
        this.b = reporter;
        this.c = mapper;
    }
}
