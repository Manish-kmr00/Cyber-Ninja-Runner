package net.pubnative.lite.sdk.contentinfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import net.pubnative.lite.sdk.core.R;
import net.pubnative.lite.sdk.models.Ad;
import net.pubnative.lite.sdk.mraid.MRAIDInterstitial;
import net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener;
import net.pubnative.lite.sdk.mraid.MRAIDView;
import net.pubnative.lite.sdk.mraid.MRAIDViewListener;
import net.pubnative.lite.sdk.utils.URLValidator;
import net.pubnative.lite.sdk.utils.UrlHandler;
import net.pubnative.lite.sdk.views.ProgressDialogView;
import net.pubnative.lite.sdk.vpaid.helpers.SimpleTimer;

/* JADX INFO: loaded from: classes11.dex */
public class AdFeedbackActivity extends Activity implements MRAIDViewListener, MRAIDNativeFeatureListener {
    public static final String EXTRA_FEEDBACK_FORM_CALLBACK = "extra_feedback_form_callback";
    public static final String EXTRA_FEEDBACK_FORM_DATA = "extra_feedback_form_data";
    public static final String EXTRA_FEEDBACK_FORM_URL = "extra_feedback_form_url";
    private ResultReceiver callback;
    private String feedbackFormUrl;
    private AdFeedbackData mAdFeedbackData;
    private SimpleTimer mFeedbackFormExpirationTimer;
    private Boolean mIsFeedbackFormLoading = false;
    private UrlHandler mUrlHandlerDelegate;
    private MRAIDInterstitial mViewContainer;
    ProgressDialogView progressDialogView;
    RelativeLayout rootLayout;

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.C, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener
    public void mraidNativeFeatureCallTel(String str) {
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener
    public void mraidNativeFeatureCreateCalendarEvent(String str) {
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener
    public void mraidNativeFeaturePlayVideo(String str) {
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener
    public void mraidNativeFeatureSendSms(String str) {
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener
    public void mraidNativeFeatureStorePicture(String str) {
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
    public void mraidShowCloseButton() {
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
    public void mraidViewExpand(MRAIDView mRAIDView) {
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
    public boolean mraidViewResize(MRAIDView mRAIDView, int i, int i2, int i3, int i4) {
        return false;
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
    public void onExpandedAdClosed() {
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        if (getResources().getConfiguration().orientation == 2) {
            setRequestedOrientation(0);
        }
        if (getResources().getConfiguration().orientation == 1) {
            setRequestedOrientation(1);
        }
        super.onCreate(bundle);
        Intent intent = getIntent();
        initVariables();
        getDataFromIntent(intent);
        loadFeedbackForm();
        initUi();
        initRootView();
        initViews();
        startProgress();
    }

    private void initRootView() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.rootLayout = relativeLayout;
        relativeLayout.setLayoutParams(layoutParams);
        setContentView(this.rootLayout);
    }

    private void initViews() {
        this.progressDialogView = new ProgressDialogView(this);
        this.rootLayout.addView(this.progressDialogView, new RelativeLayout.LayoutParams(-1, -1));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString(EXTRA_FEEDBACK_FORM_URL, this.feedbackFormUrl);
        bundle.putParcelable(EXTRA_FEEDBACK_FORM_CALLBACK, this.callback);
        bundle.putSerializable(EXTRA_FEEDBACK_FORM_DATA, this.mAdFeedbackData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        this.callback = (ResultReceiver) bundle.getParcelable(EXTRA_FEEDBACK_FORM_CALLBACK);
        this.feedbackFormUrl = bundle.getString(EXTRA_FEEDBACK_FORM_URL);
        this.mAdFeedbackData = (AdFeedbackData) bundle.getSerializable(EXTRA_FEEDBACK_FORM_DATA);
        super.onRestoreInstanceState(bundle);
    }

    private void initUi() {
        getWindow().addFlags(1024);
        getWindow().clearFlags(2048);
    }

    private void initVariables() {
        this.mUrlHandlerDelegate = new UrlHandler(this);
    }

    private void getDataFromIntent(Intent intent) {
        try {
            if (intent.hasExtra(EXTRA_FEEDBACK_FORM_CALLBACK)) {
                this.callback = (ResultReceiver) intent.getParcelableExtra(EXTRA_FEEDBACK_FORM_CALLBACK);
            }
            if (intent.hasExtra(EXTRA_FEEDBACK_FORM_URL) && !TextUtils.isEmpty(intent.getStringExtra(EXTRA_FEEDBACK_FORM_URL))) {
                this.feedbackFormUrl = intent.getStringExtra(EXTRA_FEEDBACK_FORM_URL);
            } else {
                sendError();
                finish();
            }
            if (intent.hasExtra(EXTRA_FEEDBACK_FORM_DATA) && intent.getSerializableExtra(EXTRA_FEEDBACK_FORM_DATA) != null) {
                this.mAdFeedbackData = (AdFeedbackData) intent.getSerializableExtra(EXTRA_FEEDBACK_FORM_DATA);
            } else {
                sendError();
                finish();
            }
        } catch (Exception unused) {
            sendError();
            finish();
        }
    }

    private void startProgress() {
        this.mIsFeedbackFormLoading = true;
        cancelExistingFeedbackTimer();
        showProgressDialog(null, getString(R.string.loading));
        SimpleTimer simpleTimer = new SimpleTimer(10000L, new SimpleTimer.Listener() { // from class: net.pubnative.lite.sdk.contentinfo.AdFeedbackActivity.1
            @Override // net.pubnative.lite.sdk.vpaid.helpers.SimpleTimer.Listener
            public void onTick(long j) {
            }

            @Override // net.pubnative.lite.sdk.vpaid.helpers.SimpleTimer.Listener
            public void onFinish() {
                if (AdFeedbackActivity.this.mIsFeedbackFormLoading.booleanValue()) {
                    AdFeedbackActivity.this.finish();
                }
            }
        });
        this.mFeedbackFormExpirationTimer = simpleTimer;
        simpleTimer.start();
    }

    private void loadFeedbackForm() {
        if (this.feedbackFormUrl == null) {
            sendError();
            finish();
        }
        MRAIDInterstitial mRAIDInterstitial = new MRAIDInterstitial(this, this.feedbackFormUrl, null, true, true, new String[]{"calendar", "inlineVideo", "sms", "storePicture", "tel", "location"}, this, this, null);
        this.mViewContainer = mRAIDInterstitial;
        mRAIDInterstitial.markCreativeAdComingFromFeedbackForm();
        this.mViewContainer.setVisibility(4);
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener
    public void mraidNativeFeatureOpenBrowser(String str) {
        this.mUrlHandlerDelegate.handleUrl(str, null);
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
    public void mraidViewLoaded(MRAIDView mRAIDView) {
        this.mIsFeedbackFormLoading = false;
        new FeedbackJSInterface().submitData(this.mAdFeedbackData, mRAIDView);
        hideProgressDialog();
        sendOpenAction();
        if (URLValidator.isValidURL(this.feedbackFormUrl)) {
            this.mViewContainer.show(this, new MRAIDView.OnExpandCreativeFailListener() { // from class: net.pubnative.lite.sdk.contentinfo.AdFeedbackActivity$$ExternalSyntheticLambda0
                @Override // net.pubnative.lite.sdk.mraid.MRAIDView.OnExpandCreativeFailListener
                public final void onExpandFailed() {
                    this.f$0.m9595x9d9d03b2();
                }
            }, this.feedbackFormUrl);
        } else {
            sendError();
            finish();
        }
    }

    /* JADX INFO: renamed from: lambda$mraidViewLoaded$0$net-pubnative-lite-sdk-contentinfo-AdFeedbackActivity, reason: not valid java name */
    /* synthetic */ void m9595x9d9d03b2() {
        this.mViewContainer.showDefaultContentInfoURL(Ad.CONTENT_INFO_LINK_URL);
        sendError();
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
    public void mraidViewError(MRAIDView mRAIDView) {
        sendError();
        finish();
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
    public void mraidViewClose(MRAIDView mRAIDView) {
        finish();
    }

    public void showProgressDialog(String str, String str2) {
        this.progressDialogView.show(str, str2);
        getWindow().setFlags(16, 16);
    }

    public void hideProgressDialog() {
        this.progressDialogView.hide();
        getWindow().clearFlags(16);
    }

    private void sendCloseAction() {
        ResultReceiver resultReceiver = this.callback;
        if (resultReceiver != null) {
            resultReceiver.send(AdFeedbackFormHelper.FeedbackFormAction.CLOSE.code, null);
        }
    }

    private void sendOpenAction() {
        ResultReceiver resultReceiver = this.callback;
        if (resultReceiver != null) {
            resultReceiver.send(AdFeedbackFormHelper.FeedbackFormAction.OPEN.code, null);
        }
    }

    private void sendError() {
        ResultReceiver resultReceiver = this.callback;
        if (resultReceiver != null) {
            resultReceiver.send(AdFeedbackFormHelper.FeedbackFormAction.ERROR.code, null);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        sendCloseAction();
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        finish();
    }

    private void cancelExistingFeedbackTimer() {
        SimpleTimer simpleTimer = this.mFeedbackFormExpirationTimer;
        if (simpleTimer != null) {
            simpleTimer.cancel();
        }
    }
}
