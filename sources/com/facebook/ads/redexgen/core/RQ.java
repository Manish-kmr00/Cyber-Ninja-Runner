package com.facebook.ads.redexgen.core;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.util.Pair;
import android.view.Surface;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class RQ implements InterfaceC2068Yz {
    public ByteBuffer[] A00;
    public ByteBuffer[] A01;
    public final MediaCodec A02;

    @MetaExoPlayerCustomization("This constructor is private in Exo r2.18.6 and builder pattern should be used.This can be fixed after MediaCodecPool.Java dependency is removed.Because the Factory calls start before allocating the adapter it can call getInputBuffers here. Butdo not do it while the constructor is public because start hasn't been called yet.See S358180")
    public RQ(MediaCodec mediaCodec) {
        this.A02 = mediaCodec;
    }

    public final /* synthetic */ void A00(InterfaceC2067Yy interfaceC2067Yy, MediaCodec mediaCodec, long j, long j2) {
        interfaceC2067Yy.ADE(this, j, j2);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2068Yz
    @MetaExoPlayerCustomization("Override is customization due to dependency on MediaCodec[Audio/Video]Renderer")
    public final void A4y(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i, Object obj) {
        this.A02.configure(mediaFormat, surface, mediaCrypto, i);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2068Yz
    public final int A5i() {
        return this.A02.dequeueInputBuffer(0L);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2068Yz
    public final int A5k(MediaCodec.BufferInfo bufferInfo) {
        int iDequeueOutputBuffer;
        do {
            iDequeueOutputBuffer = this.A02.dequeueOutputBuffer(bufferInfo, 0L);
            if (iDequeueOutputBuffer == -3 && AbstractC2471gE.A02 < 21) {
                this.A01 = this.A02.getOutputBuffers();
            }
        } while (iDequeueOutputBuffer == -3);
        return iDequeueOutputBuffer;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2068Yz
    public final ByteBuffer A89(int i) {
        if (AbstractC2471gE.A02 >= 21) {
            return this.A02.getInputBuffer(i);
        }
        return ((ByteBuffer[]) AbstractC2471gE.A0f(this.A00))[i];
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2068Yz
    public final ByteBuffer A8U(int i) {
        if (AbstractC2471gE.A02 >= 21) {
            return this.A02.getOutputBuffer(i);
        }
        return ((ByteBuffer[]) AbstractC2471gE.A0f(this.A01))[i];
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2068Yz
    public final MediaFormat A8V() {
        return this.A02.getOutputFormat();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2068Yz
    @MetaExoPlayerCustomization("Added in D39791066")
    public final Pair<Long, Integer> A8Z() {
        return new Pair<>(0L, 0);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2068Yz
    @MetaExoPlayerCustomization("Added in D39791066")
    public final int A9A() {
        return 0;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2068Yz
    public final void AGQ(int i, int i2, int i3, long j, int i4) {
        this.A02.queueInputBuffer(i, i2, i3, j, i4);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2068Yz
    public final void AGS(int i, int i2, C1907Sk c1907Sk, long j, int i3) {
        this.A02.queueSecureInputBuffer(i, i2, c1907Sk.A00(), j, i3);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2068Yz
    public final void AGj() {
        this.A00 = null;
        this.A01 = null;
        this.A02.release();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2068Yz
    public final void AGp(int i, long j) {
        this.A02.releaseOutputBuffer(i, j);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2068Yz
    public final void AGq(int i, boolean z) {
        this.A02.releaseOutputBuffer(i, z);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2068Yz
    public final void AIg(final InterfaceC2067Yy interfaceC2067Yy, Handler handler) {
        this.A02.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() { // from class: com.facebook.ads.redexgen.X.Za
            @Override // android.media.MediaCodec.OnFrameRenderedListener
            public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
                this.A01.A00(interfaceC2067Yy, mediaCodec, j, j2);
            }
        }, handler);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2068Yz
    public final void AIh(Surface surface) {
        this.A02.setOutputSurface(surface);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2068Yz
    public final void AIy(int i) {
        this.A02.setVideoScalingMode(i);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2068Yz
    public final void flush() {
        this.A02.flush();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2068Yz
    @MetaExoPlayerCustomization
    public final void reset() {
        this.A02.reset();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2068Yz
    @MetaExoPlayerCustomization("Could be revisited after upgrading MediaCodecRenderer")
    public final void start() {
        this.A02.start();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2068Yz
    @MetaExoPlayerCustomization
    public final void stop() {
        this.A02.stop();
    }
}
