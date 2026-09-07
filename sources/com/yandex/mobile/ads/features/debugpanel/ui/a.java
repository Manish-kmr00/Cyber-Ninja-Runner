package com.yandex.mobile.ads.features.debugpanel.ui;

import com.yandex.mobile.ads.impl.bp0;
import com.yandex.mobile.ads.impl.zx;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class a extends FunctionReferenceImpl implements Function1<zx, Unit> {
    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(zx zxVar) {
        zx p0 = zxVar;
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((bp0) this.receiver).a(p0);
        return Unit.INSTANCE;
    }

    a(bp0 bp0Var) {
        super(1, bp0Var, bp0.class, "onAction", "onAction(Lcom/yandex/mobile/ads/features/debugpanel/ui/model/DebugPanelUiAction;)V", 0);
    }
}
