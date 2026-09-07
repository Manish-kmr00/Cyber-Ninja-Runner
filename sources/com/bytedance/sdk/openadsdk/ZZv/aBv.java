package com.bytedance.sdk.openadsdk.ZZv;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import java.util.Iterator;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class aBv implements com.bytedance.sdk.openadsdk.ZZv.ZZv.ML {
    private JSONObject JG;
    private Boolean KZx;
    private Boolean ML;
    private yFO Og;
    private JSONArray SD;
    private Boolean ZZv;
    private JSONArray omh;
    private String pA;

    public aBv(int i, String str, yFO yfo) {
        this.pA = "embeded_ad";
        this.KZx = Boolean.FALSE;
        this.ZZv = Boolean.FALSE;
        this.ML = Boolean.FALSE;
        this.pA = str;
        this.Og = yfo;
        this.JG = new JSONObject();
        this.SD = new JSONArray();
        this.omh = new JSONArray();
        pA(this.JG, "webview_source", Integer.valueOf(i));
    }

    protected aBv() {
        this.pA = "embeded_ad";
        this.KZx = Boolean.FALSE;
        this.ZZv = Boolean.FALSE;
        this.ML = Boolean.FALSE;
    }

    @Override // com.bytedance.sdk.openadsdk.ZZv.ZZv.ZZv
    public void pA() {
        com.bytedance.sdk.component.utils.SD.pA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.ZZv.aBv.1
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                aBv.this.pA(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                aBv abv = aBv.this;
                abv.pA(jSONObject, "render_sequence", Integer.valueOf(abv.Og.du()));
                if (aBv.this.Og != null) {
                    if (aBv.this.Og.CIG() != null) {
                        if (aBv.this.Og.CIG().Sn()) {
                            aBv.this.pA(jSONObject, "webview_count", Integer.valueOf(com.bytedance.sdk.component.adexpress.ML.ML.pA().ZZv()));
                            aBv.this.pA(jSONObject, "available_cache_count", Integer.valueOf(com.bytedance.sdk.component.adexpress.ML.ML.pA().ZZv()));
                        } else {
                            aBv.this.pA(jSONObject, "webview_count", Integer.valueOf(com.bytedance.sdk.component.adexpress.ML.ML.pA().KZx()));
                            aBv.this.pA(jSONObject, "available_cache_count", Integer.valueOf(com.bytedance.sdk.component.adexpress.ML.ML.pA().KZx()));
                        }
                    } else if (aBv.this.Og.FQ() != null) {
                        aBv.this.pA(jSONObject, "webview_count", Integer.valueOf(com.bytedance.sdk.component.adexpress.ML.ML.pA().ZZv()));
                        aBv.this.pA(jSONObject, "available_cache_count", Integer.valueOf(com.bytedance.sdk.component.adexpress.ML.ML.pA().ZZv()));
                    }
                }
                aBv abv2 = aBv.this;
                abv2.pA(abv2.JG, "render_start", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ZZv.ZZv.ZZv
    public void Og() {
        com.bytedance.sdk.component.utils.SD.pA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.ZZv.aBv.12
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                aBv.this.pA(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                aBv abv = aBv.this;
                abv.pA(abv.JG, "render_success", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ZZv.ZZv.ZZv
    public void pA(final int i, final String str) {
        com.bytedance.sdk.component.utils.SD.pA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.ZZv.aBv.23
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                aBv.this.pA(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                aBv.this.pA(jSONObject, "code", Integer.valueOf(i));
                String str2 = str;
                if (str2 != null) {
                    aBv.this.pA(jSONObject, "reason", str2);
                }
                aBv abv = aBv.this;
                abv.pA(abv.JG, Reporting.EventType.RENDER_ERROR, jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ZZv.ZZv.Og
    public void KZx() {
        com.bytedance.sdk.component.utils.SD.pA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.ZZv.aBv.25
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                aBv.this.pA(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                aBv abv = aBv.this;
                abv.pA(abv.JG, "native_render_start", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ZZv.ZZv.KZx
    public void ZZv() {
        com.bytedance.sdk.component.utils.SD.pA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.ZZv.aBv.26
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                aBv.this.pA(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                aBv abv = aBv.this;
                abv.pA(abv.JG, "native_render_end", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ZZv.ZZv.JG
    public void ML() {
        com.bytedance.sdk.component.utils.SD.pA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.ZZv.aBv.27
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                aBv.this.pA(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                aBv abv = aBv.this;
                abv.pA(abv.JG, "webview_load_start", (Object) jSONObject, false);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ZZv.ZZv.JG
    public void JG() {
        com.bytedance.sdk.component.utils.SD.pA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.ZZv.aBv.28
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                aBv.this.pA(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                aBv abv = aBv.this;
                abv.pA(abv.JG, "webview_load_success", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ZZv.ZZv.JG
    public void pA(final JSONObject jSONObject) {
        com.bytedance.sdk.component.utils.SD.pA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.ZZv.aBv.29
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject2 = jSONObject;
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                aBv.this.pA(jSONObject2, "ts", Long.valueOf(System.currentTimeMillis()));
                aBv abv = aBv.this;
                abv.pA(abv.JG, "webview_load_error", jSONObject2);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ZZv.ZZv.KZx
    public void SD() {
        com.bytedance.sdk.component.utils.SD.pA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.ZZv.aBv.30
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                aBv.this.pA(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                aBv abv = aBv.this;
                abv.pA(abv.JG, "native_endcard_show", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ZZv.ZZv.KZx
    public void omh() {
        com.bytedance.sdk.component.utils.SD.pA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.ZZv.aBv.2
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                aBv.this.pA(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                aBv abv = aBv.this;
                abv.pA(abv.JG, "native_endcard_close", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ZZv.ZZv.KZx
    public void Bzk() {
        com.bytedance.sdk.component.utils.SD.pA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.ZZv.aBv.3
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                aBv.this.pA(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                aBv.this.pA(jSONObject, "type", "native_enterBackground");
                aBv abv = aBv.this;
                abv.pA(abv.SD, jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ZZv.ZZv.KZx
    public void SGo() {
        com.bytedance.sdk.component.utils.SD.pA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.ZZv.aBv.4
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                aBv.this.pA(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                aBv.this.pA(jSONObject, "type", "native_enterForeground");
                aBv abv = aBv.this;
                abv.pA(abv.SD, jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ZZv.ZZv.JG
    public void pA(final String str, final long j, final long j2, final int i) {
        com.bytedance.sdk.component.utils.SD.pA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.ZZv.aBv.5
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(str) || j2 < j) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                aBv.this.pA(jSONObject, "start_ts", Long.valueOf(j));
                aBv.this.pA(jSONObject, "end_ts", Long.valueOf(j2));
                aBv.this.pA(jSONObject, "intercept_type", Integer.valueOf(i));
                aBv.this.pA(jSONObject, "type", "intercept_html");
                aBv.this.pA(jSONObject, "url", str);
                aBv.this.pA(jSONObject, "duration", Long.valueOf(j2 - j));
                aBv abv = aBv.this;
                abv.pA(abv.omh, jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ZZv.ZZv.JG
    public void Og(final String str, final long j, final long j2, final int i) {
        com.bytedance.sdk.component.utils.SD.pA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.ZZv.aBv.6
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(str) || j2 < j) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                aBv.this.pA(jSONObject, "start_ts", Long.valueOf(j));
                aBv.this.pA(jSONObject, "end_ts", Long.valueOf(j2));
                aBv.this.pA(jSONObject, "intercept_type", Integer.valueOf(i));
                aBv.this.pA(jSONObject, "type", "intercept_js");
                aBv.this.pA(jSONObject, "url", str);
                aBv.this.pA(jSONObject, "duration", Long.valueOf(j2 - j));
                aBv abv = aBv.this;
                abv.pA(abv.omh, jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ZZv.ZZv.JG
    public void pA(final String str) {
        com.bytedance.sdk.component.utils.SD.pA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.ZZv.aBv.7
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                aBv.this.pA(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                aBv.this.pA(jSONObject, "jsb", str);
                aBv abv = aBv.this;
                abv.pA(abv.JG, "webview_jsb_start", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ZZv.ZZv.JG
    public void Og(final String str) {
        com.bytedance.sdk.component.utils.SD.pA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.ZZv.aBv.8
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                aBv.this.pA(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                aBv.this.pA(jSONObject, "jsb", str);
                aBv abv = aBv.this;
                abv.pA(abv.JG, "webview_jsb_end", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ZZv.ZZv.JG
    public void Og(final JSONObject jSONObject) {
        com.bytedance.sdk.component.utils.SD.pA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.ZZv.aBv.9
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject2;
                if (aBv.this.JG == null || (jSONObject2 = jSONObject) == null) {
                    return;
                }
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    aBv abv = aBv.this;
                    abv.pA(abv.JG, next, jSONObject.opt(next));
                }
                aBv.this.ZZv = Boolean.TRUE;
                aBv.this.WV();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ZZv.ZZv.ML
    public void BSW() {
        this.KZx = Boolean.TRUE;
    }

    @Override // com.bytedance.sdk.openadsdk.ZZv.ZZv.ML
    public void pA(boolean z) {
        this.ML = Boolean.valueOf(z);
    }

    @Override // com.bytedance.sdk.openadsdk.ZZv.ZZv.ML
    public void WV() {
        com.bytedance.sdk.component.utils.SD.pA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.ZZv.aBv.10
            @Override // java.lang.Runnable
            public void run() {
                if (aBv.this.aBv()) {
                    if (aBv.this.SD != null && aBv.this.SD.length() != 0) {
                        try {
                            aBv.this.JG.put("native_switchBackgroundAndForeground", aBv.this.SD);
                        } catch (Exception unused) {
                        }
                    }
                    if (aBv.this.omh != null && aBv.this.omh.length() != 0) {
                        try {
                            aBv.this.JG.put("intercept_source", aBv.this.omh);
                        } catch (Exception unused2) {
                        }
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("webview_time_track", aBv.this.JG);
                    } catch (JSONException e) {
                        com.bytedance.sdk.component.utils.WV.pA("WebviewTimeTrack", "trySendTrackInfo json error", e);
                    }
                    if (com.bytedance.sdk.openadsdk.core.Bzk.Og().aBv() && aBv.this.JG != null) {
                        JSONObject unused3 = aBv.this.JG;
                    }
                    KZx.Og(aBv.this.Og, aBv.this.pA, "webview_time_track", jSONObject);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aBv() {
        if (this.ML.booleanValue()) {
            return true;
        }
        return this.ZZv.booleanValue() && this.KZx.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(JSONObject jSONObject, String str, Object obj, boolean z) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (!z) {
            try {
                if (jSONObject.has(str)) {
                    return;
                }
            } catch (Exception unused) {
                return;
            }
        }
        jSONObject.put(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(JSONObject jSONObject, String str, Object obj) {
        pA(jSONObject, str, obj, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(JSONArray jSONArray, Object obj) {
        if (jSONArray == null || jSONArray.length() >= 10) {
            return;
        }
        try {
            jSONArray.put(obj);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ZZv.ZZv.pA
    public void KZx(final String str) {
        com.bytedance.sdk.component.utils.SD.pA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.ZZv.aBv.11
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                aBv.this.pA(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                aBv abv = aBv.this;
                abv.pA(abv.JG, str, jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ZZv.ZZv.pA
    public void Og(final int i, final String str) {
        com.bytedance.sdk.component.utils.SD.pA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.ZZv.aBv.13
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                aBv.this.pA(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                aBv.this.pA(jSONObject, "code", Integer.valueOf(i));
                aBv abv = aBv.this;
                abv.pA(abv.JG, str, jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ZZv.ZZv.Og
    public void Wx() {
        com.bytedance.sdk.component.utils.SD.pA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.ZZv.aBv.14
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                aBv.this.pA(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                aBv abv = aBv.this;
                abv.pA(abv.JG, "native_render_end", jSONObject);
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                JSONObject jSONObject2 = new JSONObject();
                aBv.this.pA(jSONObject2, "ts", Long.valueOf(jCurrentTimeMillis2));
                aBv abv2 = aBv.this;
                abv2.pA(abv2.JG, "render_success", jSONObject2);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ZZv.ZZv.Og
    public void Sn() {
        com.bytedance.sdk.component.utils.SD.pA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.ZZv.aBv.15
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                aBv.this.pA(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                aBv abv = aBv.this;
                abv.pA(abv.JG, "no_native_render", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ZZv.ZZv.ZZv
    public void DX() {
        com.bytedance.sdk.component.utils.SD.pA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.ZZv.aBv.16
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                aBv.this.pA(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                aBv abv = aBv.this;
                abv.pA(abv.JG, "render_failed", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ZZv.ZZv.ZZv
    public void oX() {
        try {
            com.bytedance.sdk.component.utils.SD.pA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.ZZv.aBv.17
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    aBv.this.pA(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    aBv abv = aBv.this;
                    abv.pA(abv.JG, "render_did_finish", jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ZZv.ZZv.pA
    public void ZZv(final String str) {
        com.bytedance.sdk.component.utils.SD.pA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.ZZv.aBv.18
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                aBv.this.pA(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                aBv abv = aBv.this;
                abv.pA(abv.JG, str, jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ZZv.ZZv.pA
    public void ML(final String str) {
        try {
            com.bytedance.sdk.component.utils.SD.pA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.ZZv.aBv.19
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    aBv.this.pA(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    aBv abv = aBv.this;
                    abv.pA(abv.JG, str, jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ZZv.ZZv.pA
    public void JG(final String str) {
        try {
            com.bytedance.sdk.component.utils.SD.pA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.ZZv.aBv.20
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    aBv.this.pA(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    aBv abv = aBv.this;
                    abv.pA(abv.JG, str, jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ZZv.ZZv.pA
    public void KZx(final int i, final String str) {
        try {
            com.bytedance.sdk.component.utils.SD.pA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.ZZv.aBv.21
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    aBv.this.pA(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    aBv.this.pA(jSONObject, "code", Integer.valueOf(i));
                    aBv abv = aBv.this;
                    abv.pA(abv.JG, str, jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ZZv.ZZv.pA
    public void SD(final String str) {
        com.bytedance.sdk.component.utils.SD.pA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.ZZv.aBv.22
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                aBv.this.pA(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                aBv abv = aBv.this;
                abv.pA(abv.JG, str, jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ZZv.ZZv.JG
    public void pA(final int i) {
        com.bytedance.sdk.component.utils.SD.pA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.ZZv.aBv.24
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                aBv.this.pA(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                aBv.this.pA(jSONObject, "isWebViewCache", Integer.valueOf(i));
                if (aBv.this.Og != null) {
                    if (aBv.this.Og.SzT()) {
                        aBv.this.pA(jSONObject, "engine_version", "v3");
                    } else {
                        aBv.this.pA(jSONObject, "engine_version", "v1");
                    }
                }
                aBv abv = aBv.this;
                abv.pA(abv.JG, "before_webview_request", jSONObject);
            }
        });
    }
}
