package com.yandex.mobile.ads.impl;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public interface t52 {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f10270a;
        public final byte[] b;
        public final int c;
        public final int d;

        public a(int i, int i2, int i3, byte[] bArr) {
            this.f10270a = i;
            this.b = bArr;
            this.c = i2;
            this.d = i3;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f10270a == aVar.f10270a && this.c == aVar.c && this.d == aVar.d && Arrays.equals(this.b, aVar.b);
        }

        public final int hashCode() {
            return ((((Arrays.hashCode(this.b) + (this.f10270a * 31)) * 31) + this.c) * 31) + this.d;
        }
    }

    int a(nv nvVar, int i, boolean z) throws IOException;

    void a(long j, int i, int i2, int i3, a aVar);

    void a(gc0 gc0Var);

    void b(int i, wf1 wf1Var);

    default void a(int i, wf1 wf1Var) {
        b(i, wf1Var);
    }

    default int b(nv nvVar, int i, boolean z) throws IOException {
        return a(nvVar, i, z);
    }
}
