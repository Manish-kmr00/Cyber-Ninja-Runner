package com.mbridge.msdk.mbsignalcommon.windvane;

import com.pubmatic.sdk.common.POBCommonConstants;
import com.pubmatic.sdk.openwrap.core.POBConstants;

/* JADX INFO: compiled from: MimeTypeEnum.java */
/* JADX INFO: loaded from: classes12.dex */
public enum d {
    JS(POBConstants.KEY_JS, "application/x-javascript"),
    CSS("css", "text/css"),
    JPG("jpg", "image/jpeg"),
    JPEG("jpep", "image/jpeg"),
    PNG("png", "image/png"),
    WEBP("webp", "image/webp"),
    GIF("gif", "image/gif"),
    HTM("htm", POBCommonConstants.CONTENT_TYPE_HTML),
    HTML("html", POBCommonConstants.CONTENT_TYPE_HTML);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5260a;
    private String b;

    d(String str, String str2) {
        this.f5260a = str;
        this.b = str2;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.f5260a;
    }
}
