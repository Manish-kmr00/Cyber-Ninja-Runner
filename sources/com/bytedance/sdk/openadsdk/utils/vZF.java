package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsSession;
import com.bytedance.sdk.openadsdk.activity.TTBaseActivity;
import com.bytedance.sdk.openadsdk.core.act.AdActAction;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public class vZF {
    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, h.u);
        p0.startActivity(p1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.bytedance.sdk.openadsdk.Sn.pA.Og Og(String str, int i, com.bytedance.sdk.openadsdk.core.model.yFO yfo) {
        com.bytedance.sdk.openadsdk.Sn.pA.Og og = new com.bytedance.sdk.openadsdk.Sn.pA.Og();
        og.pA(str);
        og.pA(yfo);
        og.Og(gbA.pA(yfo));
        og.pA(i);
        og.pA(false);
        og.Og(yfo.JBA());
        return og;
    }

    public static boolean pA(Context context, final String str, final com.bytedance.sdk.openadsdk.core.model.yFO yfo, final String str2) {
        if (context instanceof Activity) {
            if (!pA((Activity) context)) {
                context = null;
            }
        } else {
            Activity activityOg = com.bytedance.sdk.openadsdk.core.DX.pA().ML().Og();
            if (activityOg != null && pA(activityOg)) {
                context = activityOg;
            }
        }
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.aBv.pA();
        }
        if (context == null) {
            return false;
        }
        final String strPA = gbA.pA(yfo);
        if (!com.bytedance.sdk.component.utils.DX.pA(str)) {
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(Og(str2, 5, yfo));
            return false;
        }
        final String strOg = com.bytedance.sdk.openadsdk.core.model.yFO.Og(context, yfo);
        if (!TextUtils.isEmpty(strOg)) {
            try {
                final CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setUrlBarHidingEnabled(false);
                builder.setShareState(2);
                final Context context2 = context;
                new AdActAction(context, yfo, str2, str).pA(new AdActAction.BindCustomTabsServiceCallback() { // from class: com.bytedance.sdk.openadsdk.utils.vZF.1
                    @Override // com.bytedance.sdk.openadsdk.core.act.AdActAction.BindCustomTabsServiceCallback
                    public void onBindSuccess(CustomTabsSession customTabsSession) {
                        if (customTabsSession != null) {
                            try {
                                builder.setSession(customTabsSession);
                            } catch (Throwable th) {
                                String message = th.getMessage();
                                com.bytedance.sdk.component.utils.WV.pA("OpenUtils", message);
                                com.bytedance.sdk.openadsdk.Sn.pA.Og Og = vZF.Og(str2, 13, yfo);
                                Og.KZx(message);
                                com.bytedance.sdk.openadsdk.ZZv.KZx.pA(Og);
                                vZF.Og(context2, str, yfo, str2, strPA);
                                return;
                            }
                        }
                        CustomTabsIntent customTabsIntentBuild = builder.build();
                        if (!(context2 instanceof Activity)) {
                            customTabsIntentBuild.intent.addFlags(268435456);
                        }
                        com.bytedance.sdk.openadsdk.core.act.KZx.pA(context2, strOg, customTabsIntentBuild, Uri.parse(str));
                        Context context3 = context2;
                        if (context3 instanceof TTBaseActivity) {
                            ((TTBaseActivity) context3).Og(true);
                        }
                        com.bytedance.sdk.openadsdk.Sn.pA.Og Og2 = vZF.Og(str2, 100, yfo);
                        Og2.pA(true);
                        Og2.Og(8);
                        com.bytedance.sdk.openadsdk.ZZv.KZx.pA(Og2);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.act.AdActAction.BindCustomTabsServiceCallback
                    public void onBindFail(int i, String str3) {
                        com.bytedance.sdk.openadsdk.Sn.pA.Og Og = vZF.Og(str2, i, yfo);
                        Og.KZx(str3);
                        com.bytedance.sdk.openadsdk.ZZv.KZx.pA(Og);
                        vZF.Og(context2, str, yfo, str2, strPA);
                    }
                });
                return true;
            } catch (Throwable th) {
                String message = th.getMessage();
                com.bytedance.sdk.component.utils.WV.pA("OpenUtils", message);
                com.bytedance.sdk.openadsdk.Sn.pA.Og Og = Og(str2, 12, yfo);
                Og.KZx(message);
                com.bytedance.sdk.openadsdk.ZZv.KZx.pA(Og);
                return Og(context, str, yfo, str2, strPA);
            }
        }
        return Og(context, str, yfo, str2, strPA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean Og(Context context, String str, com.bytedance.sdk.openadsdk.core.model.yFO yfo, String str2, String str3) {
        Intent intent = new Intent("android.intent.action.VIEW");
        try {
            intent.setData(Uri.parse(str));
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            try {
                safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, intent);
                com.bytedance.sdk.openadsdk.Sn.pA.Og Og = Og(str2, 100, yfo);
                Og.pA(true);
                Og.Og(2);
                com.bytedance.sdk.openadsdk.ZZv.KZx.pA(Og);
                return true;
            } catch (Throwable th) {
                String message = th.getMessage();
                com.bytedance.sdk.openadsdk.Sn.pA.Og Og2 = Og(str2, 7, yfo);
                Og2.KZx(message);
                Og2.Og(2);
                com.bytedance.sdk.openadsdk.ZZv.KZx.pA(Og2);
                return false;
            }
        } catch (Throwable th2) {
            String message2 = th2.getMessage();
            com.bytedance.sdk.openadsdk.Sn.pA.Og Og3 = Og(str2, 6, yfo);
            Og3.KZx(message2);
            Og3.Og(2);
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(Og3);
            return false;
        }
    }

    public static boolean Og(Context context, String str, com.bytedance.sdk.openadsdk.core.model.yFO yfo, String str2) {
        if (context instanceof Activity) {
            if (!pA((Activity) context)) {
                context = null;
            }
        } else {
            Activity activityOg = com.bytedance.sdk.openadsdk.core.DX.pA().ML().Og();
            if (activityOg != null && pA(activityOg)) {
                context = activityOg;
            }
        }
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.aBv.pA();
        }
        Context context2 = context;
        if (context2 == null || !pA(str)) {
            return false;
        }
        Uri uri = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        HashMap map = new HashMap();
        map.put("deeplink_url", str);
        map.put("jsb_deeplink", 1);
        if (com.bytedance.sdk.openadsdk.XT.pA.pA.KZx.pA()) {
            return com.bytedance.sdk.openadsdk.XT.pA.pA.KZx.pA(context2, str, yfo, gbA.Og(yfo), map, true);
        }
        if (gbA.omh(context2)) {
            if (gbA.pA(context2, intent)) {
                com.bytedance.sdk.openadsdk.ZZv.KZx.pA(yfo, str2, "open_url_app", map);
                try {
                    if (!(context2 instanceof Activity)) {
                        intent.addFlags(268435456);
                    }
                    safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context2, intent);
                    com.bytedance.sdk.openadsdk.ZZv.WV.pA().pA(map).pA(yfo, str2);
                    return true;
                } catch (Throwable unused) {
                }
            }
            return false;
        }
        try {
            if (!(context2 instanceof Activity)) {
                intent.addFlags(268435456);
            }
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(yfo, str2, "open_url_app", map);
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context2, intent);
            com.bytedance.sdk.openadsdk.ZZv.WV.pA().pA(map).pA(yfo, str2);
            return true;
        } catch (Exception unused2) {
            return false;
        }
    }

    public static boolean pA(String str) {
        return !TextUtils.isEmpty(str);
    }

    public static boolean pA(Activity activity) {
        return (activity == null || activity.isDestroyed() || activity.isFinishing()) ? false : true;
    }
}
