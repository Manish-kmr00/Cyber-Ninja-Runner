package com.inmobi.media;

import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
public final class N4 extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ArrayList f3144a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N4(ArrayList arrayList) {
        super(1);
        this.f3144a = arrayList;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        C3423j5 it = (C3423j5) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        this.f3144a.add(new C3483n5(it));
        return Unit.INSTANCE;
    }
}
