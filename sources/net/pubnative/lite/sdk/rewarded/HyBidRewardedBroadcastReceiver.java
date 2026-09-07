package net.pubnative.lite.sdk.rewarded;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import java.util.Random;
import net.pubnative.lite.sdk.CustomEndCardListener;
import net.pubnative.lite.sdk.VideoListener;
import net.pubnative.lite.sdk.analytics.Reporting;
import net.pubnative.lite.sdk.rewarded.presenter.RewardedPresenter;
import net.pubnative.lite.sdk.utils.PNLocalBroadcastManager;

/* JADX INFO: loaded from: classes3.dex */
public class HyBidRewardedBroadcastReceiver extends BroadcastReceiver {
    public static final String BROADCAST_ID = "pn_rewarded_broadcastId";
    public static final String VIDEO_PROGRESS = "pn_video_progress";
    private final long mBroadcastId;
    private boolean mDestroyed;
    private final IntentFilter mIntentFilter;
    private Listener mListener;
    private final PNLocalBroadcastManager mLocalBroadcastManager;

    public interface Listener {
        void onReceivedAction(Action action, Bundle bundle);
    }

    public enum Action {
        OPEN("net.pubnative.hybid.rewarded.open"),
        CLICK("net.pubnative.hybid.rewarded.click"),
        CLOSE("net.pubnative.hybid.rewarded.close"),
        ERROR("net.pubnative.hybid.rewarded.error"),
        VIDEO_ERROR("net.pubnative.hybid.rewarded.video_error"),
        VIDEO_START("net.pubnative.hybid.rewarded.video_start"),
        VIDEO_SKIP("net.pubnative.hybid.rewarded.video_skip"),
        VIDEO_DISMISS("net.pubnative.hybid.rewarded.video_dismiss"),
        VIDEO_FINISH("net.pubnative.hybid.rewarded.video_finish"),
        CUSTOM_END_CARD_SHOW("net.pubnative.hybid.rewarded.custom_end_card_show"),
        CUSTOM_END_CARD_CLICK("net.pubnative.hybid.rewarded.custom_end_card_click"),
        DEFAULT_END_CARD_SHOW("net.pubnative.hybid.rewarded.default_end_card_show"),
        DEFAULT_END_CARD_CLICK("net.pubnative.hybid.rewarded.default_end_card_click"),
        END_CARD_LOAD_SUCCESS("net.pubnative.hybid.interstitial.end_card_load_success"),
        END_CARD_LOAD_FAILURE("net.pubnative.hybid.interstitial.end_card_load_failure"),
        NONE("none");

        private final String mId;

        public static Action from(String str) {
            Action action = OPEN;
            if (action.getId().equals(str)) {
                return action;
            }
            Action action2 = CLICK;
            if (action2.getId().equals(str)) {
                return action2;
            }
            Action action3 = CLOSE;
            if (action3.getId().equals(str)) {
                return action3;
            }
            Action action4 = VIDEO_START;
            if (action4.getId().equals(str)) {
                return action4;
            }
            Action action5 = VIDEO_SKIP;
            if (action5.getId().equals(str)) {
                return action5;
            }
            Action action6 = VIDEO_FINISH;
            if (action6.getId().equals(str)) {
                return action6;
            }
            Action action7 = VIDEO_DISMISS;
            if (action7.getId().equals(str)) {
                return action7;
            }
            Action action8 = VIDEO_ERROR;
            if (action8.getId().equals(str)) {
                return action8;
            }
            Action action9 = ERROR;
            if (action9.getId().equals(str)) {
                return action9;
            }
            Action action10 = CUSTOM_END_CARD_SHOW;
            if (action10.getId().equals(str)) {
                return action10;
            }
            Action action11 = CUSTOM_END_CARD_CLICK;
            if (action11.getId().equals(str)) {
                return action11;
            }
            Action action12 = DEFAULT_END_CARD_SHOW;
            if (action12.getId().equals(str)) {
                return action12;
            }
            Action action13 = DEFAULT_END_CARD_CLICK;
            if (action13.getId().equals(str)) {
                return action13;
            }
            Action action14 = END_CARD_LOAD_SUCCESS;
            if (action14.getId().equals(str)) {
                return action14;
            }
            Action action15 = END_CARD_LOAD_FAILURE;
            return action15.getId().equals(str) ? action15 : NONE;
        }

        Action(String str) {
            this.mId = str;
        }

        public String getId() {
            return this.mId;
        }
    }

    public HyBidRewardedBroadcastReceiver(Context context) {
        this(new Random().nextLong(), PNLocalBroadcastManager.getInstance(context), new IntentFilter());
    }

    HyBidRewardedBroadcastReceiver(long j, PNLocalBroadcastManager pNLocalBroadcastManager, IntentFilter intentFilter) {
        this.mBroadcastId = j;
        this.mLocalBroadcastManager = pNLocalBroadcastManager;
        this.mIntentFilter = intentFilter;
        intentFilter.addAction(Action.OPEN.getId());
        intentFilter.addAction(Action.CLICK.getId());
        intentFilter.addAction(Action.CLOSE.getId());
        intentFilter.addAction(Action.VIDEO_START.getId());
        intentFilter.addAction(Action.VIDEO_SKIP.getId());
        intentFilter.addAction(Action.VIDEO_FINISH.getId());
        intentFilter.addAction(Action.VIDEO_DISMISS.getId());
        intentFilter.addAction(Action.VIDEO_ERROR.getId());
        intentFilter.addAction(Action.CUSTOM_END_CARD_SHOW.getId());
        intentFilter.addAction(Action.CUSTOM_END_CARD_CLICK.getId());
        intentFilter.addAction(Action.DEFAULT_END_CARD_SHOW.getId());
        intentFilter.addAction(Action.DEFAULT_END_CARD_CLICK.getId());
        intentFilter.addAction(Action.END_CARD_LOAD_SUCCESS.getId());
        intentFilter.addAction(Action.END_CARD_LOAD_FAILURE.getId());
        intentFilter.addAction(Action.ERROR.getId());
    }

