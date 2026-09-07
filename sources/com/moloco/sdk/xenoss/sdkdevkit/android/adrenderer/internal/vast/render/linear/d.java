package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f7087a = 0;

    public static final class a extends d {
        public static final a b = new a();
        public static final int c = 0;

        public a() {
            super(null);
        }
    }

    public static final class b extends d {
        public static final b b = new b();
        public static final int c = 0;

        public b() {
            super(null);
        }
    }

    public static final class c extends d {
        public static final c b = new c();
        public static final int c = 0;

        public c() {
            super(null);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.d$d, reason: collision with other inner class name */
    public static final class C0683d extends d {
        public static final int c = 0;
        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0683d(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l error) {
            super(null);
            Intrinsics.checkNotNullParameter(error, "error");
            this.b = error;
        }

        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l a() {
            return this.b;
        }

        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof C0683d) && this.b == ((C0683d) obj).b;
        }

        public int hashCode() {
            return this.b.hashCode();
        }

        public String toString() {
            return "Error(error=" + this.b + ')';
        }

        public final C0683d a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l error) {
            Intrinsics.checkNotNullParameter(error, "error");
            return new C0683d(error);
        }

        public static /* synthetic */ C0683d a(C0683d c0683d, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l lVar, int i, Object obj) {
            if ((i & 1) != 0) {
                lVar = c0683d.b;
            }
            return c0683d.a(lVar);
        }
    }

    public static final class e extends d {
        public static final e b = new e();
        public static final int c = 0;

        public e() {
            super(null);
        }
    }

    public /* synthetic */ d(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public d() {
    }
}
