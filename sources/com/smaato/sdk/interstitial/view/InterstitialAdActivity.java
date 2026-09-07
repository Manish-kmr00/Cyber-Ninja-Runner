package com.smaato.sdk.interstitial.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import com.smaato.sdk.core.AndroidsInjector;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.mvvm.view.SmaatoSdkViewDelegate;
import com.smaato.sdk.core.mvvm.view.ViewDelegateStorage;
import com.smaato.sdk.core.ui.AdContentView;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.diinjection.Inject;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.interstitial.R;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

/* JADX INFO: loaded from: classes10.dex */
public class InterstitialAdActivity extends Activity {
    protected static final String KEY_BACKGROUND_COLOR = "KEY_BACKGROUND_COLOR";
    protected static final String KEY_IS_SPLASH = "KEY_IS_SPLASH";
    protected static final String KEY_VIEWDELEGATE_UUID = "KEY_PRESENTER_UUID";
    private static final long SPLASH_DELAY_CLOSE_AD_MS = 5000;
    private static final long SPLASH_DELAY_SHOW_CLOSE_BUTTON_MS = 3000;
    private ImageButton closeButton;
    private FrameLayout contentHolder;
    private WeakReference<TextView> countDownText;
    protected InterstitialAdBaseDelegate interstitialAdBaseDelegate;
    private boolean isBackButtonEnabled;
    private boolean isSplash;

    @Inject
    private Logger logger;

