package com.yandex.mobile.ads.impl;

import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes4.dex */
public abstract class tk implements e70 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final r52 f10308a;
    protected final int b;
    protected final int[] c;
    private final gc0[] d;
    private int e;

    @Override // com.yandex.mobile.ads.impl.e70
    public void a(float f) {
    }

    @Override // com.yandex.mobile.ads.impl.e70
    public void c() {
    }

    @Override // com.yandex.mobile.ads.impl.e70
    public void d() {
    }

    public tk(r52 r52Var, int[] iArr) {
        int i = 0;
        hg.b(iArr.length > 0);
        this.f10308a = (r52) hg.a(r52Var);
        int length = iArr.length;
        this.b = length;
        this.d = new gc0[length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.d[i2] = r52Var.a(iArr[i2]);
        }
        Arrays.sort(this.d, new Comparator() { // from class: com.yandex.mobile.ads.impl.tk$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return tk.a((gc0) obj, (gc0) obj2);
            }
        });
        this.c = new int[this.b];
        while (true) {
            int i3 = this.b;
            if (i >= i3) {
                long[] jArr = new long[i3];
                return;
            } else {
                this.c[i] = r52Var.a(this.d[i]);
                i++;
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.v52
    public final gc0 a(int i) {
        return this.d[i];
    }

    @Override // com.yandex.mobile.ads.impl.v52
    public final int b(int i) {
        return this.c[i];
    }

    @Override // com.yandex.mobile.ads.impl.v52
    public final int c(int i) {
        for (int i2 = 0; i2 < this.b; i2++) {
            if (this.c[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.yandex.mobile.ads.impl.e70
    public final gc0 e() {
        return this.d[0];
    }

    public final int hashCode() {
        if (this.e == 0) {
            this.e = Arrays.hashCode(this.c) + (System.identityHashCode(this.f10308a) * 31);
        }
        return this.e;
    }

    @Override // com.yandex.mobile.ads.impl.v52
    public final r52 a() {
        return this.f10308a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        tk tkVar = (tk) obj;
        return this.f10308a == tkVar.f10308a && Arrays.equals(this.c, tkVar.c);
    }

    @Override // com.yandex.mobile.ads.impl.v52
    public final int b() {
        return this.c.length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a(gc0 gc0Var, gc0 gc0Var2) {
        return gc0Var2.i - gc0Var.i;
    }
}
