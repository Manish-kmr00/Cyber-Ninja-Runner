package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes13.dex */
public class z80 extends bk<String> {
    private final ha0 w;

    @Override // com.yandex.mobile.ads.impl.bk
    protected final zj<String> a(String url, String query) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(query, "query");
        Context contextL = l();
        o3 o3VarF = f();
        ha0 ha0Var = this.w;
        lx1.f9575a.getClass();
        return new w80(contextL, o3VarF, url, query, this, this, ha0Var, lx1.a.a(contextL), new ng0(), new d8());
    }

    public /* synthetic */ z80(Context context, o3 o3Var, g5 g5Var, ha0 ha0Var) {
        this(context, o3Var, g5Var, ha0Var, pu.a());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected z80(Context context, o3 adConfiguration, g5 adLoadingPhasesManager, ha0 ha0Var, CoroutineScope coroutineScope) {
        super(context, adLoadingPhasesManager, adConfiguration, coroutineScope);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        this.w = ha0Var;
    }
}
