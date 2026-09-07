package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
abstract class jh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9316a;

    public static String a(int i) {
        return "" + ((char) ((i >> 24) & 255)) + ((char) ((i >> 16) & 255)) + ((char) ((i >> 8) & 255)) + ((char) (i & 255));
    }

    public jh(int i) {
        this.f9316a = i;
    }

    public String toString() {
        return a(this.f9316a);
    }

    static final class b extends jh {
        public final wf1 b;

        public b(int i, wf1 wf1Var) {
            super(i);
            this.b = wf1Var;
        }
    }

    static final class a extends jh {
        public final long b;
        public final ArrayList c;
        public final ArrayList d;

        @Override // com.yandex.mobile.ads.impl.jh
        public final String toString() {
            return jh.a(this.f9316a) + " leaves: " + Arrays.toString(this.c.toArray()) + " containers: " + Arrays.toString(this.d.toArray());
        }

        public a(int i, long j) {
            super(i);
            this.b = j;
            this.c = new ArrayList();
            this.d = new ArrayList();
        }

        public final b c(int i) {
            int size = this.c.size();
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = (b) this.c.get(i2);
                if (bVar.f9316a == i) {
                    return bVar;
                }
            }
            return null;
        }

        public final a b(int i) {
            int size = this.d.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = (a) this.d.get(i2);
                if (aVar.f9316a == i) {
                    return aVar;
                }
            }
            return null;
        }
    }
}
