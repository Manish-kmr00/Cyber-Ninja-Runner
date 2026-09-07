package com.bytedance.adsdk.pA.Og.KZx.pA;

import com.bytedance.adsdk.pA.Og.Og.pA.DX;
import java.util.Deque;

/* JADX INFO: loaded from: classes9.dex */
public class SD extends JG {
    private boolean pA(String str, int i, Deque<com.bytedance.adsdk.pA.Og.Og.pA> deque) {
        if ('-' == pA(i, str)) {
            if (deque.peek() != null && !com.bytedance.adsdk.pA.Og.ZZv.KZx.pA(deque.peek().pA())) {
                return false;
            }
            if (com.bytedance.adsdk.pA.Og.ML.pA.KZx(pA(i + 1, str))) {
                return true;
            }
            throw new IllegalArgumentException("Unrecognized - symbol, not a negative number or operator, problem range:" + str.substring(0, i));
        }
        return com.bytedance.adsdk.pA.Og.ML.pA.KZx(pA(i, str));
    }

    @Override // com.bytedance.adsdk.pA.Og.KZx.pA.JG
    public int pA(String str, int i, Deque<com.bytedance.adsdk.pA.Og.Og.pA> deque, com.bytedance.adsdk.pA.Og.KZx.pA pAVar) {
        char cPA;
        if (!pA(str, i, deque)) {
            return pAVar.pA(str, i, deque);
        }
        int i2 = pA(i, str) == '-' ? i + 1 : i;
        boolean z = false;
        while (true) {
            cPA = pA(i2, str);
            if (!com.bytedance.adsdk.pA.Og.ML.pA.KZx(cPA) && (z || cPA != '.')) {
                break;
            }
            i2++;
            if (cPA == '.') {
                z = true;
            }
        }
        if (cPA == '.') {
            throw new IllegalArgumentException("Illegal negative number format, problem interval:" + str.substring(i, i2));
        }
        deque.push(new DX(str.substring(i, i2)));
        return i2;
    }
}
