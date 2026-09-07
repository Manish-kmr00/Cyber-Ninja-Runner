package com.yandex.mobile.ads.impl;

import android.util.Base64;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: classes12.dex */
public final class h00 {
    public static final m32<String> h = new m32() { // from class: com.yandex.mobile.ads.impl.h00$$ExternalSyntheticLambda0
        @Override // com.yandex.mobile.ads.impl.m32
        public final Object get() {
            return h00.a();
        }
    };
    private static final Random i = new Random();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b52.d f9048a;
    private final b52.b b;
    private final HashMap<String, a> c;
    private final m32<String> d;
    private ai1 e;
    private b52 f;
    private String g;

    public h00() {
        this(h);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0037, code lost:
    
        if (r1.d < r2) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void c(com.yandex.mobile.ads.impl.ld.a r8) {
        /*
            Method dump skipped, instruction units count: 209
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.mobile.ads.impl.h00.c(com.yandex.mobile.ads.impl.ld$a):void");
    }

    public h00(m32<String> m32Var) {
        this.d = m32Var;
        this.f9048a = new b52.d();
        this.b = new b52.b();
        this.c = new HashMap<>();
        this.f = b52.b;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0097 A[Catch: all -> 0x00ac, TryCatch #0 {, blocks: (B:3:0x0001, B:4:0x0016, B:6:0x001c, B:8:0x002f, B:19:0x0067, B:29:0x0082, B:31:0x008b, B:33:0x0097, B:34:0x009a, B:22:0x006d, B:27:0x007c, B:25:0x0074, B:11:0x0036, B:12:0x0045, B:14:0x004d, B:16:0x0057, B:17:0x0063, B:35:0x00a7), top: B:41:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x008b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:50:0x0016 A[SYNTHETIC] */
    public final synchronized void d(ld.a aVar) {
        rw0.b bVar;
        this.e.getClass();
        b52 b52Var = this.f;
        this.f = aVar.b;
        Iterator<a> it = this.c.values().iterator();
        while (it.hasNext()) {
            a next = it.next();
            b52 b52Var2 = this.f;
            int i2 = next.b;
            if (i2 >= b52Var.b()) {
                if (i2 >= b52Var2.b()) {
                    i2 = -1;
                    break;
                }
            } else {
                b52Var.a(i2, h00.this.f9048a, 0L);
                int i3 = h00.this.f9048a.p;
                while (true) {
                    if (i3 > h00.this.f9048a.q) {
                        i2 = -1;
                        break;
                    }
                    int iA = b52Var2.a(b52Var.a(i3));
                    if (iA != -1) {
                        i2 = b52Var2.a(iA, h00.this.b, false).d;
                        break;
                    }
                    i3++;
                }
            }
            next.b = i2;
            if (i2 != -1 && ((bVar = next.d) == null || b52Var2.a(bVar.f9759a) != -1)) {
                if (next.a(aVar)) {
                    it.remove();
                    if (!next.e) {
                        if (next.f9049a.equals(this.g)) {
                            this.g = null;
                        }
                        ((jw0) this.e).b(aVar, next.f9049a);
                    }
                }
            } else {
                it.remove();
                if (!next.e) {
                    if (next.f9049a.equals(this.g)) {
                        this.g = null;
                    }
                    ((jw0) this.e).b(aVar, next.f9049a);
                }
            }
        }
        b(aVar);
    }

    public final synchronized String b() {
        return this.g;
    }

    public final synchronized void a(ld.a aVar) {
        ai1 ai1Var;
        this.g = null;
        Iterator<a> it = this.c.values().iterator();
        while (it.hasNext()) {
            a next = it.next();
            it.remove();
            if (next.e && (ai1Var = this.e) != null) {
                ((jw0) ai1Var).b(aVar, next.f9049a);
            }
        }
    }

    private final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9049a;
        private int b;
        private long c;
        private rw0.b d;
        private boolean e;
        private boolean f;

        public a(String str, int i, rw0.b bVar) {
            this.f9049a = str;
            this.b = i;
            this.c = bVar == null ? -1L : bVar.d;
            if (bVar == null || !bVar.a()) {
                return;
            }
            this.d = bVar;
        }

        public final boolean a(ld.a aVar) {
            long j = this.c;
            if (j == -1) {
                return false;
            }
            rw0.b bVar = aVar.d;
            if (bVar == null) {
                return this.b != aVar.c;
            }
            if (bVar.d > j) {
                return true;
            }
            if (this.d == null) {
                return false;
            }
            int iA = aVar.b.a(bVar.f9759a);
            int iA2 = aVar.b.a(this.d.f9759a);
            rw0.b bVar2 = aVar.d;
            if (bVar2.d < this.d.d || iA < iA2) {
                return false;
            }
            if (iA > iA2) {
                return true;
            }
            if (bVar2.a()) {
                rw0.b bVar3 = aVar.d;
                int i = bVar3.b;
                int i2 = bVar3.c;
                rw0.b bVar4 = this.d;
                int i3 = bVar4.b;
                return i > i3 || (i == i3 && i2 > bVar4.c);
            }
            int i4 = aVar.d.e;
            return i4 == -1 || i4 > this.d.b;
        }
    }

    @RequiresNonNull({ServiceSpecificExtraArgs.CastExtraArgs.LISTENER})
    private void b(ld.a aVar) {
        rw0.b bVar;
        if (aVar.b.c()) {
            this.g = null;
            return;
        }
        a aVar2 = this.c.get(this.g);
        this.g = a(aVar.c, aVar.d).f9049a;
        c(aVar);
        rw0.b bVar2 = aVar.d;
        if (bVar2 == null || !bVar2.a()) {
            return;
        }
        if (aVar2 != null) {
            long j = aVar2.c;
            rw0.b bVar3 = aVar.d;
            if (j == bVar3.d && (bVar = aVar2.d) != null && bVar.b == bVar3.b && bVar.c == bVar3.c) {
                return;
            }
        }
        rw0.b bVar4 = aVar.d;
        a(aVar.c, new rw0.b(bVar4.f9759a, bVar4.d));
        this.e.getClass();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String a() {
        byte[] bArr = new byte[12];
        i.nextBytes(bArr);
        return Base64.encodeToString(bArr, 10);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x006f  */
    /* JADX WARN: Code duplicated, block: B:46:0x0086 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    private a a(int i2, rw0.b bVar) {
        long j;
        a aVar = null;
        long j2 = Long.MAX_VALUE;
        for (a aVar2 : this.c.values()) {
            if (aVar2.c == -1 && i2 == aVar2.b && bVar != null) {
                aVar2.c = bVar.d;
            }
            if (bVar == null) {
                if (i2 == aVar2.b) {
                    j = aVar2.c;
                    if (j != -1 || j < j2) {
                        aVar = aVar2;
                        j2 = j;
                    } else if (j == j2) {
                        int i3 = x82.f10629a;
                        if (aVar.d != null && aVar2.d != null) {
                            aVar = aVar2;
                        }
                    }
                }
            } else {
                rw0.b bVar2 = aVar2.d;
                if (bVar2 == null) {
                    if (!bVar.a() && bVar.d == aVar2.c) {
                        j = aVar2.c;
                        if (j != -1) {
                        }
                        aVar = aVar2;
                        j2 = j;
                    }
                } else if (bVar.d == bVar2.d && bVar.b == bVar2.b && bVar.c == bVar2.c) {
                    j = aVar2.c;
                    if (j != -1) {
                    }
                    aVar = aVar2;
                    j2 = j;
                }
            }
        }
        if (aVar != null) {
            return aVar;
        }
        String str = this.d.get();
        a aVar3 = new a(str, i2, bVar);
        this.c.put(str, aVar3);
        return aVar3;
    }

    public final synchronized String a(b52 b52Var, rw0.b bVar) {
        return a(b52Var.a(bVar.f9759a, this.b).d, bVar).f9049a;
    }

    public final void a(ai1 ai1Var) {
        this.e = ai1Var;
    }

    public final synchronized void a(ld.a aVar, int i2) {
        this.e.getClass();
        boolean z = i2 == 0;
        Iterator<a> it = this.c.values().iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.a(aVar)) {
                it.remove();
                if (next.e) {
                    boolean zEquals = next.f9049a.equals(this.g);
                    if (z && zEquals) {
                        boolean unused = next.f;
                    }
                    if (zEquals) {
                        this.g = null;
                    }
                    ((jw0) this.e).b(aVar, next.f9049a);
                }
            }
        }
        b(aVar);
    }
}
