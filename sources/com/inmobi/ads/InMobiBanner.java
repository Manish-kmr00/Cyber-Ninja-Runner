package com.inmobi.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.inmobi.ads.banner.AudioListener;
import com.inmobi.ads.controllers.PublisherCallbacks;
import com.inmobi.ads.exceptions.InvalidPlacementIdException;
import com.inmobi.ads.exceptions.SdkNotInitializedException;
import com.inmobi.ads.listeners.BannerAdEventListener;
import com.inmobi.media.AbstractC3498o6;
import com.inmobi.media.AbstractC3534r1;
import com.inmobi.media.AbstractC3565t3;
import com.inmobi.media.B1;
import com.inmobi.media.C3517pb;
import com.inmobi.media.C3531qb;
import com.inmobi.media.C3548s1;
import com.inmobi.media.C3579u3;
import com.inmobi.media.C3633y1;
import com.inmobi.media.E4;
import com.inmobi.media.E9;
import com.inmobi.media.EnumC3479n1;
import com.inmobi.media.F4;
import com.inmobi.media.G4;
import com.inmobi.media.HandlerC3647z1;
import com.inmobi.media.L4;
import com.inmobi.media.Lb;
import com.inmobi.media.M4;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 ~2\u00020\u0001:\u0004\u007fR\u0080\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0010\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0010\u0010\rJ\u000f\u0010\u0013\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\u0012\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0010\u0010\u0014J#\u0010\u0018\u001a\u00020\u000b2\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u0016¢\u0006\u0004\b\u001e\u0010\u001cJ\u0015\u0010!\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u0015\u0010%\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J\u0015\u0010)\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J\u0015\u0010-\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b-\u0010.J\r\u0010/\u001a\u00020\u000b¢\u0006\u0004\b/\u0010\rJ\u000f\u00100\u001a\u00020\u000bH\u0014¢\u0006\u0004\b0\u0010\rJ\u000f\u00101\u001a\u00020\u000bH\u0014¢\u0006\u0004\b1\u0010\rJ\u0015\u00104\u001a\u00020\u000b2\u0006\u00103\u001a\u000202¢\u0006\u0004\b4\u00105J!\u00108\u001a\u00020\u000b2\b\b\u0001\u00106\u001a\u00020'2\b\b\u0001\u00107\u001a\u00020'¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u000bH\u0007¢\u0006\u0004\b:\u0010\rJ\u001f\u0010>\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020;2\u0006\u0010=\u001a\u00020'H\u0014¢\u0006\u0004\b>\u0010?J\u0017\u0010A\u001a\u00020\u000b2\u0006\u0010@\u001a\u00020#H\u0016¢\u0006\u0004\bA\u0010&J\u000f\u0010C\u001a\u00020\u000bH\u0000¢\u0006\u0004\bB\u0010\rJ\u000f\u0010E\u001a\u00020\u000bH\u0001¢\u0006\u0004\bD\u0010\rJ\r\u0010F\u001a\u00020\u000b¢\u0006\u0004\bF\u0010\rJ\r\u0010G\u001a\u00020\u000b¢\u0006\u0004\bG\u0010\rJ\r\u0010H\u001a\u00020\b¢\u0006\u0004\bH\u0010IJ\u0015\u0010L\u001a\u00020\u000b2\u0006\u0010K\u001a\u00020J¢\u0006\u0004\bL\u0010MJ\r\u0010N\u001a\u00020#¢\u0006\u0004\bN\u0010OJ\u000f\u0010P\u001a\u00020\u000bH\u0007¢\u0006\u0004\bP\u0010\rR$\u0010X\u001a\u0004\u0018\u00010Q8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR$\u0010^\u001a\u0004\u0018\u00010J8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010MR\"\u0010f\u001a\u00020_8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR$\u0010n\u001a\u0004\u0018\u00010g8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\u001a\u0010t\u001a\u00020o8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bp\u0010q\u001a\u0004\br\u0010sR\u0017\u0010z\u001a\u00020u8\u0006¢\u0006\f\n\u0004\bv\u0010w\u001a\u0004\bx\u0010yR\u0014\u0010}\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b{\u0010|¨\u0006\u0081\u0001"}, d2 = {"Lcom/inmobi/ads/InMobiBanner;", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "placementId", "(Landroid/content/Context;J)V", "", "getSignals", "()V", "", "response", "load", "([B)V", "refreshBanner$media_release", "refreshBanner", "(Landroid/content/Context;)V", "", "", "extras", "setExtras", "(Ljava/util/Map;)V", "keywords", "setKeywords", "(Ljava/lang/String;)V", "contentUrl", "setContentUrl", "Lcom/inmobi/ads/listeners/BannerAdEventListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setListener", "(Lcom/inmobi/ads/listeners/BannerAdEventListener;)V", "", "enabled", "setEnableAutoRefresh", "(Z)V", "", POBConstants.KEY_REFRESH_INTERVAL, "setRefreshInterval", "(I)V", "Lcom/inmobi/ads/InMobiBanner$AnimationType;", "animationType", "setAnimationType", "(Lcom/inmobi/ads/InMobiBanner$AnimationType;)V", "disableHardwareAcceleration", "onAttachedToWindow", "onDetachedFromWindow", "Lcom/inmobi/ads/WatermarkData;", "watermarkData", "setWatermarkData", "(Lcom/inmobi/ads/WatermarkData;)V", "widthInDp", "heightInDp", "setBannerSize", "(II)V", "setupBannerSizeObserver", "Landroid/view/View;", "changedView", "visibility", "onVisibilityChanged", "(Landroid/view/View;I)V", "hasWindowFocus", "onWindowFocusChanged", "scheduleRefresh$media_release", "scheduleRefresh", "swapAdUnitsAndDisplayAd$media_release", "swapAdUnitsAndDisplayAd", "resume", "pause", "getPlacementId", "()J", "Lcom/inmobi/ads/banner/AudioListener;", "audioListener", "setAudioListener", "(Lcom/inmobi/ads/banner/AudioListener;)V", "isAudioAd", "()Z", "destroy", "Lcom/inmobi/media/r1;", "a", "Lcom/inmobi/media/r1;", "getMPubListener$media_release", "()Lcom/inmobi/media/r1;", "setMPubListener$media_release", "(Lcom/inmobi/media/r1;)V", "mPubListener", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/inmobi/ads/banner/AudioListener;", "getMAudioListener$media_release", "()Lcom/inmobi/ads/banner/AudioListener;", "setMAudioListener$media_release", "mAudioListener", "Lcom/inmobi/media/n1;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/inmobi/media/n1;", "getAudioStatusInternal$media_release", "()Lcom/inmobi/media/n1;", "setAudioStatusInternal$media_release", "(Lcom/inmobi/media/n1;)V", "audioStatusInternal", "Lcom/inmobi/media/B1;", "d", "Lcom/inmobi/media/B1;", "getMAdManager$media_release", "()Lcom/inmobi/media/B1;", "setMAdManager$media_release", "(Lcom/inmobi/media/B1;)V", "mAdManager", "Lcom/inmobi/media/E9;", "n", "Lcom/inmobi/media/E9;", "getMPubSettings$media_release", "()Lcom/inmobi/media/E9;", "mPubSettings", "Lcom/inmobi/ads/PreloadManager;", "o", "Lcom/inmobi/ads/PreloadManager;", "getPreloadManager", "()Lcom/inmobi/ads/PreloadManager;", "preloadManager", "getFrameSizeString", "()Ljava/lang/String;", "frameSizeString", "Companion", "AnimationType", "com/inmobi/media/E4", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class InMobiBanner extends RelativeLayout {
    public static final E4 Companion = new E4();

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public AbstractC3534r1 mPubListener;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public AudioListener mAudioListener;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public EnumC3479n1 audioStatusInternal;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public B1 mAdManager;
    public final a e;
    public int f;
    public boolean g;
    public final HandlerC3647z1 h;
    public int i;
    public int j;
    public AnimationType k;
    public long l;
    public WeakReference m;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public final E9 mPubSettings;
    public final e o;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/inmobi/ads/InMobiBanner$AnimationType;", "", "(Ljava/lang/String;I)V", "ANIMATION_OFF", "ROTATE_HORIZONTAL_AXIS", "ANIMATION_ALPHA", "ROTATE_VERTICAL_AXIS", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public enum AnimationType {
        ANIMATION_OFF,
        ROTATE_HORIZONTAL_AXIS,
        ANIMATION_ALPHA,
        ROTATE_VERTICAL_AXIS;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<AnimationType> getEntries() {
            return $ENTRIES;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/inmobi/ads/InMobiBanner$a;", "Lcom/inmobi/media/y1;", "Lcom/inmobi/ads/InMobiBanner;", "banner", "<init>", "(Lcom/inmobi/ads/InMobiBanner;)V", "Lcom/inmobi/ads/AdMetaInfo;", "info", "", "onAdFetchSuccessful", "(Lcom/inmobi/ads/AdMetaInfo;)V", "Lcom/inmobi/ads/InMobiAdRequestStatus;", "status", "onAdFetchFailed", "(Lcom/inmobi/ads/InMobiAdRequestStatus;)V", "", "getType", "()B", "type", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class a extends C3633y1 {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InMobiBanner banner) {
            super(banner);
            Intrinsics.checkNotNullParameter(banner, "banner");
        }

        @Override // com.inmobi.media.C3633y1, com.inmobi.ads.controllers.PublisherCallbacks
        public byte getType() {
            return (byte) 0;
        }

        @Override // com.inmobi.media.C3633y1, com.inmobi.ads.controllers.PublisherCallbacks
        public void onAdFetchFailed(InMobiAdRequestStatus status) {
            Intrinsics.checkNotNullParameter(status, "status");
            InMobiBanner inMobiBanner = a().get();
            if (inMobiBanner == null) {
                return;
            }
            AbstractC3534r1 mPubListener = inMobiBanner.getMPubListener();
            if (mPubListener != null) {
                mPubListener.a(inMobiBanner, status);
            }
            inMobiBanner.scheduleRefresh$media_release();
        }

        @Override // com.inmobi.media.C3633y1, com.inmobi.ads.controllers.PublisherCallbacks
        public void onAdFetchSuccessful(AdMetaInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            super.onAdFetchSuccessful(info);
            InMobiBanner inMobiBanner = a().get();
            if (inMobiBanner != null) {
                try {
                    B1 mAdManager = inMobiBanner.getMAdManager();
                    if (mAdManager != null) {
                        mAdManager.G();
                    }
                } catch (IllegalStateException e) {
                    String strAccess$getTAG$cp = InMobiBanner.access$getTAG$cp();
                    Intrinsics.checkNotNullExpressionValue(strAccess$getTAG$cp, "access$getTAG$cp(...)");
                    AbstractC3498o6.a((byte) 1, strAccess$getTAG$cp, e.getMessage());
                    AbstractC3534r1 mPubListener = inMobiBanner.getMPubListener();
                    if (mPubListener != null) {
                        mPubListener.a(inMobiBanner, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InMobiBanner(Context context, AttributeSet attributeSet) {
        L4 l4P;
        L4 l4P2;
        long j;
        L4 l4P3;
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
        this.audioStatusInternal = EnumC3479n1.d;
        this.e = new a(this);
        this.g = true;
        this.k = AnimationType.ROTATE_HORIZONTAL_AXIS;
        this.mPubSettings = new E9();
        this.o = new e(this);
        if (!C3517pb.q()) {
            Intrinsics.checkNotNullExpressionValue("InMobiBanner", "TAG");
            throw new SdkNotInitializedException("InMobiBanner");
        }
        if (context instanceof Activity) {
            this.m = new WeakReference(context);
        }
        this.mAdManager = new B1();
        String attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/lib/com.inmobi.ads", "placementId");
        String attributeValue2 = attributeSet.getAttributeValue("http://schemas.android.com/apk/lib/com.inmobi.ads", POBConstants.KEY_REFRESH_INTERVAL);
        if (attributeValue != null) {
            try {
                int length = attributeValue.length() - 1;
                int i = 0;
                boolean z = false;
                while (i <= length) {
                    boolean z2 = Intrinsics.compare((int) attributeValue.charAt(!z ? i : length), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            break;
                        } else {
                            length--;
                        }
                    } else if (z2) {
                        i++;
                    } else {
                        z = true;
                    }
                }
                StringBuilder sb = new StringBuilder(attributeValue.subSequence(i, length + 1).toString());
                if (StringsKt.equals("plid-", sb.substring(0, 5), true)) {
                    String strSubstring = sb.substring(5, sb.length());
                    Intrinsics.checkNotNull(strSubstring);
                    int length2 = strSubstring.length() - 1;
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 <= length2) {
                        boolean z4 = Intrinsics.compare((int) strSubstring.charAt(!z3 ? i2 : length2), 32) <= 0;
                        if (z3) {
                            if (!z4) {
                                break;
                            } else {
                                length2--;
                            }
                        } else if (z4) {
                            i2++;
                        } else {
                            z3 = true;
                        }
                    }
                    j = Long.parseLong(strSubstring.subSequence(i2, length2 + 1).toString());
                } else {
                    B1 b1 = this.mAdManager;
                    if (b1 != null && (l4P3 = b1.p()) != null) {
                        Intrinsics.checkNotNullExpressionValue("InMobiBanner", "TAG");
                        ((M4) l4P3).b("InMobiBanner", "Invalid Placement id: " + attributeValue);
                    }
                    j = Long.MIN_VALUE;
                }
            } catch (NumberFormatException unused) {
                B1 b2 = this.mAdManager;
                if (b2 != null && (l4P2 = b2.p()) != null) {
                    Intrinsics.checkNotNullExpressionValue("InMobiBanner", "TAG");
                    ((M4) l4P2).b("InMobiBanner", "Invalid Placement id: ".concat(attributeValue));
                }
            } catch (StringIndexOutOfBoundsException unused2) {
                B1 b3 = this.mAdManager;
                if (b3 != null && (l4P = b3.p()) != null) {
                    Intrinsics.checkNotNullExpressionValue("InMobiBanner", "TAG");
                    ((M4) l4P).b("InMobiBanner", "Invalid Placement id: ".concat(attributeValue));
                }
            }
            if (j == Long.MIN_VALUE) {
                throw new InvalidPlacementIdException();
            }
            this.mPubSettings.f3059a = j;
        }
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        a(context2, "banner");
        B1 b4 = this.mAdManager;
        this.f = b4 != null ? b4.A() : 0;
        this.h = new HandlerC3647z1(this);
        if (attributeValue2 != null) {
            try {
                int length3 = attributeValue2.length() - 1;
                int i3 = 0;
                boolean z5 = false;
                while (i3 <= length3) {
                    boolean z6 = Intrinsics.compare((int) attributeValue2.charAt(!z5 ? i3 : length3), 32) <= 0;
                    if (z5) {
                        if (!z6) {
                            break;
                        } else {
                            length3--;
                        }
                    } else if (z6) {
                        i3++;
                    } else {
                        z5 = true;
                    }
                }
                String string = attributeValue2.subSequence(i3, length3 + 1).toString();
                Intrinsics.checkNotNull(string);
                setRefreshInterval(Integer.parseInt(string));
            } catch (NumberFormatException unused3) {
                Intrinsics.checkNotNullExpressionValue("InMobiBanner", "TAG");
                AbstractC3498o6.a((byte) 1, "InMobiBanner", "Refresh interval value supplied in XML layout is not valid. Falling back to default value.");
            }
        }
    }

    public static final boolean access$checkForRefreshRate(InMobiBanner inMobiBanner) {
        B1 b1;
        long j = inMobiBanner.l;
        if (j != 0 && (b1 = inMobiBanner.mAdManager) != null && !b1.a(j)) {
            return false;
        }
        inMobiBanner.l = SystemClock.elapsedRealtime();
        return true;
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        return "InMobiBanner";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getFrameSizeString() {
        return new StringBuilder().append(this.i).append('x').append(this.j).toString();
    }

    public final boolean a(boolean z) {
        L4 l4P;
        L4 l4P2;
        B1 b1 = this.mAdManager;
        if (b1 != null && (l4P2 = b1.p()) != null) {
            Intrinsics.checkNotNullExpressionValue("InMobiBanner", "TAG");
            ((M4) l4P2).c("InMobiBanner", "checkStateAndLogError");
        }
        if (!z || this.mPubListener != null) {
            return true;
        }
        B1 b2 = this.mAdManager;
        if (b2 != null && (l4P = b2.p()) != null) {
            Intrinsics.checkNotNullExpressionValue("InMobiBanner", "TAG");
            ((M4) l4P).b("InMobiBanner", "Listener supplied is null, Ignoring your call.");
        }
        return false;
    }

    public final boolean b() {
        return this.i > 0 && this.j > 0;
    }

    public final void destroy() {
        a();
        removeAllViews();
        B1 b1 = this.mAdManager;
        if (b1 != null) {
            b1.z();
        }
        this.mPubListener = null;
    }

    public final void disableHardwareAcceleration() {
        this.mPubSettings.d = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.i, this, me);
        return super.dispatchTouchEvent(me);
    }

    /* JADX INFO: renamed from: getAudioStatusInternal$media_release, reason: from getter */
    public final EnumC3479n1 getAudioStatusInternal() {
        return this.audioStatusInternal;
    }

    /* JADX INFO: renamed from: getMAdManager$media_release, reason: from getter */
    public final B1 getMAdManager() {
        return this.mAdManager;
    }

    /* JADX INFO: renamed from: getMAudioListener$media_release, reason: from getter */
    public final AudioListener getMAudioListener() {
        return this.mAudioListener;
    }

    /* JADX INFO: renamed from: getMPubListener$media_release, reason: from getter */
    public final AbstractC3534r1 getMPubListener() {
        return this.mPubListener;
    }

    /* JADX INFO: renamed from: getMPubSettings$media_release, reason: from getter */
    public final E9 getMPubSettings() {
        return this.mPubSettings;
    }

    public final long getPlacementId() {
        return this.mPubSettings.f3059a;
    }

    public final PreloadManager getPreloadManager() {
        return this.o;
    }

    public final void getSignals() {
        L4 l4P;
        if (a(true)) {
            if (!a("getSignals()")) {
                this.e.onRequestPayloadCreationFailed(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.CONFIGURATION_ERROR));
                return;
            }
            B1 b1 = this.mAdManager;
            if (b1 == null || !b1.D()) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                a(context, "getToken");
            }
            B1 b2 = this.mAdManager;
            if (b2 != null && (l4P = b2.p()) != null) {
                Intrinsics.checkNotNullExpressionValue("InMobiBanner", "TAG");
                ((M4) l4P).a("InMobiBanner", "getSignals");
            }
            setEnableAutoRefresh(false);
            B1 b3 = this.mAdManager;
            if (b3 != null) {
                b3.a(this.e);
            }
        }
    }

    public final boolean isAudioAd() {
        B1 b1 = this.mAdManager;
        if (b1 != null) {
            return b1.C();
        }
        return false;
    }

    public final void load(byte[] response) {
        B1 b1;
        B1 b2;
        if (a(false)) {
            this.mPubSettings.e = "AB";
            if (getLayoutParams() != null) {
                this.i = AbstractC3565t3.a(getLayoutParams().width);
                this.j = AbstractC3565t3.a(getLayoutParams().height);
            }
            B1 b3 = this.mAdManager;
            if (b3 == null || !b3.D() || ((b1 = this.mAdManager) != null && b1.D() && (b2 = this.mAdManager) != null && b2.q() == 0)) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                a(context, "banner");
            }
            B1 b4 = this.mAdManager;
            if (b4 != null) {
                b4.w();
            }
            a("load(byte[])", new d(this, response));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        L4 l4P;
        try {
            super.onAttachedToWindow();
            B1 b1 = this.mAdManager;
            if (b1 != null) {
                b1.F();
            }
            if (getLayoutParams() != null) {
                this.i = AbstractC3565t3.a(getLayoutParams().width);
                this.j = AbstractC3565t3.a(getLayoutParams().height);
            }
            if (!b()) {
                setupBannerSizeObserver();
            }
            scheduleRefresh$media_release();
            if (Build.VERSION.SDK_INT >= 29) {
                C3579u3 c3579u3 = AbstractC3565t3.f3431a;
                Context context = getContext();
                WindowInsets rootWindowInsets = getRootWindowInsets();
                Intrinsics.checkNotNullExpressionValue(rootWindowInsets, "getRootWindowInsets(...)");
                AbstractC3565t3.a(rootWindowInsets, context);
            }
        } catch (Exception e) {
            B1 b2 = this.mAdManager;
            if (b2 == null || (l4P = b2.p()) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue("InMobiBanner", "TAG");
            ((M4) l4P).a("InMobiBanner", "InMobiBanner#onAttachedToWindow() handler threw unexpected error: ", e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        L4 l4P;
        try {
            super.onDetachedFromWindow();
            a();
            B1 b1 = this.mAdManager;
            if (b1 != null) {
                b1.K();
            }
        } catch (Exception e) {
            B1 b2 = this.mAdManager;
            if (b2 == null || (l4P = b2.p()) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue("InMobiBanner", "TAG");
            ((M4) l4P).a("InMobiBanner", "InMobiBanner.onDetachedFromWindow() handler threw unexpected error: ", e);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View changedView, int visibility) {
        L4 l4P;
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        try {
            super.onVisibilityChanged(changedView, visibility);
            if (visibility == 0) {
                scheduleRefresh$media_release();
            } else {
                a();
            }
        } catch (Exception e) {
            B1 b1 = this.mAdManager;
            if (b1 == null || (l4P = b1.p()) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue("InMobiBanner", "TAG");
            ((M4) l4P).a("InMobiBanner", "InMobiBanner$1.onVisibilityChanged() handler threw unexpected error: ", e);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        L4 l4P;
        try {
            super.onWindowFocusChanged(hasWindowFocus);
            if (hasWindowFocus) {
                scheduleRefresh$media_release();
            } else {
                a();
            }
        } catch (Exception e) {
            B1 b1 = this.mAdManager;
            if (b1 == null || (l4P = b1.p()) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue("InMobiBanner", "TAG");
            ((M4) l4P).a("InMobiBanner", "InMobiBanner$1.onWindowFocusChanged() handler threw unexpected error: ", e);
        }
    }

    public final void pause() {
        L4 l4P;
        B1 b1;
        try {
            if (this.m != null || (b1 = this.mAdManager) == null) {
                return;
            }
            b1.E();
        } catch (Exception e) {
            B1 b2 = this.mAdManager;
            if (b2 == null || (l4P = b2.p()) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue("InMobiBanner", "TAG");
            ((M4) l4P).a("InMobiBanner", "SDK encountered unexpected error in pausing ad; ", e);
        }
    }

    public final void refreshBanner$media_release() {
        a(this.e, "NonAB", true);
    }

    public final void resume() {
        L4 l4P;
        B1 b1;
        try {
            if (this.m != null || (b1 = this.mAdManager) == null) {
                return;
            }
            b1.H();
        } catch (Exception e) {
            B1 b2 = this.mAdManager;
            if (b2 == null || (l4P = b2.p()) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue("InMobiBanner", "TAG");
            ((M4) l4P).a("InMobiBanner", "SDK encountered unexpected error in resuming ad; ", e);
        }
    }

    public final void scheduleRefresh$media_release() {
        HandlerC3647z1 handlerC3647z1;
        if (isShown() && hasWindowFocus()) {
            HandlerC3647z1 handlerC3647z2 = this.h;
            if (handlerC3647z2 != null) {
                handlerC3647z2.removeMessages(1);
            }
            B1 b1 = this.mAdManager;
            if (b1 == null || !b1.y() || !this.g || (handlerC3647z1 = this.h) == null) {
                return;
            }
            handlerC3647z1.sendEmptyMessageDelayed(1, this.f * 1000);
        }
    }

    public final void setAnimationType(AnimationType animationType) {
        Intrinsics.checkNotNullParameter(animationType, "animationType");
        this.k = animationType;
    }

    public final void setAudioListener(AudioListener audioListener) {
        AudioStatus audioStatus;
        Intrinsics.checkNotNullParameter(audioListener, "audioListener");
        this.mAudioListener = audioListener;
        EnumC3479n1 item = this.audioStatusInternal;
        if (item == EnumC3479n1.d || audioListener == null) {
            return;
        }
        EnumC3479n1.b.getClass();
        Intrinsics.checkNotNullParameter(item, "item");
        int iOrdinal = item.ordinal();
        if (iOrdinal != 1) {
            audioStatus = iOrdinal != 2 ? AudioStatus.COMPLETED : AudioStatus.PAUSED;
        } else {
            audioStatus = AudioStatus.PLAYING;
        }
        audioListener.onAudioStatusChanged(this, audioStatus);
    }

    public final void setAudioStatusInternal$media_release(EnumC3479n1 enumC3479n1) {
        Intrinsics.checkNotNullParameter(enumC3479n1, "<set-?>");
        this.audioStatusInternal = enumC3479n1;
    }

    public final void setBannerSize(int widthInDp, int heightInDp) {
        this.i = widthInDp;
        this.j = heightInDp;
    }

    public final void setContentUrl(String contentUrl) {
        Intrinsics.checkNotNullParameter(contentUrl, "contentUrl");
        this.mPubSettings.f = contentUrl;
    }

    public final void setEnableAutoRefresh(boolean enabled) {
        L4 l4P;
        try {
            if (this.g == enabled) {
                return;
            }
            this.g = enabled;
            if (enabled) {
                scheduleRefresh$media_release();
            } else {
                a();
            }
        } catch (Exception e) {
            B1 b1 = this.mAdManager;
            if (b1 == null || (l4P = b1.p()) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue("InMobiBanner", "TAG");
            ((M4) l4P).a("InMobiBanner", "Setting up auto-refresh failed with unexpected error: ", e);
        }
    }

    public final void setExtras(Map<String, String> extras) {
        if (extras != null) {
            C3531qb.a(extras.get("tp"));
            C3531qb.b(extras.get("tp-v"));
        }
        this.mPubSettings.c = extras;
    }

    public final void setKeywords(String keywords) {
        this.mPubSettings.b = keywords;
    }

    public final void setListener(BannerAdEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mPubListener = new C3548s1(listener);
    }

    public final void setMAdManager$media_release(B1 b1) {
        this.mAdManager = b1;
    }

    public final void setMAudioListener$media_release(AudioListener audioListener) {
        this.mAudioListener = audioListener;
    }

    public final void setMPubListener$media_release(AbstractC3534r1 abstractC3534r1) {
        this.mPubListener = abstractC3534r1;
    }

    public final void setRefreshInterval(int refreshInterval) {
        L4 l4P;
        try {
            this.mPubSettings.e = "NonAB";
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            a(context, "banner");
            B1 b1 = this.mAdManager;
            this.f = b1 != null ? b1.a(refreshInterval, this.f) : 0;
        } catch (Exception e) {
            B1 b2 = this.mAdManager;
            if (b2 == null || (l4P = b2.p()) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue("InMobiBanner", "TAG");
            ((M4) l4P).a("InMobiBanner", "Setting refresh interval failed with unexpected error: ", e);
        }
    }

    public final void setWatermarkData(WatermarkData watermarkData) {
        Intrinsics.checkNotNullParameter(watermarkData, "watermarkData");
        B1 b1 = this.mAdManager;
        if (b1 != null) {
            b1.a(watermarkData);
        }
    }

    public final void setupBannerSizeObserver() {
        getViewTreeObserver().addOnGlobalLayoutListener(new G4(this));
    }

    public final void swapAdUnitsAndDisplayAd$media_release() {
        L4 l4P;
        B1 b1 = this.mAdManager;
        if (b1 != null) {
            b1.J();
        }
        try {
            Animation animationA = b.a(this.k, getWidth(), getHeight());
            B1 b2 = this.mAdManager;
            if (b2 != null) {
                b2.a(this);
            }
            if (animationA != null) {
                startAnimation(animationA);
            }
        } catch (Exception e) {
            B1 b3 = this.mAdManager;
            if (b3 == null || (l4P = b3.p()) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue("InMobiBanner", "TAG");
            ((M4) l4P).a("InMobiBanner", "Unexpected error while displaying Banner Ad : ", e);
        }
    }

    public final void a(PublisherCallbacks publisherCallbacks, String str, boolean z) {
        L4 l4P;
        L4 l4P2;
        L4 l4P3;
        L4 l4P4;
        L4 l4P5;
        try {
            this.mPubSettings.e = str;
            B1 b1 = this.mAdManager;
            if (b1 != null && b1.B()) {
                B1 b2 = this.mAdManager;
                if (b2 != null) {
                    b2.w();
                }
                B1 b3 = this.mAdManager;
                if (b3 != null && (l4P5 = b3.p()) != null) {
                    Intrinsics.checkNotNullExpressionValue("InMobiBanner", "TAG");
                    ((M4) l4P5).a("InMobiBanner", "load called - placementType - " + str + ' ' + this);
                }
                B1 b4 = this.mAdManager;
                if (b4 != null && (l4P4 = b4.p()) != null) {
                    Intrinsics.checkNotNullExpressionValue("InMobiBanner", "TAG");
                    ((M4) l4P4).b("InMobiBanner", "load already in progress");
                }
                B1 b5 = this.mAdManager;
                if (b5 != null) {
                    b5.b((short) 2169);
                }
                AbstractC3534r1 abstractC3534r1 = this.mPubListener;
                if (abstractC3534r1 != null) {
                    abstractC3534r1.a(this, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.AD_ACTIVE));
                }
                B1 b6 = this.mAdManager;
                if (b6 != null && (l4P3 = b6.p()) != null) {
                    Intrinsics.checkNotNullExpressionValue("InMobiBanner", "TAG");
                    ((M4) l4P3).b("InMobiBanner", "An ad is currently being viewed by the user. Please wait for the user to close the ad before requesting for another ad.");
                }
                AbstractC3498o6.a((byte) 1, "InMobi", "An ad is currently being viewed by the user. Please wait for the user to close the ad before requesting for another ad.");
                return;
            }
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            a(context, "banner");
            B1 b7 = this.mAdManager;
            if (b7 != null) {
                b7.w();
            }
            B1 b8 = this.mAdManager;
            if (b8 != null && (l4P2 = b8.p()) != null) {
                Intrinsics.checkNotNullExpressionValue("InMobiBanner", "TAG");
                ((M4) l4P2).a("InMobiBanner", "load called - placementType - " + str + ' ' + this);
            }
            a("load", new F4(this, publisherCallbacks, z));
        } catch (Exception e) {
            B1 b9 = this.mAdManager;
            if (b9 != null) {
                b9.a((short) 2172);
            }
            AbstractC3534r1 abstractC3534r2 = this.mPubListener;
            if (abstractC3534r2 != null) {
                abstractC3534r2.a(this, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
            }
            B1 b10 = this.mAdManager;
            if (b10 == null || (l4P = b10.p()) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue("InMobiBanner", "TAG");
            ((M4) l4P).a("InMobiBanner", "Load failed with unexpected error: ", e);
        }
    }

    public final void load() {
        if (a(false)) {
            a(this.e, "NonAB", false);
        }
    }

    public final void load(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (a(false)) {
            this.m = context instanceof Activity ? new WeakReference(context) : null;
            a(this.e, "NonAB", false);
        }
    }

    public final void a(String str, final Function0 function0) {
        L4 l4P;
        L4 l4P2;
        B1 b1 = this.mAdManager;
        if (b1 != null && (l4P2 = b1.p()) != null) {
            Intrinsics.checkNotNullExpressionValue("InMobiBanner", "TAG");
            ((M4) l4P2).c("InMobiBanner", "validateSizeAndLoad");
        }
        if (!a(str)) {
            B1 b2 = this.mAdManager;
            if (b2 != null && (l4P = b2.p()) != null) {
                Intrinsics.checkNotNullExpressionValue("InMobiBanner", "TAG");
                ((M4) l4P).b("InMobiBanner", "invalid banner size. fail.");
            }
            B1 b3 = this.mAdManager;
            if (b3 != null) {
                b3.a((short) 2170);
            }
            AbstractC3534r1 abstractC3534r1 = this.mPubListener;
            if (abstractC3534r1 != null) {
                abstractC3534r1.a(this, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.CONFIGURATION_ERROR));
                return;
            }
            return;
        }
        if (!b()) {
            Lb.a(new Runnable() { // from class: com.inmobi.ads.InMobiBanner$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    InMobiBanner.a(this.f$0, function0);
                }
            }, 200L);
        } else {
            function0.invoke();
        }
    }

    public static final void a(InMobiBanner this$0, Function0 onSuccess) {
        L4 l4P;
        L4 l4P2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(onSuccess, "$onSuccess");
        try {
            if (this$0.b()) {
                onSuccess.invoke();
                return;
            }
            B1 b1 = this$0.mAdManager;
            if (b1 != null && (l4P2 = b1.p()) != null) {
                Intrinsics.checkNotNullExpressionValue("InMobiBanner", "TAG");
                ((M4) l4P2).b("InMobiBanner", "The height or width of the banner can not be determined");
            }
            B1 b2 = this$0.mAdManager;
            if (b2 != null) {
                b2.a((short) 2171);
            }
            AbstractC3534r1 abstractC3534r1 = this$0.mPubListener;
            if (abstractC3534r1 != null) {
                abstractC3534r1.a(this$0, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.CONFIGURATION_ERROR));
            }
        } catch (Exception e) {
            B1 b3 = this$0.mAdManager;
            if (b3 != null) {
                b3.a((short) 2172);
            }
            AbstractC3534r1 abstractC3534r2 = this$0.mPubListener;
            if (abstractC3534r2 != null) {
                abstractC3534r2.a(this$0, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
            }
            B1 b4 = this$0.mAdManager;
            if (b4 == null || (l4P = b4.p()) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue("InMobiBanner", "TAG");
            ((M4) l4P).a("InMobiBanner", "InMobiBanner$4.run() threw unexpected error: ", e);
        }
    }

    public final boolean a(String str) {
        L4 l4P;
        L4 l4P2;
        if (b()) {
            return true;
        }
        if (getLayoutParams() == null) {
            B1 b1 = this.mAdManager;
            if (b1 != null && (l4P2 = b1.p()) != null) {
                Intrinsics.checkNotNullExpressionValue("InMobiBanner", "TAG");
                ((M4) l4P2).b("InMobiBanner", "The layout params of the banner must be set before calling " + str + " or call setBannerSize(int widthInDp, int heightInDp) before " + str);
            }
            return false;
        }
        if (getLayoutParams().width != -2 && getLayoutParams().height != -2) {
            if (getLayoutParams() == null) {
                return true;
            }
            this.i = AbstractC3565t3.a(getLayoutParams().width);
            this.j = AbstractC3565t3.a(getLayoutParams().height);
            return true;
        }
        B1 b2 = this.mAdManager;
        if (b2 != null && (l4P = b2.p()) != null) {
            Intrinsics.checkNotNullExpressionValue("InMobiBanner", "TAG");
            ((M4) l4P).b("InMobiBanner", "The height or width of a Banner ad can't be WRAP_CONTENT or call setBannerSize(int widthInDp, int heightInDp) before ".concat(str));
        }
        return false;
    }

    public final void a(Context context, String str) {
        int iA;
        B1 b1 = this.mAdManager;
        if (b1 != null) {
            b1.a(context, this.mPubSettings, getFrameSizeString(), str);
        }
        B1 b2 = this.mAdManager;
        if (b2 != null) {
            int i = this.f;
            iA = b2.a(i, i);
        } else {
            iA = 0;
        }
        this.f = iA;
    }

    public final void a() {
        HandlerC3647z1 handlerC3647z1 = this.h;
        if (handlerC3647z1 != null) {
            handlerC3647z1.removeMessages(1);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InMobiBanner(Context context, long j) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.audioStatusInternal = EnumC3479n1.d;
        this.e = new a(this);
        this.g = true;
        this.k = AnimationType.ROTATE_HORIZONTAL_AXIS;
        E9 e9 = new E9();
        this.mPubSettings = e9;
        this.o = new e(this);
        if (C3517pb.q()) {
            if (context instanceof Activity) {
                this.m = new WeakReference(context);
            }
            this.mAdManager = new B1();
            e9.f3059a = j;
            a(context, "banner");
            B1 b1 = this.mAdManager;
            this.f = b1 != null ? b1.A() : 0;
            this.h = new HandlerC3647z1(this);
            return;
        }
        Intrinsics.checkNotNullExpressionValue("InMobiBanner", "TAG");
        throw new SdkNotInitializedException("InMobiBanner");
    }
}
