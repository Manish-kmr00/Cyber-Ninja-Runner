package com.mbridge.msdk.video.module.listener.impl;

import com.mbridge.msdk.foundation.entity.CampaignEx;

/* JADX INFO: compiled from: PlayableStatisticsOnNotifyListener.java */
/* JADX INFO: loaded from: classes13.dex */
public class h extends k {
    public h(CampaignEx campaignEx, com.mbridge.msdk.videocommon.download.a aVar, com.mbridge.msdk.videocommon.entity.c cVar, String str, String str2, com.mbridge.msdk.video.module.listener.a aVar2, int i, boolean z) {
        super(campaignEx, aVar, cVar, str, str2, aVar2, i, z);
    }

    @Override // com.mbridge.msdk.video.module.listener.impl.k, com.mbridge.msdk.video.module.listener.impl.f, com.mbridge.msdk.video.module.listener.a
    public void a(int i, Object obj) {
        if (i == 100) {
            j();
            h();
            i();
            b(2);
        } else if (i == 109) {
            a(2);
        } else if (i == 122) {
            g();
        } else if (i != 129) {
            String str = "";
            if (i == 118) {
                if (obj != null && (obj instanceof String)) {
                    str = (String) obj;
                }
                a(3, str);
            } else if (i == 119) {
                if (obj != null && (obj instanceof String)) {
                    str = (String) obj;
                }
                a(4, str);
            }
        } else {
            CampaignEx campaignEx = this.b;
            if (campaignEx != null && campaignEx.getPlayable_ads_without_video() == 2) {
                j();
                h();
                i();
                b(1);
            }
        }
        super.a(i, obj);
    }
}
