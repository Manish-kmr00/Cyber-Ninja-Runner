package com.bytedance.sdk.openadsdk.Bzk;

import com.bytedance.sdk.component.ML.Bzk;
import com.bytedance.sdk.component.ML.vZF;
import com.json.b9;

/* JADX INFO: loaded from: classes3.dex */
public class ML implements vZF {
    private static int pA;
    private long KZx;
    private final String ML;
    private long Og = 0;
    private boolean ZZv;

    public ML() {
        pA++;
        this.ML = "image_request_" + pA;
    }

    @Override // com.bytedance.sdk.component.ML.vZF
    public void pA(String str, Bzk bzk) {
        if (!this.ZZv) {
            bzk.pA();
            bzk.Og();
            bzk.KZx();
            this.ZZv = true;
        }
        this.Og = System.currentTimeMillis();
        KZx(str, bzk);
    }

    @Override // com.bytedance.sdk.component.ML.vZF
    public void Og(String str, Bzk bzk) {
        this.KZx += System.currentTimeMillis() - this.Og;
        KZx(str, bzk);
    }

    private String KZx(String str, Bzk bzk) {
        com.bytedance.sdk.component.ML.KZx.pA pAVarXT;
        if (str != null) {
            str.hashCode();
            switch (str) {
                case "success":
                    return "success";
                case "raw_cache":
                    return "raw cache";
                case "image_type":
                    return "image type：";
                case "disk_cache":
                    return "disk cache";
                case "decode":
                    return "decode";
                case "failed":
                    if ((bzk instanceof com.bytedance.sdk.component.ML.KZx.KZx) && (pAVarXT = ((com.bytedance.sdk.component.ML.KZx.KZx) bzk).XT()) != null) {
                        Throwable thKZx = pAVarXT.KZx();
                        return "fail：code:" + pAVarXT.pA() + ", msg:" + pAVarXT.Og() + ", exception:" + (thKZx != null ? thKZx.getMessage() : "null \r\n");
                    }
                    return b9.f.e;
                case "check_duplicate":
                    return "duplicate request";
                case "memory_cache":
                    return "memory cache";
                case "net_request":
                    return "net request";
                case "generate_key":
                    return "generate key:" + bzk.ML();
                case "cache_policy":
                    return "cache policy";
            }
        }
        return str;
    }
}
