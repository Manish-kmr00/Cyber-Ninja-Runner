package io.bidmachine.iab.mraid;

import java.util.Locale;

/* JADX INFO: loaded from: classes12.dex */
public enum MraidPlacementType {
    INLINE,
    INTERSTITIAL;

    String b() {
        return toString().toLowerCase(Locale.US);
    }
}
