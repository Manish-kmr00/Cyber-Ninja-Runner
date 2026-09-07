package com.json;

import com.json.mediationsdk.adunit.adapter.utility.AdInfo;
import com.json.mediationsdk.logger.IronSourceError;
import com.json.mediationsdk.model.Placement;

/* JADX INFO: loaded from: classes9.dex */
public class qj extends l2 {
    @Override // com.json.l2
    public void a(AdInfo adInfo) {
        sg.a().c(adInfo);
    }

    @Override // com.json.l2
    public void a(IronSourceError ironSourceError, AdInfo adInfo) {
        sg.a().a(ironSourceError, adInfo);
    }

    @Override // com.json.l2
    public void a(Placement placement, AdInfo adInfo) {
        sg.a().b(adInfo);
    }

    @Override // com.json.l2
    public void c(AdInfo adInfo) {
        sg.a().e(adInfo);
    }

    @Override // com.json.l2
    public void d(AdInfo adInfo) {
        sg.a().d(adInfo);
    }

    @Override // com.json.l2
    public void g(AdInfo adInfo) {
        sg.a().f(adInfo);
    }
}
