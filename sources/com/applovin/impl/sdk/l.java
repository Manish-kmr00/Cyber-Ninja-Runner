package com.applovin.impl.sdk;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.app.ApplicationStartInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Point;
import android.hardware.SensorManager;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.v4.media.session.PlaybackStateCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Range;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.applovin.impl.b6;
import com.applovin.impl.c2;
import com.applovin.impl.g5;
import com.applovin.impl.h7;
import com.applovin.impl.j7;
import com.applovin.impl.k7;
import com.applovin.impl.k8;
import com.applovin.impl.m5;
import com.applovin.impl.o0;
import com.applovin.impl.o4;
import com.applovin.impl.p0;
import com.applovin.impl.p6;
import com.applovin.impl.q0;
import com.applovin.impl.q2;
import com.applovin.impl.r0;
import com.applovin.impl.s4;
import com.applovin.impl.sdk.array.ArrayService;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.v;
import com.applovin.impl.v4;
import com.applovin.impl.x4;
import com.applovin.impl.z3;
import com.applovin.sdk.AppLovinBidTokenCollectionListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.Scopes;
import com.json.fe;
import com.safedk.android.analytics.events.BrandSafetyEvent;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import net.pubnative.lite.sdk.models.AdExperience;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class l {
    private static String i;
    private static String j;
    private static final AtomicReference k = new AtomicReference();
    private static final AtomicReference l = new AtomicReference();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f660a;
    private final o b;
    private final Context c;
    private final Map d;
    private final Map f;
    private boolean g;
    private final Object e = new Object();
    private final AtomicReference h = new AtomicReference();

    class a implements m5.a {
        a() {
        }

        @Override // com.applovin.impl.m5.a
        public void a(v.a aVar) {
            l.k.set(aVar);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f662a;
        public final int b;

        public b(String str, int i) {
            this.f662a = str;
            this.b = i;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f663a = -1;
        public int b = -1;
        public Boolean c = null;
    }

    protected l(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f660a = kVar;
        this.b = kVar.O();
        this.c = k.o();
        this.d = B();
        this.f = A();
    }

    private Map A() {
        PackageInfo packageInfo;
        HashMap map = new HashMap();
        PackageManager packageManager = this.c.getPackageManager();
        ApplicationInfo applicationInfo = this.c.getApplicationInfo();
        long jLastModified = new File(applicationInfo.sourceDir).lastModified();
        try {
            packageInfo = packageManager.getPackageInfo(this.c.getPackageName(), 0);
        } catch (Throwable unused) {
            packageInfo = null;
        }
        String strA = a(applicationInfo.packageName, packageManager, this.f660a);
        map.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, packageManager.getApplicationLabel(applicationInfo));
        map.put("app_version", packageInfo != null ? packageInfo.versionName : "");
        map.put("app_version_code", Integer.valueOf(packageInfo != null ? packageInfo.versionCode : -1));
        if (strA == null) {
            strA = "";
        }
        map.put("installer_name", strA);
        map.put("tg", j7.a(this.f660a));
        map.put("debug", Boolean.valueOf(k7.c(this.f660a)));
        map.put("ia", Long.valueOf(jLastModified));
        map.put("alts_ms", Long.valueOf(k.n()));
        map.put(SDKAnalyticsEvents.PARAMETER_SESSION_ID, this.f660a.n0().getSessionId());
        map.put("j8", Boolean.valueOf(k.G0()));
        map.put("ps_tpg", Boolean.valueOf(o4.d(this.c)));
        map.put("ps_apg", Boolean.valueOf(o4.b(this.c)));
        map.put("ps_capg", Boolean.valueOf(o4.c(this.c)));
        map.put("ps_aipg", Boolean.valueOf(o4.a(this.c)));
        k kVar = this.f660a;
        x4 x4Var = x4.h;
        Long l2 = (Long) kVar.a(x4Var);
        if (l2 != null) {
            map.put("ia_v2", l2);
        } else {
            this.f660a.b(x4Var, Long.valueOf(jLastModified));
        }
        map.put("sdk_version", AppLovinSdk.VERSION);
        map.put("omid_sdk_version", this.f660a.e0().c());
        CollectionUtils.putStringIfValid("ad_review_sdk_version", com.applovin.impl.j.b(), map);
        map.put("api_did", this.f660a.a(v4.f));
        map.put("first_install_v3_ms", packageInfo != null ? Long.valueOf(packageInfo.firstInstallTime) : "");
        CollectionUtils.putLongIfValid("last_launch_ms", this.f660a.M(), map);
        CollectionUtils.putLongIfValid("app_launch_count", Long.valueOf(this.f660a.N()), map);
        map.put("target_sdk", Integer.valueOf(applicationInfo.targetSdkVersion));
        if (o0.g()) {
            map.put("min_sdk", Integer.valueOf(applicationInfo.minSdkVersion));
        }
        if (this.f660a.I0()) {
            map.put("unity_version", k7.a(this.f660a.o0()));
        }
        List listI = i();
        if (!CollectionUtils.isEmpty(listI)) {
            map.put("application_start_info", listI);
        }
        List listG = g();
        if (!CollectionUtils.isEmpty(listG)) {
            map.put("application_exit_info", listG);
        }
        return map;
    }

    private Map B() {
        HashMap map = new HashMap(35);
        map.put("api_level", Integer.valueOf(Build.VERSION.SDK_INT));
        map.put(AdExperience.BRAND, Build.MANUFACTURER);
        map.put("brand_name", Build.BRAND);
        map.put("hardware", Build.HARDWARE);
        map.put("sim", Boolean.valueOf(AppLovinSdkUtils.isEmulator()));
        map.put("aida", Boolean.valueOf(v.a()));
        map.put(CommonUrlParts.LOCALE, Locale.getDefault().toString());
        map.put("model", Build.MODEL);
        map.put("os", Build.VERSION.RELEASE);
        map.put("platform", y());
        map.put("revision", Build.DEVICE);
        map.put("tz_offset", Double.valueOf(C()));
        map.put("gy", Boolean.valueOf(s()));
        map.put("country_code", m());
        map.put("mcc", w());
        map.put("mnc", x());
        map.put("carrier", k());
        map.put("tv", Boolean.valueOf(AppLovinSdkUtils.isTv(this.c)));
        map.put(ApsMetricsDataMap.APSMETRICS_FIELD_PLATFORMCATEGORY, Integer.valueOf(Runtime.getRuntime().availableProcessors()));
        map.put("hdr", Q());
        map.put("supported_abis", M());
        DisplayMetrics displayMetrics = this.c.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            map.put("adns", Float.valueOf(displayMetrics.density));
            map.put("adnsd", Integer.valueOf(displayMetrics.densityDpi));
            map.put("xdpi", Float.valueOf(displayMetrics.xdpi));
            map.put("ydpi", Float.valueOf(displayMetrics.ydpi));
            o0.b bVarA = o0.a(this.c, this.f660a);
            if (bVarA != null) {
                map.put("tl_cr", Integer.valueOf(bVarA.c()));
                map.put("tr_cr", Integer.valueOf(bVarA.d()));
                map.put("bl_cr", Integer.valueOf(bVarA.a()));
                map.put("br_cr", Integer.valueOf(bVarA.b()));
            }
        }
        map.put("bt_ms", Long.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
        map.put("tbalsi_ms", Long.valueOf(this.f660a.L() - k.n()));
        CollectionUtils.putBooleanIfValid("psase", Boolean.valueOf(o4.e(this.c)), map);
        CollectionUtils.putStringIfValid("process_name", k7.c(this.c), map);
        CollectionUtils.putBooleanIfValid("is_main_process", k7.i(this.c), map);
        try {
            PackageInfo packageInfo = this.c.getPackageManager().getPackageInfo("com.android.vending", 0);
            map.put("ps_version", packageInfo.versionName);
            map.put("ps_version_code", Integer.valueOf(packageInfo.versionCode));
        } catch (Throwable unused) {
            map.put("ps_version", "");
            map.put("ps_version_code", -1);
        }
        CollectionUtils.putBooleanIfValid("play_store_disabled", h7.a(this.c), map);
        a(map);
        return map;
    }

    private double C() {
        return Math.round((((double) TimeZone.getDefault().getOffset(new Date().getTime())) * 10.0d) / 3600000.0d) / 10.0d;
    }

    /* JADX WARN: Code duplicated, block: B:148:0x023a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x018a  */
    /* JADX WARN: Code duplicated, block: B:98:0x020b  */
    /* JADX WARN: Code duplicated, block: B:99:0x022c  */
    private JSONArray D() {
        MediaCodecInfo[] mediaCodecInfoArr;
        int i2;
        int i3;
        ArrayList arrayList;
        int i4;
        String[] strArr;
        int i5;
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        int i6;
        if (!o0.e()) {
            return new JSONArray();
        }
        ArrayList arrayList2 = new ArrayList();
        try {
            MediaCodecInfo[] codecInfos = new MediaCodecList(1).getCodecInfos();
            int length = codecInfos.length;
            int i7 = 0;
            while (i7 < length) {
                MediaCodecInfo mediaCodecInfo = codecInfos[i7];
                if (mediaCodecInfo.isEncoder()) {
                    arrayList = arrayList2;
                    mediaCodecInfoArr = codecInfos;
                    i2 = length;
                    i3 = i7;
                } else {
                    HashMap map = new HashMap();
                    map.put("name", mediaCodecInfo.getName());
                    if (o0.j()) {
                        map.put("is_hardware_accelerated", Boolean.valueOf(mediaCodecInfo.isHardwareAccelerated()));
                        map.put("is_software_only", Boolean.valueOf(mediaCodecInfo.isSoftwareOnly()));
                    }
                    String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                    ArrayList arrayList3 = new ArrayList();
                    HashMap map2 = new HashMap();
                    int length2 = supportedTypes.length;
                    int i8 = 0;
                    while (i8 < length2) {
                        String str = supportedTypes[i8];
                        MediaCodecInfo[] mediaCodecInfoArr2 = codecInfos;
                        if (str.toLowerCase(Locale.ROOT).startsWith("video/")) {
                            arrayList3.add(str);
                            try {
                                MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
                                if (capabilitiesForType == null || (videoCapabilities = capabilitiesForType.getVideoCapabilities()) == null) {
                                    arrayList2 = arrayList2;
                                    i4 = length;
                                    i7 = i7;
                                    map = map;
                                    strArr = supportedTypes;
                                    i5 = length2;
                                } else {
                                    i4 = length;
                                    try {
                                        HashMap map3 = new HashMap();
                                        strArr = supportedTypes;
                                        try {
                                            i5 = length2;
                                            try {
                                                map3.put("max_width", videoCapabilities.getSupportedWidths().getUpper());
                                                map3.put("max_height", videoCapabilities.getSupportedHeights().getUpper());
                                                Range<Integer> bitrateRange = videoCapabilities.getBitrateRange();
                                                Integer num = (Integer) bitrateRange.getLower();
                                                Integer num2 = (Integer) bitrateRange.getUpper();
                                                i7 = i7;
                                                arrayList2 = arrayList2;
                                                try {
                                                    Integer[] numArr = new Integer[2];
                                                    try {
                                                        numArr[0] = num;
                                                        numArr[1] = num2;
                                                        map3.put("bitrate_range_bps", Arrays.asList(numArr));
                                                        Range<Integer> supportedFrameRates = videoCapabilities.getSupportedFrameRates();
                                                        Integer num3 = (Integer) supportedFrameRates.getLower();
                                                        Integer num4 = (Integer) supportedFrameRates.getUpper();
                                                        map = map;
                                                        try {
                                                            Integer[] numArr2 = new Integer[2];
                                                            try {
                                                                numArr2[0] = num3;
                                                                numArr2[1] = num4;
                                                                map3.put("overall_frame_rate_range", Arrays.asList(numArr2));
                                                                int iIntValue = ((Integer) videoCapabilities.getSupportedWidths().getUpper()).intValue();
                                                                int iIntValue2 = ((Integer) videoCapabilities.getSupportedHeights().getUpper()).intValue();
                                                                if (videoCapabilities.isSizeSupported(iIntValue, iIntValue2)) {
                                                                    try {
                                                                        Range<Double> supportedFrameRatesFor = videoCapabilities.getSupportedFrameRatesFor(iIntValue, iIntValue2);
                                                                        if (supportedFrameRatesFor != null) {
                                                                            Double d = (Double) supportedFrameRatesFor.getLower();
                                                                            Double d2 = (Double) supportedFrameRatesFor.getUpper();
                                                                            Double[] dArr = new Double[2];
                                                                            i6 = 0;
                                                                            try {
                                                                                dArr[0] = d;
                                                                                try {
                                                                                    dArr[1] = d2;
                                                                                    map3.put("frame_rate_range_for_max_res", Arrays.asList(dArr));
                                                                                } catch (Throwable th) {
                                                                                    th = th;
                                                                                    if (o.a()) {
                                                                                        this.b.a("DataCollector", "Could not get frame rates for max resolution for codec: " + mediaCodecInfo.getName() + ", MIME type: " + str, th);
                                                                                    }
                                                                                }
                                                                            } catch (Throwable th2) {
                                                                                th = th2;
                                                                            }
                                                                        } else {
                                                                            i6 = 0;
                                                                        }
                                                                    } catch (Throwable th3) {
                                                                        th = th3;
                                                                        i6 = 0;
                                                                    }
                                                                } else {
                                                                    i6 = 0;
                                                                }
                                                                ArrayList arrayList4 = new ArrayList();
                                                                MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr = capabilitiesForType.profileLevels;
                                                                if (codecProfileLevelArr != null && codecProfileLevelArr.length > 0) {
                                                                    int length3 = codecProfileLevelArr.length;
                                                                    int i9 = i6;
                                                                    while (i9 < length3) {
                                                                        MediaCodecInfo.CodecProfileLevel codecProfileLevel = codecProfileLevelArr[i9];
                                                                        HashMap map4 = new HashMap();
                                                                        map4.put(Scopes.PROFILE, Integer.valueOf(codecProfileLevel.profile));
                                                                        map4.put("level", Integer.valueOf(codecProfileLevel.level));
                                                                        arrayList4.add(map4);
                                                                        i9++;
                                                                        codecProfileLevelArr = codecProfileLevelArr;
                                                                    }
                                                                    map3.put("profile_levels", arrayList4);
                                                                }
                                                                if (!map3.isEmpty()) {
                                                                    map2.put(str, map3);
                                                                }
                                                            } catch (Throwable th4) {
                                                                th = th4;
                                                                if (o.a()) {
                                                                    this.b.a("DataCollector", "Failed to get capabilities for codec: " + mediaCodecInfo.getName() + ", MIME type: " + str, th);
                                                                }
                                                            }
                                                        } catch (Throwable th5) {
                                                            th = th5;
                                                            if (o.a()) {
                                                                this.b.a("DataCollector", "Failed to get capabilities for codec: " + mediaCodecInfo.getName() + ", MIME type: " + str, th);
                                                            }
                                                            i8++;
                                                            codecInfos = mediaCodecInfoArr2;
                                                            length = i4;
                                                            supportedTypes = strArr;
                                                            map = map;
                                                            length2 = i5;
                                                            i7 = i7;
                                                            arrayList2 = arrayList2;
                                                        }
                                                    } catch (Throwable th6) {
                                                        th = th6;
                                                        map = map;
                                                    }
                                                } catch (Throwable th7) {
                                                    th = th7;
                                                    map = map;
                                                    if (o.a()) {
                                                        this.b.a("DataCollector", "Failed to get capabilities for codec: " + mediaCodecInfo.getName() + ", MIME type: " + str, th);
                                                    }
                                                    i8++;
                                                    codecInfos = mediaCodecInfoArr2;
                                                    length = i4;
                                                    supportedTypes = strArr;
                                                    map = map;
                                                    length2 = i5;
                                                    i7 = i7;
                                                    arrayList2 = arrayList2;
                                                }
                                            } catch (Throwable th8) {
                                                th = th8;
                                                arrayList2 = arrayList2;
                                                i7 = i7;
                                            }
                                        } catch (Throwable th9) {
                                            th = th9;
                                            arrayList2 = arrayList2;
                                            i5 = length2;
                                            if (o.a()) {
                                                this.b.a("DataCollector", "Failed to get capabilities for codec: " + mediaCodecInfo.getName() + ", MIME type: " + str, th);
                                            }
                                            i8++;
                                            codecInfos = mediaCodecInfoArr2;
                                            length = i4;
                                            supportedTypes = strArr;
                                            map = map;
                                            length2 = i5;
                                            i7 = i7;
                                            arrayList2 = arrayList2;
                                        }
                                    } catch (Throwable th10) {
                                        th = th10;
                                        strArr = supportedTypes;
                                        i5 = length2;
                                        if (o.a()) {
                                            this.b.a("DataCollector", "Failed to get capabilities for codec: " + mediaCodecInfo.getName() + ", MIME type: " + str, th);
                                        }
                                        i8++;
                                        codecInfos = mediaCodecInfoArr2;
                                        length = i4;
                                        supportedTypes = strArr;
                                        map = map;
                                        length2 = i5;
                                        i7 = i7;
                                        arrayList2 = arrayList2;
                                    }
                                }
                            } catch (Throwable th11) {
                                th = th11;
                                i4 = length;
                            }
                        } else {
                            arrayList2 = arrayList2;
                            i4 = length;
                            i7 = i7;
                            map = map;
                            strArr = supportedTypes;
                            i5 = length2;
                        }
                        i8++;
                        codecInfos = mediaCodecInfoArr2;
                        length = i4;
                        supportedTypes = strArr;
                        map = map;
                        length2 = i5;
                        i7 = i7;
                        arrayList2 = arrayList2;
                    }
                    ArrayList arrayList5 = arrayList2;
                    mediaCodecInfoArr = codecInfos;
                    i2 = length;
                    i3 = i7;
                    HashMap map5 = map;
                    if (arrayList3.isEmpty()) {
                        arrayList = arrayList5;
                    } else {
                        map5.put("supported_mime_types", arrayList3);
                        if (!map2.isEmpty()) {
                            map5.put("capabilities_by_type", map2);
                        }
                        arrayList = arrayList5;
                        arrayList.add(map5);
                    }
                }
                i7 = i3 + 1;
                arrayList2 = arrayList;
                codecInfos = mediaCodecInfoArr;
                length = i2;
            }
            return new JSONArray((Collection) arrayList2);
        } catch (Throwable th12) {
            if (o.a()) {
                this.b.a("DataCollector", "Failed to get MediaCodecList", th12);
            }
            return new JSONArray();
        }
    }

    public static String H() {
        return j;
    }

    private Map J() {
        return k7.a(a((Map) null, true, false));
    }

    private JSONArray M() {
        if (o0.e()) {
            return CollectionUtils.toJSONArray(Build.SUPPORTED_ABIS);
        }
        JSONArray jSONArray = new JSONArray();
        JsonUtils.putStringIfValid(jSONArray, Build.CPU_ABI);
        JsonUtils.putStringIfValid(jSONArray, Build.CPU_ABI2);
        return jSONArray;
    }

    private boolean N() {
        try {
            return b() || c();
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean O() {
        ConnectivityManager connectivityManager;
        if (o0.g() && (connectivityManager = (ConnectivityManager) this.c.getSystemService("connectivity")) != null) {
            try {
                return connectivityManager.getRestrictBackgroundStatus() == 3;
            } catch (Throwable th) {
                this.f660a.O();
                if (o.a()) {
                    this.f660a.O().a("DataCollector", "Unable to collect constrained network info.", th);
                }
            }
        }
        return false;
    }

    private boolean P() {
        boolean z = this.c.getResources().getConfiguration().keyboard == 2;
        PackageManager packageManager = this.c.getPackageManager();
        return z && (packageManager.hasSystemFeature("com.google.android.play.feature.HPE_EXPERIENCE") || packageManager.hasSystemFeature("android.hardware.type.pc"));
    }

    private Boolean Q() {
        if (o0.h()) {
            return Boolean.valueOf(this.c.getResources().getConfiguration().isScreenHdr());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S() {
        this.h.set(q());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(AppLovinBidTokenCollectionListener appLovinBidTokenCollectionListener) {
        try {
            String strG = G();
            if (StringUtils.isValidString(strG)) {
                this.f660a.O();
                if (o.a()) {
                    this.f660a.O().a("DataCollector", "Successfully retrieved bid token");
                }
                q2.a(appLovinBidTokenCollectionListener, strG);
                return;
            }
            this.f660a.O();
            if (o.a()) {
                this.f660a.O().b("DataCollector", "Empty bid token");
            }
            q2.b(appLovinBidTokenCollectionListener, "Empty bid token");
        } catch (Throwable th) {
            if (o.a()) {
                this.b.a("DataCollector", "Failed to collect bid token", th);
            }
            this.f660a.E().a("DataCollector", "collectBidToken", th);
            q2.b(appLovinBidTokenCollectionListener, "Failed to collect bid token");
        }
    }

    private boolean c() {
        String[] strArr = {"&zpz}ld&hyy&Z|yl{|zl{'hyb", "&zk`g&z|", "&zpz}ld&k`g&z|", "&zpz}ld&qk`g&z|", "&mh}h&efjhe&qk`g&z|", "&mh}h&efjhe&k`g&z|", "&zpz}ld&zm&qk`g&z|", "&zpz}ld&k`g&oh`ezhol&z|", "&mh}h&efjhe&z|"};
        for (int i2 = 0; i2 < 9; i2++) {
            if (new File(c(strArr[i2])).exists()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:106:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:108:0x01ae A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:109:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:112:0x01be  */
    /* JADX WARN: Code duplicated, block: B:114:0x01c5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:115:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:118:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:120:0x01dc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:121:0x01de  */
    /* JADX WARN: Code duplicated, block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:106:0x01a7, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:112:0x01be, please report this as an issue */
    private long d() {
        long j2;
        int iB;
        int iB2;
        int iB3;
        long j3;
        long j4;
        long j5;
        String strEmptyIfNull = StringUtils.emptyIfNull(Settings.Secure.getString(this.c.getContentResolver(), "enabled_accessibility_services"));
        long j6 = strEmptyIfNull.contains("AccessibilityMenuService") ? 256L : 0L;
        if (strEmptyIfNull.contains("SelectToSpeakService")) {
            j6 |= 512;
        }
        if (strEmptyIfNull.contains("SoundAmplifierService")) {
            j6 |= 2;
        }
        if (strEmptyIfNull.contains("SpeechToTextAccessibilityService")) {
            j6 |= 128;
        }
        if (strEmptyIfNull.contains("SwitchAccessService")) {
            j6 |= 4;
        }
        if ((this.c.getResources().getConfiguration().uiMode & 48) == 32) {
            j6 |= 1024;
        }
        if (a("accessibility_enabled")) {
            j6 |= 8;
        }
        if (a("touch_exploration_enabled")) {
            j6 |= 16;
        }
        if (o0.e()) {
            if (a("accessibility_display_inversion_enabled")) {
                j6 |= 32;
            }
            if (a("skip_first_use_hints")) {
                j6 |= 64;
            }
        }
        if (a("lock_screen_allow_remote_input")) {
            j6 |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        if (a("enabled_accessibility_audio_description_by_default")) {
            j6 |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        if (a("accessibility_shortcut_on_lock_screen")) {
            j6 |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        }
        if (a("wear_talkback_enabled")) {
            j6 |= 16384;
        }
        if (a("hush_gesture_used")) {
            j6 |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
        }
        if (a("high_text_contrast_enabled")) {
            j6 |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        }
        if (a("accessibility_display_magnification_enabled")) {
            j6 |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
        }
        if (a("accessibility_display_magnification_navbar_enabled")) {
            j6 |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
        }
        if (a("accessibility_captioning_enabled")) {
            j6 |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
        }
        if (a("accessibility_display_daltonizer_enabled")) {
            j6 |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        }
        if (a("accessibility_autoclick_enabled")) {
            j6 |= 2097152;
        }
        if (a("accessibility_large_pointer_icon")) {
            j6 |= PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED;
        }
        if (a("reduce_bright_colors_activated")) {
            j6 |= 8388608;
        }
        if (a("reduce_bright_colors_persist_across_reboots")) {
            j6 |= 16777216;
        }
        if (a("tty_mode_enabled")) {
            j6 |= 33554432;
        }
        if (a("rtt_calling_mode")) {
            j6 |= 67108864;
        }
        if (a("accessibility_floating_menu_fade_enabled")) {
            j6 |= 134217728;
        }
        if (a("accessibility_show_window_magnification_prompt")) {
            j6 |= 268435456;
        }
        if (a("accessibility_floating_menu_migration_tooltip_prompt")) {
            j6 |= 536870912;
        }
        int iB4 = b("accessibility_magnification_mode");
        if (iB4 == 0) {
            j2 = 1073741824;
        } else if (iB4 == 1) {
            j2 = 2147483648L;
        } else {
            if (iB4 != 2) {
                if (iB4 == 3) {
                    j2 = 8589934592L;
                }
                iB = b("accessibility_button_mode");
                if (iB == 0) {
                    j5 = iB == 1 ? 34359738368L : 17179869184L;
                    iB2 = b("accessibility_floating_menu_size");
                    if (iB2 == 0) {
                        j4 = iB2 == 1 ? 137438953472L : 68719476736L;
                        iB3 = b("accessibility_floating_menu_icon_type");
                        if (iB3 == 0) {
                            j3 = 274877906944L;
                        } else {
                            if (iB3 == 1) {
                                return j6;
                            }
                            j3 = 549755813888L;
                        }
                        return j6 | j3;
                    }
                    j6 |= j4;
                    iB3 = b("accessibility_floating_menu_icon_type");
                    if (iB3 == 0) {
                        j3 = 274877906944L;
                    } else {
                        if (iB3 == 1) {
                            return j6;
                        }
                        j3 = 549755813888L;
                    }
                    return j6 | j3;
                }
                j6 |= j5;
                iB2 = b("accessibility_floating_menu_size");
                if (iB2 == 0) {
                    if (iB2 == 1) {
                    }
                    iB3 = b("accessibility_floating_menu_icon_type");
                    if (iB3 == 0) {
                        j3 = 274877906944L;
                    } else {
                        if (iB3 == 1) {
                            return j6;
                        }
                        j3 = 549755813888L;
                    }
                    return j6 | j3;
                }
                j6 |= j4;
                iB3 = b("accessibility_floating_menu_icon_type");
                if (iB3 == 0) {
                    j3 = 274877906944L;
                } else {
                    if (iB3 == 1) {
                        return j6;
                    }
                    j3 = 549755813888L;
                }
                return j6 | j3;
            }
            j2 = 4294967296L;
        }
        j6 |= j2;
        iB = b("accessibility_button_mode");
        if (iB == 0) {
            if (iB == 1) {
            }
            iB2 = b("accessibility_floating_menu_size");
            if (iB2 == 0) {
                if (iB2 == 1) {
                }
                iB3 = b("accessibility_floating_menu_icon_type");
                if (iB3 == 0) {
                    j3 = 274877906944L;
                } else {
                    if (iB3 == 1) {
                        return j6;
                    }
                    j3 = 549755813888L;
                }
                return j6 | j3;
            }
            j6 |= j4;
            iB3 = b("accessibility_floating_menu_icon_type");
            if (iB3 == 0) {
                j3 = 274877906944L;
            } else {
                if (iB3 == 1) {
                    return j6;
                }
                j3 = 549755813888L;
            }
            return j6 | j3;
        }
        j6 |= j5;
        iB2 = b("accessibility_floating_menu_size");
        if (iB2 == 0) {
            if (iB2 == 1) {
            }
            iB3 = b("accessibility_floating_menu_icon_type");
            if (iB3 == 0) {
                j3 = 274877906944L;
            } else {
                if (iB3 == 1) {
                    return j6;
                }
                j3 = 549755813888L;
            }
            return j6 | j3;
        }
        j6 |= j4;
        iB3 = b("accessibility_floating_menu_icon_type");
        if (iB3 == 0) {
            j3 = 274877906944L;
        } else {
            if (iB3 == 1) {
                return j6;
            }
            j3 = 549755813888L;
        }
        return j6 | j3;
    }

    private List g() {
        ActivityManager activityManager;
        if (!o0.b()) {
            return null;
        }
        Integer num = (Integer) this.f660a.a(v4.x4);
        if (num.intValue() < 0 || (activityManager = (ActivityManager) this.c.getSystemService("activity")) == null) {
            return null;
        }
        List<ApplicationExitInfo> historicalProcessExitReasons = activityManager.getHistoricalProcessExitReasons(((Boolean) this.f660a.a(v4.y4)).booleanValue() ? this.c.getPackageName() : null, 0, num.intValue());
        if (CollectionUtils.isEmpty(historicalProcessExitReasons)) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(historicalProcessExitReasons.size());
        for (ApplicationExitInfo applicationExitInfo : historicalProcessExitReasons) {
            HashMap map = new HashMap(13);
            int reason = applicationExitInfo.getReason();
            map.put("reason", Integer.valueOf(reason));
            String description = applicationExitInfo.getDescription();
            CollectionUtils.putStringIfValid("description", description, map);
            map.put("timestamp", Long.valueOf(applicationExitInfo.getTimestamp()));
            map.put("status", Integer.valueOf(applicationExitInfo.getStatus()));
            map.put("importance", Integer.valueOf(applicationExitInfo.getImportance()));
            map.put("pss", Long.valueOf(applicationExitInfo.getPss()));
            map.put("rss", Long.valueOf(applicationExitInfo.getRss()));
            CollectionUtils.putStringIfValid("process_name", applicationExitInfo.getProcessName(), map);
            map.put("pid", Integer.valueOf(applicationExitInfo.getPid()));
            map.put("ruid", Integer.valueOf(applicationExitInfo.getRealUid()));
            map.put("puid", Integer.valueOf(applicationExitInfo.getPackageUid()));
            map.put("duid", Integer.valueOf(applicationExitInfo.getDefiningUid()));
            String strA = a(applicationExitInfo, reason);
            if (StringUtils.isValidString(strA)) {
                map.put("stack_trace", strA);
                b(strA, reason, description);
            }
            arrayList.add(map);
        }
        return arrayList;
    }

    private List i() {
        ActivityManager activityManager;
        if (!o0.c()) {
            return null;
        }
        Integer num = (Integer) this.f660a.a(v4.w4);
        if (num.intValue() < 0 || (activityManager = (ActivityManager) this.c.getSystemService("activity")) == null) {
            return null;
        }
        List<ApplicationStartInfo> historicalProcessStartReasons = activityManager.getHistoricalProcessStartReasons(num.intValue());
        if (CollectionUtils.isEmpty(historicalProcessStartReasons)) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(historicalProcessStartReasons.size());
        for (ApplicationStartInfo applicationStartInfo : historicalProcessStartReasons) {
            HashMap map = new HashMap(11);
            map.put("reason", Integer.valueOf(applicationStartInfo.getReason()));
            map.put("startup_state", Integer.valueOf(applicationStartInfo.getStartupState()));
            map.put("start_type", Integer.valueOf(applicationStartInfo.getStartType()));
            map.put("was_force_stopped", Boolean.valueOf(applicationStartInfo.wasForceStopped()));
            map.put("startup_timestamps", applicationStartInfo.getStartupTimestamps());
            CollectionUtils.putStringIfValid("process_name", applicationStartInfo.getProcessName(), map);
            map.put("pid", Integer.valueOf(applicationStartInfo.getPid()));
            map.put("ruid", Integer.valueOf(applicationStartInfo.getRealUid()));
            map.put("puid", Integer.valueOf(applicationStartInfo.getPackageUid()));
            map.put("duid", Integer.valueOf(applicationStartInfo.getDefiningUid()));
            map.put("launch_mode", Integer.valueOf(applicationStartInfo.getLaunchMode()));
            map.put(SDKConstants.PARAM_INTENT, a(applicationStartInfo.getIntent()));
            arrayList.add(map);
        }
        return arrayList;
    }

    private c j() {
        c cVar = new c();
        Intent intentRegisterReceiver = this.c.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int intExtra = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("level", -1) : -1;
        int intExtra2 = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("scale", -1) : -1;
        if (intExtra <= 0 || intExtra2 <= 0) {
            cVar.b = -1;
        } else {
            cVar.b = (int) ((intExtra / intExtra2) * 100.0f);
        }
        cVar.f663a = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("status", -1) : -1;
        cVar.c = Boolean.valueOf(Settings.Global.getInt(this.c.getContentResolver(), "stay_on_while_plugged_in", -1) > 0);
        return cVar;
    }

    private String k() {
        TelephonyManager telephonyManager = (TelephonyManager) this.c.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        try {
            return telephonyManager.getNetworkOperatorName();
        } catch (Throwable th) {
            if (!o.a()) {
                return "";
            }
            this.b.a("DataCollector", "Unable to collect carrier", th);
            return "";
        }
    }

    private String m() {
        TelephonyManager telephonyManager = (TelephonyManager) this.c.getSystemService("phone");
        return telephonyManager != null ? telephonyManager.getSimCountryIso().toUpperCase(Locale.ENGLISH) : "";
    }

    private String n() {
        ActivityInfo activityInfo;
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://"));
        ResolveInfo resolveInfoResolveActivity = this.c.getPackageManager().resolveActivity(intent, 65536);
        if (resolveInfoResolveActivity != null && (activityInfo = resolveInfoResolveActivity.activityInfo) != null) {
            j = activityInfo.packageName;
        }
        return j;
    }

    private String p() {
        if (!o0.g()) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            LocaleList locales = this.c.getResources().getConfiguration().getLocales();
            for (int i2 = 0; i2 < locales.size(); i2++) {
                sb.append(locales.get(i2));
                sb.append(io.appmetrica.analytics.coreutils.internal.StringUtils.COMMA);
            }
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ',') {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    private Float q() {
        Float f = (Float) this.f660a.a(v4.X3);
        Float fB = this.f660a.q().b();
        if (fB != null) {
            return Float.valueOf(fB.floatValue() * f.floatValue());
        }
        return null;
    }

    private float r() {
        try {
            return Settings.System.getFloat(this.c.getContentResolver(), "font_scale");
        } catch (Settings.SettingNotFoundException e) {
            if (!o.a()) {
                return -1.0f;
            }
            this.b.a("DataCollector", "Error collecting font scale", e);
            return -1.0f;
        }
    }

    private boolean s() {
        SensorManager sensorManager = (SensorManager) this.c.getSystemService("sensor");
        return (sensorManager == null || sensorManager.getDefaultSensor(4) == null) ? false : true;
    }

    private Map t() {
        HashMap map = new HashMap();
        CollectionUtils.putIntegerIfValid("IABTCF_gdprApplies", this.f660a.s0().g(), map);
        CollectionUtils.putStringIfValid("IABTCF_TCString", this.f660a.s0().j(), map);
        CollectionUtils.putStringIfValid("IABTCF_AddtlConsent", this.f660a.s0().c(), map);
        return map;
    }

    private Boolean u() {
        AudioManager audioManager = (AudioManager) this.c.getSystemService("audio");
        if (audioManager == null) {
            return null;
        }
        return Boolean.valueOf(audioManager.isMusicActive());
    }

    private Boolean v() {
        AudioManager audioManager = (AudioManager) this.c.getSystemService("audio");
        if (audioManager == null) {
            return null;
        }
        return Boolean.valueOf(audioManager.isSpeakerphoneOn());
    }

    private String w() {
        TelephonyManager telephonyManager = (TelephonyManager) this.c.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        try {
            String networkOperator = telephonyManager.getNetworkOperator();
            return networkOperator.substring(0, Math.min(3, networkOperator.length()));
        } catch (Throwable th) {
            if (!o.a()) {
                return "";
            }
            this.b.a("DataCollector", "Unable to collect mobile country code", th);
            return "";
        }
    }

    private String x() {
        TelephonyManager telephonyManager = (TelephonyManager) this.c.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        try {
            String networkOperator = telephonyManager.getNetworkOperator();
            return networkOperator.substring(Math.min(3, networkOperator.length()));
        } catch (Throwable th) {
            if (!o.a()) {
                return "";
            }
            this.b.a("DataCollector", "Unable to collect mobile network code", th);
            return "";
        }
    }

    private String z() {
        AudioManager audioManager = (AudioManager) this.c.getSystemService("audio");
        if (audioManager == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (o0.f()) {
            for (AudioDeviceInfo audioDeviceInfo : audioManager.getDevices(2)) {
                sb.append(audioDeviceInfo.getType());
                sb.append(io.appmetrica.analytics.coreutils.internal.StringUtils.COMMA);
            }
        } else {
            if (audioManager.isWiredHeadsetOn()) {
                sb.append("3,");
            }
            if (audioManager.isBluetoothScoOn()) {
                sb.append("7,");
            }
            if (audioManager.isBluetoothA2dpOn()) {
                sb.append(8);
            }
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ',') {
            sb.deleteCharAt(sb.length() - 1);
        }
        String string = sb.toString();
        if (TextUtils.isEmpty(string) && o.a()) {
            this.b.a("DataCollector", "No sound outputs detected");
        }
        return string;
    }

    public Map E() {
        Map map = CollectionUtils.map(this.f);
        String str = StringUtils.isValidString(i) ? i : this.c.getApplicationInfo().packageName;
        map.put("package_name", str);
        map.put("vz", StringUtils.toShortSHA1Hash(str));
        map.put("first_install", Boolean.valueOf(this.f660a.D0()));
        map.put("first_install_v2", Boolean.valueOf(!this.f660a.A0()));
        map.put("test_ads", Boolean.valueOf(this.g));
        map.put("test_mode", Integer.valueOf(this.f660a.t0().c() ? 1 : 0));
        map.put("muted", Boolean.valueOf(this.f660a.o0().isMuted()));
        if (((Boolean) this.f660a.a(v4.x3)).booleanValue()) {
            CollectionUtils.putStringIfValid("cuid", this.f660a.x0().e(), map);
        }
        if (((Boolean) this.f660a.a(v4.A3)).booleanValue()) {
            map.put("compass_random_token", this.f660a.v());
        }
        if (((Boolean) this.f660a.a(v4.C3)).booleanValue()) {
            map.put("applovin_random_token", this.f660a.i0());
        }
        if (((Boolean) this.f660a.a(v4.G3)).booleanValue()) {
            map.put("art", this.f660a.s());
        }
        map.putAll(t());
        if (this.f660a.h0() != null) {
            CollectionUtils.putJsonArrayIfValid("ps_topics", this.f660a.h0().a(), map);
        }
        CollectionUtils.putStringIfValid("template_browser_package_name", (String) this.f660a.q0().a(x4.S, null), map);
        return map;
    }

    public b F() {
        return (b) l.get();
    }

    protected String G() {
        String strEncodeToString = Base64.encodeToString(new JSONObject(J()).toString().getBytes(Charset.defaultCharset()), 2);
        return ((Boolean) this.f660a.a(v4.c5)).booleanValue() ? s4.b(strEncodeToString, k7.a(this.f660a), s4.a.a(((Integer) this.f660a.a(v4.d5)).intValue()), this.f660a.j0(), this.f660a) : strEncodeToString;
    }

    public String I() {
        ActivityManager activityManager = (ActivityManager) this.c.getSystemService("activity");
        if (activityManager == null) {
            return null;
        }
        return activityManager.getDeviceConfigurationInfo().getGlEsVersion();
    }

    public Map K() {
        return CollectionUtils.map(this.f);
    }

    public Map L() {
        return CollectionUtils.map(this.d);
    }

    public boolean R() {
        return this.g;
    }

    public void T() {
        b6 b6VarR0 = this.f660a.r0();
        m5 m5Var = new m5(this.f660a, new a());
        b6.b bVar = b6.b.OTHER;
        b6VarR0.a((g5) m5Var, bVar);
        this.f660a.r0().a((g5) new p6(this.f660a, true, "setDeviceVolume", new Runnable() { // from class: com.applovin.impl.sdk.l$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.S();
            }
        }), bVar);
    }

    public void U() {
        synchronized (this.e) {
            a(this.d);
        }
    }

    public Map e() {
        HashMap map = new HashMap();
        map.put("sc", this.f660a.a(v4.l));
        map.put("sc2", this.f660a.a(v4.m));
        map.put("sc3", this.f660a.a(v4.n));
        map.put("server_installed_at", this.f660a.a(v4.o));
        CollectionUtils.putStringIfValid("persisted_data", (String) this.f660a.a(x4.G), map);
        return map;
    }

    public v.a f() {
        v.a aVarB = v.b(this.c);
        if (aVarB == null) {
            return new v.a();
        }
        if (((Boolean) this.f660a.a(v4.v3)).booleanValue()) {
            if (aVarB.c() && !((Boolean) this.f660a.a(v4.u3)).booleanValue()) {
                aVarB.a("");
            }
            k.set(aVarB);
        } else {
            aVarB = new v.a();
        }
        List<String> testDeviceAdvertisingIds = this.f660a.K() != null ? this.f660a.K().getTestDeviceAdvertisingIds() : null;
        if (testDeviceAdvertisingIds != null) {
            String strA = aVarB.a();
            if (StringUtils.isValidString(strA)) {
                this.g = testDeviceAdvertisingIds.contains(strA);
            }
            b bVarF = F();
            String str = bVarF != null ? bVarF.f662a : null;
            if (StringUtils.isValidString(str)) {
                this.g = testDeviceAdvertisingIds.contains(str) | this.g;
            }
        } else {
            this.g = false;
        }
        return aVarB;
    }

    public Map l() {
        HashMap map = new HashMap();
        z3 z3VarD0 = this.f660a.d0();
        Deque dequeB = z3VarD0.b();
        if (!CollectionUtils.isEmpty(dequeB)) {
            map.put("network_throughput_info", dequeB);
        }
        CollectionUtils.putLongIfValid("network_throughput_kbps", z3VarD0.a(), map);
        q0.d dVarA = this.f660a.x().a();
        if (dVarA != null) {
            map.put("lrm_ts_ms", String.valueOf(dVarA.c()));
            map.put("lrm_url", dVarA.d());
            map.put("lrm_ct_ms", String.valueOf(dVarA.a()));
            map.put("lrm_rs", String.valueOf(dVarA.b()));
        }
        if (map.isEmpty()) {
            return null;
        }
        return map;
    }

    public Map o() {
        return a(false);
    }

    public String y() {
        return AppLovinSdkUtils.isFireOS(this.c) ? "fireos" : "android";
    }

    private String h() {
        int orientation = AppLovinSdkUtils.getOrientation(this.c);
        if (orientation == 1) {
            return "portrait";
        }
        return orientation == 2 ? "landscape" : "none";
    }

    protected void a(final AppLovinBidTokenCollectionListener appLovinBidTokenCollectionListener) {
        this.f660a.r0().a((g5) new p6(this.f660a, ((Boolean) this.f660a.a(v4.K3)).booleanValue(), "DataCollector", new Runnable() { // from class: com.applovin.impl.sdk.l$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(appLovinBidTokenCollectionListener);
            }
        }), b6.b.CORE);
    }

    public Map a(Map map, boolean z, boolean z2) {
        HashMap map2 = new HashMap(64);
        Map mapA = a(z);
        Map mapE = E();
        Map mapL = l();
        Map mapL0 = this.f660a.l0();
        if (z2) {
            map2.put(DeviceRequestsHelper.DEVICE_INFO_PARAM, mapA);
            map2.put("app_info", mapE);
            if (mapL != null) {
                map2.put("connection_info", mapL);
            }
            if (map != null) {
                map2.put("ad_info", map);
            }
            if (!CollectionUtils.isEmpty(mapL0)) {
                map2.put("segments", mapL0);
            }
        } else {
            map2.putAll(mapA);
            map2.putAll(mapE);
            if (mapL != null) {
                map2.putAll(mapL);
            }
            if (map != null) {
                map2.putAll(map);
            }
            if (!CollectionUtils.isEmpty(mapL0)) {
                map2.putAll(mapL0);
            }
        }
        map2.put("accept", "custom_size,launch_app,video");
        map2.put("format", "json");
        CollectionUtils.putStringIfValid("mediation_provider", this.f660a.V(), map2);
        CollectionUtils.putStringIfValid("mediation_provider_v2", this.f660a.D(), map2);
        CollectionUtils.putStringIfValid("plugin_version", (String) this.f660a.a(v4.I3), map2);
        CollectionUtils.putLongIfValid("tssf_ms", Long.valueOf(this.f660a.u0()), map2);
        if (!((Boolean) this.f660a.a(v4.a5)).booleanValue()) {
            map2.put("sdk_key", this.f660a.j0());
        }
        CollectionUtils.putStringIfValid("connectEventKey", this.f660a.r(), map2);
        map2.putAll(e());
        map2.put(com.safedk.android.analytics.brandsafety.l.x, UUID.randomUUID().toString());
        return map2;
    }

    private void b(final String str, final int i2, final String str2) {
        this.f660a.r0().a((g5) new p6(this.f660a, "reportAppExitInfoStackTrace", new Runnable() { // from class: com.applovin.impl.sdk.l$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(str, i2, str2);
            }
        }), b6.b.OTHER);
    }

    private String c(String str) {
        int length = str.length();
        int[] iArr = {11, 12, 10, 3, 2, 1, 15, 10, 15, 14};
        char[] cArr = new char[length];
        for (int i2 = 0; i2 < length; i2++) {
            cArr[i2] = str.charAt(i2);
            for (int i3 = 9; i3 >= 0; i3--) {
                cArr[i2] = (char) (cArr[i2] ^ iArr[i3]);
            }
        }
        return new String(cArr);
    }

    private int b(String str) {
        try {
            return Settings.Secure.getInt(this.c.getContentResolver(), str);
        } catch (Throwable unused) {
            return -1;
        }
    }

    private boolean b() {
        String str = Build.TAGS;
        return str != null && str.contains(c("lz}$blpz"));
    }

    public Map a(boolean z) {
        Map map;
        synchronized (this.e) {
            map = CollectionUtils.map(this.d);
        }
        return a(map, z);
    }

    private void a(Map map) {
        JSONArray jSONArrayD;
        if (((Boolean) this.f660a.a(v4.R3)).booleanValue() && !map.containsKey(ApsMetricsDataMap.APSMETRICS_FIELD_ADFORMAT)) {
            map.put(ApsMetricsDataMap.APSMETRICS_FIELD_ADFORMAT, Long.valueOf(d()));
        }
        if (((Boolean) this.f660a.a(v4.S3)).booleanValue() && !map.containsKey("font")) {
            map.put("font", Float.valueOf(r()));
        }
        if (((Boolean) this.f660a.a(v4.Z3)).booleanValue() && k7.d(this.f660a)) {
            k8.a(this.f660a);
        }
        if (((Boolean) this.f660a.a(v4.k4)).booleanValue()) {
            k8.b(this.f660a);
        }
        if (((Boolean) this.f660a.a(v4.Y3)).booleanValue() && !map.containsKey("sua")) {
            map.put("sua", System.getProperty("http.agent"));
        }
        if (((Boolean) this.f660a.a(v4.U3)).booleanValue() && !map.containsKey("network_restricted")) {
            map.put("network_restricted", Boolean.valueOf(O()));
        }
        map.put("is_pc", Boolean.valueOf(P()));
        if (((Boolean) this.f660a.a(v4.m4)).booleanValue()) {
            CollectionUtils.putStringIfValid("oglv", I(), map);
        }
        if (((Boolean) this.f660a.a(v4.y6)).booleanValue()) {
            CollectionUtils.putStringIfValid("dbpn", n(), map);
        }
        if (!((Boolean) this.f660a.a(v4.z6)).booleanValue() || map.containsKey("video_decoders") || (jSONArrayD = D()) == null || jSONArrayD.length() <= 0) {
            return;
        }
        map.put("video_decoders", jSONArrayD);
    }

    private Map a(Map map, boolean z) {
        v.a aVarF;
        PowerManager powerManager;
        Map map2 = CollectionUtils.map(map);
        Point pointB = o0.b(this.c);
        map2.put("dx", Integer.valueOf(pointB.x));
        map2.put("dy", Integer.valueOf(pointB.y));
        DisplayMetrics displayMetrics = this.c.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            map2.put("screen_size_in", Double.valueOf(Math.sqrt(Math.pow(pointB.x, 2.0d) + Math.pow(pointB.y, 2.0d)) / ((double) displayMetrics.xdpi)));
        }
        map2.put("is_tablet", Boolean.valueOf(AppLovinSdkUtils.isTablet(this.c)));
        if (((Boolean) this.f660a.a(v4.B4)).booleanValue()) {
            String strB = k7.b(this.c);
            Map mapA = o0.a(strB);
            if (mapA != null) {
                map2.put("display_cutout_insets", mapA);
            }
            Map mapC = o0.c(strB);
            if (mapC != null) {
                map2.put("status_bar_insets", mapC);
            }
            Map mapB = o0.b(strB);
            if (mapB != null) {
                map2.put("nav_bar_insets", mapB);
            }
        }
        if (z) {
            aVarF = (v.a) k.get();
            if (aVarF != null) {
                T();
            } else if (k7.h()) {
                aVarF = new v.a();
                map2.put("inc", Boolean.TRUE);
            } else {
                aVarF = f();
            }
        } else {
            aVarF = f();
        }
        String strA = aVarF.a();
        if (StringUtils.isValidString(strA)) {
            map2.put("idfa", strA);
        }
        map2.put("dnt", Boolean.valueOf(aVarF.c()));
        map2.put("dnt_code", aVarF.b().b());
        b bVar = (b) l.get();
        if (((Boolean) this.f660a.a(v4.w3)).booleanValue() && bVar != null) {
            map2.put("idfv", bVar.f662a);
            map2.put("idfv_scope", Integer.valueOf(bVar.b));
        }
        Boolean boolB = p0.b().b(this.c);
        if (boolB != null) {
            map2.put("huc", boolB);
        }
        Boolean boolB2 = p0.c().b(this.c);
        if (boolB2 != null) {
            map2.put("aru", boolB2);
        }
        Boolean boolB3 = p0.a().b(this.c);
        if (boolB3 != null) {
            map2.put("dns", boolB3);
        }
        if (((Boolean) this.f660a.a(v4.L3)).booleanValue()) {
            c cVarJ = j();
            CollectionUtils.putIntegerIfValid("act", Integer.valueOf(cVarJ.f663a), map2);
            CollectionUtils.putIntegerIfValid("acm", Integer.valueOf(cVarJ.b), map2);
            CollectionUtils.putBooleanIfValid("sowpie", cVarJ.c, map2);
        }
        if (((Boolean) this.f660a.a(v4.T3)).booleanValue()) {
            map2.put("mtl", Integer.valueOf(this.f660a.n0().getLastTrimMemoryLevel()));
        }
        if (((Boolean) this.f660a.a(v4.W3)).booleanValue()) {
            map2.put(com.safedk.android.analytics.brandsafety.l.C, Boolean.valueOf(N()));
        }
        Float fQ = z ? (Float) this.h.get() : q();
        if (fQ != null) {
            map2.put("volume", fQ);
        }
        CollectionUtils.putBooleanIfValid("ma", u(), map2);
        CollectionUtils.putBooleanIfValid("spo", v(), map2);
        CollectionUtils.putBooleanIfValid("aif", Boolean.valueOf(!this.f660a.n0().isApplicationPaused()), map2);
        CollectionUtils.putLongIfValid("af_ts_ms", Long.valueOf(this.f660a.n0().getAppEnteredForegroundTimeMillis()), map2);
        CollectionUtils.putLongIfValid("ab_ts_ms", Long.valueOf(this.f660a.n0().getAppEnteredBackgroundTimeMillis()), map2);
        try {
            map2.put("sb", Integer.valueOf((int) ((Settings.System.getInt(this.c.getContentResolver(), "screen_brightness") / 255.0f) * 100.0f)));
        } catch (Settings.SettingNotFoundException e) {
            if (o.a()) {
                this.b.a("DataCollector", "Unable to collect screen brightness", e);
            }
        }
        if (((Boolean) this.f660a.a(v4.Z3)).booleanValue() && k7.d(this.f660a)) {
            k8.a(this.f660a);
            String strA2 = k8.a();
            if (StringUtils.isValidString(strA2)) {
                map2.put("ua", strA2);
            }
        }
        if (((Boolean) this.f660a.a(v4.k4)).booleanValue()) {
            k8.b(this.f660a);
            CollectionUtils.putIntegerIfValid("wvvc", Integer.valueOf(k8.d()), map2);
            CollectionUtils.putStringIfValid("wvv", k8.c(), map2);
            CollectionUtils.putStringIfValid("wvpn", k8.b(), map2);
        }
        if (((Boolean) this.f660a.a(v4.N3)).booleanValue()) {
            try {
                map2.put(fe.P0, Long.valueOf(Environment.getDataDirectory().getFreeSpace()));
                map2.put("tds", Long.valueOf(Environment.getDataDirectory().getTotalSpace()));
            } catch (Throwable th) {
                map2.put(fe.P0, -1);
                map2.put("tds", -1);
                if (o.a()) {
                    this.b.a("DataCollector", "Unable to collect total & free space.", th);
                }
            }
        }
        if (((Boolean) this.f660a.a(v4.O3)).booleanValue()) {
            ActivityManager.MemoryInfo memoryInfoA = k7.a((ActivityManager) this.c.getSystemService("activity"));
            if (memoryInfoA != null) {
                map2.put("fm", Long.valueOf(memoryInfoA.availMem));
                map2.put("tm", Long.valueOf(memoryInfoA.totalMem));
                map2.put("lmt", Long.valueOf(memoryInfoA.threshold));
                map2.put("lm", Boolean.valueOf(memoryInfoA.lowMemory));
            } else {
                map2.put("fm", -1);
                map2.put("tm", -1);
                map2.put("lmt", -1);
            }
        }
        if (((Boolean) this.f660a.a(v4.P3)).booleanValue() && o0.a("android.permission.READ_PHONE_STATE", this.c) && o0.g()) {
            map2.put("rat", Integer.valueOf(((TelephonyManager) this.c.getSystemService("phone")).getDataNetworkType()));
        }
        if (((Boolean) this.f660a.a(v4.M3)).booleanValue()) {
            String strZ = z();
            if (!TextUtils.isEmpty(strZ)) {
                map2.put("so", strZ);
            }
        }
        map2.put(BrandSafetyEvent.aw, k7.b(this.c));
        map2.put("orientation_lock", h());
        if (((Boolean) this.f660a.a(v4.Q3)).booleanValue()) {
            map2.put("vs", Boolean.valueOf(k7.j()));
        }
        if (o0.e() && (powerManager = (PowerManager) this.c.getSystemService("power")) != null) {
            map2.put(fe.U0, Integer.valueOf(powerManager.isPowerSaveMode() ? 1 : 0));
        }
        if (((Boolean) this.f660a.a(v4.b4)).booleanValue() && this.f660a.m0() != null) {
            map2.put("da", Float.valueOf(this.f660a.m0().a()));
        }
        if (((Boolean) this.f660a.a(v4.c4)).booleanValue() && this.f660a.m0() != null) {
            map2.put(ApsMetricsDataMap.APSMETRICS_FIELD_MANUFACTURER, Float.valueOf(this.f660a.m0().b()));
        }
        map2.put("mute_switch", Integer.valueOf(this.f660a.q().c()));
        map2.put("network", r0.g(this.f660a));
        String strP = p();
        if (StringUtils.isValidString(strP)) {
            map2.put("kb", strP);
        }
        ArrayService arrayServiceP = this.f660a.p();
        if (arrayServiceP.isAppHubInstalled()) {
            if (arrayServiceP.getIsDirectDownloadEnabled() != null) {
                map2.put("ah_dd_enabled", arrayServiceP.getIsDirectDownloadEnabled());
            }
            map2.put("ah_sdk_version_code", Long.valueOf(arrayServiceP.getAppHubVersionCode()));
            map2.put("ah_random_user_token", StringUtils.emptyIfNull(arrayServiceP.getRandomUserToken()));
            map2.put("ah_sdk_package_name", StringUtils.emptyIfNull(arrayServiceP.getAppHubPackageName()));
        }
        return map2;
    }

    private Map a(Intent intent) {
        if (intent == null) {
            return Collections.emptyMap();
        }
        HashMap map = new HashMap(5);
        map.put("action", StringUtils.emptyIfNull(intent.getAction()));
        map.put("data", StringUtils.emptyIfNull(intent.getDataString()));
        map.put("flags", Integer.valueOf(intent.getFlags()));
        ComponentName component = intent.getComponent();
        map.put("component", component != null ? component.flattenToString() : "");
        Set<String> categories = intent.getCategories();
        map.put("categories", categories != null ? new ArrayList(categories) : Collections.emptyList());
        return map;
    }

    private String a(ApplicationExitInfo applicationExitInfo, int i2) {
        InputStream traceInputStream;
        String line;
        if (this.f660a.c(v4.A4).contains(Integer.toString(i2))) {
            return null;
        }
        Integer num = (Integer) this.f660a.a(v4.z4);
        if (num.intValue() <= 0) {
            return null;
        }
        try {
            traceInputStream = applicationExitInfo.getTraceInputStream();
        } catch (Throwable th) {
            this.f660a.O();
            if (o.a()) {
                this.f660a.O().a("DataCollector", "Failed to obtain trace input stream from application exit info", th);
            }
            this.f660a.E().b("DataCollector", "getTraceInputStream", th);
            traceInputStream = null;
        }
        if (traceInputStream == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(traceInputStream));
            for (int i3 = 0; i3 < num.intValue() && (line = bufferedReader.readLine()) != null; i3++) {
                try {
                    sb.append(line).append('\n');
                } catch (Throwable th2) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
            bufferedReader.close();
        } catch (Throwable th4) {
            this.f660a.O();
            if (o.a()) {
                this.f660a.O().a("DataCollector", "Failed to read stack trace from input stream", th4);
            }
            this.f660a.E().b("DataCollector", "readStackTraceFromInputStream", th4);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, int i2, String str2) {
        HashMap<String, String> mapHashMap = CollectionUtils.hashMap("details", str);
        CollectionUtils.putIntegerIfValid("error_code", Integer.valueOf(i2), mapHashMap);
        CollectionUtils.putStringIfValid("error_message", str2, mapHashMap);
        this.f660a.E().d(c2.s0, mapHashMap);
    }

    public static void a(v.a aVar) {
        k.set(aVar);
    }

    public static void a(b bVar) {
        l.set(bVar);
    }

    public static void a(String str, k kVar) {
        String strA = a(k.o().getApplicationInfo().packageName, k.o().getPackageManager(), kVar);
        List listC = kVar.c(v4.K6);
        if (!StringUtils.isValidString(strA) || listC.contains(strA)) {
            i = str;
        }
    }

    private boolean a(String str) {
        return b(str) == 1;
    }

    private static String a(String str, PackageManager packageManager, k kVar) {
        try {
            if (((Boolean) kVar.a(v4.u4)).booleanValue() && o0.b()) {
                return packageManager.getInstallSourceInfo(str).getInstallingPackageName();
            }
            return packageManager.getInstallerPackageName(str);
        } catch (Throwable th) {
            kVar.E().a("DataCollector", "getInstallerName", th);
            return null;
        }
    }
}
