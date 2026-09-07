package com.fyber.inneractive.sdk.player.exoplayer2.video;

import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import com.amazon.device.ads.DtbConstants;
import com.fyber.inneractive.sdk.player.exoplayer2.decoder.DecoderCounters;
import com.fyber.inneractive.sdk.player.exoplayer2.util.w;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import com.json.b9;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.unity3d.services.core.di.ServiceProvider;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes13.dex */
public class MediaCodecVideoRenderer extends com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c {
    public static final int[] q0 = {1920, IronSourceConstants.RV_OPERATIONAL_LOAD_AD, 1440, 1280, 960, 854, 640, 540, DtbConstants.DEFAULT_PLAYER_HEIGHT};
    public final h P;
    public final VideoRendererEventListener.EventDispatcher Q;
    public final long R;
    public final int S;
    public final boolean T;
    public com.fyber.inneractive.sdk.player.exoplayer2.o[] U;
    public e V;
    public Surface W;
    public int X;
    public boolean Y;
    public long Z;
    public long a0;
    public int b0;
    public int c0;
    public int d0;
    public float e0;
    public int f0;
    public int g0;
    public int h0;
    public float i0;
    public int j0;
    public int k0;
    public int l0;
    public float m0;
    public boolean n0;
    public int o0;
    public f p0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaCodecVideoRenderer(Handler handler, VideoRendererEventListener videoRendererEventListener) {
        super(2, false);
        boolean z = false;
        this.R = 5000L;
        this.S = -1;
        this.P = new h();
        this.Q = new VideoRendererEventListener.EventDispatcher(handler, videoRendererEventListener);
        if (z.f2192a <= 22 && "foster".equals(z.b) && "NVIDIA".equals(z.c)) {
            z = true;
        }
        this.T = z;
        this.Z = -9223372036854775807L;
        this.f0 = -1;
        this.g0 = -1;
        this.i0 = -1.0f;
        this.e0 = -1.0f;
        this.X = 1;
        this.j0 = -1;
        this.k0 = -1;
        this.m0 = -1.0f;
        this.l0 = -1;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.a
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.o[] oVarArr) {
        this.U = oVarArr;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c
    public final int b(com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.d dVar, com.fyber.inneractive.sdk.player.exoplayer2.o oVar) {
        boolean z;
        int i;
        int i2;
        String str = oVar.f;
        if (!"video".equals(com.fyber.inneractive.sdk.player.exoplayer2.util.i.b(str))) {
            return 0;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.drm.d dVar2 = oVar.i;
        if (dVar2 != null) {
            z = false;
            for (int i3 = 0; i3 < dVar2.c; i3++) {
                z |= dVar2.f1995a[i3].e;
            }
        } else {
            z = false;
        }
        dVar.getClass();
        com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.a aVarA = com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.j.a(z, str);
        if (aVarA == null) {
            return 1;
        }
        boolean zA = aVarA.a(oVar.c);
        if (zA && (i = oVar.j) > 0 && (i2 = oVar.k) > 0) {
            if (z.f2192a >= 21) {
                zA = aVarA.a(i, i2, oVar.l);
            } else {
                boolean z2 = i * i2 <= com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.j.a();
                if (!z2) {
                    Log.d("MediaCodecVideoRenderer", "FalseCheck [legacyFrameSize, " + oVar.j + VastAttributes.HORIZONTAL_POSITION + oVar.k + "] [" + z.e + b9.i.e);
                }
                zA = z2;
            }
        }
        return (zA ? 3 : 2) | (aVarA.b ? 8 : 4) | (aVarA.c ? 16 : 0);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c, com.fyber.inneractive.sdk.player.exoplayer2.a
    public final boolean f() {
        if ((this.Y || super.q()) && super.f()) {
            this.Z = -9223372036854775807L;
            return true;
        }
        if (this.Z == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.Z) {
            return true;
        }
        this.Z = -9223372036854775807L;
        return false;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.a
    public final void g() {
        this.f0 = -1;
        this.g0 = -1;
        this.i0 = -1.0f;
        this.e0 = -1.0f;
        this.j0 = -1;
        this.k0 = -1;
        this.m0 = -1.0f;
        this.l0 = -1;
        r();
        h hVar = this.P;
        if (hVar.b) {
            hVar.f2200a.b.sendEmptyMessage(2);
        }
        this.p0 = null;
        try {
            this.n = null;
            o();
        } finally {
            this.N.ensureUpdated();
            this.Q.disabled(this.N);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.a
    public final void h() {
        DecoderCounters decoderCounters = new DecoderCounters();
        this.N = decoderCounters;
        int i = this.b.f2138a;
        this.o0 = i;
        this.n0 = i != 0;
        this.Q.enabled(decoderCounters);
        h hVar = this.P;
        hVar.h = false;
        if (hVar.b) {
            hVar.f2200a.b.sendEmptyMessage(1);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.a
    public final void i() {
        this.b0 = 0;
        this.a0 = SystemClock.elapsedRealtime();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.a
    public final void j() {
        this.Z = -9223372036854775807L;
        if (this.b0 > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.Q.droppedFrames(this.b0, jElapsedRealtime - this.a0);
            this.b0 = 0;
            this.a0 = jElapsedRealtime;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c
    public final void m() {
        if (z.f2192a >= 23 || !this.n0 || this.Y) {
            return;
        }
        this.Y = true;
        this.Q.renderedFirstFrame(this.W);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c
    public final boolean q() {
        Surface surface;
        return super.q() && (surface = this.W) != null && surface.isValid();
    }

    public final void r() {
        MediaCodec mediaCodec;
        this.Y = false;
        if (z.f2192a < 23 || !this.n0 || (mediaCodec = this.o) == null) {
            return;
        }
        this.p0 = new f(this, mediaCodec);
    }

    public final void s() {
        int i = this.f0;
        if (i == -1 && this.g0 == -1) {
            return;
        }
        if (this.j0 == i && this.k0 == this.g0 && this.l0 == this.h0 && this.m0 == this.i0) {
            return;
        }
        this.Q.videoSizeChanged(i, this.g0, this.h0, this.i0);
        this.j0 = this.f0;
        this.k0 = this.g0;
        this.l0 = this.h0;
        this.m0 = this.i0;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c, com.fyber.inneractive.sdk.player.exoplayer2.a
    public final void a(boolean z, long j) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        super.a(z, j);
        r();
        this.c0 = 0;
        if (z) {
            this.Z = this.R > 0 ? SystemClock.elapsedRealtime() + this.R : -9223372036854775807L;
        } else {
            this.Z = -9223372036854775807L;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.a
    public final void a(int i, Object obj) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        if (i != 1) {
            if (i == 4) {
                int iIntValue = ((Integer) obj).intValue();
                this.X = iIntValue;
                MediaCodec mediaCodec = this.o;
                if (mediaCodec != null) {
                    mediaCodec.setVideoScalingMode(iIntValue);
                    return;
                }
                return;
            }
            return;
        }
        Surface surface = (Surface) obj;
        if (this.W == surface) {
            if (surface != null) {
                int i2 = this.j0;
                if (i2 != -1 || this.k0 != -1) {
                    this.Q.videoSizeChanged(i2, this.k0, this.l0, this.m0);
                }
                if (this.Y) {
                    this.Q.renderedFirstFrame(this.W);
                    return;
                }
                return;
            }
            return;
        }
        this.W = surface;
        int i3 = this.c;
        if (i3 == 1 || i3 == 2) {
            MediaCodec mediaCodec2 = this.o;
            if (z.f2192a >= 23 && mediaCodec2 != null && surface != null) {
                mediaCodec2.setOutputSurface(surface);
            } else {
                o();
                l();
            }
        }
        if (surface != null) {
            int i4 = this.j0;
            if (i4 != -1 || this.k0 != -1) {
                this.Q.videoSizeChanged(i4, this.k0, this.l0, this.m0);
            }
            r();
            if (i3 == 2) {
                this.Z = this.R > 0 ? SystemClock.elapsedRealtime() + this.R : -9223372036854775807L;
                return;
            }
            return;
        }
        this.j0 = -1;
        this.k0 = -1;
        this.m0 = -1.0f;
        this.l0 = -1;
        r();
    }

    public static boolean b(boolean z, com.fyber.inneractive.sdk.player.exoplayer2.o oVar, com.fyber.inneractive.sdk.player.exoplayer2.o oVar2) {
        if (!oVar.f.equals(oVar2.f)) {
            return false;
        }
        int i = oVar.m;
        if (i == -1) {
            i = 0;
        }
        int i2 = oVar2.m;
        if (i2 == -1) {
            i2 = 0;
        }
        if (i == i2) {
            return z || (oVar.j == oVar2.j && oVar.k == oVar2.k);
        }
        return false;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.a aVar, MediaCodec mediaCodec, com.fyber.inneractive.sdk.player.exoplayer2.o oVar) {
        e eVar;
        String str;
        Point point;
        int i;
        com.fyber.inneractive.sdk.player.exoplayer2.o[] oVarArr = this.U;
        int iMax = oVar.j;
        int iMax2 = oVar.k;
        int iMax3 = oVar.g;
        if (iMax3 == -1) {
            iMax3 = a(oVar.f, iMax, iMax2);
        }
        if (oVarArr.length == 1) {
            eVar = new e(iMax, iMax2, iMax3);
        } else {
            boolean z = false;
            for (com.fyber.inneractive.sdk.player.exoplayer2.o oVar2 : oVarArr) {
                if (b(aVar.b, oVar, oVar2)) {
                    int i2 = oVar2.j;
                    z |= i2 == -1 || oVar2.k == -1;
                    iMax = Math.max(iMax, i2);
                    iMax2 = Math.max(iMax2, oVar2.k);
                    int iA = oVar2.g;
                    if (iA == -1) {
                        iA = a(oVar2.f, oVar2.j, oVar2.k);
                    }
                    iMax3 = Math.max(iMax3, iA);
                }
            }
            if (z) {
                StringBuilder sbAppend = new StringBuilder("Resolutions unknown. Codec max resolution: ").append(iMax);
                String str2 = VastAttributes.HORIZONTAL_POSITION;
                Log.w("MediaCodecVideoRenderer", sbAppend.append(VastAttributes.HORIZONTAL_POSITION).append(iMax2).toString());
                int i3 = oVar.k;
                int i4 = oVar.j;
                boolean z2 = i3 > i4;
                int i5 = z2 ? i3 : i4;
                if (z2) {
                    i3 = i4;
                }
                float f = i3 / i5;
                int[] iArr = q0;
                int i6 = 0;
                while (true) {
                    if (i6 < 9) {
                        int i7 = iArr[i6];
                        int[] iArr2 = iArr;
                        int i8 = (int) (i7 * f);
                        if (i7 > i5 && i8 > i3) {
                            int i9 = i3;
                            float f2 = f;
                            if (z.f2192a >= 21) {
                                int i10 = z2 ? i8 : i7;
                                if (!z2) {
                                    i7 = i8;
                                }
                                point = aVar.a(i10, i7);
                                str = str2;
                                if (aVar.a(point.x, point.y, oVar.l)) {
                                    break;
                                }
                                i6++;
                                iArr = iArr2;
                                i3 = i9;
                                f = f2;
                                str2 = str;
                            } else {
                                str = str2;
                                int i11 = ((i7 + 15) / 16) * 16;
                                int i12 = ((i8 + 15) / 16) * 16;
                                if (i11 * i12 <= com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.j.a()) {
                                    int i13 = z2 ? i12 : i11;
                                    if (!z2) {
                                        i11 = i12;
                                    }
                                    point = new Point(i13, i11);
                                    break;
                                }
                                i6++;
                                iArr = iArr2;
                                i3 = i9;
                                f = f2;
                                str2 = str;
                            }
                        }
                    }
                    str = str2;
                    point = null;
                    break;
                }
                if (point != null) {
                    iMax = Math.max(iMax, point.x);
                    iMax2 = Math.max(iMax2, point.y);
                    iMax3 = Math.max(iMax3, a(oVar.f, iMax, iMax2));
                    Log.w("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + iMax + str + iMax2);
                }
            }
            eVar = new e(iMax, iMax2, iMax3);
        }
        this.V = eVar;
        boolean z3 = this.T;
        int i14 = this.o0;
        MediaFormat mediaFormatA = oVar.a();
        mediaFormatA.setInteger("max-width", eVar.f2197a);
        mediaFormatA.setInteger("max-height", eVar.b);
        int i15 = eVar.c;
        if (i15 != -1) {
            mediaFormatA.setInteger("max-input-size", i15);
        }
        if (z3) {
            i = 0;
            mediaFormatA.setInteger("auto-frc", 0);
        } else {
            i = 0;
        }
        if (i14 != 0) {
            mediaFormatA.setFeatureEnabled("tunneled-playback", true);
            mediaFormatA.setInteger("audio-session-id", i14);
        }
        mediaCodec.configure(mediaFormatA, this.W, (MediaCrypto) null, i);
        if (z.f2192a < 23 || !this.n0) {
            return;
        }
        this.p0 = new f(this, mediaCodec);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c
    public final void a(String str, long j, long j2) {
        this.Q.decoderInitialized(str, j, j2);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.o oVar) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        super.a(oVar);
        this.Q.inputFormatChanged(oVar);
        float f = oVar.n;
        if (f == -1.0f) {
            f = 1.0f;
        }
        this.e0 = f;
        int i = oVar.m;
        if (i == -1) {
            i = 0;
        }
        this.d0 = i;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c
    public final void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int integer;
        int integer2;
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        if (z) {
            integer = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            integer = mediaFormat.getInteger("width");
        }
        this.f0 = integer;
        if (z) {
            integer2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            integer2 = mediaFormat.getInteger("height");
        }
        this.g0 = integer2;
        float f = this.e0;
        this.i0 = f;
        if (z.f2192a >= 21) {
            int i = this.d0;
            if (i == 90 || i == 270) {
                int i2 = this.f0;
                this.f0 = integer2;
                this.g0 = i2;
                this.i0 = 1.0f / f;
            }
        } else {
            this.h0 = this.d0;
        }
        mediaCodec.setVideoScalingMode(this.X);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c
    public final boolean a(boolean z, com.fyber.inneractive.sdk.player.exoplayer2.o oVar, com.fyber.inneractive.sdk.player.exoplayer2.o oVar2) {
        if (b(z, oVar, oVar2)) {
            int i = oVar2.j;
            e eVar = this.V;
            if (i <= eVar.f2197a && oVar2.k <= eVar.b && oVar2.g <= eVar.c) {
                return true;
            }
        }
        return false;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c
    public final boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, long j3, boolean z) {
        long j4;
        long j5;
        long j6;
        if (z) {
            w.a("skipVideoBuffer");
            mediaCodec.releaseOutputBuffer(i, false);
            w.a();
            this.N.skippedOutputBufferCount++;
            return true;
        }
        if (!this.Y) {
            if (z.f2192a >= 21) {
                long jNanoTime = System.nanoTime();
                s();
                w.a("releaseOutputBuffer");
                mediaCodec.releaseOutputBuffer(i, jNanoTime);
                w.a();
                this.N.renderedOutputBufferCount++;
                this.c0 = 0;
                if (!this.Y) {
                    this.Y = true;
                    this.Q.renderedFirstFrame(this.W);
                }
            } else {
                s();
                w.a("releaseOutputBuffer");
                mediaCodec.releaseOutputBuffer(i, true);
                w.a();
                this.N.renderedOutputBufferCount++;
                this.c0 = 0;
                if (!this.Y) {
                    this.Y = true;
                    this.Q.renderedFirstFrame(this.W);
                }
            }
            return true;
        }
        if (this.c != 2) {
            return false;
        }
        long jElapsedRealtime = (j3 - j) - ((SystemClock.elapsedRealtime() * 1000) - j2);
        long jNanoTime2 = System.nanoTime();
        long j7 = (jElapsedRealtime * 1000) + jNanoTime2;
        h hVar = this.P;
        long j8 = j3 * 1000;
        if (hVar.h) {
            if (j3 != hVar.e) {
                hVar.k++;
                hVar.f = hVar.g;
            }
            long j9 = hVar.k;
            if (j9 >= 6) {
                long j10 = hVar.j;
                j4 = hVar.f + ((j8 - j10) / j9);
                if (Math.abs((j7 - hVar.i) - (j4 - j10)) > 20000000) {
                    hVar.h = false;
                } else {
                    j5 = (hVar.i + j4) - hVar.j;
                }
            } else {
                if (Math.abs((j7 - hVar.i) - (j8 - hVar.j)) > 20000000) {
                    hVar.h = false;
                }
            }
            j4 = j8;
            j5 = j7;
        } else {
            j4 = j8;
            j5 = j7;
        }
        if (!hVar.h) {
            hVar.j = j8;
            hVar.i = j7;
            hVar.k = 0L;
            hVar.h = true;
        }
        hVar.e = j3;
        hVar.g = j4;
        g gVar = hVar.f2200a;
        if (gVar != null && gVar.f2199a != 0) {
            long j11 = hVar.f2200a.f2199a;
            long j12 = hVar.c;
            long j13 = (((j5 - j11) / j12) * j12) + j11;
            if (j5 <= j13) {
                j6 = j13 - j12;
            } else {
                j6 = j13;
                j13 = j12 + j13;
            }
            if (j13 - j5 >= j5 - j6) {
                j13 = j6;
            }
            j5 = j13 - hVar.d;
        }
        long j14 = (j5 - jNanoTime2) / 1000;
        if (j14 < -30000) {
            w.a("dropVideoBuffer");
            mediaCodec.releaseOutputBuffer(i, false);
            w.a();
            DecoderCounters decoderCounters = this.N;
            decoderCounters.droppedOutputBufferCount++;
            this.b0++;
            int i2 = this.c0 + 1;
            this.c0 = i2;
            decoderCounters.maxConsecutiveDroppedOutputBufferCount = Math.max(i2, decoderCounters.maxConsecutiveDroppedOutputBufferCount);
            int i3 = this.b0;
            if (i3 != this.S || i3 <= 0) {
                return true;
            }
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            this.Q.droppedFrames(this.b0, jElapsedRealtime2 - this.a0);
            this.b0 = 0;
            this.a0 = jElapsedRealtime2;
            return true;
        }
        if (z.f2192a >= 21) {
            if (j14 >= ServiceProvider.SCAR_SIGNALS_FETCH_TIMEOUT) {
                return false;
            }
            s();
            w.a("releaseOutputBuffer");
            mediaCodec.releaseOutputBuffer(i, j5);
            w.a();
            this.N.renderedOutputBufferCount++;
            this.c0 = 0;
            if (!this.Y) {
                this.Y = true;
                this.Q.renderedFirstFrame(this.W);
            }
            return true;
        }
        if (j14 >= 30000) {
            return false;
        }
        if (j14 > 11000) {
            try {
                Thread.sleep((j14 - 10000) / 1000);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        s();
        w.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        w.a();
        this.N.renderedOutputBufferCount++;
        this.c0 = 0;
        if (!this.Y) {
            this.Y = true;
            this.Q.renderedFirstFrame(this.W);
        }
        return true;
    }

    public static int a(String str, int i, int i2) {
        int i3;
        if (i == -1 || i2 == -1) {
            return -1;
        }
        str.getClass();
        str.hashCode();
        int i4 = 4;
        switch (str) {
            case "video/3gpp":
            case "video/mp4v-es":
            case "video/x-vnd.on2.vp8":
                i3 = i2 * i;
                i4 = 2;
                return (i3 * 3) / (i4 * 2);
            case "video/hevc":
            case "video/x-vnd.on2.vp9":
                i3 = i2 * i;
                return (i3 * 3) / (i4 * 2);
            case "video/avc":
                if ("BRAVIA 4K 2015".equals(z.d)) {
                    return -1;
                }
                i3 = ((i2 + 15) / 16) * ((i + 15) / 16) * 256;
                i4 = 2;
                return (i3 * 3) / (i4 * 2);
            default:
                return -1;
        }
    }
}
