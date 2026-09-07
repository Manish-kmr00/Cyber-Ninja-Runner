package com.bytedance.sdk.openadsdk.BF.Og;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.lT;

/* JADX INFO: loaded from: classes13.dex */
public class JG {
    public static boolean pA(View view, int i) {
        return pA(view, false, i);
    }

    public static boolean pA(View view, boolean z, int i) {
        if (view == null) {
            return false;
        }
        return lT.pA(view, z ? 30 : 50, i);
    }
}
