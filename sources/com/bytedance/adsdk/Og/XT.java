package com.bytedance.adsdk.Og;

import android.util.Pair;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes7.dex */
public class XT {
    private boolean pA = false;
    private final Set<Object> Og = new pA();
    private final Map<String, com.bytedance.adsdk.Og.JG.ZZv> KZx = new HashMap();
    private final Comparator<Pair<String, Float>> ZZv = new Comparator<Pair<String, Float>>() { // from class: com.bytedance.adsdk.Og.XT.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
        public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float fFloatValue = ((Float) pair.second).floatValue();
            float fFloatValue2 = ((Float) pair2.second).floatValue();
            if (fFloatValue2 > fFloatValue) {
                return 1;
            }
            return fFloatValue > fFloatValue2 ? -1 : 0;
        }
    };

    void pA(boolean z) {
        this.pA = z;
    }

    public void pA(String str, float f) {
        if (this.pA) {
            com.bytedance.adsdk.Og.JG.ZZv zZv = this.KZx.get(str);
            if (zZv == null) {
                zZv = new com.bytedance.adsdk.Og.JG.ZZv();
                this.KZx.put(str, zZv);
            }
            zZv.pA(f);
            if (str.equals("__container")) {
                Iterator<Object> it = this.Og.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    }
}
