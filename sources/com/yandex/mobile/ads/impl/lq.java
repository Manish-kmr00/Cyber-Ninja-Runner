package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class lq {

    public static final class c extends lq {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9554a;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && Intrinsics.areEqual(this.f9554a, ((c) obj).f9554a);
        }

        public final int hashCode() {
            String str = this.f9554a;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public final String toString() {
            return "ConsentString(value=" + this.f9554a + ")";
        }

        public c(String str) {
            super(0);
            this.f9554a = str;
        }

        public final String a() {
            return this.f9554a;
        }
    }

    private lq() {
    }

    public static final class d extends lq {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9555a;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && Intrinsics.areEqual(this.f9555a, ((d) obj).f9555a);
        }

        public final int hashCode() {
            String str = this.f9555a;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public final String toString() {
            return "Gdpr(value=" + this.f9555a + ")";
        }

        public d(String str) {
            super(0);
            this.f9555a = str;
        }

        public final String a() {
            return this.f9555a;
        }
    }

    public static final class b extends lq {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f9553a;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && this.f9553a == ((b) obj).f9553a;
        }

        public final int hashCode() {
            return Boolean.hashCode(this.f9553a);
        }

        public final String toString() {
            return "CmpPresent(value=" + this.f9553a + ")";
        }

        public b(boolean z) {
            super(0);
            this.f9553a = z;
        }

        public final boolean a() {
            return this.f9553a;
        }
    }

    public /* synthetic */ lq(int i) {
        this();
    }

    public static final class e extends lq {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9556a;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof e) && Intrinsics.areEqual(this.f9556a, ((e) obj).f9556a);
        }

        public final int hashCode() {
            String str = this.f9556a;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public final String toString() {
            return "PurposeConsents(value=" + this.f9556a + ")";
        }

        public e(String str) {
            super(0);
            this.f9556a = str;
        }

        public final String a() {
            return this.f9556a;
        }
    }

    public static final class f extends lq {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9557a;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof f) && Intrinsics.areEqual(this.f9557a, ((f) obj).f9557a);
        }

        public final int hashCode() {
            String str = this.f9557a;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public final String toString() {
            return "VendorConsents(value=" + this.f9557a + ")";
        }

        public f(String str) {
            super(0);
            this.f9557a = str;
        }

        public final String a() {
            return this.f9557a;
        }
    }

    public static final class a extends lq {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9552a;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.areEqual(this.f9552a, ((a) obj).f9552a);
        }

        public final int hashCode() {
            String str = this.f9552a;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public final String toString() {
            return "AdditionalConsent(value=" + this.f9552a + ")";
        }

        public a(String str) {
            super(0);
            this.f9552a = str;
        }

        public final String a() {
            return this.f9552a;
        }
    }
}
