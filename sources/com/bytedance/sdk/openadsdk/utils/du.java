package com.bytedance.sdk.openadsdk.utils;

import android.os.Build;
import android.text.TextUtils;
import com.json.b9;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public class du {
    private static int JG = Integer.MAX_VALUE;
    private static String ML;
    public static boolean Og;
    public static boolean pA;
    private static final CharSequence KZx = "amigo";
    private static final CharSequence ZZv = "funtouch";
    private static final ConcurrentHashMap<String, String> SD = new ConcurrentHashMap<>();

    public static String pA() {
        if (!TextUtils.isEmpty(ML)) {
            return ML;
        }
        String strPA = com.bytedance.sdk.openadsdk.core.Bzk.pA("sdk_local_rom_info", 604800000L);
        ML = strPA;
        if (TextUtils.isEmpty(strPA)) {
            String strTX = TX();
            ML = strTX;
            com.bytedance.sdk.openadsdk.core.Bzk.pA("sdk_local_rom_info", strTX);
        }
        return ML;
    }

    private static String TX() {
        if (DX()) {
            return oX();
        }
        if (ML()) {
            return WV();
        }
        if (Og()) {
            return aBv();
        }
        if (XT()) {
            return yFO();
        }
        String strWx = Wx();
        if (!TextUtils.isEmpty(strWx)) {
            return strWx;
        }
        if (SD()) {
            return JG();
        }
        if (omh()) {
            return Bzk();
        }
        if (ZZv()) {
            return KZx();
        }
        String strSGo = SGo();
        return !TextUtils.isEmpty(strSGo) ? strSGo : Build.DISPLAY;
    }

    public static boolean Og() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    public static String KZx() {
        return ZZv("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static boolean ZZv() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static boolean ML() {
        if (!Og) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    pA = true;
                    Og = true;
                    return true;
                }
            } catch (Exception unused) {
            }
            Og = true;
        }
        return pA;
    }

    public static String JG() {
        return ZZv("ro.vivo.os.build.display.id") + "_" + ZZv("ro.vivo.product.version");
    }

    public static boolean SD() {
        String strZZv = ZZv("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(strZZv) && strZZv.toLowerCase().contains(ZZv);
    }

    public static boolean omh() {
        return !TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase().contains(KZx);
    }

    public static String Bzk() {
        return Build.DISPLAY + "_" + ZZv("ro.gn.sv.version");
    }

    public static String SGo() {
        if (BSW()) {
            return "eui_" + ZZv("ro.letv.release.version") + "_" + Build.DISPLAY;
        }
        return "";
    }

    public static boolean BSW() {
        return !TextUtils.isEmpty(ZZv("ro.letv.release.version"));
    }

    public static String WV() {
        if (ML()) {
            return "miui_" + ZZv("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
        }
        return "";
    }

    public static String Wx() {
        String strSn = Sn();
        if (strSn != null && strSn.toLowerCase().contains("emotionui")) {
            return strSn + "_" + Build.DISPLAY;
        }
        return "";
    }

    public static String Sn() {
        return ZZv("ro.build.version.emui");
    }

    public static boolean DX() {
        return "smartisan".equalsIgnoreCase(Build.MANUFACTURER) || "smartisan".equalsIgnoreCase(Build.BRAND);
    }

    public static String oX() {
        if (DX()) {
            try {
                return "smartisan_".concat(String.valueOf(ZZv("ro.smartisan.version")));
            } catch (Throwable unused) {
            }
        }
        return Build.DISPLAY;
    }

    public static String aBv() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains("flyme")) ? "" : str;
    }

    public static boolean XT() {
        if (JG == Integer.MAX_VALUE) {
            String str = Build.MANUFACTURER;
            String strSD = gbA.SD("kllk");
            if (!TextUtils.isEmpty(str) && str.toLowerCase().contains(strSD)) {
                JG = 1;
            } else {
                JG = 0;
            }
        }
        return JG == 1;
    }

    public static String yFO() {
        if (XT()) {
            return "coloros_" + ZZv(gbA.SD("ro.build.version.kllkrom")) + "_" + Build.DISPLAY;
        }
        return "";
    }

    public static boolean vZF() {
        try {
            return (!TextUtils.isEmpty(Build.BRAND) && Build.BRAND.toLowerCase().startsWith("huawei")) || (!TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase().startsWith("huawei"));
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean pA(String str) {
        if (TextUtils.isEmpty(str)) {
            str = Sn();
        }
        return (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("emotionui")) || vZF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String KZx(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        String line = "";
        Process process = null;
        try {
            try {
                try {
                    Process processExec = Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str)));
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()), 1024);
                        try {
                            line = bufferedReader.readLine();
                            processExec.exitValue();
                            bufferedReader.close();
                        } catch (IllegalThreadStateException unused) {
                            process = processExec;
                            try {
                                process.destroy();
                            } catch (Throwable unused2) {
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return line;
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                com.bytedance.sdk.component.utils.WV.pA("ToolUtils", "Unable to read sysprop ".concat(String.valueOf(str)), th);
                                return line;
                            } finally {
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e) {
                                        com.bytedance.sdk.component.utils.WV.pA("ToolUtils", "Exception while closing InputStream", e);
                                    }
                                }
                            }
                        }
                    } catch (IllegalThreadStateException unused3) {
                        bufferedReader = null;
                    }
                } catch (Throwable th3) {
                    bufferedReader = null;
                    th = th3;
                }
            } catch (IllegalThreadStateException unused4) {
                bufferedReader = null;
            }
        } catch (IOException e2) {
            com.bytedance.sdk.component.utils.WV.pA("ToolUtils", "Exception while closing InputStream", e2);
        }
        return line;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static String ZZv(String str) {
        String str2;
        new Object[]{"getSystemPropertyTask() called with: propName = [", str, b9.i.e};
        String str3 = SD.get(str);
        if (str3 != null) {
            return str3;
        }
        try {
            if (!TextUtils.isEmpty("")) {
                str2 = "";
            } else {
                final com.bytedance.sdk.component.omh.SD sd = new com.bytedance.sdk.component.omh.SD(new pA(str), 5, 2);
                xy.Og(new com.bytedance.sdk.component.omh.omh("_getSystemPropertyTask") { // from class: com.bytedance.sdk.openadsdk.utils.du.1
                    @Override // java.lang.Runnable
                    public void run() {
                        sd.run();
                    }
                });
                str2 = (String) sd.get(1L, TimeUnit.SECONDS);
            }
        } catch (Throwable unused) {
        }
        return str2 == null ? "" : str2;
    }

    public static class pA implements Callable<String> {
        private final String pA;

        public pA(String str) {
            this.pA = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
        public String call() throws Exception {
            String str = (String) du.SD.get(this.pA);
            if (str != null) {
                return str;
            }
            System.currentTimeMillis();
            String strKZx = du.KZx(this.pA);
            System.currentTimeMillis();
            if (strKZx != null) {
                du.SD.put(this.pA, strKZx);
            }
            return strKZx;
        }
    }
}
