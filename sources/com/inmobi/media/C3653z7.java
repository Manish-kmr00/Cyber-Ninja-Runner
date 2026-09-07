package com.inmobi.media;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.inmobi.media.z7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3653z7 extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3495a;
    public final /* synthetic */ A7 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3653z7(A7 a7, String str) {
        super(0);
        this.f3495a = str;
        this.b = a7;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        C3417j c3417jB = AbstractC3415ib.a().b(this.f3495a);
        Z3 z3A = null;
        if (c3417jB == null) {
            return null;
        }
        A7 a7 = this.b;
        try {
            String str = c3417jB.c;
            if (str == null) {
                return null;
            }
            z3A = A7.a(a7, str);
            Unit unit = Unit.INSTANCE;
            return z3A;
        } catch (Exception e) {
            Intrinsics.checkNotNullExpressionValue(a7.x, "access$getTAG$p(...)");
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
            Unit unit2 = Unit.INSTANCE;
            return z3A;
        }
    }
}
