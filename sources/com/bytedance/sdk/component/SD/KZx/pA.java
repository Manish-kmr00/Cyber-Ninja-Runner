package com.bytedance.sdk.component.SD.KZx;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Address;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.TV;
import com.bytedance.sdk.component.utils.aBv;
import com.json.yk;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import com.unity3d.services.UnityAdsConstants;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class pA implements TV.pA {
    private static KZx Bzk;
    private static ThreadPoolExecutor SGo;
    private static boolean omh;
    private int DX;
    private final boolean Og;
    private com.bytedance.sdk.component.SD.pA Sn;
    private final Context WV;
    private volatile boolean KZx = false;
    private boolean ZZv = true;
    private boolean ML = false;
    private long JG = 0;
    private long SD = 0;
    private AtomicBoolean BSW = new AtomicBoolean(false);
    private volatile boolean Wx = false;
    final TV pA = com.bytedance.sdk.component.omh.pA.pA.pA().pA(this, "tt-net");

    public pA(Context context, int i) {
        this.WV = context;
        this.Og = aBv.pA(context);
        this.DX = i;
    }

    public void pA() {
        pA(false);
    }

    public synchronized void pA(boolean z) {
        if (this.Og) {
            ZZv(z);
            return;
        }
        if (this.JG <= 0) {
            try {
                SD().execute(new Runnable() { // from class: com.bytedance.sdk.component.SD.KZx.pA.1
                    @Override // java.lang.Runnable
                    public void run() {
                        pA.this.Og();
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }

    public static void Og(boolean z) {
        omh = z;
    }

    synchronized void Og() {
        if (System.currentTimeMillis() - this.JG > 3600000) {
            this.JG = System.currentTimeMillis();
            try {
                if (omh.pA().pA(this.DX).omh() != null) {
                    omh.pA().pA(this.DX).omh().Og();
                }
            } catch (Exception unused) {
            }
        }
    }

    private void ZZv(boolean z) {
        if (this.ML) {
            return;
        }
        if (this.ZZv) {
            this.ZZv = false;
            this.JG = 0L;
            this.SD = 0L;
        }
        long j = z ? 360000L : 43200000L;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.JG > j) {
            if (jCurrentTimeMillis - this.SD > UnityAdsConstants.Timeout.INIT_TIMEOUT_MS || !this.Wx) {
                KZx();
            }
        }
    }

    public boolean KZx() {
        this.BSW.get();
        SD().execute(new Runnable() { // from class: com.bytedance.sdk.component.SD.KZx.pA.2
            @Override // java.lang.Runnable
            public void run() {
                boolean zPA = com.bytedance.sdk.component.SD.ZZv.ML.pA(pA.this.WV);
                if (zPA) {
                    pA.this.SD = System.currentTimeMillis();
                    if (pA.this.BSW.compareAndSet(false, true)) {
                        pA.this.KZx(zPA);
                    }
                }
            }
        });
        return true;
    }

    @Override // com.bytedance.sdk.component.utils.TV.pA
    public void pA(Message message) {
        int i = message.what;
        if (i == 101) {
            this.ML = false;
            this.JG = System.currentTimeMillis();
            if (this.ZZv) {
                pA();
            }
            this.BSW.set(false);
            return;
        }
        if (i != 102) {
            return;
        }
        this.ML = false;
        if (this.ZZv) {
            pA();
        }
        this.BSW.set(false);
    }

    public synchronized void ZZv() {
        if (this.Wx) {
            return;
        }
        this.Wx = true;
        long j = this.WV.getSharedPreferences("ss_app_config", 0).getLong("last_refresh_time", 0L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (j > jCurrentTimeMillis) {
            j = jCurrentTimeMillis;
        }
        this.JG = j;
        try {
            if (omh.pA().pA(this.DX).omh() != null) {
                omh.pA().pA(this.DX).omh().pA();
            }
        } catch (Exception unused) {
        }
    }

    public void ML() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        try {
            if (this.Og) {
                ZZv();
            } else {
                Og();
            }
        } catch (Throwable unused) {
        }
    }

    void KZx(boolean z) {
        ZZv();
        this.ML = true;
        if (!z) {
            this.pA.sendEmptyMessage(102);
            return;
        }
        try {
            omh();
        } catch (Exception unused) {
            this.BSW.set(false);
        }
    }

    public String[] JG() {
        String[] strArrJG = omh.pA().pA(this.DX).ZZv() != null ? omh.pA().pA(this.DX).ZZv().JG() : null;
        return (strArrJG == null || strArrJG.length <= 0) ? new String[0] : strArrJG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pA(Object obj) throws Exception {
        JSONObject jSONObjectJsonObjectInit;
        if (obj instanceof String) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            jSONObjectJsonObjectInit = PangleNetworkBridge.jsonObjectInit(str);
            if (!"success".equals(jSONObjectJsonObjectInit.getString("message"))) {
                return false;
            }
        } else {
            jSONObjectJsonObjectInit = obj instanceof JSONObject ? (JSONObject) obj : null;
        }
        if (jSONObjectJsonObjectInit == null) {
            return false;
        }
        JSONObject jSONObject = jSONObjectJsonObjectInit.getJSONObject("data");
        synchronized (this) {
            SharedPreferences.Editor editorEdit = this.WV.getSharedPreferences("ss_app_config", 0).edit();
            editorEdit.putLong("last_refresh_time", System.currentTimeMillis());
            editorEdit.apply();
        }
        if (omh.pA().pA(this.DX).omh() == null) {
            return true;
        }
        omh.pA().pA(this.DX).omh().pA(jSONObject);
        return true;
    }

    private boolean omh() {
        String[] strArrJG = JG();
        if (strArrJG != null && strArrJG.length != 0) {
            pA(0);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(final int i) {
        String[] strArrJG = JG();
        if (strArrJG == null || strArrJG.length <= i) {
            Og(102);
            return;
        }
        String str = strArrJG[i];
        if (TextUtils.isEmpty(str)) {
            Og(102);
            return;
        }
        try {
            String strPA = pA(str);
            if (TextUtils.isEmpty(strPA)) {
                Og(102);
                return;
            }
            com.bytedance.sdk.component.SD.Og.Og ogKZx = Bzk().KZx();
            ogKZx.Og(strPA);
            pA(ogKZx);
            ogKZx.pA(new com.bytedance.sdk.component.SD.pA.pA() { // from class: com.bytedance.sdk.component.SD.KZx.pA.3
                @Override // com.bytedance.sdk.component.SD.pA.pA
                public void pA(com.bytedance.sdk.component.SD.Og.KZx kZx, com.bytedance.sdk.component.SD.Og og) {
                    JSONObject jSONObjectJsonObjectInit;
                    if (og == null || !og.JG()) {
                        pA.this.pA(i + 1);
                        return;
                    }
                    String string = null;
                    try {
                        jSONObjectJsonObjectInit = PangleNetworkBridge.jsonObjectInit(og.ZZv());
                    } catch (Exception unused) {
                        jSONObjectJsonObjectInit = null;
                    }
                    if (jSONObjectJsonObjectInit == null) {
                        pA.this.pA(i + 1);
                        return;
                    }
                    try {
                        string = jSONObjectJsonObjectInit.getString("message");
                    } catch (Exception unused2) {
                    }
                    if (!"success".equals(string)) {
                        pA.this.pA(i + 1);
                        return;
                    }
                    try {
                        if (pA.this.pA(jSONObjectJsonObjectInit)) {
                            pA.this.Og(101);
                        } else {
                            pA.this.pA(i + 1);
                        }
                    } catch (Exception unused3) {
                    }
                }

                @Override // com.bytedance.sdk.component.SD.pA.pA
                public void pA(com.bytedance.sdk.component.SD.Og.KZx kZx, IOException iOException) {
                    pA.this.pA(i + 1);
                }
            });
        } catch (Throwable th) {
            new StringBuilder("try app config exception: ").append(th);
        }
    }

    private com.bytedance.sdk.component.SD.pA Bzk() {
        if (this.Sn == null) {
            this.Sn = new com.bytedance.sdk.component.SD.pA.C0196pA().pA(10L, TimeUnit.SECONDS).Og(10L, TimeUnit.SECONDS).KZx(10L, TimeUnit.SECONDS).pA();
        }
        return this.Sn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Og(int i) {
        TV tv = this.pA;
        if (tv != null) {
            tv.sendEmptyMessage(i);
        }
    }

    private String pA(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder sb = new StringBuilder("https://");
        sb.append(str).append("/get_domains/v4/");
        return sb.toString();
    }

    private void pA(com.bytedance.sdk.component.SD.Og.Og og) {
        if (og == null) {
            return;
        }
        Address addressPA = omh.pA().pA(this.DX).ZZv() != null ? omh.pA().pA(this.DX).ZZv().pA(this.WV) : null;
        if (addressPA != null && addressPA.hasLatitude() && addressPA.hasLongitude()) {
            og.pA("latitude", new StringBuilder().append(addressPA.getLatitude()).toString());
            og.pA("longitude", new StringBuilder().append(addressPA.getLongitude()).toString());
            String locality = addressPA.getLocality();
            if (!TextUtils.isEmpty(locality)) {
                og.pA(POBConstants.KEY_CITY, Uri.encode(locality));
            }
        }
        if (this.KZx) {
            og.pA("force", "1");
        }
        try {
            og.pA("abi", Build.SUPPORTED_ABIS[0]);
        } catch (Throwable unused) {
        }
        if (omh.pA().pA(this.DX).ZZv() != null) {
            og.pA(yk.SESSION_HISTORY_KEY_AD_ID, new StringBuilder().append(omh.pA().pA(this.DX).ZZv().pA()).toString());
            og.pA("device_platform", omh.pA().pA(this.DX).ZZv().KZx());
            og.pA("channel", omh.pA().pA(this.DX).ZZv().Og());
            og.pA("version_code", new StringBuilder().append(omh.pA().pA(this.DX).ZZv().ZZv()).toString());
            og.pA("custom_info_1", omh.pA().pA(this.DX).ZZv().ML());
        }
    }

    public static ExecutorService SD() {
        KZx kZx = Bzk;
        ExecutorService threadPool = kZx != null ? kZx.getThreadPool() : null;
        if (threadPool != null) {
            return threadPool;
        }
        if (SGo == null) {
            synchronized (pA.class) {
                if (SGo == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue());
                    SGo = threadPoolExecutor;
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
            }
        }
        return SGo;
    }

    public static void pA(KZx kZx) {
        Bzk = kZx;
    }
}
