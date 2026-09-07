package com.mbridge.msdk.video.module.listener.impl;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.video.module.MBridgeContainerView;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.safedk.android.internal.special.SpecialsBridge;

/* JADX INFO: compiled from: ContainerViewDefaultListener.java */
/* JADX INFO: loaded from: classes13.dex */
public class b extends d {
    private MBridgeVideoView n;
    private MBridgeContainerView o;

    public b(MBridgeVideoView mBridgeVideoView, MBridgeContainerView mBridgeContainerView, CampaignEx campaignEx, com.mbridge.msdk.videocommon.entity.c cVar, com.mbridge.msdk.videocommon.download.a aVar, String str, String str2, com.mbridge.msdk.video.module.listener.a aVar2, int i, boolean z) {
        super(campaignEx, aVar, cVar, str, str2, aVar2, i, z);
        this.n = mBridgeVideoView;
        this.o = mBridgeContainerView;
        if (mBridgeVideoView == null || mBridgeContainerView == null) {
            this.f5843a = false;
        }
    }

    @Override // com.mbridge.msdk.video.module.listener.impl.d, com.mbridge.msdk.video.module.listener.impl.k, com.mbridge.msdk.video.module.listener.impl.f, com.mbridge.msdk.video.module.listener.a
    public void a(int i, Object obj) {
        if (this.f5843a) {
            if (i == 8) {
                MBridgeContainerView mBridgeContainerView = this.o;
                if (mBridgeContainerView == null) {
                    MBridgeVideoView mBridgeVideoView = this.n;
                    if (mBridgeVideoView != null) {
                        SpecialsBridge.MBridgeVideoView_showAlertView(mBridgeVideoView);
                    }
                } else if (mBridgeContainerView.showAlertWebView()) {
                    MBridgeVideoView mBridgeVideoView2 = this.n;
                    if (mBridgeVideoView2 != null) {
                        mBridgeVideoView2.alertWebViewShowed();
                    }
                } else {
                    MBridgeVideoView mBridgeVideoView3 = this.n;
                    if (mBridgeVideoView3 != null) {
                        SpecialsBridge.MBridgeVideoView_showAlertView(mBridgeVideoView3);
                    }
                }
            } else if (i == 107) {
                this.o.showVideoClickView(-1);
                this.n.setCover(false);
                this.n.setMiniEndCardState(false);
                SpecialsBridge.MBridgeVideoView_videoOperate(this.n, 1);
            } else if (i == 112) {
                this.n.setCover(true);
                this.n.setMiniEndCardState(true);
                SpecialsBridge.MBridgeVideoView_videoOperate(this.n, 2);
            } else if (i == 115) {
                this.o.resizeMiniCard(this.n.getBorderViewWidth(), this.n.getBorderViewHeight(), this.n.getBorderViewRadius());
            }
        }
        super.a(i, obj);
    }
}
