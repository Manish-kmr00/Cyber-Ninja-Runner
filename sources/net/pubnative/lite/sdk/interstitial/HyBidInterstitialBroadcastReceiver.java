package net.pubnative.lite.sdk.interstitial;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import java.util.Random;
import net.pubnative.lite.sdk.CustomEndCardListener;
import net.pubnative.lite.sdk.VideoListener;
import net.pubnative.lite.sdk.analytics.Reporting;
import net.pubnative.lite.sdk.interstitial.presenter.InterstitialPresenter;
import net.pubnative.lite.sdk.utils.PNLocalBroadcastManager;

/* JADX INFO: loaded from: classes10.dex */
public class HyBidInterstitialBroadcastReceiver extends BroadcastReceiver {
    public static final String BROADCAST_ID = "pn_broadcastId";
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
        SHOW("net.pubnative.hybid.interstitial.show"),
        CLICK("net.pubnative.hybid.interstitial.click"),
        DISMISS("net.pubnative.hybid.interstitial.dismiss"),
        ERROR("net.pubnative.hybid.interstitial.error"),
        VIDEO_ERROR("net.pubnative.hybid.interstitial.video_error"),
        VIDEO_START("net.pubnative.hybid.interstitial.video_start"),
        VIDEO_SKIP("net.pubnative.hybid.interstitial.video_skip"),
        VIDEO_DISMISS("net.pubnative.hybid.interstitial.video_dismiss"),
        VIDEO_FINISH("net.pubnative.hybid.interstitial.video_finish"),
        CUSTOM_END_CARD_SHOW("net.pubnative.hybid.interstitial.custom_end_card_show"),
        CUSTOM_END_CARD_CLICK("net.pubnative.hybid.interstitial.custom_end_card_click"),
        DEFAULT_END_CARD_SHOW("net.pubnative.hybid.interstitial.default_end_card_show"),
        DEFAULT_END_CARD_CLICK("net.pubnative.hybid.interstitial.default_end_card_click"),
        END_CARD_LOAD_SUCCESS("net.pubnative.hybid.interstitial.end_card_load_success"),
        END_CARD_LOAD_FAILURE("net.pubnative.hybid.interstitial.end_card_load_failure"),
        NONE("none");

        private final String mId;

