package sg.bigo.ads.api;

import android.content.Context;
import sg.bigo.ads.common.p;
import sg.bigo.ads.common.utils.e;

/* JADX INFO: loaded from: classes8.dex */
public final class AdSize extends p {
    public static final String ADAPTIVE = "adaptive";
    private static p d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13083a;
    public static final AdSize BANNER = new AdSize(320, 50, "320x50");
    public static final AdSize MEDIUM_RECTANGLE = new AdSize(300, 250, "300x250");
    public static final AdSize LARGE_BANNER = new AdSize(320, 90, "320x90");
    public static final AdSize MOBILE_LARGE_LEADERBOARD = new AdSize(320, 100, "320x100");
    public static final AdSize LEADERBOARD = new AdSize(728, 90, "728x90");

    private AdSize(int i, int i2, String str) {
        super(i, i2);
        this.f13083a = str;
    }

    public static int dp2px(Context context, int i) {
        if (context == null) {
            return 0;
        }
        return e.a(context, i);
    }

    public static AdSize getAdaptiveAdSize(Context context, int i) {
        float f;
        float f2;
        int iRound;
        if (context == null || i == 0) {
            return BANNER;
        }
        if (d == null) {
            d = e.e(context);
        }
        int height = d.getHeight();
        if (height <= 0) {
            return BANNER;
        }
        int iMin = Math.min(90, Math.round(height * 0.15f));
        if (i < 0) {
            i = d.getWidth();
        }
        if (i <= 655) {
            if (i > 632) {
                iRound = 81;
            } else if (i > 526) {
                f = i / 468.0f;
                f2 = 60.0f;
            } else if (i > 432) {
                iRound = 68;
            } else {
                f = i / 320.0f;
                f2 = 50.0f;
            }
            return new AdSize(i, Math.max(Math.min(iRound, iMin), 50), ADAPTIVE);
        }
        f = i / 728.0f;
        f2 = 90.0f;
        iRound = Math.round(f * f2);
        return new AdSize(i, Math.max(Math.min(iRound, iMin), 50), ADAPTIVE);
    }

    @Override // sg.bigo.ads.common.p
    public final int getHeight() {
        return super.getHeight();
    }

    @Override // sg.bigo.ads.common.p
    public final int getWidth() {
        return super.getWidth();
    }
}
