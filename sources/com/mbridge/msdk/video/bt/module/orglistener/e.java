package com.mbridge.msdk.video.bt.module.orglistener;

import com.mbridge.msdk.video.bt.module.MBTempContainer;

/* JADX INFO: compiled from: ReportBTContainerErrorListener.java */
/* JADX INFO: loaded from: classes8.dex */
public class e extends MBTempContainer.k.a {
    private h b;
    private com.mbridge.msdk.foundation.same.report.metrics.c c;

    public e(com.mbridge.msdk.foundation.same.report.metrics.c cVar, h hVar) {
        this.b = hVar;
        this.c = cVar;
    }

    @Override // com.mbridge.msdk.video.bt.module.MBTempContainer.k.a, com.mbridge.msdk.video.bt.module.MBTempContainer.k
    public void onError(String str) {
        super.onError(str);
        h hVar = this.b;
        if (hVar != null) {
            hVar.a(this.c, str);
        }
    }
}
