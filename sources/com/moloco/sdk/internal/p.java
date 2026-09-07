package com.moloco.sdk.internal;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f6155a = LazyKt.lazy(a.f6156a);
    public static final Lazy b = LazyKt.lazy(b.f6158a);

    public static final class a extends Lambda implements Function0<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6156a = new a();

        /* JADX INFO: renamed from: com.moloco.sdk.internal.p$a$a, reason: collision with other inner class name */
        public static final class C0538a extends Lambda implements Function0<Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0538a f6157a = new C0538a();

            public C0538a() {
                super(0);
            }

            public final void a() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i invoke() {
            return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i(C0538a.f6157a, null, null, 6, null);
        }
    }

    public static final class b extends Lambda implements Function0<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f6158a = new b();

        public static final class a extends Lambda implements Function0<Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f6159a = new a();

            public a() {
                super(0);
            }

            public final void a() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.internal.p$b$b, reason: collision with other inner class name */
        public static final class C0539b extends Lambda implements Function0<Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0539b f6160a = new C0539b();

            public C0539b() {
                super(0);
            }

            public final void a() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        public static final class c extends Lambda implements Function0<Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f6161a = new c();

            public c() {
                super(0);
            }

            public final void a() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i invoke() {
            return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i(a.f6159a, C0539b.f6160a, c.f6161a);
        }
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i a(boolean z) {
        if (z) {
            return null;
        }
        return a();
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i b() {
        return (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i) b.getValue();
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i a() {
        return (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i) f6155a.getValue();
    }
}
