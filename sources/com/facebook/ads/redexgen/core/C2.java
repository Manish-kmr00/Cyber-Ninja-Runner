package com.facebook.ads.redexgen.core;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.internal.util.activity.AdActivityIntent;
import com.facebook.ads.internal.util.process.ProcessUtils;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.unity3d.mediation.LevelPlayAdError;
import io.bidmachine.protobuf.EventTypeExtended;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2 {
    public static byte[] A00;
    public static String[] A01 = {"T4dPy6oALRnRtXie0LYtNa7PXoaz5xNV", "GuB", "", "N5ZcwGbFLOfjQt8i7LOYdNhhAY9bfZ8J", "XGEF2r9HzP4eyBZiq0puzcaX55o", "r68Pu4BAqG0jUrZ19Ek7iVXcY822rh1q", "w97ZnD7u", "Y1Vl"};

    public static String A06(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 79);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A08() {
        A00 = new byte[]{77, 66, 83, 74, 78, 56, 77, 83, 95, 73, 79, 89, 94, 73, 83, 88, 67, 71, 73, 66, 84, 91, 74, 82, 69, 70, 74, 84, 81, 74, 86, 90, 91, 65, 80, 91, 65, 85, 87, 90, 90, 83, 68, 73, 82, 89, 91, 87, 95, 88, 88, 122, 117, 60, 111, 59, 104, 111, 122, 105, 111, 59, 90, 110, 127, 114, 126, 117, 120, 126, 85, 126, 111, 108, 116, 105, 112, 90, 120, 111, 114, 109, 114, 111, 98, 53, 59, 86, 122, 112, 126, 59, 104, 110, 105, 126, 59, 111, 115, 122, 111, 59, 114, 111, 60, 104, 59, 114, 117, 59, 98, 116, 110, 105, 59, 90, 117, 127, 105, 116, 114, 127, 86, 122, 117, 114, 125, 126, 104, 111, 53, 99, 118, 119, 59, 125, 114, 119, 126, 53, Ascii.FS, 1, Ascii.CR, Ascii.VT, Ascii.CAN, 6, Ascii.FF, Ascii.VT, Ascii.NAK, Ascii.NAK, 17, Ascii.DC2, 38, 55, 58, 54, Base64.padSymbol, 48, 54, Ascii.GS, 54, 39, 36, 60, 33, 56, Ascii.SUB, 104, SignedBytes.MAX_POWER_OF_TWO, 79, 126, SignedBytes.MAX_POWER_OF_TWO, 66, 85, 72, 87, 72, 85, 88, 41, 38, 44, 58, 39, 33, 44, 36, 43, 33, 55, 42, 44, 33, 107, 44, 43, 49, 32, 43, 49, 107, 36, 38, 49, 44, 42, 43, 107, 19, Ascii.FF, 0, Ascii.DC2, 58, 53, 63, 41, 52, 50, 63, 117, 50, 53, 47, 62, 53, 47, 117, 56, 58, 47, 62, 60, 52, 41, 34, 117, Ascii.EM, 9, Ascii.DC4, Ascii.FF, 8, Ascii.SUB, Ascii.EM, Ascii.ETB, Ascii.RS, 112, 125, 125, 126, 70, 86, 75, 83, 87, 65, 86, 113, 118, 104, 50, 48, Base64.padSymbol, Base64.padSymbol, 52, 35, Ascii.CAN, 53, Ascii.DC4, Ascii.SYN, Ascii.ESC, Ascii.ESC, Ascii.DC2, 5, 35, Ascii.SO, 7, Ascii.DC2, 54, 57, 60, 48, 59, 33, 1, 58, 62, 48, 59, 113, 125, 127, 60, 115, 124, 118, 96, 125, 123, 118, 60, 112, 96, 125, 101, 97, 119, 96, 60, 115, 98, 98, 126, 123, 113, 115, 102, 123, 125, 124, 77, 123, 118, Ascii.SI, 3, 1, 66, Ascii.CR, 2, 8, Ascii.RS, 3, 5, 8, 66, Ascii.SUB, 9, 2, 8, 5, 2, Ascii.VT, 103, 107, 105, 42, 98, 101, 103, 97, 102, 107, 107, 111, 42, 99, 107, 107, 99, 104, 97, 116, 104, 101, 125, 119, 112, 107, 118, 97, 101, 106, 42, 67, 107, 107, 99, 104, 97, 84, 104, 101, 125, 87, 112, 107, 118, 97, 69, 74, 75, 114, 97, 118, 104, 101, 125, 65, 124, 112, 97, 118, 106, 101, 104, 69, 103, 112, 109, 114, 109, 112, 125, 109, 97, 99, 32, 104, 111, 109, 107, 108, 97, 97, 101, 32, 101, 111, 122, 111, 96, 111, 66, 78, 79, 71, 72, 70, 126, 82, 84, 81, 81, 78, 83, 85, 82, 108, 84, 77, 85, 72, 118, 72, 79, 69, 78, 86, 3, Ascii.SI, Ascii.SO, 6, 9, 7, 63, 19, Ascii.NAK, Ascii.DLE, Ascii.DLE, Ascii.SI, Ascii.DC2, Ascii.DC4, 19, 51, Ascii.DLE, Ascii.FF, 9, Ascii.DC4, 51, 3, Ascii.DC2, 5, 5, Ascii.SO, 45, Ascii.NAK, Ascii.FF, Ascii.DC4, 9, 55, 9, Ascii.SO, 4, Ascii.SI, Ascii.ETB, 5, Ascii.DC4, 3, 7, Ascii.DC2, 3, 57, 8, 3, 17, 57, Ascii.DC2, 7, 4, 75, 79, 4, Ascii.VT, Ascii.SO, Ascii.SYN, 7, Ascii.DLE, 7, 6, Base64.padSymbol, 1, Ascii.SO, Ascii.VT, 1, 9, Base64.padSymbol, 6, 7, Ascii.SO, 3, Ascii.ESC, Base64.padSymbol, Ascii.SI, 17, 39, 46, 33, 43, 35, 42, Base64.padSymbol, Ascii.ESC, 38, 34, 42, Ascii.ETB, Ascii.VT, Ascii.VT, Ascii.SI, 36, 56, 56, 60, 118, 99, 99, 60, 32, 45, 53, 98, 43, 35, 35, 43, 32, 41, 98, 47, 35, 33, 99, 63, 56, 35, 62, 41, 99, 45, 60, 60, 63, 99, 38, 58, 58, 62, Base64.padSymbol, 83, 94, Ascii.CAN, Ascii.US, 2, 5, Ascii.DLE, Ascii.US, 5, 46, Ascii.SYN, Ascii.DLE, Ascii.FS, Ascii.DC4, 2, SignedBytes.MAX_POWER_OF_TWO, 90, 118, 74, 72, 74, 118, 79, SignedBytes.MAX_POWER_OF_TWO, 69, 93, 76, 91, 118, 74, 69, SignedBytes.MAX_POWER_OF_TWO, 74, 66, 90, 118, 70, 71, 118, 74, 93, 72, Base64.padSymbol, 39, Ascii.VT, 55, 38, 49, 53, 32, Base64.padSymbol, 34, 49, Ascii.VT, 53, 39, Ascii.VT, 55, 32, 53, Ascii.VT, 34, 102, 9, 5, Ascii.SYN, Ascii.SI, 1, Ascii.DLE, 104, 113, 98, 117, 107, 102, 126, 74, 86, 91, 67, Ascii.DC4, 93, 85, 85, 93, 86, 95, Ascii.DC4, 89, 85, 87, 59, 44, 58, 32, 51, 44, 4, 38, 45, 44, 50, 41, 46, 54, 50, 34, Ascii.SO, 35, 32, 63, 51, 33, 2, 47, 38, 51};
    }

    static {
        A08();
    }

    private int A00(C2699k1 c2699k1) {
        PackageInfo packageInfo;
        try {
            PackageManager packageManager = c2699k1.getPackageManager();
            if (packageManager != null && (packageInfo = packageManager.getPackageInfo(A06(412, 19, 65), 0)) != null && !TextUtils.isEmpty(packageInfo.versionName)) {
                return Integer.parseInt(packageInfo.versionName.split(A06(166, 2, 9), 2)[0]);
            }
            return -1;
        } catch (PackageManager.NameNotFoundException | NumberFormatException unused) {
            return -1;
        }
    }

    public static Intent A01(Uri uri) {
        Intent intent = new Intent(A06(186, 26, 10), uri);
        intent.setComponent(null);
        intent.setSelector(null);
        return intent;
    }

    public static Intent A02(C2699k1 c2699k1, Uri uri) {
        Intent intentA01 = A01(uri);
        intentA01.addCategory(A06(212, 33, 20));
        intentA01.addFlags(268435456);
        intentA01.putExtra(A06(288, 34, 93), c2699k1.getPackageName());
        intentA01.putExtra(A06(494, 14, 41), false);
        if (C14499m.A1w(c2699k1)) {
            if (A06(508, 2, 98).equals(uri.getScheme())) {
                intentA01.setPackage(A06(412, 19, 65));
            }
        }
        return intentA01;
    }

    public static Intent A03(C2699k1 c2699k1, Uri uri) {
        Intent intentA01 = A01(uri);
        intentA01.setPackage(A06(322, 19, 35));
        intentA01.putExtra(A06(259, 8, 30), c2699k1.getPackageName());
        intentA01.putExtra(A06(656, 7, 72), true);
        return intentA01;
    }

    private final EnumC12541u A04(C2699k1 c2699k1, Uri uri, String str, Map<String, String> map) throws C1489Bo {
        boolean zA05 = AbstractC14509n.A05(c2699k1);
        boolean isInAppBrowserEnabled = A0E(uri);
        if (isInAppBrowserEnabled && zA05) {
            A0B(c2699k1, uri, str, map);
            EnumC12541u enumC12541u = EnumC12541u.A08;
            if (A01[7].length() == 30) {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[2] = "";
            strArr[1] = "Q7p";
            return enumC12541u;
        }
        c2699k1.A0F().A9n(zA05);
        A09(c2699k1, uri);
        return EnumC12541u.A07;
    }

    public static EnumC12541u A05(C2 c2, C2699k1 c2699k1, Uri uri, String str, Map<String, String> extraData) throws C1489Bo {
        boolean z = A0E(uri) && A06(EventTypeExtended.EVENT_TYPE_EXTENDED_SK_OVERLAY_DISMISSING_VALUE, 15, 117).equals(uri.getHost());
        boolean isGooglePlayWebLink = A06(650, 6, 43).equals(uri.getScheme());
        if (!isGooglePlayWebLink && !z) {
            return c2.A04(c2699k1, uri, str, extraData);
        }
        try {
            c2.A0A(c2699k1, uri, str);
            return EnumC12541u.A03;
        } catch (C0 unused) {
            return c2.A04(c2699k1, uri, str, extraData);
        }
    }

    private String A07(String str) {
        return android.util.Base64.encodeToString(str.getBytes(), 0);
    }

    private void A09(C2699k1 c2699k1, Uri uri) throws C1489Bo {
        C1491Bq.A0D(c2699k1, A02(c2699k1, uri));
    }

    private final void A0A(C2699k1 c2699k1, Uri uri, String str) throws C1489Bo, C0 {
        if (A0G(c2699k1)) {
            if (C14499m.A1F(c2699k1)) {
                String queryParameter = uri.getQueryParameter(A06(587, 2, 117));
                if (!TextUtils.isEmpty(queryParameter)) {
                    if (A01[3].charAt(29) != 'Z') {
                        throw new RuntimeException();
                    }
                    String[] strArr = A01;
                    strArr[4] = "AXwrjbGi2NqoDqohSkmHlyhQGK6";
                    strArr[6] = "xSKC0PNk";
                    String strA06 = A06(589, 13, 62);
                    String packageName = uri.toString();
                    AbstractC12863a.A03(queryParameter, strA06, packageName);
                }
            }
            boolean z = (c2699k1.A0H().A01() && C14499m.A1Z(c2699k1)) || (C14499m.A1x(c2699k1) && A0H(c2699k1));
            if (!z) {
                boolean shouldTryToOpenSplitScreen = C14499m.A2J(c2699k1);
                if (shouldTryToOpenSplitScreen) {
                    boolean shouldTryToOpenSplitScreen2 = C1491Bq.A0E(c2699k1, A03(c2699k1, uri));
                    if (shouldTryToOpenSplitScreen2) {
                        return;
                    }
                }
            }
            boolean zA0K = A0K(c2699k1, uri, str);
            if (A01[3].charAt(29) != 'Z') {
                A01[7] = "w5Gj6271lmeoEbiTTMEsWTdaWp";
                if (zA0K) {
                    return;
                }
            } else {
                A01[3] = "TMuIQjN9vpUXBqY7VYY4Z8DVMg5lcZnK";
                if (zA0K) {
                    return;
                }
            }
            Intent intentA02 = A02(c2699k1, uri);
            intentA02.setPackage(A06(322, 19, 35));
            if (Build.VERSION.SDK_INT >= 24 && z) {
                intentA02.addFlags(268472320);
            }
            C1491Bq.A0D(c2699k1, intentA02);
            return;
        }
        throw new C0();
    }

    private void A0B(C2699k1 c2699k1, Uri uri, String str, Map<String, String> map) {
        AdActivityIntent adActivityIntentA05 = C1491Bq.A05(c2699k1);
        if (!ProcessUtils.isRemoteRenderingProcess()) {
            adActivityIntentA05.addFlags(268435456);
        }
        adActivityIntentA05.putExtra(A06(696, 8, 25), BG.A03);
        adActivityIntentA05.putExtra(A06(249, 10, 107), uri.toString());
        adActivityIntentA05.putExtra(A06(277, 11, 26), str);
        adActivityIntentA05.putExtra(A06(533, 11, 0), System.currentTimeMillis());
        if (map != null) {
            String strA06 = A06(267, 10, 56);
            adActivityIntentA05.putExtra(strA06, map.get(strA06));
            String strA07 = A06(LevelPlayAdError.ERROR_CODE_LOAD_WHILE_SHOW, 21, 27);
            adActivityIntentA05.putExtra(strA07, map.get(strA07));
            String strA08 = A06(602, 27, 102);
            adActivityIntentA05.putExtra(strA08, map.get(strA08));
            String strA09 = A06(510, 23, 45);
            adActivityIntentA05.putExtra(strA09, map.get(strA09));
            String strA010 = A06(688, 8, 8);
            String str2 = map.get(strA010);
            if (str2 != null) {
                adActivityIntentA05.putExtra(strA010, str2);
            }
        }
        try {
            C1491Bq.A0B(c2699k1, adActivityIntentA05);
        } catch (C1489Bo e) {
            Throwable cause = e.getCause();
            C1489Bo cause2 = e;
            if (cause != null) {
                cause2 = e.getCause();
            }
            c2699k1.A08().AAu(A06(168, 11, 110), AbstractC14128a.A0D, new C14138b(cause2));
            Log.e(A06(149, 17, 28), A06(50, 90, 84), cause2);
        }
    }

    public static void A0C(C2 c2, C2699k1 c2699k1, Uri uri, String str) {
        c2.A0L(c2699k1, uri, str);
    }

    public static void A0D(C2 c2, C2699k1 c2699k1, Uri uri, String str) throws C1489Bo {
        A05(c2, c2699k1, uri, str, null);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0035  */
    /* JADX WARN: Code duplicated, block: B:18:? A[RETURN, SYNTHETIC] */
    public static boolean A0E(Uri uri) {
        boolean isHttpPermitted;
        boolean isHttpPermitted2 = Build.VERSION.SDK_INT < 24 || NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted() || NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(uri.getHost());
        String scheme = uri.getScheme();
        if (isHttpPermitted2) {
            boolean isHttpPermitted3 = A06(544, 4, 48).equalsIgnoreCase(scheme);
            if (!isHttpPermitted3) {
                isHttpPermitted = A06(582, 5, 1).equalsIgnoreCase(scheme);
                if (isHttpPermitted) {
                    return false;
                }
            }
        } else {
            isHttpPermitted = A06(582, 5, 1).equalsIgnoreCase(scheme);
            if (isHttpPermitted) {
                return false;
            }
        }
        return true;
    }

    private boolean A0F(C2699k1 c2699k1) {
        if (!C14499m.A1D(c2699k1)) {
            return false;
        }
        int deviceFBVersion = C14499m.A0E(c2699k1);
        int iA00 = A00(c2699k1);
        if (deviceFBVersion == -1 || iA00 == -1 || deviceFBVersion > iA00) {
            return false;
        }
        int i = Build.VERSION.SDK_INT;
        String[] strArr = A01;
        String str = strArr[4];
        String str2 = strArr[6];
        int length = str.length();
        int fbVersionWithGPOverlay = str2.length();
        if (length == fbVersionWithGPOverlay) {
            throw new RuntimeException();
        }
        A01[7] = "9F";
        if (i < 28) {
            return false;
        }
        String[] strArr2 = A01;
        String str3 = strArr2[2];
        String str4 = strArr2[1];
        int length2 = str3.length();
        int fbVersionWithGPOverlay2 = str4.length();
        if (length2 != fbVersionWithGPOverlay2) {
            String[] strArr3 = A01;
            strArr3[4] = "HTEWLbQNfCJbfH7LEcJTogLCYG9";
            strArr3[6] = "jIuteURS";
            return true;
        }
        return true;
    }

    private boolean A0G(C2699k1 c2699k1) {
        Intent playStoreIntent = new Intent(A06(186, 26, 10), C5.A00(A06(548, 34, 3)));
        Iterator<ResolveInfo> it = c2699k1.getPackageManager().queryIntentActivities(playStoreIntent, 0).iterator();
        do {
            boolean zHasNext = it.hasNext();
            String[] strArr = A01;
            if (strArr[5].charAt(7) != strArr[0].charAt(7)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[4] = "NqbTETCkL6wtg2G74gvKWlTJws9";
            strArr2[6] = "JszVyiBC";
            if (!zHasNext) {
                return false;
            }
        } while (!it.next().activityInfo.applicationInfo.packageName.equals(A06(322, 19, 35)));
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0079 A[PHI: r0 r1 r5
  0x0079: PHI (r0v21 int) = (r0v17 int), (r0v25 int) binds: [B:33:0x00d7, B:19:0x0077] A[DONT_GENERATE, DONT_INLINE]
  0x0079: PHI (r1v15 java.lang.String) = (r1v12 java.lang.String), (r1v19 java.lang.String) binds: [B:33:0x00d7, B:19:0x0077] A[DONT_GENERATE, DONT_INLINE]
  0x0079: PHI (r5v2 java.lang.String) = (r5v0 java.lang.String), (r5v3 java.lang.String) binds: [B:33:0x00d7, B:19:0x0077] A[DONT_GENERATE, DONT_INLINE]] */
    public static boolean A0H(C2699k1 c2699k1) {
        String strA06;
        String strA07;
        int identifier;
        boolean z = Build.VERSION.SDK_INT >= 24;
        boolean zA0I = A0I(c2699k1);
        String[] strArr = A01;
        if (strArr[5].charAt(7) != strArr[0].charAt(7)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[2] = "";
        strArr2[1] = "LeI";
        boolean z2 = z && zA0I;
        boolean z3 = true;
        boolean supportsSplitScreenMultiWindow = true;
        boolean appResizingSupported = true;
        boolean onAndAboveNOS = C14499m.A26(c2699k1);
        if (onAndAboveNOS) {
            Resources system = Resources.getSystem();
            String[] strArr3 = A01;
            if (strArr3[5].charAt(7) != strArr3[0].charAt(7)) {
                String strA08 = A06(431, 26, 110);
                strA06 = A06(245, 4, 93);
                strA07 = A06(179, 7, 7);
                identifier = system.getIdentifier(strA08, strA06, strA07);
                if (identifier != 0) {
                    z3 = Resources.getSystem().getBoolean(identifier);
                }
            } else {
                String[] strArr4 = A01;
                strArr4[2] = "";
                strArr4[1] = "Rqc";
                String strA09 = A06(431, 26, 110);
                strA06 = A06(245, 4, 93);
                strA07 = A06(179, 7, 7);
                identifier = system.getIdentifier(strA09, strA06, strA07);
                if (identifier != 0) {
                    z3 = Resources.getSystem().getBoolean(identifier);
                }
            }
            int identifier2 = system.getIdentifier(A06(457, 37, 47), strA06, strA07);
            if (identifier2 != 0) {
                supportsSplitScreenMultiWindow = Resources.getSystem().getBoolean(identifier2);
            }
            appResizingSupported = CE.A0C(c2699k1);
            z2 &= z3 && supportsSplitScreenMultiWindow && appResizingSupported;
        }
        c2699k1.A0F().ABR(zA0I, z2, z3, supportsSplitScreenMultiWindow, appResizingSupported);
        return z2;
    }

    public static boolean A0I(C2699k1 c2699k1) {
        ActivityInfo activityInfo;
        try {
            Activity activityA0E = c2699k1.A0E();
            PackageManager packageManager = c2699k1.getPackageManager();
            if (activityA0E == null || packageManager == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT > 32) {
                activityInfo = packageManager.getActivityInfo(activityA0E.getComponentName(), PackageManager.ComponentInfoFlags.of(0L));
            } else {
                activityInfo = packageManager.getActivityInfo(activityA0E.getComponentName(), 128);
            }
            Field declaredField = ActivityInfo.class.getDeclaredField(A06(678, 10, 6));
            declaredField.setAccessible(true);
            Object obj = declaredField.get(activityInfo);
            return (obj instanceof Integer) && ((Integer) obj).intValue() != 0;
        } catch (PackageManager.NameNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            c2699k1.A0F().ABP(e.getMessage());
        }
        return false;
    }

    private boolean A0J(C2699k1 c2699k1, Uri uri, String str) throws C1489Bo {
        try {
            Activity activityA0E = c2699k1.A0E();
            String string = uri.toString();
            if (activityA0E != null && !TextUtils.isEmpty(string)) {
                Intent fbIntent = new Intent();
                if (C14499m.A1E(c2699k1)) {
                    String strA06 = AbstractC2855md.A06(str);
                    if (TextUtils.isEmpty(strA06)) {
                        return false;
                    }
                    fbIntent.putExtra(A06(0, 20, 67), A07(strA06));
                }
                fbIntent.setComponent(new ComponentName(A06(412, 19, 65), A06(FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS, 71, 75)));
                fbIntent.putExtra(A06(IronSourceConstants.USING_CACHE_FOR_INIT_EVENT, 9, 22), string);
                fbIntent.putExtra(A06(37, 13, 89), A07(A06(20, 17, 90)));
                if (!C1491Bq.A0E(c2699k1, fbIntent)) {
                    activityA0E.startActivityForResult(fbIntent, 2);
                    return true;
                }
                return true;
            }
            return false;
        } catch (ActivityNotFoundException | IllegalStateException e) {
            c2699k1.A0F().AAy(e.getMessage());
            return false;
        }
    }

    private boolean A0K(C2699k1 c2699k1, Uri uri, String str) throws C1489Bo {
        return A0F(c2699k1) && A0J(c2699k1, uri, str);
    }

    private final boolean A0L(C2699k1 c2699k1, Uri uri, String str) {
        return C1491Bq.A0G(c2699k1, uri, str);
    }

    public static boolean A0M(C2 c2, C2699k1 c2699k1, Uri uri, String str) {
        try {
            A0D(c2, c2699k1, uri, str);
            return true;
        } catch (C1489Bo e) {
            Throwable cause = e.getCause();
            C1489Bo cause2 = e;
            if (cause != null) {
                cause2 = e.getCause();
            }
            c2699k1.A08().AAu(A06(168, 11, 110), AbstractC14128a.A05, new C14138b(cause2));
            return false;
        }
    }
}
