package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.media.DeniedByServerException;
import android.media.MediaCodec;
import android.media.MediaDrm;
import android.media.MediaDrmResetException;
import android.media.NotProvisionedException;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.media.metrics.NetworkEvent;
import android.media.metrics.PlaybackErrorEvent;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.PlaybackStateEvent;
import android.media.metrics.TrackChangeEvent;
import android.os.SystemClock;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.util.Pair;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: classes7.dex */
public final class jw0 implements ld, ai1 {
    private boolean A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9355a;
    private final h00 b;
    private final PlaybackSession c;
    private String i;
    private PlaybackMetrics.Builder j;
    private int k;
    private uh1 n;
    private b o;
    private b p;
    private b q;
    private gc0 r;
    private gc0 s;
    private gc0 t;
    private boolean u;
    private int v;
    private boolean w;
    private int x;
    private int y;
    private int z;
    private final b52.d e = new b52.d();
    private final b52.b f = new b52.b();
    private final HashMap<String, Long> h = new HashMap<>();
    private final HashMap<String, Long> g = new HashMap<>();
    private final long d = SystemClock.elapsedRealtime();
    private int l = 0;
    private int m = 0;

    public static jw0 a(Context context) {
        MediaMetricsManager mediaMetricsManager = (MediaMetricsManager) context.getSystemService("media_metrics");
        if (mediaMetricsManager == null) {
            return null;
        }
        return new jw0(context, mediaMetricsManager.createPlaybackSession());
    }

    private jw0(Context context, PlaybackSession playbackSession) {
        this.f9355a = context.getApplicationContext();
        this.c = playbackSession;
        h00 h00Var = new h00();
        this.b = h00Var;
        h00Var.a(this);
    }

    public final LogSessionId b() {
        return this.c.getSessionId();
    }

    public final void b(ld.a aVar, String str) {
        rw0.b bVar = aVar.d;
        if ((bVar == null || !bVar.a()) && str.equals(this.i)) {
            a();
        }
        this.g.remove(str);
        this.h.remove(str);
    }

    private void a() {
        PlaybackMetrics.Builder builder = this.j;
        if (builder != null && this.A) {
            builder.setAudioUnderrunCount(this.z);
            this.j.setVideoFramesDropped(this.x);
            this.j.setVideoFramesPlayed(this.y);
            Long l = this.g.get(this.i);
            this.j.setNetworkTransferDurationMillis(l == null ? 0L : l.longValue());
            Long l2 = this.h.get(this.i);
            this.j.setNetworkBytesRead(l2 == null ? 0L : l2.longValue());
            this.j.setStreamSource((l2 == null || l2.longValue() <= 0) ? 0 : 1);
            this.c.reportPlaybackMetrics(this.j.build());
        }
        this.j = null;
        this.i = null;
        this.z = 0;
        this.x = 0;
        this.y = 0;
        this.r = null;
        this.s = null;
        this.t = null;
        this.A = false;
    }

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f9356a;
        public final int b;

        public a(int i, int i2) {
            this.f9356a = i;
            this.b = i2;
        }
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final gc0 f9357a;
        public final int b;
        public final String c;

