package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes6.dex */
public final class wk implements oc1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final mk f10569a;
    protected final om b;

    /* JADX WARN: Code restructure failed: missing block: B:5:0x001a, code lost:
    
        r12 = r3.d();
        r0 = r3.c();
     */
    @Override // com.yandex.mobile.ads.impl.oc1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.yandex.mobile.ads.impl.tc1 a(com.yandex.mobile.ads.impl.np1<?> r19) throws com.yandex.mobile.ads.impl.ki2 {
        /*
            r18 = this;
            r1 = r18
            r8 = r19
            long r9 = android.os.SystemClock.elapsedRealtime()
        L8:
            java.util.Collections.emptyList()
            r2 = 0
            com.yandex.mobile.ads.impl.sm$a r0 = r19.c()     // Catch: java.io.IOException -> L70
            java.util.Map r0 = com.yandex.mobile.ads.impl.th0.a(r0)     // Catch: java.io.IOException -> L70
            com.yandex.mobile.ads.impl.mk r3 = r1.f10569a     // Catch: java.io.IOException -> L70
            com.yandex.mobile.ads.impl.zh0 r3 = r3.a(r8, r0)     // Catch: java.io.IOException -> L70
            int r12 = r3.d()     // Catch: java.io.IOException -> L6b
            java.util.List r0 = r3.c()     // Catch: java.io.IOException -> L6b
            r4 = 304(0x130, float:4.26E-43)
            if (r12 != r4) goto L30
            long r4 = android.os.SystemClock.elapsedRealtime()     // Catch: java.io.IOException -> L6b
            long r4 = r4 - r9
            com.yandex.mobile.ads.impl.tc1 r0 = com.yandex.mobile.ads.impl.bd1.a(r8, r4, r0)     // Catch: java.io.IOException -> L6b
            return r0
        L30:
            java.io.InputStream r4 = r3.a()     // Catch: java.io.IOException -> L6b
            if (r4 == 0) goto L41
            int r5 = r3.b()     // Catch: java.io.IOException -> L6b
            com.yandex.mobile.ads.impl.om r6 = r1.b     // Catch: java.io.IOException -> L6b
            byte[] r2 = com.yandex.mobile.ads.impl.bd1.a(r4, r5, r6)     // Catch: java.io.IOException -> L6b
            goto L44
        L41:
            r4 = 0
            byte[] r2 = new byte[r4]     // Catch: java.io.IOException -> L6b
        L44:
            long r4 = android.os.SystemClock.elapsedRealtime()     // Catch: java.io.IOException -> L6b
            long r4 = r4 - r9
            com.yandex.mobile.ads.impl.bd1.a(r4, r8, r2, r12)     // Catch: java.io.IOException -> L6b
            r4 = 200(0xc8, float:2.8E-43)
            if (r12 < r4) goto L65
            r4 = 299(0x12b, float:4.19E-43)
            if (r12 > r4) goto L65
            com.yandex.mobile.ads.impl.tc1 r4 = new com.yandex.mobile.ads.impl.tc1     // Catch: java.io.IOException -> L6b
            long r5 = android.os.SystemClock.elapsedRealtime()     // Catch: java.io.IOException -> L6b
            long r15 = r5 - r9
            r14 = 0
            r11 = r4
            r13 = r2
            r17 = r0
            r11.<init>(r12, r13, r14, r15, r17)     // Catch: java.io.IOException -> L6b
            return r4
        L65:
            java.io.IOException r0 = new java.io.IOException     // Catch: java.io.IOException -> L6b
            r0.<init>()     // Catch: java.io.IOException -> L6b
            throw r0     // Catch: java.io.IOException -> L6b
        L6b:
            r0 = move-exception
            r7 = r2
            r6 = r3
            r3 = r0
            goto L74
        L70:
            r0 = move-exception
            r3 = r0
            r6 = r2
            r7 = r6
        L74:
            r2 = r19
            r4 = r9
            com.yandex.mobile.ads.impl.bd1$a r0 = com.yandex.mobile.ads.impl.bd1.a(r2, r3, r4, r6, r7)
            com.yandex.mobile.ads.impl.bd1.a(r8, r0)
            goto L8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.mobile.ads.impl.wk.a(com.yandex.mobile.ads.impl.np1):com.yandex.mobile.ads.impl.tc1");
    }

    public wk(ci0 ci0Var, om omVar) {
        this.f10569a = ci0Var;
        this.b = omVar;
    }
}
