package com.inmobi.media;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
public final class dd extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fd f3297a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dd(fd fdVar) {
        super(0);
        this.f3297a = fdVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        fd fdVar = this.f3297a;
        return new RunnableC3304ad(fdVar, fdVar.i);
    }
}
