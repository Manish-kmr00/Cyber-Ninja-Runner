package net.pubnative.lite.sdk.rewarded.presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import net.pubnative.lite.sdk.CustomEndCardListener;
import net.pubnative.lite.sdk.VideoListener;
import net.pubnative.lite.sdk.models.Ad;
import net.pubnative.lite.sdk.rewarded.HyBidRewardedBroadcastReceiver;
import net.pubnative.lite.sdk.rewarded.activity.MraidRewardedActivity;
import net.pubnative.lite.sdk.utils.CheckUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class MraidRewardedPresenter implements RewardedPresenter, HyBidRewardedBroadcastReceiver.Listener {
    private final Ad mAd;
    private final HyBidRewardedBroadcastReceiver mBroadcastReceiver;
    private final Context mContext;
    private boolean mIsDestroyed;
    private RewardedPresenter.Listener mListener;
    private boolean mReady = false;
    private final String mZoneId;

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, h.C);
        p0.startActivity(p1);
    }

    @Override // net.pubnative.lite.sdk.rewarded.presenter.RewardedPresenter
    public JSONObject getPlacementParams() {
        return null;
    }

    @Override // net.pubnative.lite.sdk.rewarded.presenter.RewardedPresenter
    public void setCustomEndCardListener(CustomEndCardListener customEndCardListener) {
    }

    @Override // net.pubnative.lite.sdk.rewarded.presenter.RewardedPresenter
    public void setVideoListener(VideoListener videoListener) {
    }

    public MraidRewardedPresenter(Context context, Ad ad, String str) {
        this.mContext = context;
        this.mAd = ad;
        this.mZoneId = str;
        if (context != null && context.getApplicationContext() != null) {
            HyBidRewardedBroadcastReceiver hyBidRewardedBroadcastReceiver = new HyBidRewardedBroadcastReceiver(context);
            this.mBroadcastReceiver = hyBidRewardedBroadcastReceiver;
            hyBidRewardedBroadcastReceiver.setListener(this);
            return;
        }
        this.mBroadcastReceiver = null;
    }

    @Override // net.pubnative.lite.sdk.rewarded.presenter.RewardedPresenter
    public void setListener(RewardedPresenter.Listener listener) {
        this.mListener = listener;
    }

    @Override // net.pubnative.lite.sdk.rewarded.presenter.RewardedPresenter
    public Ad getAd() {
        return this.mAd;
    }

    @Override // net.pubnative.lite.sdk.rewarded.presenter.RewardedPresenter
    public void load() {
        if (CheckUtils.NoThrow.checkArgument(!this.mIsDestroyed, "VastRewardedPresenter is destroyed")) {
            this.mReady = true;
            RewardedPresenter.Listener listener = this.mListener;
            if (listener != null) {
                listener.onRewardedLoaded(this);
            }
        }
    }

    @Override // net.pubnative.lite.sdk.rewarded.presenter.RewardedPresenter
    public boolean isReady() {
        return this.mReady;
    }

    @Override // net.pubnative.lite.sdk.rewarded.presenter.RewardedPresenter
    public void show() {
        HyBidRewardedBroadcastReceiver hyBidRewardedBroadcastReceiver;
        if (CheckUtils.NoThrow.checkArgument(!this.mIsDestroyed, "VastRewardedPresenter is destroyed") && (hyBidRewardedBroadcastReceiver = this.mBroadcastReceiver) != null) {
            hyBidRewardedBroadcastReceiver.register();
            Intent intent = new Intent(this.mContext, (Class<?>) MraidRewardedActivity.class);
            intent.putExtra("extra_pn_broadcast_id", this.mBroadcastReceiver.getBroadcastId());
            intent.putExtra("extra_pn_zone_id", this.mZoneId);
            intent.addFlags(268435456);
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(this.mContext, intent);
        }
    }

    @Override // net.pubnative.lite.sdk.rewarded.presenter.RewardedPresenter
    public void destroy() {
        HyBidRewardedBroadcastReceiver hyBidRewardedBroadcastReceiver = this.mBroadcastReceiver;
        if (hyBidRewardedBroadcastReceiver != null) {
            hyBidRewardedBroadcastReceiver.destroy();
        }
        this.mListener = null;
        this.mIsDestroyed = true;
        this.mReady = false;
    }

    @Override // net.pubnative.lite.sdk.rewarded.HyBidRewardedBroadcastReceiver.Listener
    public void onReceivedAction(HyBidRewardedBroadcastReceiver.Action action, Bundle bundle) {
        this.mBroadcastReceiver.handleAction(action, this, bundle, this.mListener, null, null);
    }
}
