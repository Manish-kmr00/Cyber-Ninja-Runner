package com.fyber.inneractive.sdk.player.exoplayer2.source;

import android.net.Uri;

/* JADX INFO: loaded from: classes14.dex */
public final class m implements com.fyber.inneractive.sdk.player.exoplayer2.upstream.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f2131a;
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.h b;
    public final n c;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.e d;
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.o e;
    public volatile boolean f;
    public boolean g;
    public long h;
    public long i;
    public final /* synthetic */ p j;

    public m(p pVar, Uri uri, com.fyber.inneractive.sdk.player.exoplayer2.upstream.h hVar, n nVar, com.fyber.inneractive.sdk.player.exoplayer2.util.e eVar) {
        this.j = pVar;
        uri.getClass();
        this.f2131a = uri;
        hVar.getClass();
        this.b = hVar;
        nVar.getClass();
        this.c = nVar;
        this.d = eVar;
        this.e = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.o();
        this.g = true;
        this.i = -1L;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.z
    public final boolean a() {
        return this.f;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.z
    public final void b() {
        this.f = true;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0091 */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void load() throws java.lang.Throwable {
        /*
            r22 = this;
            r1 = r22
            r0 = 0
            r2 = r0
        L4:
            if (r2 != 0) goto Lbb
            boolean r3 = r1.f
            if (r3 != 0) goto Lbb
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.o r4 = r1.e     // Catch: java.lang.Throwable -> La8
            long r14 = r4.f2054a     // Catch: java.lang.Throwable -> La8
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.h r4 = r1.b     // Catch: java.lang.Throwable -> La8
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.k r13 = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.k     // Catch: java.lang.Throwable -> La8
            android.net.Uri r6 = r1.f2131a     // Catch: java.lang.Throwable -> La8
            com.fyber.inneractive.sdk.player.exoplayer2.source.p r5 = r1.j     // Catch: java.lang.Throwable -> La8
            java.lang.String r11 = r5.h     // Catch: java.lang.Throwable -> La8
            r16 = 0
            r17 = -1
            r5 = r13
            r7 = r14
            r9 = r14
            r19 = r11
            r11 = r17
            r3 = r13
            r13 = r19
            r20 = r14
            r14 = r16
            r5.<init>(r6, r7, r9, r11, r13, r14)     // Catch: java.lang.Throwable -> La8
            long r3 = r4.a(r3)     // Catch: java.lang.Throwable -> La8
            r1.i = r3     // Catch: java.lang.Throwable -> La8
            r5 = -1
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            r11 = r20
            if (r5 == 0) goto L3e
            long r3 = r3 + r11
            r1.i = r3     // Catch: java.lang.Throwable -> La8
        L3e:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.b r3 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.b     // Catch: java.lang.Throwable -> La8
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.h r4 = r1.b     // Catch: java.lang.Throwable -> La8
            long r9 = r1.i     // Catch: java.lang.Throwable -> La8
            r5 = r3
            r6 = r4
            r7 = r11
            r5.<init>(r6, r7, r9)     // Catch: java.lang.Throwable -> La8
            com.fyber.inneractive.sdk.player.exoplayer2.source.n r5 = r1.c     // Catch: java.lang.Throwable -> L91
            r4.a()     // Catch: java.lang.Throwable -> L91
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.i r4 = r5.a(r3)     // Catch: java.lang.Throwable -> L91
            boolean r5 = r1.g     // Catch: java.lang.Throwable -> L91
            if (r5 == 0) goto L5e
            long r5 = r1.h     // Catch: java.lang.Throwable -> L91
            r4.a(r11, r5)     // Catch: java.lang.Throwable -> L91
            r1.g = r0     // Catch: java.lang.Throwable -> L91
        L5e:
            r14 = r11
        L5f:
            if (r2 != 0) goto L96
            boolean r5 = r1.f     // Catch: java.lang.Throwable -> L91
            if (r5 != 0) goto L96
            com.fyber.inneractive.sdk.player.exoplayer2.util.e r5 = r1.d     // Catch: java.lang.Throwable -> L91
            monitor-enter(r5)     // Catch: java.lang.Throwable -> L91
        L68:
            boolean r6 = r5.f2177a     // Catch: java.lang.Throwable -> L93
            if (r6 != 0) goto L70
            r5.wait()     // Catch: java.lang.Throwable -> L93
            goto L68
        L70:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L91
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.o r5 = r1.e     // Catch: java.lang.Throwable -> L91
            int r2 = r4.a(r3, r5)     // Catch: java.lang.Throwable -> L91
            long r5 = r3.c     // Catch: java.lang.Throwable -> L91
            r7 = 1048576(0x100000, double:5.180654E-318)
            long r7 = r7 + r14
            int r7 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r7 <= 0) goto L5f
            com.fyber.inneractive.sdk.player.exoplayer2.util.e r7 = r1.d     // Catch: java.lang.Throwable -> L91
            r7.a()     // Catch: java.lang.Throwable -> L91
            com.fyber.inneractive.sdk.player.exoplayer2.source.p r7 = r1.j     // Catch: java.lang.Throwable -> L91
            android.os.Handler r8 = r7.n     // Catch: java.lang.Throwable -> L91
            com.fyber.inneractive.sdk.player.exoplayer2.source.j r7 = r7.m     // Catch: java.lang.Throwable -> L91
            r8.post(r7)     // Catch: java.lang.Throwable -> L91
            r14 = r5
            goto L5f
        L91:
            r0 = move-exception
            goto Laa
        L93:
            r0 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L91
            throw r0     // Catch: java.lang.Throwable -> L91
        L96:
            r4 = 1
            if (r2 != r4) goto L9b
            r2 = r0
            goto La1
        L9b:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.o r4 = r1.e
            long r5 = r3.c
            r4.f2054a = r5
        La1:
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.h r3 = r1.b
            com.fyber.inneractive.sdk.player.exoplayer2.util.z.a(r3)
            goto L4
        La8:
            r0 = move-exception
            r3 = 0
        Laa:
            r4 = 1
            if (r2 == r4) goto Lb5
            if (r3 == 0) goto Lb5
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.o r2 = r1.e
            long r3 = r3.c
            r2.f2054a = r3
        Lb5:
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.h r2 = r1.b
            com.fyber.inneractive.sdk.player.exoplayer2.util.z.a(r2)
            throw r0
        Lbb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.source.m.load():void");
    }
}