    @Inject
    private ViewDelegateStorage viewDelegateStorage;
    private UUID viewModelUuid;
    private boolean splashTimersAreStarted = false;
    private final TimerTask showCloseButtonTask = new AnonymousClass1();
    private final TimerTask closeAdTask = new AnonymousClass2();
    private final Consumer<Boolean> closeButtonVisibilityChanger = new Consumer() { // from class: com.smaato.sdk.interstitial.view.InterstitialAdActivity$$ExternalSyntheticLambda11
        @Override // com.smaato.sdk.core.util.fi.Consumer
        public final void accept(Object obj) {
            this.f$0.m5585x9f5cbcf0((Boolean) obj);
        }
    };
    private final Consumer<Boolean> backButtonEnabledChanger = new Consumer() { // from class: com.smaato.sdk.interstitial.view.InterstitialAdActivity$$ExternalSyntheticLambda12
        @Override // com.smaato.sdk.core.util.fi.Consumer
        public final void accept(Object obj) {
            this.f$0.m5586xc4f0c5f1((Boolean) obj);
        }
    };
    private final Consumer<Long> countDownTextChanger = new Consumer() { // from class: com.smaato.sdk.interstitial.view.InterstitialAdActivity$$ExternalSyntheticLambda13
        @Override // com.smaato.sdk.core.util.fi.Consumer
        public final void accept(Object obj) {
            this.f$0.m5587x1018d7f3((Long) obj);
        }
    };
    private final Consumer<Boolean> countDownTextVisibilityChanger = new Consumer() { // from class: com.smaato.sdk.interstitial.view.InterstitialAdActivity$$ExternalSyntheticLambda14
        @Override // com.smaato.sdk.core.util.fi.Consumer
        public final void accept(Object obj) {
            this.f$0.m5588x5b40e9f5((Boolean) obj);
        }
    };

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.v, me);
        return super.dispatchTouchEvent(me);
    }

    /* JADX INFO: renamed from: com.smaato.sdk.interstitial.view.InterstitialAdActivity$1, reason: invalid class name */
    class AnonymousClass1 extends TimerTask {
        AnonymousClass1() {
        }

        /* JADX INFO: renamed from: lambda$run$1$com-smaato-sdk-interstitial-view-InterstitialAdActivity$1, reason: not valid java name */
        /* synthetic */ void m5590xbf23abe8() {
            Objects.onNotNull(InterstitialAdActivity.this.closeButton, new Consumer() { // from class: com.smaato.sdk.interstitial.view.InterstitialAdActivity$1$$ExternalSyntheticLambda1
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((ImageButton) obj).setVisibility(0);
                }
            });
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            InterstitialAdActivity.this.runOnUiThread(new Runnable() { // from class: com.smaato.sdk.interstitial.view.InterstitialAdActivity$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5590xbf23abe8();
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.smaato.sdk.interstitial.view.InterstitialAdActivity$2, reason: invalid class name */
    class AnonymousClass2 extends TimerTask {
        AnonymousClass2() {
        }

        /* JADX INFO: renamed from: lambda$run$0$com-smaato-sdk-interstitial-view-InterstitialAdActivity$2, reason: not valid java name */
        /* synthetic */ void m5591xae6ddf28() {
            InterstitialAdActivity.this.onCloseClicked();
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            InterstitialAdActivity.this.runOnUiThread(new Runnable() { // from class: com.smaato.sdk.interstitial.view.InterstitialAdActivity$2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5591xae6ddf28();
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$new$1$com-smaato-sdk-interstitial-view-InterstitialAdActivity, reason: not valid java name */
    /* synthetic */ void m5585x9f5cbcf0(final Boolean bool) {
        Objects.onNotNull(this.closeButton, new Consumer() { // from class: com.smaato.sdk.interstitial.view.InterstitialAdActivity$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((ImageButton) obj).setVisibility(bool.booleanValue() ? 0 : 8);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$new$2$com-smaato-sdk-interstitial-view-InterstitialAdActivity, reason: not valid java name */
    /* synthetic */ void m5586xc4f0c5f1(Boolean bool) {
        this.isBackButtonEnabled = bool.booleanValue();
    }

    /* JADX INFO: renamed from: lambda$new$4$com-smaato-sdk-interstitial-view-InterstitialAdActivity, reason: not valid java name */
    /* synthetic */ void m5587x1018d7f3(final Long l) {
        Objects.onNotNull(this.countDownText.get(), new Consumer() { // from class: com.smaato.sdk.interstitial.view.InterstitialAdActivity$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((TextView) obj).setText(String.valueOf(l));
            }
        });
    }

    /* JADX INFO: renamed from: lambda$new$6$com-smaato-sdk-interstitial-view-InterstitialAdActivity, reason: not valid java name */
    /* synthetic */ void m5588x5b40e9f5(final Boolean bool) {
        Objects.onNotNull(this.countDownText.get(), new Consumer() { // from class: com.smaato.sdk.interstitial.view.InterstitialAdActivity$$ExternalSyntheticLambda9
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((TextView) obj).setVisibility(bool.booleanValue() ? 0 : 8);
            }
        });
    }

    public static Intent createIntent(Context context, UUID uuid, int i, boolean z) {
        Objects.requireNonNull(context);
        Objects.requireNonNull(uuid);
        return new Intent(context, (Class<?>) InterstitialAdActivity.class).putExtra(KEY_VIEWDELEGATE_UUID, uuid).putExtra(KEY_BACKGROUND_COLOR, i).putExtra(KEY_IS_SPLASH, z);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AndroidsInjector.inject(this);
        if (this.viewDelegateStorage == null) {
            Logger logger = this.logger;
            if (logger != null) {
                logger.error(LogDomain.INTERSTITIAL, "SmaatoSdk is not initialized.", new Object[0]);
            }
            finish();
            return;
        }
        UUID uuid = (UUID) getIntent().getSerializableExtra(KEY_VIEWDELEGATE_UUID);
        this.viewModelUuid = uuid;
        SmaatoSdkViewDelegate smaatoSdkViewDelegate = this.viewDelegateStorage.get(uuid);
        if (smaatoSdkViewDelegate instanceof InterstitialAdBaseDelegate) {
            InterstitialAdBaseDelegate interstitialAdBaseDelegate = (InterstitialAdBaseDelegate) smaatoSdkViewDelegate;
            this.interstitialAdBaseDelegate = interstitialAdBaseDelegate;
            interstitialAdBaseDelegate.setCloseButtonVisibility(false);
            this.interstitialAdBaseDelegate.setCloseButtonVisibilityChanger(this.closeButtonVisibilityChanger);
            this.interstitialAdBaseDelegate.setBackButtonEnabledChanger(this.backButtonEnabledChanger);
            this.interstitialAdBaseDelegate.setActivityFinisher(new Runnable() { // from class: com.smaato.sdk.interstitial.view.InterstitialAdActivity$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.finish();
                }
            });
            this.interstitialAdBaseDelegate.setCountDownTimerTextChanger(this.countDownTextChanger);
            this.interstitialAdBaseDelegate.setCountDownTimerVisibilityChanger(this.countDownTextVisibilityChanger);
            this.interstitialAdBaseDelegate.startFailsafeCountDownTimer();
            initView(this.interstitialAdBaseDelegate.getAdContentView());
        } else {
            Logger logger2 = this.logger;
            if (logger2 != null) {
                logger2.error(LogDomain.INTERSTITIAL, "No InterstitialAdBaseDelegate available", new Object[0]);
            }
            finish();
        }
        this.isSplash = getIntent().getBooleanExtra(KEY_IS_SPLASH, false);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        Objects.onNotNull(this.interstitialAdBaseDelegate, new Consumer() { // from class: com.smaato.sdk.interstitial.view.InterstitialAdActivity$$ExternalSyntheticLambda6
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((InterstitialAdBaseDelegate) obj).onActivityPause();
            }
        });
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        Objects.onNotNull(this.interstitialAdBaseDelegate, new Consumer() { // from class: com.smaato.sdk.interstitial.view.InterstitialAdActivity$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((InterstitialAdBaseDelegate) obj).onActivityResume();
            }
        });
        if (!this.isSplash || this.splashTimersAreStarted) {
            return;
        }
        startSplashClosingTimers();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {
            Objects.onNotNull(this.interstitialAdBaseDelegate, new Consumer() { // from class: com.smaato.sdk.interstitial.view.InterstitialAdActivity$$ExternalSyntheticLambda4
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((InterstitialAdBaseDelegate) obj).onActivityFinishing();
                }
            });
            Objects.onNotNull(this.viewDelegateStorage, new Consumer() { // from class: com.smaato.sdk.interstitial.view.InterstitialAdActivity$$ExternalSyntheticLambda5
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    this.f$0.m5589xb8dfd471((ViewDelegateStorage) obj);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$onDestroy$7$com-smaato-sdk-interstitial-view-InterstitialAdActivity, reason: not valid java name */
    /* synthetic */ void m5589xb8dfd471(ViewDelegateStorage viewDelegateStorage) {
        viewDelegateStorage.remove(this.viewModelUuid);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.isBackButtonEnabled) {
            onCloseClicked();
            super.onBackPressed();
        }
    }

    protected void initView(AdContentView adContentView) {
        if (adContentView == null) {
            this.interstitialAdBaseDelegate.noContentViewFoundError();
            finish();
            return;
        }
        setContentView(R.layout.smaato_sdk_interstitial_activity);
        adjustInsets();
        this.contentHolder = (FrameLayout) findViewById(R.id.smaato_sdk_interstitial_content);
        if (adContentView.getParent() != null) {
            ((ViewGroup) adContentView.getParent()).removeView(adContentView);
        }
        this.contentHolder.addView(adContentView);
        initCloseButton();
        initCloseButtonCountDown();
        initBackground();
        setAutomaticContentViewScaling(adContentView);
        this.interstitialAdBaseDelegate.setProgressBar(initProgressView());
    }

    private void adjustInsets() {
        try {
            if (Build.VERSION.SDK_INT >= 30) {
                getWindow().getDecorView().findViewById(android.R.id.content).setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.smaato.sdk.interstitial.view.InterstitialAdActivity$$ExternalSyntheticLambda8
                    @Override // android.view.View.OnApplyWindowInsetsListener
                    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                        return this.f$0.m5583x4417e916(view, windowInsets);
                    }
                });
            }
        } catch (Exception e) {
            Logger logger = this.logger;
            if (logger != null) {
                logger.error(LogDomain.INTERSTITIAL, e, "error while setting view insets", new Object[0]);
            }
        }
    }

    /* JADX INFO: renamed from: lambda$adjustInsets$8$com-smaato-sdk-interstitial-view-InterstitialAdActivity, reason: not valid java name */
    /* synthetic */ WindowInsets m5583x4417e916(View view, WindowInsets windowInsets) {
        try {
            view.setPadding(0, 0, 0, windowInsets.getInsets(WindowInsets.Type.systemBars()).bottom);
            return windowInsets;
        } catch (Exception e) {
            Logger logger = this.logger;
            if (logger != null) {
                logger.error(LogDomain.INTERSTITIAL, e, "error while setting view insets using setOnApplyWindowInsetsListener", new Object[0]);
            }
            return windowInsets;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float defineScaleFactor(FrameLayout frameLayout, AdContentView adContentView) {
        return Math.min(frameLayout.getWidth() / adContentView.getWidth(), frameLayout.getHeight() / adContentView.getHeight());
    }

    private void startSplashClosingTimers() {
        new Timer().schedule(this.showCloseButtonTask, 3000L);
        new Timer().schedule(this.closeAdTask, 5000L);
        this.splashTimersAreStarted = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCloseClicked() {
        Objects.onNotNull(this.interstitialAdBaseDelegate, new Consumer() { // from class: com.smaato.sdk.interstitial.view.InterstitialAdActivity$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((InterstitialAdBaseDelegate) obj).onCloseClicked();
            }
        });
    }

    private void setAutomaticContentViewScaling(final AdContentView adContentView) {
        this.contentHolder.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.smaato.sdk.interstitial.view.InterstitialAdActivity.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                InterstitialAdActivity.this.contentHolder.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                InterstitialAdActivity interstitialAdActivity = InterstitialAdActivity.this;
                float fDefineScaleFactor = interstitialAdActivity.defineScaleFactor(interstitialAdActivity.contentHolder, adContentView);
                if (Float.isNaN(fDefineScaleFactor) || Float.isInfinite(fDefineScaleFactor)) {
                    fDefineScaleFactor = 1.0f;
                }
                adContentView.setScaleX(fDefineScaleFactor);
                adContentView.setScaleY(fDefineScaleFactor);
            }
        });
    }

    private void initBackground() {
        findViewById(android.R.id.content).setBackgroundColor(getIntent().getIntExtra(KEY_BACKGROUND_COLOR, ViewCompat.MEASURED_STATE_MASK));
    }

    private void initCloseButton() {
        ImageButton imageButton = (ImageButton) findViewById(R.id.smaato_sdk_interstitial_close);
        this.closeButton = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.smaato.sdk.interstitial.view.InterstitialAdActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m5584xf3ebc272(view);
            }
        });
        this.interstitialAdBaseDelegate.setCloseButtonSize(this.closeButton);
        this.interstitialAdBaseDelegate.setFriendlyObstructionView(this.closeButton);
        reSizeCloseButtonForSmallerResolutions();
    }

    /* JADX INFO: renamed from: lambda$initCloseButton$9$com-smaato-sdk-interstitial-view-InterstitialAdActivity, reason: not valid java name */
    /* synthetic */ void m5584xf3ebc272(View view) {
        onCloseClicked();
    }

    private void initCloseButtonCountDown() {
        this.countDownText = new WeakReference<>((TextView) findViewById(R.id.smaato_sdk_interstitial_countdown));
    }

    void reSizeCloseButtonForSmallerResolutions() {
        if (this.closeButton == null) {
            return;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.densityDpi;
            float scaleX = this.closeButton.getScaleX();
            float scaleY = this.closeButton.getScaleY();
            if (i <= 160) {
                this.closeButton.setScaleX(scaleX * 0.7f);
                this.closeButton.setScaleY(scaleY * 0.7f);
            } else if (i <= 240) {
                this.closeButton.setScaleX(scaleX * 0.65f);
                this.closeButton.setScaleY(scaleY * 0.65f);
            } else if (i <= 320) {
                this.closeButton.setScaleX(scaleX * 0.7f);
                this.closeButton.setScaleY(scaleY * 0.7f);
            }
        } catch (Exception e) {
            Logger logger = this.logger;
            if (logger != null) {
                logger.error(LogDomain.INTERSTITIAL, e, "error while getting display metrics", new Object[0]);
            }
        }
    }

    private ProgressBar initProgressView() {
        return (ProgressBar) findViewById(com.smaato.sdk.video.R.id.smaato_sdk_video_video_progress);
    }
}
