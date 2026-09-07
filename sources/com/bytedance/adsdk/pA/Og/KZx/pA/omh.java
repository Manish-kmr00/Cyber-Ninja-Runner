package com.bytedance.adsdk.pA.Og.KZx.pA;

import com.bytedance.adsdk.pA.Og.Og.pA.oX;
import java.util.Deque;

/* JADX INFO: loaded from: classes9.dex */
public class omh extends JG {
    @Override // com.bytedance.adsdk.pA.Og.KZx.pA.JG
    public int pA(String str, int i, Deque<com.bytedance.adsdk.pA.Og.Og.pA> deque, com.bytedance.adsdk.pA.Og.KZx.pA pAVar) {
        if (!com.bytedance.adsdk.pA.Og.ML.pA.ZZv(pA(i, str))) {
            return pAVar.pA(str, i, deque);
        }
        int i2 = i + 1;
        String str2 = new String(new char[]{pA(i, str), pA(i2, str)});
        if (com.bytedance.adsdk.pA.Og.ZZv.KZx.pA(str2) != null) {
            deque.push(new oX(com.bytedance.adsdk.pA.Og.ZZv.KZx.pA(str2)));
            return i + 2;
        }
        String strValueOf = String.valueOf(pA(i, str));
        if (com.bytedance.adsdk.pA.Og.ZZv.KZx.pA(strValueOf) != null) {
            deque.push(new oX(com.bytedance.adsdk.pA.Og.ZZv.KZx.pA(strValueOf)));
            return i2;
        }
        throw new IllegalArgumentException("Unrecognized:" + strValueOf + "examine:" + str.substring(0, i));
    }
}
