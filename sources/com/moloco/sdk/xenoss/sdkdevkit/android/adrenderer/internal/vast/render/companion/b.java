package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6945a = new a();
        public static final int b = 0;

        public a() {
            super(null);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.b$b, reason: collision with other inner class name */
    public static final class C0653b extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0653b f6946a = new C0653b();
        public static final int b = 0;

        public C0653b() {
            super(null);
        }
    }

    public static final class c extends b {
        public static final int b = 8;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c f6947a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c error) {
            super(null);
            Intrinsics.checkNotNullParameter(error, "error");
            this.f6947a = error;
        }

        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c a() {
            return this.f6947a;
        }

        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c b() {
            return this.f6947a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && Intrinsics.areEqual(this.f6947a, ((c) obj).f6947a);
        }

        public int hashCode() {
            return this.f6947a.hashCode();
        }

        public String toString() {
            return "Error(error=" + this.f6947a + ')';
        }

        public final c a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c error) {
            Intrinsics.checkNotNullParameter(error, "error");
            return new c(error);
        }

        public static /* synthetic */ c a(c cVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c cVar2, int i, Object obj) {
            if ((i & 1) != 0) {
                cVar2 = cVar.f6947a;
            }
            return cVar.a(cVar2);
        }
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public b() {
    }
}
