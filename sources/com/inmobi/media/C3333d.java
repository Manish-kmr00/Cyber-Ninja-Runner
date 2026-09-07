package com.inmobi.media;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.inmobi.media.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes7.dex */
public final class C3333d extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Lambda f3288a;
    public final /* synthetic */ InterfaceC3291a0 b;
    public final /* synthetic */ D9 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public C3333d(Function0 function0, InterfaceC3291a0 interfaceC3291a0, D9 d9) {
        super(0);
        this.f3288a = (Lambda) function0;
        this.b = interfaceC3291a0;
        this.c = d9;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        try {
            if (((Boolean) this.f3288a.invoke()).booleanValue()) {
                this.c.a(this.b.a());
            } else {
                this.c.onError(new Exception("Capture Aborted: Should Capture not satisfied"));
            }
        } catch (Exception e) {
            this.c.onError(e);
        }
        return Unit.INSTANCE;
    }
}
