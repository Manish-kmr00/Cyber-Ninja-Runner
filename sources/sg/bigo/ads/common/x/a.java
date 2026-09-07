package sg.bigo.ads.common.x;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.Log;
import com.smaato.sdk.core.gdpr.CmpApiConstants;
import java.util.UUID;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f13360a = "";

    public static boolean A() {
        return ((Boolean) b.b("sp_ads_encryptreport_request", Boolean.TRUE, 4)).booleanValue();
    }

    public static void B() {
        b.a("sp_ads_encryptreport_request", Boolean.FALSE, 4);
    }

    public static boolean C() {
        return ((Boolean) b.b("sp_ads_encryptcallback_request", Boolean.TRUE, 4)).booleanValue();
    }

    public static void D() {
        b.a("sp_ads_encryptcallback_request", Boolean.FALSE, 4);
    }

    private static synchronized void E() {
        if (TextUtils.isEmpty(f13360a)) {
            f13360a = String.valueOf(UUID.randomUUID());
        }
    }

    public static int a() {
        return ((Integer) b.b("sp_cpu_core_num", 0, 0)).intValue();
    }

    public static void a(int i) {
        b.a("sp_cpu_core_num", Integer.valueOf(i), 0);
    }

    public static void a(long j) {
        b.a("sp_cpu_max_freq", Long.valueOf(j), 1);
    }

    public static void a(String str) {
        b.a("sp_user_agent", str, 3);
    }

    public static void a(String str, int i) {
        b.a("impression_num_".concat(String.valueOf(str)), Integer.valueOf(i), 0);
    }

    public static void a(String str, long j) {
        b.a("last_impression_ts_".concat(String.valueOf(str)), Long.valueOf(j), 1);
    }

    public static void a(String str, SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        SharedPreferences sharedPreferencesA = b.a(str + "_preferences");
        if (sharedPreferencesA != null) {
            sharedPreferencesA.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        }
    }

    public static boolean a(String str, String str2) {
        SharedPreferences sharedPreferencesA = b.a(str);
        if (sharedPreferencesA != null) {
            return sharedPreferencesA.contains(str2);
        }
        return false;
    }

    public static long b() {
        return ((Long) b.b("sp_cpu_max_freq", 0L, 1)).longValue();
    }

    public static void b(int i) {
        b.a("consent_gdpr", Integer.valueOf(i), 0);
    }

    public static void b(long j) {
        b.a("sp_user_agent_last_check_ts", Long.valueOf(j), 1);
    }

    public static void b(String str) {
        b.a("sp_omid_service_downloaded_url", str, 3);
    }

    public static String c() {
        return (String) b.b("sp_user_agent", "", 3);
    }

    public static void c(int i) {
        b.a("consent_ccpa", Integer.valueOf(i), 0);
    }

    public static void c(long j) {
        b.a("last_stat_init_time", Long.valueOf(j), 1);
    }

    public static void c(String str) {
        b.a("sp_banner_js_downloaded_url", str, 3);
    }

    public static long d() {
        return ((Long) b.b("sp_user_agent_last_check_ts", 0L, 1)).longValue();
    }

    public static void d(int i) {
        b.a("consent_lgpd", Integer.valueOf(i), 0);
    }

    public static void d(long j) {
        b.a("last_stat_cb_events_time", Long.valueOf(j), 1);
    }

    public static void d(String str) {
        b.a("cb_event_count", str, 3);
    }

    public static long e() {
        return ((Long) b.b("sp_fix_ts_diff", 0L, 1)).longValue();
    }

    public static String e(String str) {
        try {
            return (String) b.b(str + "_preferences", CmpApiConstants.IABTCF_PURPOSE_CONSENTS, "", 3);
        } catch (Exception unused) {
            return "";
        }
    }

    public static void e(int i) {
        b.a("consent_coppa", Integer.valueOf(i), 0);
    }

    public static String f(String str) {
        try {
            return (String) b.b(str + "_preferences", "IABTCF_TCString", "", 3);
        } catch (Exception unused) {
            return "";
        }
    }

    public static void f() {
        b.a("sp_fix_ts_diff", 0L, 1);
    }

    public static int g(String str) {
        try {
            return ((Integer) b.b(str + "_preferences", "IABTCF_gdprApplies", 0, 0)).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String g() {
        return (String) b.b("sp_omid_service_downloaded_url", "", 3);
    }

    public static String h() {
        return (String) b.b("sp_banner_js_downloaded_url", "", 3);
    }

    public static String h(String str) {
        try {
            return (String) b.b(str + "_preferences", CmpApiConstants.IABTCF_PURPOSE_LEGITIMATE_INTERESTS, "", 3);
        } catch (Exception unused) {
            return "";
        }
    }

    public static int i(String str) {
        return ((Integer) b.b("impression_num_".concat(String.valueOf(str)), 0, 0)).intValue();
    }

    public static long i() {
        return ((Long) b.b("last_stat_init_time", 0, 1)).longValue();
    }

    public static long j() {
        return ((Long) b.b("last_stat_cb_events_time", 0, 1)).longValue();
    }

    public static void j(String str) {
        long jLongValue = ((Long) b.b("last_impression_ts_".concat(String.valueOf(str)), 0, 1)).longValue();
        if (jLongValue <= 0 || DateUtils.isToday(jLongValue)) {
            return;
        }
        a(str, 0);
        a(str, 0L);
    }

    public static String k() {
        return (String) b.b("cb_event_count", "", 3);
    }

    public static int l() {
        return ((Integer) b.b("consent_gdpr", 0, 0)).intValue();
    }

    public static int m() {
        return ((Integer) b.b("consent_ccpa", 0, 0)).intValue();
    }

    public static int n() {
        return ((Integer) b.b("consent_lgpd", 0, 0)).intValue();
    }

    public static int o() {
        return ((Integer) b.b("consent_coppa", 0, 0)).intValue();
    }

    public static boolean p() {
        return l() == 2 || m() == 2 || n() == 2 || o() == 2;
    }

    public static String q() {
        if (!TextUtils.isEmpty(f13360a)) {
            return f13360a;
        }
        String str = (String) b.b("sp_ads_tiny", "sp_ads_uuid", "", 3);
        f13360a = str;
        if (TextUtils.isEmpty(str)) {
            try {
                E();
                if (!TextUtils.isEmpty(f13360a)) {
                    b.a("sp_ads_tiny", "sp_ads_uuid", f13360a, 3);
                }
            } catch (Throwable unused) {
            }
        }
        return f13360a;
    }

    public static void r() {
        try {
            SharedPreferences.Editor editorB = b.b("sp_ads");
            editorB.clear();
            c.a.a();
            c.a.C0882a.a(editorB);
        } catch (Exception e) {
            sg.bigo.ads.common.t.a.a(0, "SharedPreferenceManager", Log.getStackTraceString(e));
        }
    }

    public static boolean s() {
        return ((Boolean) b.b("sp_ads_encryptpost_request", Boolean.TRUE, 4)).booleanValue();
    }

    public static void t() {
        b.a("sp_ads_encryptpost_request", Boolean.FALSE, 4);
    }

    public static boolean u() {
        return ((Boolean) b.b("sp_ads_encryptsdkconfig_request", Boolean.TRUE, 4)).booleanValue();
    }

    public static void v() {
        b.a("sp_ads_encryptsdkconfig_request", Boolean.FALSE, 4);
    }

    public static boolean w() {
        return ((Boolean) b.b("sp_ads_encryptaddata_request", Boolean.TRUE, 4)).booleanValue();
    }

    public static void x() {
        b.a("sp_ads_encryptaddata_request", Boolean.FALSE, 4);
    }

    public static boolean y() {
        return ((Boolean) b.b("sp_ads_encrypticon_ads_data_request", Boolean.TRUE, 4)).booleanValue();
    }

    public static void z() {
        b.a("sp_ads_encrypticon_ads_data_request", Boolean.FALSE, 4);
    }
}
