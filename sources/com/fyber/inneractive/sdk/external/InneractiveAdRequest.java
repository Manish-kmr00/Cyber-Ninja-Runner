package com.fyber.inneractive.sdk.external;

import com.fyber.inneractive.sdk.flow.U;

/* JADX INFO: loaded from: classes12.dex */
public class InneractiveAdRequest extends U {
    public final String c;
    public com.fyber.inneractive.sdk.config.U d;

    public InneractiveAdRequest(String str) {
        this.c = str;
    }

    @Deprecated
    public boolean getMuteVideo() {
        return InneractiveAdManager.getMuteVideo();
    }

    public com.fyber.inneractive.sdk.config.U getSelectedUnitConfig() {
        return this.d;
    }

    public String getSpotId() {
        return this.c;
    }

    @Deprecated
    public InneractiveUserConfig getUserParams() {
        return InneractiveAdManager.getUserParams();
    }

    @Deprecated
    public void setMuteVideo(boolean z) {
        InneractiveAdManager.setMuteVideo(z);
    }

    public void setSelectedUnitConfig(com.fyber.inneractive.sdk.config.U u) {
        this.d = u;
    }

    @Deprecated
    public void setUserParams(InneractiveUserConfig inneractiveUserConfig) {
        InneractiveAdManager.setUserParams(inneractiveUserConfig);
    }
}