        public b(gc0 gc0Var, int i, String str) {
            this.f9357a = gc0Var;
            this.b = i;
            this.c = str;
        }
    }

    @RequiresNonNull({"metricsBuilder"})
    private void a(b52 b52Var, rw0.b bVar) {
        int iA;
        PlaybackMetrics.Builder builder = this.j;
        if (bVar == null || (iA = b52Var.a(bVar.f9759a)) == -1) {
            return;
        }
        int i = 0;
        b52Var.a(iA, this.f, false);
        b52Var.a(this.f.d, this.e, 0L);
        fw0.g gVar = this.e.d.c;
        if (gVar != null) {
            int iA2 = x82.a(gVar.f8935a, gVar.b);
            if (iA2 == 0) {
                i = 3;
            } else if (iA2 != 1) {
                i = iA2 != 2 ? 1 : 4;
            } else {
                i = 5;
            }
        }
        builder.setStreamType(i);
        b52.d dVar = this.e;
        if (dVar.o != -9223372036854775807L && !dVar.m && !dVar.j && !dVar.a()) {
            builder.setMediaDurationMillis(x82.b(this.e.o));
        }
        builder.setPlaybackType(this.e.a() ? 2 : 1);
        this.A = true;
    }

    public final void a(ld.a aVar, int i, long j) {
        rw0.b bVar = aVar.d;
        if (bVar != null) {
            String strA = this.b.a(aVar.b, bVar);
            Long l = this.h.get(strA);
            Long l2 = this.g.get(strA);
            this.h.put(strA, Long.valueOf((l == null ? 0L : l.longValue()) + j));
            this.g.put(strA, Long.valueOf((l2 != null ? l2.longValue() : 0L) + ((long) i)));
        }
    }

    public final void a(ld.a aVar, hw0 hw0Var) {
        if (aVar.d == null) {
            return;
        }
        gc0 gc0Var = hw0Var.c;
        gc0Var.getClass();
        int i = hw0Var.d;
        h00 h00Var = this.b;
        b52 b52Var = aVar.b;
        rw0.b bVar = aVar.d;
        bVar.getClass();
        b bVar2 = new b(gc0Var, i, h00Var.a(b52Var, bVar));
        int i2 = hw0Var.b;
        if (i2 != 0) {
            if (i2 == 1) {
                this.p = bVar2;
                return;
            } else if (i2 != 2) {
                if (i2 != 3) {
                    return;
                }
                this.q = bVar2;
                return;
            }
        }
        this.o = bVar2;
    }

    /* JADX WARN: Code duplicated, block: B:114:0x018b  */
    /* JADX WARN: Code duplicated, block: B:115:0x018e  */
    /* JADX WARN: Code duplicated, block: B:116:0x0191  */
    /* JADX WARN: Code duplicated, block: B:227:0x0363  */
    /* JADX WARN: Code duplicated, block: B:233:0x0374  */
    /* JADX WARN: Code duplicated, block: B:234:0x0376  */
    /* JADX WARN: Code duplicated, block: B:235:0x0379  */
    /* JADX WARN: Code duplicated, block: B:236:0x037c  */
    /* JADX WARN: Code duplicated, block: B:237:0x037e  */
    /* JADX WARN: Code duplicated, block: B:275:0x0445  */
    /* JADX WARN: Code duplicated, block: B:373:0x05a0 A[PHI: r0
  0x05a0: PHI (r0v25 int) = (r0v23 int), (r0v22 int) binds: [B:371:0x059b, B:361:0x0585] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v50, types: [com.yandex.mobile.ads.impl.u62] */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v16, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r1v92, types: [android.media.metrics.NetworkEvent$Builder] */
    /* JADX WARN: Type inference failed for: r22v0, types: [com.yandex.mobile.ads.impl.jw0] */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r5v35 */
    /* JADX WARN: Type inference failed for: r5v36 */
    /* JADX WARN: Type inference failed for: r5v37 */
    /* JADX WARN: Type inference failed for: r5v38 */
    /* JADX WARN: Type inference failed for: r5v39 */
    /* JADX WARN: Type inference failed for: r5v40 */
    /* JADX WARN: Type inference failed for: r5v41 */
    /* JADX WARN: Type inference failed for: r5v42 */
    /* JADX WARN: Type inference failed for: r5v43, types: [int] */
    /* JADX WARN: Type inference failed for: r5v44 */
    /* JADX WARN: Type inference failed for: r5v45 */
    /* JADX WARN: Type inference failed for: r5v46, types: [int] */
    /* JADX WARN: Type inference failed for: r5v47 */
    /* JADX WARN: Type inference failed for: r5v48 */
    /* JADX WARN: Type inference failed for: r5v49, types: [int] */
    /* JADX WARN: Type inference failed for: r5v50 */
    /* JADX WARN: Type inference failed for: r5v51 */
    /* JADX WARN: Type inference failed for: r5v52, types: [int] */
    /* JADX WARN: Type inference failed for: r5v53 */
    /* JADX WARN: Type inference failed for: r5v54 */
    /* JADX WARN: Type inference failed for: r5v55, types: [int] */
    /* JADX WARN: Type inference failed for: r5v56 */
    /* JADX WARN: Type inference failed for: r5v57 */
    /* JADX WARN: Type inference failed for: r5v58, types: [int] */
    /* JADX WARN: Type inference failed for: r5v59 */
    /* JADX WARN: Type inference failed for: r5v60 */
    public final void a(di1 di1Var, ld.b bVar) {
        int i;
        boolean z;
        int i2;
        int i3;
        char c;
        int i4;
        a aVar;
        char c2;
        int i5;
        a aVar2;
        int i6;
        int i7;
        char c3;
        int i8;
        a aVar3;
        ?? r13;
        int i9;
        ?? r5;
        int i10;
        c40 c40Var;
        int i11;
        if (bVar.a() == 0) {
            return;
        }
        for (int i12 = 0; i12 < bVar.a(); i12++) {
            int iB = bVar.b(i12);
            ld.a aVarC = bVar.c(iB);
            if (iB == 0) {
                this.b.d(aVarC);
            } else if (iB == 11) {
                this.b.a(aVarC, this.k);
            } else {
                this.b.c(aVarC);
            }
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (bVar.a(0)) {
            ld.a aVarC2 = bVar.c(0);
            if (this.j != null) {
                a(aVarC2.b, aVarC2.d);
            }
        }
        if (bVar.a(2) && this.j != null) {
            c82<u62.a> c82VarListIterator = di1Var.getCurrentTracks().a().listIterator(0);
            loop1: while (true) {
                if (!c82VarListIterator.hasNext()) {
                    c40Var = null;
                    break;
                }
                u62.a next = c82VarListIterator.next();
                for (int i13 = 0; i13 < next.b; i13++) {
                    if (next.b(i13) && (c40Var = next.a(i13).p) != null) {
                        break loop1;
                    }
                }
            }
            if (c40Var != null) {
                PlaybackMetrics.Builder builder = this.j;
                int i14 = x82.f10629a;
                int i15 = 0;
                while (true) {
                    if (i15 >= c40Var.e) {
                        i11 = 1;
                        break;
                    }
                    UUID uuid = c40Var.a(i15).c;
                    if (uuid.equals(qm.d)) {
                        i11 = 3;
                        break;
                    } else if (uuid.equals(qm.e)) {
                        i11 = 2;
                        break;
                    } else {
                        if (uuid.equals(qm.c)) {
                            i11 = 6;
                            break;
                        }
                        i15++;
                    }
                }
                builder.setDrmType(i11);
            }
        }
        if (bVar.a(1011)) {
            this.z++;
        }
        uh1 uh1Var = this.n;
        int i16 = 4;
        if (uh1Var == null) {
            r13 = 1;
            c = '\b';
            i4 = 7;
            i2 = 9;
            i3 = 6;
        } else {
            Context context = this.f9355a;
            boolean z2 = this.v == 4;
            if (uh1Var.b == 1001) {
                aVar = new a(20, 0);
            } else {
                if (uh1Var instanceof j60) {
                    j60 j60Var = (j60) uh1Var;
                    boolean z3 = j60Var.d == 1;
                    i = j60Var.h;
                    z = z3;
                } else {
                    i = 0;
                    z = false;
                }
                Throwable cause = uh1Var.getCause();
                cause.getClass();
                if (cause instanceof IOException) {
                    if (cause instanceof qh0) {
                        aVar3 = new a(5, ((qh0) cause).e);
                    } else {
                        if (!(cause instanceof ph0) && !(cause instanceof ag1)) {
                            boolean z4 = cause instanceof oh0;
                            if (!z4 && !(cause instanceof s72.a)) {
                                if (uh1Var.b == 1002) {
                                    aVar = new a(21, 0);
                                } else if (cause instanceof d40.a) {
                                    Throwable cause2 = cause.getCause();
                                    cause2.getClass();
                                    int i17 = x82.f10629a;
                                    if (i17 >= 21 && (cause2 instanceof MediaDrm.MediaDrmStateException)) {
                                        int iA = x82.a(((MediaDrm.MediaDrmStateException) cause2).getDiagnosticInfo());
                                        if (iA == 2 || iA == 4) {
                                            c3 = 6005;
                                        } else if (iA == 10) {
                                            c3 = 6004;
                                        } else if (iA == 7) {
                                            c3 = 6005;
                                        } else if (iA != 8) {
                                            switch (iA) {
                                                case 15:
                                                    c3 = 6003;
                                                    break;
                                                case 16:
                                                case 18:
                                                    c3 = 6005;
                                                    break;
                                                case 17:
                                                case 19:
                                                case 20:
                                                case 21:
                                                case 22:
                                                    c3 = 6004;
                                                    break;
                                                default:
                                                    switch (iA) {
                                                        case 24:
                                                        case 25:
                                                        case 26:
                                                        case 27:
                                                        case 28:
                                                            c3 = 6002;
                                                            break;
                                                        default:
                                                            c3 = 6006;
                                                            break;
                                                    }
                                                    break;
                                            }
                                        } else {
                                            c3 = 6003;
                                        }
                                        switch (c3) {
                                            case 6002:
                                                i8 = 24;
                                                break;
                                            case 6003:
                                                i8 = 28;
                                                break;
                                            case 6004:
                                                i8 = 25;
                                                break;
                                            case 6005:
                                                i8 = 26;
                                                break;
                                            default:
                                                i8 = 27;
                                                break;
                                        }
                                        aVar3 = new a(i8, iA);
                                    } else if (i17 >= 23 && (cause2 instanceof MediaDrmResetException)) {
                                        aVar = new a(27, 0);
                                    } else if (i17 >= 18 && (cause2 instanceof NotProvisionedException)) {
                                        aVar = new a(24, 0);
                                    } else if (i17 >= 18 && (cause2 instanceof DeniedByServerException)) {
                                        aVar = new a(29, 0);
                                    } else if (cause2 instanceof e82) {
                                        aVar = new a(23, 0);
                                    } else if (cause2 instanceof pz.d) {
                                        aVar = new a(28, 0);
                                    } else {
                                        aVar = new a(30, 0);
                                    }
                                } else if ((cause instanceof eb0.c) && (cause.getCause() instanceof FileNotFoundException)) {
                                    Throwable cause3 = cause.getCause();
                                    cause3.getClass();
                                    Throwable cause4 = cause3.getCause();
                                    if (x82.f10629a >= 21 && (cause4 instanceof ErrnoException) && ((ErrnoException) cause4).errno == OsConstants.EACCES) {
                                        aVar = new a(32, 0);
                                    } else {
                                        aVar = new a(31, 0);
                                    }
                                } else {
                                    i6 = 9;
                                    aVar = new a(9, 0);
                                }
                            } else {
                                i6 = 9;
                                if (ad1.a(context).a() == 1) {
                                    aVar = new a(3, 0);
                                } else {
                                    Throwable cause5 = cause.getCause();
                                    if (cause5 instanceof UnknownHostException) {
                                        i7 = 6;
                                        aVar = new a(6, 0);
                                    } else {
                                        i7 = 6;
                                        if (cause5 instanceof SocketTimeoutException) {
                                            i4 = 7;
                                            aVar = new a(7, 0);
                                            i2 = 9;
                                            i3 = 6;
                                            c = '\b';
                                        } else {
                                            if (z4 && ((oh0) cause).d == 1) {
                                                aVar = new a(4, 0);
                                            } else {
                                                aVar = new a(8, 0);
                                                i2 = 9;
                                                c = '\b';
                                                i3 = 6;
                                            }
                                            i4 = 7;
                                        }
                                        this.c.reportPlaybackErrorEvent(new PlaybackErrorEvent.Builder().setTimeSinceCreatedMillis(jElapsedRealtime - this.d).setErrorCode(aVar.f9356a).setSubErrorCode(aVar.b).setException(uh1Var).build());
                                        r13 = 1;
                                        this.A = true;
                                        this.n = null;
                                    }
                                }
                            }
                            i2 = i6;
                            c = '\b';
                            i4 = 7;
                            i3 = 6;
                            this.c.reportPlaybackErrorEvent(new PlaybackErrorEvent.Builder().setTimeSinceCreatedMillis(jElapsedRealtime - this.d).setErrorCode(aVar.f9356a).setSubErrorCode(aVar.b).setException(uh1Var).build());
                            r13 = 1;
                            this.A = true;
                            this.n = null;
                        } else {
                            i6 = 9;
                            i7 = 6;
                            aVar = new a(z2 ? 10 : 11, 0);
                        }
                        i2 = i6;
                        i3 = i7;
                    }
                    aVar = aVar3;
                } else {
                    i2 = 9;
                    i3 = 6;
                    if (z && (i == 0 || i == 1)) {
                        aVar = new a(35, 0);
                    } else if (z && i == 3) {
                        aVar = new a(15, 0);
                    } else {
                        if (z && i == 2) {
                            aVar = new a(23, 0);
                        } else {
                            if (cause instanceof iv0.b) {
                                aVar2 = new a(13, x82.a(((iv0.b) cause).e));
                            } else {
                                if (cause instanceof fv0) {
                                    aVar = new a(14, x82.a(((fv0) cause).b));
                                } else if (cause instanceof OutOfMemoryError) {
                                    aVar = new a(14, 0);
                                } else if (cause instanceof vh.b) {
                                    aVar2 = new a(17, ((vh.b) cause).b);
                                } else if (cause instanceof vh.e) {
                                    aVar2 = new a(18, ((vh.e) cause).b);
                                } else if (x82.f10629a >= 16 && (cause instanceof MediaCodec.CryptoException)) {
                                    int errorCode = ((MediaCodec.CryptoException) cause).getErrorCode();
                                    if (errorCode == 2 || errorCode == 4) {
                                        c = '\b';
                                        i4 = 7;
                                    } else {
                                        if (errorCode != 10) {
                                            i4 = 7;
                                            c = '\b';
                                            if (errorCode != 7) {
                                                if (errorCode != 8) {
                                                    switch (errorCode) {
                                                        case 15:
                                                            c2 = 6003;
                                                            break;
                                                        case 16:
                                                        case 18:
                                                            break;
                                                        case 17:
                                                        case 19:
                                                        case 20:
                                                        case 21:
                                                        case 22:
                                                            break;
                                                        default:
                                                            switch (errorCode) {
                                                                case 24:
                                                                case 25:
                                                                case 26:
                                                                case 27:
                                                                case 28:
                                                                    c2 = 6002;
                                                                    break;
                                                                default:
                                                                    c2 = 6006;
                                                                    break;
                                                            }
                                                            break;
                                                    }
                                                } else {
                                                    c2 = 6003;
                                                }
                                            }
                                            switch (c2) {
                                                case 6002:
                                                    i5 = 24;
                                                    break;
                                                case 6003:
                                                    i5 = 28;
                                                    break;
                                                case 6004:
                                                    i5 = 25;
                                                    break;
                                                case 6005:
                                                    i5 = 26;
                                                    break;
                                                default:
                                                    i5 = 27;
                                                    break;
                                            }
                                            aVar = new a(i5, errorCode);
                                        } else {
                                            c = '\b';
                                            i4 = 7;
                                        }
                                        c2 = 6004;
                                        switch (c2) {
                                            case 6002:
                                                i5 = 24;
                                                break;
                                            case 6003:
                                                i5 = 28;
                                                break;
                                            case 6004:
                                                i5 = 25;
                                                break;
                                            case 6005:
                                                i5 = 26;
                                                break;
                                            default:
                                                i5 = 27;
                                                break;
                                        }
                                        aVar = new a(i5, errorCode);
                                    }
                                    c2 = 6005;
                                    switch (c2) {
                                        case 6002:
                                            i5 = 24;
                                            break;
                                        case 6003:
                                            i5 = 28;
                                            break;
                                        case 6004:
                                            i5 = 25;
                                            break;
                                        case 6005:
                                            i5 = 26;
                                            break;
                                        default:
                                            i5 = 27;
                                            break;
                                    }
                                    aVar = new a(i5, errorCode);
                                } else {
                                    c = '\b';
                                    i4 = 7;
                                    aVar = new a(22, 0);
                                }
                                c = '\b';
                                i4 = 7;
                            }
                            aVar = aVar2;
                            c = '\b';
                            i4 = 7;
                        }
                        this.c.reportPlaybackErrorEvent(new PlaybackErrorEvent.Builder().setTimeSinceCreatedMillis(jElapsedRealtime - this.d).setErrorCode(aVar.f9356a).setSubErrorCode(aVar.b).setException(uh1Var).build());
                        r13 = 1;
                        this.A = true;
                        this.n = null;
                    }
                }
                c = '\b';
                i4 = 7;
                this.c.reportPlaybackErrorEvent(new PlaybackErrorEvent.Builder().setTimeSinceCreatedMillis(jElapsedRealtime - this.d).setErrorCode(aVar.f9356a).setSubErrorCode(aVar.b).setException(uh1Var).build());
                r13 = 1;
                this.A = true;
                this.n = null;
            }
            c = '\b';
            i4 = 7;
            i2 = 9;
            i3 = 6;
            this.c.reportPlaybackErrorEvent(new PlaybackErrorEvent.Builder().setTimeSinceCreatedMillis(jElapsedRealtime - this.d).setErrorCode(aVar.f9356a).setSubErrorCode(aVar.b).setException(uh1Var).build());
            r13 = 1;
            this.A = true;
            this.n = null;
        }
        if (bVar.a(2)) {
            ?? currentTracks = di1Var.getCurrentTracks();
            boolean zA = currentTracks.a(2);
            boolean zA2 = currentTracks.a(r13);
            boolean zA3 = currentTracks.a(3);
            if (zA || zA2 || zA3) {
                if (zA || x82.a(this.r, (Object) null)) {
                    i9 = 5;
                } else {
                    ?? r16 = this.r == null ? r13 : 0;
                    this.r = null;
                    i9 = 5;
                    a(1, jElapsedRealtime, null, r16 == true ? 1 : 0);
                }
                if (!zA2 && !x82.a(this.s, (Object) null)) {
                    ?? r6 = this.s == null ? r13 : 0;
                    this.s = null;
                    a(0, jElapsedRealtime, null, r6);
                }
                if (!zA3 && !x82.a(this.t, (Object) null)) {
                    ?? r7 = this.t == null ? r13 : 0;
                    this.t = null;
                    a(2, jElapsedRealtime, null, r7);
                }
            } else {
                c = c;
                i16 = 4;
                i4 = i4;
                i9 = 5;
            }
        } else {
            c = c;
            i16 = 4;
            i4 = i4;
            i9 = 5;
        }
        b bVar2 = this.o;
        if (bVar2 != null && bVar2.c.equals(this.b.b())) {
            b bVar3 = this.o;
            gc0 gc0Var = bVar3.f9357a;
            if (gc0Var.s != -1) {
                int i18 = bVar3.b;
                if (!x82.a(this.r, gc0Var)) {
                    ?? r8 = (this.r == null && i18 == 0) ? r13 : i18;
                    this.r = gc0Var;
                    a(1, jElapsedRealtime, gc0Var, r8);
                }
                this.o = null;
            }
        }
        b bVar4 = this.p;
        if (bVar4 != null && bVar4.c.equals(this.b.b())) {
            b bVar5 = this.p;
            gc0 gc0Var2 = bVar5.f9357a;
            int i19 = bVar5.b;
            if (!x82.a(this.s, gc0Var2)) {
                ?? r9 = (this.s == null && i19 == 0) ? r13 : i19;
                this.s = gc0Var2;
                a(0, jElapsedRealtime, gc0Var2, r9);
            }
            this.p = null;
        }
        b bVar6 = this.q;
        if (bVar6 != null && bVar6.c.equals(this.b.b())) {
            b bVar7 = this.q;
            gc0 gc0Var3 = bVar7.f9357a;
            int i20 = bVar7.b;
            if (!x82.a(this.t, gc0Var3)) {
                ?? r10 = (this.t == null && i20 == 0) ? r13 : i20;
                this.t = gc0Var3;
                a(2, jElapsedRealtime, gc0Var3, r10);
            }
            this.q = null;
        }
        switch (ad1.a(this.f9355a).a()) {
            case 0:
                r5 = 0;
                break;
            case 1:
                r5 = i2;
                break;
            case 2:
                r5 = 2;
                break;
            case 3:
                r5 = i16;
                break;
            case 4:
                r5 = i9;
                break;
            case 5:
                r5 = i3;
                break;
            case 6:
            case 8:
            default:
                r5 = r13;
                break;
            case 7:
                r5 = 3;
                break;
            case 9:
                r5 = c;
                break;
            case 10:
                r5 = i4;
                break;
        }
        if (r5 != this.m) {
            this.m = r5;
            this.c.reportNetworkEvent(new NetworkEvent.Builder().setNetworkType(r5).setTimeSinceCreatedMillis(jElapsedRealtime - this.d).build());
        }
        if (di1Var.getPlaybackState() != 2) {
            this.u = false;
        }
        if (di1Var.a() == null) {
            this.w = false;
            i10 = 10;
        } else {
            i10 = 10;
            if (bVar.a(10)) {
                this.w = r13;
            }
        }
        int playbackState = di1Var.getPlaybackState();
        if (this.u) {
            i16 = i9;
        } else if (this.w) {
            i16 = 13;
        } else if (playbackState == i16) {
            i16 = 11;
        } else if (playbackState == 2) {
            int i21 = this.l;
            if (i21 == 0 || i21 == 2) {
                i16 = 2;
            } else if (!di1Var.getPlayWhenReady()) {
                i16 = i4;
            } else if (di1Var.getPlaybackSuppressionReason() != 0) {
                i16 = i10;
            } else {
                i16 = i3;
            }
        } else {
            i10 = 3;
            if (playbackState == 3) {
                if (di1Var.getPlayWhenReady()) {
                    if (di1Var.getPlaybackSuppressionReason() != 0) {
                        i16 = i2;
                    } else {
                        i16 = i10;
                    }
                }
            } else {
                i16 = (playbackState != r13 || this.l == 0) ? this.l : 12;
            }
        }
        if (this.l != i16) {
            this.l = i16;
            this.A = r13;
            this.c.reportPlaybackStateEvent(new PlaybackStateEvent.Builder().setState(this.l).setTimeSinceCreatedMillis(jElapsedRealtime - this.d).build());
        }
        if (bVar.a(1028)) {
            this.b.a(bVar.c(1028));
        }
    }

    public final void a(hw0 hw0Var) {
        this.v = hw0Var.f9142a;
    }

    public final void a(uh1 uh1Var) {
        this.n = uh1Var;
    }

    public final void a(int i) {
        if (i == 1) {
            this.u = true;
        }
        this.k = i;
    }

    public final void a(ld.a aVar, String str) {
        rw0.b bVar = aVar.d;
        if (bVar == null || !bVar.a()) {
            a();
            this.i = str;
            this.j = new PlaybackMetrics.Builder().setPlayerName(ExoPlayerLibraryInfo.TAG).setPlayerVersion("2.18.1");
            a(aVar.b, aVar.d);
        }
    }

    public final void a(my myVar) {
        this.x += myVar.g;
        this.y += myVar.e;
    }

    public final void a(uf2 uf2Var) {
        b bVar = this.o;
        if (bVar != null) {
            gc0 gc0Var = bVar.f9357a;
            if (gc0Var.s == -1) {
                this.o = new b(gc0Var.a().o(uf2Var.b).f(uf2Var.c).a(), bVar.b, bVar.c);
            }
        }
    }

    private void a(int i, long j, gc0 gc0Var, int i2) {
        int i3;
        TrackChangeEvent.Builder timeSinceCreatedMillis = new TrackChangeEvent.Builder(i).setTimeSinceCreatedMillis(j - this.d);
        if (gc0Var != null) {
            timeSinceCreatedMillis.setTrackState(1);
            if (i2 != 1) {
                i3 = 3;
                if (i2 != 2) {
                    i3 = i2 != 3 ? 1 : 4;
                }
            } else {
                i3 = 2;
            }
            timeSinceCreatedMillis.setTrackChangeReason(i3);
            String str = gc0Var.l;
            if (str != null) {
                timeSinceCreatedMillis.setContainerMimeType(str);
            }
            String str2 = gc0Var.m;
            if (str2 != null) {
                timeSinceCreatedMillis.setSampleMimeType(str2);
            }
            String str3 = gc0Var.j;
            if (str3 != null) {
                timeSinceCreatedMillis.setCodecName(str3);
            }
            int i4 = gc0Var.i;
            if (i4 != -1) {
                timeSinceCreatedMillis.setBitrate(i4);
            }
            int i5 = gc0Var.r;
            if (i5 != -1) {
                timeSinceCreatedMillis.setWidth(i5);
            }
            int i6 = gc0Var.s;
            if (i6 != -1) {
                timeSinceCreatedMillis.setHeight(i6);
            }
            int i7 = gc0Var.z;
            if (i7 != -1) {
                timeSinceCreatedMillis.setChannelCount(i7);
            }
            int i8 = gc0Var.A;
            if (i8 != -1) {
                timeSinceCreatedMillis.setAudioSampleRate(i8);
            }
            String str4 = gc0Var.d;
            if (str4 != null) {
                int i9 = x82.f10629a;
                String[] strArrSplit = str4.split("-", -1);
                Pair pairCreate = Pair.create(strArrSplit[0], strArrSplit.length >= 2 ? strArrSplit[1] : null);
                timeSinceCreatedMillis.setLanguage((String) pairCreate.first);
                Object obj = pairCreate.second;
                if (obj != null) {
                    timeSinceCreatedMillis.setLanguageRegion((String) obj);
                }
            }
            float f = gc0Var.t;
            if (f != -1.0f) {
                timeSinceCreatedMillis.setVideoFrameRate(f);
            }
        } else {
            timeSinceCreatedMillis.setTrackState(0);
        }
        this.A = true;
        this.c.reportTrackChangeEvent(timeSinceCreatedMillis.build());
    }
}
