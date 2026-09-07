package com.inmobi.media;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.inmobi.media.t5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3567t5 extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3609w5 f3433a;
    public final /* synthetic */ short b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3567t5(C3609w5 c3609w5, short s) {
        super(0);
        this.f3433a = c3609w5;
        this.b = s;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        AbstractC3498o6.a((byte) 2, "InMobiInterstitial", "RenderProcess of the WebView has crashed. Please create another adUnit");
        L4 l4 = this.f3433a.j;
        if (l4 != null) {
            String strE = C3609w5.e();
            Intrinsics.checkNotNullExpressionValue(strE, "access$getTAG$cp(...)");
            ((M4) l4).b(strE, "RenderProcess of the WebView has crashed. Please create another adUnit");
        }
        this.f3433a.a(true, this.b);
        this.f3433a.P = null;
        return Unit.INSTANCE;
    }
}
