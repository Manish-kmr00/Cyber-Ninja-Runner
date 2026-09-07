package com.ogury.ad.internal;

import android.graphics.Rect;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final /* synthetic */ class u6 extends FunctionReferenceImpl implements Function1<h, Unit> {
    public u6(Object obj) {
        super(1, obj, v6.class, "onMouseUp", "onMouseUp(Lcom/ogury/ad/viewer/AdLayout;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(h hVar) {
        h p0 = hVar;
        Intrinsics.checkNotNullParameter(p0, "p0");
        v6 v6Var = (v6) this.receiver;
        v6Var.f7422a.getClass();
        Rect adLayoutRect = z9.a(p0);
        k8 k8Var = v6Var.b;
        k8Var.getClass();
        Intrinsics.checkNotNullParameter(adLayoutRect, "adLayoutRect");
        k8Var.c = new Rect(adLayoutRect);
        return Unit.INSTANCE;
    }
}
