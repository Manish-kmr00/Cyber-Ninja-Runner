package net.pubnative.lite.sdk.vpaid;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.iab.omid.library.pubnativenet.adsession.FriendlyObstructionPurpose;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.internal.partials.VerveVideoBridge;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Vector;
import kotlin.UByte$$ExternalSyntheticBackport0;
import net.pubnative.lite.sdk.HyBid;
import net.pubnative.lite.sdk.analytics.Reporting;
import net.pubnative.lite.sdk.analytics.ReportingEvent;
import net.pubnative.lite.sdk.models.Ad;
import net.pubnative.lite.sdk.models.AdExperience;
import net.pubnative.lite.sdk.models.CustomCTAData;
import net.pubnative.lite.sdk.models.EndCardData;
import net.pubnative.lite.sdk.models.IntegrationType;
import net.pubnative.lite.sdk.presenter.AdPresenter;
import net.pubnative.lite.sdk.utils.AdEndCardManager;
import net.pubnative.lite.sdk.utils.AdTracker;
import net.pubnative.lite.sdk.utils.MediaPlayerErrors;
import net.pubnative.lite.sdk.utils.SkipOffsetManager;
import net.pubnative.lite.sdk.utils.UrlHandler;
import net.pubnative.lite.sdk.viewability.HyBidViewabilityFriendlyObstruction;
import net.pubnative.lite.sdk.viewability.HyBidViewabilityNativeVideoAdSession;
import net.pubnative.lite.sdk.vpaid.enums.EventConstants;
import net.pubnative.lite.sdk.vpaid.enums.VastError;
import net.pubnative.lite.sdk.vpaid.helpers.ErrorLog;
import net.pubnative.lite.sdk.vpaid.helpers.EventTracker;
import net.pubnative.lite.sdk.vpaid.helpers.TimerWithPause;
import net.pubnative.lite.sdk.vpaid.macros.MacroHelper;
import net.pubnative.lite.sdk.vpaid.models.vast.Tracking;
import net.pubnative.lite.sdk.vpaid.models.vpaid.TrackingEvent;
import net.pubnative.lite.sdk.vpaid.response.AdParams;
import net.pubnative.lite.sdk.vpaid.utils.Utils;
import net.pubnative.lite.sdk.vpaid.vast.ViewControllerVast;
import net.pubnative.lite.sdk.vpaid.volume.IVolumeObserver;
import net.pubnative.lite.sdk.vpaid.volume.VolumeObserver;

