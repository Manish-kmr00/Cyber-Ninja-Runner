package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv;

import android.util.SparseArray;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.i;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.j;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.o;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.p;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.q;
import com.fyber.inneractive.sdk.player.exoplayer2.m;
import com.fyber.inneractive.sdk.player.exoplayer2.r;
import com.fyber.inneractive.sdk.player.exoplayer2.util.l;
import com.fyber.inneractive.sdk.player.exoplayer2.util.n;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import com.google.firebase.FirebaseError;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements i {
    public static final byte[] Z = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    public static final byte[] a0 = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    public static final UUID b0 = new UUID(72057594037932032L, -9223371306706625679L);
    public long A;
    public com.fyber.inneractive.sdk.player.exoplayer2.util.g B;
    public com.fyber.inneractive.sdk.player.exoplayer2.util.g C;
    public boolean D;
    public int E;
    public long F;
    public long G;
    public int H;
    public int I;
    public int[] J;
    public int K;
    public int L;
    public int M;
    public int N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public byte S;
    public int T;
    public int U;
    public int V;
    public boolean W;
    public boolean X;
    public j Y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f2028a;
    public final g b;
    public final SparseArray c;
    public final boolean d;
    public final n e;
    public final n f;
    public final n g;
    public final n h;
    public final n i;
    public final n j;
    public final n k;
    public final n l;
    public final n m;
    public ByteBuffer n;
    public long o;
    public long p;
    public long q;
    public long r;
    public long s;
    public d t;
    public boolean u;
    public int v;
    public long w;
    public boolean x;
    public long y;
    public long z;

    public e() {
        b bVar = new b();
        this.p = -1L;
        this.q = -9223372036854775807L;
        this.r = -9223372036854775807L;
        this.s = -9223372036854775807L;
        this.y = -1L;
        this.z = -1L;
        this.A = -9223372036854775807L;
        this.f2028a = bVar;
        bVar.d = new c(this);
        this.d = true;
        this.b = new g();
        this.c = new SparseArray();
        this.g = new n(4);
        this.h = new n(ByteBuffer.allocate(4).putInt(-1).array());
        this.i = new n(4);
        this.e = new n(l.f2182a);
        this.f = new n(4);
        this.j = new n();
        this.k = new n();
        this.l = new n(8);
        this.m = new n();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar) throws InterruptedException, EOFException {
        f fVar = new f();
        long j = bVar.b;
        long j2 = 1024;
        if (j != -1 && j <= 1024) {
            j2 = j;
        }
        int i = (int) j2;
        bVar.a(fVar.f2029a.f2184a, 0, 4, false);
        fVar.b = 4;
        for (long jK = fVar.f2029a.k(); jK != 440786851; jK = ((jK << 8) & (-256)) | ((long) (fVar.f2029a.f2184a[0] & 255))) {
            int i2 = fVar.b + 1;
            fVar.b = i2;
            if (i2 == i) {
                return false;
            }
            bVar.a(fVar.f2029a.f2184a, 0, 1, false);
        }
        long jA = fVar.a(bVar);
        long j3 = fVar.b;
        if (jA == Long.MIN_VALUE) {
            return false;
        }
        if (j != -1 && j3 + jA >= j) {
            return false;
        }
        while (true) {
            long j4 = fVar.b;
            long j5 = j3 + jA;
            if (j4 >= j5) {
                return j4 == j5;
            }
            if (fVar.a(bVar) == Long.MIN_VALUE) {
                return false;
            }
            long jA2 = fVar.a(bVar);
            if (jA2 < 0 || jA2 > 2147483647L) {
                return false;
            }
            if (jA2 != 0) {
                bVar.a((int) jA2, false);
                fVar.b = (int) (((long) fVar.b) + jA2);
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(j jVar) {
        this.Y = jVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(long j, long j2) {
        this.A = -9223372036854775807L;
        this.E = 0;
        b bVar = this.f2028a;
        bVar.e = 0;
        bVar.b.clear();
        g gVar = bVar.c;
        gVar.b = 0;
        gVar.c = 0;
        g gVar2 = this.b;
        gVar2.b = 0;
        gVar2.c = 0;
        this.N = 0;
        this.V = 0;
        this.U = 0;
        this.O = false;
        this.P = false;
        this.R = false;
        this.T = 0;
        this.S = (byte) 0;
        this.Q = false;
        n nVar = this.j;
        nVar.b = 0;
        nVar.c = 0;
    }

    /* JADX WARN: Code duplicated, block: B:302:0x0579  */
    /* JADX WARN: Code duplicated, block: B:303:0x0587  */
    /* JADX WARN: Code duplicated, block: B:305:0x058b  */
    /* JADX WARN: Code duplicated, block: B:308:0x0594  */
    /* JADX WARN: Code duplicated, block: B:312:0x05b5 A[LOOP:7: B:309:0x0598->B:312:0x05b5, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:314:0x05c4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:315:0x05c6  */
    /* JADX WARN: Code duplicated, block: B:318:0x05d0  */
    /* JADX WARN: Code duplicated, block: B:320:0x05e2  */
    /* JADX WARN: Code duplicated, block: B:322:0x05e5  */
    /* JADX WARN: Code duplicated, block: B:327:0x0609 A[LOOP:10: B:325:0x0606->B:327:0x0609, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:329:0x061c  */
    /* JADX WARN: Code duplicated, block: B:331:0x062e A[LOOP:9: B:321:0x05e3->B:331:0x062e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:441:0x081b  */
    /* JADX WARN: Code duplicated, block: B:578:0x0abf  */
    /* JADX WARN: Code duplicated, block: B:582:0x0acf  */
    /* JADX WARN: Code duplicated, block: B:584:0x0ad3  */
    /* JADX WARN: Code duplicated, block: B:612:0x06c4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:613:0x0665 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:628:0x0ac5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:629:0x0adb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:630:0x0ae1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:631:0x0ae1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:632:0x0ae1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:647:0x05b8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:649:0x066d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:652:0x0635 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:653:0x05f4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:654:0x061a A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v132 */
    /* JADX WARN: Type inference failed for: r4v89, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v93 */
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
    public final int a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar, o oVar) throws InterruptedException, r, EOFException {
        boolean z;
        int i;
        int i2;
        boolean z2;
        long j;
        long j2;
        boolean z3;
        int i3;
        int i4;
        int i5;
        String str;
        int i6;
        int i7;
        int i8;
        int[] iArr;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        long j3;
        int i17;
        int i18;
        int i19;
        long j4;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        double dLongBitsToDouble;
        long j5;
        int i28;
        int iA;
        q pVar;
        com.fyber.inneractive.sdk.player.exoplayer2.util.g gVar;
        int i29;
        com.fyber.inneractive.sdk.player.exoplayer2.util.g gVar2;
        int i30 = 0;
        this.W = false;
        boolean z4 = true;
        while (z4 && !this.W) {
            b bVar2 = this.f2028a;
            if (bVar2.d == null) {
                throw new IllegalStateException();
            }
            while (true) {
                if (bVar2.b.isEmpty()) {
                    z = i30;
                } else {
                    if (bVar.c >= ((a) bVar2.b.peek()).b) {
                        c cVar = bVar2.d;
                        int i31 = ((a) bVar2.b.pop()).f2024a;
                        e eVar = cVar.f2026a;
                        if (i31 != 160) {
                            if (i31 == 174) {
                                String str2 = eVar.t.f2027a;
                                if ("V_VP8".equals(str2) || "V_VP9".equals(str2) || "V_MPEG2".equals(str2) || "V_MPEG4/ISO/SP".equals(str2) || "V_MPEG4/ISO/ASP".equals(str2) || "V_MPEG4/ISO/AP".equals(str2) || "V_MPEG4/ISO/AVC".equals(str2) || "V_MPEGH/ISO/HEVC".equals(str2) || "V_MS/VFW/FOURCC".equals(str2) || "V_THEORA".equals(str2) || "A_OPUS".equals(str2) || "A_VORBIS".equals(str2) || "A_AAC".equals(str2) || "A_MPEG/L2".equals(str2) || "A_MPEG/L3".equals(str2) || "A_AC3".equals(str2) || "A_EAC3".equals(str2) || "A_TRUEHD".equals(str2) || "A_DTS".equals(str2) || "A_DTS/EXPRESS".equals(str2) || "A_DTS/LOSSLESS".equals(str2) || "A_FLAC".equals(str2) || "A_MS/ACM".equals(str2) || "A_PCM/INT/LIT".equals(str2) || "S_TEXT/UTF8".equals(str2) || "S_VOBSUB".equals(str2) || "S_HDMV/PGS".equals(str2) || "S_DVBSUB".equals(str2)) {
                                    d dVar = eVar.t;
                                    dVar.a(eVar.Y, dVar.b);
                                    SparseArray sparseArray = eVar.c;
                                    d dVar2 = eVar.t;
                                    sparseArray.put(dVar2.b, dVar2);
                                }
                                eVar.t = null;
                            } else {
                                if (i31 == 19899) {
                                    int i32 = eVar.v;
                                    if (i32 != -1) {
                                        long j6 = eVar.w;
                                        if (j6 != -1) {
                                            if (i32 == 475249515) {
                                                eVar.y = j6;
                                            }
                                        }
                                    }
                                    throw new r("Mandatory element SeekID or SeekPosition not found");
                                }
                                if (i31 == 25152) {
                                    d dVar3 = eVar.t;
                                    if (dVar3.e) {
                                        byte[] bArr = dVar3.g;
                                        if (bArr != null) {
                                            dVar3.i = new com.fyber.inneractive.sdk.player.exoplayer2.drm.d(true, new com.fyber.inneractive.sdk.player.exoplayer2.drm.c(com.fyber.inneractive.sdk.player.exoplayer2.b.b, "video/webm", bArr));
                                        } else {
                                            throw new r("Encrypted Track found but ContentEncKeyID was not found");
                                        }
                                    }
                                } else if (i31 == 28032) {
                                    d dVar4 = eVar.t;
                                    if (dVar4.e && dVar4.f != null) {
                                        throw new r("Combining encryption and compression is not supported");
                                    }
                                } else if (i31 == 357149030) {
                                    if (eVar.q == -9223372036854775807L) {
                                        eVar.q = 1000000L;
                                    }
                                    long j7 = eVar.r;
                                    if (j7 != -9223372036854775807L) {
                                        eVar.s = eVar.a(j7);
                                    }
                                } else if (i31 != 374648427) {
                                    if (i31 != 475249515) {
                                        eVar.getClass();
                                    } else if (!eVar.u) {
                                        j jVar = eVar.Y;
                                        if (eVar.p != -1 && eVar.s != -9223372036854775807L && (gVar = eVar.B) != null && (i29 = gVar.f2179a) != 0 && (gVar2 = eVar.C) != null && gVar2.f2179a == i29) {
                                            int[] iArr2 = new int[i29];
                                            long[] jArr = new long[i29];
                                            long[] jArr2 = new long[i29];
                                            long[] jArr3 = new long[i29];
                                            for (int i33 = 0; i33 < i29; i33++) {
                                                com.fyber.inneractive.sdk.player.exoplayer2.util.g gVar3 = eVar.B;
                                                if (i33 >= 0) {
                                                    if (i33 < gVar3.f2179a) {
                                                        jArr3[i33] = gVar3.b[i33];
                                                        long j8 = eVar.p;
                                                        com.fyber.inneractive.sdk.player.exoplayer2.util.g gVar4 = eVar.C;
                                                        if (i33 < 0) {
                                                            gVar4.getClass();
                                                        } else if (i33 < gVar4.f2179a) {
                                                            jArr[i33] = gVar4.b[i33] + j8;
                                                        }
                                                        throw new IndexOutOfBoundsException(com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.l.a("Invalid index ", i33, ", size is ").append(gVar4.f2179a).toString());
                                                    }
                                                } else {
                                                    gVar3.getClass();
                                                }
                                                throw new IndexOutOfBoundsException(com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.l.a("Invalid index ", i33, ", size is ").append(gVar3.f2179a).toString());
                                            }
                                            int i34 = 0;
                                            while (true) {
                                                int i35 = i29 - 1;
                                                if (i34 < i35) {
                                                    int i36 = i34 + 1;
                                                    iArr2[i34] = (int) (jArr[i36] - jArr[i34]);
                                                    jArr2[i34] = jArr3[i36] - jArr3[i34];
                                                    i34 = i36;
                                                } else {
                                                    iArr2[i35] = (int) ((eVar.p + eVar.o) - jArr[i35]);
                                                    jArr2[i35] = eVar.s - jArr3[i35];
                                                    eVar.B = null;
                                                    eVar.C = null;
                                                    pVar = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.a(iArr2, jArr, jArr2, jArr3);
                                                }
                                            }
                                        } else {
                                            eVar.B = null;
                                            eVar.C = null;
                                            pVar = new p(eVar.s);
                                        }
                                        jVar.a(pVar);
                                        eVar.u = true;
                                    }
                                } else if (eVar.c.size() != 0) {
                                    eVar.Y.b();
                                } else {
                                    throw new r("No valid tracks were found");
                                }
                            }
                        } else if (eVar.E == 2) {
                            if (!eVar.X) {
                                eVar.M |= 1;
                            }
                            eVar.a((d) eVar.c.get(eVar.K), eVar.F);
                            i = 0;
                            eVar.E = 0;
                        }
                        i = 0;
                    } else {
                        z = 0;
                    }
                    i2 = i;
                    z4 = true;
                    z2 = i2;
                    if (z4) {
                        j = bVar.c;
                        if (this.x) {
                            this.z = j;
                            oVar.f2054a = this.y;
                            this.x = z2;
                            return 1;
                        }
                        if (this.u) {
                            j2 = this.z;
                            if (j2 != -1) {
                                oVar.f2054a = j2;
                                this.z = -1L;
                                return 1;
                            }
                        } else {
                            continue;
                        }
                    }
                    i30 = 0;
                }
                int i37 = 8;
                if (bVar2.e == 0) {
                    long jA = bVar2.c.a(bVar, true, z, 4);
                    if (jA == -2) {
                        bVar.e = z ? 1 : 0;
                        ?? r4 = z;
                        while (true) {
                            bVar.a(bVar2.f2025a, r4, 4, r4);
                            byte b = bVar2.f2025a[r4];
                            int i38 = 0;
                            while (true) {
                                long[] jArr4 = g.d;
                                if (i38 >= 8) {
                                    i28 = -1;
                                } else if ((jArr4[i38] & ((long) b)) != 0) {
                                    i28 = i38 + 1;
                                } else {
                                    i38++;
                                }
                            }
                            if (i28 != -1 && i28 <= 4) {
                                iA = (int) g.a(bVar2.f2025a, i28, false);
                                bVar2.d.f2026a.getClass();
                                if (iA == 357149030 || iA == 524531317 || iA == 475249515 || iA == 374648427) {
                                }
                            }
                            bVar.a(1);
                            r4 = 0;
                        }
                        bVar.a(i28);
                        j5 = iA;
                        z3 = true;
                    } else {
                        z3 = true;
                        j5 = jA;
                    }
                    if (j5 == -1) {
                        z2 = 0;
                        z4 = false;
                    } else {
                        bVar2.f = (int) j5;
                        bVar2.e = z3 ? 1 : 0;
                    }
                    if (z4) {
                        j = bVar.c;
                        if (this.x) {
                            this.z = j;
                            oVar.f2054a = this.y;
                            this.x = z2;
                            return 1;
                        }
                        if (this.u) {
                            j2 = this.z;
                            if (j2 != -1) {
                                oVar.f2054a = j2;
                                this.z = -1L;
                                return 1;
                            }
                        } else {
                            continue;
                        }
                    }
                    i30 = 0;
                } else {
                    z3 = true;
                }
                if (bVar2.e == z3) {
                    bVar2.g = bVar2.c.a(bVar, false, z3, 8);
                    bVar2.e = 2;
                }
                c cVar2 = bVar2.d;
                int i39 = bVar2.f;
                cVar2.f2026a.getClass();
                switch (i39) {
                    case MRAID_JS_WRITE_FAILED_VALUE:
                    case 136:
                    case 155:
                    case 159:
                    case 176:
                    case 179:
                    case 186:
                    case AD_RESPONSE_EMPTY_VALUE:
                    case 231:
                    case 241:
                    case 251:
                    case 16980:
                    case 17029:
                    case 17143:
                    case 18401:
                    case 18408:
                    case 20529:
                    case 20530:
                    case 21420:
                    case 21432:
                    case 21680:
                    case 21682:
                    case 21690:
                    case 21930:
                    case 21945:
                    case 21946:
                    case 21947:
                    case 21948:
                    case 21949:
                    case 22186:
                    case 22203:
                    case 25188:
                    case 2352003:
                    case 2807729:
                        i3 = 2;
                        break;
                    case 134:
                    case FirebaseError.ERROR_WEAK_PASSWORD /* 17026 */:
                    case 2274716:
                        i3 = 3;
                        break;
                    case 160:
                    case 174:
                    case 183:
                    case 187:
                    case 224:
                    case 225:
                    case 18407:
                    case 19899:
                    case 20532:
                    case 20533:
                    case 21936:
                    case 21968:
                    case 25152:
                    case 28032:
                    case 30320:
                    case 290298740:
                    case 357149030:
                    case 374648427:
                    case 408125543:
                    case 440786851:
                    case 475249515:
                    case 524531317:
                        i3 = 1;
                        break;
                    case 161:
                    case 163:
                    case 16981:
                    case 18402:
                    case 21419:
                    case 25506:
                    case 30322:
                        i3 = 4;
                        break;
                    case 181:
                    case 17545:
                    case 21969:
                    case 21970:
                    case 21971:
                    case 21972:
                    case 21973:
                    case 21974:
                    case 21975:
                    case 21976:
                    case 21977:
                    case 21978:
                        i3 = 5;
                        break;
                    default:
                        i3 = 0;
                        break;
                }
                if (i3 != 0) {
                    if (i3 == 1) {
                        long j9 = bVar.c;
                        bVar2.b.add(new a(bVar2.f, bVar2.g + j9));
                        c cVar3 = bVar2.d;
                        int i40 = bVar2.f;
                        long j10 = bVar2.g;
                        e eVar2 = cVar3.f2026a;
                        eVar2.getClass();
                        if (i40 == 160) {
                            i4 = 0;
                            eVar2.X = false;
                        } else if (i40 == 174) {
                            i4 = 0;
                            eVar2.t = new d();
                        } else if (i40 != 187) {
                            if (i40 == 19899) {
                                eVar2.v = -1;
                                eVar2.w = -1L;
                            } else if (i40 == 20533) {
                                eVar2.t.e = true;
                            } else if (i40 == 21968) {
                                eVar2.t.q = true;
                            } else if (i40 == 408125543) {
                                long j11 = eVar2.p;
                                if (j11 != -1 && j11 != j9) {
                                    throw new r("Multiple Segment elements not supported");
                                }
                                eVar2.p = j9;
                                eVar2.o = j10;
                            } else if (i40 != 475249515) {
                                if (i40 == 524531317 && !eVar2.u) {
                                    if (eVar2.d && eVar2.y != -1) {
                                        eVar2.x = true;
                                    } else {
                                        eVar2.Y.a(new p(eVar2.s));
                                        eVar2.u = true;
                                    }
                                }
                            } else {
                                eVar2.B = new com.fyber.inneractive.sdk.player.exoplayer2.util.g();
                                eVar2.C = new com.fyber.inneractive.sdk.player.exoplayer2.util.g();
                            }
                            i4 = 0;
                        } else {
                            i4 = 0;
                            eVar2.D = false;
                        }
                        bVar2.e = i4 == true ? 1 : 0;
                        i2 = i4;
                    } else if (i3 == 2) {
                        long j12 = bVar2.g;
                        if (j12 <= 8) {
                            c cVar4 = bVar2.d;
                            int i41 = bVar2.f;
                            int i42 = (int) j12;
                            bVar.b(bVar2.f2025a, 0, i42, false);
                            long j13 = 0;
                            for (int i43 = 0; i43 < i42; i43++) {
                                j13 = (j13 << 8) | ((long) (bVar2.f2025a[i43] & 255));
                            }
                            e eVar3 = cVar4.f2026a;
                            eVar3.getClass();
                            if (i41 != 20529) {
                                if (i41 != 20530) {
                                    switch (i41) {
                                        case MRAID_JS_WRITE_FAILED_VALUE:
                                            eVar3.t.c = (int) j13;
                                            break;
                                        case 136:
                                            eVar3.t.L = j13 == 1;
                                            break;
                                        case 155:
                                            eVar3.G = eVar3.a(j13);
                                            break;
                                        case 159:
                                            eVar3.t.G = (int) j13;
                                            break;
                                        case 176:
                                            eVar3.t.j = (int) j13;
                                            break;
                                        case 179:
                                            eVar3.B.a(eVar3.a(j13));
                                            break;
                                        case 186:
                                            eVar3.t.k = (int) j13;
                                            break;
                                        case AD_RESPONSE_EMPTY_VALUE:
                                            eVar3.t.b = (int) j13;
                                            break;
                                        case 231:
                                            eVar3.A = eVar3.a(j13);
                                            break;
                                        case 241:
                                            if (!eVar3.D) {
                                                eVar3.C.a(j13);
                                                eVar3.D = true;
                                            }
                                            break;
                                        case 251:
                                            eVar3.X = true;
                                            break;
                                        case 16980:
                                            if (j13 != 3) {
                                                throw new r("ContentCompAlgo " + j13 + " not supported");
                                            }
                                            break;
                                        case 17029:
                                            if (j13 < 1 || j13 > 2) {
                                                throw new r("DocTypeReadVersion " + j13 + " not supported");
                                            }
                                            break;
                                        case 17143:
                                            if (j13 != 1) {
                                                throw new r("EBMLReadVersion " + j13 + " not supported");
                                            }
                                            break;
                                        case 18401:
                                            if (j13 != 5) {
                                                throw new r("ContentEncAlgo " + j13 + " not supported");
                                            }
                                            break;
                                        case 18408:
                                            if (j13 != 1) {
                                                throw new r("AESSettingsCipherMode " + j13 + " not supported");
                                            }
                                            break;
                                        case 21420:
                                            eVar3.w = j13 + eVar3.p;
                                            break;
                                        case 21432:
                                            int i44 = (int) j13;
                                            if (i44 == 0) {
                                                eVar3.t.p = 0;
                                                i5 = 0;
                                            } else if (i44 == 1) {
                                                eVar3.t.p = 2;
                                            } else if (i44 == 3) {
                                                eVar3.t.p = 1;
                                            } else if (i44 == 15) {
                                                eVar3.t.p = 3;
                                            }
                                            bVar2.e = i5 == true ? 1 : 0;
                                            i2 = i5;
                                            break;
                                        case 21680:
                                            eVar3.t.l = (int) j13;
                                            break;
                                        case 21682:
                                            eVar3.t.n = (int) j13;
                                            break;
                                        case 21690:
                                            eVar3.t.m = (int) j13;
                                            break;
                                        case 21930:
                                            eVar3.t.M = j13 == 1;
                                            break;
                                        case 22186:
                                            eVar3.t.J = j13;
                                            break;
                                        case 22203:
                                            eVar3.t.K = j13;
                                            break;
                                        case 25188:
                                            eVar3.t.H = (int) j13;
                                            break;
                                        case 2352003:
                                            eVar3.t.d = (int) j13;
                                            break;
                                        case 2807729:
                                            eVar3.q = j13;
                                            break;
                                        default:
                                            switch (i41) {
                                                case 21945:
                                                    int i45 = (int) j13;
                                                    if (i45 == 1) {
                                                        eVar3.t.t = 2;
                                                    } else if (i45 == 2) {
                                                        eVar3.t.t = 1;
                                                    }
                                                    break;
                                                case 21946:
                                                    int i46 = (int) j13;
                                                    if (i46 == 1) {
                                                        eVar3.t.s = 3;
                                                    } else if (i46 == 16) {
                                                        eVar3.t.s = 6;
                                                    } else if (i46 == 18) {
                                                        eVar3.t.s = 7;
                                                    } else if (i46 == 6 || i46 == 7) {
                                                        eVar3.t.s = 3;
                                                    }
                                                    break;
                                                case 21947:
                                                    d dVar5 = eVar3.t;
                                                    dVar5.q = true;
                                                    int i47 = (int) j13;
                                                    if (i47 == 1) {
                                                        dVar5.r = 1;
                                                    } else if (i47 == 9) {
                                                        dVar5.r = 6;
                                                    } else if (i47 == 4 || i47 == 5 || i47 == 6 || i47 == 7) {
                                                        dVar5.r = 2;
                                                    }
                                                    break;
                                                case 21948:
                                                    eVar3.t.u = (int) j13;
                                                    break;
                                                case 21949:
                                                    eVar3.t.v = (int) j13;
                                                    break;
                                            }
                                            break;
                                    }
                                } else if (j13 != 1) {
                                    throw new r("ContentEncodingScope " + j13 + " not supported");
                                }
                            } else if (j13 != 0) {
                                throw new r("ContentEncodingOrder " + j13 + " not supported");
                            }
                            i5 = 0;
                            bVar2.e = i5 == true ? 1 : 0;
                            i2 = i5;
                        } else {
                            throw new r("Invalid integer size: " + bVar2.g);
                        }
                    } else if (i3 == 3) {
                        long j14 = bVar2.g;
                        if (j14 <= 2147483647L) {
                            c cVar5 = bVar2.d;
                            int i48 = bVar2.f;
                            int i49 = (int) j14;
                            if (i49 == 0) {
                                str = "";
                            } else {
                                byte[] bArr2 = new byte[i49];
                                bVar.b(bArr2, 0, i49, false);
                                str = new String(bArr2);
                            }
                            e eVar4 = cVar5.f2026a;
                            eVar4.getClass();
                            if (i48 == 134) {
                                eVar4.t.f2027a = str;
                            } else if (i48 != 17026) {
                                if (i48 == 2274716) {
                                    eVar4.t.N = str;
                                }
                            } else if (!"webm".equals(str) && !"matroska".equals(str)) {
                                throw new r("DocType " + str + " not supported");
                            }
                            i2 = 0;
                            bVar2.e = 0;
                        } else {
                            throw new r("String element size: " + bVar2.g);
                        }
                    } else if (i3 != 4) {
                        if (i3 != 5) {
                            throw new r(m.a("Invalid element type ", i3));
                        }
                        long j15 = bVar2.g;
                        if (j15 != 4 && j15 != 8) {
                            throw new r("Invalid float size: " + bVar2.g);
                        }
                        c cVar6 = bVar2.d;
                        int i50 = bVar2.f;
                        int i51 = (int) j15;
                        bVar.b(bVar2.f2025a, 0, i51, false);
                        long j16 = 0;
                        for (int i52 = 0; i52 < i51; i52++) {
                            j16 = (j16 << 8) | ((long) (bVar2.f2025a[i52] & 255));
                        }
                        if (i51 == 4) {
                            dLongBitsToDouble = Float.intBitsToFloat((int) j16);
                        } else {
                            dLongBitsToDouble = Double.longBitsToDouble(j16);
                        }
                        e eVar5 = cVar6.f2026a;
                        if (i50 == 181) {
                            eVar5.t.I = (int) dLongBitsToDouble;
                        } else if (i50 != 17545) {
                            switch (i50) {
                                case 21969:
                                    eVar5.t.w = (float) dLongBitsToDouble;
                                    break;
                                case 21970:
                                    eVar5.t.x = (float) dLongBitsToDouble;
                                    break;
                                case 21971:
                                    eVar5.t.y = (float) dLongBitsToDouble;
                                    break;
                                case 21972:
                                    eVar5.t.z = (float) dLongBitsToDouble;
                                    break;
                                case 21973:
                                    eVar5.t.A = (float) dLongBitsToDouble;
                                    break;
                                case 21974:
                                    eVar5.t.B = (float) dLongBitsToDouble;
                                    break;
                                case 21975:
                                    eVar5.t.C = (float) dLongBitsToDouble;
                                    break;
                                case 21976:
                                    eVar5.t.D = (float) dLongBitsToDouble;
                                    break;
                                case 21977:
                                    eVar5.t.E = (float) dLongBitsToDouble;
                                    break;
                                case 21978:
                                    eVar5.t.F = (float) dLongBitsToDouble;
                                    break;
                                default:
                                    eVar5.getClass();
                                    break;
                            }
                        } else {
                            eVar5.r = (long) dLongBitsToDouble;
                        }
                        i2 = 0;
                        bVar2.e = 0;
                    } else {
                        c cVar7 = bVar2.d;
                        int i53 = bVar2.f;
                        int i54 = (int) bVar2.g;
                        e eVar6 = cVar7.f2026a;
                        if (i53 == 161 || i53 == 163) {
                            i6 = 0;
                            if (eVar6.E == 0) {
                                eVar6.K = (int) eVar6.b.a(bVar, false, true, 8);
                                eVar6.L = eVar6.b.c;
                                eVar6.G = -9223372036854775807L;
                                eVar6.E = 1;
                                n nVar = eVar6.g;
                                nVar.b = 0;
                                nVar.c = 0;
                            }
                            d dVar6 = (d) eVar6.c.get(eVar6.K);
                            if (dVar6 == null) {
                                bVar.a(i54 - eVar6.L);
                                eVar6.E = 0;
                            } else {
                                if (eVar6.E == 1) {
                                    eVar6.a(bVar, 3);
                                    int i55 = (eVar6.g.f2184a[2] & 6) >> 1;
                                    if (i55 == 0) {
                                        eVar6.I = 1;
                                        int[] iArr3 = eVar6.J;
                                        if (iArr3 == null) {
                                            iArr3 = new int[1];
                                        } else if (iArr3.length < 1) {
                                            iArr3 = new int[Math.max(iArr3.length * 2, 1)];
                                        }
                                        eVar6.J = iArr3;
                                        iArr3[0] = (i54 - eVar6.L) - 3;
                                    } else if (i53 == 163) {
                                        eVar6.a(bVar, 4);
                                        int i56 = (eVar6.g.f2184a[3] & 255) + 1;
                                        eVar6.I = i56;
                                        int[] iArr4 = eVar6.J;
                                        if (iArr4 == null) {
                                            iArr4 = new int[i56];
                                        } else {
                                            if (iArr4.length < i56) {
                                                int length = iArr4.length;
                                                i8 = 2;
                                                iArr = new int[Math.max(length * 2, i56)];
                                            }
                                            eVar6.J = iArr;
                                            if (i55 == i8) {
                                                int i57 = (i54 - eVar6.L) - 4;
                                                int i58 = eVar6.I;
                                                Arrays.fill(iArr, 0, i58, i57 / i58);
                                            } else {
                                                i9 = 1;
                                                i10 = 0;
                                                if (i55 == 1) {
                                                    i21 = 0;
                                                    i22 = 0;
                                                    i23 = 4;
                                                    while (true) {
                                                        i24 = eVar6.I - i9;
                                                        if (i21 < i24) {
                                                            eVar6.J[i21] = i10;
                                                            while (true) {
                                                                i25 = i23 + 1;
                                                                eVar6.a(bVar, i25);
                                                                i26 = eVar6.g.f2184a[i23] & 255;
                                                                int[] iArr5 = eVar6.J;
                                                                i27 = iArr5[i21] + i26;
                                                                iArr5[i21] = i27;
                                                                if (i26 != 255) {
                                                                    break;
                                                                }
                                                                i23 = i25;
                                                            }
                                                            i22 += i27;
                                                            i21++;
                                                            i23 = i25;
                                                            i9 = 1;
                                                            i10 = 0;
                                                        } else {
                                                            eVar6.J[i24] = ((i54 - eVar6.L) - i23) - i22;
                                                        }
                                                    }
                                                } else {
                                                    if (i55 == 3) {
                                                        throw new r(m.a("Unexpected lacing value: ", i55));
                                                    }
                                                    i11 = 0;
                                                    i12 = 0;
                                                    i13 = 4;
                                                    while (true) {
                                                        i14 = eVar6.I - 1;
                                                        if (i11 < i14) {
                                                            eVar6.J[i11] = 0;
                                                            i15 = i13 + 1;
                                                            eVar6.a(bVar, i15);
                                                            if (eVar6.g.f2184a[i13] == 0) {
                                                                throw new r("No valid varint length mask found");
                                                            }
                                                            i16 = 0;
                                                            while (true) {
                                                                if (i16 < i37) {
                                                                    i17 = 1 << (7 - i16);
                                                                    if ((eVar6.g.f2184a[i13] & i17) != 0) {
                                                                        i18 = i15 + i16;
                                                                        eVar6.a(bVar, i18);
                                                                        int i59 = eVar6.g.f2184a[i13] & 255 & (~i17);
                                                                        i19 = i15;
                                                                        j4 = i59;
                                                                        while (true) {
                                                                            i20 = i19;
                                                                            if (i20 < i18) {
                                                                                i19 = i20 + 1;
                                                                                j4 = (j4 << 8) | ((long) (eVar6.g.f2184a[i20] & 255));
                                                                            } else {
                                                                                if (i11 > 0) {
                                                                                    j4 -= (1 << ((i16 * 7) + 6)) - 1;
                                                                                }
                                                                                long j17 = j4;
                                                                                i13 = i18;
                                                                                j3 = j17;
                                                                            }
                                                                        }
                                                                    } else {
                                                                        i16++;
                                                                        i37 = 8;
                                                                    }
                                                                } else {
                                                                    i13 = i15;
                                                                    j3 = 0;
                                                                }
                                                            }
                                                            if (j3 < -2147483648L && j3 <= 2147483647L) {
                                                                int i60 = (int) j3;
                                                                int[] iArr6 = eVar6.J;
                                                                if (i11 != 0) {
                                                                    i60 += iArr6[i11 - 1];
                                                                }
                                                                iArr6[i11] = i60;
                                                                i12 += i60;
                                                                i11++;
                                                                i37 = 8;
                                                            } else {
                                                                throw new r("EBML lacing sample size out of range.");
                                                            }
                                                        } else {
                                                            eVar6.J[i14] = ((i54 - eVar6.L) - i13) - i12;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        iArr = iArr4;
                                        i8 = 2;
                                        eVar6.J = iArr;
                                        if (i55 == i8) {
                                            int i510 = (i54 - eVar6.L) - 4;
                                            int i511 = eVar6.I;
                                            Arrays.fill(iArr, 0, i511, i510 / i511);
                                        } else {
                                            i9 = 1;
                                            i10 = 0;
                                            if (i55 == 1) {
                                                i21 = 0;
                                                i22 = 0;
                                                i23 = 4;
                                                while (true) {
                                                    i24 = eVar6.I - i9;
                                                    if (i21 < i24) {
                                                        eVar6.J[i21] = i10;
                                                        while (true) {
                                                            i25 = i23 + 1;
                                                            eVar6.a(bVar, i25);
                                                            i26 = eVar6.g.f2184a[i23] & 255;
                                                            int[] iArr7 = eVar6.J;
                                                            i27 = iArr7[i21] + i26;
                                                            iArr7[i21] = i27;
                                                            if (i26 != 255) {
                                                                break;
                                                            }
                                                            i23 = i25;
                                                        }
                                                        i22 += i27;
                                                        i21++;
                                                        i23 = i25;
                                                        i9 = 1;
                                                        i10 = 0;
                                                    } else {
                                                        eVar6.J[i24] = ((i54 - eVar6.L) - i23) - i22;
                                                    }
                                                }
                                            } else {
                                                if (i55 == 3) {
                                                    throw new r(m.a("Unexpected lacing value: ", i55));
                                                }
                                                i11 = 0;
                                                i12 = 0;
                                                i13 = 4;
                                                while (true) {
                                                    i14 = eVar6.I - 1;
                                                    if (i11 < i14) {
                                                        eVar6.J[i11] = 0;
                                                        i15 = i13 + 1;
                                                        eVar6.a(bVar, i15);
                                                        if (eVar6.g.f2184a[i13] == 0) {
                                                            i16 = 0;
                                                            while (true) {
                                                                if (i16 < i37) {
                                                                    i17 = 1 << (7 - i16);
                                                                    if ((eVar6.g.f2184a[i13] & i17) != 0) {
                                                                        i18 = i15 + i16;
                                                                        eVar6.a(bVar, i18);
                                                                        int i512 = eVar6.g.f2184a[i13] & 255 & (~i17);
                                                                        i19 = i15;
                                                                        j4 = i512;
                                                                        while (true) {
                                                                            i20 = i19;
                                                                            if (i20 < i18) {
                                                                                i19 = i20 + 1;
                                                                                j4 = (j4 << 8) | ((long) (eVar6.g.f2184a[i20] & 255));
                                                                            } else {
                                                                                if (i11 > 0) {
                                                                                    j4 -= (1 << ((i16 * 7) + 6)) - 1;
                                                                                }
                                                                                long j18 = j4;
                                                                                i13 = i18;
                                                                                j3 = j18;
                                                                            }
                                                                        }
                                                                    } else {
                                                                        i16++;
                                                                        i37 = 8;
                                                                    }
                                                                } else {
                                                                    i13 = i15;
                                                                    j3 = 0;
                                                                }
                                                            }
                                                            if (j3 < -2147483648L) {
                                                            }
                                                            throw new r("EBML lacing sample size out of range.");
                                                        }
                                                        throw new r("No valid varint length mask found");
                                                    }
                                                    eVar6.J[i14] = ((i54 - eVar6.L) - i13) - i12;
                                                    iArr6[i11] = i60;
                                                    i12 += i60;
                                                    i11++;
                                                    i37 = 8;
                                                }
                                            }
                                        }
                                    } else {
                                        throw new r("Lacing only supported in SimpleBlocks.");
                                    }
                                    byte[] bArr3 = eVar6.g.f2184a;
                                    eVar6.F = eVar6.a((bArr3[1] & 255) | (bArr3[0] << 8)) + eVar6.A;
                                    byte b2 = eVar6.g.f2184a[2];
                                    eVar6.M = ((dVar6.c == 2 || (i53 == 163 && (b2 & 128) == 128)) ? 1 : 0) | ((b2 & 8) == 8 ? Integer.MIN_VALUE : 0);
                                    eVar6.E = 2;
                                    eVar6.H = 0;
                                    i7 = 163;
                                } else {
                                    i7 = 163;
                                }
                                if (i53 == i7) {
                                    while (true) {
                                        int i61 = eVar6.H;
                                        if (i61 < eVar6.I) {
                                            eVar6.a(bVar, dVar6, eVar6.J[i61]);
                                            eVar6.a(dVar6, eVar6.F + ((long) ((eVar6.H * dVar6.d) / 1000)));
                                            eVar6.H++;
                                        } else {
                                            i = 0;
                                            eVar6.E = 0;
                                        }
                                    }
                                } else {
                                    i = 0;
                                    eVar6.a(bVar, dVar6, eVar6.J[0]);
                                }
                            }
                            bVar2.e = i;
                            i2 = i;
                        } else if (i53 == 16981) {
                            i6 = 0;
                            byte[] bArr4 = new byte[i54];
                            eVar6.t.f = bArr4;
                            bVar.b(bArr4, 0, i54, false);
                        } else if (i53 == 18402) {
                            i6 = 0;
                            byte[] bArr5 = new byte[i54];
                            eVar6.t.g = bArr5;
                            bVar.b(bArr5, 0, i54, false);
                        } else if (i53 == 21419) {
                            i6 = 0;
                            Arrays.fill(eVar6.i.f2184a, (byte) 0);
                            bVar.b(eVar6.i.f2184a, 4 - i54, i54, false);
                            eVar6.i.e(0);
                            eVar6.v = (int) eVar6.i.k();
                        } else if (i53 != 25506) {
                            if (i53 != 30322) {
                                eVar6.getClass();
                                throw new r(m.a("Unexpected id: ", i53));
                            }
                            byte[] bArr6 = new byte[i54];
                            eVar6.t.o = bArr6;
                            i6 = 0;
                            bVar.b(bArr6, 0, i54, false);
                        } else {
                            i6 = 0;
                            byte[] bArr7 = new byte[i54];
                            eVar6.t.h = bArr7;
                            bVar.b(bArr7, 0, i54, false);
                        }
                        i = i6;
                        bVar2.e = i;
                        i2 = i;
                    }
                    z4 = true;
                    z2 = i2;
                    if (z4) {
                        j = bVar.c;
                        if (this.x) {
                            this.z = j;
                            oVar.f2054a = this.y;
                            this.x = z2;
                            return 1;
                        }
                        if (this.u) {
                            j2 = this.z;
                            if (j2 != -1) {
                                oVar.f2054a = j2;
                                this.z = -1L;
                                return 1;
                            }
                        } else {
                            continue;
                        }
                    }
                    i30 = 0;
                } else {
                    bVar.a((int) bVar2.g);
                    bVar2.e = 0;
                    i30 = 0;
                }
            }
        }
        int i62 = i30;
        if (z4) {
            return i62;
        }
        return -1;
    }

    public final void a(d dVar, long j) {
        byte[] bArrB;
        if ("S_TEXT/UTF8".equals(dVar.f2027a)) {
            byte[] bArr = this.k.f2184a;
            long j2 = this.G;
            if (j2 == -9223372036854775807L) {
                bArrB = a0;
            } else {
                int i = (int) (j2 / 3600000000L);
                long j3 = j2 - (((long) i) * 3600000000L);
                int i2 = (int) (j3 / 60000000);
                long j4 = j3 - ((long) (60000000 * i2));
                int i3 = (int) (j4 / 1000000);
                bArrB = z.b(String.format(Locale.US, "%02d:%02d:%02d,%03d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((int) ((j4 - ((long) (1000000 * i3))) / 1000))));
            }
            System.arraycopy(bArrB, 0, bArr, 19, 12);
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.r rVar = dVar.O;
            n nVar = this.k;
            rVar.a(nVar.c, nVar);
            this.V += this.k.c;
        }
        dVar.O.a(j, this.M, this.V, 0, dVar.g);
        this.W = true;
        this.N = 0;
        this.V = 0;
        this.U = 0;
        this.O = false;
        this.P = false;
        this.R = false;
        this.T = 0;
        this.S = (byte) 0;
        this.Q = false;
        n nVar2 = this.j;
        nVar2.b = 0;
        nVar2.c = 0;
    }

    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar, int i) throws InterruptedException, EOFException {
        n nVar = this.g;
        if (nVar.c >= i) {
            return;
        }
        if (nVar.a() < i) {
            n nVar2 = this.g;
            byte[] bArr = nVar2.f2184a;
            byte[] bArrCopyOf = Arrays.copyOf(bArr, Math.max(bArr.length * 2, i));
            int i2 = this.g.c;
            nVar2.f2184a = bArrCopyOf;
            nVar2.c = i2;
            nVar2.b = 0;
        }
        n nVar3 = this.g;
        byte[] bArr2 = nVar3.f2184a;
        int i3 = nVar3.c;
        bVar.b(bArr2, i3, i - i3, false);
        this.g.d(i);
    }

    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar, d dVar, int i) throws InterruptedException, r, EOFException {
        int iA;
        int iA2;
        int i2;
        if ("S_TEXT/UTF8".equals(dVar.f2027a)) {
            byte[] bArr = Z;
            int i3 = i + 32;
            if (this.k.a() < i3) {
                this.k.f2184a = Arrays.copyOf(bArr, i3 + i);
            }
            bVar.b(this.k.f2184a, 32, i, false);
            this.k.e(0);
            this.k.d(i3);
            return;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.r rVar = dVar.O;
        if (!this.O) {
            if (dVar.e) {
                this.M &= -1073741825;
                if (!this.P) {
                    bVar.b(this.g.f2184a, 0, 1, false);
                    this.N++;
                    byte b = this.g.f2184a[0];
                    if ((b & 128) != 128) {
                        this.S = b;
                        this.P = true;
                    } else {
                        throw new r("Extension bit is set in signal byte");
                    }
                }
                byte b2 = this.S;
                if ((b2 & 1) == 1) {
                    boolean z = (b2 & 2) == 2;
                    this.M |= 1073741824;
                    if (!this.Q) {
                        bVar.b(this.l.f2184a, 0, 8, false);
                        this.N += 8;
                        this.Q = true;
                        n nVar = this.g;
                        nVar.f2184a[0] = (byte) ((z ? 128 : 0) | 8);
                        nVar.e(0);
                        rVar.a(1, this.g);
                        this.V++;
                        this.l.e(0);
                        rVar.a(8, this.l);
                        this.V += 8;
                    }
                    if (z) {
                        if (!this.R) {
                            bVar.b(this.g.f2184a, 0, 1, false);
                            this.N++;
                            this.g.e(0);
                            this.T = this.g.j();
                            this.R = true;
                        }
                        int i4 = this.T * 4;
                        this.g.c(i4);
                        bVar.b(this.g.f2184a, 0, i4, false);
                        this.N += i4;
                        short s = (short) ((this.T / 2) + 1);
                        int i5 = (s * 6) + 2;
                        ByteBuffer byteBuffer = this.n;
                        if (byteBuffer == null || byteBuffer.capacity() < i5) {
                            this.n = ByteBuffer.allocate(i5);
                        }
                        this.n.position(0);
                        this.n.putShort(s);
                        int i6 = 0;
                        int i7 = 0;
                        while (true) {
                            i2 = this.T;
                            if (i6 >= i2) {
                                break;
                            }
                            int iM = this.g.m();
                            if (i6 % 2 == 0) {
                                this.n.putShort((short) (iM - i7));
                            } else {
                                this.n.putInt(iM - i7);
                            }
                            i6++;
                            i7 = iM;
                        }
                        int i8 = (i - this.N) - i7;
                        if (i2 % 2 == 1) {
                            this.n.putInt(i8);
                        } else {
                            this.n.putShort((short) i8);
                            this.n.putInt(0);
                        }
                        n nVar2 = this.m;
                        nVar2.f2184a = this.n.array();
                        nVar2.c = i5;
                        nVar2.b = 0;
                        rVar.a(i5, this.m);
                        this.V += i5;
                    }
                }
            } else {
                byte[] bArr2 = dVar.f;
                if (bArr2 != null) {
                    n nVar3 = this.j;
                    int length = bArr2.length;
                    nVar3.f2184a = bArr2;
                    nVar3.c = length;
                    nVar3.b = 0;
                }
            }
            this.O = true;
        }
        int i9 = i + this.j.c;
        if (!"V_MPEG4/ISO/AVC".equals(dVar.f2027a) && !"V_MPEGH/ISO/HEVC".equals(dVar.f2027a)) {
            while (true) {
                int i10 = this.N;
                if (i10 >= i9) {
                    break;
                }
                int i11 = i9 - i10;
                n nVar4 = this.j;
                int i12 = nVar4.c - nVar4.b;
                if (i12 > 0) {
                    iA2 = Math.min(i11, i12);
                    rVar.a(iA2, this.j);
                } else {
                    iA2 = rVar.a(bVar, i11, false);
                }
                this.N += iA2;
                this.V += iA2;
            }
        } else {
            byte[] bArr3 = this.f.f2184a;
            bArr3[0] = 0;
            bArr3[1] = 0;
            bArr3[2] = 0;
            int i13 = dVar.P;
            int i14 = 4 - i13;
            while (this.N < i9) {
                int i15 = this.U;
                if (i15 == 0) {
                    n nVar5 = this.j;
                    int iMin = Math.min(i13, nVar5.c - nVar5.b);
                    bVar.b(bArr3, i14 + iMin, i13 - iMin, false);
                    if (iMin > 0) {
                        this.j.a(bArr3, i14, iMin);
                    }
                    this.N += i13;
                    this.f.e(0);
                    this.U = this.f.m();
                    this.e.e(0);
                    rVar.a(4, this.e);
                    this.V += 4;
                } else {
                    n nVar6 = this.j;
                    int i16 = nVar6.c - nVar6.b;
                    if (i16 > 0) {
                        iA = Math.min(i15, i16);
                        rVar.a(iA, this.j);
                    } else {
                        iA = rVar.a(bVar, i15, false);
                    }
                    this.N += iA;
                    this.V += iA;
                    this.U = i15 - iA;
                }
            }
        }
        if ("A_VORBIS".equals(dVar.f2027a)) {
            this.h.e(0);
            rVar.a(4, this.h);
            this.V += 4;
        }
    }

    public final long a(long j) throws r {
        long j2 = this.q;
        if (j2 != -9223372036854775807L) {
            return z.a(j, j2, 1000L);
        }
        throw new r("Can't scale timecode prior to timecodeScale being set.");
    }
}
