package sg.bigo.ads.core.e.a;

import android.content.Context;
import android.text.TextUtils;
import com.amazon.aps.shared.util.APSSharedUtil;
import com.pubmatic.sdk.common.POBCommonConstants;
import java.util.Map;
import sg.bigo.ads.api.core.r;

/* JADX INFO: loaded from: classes7.dex */
public class g {
    private static final String b = "g";
    private final Map<String, String> c;
    private final r d;
    private final String e;
    private final String f;
    private final String g;
    private int i;
    private final int[] h = {0, 30000, POBCommonConstants.BANNER_BID_EXPIRE_TIME_IN_MILLIS};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f13572a = 0;

    private g(Map<String, String> map, r rVar, int i, String str, String str2, String str3) {
        this.c = map;
        this.d = rVar;
        this.e = str;
        this.f = str2;
        this.g = str3;
        this.i = i;
    }

    public static g a(Map<String, String> map, r rVar, int i, String str, String str2, String str3) {
        return new g(map, rVar, i, str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context) {
        sg.bigo.ads.common.t.a.a(0, 3, b, "Vast tracker request start, action: " + this.e + ", url: " + b(this.f));
        sg.bigo.ads.core.e.b.a(context, this.e, new sg.bigo.ads.common.u.b.d(this.f), this.g, this.i, false, this.f13572a, this.c, new sg.bigo.ads.core.e.b.a() { // from class: sg.bigo.ads.core.e.a.g.2
            @Override // sg.bigo.ads.core.e.b.a
            public final void a() {
                sg.bigo.ads.common.t.a.a(0, 3, g.b, "Vast tracker request error, action: " + g.this.e + ", url: " + g.b(g.this.f));
                g.b(g.this, context);
            }

            @Override // sg.bigo.ads.core.e.b.a
            public final boolean a(int i) {
                return g.this.d != null && g.this.d.a(i);
            }

            @Override // sg.bigo.ads.core.e.b.a
            public final void b() {
                sg.bigo.ads.common.t.a.a(0, 3, g.b, "Vast tracker request success, action: " + g.this.e + ", url: " + g.b(g.this.f));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str) {
        return (str == null || str.length() < 40) ? str : str.substring(0, 20) + APSSharedUtil.TRUNCATE_SEPARATOR + str.substring(str.length() - 10);
    }

    static /* synthetic */ void b(g gVar, Context context) {
        if (TextUtils.equals("va_show", gVar.e) || TextUtils.equals("va_cli", gVar.e) || TextUtils.equals("va_cpn_imp", gVar.e) || TextUtils.equals("va_cpn_cli", gVar.e)) {
            int i = gVar.f13572a + 1;
            gVar.f13572a = i;
            gVar.a(context, i);
        }
    }

    final void a(final Context context, int i) {
        if (i >= 3) {
            sg.bigo.ads.common.t.a.a(0, 3, b, "Vast tracker retry time exceed, action: " + this.e + ", url: " + b(this.f));
            return;
        }
        int[] iArr = this.h;
        int i2 = iArr[i % iArr.length];
        if (i2 <= 0) {
            a(context);
        } else {
            sg.bigo.ads.common.t.a.a(0, 3, b, "Vast tracker retry after " + i2 + " ms, action: " + this.e + ", url: " + b(this.f));
            sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.core.e.a.g.1
                @Override // java.lang.Runnable
                public final void run() {
                    g.this.a(context);
                }
            }, i2);
        }
    }
}
