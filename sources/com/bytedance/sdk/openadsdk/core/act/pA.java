package com.bytedance.sdk.openadsdk.core.act;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsService;
import androidx.browser.customtabs.CustomTabsSession;
import androidx.browser.customtabs.EngagementSignalsCallback;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.Sn.pA.ZZv;
import com.bytedance.sdk.openadsdk.core.Sn;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class pA {
    private static ActServiceConnection JG = null;
    private static int KZx = -1;
    private static Boolean ML = null;
    private static int Og = -1;
    private static volatile boolean ZZv;
    private static String pA;

    private pA() {
    }

    public static String pA(final Context context) {
        String str = pA;
        if (str != null) {
            return str;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
            ResolveInfo resolveInfoResolveActivity = packageManager.resolveActivity(intent, 0);
            String str2 = resolveInfoResolveActivity != null ? resolveInfoResolveActivity.activityInfo.packageName : null;
            List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 0);
            ArrayList arrayList = new ArrayList();
            for (ResolveInfo resolveInfo : listQueryIntentActivities) {
                Intent intent2 = new Intent();
                intent2.setAction(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION);
                intent2.setPackage(resolveInfo.activityInfo.packageName);
                if (packageManager.resolveService(intent2, 0) != null) {
                    arrayList.add(resolveInfo.activityInfo.packageName);
                }
            }
            if (arrayList.isEmpty()) {
                pA = null;
            } else if (!TextUtils.isEmpty(str2) && !pA(context, intent) && arrayList.contains(str2)) {
                pA = str2;
            } else {
                pA = (String) arrayList.get(0);
            }
            if (!TextUtils.isEmpty(pA)) {
                synchronized (pA.class) {
                    if (!ZZv) {
                        Og og = new Og() { // from class: com.bytedance.sdk.openadsdk.core.act.pA.1
                            @Override // com.bytedance.sdk.openadsdk.core.act.Og
                            public void pA(final CustomTabsClient customTabsClient) {
                                Sn.Og().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.act.pA.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Throwable th;
                                        boolean zIsEngagementSignalsApiAvailable;
                                        boolean engagementSignalsCallback = false;
                                        try {
                                            CustomTabsCallback customTabsCallback = new CustomTabsCallback();
                                            EngagementSignalsCallback engagementSignalsCallback2 = new EngagementSignalsCallback() { // from class: com.bytedance.sdk.openadsdk.core.act.pA.1.1.1
                                                @Override // androidx.browser.customtabs.EngagementSignalsCallback
                                                public void onGreatestScrollPercentageIncreased(int i, Bundle bundle) {
                                                }

                                                @Override // androidx.browser.customtabs.EngagementSignalsCallback
                                                public void onSessionEnded(boolean z, Bundle bundle) {
                                                }

                                                @Override // androidx.browser.customtabs.EngagementSignalsCallback
                                                public void onVerticalScrollEvent(boolean z, Bundle bundle) {
                                                }
                                            };
                                            CustomTabsSession customTabsSessionNewSession = customTabsClient.newSession(customTabsCallback);
                                            zIsEngagementSignalsApiAvailable = customTabsSessionNewSession != null ? customTabsSessionNewSession.isEngagementSignalsApiAvailable(Bundle.EMPTY) : false;
                                            try {
                                                if (zIsEngagementSignalsApiAvailable) {
                                                    int unused = pA.Og = 1;
                                                    engagementSignalsCallback = customTabsSessionNewSession.setEngagementSignalsCallback(engagementSignalsCallback2, Bundle.EMPTY);
                                                    if (engagementSignalsCallback) {
                                                        int unused2 = pA.KZx = 1;
                                                    }
                                                } else {
                                                    int unused3 = pA.Og = 0;
                                                }
                                                if (!zIsEngagementSignalsApiAvailable || !engagementSignalsCallback) {
                                                    Boolean unused4 = pA.ML = Boolean.FALSE;
                                                } else {
                                                    Boolean unused5 = pA.ML = Boolean.TRUE;
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                engagementSignalsCallback = zIsEngagementSignalsApiAvailable;
                                                WV.pA("CustomTabsHelper", th.getMessage());
                                                zIsEngagementSignalsApiAvailable = engagementSignalsCallback;
                                                engagementSignalsCallback = false;
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                        }
                                        new Object[]{"pagact before  ", "   api_Available=", Boolean.valueOf(zIsEngagementSignalsApiAvailable), "  signalsCallback=", Boolean.valueOf(engagementSignalsCallback)};
                                        ActServiceConnection actServiceConnection = pA.JG;
                                        if (!pA.ZZv || actServiceConnection == null) {
                                            return;
                                        }
                                        try {
                                            context.unbindService(actServiceConnection);
                                        } catch (Throwable unused6) {
                                        }
                                    }
                                });
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.act.Og
                            public void pA() {
                                ActServiceConnection unused = pA.JG = null;
                            }
                        };
                        if (JG == null) {
                            JG = new ActServiceConnection(og);
                        }
                        CustomTabsClient.bindCustomTabsService(context, pA, JG);
                        ZZv = true;
                    }
                }
            }
        } catch (Throwable th) {
            WV.pA("CustomTabsHelper", th.getMessage());
        }
        com.bytedance.sdk.openadsdk.Sn.KZx.pA("act_package_name", false, new com.bytedance.sdk.openadsdk.Sn.Og() { // from class: com.bytedance.sdk.openadsdk.core.act.pA.2
            @Override // com.bytedance.sdk.openadsdk.Sn.Og
            public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("package_name", pA.pA);
                return ZZv.Og().pA("act_package_name").Og(jSONObject.toString());
            }
        });
        return pA;
    }

    private static boolean pA(Context context, Intent intent) {
        try {
            List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 64);
            if (listQueryIntentActivities.size() == 0) {
                return false;
            }
            for (ResolveInfo resolveInfo : listQueryIntentActivities) {
                IntentFilter intentFilter = resolveInfo.filter;
                if (intentFilter != null && intentFilter.countDataAuthorities() != 0 && intentFilter.countDataPaths() != 0 && resolveInfo.activityInfo != null) {
                    return true;
                }
            }
        } catch (RuntimeException unused) {
            Log.e("CustomTabsHelper", "Runtime exception while getting specialized handlers");
        }
        return false;
    }

    public static int pA() {
        Boolean bool = ML;
        return (bool != null && bool.booleanValue()) ? 1 : 0;
    }

    public static int Og(Context context) {
        try {
            return !TextUtils.isEmpty(pA(context)) ? 1 : 0;
        } catch (Throwable unused) {
        }
    }

    public static int Og() {
        return Og;
    }

    public static int KZx() {
        return KZx;
    }

    public static void pA(int i) {
        Og = i;
    }

    public static void Og(int i) {
        KZx = i;
    }
}
