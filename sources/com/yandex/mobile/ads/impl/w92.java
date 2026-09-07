package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class w92 implements wp1<List<? extends eb2>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p2 f10546a;
    private final wp1<dt> b;
    private final eo0 c;

    public w92(Context context, uu1 sdkEnvironmentModule, p2 adBreak, wp1<dt> instreamAdBreakRequestListener, eo0 instreamVideoAdBreakCreator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(adBreak, "adBreak");
        Intrinsics.checkNotNullParameter(instreamAdBreakRequestListener, "instreamAdBreakRequestListener");
        Intrinsics.checkNotNullParameter(instreamVideoAdBreakCreator, "instreamVideoAdBreakCreator");
        this.f10546a = adBreak;
        this.b = instreamAdBreakRequestListener;
        this.c = instreamVideoAdBreakCreator;
    }

    @Override // com.yandex.mobile.ads.impl.wp1
    public final void a(kb2 error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.b.a(error);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yandex.mobile.ads.impl.wp1
    public final void a(List<? extends eb2> list) {
        List<? extends eb2> result = list;
        Intrinsics.checkNotNullParameter(result, "result");
        dt dtVarA = this.c.a(this.f10546a, result);
        if (dtVarA != null) {
            this.b.a(dtVarA);
            return;
        }
        Intrinsics.checkNotNullParameter("Failed to parse ad break", "description");
        this.b.a(new kb2(1, "Failed to parse ad break"));
    }
}
