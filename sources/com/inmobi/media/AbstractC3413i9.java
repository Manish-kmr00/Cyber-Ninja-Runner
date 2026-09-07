package com.inmobi.media;

import com.iab.omid.library.inmobi.adsession.AdSessionContext;
import com.iab.omid.library.inmobi.adsession.ImpressionType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.i9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public abstract class AbstractC3413i9 {
    public static C3371f9 a(String creativeType, Ba webView, boolean z, String str, byte b, String str2) {
        AdSessionContext adSessionContextCreateHtmlAdSessionContext;
        ImpressionType impressionType;
        Intrinsics.checkNotNullParameter(creativeType, "creativeType");
        if (webView != null) {
            C3487n9 c3487n9 = AbstractC3473m9.f3376a;
            c3487n9.getClass();
            Intrinsics.checkNotNullParameter(webView, "webView");
            adSessionContextCreateHtmlAdSessionContext = AdSessionContext.createHtmlAdSessionContext(c3487n9.b, webView, str, str2);
            Intrinsics.checkNotNullExpressionValue(adSessionContextCreateHtmlAdSessionContext, "createHtmlAdSessionContext(...)");
        } else {
            adSessionContextCreateHtmlAdSessionContext = null;
        }
        if (b == 1) {
            impressionType = ImpressionType.DEFINED_BY_JAVASCRIPT;
        } else if (b == 2) {
            impressionType = ImpressionType.UNSPECIFIED;
        } else if (b == 3) {
            impressionType = ImpressionType.LOADED;
        } else if (b == 4) {
            impressionType = ImpressionType.BEGIN_TO_RENDER;
        } else if (b == 5) {
            impressionType = ImpressionType.ONE_PIXEL;
        } else if (b == 6) {
            impressionType = ImpressionType.VIEWABLE;
        } else if (b == 7) {
            impressionType = ImpressionType.AUDIBLE;
        } else {
            impressionType = b == 0 ? ImpressionType.OTHER : ImpressionType.OTHER;
        }
        int iHashCode = creativeType.hashCode();
        if (iHashCode != -284840886) {
            if (iHashCode != 93166550) {
                if (iHashCode != 112202875) {
                    if (iHashCode == 1425678798 && creativeType.equals("nonvideo")) {
                        return new C3371f9("html_display_ad", impressionType, adSessionContextCreateHtmlAdSessionContext, false);
                    }
                } else if (creativeType.equals("video")) {
                    return new C3371f9("html_video_ad", impressionType, adSessionContextCreateHtmlAdSessionContext, z);
                }
            } else if (creativeType.equals("audio")) {
                return new C3371f9("html_audio_ad", impressionType, adSessionContextCreateHtmlAdSessionContext, z);
            }
        } else if (creativeType.equals("unknown")) {
            Intrinsics.checkNotNullExpressionValue("j9", "access$getTAG$cp(...)");
            return null;
        }
        Intrinsics.checkNotNullExpressionValue("j9", "access$getTAG$cp(...)");
        return null;
    }
}
