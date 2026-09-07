package com.mbridge.msdk.video.signal.impl;

import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.safedk.android.internal.special.SpecialsBridge;

/* JADX INFO: compiled from: JSVideoModule.java */
/* JADX INFO: loaded from: classes11.dex */
public class q extends r {
    public q(MBridgeVideoView mBridgeVideoView) {
        this.f5954a = mBridgeVideoView;
    }

    @Override // com.mbridge.msdk.video.signal.impl.h, com.mbridge.msdk.video.signal.j
    public void alertWebViewShowed() {
        MBridgeVideoView mBridgeVideoView = this.f5954a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.alertWebViewShowed();
        } else {
            super.alertWebViewShowed();
        }
    }

    @Override // com.mbridge.msdk.video.signal.impl.h, com.mbridge.msdk.video.signal.j
    public void closeVideoOperate(int i, int i2) {
        super.closeVideoOperate(i, i2);
        MBridgeVideoView mBridgeVideoView = this.f5954a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.closeVideoOperate(i, i2);
        }
    }

    @Override // com.mbridge.msdk.video.signal.impl.h, com.mbridge.msdk.video.signal.j
    public void dismissAllAlert() {
        MBridgeVideoView mBridgeVideoView = this.f5954a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.dismissAllAlert();
        } else {
            super.dismissAllAlert();
        }
    }

    @Override // com.mbridge.msdk.video.signal.impl.h, com.mbridge.msdk.video.signal.j
    public int getBorderViewHeight() {
        MBridgeVideoView mBridgeVideoView = this.f5954a;
        return mBridgeVideoView != null ? mBridgeVideoView.getBorderViewHeight() : super.getBorderViewHeight();
    }

    @Override // com.mbridge.msdk.video.signal.impl.h, com.mbridge.msdk.video.signal.j
    public int getBorderViewLeft() {
        MBridgeVideoView mBridgeVideoView = this.f5954a;
        return mBridgeVideoView != null ? mBridgeVideoView.getBorderViewLeft() : super.getBorderViewLeft();
    }

    @Override // com.mbridge.msdk.video.signal.impl.h, com.mbridge.msdk.video.signal.j
    public int getBorderViewRadius() {
        MBridgeVideoView mBridgeVideoView = this.f5954a;
        return mBridgeVideoView != null ? mBridgeVideoView.getBorderViewRadius() : super.getBorderViewRadius();
    }

    @Override // com.mbridge.msdk.video.signal.impl.h, com.mbridge.msdk.video.signal.j
    public int getBorderViewTop() {
        MBridgeVideoView mBridgeVideoView = this.f5954a;
        return mBridgeVideoView != null ? mBridgeVideoView.getBorderViewTop() : super.getBorderViewTop();
    }

    @Override // com.mbridge.msdk.video.signal.impl.h, com.mbridge.msdk.video.signal.j
    public int getBorderViewWidth() {
        MBridgeVideoView mBridgeVideoView = this.f5954a;
        return mBridgeVideoView != null ? mBridgeVideoView.getBorderViewWidth() : super.getBorderViewWidth();
    }

    @Override // com.mbridge.msdk.video.signal.impl.h, com.mbridge.msdk.video.signal.j
    public String getCurrentProgress() {
        MBridgeVideoView mBridgeVideoView = this.f5954a;
        return mBridgeVideoView != null ? mBridgeVideoView.getCurrentProgress() : super.getCurrentProgress();
    }

    @Override // com.mbridge.msdk.video.signal.impl.h, com.mbridge.msdk.video.signal.j
    public void hideAlertView(int i) {
        MBridgeVideoView mBridgeVideoView = this.f5954a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.hideAlertView(i);
        } else {
            super.hideAlertView(i);
        }
    }

    @Override // com.mbridge.msdk.video.signal.impl.h, com.mbridge.msdk.video.signal.j
    public boolean isH5Canvas() {
        MBridgeVideoView mBridgeVideoView = this.f5954a;
        return mBridgeVideoView != null ? mBridgeVideoView.isH5Canvas() : super.isH5Canvas();
    }

    @Override // com.mbridge.msdk.video.signal.impl.h, com.mbridge.msdk.video.signal.j
    public void progressBarOperate(int i) {
        super.progressBarOperate(i);
        MBridgeVideoView mBridgeVideoView = this.f5954a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.progressBarOperate(i);
        }
    }

    @Override // com.mbridge.msdk.video.signal.impl.h, com.mbridge.msdk.video.signal.j
    public void progressOperate(int i, int i2) {
        super.progressOperate(i, i2);
        MBridgeVideoView mBridgeVideoView = this.f5954a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.progressOperate(i, i2);
        }
    }

    @Override // com.mbridge.msdk.video.signal.impl.h, com.mbridge.msdk.video.signal.j
    public void setCover(boolean z) {
        MBridgeVideoView mBridgeVideoView = this.f5954a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.setCover(z);
        } else {
            super.setCover(z);
        }
    }

    @Override // com.mbridge.msdk.video.signal.impl.h, com.mbridge.msdk.video.signal.j
    public void setMiniEndCardState(boolean z) {
        MBridgeVideoView mBridgeVideoView = this.f5954a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.setMiniEndCardState(z);
        } else {
            super.setMiniEndCardState(z);
        }
    }

    @Override // com.mbridge.msdk.video.signal.impl.h, com.mbridge.msdk.video.signal.j
    public void setScaleFitXY(int i) {
        MBridgeVideoView mBridgeVideoView = this.f5954a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.setScaleFitXY(i);
        } else {
            super.setScaleFitXY(i);
        }
    }

    @Override // com.mbridge.msdk.video.signal.impl.h, com.mbridge.msdk.video.signal.j
    public void setVisible(int i) {
        MBridgeVideoView mBridgeVideoView = this.f5954a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.setVisible(i);
        } else {
            super.setVisible(i);
        }
    }

    @Override // com.mbridge.msdk.video.signal.impl.h, com.mbridge.msdk.video.signal.j
    public void showAlertView() {
        MBridgeVideoView mBridgeVideoView = this.f5954a;
        if (mBridgeVideoView != null) {
            SpecialsBridge.MBridgeVideoView_showAlertView(mBridgeVideoView);
        } else {
            super.showAlertView();
        }
    }

    @Override // com.mbridge.msdk.video.signal.impl.h, com.mbridge.msdk.video.signal.j
    public void showIVRewardAlertView(String str) {
        MBridgeVideoView mBridgeVideoView = this.f5954a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.showIVRewardAlertView(str);
        } else {
            super.showIVRewardAlertView(str);
        }
    }

    @Override // com.mbridge.msdk.video.signal.impl.h, com.mbridge.msdk.video.signal.j
    public void showVideoLocation(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        super.showVideoLocation(i, i2, i3, i4, i5, i6, i7, i8, i9);
        MBridgeVideoView mBridgeVideoView = this.f5954a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.showVideoLocation(i, i2, i3, i4, i5, i6, i7, i8, i9);
        }
    }

    @Override // com.mbridge.msdk.video.signal.impl.h, com.mbridge.msdk.video.signal.j
    public void soundOperate(int i, int i2) {
        super.soundOperate(i, i2);
        MBridgeVideoView mBridgeVideoView = this.f5954a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.soundOperate(i, i2);
        }
    }

    @Override // com.mbridge.msdk.video.signal.impl.h, com.mbridge.msdk.video.signal.j
    public void videoOperate(int i) {
        super.videoOperate(i);
        MBridgeVideoView mBridgeVideoView = this.f5954a;
        if (mBridgeVideoView != null) {
            SpecialsBridge.MBridgeVideoView_videoOperate(mBridgeVideoView, i);
        }
    }

    @Override // com.mbridge.msdk.video.signal.impl.h, com.mbridge.msdk.video.signal.j
    public void soundOperate(int i, int i2, String str) {
        super.soundOperate(i, i2, str);
        MBridgeVideoView mBridgeVideoView = this.f5954a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.soundOperate(i, i2, str);
        }
    }
}
