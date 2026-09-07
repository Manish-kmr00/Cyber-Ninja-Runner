package com.playon.bridge;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.math.MathUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.bykv.vk.openvk.preload.falconx.statistic.StatisticData;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.iab.omid.library.odeeoio.Omid;
import com.iab.omid.library.odeeoio.adsession.AdEvents;
import com.iab.omid.library.odeeoio.adsession.AdSession;
import com.iab.omid.library.odeeoio.adsession.AdSessionConfiguration;
import com.iab.omid.library.odeeoio.adsession.AdSessionContext;
import com.iab.omid.library.odeeoio.adsession.CreativeType;
import com.iab.omid.library.odeeoio.adsession.ImpressionType;
import com.iab.omid.library.odeeoio.adsession.Owner;
import com.iab.omid.library.odeeoio.adsession.Partner;
import com.iab.omid.library.odeeoio.adsession.VerificationScriptResource;
import com.iab.omid.library.odeeoio.adsession.media.InteractionType;
import com.iab.omid.library.odeeoio.adsession.media.MediaEvents;
import com.iab.omid.library.odeeoio.adsession.media.Position;
import com.iab.omid.library.odeeoio.adsession.media.VastProperties;
import com.playon.bridge.common.AudioVolumeObserver;
import com.playon.bridge.common.LineBarVisualizer;
import com.playon.bridge.common.Log;
import com.playon.bridge.common.OnAudioVolumeChangedListener;
import com.playon.bridge.common.SquareProgressView;
import com.playon.bridge.common.util.PluginUtils;
import com.playon.bridge.custom_event.CustomEventPresenter;
import com.playon.bridge.custom_event.CustomEventPresenterImp;
import com.playon.bridge.custom_event.Event;
import com.playon.bridge.custom_event.MediaEventErrorHandler;
import com.playon.bridge.custom_event.RewardEventId;
import com.playon.bridge.reflection.ExoPlayerReflection;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import net.pubnative.lite.sdk.vpaid.enums.EventConstants;

/* JADX INFO: loaded from: classes7.dex */
public final class AdUnitActivity implements OnAudioVolumeChangedListener, Player.Listener, AdView.AdViewListener {
    private static final int ACTION_BUTTON_SIZE = 24;
    private static final int AD_CORNER_RADIUS_MAXIMUM = 14;
    private static final int AD_CORNER_RADIUS_MINIMUM = 6;
    private static final int AD_MARK_LAYOUT_SIZE = 12;
    private static final int AD_MARK_TEXT_SIZE = 5;
    private static final int AD_MARK_TRANSPARENCY = 180;
    private static final int BANNER_PROGRESSBAR_HEIGHT = 2;
    private static final int EXOPLAYER_v16 = 2016000;
    private static final int LINEBAR_CORNER_MARGIN_OFFSET = 2;
    private static final int LINEBAR_CORNER_SIZE = 24;
    private static final int LINEBAR_CORNER_TRANSPARENCY = 102;
    private static final int LOGO_PROGRESSBAR_ADVIEW_SPACE = 1;
    private static final int LOGO_PROGRESSBAR_WIDTH = 2;
    private static final int MAX_AD_SIZE = 120;
    private static final int MIN_AD_SIZE = 70;
    private static final String TAG = Log.makeTag("AdUnitActivity");
    private static final int UNIT_PROGRESSBAR_SPACE = 10;
    private final float DENSITY_PIXELS_TO_PIXEL_SCALE;
    private final float STREAM_MAX_VOLUME;
    AdEvents adEvents;
    private Date adPausedTime;
    AdSession adSession;
    private int barGrav;
    private final LineBarVisualizer lineBarVisualizer;
    public boolean mActive;
    private final Activity mActivity;
    private final Bundle mAd;
    private final PlayOnManager.AdActivity mAdListener;
    AdUnit.AdUnitType mAdType;
    private AdView mAdView;
    private AudioManager mAudioManager;
    private ExoPlayer mAudioPlayer;
    private AudioVolumeObserver mAudioVolumeObserver;
    private PopupWindow mLogoWindow;
    private PopupWindow mPopupWindow;
    private int mPosition;
    private ProgressBar mProgressBar;
    private final FrameLayout.LayoutParams mWrapContentCenteredLayoutParam;
    MediaEvents mediaEvents;
    Bundle mediaTracks;
    private ImageButton muteBtn;
    private PopupWindow popUp;
    private SquareProgressView progressSquareView;
    private ImageButton skipBtn;
    private ImageButton unmuteBtn;
    private int xBarOffset;
    private int yBarOffset;
    private int mErrorCode = 0;
    private int startStreamVolumeIndex = 0;
    private int beforeApplicationPause = 0;
    private boolean shouldResetStreamVolume = false;
    private AdUnit.Position popupPosition = AdUnit.Position.BottomRight;
    private int popupXOffset = 0;
    private int popupYOffset = 0;
    private int mVisualizationMainColor = -1;
    private int mVisualizationSecondFromColor = Color.rgb(249, 0, 243);
    private int mVisualizationSecondToColor = Color.rgb(130, 1, 241);
    private final int MAX_VOLUME_PERCENT = 100;
    private boolean isRewardEnabled = false;
    private boolean isMuteEnabled = false;
    private boolean isMuteShowed = false;
    private boolean isSkipShowed = false;
    private boolean isRewarded = false;
    private boolean isSkipSent = false;
    private boolean hasImpression = false;
    private float rewardAmount = 0.0f;
    private AdUnit.RewardType rewardType = AdUnit.RewardType.EndLevel;
    private MediaEventErrorHandler eventHandler = new MediaEventErrorHandler();
    private boolean adUnitClickedEvent = false;
    private final CustomEventPresenter customEventPresenter = new CustomEventPresenterImp();
    boolean lineBarShouldBeMoved = false;
    boolean start = false;
    boolean firstQuartile = false;
    boolean midpoint = false;
    boolean thirdQuartile = false;
    boolean complete = false;
    float mActionButtonDelay = 5.0f;
    private final Handler mHandler = new Handler();
    private final Runnable mUpdateTimeTask = new AnonymousClass1();
    private boolean isBuffering = false;

    /* JADX INFO: Access modifiers changed from: private */
    public int getMaxVolumePercent() {
        return 100;
    }

    @Override // com.playon.bridge.AdView.AdViewListener
    public void onAdViewCleared(AdView adView) {
    }

    @Override // com.playon.bridge.AdView.AdViewListener
    public void onAdViewError(AdView adView, int i) {
    }

