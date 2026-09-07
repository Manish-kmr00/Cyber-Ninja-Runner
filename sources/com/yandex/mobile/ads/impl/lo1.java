package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class lo1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<String> f9549a;
    private final v9 b;
    private final ko1 c;

    public final void a(q91 reportParameterManager) {
        Intrinsics.checkNotNullParameter(reportParameterManager, "reportParameterManager");
        this.c.a(reportParameterManager);
    }

    public /* synthetic */ lo1(Context context, o8 o8Var, o3 o3Var, s9 s9Var, List list) {
        this(context, o8Var, o3Var, s9Var, list, new v9(context, o3Var), new ko1(context, o3Var, o8Var, s9Var));
    }

    public lo1(Context context, o8<?> adResponse, o3 adConfiguration, s9 adStructureType, List<String> list, v9 adTracker, ko1 renderReporter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adStructureType, "adStructureType");
        Intrinsics.checkNotNullParameter(adTracker, "adTracker");
        Intrinsics.checkNotNullParameter(renderReporter, "renderReporter");
        this.f9549a = list;
        this.b = adTracker;
        this.c = renderReporter;
    }

    public final void a() {
        List<String> list = this.f9549a;
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                this.b.a(it.next(), s62.i);
            }
        }
        this.c.a();
    }
}
