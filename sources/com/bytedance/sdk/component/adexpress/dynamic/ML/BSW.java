package com.bytedance.sdk.component.adexpress.dynamic.ML;

import android.text.TextUtils;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.Og.Wx;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.component.utils.yFO;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import com.yandex.div2.PhoneMasks;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import net.pubnative.lite.sdk.vpaid.enums.EventConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class BSW {
    private static String Og;
    private static final Set<String> pA = Collections.unmodifiableSet(new HashSet(Arrays.asList("dislike", "close", "close-fill", "webview-close")));

    /* JADX WARN: Code duplicated, block: B:218:0x0496  */
    /* JADX WARN: Code duplicated, block: B:221:0x04a3 A[Catch: Exception -> 0x04b4, JSONException -> 0x04b8, TryCatch #1 {JSONException -> 0x04b8, blocks: (B:177:0x03b3, B:179:0x0412, B:181:0x0417, B:183:0x0420, B:191:0x0435, B:193:0x043c, B:195:0x0449, B:197:0x0451, B:200:0x0458, B:204:0x0462, B:210:0x0476, B:212:0x047f, B:214:0x0485, B:216:0x048d, B:228:0x04b4, B:219:0x0498, B:221:0x04a3, B:226:0x04ad, B:206:0x046b), top: B:272:0x03b3 }] */
    /* JADX WARN: Code duplicated, block: B:223:0x04a9 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:225:0x04ac  */
    public static Og.KZx pA(String str, String str2, String str3, boolean z, boolean z2, int i, com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar, double d, int i2, double d2, String str4, Wx wx) {
        int i3;
        int i4;
        float f;
        float f2;
        Og.KZx kZxPA;
        int i5;
        com.bytedance.sdk.component.adexpress.dynamic.ZZv.JG jgML;
        String strOptString = str;
        int i6 = i;
        String strZZv = wx.ZZv();
        int iSD = wx.SD();
        if (com.bytedance.sdk.component.adexpress.ZZv.Og() && i2 != 4 && (TextUtils.equals(str2, "text_star") || TextUtils.equals(str2, "score-count") || TextUtils.equals(str2, "score-count-type-1") || TextUtils.equals(str2, "score-count-type-2"))) {
            return new Og.KZx(0.0f, 0.0f);
        }
        Og.KZx kZx = new Og.KZx();
        if (strOptString.startsWith("<svg") || pA.contains(str2)) {
            try {
                if ("close".equals(str2) || (com.bytedance.sdk.component.adexpress.ZZv.Og() && "close-fill".equals(str2))) {
                    float fOptDouble = (float) PangleNetworkBridge.jsonObjectInit(str3).optDouble("fontSize");
                    kZx.pA = fOptDouble;
                    kZx.Og = fOptDouble;
                    return kZx;
                }
            } catch (Exception unused) {
            }
            kZx.pA = 10.0f;
            kZx.Og = 10.0f;
            return kZx;
        }
        if ("logo".equals(str2)) {
            if (!com.bytedance.sdk.component.adexpress.ZZv.Og() && ((!TextUtils.isEmpty(str) && strOptString.contains("adx:")) || Og())) {
                if (Og()) {
                    return pA(kZx, strOptString, str3, Og);
                }
                return pA(kZx, strOptString, str3, "");
            }
            kZx.pA = "union".equals(strOptString) ? 10.0f : 20.0f;
            kZx.Og = 10.0f;
            if (com.bytedance.sdk.component.adexpress.ZZv.Og()) {
                String str5 = str2 + strOptString;
                float fOg = (float) Og(str3);
                if (str5.contains("logoad")) {
                    return pA(yFO.pA(com.bytedance.sdk.component.adexpress.ZZv.pA(), "tt_logo_en"), str3);
                }
                kZx.Og = fOg;
            }
            return kZx;
        }
        if ("development-name".equals(str2)) {
            strOptString = yFO.pA(com.bytedance.sdk.component.adexpress.ZZv.pA(), "tt_text_privacy_development") + strOptString;
        }
        if ("app-version".equals(str2)) {
            strOptString = yFO.pA(com.bytedance.sdk.component.adexpress.ZZv.pA(), "tt_text_privacy_app_version") + strOptString;
        }
        if ("score-count".equals(str2)) {
            try {
                i3 = Integer.parseInt(strOptString);
            } catch (NumberFormatException unused2) {
                i3 = 0;
            }
            if (com.bytedance.sdk.component.adexpress.ZZv.Og() && i3 < 0) {
                return new Og.KZx(0.0f, 0.0f);
            }
            return pA("(" + String.format(yFO.pA(com.bytedance.sdk.component.adexpress.ZZv.pA(), "tt_comment_num"), Integer.valueOf(i3)) + ")", str3);
        }
        if ("score-count-type-2".equals(str2)) {
            try {
                i4 = Integer.parseInt(strOptString);
            } catch (NumberFormatException unused3) {
                i4 = 0;
            }
            if (com.bytedance.sdk.component.adexpress.ZZv.Og() && i4 < 0) {
                return new Og.KZx(0.0f, 0.0f);
            }
            return pA("(" + String.format(new DecimalFormat("###,###,###").format(i4), Integer.valueOf(i4)) + ")", str3);
        }
        if ("feedback-dislike".equals(str2)) {
            if (com.bytedance.sdk.component.adexpress.ZZv.Og()) {
                Og.KZx kZx2 = new Og.KZx();
                float fOg2 = (float) Og(str3);
                kZx2.pA = fOg2;
                kZx2.Og = fOg2;
                return kZx2;
            }
            return pA(yFO.pA(com.bytedance.sdk.component.adexpress.ZZv.pA(), "tt_reward_feedback"), str3);
        }
        if ("skip-with-time-countdown".equals(str2) || TextUtils.equals("skip-with-countdowns-video-countdown", str2)) {
            if (!wx.pA() || !com.bytedance.sdk.component.adexpress.ZZv.SD.Og(strZZv)) {
                if (d < 10.0d) {
                    return pA("0S", str3);
                }
                return pA("00S", str3);
            }
            if (((int) (d + 0.5d)) - iSD < 10) {
                if (!com.bytedance.sdk.component.adexpress.ZZv.Og()) {
                    return pA(String.format(yFO.pA(com.bytedance.sdk.component.adexpress.ZZv.pA(), "tt_reward_full_skip"), "0"), str3);
                }
                return pA("0s", str3);
            }
            if (!com.bytedance.sdk.component.adexpress.ZZv.Og()) {
                return pA(String.format(yFO.pA(com.bytedance.sdk.component.adexpress.ZZv.pA(), "tt_reward_full_skip"), PhoneMasks.EXTRA_NUMBERS), str3);
            }
            return pA("00s", str3);
        }
        if (TextUtils.equals("skip-with-countdowns-skip-btn", str2)) {
            return pA("| " + yFO.pA(com.bytedance.sdk.component.adexpress.ZZv.pA(), "tt_reward_screen_skip_tx"), str3);
        }
        if (TextUtils.equals("skip-with-countdowns-skip-countdown", str2)) {
            return pA("| ".concat(String.valueOf(String.format(yFO.pA(com.bytedance.sdk.component.adexpress.ZZv.pA(), "tt_reward_full_skip_count_down"), PhoneMasks.EXTRA_NUMBERS))), str3);
        }
        if ("skip-with-time-skip-btn".equals(str2)) {
            Og.KZx kZxPA2 = pA("| " + yFO.pA(com.bytedance.sdk.component.adexpress.ZZv.pA(), "tt_reward_screen_skip_tx"), str3);
            if (com.bytedance.sdk.component.adexpress.ZZv.Og()) {
                try {
                    kZxPA2.Og = (float) ((((double) kZxPA2.Og) * PangleNetworkBridge.jsonObjectInit(str3).optDouble("lineHeight")) / 1.2d);
                } catch (Throwable unused4) {
                }
                kZxPA2.pA = kZxPA2.Og;
            }
            return kZxPA2;
        }
        if (EventConstants.SKIP.equals(str2)) {
            return pA(yFO.pA(com.bytedance.sdk.component.adexpress.ZZv.pA(), "tt_reward_screen_skip_tx"), str3);
        }
        if ("timedown".equals(str2)) {
            return pA(IdManager.DEFAULT_VERSION_NAME, str3);
        }
        if ("text_star".equals(str2)) {
            if (com.bytedance.sdk.component.adexpress.ZZv.Og() && (d2 < 0.0d || d2 > 5.0d)) {
                return new Og.KZx(0.0f, 0.0f);
            }
            return pA(IdManager.DEFAULT_VERSION_NAME, str3);
        }
        if (TextUtils.equals("privacy-detail", str2)) {
            return pA("Permission list | Privacy policy", str3);
        }
        if ("arrowButton".equals(str2)) {
            return pA("Download", str3);
        }
        if ("text".equals(str2) && com.bytedance.sdk.component.adexpress.ZZv.Og() && TextUtils.isEmpty(strOptString) && (jgML = omhVar.SGo().ML()) != null) {
            strOptString = jgML.bU() != null ? omhVar.SGo().ML().bU().optString(com.bytedance.sdk.component.adexpress.ZZv.omh.KZx(com.bytedance.sdk.component.adexpress.ZZv.pA())) : "";
        }
        if ("fillButton".equals(str2) || "text".equals(str2) || "button".equals(str2) || "downloadWithIcon".equals(str2) || "downloadButton".equals(str2) || "laceButton".equals(str2) || "cardButton".equals(str2) || "colourMixtureButton".equals(str2) || "arrowButton".equals(str2) || (("source".equals(str2) && (!com.bytedance.sdk.component.adexpress.ZZv.Og() || !"open_ad".equals(strZZv))) || TextUtils.equals("app-version", str2) || TextUtils.equals("development-name", str2))) {
            return pA(strOptString, str3);
        }
        try {
            JSONObject jSONObjectJsonObjectInit = PangleNetworkBridge.jsonObjectInit(str3);
            int length = strOptString.length();
            float fOptDouble2 = (float) jSONObjectJsonObjectInit.optDouble("fontSize");
            float fOptDouble3 = (float) jSONObjectJsonObjectInit.optDouble("letterSpacing");
            float fOptDouble4 = (float) jSONObjectJsonObjectInit.optDouble("lineHeight");
            float fOptDouble5 = (float) jSONObjectJsonObjectInit.optDouble("maxWidth");
            float f3 = (length * (fOptDouble2 + fOptDouble3)) - fOptDouble3;
            WV.pA("DynamicBaseWidget", "getDomSizeFromNative letterSpacing==" + fOptDouble3 + ",lineHeight==" + fOptDouble4 + ",maxWidth ==" + fOptDouble5 + ",totalStrLength" + f3);
            if ("muted".equals(str2)) {
                kZx.pA = fOptDouble2;
                kZx.Og = fOptDouble2;
                return kZx;
            }
            if ("star".equals(str2)) {
                if (com.bytedance.sdk.component.adexpress.ZZv.Og() && (d2 < 0.0d || d2 > 5.0d || i2 != 4)) {
                    return new Og.KZx(0.0f, 0.0f);
                }
                Og.KZx kZxPA3 = pA("str", str3);
                kZxPA3.pA = fOptDouble2 * 5.0f;
                return kZxPA3;
            }
            if ("icon".equals(str2)) {
                kZx.pA = fOptDouble2;
                kZx.Og = fOptDouble2;
                return kZx;
            }
            if (!z) {
                f = (float) (((double) (fOptDouble4 * fOptDouble2)) * 1.2d);
                if (f3 <= fOptDouble5) {
                    f2 = f3;
                }
                if (!"title".equals(str2) || (com.bytedance.sdk.component.adexpress.ZZv.Og() && "open_ad".equals(strZZv) && "source".equals(str2))) {
                    try {
                        kZxPA = pA(strOptString.replace('\n', ' '), str3, false);
                        if (z) {
                            i5 = ((int) (f3 / fOptDouble5)) + 1;
                            if (z2 || i5 < i6) {
                                i6 = i5;
                            }
                            kZxPA.Og *= i6;
                        }
                        return kZxPA;
                    } catch (Exception unused5) {
                    }
                }
                kZx.pA = f2;
                kZx.Og = f;
                return kZx;
            }
            int i7 = ((int) (f3 / fOptDouble5)) + 1;
            if (z2 && i7 >= i6) {
                i7 = i6;
            }
            f = (float) (((double) (fOptDouble4 * fOptDouble2 * i7)) * 1.2d);
            f2 = fOptDouble5;
            if (!"title".equals(str2)) {
                kZxPA = pA(strOptString.replace('\n', ' '), str3, false);
                if (z) {
                    i5 = ((int) (f3 / fOptDouble5)) + 1;
                    if (z2) {
                        i6 = i5;
                    } else {
                        i6 = i5;
                    }
                    kZxPA.Og *= i6;
                }
                return kZxPA;
            }
            kZxPA = pA(strOptString.replace('\n', ' '), str3, false);
            if (z) {
                i5 = ((int) (f3 / fOptDouble5)) + 1;
                if (z2) {
                    i6 = i5;
                } else {
                    i6 = i5;
                }
                kZxPA.Og *= i6;
            }
            return kZxPA;
            return kZx;
        } catch (JSONException unused6) {
        }
    }

    public static String pA(String str) {
        String[] strArrSplit;
        return (TextUtils.isEmpty(str) || (strArrSplit = str.split("adx:")) == null || strArrSplit.length < 2) ? "" : strArrSplit[1];
    }

    private static Og.KZx pA(Og.KZx kZx, String str, String str2, String str3) {
        if (str.contains("union")) {
            kZx.pA = 0.0f;
            kZx.Og = 0.0f;
        } else {
            if (TextUtils.isEmpty(str3)) {
                str3 = pA(str);
            }
            if (TextUtils.isEmpty(str3)) {
                kZx.pA = 0.0f;
                kZx.Og = 0.0f;
            } else {
                return pA(str3, str2);
            }
        }
        return kZx;
    }

    public static Og.KZx pA(String str, String str2) {
        return pA(str, str2, false);
    }

    public static Og.KZx pA(String str, String str2, boolean z) {
        Og.KZx kZx = new Og.KZx();
        try {
            JSONObject jSONObjectJsonObjectInit = PangleNetworkBridge.jsonObjectInit(str2);
            int[] iArrPA = pA(str, (float) Og(str2), z);
            kZx.pA = iArrPA[0];
            kZx.Og = iArrPA[1];
            if (jSONObjectJsonObjectInit.optDouble("lineHeight", 1.0d) == 0.0d) {
                kZx.Og = 0.0f;
            }
        } catch (Exception unused) {
        }
        return kZx;
    }

    public static double Og(String str) {
        try {
            return Double.parseDouble(PangleNetworkBridge.jsonObjectInit(str).optString("fontSize"));
        } catch (Throwable unused) {
            return 0.0d;
        }
    }

    public static int[] pA(String str, float f, boolean z) {
        int[] iArrOg = Og(str, f, z);
        return new int[]{com.bytedance.sdk.component.adexpress.ZZv.omh.Og(com.bytedance.sdk.component.adexpress.ZZv.pA(), iArrOg[0]), com.bytedance.sdk.component.adexpress.ZZv.omh.Og(com.bytedance.sdk.component.adexpress.ZZv.pA(), iArrOg[1])};
    }

    public static int[] Og(String str, float f, boolean z) {
        try {
            TextView textView = new TextView(com.bytedance.sdk.component.adexpress.ZZv.pA());
            textView.setTextSize(f);
            textView.setText(str);
            textView.setIncludeFontPadding(false);
            if (z) {
                textView.setSingleLine();
            }
            textView.measure(-2, -2);
            return new int[]{textView.getMeasuredWidth() + 2, textView.getMeasuredHeight() + 2};
        } catch (Exception unused) {
            return new int[]{0, 0};
        }
    }

    public static String pA() {
        return Og;
    }

    public static boolean Og() {
        return !TextUtils.isEmpty(Og);
    }
}
