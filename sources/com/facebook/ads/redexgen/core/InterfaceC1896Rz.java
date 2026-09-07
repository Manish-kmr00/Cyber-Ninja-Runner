package com.facebook.ads.redexgen.core;

import android.media.AudioDeviceInfo;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Rz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public interface InterfaceC1896Rz {
    void A4z(ZM zm, int i, int[] iArr) throws C1889Rs;

    void A5p();

    void A6C();

    void A6J();

    long A7V(boolean z);

    C2064Yv A8c();

    boolean A9U(ByteBuffer byteBuffer, long j, int i) throws C1890Rt, C1895Ry;

    void A9X();

    boolean A9e();

    boolean AAE();

    void AG8();

    void AGA() throws C1895Ry;

    void AIM(C2080Zm c2080Zm);

    void AIN(int i);

    void AIO(NY ny);

    @MetaExoPlayerCustomization(type = {"NEW_METHOD"}, value = "Enable Retry Audio Track")
    void AIW(boolean z);

    void AIb(InterfaceC1892Rv interfaceC1892Rv);

    void AIj(C2064Yv c2064Yv);

    void AIm(RK rk);

    void AIo(AudioDeviceInfo audioDeviceInfo);

    void AIu(boolean z);

    boolean AJS(ZM zm);

    @MetaExoPlayerCustomization(type = {"TEMPORARY"}, value = "Old API that can be removed when we move to MediaCodecRenderer2")
    boolean AJU(int i, int i2);

    void flush();

    void pause();

    void setVolume(float f);
}
