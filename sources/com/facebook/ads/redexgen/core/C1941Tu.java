package com.facebook.ads.redexgen.core;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Tu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final /* synthetic */ class C1941Tu implements UO {
    @Override // com.facebook.ads.redexgen.core.UO
    public final UK[] A5D() {
        return MatroskaExtractor.A0Q();
    }

    @Override // com.facebook.ads.redexgen.core.UO
    public final /* synthetic */ UK[] A5E(Uri uri, Map map) {
        return UN.A01(this, uri, map);
    }
}
