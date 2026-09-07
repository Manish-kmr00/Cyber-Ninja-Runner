package com.safedk.android.internal;

import android.os.Bundle;
import com.safedk.android.SafeDK;
import com.safedk.android.analytics.AppLovinBridge;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkConfiguration;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.SdksMapping;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class d {
    public static final String A = "disableWebViewTracking";
    public static final String B = "imageMimeTypesList";
    public static final String C = "videoMimeTypesList";
    public static final String D = "audioMimeTypesList";
    public static final String E = "maxBannerUniformPixelsPercentageToStopSampling";
    public static final String F = "minBannerUniformPixelsPercentageForUniformImage";
    public static final String G = "maxAttemptsToCaptureBannerImage";
    public static final String H = "bannerImageSamplingInterval";
    public static final String I = "bannerDimensionsMaxSize";
    public static final String J = "isBannersEnabled";
    public static final String L = "https://edge.safedk.com";
    public static final String M = "https://edge.safedk.com";
    public static final long N = 1200000;
    public static final int O = 20;
    public static final String P = "apng;bmp;gif;x-icon;x-icon;png;svg+xml;tiff";
    public static final String Q = "wave;wav;x-wav;x-pn-wav;webm;ogg;";
    public static final String R = "webViewAnalysisIntervals";
    public static final String S = "webViewVideoObserverIntervals";
    public static final String V = "bannersWebViewAnalysisIntervals";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f8138a = 300;
    private static final int aH = 8192;
    private static final int aJ = 540;
    private static final float aL = 2.5f;
    private static final float aN = 40.0f;
    private static final float aP = 90.0f;
    private static final int aR = 5;
    private static final int aT = 25000;
    private static final boolean aV = false;
    private static final int aX = 10000;
    private static final int aZ = 15000;
    public static final String ab = "webViewMergeNetworkResources";
    private static final String ac = "SafeDKConfiguration";
    private static final String ad = "settings";
    private static final String ae = "android";
    private static final String af = "images";
    private static final String ag = "banners";
    private static final String ah = "adCaching";
    private static final String ai = "general";
    private static final String aj = "timers";
    private static final String ak = "redirectClickTimeout";
    private static final String al = "sdkSpecificMinUniformPixelsPercentageForUniformImage";
    private static final String am = "sdkSpecificCachedCIMaxAge";
    private static final String an = "sdkSpecificCachedCIExpiration";
    private static final String ao = "handleSVForPC";
    private static final int ap = 30000;
    private static final int aq = 30000;
    private static final int ar = 15000;
    public static final int b = 5000;
    private static final boolean bA = true;
    private static final boolean bC = true;
    private static final boolean bG = true;
    private static final String bI = "maxFileItemsToStoreOnDevice";
    private static final int bJ = 40;
    private static final String bL = "istmin";
    private static final String bN = "istmax";
    private static final int bb = 15000;
    private static final boolean bd = true;
    private static final int bn = 100;
    private static final float bq = 40.0f;
    private static final float bs = 90.0f;
    private static final int bu = 5;
    private static final int bw = 2;
    private static final int by = 480;
    public static final int c = 500;
    public static final String d = "minValidImageSize";
    public static final String e = "interstitialDimensionsMaxSize";
    public static final String f = "idsf";
    public static final String g = "maxUniformPixelsPercentageToStopSampling";
    public static final String h = "maxImagesToStoreOnDevice";
    public static final String i = "minImageSizeToStopSampling";
    public static final String j = "minUniformPixelsPercentageForUniformImage";
    public static final String k = "awsUploadTimeout";
    public static final String l = "resolveUrlTimeout";
    public static final String m = "clickValidityTimeout";
    public static final String n = "interstitialActivitiesToInclude";
    public static final String o = "interstitialActivitiesToExclude";
    public static final String p = "edgeServerUrl";
    public static final String q = "backupEdgeServerUrl";
    public static final String r = "devicesWithDebugLog";
    public static final String s = "cachedCreativeInfoMaxAge";
    public static final String t = "cachedMaxNumberOfItems";
    public static final String u = "cachedNumberOfItemsThreshold";
    public static final String v = "cacheSupportingSdkUUIDs";
    public static final String w = "safeDKDeactivation";
    public static final String x = "activePercentage";
    public static final String y = "deactivated";
    public static final String z = "alwaysTakeScreenshot";
    public static final List<Integer> T = Arrays.asList(0, 2, 4, 8, 16, 32, 64);
    public static List<Integer> U = T;
    public static final List<Integer> W = Arrays.asList(0, 2, 4, 8, 16, 32, 64);
    public static List<Integer> X = W;
    public static final List<Integer> Y = Arrays.asList(0, 2, 4, 8, 16, 32, 64);
    public static List<Integer> Z = T;
    public static List<Integer> aa = Y;
    private static int bK = 40;
    private static int bM = 4;
    private static int bO = 10;
    private boolean as = false;
    private int at = 300;
    private boolean au = false;
    private int av = 5000;
    private int aw = 500;
    public int K = 30000;
    private int ax = 30000;
    private int ay = 15000;
    private boolean az = false;
    private boolean aA = true;
    private boolean aB = false;
    private boolean aC = false;
    private JSONObject aD = new JSONObject();
    private JSONObject aE = new JSONObject();
    private ArrayList<String> aF = new ArrayList<>(Arrays.asList(com.safedk.android.utils.h.d, com.safedk.android.utils.h.b, com.safedk.android.utils.h.u, "com.five_corp.ad", com.safedk.android.utils.h.o));
    private boolean aG = false;
    private int aI = 8192;
    private int aK = aJ;
    private float aM = aL;
    private float aO = 40.0f;
    private float aQ = 90.0f;
    private int aS = 5;
    private long aU = 25000;
    private boolean aW = false;
    private int aY = 10000;
    private int ba = 15000;
    private int bc = 15000;
    private boolean be = true;
    private ArrayList<String> bf = new ArrayList<>();
    private ArrayList<String> bg = new ArrayList<>();
    private String bh = "https://edge.safedk.com";
    private String bi = "https://edge.safedk.com";
    private ArrayList<String> bj = new ArrayList<>();
    private ArrayList<String> bk = new ArrayList<>();
    private long bl = N;
    private int bm = 20;
    private int bo = 100;
    private final boolean bp = false;
    private float br = 40.0f;
    private float bt = 90.0f;
    private int bv = 5;
    private int bx = 2;
    private int bz = 480;
    private boolean bB = true;
    private boolean bD = true;
    private List<String> bE = Arrays.asList(P.split(";"));
    private List<String> bF = Arrays.asList(Q.split(";"));
    private boolean bH = true;
    private boolean bP = false;

    public int a() {
        return this.K;
    }

    public int b() {
        return this.ax;
    }

    public int c() {
        return this.ay;
    }

    public boolean d() {
        return this.aG;
    }

    public int e() {
        return this.aI;
    }

    public int f() {
        return this.aK;
    }

    public float g() {
        return this.aM;
    }

    public float h() {
        return this.aO;
    }

    public float i() {
        return this.aQ;
    }

    public boolean j() {
        return this.aW;
    }

    public int k() {
        return this.aS;
    }

    public long l() {
        return this.aU;
    }

    public int m() {
        return this.aY;
    }

    public int n() {
        return this.ba;
    }

    public boolean o() {
        return this.bH;
    }

    public int p() {
        return this.bc;
    }

    public boolean q() {
        return this.be;
    }

    public float r() {
        return this.br;
    }

    public float s() {
        return this.bt;
    }

    public int t() {
        return this.bv;
    }

    public int u() {
        return this.bx;
    }

    public int v() {
        return this.bz;
    }

    public boolean w() {
        return this.bB;
    }

    public boolean x() {
        return this.bD;
    }

    public List<String> y() {
        return this.bE;
    }

    public List<String> z() {
        return this.bF;
    }

    public static int A() {
        return bK;
    }

    public static List<Integer> B() {
        return U;
    }

    public static List<Integer> C() {
        return X;
    }

    public static List<Integer> D() {
        return Z;
    }

    public static List<Integer> E() {
        return aa;
    }

    public void a(boolean z2) {
        this.bP = z2;
    }

    public boolean F() {
        return this.aC;
    }

    public boolean G() {
        return !this.bP;
    }

    public void b(boolean z2) {
        this.as = z2;
    }

    public boolean H() {
        return this.as;
    }

    public int I() {
        return this.at;
    }

    public void a(int i2) {
        this.av = i2;
    }

    public void b(int i2) {
        this.aw = i2;
    }

    public boolean J() {
        return this.az;
    }

    public boolean K() {
        return this.au;
    }

    public int L() {
        return this.av;
    }

    public int M() {
        return this.aw;
    }

    public JSONObject N() {
        return this.aD;
    }

    public JSONObject O() {
        return this.aE;
    }

    public Set<String> P() {
        return new HashSet(this.bj);
    }

    public boolean Q() {
        return this.aB;
    }

    public int R() {
        return this.bo;
    }

    public int S() {
        return bM;
    }

    public int T() {
        return bO;
    }

    public boolean a(Bundle bundle, boolean z2) {
        Logger.d(ac, "parseSettings started , bundle : " + (bundle == null ? "null" : bundle.toString()));
        Bundle bundle2 = bundle.getBundle("settings");
        if (bundle2 == null) {
            if (z2) {
                Logger.e(ac, "Settings bundle is null, cannot parse settings. Saved settings will be used");
            }
            return false;
        }
        Logger.d(ac, "parseSettings starting DEACTIVATION");
        if (bundle2.containsKey(w)) {
            Bundle bundle3 = bundle2.getBundle(w);
            if (bundle3.containsKey(y)) {
                this.bP = bundle3.getBoolean(y, false);
                Logger.d(ac, "parseSettings deactivated " + this.bP);
            } else {
                this.bP = false;
            }
            if (bundle3.containsKey(x)) {
                this.bo = (int) bundle3.getDouble(x, 100.0d);
                Logger.d(ac, "parseSettings activePercentage " + this.bo);
            } else {
                this.bo = 100;
            }
            if (!this.bP && this.bo != 100) {
                Logger.d(ac, "Checking active percentage");
                this.bP = !a(Double.valueOf((double) this.bo), SafeDK.getInstance().getUserId());
                Logger.d(ac, "After active percentage deactivated=" + this.bP);
            }
        } else {
            this.bP = false;
            this.bo = 100;
            Logger.d(ac, "parseSettings SAFE_DK_DEACTIVATION settings block does not exist. Default configuration values will be used.");
        }
        if (bundle2 != null && bundle2.containsKey(af)) {
            Bundle bundle4 = bundle2.getBundle(af);
            Logger.d(ac, "parseSettings starting IMAGES : " + bundle4.toString());
            if (bundle4.containsKey(d)) {
                this.aI = bundle4.getInt(d, 8192);
                Logger.d(ac, "parseSettings minValidImageSize " + this.aI);
            } else {
                this.aI = 8192;
            }
            if (bundle4.containsKey(e)) {
                this.aK = bundle4.getInt(e, aJ);
                Logger.d(ac, "parseSettings interstitialDimensionsMaxSize " + this.aK);
            } else {
                this.aK = aJ;
            }
            if (bundle4.containsKey(f)) {
                Object obj = bundle4.get(f);
                this.aM = obj instanceof Number ? ((Number) obj).floatValue() : aL;
                Logger.d(ac, "parseSettings idsf " + this.aM);
            } else {
                this.aM = aL;
            }
            if (bundle4.containsKey(g)) {
                this.aO = (float) bundle4.getDouble(g, 40.0d);
                Logger.d(ac, "parseSettings maxUniformPixelsPercentageToStopSampling " + this.aO);
            } else {
                this.aO = 40.0f;
            }
            if (bundle4.containsKey(h)) {
                this.aS = bundle4.getInt(h, 5);
                Logger.d(ac, "parseSettings maxImagesToStoreOnDevice " + this.aS);
            } else {
                this.aS = 5;
            }
            if (bundle4.containsKey(i)) {
                this.aU = bundle4.getInt(i, 25000);
                Logger.d(ac, "parseSettings minImageSizeToStopSampling " + this.aU);
            } else {
                this.aU = 25000L;
            }
            if (bundle4.containsKey(j)) {
                this.aQ = (float) bundle4.getDouble(j, 90.0d);
                Logger.d(ac, "parseSettings minUniformPixelsPercentageForUniformImage " + this.aQ);
                CreativeInfoManager.a(AdNetworkConfiguration.SDK_SPECIFIC_MIN_UNIFORM_PIXELS_PERCENTAGE_FOR_UNIFORM_IMAGE, this.aQ);
            }
            if (bundle4.containsKey(z)) {
                this.aW = bundle4.getBoolean(z, false);
                Logger.d(ac, "parseSettings alwaysTakeScreenshot " + this.aW);
            } else {
                this.aW = false;
            }
            if (bundle4.containsKey(ao)) {
                this.be = bundle4.getBoolean(ao, true);
                Logger.d(ac, "parseSettings handleSVForPC " + this.be);
            } else {
                this.be = true;
            }
            try {
                if (bundle4.containsKey(al)) {
                    Logger.d(ac, "parseSettings sdkSpecificMinUniformPixelsPercentageForUniformImage " + bundle4.getBundle(al));
                    Bundle bundle5 = bundle4.getBundle(al);
                    for (String str : bundle5.keySet()) {
                        Logger.d(ac, "parseSettings sdkSpecificMinUniformPixelsPercentageForUniformImage key = " + str + ", value = " + bundle5.getDouble(str));
                        double d2 = bundle5.getDouble(str);
                        String sdkPackageByPackageUUID = SdksMapping.getSdkPackageByPackageUUID(str);
                        if (sdkPackageByPackageUUID != null) {
                            Logger.d(ac, "parseSettings sdkSpecificMinUniformPixelsPercentageForUniformImage identified UUID = " + str + ", sdkPackageName = " + sdkPackageByPackageUUID + ", value = " + d2);
                            com.safedk.android.analytics.brandsafety.creatives.b bVarJ = CreativeInfoManager.j(sdkPackageByPackageUUID);
                            if (bVarJ != null) {
                                bVarJ.a(AdNetworkConfiguration.SDK_SPECIFIC_MIN_UNIFORM_PIXELS_PERCENTAGE_FOR_UNIFORM_IMAGE, (float) d2);
                                Logger.d(ac, "parseSettings sdkSpecificMinUniformPixelsPercentageForUniformImage UUID = " + str + ", sdkPackageName = " + sdkPackageByPackageUUID + ", value = " + ((float) d2));
                            } else {
                                continue;
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                Logger.d(ac, "parseSettings sdkSpecificMinUniformPixelsPercentageForUniformImage Exception : " + th.getMessage(), th);
            }
        } else {
            this.aI = 8192;
            this.aK = aJ;
            this.aM = aL;
            this.aO = 40.0f;
            this.aS = 5;
            this.aU = 25000L;
            Logger.d(ac, "minUniformPixelsPercentageForUniformImage set to " + this.aQ);
            this.aW = false;
            Logger.d(ac, "parseSettings IMAGES settings block does not exist. Default configuration values will be used.");
        }
        Logger.d(ac, "parseSettings starting BANNERS");
        if (bundle2 != null && bundle2.containsKey(ag)) {
            Bundle bundle6 = bundle2.getBundle(ag);
            if (bundle6.containsKey(E)) {
                this.br = (float) bundle6.getDouble(E, 40.0d);
                Logger.d(ac, "parseSettings maxBannerUniformPixelsPercentageToStopSampling " + this.br);
            } else {
                this.br = 40.0f;
            }
            if (bundle6.containsKey(F)) {
                this.bt = (float) bundle6.getDouble(F, 90.0d);
                Logger.d(ac, "parseSettings minBannerUniformPixelsPercentageForUniformImage " + this.bt);
            } else {
                this.bt = 90.0f;
            }
            if (bundle6.containsKey(G)) {
                this.bv = bundle6.getInt(G, 5);
                Logger.d(ac, "parseSettings maxAttemptsToCaptureBannerImage " + this.bv);
            } else {
                this.bv = 5;
            }
            if (bundle6.containsKey(H)) {
                this.bx = bundle6.getInt(H, 2);
                Logger.d(ac, "parseSettings bannerImageSamplingInterval " + this.bx);
            } else {
                this.bx = 2;
            }
            if (bundle6.containsKey(I)) {
                this.bz = bundle6.getInt(I, 480);
                Logger.d(ac, "parseSettings bannerDimensionsMaxSize " + this.bz);
            } else {
                this.bz = 480;
            }
            if (bundle6.containsKey(J)) {
                this.bB = bundle6.getBoolean(J, true);
                Logger.d(ac, "parseSettings bannerIsEnabled " + this.bB);
            } else {
                this.bB = true;
            }
        } else {
            this.br = 40.0f;
            this.bt = 90.0f;
            this.bv = 5;
            this.bx = 2;
            this.bz = 480;
            this.bB = true;
            Logger.d(ac, "parseSettings BANNERS settings block does not exist. Default configuration values will be used.");
        }
        Logger.d(ac, "parseSettings starting TIMERS");
        if (bundle2.containsKey(aj)) {
            Bundle bundle7 = bundle2.getBundle(aj);
            if (bundle7.containsKey(k)) {
                this.aY = (int) bundle7.getDouble(k, 10000.0d);
                if (z2) {
                    this.aY *= 1000;
                }
                Logger.d(ac, "parseSettings awsUploadTimeout (ms) " + this.aY);
            } else {
                this.aY = 10000;
            }
            if (bundle7.containsKey(l)) {
                this.ba = (int) bundle7.getDouble(l, 15000.0d);
                if (z2) {
                    this.ba *= 1000;
                }
                Logger.d(ac, "parseSettings resolveUrlTimeout (ms) " + this.ba);
            } else {
                this.ba = 15000;
            }
            if (bundle7.containsKey(m)) {
                this.bc = ((int) bundle7.getDouble(m, 15000.0d)) * 1000;
                if (z2) {
                    this.bc *= 1000;
                }
                Logger.d(ac, "parseSettings clickValidityTimeout (ms) " + this.bc);
            } else {
                this.bc = 15000;
            }
            if (bundle7.containsKey(ak)) {
                this.K = bundle7.getInt(ak, 30) * 1000;
                Logger.d(ac, "parseSettings redirectClickTimeout (ms) value is " + this.K + ", isFromServer=" + z2);
            } else {
                this.K = 30000;
            }
        } else {
            this.aY = 10000;
            this.ba = 15000;
            this.bc = 15000;
            this.K = 30000;
            Logger.d(ac, "parseSettings TIMERS settings block does not exist. Default configuration values will be used.");
        }
        Logger.d(ac, "parseSettings starting ANDROID");
        if (bundle2.containsKey("android")) {
            Bundle bundle8 = bundle2.getBundle("android");
            if (bundle8.containsKey(n)) {
                this.bf = bundle8.getStringArrayList(n);
                Logger.d(ac, "parseSettings interstitialActivitiesToInclude " + this.bf);
            }
            if (bundle8.containsKey(o)) {
                this.bg = bundle8.getStringArrayList(o);
                Logger.d(ac, "parseSettings interstitialActivitiesToExclude " + this.bg);
            }
            if ((this.bf != null && this.bf.size() > 0) || (this.bg != null && this.bg.size() > 0)) {
                Iterator<String> it = this.bf.iterator();
                while (it.hasNext()) {
                    BrandSafetyUtils.l(it.next());
                }
                Iterator<String> it2 = this.bg.iterator();
                while (it2.hasNext()) {
                    BrandSafetyUtils.m(it2.next());
                }
            }
            if (bundle8.containsKey(A)) {
                this.aG = bundle8.getBoolean(A, false);
                Logger.d(ac, "parseSettings disableWebViewTracking " + this.aG);
            }
            if (bundle8.containsKey(S)) {
                try {
                    ArrayList<String> stringArrayList = bundle8.getStringArrayList(S);
                    if (stringArrayList != null && stringArrayList.size() > 0) {
                        ArrayList arrayList = new ArrayList();
                        Iterator<String> it3 = stringArrayList.iterator();
                        while (it3.hasNext()) {
                            arrayList.add(Integer.valueOf(Integer.parseInt(it3.next())));
                        }
                        Z = new ArrayList(arrayList);
                    }
                } catch (Exception e2) {
                    Logger.d(ac, "caught exception: ", e2);
                }
                Logger.d(ac, "parseSettings chosen interstitial video observer intervals: " + Z);
            }
            if (bundle8.containsKey(R)) {
                try {
                    ArrayList<String> stringArrayList2 = bundle8.getStringArrayList(R);
                    if (stringArrayList2 != null && stringArrayList2.size() > 0) {
                        ArrayList arrayList2 = new ArrayList();
                        Iterator<String> it4 = stringArrayList2.iterator();
                        while (it4.hasNext()) {
                            arrayList2.add(Integer.valueOf(Integer.parseInt(it4.next())));
                        }
                        U = new ArrayList(arrayList2);
                    }
                } catch (Exception e3) {
                    Logger.d(ac, "caught exception: ", e3);
                }
                Logger.d(ac, "parseSettings chosen interstitial resource scanning intervals: " + U);
            } else {
                Logger.d(ac, "parseSettings chosen default interstitial resource scanning intervals: ");
            }
            if (bundle8.containsKey(V)) {
                try {
                    ArrayList<String> stringArrayList3 = bundle8.getStringArrayList(V);
                    if (stringArrayList3 != null && stringArrayList3.size() > 0) {
                        ArrayList arrayList3 = new ArrayList();
                        Iterator<String> it5 = stringArrayList3.iterator();
                        while (it5.hasNext()) {
                            arrayList3.add(Integer.valueOf(Integer.parseInt(it5.next())));
                        }
                        X = new ArrayList(arrayList3);
                    }
                } catch (Exception e4) {
                    Logger.d(ac, "caught exception: ", e4);
                }
                Logger.d(ac, "parseSettings chosen banner resource scanning intervals: " + X);
            } else {
                Logger.d(ac, "parseSettings chosen default banner resource scanning intervals: ");
            }
            if (bundle8.containsKey(ab)) {
                try {
                    this.bH = bundle8.getBoolean(ab);
                } catch (Exception e5) {
                    Logger.d(ac, "caught exception: ", e5);
                }
            }
        } else {
            Logger.d(ac, "parseSettings ANDROID settings block does not exist. Default configuration values will be used.");
        }
        Logger.d(ac, "parseSettings starting GENERAL");
        if (bundle2.containsKey(ai)) {
            Bundle bundle9 = bundle2.getBundle(ai);
            if (bundle9.containsKey(p)) {
                this.bh = bundle9.getString(p, "https://edge.safedk.com");
                this.bh = a(this.bh);
                Logger.d(ac, "parseSettings edgeServerUrl " + this.bh);
            } else {
                this.bh = "https://edge.safedk.com";
            }
            if (bundle9.containsKey(q)) {
                this.bi = bundle9.getString(q, "https://edge.safedk.com");
                this.bi = a(this.bi);
                Logger.d(ac, "parseSettings backupEdgeServerUrl " + this.bi);
            } else {
                this.bi = "https://edge.safedk.com";
            }
            AppLovinBridge.receiveEdgeUrls(this.bh, this.bi);
            if (bundle9.containsKey(r)) {
                this.bj = bundle9.getStringArrayList(r);
                Logger.d(ac, "parseSettings devicesWithDebugLog " + this.bj);
            }
            if (bundle9.containsKey(bI)) {
                bK = bundle9.getInt(bI);
                Logger.d(ac, "parseSettings fileStorageMaxSize " + bK);
            }
            if (bundle9.containsKey(bL)) {
                bM = bundle9.getInt(bL);
                Logger.d(ac, "parseSettings intentStackTraceMinIndex " + bM);
            }
            if (bundle9.containsKey(bN)) {
                bO = bundle9.getInt(bN);
                Logger.d(ac, "parseSettings intentStackTraceMaxIndex " + bO);
            }
        } else {
            Logger.d(ac, "parseSettings GENERAL settings block does not exist. Default configuration values will be used.");
        }
        Logger.d(ac, "parseSettings starting Ad CACHING");
        if (bundle2.containsKey(ah)) {
            Bundle bundle10 = bundle2.getBundle(ah);
            if (bundle10.containsKey(s)) {
                this.bl = (int) bundle10.getDouble(s, 1200000.0d);
                Logger.d(ac, "parseSettings cachedCreativeInfoMaxAge " + this.bl);
            } else {
                this.bl = N;
            }
            CreativeInfoManager.a(AdNetworkConfiguration.SDK_SPECIFIC_CACHED_CI_MAX_AGE, this.bl);
            if (bundle10.containsKey(t)) {
                this.bm = bundle10.getInt(t);
                Logger.d(ac, "parseSettings cachedMaxNumberOfItems " + this.bm);
            } else {
                this.bm = 20;
            }
            if (bundle10.containsKey(v)) {
                this.bk = bundle10.getStringArrayList(v);
                Logger.d(ac, "parseSettings cacheSupportingSdkUUIDs " + this.bk);
            }
            if (this.bk != null && this.bk.size() > 0) {
                a(this.bk);
            }
            try {
                if (bundle10.containsKey(am)) {
                    Logger.d(ac, "parseSettings sdkSpecificCachedCIMaxAge " + bundle10.getBundle(am));
                    Bundle bundle11 = bundle10.getBundle(am);
                    for (String str2 : bundle11.keySet()) {
                        Logger.d(ac, "parseSettings sdkSpecificCachedCIMaxAge key = " + str2 + ", value = " + bundle11.getDouble(str2));
                        long j2 = (long) bundle11.getDouble(str2);
                        String sdkPackageByPackageUUID2 = SdksMapping.getSdkPackageByPackageUUID(str2);
                        if (sdkPackageByPackageUUID2 != null) {
                            Logger.d(ac, "parseSettings sdkSpecificCachedCIMaxAge identified UUID = " + str2 + ", sdkPackageName = " + sdkPackageByPackageUUID2 + ", value = " + j2);
                            com.safedk.android.analytics.brandsafety.creatives.b bVarJ2 = CreativeInfoManager.j(sdkPackageByPackageUUID2);
                            if (bVarJ2 != null) {
                                bVarJ2.a(AdNetworkConfiguration.SDK_SPECIFIC_CACHED_CI_MAX_AGE, j2);
                                Logger.d(ac, "parseSettings sdkSpecificCachedCIMaxAge UUID = " + str2 + ", sdkPackageName = " + sdkPackageByPackageUUID2 + ", value = " + j2);
                            } else {
                                continue;
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                Logger.d(ac, "parseSettings sdkSpecificCachedCreativeInfoMaxAge Exception : " + th2.getMessage(), th2);
            }
            try {
                if (bundle10.containsKey(an)) {
                    Logger.d(ac, "parseSettings sdkSpecificCachedCreativeInfoMaxAge " + bundle10.getBundle(an));
                    Bundle bundle12 = bundle10.getBundle(an);
                    for (String str3 : bundle12.keySet()) {
                        Logger.d(ac, "parseSettings sdkSpecificCachedCIExpirationBundle key = " + str3 + ", value = " + bundle12.getBoolean(str3));
                        boolean z3 = bundle12.getBoolean(str3);
                        String sdkPackageByPackageUUID3 = SdksMapping.getSdkPackageByPackageUUID(str3);
                        if (sdkPackageByPackageUUID3 != null) {
                            Logger.d(ac, "parseSettings sdkSpecificCachedCIExpirationBundle identified UUID = " + str3 + ", sdkPackageName = " + sdkPackageByPackageUUID3 + ", value = " + z3);
                            com.safedk.android.analytics.brandsafety.creatives.b bVarJ3 = CreativeInfoManager.j(sdkPackageByPackageUUID3);
                            if (bVarJ3 != null) {
                                bVarJ3.b(AdNetworkConfiguration.SDK_SPECIFIC_CACHED_CI_EXPIRATION, z3);
                                Logger.d(ac, "parseSettings sdkSpecificCachedCIExpirationBundle UUID = " + str3 + ", sdkPackageName = " + sdkPackageByPackageUUID3 + ", value = " + z3);
                            } else {
                                continue;
                            }
                        }
                    }
                }
            } catch (Throwable th3) {
                Logger.d(ac, "parseSettings sdkSpecificCachedCIExpirationBundle Exception : " + th3.getMessage(), th3);
            }
        } else {
            this.bl = N;
            this.bm = 20;
            Logger.d(ac, "parseSettings AD_CACHING settings block does not exist. Default configuration values will be used.");
        }
        return true;
    }

    private void a(JSONObject jSONObject) throws JSONException {
        Logger.d(ac, "Attempting to parse sdk specific uniformity threshold. setting : " + jSONObject);
        if (jSONObject != null) {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                int i2 = jSONObject.getInt(next);
                String sdkPackageByPackageUUID = SdksMapping.getSdkPackageByPackageUUID(next);
                if (sdkPackageByPackageUUID != null) {
                    Logger.d(ac, "Parse sdk specific uniformity threshold setting identified, UUID = " + next + ", sdkPackageName = " + sdkPackageByPackageUUID + ", value = " + i2);
                    com.safedk.android.analytics.brandsafety.creatives.b bVarJ = CreativeInfoManager.j(sdkPackageByPackageUUID);
                    if (bVarJ != null) {
                        bVarJ.a(AdNetworkConfiguration.SDK_SPECIFIC_MIN_UNIFORM_PIXELS_PERCENTAGE_FOR_UNIFORM_IMAGE, i2);
                        Logger.d(ac, "Parse sdk specific uniformity threshold set, UUID = " + next + ", sdkPackageName = " + sdkPackageByPackageUUID + ", value = " + i2);
                    }
                }
            }
            return;
        }
        Logger.d(ac, "Cannot parse sdk specific uniformity setting, json is null");
    }

    private void a(Bundle bundle) {
        Logger.d(ac, "processSdkVersionsBundle started, bundle=" + bundle.toString());
    }

    private void a(ArrayList<String> arrayList) {
        this.aF.clear();
        for (String str : arrayList) {
            Logger.d(ac, "Adding cacheSupportingSDKUUID " + str + " to cacheSupportedSdk List");
            this.aF.add(str);
        }
    }

    private String a(String str) {
        if (str != null && str.length() > 0) {
            try {
                URL url = new URL(str);
                String protocol = url.getProtocol();
                String host = url.getHost();
                int port = url.getPort();
                if (port == -1) {
                    str = String.format("%s://%s", protocol, host);
                } else {
                    str = String.format("%s://%s:%d", protocol, host, Integer.valueOf(port));
                }
            } catch (MalformedURLException e2) {
                Logger.e(ac, "Exception sanitizing server url:" + e2.getMessage(), e2);
            }
        }
        return str;
    }

    private boolean a(Double d2, String str) {
        Logger.d(ac, "checkActivePercent started, activePercent=" + d2 + ", userId=" + str);
        float fA = DeviceData.a("", str);
        Logger.d(ac, "checkActivePercent hashValue ==" + fA);
        return ((double) fA) <= d2.doubleValue();
    }

    public long U() {
        return this.bl;
    }

    public int V() {
        return this.bm;
    }

    public ArrayList<String> W() {
        return this.aF;
    }
}
