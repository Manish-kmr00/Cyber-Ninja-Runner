package com.inmobi.media;

import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
public final class ed extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fd f3306a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ed(fd fdVar) {
        super(0);
        this.f3306a = fdVar;
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Runnable invoke() {
        final fd fdVar = this.f3306a;
        return new Runnable() { // from class: com.inmobi.media.ed$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ed.a(fdVar);
            }
        };
    }

    public static final void a(fd this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Objects.toString(this$0);
        this$0.c.post((RunnableC3304ad) this$0.k.getValue());
    }
}
