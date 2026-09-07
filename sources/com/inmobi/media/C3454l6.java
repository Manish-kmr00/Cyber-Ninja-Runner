package com.inmobi.media;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.inmobi.media.l6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3454l6 extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3468m6 f3368a;
    public final /* synthetic */ Context b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3454l6(C3468m6 c3468m6, Context context) {
        super(1);
        this.f3368a = c3468m6;
        this.b = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        C3368f6 it = (C3368f6) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        C3468m6 c3468m6 = this.f3368a;
        c3468m6.a(this.b, c3468m6.f3374a, it);
        return Unit.INSTANCE;
    }
}
