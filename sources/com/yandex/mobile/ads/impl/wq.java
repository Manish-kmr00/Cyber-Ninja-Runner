package com.yandex.mobile.ads.impl;

import java.util.Comparator;

/* JADX INFO: loaded from: classes6.dex */
public abstract class wq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final wq f10583a = new a();
    private static final wq b = new b(-1);
    private static final wq c = new b(1);

    final class a extends wq {
        @Override // com.yandex.mobile.ads.impl.wq
        public final int a() {
            return 0;
        }

        @Override // com.yandex.mobile.ads.impl.wq
        public final wq a(int i, int i2) {
            byte b;
            if (i < i2) {
                b = -1;
            } else {
                b = i > i2 ? (byte) 1 : (byte) 0;
            }
            if (b < 0) {
                return wq.b;
            }
            return b > 0 ? wq.c : wq.f10583a;
        }

        @Override // com.yandex.mobile.ads.impl.wq
        public final wq b(boolean z, boolean z2) {
            byte b;
            if (z2 == z) {
                b = 0;
            } else {
                b = z2 ? (byte) 1 : (byte) -1;
            }
            if (b < 0) {
                return wq.b;
            }
            return b > 0 ? wq.c : wq.f10583a;
        }

        @Override // com.yandex.mobile.ads.impl.wq
        public final wq a(long j, long j2) {
            byte b;
            if (j < j2) {
                b = -1;
            } else {
                b = j > j2 ? (byte) 1 : (byte) 0;
            }
            if (b < 0) {
                return wq.b;
            }
            return b > 0 ? wq.c : wq.f10583a;
        }

        a() {
            super();
        }

        @Override // com.yandex.mobile.ads.impl.wq
        public final <T> wq a(T t, T t2, Comparator<T> comparator) {
            int iCompare = comparator.compare(t, t2);
            if (iCompare < 0) {
                return wq.b;
            }
            return iCompare > 0 ? wq.c : wq.f10583a;
        }

        @Override // com.yandex.mobile.ads.impl.wq
        public final wq a(boolean z, boolean z2) {
            byte b;
            if (z == z2) {
                b = 0;
            } else {
                b = z ? (byte) 1 : (byte) -1;
            }
            if (b < 0) {
                return wq.b;
            }
            return b > 0 ? wq.c : wq.f10583a;
        }
    }

    public static wq b() {
        return f10583a;
    }

    public abstract int a();

    public abstract wq a(int i, int i2);

    public abstract wq a(long j, long j2);

    public abstract <T> wq a(T t, T t2, Comparator<T> comparator);

    public abstract wq a(boolean z, boolean z2);

    public abstract wq b(boolean z, boolean z2);

    private wq() {
    }

    private static final class b extends wq {
        final int d;

        @Override // com.yandex.mobile.ads.impl.wq
        public final wq a(int i, int i2) {
            return this;
        }

        @Override // com.yandex.mobile.ads.impl.wq
        public final wq a(long j, long j2) {
            return this;
        }

        @Override // com.yandex.mobile.ads.impl.wq
        public final <T> wq a(T t, T t2, Comparator<T> comparator) {
            return this;
        }

        @Override // com.yandex.mobile.ads.impl.wq
        public final wq a(boolean z, boolean z2) {
            return this;
        }

        @Override // com.yandex.mobile.ads.impl.wq
        public final wq b(boolean z, boolean z2) {
            return this;
        }

        b(int i) {
            super();
            this.d = i;
        }

        @Override // com.yandex.mobile.ads.impl.wq
        public final int a() {
            return this.d;
        }
    }
}
