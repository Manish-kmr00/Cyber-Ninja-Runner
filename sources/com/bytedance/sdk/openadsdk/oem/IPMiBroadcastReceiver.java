package com.bytedance.sdk.openadsdk.oem;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.sdk.component.omh.omh;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.ZZv.KZx;
import com.bytedance.sdk.openadsdk.core.Sn;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.BF;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.bytedance.sdk.openadsdk.utils.xy;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class IPMiBroadcastReceiver extends BroadcastReceiver {
    private static volatile IPMiBroadcastReceiver pA;
    private pA KZx;
    private final LruCache<String, yFO> Og;
    private int ZZv = 0;

    private IPMiBroadcastReceiver() {
        int i = 10;
        int iPA = com.bytedance.sdk.openadsdk.vZF.pA.pA("ip_data_config", "ip_ad_cache_count", 10);
        if (iPA > 0 && iPA <= 200) {
            i = iPA;
        }
        new Object[]{"cacheSize=", Integer.valueOf(i)};
        this.Og = new LruCache<>(i);
    }

    public void pA(String str, yFO yfo) {
        if (TextUtils.isEmpty(str) || yfo == null || this.Og.get(str) != null) {
            return;
        }
        this.Og.put(str, yfo);
    }

    public yFO pA(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.Og.get(str);
    }

    public void pA(pA pAVar) {
        this.KZx = pAVar;
    }

    public void pA() {
        this.KZx = null;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, final Intent intent) {
        if ("com.xiaomi.market.DOWNLOAD_INSTALL_RESULT".equals(intent.getAction())) {
            xy.KZx(new omh("ip-mi") { // from class: com.bytedance.sdk.openadsdk.oem.IPMiBroadcastReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    final int i;
                    final int i2;
                    final int i3;
                    try {
                        int intExtra = 0;
                        final int intExtra2 = intent.getIntExtra("errorCode", 0);
                        if (intExtra2 < 0) {
                            int intExtra3 = intent.getIntExtra("reason", 0);
                            if (intExtra2 == -4 && intExtra3 == -1) {
                                return;
                            } else {
                                i = intExtra3;
                            }
                        } else {
                            i = 0;
                        }
                        if (intExtra2 == 5) {
                            int intExtra4 = intent.getIntExtra("status", 0);
                            if (intExtra4 == -2) {
                                try {
                                    intExtra = intent.getIntExtra("progress", 0);
                                } catch (Throwable unused) {
                                    IPMiBroadcastReceiver.this.ZZv = 1;
                                }
                                if (intExtra < 100) {
                                    return;
                                }
                            }
                            i2 = intExtra4;
                            i3 = intExtra;
                        } else {
                            i2 = 0;
                            i3 = 0;
                        }
                        String stringExtra = intent.getStringExtra("packageName");
                        pA pAVar = IPMiBroadcastReceiver.this.KZx;
                        if (intExtra2 > 0 && pAVar != null) {
                            pAVar.pA(stringExtra, intExtra2);
                        }
                        yFO yfoPA = IPMiBroadcastReceiver.this.pA(stringExtra);
                        WV.pA("IPMiBroadcastReceiver", "err_code=", Integer.valueOf(intExtra2), " reason=", Integer.valueOf(i), " status=", Integer.valueOf(i2), " progress=", Integer.valueOf(i3));
                        if (yfoPA != null) {
                            KZx.pA(System.currentTimeMillis(), yfoPA, gbA.pA(yfoPA), "ip_listener_log", new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.oem.IPMiBroadcastReceiver.1.1
                                @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
                                public JSONObject pA() {
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        JSONObject jSONObject2 = new JSONObject();
                                        JSONObject jSONObject3 = new JSONObject();
                                        jSONObject3.put("ip_error_code", intExtra2);
                                        int i4 = intExtra2;
                                        if (i4 > 0) {
                                            if (i4 == 5) {
                                                jSONObject3.put("ip_status", i2);
                                                jSONObject3.put("ip_exec_type", IPMiBroadcastReceiver.this.ZZv);
                                            }
                                            if (i2 == -2) {
                                                jSONObject3.put("ip_progress", i3);
                                            }
                                        }
                                        if (intExtra2 < 0) {
                                            jSONObject3.put("ip_reason", i);
                                        }
                                        jSONObject2.put("pag_json_data", jSONObject3.toString());
                                        jSONObject.put("ad_extra_data", jSONObject2);
                                    } catch (Throwable th) {
                                        WV.pA("IPMiBroadcastReceiver", th.getMessage());
                                    }
                                    return jSONObject;
                                }
                            });
                        }
                    } catch (Throwable th) {
                        WV.pA("IPMiBroadcastReceiver", th.getMessage());
                    }
                }
            });
        }
    }

    public static IPMiBroadcastReceiver pA(Context context) {
        int iPA = com.bytedance.sdk.openadsdk.vZF.pA.pA("ip_data_config", "ip_link_listener", 0);
        WV.pA("IPMiBroadcastReceiver", "open =", Integer.valueOf(iPA));
        if (iPA == 0) {
            return null;
        }
        if (pA == null) {
            synchronized (IPMiBroadcastReceiver.class) {
                if (pA == null) {
                    pA = new IPMiBroadcastReceiver();
                    IntentFilter intentFilter = new IntentFilter("com.xiaomi.market.DOWNLOAD_INSTALL_RESULT");
                    if (Build.VERSION.SDK_INT >= 34 && gbA.SGo(context) >= 34) {
                        context.registerReceiver(pA, intentFilter, 2);
                    } else {
                        context.registerReceiver(pA, intentFilter);
                    }
                }
            }
        }
        return pA;
    }

    public static void pA(final Context context, yFO yfo) {
        BF bfDL;
        if (pA == null && yfo != null && (bfDL = yfo.dL()) != null && bfDL.pA()) {
            Sn.Og().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.oem.IPMiBroadcastReceiver.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        IPMiBroadcastReceiver.pA(aBv.pA(context));
                    } catch (Throwable th) {
                        WV.pA("IPMiBroadcastReceiver", th.getMessage());
                    }
                }
            });
        }
    }
}
