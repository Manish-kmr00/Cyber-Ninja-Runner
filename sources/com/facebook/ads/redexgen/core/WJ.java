package com.facebook.ads.redexgen.core;

import android.net.Uri;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;

/* JADX INFO: loaded from: assets/audience_network.dex */
public interface WJ extends O9 {
    void A3x(int i) throws IOException;

    boolean A3y(int i, boolean z) throws IOException;

    long A8E();

    long A8Y();

    long A8d();

    @MetaExoPlayerCustomization("Added API for MP4 extractor")
    Uri A9F();

    int AG0(byte[] bArr, int i, int i2) throws IOException;

    void AG1(byte[] bArr, int i, int i2) throws IOException;

    boolean AG2(byte[] bArr, int i, int i2, boolean z) throws IOException;

    boolean AGZ(byte[] bArr, int i, int i2, boolean z) throws IOException;

    void AHr();

    int AJ6(int i) throws IOException;

    void AJ9(int i) throws IOException;

    @Override // com.facebook.ads.redexgen.core.O9
    int read(byte[] bArr, int i, int i2) throws IOException;

    void readFully(byte[] bArr, int i, int i2) throws IOException;
}
