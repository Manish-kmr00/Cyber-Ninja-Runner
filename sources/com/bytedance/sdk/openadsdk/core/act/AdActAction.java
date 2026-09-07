package com.bytedance.sdk.openadsdk.core.act;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsSession;
import androidx.browser.customtabs.EngagementSignalsCallback;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.core.Bzk;
import com.bytedance.sdk.openadsdk.core.model.SGo;
import com.bytedance.sdk.openadsdk.core.model.WQf;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.bytedance.sdk.openadsdk.utils.xy;
import java.util.HashMap;
import java.util.Map;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AdActAction {
    private Long DX;
    private yFO KZx;
    private String ML;
    private Context Og;
    private CustomTabsSession SD;
    private String ZZv;
    private BindCustomTabsServiceCallback oX;
    private ActServiceConnection omh;
    private CustomTabsClient JG = null;
    private boolean Bzk = false;
    private boolean SGo = false;
    private boolean BSW = false;
    private boolean WV = false;
    private boolean Wx = false;
    private long Sn = 0;
    private Og aBv = new Og() { // from class: com.bytedance.sdk.openadsdk.core.act.AdActAction.1
        @Override // com.bytedance.sdk.openadsdk.core.act.Og
        public void pA(final CustomTabsClient customTabsClient) {
            if (xy.ML()) {
                AdActAction.this.pA(customTabsClient);
            } else {
                xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.act.AdActAction.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AdActAction.this.pA(customTabsClient);
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.act.Og
        public void pA() {
            AdActAction.this.JG = null;
            AdActAction.this.omh = null;
            AdActAction.this.SD = null;
        }
    };
    public EngagementSignalsCallback pA = new PAGEngagementSignalsCallback();
    private CustomTabsCallback XT = new PAGCustomTabsCallback();

    public interface BindCustomTabsServiceCallback {
        void onBindFail(int i, String str);

        void onBindSuccess(CustomTabsSession customTabsSession);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(CustomTabsClient customTabsClient) {
        this.JG = customTabsClient;
        this.SD = customTabsClient.newSession(this.XT);
        com.bytedance.sdk.openadsdk.Sn.pA.Og ogPA = pA(9);
        try {
            boolean zIsEngagementSignalsApiAvailable = this.SD.isEngagementSignalsApiAvailable(Bundle.EMPTY);
            boolean z = false;
            if (zIsEngagementSignalsApiAvailable) {
                boolean engagementSignalsCallback = this.SD.setEngagementSignalsCallback(this.pA, Bundle.EMPTY);
                ogPA.KZx(1);
                pA.pA(1);
                if (engagementSignalsCallback) {
                    ogPA.ZZv(1);
                    pA.Og(1);
                } else {
                    pA.Og(0);
                }
                z = engagementSignalsCallback;
            } else {
                ogPA.KZx(0);
                pA.pA(0);
            }
            new Object[]{"pagact:  api=", Boolean.valueOf(zIsEngagementSignalsApiAvailable), "  event=", Boolean.valueOf(z)};
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(ogPA);
            BindCustomTabsServiceCallback bindCustomTabsServiceCallback = this.oX;
            if (bindCustomTabsServiceCallback != null) {
                bindCustomTabsServiceCallback.onBindSuccess(this.SD);
            }
        } catch (Throwable th) {
            BindCustomTabsServiceCallback bindCustomTabsServiceCallback2 = this.oX;
            if (bindCustomTabsServiceCallback2 != null) {
                bindCustomTabsServiceCallback2.onBindFail(11, th.getMessage());
            }
        }
    }

    public class PAGEngagementSignalsCallback implements EngagementSignalsCallback {
        public PAGEngagementSignalsCallback() {
        }

        @Override // androidx.browser.customtabs.EngagementSignalsCallback
        public void onVerticalScrollEvent(boolean z, Bundle bundle) {
            AdActAction.this.Sn = System.currentTimeMillis();
            if (AdActAction.this.KZx == null || AdActAction.this.Bzk) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", AdActAction.this.ML);
                jSONObject.put("down_time", AdActAction.this.Sn);
                long jCurrentTimeMillis = System.currentTimeMillis();
                jSONObject.put("up_time", jCurrentTimeMillis);
                com.bytedance.sdk.openadsdk.ZZv.KZx.Og(AdActAction.this.KZx, gbA.pA(AdActAction.this.KZx), "in_web_click", jSONObject, jCurrentTimeMillis - AdActAction.this.Sn);
            } catch (Throwable th) {
                WV.pA("AdActAction", th.getMessage());
            }
            if (!TextUtils.isEmpty(yFO.pA(AdActAction.this.Og, AdActAction.this.KZx))) {
                com.bytedance.sdk.openadsdk.ZZv.KZx.pA("click", AdActAction.this.KZx, new SGo.pA().Og(AdActAction.this.Sn).pA(System.currentTimeMillis()).Og(Bzk.Og().pA() ? 1 : 2).KZx(Vgu.SD(AdActAction.this.Og)).pA(Vgu.ML(AdActAction.this.Og)).Og(Vgu.JG(AdActAction.this.Og)).pA(), gbA.pA(AdActAction.this.KZx), true, (Map<String, Object>) new HashMap(), 2);
            }
            AdActAction.this.Bzk = true;
        }

        @Override // androidx.browser.customtabs.EngagementSignalsCallback
        public void onGreatestScrollPercentageIncreased(int i, Bundle bundle) {
            new Object[]{"pagact scrollPercentage=", Integer.valueOf(i)};
        }

        @Override // androidx.browser.customtabs.EngagementSignalsCallback
        public void onSessionEnded(boolean z, Bundle bundle) {
            new Object[]{"pagact didUserInteract=", Boolean.valueOf(z)};
        }
    }

    public class PAGCustomTabsCallback extends CustomTabsCallback {
        public PAGCustomTabsCallback() {
        }

        @Override // androidx.browser.customtabs.CustomTabsCallback
        public void onNavigationEvent(int i, Bundle bundle) {
            new Object[]{"pagact navigationEvent=", Integer.valueOf(i)};
            if (i == 1) {
                AdActAction.this.DX = Long.valueOf(SystemClock.elapsedRealtime());
                if (AdActAction.this.WV || AdActAction.this.KZx == null) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("render_type", "h5");
                    jSONObject.putOpt("render_type_2", 0);
                    AdActAction.this.pA("load_start", jSONObject, 0L);
                    AdActAction.this.WV = true;
                    return;
                } catch (Throwable th) {
                    WV.pA("AdActAction", th.getMessage());
                    return;
                }
            }
            if (i == 2) {
                if (AdActAction.this.SGo || AdActAction.this.DX == null || AdActAction.this.KZx == null) {
                    return;
                }
                long jLongValue = AdActAction.this.DX.longValue() - SystemClock.elapsedRealtime();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("first_page", true);
                    jSONObject2.putOpt("render_type", "h5");
                    jSONObject2.putOpt("render_type_2", 0);
                    jSONObject2.put("url", AdActAction.this.ML);
                    jSONObject2.put("preload_h5_type", AdActAction.this.KZx.Bi());
                    AdActAction.this.pA("load_finish", jSONObject2, jLongValue);
                    AdActAction.this.SGo = true;
                    return;
                } catch (Throwable th2) {
                    WV.pA("AdActAction", th2.getMessage());
                    return;
                }
            }
            if (i != 3) {
                if (i != 6) {
                    return;
                }
                AdActAction.this.pA();
                if (AdActAction.this.Wx || AdActAction.this.KZx == null || AdActAction.this.BSW || AdActAction.this.SGo || AdActAction.this.DX == null) {
                    return;
                }
                com.bytedance.sdk.openadsdk.ZZv.KZx.pA(AdActAction.this.KZx, gbA.pA(AdActAction.this.KZx), SystemClock.elapsedRealtime() - AdActAction.this.DX.longValue(), 0, 1);
                return;
            }
            if (AdActAction.this.BSW || AdActAction.this.KZx == null) {
                return;
            }
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.putOpt("render_type", "h5");
                jSONObject3.putOpt("render_type_2", 0);
                jSONObject3.put("url", AdActAction.this.ML);
                jSONObject3.put("preload_h5_type", AdActAction.this.KZx.Bi());
                AdActAction.this.pA(Reporting.EventType.LOAD_FAIL, jSONObject3, 0L);
                AdActAction.this.BSW = true;
            } catch (Throwable th3) {
                WV.pA("AdActAction", th3.getMessage());
            }
        }
    }

    public AdActAction(Context context, yFO yfo, String str, String str2) {
        this.Og = context;
        this.KZx = yfo;
        this.ZZv = str;
        this.ML = str2;
    }

    public void pA(BindCustomTabsServiceCallback bindCustomTabsServiceCallback) {
        this.oX = bindCustomTabsServiceCallback;
        if (this.Og == null || this.KZx == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(pA(8));
            String strPA = pA.pA(this.Og);
            if (strPA == null) {
                return;
            }
            ActServiceConnection actServiceConnection = new ActServiceConnection(this.aBv);
            this.omh = actServiceConnection;
            CustomTabsClient.bindCustomTabsService(this.Og, strPA, actServiceConnection);
        } catch (Throwable th) {
            String message = th.getMessage();
            WV.pA("AdActAction", message);
            BindCustomTabsServiceCallback bindCustomTabsServiceCallback2 = this.oX;
            if (bindCustomTabsServiceCallback2 != null) {
                bindCustomTabsServiceCallback2.onBindFail(10, message);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA() {
        try {
            ActServiceConnection actServiceConnection = this.omh;
            if (actServiceConnection == null) {
                return;
            }
            this.Og.unbindService(actServiceConnection);
            this.JG = null;
            this.SD = null;
            this.omh = null;
        } catch (Throwable th) {
            WV.pA("AdActAction", th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(String str, final JSONObject jSONObject, final long j) {
        if (this.KZx == null || TextUtils.isEmpty(str)) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        yFO yfo = this.KZx;
        com.bytedance.sdk.openadsdk.ZZv.KZx.pA(jCurrentTimeMillis, yfo, gbA.pA(yfo), str, new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.core.act.AdActAction.2
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                JSONObject jSONObject2;
                Throwable th;
                try {
                    jSONObject.put("is_playable", WQf.Og(AdActAction.this.KZx) ? 1 : 0);
                    jSONObject.put("usecache", com.bytedance.sdk.openadsdk.core.Wx.KZx.pA.pA().pA(AdActAction.this.KZx) ? 1 : 0);
                    jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("ad_extra_data", jSONObject.toString());
                        long j2 = j;
                        if (j2 > 0) {
                            jSONObject2.put("duration", j2);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        WV.pA("AdActAction", th.getMessage());
                    }
                } catch (Throwable th3) {
                    jSONObject2 = null;
                    th = th3;
                }
                return jSONObject2;
            }
        });
    }

    private com.bytedance.sdk.openadsdk.Sn.pA.Og pA(int i) {
        com.bytedance.sdk.openadsdk.Sn.pA.Og og = new com.bytedance.sdk.openadsdk.Sn.pA.Og();
        og.pA(this.ZZv);
        og.pA(this.KZx);
        og.Og(gbA.pA(this.KZx));
        og.pA(i);
        og.pA(false);
        og.Og(8);
        return og;
    }
}
