package com.applovin.impl;

import android.os.SystemClock;
import com.applovin.mediation.MaxAdFormat;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class z4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.k f775a;
    private final Map b = new HashMap();
    private final Object c = new Object();

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f776a;

        static {
            int[] iArr = new int[b.values().length];
            f776a = iArr;
            try {
                iArr[b.AD_FORMAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f776a[b.AD_UNIT_ID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f776a[b.ALL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum b {
        AD_FORMAT,
        AD_UNIT_ID,
        ALL
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a5 f778a;
        private final long b;
        private final long c;

        /* synthetic */ c(a5 a5Var, long j, a aVar) {
            this(a5Var, j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean d() {
            return SystemClock.elapsedRealtime() - this.c > this.b;
        }

        protected boolean a(Object obj) {
            return obj instanceof c;
        }

        public a5 c() {
            return this.f778a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (!cVar.a((Object) this) || b() != cVar.b() || a() != cVar.a()) {
                return false;
            }
            a5 a5VarC = c();
            a5 a5VarC2 = cVar.c();
            return a5VarC != null ? a5VarC.equals(a5VarC2) : a5VarC2 == null;
        }

        public int hashCode() {
            long jB = b();
            long jA = a();
            a5 a5VarC = c();
            return ((((((int) (jB ^ (jB >>> 32))) + 59) * 59) + ((int) ((jA >>> 32) ^ jA))) * 59) + (a5VarC == null ? 43 : a5VarC.hashCode());
        }

        public String toString() {
            return "SignalCacheManager.SignalWrapper(signal=" + c() + ", expirationTimeMillis=" + b() + ", cacheTimestampMillis=" + a() + ")";
        }

        private c(a5 a5Var, long j) {
            this.f778a = a5Var;
            this.b = j;
            this.c = SystemClock.elapsedRealtime();
        }

        public long b() {
            return this.b;
        }

        public long a() {
            return this.c;
        }
    }

    public z4(com.applovin.impl.sdk.k kVar) {
        this.f775a = kVar;
    }

    public void a(a5 a5Var, b5 b5Var, String str, MaxAdFormat maxAdFormat) {
        if (a5Var == null) {
            return;
        }
        long jV = b5Var.v();
        if (jV <= 0) {
            return;
        }
        this.f775a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f775a.O().a("SignalCacheManager", "Caching signal for: " + b5Var);
        }
        String strA = a(b5Var, str, maxAdFormat);
        c cVar = new c(a5Var, jV, null);
        synchronized (this.c) {
            this.b.put(strA, cVar);
        }
    }

    public a5 b(b5 b5Var, String str, MaxAdFormat maxAdFormat) {
        String strA = a(b5Var, str, maxAdFormat);
        synchronized (this.c) {
            c cVar = (c) this.b.get(strA);
            if (cVar == null) {
                return null;
            }
            if (cVar.d()) {
                this.b.remove(strA);
                return null;
            }
            this.f775a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f775a.O().a("SignalCacheManager", "Returning cached signal for: " + b5Var);
            }
            return cVar.f778a;
        }
    }

    private String a(b5 b5Var, String str, MaxAdFormat maxAdFormat) {
        String strC = b5Var.c();
        int i = a.f776a[b5Var.t().ordinal()];
        if (i != 1) {
            return i != 2 ? strC : strC + "_" + str;
        }
        return strC + "_" + maxAdFormat.getLabel();
    }
}
