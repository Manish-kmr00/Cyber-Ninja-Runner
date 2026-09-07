package com.bytedance.sdk.openadsdk.core.Wx.KZx;

import com.bytedance.sdk.component.utils.JG;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class KZx extends com.bytedance.sdk.openadsdk.Og.Og {
    public KZx(int i, int i2) {
        super(i, i2);
    }

    public KZx(int i, int i2, boolean z) {
        super(i, i2);
        this.pA = z;
    }

    @Override // com.bytedance.sdk.openadsdk.Og.Og, com.bytedance.sdk.openadsdk.Og.pA
    protected void pA(List<File> list) {
        int size = list.size();
        if (pA(0L, size)) {
            return;
        }
        for (File file : list) {
            JG.KZx(file);
            size--;
            if (pA(file, 0L, size)) {
                return;
            }
        }
    }
}
