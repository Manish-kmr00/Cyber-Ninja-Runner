package sg.bigo.ads.common.b;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f13131a = "";
    private static boolean b = true;

    public static String a(Context context) {
        if (!TextUtils.isEmpty(f13131a) || !b) {
            return f13131a;
        }
        try {
            Class<?> cls = Class.forName("com.appsflyer.AppsFlyerLib");
            Object objInvoke = cls.getMethod("getAppsFlyerUID", Context.class).invoke(cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), context);
            if (objInvoke instanceof String) {
                f13131a = (String) objInvoke;
            }
        } catch (Exception unused) {
            b = false;
        }
        return f13131a;
    }
}
