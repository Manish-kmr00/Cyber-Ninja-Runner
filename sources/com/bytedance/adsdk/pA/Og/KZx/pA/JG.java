package com.bytedance.adsdk.pA.Og.KZx.pA;

import java.util.Deque;

/* JADX INFO: loaded from: classes10.dex */
public abstract class JG {
    public abstract int pA(String str, int i, Deque<com.bytedance.adsdk.pA.Og.Og.pA> deque, com.bytedance.adsdk.pA.Og.KZx.pA pAVar);

    protected char pA(int i, String str) {
        if (i >= str.length()) {
            return (char) 26;
        }
        return str.charAt(i);
    }

    protected int Og(int i, String str) {
        while (com.bytedance.adsdk.pA.Og.ML.pA.pA(pA(i, str))) {
            i++;
        }
        return i;
    }
}
