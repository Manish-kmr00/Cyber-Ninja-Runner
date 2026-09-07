package net.pubnative.lite.sdk.vpaid;

import android.view.View;
import com.iab.omid.library.pubnativenet.adsession.FriendlyObstructionPurpose;
import java.util.List;
import net.pubnative.lite.sdk.models.EndCardData;
import net.pubnative.lite.sdk.viewability.HyBidViewabilityFriendlyObstruction;
import net.pubnative.lite.sdk.viewability.HyBidViewabilityNativeVideoAdSession;
import net.pubnative.lite.sdk.vpaid.response.AdParams;

/* JADX INFO: loaded from: classes12.dex */
public interface VideoAdController {

    public interface OnPreparedListener {
        void onPrepared();
    }

    boolean adFinishedPlaying();

    void addEndCardData(EndCardData endCardData);

    void addViewabilityFriendlyObstruction(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str);

    void buildVideoAdView(VideoAdView videoAdView);

    void closeEndCard();

    void closeSelf();

    void destroy();

    void dismiss();

    AdParams getAdParams();

    int getProgress();

    HyBidViewabilityNativeVideoAdSession getViewabilityAdSession();

    List<HyBidViewabilityFriendlyObstruction> getViewabilityFriendlyObstructions();

    boolean isRewarded();

    boolean isVideoVisible();

    void onCustomCTAClick(boolean z);

    void onCustomCTALoadFail();

    void onCustomCTAShow();

    void onCustomEndCardClick(String str);

    void onCustomEndCardShow(String str);

    void onDefaultEndCardClick(String str);

    void onDefaultEndCardShow(String str);

    void onEndCardClosed(Boolean bool);

    void onEndCardLoadFail(Boolean bool);

    void onEndCardLoadSuccess(Boolean bool);

    void openUrl(String str, Boolean bool, Boolean bool2);

    void pause();

    void pauseEndCardCloseButtonTimer();

    void playAd();

    void prepare(OnPreparedListener onPreparedListener);

    void resume();

    void resumeEndCardCloseButtonTimer();

    void setEndCardFilePath(String str);

    void setVideoFilePath(String str);

    void setVideoVisible(boolean z);

    void setVolume(boolean z);

    void skipEndCard();

    void skipVideo();

    void toggleMute();
}
