package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f6887a = 0;

    public static final class a extends b {
        public static final int c = 8;
        public final o b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(o inline) {
            super(null);
            Intrinsics.checkNotNullParameter(inline, "inline");
            this.b = inline;
        }

        public final o a() {
            return this.b;
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.b$b, reason: collision with other inner class name */
    public static final class C0645b extends b {
        public static final int c = 8;
        public final b0 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0645b(b0 wrapper) {
            super(null);
            Intrinsics.checkNotNullParameter(wrapper, "wrapper");
            this.b = wrapper;
        }

        public final b0 a() {
            return this.b;
        }
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public b() {
    }
}
