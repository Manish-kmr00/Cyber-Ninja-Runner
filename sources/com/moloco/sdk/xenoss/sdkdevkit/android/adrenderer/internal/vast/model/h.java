package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f6894a = 0;

    public static final class a extends h {
        public static final int c = 8;
        public final List<e> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(List<e> companions) {
            super(null);
            Intrinsics.checkNotNullParameter(companions, "companions");
            this.b = companions;
        }

        public final List<e> a() {
            return this.b;
        }
    }

    public static final class b extends h {
        public static final int c = 8;
        public final p b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(p linear) {
            super(null);
            Intrinsics.checkNotNullParameter(linear, "linear");
            this.b = linear;
        }

        public final p a() {
            return this.b;
        }
    }

    public /* synthetic */ h(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public h() {
    }
}
