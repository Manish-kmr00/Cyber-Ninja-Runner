package com.fyber.inneractive.sdk.player.exoplayer2.audio;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.adjust.sdk.Constants;
import com.fyber.inneractive.sdk.player.exoplayer2.decoder.DecoderCounters;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes11.dex */
public class MediaCodecAudioRenderer extends com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c implements com.fyber.inneractive.sdk.player.exoplayer2.util.h {
    public final AudioRendererEventListener.EventDispatcher P;
    public final r Q;
    public boolean R;
    public int S;
    public int T;
    public long U;
    public boolean V;

    public MediaCodecAudioRenderer() {
        super(1, true);
        this.Q = new r(new c[0], new u(this));
        this.P = new AudioRendererEventListener.EventDispatcher(null, null);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c
    public final com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.a a(com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.d dVar, com.fyber.inneractive.sdk.player.exoplayer2.o oVar) {
        String str = oVar.f;
        this.Q.getClass();
        String str2 = oVar.f;
        dVar.getClass();
        return com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.j.a(false, str2);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c
    public final int b(com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.d dVar, com.fyber.inneractive.sdk.player.exoplayer2.o oVar) {
        int i;
        int i2;
        String str = oVar.f;
        if (!"audio".equals(com.fyber.inneractive.sdk.player.exoplayer2.util.i.b(str))) {
            return 0;
        }
        int i3 = z.f2192a;
        int i4 = i3 >= 21 ? 16 : 0;
        this.Q.getClass();
        dVar.getClass();
        com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.a aVarA = com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.j.a(false, str);
        if (aVarA == null) {
            return 1;
        }
        return ((i3 < 21 || (((i = oVar.s) == -1 || aVarA.b(i)) && ((i2 = oVar.r) == -1 || aVarA.a(i2)))) ? 3 : 2) | i4 | 4;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.a
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.h d() {
        return this;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c, com.fyber.inneractive.sdk.player.exoplayer2.a
    public final boolean e() {
        if (this.L) {
            r rVar = this.Q;
            if (!rVar.d() || (rVar.X && !rVar.c())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c, com.fyber.inneractive.sdk.player.exoplayer2.a
    public final boolean f() {
        return this.Q.c() || super.f();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.a
    public final void g() {
        try {
            r rVar = this.Q;
            rVar.g();
            for (c cVar : rVar.c) {
                cVar.f();
            }
            rVar.Z = 0;
            rVar.Y = false;
            try {
                this.n = null;
                o();
            } finally {
                this.N.ensureUpdated();
                this.P.disabled(this.N);
            }
        } catch (Throwable th) {
            try {
                this.n = null;
                o();
                throw th;
            } finally {
                this.N.ensureUpdated();
                this.P.disabled(this.N);
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.a
    public final void h() {
        DecoderCounters decoderCounters = new DecoderCounters();
        this.N = decoderCounters;
        this.P.enabled(decoderCounters);
        int i = this.b.f2138a;
        if (i == 0) {
            r rVar = this.Q;
            if (rVar.a0) {
                rVar.a0 = false;
                rVar.Z = 0;
                rVar.g();
                return;
            }
            return;
        }
        r rVar2 = this.Q;
        rVar2.getClass();
        if (z.f2192a < 21) {
            throw new IllegalStateException();
        }
        if (rVar2.a0 && rVar2.Z == i) {
            return;
        }
        rVar2.a0 = true;
        rVar2.Z = i;
        rVar2.g();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.a
    public final void i() {
        this.Q.f();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.a
    public final void j() {
        r rVar = this.Q;
        rVar.Y = false;
        if (rVar.d()) {
            rVar.z = 0L;
            rVar.y = 0;
            rVar.x = 0;
            rVar.A = 0L;
            rVar.B = false;
            rVar.C = 0L;
            rVar.g.d();
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c
    public final void p() throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        try {
            r rVar = this.Q;
            if (!rVar.X && rVar.d() && rVar.a()) {
                rVar.g.a(rVar.b());
                rVar.w = 0;
                rVar.X = true;
            }
        } catch (q e) {
            throw new com.fyber.inneractive.sdk.player.exoplayer2.d(e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0037  */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.a aVar, MediaCodec mediaCodec, com.fyber.inneractive.sdk.player.exoplayer2.o oVar) {
        boolean z;
        String str = aVar.f2107a;
        if (z.f2192a < 24 && "OMX.SEC.aac.dec".equals(str) && Constants.REFERRER_API_SAMSUNG.equals(z.c)) {
            String str2 = z.b;
            if (str2.startsWith("zeroflte") || str2.startsWith("herolte") || str2.startsWith("heroqlte")) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        this.R = z;
        mediaCodec.configure(oVar.a(), (Surface) null, (MediaCrypto) null, 0);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.util.h
    public final long b() {
        long jA = this.Q.a(e());
        if (jA != Long.MIN_VALUE) {
            if (!this.V) {
                jA = Math.max(this.U, jA);
            }
            this.U = jA;
            this.V = false;
        }
        return this.U;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c
    public final void a(String str, long j, long j2) {
        this.P.decoderInitialized(str, j, j2);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.o oVar) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        super.a(oVar);
        this.P.inputFormatChanged(oVar);
        this.S = "audio/raw".equals(oVar.f) ? oVar.t : 2;
        this.T = oVar.r;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c
    public final void a(MediaCodec mediaCodec, MediaFormat mediaFormat) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        int[] iArr;
        int i;
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (this.R && integer == 6 && (i = this.T) < 6) {
            iArr = new int[i];
            for (int i2 = 0; i2 < this.T; i2++) {
                iArr[i2] = i2;
            }
        } else {
            iArr = null;
        }
        try {
            this.Q.a(integer, integer2, this.S, iArr);
        } catch (m e) {
            throw new com.fyber.inneractive.sdk.player.exoplayer2.d(e);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c, com.fyber.inneractive.sdk.player.exoplayer2.a
    public final void a(boolean z, long j) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        super.a(z, j);
        this.Q.g();
        this.U = j;
        this.V = true;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.util.h
    public final com.fyber.inneractive.sdk.player.exoplayer2.s a(com.fyber.inneractive.sdk.player.exoplayer2.s sVar) {
        return this.Q.a(sVar);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.util.h
    public final com.fyber.inneractive.sdk.player.exoplayer2.s a() {
        return this.Q.s;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c
    public final boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, long j3, boolean z) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            this.N.skippedOutputBufferCount++;
            r rVar = this.Q;
            if (rVar.L == 1) {
                rVar.L = 2;
            }
            return true;
        }
        try {
            if (!this.Q.a(byteBuffer, j3)) {
                return false;
            }
            mediaCodec.releaseOutputBuffer(i, false);
            this.N.renderedOutputBufferCount++;
            return true;
        } catch (n | q e) {
            throw new com.fyber.inneractive.sdk.player.exoplayer2.d(e);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.a
    public final void a(int i, Object obj) {
        if (i == 2) {
            r rVar = this.Q;
            float fFloatValue = ((Float) obj).floatValue();
            if (rVar.P != fFloatValue) {
                rVar.P = fFloatValue;
                rVar.i();
                return;
            }
            return;
        }
        if (i != 3) {
            return;
        }
        int iIntValue = ((Integer) obj).intValue();
        r rVar2 = this.Q;
        if (rVar2.n == iIntValue) {
            return;
        }
        rVar2.n = iIntValue;
        if (rVar2.a0) {
            return;
        }
        rVar2.g();
        rVar2.Z = 0;
    }
}
