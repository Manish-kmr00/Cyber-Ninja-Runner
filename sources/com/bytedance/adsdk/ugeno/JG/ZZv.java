package com.bytedance.adsdk.ugeno.JG;

import java.util.Collection;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* JADX INFO: loaded from: classes14.dex */
public class ZZv {
    public static int pA(boolean z, int i, int i2) {
        if (i2 == 0 || !z) {
            return i;
        }
        int i3 = i - LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        int iAbs = Math.abs(i3) % i2;
        return (i3 >= 0 || iAbs == 0) ? iAbs : i2 - iAbs;
    }

    public static boolean pA(int i, Collection<?> collection) {
        return i >= 0 && i < collection.size();
    }
}
