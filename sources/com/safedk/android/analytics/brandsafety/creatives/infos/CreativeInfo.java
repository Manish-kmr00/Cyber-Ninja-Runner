package com.safedk.android.analytics.brandsafety.creatives.infos;

import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.json.mediationsdk.impressionData.ImpressionData;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.FileUploadManager;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkConfiguration;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.analytics.brandsafety.creatives.b;
import com.safedk.android.analytics.brandsafety.creatives.g;
import com.safedk.android.analytics.brandsafety.l;
import com.safedk.android.analytics.events.BrandSafetyEvent;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.PersistableBase;
import com.safedk.android.utils.SdksMapping;
import com.safedk.android.utils.d;
import com.safedk.android.utils.k;
import com.safedk.android.utils.n;
import com.smaato.sdk.video.vast.model.Ad;
import io.bidmachine.unified.UnifiedMediationParams;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class CreativeInfo extends PersistableBase {
    public static final String A = "details?id=";
    public static final String B = "isVideoAd";
    public static final String C = "isPlayable";
    public static final String D = "campaign_id";
    public static final String L = "buyer_id";
    public static final String O = "exact_webview_prefetch";
    public static final String S = "ad_system";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8086a = "CreativeInfo";
    public static final String aF = "text_ad_gradient";
    public static final String aG = "native";
    public static final String aH = "native_banner";
    public static final String aI = "/ad_count_";
    public static final String aJ = "/multiple_ads";
    public static final String aK = "/multi_ad";
    public static final String aL = "matchingMethodAddress";
    public static final String aM = "title:";
    public static final String aN = "mainImg:";
    public static final String aO = "icon:";
    public static final String aP = "body:";
    public static final String aQ = "cta:";
    public static final String aR = "star:";
    public static final String aS = "advertiser:";
    public static final String aT = "element:";
    public static final String aU = "comment:";
    public static final String aV = "ad_domain";
    public static final String ak = "end_card_url";
    public static final String al = "html";
    public static final String am = "vast_ad_tag_uris";
    public static final String an = "text_ad";
    public static final String ao = "event_id";
    public static final String ap = "text:";
    public static final String aq = "video:";
    public static final String aw = "image_ad";
    public static final String b = "prefetchTimestamp";
    public static final String c = "ad_id";
    public static final String d = "creative_id";
    public static final String e = "video_url";
    public static final String f = "log";
    public static final String g = "ci_debug_info";
    public static final String h = "exact_";
    public static final String i = "exact_fbLabel";
    public static final String j = "exact_markup";
    public static final String k = "exact_video";
    public static final String l = "exact_resource";
    public static final String m = "exact_ad_id";
    public static final String n = "exact_ad_object";
    public static final String o = "heuristic_mediation";
    public static final String p = "heuristic_pending";
    public static final String q = "downstream_struct";
    public static final String r = "vast";
    public static final String s = "survey";
    private static final long serialVersionUID = 2;
    public static final String t = "text";
    public static final String u = "playable";
    public static final String v = "image";
    public static final String w = "mraid";
    public static final String x = "dsp_creative_id";
    public static final String y = "exact_event_id";
    public static final String z = "prefetch_resource_urls";
    private BrandSafetyUtils.AdType E;
    protected String F;
    protected boolean G;
    protected boolean H;
    protected boolean I;
    protected String J;
    protected String K;
    protected String M;
    protected final HashSet<String> N;
    protected final HashSet<String> P;
    public String Q;
    Timestamp R;
    boolean T;
    boolean U;
    boolean V;
    boolean W;
    protected String X;
    private String Y;
    private boolean Z;
    private String aA;
    private String aB;
    private boolean aC;
    private String aD;
    private String aE;
    protected String aW;
    protected String aX;
    protected String aY;
    protected String aZ;
    private String aa;
    private long ab;
    private String ac;
    private String ad;
    private int ae;
    private final List<String> af;
    private boolean ag;
    private String ah;
    private String ai;
    private List<String> aj;
    protected String ar;
    protected String as;
    protected String at;
    protected final HashSet<String> au;
    boolean av;
    public final Set<String> ax;
    public boolean ay;
    private transient View az;
    protected final HashSet<String> ba;
    boolean bb;
    boolean bc;
    boolean bd;
    boolean be;
    protected boolean bf;
    protected final l bg;
    public final List<String> bh;
    private boolean bi;
    private boolean bj;
    private boolean bk;

    public CreativeInfo() {
        this.af = new ArrayList();
        this.az = null;
        this.Z = false;
        this.aW = null;
        this.G = false;
        this.H = false;
        this.ab = 0L;
        this.aC = false;
        this.ag = false;
        this.bi = true;
        this.ah = null;
        this.N = new HashSet<>();
        this.P = new HashSet<>();
        this.ba = new HashSet<>();
        this.au = new LinkedHashSet();
        this.T = false;
        this.U = false;
        this.bb = false;
        this.bc = false;
        this.bd = false;
        this.av = false;
        this.V = false;
        this.W = false;
        this.be = false;
        this.bf = false;
        this.bg = new l();
        this.bh = new ArrayList();
        this.ax = new HashSet();
        this.ay = false;
        this.bk = false;
    }

    public CreativeInfo(BrandSafetyUtils.AdType adType, String sdk, String id, String creativeId, String clickUrl, String videoUrl, String downstreamStruct, String sdkVersion) {
        this.af = new ArrayList();
        this.az = null;
        this.Z = false;
        this.aW = null;
        this.G = false;
        this.H = false;
        this.ab = 0L;
        this.aC = false;
        this.ag = false;
        this.bi = true;
        this.ah = null;
        this.N = new HashSet<>();
        this.P = new HashSet<>();
        this.ba = new HashSet<>();
        this.au = new LinkedHashSet();
        this.T = false;
        this.U = false;
        this.bb = false;
        this.bc = false;
        this.bd = false;
        this.av = false;
        this.V = false;
        this.W = false;
        this.be = false;
        this.bf = false;
        this.bg = new l();
        this.bh = new ArrayList();
        this.ax = new HashSet();
        this.ay = false;
        this.bk = false;
        this.aa = sdk;
        this.E = adType;
        this.aa = sdk;
        this.Y = id;
        k(creativeId);
        a(clickUrl, true);
        p(videoUrl);
        this.ag = true;
        this.ab = n.b(SystemClock.elapsedRealtime());
        this.F = downstreamStruct;
        this.T = TextUtils.isEmpty(videoUrl) ? false : true;
        this.bg.a(l.f8111a, new l.a[0]);
        af();
        if (sdkVersion != null) {
            this.Q = sdkVersion;
        } else {
            this.Q = SdksMapping.getSdkVersionByPackage(sdk);
            Logger.d(f8086a, "package version updated, package : " + sdk + ", sdkVersion : " + this.Q);
        }
    }

    public boolean c(String str) {
        return this.ax.contains(str);
    }

    public boolean d(String str) {
        boolean zContains;
        synchronized (this.af) {
            zContains = this.af.contains(str);
        }
        return zContains;
    }

    public boolean c() {
        return this.ay;
    }

    public void d() {
        this.ay = true;
    }

    public List<String> e() {
        return this.bh;
    }

    public View f() {
        return this.az;
    }

    public void a(View view) {
        this.az = view;
    }

    public boolean g() {
        return this.Z;
    }

    public String h() {
        return this.F;
    }

    public void e(String str) {
        this.F = str;
    }

    public void f(String str) {
        a(str, "");
    }

    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (str2 == null) {
                str2 = "";
            }
            if (TextUtils.isEmpty(this.F)) {
                this.F = str;
            } else {
                this.F += str2 + str;
            }
        }
    }

    public String j() {
        Logger.d(f8086a, "getAdUnitId started with the stored value: " + this.aW);
        return this.aW;
    }

    public void g(String str) {
        Logger.d(f8086a, "setAdUnitId started with ad unit id: " + str);
        this.aW = str;
    }

    public boolean k() {
        return this.I;
    }

    public String l() {
        return this.as;
    }

    public void a(boolean z2) {
        this.aC = z2;
    }

    public boolean m() {
        return this.aC;
    }

    public String n() {
        return this.aD;
    }

    public void h(String str) {
        this.aD = str;
    }

    public void i(String str) {
        this.aZ = str;
    }

    public String o() {
        return this.aZ;
    }

    public void j(String str) {
        this.K = str;
    }

    public String p() {
        return this.M;
    }

    public HashSet<String> q() {
        return this.N;
    }

    public HashSet<String> r() {
        return this.P;
    }

    public HashSet<String> s() {
        return this.ba;
    }

    public String t() {
        return this.Q;
    }

    public HashSet<String> u() {
        return this.au;
    }

    public void b(boolean z2) {
        this.V = z2;
    }

    public void c(boolean z2) {
        this.av = z2;
    }

    public boolean v() {
        return this.T || this.V;
    }

    public void d(boolean z2) {
        this.bc = z2;
    }

    public boolean w() {
        return this.bc;
    }

    public void e(boolean z2) {
        this.bd = z2;
    }

    public boolean x() {
        return this.bd;
    }

    public boolean y() {
        return this.W;
    }

    public void f(boolean z2) {
        Logger.d(f8086a, "VideoAd property has been set to " + z2);
        this.T = z2;
    }

    public boolean z() {
        return this.U;
    }

    public void g(boolean z2) {
        this.U = z2;
    }

    public boolean A() {
        return this.V;
    }

    public boolean B() {
        return this.av;
    }

    public String C() {
        return this.X;
    }

    public boolean D() {
        return this.bf;
    }

    public void h(boolean z2) {
        this.bf = z2;
    }

    public void E() {
        this.bj = true;
    }

    public boolean F() {
        return this.bj;
    }

    public l G() {
        return this.bg;
    }

    public void k(String str) {
        this.ac = str;
    }

    public void l(String str) {
        Logger.d(f8086a, "set Dsp Creative Id - set to value: " + str);
        this.aB = str;
    }

    public void m(String str) {
        this.ar = str;
    }

    public void n(String str) {
        this.aA = str;
    }

    public void o(String str) {
        this.as = str;
    }

    public String H() {
        return this.K;
    }

    public String I() {
        StringBuilder sb = new StringBuilder();
        if (this.G) {
            sb.append(this.Y);
        }
        sb.append(this.ac);
        sb.append(this.J);
        return sb.toString();
    }

    public String J() {
        return this.J;
    }

    public void p(String str) {
        this.J = C(str);
        Logger.d(f8086a, "setting video url to: " + this.J);
        x(this.J);
    }

    public String K() {
        return this.aE;
    }

    public void a(BrandSafetyEvent.AdFormatType adFormatType) {
        if (adFormatType == null) {
            Logger.d(f8086a, "adFormat is null , existing");
        } else if (adFormatType == BrandSafetyEvent.AdFormatType.LEADER) {
            this.aE = BrandSafetyEvent.AdFormatType.BANNER.name();
        } else {
            this.aE = adFormatType.name();
        }
    }

    public void q(String str) {
        Logger.d(f8086a, "setPackageName: " + str);
        this.M = str;
    }

    public void a(String str, Set<String> set) {
        a(Arrays.asList(str), set);
    }

    public void a(List<String> list, Set<String> set) {
        Logger.d(f8086a, "add recommendations: " + list + ", resources list: " + set);
        if (list != null) {
            synchronized (this.bh) {
                this.bh.addAll(list);
            }
            Logger.d(f8086a, "add recommendations added : " + list);
        }
        if (set != null) {
            synchronized (this.ax) {
                this.ax.addAll(set);
            }
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                String strC = C(it.next());
                if (!TextUtils.isEmpty(strC)) {
                    synchronized (this.ax) {
                        this.ax.add(strC);
                    }
                }
            }
        }
    }

    public Bundle b() {
        Bundle bundle = new Bundle();
        boolean zA = CreativeInfoManager.a(this.aa, AdNetworkConfiguration.SHOULD_REPORT_AD_ID_ON_CI_CREATION, true);
        if (!TextUtils.isEmpty(this.Y) && zA) {
            bundle.putString(c, this.Y);
        }
        if (this.H) {
            bundle.putLong(b, this.ab);
        }
        if (!TextUtils.isEmpty(this.ac)) {
            bundle.putString("creative_id", this.ac);
        }
        if (!TextUtils.isEmpty(this.aB)) {
            bundle.putString(x, this.aB);
        }
        if (!TextUtils.isEmpty(this.ar)) {
            bundle.putString(L, this.ar);
        }
        if (!TextUtils.isEmpty(this.as)) {
            bundle.putString(S, this.as);
        }
        if (!TextUtils.isEmpty(this.J)) {
            bundle.putString("video_url", this.J);
        }
        if (!TextUtils.isEmpty(this.at)) {
            bundle.putString(ak, this.at);
        }
        if (!TextUtils.isEmpty(this.ai)) {
            bundle.putString(g, this.ai);
        }
        if (!TextUtils.isEmpty(this.F)) {
            bundle.putString(q, this.F);
        }
        if (!TextUtils.isEmpty(this.K)) {
            bundle.putString("zone_id", this.K);
        }
        bundle.putString("ad_format_type", this.aE);
        if (!TextUtils.isEmpty(this.M)) {
            bundle.putString(BrandSafetyEvent.g, this.M);
        }
        bundle.putString("sdk_version", this.Q);
        if (!TextUtils.isEmpty(this.aZ)) {
            bundle.putString(aV, this.aZ);
        }
        if (this.N != null && !this.N.isEmpty()) {
            synchronized (this.N) {
                bundle.putStringArrayList(BrandSafetyEvent.h, new ArrayList<>(this.N));
            }
        }
        if (this.P != null && !this.P.isEmpty()) {
            synchronized (this.P) {
                bundle.putStringArrayList(z, new ArrayList<>(this.P));
            }
        }
        if (this.au != null && !this.au.isEmpty()) {
            synchronized (this.au) {
                bundle.putStringArrayList(am, new ArrayList<>(this.au));
            }
        }
        if (this.ay && this.bh != null && !this.bh.isEmpty()) {
            synchronized (this.bh) {
                bundle.putStringArrayList(BrandSafetyEvent.u, new ArrayList<>(this.bh));
            }
        }
        HashSet<FileUploadManager.FileUploadData> hashSetA = FileUploadManager.a().a(this);
        if (hashSetA != null && hashSetA.size() > 0) {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            Iterator<FileUploadManager.FileUploadData> it = hashSetA.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().h());
            }
            bundle.putParcelableArrayList(FileUploadManager.i, arrayList);
        }
        return bundle;
    }

    public boolean a() {
        return this.ac == null;
    }

    public boolean L() {
        return !this.ag;
    }

    public BrandSafetyUtils.AdType M() {
        return this.E;
    }

    public void a(BrandSafetyUtils.AdType adType) {
        if (adType == null) {
            Logger.d(f8086a, "setAdType - ad type is null, not setting");
            return;
        }
        Logger.d(f8086a, "setAdType - set to ad type: " + adType + " for ci with id: " + this.Y);
        this.E = adType;
        af();
    }

    public String N() {
        return this.Y;
    }

    public void r(String str) {
        this.Y = str;
    }

    public String O() {
        return this.ad;
    }

    public String P() {
        return this.ac;
    }

    public String Q() {
        return this.aB;
    }

    public String R() {
        return this.ar;
    }

    public String S() {
        return this.aa;
    }

    public void s(String str) {
        this.aa = str;
    }

    public String T() {
        return this.aA;
    }

    public int U() {
        return this.ae;
    }

    public void a(int i2) {
        this.ae = i2;
    }

    public void V() {
        Logger.d(f8086a, "resetting click url");
        this.ad = null;
    }

    public void a(String str, boolean z2) {
        Logger.d(f8086a, "setting click url to: " + str);
        this.ad = str;
        this.bk = z2;
    }

    public void i(boolean z2) {
        this.I = z2;
    }

    public void b(String str, String str2) {
        this.ah = str;
        if (str2 != null) {
            t("mi=" + str2);
        }
    }

    public void t(String str) {
        if (str != null) {
            if (this.ai == null) {
                this.ai = str;
            } else if (!this.ai.contains(str)) {
                this.ai += l.ac + str;
            } else {
                Logger.d(f8086a, "setDebugInfo ci debug info already contains the string. skipping. content : " + str);
            }
        }
    }

    public void W() {
        this.ai = null;
    }

    public String X() {
        return this.ai;
    }

    public String Y() {
        return this.ah;
    }

    public boolean a(Map<Integer, CreativeInfo> map) {
        if (this.ae == 0) {
            return false;
        }
        synchronized (map) {
            map.put(Integer.valueOf(this.ae), this);
        }
        return true;
    }

    public boolean b(Map<Integer, CreativeInfo> map) {
        CreativeInfo creativeInfoRemove;
        if (this.ae == 0) {
            return false;
        }
        synchronized (map) {
            creativeInfoRemove = map.remove(Integer.valueOf(this.ae));
        }
        return creativeInfoRemove != null;
    }

    public boolean c(Map<String, CreativeInfo> map) {
        CreativeInfo creativeInfoRemove;
        if (!WebView.class.getCanonicalName().equals(this.aX)) {
            return false;
        }
        synchronized (map) {
            creativeInfoRemove = map.remove(this.aX);
        }
        return creativeInfoRemove != null;
    }

    public void a(List<String> list) {
        this.aj = list;
    }

    public List<String> Z() {
        return this.aj;
    }

    public void b(List<String> list) {
        if (list != null) {
            for (String str : list) {
                if (str != null) {
                    String strC = C(str);
                    String strD = D(str);
                    if (!TextUtils.isEmpty(strC)) {
                        if (b(str) || b(strC) || b(strD) || str.startsWith(aT)) {
                            Logger.d(f8086a, "classifyPrefetchUrl " + this.aa + " url is a prefetch url " + str);
                            x(strC);
                        } else if (u(strC) && !strC.equals(this.ad)) {
                            Logger.d(f8086a, "classifyPrefetchUrl " + this.aa + " url is a dsp url " + str);
                            w(strC);
                        } else {
                            Logger.d(f8086a, "classifyPrefetchUrl " + this.aa + " url is not a prefetch nor a dsp url and will be discarded : " + str);
                        }
                    }
                }
            }
        }
    }

    public void c(List<String> list) {
        if (list != null) {
            n.b(f8086a, "add prefetch urls : " + list);
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                x(it.next());
            }
        }
    }

    protected boolean u(String str) {
        return g.a(this.aa, str);
    }

    protected boolean b(String str) {
        return n.a(str, (Map<String, String>) null);
    }

    public void v(String str) {
        if (u(str)) {
            w(str);
        }
    }

    public void a(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                w(it.next());
            }
        }
    }

    public void w(String str) {
        String strC = C(str);
        if (!TextUtils.isEmpty(strC) && !this.au.contains(strC)) {
            if (!this.ax.contains(strC)) {
                Logger.d(f8086a, "add dsp domain url - adding the following url: " + strC);
                synchronized (this.N) {
                    this.N.add(strC);
                }
                return;
            }
            Logger.d(f8086a, "add dsp domain url: avoid adding a recommendation resource" + strC);
            this.ay = true;
        }
    }

    public void x(String str) {
        String strC = C(str);
        if (!TextUtils.isEmpty(strC)) {
            if (this.af != null) {
                synchronized (this.P) {
                    if (!this.af.contains(strC)) {
                        this.P.add(strC);
                    }
                }
                return;
            }
            Logger.d(f8086a, "add prefetch Url: Url is in the WebView urls exclusion list , will not be added : " + strC);
        }
    }

    public void b(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                x(it.next());
            }
        }
    }

    public void y(String str) {
        if (str != null) {
            if (this.af != null) {
                synchronized (this.P) {
                    if (!this.af.contains(str)) {
                        Logger.d(f8086a, "adding prefetch text: " + str.trim());
                        this.P.add("text:" + str.trim());
                    }
                }
                return;
            }
            Logger.d(f8086a, "add prefetch text: already in the list, will not be added: " + str);
        }
    }

    public void z(String str) {
        if (str != null) {
            if (this.af != null) {
                synchronized (this.P) {
                    if (!this.af.contains(str)) {
                        this.P.add(aT + str);
                    }
                }
                return;
            }
            Logger.d(f8086a, "add prefetch element: already in the list, will not be added: " + str);
        }
    }

    public void A(String str) {
        if (str != null && !str.isEmpty()) {
            synchronized (this.ba) {
                this.ba.add(str);
            }
        }
    }

    public void B(String str) {
        String strC = C(str);
        if (!TextUtils.isEmpty(strC)) {
            synchronized (this.au) {
                this.au.add(strC);
            }
        }
        synchronized (this.N) {
            this.N.remove(strC);
        }
    }

    public String toString() {
        Bundle bundleB = b();
        bundleB.putBoolean(B, this.T | this.V);
        bundleB.putBoolean(C, this.W);
        return "matchingObjectAddress=" + this.aX + ", event_id=" + this.aD + ", id=" + this.Y + ", stopCollectingResources=" + this.aC + ", " + bundleB;
    }

    public String aa() {
        Bundle bundle = new Bundle();
        bundle.putString(c, this.Y);
        if (this.aX != null) {
            bundle.putString(aL, this.aX);
        }
        if (this.aD != null) {
            bundle.putString("event_id", this.aD);
        }
        return bundle.toString();
    }

    public Timestamp ab() {
        return this.R;
    }

    public static String C(String str) {
        return TextUtils.isEmpty(str) ? str : k.f(n.z(str));
    }

    protected String D(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (Throwable th) {
                Logger.d(f8086a, "Failure in encode url. This url will be sent as is in the next event. " + th.getMessage() + ". Url=" + str);
                return str;
            }
        }
        return str;
    }

    public void ac() {
        this.Z = true;
    }

    public void E(String str) {
        this.X = str;
    }

    public String ad() {
        return this.ac;
    }

    public long ae() {
        return this.ab;
    }

    public void af() {
        b bVarJ = CreativeInfoManager.j(this.aa);
        if (bVarJ != null) {
            if (M().equals(BrandSafetyUtils.AdType.INTERSTITIAL)) {
                this.R = new Timestamp(System.currentTimeMillis() + bVarJ.e(AdNetworkConfiguration.FULL_SCREEN_CI_MAX_AGE));
                Logger.d(f8086a, "set expiration time - sdk: " + this.aa + ", inter max age: " + bVarJ.e(AdNetworkConfiguration.SDK_SPECIFIC_CACHED_CI_MAX_AGE));
            } else if (M().equals(BrandSafetyUtils.AdType.BANNER) || M().equals(BrandSafetyUtils.AdType.MREC) || M().equals(BrandSafetyUtils.AdType.NATIVE)) {
                this.R = new Timestamp(System.currentTimeMillis() + bVarJ.e(AdNetworkConfiguration.BANNER_CI_MAX_AGE));
                Logger.d(f8086a, "set expiration time - sdk: " + this.aa + ", banner/mrec/native max age: " + bVarJ.e(AdNetworkConfiguration.SDK_SPECIFIC_CACHED_CI_MAX_AGE));
            }
        }
    }

    public boolean ag() {
        return this.bi;
    }

    public void j(boolean z2) {
        this.bi = z2;
    }

    public String ah() {
        return this.aY;
    }

    public String ai() {
        return this.aX;
    }

    public void a(Object obj) {
        if (obj != null) {
            this.aY = obj.getClass().getCanonicalName();
            this.aX = BrandSafetyUtils.a(obj);
        } else {
            this.aY = null;
            this.aX = null;
        }
        Logger.d(f8086a, "set matching object - type: " + this.aY + ", address: " + this.aX + ", ad id: " + this.Y);
    }

    public void c(String str, String str2) {
        this.aX = str;
        this.aY = str2;
    }

    public void aj() {
        long j2 = this.ab;
        this.ab = n.b(SystemClock.elapsedRealtime());
        Logger.d(f8086a, "prefetch timestamp reset. old value = " + j2 + ", new value = " + this.ab);
    }

    public void F(String str) {
        String strC = C(str);
        synchronized (this.af) {
            this.af.add(strC);
        }
    }

    public List<String> ak() {
        return this.af;
    }

    public boolean al() {
        return this.be;
    }

    public void am() {
        this.be = true;
    }

    public void a(CreativeInfo creativeInfo) {
    }

    public void a(String str, l.a... aVarArr) {
        try {
            this.bg.a(str, aVarArr);
        } catch (NullPointerException e2) {
            Logger.d(f8086a, "add impression log event failed: type=" + str + ", impressionLog=" + this.bg);
        }
    }

    public void a(Long l2, Long l3, String str, l.a... aVarArr) {
        try {
            this.bg.a(l2, l3, str, aVarArr);
        } catch (NullPointerException e2) {
            Logger.d(f8086a, "add impression log event failed: type=" + str + ", impressionLog=" + this.bg);
        }
    }

    public boolean an() {
        return this.bk;
    }

    public void G(String str) {
        this.at = str;
    }

    public boolean ao() {
        return this.bb;
    }

    public void ap() {
        this.bb = true;
    }

    @Override // com.safedk.android.utils.f
    public JSONObject i() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (this.E != null) {
            jSONObject.put(Ad.AD_TYPE, this.E.name());
        }
        if (!TextUtils.isEmpty(this.Y)) {
            jSONObject.put("id", this.Y);
        }
        if (!this.af.isEmpty()) {
            synchronized (this.af) {
                jSONObject.put("excludedWebViewResourceUrlsList", d.a(this.af));
            }
        }
        jSONObject.put("mediaFileWithJsAppAttributeExists", this.Z);
        if (!TextUtils.isEmpty(this.F)) {
            jSONObject.put("downstreamStruct", this.F);
        }
        if (!TextUtils.isEmpty(this.aW)) {
            jSONObject.put("adUnitId", this.aW);
        }
        jSONObject.put("shouldReportId", this.G);
        jSONObject.put("shouldReportPrefetchTimestamp", this.H);
        jSONObject.put("isPortraitOrientation", this.I);
        if (!TextUtils.isEmpty(this.aa)) {
            jSONObject.put("sdk", this.aa);
        }
        if (!TextUtils.isEmpty(this.aA)) {
            jSONObject.put("actualSdk", this.aA);
        }
        jSONObject.put(b, this.ab);
        if (!TextUtils.isEmpty(this.ac)) {
            jSONObject.put("creativeId", this.ac);
        }
        if (!TextUtils.isEmpty(this.aB)) {
            jSONObject.put("dspCreativeId", this.aB);
        }
        if (!TextUtils.isEmpty(this.ar)) {
            jSONObject.put("buyerId", this.ar);
        }
        if (!TextUtils.isEmpty(this.as)) {
            jSONObject.put("adSystem", this.as);
        }
        if (!TextUtils.isEmpty(this.ad)) {
            jSONObject.put("clickUrl", this.ad);
        }
        if (!TextUtils.isEmpty(this.J)) {
            jSONObject.put(UnifiedMediationParams.KEY_VIDEO_URL, this.J);
        }
        if (!TextUtils.isEmpty(this.at)) {
            jSONObject.put("endCardUrl", this.at);
        }
        jSONObject.put("stopCollectingResources", this.aC);
        jSONObject.put("contentHashCode", this.ae);
        if (!TextUtils.isEmpty(this.aD)) {
            jSONObject.put("eventId", this.aD);
        }
        jSONObject.put("fill", this.ag);
        jSONObject.put("fresh", this.bi);
        if (!TextUtils.isEmpty(this.ah)) {
            jSONObject.put("matchingMethod", this.ah);
        }
        if (!TextUtils.isEmpty(this.aX)) {
            jSONObject.put("matchingObjectAddress", this.aX);
        }
        if (!TextUtils.isEmpty(this.aY)) {
            jSONObject.put("matchingObjectType", this.aY);
        }
        if (!TextUtils.isEmpty(this.ai)) {
            jSONObject.put("ciDebugInfo", this.ai);
        }
        if (!TextUtils.isEmpty(this.aE)) {
            jSONObject.put(ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT, this.aE);
        }
        if (!TextUtils.isEmpty(this.K)) {
            jSONObject.put("placementId", this.K);
        }
        if (!TextUtils.isEmpty(this.M)) {
            jSONObject.put("packageName", this.M);
        }
        if (!TextUtils.isEmpty(this.aZ)) {
            jSONObject.put("adDomain", this.aZ);
        }
        if (this.aj != null) {
            jSONObject.put("adText", d.a(this.aj));
        }
        jSONObject.put("dspUrlList", d.a(this.N));
        jSONObject.put("prefetchUrlList", d.a(this.P));
        if (!TextUtils.isEmpty(this.Q)) {
            jSONObject.put("sdkVersion", this.Q);
        }
        if (!this.au.isEmpty()) {
            jSONObject.put("vastAdTagUriList", d.a(this.au));
        }
        jSONObject.put("expirationTimestamp", this.R != null ? Long.valueOf(this.R.getTime()) : null);
        jSONObject.put(B, this.T);
        jSONObject.put("isVideoEndCard", this.U);
        jSONObject.put("isWebsiteEndCard", this.bb);
        jSONObject.put("isEcommerceCollageAd", this.bc);
        jSONObject.put("adHasVideoLoadingScreen", this.bd);
        jSONObject.put("isVastAd", this.av);
        jSONObject.put("isVastVideoAd", this.V);
        jSONObject.put(C, this.W);
        jSONObject.put("isMultipleAds", this.be);
        if (!TextUtils.isEmpty(this.X)) {
            jSONObject.put("vastAdParameters", this.X);
        }
        jSONObject.put("isEventIDUpdated", this.bf);
        jSONObject.put("isShoppingCollageCreative", this.bj);
        jSONObject.put("impressionLog", this.bg.i());
        if (!this.bh.isEmpty()) {
            jSONObject.put("recommendations", d.a(this.bh));
        }
        if (!this.ax.isEmpty()) {
            jSONObject.put("recommendationsResources", d.a(this.ax));
        }
        jSONObject.put("recommendationDisplayed", this.ay);
        jSONObject.put("isClickUrlFromPrefetch", this.bk);
        if (this.ba != null && !this.ba.isEmpty()) {
            jSONObject.put("prefetchUrlSha256List", d.a(this.ba));
        }
        return jSONObject;
    }

    @Override // com.safedk.android.utils.f
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            String strOptString = jSONObject.optString(Ad.AD_TYPE, "");
            this.E = strOptString.isEmpty() ? null : BrandSafetyUtils.AdType.valueOf(strOptString);
            this.Y = jSONObject.optString("id", "");
            this.af.addAll(d.b(jSONObject.optJSONArray("excludedWebViewResourceUrlsList")));
            this.Z = jSONObject.optBoolean("mediaFileWithJsAppAttributeExists", false);
            this.F = jSONObject.optString("downstreamStruct", "");
            this.aW = jSONObject.optString("adUnitId", "");
            this.G = jSONObject.optBoolean("shouldReportId", false);
            this.H = jSONObject.optBoolean("shouldReportPrefetchTimestamp", false);
            this.I = jSONObject.optBoolean("isPortraitOrientation", false);
            this.aa = jSONObject.optString("sdk", "");
            this.aA = jSONObject.optString("actualSdk", "");
            this.ab = jSONObject.optLong(b, 0L);
            this.ac = jSONObject.optString("creativeId", "");
            this.aB = jSONObject.optString("dspCreativeId", "");
            this.ar = jSONObject.optString("buyerId", "");
            this.as = jSONObject.optString("adSystem", "");
            this.ad = jSONObject.optString("clickUrl", "");
            this.J = jSONObject.optString(UnifiedMediationParams.KEY_VIDEO_URL, "");
            this.at = jSONObject.optString("endCardUrl", "");
            this.aC = jSONObject.optBoolean("stopCollectingResources", false);
            this.ae = jSONObject.optInt("contentHashCode", 0);
            this.aD = jSONObject.optString("eventId", "");
            this.ag = jSONObject.optBoolean("fill", false);
            this.bi = jSONObject.optBoolean("fresh", true);
            this.ah = jSONObject.optString("matchingMethod", "");
            this.aX = jSONObject.optString("matchingObjectAddress", "");
            this.aY = jSONObject.optString("matchingObjectType", "");
            this.ai = jSONObject.optString("ciDebugInfo", "");
            this.aE = jSONObject.optString(ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT, "");
            this.K = jSONObject.optString("placementId", "");
            this.M = jSONObject.optString("packageName", "");
            this.aZ = jSONObject.optString("adDomain", "");
            this.aj = d.b(jSONObject.optJSONArray("adText"));
            this.N.addAll(d.b(jSONObject.optJSONArray("dspUrlList")));
            this.P.addAll(d.b(jSONObject.optJSONArray("prefetchUrlList")));
            this.Q = jSONObject.optString("sdkVersion", "");
            this.au.addAll(d.b(jSONObject.optJSONArray("vastAdTagUriList")));
            this.R = new Timestamp(jSONObject.optLong("expirationTimestamp", 0L));
            this.T = jSONObject.optBoolean(B, false);
            this.U = jSONObject.optBoolean("isVideoEndCard", false);
            this.bb = jSONObject.optBoolean("isWebsiteEndCard", false);
            this.bc = jSONObject.optBoolean("isEcommerceCollageAd", false);
            this.bd = jSONObject.optBoolean("adHasVideoLoadingScreen", false);
            this.av = jSONObject.optBoolean("isVastAd", false);
            this.V = jSONObject.optBoolean("isVastVideoAd", false);
            this.W = jSONObject.optBoolean(C, false);
            this.be = jSONObject.optBoolean("isMultipleAds", false);
            this.X = jSONObject.optString("vastAdParameters", "");
            this.bf = jSONObject.optBoolean("isEventIDUpdated", false);
            this.bj = jSONObject.optBoolean("isShoppingCollageCreative", false);
            this.bg.a(jSONObject.optJSONObject("impressionLog"));
            this.bh.addAll(d.b(jSONObject.optJSONArray("recommendations")));
            this.ax.addAll(d.b(jSONObject.optJSONArray("recommendationsResources")));
            this.ay = jSONObject.optBoolean("recommendationDisplayed", false);
            this.bk = jSONObject.optBoolean("isClickUrlFromPrefetch", false);
            this.ba.addAll(d.b(jSONObject.optJSONArray("prefetchUrlSha256List")));
        }
    }
}
