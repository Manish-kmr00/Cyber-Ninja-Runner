package sg.bigo.ads.ad.interstitial;

import java.util.ArrayList;
import java.util.List;
import sg.bigo.ads.R;

/* JADX INFO: loaded from: classes8.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12811a;
    public final int b;
    public final String c;
    public final boolean d;

    public enum a {
        STAR(0, R.string.bigo_ad_ic_blank, R.drawable.bigo_ad_ic_star, R.string.bigo_ad_comment_num_text, 0),
        DOWNLOAD_NUM(0, R.string.bigo_ad_ic_blank, 0, R.string.bigo_ad_download_num_text, 0),
        Everyone(0, 0, R.drawable.bigo_ad_ic_everyone, R.string.bigo_ad_ic_everyone, R.drawable.bigo_ad_ic_everyone_ic_info),
        WEB(1, 0, R.drawable.bigo_ad_ic_web, R.string.bigo_ad_ic_web, 0),
        RECOMMENDED(1, 0, R.drawable.bigo_ad_ic_recommend, R.string.bigo_ad_ic_recommended, 0),
        REVIEWS(3, 0, R.drawable.bigo_ad_ic_star2, R.string.bigo_ad_comment_num_text, 0),
        APPLICATION(2, 0, R.drawable.bigo_ad_ic_phone, R.string.bigo_ad_ic_application, 0),
        DOWNLOAD(2, 0, R.drawable.bigo_ad_ic_download_box, R.string.bigo_ad_download_num_text, 0),
        STAR_WHITE(0, R.string.bigo_ad_ic_blank, R.drawable.bigo_ad_ic_star_white, R.string.bigo_ad_comment_num_text, 0),
        DOWNLOAD_NUM_WHITE(0, R.string.bigo_ad_ic_blank, 0, R.string.bigo_ad_download_num_text, 0),
        Everyone_WHITE(0, 0, R.drawable.bigo_ad_ic_everyone_white, R.string.bigo_ad_ic_everyone, R.drawable.bigo_ad_ic_info_white),
        WEB_WHITE(4, 0, R.drawable.bigo_ad_ic_web_white, R.string.bigo_ad_ic_web, 0),
        RECOMMENDED_WHITE(4, 0, R.drawable.bigo_ad_ic_recommend_white, R.string.bigo_ad_ic_recommended, 0),
        REVIEWS_WHITE(12, 0, R.drawable.bigo_ad_ic_star2_white, R.string.bigo_ad_comment_num_text, 0),
        APPLICATION_WHITE(8, 0, R.drawable.bigo_ad_ic_phone_white, R.string.bigo_ad_ic_application, 0),
        DOWNLOAD_WHITE(8, 0, R.drawable.bigo_ad_ic_download_box_white, R.string.bigo_ad_download_num_text, 0);

        public final int q;
        public final int r;
        public final int s;
        public final int t;
        public final int u;

        a(int i, int i2, int i3, int i4, int i5) {
            this.q = i;
            this.r = i2;
            this.s = i3;
            this.t = i4;
            this.u = i5;
        }

        public static List<a> a(int i) {
            a[] aVarArrValues = values();
            ArrayList arrayList = new ArrayList();
            for (a aVar : aVarArrValues) {
                int i2 = aVar.q;
                if ((i2 & i) > 0 || i2 == i) {
                    arrayList.add(aVar);
                }
            }
            return arrayList;
        }
    }

    public f(int i, int i2, String str) {
        this.f12811a = i;
        this.b = i2;
        this.c = str;
        this.d = !sg.bigo.ads.common.utils.q.a((CharSequence) str);
    }
}
