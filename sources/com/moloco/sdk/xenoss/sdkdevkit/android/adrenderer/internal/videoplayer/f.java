package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer;

import android.view.View;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.j0;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: loaded from: classes12.dex */
public final class f {
    public static final Flow<Boolean> b(j0 j0Var, View view) {
        Flow<Boolean> flowA;
        return (view == null || (flowA = j0Var.a(view)) == null) ? FlowKt.flowOf(Boolean.FALSE) : flowA;
    }
}
