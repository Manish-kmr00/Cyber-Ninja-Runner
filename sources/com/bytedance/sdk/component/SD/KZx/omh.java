package com.bytedance.sdk.component.SD.KZx;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: loaded from: classes6.dex */
public class omh {
    private static HashMap<Integer, pA> KZx;
    private static HashMap<Integer, JG> Og;
    private static volatile omh pA;

    private omh() {
        Og = new HashMap<>();
        KZx = new HashMap<>();
    }

    public static synchronized omh pA() {
        if (pA == null) {
            synchronized (omh.class) {
                if (pA == null) {
                    pA = new omh();
                }
            }
        }
        return pA;
    }

    public JG pA(int i) {
        JG jg = Og.get(Integer.valueOf(i));
        if (jg != null) {
            return jg;
        }
        JG jg2 = new JG(i);
        Og.put(Integer.valueOf(i), jg2);
        return jg2;
    }

    public pA pA(int i, Context context) {
        pA pAVar = KZx.get(Integer.valueOf(i));
        if (pAVar != null) {
            return pAVar;
        }
        pA pAVar2 = new pA(context, i);
        KZx.put(Integer.valueOf(i), pAVar2);
        return pAVar2;
    }
}
