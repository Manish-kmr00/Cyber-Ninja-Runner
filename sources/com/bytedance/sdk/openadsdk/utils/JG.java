package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import com.adjust.sdk.Constants;
import com.json.mediationsdk.metadata.a;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicReference;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class JG {
    private static final AtomicReference<Boolean> pA = new AtomicReference<>(null);
    private static final AtomicReference<String> Og = new AtomicReference<>(null);

    public static void pA(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (Og()) {
                com.bytedance.sdk.openadsdk.core.KZx kZxPA = com.bytedance.sdk.openadsdk.core.KZx.pA(context);
                kZxPA.pA("w_ver", ML(context));
                kZxPA.pA("bp", Og(context));
                kZxPA.pA("is_fold", SD(context) ? 1 : 0);
                kZxPA.pA("abi", pA());
                kZxPA.pA("t_ver", KZx(context));
                kZxPA.pA(CampaignEx.JSON_KEY_AAB, ZZv(context));
            }
        } catch (Throwable unused) {
        }
    }

    public static int Og(Context context) {
        if (omh(context)) {
            return 1;
        }
        if (Bzk(context)) {
            return 2;
        }
        return SGo(context) ? 3 : 4;
    }

    private static boolean omh(Context context) {
        try {
            return Class.forName("com.unity3d.player.UnityPlayerActivity") != null;
        } catch (ClassNotFoundException unused) {
            if (context == null) {
                return false;
            }
            try {
                return new File(context.getApplicationInfo().nativeLibraryDir + "/libunity.so").exists();
            } catch (Throwable unused2) {
                return false;
            }
        }
    }

    private static boolean Bzk(Context context) {
        try {
            return Class.forName("io.flutter.embedding.android.FlutterActivity") != null;
        } catch (ClassNotFoundException unused) {
            if (context == null) {
                return false;
            }
            try {
                return new File(context.getApplicationInfo().nativeLibraryDir + "/libflutter.so").exists();
            } catch (Throwable unused2) {
                return false;
            }
        }
    }

    private static boolean SGo(Context context) {
        try {
            return Class.forName("com.facebook.react.ReactActivity") != null;
        } catch (ClassNotFoundException unused) {
            if (context == null) {
                return false;
            }
            try {
                return new File(context.getApplicationInfo().nativeLibraryDir + "/libreactnativejni.so").exists();
            } catch (Throwable unused2) {
                return false;
            }
        }
    }

    public static String KZx(Context context) {
        try {
            return String.valueOf(context.getApplicationInfo().targetSdkVersion);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static int ZZv(Context context) {
        try {
            return Class.forName("com.google.android.play.core.splitinstall.SplitInstallManager") != null ? 1 : 0;
        } catch (ClassNotFoundException unused) {
            return 0;
        }
    }

    public static String ML(Context context) {
        String str;
        try {
            AtomicReference<String> atomicReference = Og;
            String str2 = atomicReference.get();
            if (str2 != null) {
                return str2;
            }
            PackageInfo packageInfoJG = JG(context);
            if (packageInfoJG == null) {
                str = "";
            } else {
                str = packageInfoJG.versionName;
            }
            MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, null, str);
            return str;
        } catch (Throwable unused) {
            MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(Og, null, "");
            return "";
        }
    }

    public static PackageInfo JG(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                return WebView.getCurrentWebViewPackage();
            }
            PackageInfo packageInfo = (PackageInfo) Class.forName("android.webkit.WebViewFactory").getMethod("getLoadedPackageInfo", new Class[0]).invoke(null, new Object[0]);
            return packageInfo != null ? packageInfo : BSW(context);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    private static PackageInfo BSW(Context context) {
        try {
            String str = (String) Class.forName("android.webkit.WebViewUpdateService").getMethod("getCurrentWebViewPackageName", new Class[0]).invoke(null, new Object[0]);
            if (str == null) {
                return null;
            }
            return context.getPackageManager().getPackageInfo(str, 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0075  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static boolean SD(Context context) {
        boolean zBzk;
        boolean z;
        byte b;
        try {
            AtomicReference<Boolean> atomicReference = pA;
            Boolean bool = atomicReference.get();
            if (bool != null) {
                return bool.booleanValue();
            }
            String lowerCase = Build.BRAND;
            if (!TextUtils.isEmpty(lowerCase)) {
                lowerCase = lowerCase.toLowerCase();
            }
            String lowerCase2 = Build.MANUFACTURER;
            if (!TextUtils.isEmpty(lowerCase2)) {
                lowerCase2 = lowerCase2.toLowerCase();
            }
            if (TextUtils.isEmpty(lowerCase) && TextUtils.isEmpty(lowerCase2)) {
                MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, null, Boolean.FALSE);
                return false;
            }
            byte b2 = -1;
            if (TextUtils.isEmpty(lowerCase)) {
                zBzk = false;
                z = false;
            } else {
                switch (lowerCase.hashCode()) {
                    case -759499589:
                        if (!lowerCase.equals(Constants.REFERRER_API_XIAOMI)) {
                            b = -1;
                        } else {
                            b = 2;
                        }
                        break;
                    case 3418016:
                        if (!lowerCase.equals("oppo")) {
                            b = -1;
                        } else {
                            b = 0;
                        }
                        break;
                    case 3620012:
                        if (!lowerCase.equals(Constants.REFERRER_API_VIVO)) {
                            b = -1;
                        } else {
                            b = 1;
                        }
                        break;
                    case 1864941562:
                        if (!lowerCase.equals(Constants.REFERRER_API_SAMSUNG)) {
                            b = -1;
                        } else {
                            b = 3;
                        }
                        break;
                    default:
                        b = -1;
                        break;
                }
                if (b == 0) {
                    zBzk = Bzk();
                } else if (b == 1) {
                    zBzk = JG();
                } else if (b == 2) {
                    zBzk = ML();
                } else if (b != 3) {
                    zBzk = false;
                    z = true;
                } else {
                    zBzk = ZZv();
                }
                z = false;
            }
            if (z && !TextUtils.isEmpty(lowerCase2)) {
                switch (lowerCase2.hashCode()) {
                    case -759499589:
                        if (lowerCase2.equals(Constants.REFERRER_API_XIAOMI)) {
                            b2 = 2;
                        }
                        break;
                    case 3418016:
                        if (lowerCase2.equals("oppo")) {
                            b2 = 0;
                        }
                        break;
                    case 3620012:
                        if (lowerCase2.equals(Constants.REFERRER_API_VIVO)) {
                            b2 = 1;
                        }
                        break;
                    case 1864941562:
                        if (lowerCase2.equals(Constants.REFERRER_API_SAMSUNG)) {
                            b2 = 3;
                        }
                        break;
                }
                if (b2 == 0) {
                    zBzk = Bzk();
                } else if (b2 == 1) {
                    zBzk = JG();
                } else if (b2 == 2) {
                    zBzk = ML();
                } else {
                    zBzk = b2 != 3 ? false : ZZv();
                }
            }
            MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, null, Boolean.valueOf(zBzk));
            return zBzk;
        } catch (Throwable unused) {
            MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(pA, null, Boolean.FALSE);
            return false;
        }
    }

    private static boolean ZZv() {
        if (BSW()) {
            return true;
        }
        String[] strArr = {"sm-f9000", "sm-f9160", "sm-f9260", "sm-f9360", "sm-f9460", "sm-f9560", "sm-f7000", "sm-f7070", "sm-f7110", "sm-f7210", "sm-f7310", "sm-f7410"};
        String[] strArr2 = {Reporting.EventType.WINNER, "f2q", "q2q", "q4q", "q5q", "q6q", "bloomq", "bloomxq", "b2q", "b4q", "b5q", "b6q"};
        try {
            String lowerCase = Build.DEVICE.toLowerCase();
            if (!TextUtils.isEmpty(lowerCase)) {
                for (int i = 0; i < 12; i++) {
                    if (lowerCase.contains(strArr2[i])) {
                        return true;
                    }
                }
            }
            String lowerCase2 = Build.MODEL.toLowerCase();
            if (TextUtils.isEmpty(lowerCase2)) {
                return false;
            }
            for (int i2 = 0; i2 < 12; i2++) {
                if (lowerCase2.contains(strArr[i2])) {
                    return true;
                }
            }
            if (Og()) {
                String strPA = com.bytedance.sdk.openadsdk.vZF.pA.pA("fold_config", "fold_samung", "");
                if (TextUtils.isEmpty(strPA)) {
                    return false;
                }
                for (String str : strPA.split(StringUtils.COMMA)) {
                    if (lowerCase2.contains(str)) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static boolean ML() {
        if (omh()) {
            return true;
        }
        String[] strArr = {"M2011J18C", "22061218C", "2308CPXD0C", "24072PX77C", "2405CPX3DC", "2405CPX3DG"};
        try {
            String lowerCase = Build.MODEL.toLowerCase();
            if (!TextUtils.isEmpty(lowerCase)) {
                for (int i = 0; i < 6; i++) {
                    if (lowerCase.contains(strArr[i])) {
                        return true;
                    }
                }
                if (Og()) {
                    String strKZx = KZx();
                    if (TextUtils.isEmpty(strKZx)) {
                        return false;
                    }
                    for (String str : strKZx.split(StringUtils.COMMA)) {
                        if (lowerCase.contains(str)) {
                            return true;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static boolean JG() {
        if (SD()) {
            return true;
        }
        String[] strArr = {"V2330", "V2178A", "V2229A", "V2303A", "V2337A", "V2256A", "V2266A"};
        try {
            String lowerCase = Build.MODEL.toLowerCase();
            if (!TextUtils.isEmpty(lowerCase)) {
                for (int i = 0; i < 7; i++) {
                    if (lowerCase.contains(strArr[i].toLowerCase())) {
                        return true;
                    }
                }
                if (Og()) {
                    String strKZx = KZx();
                    if (TextUtils.isEmpty(strKZx)) {
                        return false;
                    }
                    for (String str : strKZx.split(StringUtils.COMMA)) {
                        if (lowerCase.contains(str.toLowerCase())) {
                            return true;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static boolean SD() {
        try {
            return "foldable".equals(Class.forName("android.util.FtDeviceInfo").getMethod("getDeviceType", new Class[0]).invoke(null, new Object[0]));
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("BED", "isVIVOFoldDevice return false " + th.getMessage());
            return false;
        }
    }

    private static boolean omh() {
        try {
            return ((Integer) Class.forName("android.os.SystemProperties").getMethod("getInt", String.class, Integer.TYPE).invoke(null, "persist.sys.muiltdisplay_type", 0)).intValue() == 2;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("BED", "isXiaomiFold return false " + th.getMessage());
            return false;
        }
    }

    private static boolean Bzk() {
        if (SGo()) {
            return true;
        }
        String[] strArr = {"CPH2439", "CPH2437", "CPH2499", "CPH2519", "PEUM00", "PGU110", "PGT110", "PHN110", "PHT110"};
        try {
            String lowerCase = Build.MODEL.toLowerCase();
            if (!TextUtils.isEmpty(lowerCase)) {
                for (int i = 0; i < 9; i++) {
                    if (lowerCase.contains(strArr[i].toLowerCase())) {
                        return true;
                    }
                }
                if (Og()) {
                    String strKZx = KZx();
                    if (TextUtils.isEmpty(strKZx)) {
                        return false;
                    }
                    for (String str : strKZx.split(StringUtils.COMMA)) {
                        if (lowerCase.contains(str.toLowerCase())) {
                            return true;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static boolean SGo() {
        try {
            Class<?> cls = Class.forName("com.oplus.content.OplusFeatureConfigManager");
            Object objInvoke = cls.getDeclaredMethod("hasFeature", String.class).invoke(cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), "oplus.hardware.type.fold");
            if (objInvoke instanceof Boolean) {
                return ((Boolean) objInvoke).booleanValue();
            }
            return false;
        } catch (ClassNotFoundException e) {
            e = e;
            com.bytedance.sdk.component.utils.WV.pA("BED", "get oppo fold properties error, msg: " + e.getMessage());
            return false;
        } catch (IllegalAccessException e2) {
            e = e2;
            com.bytedance.sdk.component.utils.WV.pA("BED", "get oppo fold properties error, msg: " + e.getMessage());
            return false;
        } catch (NoSuchMethodException e3) {
            e = e3;
            com.bytedance.sdk.component.utils.WV.pA("BED", "get oppo fold properties error, msg: " + e.getMessage());
            return false;
        } catch (InvocationTargetException e4) {
            e = e4;
            com.bytedance.sdk.component.utils.WV.pA("BED", "get oppo fold properties error, msg: " + e.getMessage());
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String pA() {
        try {
            return Build.SUPPORTED_ABIS[0];
        } catch (Exception unused) {
            return "";
        }
    }

    public static void pA(JSONObject jSONObject, Context context) {
        if (context == null) {
            return;
        }
        try {
            if (Og()) {
                com.bytedance.sdk.openadsdk.core.KZx kZxPA = com.bytedance.sdk.openadsdk.core.KZx.pA(context);
                String strOg = kZxPA.Og("md", com.bytedance.sdk.openadsdk.core.Bzk.Og().ML());
                if (!TextUtils.isEmpty(strOg)) {
                    jSONObject.put("md", strOg);
                }
                int iOg = kZxPA.Og("bp", Og(context));
                if (iOg != 4) {
                    jSONObject.put("bp", iOg);
                }
                String strOg2 = kZxPA.Og("t_ver", KZx(context));
                if (!TextUtils.isEmpty(strOg2)) {
                    jSONObject.put("t_ver", strOg2);
                }
                jSONObject.put("is_fold", kZxPA.Og("is_fold", SD(context) ? 1 : 0));
                jSONObject.put(CampaignEx.JSON_KEY_AAB, kZxPA.Og(CampaignEx.JSON_KEY_AAB, ZZv(context)));
                String strOg3 = kZxPA.Og("w_ver", ML(context));
                if (!TextUtils.isEmpty(strOg3)) {
                    jSONObject.put("w_ver", strOg3);
                }
                String strOg4 = kZxPA.Og("abi", pA());
                if (TextUtils.isEmpty(strOg4)) {
                    return;
                }
                jSONObject.put("abi", strOg4);
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean BSW() {
        try {
            Class<?> cls = Class.forName("com.samsung.android.feature.SemFloatingFeature");
            Object objInvoke = cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            Method declaredMethod = cls.getDeclaredMethod("getString", String.class);
            return "TRUE".equalsIgnoreCase((String) declaredMethod.invoke(objInvoke, "SEC_FLOATING_FEATURE_FRAMEWORK_SUPPORT_FOLDABLE_TYPE_FOLD")) || "TRUE".equalsIgnoreCase((String) declaredMethod.invoke(objInvoke, "SEC_FLOATING_FEATURE_FRAMEWORK_SUPPORT_FOLDABLE_TYPE_FLIP"));
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            com.bytedance.sdk.component.utils.WV.pA("PAG_BANNER", "get ss fold device error: " + e.getMessage());
            return false;
        }
    }

    public static boolean Og() {
        return com.bytedance.sdk.openadsdk.vZF.pA.pA("fold_config", a.j, 0) == 1;
    }

    public static String KZx() {
        return com.bytedance.sdk.openadsdk.vZF.pA.pA("fold_config", "fold_default", "");
    }
}
