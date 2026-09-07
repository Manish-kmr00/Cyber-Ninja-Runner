package io.appmetrica.analytics.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class Hd extends FunctionReferenceImpl implements Function1 {
    public Hd(Id id) {
        super(1, id, Id.class, "markCrashCompletedAndDeleteCompletedCrashes", "markCrashCompletedAndDeleteCompletedCrashes(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Id id = (Id) this.receiver;
        id.f11195a.markCrashCompleted((String) obj);
        id.f11195a.deleteCompletedCrashes();
        return Unit.INSTANCE;
    }
}
