package com.fyber.inneractive.sdk.player.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.SystemClock;
import com.fyber.inneractive.sdk.player.exoplayer2.decoder.DecoderCounters;
import com.fyber.inneractive.sdk.player.exoplayer2.o;
import com.fyber.inneractive.sdk.player.exoplayer2.p;
import com.fyber.inneractive.sdk.player.exoplayer2.util.w;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes13.dex */
public abstract class c extends com.fyber.inneractive.sdk.player.exoplayer2.a {
    public static final byte[] O;
    public ByteBuffer[] A;
    public long B;
    public int C;
    public int D;
    public boolean E;
    public boolean F;
    public int G;
    public int H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public DecoderCounters N;
    public final d h;
    public final com.fyber.inneractive.sdk.player.exoplayer2.decoder.c i;
    public final com.fyber.inneractive.sdk.player.exoplayer2.decoder.c j;
    public final p k;
    public final ArrayList l;
    public final MediaCodec.BufferInfo m;
    public o n;
    public MediaCodec o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public ByteBuffer[] z;

    static {
        int i = z.f2192a;
        byte[] bArr = new byte[38];
        for (int i2 = 0; i2 < 38; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) (Character.digit("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78".charAt(i3 + 1), 16) + (Character.digit("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78".charAt(i3), 16) << 4));
        }
        O = bArr;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(int i, boolean z) {
        super(i);
        d dVar = d.f2108a;
        if (z.f2192a < 16) {
            throw new IllegalStateException();
        }
        this.h = dVar;
        this.i = new com.fyber.inneractive.sdk.player.exoplayer2.decoder.c();
        this.j = new com.fyber.inneractive.sdk.player.exoplayer2.decoder.c();
        this.k = new p();
        this.l = new ArrayList();
        this.m = new MediaCodec.BufferInfo();
        this.G = 0;
        this.H = 0;
    }

    public a a(d dVar, o oVar) {
        String str = oVar.f;
        dVar.getClass();
        return j.a(false, str);
    }

    public abstract void a(MediaCodec mediaCodec, MediaFormat mediaFormat);

    public abstract void a(a aVar, MediaCodec mediaCodec, o oVar);

    public abstract void a(String str, long j, long j2);

