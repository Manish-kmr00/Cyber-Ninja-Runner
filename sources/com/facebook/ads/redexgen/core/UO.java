package com.facebook.ads.redexgen.core;

import android.net.Uri;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network.dex */
public interface UO {
    public static final UO A00 = new UO() { // from class: com.facebook.ads.redexgen.X.W4
        @Override // com.facebook.ads.redexgen.core.UO
        public final UK[] A5D() {
            return UN.A00();
        }

        @Override // com.facebook.ads.redexgen.core.UO
        public final /* synthetic */ UK[] A5E(Uri uri, Map map) {
            return UN.A01(this, uri, map);
        }
    };

    UK[] A5D();

    UK[] A5E(Uri uri, Map<String, List<String>> map);
}
