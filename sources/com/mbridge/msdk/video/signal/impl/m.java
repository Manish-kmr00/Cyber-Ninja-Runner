package com.mbridge.msdk.video.signal.impl;

import com.mbridge.msdk.video.module.MBridgeContainerView;

/* JADX INFO: compiled from: JSContainerModule.java */
/* JADX INFO: loaded from: classes11.dex */
public class m extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MBridgeContainerView f5951a;

    public m(MBridgeContainerView mBridgeContainerView) {
        this.f5951a = mBridgeContainerView;
    }

    @Override // com.mbridge.msdk.video.signal.impl.e, com.mbridge.msdk.video.signal.f
    public void configurationChanged(int i, int i2, int i3) {
        super.configurationChanged(i, i2, i3);
        try {
            MBridgeContainerView mBridgeContainerView = this.f5951a;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.configurationChanged(i, i2, i3);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.mbridge.msdk.video.signal.impl.e, com.mbridge.msdk.video.signal.f
    public boolean endCardShowing() {
        try {
            MBridgeContainerView mBridgeContainerView = this.f5951a;
            if (mBridgeContainerView != null) {
                return mBridgeContainerView.endCardShowing();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return super.endCardShowing();
    }

    @Override // com.mbridge.msdk.video.signal.impl.e, com.mbridge.msdk.video.signal.f
    public void hideAlertWebview() {
        super.hideAlertWebview();
        MBridgeContainerView mBridgeContainerView = this.f5951a;
        if (mBridgeContainerView != null) {
            mBridgeContainerView.hideAlertWebview();
        }
    }

    @Override // com.mbridge.msdk.video.signal.impl.e, com.mbridge.msdk.video.signal.f
    public void ivRewardAdsWithoutVideo(String str) {
        super.ivRewardAdsWithoutVideo(str);
        MBridgeContainerView mBridgeContainerView = this.f5951a;
        if (mBridgeContainerView != null) {
            mBridgeContainerView.ivRewardAdsWithoutVideo(str);
        }
    }

    @Override // com.mbridge.msdk.video.signal.impl.e, com.mbridge.msdk.video.signal.f
    public boolean miniCardShowing() {
        try {
            MBridgeContainerView mBridgeContainerView = this.f5951a;
            if (mBridgeContainerView != null) {
                return mBridgeContainerView.miniCardShowing();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return super.miniCardShowing();
    }

    @Override // com.mbridge.msdk.video.signal.impl.e, com.mbridge.msdk.video.signal.f
    public void readyStatus(int i) {
        try {
            MBridgeContainerView mBridgeContainerView = this.f5951a;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.readyStatus(i);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.readyStatus(i);
    }

    @Override // com.mbridge.msdk.video.signal.impl.e, com.mbridge.msdk.video.signal.f
    public void resizeMiniCard(int i, int i2, int i3) {
        super.resizeMiniCard(i, i2, i3);
        try {
            MBridgeContainerView mBridgeContainerView = this.f5951a;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.resizeMiniCard(i, i2, i3);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.mbridge.msdk.video.signal.impl.e, com.mbridge.msdk.video.signal.f
    public boolean showAlertWebView() {
        super.showAlertWebView();
        MBridgeContainerView mBridgeContainerView = this.f5951a;
        if (mBridgeContainerView != null) {
            return mBridgeContainerView.showAlertWebView();
        }
        return false;
    }

    @Override // com.mbridge.msdk.video.signal.impl.e, com.mbridge.msdk.video.signal.f
    public void showEndcard(int i) {
        super.showEndcard(i);
        try {
            MBridgeContainerView mBridgeContainerView = this.f5951a;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.showEndcard(i);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.mbridge.msdk.video.signal.impl.e, com.mbridge.msdk.video.signal.f
    public void showMiniCard(int i, int i2, int i3, int i4, int i5) {
        super.showMiniCard(i, i2, i3, i4, i5);
        try {
            MBridgeContainerView mBridgeContainerView = this.f5951a;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.showMiniCard(i, i2, i3, i4, i5);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.mbridge.msdk.video.signal.impl.e, com.mbridge.msdk.video.signal.f
    public void showVideoClickView(int i) {
        super.showVideoClickView(i);
        MBridgeContainerView mBridgeContainerView = this.f5951a;
        if (mBridgeContainerView != null) {
            mBridgeContainerView.showVideoClickView(i);
        }
    }

    @Override // com.mbridge.msdk.video.signal.impl.e, com.mbridge.msdk.video.signal.f
    public void showVideoEndCover() {
        super.showVideoEndCover();
        try {
            MBridgeContainerView mBridgeContainerView = this.f5951a;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.showVideoEndCover();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
