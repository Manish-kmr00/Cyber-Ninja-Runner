package com.yandex.mobile.ads.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public abstract class r31<K0, V0> {

    public static abstract class c<K0> {
        abstract <K extends K0, V> Map<K, Collection<V>> b();

        public final b<K0, Object> a() {
            nq.a(2, "expectedValuesPerKey");
            return new s31(this);
        }

        c() {
        }
    }

    public static c<Comparable> a() {
        mc1 mc1Var = mc1.b;
        mc1Var.getClass();
        return new q31(mc1Var);
    }

    private r31() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class a<V> implements m32<List<V>>, Serializable {
        private final int b;

        @Override // com.yandex.mobile.ads.impl.m32
        public final Object get() {
            return new ArrayList(this.b);
        }

        a(int i) {
            this.b = nq.a(i, "expectedValuesPerKey");
        }
    }

    public static abstract class b<K0, V0> extends r31<K0, V0> {
        public abstract <K extends K0, V extends V0> vr0<K, V> b();

        b() {
            super();
        }
    }
}
