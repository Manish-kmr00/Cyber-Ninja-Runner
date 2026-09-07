package com.inmobi.ads;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.inmobi.ads.exceptions.SdkNotInitializedException;
import com.inmobi.ads.listeners.NativeAdEventListener;
import com.inmobi.ads.listeners.VideoEventListener;
import com.inmobi.media.AbstractC3327c7;
import com.inmobi.media.AbstractC3498o6;
import com.inmobi.media.AbstractC3565t3;
import com.inmobi.media.C3339d5;
import com.inmobi.media.C3341d7;
import com.inmobi.media.C3342d8;
import com.inmobi.media.C3439k7;
import com.inmobi.media.C3517pb;
import com.inmobi.media.C3531qb;
import com.inmobi.media.E9;
import com.inmobi.media.I4;
import com.inmobi.media.L4;
import com.inmobi.media.M4;
import com.inmobi.media.P7;
import com.inmobi.media.Yb;
import com.json.nu;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\n\u0018\u0000 V2\u00020\u0001:\u0003VWXB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u0018\u001a\u00020\f¢\u0006\u0004\b\u0018\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\f¢\u0006\u0004\b\u001f\u0010\u0015J\r\u0010 \u001a\u00020\f¢\u0006\u0004\b \u0010\u0015J\r\u0010!\u001a\u00020\f¢\u0006\u0004\b!\u0010\u0015J5\u0010(\u001a\u0004\u0018\u00010\"2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J\r\u0010*\u001a\u00020\f¢\u0006\u0004\b*\u0010\u0015J\r\u0010+\u001a\u00020\n¢\u0006\u0004\b+\u0010,J#\u00100\u001a\u00020\f2\u0014\u0010/\u001a\u0010\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020.\u0018\u00010-¢\u0006\u0004\b0\u00101J\u0017\u00103\u001a\u00020\f2\b\u00102\u001a\u0004\u0018\u00010.¢\u0006\u0004\b3\u00104J\u0017\u00106\u001a\u00020\f2\b\u00105\u001a\u0004\u0018\u00010.¢\u0006\u0004\b6\u00104J\r\u00107\u001a\u00020\f¢\u0006\u0004\b7\u0010\u0015R$\u0010?\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0013\u0010C\u001a\u0004\u0018\u00010@8F¢\u0006\u0006\u001a\u0004\bA\u0010BR\u0013\u0010F\u001a\u0004\u0018\u00010.8F¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0013\u0010H\u001a\u0004\u0018\u00010.8F¢\u0006\u0006\u001a\u0004\bG\u0010ER\u0013\u0010J\u001a\u0004\u0018\u00010.8F¢\u0006\u0006\u001a\u0004\bI\u0010ER\u0013\u0010L\u001a\u0004\u0018\u00010.8F¢\u0006\u0006\u001a\u0004\bK\u0010ER\u0013\u0010N\u001a\u0004\u0018\u00010.8F¢\u0006\u0006\u001a\u0004\bM\u0010ER\u0011\u0010R\u001a\u00020O8F¢\u0006\u0006\u001a\u0004\bP\u0010QR\u0011\u0010S\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bS\u0010,R\u0013\u0010T\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\bT\u0010U¨\u0006Y"}, d2 = {"Lcom/inmobi/ads/InMobiNative;", "", "Landroid/content/Context;", "context", "", "placementId", "Lcom/inmobi/ads/listeners/NativeAdEventListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Landroid/content/Context;JLcom/inmobi/ads/listeners/NativeAdEventListener;)V", "", "mPrimaryViewReturned", "", "setPrimaryViewReturned", "(Z)V", "setListener", "(Lcom/inmobi/ads/listeners/NativeAdEventListener;)V", "Lcom/inmobi/ads/listeners/VideoEventListener;", "setVideoEventListener", "(Lcom/inmobi/ads/listeners/VideoEventListener;)V", "getSignals", "()V", "", "response", "load", "([B)V", "(Landroid/content/Context;)V", "Lcom/inmobi/ads/InMobiNative$LockScreenListener;", "lockScreenListener", "showOnLockScreen", "(Lcom/inmobi/ads/InMobiNative$LockScreenListener;)V", "takeAction", "pause", "resume", "Landroid/view/View;", "convertView", "Landroid/view/ViewGroup;", "parent", "", "viewWidthInPixels", "getPrimaryViewOfWidth", "(Landroid/content/Context;Landroid/view/View;Landroid/view/ViewGroup;I)Landroid/view/View;", "reportAdClickAndOpenLandingPage", "isReady", "()Z", "", "", "extras", "setExtras", "(Ljava/util/Map;)V", "keywords", "setKeywords", "(Ljava/lang/String;)V", "contentUrl", "setContentUrl", "destroy", "Lcom/inmobi/media/c7;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/inmobi/media/c7;", "getMPubListener", "()Lcom/inmobi/media/c7;", "setMPubListener", "(Lcom/inmobi/media/c7;)V", "mPubListener", "Lorg/json/JSONObject;", "getCustomAdContent", "()Lorg/json/JSONObject;", "customAdContent", "getAdTitle", "()Ljava/lang/String;", "adTitle", "getAdDescription", "adDescription", "getAdIconUrl", "adIconUrl", "getAdLandingPageUrl", "adLandingPageUrl", "getAdCtaText", "adCtaText", "", "getAdRating", "()F", "adRating", "isAppDownload", "isVideo", "()Ljava/lang/Boolean;", "Companion", "LockScreenListener", "NativeCallbacks", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class InMobiNative {
    public static final String j = "InMobiNative";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C3342d8 f3017a;
    public final NativeCallbacks b;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public AbstractC3327c7 mPubListener;
    public VideoEventListener d;
    public WeakReference e;
    public boolean f;
    public final E9 g;
    public WeakReference h;
    public LockScreenListener i;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/inmobi/ads/InMobiNative$LockScreenListener;", "", "onActionRequired", "", "nativeAd", "Lcom/inmobi/ads/InMobiNative;", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface LockScreenListener {
        void onActionRequired(InMobiNative nativeAd);
    }

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\fJ\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\bJ\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0014\u0010\fJ\u000f\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\bJ#\u0010\u0019\u001a\u00020\u00062\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001b\u0010\bJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001c\u0010\bJ\u000f\u0010\u001d\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\bJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001e\u0010\bJ\u0017\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\rH\u0016¢\u0006\u0004\b(\u0010\u0010J\u0019\u0010+\u001a\u00020\u00062\b\u0010*\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u00102¨\u00064"}, d2 = {"Lcom/inmobi/ads/InMobiNative$NativeCallbacks;", "Lcom/inmobi/media/P7;", "Lcom/inmobi/ads/InMobiNative;", "inMobiNative", "<init>", "(Lcom/inmobi/ads/InMobiNative;)V", "", "resetHasGivenCallbackFlag", "()V", "Lcom/inmobi/ads/AdMetaInfo;", "info", "onAdFetchSuccessful", "(Lcom/inmobi/ads/AdMetaInfo;)V", "Lcom/inmobi/ads/InMobiAdRequestStatus;", "status", "onAdFetchFailed", "(Lcom/inmobi/ads/InMobiAdRequestStatus;)V", "onAdLoadSucceeded", nu.b, "onAdWillDisplay", "onAdDisplayed", "onAdDismissed", "", "", "params", nu.f, "(Ljava/util/Map;)V", "onUserLeftApplication", "onAdImpressed", "onVideoCompleted", "onVideoSkipped", "", "isMuted", "onAudioStateChanged", "(Z)V", "", "request", "onRequestPayloadCreated", "([B)V", "reason", "onRequestPayloadCreationFailed", "Lcom/inmobi/media/Yb;", "telemetryOnAdImpression", "onAdImpression", "(Lcom/inmobi/media/Yb;)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Z", "mHasGivenCallback", "", "getType", "()B", "type", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class NativeCallbacks extends P7 {

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private boolean mHasGivenCallback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NativeCallbacks(InMobiNative inMobiNative) {
            super(inMobiNative);
            Intrinsics.checkNotNullParameter(inMobiNative, "inMobiNative");
            this.mHasGivenCallback = true;
        }

        @Override // com.inmobi.ads.controllers.PublisherCallbacks
        public byte getType() {
            return (byte) 0;
        }

        @Override // com.inmobi.ads.controllers.PublisherCallbacks
        public void onAdClicked(Map<Object, ? extends Object> params) {
            Intrinsics.checkNotNullParameter(params, "params");
            InMobiNative ad = getNativeRef().get();
            if (ad == null) {
                String str = InMobiNative.j;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                AbstractC3498o6.a((byte) 1, str, "Lost reference to InMobiNative! callback cannot be given");
            } else {
                AbstractC3327c7 mPubListener = ad.getMPubListener();
                if (mPubListener != null) {
                    Intrinsics.checkNotNullParameter(ad, "ad");
                    ((C3341d7) mPubListener).f3293a.onAdClicked(ad);
                }
            }
        }

        @Override // com.inmobi.ads.controllers.PublisherCallbacks
        public void onAdDismissed() {
            InMobiNative ad = getNativeRef().get();
            if (ad == null) {
                String str = InMobiNative.j;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                AbstractC3498o6.a((byte) 1, str, "Lost reference to InMobiNative! callback cannot be given");
            } else {
                AbstractC3327c7 mPubListener = ad.getMPubListener();
                if (mPubListener != null) {
                    Intrinsics.checkNotNullParameter(ad, "ad");
                    ((C3341d7) mPubListener).f3293a.onAdFullScreenDismissed(ad);
                }
            }
        }

        @Override // com.inmobi.ads.controllers.PublisherCallbacks
        public void onAdDisplayed(AdMetaInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            InMobiNative ad = getNativeRef().get();
            if (ad == null) {
                String str = InMobiNative.j;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                AbstractC3498o6.a((byte) 1, str, "Lost reference to InMobiNative! callback cannot be given");
            } else {
                AbstractC3327c7 mPubListener = ad.getMPubListener();
                if (mPubListener != null) {
                    Intrinsics.checkNotNullParameter(ad, "ad");
                    ((C3341d7) mPubListener).f3293a.onAdFullScreenDisplayed(ad);
                }
            }
        }

        @Override // com.inmobi.ads.controllers.PublisherCallbacks
        public void onAdFetchFailed(InMobiAdRequestStatus status) {
            Intrinsics.checkNotNullParameter(status, "status");
            onAdLoadFailed(status);
        }

        @Override // com.inmobi.ads.controllers.PublisherCallbacks
        public void onAdFetchSuccessful(AdMetaInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            InMobiNative inMobiNative = getNativeRef().get();
            if (inMobiNative == null) {
                String str = InMobiNative.j;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                AbstractC3498o6.a((byte) 1, str, "Lost reference to InMobiNative! callback cannot be given");
            } else {
                AbstractC3327c7 mPubListener = inMobiNative.getMPubListener();
                if (mPubListener != null) {
                    mPubListener.a(inMobiNative, info);
                }
            }
        }

        @Override // com.inmobi.ads.controllers.PublisherCallbacks
        public void onAdImpressed() {
            InMobiNative ad = getNativeRef().get();
            if (ad == null) {
                String str = InMobiNative.j;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                AbstractC3498o6.a((byte) 1, str, "Lost reference to InMobiNative! callback cannot be given");
            } else {
                AbstractC3327c7 mPubListener = ad.getMPubListener();
                if (mPubListener != null) {
                    Intrinsics.checkNotNullParameter(ad, "ad");
                    ((C3341d7) mPubListener).f3293a.onAdImpressed(ad);
                }
            }
        }

        @Override // com.inmobi.ads.controllers.PublisherCallbacks
        public void onAdImpression(Yb telemetryOnAdImpression) {
            InMobiNative inMobiNative = getNativeRef().get();
            AbstractC3327c7 mPubListener = inMobiNative != null ? inMobiNative.getMPubListener() : null;
            if (mPubListener != null) {
                mPubListener.a(inMobiNative);
                if (telemetryOnAdImpression != null) {
                    telemetryOnAdImpression.d();
                    return;
                }
                return;
            }
            String str = InMobiNative.j;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
            AbstractC3498o6.a((byte) 1, str, "Lost reference to InMobiNative! callback cannot be given");
            if (telemetryOnAdImpression != null) {
                telemetryOnAdImpression.c();
            }
        }

        @Override // com.inmobi.ads.controllers.PublisherCallbacks
        public void onAdLoadFailed(InMobiAdRequestStatus status) {
            Intrinsics.checkNotNullParameter(status, "status");
            InMobiNative inMobiNative = getNativeRef().get();
            if (inMobiNative == null) {
                String str = InMobiNative.j;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                AbstractC3498o6.a((byte) 1, str, "Lost reference to InMobiNative! callback cannot be given");
            } else {
                if (this.mHasGivenCallback) {
                    return;
                }
                this.mHasGivenCallback = true;
                AbstractC3327c7 mPubListener = inMobiNative.getMPubListener();
                if (mPubListener != null) {
                    mPubListener.a(inMobiNative, status);
                }
            }
        }

        @Override // com.inmobi.ads.controllers.PublisherCallbacks
        public void onAdLoadSucceeded(AdMetaInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            InMobiNative inMobiNative = getNativeRef().get();
            if (inMobiNative == null) {
                String str = InMobiNative.j;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                AbstractC3498o6.a((byte) 1, str, "Lost reference to InMobiNative! callback cannot be given");
            } else {
                if (this.mHasGivenCallback) {
                    return;
                }
                this.mHasGivenCallback = true;
                AbstractC3327c7 mPubListener = inMobiNative.getMPubListener();
                if (mPubListener != null) {
                    mPubListener.b(inMobiNative, info);
                }
            }
        }

        @Override // com.inmobi.ads.controllers.PublisherCallbacks
        public void onAdWillDisplay() {
            InMobiNative ad = getNativeRef().get();
            if (ad == null) {
                String str = InMobiNative.j;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                AbstractC3498o6.a((byte) 1, str, "Lost reference to InMobiNative! callback cannot be given");
                return;
            }
            LockScreenListener lockScreenListener = ad.i;
            if (lockScreenListener != null) {
                lockScreenListener.onActionRequired(ad);
            }
            AbstractC3327c7 mPubListener = ad.getMPubListener();
            if (mPubListener != null) {
                Intrinsics.checkNotNullParameter(ad, "ad");
                ((C3341d7) mPubListener).f3293a.onAdFullScreenWillDisplay(ad);
            }
        }

        @Override // com.inmobi.ads.controllers.PublisherCallbacks
        public void onAudioStateChanged(boolean isMuted) {
            InMobiNative inMobiNative = getNativeRef().get();
            if (inMobiNative == null) {
                String str = InMobiNative.j;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                AbstractC3498o6.a((byte) 1, str, "Lost reference to InMobiNative! callback cannot be given");
            } else {
                VideoEventListener videoEventListener = inMobiNative.d;
                if (videoEventListener != null) {
                    videoEventListener.onAudioStateChanged(inMobiNative, isMuted);
                }
            }
        }

        @Override // com.inmobi.ads.controllers.PublisherCallbacks
        public void onRequestPayloadCreated(byte[] request) {
            Intrinsics.checkNotNullParameter(request, "request");
            InMobiNative inMobiNative = getNativeRef().get();
            if (inMobiNative == null) {
                String str = InMobiNative.j;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                AbstractC3498o6.a((byte) 1, str, "Lost reference to InMobiNative! callback cannot be given");
            } else {
                AbstractC3327c7 mPubListener = inMobiNative.getMPubListener();
                if (mPubListener != null) {
                    ((C3341d7) mPubListener).f3293a.onRequestPayloadCreated(request);
                }
            }
        }

        @Override // com.inmobi.ads.controllers.PublisherCallbacks
        public void onRequestPayloadCreationFailed(InMobiAdRequestStatus reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            InMobiNative inMobiNative = getNativeRef().get();
            if (inMobiNative == null) {
                String str = InMobiNative.j;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                AbstractC3498o6.a((byte) 1, str, "Lost reference to InMobiNative! callback cannot be given");
            } else {
                AbstractC3327c7 mPubListener = inMobiNative.getMPubListener();
                if (mPubListener != null) {
                    Intrinsics.checkNotNullParameter(reason, "status");
                    ((C3341d7) mPubListener).f3293a.onRequestPayloadCreationFailed(reason);
                }
            }
        }

        @Override // com.inmobi.ads.controllers.PublisherCallbacks
        public void onUserLeftApplication() {
            InMobiNative ad = getNativeRef().get();
            if (ad == null) {
                String str = InMobiNative.j;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                AbstractC3498o6.a((byte) 1, str, "Lost reference to InMobiNative! callback cannot be given");
                return;
            }
            LockScreenListener lockScreenListener = ad.i;
            if (lockScreenListener != null) {
                lockScreenListener.onActionRequired(ad);
            }
            AbstractC3327c7 mPubListener = ad.getMPubListener();
            if (mPubListener != null) {
                Intrinsics.checkNotNullParameter(ad, "ad");
                ((C3341d7) mPubListener).f3293a.onUserWillLeaveApplication(ad);
            }
        }

        @Override // com.inmobi.ads.controllers.PublisherCallbacks
        public void onVideoCompleted() {
            InMobiNative inMobiNative = getNativeRef().get();
            if (inMobiNative == null) {
                String str = InMobiNative.j;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                AbstractC3498o6.a((byte) 1, str, "Lost reference to InMobiNative! callback cannot be given");
            } else {
                VideoEventListener videoEventListener = inMobiNative.d;
                if (videoEventListener != null) {
                    videoEventListener.onVideoCompleted(inMobiNative);
                }
            }
        }

        @Override // com.inmobi.ads.controllers.PublisherCallbacks
        public void onVideoSkipped() {
            InMobiNative inMobiNative = getNativeRef().get();
            if (inMobiNative == null) {
                String str = InMobiNative.j;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                AbstractC3498o6.a((byte) 1, str, "Lost reference to InMobiNative! callback cannot be given");
            } else {
                VideoEventListener videoEventListener = inMobiNative.d;
                if (videoEventListener != null) {
                    videoEventListener.onVideoSkipped(inMobiNative);
                }
            }
        }

        public final void resetHasGivenCallbackFlag() {
            this.mHasGivenCallback = false;
        }
    }

    public InMobiNative(Context context, long j2, NativeAdEventListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        E9 e9 = new E9();
        this.g = e9;
        if (!C3517pb.q()) {
            String TAG = j;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            throw new SdkNotInitializedException(TAG);
        }
        e9.f3059a = j2;
        this.h = new WeakReference(context);
        this.mPubListener = new C3341d7(listener);
        NativeCallbacks nativeCallbacks = new NativeCallbacks(this);
        this.b = nativeCallbacks;
        this.f3017a = new C3342d8(nativeCallbacks);
    }

    public final boolean a(boolean z) {
        if (!z && this.mPubListener == null) {
            String TAG = j;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            AbstractC3498o6.a((byte) 1, TAG, "Listener supplied is null, your call is ignored.");
            return false;
        }
        if (this.h.get() != null) {
            return true;
        }
        String TAG2 = j;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        AbstractC3498o6.a((byte) 1, TAG2, "Context supplied is null, your call is ignored.");
        return false;
    }

    public final void destroy() {
        View view;
        try {
            WeakReference weakReference = this.e;
            if (weakReference == null) {
                view = null;
            } else {
                Intrinsics.checkNotNull(weakReference);
                view = (View) weakReference.get();
            }
            if (view != null) {
                ((ViewGroup) view).removeAllViews();
            }
            this.f3017a.x();
            this.mPubListener = null;
            this.d = null;
            this.f = false;
        } catch (Exception e) {
            String TAG = j;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            AbstractC3498o6.a((byte) 1, TAG, "Failed to destroy ad; SDK encountered an unexpected error");
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
        }
    }

    public final String getAdCtaText() {
        try {
            return this.f3017a.y();
        } catch (Exception e) {
            String TAG = j;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            AbstractC3498o6.a((byte) 1, TAG, "Could not get the ctaText; SDK encountered unexpected error");
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
            return null;
        }
    }

    public final String getAdDescription() {
        try {
            return this.f3017a.z();
        } catch (Exception e) {
            String TAG = j;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            AbstractC3498o6.a((byte) 1, TAG, "Could not get the description; SDK encountered unexpected error");
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
            return null;
        }
    }

    public final String getAdIconUrl() {
        try {
            return this.f3017a.A();
        } catch (Exception e) {
            String TAG = j;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            AbstractC3498o6.a((byte) 1, TAG, "Could not get the iconUrl; SDK encountered unexpected error");
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
            return null;
        }
    }

    public final String getAdLandingPageUrl() {
        try {
            return this.f3017a.B();
        } catch (Exception e) {
            String TAG = j;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            AbstractC3498o6.a((byte) 1, TAG, "Could not get the adLandingPageUrl; SDK encountered unexpected error");
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
            return null;
        }
    }

    public final float getAdRating() {
        try {
            return this.f3017a.C();
        } catch (Exception e) {
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
            AbstractC3498o6.a((byte) 1, "InMobi", "Could not get rating; SDK encountered an unexpected error");
            String TAG = j;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            return 0.0f;
        }
    }

    public final String getAdTitle() {
        try {
            return this.f3017a.D();
        } catch (Exception e) {
            String TAG = j;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            AbstractC3498o6.a((byte) 1, TAG, "Could not get the ad title; SDK encountered unexpected error");
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
            return null;
        }
    }

    public final JSONObject getCustomAdContent() {
        try {
            return this.f3017a.E();
        } catch (Exception e) {
            String TAG = j;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            AbstractC3498o6.a((byte) 1, TAG, "Could not get the ad customJson ; SDK encountered unexpected error");
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
            return null;
        }
    }

    public final AbstractC3327c7 getMPubListener() {
        return this.mPubListener;
    }

    public final View getPrimaryViewOfWidth(Context context, View convertView, ViewGroup parent, int viewWidthInPixels) {
        try {
            if (context == null) {
                String TAG = j;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                AbstractC3498o6.a((byte) 1, TAG, "View can not be rendered using null context");
                return null;
            }
            C3439k7 c3439k7 = this.f3017a.j() == null ? null : (C3439k7) this.f3017a.j();
            if (c3439k7 == null) {
                String TAG2 = j;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                AbstractC3498o6.a((byte) 1, TAG2, "InMobiNative is not initialized. Ignoring InMobiNative.getPrimaryView()");
                return null;
            }
            this.h = new WeakReference(context);
            c3439k7.a(context);
            Intrinsics.checkNotNull(parent);
            WeakReference weakReference = new WeakReference(c3439k7.a(convertView, parent, viewWidthInPixels));
            this.e = weakReference;
            View view = (View) weakReference.get();
            if (view != null) {
                this.f = true;
                return view;
            }
            String TAG3 = j;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            return null;
        } catch (Exception e) {
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
            AbstractC3498o6.a((byte) 1, "InMobi", "Could not pause ad; SDK encountered an unexpected error");
            String TAG4 = j;
            Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
            return null;
        }
    }

    public final void getSignals() {
        if (a(false)) {
            this.b.resetHasGivenCallbackFlag();
            Context context = (Context) this.h.get();
            if (context != null) {
                this.f3017a.a(this.g, context, false, "getToken");
            }
            this.f3017a.a(this.b);
        }
    }

    public final boolean isAppDownload() {
        try {
            return this.f3017a.G();
        } catch (Exception e) {
            String TAG = j;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            AbstractC3498o6.a((byte) 1, TAG, "Could not get isAppDownload; SDK encountered unexpected error");
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
            return false;
        }
    }

    public final boolean isReady() {
        return this.f3017a.F();
    }

    public final Boolean isVideo() {
        try {
            return this.f3017a.I();
        } catch (Exception e) {
            String TAG = j;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            AbstractC3498o6.a((byte) 1, TAG, "Could not get isVideo; SDK encountered unexpected error");
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
            return null;
        }
    }

    public final void load(byte[] response) {
        if (a(false)) {
            if (Build.VERSION.SDK_INT >= 29) {
                AbstractC3565t3.b((Context) this.h.get());
            }
            this.g.e = "AB";
            Context context = (Context) this.h.get();
            if (context != null) {
                this.f3017a.a(this.g, context, true, "native");
            }
            this.b.resetHasGivenCallbackFlag();
            this.f3017a.a(response, this.b);
        }
    }

    public final void pause() {
        try {
            this.f3017a.K();
        } catch (Exception unused) {
            String TAG = j;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            AbstractC3498o6.a((byte) 1, TAG, "Could not pause ad; SDK encountered an unexpected error");
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        }
    }

    public final void reportAdClickAndOpenLandingPage() {
        try {
            this.f3017a.L();
        } catch (Exception e) {
            String TAG = j;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            AbstractC3498o6.a((byte) 1, TAG, "reportAdClickAndOpenLandingPage failed; SDK encountered unexpected error");
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
        }
    }

    public final void resume() {
        try {
            this.f3017a.M();
        } catch (Exception unused) {
            String TAG = j;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            AbstractC3498o6.a((byte) 1, TAG, "Could not resume ad; SDK encountered an unexpected error");
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        }
    }

    public final void setContentUrl(String contentUrl) {
        this.g.f = contentUrl;
    }

    public final void setExtras(Map<String, String> extras) {
        if (extras != null) {
            C3531qb.a(extras.get("tp"));
            C3531qb.b(extras.get("tp-v"));
        }
        this.g.c = extras;
    }

    public final void setKeywords(String keywords) {
        this.g.b = keywords;
    }

    public final void setListener(NativeAdEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mPubListener = new C3341d7(listener);
    }

    public final void setMPubListener(AbstractC3327c7 abstractC3327c7) {
        this.mPubListener = abstractC3327c7;
    }

    public final void setPrimaryViewReturned(boolean mPrimaryViewReturned) {
        this.f = mPrimaryViewReturned;
    }

    public final void setVideoEventListener(VideoEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.d = listener;
    }

    public final void showOnLockScreen(LockScreenListener lockScreenListener) {
        Intrinsics.checkNotNullParameter(lockScreenListener, "lockScreenListener");
        if (this.h.get() == null) {
            String TAG = j;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            AbstractC3498o6.a((byte) 1, TAG, "InMobiNative is not initialized. Provided context is null. Ignoring showOnLockScreen");
            return;
        }
        try {
            C3342d8 c3342d8 = this.f3017a;
            E9 e9 = this.g;
            Object obj = this.h.get();
            Intrinsics.checkNotNull(obj);
            c3342d8.a(e9, (Context) obj);
            this.i = lockScreenListener;
        } catch (Exception unused) {
            String TAG2 = j;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            AbstractC3498o6.a((byte) 1, TAG2, "SDK encountered unexpected error in showOnLockScreen");
        }
    }

    public final void takeAction() {
        try {
            this.f3017a.N();
        } catch (Exception unused) {
            String TAG = j;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            AbstractC3498o6.a((byte) 1, TAG, "SDK encountered unexpected error in takeAction");
        }
    }

    public final void load() {
        try {
            if (a(true)) {
                this.b.resetHasGivenCallbackFlag();
                if (this.f) {
                    C3342d8 c3342d8 = this.f3017a;
                    c3342d8.a(c3342d8.j(), new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.REPETITIVE_LOAD));
                    String TAG = j;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    AbstractC3498o6.a((byte) 1, TAG, "You can call load() on an instance of InMobiNative only once if the ad request has been successful. Ignoring InMobiNative.load()");
                    return;
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    AbstractC3565t3.b((Context) this.h.get());
                }
                this.g.e = "NonAB";
                Context context = (Context) this.h.get();
                if (context != null) {
                    this.f3017a.a(this.g, context, true, "native");
                }
                this.f3017a.J();
            }
        } catch (Exception e) {
            this.f3017a.a((short) 2192);
            AbstractC3327c7 abstractC3327c7 = this.mPubListener;
            if (abstractC3327c7 != null) {
                abstractC3327c7.a(this, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
            }
            L4 l4P = this.f3017a.p();
            if (l4P != null) {
                String TAG2 = j;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((M4) l4P).a(TAG2, "Load failed with unexpected error: ", e);
            }
        }
    }

    public final void load(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (a(true)) {
            this.h = new WeakReference(context);
            load();
        }
    }
}
