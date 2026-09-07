package net.pubnative.lite.sdk.interstitial.presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import net.pubnative.lite.sdk.CustomEndCardListener;
import net.pubnative.lite.sdk.VideoListener;
import net.pubnative.lite.sdk.interstitial.HyBidInterstitialBroadcastReceiver;
import net.pubnative.lite.sdk.interstitial.activity.VastInterstitialActivity;
import net.pubnative.lite.sdk.models.Ad;
import net.pubnative.lite.sdk.models.IntegrationType;
import net.pubnative.lite.sdk.utils.CheckUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class VastInterstitialPresenter implements InterstitialPresenter, HyBidInterstitialBroadcastReceiver.Listener {
    private final Ad mAd;
    private final HyBidInterstitialBroadcastReceiver mBroadcastReceiver;
    private final Context mContext;
    private CustomEndCardListener mCustomEndCardListener;
    private IntegrationType mIntegrationType;
    private boolean mIsDestroyed;
    private InterstitialPresenter.Listener mListener;
    private boolean mReady = false;
    private final int mSkipOffset;
    private VideoListener mVideoListener;
    private final String mZoneId;

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, h.C);
        p0.startActivity(p1);
    }

    @Override // net.pubnative.lite.sdk.interstitial.presenter.InterstitialPresenter
    public JSONObject getPlacementParams() {
        return null;
    }

    public VastInterstitialPresenter(Context context, Ad ad, String str, int i, IntegrationType integrationType) {
        this.mContext = context;
        this.mAd = ad;
        this.mZoneId = str;
        this.mSkipOffset = i;
        if (context != null && context.getApplicationContext() != null) {
            HyBidInterstitialBroadcastReceiver hyBidInterstitialBroadcastReceiver = new HyBidInterstitialBroadcastReceiver(context);
            this.mBroadcastReceiver = hyBidInterstitialBroadcastReceiver;
            hyBidInterstitialBroadcastReceiver.setListener(this);
        } else {
            this.mBroadcastReceiver = null;
        }
        this.mIntegrationType = integrationType;
    }

    @Override // net.pubnative.lite.sdk.interstitial.presenter.InterstitialPresenter
    public void setListener(InterstitialPresenter.Listener listener) {
        this.mListener = listener;
    }

    @Override // net.pubnative.lite.sdk.interstitial.presenter.InterstitialPresenter
    public void setVideoListener(VideoListener videoListener) {
        this.mVideoListener = videoListener;
    }

    @Override // net.pubnative.lite.sdk.interstitial.presenter.InterstitialPresenter
    public void setCustomEndCardListener(CustomEndCardListener customEndCardListener) {
        this.mCustomEndCardListener = customEndCardListener;
    }

    @Override // net.pubnative.lite.sdk.interstitial.presenter.InterstitialPresenter
    public Ad getAd() {
        return this.mAd;
    }

    @Override // net.pubnative.lite.sdk.interstitial.presenter.InterstitialPresenter
    public void load() {
        if (CheckUtils.NoThrow.checkArgument(!this.mIsDestroyed, "VastInterstitialPresenter is destroyed")) {
            this.mReady = true;
            InterstitialPresenter.Listener listener = this.mListener;
            if (listener != null) {
                listener.onInterstitialLoaded(this);
            }
        }
    }

    @Override // net.pubnative.lite.sdk.interstitial.presenter.InterstitialPresenter
    public boolean isReady() {
        return this.mReady;
    }

    @Override // net.pubnative.lite.sdk.interstitial.presenter.InterstitialPresenter
    public void show() {
        HyBidInterstitialBroadcastReceiver hyBidInterstitialBroadcastReceiver;
        if (CheckUtils.NoThrow.checkArgument(!this.mIsDestroyed, "VastInterstitialPresenter is destroyed") && (hyBidInterstitialBroadcastReceiver = this.mBroadcastReceiver) != null) {
            hyBidInterstitialBroadcastReceiver.register();
            Intent intent = new Intent(this.mContext, (Class<?>) VastInterstitialActivity.class);
            intent.putExtra("extra_pn_broadcast_id", this.mBroadcastReceiver.getBroadcastId());
            intent.putExtra("extra_pn_zone_id", this.mZoneId);
            intent.putExtra("extra_pn_skip_offset", this.mSkipOffset);
            intent.putExtra("integration_type", this.mIntegrationType.getCode());
            intent.addFlags(268435456);
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(this.mContext, intent);
        }
    }

    @Override // net.pubnative.lite.sdk.interstitial.presenter.InterstitialPresenter
    public void destroy() {
        HyBidInterstitialBroadcastReceiver hyBidInterstitialBroadcastReceiver = this.mBroadcastReceiver;
        if (hyBidInterstitialBroadcastReceiver != null) {
            hyBidInterstitialBroadcastReceiver.destroy();
        }
        this.mListener = null;
        this.mIsDestroyed = true;
        this.mReady = false;
    }

    @Override // net.pubnative.lite.sdk.interstitial.HyBidInterstitialBroadcastReceiver.Listener
    public void onReceivedAction(HyBidInterstitialBroadcastReceiver.Action action, Bundle bundle) {
        this.mBroadcastReceiver.handleAction(action, bundle, this, this.mListener, this.mVideoListener, this.mCustomEndCardListener);
    }
}
