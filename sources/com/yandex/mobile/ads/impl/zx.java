package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public interface zx {

    public static final class a implements zx {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f10857a = new a();

        private a() {
        }
    }

    public static final class g implements zx {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f10863a = new g();

        private g() {
        }
    }

    public static final class d implements zx {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f10860a = new d();

        private d() {
        }
    }

    public static final class c implements zx {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f10859a = new c();

        private c() {
        }
    }

    public static final class e implements zx {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f10861a;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof e) && this.f10861a == ((e) obj).f10861a;
        }

        public final int hashCode() {
            return Boolean.hashCode(this.f10861a);
        }

        public final String toString() {
            return "OnDebugErrorIndicatorSwitch(isChecked=" + this.f10861a + ")";
        }

        public e(boolean z) {
            this.f10861a = z;
        }
    }

    public static final class b implements zx {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10858a;

        public b(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.f10858a = id;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && Intrinsics.areEqual(this.f10858a, ((b) obj).f10858a);
        }

        public final int hashCode() {
            return this.f10858a.hashCode();
        }

        public final String toString() {
            return "OnAdUnitClick(id=" + this.f10858a + ")";
        }

        public final String a() {
            return this.f10858a;
        }
    }

    public static final class f implements zx {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final fy.g f10862a;

        public f(fy.g uiUnit) {
            Intrinsics.checkNotNullParameter(uiUnit, "uiUnit");
            this.f10862a = uiUnit;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof f) && Intrinsics.areEqual(this.f10862a, ((f) obj).f10862a);
        }

        public final int hashCode() {
            return this.f10862a.hashCode();
        }

        public final String toString() {
            return "OnMediationNetworkClick(uiUnit=" + this.f10862a + ")";
        }

        public final fy.g a() {
            return this.f10862a;
        }
    }

    public static final class h implements zx {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10864a;

        public h(String waring) {
            Intrinsics.checkNotNullParameter(waring, "waring");
            this.f10864a = waring;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof h) && Intrinsics.areEqual(this.f10864a, ((h) obj).f10864a);
        }

        public final int hashCode() {
            return this.f10864a.hashCode();
        }

        public final String toString() {
            return "OnWarningButtonClick(waring=" + this.f10864a + ")";
        }

        public final String a() {
            return this.f10864a;
        }
    }
}
