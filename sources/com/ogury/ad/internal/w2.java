package com.ogury.ad.internal;

import android.content.Context;
import com.ogury.ad.common.OguryMediation;
import com.ogury.core.internal.IntegrationLogger;
import java.util.UUID;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class w2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f7428a;
    public final o b;
    public final y c;
    public final OguryMediation d;
    public x e;
    public s f;
    public Function1<? super g8, Unit> g;

    public w2(Context context, d adConfig, o adType, OguryMediation oguryMediation) {
        y adsSourceFactory = new y(context, adConfig, adType);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        Intrinsics.checkNotNullParameter(adType, "adType");
        Intrinsics.checkNotNullParameter(adsSourceFactory, "adsSourceFactory");
        this.f7428a = adConfig;
        this.b = adType;
        this.c = adsSourceFactory;
        this.d = oguryMediation;
    }

    public final void a(String str) {
        x xVar = this.e;
        if (xVar != null && xVar.r) {
            xVar.b();
        }
        x xVar2 = this.e;
        if (xVar2 != null && xVar2.q) {
            xVar2.g();
        }
        y yVar = this.c;
        x xVar3 = this.e;
        boolean z = xVar3 != null && xVar3.o;
        OguryMediation oguryMediation = this.d;
        Context context = yVar.f7444a;
        yVar.d.getClass();
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        x xVar4 = new x(context, string, oguryMediation, yVar.b, yVar.c, z);
        xVar4.t = this.f;
        xVar4.v = this.g;
        this.e = xVar4;
        if (str != null) {
            xVar4.a(str);
        } else {
            xVar4.a((String) null);
        }
    }

    public final void a(z5 z5Var) {
        IntegrationLogger.d("[Ads][" + this.b.b() + "] Registering to ad listener");
        if (z5Var == null) {
            IntegrationLogger.d("[Ads][" + this.b.b() + "] Ad listener is null");
        }
        this.f = z5Var;
        x xVar = this.e;
        if (xVar != null) {
            xVar.a(z5Var);
        }
    }
}
