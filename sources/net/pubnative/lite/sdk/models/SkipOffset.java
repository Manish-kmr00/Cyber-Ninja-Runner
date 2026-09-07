package net.pubnative.lite.sdk.models;

/* JADX INFO: loaded from: classes10.dex */
public class SkipOffset {
    private final boolean isCustom;
    private final int offset;

    public SkipOffset(int i, boolean z) {
        this.offset = i;
        this.isCustom = z;
    }

    public int getOffset() {
        return this.offset;
    }

    public boolean isCustom() {
        return this.isCustom;
    }
}
