package com.moloco.sdk.internal;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f6449a = LazyKt.lazy(a.f6450a);
    public static final String b = "[ERROR_CODE]";
    public static final String c = "[HAPPENED_AT_TS]";

    public static final class a extends Lambda implements Function0<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6450a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final x invoke() {
            return new x(com.moloco.sdk.service_locator.a.i.f6483a.c());
        }
    }

    public static final w a() {
        return b();
    }

    public static final x b() {
        return (x) f6449a.getValue();
    }
}
