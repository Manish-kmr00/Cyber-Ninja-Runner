package com.safedk.android.analytics.brandsafety;

import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import com.json.b9;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkConfiguration;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.safedk.android.analytics.events.BrandSafetyEvent;
import com.safedk.android.utils.Logger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes6.dex */
public class c {
    protected static final String S = "network_name";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f8029a = "AdInfo";
    public static final String b = "image_hash";
    public static final String c = "sdk_package";
    public static final String d = "sdk_uid";
    public static final String e = "type";
    public static final String f = "ad_format_type";
    public static final String g = "response_code";
    public static final String h = "image_url";
    public static final String i = "image_id";
    public static final String j = "image_orientation";
    public static final String k = "text";
    public static final String l = "safedk_version";
    public Bundle A;
    String B;
    String C;
    String D;
    boolean E;
    boolean F;
    boolean G;
    boolean H;
    public boolean I;
    AdNetworkDiscovery.WebViewResourceMatchingMethod J;
    String K;
    String L;
    String M;
    boolean N;
    boolean O;
    String P;
    String Q;
    final l R;
    protected boolean T;
    public boolean U;
    private final List<k> V;
    private int W;
    protected List<String> m;
    protected List<String> n;
    long o;
    public BrandSafetyUtils.AdType p;
    protected String q;
    long r;
    String s;
    String t;
    BrandSafetyUtils.ScreenShotOrientation u;
    String v;
    boolean w;
    String x;
    int y;
    int z;

    public c(String[] strArr, int i2, Bundle bundle, String str, String str2, String str3, BrandSafetyUtils.ScreenShotOrientation screenShotOrientation, BrandSafetyUtils.AdType adType) {
        this(str, str2, str3, screenShotOrientation, null, adType);
        if (strArr != null) {
            this.C = strArr[0];
            this.B = strArr[1];
        }
        this.A = bundle;
        this.z = i2;
    }

    public c(int i2, Bundle bundle, String str, String str2, String str3, BrandSafetyUtils.ScreenShotOrientation screenShotOrientation, BrandSafetyUtils.AdType adType) {
        this(str, str2, str3, screenShotOrientation, null, adType);
        this.A = bundle;
        this.z = i2;
    }

    public c(String str, String str2, String str3, BrandSafetyUtils.ScreenShotOrientation screenShotOrientation, String str4, BrandSafetyUtils.AdType adType) {
        this.m = null;
        this.n = null;
        this.o = 0L;
        this.u = BrandSafetyUtils.ScreenShotOrientation.NOT_INITIALIZED;
        this.w = false;
        this.x = null;
        this.y = 0;
        this.B = null;
        this.C = null;
        this.V = new ArrayList();
        this.D = null;
        this.E = false;
        this.F = false;
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = AdNetworkDiscovery.WebViewResourceMatchingMethod.DEFAULT;
        this.L = null;
        this.M = null;
        this.N = false;
        this.O = false;
        this.P = null;
        this.Q = null;
        this.R = new l();
        this.U = false;
        this.W = 0;
        Logger.d(f8029a, "AdInfo ctor started, hashValue = " + str + ", fileName = " + str4 + ", maxSdk = " + str2 + ", adType = " + (adType != null ? adType.name() : ""));
        this.v = str2;
        this.r = System.currentTimeMillis();
        this.p = adType;
        j jVar = new j(str, str4, screenShotOrientation);
        synchronized (this.V) {
            this.V.add(new k(str3, jVar, str2, adType));
        }
        if (str2 != null) {
            this.J = CreativeInfoManager.a(str2);
        }
    }

    public c(String str, long j2, BrandSafetyUtils.AdType adType) {
        this.m = null;
        this.n = null;
        this.o = 0L;
        this.u = BrandSafetyUtils.ScreenShotOrientation.NOT_INITIALIZED;
        this.w = false;
        this.x = null;
        this.y = 0;
        this.B = null;
        this.C = null;
        this.V = new ArrayList();
        this.D = null;
        this.E = false;
        this.F = false;
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = AdNetworkDiscovery.WebViewResourceMatchingMethod.DEFAULT;
        this.L = null;
        this.M = null;
        this.N = false;
        this.O = false;
        this.P = null;
        this.Q = null;
        this.R = new l();
        this.U = false;
        this.W = 0;
        Logger.d(f8029a, "AdInfo ctor started, maxSdk = " + str + ", timestamp = " + this.r + ", adType = " + (adType != null ? adType.name() : ""));
        this.v = str;
        this.r = j2;
        this.p = adType;
    }

    public long a() {
        return this.r;
    }

    public String b() {
        return this.t;
    }

    public void a(String str) {
        this.t = str;
    }

