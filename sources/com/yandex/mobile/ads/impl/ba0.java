package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public abstract class ba0 {

    public static final class b extends ba0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f8485a = new b();

        private b() {
            super(0);
        }
    }

    private ba0() {
    }

    public static final class d extends ba0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f8487a = new d();

        private d() {
            super(0);
        }
    }

    public /* synthetic */ ba0(int i) {
        this();
    }

    public static final class c extends ba0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f8486a = new c();

        private c() {
            super(0);
        }
    }

    public static final class a extends ba0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final w3 f8484a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(w3 adFetchRequestError) {
            super(0);
            Intrinsics.checkNotNullParameter(adFetchRequestError, "adFetchRequestError");
            this.f8484a = adFetchRequestError;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.areEqual(this.f8484a, ((a) obj).f8484a);
        }

        public final int hashCode() {
            return this.f8484a.hashCode();
        }

        public final String toString() {
            return "Failed(adFetchRequestError=" + this.f8484a + ")";
        }

        public final w3 a() {
            return this.f8484a;
        }
    }
}
