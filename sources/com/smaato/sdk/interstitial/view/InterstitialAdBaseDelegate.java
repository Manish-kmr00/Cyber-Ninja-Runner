package com.smaato.sdk.interstitial.view;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.CountDownTimer;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import com.smaato.sdk.core.ad.AdFormat;
import com.smaato.sdk.core.ad.AdRequestParams;
import com.smaato.sdk.core.ad.KeyValuePairs;
import com.smaato.sdk.core.api.ImpressionCountingType;
import com.smaato.sdk.core.linkhandler.LinkHandler$$ExternalSyntheticLambda4;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.mvvm.model.imagead.Extension;
import com.smaato.sdk.core.mvvm.view.SmaatoSdkViewDelegate;
import com.smaato.sdk.core.mvvm.view.ViewDelegateStorage;
import com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel;
import com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModelListener;
import com.smaato.sdk.core.remoteconfig.ButtonConfigurations;
import com.smaato.sdk.core.ui.AdContentView;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.Threads;
import com.smaato.sdk.core.util.UIUtils;
import com.smaato.sdk.core.util.diinjection.Inject;
import com.smaato.sdk.core.util.fi.BiConsumer;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.interstitial.R;
import com.smaato.sdk.interstitial.model.csm.InterstitialCsmBaseDelegate;
import com.smaato.sdk.interstitial.viewmodel.InterstitialAdBaseViewModel;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes8.dex */
public abstract class InterstitialAdBaseDelegate extends SmaatoSdkViewDelegate {
    private Runnable activityFinisher;

    @Inject
    private Application application;
    protected Consumer<Boolean> backButtonEnabledChanger;

    @Inject
    private ButtonConfigurations buttonConfigurations;
    protected Consumer<Boolean> closeButtonVisibilityChanger;
    protected BiConsumer<Context, Runnable> contentAdViewCreator;
    CountDownTimer countDownTimer;
    protected Consumer<Long> countDownTimerTextChanger;
    protected Consumer<Boolean> countDownTimerVisibilityChanger;
    protected Object csmDelegate;
    protected InterstitialAdBaseViewModel interstitialAdBaseViewModel;
    protected boolean isCountDownRunning;

    @Inject
    protected Logger logger;
    protected ProgressBar progressBar;
    private long remainingCountDown;
    protected boolean useCustomClose;
    private SmaatoSdkViewDelegate.VideoActivityLifecycleListener videoActivityLifecycleListener;
    private Runnable videoPlayerCloser;

    @Inject
    protected ViewDelegateStorage viewDelegateStorage;
    private int countDownTickCounter = 0;
    protected boolean isCloseButtonVisible = false;
    protected final UUID delegateUUID = UUID.randomUUID();

    protected abstract boolean videoIsClickable();

    protected abstract boolean videoIsSkippable();

    static /* synthetic */ int access$608(InterstitialAdBaseDelegate interstitialAdBaseDelegate) {
        int i = interstitialAdBaseDelegate.countDownTickCounter;
        interstitialAdBaseDelegate.countDownTickCounter = i + 1;
        return i;
    }

    protected void setViewModel(InterstitialAdBaseViewModel interstitialAdBaseViewModel) {
        super.setViewModel((SmaatoSdkViewModel) interstitialAdBaseViewModel);
        this.interstitialAdBaseViewModel = interstitialAdBaseViewModel;
    }

    public void setCloseButtonVisibility(boolean z) {
        this.isCloseButtonVisible = z;
    }

    public void setCloseButtonVisibilityChanger(Consumer<Boolean> consumer) {
        this.closeButtonVisibilityChanger = consumer;
    }

    public void setBackButtonEnabledChanger(Consumer<Boolean> consumer) {
        this.backButtonEnabledChanger = consumer;
    }

    public void setCountDownTimerTextChanger(Consumer<Long> consumer) {
        this.countDownTimerTextChanger = consumer;
    }

    public void setCountDownTimerVisibilityChanger(Consumer<Boolean> consumer) {
        this.countDownTimerVisibilityChanger = consumer;
    }

    public void setProgressBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    public void setActivityFinisher(Runnable runnable) {
        this.activityFinisher = runnable;
    }

