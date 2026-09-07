package com.facebook.ads.redexgen.core;

import android.net.Uri;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Uo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public interface InterfaceC1957Uo {
    void A6U(ZM zm);

    int AHv(O9 o9, int i, boolean z) throws IOException;

    int AHw(O9 o9, int i, boolean z, int i2) throws IOException;

    void AHx(C2447fq c2447fq, int i);

    void AHy(C2447fq c2447fq, int i, int i2);

    void AI0(long j, int i, int i2, int i3, C1956Um c1956Um);

    @MetaExoPlayerCustomization("New Meta API")
    void AJk(Uri uri);
}
