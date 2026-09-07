package com.yandex.mobile.ads.impl;

import android.os.Bundle;
import android.os.Parcel;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class g70 implements h32 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final fv f8972a = new fv();
    private final k32 b = new k32();
    private final ArrayDeque c = new ArrayDeque();
    private int d;
    private boolean e;

    @Override // com.yandex.mobile.ads.impl.h32
    public final void a(long j) {
    }

    @Override // com.yandex.mobile.ads.impl.ly
    public final l32 a() throws ny {
        if (this.e) {
            throw new IllegalStateException();
        }
        if (this.d != 2 || this.c.isEmpty()) {
            return null;
        }
        l32 l32Var = (l32) this.c.removeFirst();
        if (this.b.f()) {
            l32Var.b(4);
        } else {
            k32 k32Var = this.b;
            long j = k32Var.f;
            fv fvVar = this.f8972a;
            ByteBuffer byteBuffer = k32Var.d;
            byteBuffer.getClass();
            byte[] bArrArray = byteBuffer.array();
            fvVar.getClass();
            Parcel parcelObtain = Parcel.obtain();
            parcelObtain.unmarshall(bArrArray, 0, bArrArray.length);
            parcelObtain.setDataPosition(0);
            Bundle bundle = parcelObtain.readBundle(Bundle.class.getClassLoader());
            parcelObtain.recycle();
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM);
            parcelableArrayList.getClass();
            l32Var.a(this.b.f, new b(j, km.a(ev.t, parcelableArrayList)), 0L);
        }
        this.b.b();
        this.d = 0;
        return l32Var;
    }

    @Override // com.yandex.mobile.ads.impl.ly
    public final k32 b() throws ny {
        if (this.e) {
            throw new IllegalStateException();
        }
        if (this.d != 0) {
            return null;
        }
        this.d = 1;
        return this.b;
    }

    @Override // com.yandex.mobile.ads.impl.ly
    public final void a(k32 k32Var) throws ny {
        if (!this.e) {
            if (this.d == 1) {
                if (this.b == k32Var) {
                    this.d = 2;
                    return;
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    public g70() {
        for (int i = 0; i < 2; i++) {
            this.c.addFirst(new a());
        }
        this.d = 0;
    }

    final class a extends l32 {
        a() {
        }

        @Override // com.yandex.mobile.ads.impl.py
        public final void h() {
            g70.this.a(this);
        }
    }

    @Override // com.yandex.mobile.ads.impl.ly
    public final void flush() {
        if (!this.e) {
            this.b.b();
            this.d = 0;
            return;
        }
        throw new IllegalStateException();
    }

    @Override // com.yandex.mobile.ads.impl.ly
    public final void release() {
        this.e = true;
    }

    private static final class b implements g32 {
        private final long b;
        private final hk0<ev> c;

        @Override // com.yandex.mobile.ads.impl.g32
        public final int a() {
            return 1;
        }

        public b(long j, hk0<ev> hk0Var) {
            this.b = j;
            this.c = hk0Var;
        }

        @Override // com.yandex.mobile.ads.impl.g32
        public final long a(int i) {
            if (i == 0) {
                return this.b;
            }
            throw new IllegalArgumentException();
        }

        @Override // com.yandex.mobile.ads.impl.g32
        public final List<ev> b(long j) {
            return j >= this.b ? this.c : hk0.h();
        }

        @Override // com.yandex.mobile.ads.impl.g32
        public final int a(long j) {
            return this.b > j ? 0 : -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l32 l32Var) {
        if (this.c.size() < 2) {
            if (!this.c.contains(l32Var)) {
                l32Var.b();
                this.c.addFirst(l32Var);
                return;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalStateException();
    }
}
