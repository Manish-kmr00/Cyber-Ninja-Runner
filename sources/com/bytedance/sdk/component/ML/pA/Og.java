package com.bytedance.sdk.component.ML.pA;

import com.bytedance.sdk.component.ML.Bzk;
import com.bytedance.sdk.component.ML.WV;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes6.dex */
public class Og {
    public static WV pA() {
        return new WV() { // from class: com.bytedance.sdk.component.ML.pA.Og.1
            private WeakHashMap<String, String> pA = new WeakHashMap<>();

            @Override // com.bytedance.sdk.component.ML.WV
            public String pA(Bzk bzk) {
                return pA(bzk.pA() + "#width=" + bzk.Og() + "#height=" + bzk.KZx() + "#scaletype=" + bzk.ZZv() + "#bitmapConfig=" + bzk.JG());
            }

            @Override // com.bytedance.sdk.component.ML.WV
            public String Og(Bzk bzk) {
                return pA(bzk.pA());
            }

            private String pA(String str) {
                String str2 = this.pA.get(str);
                if (str2 != null) {
                    return str2;
                }
                String strPA = com.bytedance.sdk.component.ML.KZx.KZx.KZx.pA(str);
                this.pA.put(str, strPA);
                return strPA;
            }
        };
    }
}
