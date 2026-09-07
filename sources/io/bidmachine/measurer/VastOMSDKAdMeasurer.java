package io.bidmachine.measurer;

import android.text.TextUtils;
import android.view.View;
import com.iab.omid.library.appodeal.adsession.AdEvents;
import com.iab.omid.library.appodeal.adsession.AdSessionConfiguration;
import com.iab.omid.library.appodeal.adsession.AdSessionContext;
import com.iab.omid.library.appodeal.adsession.CreativeType;
import com.iab.omid.library.appodeal.adsession.ImpressionType;
import com.iab.omid.library.appodeal.adsession.Owner;
import com.iab.omid.library.appodeal.adsession.Partner;
import com.iab.omid.library.appodeal.adsession.VerificationScriptResource;
import com.iab.omid.library.appodeal.adsession.media.Position;
import com.iab.omid.library.appodeal.adsession.media.VastProperties;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.iab.measurer.VastAdMeasurer;
import io.bidmachine.iab.vast.VastPlaybackListener;
import io.bidmachine.iab.vast.VastRequest;
import io.bidmachine.iab.vast.processor.VastAd;
import io.bidmachine.iab.vast.tags.AdVerificationsExtensionTag;
import io.bidmachine.iab.vast.tags.JavaScriptResourceTag;
import io.bidmachine.iab.vast.tags.VerificationTag;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class VastOMSDKAdMeasurer extends OMSDKAdMeasurer<View> implements VastAdMeasurer, VastPlaybackListener {
    private static final boolean IS_AUTO_PLAY = true;
    private final List<VerificationScriptResource> resourceList = new ArrayList();
    private Float skipOffset;

    @Override // io.bidmachine.iab.measurer.VastAdMeasurer
    public void onVastModelLoaded(final VastRequest vastRequest) {
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.measurer.VastOMSDKAdMeasurer.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    VastOMSDKAdMeasurer.this.setupAdMeasurer(vastRequest);
                    VastOMSDKAdMeasurer vastOMSDKAdMeasurer = VastOMSDKAdMeasurer.this;
                    vastOMSDKAdMeasurer.startAdSession(vastOMSDKAdMeasurer.resourceList);
                } catch (Throwable th) {
                    Logger.w(th);
                }
            }
        });
    }

    public void setupAdMeasurer(final VastRequest vastRequest) {
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.measurer.VastOMSDKAdMeasurer.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    VastAd vastAd = vastRequest.getVastAd();
                    VastOMSDKAdMeasurer.this.addVerificationScriptResourceList(vastAd != null ? vastAd.getAdVerificationsExtensionList() : null);
                    VastOMSDKAdMeasurer.this.setSkipOffset(Float.valueOf(vastRequest.getFusedVideoCloseTimeSec()));
                } catch (Throwable th) {
                    Logger.w(th);
                }
            }
        });
    }

    public void addVerificationScriptResourceList(final List<AdVerificationsExtensionTag> list) {
        if (list == null) {
            return;
        }
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.measurer.VastOMSDKAdMeasurer.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    for (AdVerificationsExtensionTag adVerificationsExtensionTag : list) {
                        if (adVerificationsExtensionTag != null) {
                            for (VerificationTag verificationTag : adVerificationsExtensionTag.getVerificationTagList()) {
                                JavaScriptResourceTag javaScriptResourceTag = verificationTag.getJavaScriptResourceTag();
                                String text = javaScriptResourceTag != null ? javaScriptResourceTag.getText() : null;
                                String vendor = verificationTag.getVendor();
                                String verificationParameters = verificationTag.getVerificationParameters();
                                if (!TextUtils.isEmpty(text)) {
                                    VastOMSDKAdMeasurer.this.addVerificationScriptResource(text, vendor, verificationParameters);
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                    Logger.w(th);
                }
            }
        });
    }

    public void addVerificationScriptResource(String str, String str2, String str3) {
        VerificationScriptResource verificationScriptResourceCreateVerificationScriptResourceWithoutParameters;
        try {
            URL url = new URL(str);
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                verificationScriptResourceCreateVerificationScriptResourceWithoutParameters = VerificationScriptResource.createVerificationScriptResourceWithParameters(str2, url, str3);
            } else {
                verificationScriptResourceCreateVerificationScriptResourceWithoutParameters = VerificationScriptResource.createVerificationScriptResourceWithoutParameters(url);
            }
            this.resourceList.add(verificationScriptResourceCreateVerificationScriptResourceWithoutParameters);
        } catch (Throwable th) {
            Logger.w(th);
        }
    }

    public void setSkipOffset(Float f) {
        this.skipOffset = f;
    }

    protected void startAdSession(final List<VerificationScriptResource> list) {
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.measurer.VastOMSDKAdMeasurer.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Partner partner = OMSDKSettings.getPartner();
                    if (partner != null && !VastOMSDKAdMeasurer.this.isSessionPrepared()) {
                        VastOMSDKAdMeasurer.this.prepareAdSession(AdSessionConfiguration.createAdSessionConfiguration(CreativeType.VIDEO, ImpressionType.BEGIN_TO_RENDER, Owner.NATIVE, Owner.NATIVE, false), AdSessionContext.createNativeAdSessionContext(partner, OMSDKSettings.OM_JS, list, "", ""));
                    }
                } catch (Throwable th) {
                    Logger.w(th);
                }
            }
        });
    }

    @Override // io.bidmachine.measurer.OMSDKAdMeasurer
    protected void onAdLoaded(AdEvents adEvents) throws Throwable {
        VastProperties vastPropertiesCreateVastPropertiesForSkippableMedia;
        Float f = this.skipOffset;
        if (f == null) {
            vastPropertiesCreateVastPropertiesForSkippableMedia = VastProperties.createVastPropertiesForNonSkippableMedia(true, Position.STANDALONE);
        } else {
            vastPropertiesCreateVastPropertiesForSkippableMedia = VastProperties.createVastPropertiesForSkippableMedia(f.floatValue(), true, Position.STANDALONE);
        }
        adEvents.loaded(vastPropertiesCreateVastPropertiesForSkippableMedia);
        log("onAdLoaded");
    }

    @Override // io.bidmachine.iab.vast.VastPlaybackListener
    public void onVideoStarted(float f, float f2) {
        onMediaStarted(f, f2);
    }

    @Override // io.bidmachine.iab.vast.VastPlaybackListener
    public void onVideoFirstQuartile() {
        onMediaFirstQuartile();
    }

    @Override // io.bidmachine.iab.vast.VastPlaybackListener
    public void onVideoMidpoint() {
        onMediaMidpoint();
    }

    @Override // io.bidmachine.iab.vast.VastPlaybackListener
    public void onVideoThirdQuartile() {
        onMediaThirdQuartile();
    }

    @Override // io.bidmachine.iab.vast.VastPlaybackListener
    public void onVideoCompleted() {
        onMediaCompleted();
    }

    @Override // io.bidmachine.iab.vast.VastPlaybackListener
    public void onVideoPaused() {
        onMediaPaused();
    }

    @Override // io.bidmachine.iab.vast.VastPlaybackListener
    public void onVideoResumed() {
        onMediaResumed();
    }

    @Override // io.bidmachine.iab.vast.VastPlaybackListener
    public void onVideoVolumeChanged(float f) {
        onMediaVolumeChanged(f);
    }

    @Override // io.bidmachine.iab.vast.VastPlaybackListener
    public void onVideoSkipped() {
        onMediaSkipped();
    }
}
