package sg.bigo.ads.ad.interstitial.multi_img;

/* JADX INFO: loaded from: classes.dex */
public enum c {
    FILL_MATCH_SELF(1, 1),
    FILL_MATCH_MAIN_VIEW(2, 2),
    FILL_MATCH_PARENT(3, 3);

    public final int d;
    private final int e;

    c(int i, int i2) {
        this.e = i;
        this.d = i2;
    }

    public static c a(int i) {
        if (i != 2) {
            return i != 3 ? FILL_MATCH_SELF : FILL_MATCH_PARENT;
        }
        return FILL_MATCH_MAIN_VIEW;
    }
}
