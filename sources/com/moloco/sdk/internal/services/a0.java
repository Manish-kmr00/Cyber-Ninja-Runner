package com.moloco.sdk.internal.services;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public abstract class a0 {

    public static final class a extends a0 {
        public static final int b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f6299a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String carrier) {
            super(null);
            Intrinsics.checkNotNullParameter(carrier, "carrier");
            this.f6299a = carrier;
        }

        public final String a() {
            return this.f6299a;
        }
    }

    public static final class b extends a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f6300a = new b();
        public static final int b = 0;

        public b() {
            super(null);
        }
    }

    public static final class c extends a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f6301a = new c();
        public static final int b = 0;

        public c() {
            super(null);
        }
    }

    public /* synthetic */ a0(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public a0() {
    }
}