    public abstract boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, long j3, boolean z);

    public boolean a(boolean z, o oVar, o oVar2) {
        return false;
    }

    public abstract int b(d dVar, o oVar);

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.a
    public boolean e() {
        return this.L;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.a
    public boolean f() {
        if (this.n != null) {
            if ((this.f ? this.g : this.d.isReady()) || this.D >= 0 || (this.B != -9223372036854775807L && SystemClock.elapsedRealtime() < this.B)) {
                return true;
            }
        }
        return false;
    }

    public final boolean k() throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        MediaCodec mediaCodec = this.o;
        if (mediaCodec == null || this.H == 2 || this.K) {
            return false;
        }
        if (this.C < 0) {
            int iDequeueInputBuffer = mediaCodec.dequeueInputBuffer(0L);
            this.C = iDequeueInputBuffer;
            if (iDequeueInputBuffer < 0) {
                return false;
            }
            com.fyber.inneractive.sdk.player.exoplayer2.decoder.c cVar = this.i;
            cVar.c = this.z[iDequeueInputBuffer];
            cVar.a();
        }
        if (this.H == 1) {
            if (!this.t) {
                this.J = true;
                this.o.queueInputBuffer(this.C, 0, 0, 0L, 4);
                this.C = -1;
            }
            this.H = 2;
            return false;
        }
        if (this.x) {
            this.x = false;
            ByteBuffer byteBuffer = this.i.c;
            byte[] bArr = O;
            byteBuffer.put(bArr);
            this.o.queueInputBuffer(this.C, 0, bArr.length, 0L, 0);
            this.C = -1;
            this.I = true;
            return true;
        }
        if (this.G == 1) {
            for (int i = 0; i < this.n.h.size(); i++) {
                this.i.c.put((byte[]) this.n.h.get(i));
            }
            this.G = 2;
        }
        int iPosition = this.i.c.position();
        int iA = a(this.k, this.i, false);
        if (iA == -3) {
            return false;
        }
        if (iA == -5) {
            if (this.G == 2) {
                this.i.a();
                this.G = 1;
            }
            a(this.k.f2117a);
            return true;
        }
        if (this.i.b(4)) {
            if (this.G == 2) {
                this.i.a();
                this.G = 1;
            }
            this.K = true;
            if (!this.I) {
                n();
                return false;
            }
            try {
                if (!this.t) {
                    this.J = true;
                    this.o.queueInputBuffer(this.C, 0, 0, 0L, 4);
                    this.C = -1;
                }
                return false;
            } catch (MediaCodec.CryptoException e) {
                throw new com.fyber.inneractive.sdk.player.exoplayer2.d(e);
            }
        }
        if (this.M && !this.i.b(1)) {
            this.i.a();
            if (this.G == 2) {
                this.G = 1;
            }
            return true;
        }
        this.M = false;
        boolean zB = this.i.b(1073741824);
        if (this.q && !zB) {
            ByteBuffer byteBuffer2 = this.i.c;
            int iPosition2 = byteBuffer2.position();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = i2 + 1;
                if (i4 >= iPosition2) {
                    byteBuffer2.clear();
                    break;
                }
                int i5 = byteBuffer2.get(i2) & 255;
                if (i3 == 3) {
                    if (i5 == 1 && (byteBuffer2.get(i4) & Ascii.US) == 7) {
                        ByteBuffer byteBufferDuplicate = byteBuffer2.duplicate();
                        byteBufferDuplicate.position(i2 - 3);
                        byteBufferDuplicate.limit(iPosition2);
                        byteBuffer2.position(0);
                        byteBuffer2.put(byteBufferDuplicate);
                        break;
                    }
                } else if (i5 == 0) {
                    i3++;
                }
                if (i5 != 0) {
                    i3 = 0;
                }
                i2 = i4;
            }
            if (this.i.c.position() == 0) {
                return true;
            }
            this.q = false;
        }
        try {
            com.fyber.inneractive.sdk.player.exoplayer2.decoder.c cVar2 = this.i;
            long j = cVar2.d;
            if (cVar2.b(Integer.MIN_VALUE)) {
                this.l.add(Long.valueOf(j));
            }
            this.i.c.flip();
            m();
            if (zB) {
                MediaCodec.CryptoInfo cryptoInfo = this.i.b.d;
                if (iPosition != 0) {
                    if (cryptoInfo.numBytesOfClearData == null) {
                        cryptoInfo.numBytesOfClearData = new int[1];
                    }
                    int[] iArr = cryptoInfo.numBytesOfClearData;
                    iArr[0] = iArr[0] + iPosition;
                }
                this.o.queueSecureInputBuffer(this.C, 0, cryptoInfo, j, 0);
            } else {
                this.o.queueInputBuffer(this.C, 0, this.i.c.limit(), j, 0);
            }
            this.C = -1;
            this.I = true;
            this.G = 0;
            this.N.inputBufferCount++;
            return true;
        } catch (MediaCodec.CryptoException e2) {
            throw new com.fyber.inneractive.sdk.player.exoplayer2.d(e2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:48:0x00ac  */
    public final void l() throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        boolean z;
        if (q()) {
            o oVar = this.n;
            String str = oVar.f;
            try {
                a aVarA = a(this.h, oVar);
                if (aVarA == null) {
                    throw new com.fyber.inneractive.sdk.player.exoplayer2.d(new b(this.n, (f) null, -49999));
                }
                String str2 = aVarA.f2107a;
                this.p = aVarA.b;
                o oVar2 = this.n;
                int i = z.f2192a;
                boolean z2 = false;
                this.q = i < 21 && oVar2.h.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str2);
                this.r = i < 18 || (i == 18 && ("OMX.SEC.avc.dec".equals(str2) || "OMX.SEC.avc.dec.secure".equals(str2))) || (i == 19 && z.d.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str2) || "OMX.Exynos.avc.dec.secure".equals(str2)));
                if (i >= 24 || !("OMX.Nvidia.h264.decode".equals(str2) || "OMX.Nvidia.h264.decode.secure".equals(str2))) {
                    z = false;
                } else {
                    String str3 = z.b;
                    if ("flounder".equals(str3) || "flounder_lte".equals(str3) || "grouper".equals(str3) || "tilapia".equals(str3)) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                this.s = z;
                this.t = i <= 17 && ("OMX.rk.video_decoder.avc".equals(str2) || "OMX.allwinner.video.decoder.avc".equals(str2));
                this.u = (i <= 23 && "OMX.google.vorbis.decoder".equals(str2)) || (i <= 19 && "hb2000".equals(z.b) && ("OMX.amlogic.avc.decoder.awesome".equals(str2) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str2)));
                this.v = i == 21 && "OMX.google.aac.decoder".equals(str2);
                o oVar3 = this.n;
                if (i <= 18 && oVar3.r == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str2)) {
                    z2 = true;
                }
                this.w = z2;
                try {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    w.a("createCodec:" + str2);
                    this.o = MediaCodec.createByCodecName(str2);
                    w.a();
                    w.a("configureCodec");
                    a(aVarA, this.o, this.n);
                    w.a();
                    w.a("startCodec");
                    this.o.start();
                    w.a();
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                    a(str2, jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
                    this.z = this.o.getInputBuffers();
                    this.A = this.o.getOutputBuffers();
                    this.B = this.c == 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
                    this.C = -1;
                    this.D = -1;
                    this.M = true;
                    this.N.decoderInitCount++;
                } catch (Exception e) {
                    throw new com.fyber.inneractive.sdk.player.exoplayer2.d(new b(this.n, e, str2));
                }
            } catch (f e2) {
                throw new com.fyber.inneractive.sdk.player.exoplayer2.d(new b(this.n, e2, -49998));
            }
        }
    }

    public void m() {
    }

    public final void n() throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        if (this.H == 2) {
            o();
            l();
        } else {
            this.L = true;
            p();
        }
    }

    public final void o() {
        if (this.o != null) {
            this.B = -9223372036854775807L;
            this.C = -1;
            this.D = -1;
            this.E = false;
            this.l.clear();
            this.z = null;
            this.A = null;
            this.F = false;
            this.I = false;
            this.p = false;
            this.q = false;
            this.r = false;
            this.s = false;
            this.t = false;
            this.u = false;
            this.w = false;
            this.x = false;
            this.y = false;
            this.J = false;
            this.G = 0;
            this.H = 0;
            this.N.decoderReleaseCount++;
            this.i.c = null;
            try {
                this.o.stop();
                try {
                    this.o.release();
                } finally {
                    this.o = null;
                }
            } catch (Throwable th) {
                try {
                    this.o.release();
                    throw th;
                } finally {
                    this.o = null;
                }
            }
        }
    }

    public void p() {
    }

    public boolean q() {
        return this.o == null && this.n != null;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.a
    public void a(boolean z, long j) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        this.K = false;
        this.L = false;
        if (this.o != null) {
            this.B = -9223372036854775807L;
            this.C = -1;
            this.D = -1;
            this.M = true;
            this.E = false;
            this.l.clear();
            this.x = false;
            this.y = false;
            if (this.r || ((this.u && this.J) || this.H != 0)) {
                o();
                l();
            } else {
                this.o.flush();
                this.I = false;
            }
            if (!this.F || this.n == null) {
                return;
            }
            this.G = 1;
        }
    }

    /* JADX WARN: Code duplicated, block: B:85:0x015c  */
    /* JADX WARN: Code duplicated, block: B:87:0x0178  */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.a
    public final void a(long j, long j2) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        boolean zA;
        boolean z;
        boolean z2;
        if (this.L) {
            p();
            return;
        }
        if (this.n == null) {
            this.j.a();
            int iA = a(this.k, this.j, true);
            if (iA != -5) {
                if (iA == -4) {
                    if (this.j.b(4)) {
                        this.K = true;
                        n();
                        return;
                    }
                    throw new IllegalStateException();
                }
                return;
            }
            a(this.k.f2117a);
        }
        l();
        if (this.o != null) {
            w.a("drainAndFeed");
            do {
                if (this.D < 0) {
                    if (this.v && this.J) {
                        try {
                            this.D = this.o.dequeueOutputBuffer(this.m, 0L);
                        } catch (IllegalStateException unused) {
                            n();
                            if (this.L) {
                                o();
                            }
                        }
                    } else {
                        this.D = this.o.dequeueOutputBuffer(this.m, 0L);
                    }
                    int i = this.D;
                    if (i >= 0) {
                        if (this.y) {
                            this.y = false;
                            this.o.releaseOutputBuffer(i, false);
                            this.D = -1;
                        } else {
                            MediaCodec.BufferInfo bufferInfo = this.m;
                            if ((bufferInfo.flags & 4) != 0) {
                                n();
                                this.D = -1;
                            } else {
                                ByteBuffer byteBuffer = this.A[i];
                                if (byteBuffer != null) {
                                    byteBuffer.position(bufferInfo.offset);
                                    MediaCodec.BufferInfo bufferInfo2 = this.m;
                                    byteBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
                                }
                                long j3 = this.m.presentationTimeUs;
                                int size = this.l.size();
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= size) {
                                        z2 = false;
                                        break;
                                    } else {
                                        if (((Long) this.l.get(i2)).longValue() == j3) {
                                            this.l.remove(i2);
                                            z2 = true;
                                            break;
                                        }
                                        i2++;
                                    }
                                }
                                this.E = z2;
                                if (!this.v) {
                                    MediaCodec mediaCodec = this.o;
                                    ByteBuffer[] byteBufferArr = this.A;
                                    int i3 = this.D;
                                    ByteBuffer byteBuffer2 = byteBufferArr[i3];
                                    MediaCodec.BufferInfo bufferInfo3 = this.m;
                                    int i4 = bufferInfo3.flags;
                                    zA = a(j, j2, mediaCodec, byteBuffer2, i3, bufferInfo3.presentationTimeUs, this.E);
                                    if (zA) {
                                        long j4 = this.m.presentationTimeUs;
                                        this.D = -1;
                                    }
                                } else {
                                    MediaCodec mediaCodec2 = this.o;
                                    ByteBuffer[] byteBufferArr2 = this.A;
                                    int i5 = this.D;
                                    ByteBuffer byteBuffer3 = byteBufferArr2[i5];
                                    MediaCodec.BufferInfo bufferInfo4 = this.m;
                                    int i6 = bufferInfo4.flags;
                                    zA = a(j, j2, mediaCodec2, byteBuffer3, i5, bufferInfo4.presentationTimeUs, this.E);
                                    if (zA) {
                                        long j5 = this.m.presentationTimeUs;
                                        this.D = -1;
                                    }
                                }
                            }
                            z = false;
                        }
                        z = true;
                    } else {
                        if (i == -2) {
                            MediaFormat outputFormat = this.o.getOutputFormat();
                            if (this.s && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
                                this.y = true;
                            } else {
                                if (this.w) {
                                    outputFormat.setInteger("channel-count", 1);
                                }
                                a(this.o, outputFormat);
                            }
                        } else if (i == -3) {
                            this.A = this.o.getOutputBuffers();
                        } else {
                            if (this.t && (this.K || this.H == 2)) {
                                n();
                            }
                            z = false;
                        }
                        z = true;
                    }
                } else {
                    if (!this.v && this.J) {
                        try {
                            MediaCodec mediaCodec3 = this.o;
                            ByteBuffer[] byteBufferArr3 = this.A;
                            int i7 = this.D;
                            ByteBuffer byteBuffer4 = byteBufferArr3[i7];
                            MediaCodec.BufferInfo bufferInfo5 = this.m;
                            int i8 = bufferInfo5.flags;
                            zA = a(j, j2, mediaCodec3, byteBuffer4, i7, bufferInfo5.presentationTimeUs, this.E);
                        } catch (IllegalStateException unused2) {
                            n();
                            if (this.L) {
                                o();
                            }
                        }
                    } else {
                        MediaCodec mediaCodec4 = this.o;
                        ByteBuffer[] byteBufferArr4 = this.A;
                        int i9 = this.D;
                        ByteBuffer byteBuffer5 = byteBufferArr4[i9];
                        MediaCodec.BufferInfo bufferInfo6 = this.m;
                        int i10 = bufferInfo6.flags;
                        zA = a(j, j2, mediaCodec4, byteBuffer5, i9, bufferInfo6.presentationTimeUs, this.E);
                    }
                    if (zA) {
                        long j6 = this.m.presentationTimeUs;
                        this.D = -1;
                        z = true;
                    } else {
                        z = false;
                    }
                }
            } while (z);
            while (k()) {
            }
            w.a();
        } else {
            this.d.a(j - this.e);
            this.j.a();
            int iA2 = a(this.k, this.j, false);
            if (iA2 == -5) {
                a(this.k.f2117a);
            } else if (iA2 == -4) {
                if (this.j.b(4)) {
                    this.K = true;
                    n();
                } else {
                    throw new IllegalStateException();
                }
            }
        }
        this.N.ensureUpdated();
    }

    /* JADX WARN: Code duplicated, block: B:24:0x004c  */
    public void a(o oVar) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        boolean z;
        o oVar2 = this.n;
        this.n = oVar;
        if (!z.a(oVar.i, oVar2 == null ? null : oVar2.i) && this.n.i != null) {
            throw new com.fyber.inneractive.sdk.player.exoplayer2.d(new IllegalStateException("Media requires a DrmSessionManager"));
        }
        if (this.o != null && a(this.p, oVar2, this.n)) {
            this.F = true;
            this.G = 1;
            if (this.s) {
                o oVar3 = this.n;
                z = oVar3.j == oVar2.j && oVar3.k == oVar2.k;
            }
            this.x = z;
            return;
        }
        if (this.I) {
            this.H = 1;
        } else {
            o();
            l();
        }
    }
}