    public String c() {
        return this.v;
    }

    public void b(String str) {
        this.v = str;
    }

    public boolean d() {
        return this.w;
    }

    public void a(boolean z) {
        this.w = z;
    }

    public String e() {
        return this.x;
    }

    public boolean c(String str) {
        k kVarI = i();
        if (this.x != null || kVarI == null || (kVarI.i() != null && (!TextUtils.isEmpty(kVarI.i().O()) || kVarI.i().al()))) {
            return false;
        }
        this.x = str;
        return true;
    }

    public boolean f() {
        return this.D != null;
    }

    public void b(boolean z) {
        this.O = z;
    }

    public void a(CreativeInfo creativeInfo) {
        if (creativeInfo != null) {
            if (CreativeInfoManager.a(this.v, AdNetworkConfiguration.DETECT_MULTIPLE_ADS_BY_WEB_VIEW_CHANGE, false)) {
                if (this.D != null && !creativeInfo.al()) {
                    creativeInfo.am();
                    String strH = creativeInfo.h();
                    if (strH != null) {
                        creativeInfo.e(strH + CreativeInfo.aK);
                    }
                }
            } else if (creativeInfo.al()) {
                if (this.D == null) {
                    this.D = UUID.randomUUID().toString();
                    Logger.d(f8029a, "set CI, generate multi ad UUID: " + this.D);
                } else {
                    k kVarI = i();
                    if (kVarI != null && kVarI.i() != null) {
                        k kVar = new k(UUID.randomUUID().toString());
                        kVar.h.a(kVarI.h);
                        kVar.o.a(kVarI.o.keySet());
                        kVar.q.a(kVarI.q.keySet());
                        kVar.n.a(kVarI.n.keySet());
                        kVar.p.a(kVarI.p.keySet());
                        kVar.r.a(kVarI.r.keySet());
                        synchronized (this.V) {
                            this.V.add(kVar);
                        }
                        Logger.d(f8029a, "set CI, create new impression for multi ad, impression list: " + this.V);
                    }
                }
            }
            k kVarI2 = i();
            Logger.d(f8029a, "set CI, impression: " + kVarI2);
            if (kVarI2 != null) {
                if (!creativeInfo.al() && kVarI2.i() != null && kVarI2.i().N() != null && !kVarI2.i().N().equals(creativeInfo.N())) {
                    Logger.d(f8029a, "set CI, failed to set CI due to unmatched IDs: old: " + creativeInfo.N() + ", new: " + kVarI2.i().N());
                    return;
                }
                if (kVarI2.f() || kVarI2.g()) {
                    kVarI2.l();
                }
                kVarI2.a(creativeInfo);
            }
            Logger.d(f8029a, "set CI, number of CIs: " + k().size() + ", impression IDs: " + H() + ", multi ad UUID: " + this.D);
        }
    }

    public List<k> g() {
        return this.V;
    }

