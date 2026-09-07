package com.facebook.ads.redexgen.core;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.util.Pair;
import android.view.Surface;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Yz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public interface InterfaceC2068Yz {
    @MetaExoPlayerCustomization("No longer in upstream exo")
    void A4y(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i, Object obj);

    int A5i();

    int A5k(MediaCodec.BufferInfo bufferInfo);

    ByteBuffer A89(int i);

    ByteBuffer A8U(int i);

    MediaFormat A8V();

    @MetaExoPlayerCustomization("Added in D39791066")
    Pair<Long, Integer> A8Z();

    @MetaExoPlayerCustomization("Added in D39791066")
    int A9A();

    void AGQ(int i, int i2, int i3, long j, int i4);

    void AGS(int i, int i2, C1907Sk c1907Sk, long j, int i3);

    void AGj();

    void AGp(int i, long j);

    void AGq(int i, boolean z);

    void AIg(InterfaceC2067Yy interfaceC2067Yy, Handler handler);

    void AIh(Surface surface);

    void AIy(int i);

    void flush();

    @MetaExoPlayerCustomization("No longer in upstream exo")
    @Deprecated
    void reset();

    @MetaExoPlayerCustomization("No longer in upstream exo")
    void start();

    @MetaExoPlayerCustomization("No longer in upstream exo")
    @Deprecated
    void stop();
}
