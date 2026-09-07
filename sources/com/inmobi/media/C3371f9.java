package com.inmobi.media;

import android.view.View;
import android.view.ViewGroup;
import com.iab.omid.library.inmobi.adsession.AdEvents;
import com.iab.omid.library.inmobi.adsession.AdSession;
import com.iab.omid.library.inmobi.adsession.AdSessionConfiguration;
import com.iab.omid.library.inmobi.adsession.AdSessionContext;
import com.iab.omid.library.inmobi.adsession.CreativeType;
import com.iab.omid.library.inmobi.adsession.ErrorType;
import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.inmobi.adsession.ImpressionType;
import com.iab.omid.library.inmobi.adsession.Owner;
import com.iab.omid.library.inmobi.adsession.media.InteractionType;
import com.iab.omid.library.inmobi.adsession.media.MediaEvents;
import com.iab.omid.library.inmobi.adsession.media.PlayerState;
import com.iab.omid.library.inmobi.adsession.media.VastProperties;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.f9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3371f9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3315a;
    public final ImpressionType b;
    public AdSessionContext c;
    public final boolean d;
    public byte e;
    public AdSession f;
    public C3546s g;

    public C3371f9(String mAdSessionType, ImpressionType impressionType, AdSessionContext adSessionContext, boolean z) {
        Intrinsics.checkNotNullParameter(mAdSessionType, "mAdSessionType");
        Intrinsics.checkNotNullParameter(impressionType, "impressionType");
        this.f3315a = mAdSessionType;
        this.b = impressionType;
        this.c = adSessionContext;
        this.d = z;
    }

    public static boolean a(byte b, byte b2) {
        if (b == b2) {
            return true;
        }
        C3339d5 c3339d5 = C3339d5.f3292a;
        P1 event = new P1(new Exception("Omid AdSession State Error currentState :: " + ((int) b) + ", expectedState :: " + ((int) b2)));
        Intrinsics.checkNotNullParameter(event, "event");
        C3339d5.c.a(event);
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:29:0x0062  */
    public final void a(View view, Map map, View view2) {
        AdSession adSession;
        CreativeType creativeType;
        Owner owner;
        CreativeType creativeType2;
        Intrinsics.checkNotNullParameter(view, "trackingView");
        if (this.f == null) {
            boolean z = this.d;
            Owner owner2 = Owner.JAVASCRIPT;
            CreativeType creativeType3 = CreativeType.DEFINED_BY_JAVASCRIPT;
            switch (this.f3315a) {
                case "native_display_ad":
                    owner2 = Owner.NATIVE;
                    owner = Owner.NONE;
                    creativeType = CreativeType.NATIVE_DISPLAY;
                    break;
                case "html_display_ad":
                    owner = Owner.NONE;
                    creativeType = CreativeType.HTML_DISPLAY;
                    break;
                case "native_video_ad":
                    owner2 = Owner.NATIVE;
                    creativeType2 = CreativeType.VIDEO;
                    creativeType = creativeType2;
                    owner = owner2;
                    break;
                case "html_audio_ad":
                    creativeType2 = CreativeType.AUDIO;
                    creativeType = creativeType2;
                    owner = owner2;
                    break;
                case "html_video_ad":
                    creativeType2 = CreativeType.VIDEO;
                    creativeType = creativeType2;
                    owner = owner2;
                    break;
                default:
                    creativeType = creativeType3;
                    owner = null;
                    break;
            }
            AdSession adSessionCreateAdSession = AdSession.createAdSession(AdSessionConfiguration.createAdSessionConfiguration(creativeType, this.b, owner2, owner, z), this.c);
            Intrinsics.checkNotNullExpressionValue(adSessionCreateAdSession, "createAdSession(...)");
            this.f = adSessionCreateAdSession;
            if (adSessionCreateAdSession != null) {
                this.g = new C3546s(adSessionCreateAdSession, this.f3315a);
                this.e = (byte) 1;
            }
        }
        Intrinsics.checkNotNullParameter(view, "view");
        if (a(this.e, (byte) 1) && (adSession = this.f) != null) {
            adSession.registerAdView(view);
        }
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                a((View) entry.getKey(), (FriendlyObstructionPurpose) entry.getValue());
            }
        }
        if (view2 != null && (view2 instanceof ViewGroup)) {
            a(view, map, (ViewGroup) view2);
        }
        if (a(this.e, (byte) 1)) {
            AdSession adSession2 = this.f;
            if (adSession2 != null) {
                adSession2.start();
            }
            this.e = (byte) 2;
        }
        AdSession adSession3 = this.f;
        Intrinsics.checkNotNull(adSession3);
        adSession3.getAdSessionId();
    }

    public final void a(int i, int i2, float f, VastProperties vastProps) {
        C3546s c3546s;
        AdEvents adEvents;
        AdSession adSession;
        Intrinsics.checkNotNullParameter(vastProps, "vastProperties");
        if (a(this.e, (byte) 2)) {
            byte b = (byte) i;
            if (b == 17) {
                ErrorType errorType = ErrorType.VIDEO;
                Intrinsics.checkNotNullParameter(errorType, "errorType");
                Intrinsics.checkNotNullParameter("Unknown Player error", "errorMsg");
                if (a(this.e, (byte) 2) && (adSession = this.f) != null) {
                    adSession.error(errorType, "Unknown Player error");
                }
            } else if (b == 0 && (c3546s = this.g) != null && (adEvents = c3546s.f3421a) != null) {
                adEvents.impressionOccurred();
            }
            C3546s c3546s2 = this.g;
            if (c3546s2 != null) {
                Intrinsics.checkNotNullParameter(vastProps, "vastProps");
                MediaEvents mediaEvents = c3546s2.b;
                if (mediaEvents == null) {
                    return;
                }
                if (b == 7) {
                    mediaEvents.pause();
                    return;
                }
                if (b == 5) {
                    AdEvents adEvents2 = c3546s2.f3421a;
                    if (adEvents2 != null) {
                        adEvents2.loaded(vastProps);
                        return;
                    }
                    return;
                }
                if (b == 6) {
                    mediaEvents.start(i2, f);
                    return;
                }
                if (b == 8 || b == 16) {
                    mediaEvents.resume();
                    return;
                }
                if (b == 15) {
                    mediaEvents.skipped();
                    return;
                }
                if (b == 9) {
                    mediaEvents.firstQuartile();
                    return;
                }
                if (b == 10) {
                    mediaEvents.midpoint();
                    return;
                }
                if (b == 11) {
                    mediaEvents.thirdQuartile();
                    return;
                }
                if (b == 12) {
                    mediaEvents.complete();
                    return;
                }
                if (b == 13) {
                    mediaEvents.volumeChange(0.0f);
                    return;
                }
                if (b == 14) {
                    mediaEvents.volumeChange(f);
                    return;
                }
                if (b == 1) {
                    mediaEvents.playerStateChange(PlayerState.FULLSCREEN);
                    return;
                }
                if (b == 2) {
                    mediaEvents.playerStateChange(PlayerState.NORMAL);
                } else if (b == 4) {
                    mediaEvents.adUserInteraction(InteractionType.CLICK);
                } else if (b == 18) {
                    mediaEvents.adUserInteraction(InteractionType.INVITATION_ACCEPTED);
                }
            }
        }
    }

    public final void a(View childView, FriendlyObstructionPurpose obstructionCode) {
        Intrinsics.checkNotNullParameter(childView, "childView");
        Intrinsics.checkNotNullParameter(obstructionCode, "obstructionCode");
        byte b = this.e;
        if (b > 0) {
            AdSession adSession = this.f;
            if (adSession != null) {
                adSession.addFriendlyObstruction(childView, obstructionCode, null);
                return;
            }
            return;
        }
        C3339d5 c3339d5 = C3339d5.f3292a;
        P1 event = new P1(new Exception("Omid AdSession State Error currentState :: " + ((int) b) + ", expectedState :: 1"));
        Intrinsics.checkNotNullParameter(event, "event");
        C3339d5.c.a(event);
    }

    public final void a() {
        AdSession adSession = this.f;
        if (adSession != null) {
            adSession.getAdSessionId();
        }
        if (a(this.e, (byte) 2)) {
            AdSession adSession2 = this.f;
            if (adSession2 != null) {
                adSession2.finish();
            }
            this.f = null;
            this.e = (byte) 3;
        }
    }

    public final void a(View view, Map map, ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (!Intrinsics.areEqual(childAt, view)) {
                if (map == null || !map.containsKey(childAt)) {
                    Intrinsics.checkNotNull(childAt);
                    a(childAt, FriendlyObstructionPurpose.OTHER);
                }
                if (childAt instanceof ViewGroup) {
                    ViewGroup viewGroup2 = (ViewGroup) childAt;
                    if (viewGroup2.getChildCount() > 0) {
                        a(view, map, viewGroup2);
                    }
                }
            }
        }
    }
}
