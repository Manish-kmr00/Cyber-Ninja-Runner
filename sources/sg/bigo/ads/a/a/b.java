package sg.bigo.ads.a.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f12467a;
    private static a b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f12468a;
        public final String b;
        public final String c;
        public final String d;
        public final String e;

        public a(boolean z, String str, String str2, String str3, String str4) {
            this.f12468a = z;
            this.e = str;
            this.d = str2;
            this.c = str3;
            this.b = str4;
        }
    }

    public static a a(Context context) {
        String string;
        String str;
        String str2;
        String str3;
        String strValueOf;
        int iIndexOf;
        a aVar = b;
        if (aVar != null) {
            return aVar;
        }
        boolean z = false;
        ResolveInfo resolveInfoResolveActivity = context.getPackageManager().resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com")), 0);
        String strConcat = null;
        String str4 = resolveInfoResolveActivity != null ? resolveInfoResolveActivity.activityInfo.packageName : null;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.android.chrome", 0);
            if (packageInfo == null || !"com.android.chrome".equals(packageInfo.packageName)) {
                string = "No chrome pkg";
                str = string;
                str2 = strConcat;
            } else {
                f12467a = "com.android.chrome";
                String str5 = packageInfo.versionName;
                try {
                    String strSubstring = (TextUtils.isEmpty(str5) || (iIndexOf = str5.indexOf(".")) < 0) ? null : str5.substring(0, iIndexOf);
                    if (TextUtils.isEmpty(strSubstring)) {
                        str3 = "Invalid chrome version: ";
                        strValueOf = String.valueOf(str5);
                    } else {
                        if (Integer.parseInt(strSubstring) >= 45) {
                            z = true;
                        } else {
                            str3 = "Chrome version is low: ";
                            strValueOf = String.valueOf(str5);
                        }
                        str2 = str5;
                        str = strConcat;
                    }
                    strConcat = str3.concat(strValueOf);
                    str2 = str5;
                    str = strConcat;
                } catch (PackageManager.NameNotFoundException e) {
                    e = e;
                    strConcat = str5;
                    string = e.toString();
                    str = string;
                    str2 = strConcat;
                } catch (Exception e2) {
                    e = e2;
                    strConcat = str5;
                    string = e.toString();
                    str = string;
                    str2 = strConcat;
                }
            }
        } catch (PackageManager.NameNotFoundException e3) {
            e = e3;
        } catch (Exception e4) {
            e = e4;
        }
        a aVar2 = new a(z, f12467a, str2, str4, str);
        b = aVar2;
        return aVar2;
    }
}
