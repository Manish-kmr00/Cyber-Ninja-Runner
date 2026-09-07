package com.yandex.mobile.ads.impl;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes9.dex */
public final class vk0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final jb2 f10487a;
    private final wk2 b;

    public final eb2 a(XmlPullParser parser, eb2.a videoAdBuilder, wj base64EncodingParameters) throws XmlPullParserException, JSONException, IOException {
        Intrinsics.checkNotNullParameter(parser, "parser");
        Intrinsics.checkNotNullParameter(videoAdBuilder, "videoAdBuilder");
        Intrinsics.checkNotNullParameter(base64EncodingParameters, "base64EncodingParameters");
        this.b.getClass();
        Intrinsics.checkNotNullParameter(parser, "parser");
        parser.require(2, null, "InLine");
        while (true) {
            this.b.getClass();
            if (!wk2.a(parser)) {
                break;
            }
            this.b.getClass();
            if (wk2.b(parser)) {
                this.f10487a.a(parser, videoAdBuilder, base64EncodingParameters);
            }
        }
        eb2 eb2VarA = videoAdBuilder.a();
        if (eb2VarA.e().isEmpty()) {
            return null;
        }
        return eb2VarA;
    }

    public /* synthetic */ vk0(jb2 jb2Var) {
        this(jb2Var, new wk2());
    }

    public vk0(jb2 videoAdElementParser, wk2 xmlHelper) {
        Intrinsics.checkNotNullParameter(videoAdElementParser, "videoAdElementParser");
        Intrinsics.checkNotNullParameter(xmlHelper, "xmlHelper");
        this.f10487a = videoAdElementParser;
        this.b = xmlHelper;
    }
}
