package sg.bigo.ads.ad.interstitial.multi_img;

/* JADX INFO: loaded from: classes.dex */
public enum d {
    NONE(0, 3, 20, 0, 1.0f, 1.0f),
    LTR(1, 1, 20, 12, 1.0f, 1.0f),
    CENTER(2, 2, 30, 12, 0.8f, 0.9f),
    FULL(3, 3, 20, 0, 1.0f, 1.0f),
    TILE(Integer.MIN_VALUE, Integer.MIN_VALUE, 20, 12, 1.0f, 1.0f);

    public final int f;
    final float g;
    final float h;
    public final int i;
    public final int j;
    private final int k;

    d(int i, int i2, int i3, int i4, float f, float f2) {
        this.k = i;
        this.j = i2;
        this.i = i3;
        this.f = i4;
        this.g = f;
        this.h = f2;
    }

    public static d a(int i) {
        if (i == Integer.MIN_VALUE) {
            return TILE;
        }
        if (i == 1) {
            return LTR;
        }
        if (i != 2) {
            return i != 3 ? NONE : FULL;
        }
        return CENTER;
    }
}
