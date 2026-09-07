package com.inmobi.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.WindowInsets;
import android.widget.RelativeLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.inmobi.ads.exceptions.InvalidPlacementIdException;
import com.inmobi.ads.exceptions.SdkNotInitializedException;
import com.inmobi.ads.listeners.AudioAdEventListener;
import com.inmobi.commons.core.configs.AdConfig;
import com.inmobi.commons.core.configs.Config;
import com.inmobi.media.AbstractC3433k1;
import com.inmobi.media.AbstractC3498o6;
import com.inmobi.media.AbstractC3507p1;
import com.inmobi.media.AbstractC3565t3;
import com.inmobi.media.B4;
import com.inmobi.media.C3419j1;
import com.inmobi.media.C3435k3;
import com.inmobi.media.C3442ka;
import com.inmobi.media.C3493o1;
import com.inmobi.media.C3517pb;
import com.inmobi.media.C3531qb;
import com.inmobi.media.C3549s2;
import com.inmobi.media.C3578u2;
import com.inmobi.media.C3579u3;
import com.inmobi.media.C4;
import com.inmobi.media.E9;
import com.inmobi.media.EnumC3396h6;
import com.inmobi.media.H;
import com.inmobi.media.J;
import com.inmobi.media.L4;
import com.inmobi.media.Lb;
import com.inmobi.media.M4;
import com.json.m5;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001)B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\rJ#\u0010\u0012\u001a\u00020\u000b2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0010¢\u0006\u0004\b\u0018\u0010\u0016J\u0015\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u000b¢\u0006\u0004\b\u001d\u0010\rJ\u000f\u0010\u001e\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u001e\u0010\rJ\u000f\u0010\u001f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u001f\u0010\rJ!\u0010#\u001a\u00020\u000b2\b\b\u0001\u0010!\u001a\u00020 2\b\b\u0001\u0010\"\u001a\u00020 ¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u000bH\u0007¢\u0006\u0004\b%\u0010\rJ\r\u0010&\u001a\u00020\u000b¢\u0006\u0004\b&\u0010\rJ\r\u0010'\u001a\u00020\u000b¢\u0006\u0004\b'\u0010\rJ\u000f\u0010(\u001a\u00020\u000bH\u0007¢\u0006\u0004\b(\u0010\rR$\u0010.\u001a\u0004\u0018\u00010\u00198\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010\u001cR$\u00106\u001a\u0004\u0018\u00010/8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0014\u00109\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u00108¨\u0006:"}, d2 = {"Lcom/inmobi/ads/InMobiAudio;", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "placementId", "(Landroid/content/Context;J)V", "", "load", "()V", m5.v, "", "", "extras", "setExtras", "(Ljava/util/Map;)V", "keywords", "setKeywords", "(Ljava/lang/String;)V", "contentUrl", "setContentUrl", "Lcom/inmobi/ads/listeners/AudioAdEventListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setListener", "(Lcom/inmobi/ads/listeners/AudioAdEventListener;)V", "disableHardwareAcceleration", "onAttachedToWindow", "onDetachedFromWindow", "", "widthInDp", "heightInDp", "setAudioSize", "(II)V", "setupViewSizeObserver", "resume", "pause", "destroy", "a", "Lcom/inmobi/ads/listeners/AudioAdEventListener;", "getMPubListener$media_release", "()Lcom/inmobi/ads/listeners/AudioAdEventListener;", "setMPubListener$media_release", "mPubListener", "Lcom/inmobi/media/o1;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/inmobi/media/o1;", "getMAdManager$media_release", "()Lcom/inmobi/media/o1;", "setMAdManager$media_release", "(Lcom/inmobi/media/o1;)V", "mAdManager", "getFrameSizeString", "()Ljava/lang/String;", "frameSizeString", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class InMobiAudio extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public AudioAdEventListener mPubListener;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public C3493o1 mAdManager;
    public final WeakReference c;
    public final E9 d;
    public long e;
    public int f;
    public int g;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/inmobi/ads/InMobiAudio$a;", "Lcom/inmobi/media/k1;", "Lcom/inmobi/ads/InMobiAudio;", "audio", "<init>", "(Lcom/inmobi/ads/InMobiAudio;)V", "Lcom/inmobi/ads/AdMetaInfo;", "info", "", "onAdFetchSuccessful", "(Lcom/inmobi/ads/AdMetaInfo;)V", "Lcom/inmobi/ads/InMobiAdRequestStatus;", "status", "onAdFetchFailed", "(Lcom/inmobi/ads/InMobiAdRequestStatus;)V", "", "getType", "()B", "type", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class a extends AbstractC3433k1 {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InMobiAudio audio) {
            super(audio);
            Intrinsics.checkNotNullParameter(audio, "audio");
        }

        @Override // com.inmobi.ads.controllers.PublisherCallbacks
        public byte getType() {
            return (byte) 0;
        }

        @Override // com.inmobi.ads.controllers.PublisherCallbacks
        public void onAdFetchFailed(InMobiAdRequestStatus status) {
            AudioAdEventListener mPubListener;
            Intrinsics.checkNotNullParameter(status, "status");
            InMobiAudio inMobiAudio = a().get();
            if (inMobiAudio == null || (mPubListener = inMobiAudio.getMPubListener()) == null) {
                return;
            }
            mPubListener.onAdLoadFailed(inMobiAudio, status);
        }

        @Override // com.inmobi.media.AbstractC3433k1, com.inmobi.ads.controllers.PublisherCallbacks
        public void onAdFetchSuccessful(AdMetaInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            super.onAdFetchSuccessful(info);
            InMobiAudio inMobiAudio = a().get();
            if (inMobiAudio == null) {
                return;
            }
            try {
                C3493o1 mAdManager = inMobiAudio.getMAdManager();
                if (mAdManager != null) {
                    mAdManager.y();
                }
            } catch (IllegalStateException e) {
                AbstractC3498o6.a((byte) 1, "InMobiAudio", e.getMessage());
                AudioAdEventListener mPubListener = inMobiAudio.getMPubListener();
                if (mPubListener != null) {
                    mPubListener.onAdLoadFailed(inMobiAudio, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InMobiAudio(Context context, AttributeSet attributeSet) {
        long j;
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
        a aVar = new a(this);
        this.d = new E9();
        if (!C3517pb.q()) {
            throw new SdkNotInitializedException("InMobiAudio");
        }
        if (context instanceof Activity) {
            this.c = new WeakReference(context);
        }
        this.mAdManager = new C3493o1(aVar);
        String attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/lib/com.inmobi.ads", "placementId");
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
                    AbstractC3498o6.a((byte) 1, "InMobiAudio", "Placement id value supplied in XML layout is not valid. Please make sure placement id is in plid-0123456789 format.");
                    AbstractC3498o6.a((byte) 1, "InMobiAudio", "Invalid Placement id: " + attributeValue);
                    j = Long.MIN_VALUE;
                }
            } catch (NumberFormatException unused) {
                AbstractC3498o6.a((byte) 1, "InMobiAudio", "Placement id value supplied in XML layout is not valid. Audio creation failed.");
                AbstractC3498o6.a((byte) 1, "InMobiAudio", "Invalid Placement id: ".concat(attributeValue));
            } catch (StringIndexOutOfBoundsException unused2) {
                AbstractC3498o6.a((byte) 1, "InMobiAudio", "Placement id value supplied in XML layout is not valid. Please make sure placement id is in plid-0123456789 format.");
                AbstractC3498o6.a((byte) 1, "InMobiAudio", "Invalid Placement id: ".concat(attributeValue));
            }
            if (j == Long.MIN_VALUE) {
                throw new InvalidPlacementIdException();
            }
            this.d.f3059a = j;
        }
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        a(context2);
    }

    public static final void a(InMobiAudio this$0) {
        C3493o1 c3493o1;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            if (this$0.b()) {
                if (!this$0.a() || (c3493o1 = this$0.mAdManager) == null) {
                    return;
                }
                c3493o1.b(this$0.getFrameSizeString());
                return;
            }
            AbstractC3498o6.a((byte) 1, "InMobiAudio", "The height or width of the audio ad can not be determined");
            C3493o1 c3493o2 = this$0.mAdManager;
            if (c3493o2 != null) {
                c3493o2.a((short) 108);
            }
            C3493o1 c3493o3 = this$0.mAdManager;
            if (c3493o3 != null) {
                c3493o3.a(c3493o3.j(), new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
            }
        } catch (Exception unused) {
            C3493o1 c3493o4 = this$0.mAdManager;
            if (c3493o4 != null) {
                c3493o4.a((short) 105);
            }
            AbstractC3498o6.a((byte) 1, "InMobiAudio", "SDK encountered unexpected error while loading an ad");
        }
    }

    private final String getFrameSizeString() {
        return new StringBuilder().append(this.f).append('x').append(this.g).toString();
    }

    public final boolean b() {
        return this.f > 0 && this.g > 0;
    }

    public final boolean c() {
        if (!b()) {
            if (getLayoutParams() == null) {
                AbstractC3498o6.a((byte) 1, "InMobiAudio", "The layout params of the audio ad view must be set before calling load or call setAudioSize(int widthInDp, int heightInDp) before load");
                return false;
            }
            if (getLayoutParams().width == -2 || getLayoutParams().height == -2) {
                AbstractC3498o6.a((byte) 1, "InMobiAudio", "The height or width of a Audio ad can't be WRAP_CONTENT or call setAudioSize(int widthInDp, int heightInDp) before load");
                return false;
            }
            if (getLayoutParams() != null) {
                this.f = AbstractC3565t3.a(getLayoutParams().width);
                this.g = AbstractC3565t3.a(getLayoutParams().height);
            }
        }
        return true;
    }

    public final void d() {
        C3493o1 c3493o1;
        try {
            LinkedHashMap linkedHashMap = C3578u2.f3440a;
            Config configA = C3549s2.a("ads", C3517pb.b(), null);
            Intrinsics.checkNotNull(configA, "null cannot be cast to non-null type com.inmobi.commons.core.configs.AdConfig");
            if (!((AdConfig) configA).getAudio().getIsAudioEnabled()) {
                C3493o1 c3493o2 = this.mAdManager;
                if (c3493o2 != null) {
                    c3493o2.a((short) 107);
                }
                C3493o1 c3493o3 = this.mAdManager;
                if (c3493o3 != null) {
                    c3493o3.a(c3493o3.j(), new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.FEATURE_DISABLED));
                }
                AbstractC3498o6.a((byte) 1, "InMobi", "");
                return;
            }
            this.d.e = "NonAB";
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            a(context);
            C3493o1 c3493o4 = this.mAdManager;
            if (c3493o4 != null) {
                C3419j1 c3419j1 = c3493o4.q;
                if (c3419j1 != null ? c3419j1.D0() : false) {
                    C3493o1 c3493o5 = this.mAdManager;
                    if (c3493o5 != null) {
                        L4 l4P = c3493o5.p();
                        if (l4P != null) {
                            String str = AbstractC3507p1.f3395a;
                            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
                            ((M4) l4P).b(str, "submitAdLoadFailed " + c3493o5);
                        }
                        C3419j1 c3419j2 = c3493o5.r;
                        if (c3419j2 != null) {
                            c3419j2.b((short) 15);
                        }
                    }
                    AudioAdEventListener audioAdEventListener = this.mPubListener;
                    if (audioAdEventListener != null) {
                        audioAdEventListener.onAdLoadFailed(this, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.AD_ACTIVE));
                    }
                    AbstractC3498o6.a((byte) 1, "InMobiAudio", "An ad is currently being viewed by the user. Please wait for the user to close the ad before requesting for another ad.");
                    return;
                }
            }
            if (!c()) {
                C3493o1 c3493o6 = this.mAdManager;
                if (c3493o6 != null) {
                    c3493o6.a((short) 108);
                }
                C3493o1 c3493o7 = this.mAdManager;
                if (c3493o7 != null) {
                    c3493o7.a(c3493o7.j(), new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.REQUEST_INVALID));
                    return;
                }
                return;
            }
            Config configA2 = C3549s2.a("ads", C3517pb.b(), null);
            Intrinsics.checkNotNull(configA2, "null cannot be cast to non-null type com.inmobi.commons.core.configs.AdConfig");
            if (((AdConfig) configA2).getAudio().getMinDeviceVolume() > C3435k3.f3355a.a(C3517pb.d(), C3517pb.o())) {
                C3493o1 c3493o8 = this.mAdManager;
                if (c3493o8 != null) {
                    c3493o8.a((short) 106);
                }
                C3493o1 c3493o9 = this.mAdManager;
                if (c3493o9 != null) {
                    c3493o9.a(c3493o9.j(), new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.DEVICE_AUDIO_LEVEL_LOW));
                    return;
                }
                return;
            }
            if (!b()) {
                Lb.a(new Runnable() { // from class: com.inmobi.ads.InMobiAudio$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        InMobiAudio.a(this.f$0);
                    }
                }, 200L);
            } else {
                if (!a() || (c3493o1 = this.mAdManager) == null) {
                    return;
                }
                c3493o1.b(getFrameSizeString());
            }
        } catch (Exception unused) {
            C3493o1 c3493o10 = this.mAdManager;
            if (c3493o10 != null) {
                c3493o10.a((short) 105);
            }
            AbstractC3498o6.a((byte) 1, "InMobiAudio", "Unable to load ad; SDK encountered an unexpected error");
        }
    }

    public final void destroy() {
        removeAllViews();
        C3493o1 c3493o1 = this.mAdManager;
        if (c3493o1 != null) {
            L4 l4P = c3493o1.p();
            if (l4P != null) {
                String str = AbstractC3507p1.f3395a;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
                ((M4) l4P).a(str, "clear " + c3493o1);
            }
            L4 l4P2 = c3493o1.p();
            if (l4P2 != null) {
                String str2 = AbstractC3507p1.f3395a;
                Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
                ((M4) l4P2).c(str2, "unregisterLifecycleCallbacks " + c3493o1);
            }
            C3419j1 c3419j1 = c3493o1.o;
            if (c3419j1 != null) {
                c3419j1.I0();
            }
            C3419j1 c3419j2 = c3493o1.p;
            if (c3419j2 != null) {
                c3419j2.I0();
            }
            C3419j1 c3419j3 = c3493o1.o;
            if (c3419j3 != null) {
                c3419j3.g();
            }
            c3493o1.o = null;
            C3419j1 c3419j4 = c3493o1.p;
            if (c3419j4 != null) {
                c3419j4.g();
            }
            c3493o1.p = null;
            c3493o1.q = null;
            c3493o1.r = null;
            c3493o1.a((Boolean) null);
        }
        this.mPubListener = null;
    }

    public final void disableHardwareAcceleration() {
        this.d.d = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.i, this, me);
        return super.dispatchTouchEvent(me);
    }

    /* JADX INFO: renamed from: getMAdManager$media_release, reason: from getter */
    public final C3493o1 getMAdManager() {
        return this.mAdManager;
    }

    /* JADX INFO: renamed from: getMPubListener$media_release, reason: from getter */
    public final AudioAdEventListener getMPubListener() {
        return this.mPubListener;
    }

    public final void load() {
        C3493o1 c3493o1 = this.mAdManager;
        if (c3493o1 != null) {
            c3493o1.w();
        }
        d();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        try {
            super.onAttachedToWindow();
            C3493o1 c3493o1 = this.mAdManager;
            if (c3493o1 != null) {
                c3493o1.x();
            }
            if (getLayoutParams() != null) {
                this.f = AbstractC3565t3.a(getLayoutParams().width);
                this.g = AbstractC3565t3.a(getLayoutParams().height);
            }
            if (!b()) {
                setupViewSizeObserver();
            }
            if (Build.VERSION.SDK_INT >= 29) {
                C3579u3 c3579u3 = AbstractC3565t3.f3431a;
                Context context = getContext();
                WindowInsets rootWindowInsets = getRootWindowInsets();
                Intrinsics.checkNotNullExpressionValue(rootWindowInsets, "getRootWindowInsets(...)");
                AbstractC3565t3.a(rootWindowInsets, context);
            }
        } catch (Exception unused) {
            AbstractC3498o6.a((byte) 1, "InMobiAudio", "InMobiAudio#onAttachedToWindow() handler threw unexpected error");
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
            C3493o1 c3493o1 = this.mAdManager;
            if (c3493o1 != null) {
                L4 l4P = c3493o1.p();
                if (l4P != null) {
                    String str = AbstractC3507p1.f3395a;
                    Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
                    ((M4) l4P).c(str, "unregisterLifecycleCallbacks " + c3493o1);
                }
                C3419j1 c3419j1 = c3493o1.o;
                if (c3419j1 != null) {
                    c3419j1.I0();
                }
                C3419j1 c3419j2 = c3493o1.p;
                if (c3419j2 != null) {
                    c3419j2.I0();
                }
            }
        } catch (Exception unused) {
            AbstractC3498o6.a((byte) 1, "InMobiAudio", "InMobiAudio.onDetachedFromWindow() handler threw unexpected error");
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

    public final void pause() {
        C3493o1 c3493o1;
        try {
            if (this.c != null || (c3493o1 = this.mAdManager) == null) {
                return;
            }
            L4 l4P = c3493o1.p();
            if (l4P != null) {
                String str = AbstractC3507p1.f3395a;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
                ((M4) l4P).a(str, "pause " + c3493o1);
            }
            C3419j1 c3419j1 = c3493o1.q;
            if (c3419j1 != null) {
                c3419j1.E0();
            }
        } catch (Exception unused) {
            AbstractC3498o6.a((byte) 1, "InMobi", "Could not pause ad; SDK encountered an unexpected error");
        }
    }

    public final void resume() {
        C3493o1 c3493o1;
        try {
            if (this.c != null || (c3493o1 = this.mAdManager) == null) {
                return;
            }
            L4 l4P = c3493o1.p();
            if (l4P != null) {
                String str = AbstractC3507p1.f3395a;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
                ((M4) l4P).a(str, "resume " + c3493o1);
            }
            C3419j1 c3419j1 = c3493o1.q;
            if (c3419j1 != null) {
                c3419j1.F0();
            }
        } catch (Exception unused) {
            AbstractC3498o6.a((byte) 1, "InMobi", "Could not resume ad; SDK encountered an unexpected error");
        }
    }

    public final void setAudioSize(int widthInDp, int heightInDp) {
        this.f = widthInDp;
        this.g = heightInDp;
    }

    public final void setContentUrl(String contentUrl) {
        Intrinsics.checkNotNullParameter(contentUrl, "contentUrl");
        this.d.f = contentUrl;
    }

    public final void setExtras(Map<String, String> extras) {
        if (extras != null) {
            String str = extras.get("tp");
            if (str != null) {
                C3531qb.a(str);
            }
            String str2 = extras.get("tp-v");
            if (str2 != null) {
                C3531qb.b(str2);
            }
        }
        this.d.c = extras;
    }

    public final void setKeywords(String keywords) {
        this.d.b = keywords;
    }

    public final void setListener(AudioAdEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mPubListener = listener;
    }

    public final void setMAdManager$media_release(C3493o1 c3493o1) {
        this.mAdManager = c3493o1;
    }

    public final void setMPubListener$media_release(AudioAdEventListener audioAdEventListener) {
        this.mPubListener = audioAdEventListener;
    }

    public final void setupViewSizeObserver() {
        getViewTreeObserver().addOnGlobalLayoutListener(new C4(this));
    }

    public final void show() {
        C3493o1 c3493o1 = this.mAdManager;
        if (c3493o1 != null) {
            L4 l4P = c3493o1.p();
            if (l4P != null) {
                String str = AbstractC3507p1.f3395a;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
                ((M4) l4P).a(str, "submitAdShowCalled " + c3493o1);
            }
            C3419j1 c3419j1 = c3493o1.r;
            if (c3419j1 != null) {
                c3419j1.w0();
            }
        }
        C3493o1 c3493o2 = this.mAdManager;
        if (c3493o2 != null) {
            c3493o2.a(this);
        }
    }

    public final boolean a() {
        C3493o1 c3493o1;
        long j = this.e;
        if (j != 0 && (c3493o1 = this.mAdManager) != null) {
            L4 l4P = c3493o1.p();
            if (l4P != null) {
                String str = AbstractC3507p1.f3395a;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
                ((M4) l4P).c(str, "checkForRefreshRate " + c3493o1);
            }
            if (c3493o1.r == null) {
                return false;
            }
            LinkedHashMap linkedHashMap = C3578u2.f3440a;
            int minRefreshInterval = ((AdConfig) B4.a("ads", "null cannot be cast to non-null type com.inmobi.commons.core.configs.AdConfig", null)).getAudio().getMinRefreshInterval();
            if (SystemClock.elapsedRealtime() - j < minRefreshInterval * 1000) {
                c3493o1.a((short) 2175);
                c3493o1.b(c3493o1.r, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.EARLY_REFRESH_REQUEST).setCustomMessage("Ad cannot be refreshed before " + minRefreshInterval + " seconds"));
                String str2 = AbstractC3507p1.f3395a;
                Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
                StringBuilder sbAppend = new StringBuilder("Ad cannot be refreshed before ").append(minRefreshInterval).append(" seconds (AdPlacement Id = ");
                C3419j1 c3419j1 = c3493o1.r;
                AbstractC3498o6.a((byte) 1, str2, sbAppend.append(c3419j1 != null ? c3419j1.I() : null).append(')').toString());
                L4 l4P2 = c3493o1.p();
                if (l4P2 == null) {
                    return false;
                }
                Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
                StringBuilder sbAppend2 = new StringBuilder("Ad cannot be refreshed before ").append(minRefreshInterval).append(" seconds (AdPlacement Id = ");
                C3419j1 c3419j2 = c3493o1.r;
                ((M4) l4P2).b(str2, sbAppend2.append(c3419j2 != null ? c3419j2.I() : null).append(')').toString());
                return false;
            }
        }
        this.e = SystemClock.elapsedRealtime();
        return true;
    }

    public final void a(Context context) {
        String str;
        C3493o1 c3493o1 = this.mAdManager;
        if (c3493o1 != null) {
            E9 pubSettings = this.d;
            String adSize = getFrameSizeString();
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(pubSettings, "pubSettings");
            Intrinsics.checkNotNullParameter(adSize, "adSize");
            String str2 = AbstractC3507p1.f3395a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            H h = new H("audio");
            Intrinsics.checkNotNullParameter(context, "context");
            if (context instanceof Activity) {
                str = "activity";
            } else {
                str = "others";
            }
            J jA = h.d(str).a(pubSettings.f3059a).c(pubSettings.b).a(pubSettings.c).a(adSize).a(pubSettings.d).e(pubSettings.e).b(pubSettings.f).a();
            C3419j1 c3419j1 = c3493o1.o;
            if (c3419j1 != null && c3493o1.p != null) {
                c3419j1.a(context, jA, c3493o1);
                C3419j1 c3419j2 = c3493o1.p;
                if (c3419j2 != null) {
                    c3419j2.a(context, jA, c3493o1);
                }
            } else {
                c3493o1.o = new C3419j1(context, jA, c3493o1);
                c3493o1.p = new C3419j1(context, jA, c3493o1);
                c3493o1.r = c3493o1.o;
            }
            String str3 = pubSettings.e;
            if (str3 != null) {
                L4 l4P = c3493o1.p();
                if (l4P != null) {
                    ((M4) l4P).a();
                }
                EnumC3396h6 enumC3396h6 = C3442ka.f3360a;
                c3493o1.a(C3442ka.a("audio", str3, false));
                L4 l4P2 = c3493o1.p();
                if (l4P2 != null) {
                    Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
                    ((M4) l4P2).a(str2, "adding audioAdUnit1 to reference tracker");
                }
                C3419j1 c3419j3 = c3493o1.o;
                Intrinsics.checkNotNull(c3419j3);
                C3442ka.a(c3419j3, c3493o1.p());
                L4 l4P3 = c3493o1.p();
                if (l4P3 != null) {
                    Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
                    ((M4) l4P3).a(str2, "adding audioAdUnit2 to reference tracker");
                }
                C3419j1 c3419j4 = c3493o1.p;
                Intrinsics.checkNotNull(c3419j4);
                C3442ka.a(c3419j4, c3493o1.p());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InMobiAudio(Context context, long j) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        a aVar = new a(this);
        E9 e9 = new E9();
        this.d = e9;
        if (C3517pb.q()) {
            if (context instanceof Activity) {
                this.c = new WeakReference(context);
            }
            this.mAdManager = new C3493o1(aVar);
            e9.f3059a = j;
            a(context);
            return;
        }
        throw new SdkNotInitializedException("InMobiAudio");
    }
}