    protected void setCloseButtonSize(ImageButton imageButton) {
        Objects.onNotNull(imageButton, new Consumer() { // from class: com.smaato.sdk.interstitial.view.InterstitialAdBaseDelegate$$ExternalSyntheticLambda8
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5592xfe3d8f79((ImageButton) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$setCloseButtonSize$0$com-smaato-sdk-interstitial-view-InterstitialAdBaseDelegate, reason: not valid java name */
    /* synthetic */ void m5592xfe3d8f79(ImageButton imageButton) {
        ViewGroup.LayoutParams layoutParams = imageButton.getLayoutParams();
        int iApplyDimension = (int) TypedValue.applyDimension(1, this.buttonConfigurations.getButtonSize(getBundleId()), imageButton.getContext().getResources().getDisplayMetrics());
        layoutParams.height = iApplyDimension;
        layoutParams.width = iApplyDimension;
        imageButton.setLayoutParams(layoutParams);
    }

    public void loadAd(String str, AdFormat adFormat, String str2, String str3, String str4, AdRequestParams adRequestParams, KeyValuePairs keyValuePairs, Map<String, Object> map, String str5, boolean z, boolean z2) {
        this.interstitialAdBaseViewModel.setViewModelListener(createViewModelListener());
        this.interstitialAdBaseViewModel.setMediationNetworkName(str2);
        this.interstitialAdBaseViewModel.setMediationNetworkSDKVersion(str3);
        this.interstitialAdBaseViewModel.setMediationAdapterVersion(str4);
        this.interstitialAdBaseViewModel.setKeyValuePairs(keyValuePairs);
        this.interstitialAdBaseViewModel.setObjectExtras(map);
        this.useCustomClose = false;
        this.interstitialAdBaseViewModel.loadAd(str, adFormat, this.application.getString(R.string.smaato_sdk_core_fullscreen_dimension), UIUtils.getDisplayWidthInDp(), UIUtils.getDisplayHeightInDp(), adRequestParams, str5, z, z2);
    }

    public AdContentView getAdContentView() {
        return this.adContentViewReference.get();
    }

    public void setFriendlyObstructionView(ImageButton imageButton) {
        Objects.onNotNull(imageButton, new Consumer() { // from class: com.smaato.sdk.interstitial.view.InterstitialAdBaseDelegate$$ExternalSyntheticLambda6
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5593xbcad3089((ImageButton) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$setFriendlyObstructionView$1$com-smaato-sdk-interstitial-view-InterstitialAdBaseDelegate, reason: not valid java name */
    /* synthetic */ void m5593xbcad3089(ImageButton imageButton) {
        this.smaatoSdkViewModel.registerFriendlyObstruction(imageButton);
    }

    public void onCloseClicked() {
        Runnable runnable = this.videoPlayerCloser;
        if (runnable != null) {
            runnable.run();
            this.videoPlayerCloser = null;
        } else {
            this.interstitialAdBaseViewModel.onAdClosed();
            finishAd();
        }
    }

    public void finishAd() {
        Objects.onNotNull(this.activityFinisher, new LinkHandler$$ExternalSyntheticLambda4());
        this.activityFinisher = null;
    }

    public void noContentViewFoundError() {
        this.interstitialAdBaseViewModel.onShowError();
    }

    @Override // com.smaato.sdk.core.mvvm.view.SmaatoSdkViewDelegate
    public void onVideoClosed() {
        this.interstitialAdBaseViewModel.onAdClosed();
        finishAd();
    }

    @Override // com.smaato.sdk.core.mvvm.view.SmaatoSdkViewDelegate
    public void setVideoPlayerCloser(Runnable runnable) {
        this.videoPlayerCloser = runnable;
    }

    @Override // com.smaato.sdk.core.mvvm.view.SmaatoSdkViewDelegate
    public String onWrongVastObjectCreated(Object obj) {
        String strOnWrongVastObjectCreated = super.onWrongVastObjectCreated(obj);
        this.smaatoSdkViewModel.onFailedToCreateContentView(new Exception(strOnWrongVastObjectCreated));
        return strOnWrongVastObjectCreated;
    }

    @Override // com.smaato.sdk.core.mvvm.view.SmaatoSdkViewDelegate
    public void onCompanionShown() {
        super.onCompanionShown();
        if (this.useCustomClose) {
            return;
        }
        initializeAndStartCountdownAndCloseButtonTimer();
    }

    @Override // com.smaato.sdk.core.mvvm.view.SmaatoSdkViewDelegate
    public void onVideoCompleted(boolean z) {
        super.onVideoCompleted(z);
        if (z) {
            return;
        }
        Objects.onNotNull(this.closeButtonVisibilityChanger, new Consumer() { // from class: com.smaato.sdk.interstitial.view.InterstitialAdBaseDelegate$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((Consumer) obj).accept(Boolean.TRUE);
            }
        });
        Objects.onNotNull(this.backButtonEnabledChanger, new Consumer() { // from class: com.smaato.sdk.interstitial.view.InterstitialAdBaseDelegate$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((Consumer) obj).accept(Boolean.TRUE);
            }
        });
    }

    @Override // com.smaato.sdk.core.mvvm.view.SmaatoSdkViewDelegate
    public void onUseCustomClose() {
        this.useCustomClose = true;
        initializeAndStartCountdownAndCloseButtonTimer();
    }

    /* JADX INFO: renamed from: com.smaato.sdk.interstitial.view.InterstitialAdBaseDelegate$1, reason: invalid class name */
    class AnonymousClass1 implements SmaatoSdkViewModelListener {
        AnonymousClass1() {
        }

        @Override // com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModelListener
        public void onImageAdLoaded(final Bitmap bitmap, int i, int i2, final List<Extension> list, final ImpressionCountingType impressionCountingType) {
            InterstitialAdBaseDelegate.this.contentAdViewCreator = new BiConsumer() { // from class: com.smaato.sdk.interstitial.view.InterstitialAdBaseDelegate$1$$ExternalSyntheticLambda3
                @Override // com.smaato.sdk.core.util.fi.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f$0.m5596x3f410227(bitmap, list, impressionCountingType, (Context) obj, (Runnable) obj2);
                }
            };
        }

        /* JADX INFO: renamed from: lambda$onImageAdLoaded$0$com-smaato-sdk-interstitial-view-InterstitialAdBaseDelegate$1, reason: not valid java name */
        /* synthetic */ void m5596x3f410227(Bitmap bitmap, List list, ImpressionCountingType impressionCountingType, Context context, Runnable runnable) {
            InterstitialAdBaseDelegate.this.createImageAdContentView(context, bitmap, -1, -1, list, impressionCountingType);
            runnable.run();
        }

        @Override // com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModelListener
        public void onRichMediaAdLoaded(final String str, int i, int i2, final ImpressionCountingType impressionCountingType) {
            InterstitialAdBaseDelegate.this.contentAdViewCreator = new BiConsumer() { // from class: com.smaato.sdk.interstitial.view.InterstitialAdBaseDelegate$1$$ExternalSyntheticLambda2
                @Override // com.smaato.sdk.core.util.fi.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f$0.m5597x4e017675(str, impressionCountingType, (Context) obj, (Runnable) obj2);
                }
            };
        }

        /* JADX INFO: renamed from: lambda$onRichMediaAdLoaded$1$com-smaato-sdk-interstitial-view-InterstitialAdBaseDelegate$1, reason: not valid java name */
        /* synthetic */ void m5597x4e017675(String str, ImpressionCountingType impressionCountingType, Context context, Runnable runnable) {
            InterstitialAdBaseDelegate interstitialAdBaseDelegate = InterstitialAdBaseDelegate.this;
            interstitialAdBaseDelegate.createRichMediaAdContentView(((SmaatoSdkViewDelegate) interstitialAdBaseDelegate).richMediaAdContentViewCreator, context, str, -1, -1, true, impressionCountingType);
            runnable.run();
        }

        @Override // com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModelListener
        public void onVideoAdLoaded(final Object obj, final ImpressionCountingType impressionCountingType) {
            InterstitialAdBaseDelegate.this.contentAdViewCreator = new BiConsumer() { // from class: com.smaato.sdk.interstitial.view.InterstitialAdBaseDelegate$1$$ExternalSyntheticLambda4
                @Override // com.smaato.sdk.core.util.fi.BiConsumer
                public final void accept(Object obj2, Object obj3) {
                    this.f$0.m5599x48aeda0a(obj, impressionCountingType, (Context) obj2, (Runnable) obj3);
                }
            };
        }

        /* JADX INFO: renamed from: lambda$onVideoAdLoaded$3$com-smaato-sdk-interstitial-view-InterstitialAdBaseDelegate$1, reason: not valid java name */
        /* synthetic */ void m5599x48aeda0a(Object obj, ImpressionCountingType impressionCountingType, Context context, Runnable runnable) {
            InterstitialAdBaseDelegate interstitialAdBaseDelegate = InterstitialAdBaseDelegate.this;
            interstitialAdBaseDelegate.createVideoAdContentView(obj, interstitialAdBaseDelegate.videoIsSkippable(), InterstitialAdBaseDelegate.this.videoIsClickable(), impressionCountingType, runnable, new Consumer() { // from class: com.smaato.sdk.interstitial.view.InterstitialAdBaseDelegate$1$$ExternalSyntheticLambda0
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj2) {
                    this.f$0.m5598x551f55c9((SmaatoSdkViewDelegate.VideoActivityLifecycleListener) obj2);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onVideoAdLoaded$2$com-smaato-sdk-interstitial-view-InterstitialAdBaseDelegate$1, reason: not valid java name */
        /* synthetic */ void m5598x551f55c9(SmaatoSdkViewDelegate.VideoActivityLifecycleListener videoActivityLifecycleListener) {
            InterstitialAdBaseDelegate.this.videoActivityLifecycleListener = videoActivityLifecycleListener;
        }

        @Override // com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModelListener
        public void onCsmAdObjectLoaded(final Object obj, final ImpressionCountingType impressionCountingType) {
            InterstitialAdBaseDelegate.this.contentAdViewCreator = new BiConsumer() { // from class: com.smaato.sdk.interstitial.view.InterstitialAdBaseDelegate$1$$ExternalSyntheticLambda1
                @Override // com.smaato.sdk.core.util.fi.BiConsumer
                public final void accept(Object obj2, Object obj3) {
                    this.f$0.m5595xd9f64bec(obj, impressionCountingType, (Context) obj2, (Runnable) obj3);
                }
            };
        }

        /* JADX INFO: renamed from: lambda$onCsmAdObjectLoaded$4$com-smaato-sdk-interstitial-view-InterstitialAdBaseDelegate$1, reason: not valid java name */
        /* synthetic */ void m5595xd9f64bec(Object obj, ImpressionCountingType impressionCountingType, Context context, Runnable runnable) {
            if (obj instanceof View) {
                InterstitialAdBaseDelegate.this.createCsmImageAdContentView((View) obj, impressionCountingType);
                runnable.run();
            }
            if (obj instanceof InterstitialCsmBaseDelegate) {
                InterstitialAdBaseDelegate.this.csmDelegate = obj;
                runnable.run();
            } else {
                InterstitialAdBaseDelegate.this.interstitialAdBaseViewModel.onFailedToCreateContentView(new Exception("CsmAdObject not of type view: " + obj));
            }
        }
    }

    protected SmaatoSdkViewModelListener createViewModelListener() {
        return new AnonymousClass1();
    }

    protected void initializeAndStartCountdownAndCloseButtonTimer() {
        if (this.isCloseButtonVisible) {
            return;
        }
        Objects.onNotNull(this.backButtonEnabledChanger, new Consumer() { // from class: com.smaato.sdk.interstitial.view.InterstitialAdBaseDelegate$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((Consumer) obj).accept(Boolean.FALSE);
            }
        });
        Objects.onNotNull(this.closeButtonVisibilityChanger, new Consumer() { // from class: com.smaato.sdk.interstitial.view.InterstitialAdBaseDelegate$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((Consumer) obj).accept(Boolean.FALSE);
            }
        });
        Objects.onNotNull(this.countDownTimerVisibilityChanger, new Consumer() { // from class: com.smaato.sdk.interstitial.view.InterstitialAdBaseDelegate$$ExternalSyntheticLambda4
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((Consumer) obj).accept(Boolean.FALSE);
            }
        });
        long displayAdCloseButtonDelay = this.useCustomClose ? 15000L : getDisplayAdCloseButtonDelay();
        this.remainingCountDown = displayAdCloseButtonDelay;
        startOrResumeCountdownAndCloseButtonTimer(displayAdCloseButtonDelay);
    }

    protected void startOrResumeCountdownAndCloseButtonTimer(long j) {
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        if (j == 0) {
            return;
        }
        if (!this.useCustomClose) {
            Objects.onNotNull(this.countDownTimerVisibilityChanger, new Consumer() { // from class: com.smaato.sdk.interstitial.view.InterstitialAdBaseDelegate$$ExternalSyntheticLambda7
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((Consumer) obj).accept(Boolean.TRUE);
                }
            });
        }
        this.isCountDownRunning = true;
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(j, 1000L);
        this.countDownTimer = anonymousClass2;
        anonymousClass2.start();
    }

    /* JADX INFO: renamed from: com.smaato.sdk.interstitial.view.InterstitialAdBaseDelegate$2, reason: invalid class name */
    class AnonymousClass2 extends CountDownTimer {
        AnonymousClass2(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onTick(final long j) {
            Objects.onNotNull(InterstitialAdBaseDelegate.this.countDownTimerTextChanger, new Consumer() { // from class: com.smaato.sdk.interstitial.view.InterstitialAdBaseDelegate$2$$ExternalSyntheticLambda3
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((Consumer) obj).accept(Long.valueOf((j / 1000) + 1));
                }
            });
            InterstitialAdBaseDelegate interstitialAdBaseDelegate = InterstitialAdBaseDelegate.this;
            if (interstitialAdBaseDelegate.useCustomClose && interstitialAdBaseDelegate.countDownTickCounter == 3) {
                Objects.onNotNull(InterstitialAdBaseDelegate.this.backButtonEnabledChanger, new Consumer() { // from class: com.smaato.sdk.interstitial.view.InterstitialAdBaseDelegate$2$$ExternalSyntheticLambda4
                    @Override // com.smaato.sdk.core.util.fi.Consumer
                    public final void accept(Object obj) {
                        ((Consumer) obj).accept(Boolean.TRUE);
                    }
                });
            }
            InterstitialAdBaseDelegate.access$608(InterstitialAdBaseDelegate.this);
            InterstitialAdBaseDelegate.this.remainingCountDown = j;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            InterstitialAdBaseDelegate interstitialAdBaseDelegate = InterstitialAdBaseDelegate.this;
            interstitialAdBaseDelegate.isCountDownRunning = false;
            interstitialAdBaseDelegate.remainingCountDown = 0L;
            Objects.onNotNull(InterstitialAdBaseDelegate.this.countDownTimerVisibilityChanger, new Consumer() { // from class: com.smaato.sdk.interstitial.view.InterstitialAdBaseDelegate$2$$ExternalSyntheticLambda0
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((Consumer) obj).accept(Boolean.FALSE);
                }
            });
            Objects.onNotNull(InterstitialAdBaseDelegate.this.closeButtonVisibilityChanger, new Consumer() { // from class: com.smaato.sdk.interstitial.view.InterstitialAdBaseDelegate$2$$ExternalSyntheticLambda1
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    this.f$0.m5600xae748873((Consumer) obj);
                }
            });
            Objects.onNotNull(InterstitialAdBaseDelegate.this.backButtonEnabledChanger, new Consumer() { // from class: com.smaato.sdk.interstitial.view.InterstitialAdBaseDelegate$2$$ExternalSyntheticLambda2
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((Consumer) obj).accept(Boolean.TRUE);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onFinish$3$com-smaato-sdk-interstitial-view-InterstitialAdBaseDelegate$2, reason: not valid java name */
        /* synthetic */ void m5600xae748873(Consumer consumer) {
            InterstitialAdBaseDelegate.this.isCloseButtonVisible = true;
            consumer.accept(Boolean.TRUE);
        }
    }

    protected void startFailsafeCountDownTimer() {
        if (this.interstitialAdBaseViewModel.isDisplayingVideoAd()) {
            return;
        }
        Threads.newUiHandler().postDelayed(new Runnable() { // from class: com.smaato.sdk.interstitial.view.InterstitialAdBaseDelegate$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5594xa9f44ff();
            }
        }, 3000L);
    }

    /* JADX INFO: renamed from: lambda$startFailsafeCountDownTimer$8$com-smaato-sdk-interstitial-view-InterstitialAdBaseDelegate, reason: not valid java name */
    /* synthetic */ void m5594xa9f44ff() {
        if (this.isCountDownRunning) {
            return;
        }
        initializeAndStartCountdownAndCloseButtonTimer();
    }

    private long getDisplayAdCloseButtonDelay() {
        return ((long) this.buttonConfigurations.getDisplayAdCloseButtonDelay(getBundleId())) * 1000;
    }

    private void pauseCountDownTimer() {
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer == null || !this.isCountDownRunning) {
            return;
        }
        countDownTimer.cancel();
        this.isCountDownRunning = false;
    }

    protected void onActivityPause() {
        SmaatoSdkViewDelegate.VideoActivityLifecycleListener videoActivityLifecycleListener = this.videoActivityLifecycleListener;
        if (videoActivityLifecycleListener != null) {
            videoActivityLifecycleListener.onActivityPause();
        }
        pauseCountDownTimer();
    }

    protected void onActivityResume() {
        SmaatoSdkViewDelegate.VideoActivityLifecycleListener videoActivityLifecycleListener = this.videoActivityLifecycleListener;
        if (videoActivityLifecycleListener != null) {
            videoActivityLifecycleListener.onActivityResume();
        }
        if (this.countDownTimer == null || this.isCountDownRunning) {
            return;
        }
        startOrResumeCountdownAndCloseButtonTimer(this.remainingCountDown);
    }

    protected void onActivityFinishing() {
        this.activityFinisher = null;
        this.closeButtonVisibilityChanger = null;
        this.backButtonEnabledChanger = null;
        this.progressBar = null;
        this.countDownTimerVisibilityChanger = null;
        this.countDownTimerTextChanger = null;
        destroy();
        this.interstitialAdBaseViewModel.onActivityFinishing();
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
}
