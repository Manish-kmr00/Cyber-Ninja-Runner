package com.bytedance.adsdk.pA.Og.KZx.pA;

import com.bytedance.adsdk.pA.Og.Og.pA.vZF;
import java.util.Deque;

/* JADX INFO: loaded from: classes10.dex */
public class Og extends JG {
    @Override // com.bytedance.adsdk.pA.Og.KZx.pA.JG
    public int pA(String str, int i, Deque<com.bytedance.adsdk.pA.Og.Og.pA> deque, com.bytedance.adsdk.pA.Og.KZx.pA pAVar) {
        if ('\'' != pA(i, str)) {
            return pAVar.pA(str, i, deque);
        }
        int i2 = i + 1;
        int length = str.length();
        int i3 = i2;
        while (i3 < length && pA(i3, str) != '\'') {
            i3++;
        }
        if (pA(i3, str) != '\'') {
            throw new com.bytedance.adsdk.pA.pA.pA("String expression not surrounded by '", str.substring(i));
        }
        deque.push(new vZF(str.substring(i2, i3)));
        return i3 + 1;
    }
}