    public AdUnitActivity(Activity activity, AdUnit.AdUnitType adUnitType, Bundle bundle, PlayOnManager.AdActivity adActivity) {
        this.mActivity = activity;
        this.mAdType = adUnitType;
        String str = TAG;
        Log.d(str, "Creating AdActivity");
        this.mWrapContentCenteredLayoutParam = new FrameLayout.LayoutParams(-2, -2, 17);
        this.DENSITY_PIXELS_TO_PIXEL_SCALE = PluginUtils.getDeviceDensityPixelScale(activity);
        this.mAd = bundle;
        this.mediaTracks = bundle.getBundle(Ad.MEDIA_TRACKING_EVENTS);
        this.mAdListener = adActivity;
        LineBarVisualizer lineBarVisualizer = new LineBarVisualizer(activity);
        this.lineBarVisualizer = lineBarVisualizer;
        lineBarVisualizer.setLayoutDirection(0);
        this.mAdView = new AdView(activity);
        this.mAdView.setLayoutDirection(0);
        AudioManager audioManager = (AudioManager) activity.getSystemService("audio");
        this.mAudioManager = audioManager;
        this.STREAM_MAX_VOLUME = audioManager.getStreamMaxVolume(3);
        setupAudioManager();
        Log.d(str, "Init AudioManager Done");
        ArrayList<Bundle> parcelableArrayList = bundle.getParcelableArrayList(Ad.ADVERIFICATIONS);
        if (Omid.isActive() && parcelableArrayList != null && !parcelableArrayList.isEmpty()) {
            try {
                InputStream inputStreamOpenRawResource = activity.getResources().openRawResource(R.raw.omsdk);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = inputStreamOpenRawResource.read(bArr);
                    if (i == -1) {
                        break;
                    } else {
                        byteArrayOutputStream.write(bArr, 0, i);
                    }
                }
                byteArrayOutputStream.close();
                inputStreamOpenRawResource.close();
                ArrayList arrayList = new ArrayList();
                for (Bundle bundle2 : parcelableArrayList) {
                    arrayList.add(VerificationScriptResource.createVerificationScriptResourceWithParameters(bundle2.getString("vendor"), new URL(bundle2.getString(Ad.VERIFICATIONRESOURCE)), bundle2.getString(Ad.VERIFICATIONPARAM)));
                }
                AdSession adSessionCreateAdSession = AdSession.createAdSession(AdSessionConfiguration.createAdSessionConfiguration(CreativeType.AUDIO, ImpressionType.AUDIBLE, Owner.NATIVE, Owner.NATIVE, false), AdSessionContext.createNativeAdSessionContext(Partner.createPartner("odeeoio", "2.0.9"), byteArrayOutputStream.toString(), arrayList, null, null));
                this.adSession = adSessionCreateAdSession;
                this.adEvents = AdEvents.createAdEvents(adSessionCreateAdSession);
                this.mediaEvents = MediaEvents.createMediaEvents(this.adSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Log.d(TAG, "Verifications initialized");
    }

    public void setVisualizationColor(int i, int i2, int i3) {
        this.mVisualizationMainColor = i;
        this.mVisualizationSecondFromColor = i2;
        this.mVisualizationSecondToColor = i3;
        AdView adView = this.mAdView;
        if (adView == null || !adView.getCompanion().getBoolean(Ad.SOUND_VISUALISER_ENABLED)) {
            return;
        }
        this.lineBarVisualizer.setColor(this.mVisualizationMainColor);
        this.mAdView.clearWithColor(this.mVisualizationSecondFromColor, this.mVisualizationSecondToColor);
    }

    private void turnOnVisualization(GradientDrawable gradientDrawable, FrameLayout.LayoutParams layoutParams) {
        if (this.mAdView.getCompanion().getBoolean(Ad.SOUND_VISUALISER_ENABLED)) {
            this.lineBarVisualizer.setColor(this.mVisualizationMainColor);
            this.lineBarVisualizer.setWidth(6);
            this.lineBarVisualizer.setSpace(6);
            this.lineBarVisualizer.setLenght(25);
            this.mAdView.addView(this.lineBarVisualizer, new FrameLayout.LayoutParams(-2, -2, 17));
            this.mAdView.clearWithColor(this.mVisualizationSecondFromColor, this.mVisualizationSecondToColor);
            gradientDrawable.setAlpha(0);
        } else {
            this.lineBarVisualizer.setLines(3, true);
            this.lineBarVisualizer.setWidth(2);
            this.lineBarVisualizer.setSpace(2);
            this.lineBarVisualizer.setLenght(10);
            this.mAdView.addView(this.lineBarVisualizer, layoutParams);
            gradientDrawable.setAlpha(102);
        }
        this.lineBarVisualizer.setBackground(gradientDrawable);
    }

    public void turnOnBanner(AdUnit.Position position, int i, AdUnit.ActionButtonType actionButtonType, float f) {
        this.mPosition = AdUnit.PositionToGravity(position);
        FrameLayout frameLayout = new FrameLayout(this.mActivity.getApplicationContext());
        frameLayout.setLayoutDirection(0);
        frameLayout.setBackground(new ColorDrawable(0));
        frameLayout.setSystemUiVisibility(this.mActivity.getWindow().getAttributes().flags);
        frameLayout.setVisibility(0);
        if (this.mAd.getString(Ad.MIME_TYPE) == null) {
            Log.e(TAG, "MIME type not set");
            finishWithError(AdUnit.ERROR_UNSUPPORTED_MIME_TYPE);
            return;
        }
        Bundle bundle = (Bundle) this.mAd.getParcelableArrayList(Ad.COMPANION).get(0);
        int i2 = bundle.getInt("width");
        int i3 = bundle.getInt("height");
        boolean z = bundle.getBoolean(Ad.SOUND_VISUALISER_ENABLED);
        this.mAdView.showAd(bundle, i2, i3);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, 12), PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, 12), 8388693);
        layoutParams.setMargins(0, 0, 0, PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, 2));
        AddAdMark(this.mAdView, layoutParams);
        frameLayout.addView(this.mAdView, this.mWrapContentCenteredLayoutParam);
        AdUnit.ActionButtonType actionButtonType2 = (this.isRewardEnabled || actionButtonType == AdUnit.ActionButtonType.Close) ? AdUnit.ActionButtonType.None : actionButtonType;
        FrameLayout frameLayout2 = new FrameLayout(this.mActivity);
        float fDensityPixelsToPixels = PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, 2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(ViewCompat.MEASURED_STATE_MASK);
        gradientDrawable.setAlpha(102);
        gradientDrawable.setCornerRadii(new float[]{fDensityPixelsToPixels, fDensityPixelsToPixels, 0.0f, 0.0f, 0.0f, 0.0f, fDensityPixelsToPixels, fDensityPixelsToPixels});
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setColor(ViewCompat.MEASURED_STATE_MASK);
        gradientDrawable2.setAlpha(102);
        turnOnVisualization(gradientDrawable, new FrameLayout.LayoutParams(PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, 24), PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, 24), 8388661));
        if (z) {
            this.lineBarVisualizer.setLines(7, false);
            gradientDrawable2.setCornerRadii(new float[]{fDensityPixelsToPixels, fDensityPixelsToPixels, 0.0f, 0.0f, 0.0f, 0.0f, fDensityPixelsToPixels, fDensityPixelsToPixels});
        } else {
            this.lineBarShouldBeMoved = true;
        }
        AddActionButton(frameLayout2, actionButtonType2, f, gradientDrawable2);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, 24), PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, 24), 8388661);
        layoutParams2.setMargins(0, PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, 2), 0, 0);
        frameLayout.addView(frameLayout2, layoutParams2);
        PopupWindow popupWindow = new PopupWindow(frameLayout, (int) PluginUtils.convertDpToPixel(i2), (int) PluginUtils.convertDpToPixel(i3));
        this.mPopupWindow = popupWindow;
        popupWindow.getContentView().setSystemUiVisibility(this.mActivity.getWindow().getAttributes().flags);
        PluginUtils.setPopUpWindowLayoutType(this.mPopupWindow, 1002);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setAlpha(0);
        this.mPopupWindow.setBackgroundDrawable(gradientDrawable3);
        this.mPopupWindow.setTouchable(true);
        this.mPopupWindow.update();
        ProgressBar progressBar = new ProgressBar(this.mActivity.getApplicationContext(), null, android.R.attr.progressBarStyleHorizontal);
        this.mProgressBar = progressBar;
        progressBar.setBackgroundColor(Color.argb(102, 0, 0, 0));
        this.mProgressBar.getProgressDrawable().setColorFilter(i, PorterDuff.Mode.SRC_IN);
        this.mProgressBar.setMax(100);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, i2), PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, 2), 48);
        int i4 = AnonymousClass2.$SwitchMap$com$playon$bridge$AdUnit$Position[position.ordinal()];
        if (i4 == 1 || i4 == 2 || i4 == 3) {
            layoutParams3 = new FrameLayout.LayoutParams(PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, i2), PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, 2), 80);
        }
        frameLayout.addView(this.mProgressBar, layoutParams3);
    }

    public void turnOnRewardCallback(AdUnit.RewardType rewardType, float f) {
        this.isRewardEnabled = true;
        this.rewardType = rewardType;
        this.rewardAmount = f;
    }

    public void turnOnPopup(AdUnit.Position position, int i, int i2) {
        this.popupPosition = position;
        this.popupXOffset = i;
        this.popupYOffset = i2;
        InitPoPup();
    }

    public void turnOnLogo(AdUnit.Position position, int i, int i2, int i3, int i4, AdUnit.ActionButtonType actionButtonType, float f) {
        int iMax = Math.max(70, Math.min(120, i3));
        int iLerp = (int) PluginUtils.lerp(6.0f, 14.0f, (iMax - 70) / 50.0f);
        String str = TAG;
        Log.d(str, Integer.valueOf(iLerp));
        int i5 = iMax - 10;
        int i6 = iMax - 15;
        this.barGrav = AdUnit.PositionToGravity(position);
        this.xBarOffset = PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, i);
        this.yBarOffset = PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, i2);
        FrameLayout frameLayout = new FrameLayout(this.mActivity.getApplicationContext());
        frameLayout.setLayoutDirection(0);
        frameLayout.setSystemUiVisibility(this.mActivity.getWindow().getAttributes().flags);
        frameLayout.setVisibility(0);
        this.mAdView.showAd((Bundle) this.mAd.getParcelableArrayList(Ad.COMPANION).get(0), i6, i6);
        this.mAdView.setListener(this);
        this.mAdView.setBackgroundColor(0);
        this.mAdView.setWebViewCornerRadius(iLerp);
        int iDensityPixelsToPixels = PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, 3);
        int iDensityPixelsToPixels2 = PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, iLerp + 3);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, 12), PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, 12), 8388691);
        layoutParams.setMargins(iDensityPixelsToPixels, 0, 0, iDensityPixelsToPixels2);
        AddAdMark(this.mAdView, layoutParams);
        SquareProgressView squareProgressView = new SquareProgressView(this.mActivity);
        this.progressSquareView = squareProgressView;
        squareProgressView.setRoundedCorners(iLerp + 2);
        this.progressSquareView.setColor(i4);
        this.progressSquareView.setCenterline(true);
        this.progressSquareView.setWidthInDp(2);
        this.progressSquareView.setProgress(0.0f, false);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(ViewCompat.MEASURED_STATE_MASK);
        gradientDrawable.setCornerRadius(PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, iLerp));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, 24), PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, 24), 8388693);
        int iDensityPixelsToPixels3 = PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, 5);
        layoutParams2.setMargins(0, 0, iDensityPixelsToPixels3, iDensityPixelsToPixels3);
        this.lineBarVisualizer.setLines(3, true);
        turnOnVisualization(gradientDrawable, layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, i5), PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, i5), 8388693);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, i5), PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, i5), 8388691);
        int i7 = AnonymousClass2.$SwitchMap$com$playon$bridge$AdUnit$ActionButtonType[actionButtonType.ordinal()];
        if (i7 == 1 || i7 == 2) {
            frameLayout.addView(this.mAdView, layoutParams4);
            frameLayout.addView(this.progressSquareView, layoutParams4);
        } else if (i7 == 3) {
            frameLayout.addView(this.mAdView, layoutParams3);
            frameLayout.addView(this.progressSquareView, layoutParams3);
        }
        frameLayout.setBackground(new ColorDrawable(0));
        AdUnit.ActionButtonType actionButtonType2 = this.isRewardEnabled ? AdUnit.ActionButtonType.None : actionButtonType;
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(ViewCompat.MEASURED_STATE_MASK);
        gradientDrawable2.setShape(1);
        int i8 = AnonymousClass2.$SwitchMap$com$playon$bridge$AdUnit$ActionButtonType[actionButtonType2.ordinal()];
        if (i8 == 1) {
            FrameLayout frameLayout2 = new FrameLayout(this.mActivity);
            AddActionButton(frameLayout2, actionButtonType2, f, gradientDrawable2);
            frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, 24), PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, 24), 8388661));
        } else if (i8 == 3) {
            FrameLayout frameLayout3 = new FrameLayout(this.mActivity);
            AddActionButton(frameLayout3, actionButtonType2, f, gradientDrawable2);
            frameLayout.addView(frameLayout3, new FrameLayout.LayoutParams(PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, 24), PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, 24), GravityCompat.START));
        }
        PopupWindow popupWindow = new PopupWindow(frameLayout, PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, iMax), PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, iMax));
        this.mLogoWindow = popupWindow;
        popupWindow.getContentView().setSystemUiVisibility(this.mActivity.getWindow().getAttributes().flags);
        PluginUtils.setPopUpWindowLayoutType(this.mLogoWindow, 1002);
        this.mLogoWindow.setTouchable(true);
        Log.d(str, "Init Logo - Done");
    }

    private void AddActionButton(FrameLayout frameLayout, AdUnit.ActionButtonType actionButtonType, float f, GradientDrawable gradientDrawable) {
        int i = AnonymousClass2.$SwitchMap$com$playon$bridge$AdUnit$ActionButtonType[actionButtonType.ordinal()];
        if (i != 1) {
            if (i != 3) {
                return;
            }
            this.mActionButtonDelay = f > 0.0f ? f : PlayOnManager.getInstance().getSettings().getSkipMs();
            this.mActionButtonDelay = Math.max(PlayOnManager.getInstance().getSettings().getMinSkipMs(), f);
            ImageButton imageButton = new ImageButton(this.mActivity.getApplicationContext());
            this.skipBtn = imageButton;
            imageButton.setBackground(gradientDrawable);
            this.skipBtn.setVisibility(8);
            this.skipBtn.setOnClickListener(new View.OnClickListener() { // from class: com.playon.bridge.AdUnitActivity$$ExternalSyntheticLambda14
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m5471lambda$AddActionButton$2$complayonbridgeAdUnitActivity(view);
                }
            });
            this.skipBtn.setImageDrawable(this.mActivity.getResources().getDrawable(this.mActivity.getResources().getIdentifier("playon_skip_template", "drawable", this.mActivity.getPackageName())));
            this.skipBtn.setAdjustViewBounds(true);
            this.skipBtn.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.skipBtn.setPadding(12, 12, 12, 12);
            frameLayout.addView(this.skipBtn, new FrameLayout.LayoutParams(PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, 24), PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, 24), 17));
            return;
        }
        this.mActionButtonDelay = f > 0.0f ? f : PlayOnManager.getInstance().getSettings().getMuteMs();
        this.mActionButtonDelay = Math.max(PlayOnManager.getInstance().getSettings().getMinMuteMs(), f);
        ImageButton imageButton2 = new ImageButton(this.mActivity.getApplicationContext());
        this.muteBtn = imageButton2;
        imageButton2.setBackground(gradientDrawable);
        this.muteBtn.setVisibility(8);
        this.muteBtn.setOnClickListener(new View.OnClickListener() { // from class: com.playon.bridge.AdUnitActivity$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m5469lambda$AddActionButton$0$complayonbridgeAdUnitActivity(view);
            }
        });
        this.muteBtn.setImageDrawable(this.mActivity.getResources().getDrawable(this.mActivity.getResources().getIdentifier("playon_mute_template", "drawable", this.mActivity.getPackageName())));
        this.muteBtn.setAdjustViewBounds(true);
        this.muteBtn.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.muteBtn.setPadding(6, 6, 6, 6);
        frameLayout.addView(this.muteBtn, new FrameLayout.LayoutParams(PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, 24), PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, 24), 17));
        ImageButton imageButton3 = new ImageButton(this.mActivity.getApplicationContext());
        this.unmuteBtn = imageButton3;
        imageButton3.setBackground(gradientDrawable);
        this.unmuteBtn.setVisibility(8);
        this.unmuteBtn.setOnClickListener(new View.OnClickListener() { // from class: com.playon.bridge.AdUnitActivity$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m5470lambda$AddActionButton$1$complayonbridgeAdUnitActivity(view);
            }
        });
        this.unmuteBtn.setImageDrawable(this.mActivity.getResources().getDrawable(this.mActivity.getResources().getIdentifier("playon_unmute_template", "drawable", this.mActivity.getPackageName())));
        this.unmuteBtn.setAdjustViewBounds(true);
        this.unmuteBtn.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.unmuteBtn.setPadding(6, 6, 6, 6);
        frameLayout.addView(this.unmuteBtn, new FrameLayout.LayoutParams(PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, 24), PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, 24), 17));
    }

    /* JADX INFO: renamed from: lambda$AddActionButton$0$com-playon-bridge-AdUnitActivity, reason: not valid java name */
    /* synthetic */ void m5469lambda$AddActionButton$0$complayonbridgeAdUnitActivity(View view) {
        muteEnabled(true);
    }

    /* JADX INFO: renamed from: lambda$AddActionButton$1$com-playon-bridge-AdUnitActivity, reason: not valid java name */
    /* synthetic */ void m5470lambda$AddActionButton$1$complayonbridgeAdUnitActivity(View view) {
        muteEnabled(false);
    }

    /* JADX INFO: renamed from: lambda$AddActionButton$2$com-playon-bridge-AdUnitActivity, reason: not valid java name */
    /* synthetic */ void m5471lambda$AddActionButton$2$complayonbridgeAdUnitActivity(View view) {
        finishWithError(8012);
    }

    private void AddAdMark(FrameLayout frameLayout, FrameLayout.LayoutParams layoutParams) {
        float fDensityPixelsToPixels = PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, 2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(ViewCompat.MEASURED_STATE_MASK);
        gradientDrawable.setAlpha(AD_MARK_TRANSPARENCY);
        gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, fDensityPixelsToPixels, fDensityPixelsToPixels, fDensityPixelsToPixels, fDensityPixelsToPixels, 0.0f, 0.0f});
        TextView textView = new TextView(this.mActivity);
        textView.setTextSize(5.0f);
        textView.setText("AD");
        textView.setTextColor(-1);
        textView.setGravity(17);
        textView.setBackground(gradientDrawable);
        frameLayout.addView(textView, layoutParams);
    }

    public void play() {
        AdSession adSession = this.adSession;
        if (adSession != null) {
            adSession.start();
        }
        this.mActive = true;
        String string = this.mAd.getString("url");
        if (this.mAudioPlayer == null) {
            try {
                this.mAudioPlayer = buildExoPlayer();
                ExoPlayerReflection.setAudioAttributes(this.mAudioPlayer, new AudioAttributes.Builder().setUsage(1).setContentType(1).build(), true);
                this.mAudioPlayer.addListener(this);
                this.mAudioPlayer.setMediaItem(MediaItem.fromUri(string));
                this.mAudioPlayer.prepare();
            } catch (Exception e) {
                Log.e(TAG, e, "MediaPlayer.setDataSource() exception:" + e.getMessage());
                finishWithError(AdUnit.ERROR_MEDIA_PLAYER_ERROR);
            }
        }
        VastProperties vastPropertiesCreateVastPropertiesForSkippableMedia = VastProperties.createVastPropertiesForSkippableMedia(PlayOnManager.getInstance().getSettings().getSkipMs(), true, Position.MIDROLL);
        AdEvents adEvents = this.adEvents;
        if (adEvents != null) {
            adEvents.loaded(vastPropertiesCreateVastPropertiesForSkippableMedia);
        }
        Log.i(TAG, "Starting Ad");
    }

    private ExoPlayer buildExoPlayer() {
        if (ExoPlayerReflection.getVersion() >= EXOPLAYER_v16) {
            return new ExoPlayer.Builder(this.mActivity).build();
        }
        return new SimpleExoPlayer.Builder(this.mActivity).build();
    }

    private void onReadyToShow() {
        Activity activity = this.mActivity;
        if ((activity == null || !activity.isFinishing()) && !this.hasImpression) {
            this.mAudioPlayer.play();
            PopupWindow popupWindow = this.mPopupWindow;
            if (popupWindow != null && !popupWindow.isShowing()) {
                this.mPopupWindow.showAtLocation(this.mActivity.getWindow().getDecorView().getRootView(), this.mPosition, 0, 0);
            }
            PopupWindow popupWindow2 = this.mLogoWindow;
            if (popupWindow2 != null && !popupWindow2.isShowing()) {
                this.mLogoWindow.showAtLocation(this.mActivity.getWindow().getDecorView().getRootView(), this.barGrav, this.xBarOffset, this.yBarOffset);
            }
            createAndStartTimer();
            ArrayList<String> stringArrayList = this.mAd.getStringArrayList(Ad.IMPRESSION_TRACKING_URLS);
            Log.d(TAG, "impression postback");
            if (stringArrayList != null) {
                Ad.trackUrls(stringArrayList);
            }
            ArrayList<String> stringArrayList2 = this.mAd.getStringArrayList(Ad.IMPRESSION_INTERNAL_TRACKING_URLS);
            HashMap map = new HashMap();
            map.put("max_volume", StatisticData.ERROR_CODE_NOT_FOUND);
            map.put("current_volume", String.valueOf(getCurrentToStreamMaxVolume()));
            if (stringArrayList2 != null) {
                Ad.trackInternalUrls(stringArrayList2, map);
            }
            AdEvents adEvents = this.adEvents;
            if (adEvents != null) {
                adEvents.impressionOccurred();
            }
            if (PlayOnManager.getInstance().getSettings().getImpressionCallbackEnabled()) {
                this.mAdListener.onImpression(new ImpressionData(this.mAdType, PlayOnManager.getInstance().getPersonalInfo().getApiKey(), PlayOnManager.getInstance().getPersonalInfo().getSessionID(), PlayOnManager.getInstance().getPersonalInfo().getCountry(), ((Bundle) this.mAd.getParcelable("price")).getDouble(Ad.PRICINGVALUE)));
            }
            this.hasImpression = true;
            this.mAdListener.onShow();
        }
    }

    private void setVolumeToLevel(int i) {
        this.mAudioManager.setStreamVolume(3, (int) ((i / 100.0f) * this.STREAM_MAX_VOLUME), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentVolume() {
        return (int) getCurrentToStreamMaxVolume();
    }

    private float getCurrentToStreamMaxVolume(int i) {
        float f = this.STREAM_MAX_VOLUME;
        if (f == 0.0f) {
            return 0.0f;
        }
        return (i / f) * getMaxVolumePercent();
    }

    private float getCurrentToStreamMaxVolume() {
        return getCurrentToStreamMaxVolume(this.mAudioManager.getStreamVolume(3));
    }

    private void setupAudioManager() {
        this.mActivity.setVolumeControlStream(3);
        if (this.mAudioVolumeObserver == null) {
            this.mAudioVolumeObserver = new AudioVolumeObserver(this.mActivity);
        }
        this.mAudioVolumeObserver.register(3, this);
        if (Build.VERSION.SDK_INT >= 26) {
            this.mAudioManager.requestAudioFocus(new AudioFocusRequest.Builder(2).setAudioAttributes(new android.media.AudioAttributes.Builder().setUsage(14).setContentType(1).build()).setAcceptsDelayedFocusGain(true).setOnAudioFocusChangeListener(new AudioManager.OnAudioFocusChangeListener() { // from class: com.playon.bridge.AdUnitActivity$$ExternalSyntheticLambda0
                @Override // android.media.AudioManager.OnAudioFocusChangeListener
                public final void onAudioFocusChange(int i) {
                    Log.d(AdUnitActivity.TAG, "Focus Changed " + i);
                }
            }).build());
        } else {
            this.mAudioManager.requestAudioFocus(new AudioManager.OnAudioFocusChangeListener() { // from class: com.playon.bridge.AdUnitActivity$$ExternalSyntheticLambda6
                @Override // android.media.AudioManager.OnAudioFocusChangeListener
                public final void onAudioFocusChange(int i) {
                    Log.d(AdUnitActivity.TAG, "Focus Changed " + i);
                }
            }, 3, 2);
        }
    }

    public void InitPoPup() {
        String str = TAG;
        Log.d(str, "Creating pop-up");
        FrameLayout frameLayout = new FrameLayout(this.mActivity.getApplicationContext());
        frameLayout.setBackground(new ColorDrawable(0));
        frameLayout.setSystemUiVisibility(this.mActivity.getWindow().getAttributes().flags);
        frameLayout.setVisibility(0);
        ImageView imageView = new ImageView(this.mActivity.getApplicationContext());
        int iDensityPixelsToPixels = PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, imageView.getMinimumWidth());
        int iDensityPixelsToPixels2 = PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, imageView.getMinimumHeight());
        if (this.rewardType == AdUnit.RewardType.EndLevel) {
            imageView.setImageDrawable(PlayOnManager.getInstance().getSettings().getEndLevelPopUpImage());
            iDensityPixelsToPixels = PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, 320);
            iDensityPixelsToPixels2 = PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, 50);
            this.popupPosition = AdUnit.Position.BottomCenter;
            this.popupXOffset = 0;
            this.popupYOffset = 0;
        } else if (this.rewardType == AdUnit.RewardType.InLevel) {
            imageView.setImageDrawable(PlayOnManager.getInstance().getSettings().getInLevelPopUpImage());
            int iDensityPixelsToPixels3 = PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, 120);
            iDensityPixelsToPixels2 = PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, 120);
            iDensityPixelsToPixels = iDensityPixelsToPixels3;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.playon.bridge.AdUnitActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m5472lambda$InitPoPup$5$complayonbridgeAdUnitActivity(view);
            }
        });
        frameLayout.addView(imageView);
        PopupWindow popupWindow = new PopupWindow(frameLayout, iDensityPixelsToPixels, iDensityPixelsToPixels2);
        this.popUp = popupWindow;
        popupWindow.getContentView().setSystemUiVisibility(this.mActivity.getWindow().getAttributes().flags);
        PluginUtils.setPopUpWindowLayoutType(this.popUp, 1002);
        this.popUp.setTouchable(true);
        Log.d(str, "Init Popup - Done");
    }

    /* JADX INFO: renamed from: lambda$InitPoPup$5$com-playon-bridge-AdUnitActivity, reason: not valid java name */
    /* synthetic */ void m5472lambda$InitPoPup$5$complayonbridgeAdUnitActivity(View view) {
        this.shouldResetStreamVolume = true;
        setVolumeToLevel(PlayOnManager.getInstance().getSettings().getRewardMinVolumeLevel());
    }

    private void checkIsVolumeValid(float f) {
        String str = TAG;
        Log.d(str, "Checking Volume, current system:" + f);
        RefreshVolume();
        if (f < PlayOnManager.getInstance().getSettings().getRewardMinVolumeLevel()) {
            PopupWindow popupWindow = this.popUp;
            if (popupWindow == null || popupWindow.isShowing()) {
                return;
            }
            Log.d(str, "Volume too low, showing popup");
            this.popUp.showAtLocation(this.mActivity.getWindow().getDecorView().getRootView(), AdUnit.PositionToGravity(this.popupPosition), this.popupXOffset, this.popupYOffset);
            pauseAd();
            this.customEventPresenter.sendTrackingEvent("internalPause", this.mAd.getString(Ad.TRACKINGEVENTPAYLOAD), 202, this.mAd.getString(Ad.TRACKINGEVENTURL), null, null);
            return;
        }
        if (this.popUp != null) {
            ExoPlayer exoPlayer = this.mAudioPlayer;
            if (exoPlayer != null && exoPlayer.getPlaybackState() == 3) {
                onReadyToShow();
            }
            if (this.popUp.isShowing()) {
                this.popUp.dismiss();
                resumeAd();
                this.customEventPresenter.sendTrackingEvent("internalResume", this.mAd.getString(Ad.TRACKINGEVENTPAYLOAD), 203, this.mAd.getString(Ad.TRACKINGEVENTURL), null, null);
            }
        }
    }

    public void onDestroy() {
        if (this.mAudioManager != null) {
            this.mAudioManager = null;
        }
        AdView adView = this.mAdView;
        if (adView != null) {
            adView.release();
            this.mAdView = null;
        }
        if (this.mAudioPlayer != null) {
            this.mAudioPlayer = null;
        }
        AudioVolumeObserver audioVolumeObserver = this.mAudioVolumeObserver;
        if (audioVolumeObserver != null) {
            audioVolumeObserver.unregister();
        }
    }

    public void finishWithError(int i) {
        this.mErrorCode = i;
        finishWithSuccess();
    }

    public void finishWithSuccess() {
        int rewardEndLevelTimeSeconds;
        this.mActive = false;
        AdUnit.AdUnitType adUnitType = this.mAdType;
        if (adUnitType != null && ((adUnitType.equals(AdUnit.AdUnitType.AudioRewardedLogoAd) || this.mAdType.equals(AdUnit.AdUnitType.AudioRewardedBannerAd)) && !this.isRewarded)) {
            CustomEventPresenter customEventPresenter = this.customEventPresenter;
            RewardEventId rewardEventId = RewardEventId.RewardRejected;
            AdUnit.RewardType rewardType = this.rewardType;
            float f = this.rewardAmount;
            String string = this.mAd.getString(Ad.TRACKINGEVENTPAYLOAD);
            if (this.rewardType == AdUnit.RewardType.InLevel) {
                rewardEndLevelTimeSeconds = PlayOnManager.getInstance().getSettings().getRewardInLevelTimeSeconds();
            } else {
                rewardEndLevelTimeSeconds = PlayOnManager.getInstance().getSettings().getRewardEndLevelTimeSeconds();
            }
            customEventPresenter.sendRewardEvent(rewardEventId, rewardType, f, string, rewardEndLevelTimeSeconds, this.mAd.getString(Ad.REWARD_REJECTED_CALLBACK_URL), getMaxVolumePercent(), getCurrentVolume());
        }
        if (this.shouldResetStreamVolume) {
            this.mAudioManager.setStreamVolume(3, this.startStreamVolumeIndex, 0);
        }
        int i = this.mErrorCode;
        if (i > 0) {
            this.mAdListener.onError(i);
        } else {
            this.mAdListener.onSuccess();
        }
        if (!this.isSkipSent) {
            if (this.mErrorCode == 8012) {
                this.customEventPresenter.sendTrackingEvent("internalVolumeChange", this.mAd.getString(Ad.TRACKINGEVENTPAYLOAD), 212, this.mAd.getString(Ad.TRACKINGEVENTURL), null, null);
                if (this.mediaTracks != null) {
                    Log.d(TAG, "skip postback " + this.mErrorCode);
                    Ad.trackUrls(this.mediaTracks.getStringArrayList(EventConstants.SKIP));
                }
                this.isSkipSent = true;
            }
            if (this.mErrorCode == 8010) {
                this.customEventPresenter.sendTrackingEvent("internalVolumeChange", this.mAd.getString(Ad.TRACKINGEVENTPAYLOAD), 211, this.mAd.getString(Ad.TRACKINGEVENTURL), null, null);
                if (this.mediaTracks != null) {
                    Log.d(TAG, "skip closeLinear");
                    Ad.trackUrls(this.mediaTracks.getStringArrayList(EventConstants.CLOSE_LINEAR));
                }
                this.isSkipSent = true;
            }
            if (this.isSkipSent && this.mediaEvents != null) {
                this.eventHandler.handleEvent(new Event() { // from class: com.playon.bridge.AdUnitActivity$$ExternalSyntheticLambda11
                    @Override // com.playon.bridge.custom_event.Event
                    public final void call() {
                        this.f$0.m5475lambda$finishWithSuccess$6$complayonbridgeAdUnitActivity();
                    }
                });
            }
        }
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
            this.mPopupWindow.setTouchable(false);
            this.mPopupWindow.update();
        }
        PopupWindow popupWindow2 = this.mLogoWindow;
        if (popupWindow2 != null) {
            popupWindow2.dismiss();
            this.mLogoWindow.setTouchable(false);
            this.mLogoWindow.update();
        }
        PopupWindow popupWindow3 = this.popUp;
        if (popupWindow3 != null) {
            popupWindow3.dismiss();
            this.popUp.setTouchable(false);
            this.popUp.update();
        }
        AdSession adSession = this.adSession;
        if (adSession != null) {
            adSession.finish();
            this.adSession = null;
        }
        ExoPlayer exoPlayer = this.mAudioPlayer;
        if (exoPlayer != null) {
            exoPlayer.stop();
            this.mAudioPlayer.removeListener(this);
            this.mAudioPlayer.release();
            this.mAudioPlayer = null;
        }
        this.mHandler.removeCallbacks(this.mUpdateTimeTask);
        onDestroy();
    }

    /* JADX INFO: renamed from: lambda$finishWithSuccess$6$com-playon-bridge-AdUnitActivity, reason: not valid java name */
    /* synthetic */ void m5475lambda$finishWithSuccess$6$complayonbridgeAdUnitActivity() {
        this.mediaEvents.skipped();
    }

    private void createAndStartTimer() {
        this.mHandler.postDelayed(this.mUpdateTimeTask, 50L);
    }

    /* JADX INFO: renamed from: com.playon.bridge.AdUnitActivity$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int currentPosition = (int) (((double) (AdUnitActivity.this.mAudioPlayer.getCurrentPosition() / AdUnitActivity.this.mAudioPlayer.getDuration())) * 100.0d);
            if (AdUnitActivity.this.lineBarVisualizer != null) {
                AdUnitActivity.this.lineBarVisualizer.invalidate();
            }
            if (!AdUnitActivity.this.isSkipShowed && AdUnitActivity.this.skipBtn != null && AdUnitActivity.this.skipBtn.getVisibility() != 0 && AdUnitActivity.this.mAudioPlayer.getCurrentPosition() >= AdUnitActivity.this.mActionButtonDelay) {
                AdUnitActivity.this.isSkipShowed = true;
                AdUnitActivity.this.skipBtn.setVisibility(0);
                if (AdUnitActivity.this.lineBarVisualizer != null && AdUnitActivity.this.lineBarShouldBeMoved && (AdUnitActivity.this.lineBarVisualizer.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                    ((ViewGroup.MarginLayoutParams) AdUnitActivity.this.lineBarVisualizer.getLayoutParams()).setMargins(0, PluginUtils.densityPixelsToPixels(AdUnitActivity.this.DENSITY_PIXELS_TO_PIXEL_SCALE, 2), PluginUtils.densityPixelsToPixels(AdUnitActivity.this.DENSITY_PIXELS_TO_PIXEL_SCALE, 24), 0);
                    AdUnitActivity.this.lineBarVisualizer.requestLayout();
                }
            }
            if (!AdUnitActivity.this.isMuteShowed && AdUnitActivity.this.muteBtn != null && AdUnitActivity.this.unmuteBtn != null && AdUnitActivity.this.mAudioPlayer.getCurrentPosition() >= AdUnitActivity.this.mActionButtonDelay) {
                AdUnitActivity.this.isMuteShowed = true;
                if (!AdUnitActivity.this.isMuteEnabled) {
                    AdUnitActivity.this.muteBtn.setVisibility(0);
                }
                if (AdUnitActivity.this.isMuteEnabled) {
                    AdUnitActivity.this.unmuteBtn.setVisibility(0);
                }
                if (AdUnitActivity.this.lineBarVisualizer != null && AdUnitActivity.this.lineBarShouldBeMoved && (AdUnitActivity.this.lineBarVisualizer.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                    ((ViewGroup.MarginLayoutParams) AdUnitActivity.this.lineBarVisualizer.getLayoutParams()).setMargins(0, PluginUtils.densityPixelsToPixels(AdUnitActivity.this.DENSITY_PIXELS_TO_PIXEL_SCALE, 2), PluginUtils.densityPixelsToPixels(AdUnitActivity.this.DENSITY_PIXELS_TO_PIXEL_SCALE, 24), 0);
                    AdUnitActivity.this.lineBarVisualizer.requestLayout();
                }
            }
            if (AdUnitActivity.this.progressSquareView != null) {
                AdUnitActivity.this.progressSquareView.setProgress(currentPosition, true);
            }
            if (AdUnitActivity.this.mProgressBar != null) {
                AdUnitActivity.this.mProgressBar.setProgress(currentPosition, true);
            }
            if (!AdUnitActivity.this.start && currentPosition >= 0) {
                AdUnitActivity.this.start = true;
                Log.d(AdUnitActivity.TAG, "start postback");
                if (AdUnitActivity.this.mediaTracks != null) {
                    Ad.trackInternalUrls(AdUnitActivity.this.mediaTracks.getStringArrayList("start"), AdUnitActivity.this.getVolumeAttributes());
                    if (AdUnitActivity.this.mediaEvents != null) {
                        AdUnitActivity.this.eventHandler.handleEvent(new Event() { // from class: com.playon.bridge.AdUnitActivity$1$$ExternalSyntheticLambda0
                            @Override // com.playon.bridge.custom_event.Event
                            public final void call() {
                                this.f$0.m5482lambda$run$0$complayonbridgeAdUnitActivity$1();
                            }
                        });
                    }
                }
            }
            if (!AdUnitActivity.this.firstQuartile && currentPosition >= 25) {
                AdUnitActivity.this.firstQuartile = true;
                Log.d(AdUnitActivity.TAG, "firstQuartile postback");
                if (AdUnitActivity.this.mediaTracks != null) {
                    Ad.trackInternalUrls(AdUnitActivity.this.mediaTracks.getStringArrayList(EventConstants.FIRST_QUARTILE), AdUnitActivity.this.getVolumeAttributes());
                }
                if (AdUnitActivity.this.mediaEvents != null) {
                    AdUnitActivity.this.eventHandler.handleEvent(new Event() { // from class: com.playon.bridge.AdUnitActivity$1$$ExternalSyntheticLambda1
                        @Override // com.playon.bridge.custom_event.Event
                        public final void call() {
                            this.f$0.m5483lambda$run$1$complayonbridgeAdUnitActivity$1();
                        }
                    });
                }
            }
            if (!AdUnitActivity.this.midpoint && currentPosition >= 50) {
                AdUnitActivity.this.midpoint = true;
                Log.d(AdUnitActivity.TAG, "midpoint postback");
                if (AdUnitActivity.this.mediaTracks != null) {
                    Ad.trackInternalUrls(AdUnitActivity.this.mediaTracks.getStringArrayList("midpoint"), AdUnitActivity.this.getVolumeAttributes());
                }
                if (AdUnitActivity.this.mediaEvents != null) {
                    AdUnitActivity.this.eventHandler.handleEvent(new Event() { // from class: com.playon.bridge.AdUnitActivity$1$$ExternalSyntheticLambda2
                        @Override // com.playon.bridge.custom_event.Event
                        public final void call() {
                            this.f$0.m5484lambda$run$2$complayonbridgeAdUnitActivity$1();
                        }
                    });
                }
            }
            if (!AdUnitActivity.this.thirdQuartile && currentPosition >= 75) {
                AdUnitActivity.this.thirdQuartile = true;
                Log.d(AdUnitActivity.TAG, "thirdQuartile postback");
                if (AdUnitActivity.this.mediaTracks != null) {
                    Ad.trackInternalUrls(AdUnitActivity.this.mediaTracks.getStringArrayList(EventConstants.THIRD_QUARTILE), AdUnitActivity.this.getVolumeAttributes());
                }
                if (AdUnitActivity.this.mediaEvents != null) {
                    AdUnitActivity.this.eventHandler.handleEvent(new Event() { // from class: com.playon.bridge.AdUnitActivity$1$$ExternalSyntheticLambda3
                        @Override // com.playon.bridge.custom_event.Event
                        public final void call() {
                            this.f$0.m5485lambda$run$3$complayonbridgeAdUnitActivity$1();
                        }
                    });
                }
            }
            if (AdUnitActivity.this.isRewardEnabled && !AdUnitActivity.this.isRewarded) {
                int i = AnonymousClass2.$SwitchMap$com$playon$bridge$AdUnit$RewardType[AdUnitActivity.this.rewardType.ordinal()];
                if (i != 1) {
                    if (i == 2 && AdUnitActivity.this.mAudioPlayer.getCurrentPosition() >= PlayOnManager.getInstance().getSettings().getRewardInLevelTimeMs()) {
                        Log.d(AdUnitActivity.TAG, "Give Reward InLevel");
                        if (AdUnitActivity.this.mAdListener != null) {
                            AdUnitActivity.this.mAdListener.onReward(AdUnitActivity.this.rewardAmount);
                        }
                        AdUnitActivity.this.customEventPresenter.sendRewardEvent(RewardEventId.RewardGranted, AdUnitActivity.this.rewardType, AdUnitActivity.this.rewardAmount, AdUnitActivity.this.mAd.getString(Ad.TRACKINGEVENTPAYLOAD), PlayOnManager.getInstance().getSettings().getRewardInLevelTimeSeconds(), AdUnitActivity.this.mAd.getString(Ad.REWARD_GRANTED_CALLBACK_URL), AdUnitActivity.this.getMaxVolumePercent(), AdUnitActivity.this.getCurrentVolume());
                        AdUnitActivity.this.isRewarded = true;
                    }
                } else if (AdUnitActivity.this.mAudioPlayer.getCurrentPosition() >= PlayOnManager.getInstance().getSettings().getRewardEndLevelTimeMs()) {
                    Log.d(AdUnitActivity.TAG, "Give Reward EndLevel");
                    if (AdUnitActivity.this.mAdListener != null) {
                        AdUnitActivity.this.mAdListener.onReward(AdUnitActivity.this.rewardAmount);
                    }
                    AdUnitActivity.this.customEventPresenter.sendRewardEvent(RewardEventId.RewardGranted, AdUnitActivity.this.rewardType, AdUnitActivity.this.rewardAmount, AdUnitActivity.this.mAd.getString(Ad.TRACKINGEVENTPAYLOAD), PlayOnManager.getInstance().getSettings().getRewardEndLevelTimeSeconds(), AdUnitActivity.this.mAd.getString(Ad.REWARD_GRANTED_CALLBACK_URL), AdUnitActivity.this.getMaxVolumePercent(), AdUnitActivity.this.getCurrentVolume());
                    AdUnitActivity.this.isRewarded = true;
                }
            }
            AdUnitActivity.this.mHandler.postDelayed(this, 50L);
        }

        /* JADX INFO: renamed from: lambda$run$0$com-playon-bridge-AdUnitActivity$1, reason: not valid java name */
        /* synthetic */ void m5482lambda$run$0$complayonbridgeAdUnitActivity$1() {
            AdUnitActivity.this.mediaEvents.start(AdUnitActivity.this.mAudioPlayer.getDuration(), AdUnitActivity.this.mAudioPlayer.getVolume() > 0.0f ? 1.0f : 0.0f);
        }

        /* JADX INFO: renamed from: lambda$run$1$com-playon-bridge-AdUnitActivity$1, reason: not valid java name */
        /* synthetic */ void m5483lambda$run$1$complayonbridgeAdUnitActivity$1() {
            AdUnitActivity.this.mediaEvents.firstQuartile();
        }

        /* JADX INFO: renamed from: lambda$run$2$com-playon-bridge-AdUnitActivity$1, reason: not valid java name */
        /* synthetic */ void m5484lambda$run$2$complayonbridgeAdUnitActivity$1() {
            AdUnitActivity.this.mediaEvents.midpoint();
        }

        /* JADX INFO: renamed from: lambda$run$3$com-playon-bridge-AdUnitActivity$1, reason: not valid java name */
        /* synthetic */ void m5485lambda$run$3$complayonbridgeAdUnitActivity$1() {
            AdUnitActivity.this.mediaEvents.thirdQuartile();
        }
    }

    /* JADX INFO: renamed from: com.playon.bridge.AdUnitActivity$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$playon$bridge$AdUnit$ActionButtonType;
        static final /* synthetic */ int[] $SwitchMap$com$playon$bridge$AdUnit$Position;
        static final /* synthetic */ int[] $SwitchMap$com$playon$bridge$AdUnit$RewardType;

        static {
            int[] iArr = new int[AdUnit.RewardType.values().length];
            $SwitchMap$com$playon$bridge$AdUnit$RewardType = iArr;
            try {
                iArr[AdUnit.RewardType.EndLevel.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$playon$bridge$AdUnit$RewardType[AdUnit.RewardType.InLevel.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[AdUnit.ActionButtonType.values().length];
            $SwitchMap$com$playon$bridge$AdUnit$ActionButtonType = iArr2;
            try {
                iArr2[AdUnit.ActionButtonType.Mute.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$playon$bridge$AdUnit$ActionButtonType[AdUnit.ActionButtonType.None.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$playon$bridge$AdUnit$ActionButtonType[AdUnit.ActionButtonType.Close.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr3 = new int[AdUnit.Position.values().length];
            $SwitchMap$com$playon$bridge$AdUnit$Position = iArr3;
            try {
                iArr3[AdUnit.Position.TopLeft.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$playon$bridge$AdUnit$Position[AdUnit.Position.TopRight.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$playon$bridge$AdUnit$Position[AdUnit.Position.TopCenter.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, String> getVolumeAttributes() {
        HashMap<String, String> map = new HashMap<>();
        map.put("max_volume", StatisticData.ERROR_CODE_NOT_FOUND);
        map.put("current_volume", String.valueOf(getCurrentToStreamMaxVolume()));
        return map;
    }

    @Override // com.playon.bridge.common.OnAudioVolumeChangedListener
    public void onAudioVolumeChanged(int i, int i2) {
        float currentToStreamMaxVolume = getCurrentToStreamMaxVolume(i);
        this.customEventPresenter.sendTrackingEvent("internalVolumeChange", this.mAd.getString(Ad.TRACKINGEVENTPAYLOAD), 210, this.mAd.getString(Ad.TRACKINGEVENTURL), 100, Integer.valueOf((int) currentToStreamMaxVolume));
        checkIsVolumeValid(currentToStreamMaxVolume);
    }

    private void muteEnabled(boolean z) {
        ImageButton imageButton;
        ImageButton imageButton2;
        this.isMuteEnabled = z;
        if (this.mAudioPlayer == null) {
            return;
        }
        RefreshVolume();
        if (z) {
            Log.d(TAG, "mute postback");
            Bundle bundle = this.mediaTracks;
            if (bundle != null) {
                Ad.trackUrls(bundle.getStringArrayList("mute"));
            }
        } else {
            Log.d(TAG, "unmute postback");
            Bundle bundle2 = this.mediaTracks;
            if (bundle2 != null) {
                Ad.trackUrls(bundle2.getStringArrayList("unmute"));
            }
        }
        if (this.isMuteShowed && !this.isMuteEnabled && (imageButton2 = this.muteBtn) != null && this.unmuteBtn != null) {
            imageButton2.setVisibility(0);
            this.unmuteBtn.setVisibility(8);
        }
        if (!this.isMuteShowed || !this.isMuteEnabled || (imageButton = this.unmuteBtn) == null || this.muteBtn == null) {
            return;
        }
        imageButton.setVisibility(0);
        this.muteBtn.setVisibility(8);
    }

    private void RefreshVolume() {
        float fClamp;
        ExoPlayer exoPlayer = this.mAudioPlayer;
        if (exoPlayer == null) {
            return;
        }
        if (this.isMuteEnabled) {
            exoPlayer.setVolume(0.0f);
            if (this.mediaEvents != null) {
                this.eventHandler.handleEvent(new Event() { // from class: com.playon.bridge.AdUnitActivity$$ExternalSyntheticLambda9
                    @Override // com.playon.bridge.custom_event.Event
                    public final void call() {
                        this.f$0.m5473lambda$RefreshVolume$7$complayonbridgeAdUnitActivity();
                    }
                });
                return;
            }
            return;
        }
        this.beforeApplicationPause = this.mAudioManager.getStreamVolume(3);
        int maxAdVolume = PlayOnManager.getInstance().getSettings().getMaxAdVolume();
        int minAdVolume = PlayOnManager.getInstance().getSettings().getMinAdVolume();
        int volumeBreakPoint = PlayOnManager.getInstance().getSettings().getVolumeBreakPoint();
        int currentToStreamMaxVolume = (int) getCurrentToStreamMaxVolume(this.mAudioManager.getStreamVolume(3));
        int i = 100 - currentToStreamMaxVolume;
        if (currentToStreamMaxVolume >= volumeBreakPoint) {
            fClamp = MathUtils.clamp((maxAdVolume / 100.0f) + (i / 100.0f), 0.0f, 1.0f);
        } else {
            fClamp = MathUtils.clamp((minAdVolume / 100.0f) + (i / 100.0f), 0.0f, 1.0f);
        }
        this.mAudioPlayer.setVolume(fClamp);
        if (this.mediaEvents != null) {
            this.eventHandler.handleEvent(new Event() { // from class: com.playon.bridge.AdUnitActivity$$ExternalSyntheticLambda10
                @Override // com.playon.bridge.custom_event.Event
                public final void call() {
                    this.f$0.m5474lambda$RefreshVolume$8$complayonbridgeAdUnitActivity();
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$RefreshVolume$7$com-playon-bridge-AdUnitActivity, reason: not valid java name */
    /* synthetic */ void m5473lambda$RefreshVolume$7$complayonbridgeAdUnitActivity() {
        this.mediaEvents.volumeChange(0.0f);
    }

    /* JADX INFO: renamed from: lambda$RefreshVolume$8$com-playon-bridge-AdUnitActivity, reason: not valid java name */
    /* synthetic */ void m5474lambda$RefreshVolume$8$complayonbridgeAdUnitActivity() {
        this.mediaEvents.volumeChange(1.0f);
    }

    private void resumeAd() {
        String str = TAG;
        Log.i(str, "resume");
        ExoPlayer exoPlayer = this.mAudioPlayer;
        if (exoPlayer == null || exoPlayer.isPlaying()) {
            return;
        }
        PopupWindow popupWindow = this.popUp;
        if (popupWindow == null || !popupWindow.isShowing()) {
            AdView adView = this.mAdView;
            if (adView != null) {
                adView.onResume();
            }
            ExoPlayer exoPlayer2 = this.mAudioPlayer;
            if (exoPlayer2 != null) {
                exoPlayer2.play();
                Log.d(str, "resume postback");
                Bundle bundle = this.mediaTracks;
                if (bundle != null) {
                    Ad.trackUrls(bundle.getStringArrayList("resume"));
                }
                if (this.mediaEvents != null) {
                    this.eventHandler.handleEvent(new Event() { // from class: com.playon.bridge.AdUnitActivity$$ExternalSyntheticLambda1
                        @Override // com.playon.bridge.custom_event.Event
                        public final void call() {
                            this.f$0.m5481lambda$resumeAd$9$complayonbridgeAdUnitActivity();
                        }
                    });
                }
                createAndStartTimer();
            }
        }
    }

    /* JADX INFO: renamed from: lambda$resumeAd$9$com-playon-bridge-AdUnitActivity, reason: not valid java name */
    /* synthetic */ void m5481lambda$resumeAd$9$complayonbridgeAdUnitActivity() {
        this.mediaEvents.resume();
    }

    public void onApplicationResume() {
        Log.i(TAG, "Application Resumed");
        this.mAudioVolumeObserver.register(3, this);
        ExoPlayer exoPlayer = this.mAudioPlayer;
        if (exoPlayer != null) {
            exoPlayer.removeListener(this);
            this.mAudioPlayer.addListener(this);
        }
        if (this.beforeApplicationPause != this.mAudioManager.getStreamVolume(3)) {
            checkIsVolumeValid(getCurrentToStreamMaxVolume());
        }
        resumeAd();
        this.customEventPresenter.sendTrackingEvent("internalResume", this.mAd.getString(Ad.TRACKINGEVENTPAYLOAD), 201, this.mAd.getString(Ad.TRACKINGEVENTURL), null, null);
        if (this.adUnitClickedEvent) {
            this.customEventPresenter.sendTrackingEvent("internalResume", this.mAd.getString(Ad.TRACKINGEVENTPAYLOAD), 209, this.mAd.getString(Ad.TRACKINGEVENTURL), null, null);
            this.adUnitClickedEvent = false;
        }
        if (Calendar.getInstance().getTime().getTime() - this.adPausedTime.getTime() >= PlayOnManager.getInstance().getSettings().getAdPauseInterval()) {
            finishWithError(8011);
        }
    }

    private void pauseAd() {
        String str = TAG;
        Log.i(str, "pause");
        ExoPlayer exoPlayer = this.mAudioPlayer;
        if (exoPlayer == null || !exoPlayer.isPlaying()) {
            return;
        }
        AdView adView = this.mAdView;
        if (adView != null) {
            adView.onPause();
        }
        if (this.mAudioPlayer != null) {
            this.adPausedTime = Calendar.getInstance().getTime();
            this.mAudioPlayer.pause();
            Log.d(str, "pause postback");
            Bundle bundle = this.mediaTracks;
            if (bundle != null) {
                Ad.trackUrls(bundle.getStringArrayList("pause"));
            }
            if (this.mediaEvents != null) {
                this.eventHandler.handleEvent(new Event() { // from class: com.playon.bridge.AdUnitActivity$$ExternalSyntheticLambda7
                    @Override // com.playon.bridge.custom_event.Event
                    public final void call() {
                        this.f$0.m5480lambda$pauseAd$10$complayonbridgeAdUnitActivity();
                    }
                });
            }
            this.mHandler.removeCallbacks(this.mUpdateTimeTask);
        }
    }

    /* JADX INFO: renamed from: lambda$pauseAd$10$com-playon-bridge-AdUnitActivity, reason: not valid java name */
    /* synthetic */ void m5480lambda$pauseAd$10$complayonbridgeAdUnitActivity() {
        this.mediaEvents.pause();
    }

    public void onApplicationPause() {
        Log.i(TAG, "Application Paused");
        this.mAudioVolumeObserver.unregister();
        ExoPlayer exoPlayer = this.mAudioPlayer;
        if (exoPlayer != null) {
            exoPlayer.removeListener(this);
        }
        pauseAd();
        this.customEventPresenter.sendTrackingEvent("internalPause", this.mAd.getString(Ad.TRACKINGEVENTPAYLOAD), 200, this.mAd.getString(Ad.TRACKINGEVENTURL), null, null);
        if (this.adUnitClickedEvent) {
            this.customEventPresenter.sendTrackingEvent("internalPause", this.mAd.getString(Ad.TRACKINGEVENTPAYLOAD), 206, this.mAd.getString(Ad.TRACKINGEVENTURL), null, null);
        }
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onPlaybackStateChanged(int i) {
        String str = TAG;
        Log.e(str, "onPlaybackStateChanged " + i);
        if (i == 2) {
            this.isBuffering = true;
            if (this.mediaEvents != null) {
                this.eventHandler.handleEvent(new Event() { // from class: com.playon.bridge.AdUnitActivity$$ExternalSyntheticLambda3
                    @Override // com.playon.bridge.custom_event.Event
                    public final void call() {
                        this.f$0.m5477x3d6ac8e6();
                    }
                });
            }
        } else if (this.isBuffering) {
            this.isBuffering = false;
            if (this.mediaEvents != null) {
                this.eventHandler.handleEvent(new Event() { // from class: com.playon.bridge.AdUnitActivity$$ExternalSyntheticLambda4
                    @Override // com.playon.bridge.custom_event.Event
                    public final void call() {
                        this.f$0.m5478x7a8a8d05();
                    }
                });
            }
        }
        if (i == 3) {
            int streamVolume = this.mAudioManager.getStreamVolume(3);
            this.startStreamVolumeIndex = streamVolume;
            Activity activity = this.mActivity;
            if (activity != null && !activity.isFinishing()) {
                checkIsVolumeValid(getCurrentToStreamMaxVolume(streamVolume));
                if (this.popUp == null) {
                    onReadyToShow();
                }
            }
        }
        if (i == 4) {
            if (!this.complete) {
                this.complete = true;
                Log.d(str, "complete postback");
                Bundle bundle = this.mediaTracks;
                if (bundle != null) {
                    Ad.trackInternalUrls(bundle.getStringArrayList("complete"), getVolumeAttributes());
                }
                if (this.mediaEvents != null) {
                    this.eventHandler.handleEvent(new Event() { // from class: com.playon.bridge.AdUnitActivity$$ExternalSyntheticLambda5
                        @Override // com.playon.bridge.custom_event.Event
                        public final void call() {
                            this.f$0.m5479xb7aa5124();
                        }
                    });
                }
            }
            finishWithSuccess();
        }
    }

    /* JADX INFO: renamed from: lambda$onPlaybackStateChanged$11$com-playon-bridge-AdUnitActivity, reason: not valid java name */
    /* synthetic */ void m5477x3d6ac8e6() {
        this.mediaEvents.bufferStart();
    }

    /* JADX INFO: renamed from: lambda$onPlaybackStateChanged$12$com-playon-bridge-AdUnitActivity, reason: not valid java name */
    /* synthetic */ void m5478x7a8a8d05() {
        this.mediaEvents.bufferFinish();
    }

    /* JADX INFO: renamed from: lambda$onPlaybackStateChanged$13$com-playon-bridge-AdUnitActivity, reason: not valid java name */
    /* synthetic */ void m5479xb7aa5124() {
        this.mediaEvents.complete();
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onPlayWhenReadyChanged(boolean z, int i) {
        Log.e(TAG, "onPlayWhenReadyChanged " + z + " " + i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onPlayerError(PlaybackException playbackException) {
        finishWithError(AdUnit.ERROR_MEDIA_PLAYER_ERROR);
    }

    /* JADX INFO: renamed from: lambda$onAdViewClicked$14$com-playon-bridge-AdUnitActivity, reason: not valid java name */
    /* synthetic */ void m5476lambda$onAdViewClicked$14$complayonbridgeAdUnitActivity() {
        this.mediaEvents.adUserInteraction(InteractionType.CLICK);
    }

    @Override // com.playon.bridge.AdView.AdViewListener
    public void onAdViewClicked(AdView adView) {
        if (this.mediaEvents != null) {
            this.eventHandler.handleEvent(new Event() { // from class: com.playon.bridge.AdUnitActivity$$ExternalSyntheticLambda8
                @Override // com.playon.bridge.custom_event.Event
                public final void call() {
                    this.f$0.m5476lambda$onAdViewClicked$14$complayonbridgeAdUnitActivity();
                }
            });
        }
        Log.d(TAG, "click postback");
        Ad.trackUrls(adView.getCompanion().getStringArrayList(Ad.COMPANION_CLICK_TRACKING_EVENT));
        this.adUnitClickedEvent = true;
        this.mAdListener.onClick();
    }

    @Override // com.playon.bridge.AdView.AdViewListener
    public void onAdViewLoaded(AdView adView) {
        Log.d(TAG, "companion postback");
        Ad.trackUrls(adView.getCompanion().getStringArrayList(Ad.COMPANION_TRACKING_EVENTS));
    }
}
