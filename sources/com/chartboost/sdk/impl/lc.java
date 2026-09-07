package com.chartboost.sdk.impl;

import android.view.View;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class lc extends zc {
    public static lc d = new lc();

    public static lc g() {
        return d;
    }

    @Override // com.chartboost.sdk.impl.zc
    public void b(boolean z) {
        Iterator<zb> it = tc.c().b().iterator();
        while (it.hasNext()) {
            it.next().f().a(z);
        }
    }

    @Override // com.chartboost.sdk.impl.zc
    public boolean d() {
        Iterator<zb> it = tc.c().a().iterator();
        while (it.hasNext()) {
            View viewG = it.next().g();
            if (viewG != null && viewG.hasWindowFocus()) {
                return true;
            }
        }
        return false;
    }
}
