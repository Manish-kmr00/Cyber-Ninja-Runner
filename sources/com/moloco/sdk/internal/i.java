package com.moloco.sdk.internal;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6104a;
    public final int b;

    public static final class a extends i {
        public static final int e = 0;
        public final int c;
        public final int d;

        public a(int i, int i2) {
            super(i, i2, null);
            this.c = i;
            this.d = i2;
        }

        public final a a(int i, int i2) {
            return new a(i, i2);
        }

        @Override // com.moloco.sdk.internal.i
        public int b() {
            return this.c;
        }

        public final int c() {
            return this.c;
        }

        public final int d() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.c == aVar.c && this.d == aVar.d;
        }

        public int hashCode() {
            return (Integer.hashCode(this.c) * 31) + Integer.hashCode(this.d);
        }

        public String toString() {
            return "Custom(wDp=" + this.c + ", hDp=" + this.d + ')';
        }

        public static /* synthetic */ a a(a aVar, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = aVar.c;
            }
            if ((i3 & 2) != 0) {
                i2 = aVar.d;
            }
            return aVar.a(i, i2);
        }

        @Override // com.moloco.sdk.internal.i
        public int a() {
            return this.d;
        }
    }

    public static final class b extends i {
        public static final b c = new b();
        public static final int d = 0;

        public b() {
            super(300, 250, null);
        }
    }

    public static final class c extends i {
        public static final c c = new c();
        public static final int d = 0;

        public c() {
            super(320, 50, null);
        }
    }

    public static final class d extends i {
        public static final d c = new d();
        public static final int d = 0;

        public d() {
            super(728, 90, null);
        }
    }

    public /* synthetic */ i(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2);
    }

    public int a() {
        return this.b;
    }

    public int b() {
        return this.f6104a;
    }

    public i(int i, int i2) {
        this.f6104a = i;
        this.b = i2;
    }
}
