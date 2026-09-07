package com.bytedance.sdk.openadsdk.ZZv.pA;

/* JADX INFO: loaded from: classes5.dex */
public class pA {
    public static final Og pA = new Og(0);
    public static final Og Og = new Og(1);
    public static final Og KZx = new Og(2);
    public static final Og ZZv = new Og(0);
    public static final Og ML = new Og(1);
    public static final Og JG = new Og(2);

    public static void pA(Og og, boolean z, int i, long j) {
        try {
            og.SD.getAndSet(true);
            if (z) {
                og.pA.incrementAndGet();
                og.KZx.addAndGet(j);
                return;
            }
            og.Og.incrementAndGet();
            Integer num = og.JG.get(Integer.valueOf(i));
            if (num != null) {
                og.JG.put(Integer.valueOf(i), Integer.valueOf(num.intValue() + 1));
            } else {
                og.JG.put(Integer.valueOf(i), 1);
            }
        } catch (Throwable unused) {
        }
    }

    public static void pA(Og og, boolean z) {
        try {
            og.SD.getAndSet(true);
            if (z) {
                og.pA.incrementAndGet();
            } else {
                og.Og.incrementAndGet();
            }
        } catch (Throwable unused) {
        }
    }

    public static void pA(Og og) {
        try {
            og.SD.getAndSet(true);
            og.ML.incrementAndGet();
        } catch (Throwable unused) {
        }
    }

    public static void pA() {
        try {
            Og og = pA;
            if (og.SD.get()) {
                com.bytedance.sdk.openadsdk.multipro.ZZv.pA.pA("tt_sdk_event_net_ad", "tt_sdk_event_net_ad", og.pA().toString());
            }
            Og og2 = Og;
            if (og2.SD.get()) {
                com.bytedance.sdk.openadsdk.multipro.ZZv.pA.pA("tt_sdk_event_net_state", "tt_sdk_event_net_state", og2.pA().toString());
            }
            Og og3 = KZx;
            if (og3.SD.get()) {
                com.bytedance.sdk.openadsdk.multipro.ZZv.pA.pA("tt_sdk_event_net_trail", "tt_sdk_event_net_trail", og3.pA().toString());
            }
            Og og4 = ZZv;
            if (og4.SD.get()) {
                com.bytedance.sdk.openadsdk.multipro.ZZv.pA.pA("tt_sdk_event_db_ad", "tt_sdk_event_db_ad", og4.Og().toString());
            }
            Og og5 = ML;
            if (og5.SD.get()) {
                com.bytedance.sdk.openadsdk.multipro.ZZv.pA.pA("tt_sdk_event_db_state", "tt_sdk_event_db_state", og5.Og().toString());
            }
            Og og6 = JG;
            if (og6.SD.get()) {
                com.bytedance.sdk.openadsdk.multipro.ZZv.pA.pA("tt_sdk_event_db_trail", "tt_sdk_event_db_trail", og6.Og().toString());
            }
        } catch (Throwable unused) {
        }
    }

    public static void Og() {
        try {
            com.bytedance.sdk.openadsdk.Sn.KZx.Og("net_upload_monitor", com.bytedance.sdk.openadsdk.multipro.ZZv.pA.Og("tt_sdk_event_net_ad", "tt_sdk_event_net_ad", ""));
            com.bytedance.sdk.openadsdk.multipro.ZZv.pA.pA("tt_sdk_event_net_ad");
            com.bytedance.sdk.openadsdk.Sn.KZx.Og("net_upload_monitor", com.bytedance.sdk.openadsdk.multipro.ZZv.pA.Og("tt_sdk_event_net_state", "tt_sdk_event_net_state", ""));
            com.bytedance.sdk.openadsdk.multipro.ZZv.pA.pA("tt_sdk_event_net_state");
            com.bytedance.sdk.openadsdk.Sn.KZx.Og("net_upload_monitor", com.bytedance.sdk.openadsdk.multipro.ZZv.pA.Og("tt_sdk_event_net_trail", "tt_sdk_event_net_trail", ""));
            com.bytedance.sdk.openadsdk.multipro.ZZv.pA.pA("tt_sdk_event_net_trail");
            com.bytedance.sdk.openadsdk.Sn.KZx.Og("db_upload_monitor", com.bytedance.sdk.openadsdk.multipro.ZZv.pA.Og("tt_sdk_event_db_ad", "tt_sdk_event_db_ad", ""));
            com.bytedance.sdk.openadsdk.multipro.ZZv.pA.pA("tt_sdk_event_db_ad");
            com.bytedance.sdk.openadsdk.Sn.KZx.Og("db_upload_monitor", com.bytedance.sdk.openadsdk.multipro.ZZv.pA.Og("tt_sdk_event_db_state", "tt_sdk_event_db_state", ""));
            com.bytedance.sdk.openadsdk.multipro.ZZv.pA.pA("tt_sdk_event_db_state");
            com.bytedance.sdk.openadsdk.Sn.KZx.Og("db_upload_monitor", com.bytedance.sdk.openadsdk.multipro.ZZv.pA.Og("tt_sdk_event_db_trail", "tt_sdk_event_db_trail", ""));
            com.bytedance.sdk.openadsdk.multipro.ZZv.pA.pA("tt_sdk_event_db_trail");
        } catch (Throwable unused) {
        }
    }
}
