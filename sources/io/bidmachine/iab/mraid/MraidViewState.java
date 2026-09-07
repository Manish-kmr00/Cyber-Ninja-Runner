package io.bidmachine.iab.mraid;

import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public enum MraidViewState {
    LOADING,
    DEFAULT,
    RESIZED,
    EXPANDED,
    HIDDEN;

    public String toJsString() {
        return toString().toLowerCase(Locale.US);
    }
}
