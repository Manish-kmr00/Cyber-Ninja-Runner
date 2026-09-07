package com.inmobi.media;

import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes6.dex */
public final class O6 extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int[] f3155a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public O6(int[] iArr) {
        super(1);
        this.f3155a = iArr;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        N1 event = (N1) obj;
        Intrinsics.checkNotNullParameter(event, "event");
        return Boolean.valueOf(ArraysKt.contains(this.f3155a, event.f3141a));
    }
}
