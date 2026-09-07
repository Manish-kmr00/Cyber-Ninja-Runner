package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes4.dex */
public final class jb2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wk2 f9304a;
    private final uk2<ru> b;
    private final uk2<oa2> c;
    private final sh2 d;
    private final nb2 e;

    public final void a(XmlPullParser parser, eb2.a videoAdBuilder, wj base64EncodingParameters) throws XmlPullParserException, JSONException, IOException {
        Intrinsics.checkNotNullParameter(parser, "parser");
        Intrinsics.checkNotNullParameter(videoAdBuilder, "videoAdBuilder");
        Intrinsics.checkNotNullParameter(base64EncodingParameters, "base64EncodingParameters");
        String name = parser.getName();
        if (Intrinsics.areEqual("Impression", name)) {
            this.f9304a.getClass();
            videoAdBuilder.b(wk2.c(parser));
            return;
        }
        if (Intrinsics.areEqual("ViewableImpression", name)) {
            videoAdBuilder.a(this.d.a(parser, base64EncodingParameters));
            return;
        }
        if (Intrinsics.areEqual("Error", name)) {
            this.f9304a.getClass();
            videoAdBuilder.a(wk2.c(parser));
            return;
        }
        if (Intrinsics.areEqual(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.m, name)) {
            this.f9304a.getClass();
            videoAdBuilder.g(wk2.c(parser));
            return;
        }
        if (Intrinsics.areEqual("Description", name)) {
            this.f9304a.getClass();
            videoAdBuilder.e(wk2.c(parser));
            return;
        }
        if (Intrinsics.areEqual("AdTitle", name)) {
            this.f9304a.getClass();
            videoAdBuilder.d(wk2.c(parser));
            return;
        }
        if (Intrinsics.areEqual("AdSystem", name)) {
            this.f9304a.getClass();
            videoAdBuilder.c(wk2.c(parser));
            return;
        }
        if (Intrinsics.areEqual("Creatives", name)) {
            videoAdBuilder.a(this.b.a(parser, base64EncodingParameters));
            return;
        }
        if (Intrinsics.areEqual("AdVerifications", name)) {
            videoAdBuilder.a((List) this.c.a(parser, base64EncodingParameters));
        } else if (Intrinsics.areEqual("Extensions", name)) {
            videoAdBuilder.a(this.e.a(parser, base64EncodingParameters));
        } else {
            this.f9304a.getClass();
            wk2.d(parser);
        }
    }

    public /* synthetic */ jb2(Context context, lp1 lp1Var) {
        this(context, lp1Var, new wk2(), new uk2(new yu(context, lp1Var), "Creatives", "Creative"), new uk2(new sa2(), "AdVerifications", "Verification"), new sh2(), new nb2());
    }

    public jb2(Context context, lp1 reporter, wk2 xmlHelper, uk2<ru> creativeArrayParser, uk2<oa2> verificationArrayParser, sh2 viewableImpressionParser, nb2 videoAdExtensionsParser) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(xmlHelper, "xmlHelper");
        Intrinsics.checkNotNullParameter(creativeArrayParser, "creativeArrayParser");
        Intrinsics.checkNotNullParameter(verificationArrayParser, "verificationArrayParser");
        Intrinsics.checkNotNullParameter(viewableImpressionParser, "viewableImpressionParser");
        Intrinsics.checkNotNullParameter(videoAdExtensionsParser, "videoAdExtensionsParser");
        this.f9304a = xmlHelper;
        this.b = creativeArrayParser;
        this.c = verificationArrayParser;
        this.d = viewableImpressionParser;
        this.e = videoAdExtensionsParser;
    }
}
