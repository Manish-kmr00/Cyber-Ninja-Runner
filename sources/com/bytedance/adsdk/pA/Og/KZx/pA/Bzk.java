package com.bytedance.adsdk.pA.Og.KZx.pA;

import java.util.Deque;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes11.dex */
public class Bzk extends JG {
    @Override // com.bytedance.adsdk.pA.Og.KZx.pA.JG
    public int pA(String str, int i, Deque<com.bytedance.adsdk.pA.Og.Og.pA> deque, com.bytedance.adsdk.pA.Og.KZx.pA pAVar) {
        com.bytedance.adsdk.pA.Og.Og.pA pAVarPollFirst;
        if (')' != pA(i, str)) {
            return pAVar.pA(str, i, deque);
        }
        LinkedList<com.bytedance.adsdk.pA.Og.Og.pA> linkedList = new LinkedList();
        while (true) {
            pAVarPollFirst = deque.pollFirst();
            if (pAVarPollFirst == null || pAVarPollFirst.pA() == com.bytedance.adsdk.pA.Og.ZZv.Og.METHOD || pAVarPollFirst.pA() == com.bytedance.adsdk.pA.Og.ZZv.ZZv.LEFT_PAREN) {
                break;
            }
            linkedList.addFirst(pAVarPollFirst);
        }
        if (pAVarPollFirst == null) {
            throw new IllegalArgumentException(str.substring(0, i));
        }
        if (pAVarPollFirst.pA() != com.bytedance.adsdk.pA.Og.ZZv.Og.METHOD) {
            deque.push(com.bytedance.adsdk.pA.Og.ML.Og.pA(linkedList, str, i));
            return i + 1;
        }
        com.bytedance.adsdk.pA.Og.Og.pA.SGo sGo = (com.bytedance.adsdk.pA.Og.Og.pA.SGo) pAVarPollFirst;
        LinkedList linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        for (com.bytedance.adsdk.pA.Og.Og.pA pAVar2 : linkedList) {
            if (pAVar2.pA() == com.bytedance.adsdk.pA.Og.ZZv.ZZv.COMMA) {
                linkedList2.add(com.bytedance.adsdk.pA.Og.ML.Og.pA(linkedList3, str, i));
                linkedList3.clear();
            } else {
                linkedList3.addLast(pAVar2);
            }
        }
        if (!linkedList3.isEmpty()) {
            linkedList2.add(com.bytedance.adsdk.pA.Og.ML.Og.pA(linkedList3, str, i));
        }
        sGo.pA((com.bytedance.adsdk.pA.Og.Og.pA[]) linkedList2.toArray(new com.bytedance.adsdk.pA.Og.Og.pA[linkedList2.size()]));
        int i2 = i + 1;
        deque.push(sGo);
        return i2;
    }
}
