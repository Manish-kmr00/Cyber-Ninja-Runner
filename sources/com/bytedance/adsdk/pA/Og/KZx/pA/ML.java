package com.bytedance.adsdk.pA.Og.KZx.pA;

import java.util.Deque;

/* JADX INFO: loaded from: classes10.dex */
public class ML extends JG {
    @Override // com.bytedance.adsdk.pA.Og.KZx.pA.JG
    public int pA(String str, int i, Deque<com.bytedance.adsdk.pA.Og.Og.pA> deque, com.bytedance.adsdk.pA.Og.KZx.pA pAVar) {
        char cPA;
        int i2 = i;
        while (true) {
            cPA = pA(i2, str);
            if (!com.bytedance.adsdk.pA.Og.ML.pA.Og(cPA) && !com.bytedance.adsdk.pA.Og.ML.pA.KZx(cPA)) {
                break;
            }
            i2++;
        }
        if (cPA != '(') {
            return pAVar.pA(str, i, deque);
        }
        deque.push(new com.bytedance.adsdk.pA.Og.Og.pA.SGo(str.substring(i, i2)));
        return i2 + 1;
    }
}
