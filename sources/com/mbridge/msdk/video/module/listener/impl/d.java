package com.mbridge.msdk.video.module.listener.impl;

import android.net.Uri;
import android.text.TextUtils;
import com.json.b9;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* JADX INFO: compiled from: ContainerViewStatisticsListener.java */
/* JADX INFO: loaded from: classes13.dex */
public class d extends k {
    public d(CampaignEx campaignEx, com.mbridge.msdk.videocommon.download.a aVar, com.mbridge.msdk.videocommon.entity.c cVar, String str, String str2, com.mbridge.msdk.video.module.listener.a aVar2, int i, boolean z) {
        super(campaignEx, aVar, cVar, str, str2, aVar2, i, z);
    }

    @Override // com.mbridge.msdk.video.module.listener.impl.k, com.mbridge.msdk.video.module.listener.impl.f, com.mbridge.msdk.video.module.listener.a
    public void a(int i, Object obj) {
        super.a(i, obj);
        if (this.f5843a) {
            try {
                CampaignEx campaignEx = this.b;
                if (campaignEx != null && campaignEx.getDynamicTempCode() == 5) {
                    a(obj.toString());
                }
            } catch (Exception unused) {
            }
            if (i == 105 || i == 106 || i == 113) {
                com.mbridge.msdk.video.module.report.b.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.b);
                if (i != 105) {
                    String noticeUrl = this.b.getNoticeUrl();
                    if (!TextUtils.isEmpty(noticeUrl)) {
                        if (noticeUrl.contains(com.mbridge.msdk.foundation.same.a.m)) {
                            noticeUrl = noticeUrl.replace(com.mbridge.msdk.foundation.same.a.m + "=" + Uri.parse(noticeUrl).getQueryParameter(com.mbridge.msdk.foundation.same.a.m), com.mbridge.msdk.foundation.same.a.m + "=2");
                        } else {
                            noticeUrl = noticeUrl + b9.i.c + com.mbridge.msdk.foundation.same.a.m + "=2";
                        }
                    }
                    com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.b, this.g, noticeUrl, true, false, com.mbridge.msdk.click.retry.a.o);
                }
                return;
            }
            if (i == 122) {
                g();
                return;
            }
            switch (i) {
                case 109:
                    a(2);
                    b(2);
                    break;
                case 110:
                    a(1);
                    b(1);
                    break;
                case 111:
                    b(1);
                    break;
            }
        }
    }
}
