package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f6911a = 0;

    public static final class a extends y {
        public static final int c = 0;
        public final j b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(j resource) {
            super(null);
            Intrinsics.checkNotNullParameter(resource, "resource");
            this.b = resource;
        }

        public final j a() {
            return this.b;
        }
    }

    public static final class b extends y {
        public static final int c = 0;
        public final k b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(k resource) {
            super(null);
            Intrinsics.checkNotNullParameter(resource, "resource");
            this.b = resource;
        }

        public final k a() {
            return this.b;
        }
    }

    public static final class c extends y {
        public static final int c = 0;
        public final t b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(t resource) {
            super(null);
            Intrinsics.checkNotNullParameter(resource, "resource");
            this.b = resource;
        }

        public final t a() {
            return this.b;
        }
    }

    public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public y() {
    }
}
