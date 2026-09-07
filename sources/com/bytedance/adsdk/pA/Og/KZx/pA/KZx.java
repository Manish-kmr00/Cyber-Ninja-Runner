package com.bytedance.adsdk.pA.Og.KZx.pA;

import com.bytedance.adsdk.pA.Og.Og.pA.BF;
import java.util.Deque;

/* JADX INFO: loaded from: classes12.dex */
public class KZx extends JG {
    @Override // com.bytedance.adsdk.pA.Og.KZx.pA.JG
    public int pA(String str, int i, Deque<com.bytedance.adsdk.pA.Og.Og.pA> deque, com.bytedance.adsdk.pA.Og.KZx.pA pAVar) {
        if (!com.bytedance.adsdk.pA.Og.ML.pA.Og(pA(i, str))) {
            return pAVar.pA(str, i, deque);
        }
        return pA(str, i, deque);
    }

    private int pA(String str, int i, Deque<com.bytedance.adsdk.pA.Og.Og.pA> deque) {
        int i2;
        int i3 = 0;
        while (true) {
            i2 = i3 + i;
            char cPA = pA(i2, str);
            if (!com.bytedance.adsdk.pA.Og.ML.pA.Og(cPA) && !com.bytedance.adsdk.pA.Og.ML.pA.KZx(cPA) && '.' != cPA && '[' != cPA && ']' != cPA && '_' != cPA && '-' != cPA) {
                break;
            }
            i3++;
        }
        String strSubstring = str.substring(i, i2);
        if (com.bytedance.adsdk.pA.Og.ZZv.pA.pA(strSubstring) != null) {
            deque.push(new com.bytedance.adsdk.pA.Og.Og.pA.SD(strSubstring));
        } else {
            deque.push(new BF(strSubstring));
        }
        return i2;
    }
}
