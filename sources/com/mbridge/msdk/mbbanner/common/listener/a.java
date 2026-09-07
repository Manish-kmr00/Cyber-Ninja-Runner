package com.mbridge.msdk.mbbanner.common.listener;

import com.mbridge.msdk.foundation.entity.CampaignEx;

/* JADX INFO: compiled from: BannerBridgeListener.java */
/* JADX INFO: loaded from: classes12.dex */
public interface a {
    void a(CampaignEx campaignEx);

    void a(boolean z);

    void a(boolean z, String str);

    void close();

    void readyStatus(int i);

    void toggleCloseBtn(int i);

    void triggerCloseBtn(String str);
}
