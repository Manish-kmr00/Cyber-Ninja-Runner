package sg.bigo.ads.common.m;

import android.content.Context;
import android.content.SharedPreferences;
import com.smaato.sdk.core.gdpr.CmpApiConstants;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f13216a = "";
    private static int b = 0;
    private static String c = "";
    private static String d = "";
    private static boolean e = true;
    private static SharedPreferences.OnSharedPreferenceChangeListener f = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: sg.bigo.ads.common.m.b.1
        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            if (q.a((CharSequence) str)) {
                return;
            }
            byte b2 = 0;
            sg.bigo.ads.common.t.a.a(0, 3, "GdprManager", "Listener SharedPreferenceChanged, key: ".concat(String.valueOf(str)));
            str.hashCode();
            switch (str.hashCode()) {
                case -2004976699:
                    if (!str.equals(CmpApiConstants.IABTCF_PURPOSE_CONSENTS)) {
                        b2 = -1;
                    }
                    break;
                case -464306296:
                    b2 = !str.equals(CmpApiConstants.IABTCF_PURPOSE_LEGITIMATE_INTERESTS) ? (byte) -1 : (byte) 1;
                    break;
                case 83641339:
                    b2 = !str.equals("IABTCF_gdprApplies") ? (byte) -1 : (byte) 2;
                    break;
                case 1218895378:
                    b2 = !str.equals("IABTCF_TCString") ? (byte) -1 : (byte) 3;
                    break;
                default:
                    b2 = -1;
                    break;
            }
            switch (b2) {
                case 0:
                    b.a(sharedPreferences);
                    break;
                case 1:
                    b.c(sharedPreferences);
                    break;
                case 2:
                    b.b(sharedPreferences);
                    break;
                case 3:
                    b.d(sharedPreferences);
                    b.i();
                    return;
                default:
                    return;
            }
            b.i();
        }
    };
    private static Context g;

    public static void a(Context context) {
        g = context;
        sg.bigo.ads.common.x.a.a(context.getPackageName(), f);
    }

    public static void a(SharedPreferences sharedPreferences) {
        if (sharedPreferences == null) {
            return;
        }
        try {
            f13216a = sharedPreferences.getString(CmpApiConstants.IABTCF_PURPOSE_CONSENTS, "");
        } catch (Exception unused) {
            f13216a = "";
        }
    }

    public static boolean a() {
        return g != null;
    }

    public static String b() {
        if (q.a((CharSequence) f13216a) && a()) {
            f13216a = sg.bigo.ads.common.x.a.e(g.getPackageName());
        }
        return f13216a;
    }

    public static void b(SharedPreferences sharedPreferences) {
        if (sharedPreferences == null || sharedPreferences.getAll() == null) {
            return;
        }
        Object obj = sharedPreferences.getAll().get("IABTCF_gdprApplies");
        if (obj instanceof Integer) {
            b = ((Integer) obj).intValue();
        } else if (obj instanceof String) {
            try {
                b = Integer.parseInt((String) obj);
            } catch (Exception unused) {
                b = 0;
            }
        }
    }

    public static int c() {
        if (b == 0 && a()) {
            b = sg.bigo.ads.common.x.a.g(g.getPackageName());
        }
        return b;
    }

    public static void c(SharedPreferences sharedPreferences) {
        if (sharedPreferences == null) {
            return;
        }
        try {
            c = sharedPreferences.getString(CmpApiConstants.IABTCF_PURPOSE_LEGITIMATE_INTERESTS, "");
        } catch (Exception unused) {
            c = "";
        }
    }

    public static String d() {
        if (q.a((CharSequence) c) && a()) {
            c = sg.bigo.ads.common.x.a.h(g.getPackageName());
        }
        return c;
    }

    public static void d(SharedPreferences sharedPreferences) {
        if (sharedPreferences == null) {
            return;
        }
        try {
            d = sharedPreferences.getString("IABTCF_TCString", "");
        } catch (Exception unused) {
            d = "";
        }
    }

    public static String e() {
        if (q.a((CharSequence) d) && a()) {
            d = sg.bigo.ads.common.x.a.f(g.getPackageName());
        }
        return d;
    }

    public static boolean f() {
        return e;
    }

    public static void g() {
        e = false;
    }

    public static boolean h() {
        return sg.bigo.ads.common.x.a.a(g.getPackageName() + "_preferences", "IABTCF_gdprApplies");
    }

    static /* synthetic */ boolean i() {
        e = true;
        return true;
    }
}
