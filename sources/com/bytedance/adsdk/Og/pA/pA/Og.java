package com.bytedance.adsdk.Og.pA.pA;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class Og {
    private final List<TX> pA = new ArrayList();

    void pA(TX tx) {
        this.pA.add(tx);
    }

    public void pA(Path path) {
        for (int size = this.pA.size() - 1; size >= 0; size--) {
            com.bytedance.adsdk.Og.JG.JG.pA(path, this.pA.get(size));
        }
    }
}
