package com.chartboost.sdk.impl;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0006\u001a\u00020\u00028VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005¨\u0006\r"}, d2 = {"Lcom/chartboost/sdk/impl/y8;", "Lcom/chartboost/sdk/impl/x8;", "Lcom/chartboost/sdk/impl/z8;", "a", "Lkotlin/Lazy;", "()Lcom/chartboost/sdk/impl/z8;", "rendererActivityBridge", "Lcom/chartboost/sdk/impl/w0;", "androidComponent", "Lcom/chartboost/sdk/impl/ea;", "trackerComponent", "<init>", "(Lcom/chartboost/sdk/impl/w0;Lcom/chartboost/sdk/impl/ea;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class y8 implements x8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Lazy rendererActivityBridge;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/a9;", "a", "()Lcom/chartboost/sdk/impl/a9;"}, k = 3, mv = {1, 8, 0})
    public static final class a extends Lambda implements Function0<a9> {
        public final /* synthetic */ w0 b;
        public final /* synthetic */ ea c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(w0 w0Var, ea eaVar) {
            super(0);
            this.b = w0Var;
            this.c = eaVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a9 invoke() {
            return new a9(new t5(this.b.getContext()), this.c.a());
        }
    }

    public y8(w0 androidComponent, ea trackerComponent) {
        Intrinsics.checkNotNullParameter(androidComponent, "androidComponent");
        Intrinsics.checkNotNullParameter(trackerComponent, "trackerComponent");
        this.rendererActivityBridge = LazyKt.lazy(new a(androidComponent, trackerComponent));
    }

    @Override // com.chartboost.sdk.impl.x8
    public z8 a() {
        return (z8) this.rendererActivityBridge.getValue();
    }
}
