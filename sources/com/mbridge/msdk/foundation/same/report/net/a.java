package com.mbridge.msdk.foundation.same.report.net;

import android.content.Context;
import com.mbridge.msdk.foundation.same.net.wrapper.c;
import com.mbridge.msdk.foundation.same.net.wrapper.e;

/* JADX INFO: compiled from: ReportRequest.java */
/* JADX INFO: loaded from: classes10.dex */
public class a extends c {
    public a(Context context) {
        super(context);
    }

    @Override // com.mbridge.msdk.foundation.same.net.wrapper.c
    public void addExtraParams(String str, e eVar) {
        super.addExtraParams(str, eVar);
    }

    @Override // com.mbridge.msdk.foundation.same.net.wrapper.c
    protected boolean canTrack() {
        return false;
    }
}
