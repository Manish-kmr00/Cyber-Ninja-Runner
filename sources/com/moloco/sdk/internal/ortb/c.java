package com.moloco.sdk.internal.ortb;

import com.moloco.sdk.internal.q;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes12.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f6111a = LazyKt.lazy(a.f6112a);

    public static final class a extends Lambda implements Function0<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6112a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b invoke() {
            return new b(q.a());
        }
    }

    public static final com.moloco.sdk.internal.ortb.a a() {
        return b();
    }

    public static final com.moloco.sdk.internal.ortb.a b() {
        return (com.moloco.sdk.internal.ortb.a) f6111a.getValue();
    }
}
