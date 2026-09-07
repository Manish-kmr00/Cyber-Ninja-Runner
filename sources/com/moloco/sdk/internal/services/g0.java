package com.moloco.sdk.internal.services;

import android.content.Context;
import com.moloco.sdk.common_adapter_internal.ScreenData;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class g0 implements f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6387a;

    public g0(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f6387a = context;
    }

    @Override // com.moloco.sdk.internal.services.f0
    public e0 a() {
        ScreenData screenDataInvoke = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.q.a(this.f6387a).invoke();
        float widthDp = screenDataInvoke.getWidthDp();
        return new e0(screenDataInvoke.getWidthPx(), widthDp, screenDataInvoke.getHeightPx(), screenDataInvoke.getHeightDp(), screenDataInvoke.getPxRatio(), screenDataInvoke.getDpi(), this.f6387a.getResources().getDisplayMetrics().xdpi, this.f6387a.getResources().getDisplayMetrics().ydpi);
    }

    @Override // com.moloco.sdk.internal.services.f0
    public h0 b() {
        int i = this.f6387a.getResources().getConfiguration().orientation;
        if (i != 1) {
            return i != 2 ? h0.UNKNOWN : h0.LANDSCAPE;
        }
        return h0.PORTRAIT;
    }

    public final Context c() {
        return this.f6387a;
    }

    @Override // com.moloco.sdk.internal.services.f0
    @Deprecated(message = "Use screenInfo() instead", replaceWith = @ReplaceWith(expression = "screenInfo()", imports = {}))
    public e0 invoke() {
        return a();
    }
}
