package io.appmetrica.analytics.impl;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.qd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4390qd extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C4263lb f11736a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4390qd(C4263lb c4263lb) {
        super(1);
        this.f11736a = c4263lb;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        C4066dd c4066dd = (C4066dd) ((Map.Entry) obj).getValue();
        return c4066dd.b.parse(this.f11736a);
    }
}
