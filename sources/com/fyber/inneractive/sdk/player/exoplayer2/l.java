package com.fyber.inneractive.sdk.player.exoplayer2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import com.fyber.inneractive.sdk.player.exoplayer2.audio.MediaCodecAudioRenderer;
import java.io.IOException;

/* JADX INFO: loaded from: classes13.dex */
public final class l implements Handler.Callback, com.fyber.inneractive.sdk.player.exoplayer2.source.r, com.fyber.inneractive.sdk.player.exoplayer2.source.t {
    public h A;
    public h B;
    public x C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a[] f2106a;
    public final a[] b;
    public final com.fyber.inneractive.sdk.player.exoplayer2.trackselection.i c;
    public final c d;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.u e;
    public final Handler f;
    public final HandlerThread g;
    public final Handler h;
    public final w i;
    public final v j;
    public i k;
    public s l;
    public a m;
    public com.fyber.inneractive.sdk.player.exoplayer2.util.h n;
    public com.fyber.inneractive.sdk.player.exoplayer2.source.u o;
    public a[] p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public int u = 1;
    public long v;
    public int w;
    public j x;
    public long y;
    public h z;

    public l(a[] aVarArr, com.fyber.inneractive.sdk.player.exoplayer2.trackselection.d dVar, c cVar, boolean z, f fVar, i iVar, g gVar) {
        this.f2106a = aVarArr;
        this.c = dVar;
        this.d = cVar;
        this.r = z;
        this.h = fVar;
        this.k = iVar;
        this.b = new a[aVarArr.length];
        for (int i = 0; i < aVarArr.length; i++) {
            a aVar = aVarArr[i];
            aVar.getClass();
            this.b[i] = aVar;
        }
        this.e = new com.fyber.inneractive.sdk.player.exoplayer2.util.u();
        this.p = new a[0];
        this.i = new w();
        this.j = new v();
        this.l = s.d;
        HandlerThread handlerThread = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.g = handlerThread;
        handlerThread.start();
        this.f = new Handler(handlerThread.getLooper(), this);
    }

    public static void a(a aVar) {
        int i = aVar.c;
        if (i == 2) {
            if (i != 2) {
                throw new IllegalStateException();
            }
            aVar.c = 1;
            aVar.j();
        }
    }

    public final void b(boolean z) {
        if (this.t != z) {
            this.t = z;
            this.h.obtainMessage(2, z ? 1 : 0, 0).sendToTarget();
        }
    }

    public final void c(boolean z) {
        this.s = false;
        this.r = z;
        if (!z) {
            g();
            h();
            a(false);
            return;
        }
        int i = this.u;
        if (i != 3) {
            if (i == 2) {
                this.f.sendEmptyMessage(2);
                return;
            }
            return;
        }
        this.s = false;
        com.fyber.inneractive.sdk.player.exoplayer2.util.u uVar = this.e;
        if (!uVar.f2189a) {
            uVar.c = SystemClock.elapsedRealtime();
            uVar.f2189a = true;
        }
        for (a aVar : this.p) {
            if (aVar.c != 1) {
                throw new IllegalStateException();
            }
            aVar.c = 2;
            aVar.i();
        }
        this.f.sendEmptyMessage(2);
    }

