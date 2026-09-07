package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes11.dex */
public final class pk2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wk2 f9935a;
    private final jb2 b;
    private final nk2 c;

    public final eb2 a(XmlPullParser parser, eb2.a videoAdBuilder, wj base64EncodingParameters) throws XmlPullParserException, JSONException, IOException {
        Intrinsics.checkNotNullParameter(parser, "parser");
        Intrinsics.checkNotNullParameter(videoAdBuilder, "videoAdBuilder");
        Intrinsics.checkNotNullParameter(base64EncodingParameters, "base64EncodingParameters");
        this.f9935a.getClass();
        Intrinsics.checkNotNullParameter(parser, "parser");
        parser.require(2, null, "Wrapper");
        this.c.getClass();
        Intrinsics.checkNotNullParameter(parser, "parser");
        videoAdBuilder.a(new mk2(Boolean.parseBoolean(parser.getAttributeValue(null, "allowMultipleAds")), Boolean.parseBoolean(parser.getAttributeValue(null, "followAdditionalWrappers"))));
        while (true) {
            this.f9935a.getClass();
            if (!wk2.a(parser)) {
                return videoAdBuilder.a();
            }
            this.f9935a.getClass();
            if (wk2.b(parser)) {
                if (Intrinsics.areEqual("VASTAdTagURI", parser.getName())) {
                    this.f9935a.getClass();
                    videoAdBuilder.h(wk2.c(parser));
                } else {
                    this.b.a(parser, videoAdBuilder, base64EncodingParameters);
                }
            }
        }
    }

    public /* synthetic */ pk2(Context context, lp1 lp1Var) {
        this(context, lp1Var, new wk2(), new jb2(context, lp1Var), new nk2());
    }

    public pk2(Context context, lp1 reporter, wk2 xmlHelper, jb2 videoAdElementParser, nk2 wrapperConfigurationParser) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(xmlHelper, "xmlHelper");
        Intrinsics.checkNotNullParameter(videoAdElementParser, "videoAdElementParser");
        Intrinsics.checkNotNullParameter(wrapperConfigurationParser, "wrapperConfigurationParser");
        this.f9935a = xmlHelper;
        this.b = videoAdElementParser;
        this.c = wrapperConfigurationParser;
    }
}