        public static Action from(String str) {
            Action action = SHOW;
            if (action.getId().equals(str)) {
                return action;
            }
            Action action2 = CLICK;
            if (action2.getId().equals(str)) {
                return action2;
            }
            Action action3 = DISMISS;
            if (action3.getId().equals(str)) {
                return action3;
            }
            Action action4 = ERROR;
            if (action4.getId().equals(str)) {
                return action4;
            }
            Action action5 = VIDEO_ERROR;
            if (action5.getId().equals(str)) {
                return action5;
            }
            Action action6 = VIDEO_START;
            if (action6.getId().equals(str)) {
                return action6;
            }
            Action action7 = VIDEO_SKIP;
            if (action7.getId().equals(str)) {
                return action7;
            }
            Action action8 = VIDEO_DISMISS;
            if (action8.getId().equals(str)) {
                return action8;
            }
            Action action9 = VIDEO_FINISH;
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

    public HyBidInterstitialBroadcastReceiver(Context context) {
        this(new Random().nextLong(), PNLocalBroadcastManager.getInstance(context), new IntentFilter());
    }

    HyBidInterstitialBroadcastReceiver(long j, PNLocalBroadcastManager pNLocalBroadcastManager, IntentFilter intentFilter) {
        this.mBroadcastId = j;
        this.mLocalBroadcastManager = pNLocalBroadcastManager;
        this.mIntentFilter = intentFilter;
        intentFilter.addAction(Action.SHOW.getId());
        intentFilter.addAction(Action.CLICK.getId());
        intentFilter.addAction(Action.DISMISS.getId());
        intentFilter.addAction(Action.VIDEO_ERROR.getId());
        intentFilter.addAction(Action.VIDEO_START.getId());
        intentFilter.addAction(Action.VIDEO_SKIP.getId());
        intentFilter.addAction(Action.VIDEO_DISMISS.getId());
        intentFilter.addAction(Action.VIDEO_FINISH.getId());
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

    public void handleAction(Action action, Bundle bundle, InterstitialPresenter interstitialPresenter, InterstitialPresenter.Listener listener) {
        handleAction(action, bundle, interstitialPresenter, listener, null, null);
    }

    /* JADX INFO: renamed from: net.pubnative.lite.sdk.interstitial.HyBidInterstitialBroadcastReceiver$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$pubnative$lite$sdk$interstitial$HyBidInterstitialBroadcastReceiver$Action;

        static {
            int[] iArr = new int[Action.values().length];
            $SwitchMap$net$pubnative$lite$sdk$interstitial$HyBidInterstitialBroadcastReceiver$Action = iArr;
            try {
                iArr[Action.SHOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$interstitial$HyBidInterstitialBroadcastReceiver$Action[Action.CLICK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$interstitial$HyBidInterstitialBroadcastReceiver$Action[Action.DISMISS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$interstitial$HyBidInterstitialBroadcastReceiver$Action[Action.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$interstitial$HyBidInterstitialBroadcastReceiver$Action[Action.VIDEO_ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$interstitial$HyBidInterstitialBroadcastReceiver$Action[Action.VIDEO_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$interstitial$HyBidInterstitialBroadcastReceiver$Action[Action.VIDEO_SKIP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$interstitial$HyBidInterstitialBroadcastReceiver$Action[Action.VIDEO_DISMISS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$interstitial$HyBidInterstitialBroadcastReceiver$Action[Action.VIDEO_FINISH.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$interstitial$HyBidInterstitialBroadcastReceiver$Action[Action.CUSTOM_END_CARD_SHOW.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$interstitial$HyBidInterstitialBroadcastReceiver$Action[Action.CUSTOM_END_CARD_CLICK.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$interstitial$HyBidInterstitialBroadcastReceiver$Action[Action.DEFAULT_END_CARD_SHOW.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$interstitial$HyBidInterstitialBroadcastReceiver$Action[Action.DEFAULT_END_CARD_CLICK.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$interstitial$HyBidInterstitialBroadcastReceiver$Action[Action.END_CARD_LOAD_SUCCESS.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$interstitial$HyBidInterstitialBroadcastReceiver$Action[Action.END_CARD_LOAD_FAILURE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$interstitial$HyBidInterstitialBroadcastReceiver$Action[Action.NONE.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    public void handleAction(Action action, Bundle bundle, InterstitialPresenter interstitialPresenter, InterstitialPresenter.Listener listener, VideoListener videoListener, CustomEndCardListener customEndCardListener) {
        if (listener == null) {
        }
        switch (AnonymousClass1.$SwitchMap$net$pubnative$lite$sdk$interstitial$HyBidInterstitialBroadcastReceiver$Action[action.ordinal()]) {
            case 1:
                listener.onInterstitialShown(interstitialPresenter);
                break;
            case 2:
                listener.onInterstitialClicked(interstitialPresenter);
                break;
            case 3:
                listener.onInterstitialDismissed(interstitialPresenter);
                break;
            case 4:
                listener.onInterstitialError(interstitialPresenter);
                break;
            case 5:
                if (videoListener != null) {
                    if (bundle != null) {
                        videoListener.onVideoError(bundle.getInt("pn_video_progress", -1));
                    } else {
                        videoListener.onVideoError(-1);
                    }
                }
                break;
            case 6:
                if (videoListener != null) {
                    videoListener.onVideoStarted();
                }
                break;
            case 7:
                if (videoListener != null) {
                    videoListener.onVideoSkipped();
                }
                break;
            case 8:
                if (videoListener != null) {
                    if (bundle != null) {
                        videoListener.onVideoDismissed(bundle.getInt("pn_video_progress", -1));
                    } else {
                        videoListener.onVideoDismissed(-1);
                    }
                }
                break;
            case 9:
                if (videoListener != null) {
                    videoListener.onVideoFinished();
                }
                break;
            case 10:
                if (customEndCardListener != null) {
                    customEndCardListener.onCustomEndCardShow();
                }
                break;
            case 11:
                if (customEndCardListener != null) {
                    customEndCardListener.onCustomEndCardClick();
                }
                break;
            case 12:
                if (customEndCardListener != null) {
                    customEndCardListener.onDefaultEndCardShow();
                }
                break;
            case 13:
                if (customEndCardListener != null) {
                    customEndCardListener.onDefaultEndCardClick();
                }
                break;
            case 14:
                if (customEndCardListener != null) {
                    customEndCardListener.onEndCardLoadSuccess(bundle.getBoolean(Reporting.Key.IS_CUSTOM_END_CARD, false));
                }
                break;
            case 15:
                if (customEndCardListener != null) {
                    customEndCardListener.onEndCardLoadFailure(bundle.getBoolean(Reporting.Key.IS_CUSTOM_END_CARD, false));
                }
                break;
        }
    }
}
