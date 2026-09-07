package com.bytedance.adsdk.pA.Og.KZx.pA;

import com.bytedance.adsdk.pA.Og.Og.pA.TX;
import java.util.Deque;

/* JADX INFO: loaded from: classes8.dex */
public class ZZv extends JG {
    @Override // com.bytedance.adsdk.pA.Og.KZx.pA.JG
    public int pA(String str, int i, Deque<com.bytedance.adsdk.pA.Og.Og.pA> deque, com.bytedance.adsdk.pA.Og.KZx.pA pAVar) {
        if ('(' != pA(i, str)) {
            return pAVar.pA(str, i, deque);
        }
        deque.push(new TX(com.bytedance.adsdk.pA.Og.ZZv.ZZv.LEFT_PAREN));
        return i + 1;
    }
}
