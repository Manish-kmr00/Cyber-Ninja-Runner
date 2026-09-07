package com.bytedance.sdk.component.omh;

/* JADX INFO: loaded from: classes11.dex */
public class ML {
    private static SGo pA = new SGo() { // from class: com.bytedance.sdk.component.omh.ML.1
        @Override // com.bytedance.sdk.component.omh.SGo
        public Bzk createThreadFactory(int i, String str) {
            return new Bzk(i, str);
        }
    };

    public static void pA(SGo sGo) {
        pA = sGo;
    }

    public static SGo pA() {
        return pA;
    }
}
