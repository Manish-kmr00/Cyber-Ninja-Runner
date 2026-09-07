package com.mbridge.msdk.advanced.request;

import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.tracker.network.g;
import java.util.List;

/* JADX INFO: compiled from: NativeAdvancedLoadResponseHandler.java */
/* JADX INFO: loaded from: classes12.dex */
public abstract class b extends d {
    private int d;

    public b(int i) {
        this.d = i;
    }

    public abstract void a(CampaignUnit campaignUnit, int i);

    @Override // com.mbridge.msdk.advanced.request.d
    public void a(List<Frame> list) {
    }

    @Override // com.mbridge.msdk.advanced.request.d
    public void a(List<g> list, CampaignUnit campaignUnit) {
        a(campaignUnit, this.d);
    }

    public abstract void b(int i, String str);

    @Override // com.mbridge.msdk.advanced.request.d
    public void a(int i, String str) {
        b(i, str);
    }
}
