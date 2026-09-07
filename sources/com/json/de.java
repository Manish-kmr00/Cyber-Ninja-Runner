package com.json;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.support.v4.media.session.PlaybackStateCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.amazon.device.ads.DtbDeviceData;
import com.json.mediationsdk.config.ConfigFile;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.logger.IronSourceLogger;
import com.json.mediationsdk.logger.IronSourceLoggerManager;
import com.json.mediationsdk.p;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.json.mediationsdk.utils.IronSourceUtils;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes10.dex */
public class de implements Runnable {
    public static final String M = "sdkVersion";
    public static final String N = "AdvIdOptOutReason";
    private static final int O = 15;
    private static final int P = 840;
    private static final int Q = -720;
    private Context K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f3609a = getClass().getSimpleName();
    private final String b = "bundleId";
    private final String c = "advertisingId";
    private final String d = b9.i.M;
    private final String e = "appKey";
    private final String f = "deviceOS";
    private final String g = DtbDeviceData.DEVICE_DATA_OS_VERSION_KEY;
    private final String h = b9.i.t;
    private final String i = b9.i.u;
    private final String j = POBConstants.KEY_LANGUAGE;
    private final String k = b9.i.k;
    private final String l = b9.i.l;
    private final String m = b9.i.r;
    private final String n = "externalFreeMemory";
    private final String o = "internalFreeMemory";
    private final String p = "battery";
    private final String q = "gmtMinutesOffset";
    private final String r = "appVersion";
    private final String s = JsonStorageKeyNames.SESSION_ID_KEY;
    private final String t = "pluginType";
    private final String u = "pluginVersion";
    private final String v = "plugin_fw_v";
    private final String w = "jb";
    private final String x = "advertisingIdType";
    private final String y = "mt";
    private final String z = "firstSession";
    private final String A = "mcc";
    private final String B = "mnc";
    private final String C = "icc";
    private final String D = "tz";
    private final String E = "auid";
    private final String F = "userLat";
    private final String G = "publisherAPI";
    private final String H = "missingDependencies";
    private final String I = "missingManifest";
    private final String J = "other";
    private final nf L = mm.S().f();

    private de() {
    }

