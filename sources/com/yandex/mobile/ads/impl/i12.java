package com.yandex.mobile.ads.impl;

import android.util.SparseArray;

/* JADX INFO: loaded from: classes13.dex */
final class i12<V> {
    private final vr<V> c;
    private final SparseArray<V> b = new SparseArray<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9165a = -1;

    public i12(vr<V> vrVar) {
        this.c = vrVar;
    }

    public final V b(int i) {
        if (this.f9165a == -1) {
            this.f9165a = 0;
        }
        while (true) {
            int i2 = this.f9165a;
            if (i2 <= 0 || i >= this.b.keyAt(i2)) {
                break;
            }
            this.f9165a--;
        }
        while (this.f9165a < this.b.size() - 1 && i >= this.b.keyAt(this.f9165a + 1)) {
            this.f9165a++;
        }
        return this.b.valueAt(this.f9165a);
    }

    public final void a(int i, V v) {
        if (this.f9165a == -1) {
            if (this.b.size() == 0) {
                this.f9165a = 0;
            } else {
                throw new IllegalStateException();
            }
        }
        if (this.b.size() > 0) {
            SparseArray<V> sparseArray = this.b;
            int iKeyAt = sparseArray.keyAt(sparseArray.size() - 1);
            if (i < iKeyAt) {
                throw new IllegalArgumentException();
            }
            if (iKeyAt == i) {
                vr<V> vrVar = this.c;
                SparseArray<V> sparseArray2 = this.b;
                vrVar.accept(sparseArray2.valueAt(sparseArray2.size() - 1));
            }
        }
        this.b.append(i, v);
    }

    public final boolean c() {
        return this.b.size() == 0;
    }

    public final V b() {
        SparseArray<V> sparseArray = this.b;
        return sparseArray.valueAt(sparseArray.size() - 1);
    }

    public final void a() {
        for (int i = 0; i < this.b.size(); i++) {
            this.c.accept(this.b.valueAt(i));
        }
        this.f9165a = -1;
        this.b.clear();
    }

    public final void a(int i) {
        int i2 = 0;
        while (i2 < this.b.size() - 1) {
            int i3 = i2 + 1;
            if (i < this.b.keyAt(i3)) {
                return;
            }
            this.c.accept(this.b.valueAt(i2));
            this.b.removeAt(i2);
            int i4 = this.f9165a;
            if (i4 > 0) {
                this.f9165a = i4 - 1;
            }
            i2 = i3;
        }
    }
}
