package com.inmobi.media;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.inmobi.media.ua, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3586ua extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ba f3445a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3586ua(Ba ba) {
        super(1);
        this.f3445a = ba;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        Ba ba = this.f3445a;
        L4 l4 = ba.i;
        if (l4 != null) {
            String TAG = Ba.O0;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "onRenderProcessGone");
        }
        ba.getListener().a(ba, zBooleanValue);
        return Unit.INSTANCE;
    }
}
