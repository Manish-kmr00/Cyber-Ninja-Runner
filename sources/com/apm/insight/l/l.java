package com.apm.insight.l;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStreamReader;
import java.util.Locale;

/* JADX INFO: compiled from: RomUtils.java */
/* JADX INFO: loaded from: classes12.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final CharSequence f257a = "amigo";
    private static final CharSequence b = "funtouch";

    public static String a() {
        if (d.b()) {
            return d.b() ? "miui_" + a("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL : "";
        }
        if (!d.c()) {
            if (b()) {
                return b() ? "coloros_" + a("ro.build.version.opporom") + "_" + Build.DISPLAY : "";
            }
            String strA = d.a();
            String str = (strA == null || !strA.toLowerCase(Locale.getDefault()).contains("emotionui")) ? "" : strA + "_" + Build.DISPLAY;
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            String strA2 = a("ro.vivo.os.build.display.id");
            if (!TextUtils.isEmpty(strA2) && strA2.toLowerCase(Locale.getDefault()).contains(b)) {
                return a("ro.vivo.os.build.display.id") + "_" + a("ro.vivo.product.version");
            }
            if (!TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase(Locale.getDefault()).contains(f257a)) {
                return Build.DISPLAY + "_" + a("ro.gn.sv.version");
            }
            String str2 = Build.MANUFACTURER + Build.BRAND;
            if (!TextUtils.isEmpty(str2)) {
                String lowerCase = str2.toLowerCase(Locale.getDefault());
                if (lowerCase.contains("360") || lowerCase.contains("qiku")) {
                    return a("ro.build.uiversion") + "_" + Build.DISPLAY;
                }
            }
            String str3 = TextUtils.isEmpty(a("ro.letv.release.version")) ? "" : "eui_" + a("ro.letv.release.version") + "_" + Build.DISPLAY;
            return !TextUtils.isEmpty(str3) ? str3 : Build.DISPLAY;
        }
        String str4 = Build.DISPLAY;
        return (str4 == null || !str4.toLowerCase(Locale.getDefault()).contains("flyme")) ? "" : str4;
    }

    private static boolean b() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase(Locale.getDefault()).contains("oppo");
    }

    private static String a(String str) {
        BufferedReader bufferedReader;
        String line = "";
        try {
            Process processExec = Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str)));
            bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()), 1024);
            try {
                line = bufferedReader.readLine();
                processExec.destroy();
                com.apm.insight.a.a((Closeable) bufferedReader);
                return line;
            } catch (Throwable unused) {
                com.apm.insight.a.a((Closeable) bufferedReader);
                return line;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }
}
