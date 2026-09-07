package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.smaato.sdk.video.vast.model.Creative;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes6.dex */
public final class vu {
    private static final String e = "yandex_tracking_events";
    private static final String f = "yandex_linear_creative_info";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wk2 f10508a;
    private final nr0 b;
    private final tu<j80> c;
    private final uk2<e62> d;

    private static uk2 b() {
        return new uk2(new f62(), "CreativeExtension", "Tracking", new wk2());
    }

    public final uu a(XmlPullParser parser, wj base64EncodingParameters) throws XmlPullParserException, JSONException, IOException {
        Intrinsics.checkNotNullParameter(parser, "parser");
        Intrinsics.checkNotNullParameter(base64EncodingParameters, "base64EncodingParameters");
        this.f10508a.getClass();
        Intrinsics.checkNotNullParameter(parser, "parser");
        parser.require(2, null, Creative.CREATIVE_EXTENSIONS);
        uu.a aVar = new uu.a();
        while (true) {
            this.f10508a.getClass();
            if (!wk2.a(parser)) {
                return aVar.a();
            }
            this.f10508a.getClass();
            if (wk2.b(parser)) {
                if (Intrinsics.areEqual("CreativeExtension", parser.getName())) {
                    String attributeValue = parser.getAttributeValue(null, "type");
                    if (Intrinsics.areEqual("false_click", attributeValue)) {
                        aVar.a(this.c.a(parser, base64EncodingParameters));
                    } else if (Intrinsics.areEqual(e, attributeValue)) {
                        aVar.a(this.d.a(parser, base64EncodingParameters));
                    } else if (Intrinsics.areEqual(f, attributeValue)) {
                        aVar.a(this.b.a(parser, base64EncodingParameters));
                    } else {
                        this.f10508a.getClass();
                        wk2.d(parser);
                    }
                } else {
                    this.f10508a.getClass();
                    wk2.d(parser);
                }
            }
        }
    }

    public /* synthetic */ vu(Context context, lp1 lp1Var) {
        this(context, lp1Var, new wk2(), new nr0(lp1Var, new ch(context, lp1Var, (sr0) null, 12)));
    }

    public vu(Context context, lp1 reporter, wk2 xmlHelper, nr0 linearCreativeInfoParser) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(xmlHelper, "xmlHelper");
        Intrinsics.checkNotNullParameter(linearCreativeInfoParser, "linearCreativeInfoParser");
        this.f10508a = xmlHelper;
        this.b = linearCreativeInfoParser;
        this.c = a();
        this.d = b();
    }

    private static tu a() {
        return new tu(new o80(new wk2()), new wk2());
    }
}