    public void setListener(Listener listener) {
        this.mListener = listener;
    }

    public long getBroadcastId() {
        return this.mBroadcastId;
    }

    public void register() {
        if (this.mDestroyed) {
            return;
        }
        this.mLocalBroadcastManager.registerReceiver(this, this.mIntentFilter);
    }

    public void destroy() {
        this.mLocalBroadcastManager.unregisterReceiver(this);
        this.mDestroyed = true;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.mDestroyed || this.mListener == null) {
            return;
        }
        if (this.mBroadcastId != intent.getLongExtra(BROADCAST_ID, -1L)) {
            return;
        }
        this.mListener.onReceivedAction(Action.from(intent.getAction()), intent.getExtras());
    }

    /* JADX INFO: renamed from: net.pubnative.lite.sdk.rewarded.HyBidRewardedBroadcastReceiver$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$pubnative$lite$sdk$rewarded$HyBidRewardedBroadcastReceiver$Action;

        static {
            int[] iArr = new int[Action.values().length];
            $SwitchMap$net$pubnative$lite$sdk$rewarded$HyBidRewardedBroadcastReceiver$Action = iArr;
            try {
                iArr[Action.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$rewarded$HyBidRewardedBroadcastReceiver$Action[Action.CLICK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$rewarded$HyBidRewardedBroadcastReceiver$Action[Action.CLOSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$rewarded$HyBidRewardedBroadcastReceiver$Action[Action.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$rewarded$HyBidRewardedBroadcastReceiver$Action[Action.VIDEO_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$rewarded$HyBidRewardedBroadcastReceiver$Action[Action.VIDEO_SKIP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$rewarded$HyBidRewardedBroadcastReceiver$Action[Action.VIDEO_DISMISS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$rewarded$HyBidRewardedBroadcastReceiver$Action[Action.VIDEO_FINISH.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$rewarded$HyBidRewardedBroadcastReceiver$Action[Action.CUSTOM_END_CARD_SHOW.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$rewarded$HyBidRewardedBroadcastReceiver$Action[Action.CUSTOM_END_CARD_CLICK.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$rewarded$HyBidRewardedBroadcastReceiver$Action[Action.DEFAULT_END_CARD_SHOW.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$rewarded$HyBidRewardedBroadcastReceiver$Action[Action.DEFAULT_END_CARD_CLICK.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$rewarded$HyBidRewardedBroadcastReceiver$Action[Action.END_CARD_LOAD_SUCCESS.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$rewarded$HyBidRewardedBroadcastReceiver$Action[Action.END_CARD_LOAD_FAILURE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$rewarded$HyBidRewardedBroadcastReceiver$Action[Action.NONE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    public void handleAction(Action action, RewardedPresenter rewardedPresenter, Bundle bundle, RewardedPresenter.Listener listener, VideoListener videoListener, CustomEndCardListener customEndCardListener) {
        if (listener == null) {
        }
        switch (AnonymousClass1.$SwitchMap$net$pubnative$lite$sdk$rewarded$HyBidRewardedBroadcastReceiver$Action[action.ordinal()]) {
            case 1:
                listener.onRewardedOpened(rewardedPresenter);
                break;
            case 2:
                listener.onRewardedClicked(rewardedPresenter);
                break;
            case 3:
                listener.onRewardedFinished(rewardedPresenter);
                listener.onRewardedClosed(rewardedPresenter);
                break;
            case 4:
                listener.onRewardedError(rewardedPresenter);
                break;
            case 5:
                if (videoListener != null) {
                    videoListener.onVideoStarted();
                }
                break;
            case 6:
                if (videoListener != null) {
                    videoListener.onVideoSkipped();
                }
                break;
            case 7:
                if (videoListener != null) {
                    if (bundle != null) {
                        videoListener.onVideoDismissed(bundle.getInt("pn_video_progress", -1));
                    } else {
                        videoListener.onVideoDismissed(-1);
                    }
                }
                break;
            case 8:
                if (videoListener != null) {
                    videoListener.onVideoFinished();
                }
                break;
            case 9:
                if (customEndCardListener != null) {
                    customEndCardListener.onCustomEndCardShow();
                }
                break;
            case 10:
                if (customEndCardListener != null) {
                    customEndCardListener.onCustomEndCardClick();
                }
                break;
            case 11:
                if (customEndCardListener != null) {
                    customEndCardListener.onDefaultEndCardShow();
                }
                break;
            case 12:
                if (customEndCardListener != null) {
                    customEndCardListener.onDefaultEndCardClick();
                }
                break;
            case 13:
                if (customEndCardListener != null) {
                    customEndCardListener.onEndCardLoadSuccess(bundle.getBoolean(Reporting.Key.IS_CUSTOM_END_CARD, false));
                }
                break;
            case 14:
                if (customEndCardListener != null) {
                    customEndCardListener.onEndCardLoadFailure(bundle.getBoolean(Reporting.Key.IS_CUSTOM_END_CARD, false));
                }
                break;
        }
    }
}
