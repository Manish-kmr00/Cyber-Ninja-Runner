package com.bytedance.sdk.component.JG.pA.KZx;

import com.bytedance.sdk.component.JG.pA.ML;
import com.bytedance.sdk.component.JG.pA.omh;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes12.dex */
public class Og {
    public static void pA(AtomicLong atomicLong, int i) {
        ML mlOX = omh.SD().oX();
        if (mlOX == null || !mlOX.SD() || atomicLong == null) {
            return;
        }
        atomicLong.getAndAdd(i);
    }
}
