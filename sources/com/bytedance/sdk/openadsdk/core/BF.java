package com.bytedance.sdk.openadsdk.core;

import android.os.Build;
import com.bytedance.sdk.component.embedapplog.PangleEncryptConstant;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BF {
    private static final AtomicInteger KZx;
    private static final AtomicInteger Og;
    private static final AtomicInteger ZZv;
    private static final AtomicInteger pA;

    static {
        AtomicInteger atomicInteger = new AtomicInteger();
        pA = atomicInteger;
        AtomicInteger atomicInteger2 = new AtomicInteger();
        Og = atomicInteger2;
        AtomicInteger atomicInteger3 = new AtomicInteger();
        KZx = atomicInteger3;
        AtomicInteger atomicInteger4 = new AtomicInteger();
        ZZv = atomicInteger4;
        atomicInteger.addAndGet(com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("encrypt_statistics_file", "encrypt_success_count", 0));
        atomicInteger2.addAndGet(com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("encrypt_statistics_file", "encrypt_fail_count", 0));
        atomicInteger3.addAndGet(com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("encrypt_statistics_file", "decrypt_success_count", 0));
        atomicInteger4.addAndGet(com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("encrypt_statistics_file", "decrypt_fail_count", 0));
    }

    public static void pA() {
        try {
            long jPA = com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("encrypt_statistics_file", "upload_time_key", 0L);
            if (jPA <= 0 || System.currentTimeMillis() - jPA < 86400000) {
                if (jPA <= 0 || jPA > System.currentTimeMillis()) {
                    com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("encrypt_statistics_file", "upload_time_key", Long.valueOf(System.currentTimeMillis()));
                    return;
                }
                return;
            }
            Og();
            synchronized (BF.class) {
                pA.set(0);
                Og.set(0);
                KZx.set(0);
                ZZv.set(0);
                com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("encrypt_statistics_file");
                com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("encrypt_statistics_file", "upload_time_key", Long.valueOf(System.currentTimeMillis()));
            }
        } catch (Throwable unused) {
        }
    }

    private static void Og() {
        final int i = pA.get();
        final int i2 = Og.get();
        final int i3 = KZx.get();
        final int i4 = ZZv.get();
        com.bytedance.sdk.openadsdk.Sn.KZx.pA("crypt_v4_statistics", false, new com.bytedance.sdk.openadsdk.Sn.Og() { // from class: com.bytedance.sdk.openadsdk.core.BF.1
            @Override // com.bytedance.sdk.openadsdk.Sn.Og
            public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("encrypt_success_count", i);
                    jSONObject.put("encrypt_fail_count", i2);
                    jSONObject.put("decrypt_success_count", i3);
                    jSONObject.put("decrypt_fail_count", i4);
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.Sn.pA.ZZv.Og().pA("crypt_v4_statistics").Og(jSONObject.toString());
            }
        });
    }

    public static void pA(final int i, final PangleEncryptConstant.CryptDataScene cryptDataScene, final int i2) {
        com.bytedance.sdk.openadsdk.Sn.KZx.pA("crypt_v4_fail", false, new com.bytedance.sdk.openadsdk.Sn.Og() { // from class: com.bytedance.sdk.openadsdk.core.BF.2
            @Override // com.bytedance.sdk.openadsdk.Sn.Og
            public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("crypt", i);
                    jSONObject.put("scene", cryptDataScene.value());
                    jSONObject.put("reason", i2);
                    if (i2 == 6) {
                        jSONObject.put("model", Build.MODEL);
                        jSONObject.put("vendor", Build.MANUFACTURER);
                    }
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.Sn.pA.ZZv.Og().pA("crypt_v4_fail").Og(jSONObject.toString());
            }
        });
    }

    public static synchronized void pA(boolean z) {
        try {
            if (z) {
                com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("encrypt_statistics_file", "decrypt_success_count", Integer.valueOf(KZx.incrementAndGet()));
            } else {
                com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("encrypt_statistics_file", "decrypt_fail_count", Integer.valueOf(KZx.incrementAndGet()));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static void pA(JSONObject jSONObject) {
        Og(jSONObject != null && jSONObject.optInt("cypher") == 4);
    }

    public static synchronized void Og(boolean z) {
        try {
            if (z) {
                com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("encrypt_statistics_file", "encrypt_success_count", Integer.valueOf(pA.incrementAndGet()));
            } else {
                com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("encrypt_statistics_file", "encrypt_fail_count", Integer.valueOf(Og.incrementAndGet()));
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
