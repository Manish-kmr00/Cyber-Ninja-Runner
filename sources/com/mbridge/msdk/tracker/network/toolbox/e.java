package com.mbridge.msdk.tracker.network.toolbox;

import com.mbridge.msdk.tracker.network.t;

/* JADX INFO: compiled from: DefaultCacheKeyGenerator.java */
/* JADX INFO: loaded from: classes6.dex */
public class e implements com.mbridge.msdk.tracker.network.c {
    @Override // com.mbridge.msdk.tracker.network.c
    public String a(t<?> tVar) {
        String strT = tVar.t();
        int iG = tVar.g();
        return iG == 0 ? strT : Integer.toString(iG) + '-' + strT;
    }
}