/* JADX INFO: loaded from: classes11.dex */
class VideoAdControllerVast implements VideoAdController, IVolumeObserver {
    private static final int DELAY_UNTIL_EXECUTE = 100;
    private static final String LOG_TAG = "VideoAdControllerVast";
    private Boolean hasEndcard;
    boolean isAutoClose;
    Boolean isAutoCloseRemoteConfig;
    private boolean isFullscreen;
    private final AdParams mAdParams;
    private final BaseVideoAdInternal mBaseAdInternal;
    private String mImageUri;
    private final AdPresenter.ImpressionListener mImpressionListener;
    private final IntegrationType mIntegrationType;
    private MediaPlayer mMediaPlayer;
    private TimerWithPause mSkipTimerWithPause;
    private TimerWithPause mTimerWithPause;
    private String mVideoUri;
    private final ViewControllerVast mViewControllerVast;
    private final HyBidViewabilityNativeVideoAdSession mViewabilityAdSession;
    private final VolumeObserver observer;
    private boolean videoVisible;
    private final boolean CLOSE_VIDEO_AFTER_FINISH_DEFAULT = false;
    private final boolean CLOSE_VIDEO_AFTER_FINISH_REWARDED_DEFAULT = false;
    private final List<TrackingEvent> mTrackingEventsList = new ArrayList();
    private Boolean isCreativeViewEventsTracked = false;
    private final List<EndCardData> mEndCardsData = new ArrayList();
    private int mSkipTimeMillis = -1;
    private int mDuration = -1;
    private int mDoneMillis = -1;
    private boolean finishedPlaying = false;
    private boolean isImpressionFired = false;
    private boolean isVideoSkipped = false;
    private boolean isVideoCompleted = false;
    private boolean containsStartEvent = false;
    private boolean startFired = false;
    private boolean firstQuartileFired = false;
    private boolean midpointFired = false;
    private boolean thirdQuartileFired = false;
    private Boolean isAndroid6VersionDevice = false;
    private final Map<Action, List<Action>> mPendingActions = new LinkedHashMap();
    private final List<Action> mActions = new Vector();
    private final Handler mActionsProcessingHandler = new Handler(Looper.getMainLooper());
    private Boolean isActionsProcessingRun = false;
    private Action currentAction = Action.INITIAL;
    private Boolean isLastEndCardCustom = false;
    private final MediaPlayer.OnErrorListener mOnErrorListener = new MediaPlayer.OnErrorListener() { // from class: net.pubnative.lite.sdk.vpaid.VideoAdControllerVast.1
        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            if (i2 == MediaPlayerErrors.MEDIA_ERROR_SYSTEM || i2 == MediaPlayerErrors.MEDIA_ERROR_SYSTEM_CALLBACK) {
                return false;
            }
            ErrorLog.postError(VideoAdControllerVast.this.mBaseAdInternal.getContext(), VastError.MEDIA_FILE_UNSUPPORTED);
            VideoAdControllerVast.this.mBaseAdInternal.onAdLoadFailInternal(new PlayerInfo("Error loading media file"));
            return true;
        }
    };
    private final MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() { // from class: net.pubnative.lite.sdk.vpaid.VideoAdControllerVast$$ExternalSyntheticLambda6
        @Override // android.media.MediaPlayer.OnCompletionListener
        public final void onCompletion(MediaPlayer mediaPlayer) {
            Logger.d("Verve|SafeDK: Execution> Lnet/pubnative/lite/sdk/vpaid/VideoAdControllerVast$$ExternalSyntheticLambda6;->onCompletion(Landroid/media/MediaPlayer;)V");
            CreativeInfoManager.onVideoCompleted(h.C, mediaPlayer, "media-player");
            safedk_VideoAdControllerVast$$ExternalSyntheticLambda6_onCompletion_192203f969a006e5b94ab785a2c6b239(mediaPlayer);
        }

        public void safedk_VideoAdControllerVast$$ExternalSyntheticLambda6_onCompletion_192203f969a006e5b94ab785a2c6b239(MediaPlayer p0) {
            this.f$0.m9864lambda$new$2$netpubnativelitesdkvpaidVideoAdControllerVast(p0);
        }
    };
    private final TextureView.SurfaceTextureListener mCreateTextureListener = new TextureView.SurfaceTextureListener() { // from class: net.pubnative.lite.sdk.vpaid.VideoAdControllerVast.4
        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            VerveVideoBridge.MediaPlayerSetSurface(VideoAdControllerVast.this.mMediaPlayer, new Surface(surfaceTexture));
            if (VideoAdControllerVast.this.adFinishedPlaying()) {
                return;
            }
            VideoAdControllerVast.this.resumeAd();
        }
    };
    private final List<HyBidViewabilityFriendlyObstruction> mViewabilityFriendlyObstructions = new ArrayList();
    private final MacroHelper mMacroHelper = new MacroHelper();
    private final AdTracker mCreativeViewEventsTracker = new AdTracker(getAdParams().getCompanionCreativeViewEvents(), null);

    private enum Action {
        PREPARE,
        PLAY,
        PAUSE,
        RESUME,
        INITIAL
    }

    @Override // net.pubnative.lite.sdk.vpaid.VideoAdController
    public void buildVideoAdView(VideoAdView videoAdView) {
        Logger.d("Verve|SafeDK: Execution> Lnet/pubnative/lite/sdk/vpaid/VideoAdControllerVast;->buildVideoAdView(Lnet/pubnative/lite/sdk/vpaid/VideoAdView;)V");
        CreativeInfoManager.onBindView(h.C, this, videoAdView);
        safedk_VideoAdControllerVast_buildVideoAdView_12fb6b75902c35a931574cb33047c4f9(videoAdView);
    }

    VideoAdControllerVast(BaseVideoAdInternal baseVideoAdInternal, AdParams adParams, HyBidViewabilityNativeVideoAdSession hyBidViewabilityNativeVideoAdSession, boolean z, AdPresenter.ImpressionListener impressionListener, AdCloseButtonListener adCloseButtonListener, CustomCTAData customCTAData, Integer num, IntegrationType integrationType) {
        this.videoVisible = false;
        this.isFullscreen = false;
        this.isAutoCloseRemoteConfig = null;
        this.mBaseAdInternal = baseVideoAdInternal;
        this.mAdParams = adParams;
        this.mViewabilityAdSession = hyBidViewabilityNativeVideoAdSession;
        this.mViewControllerVast = new ViewControllerVast(this, z, getEndcardCloseDelay(baseVideoAdInternal), getFullScreenClickability(baseVideoAdInternal), hasReducedCloseSize(baseVideoAdInternal), adCloseButtonListener, customCTAData, num, baseVideoAdInternal.getAd().isBrandAd(), baseVideoAdInternal.getAd().hasHiddenUxControls());
        if (z) {
            this.videoVisible = true;
        }
        this.isFullscreen = z;
        VolumeObserver volumeObserver = VolumeObserver.getInstance();
        this.observer = volumeObserver;
        volumeObserver.registerVolumeObserver(this, baseVideoAdInternal.getContext());
        this.mImpressionListener = impressionListener;
        if (baseVideoAdInternal.getAd().isBrandAd()) {
            this.isAutoClose = false;
        } else {
            if (isRewarded()) {
                this.isAutoClose = false;
                if (baseVideoAdInternal.getAd() != null) {
                    this.isAutoCloseRemoteConfig = baseVideoAdInternal.getAd().needCloseRewardAfterFinish();
                }
            } else {
                this.isAutoClose = false;
                if (baseVideoAdInternal.getAd() != null) {
                    this.isAutoCloseRemoteConfig = baseVideoAdInternal.getAd().needCloseInterAfterFinish();
                }
            }
            Boolean bool = this.isAutoCloseRemoteConfig;
            if (bool != null) {
                this.isAutoClose = bool.booleanValue();
            }
        }
        this.hasEndcard = AdEndCardManager.getDefaultEndCard();
        this.mIntegrationType = integrationType;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001d A[Catch: all -> 0x004e, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x0022, B:10:0x002a, B:12:0x0032, B:14:0x003c, B:16:0x0042, B:17:0x0047, B:7:0x001d), top: B:23:0x0001 }] */
    private synchronized void addAction(Action action) {
        if (this.mActions.isEmpty()) {
            this.mActions.add(action);
        } else {
            List<Action> list = this.mActions;
            if (!list.get(list.size() - 1).equals(action)) {
                this.mActions.add(action);
            }
        }
        if (!this.mPendingActions.isEmpty() && this.mPendingActions.containsKey(action)) {
            List<Action> list2 = this.mPendingActions.get(action);
            if (list2 != null && !list2.isEmpty()) {
                this.mActions.addAll(list2);
            }
            this.mPendingActions.remove(action);
        }
    }

    private synchronized void addPendingAction(Action action, Action action2) {
        if (this.mPendingActions.containsKey(action2) && this.mPendingActions.get(action2) != null) {
            this.mPendingActions.get(action2).add(action);
        } else {
            LinkedList linkedList = new LinkedList();
            linkedList.add(action);
            this.mPendingActions.put(action2, linkedList);
        }
    }

    private synchronized void cancelPendingPauseAction() {
        List<Action> list;
        if (!this.mActions.isEmpty()) {
            List<Action> list2 = this.mActions;
            if (list2.get(list2.size() - 1) == Action.PAUSE) {
                List<Action> list3 = this.mActions;
                list3.remove(list3.size() - 1);
            }
        }
        if (this.mPendingActions.containsKey(Action.PLAY) && (list = this.mPendingActions.get(Action.PLAY)) != null && !list.isEmpty() && list.get(list.size() - 1).equals(Action.PAUSE)) {
            this.mPendingActions.get(Action.PLAY).remove(list.size() - 1);
        }
    }

    private void clearAllActions() {
        this.mActions.clear();
        this.mPendingActions.clear();
    }

    private synchronized void processActions() {
        if (!this.mActions.isEmpty() && !this.isActionsProcessingRun.booleanValue()) {
            this.isActionsProcessingRun = true;
            this.mActionsProcessingHandler.post(new Runnable() { // from class: net.pubnative.lite.sdk.vpaid.VideoAdControllerVast$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m9865x4e8cf2ff();
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$processActions$0$net-pubnative-lite-sdk-vpaid-VideoAdControllerVast, reason: not valid java name */
    /* synthetic */ void m9865x4e8cf2ff() {
        while (!this.mActions.isEmpty()) {
            Action action = this.mActions.get(0);
            executeAction(action);
            this.currentAction = action;
            if (!this.mActions.isEmpty()) {
                this.mActions.remove(0);
            }
            if (!this.mPendingActions.isEmpty() && this.mPendingActions.containsKey(action)) {
                List<Action> list = this.mPendingActions.get(action);
                if (list != null && !list.isEmpty()) {
                    this.mActions.addAll(0, list);
                }
                this.mPendingActions.remove(action);
            }
        }
        this.isActionsProcessingRun = false;
    }

    /* JADX INFO: renamed from: net.pubnative.lite.sdk.vpaid.VideoAdControllerVast$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$net$pubnative$lite$sdk$vpaid$VideoAdControllerVast$Action;

        static {
            int[] iArr = new int[Action.values().length];
            $SwitchMap$net$pubnative$lite$sdk$vpaid$VideoAdControllerVast$Action = iArr;
            try {
                iArr[Action.PREPARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$vpaid$VideoAdControllerVast$Action[Action.PLAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$vpaid$VideoAdControllerVast$Action[Action.PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$vpaid$VideoAdControllerVast$Action[Action.RESUME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private synchronized void executeAction(Action action) {
        int i = AnonymousClass5.$SwitchMap$net$pubnative$lite$sdk$vpaid$VideoAdControllerVast$Action[action.ordinal()];
        if (i == 1) {
            try {
                processPrepareAction();
            } catch (IOException unused) {
                tryReInitMediaPlayer();
            }
        } else if (i == 2) {
            processPlayAction();
        } else if (i == 3) {
            processPauseAction();
        } else if (i == 4) {
            processResumeAction();
        }
    }

    private void tryReInitMediaPlayer() {
        postDelayed(new Runnable() { // from class: net.pubnative.lite.sdk.vpaid.VideoAdControllerVast$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m9868x86146ac5();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$tryReInitMediaPlayer$1$net-pubnative-lite-sdk-vpaid-VideoAdControllerVast, reason: not valid java name */
    /* synthetic */ void m9868x86146ac5() {
        try {
            processPrepareAction();
        } catch (Exception e) {
            net.pubnative.lite.sdk.utils.Logger.e(LOG_TAG, "mediaPlayer re-init: " + e.getMessage());
            closeSelf();
        }
    }

    private void processPrepareAction() throws IllegalStateException, IOException {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            VerveVideoBridge.MediaPlayerRelease(mediaPlayer);
        }
        this.mMediaPlayer = new MediaPlayer();
        try {
            String str = this.mVideoUri;
            if (str == null || str.isEmpty()) {
                this.mBaseAdInternal.onAdLoadFailInternal(new PlayerInfo("Invalid media file uri"));
            }
            VerveVideoBridge.MediaPlayerSetDataSource(this.mMediaPlayer, this.mVideoUri);
            this.mMediaPlayer.setOnCompletionListener(this.mOnCompletionListener);
            this.mMediaPlayer.setOnErrorListener(this.mOnErrorListener);
            this.mMediaPlayer.setLooping(false);
            this.mMediaPlayer.prepare();
        } catch (IOException | RuntimeException e) {
            net.pubnative.lite.sdk.utils.Logger.e(LOG_TAG, "startMediaPlayer: " + e.getMessage());
            this.mBaseAdInternal.onAdLoadFailInternal(new PlayerInfo("Error loading media file"));
        }
    }

    private void processPlayAction() {
        if (this.mMediaPlayer == null) {
            return;
        }
        muteVideo(this.mViewControllerVast.isMute(), false);
        this.mViewControllerVast.adjustLayoutParams(this.mMediaPlayer.getVideoWidth(), this.mMediaPlayer.getVideoHeight());
        VerveVideoBridge.MediaPlayerSetSurface(this.mMediaPlayer, this.mViewControllerVast.getSurface());
        createTimer(this.mMediaPlayer.getDuration());
        getViewabilityAdSession().fireImpression();
        BaseVideoAdInternal baseVideoAdInternal = this.mBaseAdInternal;
        if (baseVideoAdInternal != null && baseVideoAdInternal.getAdListener() != null) {
            this.mBaseAdInternal.getAdListener().onAdStarted();
        }
        VerveVideoBridge.MediaPlayerStart(this.mMediaPlayer);
    }

    private void processPauseAction() {
        TimerWithPause timerWithPause = this.mTimerWithPause;
        if (timerWithPause != null) {
            timerWithPause.pause();
        }
        TimerWithPause timerWithPause2 = this.mSkipTimerWithPause;
        if (timerWithPause2 != null) {
            timerWithPause2.pause();
        }
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            VerveVideoBridge.MediaPlayerPause(this.mMediaPlayer);
            getViewabilityAdSession().firePause();
        }
        if (this.isVideoCompleted || this.isVideoSkipped) {
            return;
        }
        fireReportingEvent(Reporting.EventType.VIDEO_PAUSE);
        EventTracker.postEventByType(this.mBaseAdInternal.getContext(), this.mAdParams.getEvents(), "pause", this.mMacroHelper, false);
    }

    private void processResumeAction() {
        MediaPlayer mediaPlayer;
        if (!this.isVideoCompleted && (mediaPlayer = this.mMediaPlayer) != null) {
            VerveVideoBridge.MediaPlayerSetSurface(mediaPlayer, this.mViewControllerVast.getSurface());
            VerveVideoBridge.MediaPlayerStart(this.mMediaPlayer);
        }
        if (this.isVideoCompleted) {
            recoverMediaPlayerSurface();
        }
        TimerWithPause timerWithPause = this.mTimerWithPause;
        if (timerWithPause != null && timerWithPause.isPaused()) {
            this.mTimerWithPause.resume();
        }
        TimerWithPause timerWithPause2 = this.mSkipTimerWithPause;
        if (timerWithPause2 != null && timerWithPause2.isPaused()) {
            this.mSkipTimerWithPause.resume();
        }
        if (this.isVideoCompleted || this.isVideoSkipped) {
            return;
        }
        fireReportingEvent(Reporting.EventType.VIDEO_RESUME);
        getViewabilityAdSession().fireResume();
        EventTracker.postEventByType(this.mBaseAdInternal.getContext(), this.mAdParams.getEvents(), "resume", this.mMacroHelper, false);
    }

    @Override // net.pubnative.lite.sdk.vpaid.VideoAdController
    public void resumeEndCardCloseButtonTimer() {
        this.mViewControllerVast.resumeEndCardCloseButtonTimer();
    }

    @Override // net.pubnative.lite.sdk.vpaid.VideoAdController
    public void pauseEndCardCloseButtonTimer() {
        this.mViewControllerVast.pauseEndCardCloseButtonTimer();
    }

    @Override // net.pubnative.lite.sdk.vpaid.VideoAdController
    public void onEndCardClosed(Boolean bool) {
        BaseVideoAdInternal baseVideoAdInternal = this.mBaseAdInternal;
        if (baseVideoAdInternal != null) {
            baseVideoAdInternal.onEndCardClosed(bool);
        }
    }

    @Override // net.pubnative.lite.sdk.vpaid.VideoAdController
    public void prepare(VideoAdController.OnPreparedListener onPreparedListener) {
        onPreparedListener.onPrepared();
    }

    @Override // net.pubnative.lite.sdk.vpaid.VideoAdController
    public void setVideoFilePath(String str) {
        this.mVideoUri = str;
    }

    @Override // net.pubnative.lite.sdk.vpaid.VideoAdController
    public void addEndCardData(EndCardData endCardData) {
        if (endCardData != null) {
            this.mEndCardsData.add(endCardData);
        }
    }

    @Override // net.pubnative.lite.sdk.vpaid.VideoAdController
    public void setEndCardFilePath(String str) {
        this.mImageUri = str;
    }

    public void safedk_VideoAdControllerVast_buildVideoAdView_12fb6b75902c35a931574cb33047c4f9(VideoAdView p0) {
        this.mViewControllerVast.buildVideoAdView(p0);
    }

    @Override // net.pubnative.lite.sdk.vpaid.VideoAdController
    public void playAd() {
        addAction(Action.PREPARE);
        addAction(Action.PLAY);
        processActions();
    }

    @Override // net.pubnative.lite.sdk.vpaid.VideoAdController
    public void pause() {
        if (this.currentAction == Action.INITIAL) {
            addPendingAction(Action.PAUSE, Action.PLAY);
        } else {
            addAction(Action.PAUSE);
        }
        this.mViewControllerVast.pause();
        processActions();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resumeAd() {
        if (this.currentAction == Action.PAUSE && !this.isVideoSkipped) {
            addAction(Action.RESUME);
        } else if (isVideoVisible()) {
            cancelPendingPauseAction();
        }
        this.mViewControllerVast.resume();
        processActions();
    }

    private void createTimer(final int i) {
        ViewControllerVast viewControllerVast;
        this.mDuration = i;
        this.mDoneMillis = -1;
        initSkipTime(i);
        createProgressPoints(i);
        addMissingDefaultEvents(i);
        this.hasEndcard = Boolean.valueOf(AdEndCardManager.isEndCardEnabled(this.mBaseAdInternal.getAd()).booleanValue() && hasNextEndCard().booleanValue());
        this.mTimerWithPause = new TimerWithPause(i, 10L) { // from class: net.pubnative.lite.sdk.vpaid.VideoAdControllerVast.2
            @Override // net.pubnative.lite.sdk.vpaid.helpers.TimerWithPause
            public void onTick(long j) {
                int i2 = (int) j;
                VideoAdControllerVast.this.mViewControllerVast.setProgress(i2, i);
                VideoAdControllerVast.this.mDoneMillis = i - i2;
                if (!VideoAdControllerVast.this.isImpressionFired && !VideoAdControllerVast.this.containsStartEvent) {
                    VideoAdControllerVast.this.mImpressionListener.onImpression();
                    VideoAdControllerVast.this.isImpressionFired = true;
                }
                ArrayList arrayList = new ArrayList();
                for (TrackingEvent trackingEvent : VideoAdControllerVast.this.mTrackingEventsList) {
                    if (VideoAdControllerVast.this.mDoneMillis > trackingEvent.timeMillis) {
                        if (trackingEvent.name != null && trackingEvent.name.equals("start") && !VideoAdControllerVast.this.isImpressionFired && VideoAdControllerVast.this.containsStartEvent) {
                            VideoAdControllerVast.this.mImpressionListener.onImpression();
                            VideoAdControllerVast.this.isImpressionFired = true;
                        }
                        EventTracker.postEvent(VideoAdControllerVast.this.mBaseAdInternal.getContext(), trackingEvent.url, trackingEvent.name, VideoAdControllerVast.this.mMacroHelper, false);
                        VideoAdControllerVast.this.fireViewabilityTrackingEvent(trackingEvent.name);
                        arrayList.add(trackingEvent);
                    }
                }
                VideoAdControllerVast.this.mTrackingEventsList.removeAll(arrayList);
            }

            @Override // net.pubnative.lite.sdk.vpaid.helpers.TimerWithPause
            public void onFinish() {
                if (VideoAdControllerVast.this.mViewControllerVast != null) {
                    VideoAdControllerVast.this.mViewControllerVast.resetProgress();
                    VideoAdControllerVast.this.handleMediaPlayerComplete();
                }
            }
        }.create();
        int i2 = this.mSkipTimeMillis;
        if (i2 > 0 && this.isFullscreen) {
            this.mSkipTimerWithPause = new TimerWithPause(this.mSkipTimeMillis, 10L) { // from class: net.pubnative.lite.sdk.vpaid.VideoAdControllerVast.3
                @Override // net.pubnative.lite.sdk.vpaid.helpers.TimerWithPause
                public void onTick(long j) {
                    VideoAdControllerVast.this.mViewControllerVast.setSkipProgress((int) j, VideoAdControllerVast.this.mSkipTimeMillis);
                }

                @Override // net.pubnative.lite.sdk.vpaid.helpers.TimerWithPause
                public void onFinish() {
                    if (VideoAdControllerVast.this.mViewControllerVast != null) {
                        VideoAdControllerVast.this.mViewControllerVast.endSkip(Boolean.valueOf(VideoAdControllerVast.this.isAutoClose), VideoAdControllerVast.this.hasEndcard);
                    }
                }
            }.create();
        } else if (i2 == 0 && this.isFullscreen && (viewControllerVast = this.mViewControllerVast) != null) {
            viewControllerVast.endSkip(Boolean.valueOf(this.isAutoClose), this.hasEndcard);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireViewabilityTrackingEvent(String str) {
        if (getViewabilityAdSession() == null || TextUtils.isEmpty(str)) {
            return;
        }
        str.hashCode();
        switch (str) {
            case "midpoint":
                getViewabilityAdSession().fireMidpoint();
                if (!this.midpointFired) {
                    fireReportingEvent("midpoint");
                    this.midpointFired = true;
                    break;
                }
                break;
            case "thirdQuartile":
                getViewabilityAdSession().fireThirdQuartile();
                if (!this.thirdQuartileFired) {
                    fireReportingEvent("third_quartile");
                    this.thirdQuartileFired = true;
                    break;
                }
                break;
            case "start":
                try {
                    getViewabilityAdSession().fireStart(getAdParams().getDuration(), true);
                    break;
                } catch (Exception unused) {
                    if (this.mDuration > 0) {
                        getViewabilityAdSession().fireStart(this.mDuration, true);
                    } else if (this.mSkipTimeMillis > 0) {
                        getViewabilityAdSession().fireStart(this.mSkipTimeMillis, true);
                    }
                }
                if (!this.startFired) {
                    fireReportingEvent(Reporting.EventType.VIDEO_STARTED);
                    this.startFired = true;
                    break;
                }
                break;
            case "firstQuartile":
                getViewabilityAdSession().fireFirstQuartile();
                if (!this.firstQuartileFired) {
                    fireReportingEvent("first_quartile");
                    this.firstQuartileFired = true;
                    break;
                }
                break;
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0080  */
    /* JADX WARN: Code duplicated, block: B:29:0x008d  */
    /* JADX WARN: Code duplicated, block: B:32:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:33:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:36:0x0108  */
    private void initSkipTime(int i) {
        int publisherSkipSeconds;
        boolean z;
        boolean z2;
        int i2;
        BaseVideoAdInternal baseVideoAdInternal = this.mBaseAdInternal;
        if (baseVideoAdInternal == null || baseVideoAdInternal.getAd() == null) {
            return;
        }
        Integer numValueOf = -1;
        AdParams adParams = this.mAdParams;
        if (adParams != null) {
            publisherSkipSeconds = adParams.getPublisherSkipSeconds();
            if (!TextUtils.isEmpty(this.mAdParams.getSkipTime())) {
                if (this.mAdParams.getSkipTime().contains("%")) {
                    numValueOf = Integer.valueOf((Utils.parsePercent(this.mAdParams.getSkipTime()) * i) / 100);
                } else {
                    Integer duration = Utils.parseDuration(this.mAdParams.getSkipTime());
                    numValueOf = duration != null ? Integer.valueOf(duration.intValue() * 1000) : null;
                    z = true;
                }
            }
            if (AdEndCardManager.isEndCardEnabled(this.mBaseAdInternal.getAd()).booleanValue() || !hasNextEndCard().booleanValue()) {
                z2 = false;
            } else {
                z2 = true;
            }
            this.hasEndcard = Boolean.valueOf(z2);
            if (isRewarded()) {
                if (!z && numValueOf != null) {
                    this.mSkipTimeMillis = SkipOffsetManager.getVideoSkipOffset(this.mBaseAdInternal.getAd().getVideoRewardedSkipOffset(), Integer.valueOf(publisherSkipSeconds), Integer.valueOf(numValueOf.intValue() / 1000), this.hasEndcard, false).intValue() * 1000;
                } else {
                    this.mSkipTimeMillis = SkipOffsetManager.getVideoSkipOffset(this.mBaseAdInternal.getAd().getVideoRewardedSkipOffset(), Integer.valueOf(publisherSkipSeconds), numValueOf, this.hasEndcard, false).intValue() * 1000;
                }
            } else if (!z && numValueOf != null) {
                this.mSkipTimeMillis = SkipOffsetManager.getVideoSkipOffset(this.mBaseAdInternal.getAd().getVideoSkipOffset(), null, Integer.valueOf(numValueOf.intValue() / 1000), this.hasEndcard, true).intValue() * 1000;
            } else {
                this.mSkipTimeMillis = SkipOffsetManager.getVideoSkipOffset(this.mBaseAdInternal.getAd().getVideoSkipOffset(), null, numValueOf, this.hasEndcard, true).intValue() * 1000;
            }
            i2 = this.mSkipTimeMillis;
            if (i2 <= i || (i - i2 < 500 && i - i2 >= 0)) {
                this.mSkipTimeMillis = -1;
            }
            return;
        }
        publisherSkipSeconds = -1;
        z = false;
        if (AdEndCardManager.isEndCardEnabled(this.mBaseAdInternal.getAd()).booleanValue()) {
            z2 = false;
        } else {
            z2 = false;
        }
        this.hasEndcard = Boolean.valueOf(z2);
        if (isRewarded()) {
            if (!z) {
                this.mSkipTimeMillis = SkipOffsetManager.getVideoSkipOffset(this.mBaseAdInternal.getAd().getVideoRewardedSkipOffset(), Integer.valueOf(publisherSkipSeconds), numValueOf, this.hasEndcard, false).intValue() * 1000;
            } else {
                this.mSkipTimeMillis = SkipOffsetManager.getVideoSkipOffset(this.mBaseAdInternal.getAd().getVideoRewardedSkipOffset(), Integer.valueOf(publisherSkipSeconds), numValueOf, this.hasEndcard, false).intValue() * 1000;
            }
        } else if (!z) {
            this.mSkipTimeMillis = SkipOffsetManager.getVideoSkipOffset(this.mBaseAdInternal.getAd().getVideoSkipOffset(), null, numValueOf, this.hasEndcard, true).intValue() * 1000;
        } else {
            this.mSkipTimeMillis = SkipOffsetManager.getVideoSkipOffset(this.mBaseAdInternal.getAd().getVideoSkipOffset(), null, numValueOf, this.hasEndcard, true).intValue() * 1000;
        }
        i2 = this.mSkipTimeMillis;
        if (i2 <= i) {
        }
        this.mSkipTimeMillis = -1;
    }

    private void createProgressPoints(int i) {
        this.mTrackingEventsList.clear();
        AdParams adParams = this.mAdParams;
        if (adParams == null) {
            return;
        }
        if (adParams.getImpressions() != null) {
            Iterator<String> it = this.mAdParams.getImpressions().iterator();
            while (it.hasNext()) {
                this.mTrackingEventsList.add(new TrackingEvent(it.next()));
            }
        }
        if (this.mAdParams.getEvents() != null) {
            for (Tracking tracking : this.mAdParams.getEvents()) {
                TrackingEvent trackingEvent = new TrackingEvent(tracking.getText());
                if (tracking.getEvent().equalsIgnoreCase(EventConstants.CREATIVE_VIEW)) {
                    trackingEvent.timeMillis = 0;
                    trackingEvent.name = EventConstants.CREATIVE_VIEW;
                    this.mTrackingEventsList.add(trackingEvent);
                }
                if (tracking.getEvent().equalsIgnoreCase("start")) {
                    trackingEvent.timeMillis = 0;
                    trackingEvent.name = "start";
                    this.mTrackingEventsList.add(trackingEvent);
                    this.containsStartEvent = true;
                }
                if (tracking.getEvent().equalsIgnoreCase(EventConstants.FIRST_QUARTILE)) {
                    trackingEvent.timeMillis = i / 4;
                    trackingEvent.name = EventConstants.FIRST_QUARTILE;
                    this.mTrackingEventsList.add(trackingEvent);
                }
                if (tracking.getEvent().equalsIgnoreCase("midpoint")) {
                    trackingEvent.timeMillis = i / 2;
                    trackingEvent.name = "midpoint";
                    this.mTrackingEventsList.add(trackingEvent);
                }
                if (tracking.getEvent().equalsIgnoreCase(EventConstants.THIRD_QUARTILE)) {
                    trackingEvent.timeMillis = (i * 3) / 4;
                    trackingEvent.name = EventConstants.THIRD_QUARTILE;
                    this.mTrackingEventsList.add(trackingEvent);
                }
                if (tracking.getEvent().equalsIgnoreCase("progress") && tracking.getOffset() != null) {
                    if (tracking.getOffset().contains("%")) {
                        trackingEvent.timeMillis = (Utils.parsePercent(tracking.getOffset()) * i) / 100;
                    } else {
                        Integer duration = Utils.parseDuration(tracking.getOffset());
                        if (duration != null) {
                            trackingEvent.timeMillis = duration.intValue() * 1000;
                        }
                    }
                    this.mTrackingEventsList.add(trackingEvent);
                }
            }
        }
    }

    private void addMissingDefaultEvents(int i) {
        for (String str : UByte$$ExternalSyntheticBackport0.m(new Object[]{"start", EventConstants.FIRST_QUARTILE, "midpoint", EventConstants.THIRD_QUARTILE})) {
            Iterator<TrackingEvent> it = this.mTrackingEventsList.iterator();
            while (true) {
                if (it.hasNext()) {
                    TrackingEvent next = it.next();
                    if (next.name != null && next.name.equalsIgnoreCase(str)) {
                        break;
                    }
                } else {
                    this.mTrackingEventsList.add(createDefaultEvent(str, null, i, null));
                    break;
                }
            }
        }
    }

    private TrackingEvent createDefaultEvent(String str, String str2, int i, String str3) {
        TrackingEvent trackingEvent = new TrackingEvent(str2);
        trackingEvent.name = str;
        if (str.equalsIgnoreCase("start")) {
            trackingEvent.timeMillis = 0;
            trackingEvent.name = "start";
            this.containsStartEvent = true;
        }
        if (str.equalsIgnoreCase(EventConstants.FIRST_QUARTILE)) {
            trackingEvent.timeMillis = i / 4;
            trackingEvent.name = EventConstants.FIRST_QUARTILE;
        }
        if (str.equalsIgnoreCase("midpoint")) {
            trackingEvent.timeMillis = i / 2;
            trackingEvent.name = "midpoint";
        }
        if (str.equalsIgnoreCase(EventConstants.THIRD_QUARTILE)) {
            trackingEvent.timeMillis = (i * 3) / 4;
            trackingEvent.name = EventConstants.THIRD_QUARTILE;
        }
        return trackingEvent;
    }

    /* JADX INFO: renamed from: lambda$new$2$net-pubnative-lite-sdk-vpaid-VideoAdControllerVast, reason: not valid java name */
    /* synthetic */ void m9864lambda$new$2$netpubnativelitesdkvpaidVideoAdControllerVast(MediaPlayer mediaPlayer) {
        handleMediaPlayerComplete();
    }

    private void postDelayed(Runnable runnable) {
        this.mViewControllerVast.postDelayed(runnable, 100L);
    }

    @Override // net.pubnative.lite.sdk.vpaid.VideoAdController
    public void skipVideo() {
        this.mViewControllerVast.hideSkipButton();
        this.mViewControllerVast.hideTimerAndMuteButton();
        skipVideo(true);
        this.isVideoSkipped = true;
    }

    @Override // net.pubnative.lite.sdk.vpaid.VideoAdController
    public void skipEndCard() {
        EndCardData nextEndCard = getNextEndCard();
        if (nextEndCard == null || !isEndCardShowable() || (nextEndCard.getType() == EndCardData.Type.STATIC_RESOURCE && TextUtils.isEmpty(this.mImageUri))) {
            closeSelf();
            return;
        }
        BaseVideoAdInternal baseVideoAdInternal = this.mBaseAdInternal;
        if (baseVideoAdInternal != null) {
            baseVideoAdInternal.onEndCardSkipped(this.isLastEndCardCustom);
            ViewControllerVast viewControllerVast = this.mViewControllerVast;
            String str = this.mImageUri;
            BaseVideoAdInternal baseVideoAdInternal2 = this.mBaseAdInternal;
            Objects.requireNonNull(baseVideoAdInternal2);
            viewControllerVast.showLastCustomEndCard(nextEndCard, str, new VideoAdControllerVast$$ExternalSyntheticLambda3(baseVideoAdInternal2));
        }
    }

    @Override // net.pubnative.lite.sdk.vpaid.VideoAdController
    public void closeEndCard() {
        closeSelf();
    }

    private void skipVideo(boolean z) {
        if (this.finishedPlaying) {
            return;
        }
        this.finishedPlaying = true;
        clearAllActions();
        if (z) {
            getViewabilityAdSession().fireSkipped();
            this.mBaseAdInternal.onAdSkipped();
        } else if (!this.isVideoSkipped) {
            getViewabilityAdSession().fireComplete();
        }
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            VerveVideoBridge.MediaPlayerPause(this.mMediaPlayer);
        }
        TimerWithPause timerWithPause = this.mTimerWithPause;
        if (timerWithPause != null) {
            timerWithPause.pause();
            this.mTimerWithPause = null;
        }
        TimerWithPause timerWithPause2 = this.mSkipTimerWithPause;
        if (timerWithPause2 != null) {
            timerWithPause2.pause();
            this.mSkipTimerWithPause = null;
        }
        if (z) {
            fireReportingEvent("skipped");
            EventTracker.postEventByType(this.mBaseAdInternal.getContext(), this.mAdParams.getEvents(), EventConstants.SKIP, this.mMacroHelper, true);
        }
        if (this.isAutoClose) {
            this.hasEndcard = false;
            closeSelf();
            return;
        }
        EndCardData nextEndCard = getNextEndCard();
        Boolean boolValueOf = Boolean.valueOf(!hasNextEndCard().booleanValue());
        if (nextEndCard != null && isEndCardShowable() && (nextEndCard.getType() != EndCardData.Type.STATIC_RESOURCE || !TextUtils.isEmpty(this.mImageUri))) {
            this.hasEndcard = true;
            this.isLastEndCardCustom = nextEndCard.isCustom();
            BaseVideoAdInternal baseVideoAdInternal = this.mBaseAdInternal;
            if (baseVideoAdInternal != null) {
                ViewControllerVast viewControllerVast = this.mViewControllerVast;
                String str = this.mImageUri;
                Objects.requireNonNull(baseVideoAdInternal);
                viewControllerVast.showEndCard(nextEndCard, str, boolValueOf, new VideoAdControllerVast$$ExternalSyntheticLambda3(baseVideoAdInternal));
            }
        } else if (z) {
            closeSelf();
        } else {
            BaseVideoAdInternal baseVideoAdInternal2 = this.mBaseAdInternal;
            if (baseVideoAdInternal2 != null) {
                baseVideoAdInternal2.onAdCloseButtonVisible();
            }
        }
        postDelayed(new Runnable() { // from class: net.pubnative.lite.sdk.vpaid.VideoAdControllerVast$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m9867x686b3f08();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$skipVideo$3$net-pubnative-lite-sdk-vpaid-VideoAdControllerVast, reason: not valid java name */
    /* synthetic */ void m9867x686b3f08() {
        BaseVideoAdInternal baseVideoAdInternal = this.mBaseAdInternal;
        if (baseVideoAdInternal != null && baseVideoAdInternal.isInterstitial().booleanValue() && this.finishedPlaying && this.mImageUri == null && this.isAutoClose && !this.hasEndcard.booleanValue()) {
            closeSelf();
        }
    }

    @Override // net.pubnative.lite.sdk.vpaid.VideoAdController
    public void toggleMute() {
        this.mViewControllerVast.muteVideo();
    }

    @Override // net.pubnative.lite.sdk.vpaid.VideoAdController
    public void setVolume(boolean z) {
        muteVideo(z, true);
    }

    private synchronized void muteVideo(boolean z, boolean z2) {
        if (this.mMediaPlayer == null) {
            return;
        }
        try {
            getViewabilityAdSession().fireVolumeChange(z);
            if (z) {
                this.mMediaPlayer.setVolume(0.0f, 0.0f);
                if (z2) {
                    fireReportingEvent(Reporting.EventType.VIDEO_MUTE);
                    EventTracker.postEventByType(this.mBaseAdInternal.getContext(), this.mAdParams.getEvents(), "mute", this.mMacroHelper, false);
                }
            } else {
                float systemVolume = Utils.getSystemVolume(this.mBaseAdInternal.getContext());
                this.mMediaPlayer.setVolume(systemVolume, systemVolume);
                if (z2) {
                    fireReportingEvent(Reporting.EventType.VIDEO_UNMUTE);
                    EventTracker.postEventByType(this.mBaseAdInternal.getContext(), this.mAdParams.getEvents(), "unmute", this.mMacroHelper, false);
                }
            }
        } catch (RuntimeException e) {
            HyBid.reportException((Exception) e);
            net.pubnative.lite.sdk.utils.Logger.w(LOG_TAG, e.getMessage());
        }
    }

    private String trackVideoClicks() {
        String videoRedirectUrl = this.mAdParams.getVideoRedirectUrl();
        Iterator<String> it = this.mAdParams.getVideoClicks().iterator();
        while (it.hasNext()) {
            EventTracker.postEvent(this.mBaseAdInternal.getContext(), it.next(), "VideoClick", this.mMacroHelper, false);
        }
        return videoRedirectUrl;
    }

    private String trackEndCardClicks() {
        String endCardRedirectUrl = this.mAdParams.getEndCardRedirectUrl();
        Iterator<String> it = this.mAdParams.getEndCardClicks().iterator();
        while (it.hasNext()) {
            EventTracker.postEvent(this.mBaseAdInternal.getContext(), it.next(), "EndcardClick", this.mMacroHelper, false);
        }
        return endCardRedirectUrl;
    }

    private void trackClickThroughEvent(String str) {
        if (Objects.equals(str, this.mAdParams.getVideoRedirectUrl())) {
            EventTracker.postEvent(this.mBaseAdInternal.getContext(), str, "ClickThrough", this.mMacroHelper, false);
        } else if (Objects.equals(str, this.mAdParams.getEndCardRedirectUrl())) {
            EventTracker.postEvent(this.mBaseAdInternal.getContext(), str, "CompanionClickThrough", this.mMacroHelper, false);
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0056 A[PHI: r0
  0x0056: PHI (r0v13 java.lang.String) = (r0v7 java.lang.String), (r0v15 java.lang.String) binds: [B:13:0x0023, B:23:0x0054] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // net.pubnative.lite.sdk.vpaid.VideoAdController
    public void openUrl(String str, Boolean bool, Boolean bool2) {
        String strTrackVideoClicks;
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            try {
                if (mediaPlayer.isPlaying()) {
                    str = trackVideoClicks();
                } else {
                    if (!bool.booleanValue() && TextUtils.isEmpty(str)) {
                        str = trackEndCardClicks();
                    }
                    strTrackVideoClicks = trackVideoClicks();
                    if (str == null) {
                        str = strTrackVideoClicks;
                    }
                }
            } catch (IllegalStateException e) {
                net.pubnative.lite.sdk.utils.Logger.e(LOG_TAG, "MediaPlayer is in an invalid state: " + e.getMessage());
            }
        } else {
            if (!bool.booleanValue() && TextUtils.isEmpty(str)) {
                str = trackEndCardClicks();
            }
            strTrackVideoClicks = trackVideoClicks();
            if (str == null) {
                str = strTrackVideoClicks;
            }
        }
        if (TextUtils.isEmpty(str)) {
            if (bool.booleanValue()) {
                return;
            }
            this.mBaseAdInternal.onAdClicked();
            return;
        }
        String str2 = LOG_TAG;
        net.pubnative.lite.sdk.utils.Logger.d(str2, "Handle external url");
        if (Utils.isOnline(this.mBaseAdInternal.getContext())) {
            Context context = this.mBaseAdInternal.getContext();
            trackClickThroughEvent(str);
            new UrlHandler(context).handleUrl(str, this.mBaseAdInternal.getAd() != null ? this.mBaseAdInternal.getAd().getNavigationMode() : null);
        } else {
            net.pubnative.lite.sdk.utils.Logger.e(str2, "No internet connection");
        }
        if (bool.booleanValue() || bool2.booleanValue()) {
            return;
        }
        this.mBaseAdInternal.onAdClicked();
    }

    @Override // net.pubnative.lite.sdk.vpaid.VideoAdController
    public void onCustomEndCardShow(String str) {
        BaseVideoAdInternal baseVideoAdInternal = this.mBaseAdInternal;
        if (baseVideoAdInternal != null) {
            baseVideoAdInternal.onCustomEndCardShow(str);
        }
    }

    @Override // net.pubnative.lite.sdk.vpaid.VideoAdController
    public void onCustomCTAShow() {
        BaseVideoAdInternal baseVideoAdInternal = this.mBaseAdInternal;
        if (baseVideoAdInternal != null) {
            baseVideoAdInternal.onCustomCTAShow();
        }
    }

    @Override // net.pubnative.lite.sdk.vpaid.VideoAdController
    public void onCustomCTAClick(boolean z) {
        BaseVideoAdInternal baseVideoAdInternal = this.mBaseAdInternal;
        if (baseVideoAdInternal != null) {
            baseVideoAdInternal.onCustomCTAClick(z);
        }
    }

    @Override // net.pubnative.lite.sdk.vpaid.VideoAdController
    public void onCustomCTALoadFail() {
        BaseVideoAdInternal baseVideoAdInternal = this.mBaseAdInternal;
        if (baseVideoAdInternal != null) {
            baseVideoAdInternal.onCustomCTALoadFail();
        }
    }

    @Override // net.pubnative.lite.sdk.vpaid.VideoAdController
    public void onDefaultEndCardShow(String str) {
        BaseVideoAdInternal baseVideoAdInternal = this.mBaseAdInternal;
        if (baseVideoAdInternal != null) {
            baseVideoAdInternal.onDefaultEndCardShow(str);
        }
        if (this.mCreativeViewEventsTracker == null || this.isCreativeViewEventsTracked.booleanValue()) {
            return;
        }
        this.mCreativeViewEventsTracker.trackImpression();
        if (HyBid.getReportingController() != null && HyBid.isReportingEnabled().booleanValue()) {
            ReportingEvent reportingEvent = new ReportingEvent();
            reportingEvent.setEventType(Reporting.EventType.CREATIVE_VIEW);
            if (isRewarded()) {
                reportingEvent.setAdFormat("rewarded");
            } else if (this.isFullscreen) {
                reportingEvent.setAdFormat("fullscreen");
            } else {
                reportingEvent.setAdFormat("banner");
            }
            reportingEvent.setCreativeType("video");
            reportingEvent.setPlatform("android");
            reportingEvent.setSdkVersion(HyBid.getSDKVersionInfo(this.mIntegrationType));
            reportingEvent.setTimestamp(System.currentTimeMillis());
            BaseVideoAdInternal baseVideoAdInternal2 = this.mBaseAdInternal;
            if (baseVideoAdInternal2 != null && baseVideoAdInternal2.getAd() != null) {
                reportingEvent.setImpId(this.mBaseAdInternal.getAd().getSessionId());
                reportingEvent.setCampaignId(this.mBaseAdInternal.getAd().getCampaignId());
                reportingEvent.setConfigId(this.mBaseAdInternal.getAd().getConfigId());
            }
            HyBid.getReportingController().reportEvent(reportingEvent);
        }
        this.isCreativeViewEventsTracked = true;
    }

    @Override // net.pubnative.lite.sdk.vpaid.VideoAdController
    public void onCustomEndCardClick(String str) {
        BaseVideoAdInternal baseVideoAdInternal = this.mBaseAdInternal;
        if (baseVideoAdInternal != null) {
            baseVideoAdInternal.onCustomEndCardClick(str);
        }
    }

    @Override // net.pubnative.lite.sdk.vpaid.VideoAdController
    public void onDefaultEndCardClick(String str) {
        BaseVideoAdInternal baseVideoAdInternal = this.mBaseAdInternal;
        if (baseVideoAdInternal != null) {
            baseVideoAdInternal.onDefaultEndCardClick(str);
        }
    }

    @Override // net.pubnative.lite.sdk.vpaid.VideoAdController
    public void onEndCardLoadSuccess(Boolean bool) {
        BaseVideoAdInternal baseVideoAdInternal = this.mBaseAdInternal;
        if (baseVideoAdInternal != null) {
            baseVideoAdInternal.onEndCardLoadSuccess(bool);
        }
    }

    @Override // net.pubnative.lite.sdk.vpaid.VideoAdController
    public void onEndCardLoadFail(Boolean bool) {
        BaseVideoAdInternal baseVideoAdInternal = this.mBaseAdInternal;
        if (baseVideoAdInternal != null) {
            baseVideoAdInternal.onEndCardLoadFail(bool);
        }
    }

    @Override // net.pubnative.lite.sdk.vpaid.VideoAdController
    public void closeSelf() {
        EventTracker.postEventByType(this.mBaseAdInternal.getContext(), this.mAdParams.getEvents(), "close", this.mMacroHelper, true);
        EventTracker.postEventByType(this.mBaseAdInternal.getContext(), this.mAdParams.getEvents(), EventConstants.CLOSE_LINEAR, this.mMacroHelper, true);
        this.mBaseAdInternal.dismiss();
    }

    @Override // net.pubnative.lite.sdk.vpaid.VideoAdController
    public void dismiss() {
        this.mViewControllerVast.dismiss();
        this.observer.unregisterVolumeObserver(this, this.mBaseAdInternal.getContext());
    }

    @Override // net.pubnative.lite.sdk.vpaid.VideoAdController
    public void destroy() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            try {
                VerveVideoBridge.MediaPlayerRelease(mediaPlayer);
            } catch (RuntimeException unused) {
                net.pubnative.lite.sdk.utils.Logger.e(LOG_TAG, "Error releasing HyBid video player");
            }
        }
        if (this.currentAction == Action.INITIAL) {
            EventTracker.postEventByType(this.mBaseAdInternal.getContext(), this.mAdParams.getEvents(), EventConstants.NOT_USED, this.mMacroHelper, true);
        }
        this.finishedPlaying = true;
        TimerWithPause timerWithPause = this.mTimerWithPause;
        if (timerWithPause != null) {
            timerWithPause.pause();
            this.mTimerWithPause = null;
        }
        TimerWithPause timerWithPause2 = this.mSkipTimerWithPause;
        if (timerWithPause2 != null) {
            timerWithPause2.pause();
            this.mSkipTimerWithPause = null;
        }
        this.mViewControllerVast.destroy();
        clearAllActions();
        this.observer.unregisterVolumeObserver(this, this.mBaseAdInternal.getContext());
    }

    @Override // net.pubnative.lite.sdk.vpaid.VideoAdController
    public void resume() {
        if (this.isAndroid6VersionDevice.booleanValue() && this.mMediaPlayer != null) {
            ViewControllerVast viewControllerVast = this.mViewControllerVast;
            if (viewControllerVast != null && viewControllerVast.getTexture() != null) {
                this.mViewControllerVast.getTexture().setSurfaceTextureListener(this.mCreateTextureListener);
                return;
            } else {
                resumeAd();
                return;
            }
        }
        resumeAd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleMediaPlayerComplete() {
        if (this.isVideoCompleted) {
            return;
        }
        this.mViewControllerVast.hideSkipButton();
        this.isVideoCompleted = true;
        this.mViewControllerVast.hideTimerAndMuteButton();
        this.mBaseAdInternal.onAdDidReachEnd();
        fireReportingEvent(Reporting.EventType.VIDEO_AD_COMPLETE);
        skipVideo(false);
        if (this.isVideoSkipped) {
            return;
        }
        EventTracker.postEventByType(this.mBaseAdInternal.getContext(), this.mAdParams.getEvents(), "complete", this.mMacroHelper, true);
    }

    private void recoverMediaPlayerSurface() {
        if (this.mMediaPlayer == null) {
            return;
        }
        postDelayed(new Runnable() { // from class: net.pubnative.lite.sdk.vpaid.VideoAdControllerVast$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m9866xa8ff6217();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$recoverMediaPlayerSurface$4$net-pubnative-lite-sdk-vpaid-VideoAdControllerVast, reason: not valid java name */
    /* synthetic */ void m9866xa8ff6217() {
        try {
            VerveVideoBridge.MediaPlayerSetSurface(this.mMediaPlayer, this.mViewControllerVast.getSurface());
            if (this.finishedPlaying) {
                this.mMediaPlayer.seekTo(this.mDuration);
            }
        } catch (IllegalStateException e) {
            net.pubnative.lite.sdk.utils.Logger.e(LOG_TAG, "mediaPlayer cant recover surface: " + e.getMessage());
        }
    }

    private EndCardData getNextEndCard() {
        if (this.mEndCardsData.isEmpty()) {
            return null;
        }
        EndCardData endCardData = this.mEndCardsData.get(0);
        this.mEndCardsData.remove(0);
        return endCardData;
    }

    private Boolean hasNextEndCard() {
        return Boolean.valueOf(!this.mEndCardsData.isEmpty());
    }

    private boolean isEndCardShowable() {
        Ad ad = this.mBaseAdInternal.getAd();
        if (ad != null) {
            return AdEndCardManager.isEndCardEnabled(ad).booleanValue();
        }
        return false;
    }

    private Integer getEndcardCloseDelay(BaseVideoAdInternal baseVideoAdInternal) {
        if (baseVideoAdInternal == null || baseVideoAdInternal.getAd() == null) {
            return null;
        }
        return baseVideoAdInternal.getAd().getEndCardCloseDelay();
    }

    private Integer getNativeCloseButtonDelay(BaseVideoAdInternal baseVideoAdInternal) {
        if (baseVideoAdInternal == null || baseVideoAdInternal.getAd() == null) {
            return null;
        }
        return getCloseButtonDelay(baseVideoAdInternal.getAd());
    }

    private boolean hasReducedCloseSize(BaseVideoAdInternal baseVideoAdInternal) {
        if (baseVideoAdInternal == null || baseVideoAdInternal.getAd() == null) {
            return false;
        }
        Boolean boolIsIconSizeReduced = baseVideoAdInternal.getAd().isIconSizeReduced();
        return baseVideoAdInternal.getAd().getAdExperience().equalsIgnoreCase(AdExperience.PERFORMANCE) && boolIsIconSizeReduced != null && boolIsIconSizeReduced.booleanValue();
    }

    public Integer getCloseButtonDelay(Ad ad) {
        return SkipOffsetManager.getNativeCloseButtonDelay(ad.getNativeCloseButtonDelay());
    }

    private Boolean getFullScreenClickability(BaseVideoAdInternal baseVideoAdInternal) {
        if (baseVideoAdInternal == null || baseVideoAdInternal.getAd() == null) {
            return null;
        }
        return baseVideoAdInternal.getAd().getFullScreenClickability();
    }

    private void fireReportingEvent(String str) {
        if (HyBid.getReportingController() == null || !HyBid.isReportingEnabled().booleanValue()) {
            return;
        }
        ReportingEvent reportingEvent = new ReportingEvent();
        reportingEvent.setEventType(str);
        if (isRewarded()) {
            reportingEvent.setAdFormat("rewarded");
        } else if (this.isFullscreen) {
            reportingEvent.setAdFormat("fullscreen");
        } else {
            reportingEvent.setAdFormat("banner");
        }
        reportingEvent.setCreativeType("video");
        reportingEvent.setPlatform("android");
        reportingEvent.setSdkVersion(HyBid.getSDKVersionInfo(IntegrationType.STANDALONE));
        reportingEvent.setTimestamp(System.currentTimeMillis());
        BaseVideoAdInternal baseVideoAdInternal = this.mBaseAdInternal;
        if (baseVideoAdInternal != null && baseVideoAdInternal.getAd() != null) {
            reportingEvent.setImpId(this.mBaseAdInternal.getAd().getSessionId());
            reportingEvent.setCampaignId(this.mBaseAdInternal.getAd().getCampaignId());
            reportingEvent.setConfigId(this.mBaseAdInternal.getAd().getConfigId());
        }
        HyBid.getReportingController().reportEvent(reportingEvent);
    }

    @Override // net.pubnative.lite.sdk.vpaid.VideoAdController
    public boolean adFinishedPlaying() {
        return this.finishedPlaying;
    }

    @Override // net.pubnative.lite.sdk.vpaid.VideoAdController
    public boolean isRewarded() {
        return this.mBaseAdInternal.isRewarded();
    }

    @Override // net.pubnative.lite.sdk.vpaid.VideoAdController
    public AdParams getAdParams() {
        return this.mAdParams;
    }

    @Override // net.pubnative.lite.sdk.vpaid.VideoAdController
    public HyBidViewabilityNativeVideoAdSession getViewabilityAdSession() {
        return this.mViewabilityAdSession;
    }

    @Override // net.pubnative.lite.sdk.vpaid.VideoAdController
    public void addViewabilityFriendlyObstruction(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        if (view == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.mViewabilityFriendlyObstructions.add(new HyBidViewabilityFriendlyObstruction(view, friendlyObstructionPurpose, str));
    }

    @Override // net.pubnative.lite.sdk.vpaid.VideoAdController
    public List<HyBidViewabilityFriendlyObstruction> getViewabilityFriendlyObstructions() {
        return this.mViewabilityFriendlyObstructions;
    }

    @Override // net.pubnative.lite.sdk.vpaid.VideoAdController
    public boolean isVideoVisible() {
        return this.videoVisible;
    }

    @Override // net.pubnative.lite.sdk.vpaid.VideoAdController
    public int getProgress() {
        int i;
        int i2 = this.mDoneMillis;
        if (i2 == -1 || (i = this.mDuration) == -1) {
            return -1;
        }
        return (i2 * 100) / i;
    }

    @Override // net.pubnative.lite.sdk.vpaid.VideoAdController
    public void setVideoVisible(boolean z) {
        if (this.videoVisible && z) {
            recoverMediaPlayerSurface();
        }
        this.videoVisible = z;
    }

    @Override // net.pubnative.lite.sdk.vpaid.volume.IVolumeObserver
    public void onSystemVolumeChanged() {
        muteVideo(this.mViewControllerVast.isMute(), false);
    }
}
