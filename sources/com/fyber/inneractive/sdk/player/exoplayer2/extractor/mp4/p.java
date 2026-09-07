package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Stack;

/* JADX INFO: loaded from: classes11.dex */
public final class p implements com.fyber.inneractive.sdk.player.exoplayer2.extractor.i, com.fyber.inneractive.sdk.player.exoplayer2.extractor.q {
    public static final int p = z.a("qt  ");
    public int e;
    public int f;
    public long g;
    public int h;
    public com.fyber.inneractive.sdk.player.exoplayer2.util.n i;
    public int j;
    public int k;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.j l;
    public o[] m;
    public long n;
    public boolean o;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n c = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(16);
    public final Stack d = new Stack();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n f2047a = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(com.fyber.inneractive.sdk.player.exoplayer2.util.l.f2182a);
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n b = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(4);

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.q
    public final boolean a() {
        return true;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.q
    public final long c() {
        return this.n;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar) {
        return r.a(bVar, false);
    }

    /* JADX WARN: Code duplicated, block: B:129:0x0217 A[Catch: all -> 0x024c, TRY_LEAVE, TryCatch #0 {all -> 0x024c, blocks: (B:32:0x00aa, B:34:0x00ae, B:36:0x00bd, B:39:0x00d0, B:41:0x00d5, B:44:0x00dd, B:45:0x00e4, B:37:0x00c8, B:46:0x00ec, B:48:0x00f0, B:49:0x00f7, B:51:0x00fb, B:52:0x0102, B:54:0x0106, B:56:0x0111, B:58:0x0115, B:59:0x011d, B:61:0x0121, B:62:0x0127, B:64:0x012b, B:65:0x0132, B:67:0x0136, B:68:0x013d, B:70:0x0141, B:71:0x0148, B:73:0x014c, B:74:0x0153, B:76:0x0157, B:77:0x015e, B:79:0x0162, B:80:0x0169, B:82:0x016d, B:83:0x0175, B:85:0x0179, B:86:0x0182, B:88:0x0186, B:89:0x018d, B:91:0x0191, B:92:0x0199, B:94:0x019d, B:129:0x0217, B:95:0x01a3, B:97:0x01ab, B:98:0x01b1, B:100:0x01b5, B:103:0x01bb, B:105:0x01bf, B:108:0x01c5, B:110:0x01c9, B:111:0x01d1, B:113:0x01d5, B:114:0x01dd, B:116:0x01e1, B:117:0x01e9, B:119:0x01ed, B:120:0x01f5, B:122:0x01f9, B:123:0x0201, B:125:0x0205, B:126:0x020b, B:128:0x020f, B:131:0x0230, B:132:0x0238), top: B:405:0x00aa }] */
    /* JADX WARN: Code duplicated, block: B:194:0x03b2  */
    /* JADX WARN: Code duplicated, block: B:200:0x03c8  */
    /* JADX WARN: Code duplicated, block: B:203:0x03cd  */
    /* JADX WARN: Code duplicated, block: B:205:0x03fc A[ADDED_TO_REGION, LOOP:6: B:205:0x03fc->B:208:0x0404, LOOP_START, PHI: r9 r10 r25 r27
  0x03fc: PHI (r9v16 int) = (r9v14 int), (r9v21 int) binds: [B:204:0x03fa, B:208:0x0404] A[DONT_GENERATE, DONT_INLINE]
  0x03fc: PHI (r10v16 int) = (r10v14 int), (r10v20 int) binds: [B:204:0x03fa, B:208:0x0404] A[DONT_GENERATE, DONT_INLINE]
  0x03fc: PHI (r25v13 int) = (r25v12 int), (r25v16 int) binds: [B:204:0x03fa, B:208:0x0404] A[DONT_GENERATE, DONT_INLINE]
  0x03fc: PHI (r27v8 long) = (r27v7 long), (r27v10 long) binds: [B:204:0x03fa, B:208:0x0404] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:206:0x03fe  */
    /* JADX WARN: Code duplicated, block: B:208:0x0404 A[LOOP:6: B:205:0x03fc->B:208:0x0404, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:213:0x0421 A[ADDED_TO_REGION, LOOP:7: B:213:0x0421->B:215:0x0425, LOOP_START, PHI: r20 r21 r22
  0x0421: PHI (r20v13 int) = (r20v11 int), (r20v15 int) binds: [B:212:0x041f, B:215:0x0425] A[DONT_GENERATE, DONT_INLINE]
  0x0421: PHI (r21v13 int) = (r21v7 int), (r21v14 int) binds: [B:212:0x041f, B:215:0x0425] A[DONT_GENERATE, DONT_INLINE]
  0x0421: PHI (r22v21 int) = (r22v17 int), (r22v22 int) binds: [B:212:0x041f, B:215:0x0425] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:214:0x0423 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:219:0x043e  */
    /* JADX WARN: Code duplicated, block: B:220:0x0441  */
    /* JADX WARN: Code duplicated, block: B:223:0x044b  */
    /* JADX WARN: Code duplicated, block: B:224:0x044d  */
    /* JADX WARN: Code duplicated, block: B:227:0x0454  */
    /* JADX WARN: Code duplicated, block: B:229:0x045b  */
    /* JADX WARN: Code duplicated, block: B:232:0x046d A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:237:0x0499 A[ADDED_TO_REGION, LOOP:8: B:237:0x0499->B:240:0x04a1, LOOP_START, PHI: r22
  0x0499: PHI (r22v18 int) = (r22v17 int), (r22v19 int) binds: [B:236:0x0497, B:240:0x04a1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:238:0x049b  */
    /* JADX WARN: Code duplicated, block: B:240:0x04a1 A[LOOP:8: B:237:0x0499->B:240:0x04a1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:244:0x04af A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:249:0x04b9  */
    /* JADX WARN: Code duplicated, block: B:253:0x0509  */
    /* JADX WARN: Code duplicated, block: B:256:0x051d A[LOOP:14: B:254:0x0517->B:256:0x051d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:259:0x0534 A[LOOP:15: B:258:0x0532->B:259:0x0534, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:262:0x054f  */
    /* JADX WARN: Code duplicated, block: B:264:0x055d A[LOOP:17: B:263:0x055b->B:264:0x055d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:269:0x059d  */
    /* JADX WARN: Code duplicated, block: B:271:0x05a4  */
    /* JADX WARN: Code duplicated, block: B:276:0x05b1  */
    /* JADX WARN: Code duplicated, block: B:297:0x063a  */
    /* JADX WARN: Code duplicated, block: B:300:0x0641  */
    /* JADX WARN: Code duplicated, block: B:302:0x064b  */
    /* JADX WARN: Code duplicated, block: B:305:0x0650 A[LOOP:9: B:303:0x064d->B:305:0x0650, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:308:0x067e  */
    /* JADX WARN: Code duplicated, block: B:311:0x0685  */
    /* JADX WARN: Code duplicated, block: B:312:0x0687  */
    /* JADX WARN: Code duplicated, block: B:316:0x0693  */
    /* JADX WARN: Code duplicated, block: B:318:0x069b  */
    /* JADX WARN: Code duplicated, block: B:320:0x06bd  */
    /* JADX WARN: Code duplicated, block: B:321:0x06bf  */
    /* JADX WARN: Code duplicated, block: B:323:0x06c5  */
    /* JADX WARN: Code duplicated, block: B:327:0x06d8  */
    /* JADX WARN: Code duplicated, block: B:328:0x06da  */
    /* JADX WARN: Code duplicated, block: B:331:0x06de  */
    /* JADX WARN: Code duplicated, block: B:332:0x06e1  */
    /* JADX WARN: Code duplicated, block: B:334:0x06e5  */
    /* JADX WARN: Code duplicated, block: B:335:0x06e8  */
    /* JADX WARN: Code duplicated, block: B:337:0x06ec  */
    /* JADX WARN: Code duplicated, block: B:339:0x06f0  */
    /* JADX WARN: Code duplicated, block: B:340:0x06f3  */
    /* JADX WARN: Code duplicated, block: B:344:0x0701  */
    /* JADX WARN: Code duplicated, block: B:346:0x070b  */
    /* JADX WARN: Code duplicated, block: B:348:0x072c  */
    /* JADX WARN: Code duplicated, block: B:349:0x0742  */
    /* JADX WARN: Code duplicated, block: B:353:0x0754  */
    /* JADX WARN: Code duplicated, block: B:355:0x0777  */
    /* JADX WARN: Code duplicated, block: B:360:0x078b  */
    /* JADX WARN: Code duplicated, block: B:365:0x07b1 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:368:0x07b9  */
    /* JADX WARN: Code duplicated, block: B:369:0x07bb  */
    /* JADX WARN: Code duplicated, block: B:372:0x07c2  */
    /* JADX WARN: Code duplicated, block: B:375:0x07da  */
    /* JADX WARN: Code duplicated, block: B:411:0x0415 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:412:0x0503 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:413:0x04a7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:414:0x07d2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x00da  */
    /* JADX WARN: Code duplicated, block: B:434:0x047a A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:441:0x06d2 A[EDGE_INSN: B:441:0x06d2->B:325:0x06d2 BREAK  A[LOOP:10: B:314:0x068c->B:324:0x06c9], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:444:0x07a8 A[EDGE_INSN: B:444:0x07a8->B:362:0x07a8 BREAK  A[LOOP:11: B:342:0x06fc->B:361:0x0797], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:447:0x0788 A[EDGE_INSN: B:447:0x0788->B:359:0x0788 BREAK  A[LOOP:12: B:351:0x074e->B:358:0x077d], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:449:0x077d A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    public final void c(long j) throws com.fyber.inneractive.sdk.player.exoplayer2.r {
        com.fyber.inneractive.sdk.player.exoplayer2.metadata.b bVar;
        s sVarA;
        e hVar;
        a aVar;
        boolean z;
        long j2;
        int iM;
        int iM2;
        int iM3;
        long j3;
        boolean z2;
        s sVar;
        int i;
        int i2;
        long[] jArr;
        int[] iArr;
        int iB;
        long j4;
        int i3;
        int i4;
        int i5;
        long[] jArr2;
        int[] iArr2;
        long[] jArr3;
        int[] iArr3;
        int i6;
        int i7;
        int i8;
        int i9;
        long[] jArr4;
        int[] iArr4;
        int i10;
        long j5;
        long j6;
        int i11;
        int iMax;
        long[] jArr5;
        v vVar;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.m mVar;
        int[] iArr5;
        long[] jArr6;
        boolean z3;
        int i12;
        int i13;
        int i14;
        boolean z4;
        long[] jArr7;
        long[] jArr8;
        int[] iArr6;
        boolean z5;
        boolean z6;
        long[] jArr9;
        int[] iArr7;
        int[] iArr8;
        long[] jArr10;
        int i15;
        int i16;
        int i17;
        long j7;
        long[] jArr11;
        long[] jArr12;
        int[] iArr9;
        int i18;
        boolean z7;
        boolean z8;
        long j8;
        long j9;
        long[] jArr13;
        int[] iArr10;
        int[] iArr11;
        long[] jArr14;
        int[] iArr12;
        int iA;
        int iA2;
        int[] iArr13;
        int[] iArr14;
        long j10;
        int iA3;
        boolean z9;
        char c;
        int i19;
        v vVar2;
        long[] jArr15;
        int[] iArr15;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int iB2;
        int i26;
        long j11;
        int i27;
        int iM4;
        int iM5;
        long[] jArr16;
        int[] iArr16;
        int iB3;
        int i28;
        int i29;
        int iM6;
        s sVar2;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.m mVar2;
        ArrayList arrayList;
        int i30;
        com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.o oVarB;
        com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.o oVarA;
        int iJ;
        String str;
        p pVar = this;
        while (!pVar.d.isEmpty() && ((a) pVar.d.peek()).P0 == j) {
            a aVar2 = (a) pVar.d.pop();
            if (aVar2.f2035a == c.C) {
                ArrayList arrayList2 = new ArrayList();
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.m mVar3 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.m();
                b bVarC = aVar2.c(c.A0);
                int i31 = 12;
                if (bVarC != null) {
                    boolean z10 = pVar.o;
                    int i32 = i.f2040a;
                    if (z10) {
                        bVar = null;
                        break;
                    }
                    com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar = bVarC.P0;
                    nVar.e(8);
                    while (true) {
                        int i33 = nVar.c;
                        int i34 = nVar.b;
                        if (i33 - i34 >= 8) {
                            int iB4 = nVar.b();
                            if (nVar.b() == c.B0) {
                                nVar.e(i34);
                                int i35 = i34 + iB4;
                                nVar.e(nVar.b + i31);
                                while (true) {
                                    int i36 = nVar.b;
                                    if (i36 < i35) {
                                        int iB5 = nVar.b();
                                        if (nVar.b() == c.C0) {
                                            nVar.e(i36);
                                            int i37 = i36 + iB5;
                                            nVar.e(nVar.b + 8);
                                            ArrayList arrayList3 = new ArrayList();
                                            while (true) {
                                                int i38 = nVar.b;
                                                if (i38 >= i37) {
                                                    break;
                                                }
                                                int i39 = n.f2045a;
                                                int iB6 = nVar.b() + i38;
                                                int iB7 = nVar.b();
                                                int i40 = (iB7 >> 24) & 255;
                                                if (i40 == 169 || i40 == 65533) {
                                                    int i41 = 16777215 & iB7;
                                                    if (i41 == n.c) {
                                                        oVarB = n.a(iB7, nVar);
                                                    } else if (i41 == n.f2045a || i41 == n.b) {
                                                        oVarB = n.b(iB7, nVar, "TIT2");
                                                    } else if (i41 == n.h || i41 == n.i) {
                                                        oVarB = n.b(iB7, nVar, "TCOM");
                                                    } else if (i41 == n.d) {
                                                        oVarB = n.b(iB7, nVar, "TDRC");
                                                    } else if (i41 == n.e) {
                                                        oVarB = n.b(iB7, nVar, "TPE1");
                                                    } else if (i41 == n.f) {
                                                        oVarB = n.b(iB7, nVar, "TSSE");
                                                    } else if (i41 == n.g) {
                                                        oVarB = n.b(iB7, nVar, "TALB");
                                                    } else if (i41 == n.j) {
                                                        oVarB = n.b(iB7, nVar, "USLT");
                                                    } else if (i41 == n.k) {
                                                        oVarB = n.b(iB7, nVar, "TCON");
                                                    } else if (i41 == n.n) {
                                                        oVarB = n.b(iB7, nVar, "TIT1");
                                                    } else {
                                                        Log.d("MetadataUtil", "Skipped unknown metadata entry: " + c.a(iB7));
                                                        nVar.e(iB6);
                                                        oVarA = null;
                                                    }
                                                    oVarA = oVarB;
                                                    nVar.e(iB6);
                                                } else {
                                                    try {
                                                        if (iB7 == n.m) {
                                                            nVar.e(nVar.b + 4);
                                                            if (nVar.b() == c.F0) {
                                                                nVar.e(nVar.b + 8);
                                                                iJ = nVar.j();
                                                            } else {
                                                                Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
                                                                iJ = -1;
                                                            }
                                                            if (iJ > 0) {
                                                                String[] strArr = n.D;
                                                                if (iJ <= strArr.length) {
                                                                    str = strArr[iJ - 1];
                                                                } else {
                                                                    str = null;
                                                                }
                                                            } else {
                                                                str = null;
                                                            }
                                                            if (str != null) {
                                                                oVarA = new com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.s("TCON", null, str);
                                                            } else {
                                                                Log.w("MetadataUtil", "Failed to parse standard genre code");
                                                                oVarA = null;
                                                            }
                                                        } else {
                                                            if (iB7 == n.o) {
                                                                oVarB = n.a(iB7, nVar, "TPOS");
                                                            } else if (iB7 == n.p) {
                                                                oVarB = n.a(iB7, nVar, "TRCK");
                                                            } else if (iB7 == n.q) {
                                                                oVarB = n.a(iB7, "TBPM", nVar, true, false);
                                                            } else if (iB7 == n.r) {
                                                                oVarB = n.a(iB7, "TCMP", nVar, true, true);
                                                            } else if (iB7 == n.l) {
                                                                oVarA = n.a(nVar);
                                                            } else if (iB7 == n.s) {
                                                                oVarB = n.b(iB7, nVar, "TPE2");
                                                            } else if (iB7 == n.t) {
                                                                oVarB = n.b(iB7, nVar, "TSOT");
                                                            } else if (iB7 == n.u) {
                                                                oVarB = n.b(iB7, nVar, "TSO2");
                                                            } else if (iB7 == n.v) {
                                                                oVarB = n.b(iB7, nVar, "TSOA");
                                                            } else if (iB7 == n.w) {
                                                                oVarB = n.b(iB7, nVar, "TSOP");
                                                            } else if (iB7 == n.x) {
                                                                oVarB = n.b(iB7, nVar, "TSOC");
                                                            } else if (iB7 == n.y) {
                                                                oVarB = n.a(iB7, "ITUNESADVISORY", nVar, false, false);
                                                            } else if (iB7 == n.z) {
                                                                oVarB = n.a(iB7, "ITUNESGAPLESS", nVar, false, true);
                                                            } else if (iB7 == n.A) {
                                                                oVarB = n.b(iB7, nVar, "TVSHOWSORT");
                                                            } else if (iB7 == n.B) {
                                                                oVarB = n.b(iB7, nVar, "TVSHOW");
                                                            } else if (iB7 == n.C) {
                                                                oVarB = n.b(iB6, nVar);
                                                            } else {
                                                                Log.d("MetadataUtil", "Skipped unknown metadata entry: " + c.a(iB7));
                                                                nVar.e(iB6);
                                                                oVarA = null;
                                                            }
                                                            oVarA = oVarB;
                                                        }
                                                        nVar.e(iB6);
                                                    } catch (Throwable th) {
                                                        nVar.e(iB6);
                                                        throw th;
                                                    }
                                                }
                                                if (oVarA != null) {
                                                    arrayList3.add(oVarA);
                                                }
                                            }
                                            if (!arrayList3.isEmpty()) {
                                                bVar = new com.fyber.inneractive.sdk.player.exoplayer2.metadata.b(arrayList3);
                                                break;
                                            }
                                            break;
                                        }
                                        nVar.e(nVar.b + (iB5 - 8));
                                    }
                                }
                            } else {
                                nVar.e(nVar.b + (iB4 - 8));
                                i31 = 12;
                            }
                        }
                        bVar = null;
                        break;
                    }
                    if (bVar != null) {
                        mVar3.a(bVar);
                    }
                } else {
                    bVar = null;
                }
                long j12 = -9223372036854775807L;
                long j13 = Long.MAX_VALUE;
                int i42 = 0;
                while (i42 < aVar2.R0.size()) {
                    a aVar3 = (a) aVar2.R0.get(i42);
                    if (aVar3.f2035a == c.E && (sVarA = i.a(aVar3, aVar2.c(c.D), -9223372036854775807L, (com.fyber.inneractive.sdk.player.exoplayer2.drm.d) null, pVar.o)) != null) {
                        a aVarB = aVar3.b(c.F).b(c.G).b(c.H);
                        b bVarC2 = aVarB.c(c.q0);
                        if (bVarC2 != null) {
                            hVar = new g(bVarC2);
                        } else {
                            b bVarC3 = aVarB.c(c.r0);
                            if (bVarC3 == null) {
                                throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Track has no sample table size information");
                            }
                            hVar = new h(bVarC3);
                        }
                        int iA4 = hVar.a();
                        if (iA4 == 0) {
                            aVar = aVar2;
                            vVar = new v(new long[0], new int[0], 0, new long[0], new int[0]);
                            bVar = bVar;
                            arrayList2 = arrayList2;
                            mVar3 = mVar3;
                            j3 = j12;
                            i42 = i42;
                            j2 = j13;
                            sVar = sVarA;
                        } else {
                            aVar = aVar2;
                            b bVarC4 = aVarB.c(c.s0);
                            if (bVarC4 == null) {
                                bVarC4 = aVarB.c(c.t0);
                                z = true;
                            } else {
                                z = false;
                            }
                            com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar2 = bVarC4.P0;
                            com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar3 = aVarB.c(c.p0).P0;
                            j2 = j13;
                            com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar4 = aVarB.c(c.m0).P0;
                            b bVarC5 = aVarB.c(c.n0);
                            com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar5 = bVarC5 != null ? bVarC5.P0 : null;
                            b bVarC6 = aVarB.c(c.o0);
                            com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar6 = bVarC6 != null ? bVarC6.P0 : null;
                            d dVar = new d(nVar3, nVar2, z);
                            nVar4.e(12);
                            int iM7 = nVar4.m() - 1;
                            int iM8 = nVar4.m();
                            int iM9 = nVar4.m();
                            if (nVar6 != null) {
                                nVar6.e(12);
                                iM = nVar6.m();
                            } else {
                                iM = 0;
                            }
                            if (nVar5 != null) {
                                nVar5.e(12);
                                iM2 = nVar5.m();
                                if (iM2 > 0) {
                                    iM3 = nVar5.m() - 1;
                                } else {
                                    nVar5 = null;
                                }
                                if (hVar.c()) {
                                    j3 = j12;
                                    if (!"audio/raw".equals(sVarA.f.f) && iM7 == 0 && iM == 0 && iM2 == 0) {
                                        z2 = true;
                                    }
                                    if (z2) {
                                        sVar = sVarA;
                                        i = iA4;
                                        i2 = dVar.f2036a;
                                        jArr = new long[i2];
                                        iArr = new int[i2];
                                        while (dVar.a()) {
                                            int i43 = dVar.b;
                                            jArr[i43] = dVar.d;
                                            iArr[i43] = dVar.c;
                                        }
                                        iB = hVar.b();
                                        j4 = iM9;
                                        i3 = 8192 / iB;
                                        i5 = 0;
                                        for (i4 = 0; i4 < i2; i4++) {
                                            int i44 = iArr[i4];
                                            int i45 = z.f2192a;
                                            i5 += ((i44 + i3) - 1) / i3;
                                        }
                                        jArr2 = new long[i5];
                                        iArr2 = new int[i5];
                                        jArr3 = new long[i5];
                                        iArr3 = new int[i5];
                                        i6 = 0;
                                        i7 = 0;
                                        i8 = 0;
                                        i9 = 0;
                                        while (i6 < i2) {
                                            int i46 = iArr[i6];
                                            j6 = jArr[i6];
                                            long[] jArr17 = jArr;
                                            i11 = i46;
                                            int i47 = i2;
                                            iMax = i9;
                                            while (i11 > 0) {
                                                int iMin = Math.min(i3, i11);
                                                jArr2[i8] = j6;
                                                int[] iArr17 = iArr;
                                                int i48 = iB * iMin;
                                                iArr2[i8] = i48;
                                                iMax = Math.max(iMax, i48);
                                                jArr3[i8] = ((long) i7) * j4;
                                                iArr3[i8] = 1;
                                                j6 += (long) iArr2[i8];
                                                i7 += iMin;
                                                i11 -= iMin;
                                                i8++;
                                                iArr = iArr17;
                                                iB = iB;
                                            }
                                            i6++;
                                            i9 = iMax;
                                            i2 = i47;
                                            jArr = jArr17;
                                        }
                                        jArr4 = jArr2;
                                        iArr4 = iArr2;
                                        i10 = i9;
                                        j5 = 0;
                                    } else {
                                        jArr4 = new long[iA4];
                                        iArr4 = new int[iA4];
                                        jArr15 = new long[iA4];
                                        iArr15 = new int[iA4];
                                        i20 = iM9;
                                        i21 = iM2;
                                        i22 = iM3;
                                        i23 = iM7;
                                        i24 = 0;
                                        i25 = 0;
                                        iB2 = 0;
                                        i26 = 0;
                                        j11 = 0;
                                        j5 = 0;
                                        i27 = iM;
                                        iM4 = 0;
                                        iM5 = iM8;
                                        while (i24 < iA4) {
                                            while (i26 == 0) {
                                                if (dVar.a()) {
                                                    throw new IllegalStateException();
                                                }
                                                j11 = dVar.d;
                                                i26 = dVar.c;
                                                i20 = i20;
                                                i22 = i22;
                                            }
                                            int i49 = i20;
                                            int i50 = i22;
                                            if (nVar6 != null) {
                                                while (iM4 == 0 && i27 > 0) {
                                                    iM4 = nVar6.m();
                                                    iB2 = nVar6.b();
                                                    i27--;
                                                }
                                                iM4--;
                                            }
                                            int i51 = iB2;
                                            jArr4[i24] = j11;
                                            iB3 = hVar.b();
                                            iArr4[i24] = iB3;
                                            if (iB3 > i25) {
                                                i28 = iB3;
                                            } else {
                                                i28 = i25;
                                            }
                                            int i52 = iA4;
                                            jArr15[i24] = j5 + ((long) i51);
                                            if (nVar5 == null) {
                                                i29 = 1;
                                            } else {
                                                i29 = 0;
                                            }
                                            iArr15[i24] = i29;
                                            iM6 = i50;
                                            if (i24 == iM6) {
                                                iArr15[i24] = 1;
                                                i21--;
                                                if (i21 > 0) {
                                                    iM6 = nVar5.m() - 1;
                                                }
                                            }
                                            int[] iArr18 = iArr15;
                                            int iM10 = i49;
                                            long[] jArr18 = jArr15;
                                            j5 += (long) iM10;
                                            iM5--;
                                            if (iM5 != 0 && i23 > 0) {
                                                iM5 = nVar4.m();
                                                i23--;
                                                iM10 = nVar4.m();
                                            }
                                            j11 += (long) iArr4[i24];
                                            i26--;
                                            i24++;
                                            jArr15 = jArr18;
                                            iArr15 = iArr18;
                                            int i53 = i28;
                                            iB2 = i51;
                                            i20 = iM10;
                                            iA4 = i52;
                                            i22 = iM6;
                                            i25 = i53;
                                        }
                                        jArr16 = jArr15;
                                        iArr16 = iArr15;
                                        i = iA4;
                                        if (iM4 == 0) {
                                            throw new IllegalArgumentException();
                                        }
                                        while (i27 > 0) {
                                            if (nVar6.m() == 0) {
                                                throw new IllegalArgumentException();
                                            }
                                            nVar6.b();
                                            i27--;
                                        }
                                        if (i21 != 0 && iM5 == 0 && i26 == 0 && i23 == 0) {
                                            sVar = sVarA;
                                        } else {
                                            sVar = sVarA;
                                            Log.w("AtomParsers", "Inconsistent stbl box for track " + sVar.f2049a + ": remainingSynchronizationSamples " + i21 + ", remainingSamplesAtTimestampDelta " + iM5 + ", remainingSamplesInChunk " + i26 + ", remainingTimestampDeltaChanges " + i23);
                                        }
                                        iArr3 = iArr16;
                                        i10 = i25;
                                        jArr3 = jArr16;
                                    }
                                    jArr5 = sVar.i;
                                    if (jArr5 != null) {
                                        mVar = mVar3;
                                        if (mVar.f2023a != -1 || mVar.b == -1) {
                                            if (jArr5.length == 1 || sVar.b != 1 || jArr3.length < 2) {
                                                iArr5 = iArr4;
                                            } else {
                                                long j14 = sVar.j[0];
                                                iArr5 = iArr4;
                                                long jA = z.a(jArr5[0], sVar.c, sVar.d) + j14;
                                                long j15 = jArr3[0];
                                                if (j15 <= j14 && j14 < jArr3[1] && jArr3[jArr3.length - 1] < jA && jA <= j5) {
                                                    long j16 = j5 - jA;
                                                    long jA2 = z.a(j14 - j15, sVar.f.s, sVar.c);
                                                    long jA3 = z.a(j16, sVar.f.s, sVar.c);
                                                    if ((jA2 != 0 || jA3 != 0) && jA2 <= 2147483647L && jA3 <= 2147483647L) {
                                                        mVar.f2023a = (int) jA2;
                                                        mVar.b = (int) jA3;
                                                        z.a(jArr3, sVar.c);
                                                        vVar2 = new v(jArr4, iArr5, i10, jArr3, iArr3);
                                                    }
                                                    mVar3 = mVar;
                                                    vVar = vVar2;
                                                }
                                            }
                                            jArr6 = sVar.i;
                                            if (jArr6.length == 1) {
                                                c = 0;
                                                if (jArr6[0] == 0) {
                                                    i19 = 0;
                                                    while (i19 < jArr3.length) {
                                                        jArr3[i19] = z.a(jArr3[i19] - sVar.j[c], 1000000L, sVar.c);
                                                        i19++;
                                                        c = 0;
                                                    }
                                                    vVar2 = new v(jArr4, iArr5, i10, jArr3, iArr3);
                                                    mVar3 = mVar;
                                                    vVar = vVar2;
                                                }
                                            }
                                            if (sVar.b == 1) {
                                                z3 = true;
                                            } else {
                                                z3 = false;
                                            }
                                            i12 = 0;
                                            i13 = 0;
                                            i14 = 0;
                                            z4 = false;
                                            while (true) {
                                                jArr7 = sVar.i;
                                                if (i12 >= jArr7.length) {
                                                    break;
                                                }
                                                j10 = sVar.j[i12];
                                                if (j10 != -1) {
                                                    long jA4 = z.a(jArr7[i12], sVar.c, sVar.d);
                                                    iA3 = z.a(jArr3, j10, true, true);
                                                    int iA5 = z.a(jArr3, j10 + jA4, z3, false);
                                                    int i54 = (iA5 - iA3) + i13;
                                                    if (i14 != iA3) {
                                                        z9 = true;
                                                    } else {
                                                        z9 = false;
                                                    }
                                                    i14 = iA5;
                                                    z4 = z9 | z4;
                                                    i13 = i54;
                                                }
                                                i12++;
                                                jArr4 = jArr4;
                                                iArr5 = iArr5;
                                            }
                                            jArr8 = jArr4;
                                            iArr6 = iArr5;
                                            if (i13 != i) {
                                                z5 = true;
                                            } else {
                                                z5 = false;
                                            }
                                            z6 = z5 | z4;
                                            if (z6) {
                                                jArr9 = new long[i13];
                                            } else {
                                                jArr9 = jArr8;
                                            }
                                            if (z6) {
                                                iArr7 = new int[i13];
                                            } else {
                                                iArr7 = iArr6;
                                            }
                                            if (z6) {
                                                i10 = 0;
                                            }
                                            if (z6) {
                                                iArr8 = new int[i13];
                                            } else {
                                                iArr8 = iArr3;
                                            }
                                            jArr10 = new long[i13];
                                            i15 = i10;
                                            i16 = 0;
                                            i17 = 0;
                                            j7 = 0;
                                            while (true) {
                                                jArr11 = sVar.i;
                                                if (i16 >= jArr11.length) {
                                                    break;
                                                }
                                                j8 = sVar.j[i16];
                                                j9 = jArr11[i16];
                                                if (j8 != -1) {
                                                    jArr13 = jArr10;
                                                    iArr10 = iArr8;
                                                    iArr12 = iArr3;
                                                    long jA5 = z.a(j9, sVar.c, sVar.d) + j8;
                                                    iA = z.a(jArr3, j8, true, true);
                                                    iA2 = z.a(jArr3, jA5, z3, false);
                                                    if (z6) {
                                                        int i55 = iA2 - iA;
                                                        jArr14 = jArr8;
                                                        System.arraycopy(jArr14, iA, jArr9, i17, i55);
                                                        iArr14 = iArr6;
                                                        System.arraycopy(iArr14, iA, iArr7, i17, i55);
                                                        iArr13 = iArr12;
                                                        System.arraycopy(iArr13, iA, iArr10, i17, i55);
                                                    } else {
                                                        jArr14 = jArr8;
                                                        iArr13 = iArr12;
                                                        iArr14 = iArr6;
                                                    }
                                                    int i56 = i15;
                                                    while (true) {
                                                        iArr11 = iArr13;
                                                        iArr6 = iArr14;
                                                        if (iA >= iA2) {
                                                            break;
                                                        }
                                                        long j17 = j8;
                                                        jArr13[i17] = z.a(j7, 1000000L, sVar.d) + z.a(jArr3[iA] - j8, 1000000L, sVar.c);
                                                        if (!z6 && iArr7[i17] > i56) {
                                                            i56 = iArr6[iA];
                                                        }
                                                        i17++;
                                                        iA++;
                                                        j8 = j17;
                                                        iArr14 = iArr6;
                                                        iArr13 = iArr11;
                                                    }
                                                    i15 = i56;
                                                } else {
                                                    mVar = mVar;
                                                    jArr13 = jArr10;
                                                    iArr10 = iArr8;
                                                    iArr11 = iArr3;
                                                    jArr14 = jArr8;
                                                    z3 = z3;
                                                }
                                                j7 += j9;
                                                iArr8 = iArr10;
                                                jArr10 = jArr13;
                                                z3 = z3;
                                                iArr3 = iArr11;
                                                jArr8 = jArr14;
                                                i16++;
                                                mVar = mVar;
                                            }
                                            mVar3 = mVar;
                                            jArr12 = jArr10;
                                            iArr9 = iArr8;
                                            z7 = false;
                                            for (i18 = 0; i18 < iArr9.length && !z7; i18++) {
                                                if ((iArr9[i18] & 1) != 0) {
                                                    z8 = true;
                                                } else {
                                                    z8 = false;
                                                }
                                                z7 |= z8;
                                            }
                                            if (!z7) {
                                                throw new com.fyber.inneractive.sdk.player.exoplayer2.r("The edited sample sequence does not contain a sync sample.");
                                            }
                                            vVar = new v(jArr9, iArr7, i15, jArr12, iArr9);
                                        } else {
                                            mVar3 = mVar;
                                        }
                                    }
                                    z.a(jArr3, sVar.c);
                                    vVar = new v(jArr4, iArr4, i10, jArr3, iArr3);
                                } else {
                                    j3 = j12;
                                }
                                z2 = false;
                                if (z2) {
                                    jArr4 = new long[iA4];
                                    iArr4 = new int[iA4];
                                    jArr15 = new long[iA4];
                                    iArr15 = new int[iA4];
                                    i20 = iM9;
                                    i21 = iM2;
                                    i22 = iM3;
                                    i23 = iM7;
                                    i24 = 0;
                                    i25 = 0;
                                    iB2 = 0;
                                    i26 = 0;
                                    j11 = 0;
                                    j5 = 0;
                                    i27 = iM;
                                    iM4 = 0;
                                    iM5 = iM8;
                                    while (i24 < iA4) {
                                        while (i26 == 0) {
                                            if (dVar.a()) {
                                                throw new IllegalStateException();
                                            }
                                            j11 = dVar.d;
                                            i26 = dVar.c;
                                            i20 = i20;
                                            i22 = i22;
                                        }
                                        int i410 = i20;
                                        int i57 = i22;
                                        if (nVar6 != null) {
                                            while (iM4 == 0) {
                                                iM4 = nVar6.m();
                                                iB2 = nVar6.b();
                                                i27--;
                                            }
                                            iM4--;
                                        }
                                        int i58 = iB2;
                                        jArr4[i24] = j11;
                                        iB3 = hVar.b();
                                        iArr4[i24] = iB3;
                                        if (iB3 > i25) {
                                            i28 = iB3;
                                        } else {
                                            i28 = i25;
                                        }
                                        int i59 = iA4;
                                        jArr15[i24] = j5 + ((long) i58);
                                        if (nVar5 == null) {
                                            i29 = 1;
                                        } else {
                                            i29 = 0;
                                        }
                                        iArr15[i24] = i29;
                                        iM6 = i57;
                                        if (i24 == iM6) {
                                            iArr15[i24] = 1;
                                            i21--;
                                            if (i21 > 0) {
                                                iM6 = nVar5.m() - 1;
                                            }
                                        }
                                        int[] iArr19 = iArr15;
                                        int iM11 = i410;
                                        long[] jArr19 = jArr15;
                                        j5 += (long) iM11;
                                        iM5--;
                                        if (iM5 != 0) {
                                        }
                                        j11 += (long) iArr4[i24];
                                        i26--;
                                        i24++;
                                        jArr15 = jArr19;
                                        iArr15 = iArr19;
                                        int i510 = i28;
                                        iB2 = i58;
                                        i20 = iM11;
                                        iA4 = i59;
                                        i22 = iM6;
                                        i25 = i510;
                                    }
                                    jArr16 = jArr15;
                                    iArr16 = iArr15;
                                    i = iA4;
                                    if (iM4 == 0) {
                                        throw new IllegalArgumentException();
                                    }
                                    while (i27 > 0) {
                                        if (nVar6.m() == 0) {
                                            throw new IllegalArgumentException();
                                        }
                                        nVar6.b();
                                        i27--;
                                    }
                                    if (i21 != 0) {
                                        sVar = sVarA;
                                        Log.w("AtomParsers", "Inconsistent stbl box for track " + sVar.f2049a + ": remainingSynchronizationSamples " + i21 + ", remainingSamplesAtTimestampDelta " + iM5 + ", remainingSamplesInChunk " + i26 + ", remainingTimestampDeltaChanges " + i23);
                                    } else {
                                        sVar = sVarA;
                                        Log.w("AtomParsers", "Inconsistent stbl box for track " + sVar.f2049a + ": remainingSynchronizationSamples " + i21 + ", remainingSamplesAtTimestampDelta " + iM5 + ", remainingSamplesInChunk " + i26 + ", remainingTimestampDeltaChanges " + i23);
                                    }
                                    iArr3 = iArr16;
                                    i10 = i25;
                                    jArr3 = jArr16;
                                } else {
                                    sVar = sVarA;
                                    i = iA4;
                                    i2 = dVar.f2036a;
                                    jArr = new long[i2];
                                    iArr = new int[i2];
                                    while (dVar.a()) {
                                        int i411 = dVar.b;
                                        jArr[i411] = dVar.d;
                                        iArr[i411] = dVar.c;
                                    }
                                    iB = hVar.b();
                                    j4 = iM9;
                                    i3 = 8192 / iB;
                                    i5 = 0;
                                    while (i4 < i2) {
                                        int i412 = iArr[i4];
                                        int i413 = z.f2192a;
                                        i5 += ((i412 + i3) - 1) / i3;
                                    }
                                    jArr2 = new long[i5];
                                    iArr2 = new int[i5];
                                    jArr3 = new long[i5];
                                    iArr3 = new int[i5];
                                    i6 = 0;
                                    i7 = 0;
                                    i8 = 0;
                                    i9 = 0;
                                    while (i6 < i2) {
                                        int i414 = iArr[i6];
                                        j6 = jArr[i6];
                                        long[] jArr110 = jArr;
                                        i11 = i414;
                                        int i415 = i2;
                                        iMax = i9;
                                        while (i11 > 0) {
                                            int iMin2 = Math.min(i3, i11);
                                            jArr2[i8] = j6;
                                            int[] iArr110 = iArr;
                                            int i416 = iB * iMin2;
                                            iArr2[i8] = i416;
                                            iMax = Math.max(iMax, i416);
                                            jArr3[i8] = ((long) i7) * j4;
                                            iArr3[i8] = 1;
                                            j6 += (long) iArr2[i8];
                                            i7 += iMin2;
                                            i11 -= iMin2;
                                            i8++;
                                            iArr = iArr110;
                                            iB = iB;
                                        }
                                        i6++;
                                        i9 = iMax;
                                        i2 = i415;
                                        jArr = jArr110;
                                    }
                                    jArr4 = jArr2;
                                    iArr4 = iArr2;
                                    i10 = i9;
                                    j5 = 0;
                                }
                                jArr5 = sVar.i;
                                if (jArr5 != null) {
                                    mVar = mVar3;
                                    if (mVar.f2023a != -1) {
                                    }
                                    if (jArr5.length == 1) {
                                        iArr5 = iArr4;
                                        jArr6 = sVar.i;
                                        if (jArr6.length == 1) {
                                            c = 0;
                                            if (jArr6[0] == 0) {
                                                i19 = 0;
                                                while (i19 < jArr3.length) {
                                                    jArr3[i19] = z.a(jArr3[i19] - sVar.j[c], 1000000L, sVar.c);
                                                    i19++;
                                                    c = 0;
                                                }
                                                vVar2 = new v(jArr4, iArr5, i10, jArr3, iArr3);
                                            }
                                        }
                                        if (sVar.b == 1) {
                                            z3 = true;
                                        } else {
                                            z3 = false;
                                        }
                                        i12 = 0;
                                        i13 = 0;
                                        i14 = 0;
                                        z4 = false;
                                        while (true) {
                                            jArr7 = sVar.i;
                                            if (i12 >= jArr7.length) {
                                                break;
                                                break;
                                            }
                                            j10 = sVar.j[i12];
                                            if (j10 != -1) {
                                                long jA6 = z.a(jArr7[i12], sVar.c, sVar.d);
                                                iA3 = z.a(jArr3, j10, true, true);
                                                int iA6 = z.a(jArr3, j10 + jA6, z3, false);
                                                int i511 = (iA6 - iA3) + i13;
                                                if (i14 != iA3) {
                                                    z9 = true;
                                                } else {
                                                    z9 = false;
                                                }
                                                i14 = iA6;
                                                z4 = z9 | z4;
                                                i13 = i511;
                                            }
                                            i12++;
                                            jArr4 = jArr4;
                                            iArr5 = iArr5;
                                        }
                                        jArr8 = jArr4;
                                        iArr6 = iArr5;
                                        if (i13 != i) {
                                            z5 = true;
                                        } else {
                                            z5 = false;
                                        }
                                        z6 = z5 | z4;
                                        if (z6) {
                                            jArr9 = new long[i13];
                                        } else {
                                            jArr9 = jArr8;
                                        }
                                        if (z6) {
                                            iArr7 = new int[i13];
                                        } else {
                                            iArr7 = iArr6;
                                        }
                                        if (z6) {
                                            i10 = 0;
                                        }
                                        if (z6) {
                                            iArr8 = new int[i13];
                                        } else {
                                            iArr8 = iArr3;
                                        }
                                        jArr10 = new long[i13];
                                        i15 = i10;
                                        i16 = 0;
                                        i17 = 0;
                                        j7 = 0;
                                        while (true) {
                                            jArr11 = sVar.i;
                                            if (i16 >= jArr11.length) {
                                                break;
                                                break;
                                            }
                                            j8 = sVar.j[i16];
                                            j9 = jArr11[i16];
                                            if (j8 != -1) {
                                                jArr13 = jArr10;
                                                iArr10 = iArr8;
                                                iArr12 = iArr3;
                                                long jA7 = z.a(j9, sVar.c, sVar.d) + j8;
                                                iA = z.a(jArr3, j8, true, true);
                                                iA2 = z.a(jArr3, jA7, z3, false);
                                                if (z6) {
                                                    int i512 = iA2 - iA;
                                                    jArr14 = jArr8;
                                                    System.arraycopy(jArr14, iA, jArr9, i17, i512);
                                                    iArr14 = iArr6;
                                                    System.arraycopy(iArr14, iA, iArr7, i17, i512);
                                                    iArr13 = iArr12;
                                                    System.arraycopy(iArr13, iA, iArr10, i17, i512);
                                                } else {
                                                    jArr14 = jArr8;
                                                    iArr13 = iArr12;
                                                    iArr14 = iArr6;
                                                }
                                                int i513 = i15;
                                                while (true) {
                                                    iArr11 = iArr13;
                                                    iArr6 = iArr14;
                                                    if (iA >= iA2) {
                                                        break;
                                                        break;
                                                    }
                                                    long j18 = j8;
                                                    jArr13[i17] = z.a(j7, 1000000L, sVar.d) + z.a(jArr3[iA] - j8, 1000000L, sVar.c);
                                                    if (!z6) {
                                                    }
                                                    i17++;
                                                    iA++;
                                                    j8 = j18;
                                                    iArr14 = iArr6;
                                                    iArr13 = iArr11;
                                                }
                                                i15 = i513;
                                            } else {
                                                mVar = mVar;
                                                jArr13 = jArr10;
                                                iArr10 = iArr8;
                                                iArr11 = iArr3;
                                                jArr14 = jArr8;
                                                z3 = z3;
                                            }
                                            j7 += j9;
                                            iArr8 = iArr10;
                                            jArr10 = jArr13;
                                            z3 = z3;
                                            iArr3 = iArr11;
                                            jArr8 = jArr14;
                                            i16++;
                                            mVar = mVar;
                                        }
                                        mVar3 = mVar;
                                        jArr12 = jArr10;
                                        iArr9 = iArr8;
                                        z7 = false;
                                        while (i18 < iArr9.length) {
                                            if ((iArr9[i18] & 1) != 0) {
                                                z8 = true;
                                            } else {
                                                z8 = false;
                                            }
                                            z7 |= z8;
                                        }
                                        if (!z7) {
                                            throw new com.fyber.inneractive.sdk.player.exoplayer2.r("The edited sample sequence does not contain a sync sample.");
                                        }
                                        vVar = new v(jArr9, iArr7, i15, jArr12, iArr9);
                                    } else {
                                        iArr5 = iArr4;
                                        jArr6 = sVar.i;
                                        if (jArr6.length == 1) {
                                            c = 0;
                                            if (jArr6[0] == 0) {
                                                i19 = 0;
                                                while (i19 < jArr3.length) {
                                                    jArr3[i19] = z.a(jArr3[i19] - sVar.j[c], 1000000L, sVar.c);
                                                    i19++;
                                                    c = 0;
                                                }
                                                vVar2 = new v(jArr4, iArr5, i10, jArr3, iArr3);
                                            }
                                        }
                                        if (sVar.b == 1) {
                                            z3 = true;
                                        } else {
                                            z3 = false;
                                        }
                                        i12 = 0;
                                        i13 = 0;
                                        i14 = 0;
                                        z4 = false;
                                        while (true) {
                                            jArr7 = sVar.i;
                                            if (i12 >= jArr7.length) {
                                                break;
                                                break;
                                            }
                                            j10 = sVar.j[i12];
                                            if (j10 != -1) {
                                                long jA8 = z.a(jArr7[i12], sVar.c, sVar.d);
                                                iA3 = z.a(jArr3, j10, true, true);
                                                int iA7 = z.a(jArr3, j10 + jA8, z3, false);
                                                int i514 = (iA7 - iA3) + i13;
                                                if (i14 != iA3) {
                                                    z9 = true;
                                                } else {
                                                    z9 = false;
                                                }
                                                i14 = iA7;
                                                z4 = z9 | z4;
                                                i13 = i514;
                                            }
                                            i12++;
                                            jArr4 = jArr4;
                                            iArr5 = iArr5;
                                        }
                                        jArr8 = jArr4;
                                        iArr6 = iArr5;
                                        if (i13 != i) {
                                            z5 = true;
                                        } else {
                                            z5 = false;
                                        }
                                        z6 = z5 | z4;
                                        if (z6) {
                                            jArr9 = new long[i13];
                                        } else {
                                            jArr9 = jArr8;
                                        }
                                        if (z6) {
                                            iArr7 = new int[i13];
                                        } else {
                                            iArr7 = iArr6;
                                        }
                                        if (z6) {
                                            i10 = 0;
                                        }
                                        if (z6) {
                                            iArr8 = new int[i13];
                                        } else {
                                            iArr8 = iArr3;
                                        }
                                        jArr10 = new long[i13];
                                        i15 = i10;
                                        i16 = 0;
                                        i17 = 0;
                                        j7 = 0;
                                        while (true) {
                                            jArr11 = sVar.i;
                                            if (i16 >= jArr11.length) {
                                                break;
                                                break;
                                            }
                                            j8 = sVar.j[i16];
                                            j9 = jArr11[i16];
                                            if (j8 != -1) {
                                                jArr13 = jArr10;
                                                iArr10 = iArr8;
                                                iArr12 = iArr3;
                                                long jA9 = z.a(j9, sVar.c, sVar.d) + j8;
                                                iA = z.a(jArr3, j8, true, true);
                                                iA2 = z.a(jArr3, jA9, z3, false);
                                                if (z6) {
                                                    int i515 = iA2 - iA;
                                                    jArr14 = jArr8;
                                                    System.arraycopy(jArr14, iA, jArr9, i17, i515);
                                                    iArr14 = iArr6;
                                                    System.arraycopy(iArr14, iA, iArr7, i17, i515);
                                                    iArr13 = iArr12;
                                                    System.arraycopy(iArr13, iA, iArr10, i17, i515);
                                                } else {
                                                    jArr14 = jArr8;
                                                    iArr13 = iArr12;
                                                    iArr14 = iArr6;
                                                }
                                                int i516 = i15;
                                                while (true) {
                                                    iArr11 = iArr13;
                                                    iArr6 = iArr14;
                                                    if (iA >= iA2) {
                                                        break;
                                                        break;
                                                    }
                                                    long j19 = j8;
                                                    jArr13[i17] = z.a(j7, 1000000L, sVar.d) + z.a(jArr3[iA] - j8, 1000000L, sVar.c);
                                                    if (!z6) {
                                                    }
                                                    i17++;
                                                    iA++;
                                                    j8 = j19;
                                                    iArr14 = iArr6;
                                                    iArr13 = iArr11;
                                                }
                                                i15 = i516;
                                            } else {
                                                mVar = mVar;
                                                jArr13 = jArr10;
                                                iArr10 = iArr8;
                                                iArr11 = iArr3;
                                                jArr14 = jArr8;
                                                z3 = z3;
                                            }
                                            j7 += j9;
                                            iArr8 = iArr10;
                                            jArr10 = jArr13;
                                            z3 = z3;
                                            iArr3 = iArr11;
                                            jArr8 = jArr14;
                                            i16++;
                                            mVar = mVar;
                                        }
                                        mVar3 = mVar;
                                        jArr12 = jArr10;
                                        iArr9 = iArr8;
                                        z7 = false;
                                        while (i18 < iArr9.length) {
                                            if ((iArr9[i18] & 1) != 0) {
                                                z8 = true;
                                            } else {
                                                z8 = false;
                                            }
                                            z7 |= z8;
                                        }
                                        if (!z7) {
                                            throw new com.fyber.inneractive.sdk.player.exoplayer2.r("The edited sample sequence does not contain a sync sample.");
                                        }
                                        vVar = new v(jArr9, iArr7, i15, jArr12, iArr9);
                                    }
                                    mVar3 = mVar;
                                    vVar = vVar2;
                                }
                                z.a(jArr3, sVar.c);
                                vVar = new v(jArr4, iArr4, i10, jArr3, iArr3);
                            } else {
                                iM2 = 0;
                            }
                            iM3 = -1;
                            if (hVar.c()) {
                                j3 = j12;
                                if (!"audio/raw".equals(sVarA.f.f)) {
                                }
                                if (z2) {
                                    jArr4 = new long[iA4];
                                    iArr4 = new int[iA4];
                                    jArr15 = new long[iA4];
                                    iArr15 = new int[iA4];
                                    i20 = iM9;
                                    i21 = iM2;
                                    i22 = iM3;
                                    i23 = iM7;
                                    i24 = 0;
                                    i25 = 0;
                                    iB2 = 0;
                                    i26 = 0;
                                    j11 = 0;
                                    j5 = 0;
                                    i27 = iM;
                                    iM4 = 0;
                                    iM5 = iM8;
                                    while (i24 < iA4) {
                                        while (i26 == 0) {
                                            if (dVar.a()) {
                                                throw new IllegalStateException();
                                            }
                                            j11 = dVar.d;
                                            i26 = dVar.c;
                                            i20 = i20;
                                            i22 = i22;
                                        }
                                        int i417 = i20;
                                        int i517 = i22;
                                        if (nVar6 != null) {
                                            while (iM4 == 0) {
                                                iM4 = nVar6.m();
                                                iB2 = nVar6.b();
                                                i27--;
                                            }
                                            iM4--;
                                        }
                                        int i518 = iB2;
                                        jArr4[i24] = j11;
                                        iB3 = hVar.b();
                                        iArr4[i24] = iB3;
                                        if (iB3 > i25) {
                                            i28 = iB3;
                                        } else {
                                            i28 = i25;
                                        }
                                        int i519 = iA4;
                                        jArr15[i24] = j5 + ((long) i518);
                                        if (nVar5 == null) {
                                            i29 = 1;
                                        } else {
                                            i29 = 0;
                                        }
                                        iArr15[i24] = i29;
                                        iM6 = i517;
                                        if (i24 == iM6) {
                                            iArr15[i24] = 1;
                                            i21--;
                                            if (i21 > 0) {
                                                iM6 = nVar5.m() - 1;
                                            }
                                        }
                                        int[] iArr111 = iArr15;
                                        int iM12 = i417;
                                        long[] jArr111 = jArr15;
                                        j5 += (long) iM12;
                                        iM5--;
                                        if (iM5 != 0) {
                                        }
                                        j11 += (long) iArr4[i24];
                                        i26--;
                                        i24++;
                                        jArr15 = jArr111;
                                        iArr15 = iArr111;
                                        int i5110 = i28;
                                        iB2 = i518;
                                        i20 = iM12;
                                        iA4 = i519;
                                        i22 = iM6;
                                        i25 = i5110;
                                    }
                                    jArr16 = jArr15;
                                    iArr16 = iArr15;
                                    i = iA4;
                                    if (iM4 == 0) {
                                        throw new IllegalArgumentException();
                                    }
                                    while (i27 > 0) {
                                        if (nVar6.m() == 0) {
                                            throw new IllegalArgumentException();
                                        }
                                        nVar6.b();
                                        i27--;
                                    }
                                    if (i21 != 0) {
                                        sVar = sVarA;
                                        Log.w("AtomParsers", "Inconsistent stbl box for track " + sVar.f2049a + ": remainingSynchronizationSamples " + i21 + ", remainingSamplesAtTimestampDelta " + iM5 + ", remainingSamplesInChunk " + i26 + ", remainingTimestampDeltaChanges " + i23);
                                    } else {
                                        sVar = sVarA;
                                        Log.w("AtomParsers", "Inconsistent stbl box for track " + sVar.f2049a + ": remainingSynchronizationSamples " + i21 + ", remainingSamplesAtTimestampDelta " + iM5 + ", remainingSamplesInChunk " + i26 + ", remainingTimestampDeltaChanges " + i23);
                                    }
                                    iArr3 = iArr16;
                                    i10 = i25;
                                    jArr3 = jArr16;
                                } else {
                                    sVar = sVarA;
                                    i = iA4;
                                    i2 = dVar.f2036a;
                                    jArr = new long[i2];
                                    iArr = new int[i2];
                                    while (dVar.a()) {
                                        int i418 = dVar.b;
                                        jArr[i418] = dVar.d;
                                        iArr[i418] = dVar.c;
                                    }
                                    iB = hVar.b();
                                    j4 = iM9;
                                    i3 = 8192 / iB;
                                    i5 = 0;
                                    while (i4 < i2) {
                                        int i419 = iArr[i4];
                                        int i4110 = z.f2192a;
                                        i5 += ((i419 + i3) - 1) / i3;
                                    }
                                    jArr2 = new long[i5];
                                    iArr2 = new int[i5];
                                    jArr3 = new long[i5];
                                    iArr3 = new int[i5];
                                    i6 = 0;
                                    i7 = 0;
                                    i8 = 0;
                                    i9 = 0;
                                    while (i6 < i2) {
                                        int i4111 = iArr[i6];
                                        j6 = jArr[i6];
                                        long[] jArr112 = jArr;
                                        i11 = i4111;
                                        int i4112 = i2;
                                        iMax = i9;
                                        while (i11 > 0) {
                                            int iMin3 = Math.min(i3, i11);
                                            jArr2[i8] = j6;
                                            int[] iArr112 = iArr;
                                            int i4113 = iB * iMin3;
                                            iArr2[i8] = i4113;
                                            iMax = Math.max(iMax, i4113);
                                            jArr3[i8] = ((long) i7) * j4;
                                            iArr3[i8] = 1;
                                            j6 += (long) iArr2[i8];
                                            i7 += iMin3;
                                            i11 -= iMin3;
                                            i8++;
                                            iArr = iArr112;
                                            iB = iB;
                                        }
                                        i6++;
                                        i9 = iMax;
                                        i2 = i4112;
                                        jArr = jArr112;
                                    }
                                    jArr4 = jArr2;
                                    iArr4 = iArr2;
                                    i10 = i9;
                                    j5 = 0;
                                }
                                jArr5 = sVar.i;
                                if (jArr5 != null) {
                                    mVar = mVar3;
                                    if (mVar.f2023a != -1) {
                                    }
                                    if (jArr5.length == 1) {
                                        iArr5 = iArr4;
                                        jArr6 = sVar.i;
                                        if (jArr6.length == 1) {
                                            c = 0;
                                            if (jArr6[0] == 0) {
                                                i19 = 0;
                                                while (i19 < jArr3.length) {
                                                    jArr3[i19] = z.a(jArr3[i19] - sVar.j[c], 1000000L, sVar.c);
                                                    i19++;
                                                    c = 0;
                                                }
                                                vVar2 = new v(jArr4, iArr5, i10, jArr3, iArr3);
                                            }
                                        }
                                        if (sVar.b == 1) {
                                            z3 = true;
                                        } else {
                                            z3 = false;
                                        }
                                        i12 = 0;
                                        i13 = 0;
                                        i14 = 0;
                                        z4 = false;
                                        while (true) {
                                            jArr7 = sVar.i;
                                            if (i12 >= jArr7.length) {
                                                break;
                                                break;
                                            }
                                            j10 = sVar.j[i12];
                                            if (j10 != -1) {
                                                long jA10 = z.a(jArr7[i12], sVar.c, sVar.d);
                                                iA3 = z.a(jArr3, j10, true, true);
                                                int iA8 = z.a(jArr3, j10 + jA10, z3, false);
                                                int i5111 = (iA8 - iA3) + i13;
                                                if (i14 != iA3) {
                                                    z9 = true;
                                                } else {
                                                    z9 = false;
                                                }
                                                i14 = iA8;
                                                z4 = z9 | z4;
                                                i13 = i5111;
                                            }
                                            i12++;
                                            jArr4 = jArr4;
                                            iArr5 = iArr5;
                                        }
                                        jArr8 = jArr4;
                                        iArr6 = iArr5;
                                        if (i13 != i) {
                                            z5 = true;
                                        } else {
                                            z5 = false;
                                        }
                                        z6 = z5 | z4;
                                        if (z6) {
                                            jArr9 = new long[i13];
                                        } else {
                                            jArr9 = jArr8;
                                        }
                                        if (z6) {
                                            iArr7 = new int[i13];
                                        } else {
                                            iArr7 = iArr6;
                                        }
                                        if (z6) {
                                            i10 = 0;
                                        }
                                        if (z6) {
                                            iArr8 = new int[i13];
                                        } else {
                                            iArr8 = iArr3;
                                        }
                                        jArr10 = new long[i13];
                                        i15 = i10;
                                        i16 = 0;
                                        i17 = 0;
                                        j7 = 0;
                                        while (true) {
                                            jArr11 = sVar.i;
                                            if (i16 >= jArr11.length) {
                                                break;
                                                break;
                                            }
                                            j8 = sVar.j[i16];
                                            j9 = jArr11[i16];
                                            if (j8 != -1) {
                                                jArr13 = jArr10;
                                                iArr10 = iArr8;
                                                iArr12 = iArr3;
                                                long jA11 = z.a(j9, sVar.c, sVar.d) + j8;
                                                iA = z.a(jArr3, j8, true, true);
                                                iA2 = z.a(jArr3, jA11, z3, false);
                                                if (z6) {
                                                    int i5112 = iA2 - iA;
                                                    jArr14 = jArr8;
                                                    System.arraycopy(jArr14, iA, jArr9, i17, i5112);
                                                    iArr14 = iArr6;
                                                    System.arraycopy(iArr14, iA, iArr7, i17, i5112);
                                                    iArr13 = iArr12;
                                                    System.arraycopy(iArr13, iA, iArr10, i17, i5112);
                                                } else {
                                                    jArr14 = jArr8;
                                                    iArr13 = iArr12;
                                                    iArr14 = iArr6;
                                                }
                                                int i5113 = i15;
                                                while (true) {
                                                    iArr11 = iArr13;
                                                    iArr6 = iArr14;
                                                    if (iA >= iA2) {
                                                        break;
                                                        break;
                                                    }
                                                    long j110 = j8;
                                                    jArr13[i17] = z.a(j7, 1000000L, sVar.d) + z.a(jArr3[iA] - j8, 1000000L, sVar.c);
                                                    if (!z6) {
                                                    }
                                                    i17++;
                                                    iA++;
                                                    j8 = j110;
                                                    iArr14 = iArr6;
                                                    iArr13 = iArr11;
                                                }
                                                i15 = i5113;
                                            } else {
                                                mVar = mVar;
                                                jArr13 = jArr10;
                                                iArr10 = iArr8;
                                                iArr11 = iArr3;
                                                jArr14 = jArr8;
                                                z3 = z3;
                                            }
                                            j7 += j9;
                                            iArr8 = iArr10;
                                            jArr10 = jArr13;
                                            z3 = z3;
                                            iArr3 = iArr11;
                                            jArr8 = jArr14;
                                            i16++;
                                            mVar = mVar;
                                        }
                                        mVar3 = mVar;
                                        jArr12 = jArr10;
                                        iArr9 = iArr8;
                                        z7 = false;
                                        while (i18 < iArr9.length) {
                                            if ((iArr9[i18] & 1) != 0) {
                                                z8 = true;
                                            } else {
                                                z8 = false;
                                            }
                                            z7 |= z8;
                                        }
                                        if (!z7) {
                                            throw new com.fyber.inneractive.sdk.player.exoplayer2.r("The edited sample sequence does not contain a sync sample.");
                                        }
                                        vVar = new v(jArr9, iArr7, i15, jArr12, iArr9);
                                    } else {
                                        iArr5 = iArr4;
                                        jArr6 = sVar.i;
                                        if (jArr6.length == 1) {
                                            c = 0;
                                            if (jArr6[0] == 0) {
                                                i19 = 0;
                                                while (i19 < jArr3.length) {
                                                    jArr3[i19] = z.a(jArr3[i19] - sVar.j[c], 1000000L, sVar.c);
                                                    i19++;
                                                    c = 0;
                                                }
                                                vVar2 = new v(jArr4, iArr5, i10, jArr3, iArr3);
                                            }
                                        }
                                        if (sVar.b == 1) {
                                            z3 = true;
                                        } else {
                                            z3 = false;
                                        }
                                        i12 = 0;
                                        i13 = 0;
                                        i14 = 0;
                                        z4 = false;
                                        while (true) {
                                            jArr7 = sVar.i;
                                            if (i12 >= jArr7.length) {
                                                break;
                                                break;
                                            }
                                            j10 = sVar.j[i12];
                                            if (j10 != -1) {
                                                long jA12 = z.a(jArr7[i12], sVar.c, sVar.d);
                                                iA3 = z.a(jArr3, j10, true, true);
                                                int iA9 = z.a(jArr3, j10 + jA12, z3, false);
                                                int i5114 = (iA9 - iA3) + i13;
                                                if (i14 != iA3) {
                                                    z9 = true;
                                                } else {
                                                    z9 = false;
                                                }
                                                i14 = iA9;
                                                z4 = z9 | z4;
                                                i13 = i5114;
                                            }
                                            i12++;
                                            jArr4 = jArr4;
                                            iArr5 = iArr5;
                                        }
                                        jArr8 = jArr4;
                                        iArr6 = iArr5;
                                        if (i13 != i) {
                                            z5 = true;
                                        } else {
                                            z5 = false;
                                        }
                                        z6 = z5 | z4;
                                        if (z6) {
                                            jArr9 = new long[i13];
                                        } else {
                                            jArr9 = jArr8;
                                        }
                                        if (z6) {
                                            iArr7 = new int[i13];
                                        } else {
                                            iArr7 = iArr6;
                                        }
                                        if (z6) {
                                            i10 = 0;
                                        }
                                        if (z6) {
                                            iArr8 = new int[i13];
                                        } else {
                                            iArr8 = iArr3;
                                        }
                                        jArr10 = new long[i13];
                                        i15 = i10;
                                        i16 = 0;
                                        i17 = 0;
                                        j7 = 0;
                                        while (true) {
                                            jArr11 = sVar.i;
                                            if (i16 >= jArr11.length) {
                                                break;
                                                break;
                                            }
                                            j8 = sVar.j[i16];
                                            j9 = jArr11[i16];
                                            if (j8 != -1) {
                                                jArr13 = jArr10;
                                                iArr10 = iArr8;
                                                iArr12 = iArr3;
                                                long jA13 = z.a(j9, sVar.c, sVar.d) + j8;
                                                iA = z.a(jArr3, j8, true, true);
                                                iA2 = z.a(jArr3, jA13, z3, false);
                                                if (z6) {
                                                    int i5115 = iA2 - iA;
                                                    jArr14 = jArr8;
                                                    System.arraycopy(jArr14, iA, jArr9, i17, i5115);
                                                    iArr14 = iArr6;
                                                    System.arraycopy(iArr14, iA, iArr7, i17, i5115);
                                                    iArr13 = iArr12;
                                                    System.arraycopy(iArr13, iA, iArr10, i17, i5115);
                                                } else {
                                                    jArr14 = jArr8;
                                                    iArr13 = iArr12;
                                                    iArr14 = iArr6;
                                                }
                                                int i5116 = i15;
                                                while (true) {
                                                    iArr11 = iArr13;
                                                    iArr6 = iArr14;
                                                    if (iA >= iA2) {
                                                        break;
                                                        break;
                                                    }
                                                    long j111 = j8;
                                                    jArr13[i17] = z.a(j7, 1000000L, sVar.d) + z.a(jArr3[iA] - j8, 1000000L, sVar.c);
                                                    if (!z6) {
                                                    }
                                                    i17++;
                                                    iA++;
                                                    j8 = j111;
                                                    iArr14 = iArr6;
                                                    iArr13 = iArr11;
                                                }
                                                i15 = i5116;
                                            } else {
                                                mVar = mVar;
                                                jArr13 = jArr10;
                                                iArr10 = iArr8;
                                                iArr11 = iArr3;
                                                jArr14 = jArr8;
                                                z3 = z3;
                                            }
                                            j7 += j9;
                                            iArr8 = iArr10;
                                            jArr10 = jArr13;
                                            z3 = z3;
                                            iArr3 = iArr11;
                                            jArr8 = jArr14;
                                            i16++;
                                            mVar = mVar;
                                        }
                                        mVar3 = mVar;
                                        jArr12 = jArr10;
                                        iArr9 = iArr8;
                                        z7 = false;
                                        while (i18 < iArr9.length) {
                                            if ((iArr9[i18] & 1) != 0) {
                                                z8 = true;
                                            } else {
                                                z8 = false;
                                            }
                                            z7 |= z8;
                                        }
                                        if (!z7) {
                                            throw new com.fyber.inneractive.sdk.player.exoplayer2.r("The edited sample sequence does not contain a sync sample.");
                                        }
                                        vVar = new v(jArr9, iArr7, i15, jArr12, iArr9);
                                    }
                                    mVar3 = mVar;
                                    vVar = vVar2;
                                }
                                z.a(jArr3, sVar.c);
                                vVar = new v(jArr4, iArr4, i10, jArr3, iArr3);
                            } else {
                                j3 = j12;
                            }
                            z2 = false;
                            if (z2) {
                                jArr4 = new long[iA4];
                                iArr4 = new int[iA4];
                                jArr15 = new long[iA4];
                                iArr15 = new int[iA4];
                                i20 = iM9;
                                i21 = iM2;
                                i22 = iM3;
                                i23 = iM7;
                                i24 = 0;
                                i25 = 0;
                                iB2 = 0;
                                i26 = 0;
                                j11 = 0;
                                j5 = 0;
                                i27 = iM;
                                iM4 = 0;
                                iM5 = iM8;
                                while (i24 < iA4) {
                                    while (i26 == 0) {
                                        if (dVar.a()) {
                                            throw new IllegalStateException();
                                        }
                                        j11 = dVar.d;
                                        i26 = dVar.c;
                                        i20 = i20;
                                        i22 = i22;
                                    }
                                    int i4114 = i20;
                                    int i5117 = i22;
                                    if (nVar6 != null) {
                                        while (iM4 == 0) {
                                            iM4 = nVar6.m();
                                            iB2 = nVar6.b();
                                            i27--;
                                        }
                                        iM4--;
                                    }
                                    int i5118 = iB2;
                                    jArr4[i24] = j11;
                                    iB3 = hVar.b();
                                    iArr4[i24] = iB3;
                                    if (iB3 > i25) {
                                        i28 = iB3;
                                    } else {
                                        i28 = i25;
                                    }
                                    int i5119 = iA4;
                                    jArr15[i24] = j5 + ((long) i5118);
                                    if (nVar5 == null) {
                                        i29 = 1;
                                    } else {
                                        i29 = 0;
                                    }
                                    iArr15[i24] = i29;
                                    iM6 = i5117;
                                    if (i24 == iM6) {
                                        iArr15[i24] = 1;
                                        i21--;
                                        if (i21 > 0) {
                                            iM6 = nVar5.m() - 1;
                                        }
                                    }
                                    int[] iArr113 = iArr15;
                                    int iM13 = i4114;
                                    long[] jArr113 = jArr15;
                                    j5 += (long) iM13;
                                    iM5--;
                                    if (iM5 != 0) {
                                    }
                                    j11 += (long) iArr4[i24];
                                    i26--;
                                    i24++;
                                    jArr15 = jArr113;
                                    iArr15 = iArr113;
                                    int i51110 = i28;
                                    iB2 = i5118;
                                    i20 = iM13;
                                    iA4 = i5119;
                                    i22 = iM6;
                                    i25 = i51110;
                                }
                                jArr16 = jArr15;
                                iArr16 = iArr15;
                                i = iA4;
                                if (iM4 == 0) {
                                    throw new IllegalArgumentException();
                                }
                                while (i27 > 0) {
                                    if (nVar6.m() == 0) {
                                        throw new IllegalArgumentException();
                                    }
                                    nVar6.b();
                                    i27--;
                                }
                                if (i21 != 0) {
                                    sVar = sVarA;
                                    Log.w("AtomParsers", "Inconsistent stbl box for track " + sVar.f2049a + ": remainingSynchronizationSamples " + i21 + ", remainingSamplesAtTimestampDelta " + iM5 + ", remainingSamplesInChunk " + i26 + ", remainingTimestampDeltaChanges " + i23);
                                } else {
                                    sVar = sVarA;
                                    Log.w("AtomParsers", "Inconsistent stbl box for track " + sVar.f2049a + ": remainingSynchronizationSamples " + i21 + ", remainingSamplesAtTimestampDelta " + iM5 + ", remainingSamplesInChunk " + i26 + ", remainingTimestampDeltaChanges " + i23);
                                }
                                iArr3 = iArr16;
                                i10 = i25;
                                jArr3 = jArr16;
                            } else {
                                sVar = sVarA;
                                i = iA4;
                                i2 = dVar.f2036a;
                                jArr = new long[i2];
                                iArr = new int[i2];
                                while (dVar.a()) {
                                    int i4115 = dVar.b;
                                    jArr[i4115] = dVar.d;
                                    iArr[i4115] = dVar.c;
                                }
                                iB = hVar.b();
                                j4 = iM9;
                                i3 = 8192 / iB;
                                i5 = 0;
                                while (i4 < i2) {
                                    int i4116 = iArr[i4];
                                    int i4117 = z.f2192a;
                                    i5 += ((i4116 + i3) - 1) / i3;
                                }
                                jArr2 = new long[i5];
                                iArr2 = new int[i5];
                                jArr3 = new long[i5];
                                iArr3 = new int[i5];
                                i6 = 0;
                                i7 = 0;
                                i8 = 0;
                                i9 = 0;
                                while (i6 < i2) {
                                    int i4118 = iArr[i6];
                                    j6 = jArr[i6];
                                    long[] jArr114 = jArr;
                                    i11 = i4118;
                                    int i4119 = i2;
                                    iMax = i9;
                                    while (i11 > 0) {
                                        int iMin4 = Math.min(i3, i11);
                                        jArr2[i8] = j6;
                                        int[] iArr114 = iArr;
                                        int i41110 = iB * iMin4;
                                        iArr2[i8] = i41110;
                                        iMax = Math.max(iMax, i41110);
                                        jArr3[i8] = ((long) i7) * j4;
                                        iArr3[i8] = 1;
                                        j6 += (long) iArr2[i8];
                                        i7 += iMin4;
                                        i11 -= iMin4;
                                        i8++;
                                        iArr = iArr114;
                                        iB = iB;
                                    }
                                    i6++;
                                    i9 = iMax;
                                    i2 = i4119;
                                    jArr = jArr114;
                                }
                                jArr4 = jArr2;
                                iArr4 = iArr2;
                                i10 = i9;
                                j5 = 0;
                            }
                            jArr5 = sVar.i;
                            if (jArr5 != null) {
                                mVar = mVar3;
                                if (mVar.f2023a != -1) {
                                }
                                if (jArr5.length == 1) {
                                    iArr5 = iArr4;
                                    jArr6 = sVar.i;
                                    if (jArr6.length == 1) {
                                        c = 0;
                                        if (jArr6[0] == 0) {
                                            i19 = 0;
                                            while (i19 < jArr3.length) {
                                                jArr3[i19] = z.a(jArr3[i19] - sVar.j[c], 1000000L, sVar.c);
                                                i19++;
                                                c = 0;
                                            }
                                            vVar2 = new v(jArr4, iArr5, i10, jArr3, iArr3);
                                        }
                                    }
                                    if (sVar.b == 1) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                    i12 = 0;
                                    i13 = 0;
                                    i14 = 0;
                                    z4 = false;
                                    while (true) {
                                        jArr7 = sVar.i;
                                        if (i12 >= jArr7.length) {
                                            break;
                                            break;
                                        }
                                        j10 = sVar.j[i12];
                                        if (j10 != -1) {
                                            long jA14 = z.a(jArr7[i12], sVar.c, sVar.d);
                                            iA3 = z.a(jArr3, j10, true, true);
                                            int iA10 = z.a(jArr3, j10 + jA14, z3, false);
                                            int i51111 = (iA10 - iA3) + i13;
                                            if (i14 != iA3) {
                                                z9 = true;
                                            } else {
                                                z9 = false;
                                            }
                                            i14 = iA10;
                                            z4 = z9 | z4;
                                            i13 = i51111;
                                        }
                                        i12++;
                                        jArr4 = jArr4;
                                        iArr5 = iArr5;
                                    }
                                    jArr8 = jArr4;
                                    iArr6 = iArr5;
                                    if (i13 != i) {
                                        z5 = true;
                                    } else {
                                        z5 = false;
                                    }
                                    z6 = z5 | z4;
                                    if (z6) {
                                        jArr9 = new long[i13];
                                    } else {
                                        jArr9 = jArr8;
                                    }
                                    if (z6) {
                                        iArr7 = new int[i13];
                                    } else {
                                        iArr7 = iArr6;
                                    }
                                    if (z6) {
                                        i10 = 0;
                                    }
                                    if (z6) {
                                        iArr8 = new int[i13];
                                    } else {
                                        iArr8 = iArr3;
                                    }
                                    jArr10 = new long[i13];
                                    i15 = i10;
                                    i16 = 0;
                                    i17 = 0;
                                    j7 = 0;
                                    while (true) {
                                        jArr11 = sVar.i;
                                        if (i16 >= jArr11.length) {
                                            break;
                                            break;
                                        }
                                        j8 = sVar.j[i16];
                                        j9 = jArr11[i16];
                                        if (j8 != -1) {
                                            jArr13 = jArr10;
                                            iArr10 = iArr8;
                                            iArr12 = iArr3;
                                            long jA15 = z.a(j9, sVar.c, sVar.d) + j8;
                                            iA = z.a(jArr3, j8, true, true);
                                            iA2 = z.a(jArr3, jA15, z3, false);
                                            if (z6) {
                                                int i51112 = iA2 - iA;
                                                jArr14 = jArr8;
                                                System.arraycopy(jArr14, iA, jArr9, i17, i51112);
                                                iArr14 = iArr6;
                                                System.arraycopy(iArr14, iA, iArr7, i17, i51112);
                                                iArr13 = iArr12;
                                                System.arraycopy(iArr13, iA, iArr10, i17, i51112);
                                            } else {
                                                jArr14 = jArr8;
                                                iArr13 = iArr12;
                                                iArr14 = iArr6;
                                            }
                                            int i51113 = i15;
                                            while (true) {
                                                iArr11 = iArr13;
                                                iArr6 = iArr14;
                                                if (iA >= iA2) {
                                                    break;
                                                    break;
                                                }
                                                long j112 = j8;
                                                jArr13[i17] = z.a(j7, 1000000L, sVar.d) + z.a(jArr3[iA] - j8, 1000000L, sVar.c);
                                                if (!z6) {
                                                }
                                                i17++;
                                                iA++;
                                                j8 = j112;
                                                iArr14 = iArr6;
                                                iArr13 = iArr11;
                                            }
                                            i15 = i51113;
                                        } else {
                                            mVar = mVar;
                                            jArr13 = jArr10;
                                            iArr10 = iArr8;
                                            iArr11 = iArr3;
                                            jArr14 = jArr8;
                                            z3 = z3;
                                        }
                                        j7 += j9;
                                        iArr8 = iArr10;
                                        jArr10 = jArr13;
                                        z3 = z3;
                                        iArr3 = iArr11;
                                        jArr8 = jArr14;
                                        i16++;
                                        mVar = mVar;
                                    }
                                    mVar3 = mVar;
                                    jArr12 = jArr10;
                                    iArr9 = iArr8;
                                    z7 = false;
                                    while (i18 < iArr9.length) {
                                        if ((iArr9[i18] & 1) != 0) {
                                            z8 = true;
                                        } else {
                                            z8 = false;
                                        }
                                        z7 |= z8;
                                    }
                                    if (!z7) {
                                        throw new com.fyber.inneractive.sdk.player.exoplayer2.r("The edited sample sequence does not contain a sync sample.");
                                    }
                                    vVar = new v(jArr9, iArr7, i15, jArr12, iArr9);
                                } else {
                                    iArr5 = iArr4;
                                    jArr6 = sVar.i;
                                    if (jArr6.length == 1) {
                                        c = 0;
                                        if (jArr6[0] == 0) {
                                            i19 = 0;
                                            while (i19 < jArr3.length) {
                                                jArr3[i19] = z.a(jArr3[i19] - sVar.j[c], 1000000L, sVar.c);
                                                i19++;
                                                c = 0;
                                            }
                                            vVar2 = new v(jArr4, iArr5, i10, jArr3, iArr3);
                                        }
                                    }
                                    if (sVar.b == 1) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                    i12 = 0;
                                    i13 = 0;
                                    i14 = 0;
                                    z4 = false;
                                    while (true) {
                                        jArr7 = sVar.i;
                                        if (i12 >= jArr7.length) {
                                            break;
                                            break;
                                        }
                                        j10 = sVar.j[i12];
                                        if (j10 != -1) {
                                            long jA16 = z.a(jArr7[i12], sVar.c, sVar.d);
                                            iA3 = z.a(jArr3, j10, true, true);
                                            int iA11 = z.a(jArr3, j10 + jA16, z3, false);
                                            int i51114 = (iA11 - iA3) + i13;
                                            if (i14 != iA3) {
                                                z9 = true;
                                            } else {
                                                z9 = false;
                                            }
                                            i14 = iA11;
                                            z4 = z9 | z4;
                                            i13 = i51114;
                                        }
                                        i12++;
                                        jArr4 = jArr4;
                                        iArr5 = iArr5;
                                    }
                                    jArr8 = jArr4;
                                    iArr6 = iArr5;
                                    if (i13 != i) {
                                        z5 = true;
                                    } else {
                                        z5 = false;
                                    }
                                    z6 = z5 | z4;
                                    if (z6) {
                                        jArr9 = new long[i13];
                                    } else {
                                        jArr9 = jArr8;
                                    }
                                    if (z6) {
                                        iArr7 = new int[i13];
                                    } else {
                                        iArr7 = iArr6;
                                    }
                                    if (z6) {
                                        i10 = 0;
                                    }
                                    if (z6) {
                                        iArr8 = new int[i13];
                                    } else {
                                        iArr8 = iArr3;
                                    }
                                    jArr10 = new long[i13];
                                    i15 = i10;
                                    i16 = 0;
                                    i17 = 0;
                                    j7 = 0;
                                    while (true) {
                                        jArr11 = sVar.i;
                                        if (i16 >= jArr11.length) {
                                            break;
                                            break;
                                        }
                                        j8 = sVar.j[i16];
                                        j9 = jArr11[i16];
                                        if (j8 != -1) {
                                            jArr13 = jArr10;
                                            iArr10 = iArr8;
                                            iArr12 = iArr3;
                                            long jA17 = z.a(j9, sVar.c, sVar.d) + j8;
                                            iA = z.a(jArr3, j8, true, true);
                                            iA2 = z.a(jArr3, jA17, z3, false);
                                            if (z6) {
                                                int i51115 = iA2 - iA;
                                                jArr14 = jArr8;
                                                System.arraycopy(jArr14, iA, jArr9, i17, i51115);
                                                iArr14 = iArr6;
                                                System.arraycopy(iArr14, iA, iArr7, i17, i51115);
                                                iArr13 = iArr12;
                                                System.arraycopy(iArr13, iA, iArr10, i17, i51115);
                                            } else {
                                                jArr14 = jArr8;
                                                iArr13 = iArr12;
                                                iArr14 = iArr6;
                                            }
                                            int i51116 = i15;
                                            while (true) {
                                                iArr11 = iArr13;
                                                iArr6 = iArr14;
                                                if (iA >= iA2) {
                                                    break;
                                                    break;
                                                }
                                                long j113 = j8;
                                                jArr13[i17] = z.a(j7, 1000000L, sVar.d) + z.a(jArr3[iA] - j8, 1000000L, sVar.c);
                                                if (!z6) {
                                                }
                                                i17++;
                                                iA++;
                                                j8 = j113;
                                                iArr14 = iArr6;
                                                iArr13 = iArr11;
                                            }
                                            i15 = i51116;
                                        } else {
                                            mVar = mVar;
                                            jArr13 = jArr10;
                                            iArr10 = iArr8;
                                            iArr11 = iArr3;
                                            jArr14 = jArr8;
                                            z3 = z3;
                                        }
                                        j7 += j9;
                                        iArr8 = iArr10;
                                        jArr10 = jArr13;
                                        z3 = z3;
                                        iArr3 = iArr11;
                                        jArr8 = jArr14;
                                        i16++;
                                        mVar = mVar;
                                    }
                                    mVar3 = mVar;
                                    jArr12 = jArr10;
                                    iArr9 = iArr8;
                                    z7 = false;
                                    while (i18 < iArr9.length) {
                                        if ((iArr9[i18] & 1) != 0) {
                                            z8 = true;
                                        } else {
                                            z8 = false;
                                        }
                                        z7 |= z8;
                                    }
                                    if (!z7) {
                                        throw new com.fyber.inneractive.sdk.player.exoplayer2.r("The edited sample sequence does not contain a sync sample.");
                                    }
                                    vVar = new v(jArr9, iArr7, i15, jArr12, iArr9);
                                }
                                mVar3 = mVar;
                                vVar = vVar2;
                            }
                            z.a(jArr3, sVar.c);
                            vVar = new v(jArr4, iArr4, i10, jArr3, iArr3);
                        }
                        if (vVar.f2052a != 0) {
                            com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVarA = this.l.a(i42, sVar.b);
                            o oVar = new o(sVar, vVar, gVarA);
                            int i60 = vVar.d + 30;
                            com.fyber.inneractive.sdk.player.exoplayer2.o oVar2 = sVar.f;
                            String str2 = oVar2.f2116a;
                            String str3 = oVar2.e;
                            String str4 = oVar2.f;
                            String str5 = oVar2.c;
                            int i61 = oVar2.b;
                            int i62 = oVar2.j;
                            int i63 = oVar2.k;
                            float f = oVar2.l;
                            int i64 = oVar2.m;
                            v vVar3 = vVar;
                            float f2 = oVar2.n;
                            byte[] bArr = oVar2.p;
                            int i65 = oVar2.o;
                            com.fyber.inneractive.sdk.player.exoplayer2.video.c cVar = oVar2.q;
                            int i66 = oVar2.r;
                            int i67 = oVar2.s;
                            int i68 = oVar2.t;
                            int i69 = oVar2.u;
                            int i70 = oVar2.v;
                            int i71 = oVar2.x;
                            String str6 = oVar2.y;
                            int i72 = oVar2.z;
                            long j20 = oVar2.w;
                            com.fyber.inneractive.sdk.player.exoplayer2.o oVar3 = new com.fyber.inneractive.sdk.player.exoplayer2.o(str2, str3, str4, str5, i61, i60, i62, i63, f, i64, f2, bArr, i65, cVar, i66, i67, i68, i69, i70, i71, str6, i72, j20, oVar2.h, oVar2.i, oVar2.d);
                            if (sVar.b == 1) {
                                mVar2 = mVar3;
                                int i73 = mVar2.f2023a;
                                sVar2 = sVar;
                                if (i73 != -1 && (i30 = mVar2.b) != -1) {
                                    oVar3 = new com.fyber.inneractive.sdk.player.exoplayer2.o(str2, str3, str4, str5, i61, i60, i62, i63, f, i64, f2, bArr, i65, cVar, i66, i67, i68, i73, i30, i71, str6, i72, j20, oVar3.h, oVar3.i, oVar3.d);
                                }
                                if (bVar != null) {
                                    oVar3 = new com.fyber.inneractive.sdk.player.exoplayer2.o(oVar3.f2116a, oVar3.e, oVar3.f, oVar3.c, oVar3.b, oVar3.g, oVar3.j, oVar3.k, oVar3.l, oVar3.m, oVar3.n, oVar3.p, oVar3.o, oVar3.q, oVar3.r, oVar3.s, oVar3.t, oVar3.u, oVar3.v, oVar3.x, oVar3.y, oVar3.z, oVar3.w, oVar3.h, oVar3.i, bVar);
                                }
                            } else {
                                sVar2 = sVar;
                                mVar2 = mVar3;
                            }
                            gVarA.a(oVar3);
                            long jMax = Math.max(j3, sVar2.e);
                            arrayList = arrayList2;
                            arrayList.add(oVar);
                            long j21 = vVar3.b[0];
                            if (j21 < j2) {
                                j13 = j21;
                                j12 = jMax;
                            } else {
                                j12 = jMax;
                                j13 = j2;
                            }
                        }
                        i42++;
                        pVar = this;
                        mVar3 = mVar2;
                        arrayList2 = arrayList;
                        bVar = bVar;
                        aVar2 = aVar;
                    } else {
                        aVar = aVar2;
                        bVar = bVar;
                        arrayList2 = arrayList2;
                        mVar3 = mVar3;
                        j3 = j12;
                        i42 = i42;
                        j2 = j13;
                    }
                    j13 = j2;
                    arrayList = arrayList2;
                    j12 = j3;
                    mVar2 = mVar3;
                    i42++;
                    pVar = this;
                    mVar3 = mVar2;
                    arrayList2 = arrayList;
                    bVar = bVar;
                    aVar2 = aVar;
                }
                ArrayList arrayList4 = arrayList2;
                pVar.n = j12;
                pVar.m = (o[]) arrayList4.toArray(new o[arrayList4.size()]);
                pVar.l.b();
                pVar.l.a(pVar);
                pVar.d.clear();
                pVar.e = 2;
            } else if (!pVar.d.isEmpty()) {
                ((a) pVar.d.peek()).R0.add(aVar2);
            }
        }
        if (pVar.e != 2) {
            pVar.e = 0;
            pVar.h = 0;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar) {
        this.l = jVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(long j, long j2) {
        int i;
        this.d.clear();
        this.h = 0;
        this.j = 0;
        this.k = 0;
        if (j == 0) {
            this.e = 0;
            this.h = 0;
            return;
        }
        o[] oVarArr = this.m;
        if (oVarArr != null) {
            for (o oVar : oVarArr) {
                v vVar = oVar.b;
                int iA = z.a(vVar.e, j2, false);
                while (true) {
                    i = -1;
                    if (iA < 0) {
                        iA = -1;
                        break;
                    } else if ((vVar.f[iA] & 1) != 0) {
                        break;
                    } else {
                        iA--;
                    }
                }
                if (iA != -1) {
                    i = iA;
                    break;
                    break;
                }
                iA = z.a(vVar.e, j2, true, false);
                while (iA < vVar.e.length) {
                    if ((vVar.f[iA] & 1) != 0) {
                        i = iA;
                        break;
                    }
                    iA++;
                }
                oVar.d = i;
            }
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final int a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.o oVar) throws InterruptedException, com.fyber.inneractive.sdk.player.exoplayer2.r, EOFException {
        o[] oVarArr;
        int i;
        boolean z;
        boolean z2;
        while (true) {
            int i2 = this.e;
            if (i2 == 0) {
                if (this.h == 0) {
                    if (!bVar.b(this.c.f2184a, 0, 8, true)) {
                        return -1;
                    }
                    this.h = 8;
                    this.c.e(0);
                    this.g = this.c.k();
                    this.f = this.c.b();
                }
                if (this.g == 1) {
                    bVar.b(this.c.f2184a, 8, 8, false);
                    this.h += 8;
                    this.g = this.c.n();
                }
                int i3 = this.f;
                if (i3 != c.C && i3 != c.E && i3 != c.F && i3 != c.G && i3 != c.H && i3 != c.Q) {
                    if (i3 != c.S && i3 != c.D && i3 != c.T && i3 != c.U && i3 != c.m0 && i3 != c.n0 && i3 != c.o0 && i3 != c.R && i3 != c.p0 && i3 != c.q0 && i3 != c.r0 && i3 != c.s0 && i3 != c.t0 && i3 != c.P && i3 != c.b && i3 != c.A0) {
                        this.i = null;
                        this.e = 1;
                    } else if (this.h == 8) {
                        long j = this.g;
                        if (j <= 2147483647L) {
                            com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar = new com.fyber.inneractive.sdk.player.exoplayer2.util.n((int) j);
                            this.i = nVar;
                            System.arraycopy(this.c.f2184a, 0, nVar.f2184a, 0, 8);
                            this.e = 1;
                        } else {
                            throw new IllegalStateException();
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                } else {
                    long j2 = (bVar.c + this.g) - ((long) this.h);
                    this.d.add(new a(this.f, j2));
                    if (this.g == this.h) {
                        c(j2);
                    } else {
                        this.e = 0;
                        this.h = 0;
                    }
                }
            } else {
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException();
                    }
                    long j3 = Long.MAX_VALUE;
                    int i4 = -1;
                    int i5 = 0;
                    while (true) {
                        oVarArr = this.m;
                        if (i5 >= oVarArr.length) {
                            break;
                        }
                        o oVar2 = oVarArr[i5];
                        int i6 = oVar2.d;
                        v vVar = oVar2.b;
                        if (i6 != vVar.f2052a) {
                            long j4 = vVar.b[i6];
                            if (j4 < j3) {
                                i4 = i5;
                                j3 = j4;
                            }
                        }
                        i5++;
                    }
                    if (i4 == -1) {
                        return -1;
                    }
                    o oVar3 = oVarArr[i4];
                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.r rVar = oVar3.c;
                    int i7 = oVar3.d;
                    v vVar2 = oVar3.b;
                    long j5 = vVar2.b[i7];
                    int i8 = vVar2.c[i7];
                    if (oVar3.f2046a.g == 1) {
                        j5 += 8;
                        i8 -= 8;
                    }
                    int i9 = i8;
                    long j6 = (j5 - bVar.c) + ((long) this.j);
                    if (j6 >= 0 && j6 < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                        bVar.a((int) j6);
                        int i10 = oVar3.f2046a.k;
                        if (i10 == 0) {
                            while (true) {
                                int i11 = this.j;
                                i = i9;
                                if (i11 >= i) {
                                    break;
                                }
                                int iA = rVar.a(bVar, i - i11, false);
                                this.j += iA;
                                this.k -= iA;
                                i9 = i;
                            }
                        } else {
                            byte[] bArr = this.b.f2184a;
                            boolean z3 = false;
                            bArr[0] = 0;
                            bArr[1] = 0;
                            bArr[2] = 0;
                            int i12 = 4 - i10;
                            i = i9;
                            while (this.j < i) {
                                int i13 = this.k;
                                if (i13 == 0) {
                                    bVar.b(this.b.f2184a, i12, i10, z3);
                                    this.b.e(z3 ? 1 : 0);
                                    this.k = this.b.m();
                                    this.f2047a.e(z3 ? 1 : 0);
                                    rVar.a(4, this.f2047a);
                                    this.j += 4;
                                    i += i12;
                                } else {
                                    int iA2 = rVar.a(bVar, i13, z3);
                                    this.j += iA2;
                                    this.k -= iA2;
                                    z3 = false;
                                }
                            }
                        }
                        v vVar3 = oVar3.b;
                        rVar.a(vVar3.e[i7], vVar3.f[i7], i, 0, null);
                        oVar3.d++;
                        this.j = 0;
                        this.k = 0;
                        return 0;
                    }
                    oVar.f2054a = j5;
                    return 1;
                }
                long j7 = this.g;
                int i14 = this.h;
                long j8 = j7 - ((long) i14);
                long j9 = bVar.c + j8;
                com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar2 = this.i;
                if (nVar2 != null) {
                    bVar.b(nVar2.f2184a, i14, (int) j8, false);
                    if (this.f == c.b) {
                        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar3 = this.i;
                        nVar3.e(8);
                        if (nVar3.b() != p) {
                            nVar3.e(nVar3.b + 4);
                            while (true) {
                                if (nVar3.c - nVar3.b <= 0) {
                                    z2 = false;
                                    break;
                                }
                                if (nVar3.b() == p) {
                                    z2 = true;
                                    break;
                                }
                            }
                        } else {
                            z2 = true;
                            break;
                        }
                        this.o = z2;
                    } else if (!this.d.isEmpty()) {
                        ((a) this.d.peek()).Q0.add(new b(this.f, this.i));
                    }
                } else {
                    if (j8 < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                        bVar.a((int) j8);
                    } else {
                        oVar.f2054a = j9;
                        z = true;
                    }
                    c(j9);
                    if (z && this.e != 2) {
                        return 1;
                    }
                }
                z = false;
                c(j9);
                if (z) {
                    continue;
                }
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.q
    public final long a(long j) {
        int i;
        long j2 = Long.MAX_VALUE;
        for (o oVar : this.m) {
            v vVar = oVar.b;
            int iA = z.a(vVar.e, j, false);
            while (true) {
                i = -1;
                if (iA < 0) {
                    iA = -1;
                    break;
                }
                if ((vVar.f[iA] & 1) != 0) {
                    break;
                }
                iA--;
            }
            if (iA != -1) {
                i = iA;
                break;
            }
            iA = z.a(vVar.e, j, true, false);
            while (iA < vVar.e.length) {
                if ((vVar.f[iA] & 1) != 0) {
                    i = iA;
                    break;
                }
                iA++;
            }
            long j3 = vVar.b[i];
            if (j3 < j2) {
                j2 = j3;
            }
        }
        return j2;
    }
}
