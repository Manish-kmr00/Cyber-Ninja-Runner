package com.moloco.sdk.internal.services.init;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public abstract class j {

    public static final class a extends j {
        public static final int b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.moloco.sdk.internal.services.init.b f6408a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(com.moloco.sdk.internal.services.init.b type) {
            super(null);
            Intrinsics.checkNotNullParameter(type, "type");
            this.f6408a = type;
        }

        public final com.moloco.sdk.internal.services.init.b a() {
            return this.f6408a;
        }
    }

    public static final class b extends j {
        public static final int b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6409a;

        public b(int i) {
            super(null);
            this.f6409a = i;
        }

        public final int a() {
            return this.f6409a;
        }
    }

    public /* synthetic */ j(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public j() {
    }
}
