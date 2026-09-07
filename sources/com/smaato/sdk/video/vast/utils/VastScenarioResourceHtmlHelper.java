package com.smaato.sdk.video.vast.utils;

import android.webkit.URLUtil;
import com.smaato.sdk.video.vast.model.StaticResource;
import java.util.Locale;

/* JADX INFO: loaded from: classes13.dex */
final class VastScenarioResourceHtmlHelper {
    static String wrapStaticResourceWithSizeIntoHtml(StaticResource staticResource, String str, String str2) {
        StaticResource.CreativeType creativeType = staticResource.creativeType;
        if (!URLUtil.isValidUrl(staticResource.uri)) {
            return "";
        }
        int i = AnonymousClass1.$SwitchMap$com$smaato$sdk$video$vast$model$StaticResource$CreativeType[creativeType.ordinal()];
        if (i == 1) {
            return String.format(Locale.US, "<html><head></head><body style=\"margin:0;padding:0;-webkit-tap-highlight-color: rgba(0, 0, 0, 0);\"><img src=\"%1$s\" width=\"100%%\" style=\"max-width:100%%;max-height:100%%;\" /></body></html>", staticResource.uri);
        }
        if (i != 2) {
            return i != 3 ? "" : String.format(Locale.US, "<html><head></head><body style=\"margin:0;padding:0;-webkit-tap-highlight-color: rgba(0, 0, 0, 0);\">%1$s</body></html>", staticResource.uri);
        }
        return String.format(Locale.US, "<script src=\"%1$s\"></script>", staticResource.uri);
    }

    /* JADX INFO: renamed from: com.smaato.sdk.video.vast.utils.VastScenarioResourceHtmlHelper$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$smaato$sdk$video$vast$model$StaticResource$CreativeType;

        static {
            int[] iArr = new int[StaticResource.CreativeType.values().length];
            $SwitchMap$com$smaato$sdk$video$vast$model$StaticResource$CreativeType = iArr;
            try {
                iArr[StaticResource.CreativeType.IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$smaato$sdk$video$vast$model$StaticResource$CreativeType[StaticResource.CreativeType.JAVASCRIPT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$smaato$sdk$video$vast$model$StaticResource$CreativeType[StaticResource.CreativeType.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static String wrapHtmlResourceWithSizeIntoHtml(String str, String str2, String str3) {
        return String.format(Locale.US, "<html><head></head><body style=\"margin:0;padding:0;-webkit-tap-highlight-color: rgba(0, 0, 0, 0);\">%1$s</body></html>", str);
    }

    static String wrapIFrameResourceWithSizeIntoHtml(String str, String str2, String str3) {
        return String.format(Locale.US, "<iframe frameborder=\"0\" scrolling=\"no\" marginheight=\"0\" marginwidth=\"0\" style=\"border:0px;margin:0;padding:0\" width=\"%1$s\" height=\"%2$s\" src=\"%3$s\"></iframe>", str2, str3, str);
    }
}
