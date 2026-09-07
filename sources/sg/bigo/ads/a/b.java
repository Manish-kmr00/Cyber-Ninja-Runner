package sg.bigo.ads.a;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsSession;
import com.pubmatic.sdk.common.POBCommonConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import sg.bigo.ads.common.n.d;

/* JADX INFO: loaded from: classes12.dex */
final class b implements sg.bigo.ads.a.a.a.InterfaceC0806a {
    private static final b c = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final sg.bigo.ads.a.a.a f12470a = new sg.bigo.ads.a.a.a();
    private final int d = POBCommonConstants.BANNER_BID_EXPIRE_TIME_IN_MILLIS;
    private final int e = 200;
    final Set<String> b = new LinkedHashSet();
    private final HashMap<String, Long> f = new HashMap<>();
    private int g = 0;
    private boolean h = false;
    private boolean i = false;
    private boolean j = true;
    private boolean k = false;

    b() {
    }

    static /* synthetic */ String a(int i) {
        switch (i) {
            case 1:
                return "Navigation Started";
            case 2:
                return "Navigation Finished";
            case 3:
                return "Navigation Failed";
            case 4:
                return "Navigation Aborted";
            case 5:
                return "Tab Shown";
            case 6:
                return "Tab Hidden";
            default:
                return "Unknown Event";
        }
    }

    public static b a() {
        return c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        final String next;
        if (!this.i) {
            this.k = false;
            return;
        }
        if (!this.k) {
            sg.bigo.ads.common.t.a.a(0, 3, "ChromeTabsStatic", "The task of preload start.");
        }
        try {
            Iterator<String> it = this.b.iterator();
            if (!it.hasNext()) {
                sg.bigo.ads.common.t.a.a(0, 3, "ChromeTabsStatic", "The task of preload stop.");
                this.k = false;
                return;
            }
            this.k = true;
            next = it.next();
            try {
                this.b.remove(next);
            } catch (Exception unused) {
            }
            if (TextUtils.isEmpty(next)) {
                return;
            }
            d.a(1, new Runnable() { // from class: sg.bigo.ads.a.b.3
                @Override // java.lang.Runnable
                public final void run() {
                    CustomTabsSession customTabsSessionA;
                    Long l = (Long) b.this.f.get(next);
                    if (l == null || SystemClock.elapsedRealtime() - l.longValue() > 300000) {
                        Uri uri = Uri.parse(next);
                        sg.bigo.ads.a.a.a aVar = b.this.f12470a;
                        boolean zMayLaunchUrl = (aVar.f12465a == null || (customTabsSessionA = aVar.a()) == null) ? false : customTabsSessionA.mayLaunchUrl(uri, null, null);
                        sg.bigo.ads.common.t.a.a(0, 3, "ChromeTabsStatic", "Preload url state: " + zMayLaunchUrl + ", url: " + next);
                        if (!zMayLaunchUrl) {
                            sg.bigo.ads.core.d.b.a(3002, 10115, String.valueOf(next));
                        }
                        b.this.f.put(next, Long.valueOf(SystemClock.elapsedRealtime()));
                    } else {
                        sg.bigo.ads.common.t.a.a(0, 3, "ChromeTabsStatic", "The url that wait for preload has been preloaded before: " + next);
                    }
                    d.a(2, new Runnable() { // from class: sg.bigo.ads.a.b.3.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            b.this.e();
                        }
                    }, 200L);
                }
            });
        } catch (Exception unused2) {
            next = null;
        }
    }

    final boolean a(Context context) {
        String str;
        if (!this.j) {
            sg.bigo.ads.common.t.a.a(0, 3, "ChromeTabsStatic", "Chrome service is unavailable.");
            return false;
        }
        boolean zBindCustomTabsService = true;
        if (this.i) {
            str = "Chrome service connected";
        } else {
            if (!this.h) {
                this.h = true;
                this.f12470a.c = this;
                sg.bigo.ads.a.a.a aVar = this.f12470a;
                if (aVar.f12465a == null) {
                    sg.bigo.ads.a.a.b.a aVarA = sg.bigo.ads.a.a.b.a(context);
                    if (aVarA == null || !aVarA.f12468a) {
                        zBindCustomTabsService = false;
                    } else {
                        aVar.b = new sg.bigo.ads.a.a.c(aVar);
                        zBindCustomTabsService = CustomTabsClient.bindCustomTabsService(context, aVarA.e, aVar.b);
                    }
                }
                if (!zBindCustomTabsService) {
                    this.h = false;
                    int i = this.g;
                    this.g = i + 1;
                    if (i < 3) {
                        this.j = false;
                    }
                }
                return zBindCustomTabsService;
            }
            str = "Chrome service connect trying.";
        }
        sg.bigo.ads.common.t.a.a(0, 3, "ChromeTabsStatic", str);
        return true;
    }

    final void b() {
        if (this.k) {
            return;
        }
        e();
    }

    @Override // sg.bigo.ads.a.a.a.InterfaceC0806a
    public final void c() {
        sg.bigo.ads.common.t.a.a(0, 3, "ChromeTabsStatic", "Chrome tabs service connected.");
        this.i = true;
        this.h = false;
        b();
    }

    @Override // sg.bigo.ads.a.a.a.InterfaceC0806a
    public final void d() {
        sg.bigo.ads.common.t.a.a(0, 3, "ChromeTabsStatic", "Chrome tabs service disconnected.");
        this.i = false;
        this.h = false;
    }
}
