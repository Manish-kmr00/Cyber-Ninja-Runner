package io.bidmachine.banner;

/* JADX INFO: loaded from: classes10.dex */
public enum BannerSize {
    Size_320x50(320, 50),
    Size_300x250(300, 250),
    Size_728x90(728, 90);

    public final int height;
    public final int width;

    BannerSize(int i, int i2) {
        this.width = i;
        this.height = i2;
    }
}