    public List<k> h() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.V) {
            for (k kVar : this.V) {
                if (kVar.i() != null && this.m != null && this.m.contains(kVar.i().ai())) {
                    arrayList.add(kVar);
                }
            }
        }
        return arrayList;
    }

    public k i() {
        if (this.m != null && this.D == null) {
            synchronized (this.V) {
                for (k kVar : this.V) {
                    if (kVar.i() != null && this.m.contains(kVar.i().ai())) {
                        return kVar;
                    }
                }
            }
        }
        if (!this.V.isEmpty()) {
            return this.V.get(this.V.size() - 1);
        }
        Logger.d(f8029a, "Failed to get active impression, view hierarchy: " + this.m + ", impression IDs: " + H());
        return null;
    }

    public CreativeInfo j() {
        k kVarI = i();
        if (kVarI != null) {
            return kVarI.i();
        }
        return null;
    }

    public List<CreativeInfo> k() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.V) {
            for (k kVar : this.V) {
                if (kVar.i() != null) {
                    arrayList.add(kVar.i());
                }
            }
        }
        return arrayList;
    }

    public List<CreativeInfo> l() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.V) {
            for (k kVar : this.V) {
                if (kVar.i() != null && this.m != null && this.m.contains(kVar.i().ai())) {
                    arrayList.add(kVar.i());
                }
            }
        }
        return arrayList;
    }

    public j m() {
        k kVarI = i();
        if (kVarI != null) {
            return kVarI.c;
        }
        return null;
    }

    public String n() {
        k kVarI = i();
        return kVarI != null ? kVarI.f8110a : "";
    }

    private List<String> H() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.V) {
            Iterator<k> it = this.V.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().f8110a);
            }
        }
        return arrayList;
    }

    public String o() {
        return this.B;
    }

    public String p() {
        return this.C;
    }

    public void a(String[] strArr) {
        this.C = strArr[0];
        this.B = strArr[1];
    }

    public int q() {
        return this.z;
    }

    public Bundle r() {
        return this.A;
    }

    public int s() {
        return this.y;
    }

    public void c(boolean z) {
        this.E = z;
    }

    public void d(boolean z) {
        this.F = z;
    }

    public void e(boolean z) {
        this.G = z;
    }

    public String t() {
        return this.q;
    }

    public void u() {
        k kVarI = i();
        if (kVarI != null && kVarI.i() != null) {
            List<String> listZ = kVarI.i().Z();
            if (listZ != null && !listZ.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<String> it = listZ.iterator();
                while (it.hasNext()) {
                    sb.append(it.next()).append("\n");
                }
                this.q = sb.toString();
                return;
            }
            return;
        }
        Logger.d(f8029a, "Cannot extract text as Creative info object is null");
    }

    public long v() {
        return this.o;
    }

    public String toString() {
        return " maxAdSdk: " + (this.v != null ? this.v : "") + " impression IDs: " + H() + " clickUrl: " + (this.x != null ? this.x : "") + " viewAddress: " + (this.K != null ? this.K : "");
    }

    public String w() {
        return this.L;
    }

    public List<String> x() {
        return this.m;
    }

    public void a(List<String> list) {
        Logger.d(f8029a, "setting view hierarchy : " + list);
        this.m = list;
    }

    public void b(List<WeakReference<WebView>> list) {
        StringBuilder sb = new StringBuilder("setViewsAddresses added [");
        this.n = new ArrayList();
        synchronized (list) {
            for (WeakReference<WebView> weakReference : list) {
                if (weakReference != null && weakReference.get() != null) {
                    String strA = BrandSafetyUtils.a((Object) weakReference.get());
                    this.n.add(strA);
                    sb.append(strA + " ");
                }
            }
            sb.append(b9.i.e);
            Logger.d(f8029a, sb.toString());
        }
    }

    public String y() {
        if (this.A == null || !this.A.containsKey(BrandSafetyEvent.k) || TextUtils.isEmpty(this.A.getString(BrandSafetyEvent.k))) {
            return null;
        }
        return this.A.getString(BrandSafetyEvent.k);
    }

    public String z() {
        if (this.A == null || !this.A.containsKey("creative_id") || TextUtils.isEmpty(this.A.getString("creative_id"))) {
            return null;
        }
        return this.A.getString("creative_id");
    }

    public String A() {
        if (this.A == null || !this.A.containsKey("network_name") || TextUtils.isEmpty(this.A.getString("network_name"))) {
            return null;
        }
        return this.A.getString("network_name");
    }

    public String B() {
        return this.Q;
    }

    public void d(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.Q == null) {
                this.Q = str;
            } else if (!this.Q.contains(str)) {
                this.Q += l.ac + str;
            }
        }
    }

    public void a(String str, l.a... aVarArr) {
        this.R.a(str, aVarArr);
    }

    public void a(Long l2, Long l3, String str, l.a... aVarArr) {
        this.R.a(l2, l3, str, aVarArr);
    }

    public void b(String str, l.a... aVarArr) {
        this.R.b(str, aVarArr);
    }

    public void a(l lVar) {
        this.R.a(lVar);
    }

    public void f(boolean z) {
        this.V.clear();
        this.m = null;
        this.o = 0L;
        this.q = null;
        this.r = System.currentTimeMillis();
        this.s = null;
        this.t = null;
        this.u = BrandSafetyUtils.ScreenShotOrientation.NOT_INITIALIZED;
        this.v = null;
        this.w = false;
        this.x = null;
        this.y = 0;
        this.B = null;
        this.C = null;
        this.D = null;
        this.E = false;
        this.F = false;
        this.G = false;
        i().k = false;
        this.I = false;
        this.J = AdNetworkDiscovery.WebViewResourceMatchingMethod.DEFAULT;
        this.N = false;
        this.O = false;
        if (z) {
            this.P = null;
        }
        this.Q = null;
    }

    public void C() {
        this.L = null;
        this.K = null;
        if (i() != null && i().a() != null) {
            i().a((String) null);
        }
        this.A = null;
        this.z = 0;
        this.B = null;
        this.C = null;
    }

    public void D() {
        f(true);
        C();
    }

    public void a(d dVar, Bundle bundle, int i2) {
        this.L = dVar.c;
        this.K = dVar.g;
        if (i() != null) {
            i().a(dVar.g);
        }
        this.A = bundle;
        this.z = i2;
    }

    int E() {
        return this.W;
    }

    void F() {
        this.W++;
    }

    void G() {
        this.W = 0;
    }
}
