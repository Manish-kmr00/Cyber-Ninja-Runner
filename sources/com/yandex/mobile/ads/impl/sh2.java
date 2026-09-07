package com.yandex.mobile.ads.impl;

import com.smaato.sdk.video.vast.model.ViewableImpression;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes6.dex */
public final class sh2 implements vk2<rh2> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wk2 f10209a;

    @Override // com.yandex.mobile.ads.impl.vk2
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final rh2 a(XmlPullParser parser, wj base64EncodingParameters) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(parser, "parser");
        Intrinsics.checkNotNullParameter(base64EncodingParameters, "base64EncodingParameters");
        this.f10209a.getClass();
        Intrinsics.checkNotNullParameter(parser, "parser");
        parser.require(2, null, "ViewableImpression");
        ArrayList arrayList = new ArrayList();
        while (true) {
            this.f10209a.getClass();
            if (!wk2.a(parser)) {
                return new rh2(arrayList);
            }
            this.f10209a.getClass();
            if (wk2.b(parser)) {
                if (Intrinsics.areEqual(ViewableImpression.VIEWABLE, parser.getName())) {
                    this.f10209a.getClass();
                    arrayList.add(wk2.c(parser));
                } else {
                    this.f10209a.getClass();
                    wk2.d(parser);
                }
            }
        }
    }

    public /* synthetic */ sh2() {
        this(new wk2());
    }

    public sh2(wk2 xmlHelper) {
        Intrinsics.checkNotNullParameter(xmlHelper, "xmlHelper");
        this.f10209a = xmlHelper;
    }
}
