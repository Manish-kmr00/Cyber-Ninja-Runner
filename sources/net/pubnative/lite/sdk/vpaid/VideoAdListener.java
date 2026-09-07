package net.pubnative.lite.sdk.vpaid;

/* JADX INFO: loaded from: classes7.dex */
public abstract class VideoAdListener {
    public void onAdClicked() {
    }

    public abstract void onAdCustomEndCardFound();

    public void onAdDidReachEnd() {
    }

    public void onAdDismissed() {
    }

    public void onAdDismissed(int i) {
    }

    public void onAdExpired() {
    }

    public abstract void onAdLoadFail(PlayerInfo playerInfo);

    public abstract void onAdLoadSuccess();

    public abstract void onAdSkipped();

    public void onAdStarted() {
    }

    public void onCustomCTACLick(boolean z) {
    }

    public void onCustomCTALoadFail() {
    }

    public void onCustomCTAShow() {
    }

    public void onCustomEndCardClick(String str) {
    }

    public void onCustomEndCardShow(String str) {
    }

    public void onDefaultEndCardClick(String str) {
    }

    public void onDefaultEndCardShow(String str) {
    }

    public void onEndCardClosed(Boolean bool) {
    }

    public void onEndCardLoadFail(Boolean bool) {
    }

    public void onEndCardLoadSuccess(Boolean bool) {
    }

    public void onEndCardSkipped(Boolean bool) {
    }

    public void onLeaveApp() {
    }
}
