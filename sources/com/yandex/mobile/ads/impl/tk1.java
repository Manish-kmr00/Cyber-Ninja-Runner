package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class tk1<T, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f10310a;
    private final int b;
    private final k70 c;
    private final l70 d;
    private final ArrayList e;

    public static final class a<T, V> implements j70 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final T f10311a;
        private final V b;
        private final long c;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.f10311a, aVar.f10311a) && Intrinsics.areEqual(this.b, aVar.b) && this.c == aVar.c;
        }

        public final int hashCode() {
            T t = this.f10311a;
            int iHashCode = (t == null ? 0 : t.hashCode()) * 31;
            V v = this.b;
            return Long.hashCode(this.c) + ((iHashCode + (v != null ? v.hashCode() : 0)) * 31);
        }

        public final String toString() {
            return "CachedItem(params=" + this.f10311a + ", item=" + this.b + ", expiresAtTimestampMillis=" + this.c + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(td0 td0Var, Object obj, long j) {
            this.f10311a = td0Var;
            this.b = obj;
            this.c = j;
        }

        public final T c() {
            return this.f10311a;
        }

        public final V b() {
            return this.b;
        }

        @Override // com.yandex.mobile.ads.impl.j70
        public final long a() {
            return this.c;
        }
    }

    public /* synthetic */ tk1() {
        this(86400000L, 5, new k70(), new l70());
    }

    public final synchronized void a(td0 td0Var, Object obj) {
        a();
        if (this.e.size() < this.b) {
            ArrayList arrayList = this.e;
            l70 l70Var = this.d;
            long j = this.f10310a;
            l70Var.getClass();
            arrayList.add(new a(td0Var, obj, System.currentTimeMillis() + j));
        }
    }

    public tk1(long j, int i, k70 expirationChecker, l70 expirationTimestampUtil) {
        Intrinsics.checkNotNullParameter(expirationChecker, "expirationChecker");
        Intrinsics.checkNotNullParameter(expirationTimestampUtil, "expirationTimestampUtil");
        this.f10310a = j;
        this.b = i;
        this.c = expirationChecker;
        this.d = expirationTimestampUtil;
        this.e = new ArrayList();
    }

    public final synchronized boolean b() {
        a();
        return this.e.size() < this.b;
    }

    private final void a() {
        ArrayList arrayList = this.e;
        k70 k70Var = this.c;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            j70 any = (j70) obj;
            k70Var.getClass();
            Intrinsics.checkNotNullParameter(any, "any");
            if (System.currentTimeMillis() > any.a()) {
                arrayList2.add(obj);
            }
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            this.e.remove((a) it.next());
        }
    }

    public final synchronized Object a(td0 td0Var) {
        Object obj;
        Object next;
        Object objB;
        a();
        Iterator it = this.e.iterator();
        do {
            obj = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((a) next).c(), td0Var));
        a aVar = (a) next;
        if (aVar != null && (objB = aVar.b()) != null) {
            this.e.remove(aVar);
            obj = objB;
        }
        return obj;
    }
}