    public de(Context context) {
        this.K = context.getApplicationContext();
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "missingDependencies";
        }
        if (!xa.f4585a.b()) {
            return "publisherAPI";
        }
        if (this.L.v(this.K)) {
            return Boolean.parseBoolean(str) ? "userLat" : "other";
        }
        return "missingManifest";
    }

    private Map<String, Object> a() {
        boolean z;
        String str;
        HashMap map = new HashMap();
        map.put(JsonStorageKeyNames.SESSION_ID_KEY, IronSourceUtils.getSessionId());
        String strE = e();
        if (!TextUtils.isEmpty(strE)) {
            map.put("bundleId", strE);
            String strB = c4.b(this.K, strE);
            if (!TextUtils.isEmpty(strB)) {
                map.put("appVersion", strB);
            }
        }
        map.put("appKey", c());
        String strP = this.L.p(this.K);
        String strA = this.L.a(this.K);
        boolean z2 = false;
        if (TextUtils.isEmpty(strP)) {
            strP = this.L.M(this.K);
            z = true;
            str = !TextUtils.isEmpty(strP) ? IronSourceConstants.TYPE_UUID : "";
        } else {
            str = IronSourceConstants.TYPE_GAID;
            z = false;
        }
        if (!TextUtils.isEmpty(strP)) {
            map.put("advertisingId", strP);
            map.put("advertisingIdType", str);
        }
        if (!TextUtils.isEmpty(strA)) {
            z2 = Boolean.parseBoolean(strA);
            map.put(b9.i.M, Boolean.valueOf(z2));
        }
        if (z || z2) {
            map.put(N, a(strA));
        }
        map.put("deviceOS", h());
        if (!TextUtils.isEmpty(b())) {
            map.put(DtbDeviceData.DEVICE_DATA_OS_VERSION_KEY, b());
        }
        String connectionType = IronSourceUtils.getConnectionType(this.K);
        if (!TextUtils.isEmpty(connectionType)) {
            map.put(b9.i.t, connectionType);
        }
        String strD = y8.d(this.K);
        if (!TextUtils.isEmpty(strD)) {
            map.put(b9.i.u, strD);
        }
        map.put("sdkVersion", r());
        String strL = l();
        if (!TextUtils.isEmpty(strL)) {
            map.put(POBConstants.KEY_LANGUAGE, strL);
        }
        String strG = g();
        if (!TextUtils.isEmpty(strG)) {
            map.put(b9.i.k, strG);
        }
        String strF = f();
        if (!TextUtils.isEmpty(strF)) {
            map.put(b9.i.l, strF);
        }
        String strN = n();
        if (!TextUtils.isEmpty(strN)) {
            map.put(b9.i.r, strN);
        }
        map.put("internalFreeMemory", Long.valueOf(k()));
        map.put("externalFreeMemory", Long.valueOf(i()));
        map.put("battery", Integer.valueOf(d()));
        int iJ = j();
        if (a(iJ)) {
            map.put("gmtMinutesOffset", Integer.valueOf(iJ));
        }
        String strP2 = p();
        if (!TextUtils.isEmpty(strP2)) {
            map.put("pluginType", strP2);
        }
        String strQ = q();
        if (!TextUtils.isEmpty(strQ)) {
            map.put("pluginVersion", strQ);
        }
        String strO = o();
        if (!TextUtils.isEmpty(strO)) {
            map.put("plugin_fw_v", strO);
        }
        String strValueOf = String.valueOf(this.L.f());
        if (!TextUtils.isEmpty(strValueOf)) {
            map.put("jb", strValueOf);
        }
        String strM = m();
        if (!TextUtils.isEmpty(strM)) {
            map.put("mt", strM);
        }
        String strValueOf2 = String.valueOf(IronSourceUtils.getFirstSession(this.K));
        if (!TextUtils.isEmpty(strValueOf2)) {
            map.put("firstSession", strValueOf2);
        }
        String strT = this.L.t(this.K);
        if (!TextUtils.isEmpty(strT)) {
            map.put("auid", strT);
        }
        map.put("mcc", Integer.valueOf(x8.b(this.K)));
        map.put("mnc", Integer.valueOf(x8.c(this.K)));
        String strN2 = this.L.n(this.K);
        if (!TextUtils.isEmpty(strN2)) {
            map.put("icc", strN2);
        }
        String strB2 = this.L.b();
        if (!TextUtils.isEmpty(strB2)) {
            map.put("tz", strB2);
        }
        IronLog.INTERNAL.verbose("collecting data for events: " + map);
        return map;
    }

    private boolean a(int i) {
        return i <= P && i >= Q && i % 15 == 0;
    }

    private String b() {
        try {
            return "" + Build.VERSION.SDK_INT + "(" + Build.VERSION.RELEASE + ")";
        } catch (Exception e) {
            o9.d().a(e);
            return "";
        }
    }

    private String c() {
        return p.m().n();
    }

    private int d() {
        try {
            Intent intentRegisterReceiver = this.K.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("level", -1) : 0;
            int intExtra2 = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("scale", -1) : 0;
            if (intExtra == -1 || intExtra2 == -1) {
                return -1;
            }
            return (int) ((intExtra / intExtra2) * 100.0f);
        } catch (Exception e) {
            o9.d().a(e);
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, this.f3609a + ":getBatteryLevel()", e);
            return -1;
        }
    }

    private String e() {
        try {
            return this.K.getPackageName();
        } catch (Exception e) {
            o9.d().a(e);
            return "";
        }
    }

    private String f() {
        try {
            return Build.MODEL;
        } catch (Exception e) {
            o9.d().a(e);
            return "";
        }
    }

    private String g() {
        try {
            return Build.MANUFACTURER;
        } catch (Exception e) {
            o9.d().a(e);
            return "";
        }
    }

    private String h() {
        return "Android";
    }

    private long i() {
        if (!s()) {
            return -1L;
        }
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return (((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
    }

    private int j() {
        try {
            TimeZone timeZone = TimeZone.getDefault();
            return Math.round(((timeZone.getOffset(Calendar.getInstance(timeZone).getTimeInMillis()) / 1000) / 60) / 15) * 15;
        } catch (Exception e) {
            o9.d().a(e);
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, this.f3609a + ":getGmtMinutesOffset()", e);
            return 0;
        }
    }

    private long k() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return (((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        } catch (Exception e) {
            o9.d().a(e);
            return -1L;
        }
    }

    private String l() {
        try {
            return Locale.getDefault().getLanguage();
        } catch (Exception e) {
            o9.d().a(e);
            return "";
        }
    }

    private String m() {
        return p.m().q();
    }

    private String n() {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.K.getSystemService("phone");
            if (telephonyManager == null) {
                return "";
            }
            String networkOperatorName = telephonyManager.getNetworkOperatorName();
            return !networkOperatorName.equals("") ? networkOperatorName : "";
        } catch (Exception e) {
            o9.d().a(e);
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, this.f3609a + ":getMobileCarrier()", e);
            return "";
        }
    }

    private String o() {
        try {
            return ConfigFile.getConfigFile().getPluginFrameworkVersion();
        } catch (Exception e) {
            o9.d().a(e);
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "getPluginFrameworkVersion()", e);
            return "";
        }
    }

    private String p() {
        try {
            return ConfigFile.getConfigFile().getPluginType();
        } catch (Exception e) {
            o9.d().a(e);
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "getPluginType()", e);
            return "";
        }
    }

    private String q() {
        try {
            return ConfigFile.getConfigFile().getPluginVersion();
        } catch (Exception e) {
            o9.d().a(e);
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "getPluginVersion()", e);
            return "";
        }
    }

    private String r() {
        return IronSourceUtils.getSDKVersion();
    }

    private boolean s() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Exception e) {
            o9.d().a(e);
            return false;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            ce.a().a(a());
        } catch (Exception e) {
            o9.d().a(e);
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "Thread name = " + getClass().getSimpleName(), e);
        }
    }
}
