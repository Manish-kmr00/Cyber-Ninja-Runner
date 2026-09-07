package com.bytedance.sdk.openadsdk.core.Bzk;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.Sn.pA.ZZv;
import com.bytedance.sdk.openadsdk.core.Bzk;
import com.bytedance.sdk.openadsdk.core.Sn;
import com.bytedance.sdk.openadsdk.core.WV;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.utils.TX;
import com.pgl.ssdk.ces.out.PglSSConfig;
import com.pgl.ssdk.ces.out.PglSSManager;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
class pA {
    private volatile boolean Og;
    private PglSSManager pA;
    private volatile boolean KZx = true;
    private volatile boolean ZZv = false;

    public pA() {
        pA();
    }

    public synchronized void pA() {
        if (!this.Og) {
            try {
                Context contextPA = aBv.pA();
                String strZZv = Bzk.Og().ZZv();
                if (TextUtils.isEmpty(strZZv)) {
                    strZZv = Bzk.pA("app_id", Long.MAX_VALUE);
                }
                if (TextUtils.isEmpty(strZZv)) {
                    return;
                }
                PglSSManager.init(contextPA, PglSSConfig.builder().setAppId(strZZv).setOVRegionType(0).setAdsdkVersion(BuildConfig.VERSION_NAME).build(), null, null, WV.pA(contextPA), com.bytedance.sdk.openadsdk.XT.pA.Og.pA.pA().Og());
                Bzk();
                this.Og = true;
            } catch (Throwable unused) {
                SGo();
                this.Og = false;
            }
            try {
                if (this.KZx) {
                    KZx(PglSSManager.getLoadError());
                }
            } catch (Throwable th) {
                TX.Og("mssdk", th.getMessage());
            }
        }
    }

    public boolean Og() {
        return this.Og;
    }

    private boolean omh() {
        if (!this.Og && this.KZx) {
            pA();
        }
        return this.Og;
    }

    private void Bzk() {
        if (this.pA == null) {
            this.pA = PglSSManager.getInstance();
        }
    }

    public void pA(String str) {
        if (omh()) {
            Bzk();
            PglSSManager pglSSManager = this.pA;
            if (pglSSManager != null) {
                pglSSManager.setGaid(str);
            }
        }
    }

    public void KZx() {
        if (omh()) {
            Bzk();
            if (this.pA != null) {
                Sn.Og().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Bzk.pA.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            HashMap map = new HashMap();
                            map.put(PglSSConfig.CUSTOMINFO_KEY_CHECKCLAZZ, aBv.ZZv().xkn());
                            pA.this.pA.setCustomInfo(map);
                            new Object[]{"custom info is: ", map};
                        } catch (Throwable th) {
                            TX.Og("MSSdkImpl", "setCustomInfo", th.getMessage());
                        }
                    }
                });
            }
        }
    }

    public void Og(String str) {
        if (omh()) {
            Bzk();
            PglSSManager pglSSManager = this.pA;
            if (pglSSManager != null) {
                pglSSManager.setDeviceId(str);
            }
        }
    }

    public void pA(String str, Map<String, Object> map) {
        if (omh()) {
            Bzk();
            PglSSManager pglSSManager = this.pA;
            if (pglSSManager != null) {
                pglSSManager.reportNow(str, map);
            }
        }
    }

    public String ZZv() {
        if (!omh()) {
            return "";
        }
        Bzk();
        PglSSManager pglSSManager = this.pA;
        return pglSSManager != null ? pglSSManager.getToken() : "";
    }

    public String ML() {
        if (!omh()) {
            return "";
        }
        Bzk();
        PglSSManager pglSSManager = this.pA;
        return pglSSManager != null ? pglSSManager.getSofChara() : "";
    }

    public long JG() {
        if (!omh()) {
            return 0L;
        }
        Bzk();
        PglSSManager pglSSManager = this.pA;
        if (pglSSManager != null) {
            return pglSSManager.getECForBidding();
        }
        return 0L;
    }

    public void pA(MotionEvent motionEvent) {
        if (Og()) {
            Bzk();
            PglSSManager pglSSManager = this.pA;
            if (pglSSManager != null) {
                pglSSManager.checkEventVirtual(motionEvent);
            }
        }
    }

    public int SD() {
        if (this.KZx) {
            return PglSSManager.getInitStatus();
        }
        return 5;
    }

    public Map<String, String> pA(String str, byte[] bArr) {
        Map<String, String> featureHash;
        return (!omh() || (featureHash = this.pA.getFeatureHash(str, bArr)) == null) ? new HashMap() : featureHash;
    }

    private Class SGo() {
        Class<?> cls;
        try {
            cls = Class.forName("com.pgl.ssdk.ces.out.PglSSManager");
            try {
                this.KZx = true;
            } catch (Throwable unused) {
                this.KZx = false;
            }
        } catch (Throwable unused2) {
            cls = null;
        }
        return cls;
    }

    private void KZx(final String str) {
        if (this.ZZv || TextUtils.isEmpty(str)) {
            return;
        }
        aBv.ML().pA(new com.bytedance.sdk.openadsdk.Sn.Og() { // from class: com.bytedance.sdk.openadsdk.core.Bzk.pA.2
            @Override // com.bytedance.sdk.openadsdk.Sn.Og
            public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                return ZZv.Og().pA("secsdk_init_error").Og(str);
            }
        }, false);
        this.ZZv = true;
    }
}
