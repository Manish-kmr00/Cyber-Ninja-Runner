package com.moloco.sdk.xenoss.sdkdevkit.android.core;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f7178a = LazyKt.lazy(a.f7179a);
    public static final String b = "";

    public static final class a extends Lambda implements Function0<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f7179a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final c invoke() {
            return new c();
        }
    }

    public static final UserAgentService a() {
        return b();
    }

    public static final c b() {
        return (c) f7178a.getValue();
    }
}
