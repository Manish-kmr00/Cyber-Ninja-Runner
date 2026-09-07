package com.inmobi.media;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.inmobi.media.f1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3363f1 extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3377g1 f3307a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3363f1(C3377g1 c3377g1) {
        super(1);
        this.f3307a = c3377g1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        T8 response = (T8) obj;
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.b()) {
            L4 l4 = this.f3307a.f3321a.f3041a.d;
            if (l4 != null) {
                String str = E5.f3056a;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
                ((M4) l4).b(str, "asyncPing Failed");
            }
        } else {
            L4 l5 = this.f3307a.f3321a.f3041a.d;
            if (l5 != null) {
                String str2 = E5.f3056a;
                Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
                ((M4) l5).a(str2, "asyncPing Successful");
            }
        }
        return Unit.INSTANCE;
    }
}
