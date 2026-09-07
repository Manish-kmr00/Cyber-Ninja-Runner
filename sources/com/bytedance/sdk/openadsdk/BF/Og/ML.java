package com.bytedance.sdk.openadsdk.BF.Og;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.model.WQf;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.gbA;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes6.dex */
public class ML {
    private static final Map<Integer, Og> pA = new ConcurrentHashMap();

    public static void pA(View view, yFO yfo, pA pAVar) {
        if (view == null || yfo == null || yfo.bA()) {
            return;
        }
        boolean zKZx = KZx(yfo);
        if (WQf.Og(yfo) && pAVar != null) {
            pAVar.pA = -1;
        }
        pA(pA(view, yfo, zKZx, pAVar));
    }

    private static boolean KZx(yFO yfo) {
        if (yfo == null) {
            return false;
        }
        String strPA = gbA.pA(yfo);
        return ((!"open_ad".equals(strPA) && !"fullscreen_interstitial_ad".equals(strPA) && !"rewarded_video".equals(strPA)) || WQf.Og(yfo) || yfo.aBv() == 5 || yfo.aBv() == 33 || !yFO.ML(yfo) || yfo.Bf() == null) ? false : true;
    }

    private static Og pA(View view, yFO yfo, boolean z, pA pAVar) {
        if (view == null || yfo == null || yfo.nCO() == null) {
            return null;
        }
        Integer numOg = Og(yfo);
        Map<Integer, Og> map = pA;
        if (map.containsKey(numOg)) {
            Og og = map.get(numOg);
            if (og != null) {
                og.pA(view);
            }
            return og;
        }
        Og ogPA = Og.pA(z, numOg, view, yfo, pAVar);
        map.put(numOg, ogPA);
        return ogPA;
    }

    private static void pA(Og og) {
        if (og == null) {
            return;
        }
        og.pA();
    }

    public static void pA(yFO yfo, int i) {
        if (yfo == null || yfo.nCO() == null) {
            return;
        }
        pA(pA.get(Og(yfo)), i);
    }

    public static void pA(Og og, int i) {
        if (og == null) {
            return;
        }
        og.pA(i);
    }

    public static void pA(yFO yfo) {
        if (yfo == null || yfo.nCO() == null) {
            return;
        }
        Integer numOg = Og(yfo);
        Map<Integer, Og> map = pA;
        Og og = map.get(numOg);
        if (og != null) {
            og.SGo();
        }
        Og(numOg);
        if (map.size() <= 0) {
            SD.pA();
        }
    }

    public static Og pA(Integer num) {
        return pA.get(num);
    }

    public static void Og(Integer num) {
        pA.remove(num);
    }

    public static Integer Og(yFO yfo) {
        return Integer.valueOf((yfo.Ij() + yfo.nCO()).hashCode());
    }

    public static class pA {
        public int Og = -1;
        public int pA;

        public pA(int i) {
            this.pA = i;
        }
    }
}