    public final synchronized void d() {
        if (this.q) {
            return;
        }
        this.f.sendEmptyMessage(6);
        while (!this.q) {
            try {
                wait();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        this.g.quit();
    }

    public final void e() {
        a(true);
        this.d.a(true);
        a(1);
        synchronized (this) {
            this.q = true;
            notifyAll();
        }
    }

    public final void f() throws d {
        h hVar = this.B;
        if (hVar == null) {
            return;
        }
        boolean z = true;
        while (hVar != null && hVar.i) {
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.j jVarA = hVar.p.a(hVar.o, hVar.f2102a.a());
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.j jVar = hVar.s;
            if (jVar != null) {
                int i = 0;
                while (true) {
                    if (i >= jVarA.b.f2143a) {
                        if (hVar == this.A) {
                            z = false;
                        }
                        hVar = hVar.k;
                    } else if (jVarA.a(jVar, i)) {
                        i++;
                    }
                }
            }
            hVar.m = jVarA;
            if (z) {
                h hVar2 = this.A;
                h hVar3 = this.B;
                boolean z2 = hVar2 != hVar3;
                for (h hVar4 = hVar3.k; hVar4 != null; hVar4 = hVar4.k) {
                    hVar4.a();
                }
                h hVar5 = this.B;
                hVar5.k = null;
                this.z = hVar5;
                this.A = hVar5;
                boolean[] zArr = new boolean[this.f2106a.length];
                long jA = hVar5.a(this.k.c, z2, zArr);
                if (jA != this.k.c) {
                    this.k.c = jA;
                    a(jA);
                }
                boolean[] zArr2 = new boolean[this.f2106a.length];
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    a[] aVarArr = this.f2106a;
                    if (i2 >= aVarArr.length) {
                        break;
                    }
                    a aVar = aVarArr[i2];
                    boolean z3 = aVar.c != 0;
                    zArr2[i2] = z3;
                    com.fyber.inneractive.sdk.player.exoplayer2.source.v vVar = this.B.c[i2];
                    if (vVar != null) {
                        i3++;
                    }
                    if (z3) {
                        if (vVar != aVar.d) {
                            if (aVar == this.m) {
                                if (vVar == null) {
                                    com.fyber.inneractive.sdk.player.exoplayer2.util.u uVar = this.e;
                                    com.fyber.inneractive.sdk.player.exoplayer2.util.h hVar6 = this.n;
                                    uVar.getClass();
                                    uVar.a(hVar6.b());
                                    uVar.d = hVar6.a();
                                }
                                this.n = null;
                                this.m = null;
                            }
                            a(aVar);
                            aVar.c();
                        } else if (zArr[i2]) {
                            long j = this.y;
                            aVar.g = false;
                            aVar.f = false;
                            aVar.a(false, j);
                        }
                    }
                    i2++;
                }
                this.h.obtainMessage(3, hVar.m).sendToTarget();
                a(zArr2, i3);
            } else {
                this.z = hVar;
                for (h hVar7 = hVar.k; hVar7 != null; hVar7 = hVar7.k) {
                    hVar7.a();
                }
                h hVar8 = this.z;
                hVar8.k = null;
                if (hVar8.i) {
                    long j2 = hVar8.g;
                    long jMax = Math.max(j2, Math.abs(this.y - (hVar8.e - j2)));
                    h hVar9 = this.z;
                    hVar9.a(jMax, false, new boolean[hVar9.n.length]);
                }
            }
            b();
            h();
            this.f.sendEmptyMessage(2);
            return;
        }
    }

    public final void g() {
        com.fyber.inneractive.sdk.player.exoplayer2.util.u uVar = this.e;
        if (uVar.f2189a) {
            uVar.a(uVar.b());
            uVar.f2189a = false;
        }
        for (a aVar : this.p) {
            a(aVar);
        }
    }

    public final void h() {
        h hVar = this.B;
        if (hVar == null) {
            return;
        }
        long jG = hVar.f2102a.g();
        if (jG != -9223372036854775807L) {
            a(jG);
        } else {
            a aVar = this.m;
            if (aVar == null || aVar.e()) {
                this.y = this.e.b();
            } else {
                long jB = this.n.b();
                this.y = jB;
                this.e.a(jB);
            }
            h hVar2 = this.B;
            jG = Math.abs(this.y - (hVar2.e - hVar2.g));
        }
        this.k.c = jG;
        this.v = SystemClock.elapsedRealtime() * 1000;
        long jC = this.p.length == 0 ? Long.MIN_VALUE : this.B.f2102a.c();
        i iVar = this.k;
        if (jC == Long.MIN_VALUE) {
            long j = this.C.a(this.B.f, this.j, false).d;
        }
        iVar.getClass();
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        try {
            switch (message.what) {
                case 0:
                    a((com.fyber.inneractive.sdk.player.exoplayer2.source.u) message.obj, message.arg1 != 0);
                    return true;
                case 1:
                    c(message.arg1 != 0);
                    return true;
                case 2:
                    a();
                    return true;
                case 3:
                    b((j) message.obj);
                    return true;
                case 4:
                    a((s) message.obj);
                    return true;
                case 5:
                    a(true);
                    this.d.a(true);
                    a(1);
                    return true;
                case 6:
                    e();
                    return true;
                case 7:
                    a((Pair) message.obj);
                    return true;
                case 8:
                    a((com.fyber.inneractive.sdk.player.exoplayer2.source.s) message.obj);
                    return true;
                case 9:
                    com.fyber.inneractive.sdk.player.exoplayer2.source.s sVar = (com.fyber.inneractive.sdk.player.exoplayer2.source.s) message.obj;
                    h hVar = this.z;
                    if (hVar != null && hVar.f2102a == sVar) {
                        b();
                    }
                    return true;
                case 10:
                    f();
                    return true;
                case 11:
                    a((e[]) message.obj);
                    return true;
                default:
                    return false;
            }
        } catch (d e) {
            Log.e("ExoPlayerImplInternal", "Renderer error.", e);
            this.h.obtainMessage(8, e).sendToTarget();
            a(true);
            this.d.a(true);
            a(1);
            return true;
        } catch (IOException e2) {
            Log.e("ExoPlayerImplInternal", "Source error.", e2);
            this.h.obtainMessage(8, new d(e2)).sendToTarget();
            a(true);
            this.d.a(true);
            a(1);
            return true;
        } catch (RuntimeException e3) {
            Log.e("ExoPlayerImplInternal", "Internal runtime error.", e3);
            this.h.obtainMessage(8, new d(e3)).sendToTarget();
            a(true);
            this.d.a(true);
            a(1);
            return true;
        }
    }

    public final void b(j jVar) {
        if (this.C == null) {
            this.w++;
            this.x = jVar;
            return;
        }
        Pair pairA = a(jVar);
        if (pairA == null) {
            i iVar = new i(0, 0L);
            this.k = iVar;
            this.h.obtainMessage(4, 1, 0, iVar).sendToTarget();
            this.k = new i(0, -9223372036854775807L);
            a(4);
            a(false);
            return;
        }
        int i = jVar.c == -9223372036854775807L ? 1 : 0;
        int iIntValue = ((Integer) pairA.first).intValue();
        long jLongValue = ((Long) pairA.second).longValue();
        try {
            i iVar2 = this.k;
            if (iIntValue == iVar2.f2103a && jLongValue / 1000 == iVar2.c / 1000) {
                i iVar3 = new i(iIntValue, jLongValue);
                this.k = iVar3;
                this.h.obtainMessage(4, i, 0, iVar3).sendToTarget();
            } else {
                long jA = a(iIntValue, jLongValue);
                int i2 = i | (jLongValue == jA ? 0 : 1);
                i iVar4 = new i(iIntValue, jA);
                this.k = iVar4;
                this.h.obtainMessage(4, i2, 0, iVar4).sendToTarget();
            }
        } catch (Throwable th) {
            i iVar5 = new i(iIntValue, jLongValue);
            this.k = iVar5;
            this.h.obtainMessage(4, i, 0, iVar5).sendToTarget();
            throw th;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.t
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.source.x xVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.g gVar) {
        this.f.obtainMessage(7, Pair.create(xVar, gVar)).sendToTarget();
    }

    public final void a(int i) {
        if (this.u != i) {
            this.u = i;
            this.h.obtainMessage(1, i, 0).sendToTarget();
        }
    }

    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.source.u uVar, boolean z) {
        this.h.sendEmptyMessage(0);
        a(true);
        this.d.a(false);
        if (z) {
            this.k = new i(0, -9223372036854775807L);
        }
        this.o = uVar;
        uVar.a(this);
        a(2);
        this.f.sendEmptyMessage(2);
    }

    /* JADX WARN: Code duplicated, block: B:105:0x0215  */
    /* JADX WARN: Code duplicated, block: B:106:0x0217  */
    /* JADX WARN: Code duplicated, block: B:110:0x021e  */
    /* JADX WARN: Code duplicated, block: B:113:0x0229 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:114:0x022b  */
    /* JADX WARN: Code duplicated, block: B:115:0x022e  */
    /* JADX WARN: Code duplicated, block: B:117:0x0232  */
    /* JADX WARN: Code duplicated, block: B:129:0x027b  */
    /* JADX WARN: Code duplicated, block: B:190:0x0394  */
    /* JADX WARN: Code duplicated, block: B:191:0x0397  */
    /* JADX WARN: Code duplicated, block: B:206:0x03c3  */
    /* JADX WARN: Code duplicated, block: B:208:0x03ca  */
    /* JADX WARN: Code duplicated, block: B:210:0x03d3  */
    /* JADX WARN: Code duplicated, block: B:211:0x03dd  */
    /* JADX WARN: Code duplicated, block: B:214:0x03e4  */
    /* JADX WARN: Code duplicated, block: B:216:0x03ea A[LOOP:2: B:213:0x03e2->B:216:0x03ea, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:241:0x0438  */
    /* JADX WARN: Code duplicated, block: B:243:0x043e A[LOOP:1: B:242:0x043c->B:243:0x043e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:246:0x044c  */
    /* JADX WARN: Code duplicated, block: B:248:0x0450  */
    /* JADX WARN: Code duplicated, block: B:253:0x0460  */
    /* JADX WARN: Code duplicated, block: B:254:0x0466  */
    /* JADX WARN: Code duplicated, block: B:262:0x03f3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:265:0x0285 A[EDGE_INSN: B:265:0x0285->B:131:0x0285 BREAK  A[LOOP:4: B:79:0x01bd->B:88:0x01d6], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:271:0x01f6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:275:0x0285 A[EDGE_INSN: B:275:0x0285->B:131:0x0285 BREAK  A[LOOP:5: B:90:0x01da->B:98:0x01f3], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:279:0x027e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:281:0x027e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:0x0178  */
    /* JADX WARN: Code duplicated, block: B:71:0x0181 A[LOOP:3: B:71:0x0181->B:75:0x0191, LOOP_START] */
    /* JADX WARN: Code duplicated, block: B:78:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:81:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:89:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:92:0x01df  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [int] */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v78 */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [int] */
    /* JADX WARN: Type inference failed for: r5v51 */
    /* JADX WARN: Type inference failed for: r5v52 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9, types: [int] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void a() throws d {
        h hVar;
        int i;
        boolean z;
        boolean z2;
        h hVar2;
        h hVar3;
        h hVar4;
        ?? r5;
        a[] aVarArr;
        h hVar5;
        h hVar6;
        com.fyber.inneractive.sdk.player.exoplayer2.trackselection.j jVar;
        com.fyber.inneractive.sdk.player.exoplayer2.trackselection.j jVar2;
        boolean z3;
        ?? r1;
        a[] aVarArr2;
        a aVar;
        com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b bVar;
        a aVar2;
        com.fyber.inneractive.sdk.player.exoplayer2.source.v vVar;
        ?? r6;
        a[] aVarArr3;
        com.fyber.inneractive.sdk.player.exoplayer2.source.v vVar2;
        long j;
        int i2;
        h hVar7;
        int i3;
        h hVar8;
        com.fyber.inneractive.sdk.player.exoplayer2.util.u uVar;
        int i4;
        int i5;
        long jC;
        c cVar;
        long j2;
        a[] aVarArr4;
        int length;
        int i6;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (this.C == null) {
            this.o.a();
        } else {
            h hVar9 = this.z;
            if (hVar9 == null) {
                i = this.k.f2103a;
            } else {
                int i7 = hVar9.f;
                if (hVar9.h || !hVar9.i || ((hVar9.j && hVar9.f2102a.c() != Long.MIN_VALUE) || this.C.a(i7, this.j, false).d == -9223372036854775807L || ((hVar = this.B) != null && i7 - hVar.f == 100))) {
                    z2 = false;
                    z = true;
                } else {
                    i = this.z.f + 1;
                }
                hVar2 = this.z;
                if (hVar2 == null && (!hVar2.i || (hVar2.j && hVar2.f2102a.c() != Long.MIN_VALUE))) {
                    h hVar10 = this.z;
                    if (hVar10 != null && hVar10.l) {
                        b();
                    }
                } else {
                    b(z2);
                }
                if (this.B != null) {
                    while (true) {
                        hVar3 = this.B;
                        hVar4 = this.A;
                        if (hVar3 == hVar4 || this.y < hVar3.k.e) {
                            break;
                        }
                        hVar3.a();
                        a(this.B.k);
                        h hVar11 = this.B;
                        this.k = new i(hVar11.f, hVar11.g);
                        h();
                        this.h.obtainMessage(5, this.k).sendToTarget();
                    }
                    if (!hVar4.h) {
                        r5 = z2;
                        while (true) {
                            aVarArr = this.f2106a;
                            if (r5 < aVarArr.length) {
                                aVar2 = aVarArr[r5];
                                vVar = this.A.c[r5];
                                if (aVar2.d != vVar || (vVar != null && !aVar2.f)) {
                                    break;
                                } else {
                                    r5++;
                                }
                            } else {
                                hVar5 = this.A;
                                hVar6 = hVar5.k;
                                if (hVar6 != null || !hVar6.i) {
                                    break;
                                    break;
                                }
                                jVar = hVar5.m;
                                this.A = hVar6;
                                jVar2 = hVar6.m;
                                if (hVar6.f2102a.g() != -9223372036854775807L) {
                                    z3 = z ? 1 : 0;
                                } else {
                                    z3 = z2;
                                }
                                r1 = z2;
                                while (true) {
                                    aVarArr2 = this.f2106a;
                                    if (r1 < aVarArr2.length) {
                                        break;
                                    }
                                    aVar = aVarArr2[r1];
                                    if (jVar.b.b[r1] != null) {
                                        if (z3) {
                                            aVar.g = z;
                                        } else if (aVar.g) {
                                            continue;
                                        } else {
                                            bVar = jVar2.b.b[r1];
                                            t tVar = jVar.d[r1];
                                            t tVar2 = jVar2.d[r1];
                                            if (bVar == null && tVar2.equals(tVar)) {
                                                int length2 = bVar.c.length;
                                                o[] oVarArr = new o[length2];
                                                for (?? r15 = z2; r15 < length2; r15++) {
                                                    oVarArr[r15] = bVar.d[r15];
                                                }
                                                h hVar12 = this.A;
                                                com.fyber.inneractive.sdk.player.exoplayer2.source.v vVar3 = hVar12.c[r1];
                                                long j3 = hVar12.e - hVar12.g;
                                                if (!aVar.g) {
                                                    aVar.d = vVar3;
                                                    aVar.f = false;
                                                    aVar.e = j3;
                                                    aVar.a(oVarArr);
                                                } else {
                                                    throw new IllegalStateException();
                                                }
                                            } else {
                                                aVar.g = z;
                                            }
                                        }
                                    }
                                    z2 = false;
                                    z = true;
                                    r1++;
                                }
                            }
                        }
                    } else {
                        r6 = z2;
                        while (true) {
                            aVarArr3 = this.f2106a;
                            if (r6 < aVarArr3.length) {
                                break;
                            }
                            a aVar3 = aVarArr3[r6];
                            vVar2 = this.A.c[r6];
                            if (vVar2 == null && aVar3.d == vVar2 && aVar3.f) {
                                aVar3.g = z;
                            }
                            r6++;
                        }
                    }
                }
            }
            if (i >= this.C.a()) {
                this.o.a();
                z2 = false;
                z = true;
            } else {
                if (this.z == null) {
                    j = this.k.c;
                    z2 = false;
                    z = true;
                } else {
                    int i8 = this.C.a(i, this.j, false).c;
                    if (i != this.C.a(i8, this.i, 0L).c) {
                        z2 = false;
                        z = true;
                        j = 0;
                    } else {
                        h hVar13 = this.z;
                        z2 = false;
                        z = true;
                        Pair pairA = a(this.C, i8, -9223372036854775807L, Math.max(0L, ((hVar13.e - hVar13.g) + this.C.a(hVar13.f, this.j, false).d) - this.y));
                        if (pairA != null) {
                            int iIntValue = ((Integer) pairA.first).intValue();
                            long jLongValue = ((Long) pairA.second).longValue();
                            i = iIntValue;
                            j = jLongValue;
                        }
                    }
                }
                h hVar14 = this.z;
                long j4 = hVar14 == null ? j + 60000000 : (hVar14.e - hVar14.g) + this.C.a(hVar14.f, this.j, z2).d;
                this.C.a(i, this.j, z);
                h hVar15 = new h(this.f2106a, this.b, j4, this.c, this.d, this.o, this.j.b, i, (i != this.C.a() - (z ? 1 : 0) || this.C.a(this.j.c, this.i, 0L).b) ? z2 : z ? 1 : 0, j);
                h hVar16 = this.z;
                if (hVar16 != null) {
                    hVar16.k = hVar15;
                }
                this.z = hVar15;
                hVar15.f2102a.a(this);
                b(z);
            }
            hVar2 = this.z;
            if (hVar2 == null) {
                b(z2);
            } else {
                b(z2);
            }
            if (this.B != null) {
                while (true) {
                    hVar3 = this.B;
                    hVar4 = this.A;
                    if (hVar3 == hVar4) {
                        break;
                    }
                    break;
                    break;
                    hVar3.a();
                    a(this.B.k);
                    h hVar17 = this.B;
                    this.k = new i(hVar17.f, hVar17.g);
                    h();
                    this.h.obtainMessage(5, this.k).sendToTarget();
                }
                if (!hVar4.h) {
                    r6 = z2;
                    while (true) {
                        aVarArr3 = this.f2106a;
                        if (r6 < aVarArr3.length) {
                            break;
                            break;
                        }
                        a aVar4 = aVarArr3[r6];
                        vVar2 = this.A.c[r6];
                        if (vVar2 == null) {
                        }
                        r6++;
                    }
                } else {
                    r5 = z2;
                    while (true) {
                        aVarArr = this.f2106a;
                        if (r5 < aVarArr.length) {
                            aVar2 = aVarArr[r5];
                            vVar = this.A.c[r5];
                            if (aVar2.d != vVar) {
                                break;
                            }
                            break;
                            break;
                        }
                        hVar5 = this.A;
                        hVar6 = hVar5.k;
                        if (hVar6 != null) {
                            break;
                        }
                        jVar = hVar5.m;
                        this.A = hVar6;
                        jVar2 = hVar6.m;
                        if (hVar6.f2102a.g() != -9223372036854775807L) {
                            z3 = z ? 1 : 0;
                        } else {
                            z3 = z2;
                        }
                        r1 = z2;
                        while (true) {
                            aVarArr2 = this.f2106a;
                            if (r1 < aVarArr2.length) {
                                break;
                                break;
                            }
                            aVar = aVarArr2[r1];
                            if (jVar.b.b[r1] != null) {
                                if (z3) {
                                    aVar.g = z;
                                } else if (aVar.g) {
                                    bVar = jVar2.b.b[r1];
                                    t tVar3 = jVar.d[r1];
                                    t tVar4 = jVar2.d[r1];
                                    if (bVar == null) {
                                        aVar.g = z;
                                    } else {
                                        aVar.g = z;
                                    }
                                } else {
                                    continue;
                                }
                            }
                            z2 = false;
                            z = true;
                            r1++;
                        }
                        r5++;
                    }
                }
            }
        }
        if (this.B == null) {
            c();
            a(jElapsedRealtime, 10L);
            return;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.util.w.a("doSomeWork");
        h();
        com.fyber.inneractive.sdk.player.exoplayer2.source.s sVar = this.B.f2102a;
        long j5 = this.k.c;
        sVar.getClass();
        boolean z4 = true;
        boolean z5 = true;
        for (a aVar5 : this.p) {
            aVar5.a(this.y, this.v);
            z5 = z5 && aVar5.e();
            boolean z6 = aVar5.f() || aVar5.e();
            if (!z6) {
                aVar5.d.a();
            }
            z4 = z4 && z6;
        }
        if (!z4) {
            c();
        }
        com.fyber.inneractive.sdk.player.exoplayer2.util.h hVar18 = this.n;
        if (hVar18 != null) {
            s sVarA = hVar18.a();
            if (!sVarA.equals(this.l)) {
                this.l = sVarA;
                com.fyber.inneractive.sdk.player.exoplayer2.util.u uVar2 = this.e;
                com.fyber.inneractive.sdk.player.exoplayer2.util.h hVar19 = this.n;
                uVar2.getClass();
                uVar2.a(hVar19.b());
                uVar2.d = hVar19.a();
                this.h.obtainMessage(7, sVarA).sendToTarget();
            }
        }
        long j6 = this.C.a(this.B.f, this.j, false).d;
        if (z5 && ((j6 == -9223372036854775807L || j6 <= this.k.c) && this.B.h)) {
            a(4);
            g();
        } else {
            int i9 = this.u;
            if (i9 == 2) {
                if (this.p.length > 0) {
                    if (z4) {
                        boolean z7 = this.s;
                        h hVar20 = this.z;
                        if (!hVar20.i) {
                            jC = hVar20.g;
                        } else {
                            jC = hVar20.f2102a.c();
                        }
                        if (jC == Long.MIN_VALUE) {
                            h hVar21 = this.z;
                            if (!hVar21.h) {
                                jC = this.C.a(hVar21.f, this.j, false).d;
                                cVar = this.d;
                                h hVar22 = this.z;
                                long jAbs = jC - Math.abs(this.y - (hVar22.e - hVar22.g));
                                if (z7) {
                                    j2 = cVar.e;
                                } else {
                                    j2 = cVar.d;
                                }
                                if (j2 > 0 || jAbs >= j2) {
                                    a(3);
                                    if (this.r) {
                                        i2 = 0;
                                        this.s = false;
                                        uVar = this.e;
                                        if (uVar.f2189a) {
                                            i4 = 1;
                                        } else {
                                            uVar.c = SystemClock.elapsedRealtime();
                                            i4 = 1;
                                            uVar.f2189a = true;
                                        }
                                        for (a aVar6 : this.p) {
                                            if (aVar6.c == i4) {
                                                aVar6.c = 2;
                                                aVar6.i();
                                            } else {
                                                throw new IllegalStateException();
                                            }
                                        }
                                    }
                                }
                            } else {
                                a(3);
                                if (this.r) {
                                    i2 = 0;
                                    this.s = false;
                                    uVar = this.e;
                                    if (uVar.f2189a) {
                                        uVar.c = SystemClock.elapsedRealtime();
                                        i4 = 1;
                                        uVar.f2189a = true;
                                    } else {
                                        i4 = 1;
                                    }
                                    while (i5 < r4) {
                                        if (aVar6.c == i4) {
                                            aVar6.c = 2;
                                            aVar6.i();
                                        } else {
                                            throw new IllegalStateException();
                                        }
                                    }
                                }
                            }
                        } else {
                            cVar = this.d;
                            h hVar23 = this.z;
                            long jAbs2 = jC - Math.abs(this.y - (hVar23.e - hVar23.g));
                            if (z7) {
                                j2 = cVar.e;
                            } else {
                                j2 = cVar.d;
                            }
                            if (j2 > 0) {
                                a(3);
                                if (this.r) {
                                    i2 = 0;
                                    this.s = false;
                                    uVar = this.e;
                                    if (uVar.f2189a) {
                                        uVar.c = SystemClock.elapsedRealtime();
                                        i4 = 1;
                                        uVar.f2189a = true;
                                    } else {
                                        i4 = 1;
                                    }
                                    while (i5 < r4) {
                                        if (aVar6.c == i4) {
                                            aVar6.c = 2;
                                            aVar6.i();
                                        } else {
                                            throw new IllegalStateException();
                                        }
                                    }
                                }
                            } else {
                                a(3);
                                if (this.r) {
                                    i2 = 0;
                                    this.s = false;
                                    uVar = this.e;
                                    if (uVar.f2189a) {
                                        uVar.c = SystemClock.elapsedRealtime();
                                        i4 = 1;
                                        uVar.f2189a = true;
                                    } else {
                                        i4 = 1;
                                    }
                                    while (i5 < r4) {
                                        if (aVar6.c == i4) {
                                            aVar6.c = 2;
                                            aVar6.i();
                                        } else {
                                            throw new IllegalStateException();
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (this.u == i3) {
                        aVarArr4 = this.p;
                        length = aVarArr4.length;
                        for (i6 = i2; i6 < length; i6++) {
                            aVarArr4[i6].d.a();
                        }
                    }
                    if ((!this.r && this.u == 3) || this.u == 2) {
                        a(jElapsedRealtime, 10L);
                    } else if (this.p.length != 0) {
                        a(jElapsedRealtime, 1000L);
                    } else {
                        this.f.removeMessages(2);
                    }
                    com.fyber.inneractive.sdk.player.exoplayer2.util.w.a();
                }
                if (j6 == -9223372036854775807L || this.k.c < j6 || ((hVar8 = this.B.k) != null && hVar8.i)) {
                    a(3);
                    if (this.r) {
                        i2 = 0;
                        this.s = false;
                        uVar = this.e;
                        if (uVar.f2189a) {
                            uVar.c = SystemClock.elapsedRealtime();
                            i4 = 1;
                            uVar.f2189a = true;
                        } else {
                            i4 = 1;
                        }
                        while (i5 < r4) {
                            if (aVar6.c == i4) {
                                aVar6.c = 2;
                                aVar6.i();
                            } else {
                                throw new IllegalStateException();
                            }
                        }
                    }
                }
                i2 = 0;
            } else {
                i2 = 0;
                if (i9 == 3) {
                    if (!(this.p.length > 0 ? z4 : j6 == -9223372036854775807L || this.k.c < j6 || ((hVar7 = this.B.k) != null && hVar7.i))) {
                        this.s = this.r;
                        i3 = 2;
                        a(2);
                        g();
                    }
                }
                if (this.u == i3) {
                    aVarArr4 = this.p;
                    length = aVarArr4.length;
                    while (i6 < length) {
                        aVarArr4[i6].d.a();
                    }
                }
                if (!this.r) {
                    if (this.p.length != 0) {
                        a(jElapsedRealtime, 1000L);
                    } else {
                        this.f.removeMessages(2);
                    }
                } else if (this.p.length != 0) {
                    a(jElapsedRealtime, 1000L);
                } else {
                    this.f.removeMessages(2);
                }
                com.fyber.inneractive.sdk.player.exoplayer2.util.w.a();
            }
            i3 = 2;
            if (this.u == i3) {
                aVarArr4 = this.p;
                length = aVarArr4.length;
                while (i6 < length) {
                    aVarArr4[i6].d.a();
                }
            }
            if (!this.r) {
                if (this.p.length != 0) {
                    a(jElapsedRealtime, 1000L);
                } else {
                    this.f.removeMessages(2);
                }
            } else if (this.p.length != 0) {
                a(jElapsedRealtime, 1000L);
            } else {
                this.f.removeMessages(2);
            }
            com.fyber.inneractive.sdk.player.exoplayer2.util.w.a();
        }
        i3 = 2;
        i2 = 0;
        if (this.u == i3) {
            aVarArr4 = this.p;
            length = aVarArr4.length;
            while (i6 < length) {
                aVarArr4[i6].d.a();
            }
        }
        if (!this.r) {
            if (this.p.length != 0) {
                a(jElapsedRealtime, 1000L);
            } else {
                this.f.removeMessages(2);
            }
        } else if (this.p.length != 0) {
            a(jElapsedRealtime, 1000L);
        } else {
            this.f.removeMessages(2);
        }
        com.fyber.inneractive.sdk.player.exoplayer2.util.w.a();
    }

    public final void c() {
        h hVar = this.z;
        if (hVar == null || hVar.i) {
            return;
        }
        h hVar2 = this.A;
        if (hVar2 == null || hVar2.k == hVar) {
            for (a aVar : this.p) {
                if (!aVar.f) {
                    return;
                }
            }
            this.z.f2102a.d();
        }
    }

    public final void b() {
        char c;
        int i;
        h hVar = this.z;
        long jF = !hVar.i ? 0L : hVar.f2102a.f();
        if (jF == Long.MIN_VALUE) {
            b(false);
            return;
        }
        h hVar2 = this.z;
        long jAbs = Math.abs(this.y - (hVar2.e - hVar2.g));
        long j = jF - jAbs;
        c cVar = this.d;
        if (j > cVar.c) {
            c = 0;
        } else {
            c = j < cVar.b ? (char) 2 : (char) 1;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.l lVar = cVar.f1990a;
        synchronized (lVar) {
            i = lVar.c * 65536;
        }
        boolean z = c == 2 || (c == 1 && cVar.g && !(i >= cVar.f));
        cVar.g = z;
        b(z);
        if (z) {
            h hVar3 = this.z;
            hVar3.l = false;
            hVar3.f2102a.b(jAbs);
            return;
        }
        this.z.l = true;
    }

    public final void a(long j, long j2) {
        this.f.removeMessages(2);
        long jElapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
        if (jElapsedRealtime <= 0) {
            this.f.sendEmptyMessage(2);
        } else {
            this.f.sendEmptyMessageDelayed(2, jElapsedRealtime);
        }
    }

    public final long a(int i, long j) throws d {
        h hVar;
        g();
        this.s = false;
        a(2);
        h hVar2 = this.B;
        if (hVar2 == null) {
            h hVar3 = this.z;
            if (hVar3 != null) {
                hVar3.a();
            }
            hVar = null;
        } else {
            hVar = null;
            while (hVar2 != null) {
                if (hVar2.f == i && hVar2.i) {
                    hVar = hVar2;
                } else {
                    hVar2.a();
                }
                hVar2 = hVar2.k;
            }
        }
        h hVar4 = this.B;
        if (hVar4 != hVar || hVar4 != this.A) {
            for (a aVar : this.p) {
                aVar.c();
            }
            this.p = new a[0];
            this.n = null;
            this.m = null;
            this.B = null;
        }
        if (hVar != null) {
            hVar.k = null;
            this.z = hVar;
            this.A = hVar;
            a(hVar);
            h hVar5 = this.B;
            if (hVar5.j) {
                j = hVar5.f2102a.a(j);
            }
            a(j);
            b();
        } else {
            this.z = null;
            this.A = null;
            this.B = null;
            a(j);
        }
        this.f.sendEmptyMessage(2);
        return j;
    }

    public final void a(long j) {
        h hVar = this.B;
        long j2 = hVar == null ? j + 60000000 : j + (hVar.e - hVar.g);
        this.y = j2;
        this.e.a(j2);
        for (a aVar : this.p) {
            long j3 = this.y;
            aVar.g = false;
            aVar.f = false;
            aVar.a(false, j3);
        }
    }

    public final void a(s sVar) {
        s sVarA;
        com.fyber.inneractive.sdk.player.exoplayer2.util.h hVar = this.n;
        if (hVar != null) {
            sVarA = hVar.a(sVar);
        } else {
            sVarA = this.e.a(sVar);
        }
        this.l = sVarA;
        this.h.obtainMessage(7, sVarA).sendToTarget();
    }

    public final void a(boolean z) {
        this.f.removeMessages(2);
        this.s = false;
        com.fyber.inneractive.sdk.player.exoplayer2.util.u uVar = this.e;
        if (uVar.f2189a) {
            uVar.a(uVar.b());
            uVar.f2189a = false;
        }
        this.n = null;
        this.m = null;
        this.y = 60000000L;
        for (a aVar : this.p) {
            try {
                a(aVar);
                aVar.c();
            } catch (d | RuntimeException e) {
                Log.e("ExoPlayerImplInternal", "Stop failed.", e);
            }
        }
        this.p = new a[0];
        h hVar = this.B;
        if (hVar == null) {
            hVar = this.z;
        }
        while (hVar != null) {
            hVar.a();
            hVar = hVar.k;
        }
        this.z = null;
        this.A = null;
        this.B = null;
        b(false);
        if (z) {
            com.fyber.inneractive.sdk.player.exoplayer2.source.u uVar2 = this.o;
            if (uVar2 != null) {
                uVar2.b();
                this.o = null;
            }
            this.C = null;
        }
    }

    public final void a(e[] eVarArr) {
        try {
            for (e eVar : eVarArr) {
                eVar.f1996a.a(eVar.b, eVar.c);
            }
            if (this.o != null) {
                this.f.sendEmptyMessage(2);
            }
            synchronized (this) {
                notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this) {
                notifyAll();
                throw th;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x00cc  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [com.fyber.inneractive.sdk.player.exoplayer2.x] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2, types: [int] */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r12v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r16v0, types: [com.fyber.inneractive.sdk.player.exoplayer2.l] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.fyber.inneractive.sdk.player.exoplayer2.x] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void a(Pair pair) {
        ?? r10;
        x xVar = this.C;
        x xVar2 = (x) pair.first;
        this.C = xVar2;
        Object obj = pair.second;
        int i = 6;
        ?? r6 = 0;
        if (xVar != null) {
            r10 = r6;
        } else if (this.w > 0) {
            Pair pairA = a(this.x);
            int i2 = this.w;
            this.w = 0;
            this.x = null;
            if (pairA == null) {
                i iVar = new i(0, 0L);
                this.k = iVar;
                this.h.obtainMessage(6, new k(this.C, obj, iVar, i2)).sendToTarget();
                this.k = new i(0, -9223372036854775807L);
                a(4);
                a(false);
                return;
            }
            this.k = new i(((Integer) pairA.first).intValue(), ((Long) pairA.second).longValue());
            r10 = i2;
            i = 6;
            r6 = 0;
        } else {
            if (this.k.b == -9223372036854775807L) {
                if (xVar2.c()) {
                    i iVar2 = new i(0, 0L);
                    this.k = iVar2;
                    this.h.obtainMessage(6, new k(this.C, obj, iVar2, 0)).sendToTarget();
                    this.k = new i(0, -9223372036854775807L);
                    a(4);
                    a(false);
                    return;
                }
                Pair pairA2 = a(this.C, 0, -9223372036854775807L, 0L);
                this.k = new i(((Integer) pairA2.first).intValue(), ((Long) pairA2.second).longValue());
            }
            r10 = r6;
        }
        h hVar = this.B;
        if (hVar == null) {
            hVar = this.z;
        }
        h hVar2 = hVar;
        if (hVar2 == null) {
            this.h.obtainMessage(i, new k(this.C, obj, this.k, r10)).sendToTarget();
            return;
        }
        int iA = this.C.a(hVar2.b);
        if (iA == -1) {
            int i3 = hVar2.f;
            x xVar3 = this.C;
            int iA2 = -1;
            while (iA2 == -1 && i3 < xVar.a() - 1) {
                i3++;
                iA2 = xVar3.a(xVar.a(i3, this.j, true).b);
            }
            if (iA2 == -1) {
                i iVar3 = new i(r6, 0L);
                this.k = iVar3;
                this.h.obtainMessage(i, new k(this.C, obj, iVar3, r10)).sendToTarget();
                this.k = new i(r6, -9223372036854775807L);
                a(4);
                a(r6);
                return;
            }
            int i4 = this.C.a(iA2, this.j, r6).c;
            Pair pairA3 = a(this.C, 0, -9223372036854775807L, 0L);
            int iIntValue = ((Integer) pairA3.first).intValue();
            long jLongValue = ((Long) pairA3.second).longValue();
            this.C.a(iIntValue, this.j, true);
            Object obj2 = this.j.b;
            hVar2.f = -1;
            while (true) {
                hVar2 = hVar2.k;
                if (hVar2 != null) {
                    hVar2.f = hVar2.b.equals(obj2) ? iIntValue : -1;
                } else {
                    i iVar4 = new i(iIntValue, a(iIntValue, jLongValue));
                    this.k = iVar4;
                    this.h.obtainMessage(i, new k(this.C, obj, iVar4, r10)).sendToTarget();
                    return;
                }
            }
        } else {
            this.C.a(iA, this.j, r6);
            ?? r7 = (iA != this.C.a() - 1 || this.C.a(this.j.c, this.i, 0L).b) ? r6 : 1;
            hVar2.f = iA;
            hVar2.h = r7;
            ?? r8 = hVar2 == this.A ? 1 : r6;
            i iVar5 = this.k;
            if (iA != iVar5.f2103a) {
                i iVar6 = new i(iA, iVar5.b);
                iVar6.c = iVar5.c;
                this.k = iVar6;
            }
            while (true) {
                h hVar3 = hVar2.k;
                if (hVar3 == null) {
                    break;
                }
                iA++;
                this.C.a(iA, this.j, true);
                ?? r3 = (iA != this.C.a() - 1 || this.C.a(this.j.c, this.i, 0L).b) ? r6 : 1;
                if (!hVar3.b.equals(this.j.b)) {
                    if (r8 == 0) {
                        int i5 = this.B.f;
                        this.k = new i(i5, a(i5, this.k.c));
                        break;
                    }
                    this.z = hVar2;
                    hVar2.k = null;
                    while (hVar3 != null) {
                        hVar3.a();
                        hVar3 = hVar3.k;
                    }
                    break;
                }
                hVar3.f = iA;
                hVar3.h = r3;
                r8 |= hVar3 == this.A ? 1 : r6;
                hVar2 = hVar3;
            }
            this.h.obtainMessage(i, new k(this.C, obj, this.k, r10)).sendToTarget();
        }
    }

