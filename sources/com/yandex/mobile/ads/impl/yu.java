package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.smaato.sdk.video.vast.model.Creative;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes6.dex */
public final class yu implements vk2<ru> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wk2 f10769a;
    private final or0 b;
    private final vu c;

    public /* synthetic */ yu(Context context, lp1 lp1Var) {
        this(context, lp1Var, new wk2(), new or0(), new vu(context, lp1Var));
    }

    @Override // com.yandex.mobile.ads.impl.vk2
    public final ru a(XmlPullParser parser, wj base64EncodingParameters) throws XmlPullParserException, JSONException, IOException {
        Intrinsics.checkNotNullParameter(parser, "parser");
        Intrinsics.checkNotNullParameter(base64EncodingParameters, "base64EncodingParameters");
        this.f10769a.getClass();
        Intrinsics.checkNotNullParameter(parser, "parser");
        parser.require(2, null, "Creative");
        xu.a(this.f10769a, parser, "parser", "id", "attributeName");
        String attributeValue = parser.getAttributeValue(null, "id");
        ru.a aVar = new ru.a();
        aVar.b(attributeValue);
        boolean z = false;
        while (true) {
            this.f10769a.getClass();
            if (!wk2.a(parser)) {
                break;
            }
            this.f10769a.getClass();
            if (wk2.b(parser)) {
                String name = parser.getName();
                if (Intrinsics.areEqual("Linear", name)) {
                    this.b.a(parser, aVar, base64EncodingParameters);
                    z = true;
                } else if (Intrinsics.areEqual(Creative.CREATIVE_EXTENSIONS, name)) {
                    aVar.a(this.c.a(parser, base64EncodingParameters));
                } else {
                    this.f10769a.getClass();
                    wk2.d(parser);
                }
            }
        }
        if (z) {
            return aVar.a();
        }
        return null;
    }

    public yu(Context context, lp1 reporter, wk2 xmlHelper, or0 linearCreativeParser, vu creativeExtensionsParser) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(xmlHelper, "xmlHelper");
        Intrinsics.checkNotNullParameter(linearCreativeParser, "linearCreativeParser");
        Intrinsics.checkNotNullParameter(creativeExtensionsParser, "creativeExtensionsParser");
        this.f10769a = xmlHelper;
        this.b = linearCreativeParser;
        this.c = creativeExtensionsParser;
    }
}
