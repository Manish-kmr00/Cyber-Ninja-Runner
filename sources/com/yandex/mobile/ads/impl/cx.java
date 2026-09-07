package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public abstract class cx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8648a;

    private cx(String str) {
        this.f8648a = str;
    }

    public final String a() {
        return this.f8648a;
    }

    public static final class d extends cx {
        public static final d b = new d();

        private d() {
            super("Debug Panel", 0);
        }
    }

    public /* synthetic */ cx(String str, int i) {
        this(str);
    }

    public static final class c extends cx {
        public static final c b = new c();

        private c() {
            super("Ad Units", 0);
        }
    }

    public static final class a extends cx {
        private final String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String unitId) {
            super("Ad Units", 0);
            Intrinsics.checkNotNullParameter(unitId, "unitId");
            this.b = unitId;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.areEqual(this.b, ((a) obj).b);
        }

        public final int hashCode() {
            return this.b.hashCode();
        }

        public final String toString() {
            return "AdUnit(unitId=" + this.b + ")";
        }

        public final String b() {
            return this.b;
        }
    }

    public static final class b extends cx {
        private final fy.g b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(fy.g adapter) {
            super(adapter.f(), 0);
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            this.b = adapter;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && Intrinsics.areEqual(this.b, ((b) obj).b);
        }

        public final int hashCode() {
            return this.b.hashCode();
        }

        public final String toString() {
            return "AdUnitMediationAdapter(adapter=" + this.b + ")";
        }

        public final fy.g b() {
            return this.b;
        }
    }

    public static final class e extends cx {
        private final String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String network) {
            super(network, 0);
            Intrinsics.checkNotNullParameter(network, "network");
            this.b = network;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof e) && Intrinsics.areEqual(this.b, ((e) obj).b);
        }

        public final int hashCode() {
            return this.b.hashCode();
        }

        public final String toString() {
            return "MediationNetwork(network=" + this.b + ")";
        }

        public final String b() {
            return this.b;
        }
    }
}
