package com.yandex.mobile.ads.impl;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
public final class ep0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8821a = "Yandex Mobile Adsintegrated incorrectly";

    public final String a(e11.a.b result) {
        Intrinsics.checkNotNullParameter(result, "result");
        return CollectionsKt.joinToString$default(result.a(), "\n", this.f8821a + "\n", null, 0, null, a.b, 28, null);
    }

    static final class a extends Lambda implements Function1<xo0, CharSequence> {
        public static final a b = new a();

        a() {
            super(1);
        }

        public static String a(xo0 cause) {
            Intrinsics.checkNotNullParameter(cause, "cause");
            return "\t·\t" + cause.getMessage();
        }

        @Override // kotlin.jvm.functions.Function1
        public final /* bridge */ /* synthetic */ CharSequence invoke(xo0 xo0Var) {
            return a(xo0Var);
        }
    }
}