    public final Pair a(j jVar) {
        x xVar = jVar.f2104a;
        if (xVar.c()) {
            xVar = this.C;
        }
        try {
            Pair pairA = a(xVar, jVar.b, jVar.c, 0L);
            x xVar2 = this.C;
            if (xVar2 == xVar) {
                return pairA;
            }
            int iA = xVar2.a(xVar.a(((Integer) pairA.first).intValue(), this.j, true).b);
            if (iA != -1) {
                return Pair.create(Integer.valueOf(iA), (Long) pairA.second);
            }
            int iIntValue = ((Integer) pairA.first).intValue();
            x xVar3 = this.C;
            int iA2 = -1;
            while (iA2 == -1 && iIntValue < xVar.a() - 1) {
                iIntValue++;
                iA2 = xVar3.a(xVar.a(iIntValue, this.j, true).b);
            }
            if (iA2 == -1) {
                return null;
            }
            int i = this.C.a(iA2, this.j, false).c;
            return a(this.C, 0, -9223372036854775807L, 0L);
        } catch (IndexOutOfBoundsException unused) {
            throw new q();
        }
    }

    public final Pair a(x xVar, int i, long j, long j2) {
        int iB = xVar.b();
        if (i >= 0 && i < iB) {
            xVar.a(i, this.i, j2);
            if (j == -9223372036854775807L) {
                j = this.i.e;
                if (j == -9223372036854775807L) {
                    return null;
                }
            }
            w wVar = this.i;
            int i2 = wVar.c;
            long j3 = wVar.g + j;
            long j4 = xVar.a(i2, this.j, false).d;
            while (j4 != -9223372036854775807L && j3 >= j4 && i2 < this.i.d) {
                j3 -= j4;
                i2++;
                j4 = xVar.a(i2, this.j, false).d;
            }
            return Pair.create(Integer.valueOf(i2), Long.valueOf(j3));
        }
        throw new IndexOutOfBoundsException();
    }

    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.source.s sVar) throws d {
        com.fyber.inneractive.sdk.player.exoplayer2.source.s sVar2;
        h hVar = this.z;
        if (hVar == null || (sVar2 = hVar.f2102a) != sVar) {
            return;
        }
        hVar.i = true;
        com.fyber.inneractive.sdk.player.exoplayer2.trackselection.j jVarA = hVar.p.a(hVar.o, sVar2.a());
        com.fyber.inneractive.sdk.player.exoplayer2.trackselection.j jVar = hVar.s;
        if (jVar != null) {
            for (int i = 0; i < jVarA.b.f2143a; i++) {
                if (!jVarA.a(jVar, i)) {
                    hVar.m = jVarA;
                    break;
                }
            }
        } else {
            hVar.m = jVarA;
            break;
        }
        hVar.g = hVar.a(hVar.g, false, new boolean[hVar.n.length]);
        if (this.B == null) {
            h hVar2 = this.z;
            this.A = hVar2;
            a(hVar2.g);
            a(this.A);
        }
        b();
    }

    public final void a(h hVar) throws d {
        if (this.B == hVar) {
            return;
        }
        boolean[] zArr = new boolean[this.f2106a.length];
        int i = 0;
        int i2 = 0;
        while (true) {
            a[] aVarArr = this.f2106a;
            if (i < aVarArr.length) {
                a aVar = aVarArr[i];
                boolean z = aVar.c != 0;
                zArr[i] = z;
                com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b bVar = hVar.m.b.b[i];
                if (bVar != null) {
                    i2++;
                }
                if (z && (bVar == null || (aVar.g && aVar.d == this.B.c[i]))) {
                    if (aVar == this.m) {
                        com.fyber.inneractive.sdk.player.exoplayer2.util.u uVar = this.e;
                        com.fyber.inneractive.sdk.player.exoplayer2.util.h hVar2 = this.n;
                        uVar.getClass();
                        uVar.a(hVar2.b());
                        uVar.d = hVar2.a();
                        this.n = null;
                        this.m = null;
                    }
                    a(aVar);
                    aVar.c();
                }
                i++;
            } else {
                this.B = hVar;
                this.h.obtainMessage(3, hVar.m).sendToTarget();
                a(zArr, i2);
                return;
            }
        }
    }

    public final void a(boolean[] zArr, int i) throws d {
        int i2;
        this.p = new a[i];
        int i3 = 0;
        int i4 = 0;
        while (true) {
            a[] aVarArr = this.f2106a;
            if (i3 >= aVarArr.length) {
                return;
            }
            a aVar = aVarArr[i3];
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.j jVar = this.B.m;
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b bVar = jVar.b.b[i3];
            if (bVar != null) {
                int i5 = i4 + 1;
                this.p[i4] = aVar;
                if (aVar.c == 0) {
                    t tVar = jVar.d[i3];
                    boolean z = this.r && this.u == 3;
                    boolean z2 = !zArr[i3] && z;
                    int length = bVar.c.length;
                    o[] oVarArr = new o[length];
                    for (int i6 = 0; i6 < length; i6++) {
                        oVarArr[i6] = bVar.d[i6];
                    }
                    h hVar = this.B;
                    com.fyber.inneractive.sdk.player.exoplayer2.source.v vVar = hVar.c[i3];
                    long j = this.y;
                    i2 = i3;
                    long j2 = hVar.e - hVar.g;
                    if (aVar.c == 0) {
                        aVar.b = tVar;
                        aVar.c = 1;
                        aVar.h();
                        if (!aVar.g) {
                            aVar.d = vVar;
                            aVar.f = false;
                            aVar.e = j2;
                            aVar.a(oVarArr);
                            aVar.a(z2, j);
                            com.fyber.inneractive.sdk.player.exoplayer2.util.h hVarD = aVar.d();
                            if (hVarD != null) {
                                if (this.n == null) {
                                    this.n = hVarD;
                                    this.m = aVar;
                                    ((MediaCodecAudioRenderer) hVarD).Q.a(this.l);
                                } else {
                                    throw new d(new IllegalStateException("Multiple renderer media clocks enabled."));
                                }
                            }
                            if (z) {
                                if (aVar.c == 1) {
                                    aVar.c = 2;
                                    aVar.i();
                                } else {
                                    throw new IllegalStateException();
                                }
                            }
                        } else {
                            throw new IllegalStateException();
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                } else {
                    i2 = i3;
                }
                i4 = i5;
            } else {
                i2 = i3;
            }
            i3 = i2 + 1;
        }
    }
}
