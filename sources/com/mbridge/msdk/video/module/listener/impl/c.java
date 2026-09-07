package com.mbridge.msdk.video.module.listener.impl;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.video.signal.factory.IJSFactory;

/* JADX INFO: compiled from: ContainerViewJSListener.java */
/* JADX INFO: loaded from: classes13.dex */
public class c extends d {
    private IJSFactory n;

    public c(IJSFactory iJSFactory, CampaignEx campaignEx, com.mbridge.msdk.videocommon.entity.c cVar, com.mbridge.msdk.videocommon.download.a aVar, String str, String str2, com.mbridge.msdk.video.module.listener.a aVar2, int i, boolean z) {
        super(campaignEx, aVar, cVar, str, str2, aVar2, i, z);
        this.n = iJSFactory;
        if (iJSFactory == null) {
            this.f5843a = false;
        }
    }

    @Override // com.mbridge.msdk.video.module.listener.impl.d, com.mbridge.msdk.video.module.listener.impl.k, com.mbridge.msdk.video.module.listener.impl.f, com.mbridge.msdk.video.module.listener.a
    public void a(int i, Object obj) {
        if (this.f5843a) {
            if (i != 8) {
                if (i == 105) {
                    this.n.getJSNotifyProxy().a(3, obj.toString());
                    i = -1;
                } else if (i == 107) {
                    this.n.getJSContainerModule().showVideoClickView(-1);
                    this.n.getJSVideoModule().setCover(false);
                    this.n.getJSVideoModule().setMiniEndCardState(false);
                    this.n.getJSVideoModule().videoOperate(1);
                } else if (i == 112) {
                    this.n.getJSVideoModule().setCover(true);
                    this.n.getJSVideoModule().setMiniEndCardState(true);
                    this.n.getJSVideoModule().videoOperate(2);
                } else if (i == 115) {
                    com.mbridge.msdk.video.signal.j jSVideoModule = this.n.getJSVideoModule();
                    this.n.getJSContainerModule().resizeMiniCard(jSVideoModule.getBorderViewWidth(), jSVideoModule.getBorderViewHeight(), jSVideoModule.getBorderViewRadius());
                }
            } else if (this.n.getJSContainerModule().showAlertWebView()) {
                this.n.getJSVideoModule().alertWebViewShowed();
            } else {
                this.n.getJSVideoModule().showAlertView();
            }
        }
        super.a(i, obj);
    }
}
