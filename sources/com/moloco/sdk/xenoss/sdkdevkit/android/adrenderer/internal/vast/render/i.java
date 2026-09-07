package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes8.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f7074a = 0;

    public static final class a extends i {
        public static final int c = 0;
        public final long b;

        public a(long j) {
            super(null);
            this.b = j;
        }

        public final long a() {
            return this.b;
        }
    }

    public static final class b extends i {
        public static final b b = new b();
        public static final int c = 0;

        public b() {
            super(null);
        }
    }

    public static final class c extends i {
        public static final int d = 0;
        public final long b;
        public final long c;

        public c(long j, long j2) {
            super(null);
            this.b = j;
            this.c = j2;
        }

        public final long a() {
            return this.b;
        }

        public final long b() {
            return this.c;
        }

        public final long c() {
            return this.b;
        }

        public final long d() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.b == cVar.b && this.c == cVar.c;
        }

        public int hashCode() {
            return (Long.hashCode(this.b) * 31) + Long.hashCode(this.c);
        }

        public String toString() {
            return "Position(currentPositionMillis=" + this.b + ", totalDurationMillis=" + this.c + ')';
        }

        public final c a(long j, long j2) {
            return new c(j, j2);
        }

        public static /* synthetic */ c a(c cVar, long j, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = cVar.b;
            }
            if ((i & 2) != 0) {
                j2 = cVar.c;
            }
            return cVar.a(j, j2);
        }
    }

    public static final class d extends i {
        public static final int c = 0;
        public final long b;

        public d(long j) {
            super(null);
            this.b = j;
        }

        public final long a() {
            return this.b;
        }

        public final long b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && this.b == ((d) obj).b;
        }

        public int hashCode() {
            return Long.hashCode(this.b);
        }

        public String toString() {
            return "Preparing(totalDurationMillis=" + this.b + ')';
        }

        public final d a(long j) {
            return new d(j);
        }

        public static /* synthetic */ d a(d dVar, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = dVar.b;
            }
            return dVar.a(j);
        }
    }

    public /* synthetic */ i(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public i() {
    }
}
