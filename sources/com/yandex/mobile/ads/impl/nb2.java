package com.yandex.mobile.ads.impl;

import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes11.dex */
public final class nb2 {
    private static final String d = "yandex_tracking_events";
    private static final List<String> e = CollectionsKt.listOf((Object[]) new String[]{CreativeInfo.S, "social_ad_info", "AdTune", "yandex_ad_info", "bannerId"});

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wk2 f9718a;
    private final jy1 b;
    private final uk2<e62> c;

    public final mb2 a(XmlPullParser parser, wj base64EncodingParameters) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(parser, "parser");
        Intrinsics.checkNotNullParameter(base64EncodingParameters, "base64EncodingParameters");
        this.f9718a.getClass();
        Intrinsics.checkNotNullParameter(parser, "parser");
        parser.require(2, null, "Extensions");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        mb2.a aVar = new mb2.a();
        while (true) {
            this.f9718a.getClass();
            if (!wk2.a(parser)) {
                aVar.a(arrayList2);
                aVar.b(arrayList);
                return aVar.a();
            }
            this.f9718a.getClass();
            if (wk2.b(parser)) {
                if (Intrinsics.areEqual("Extension", parser.getName())) {
                    String attributeValue = parser.getAttributeValue(null, "type");
                    if (e.contains(attributeValue)) {
                        r70 r70VarA = this.b.a(parser, base64EncodingParameters);
                        if (r70VarA != null) {
                            arrayList2.add(r70VarA);
                        }
                    } else if (Intrinsics.areEqual(d, attributeValue)) {
                        arrayList.addAll(this.c.a(parser, base64EncodingParameters));
                    } else {
                        this.f9718a.getClass();
                        wk2.d(parser);
                    }
                } else {
                    this.f9718a.getClass();
                    wk2.d(parser);
                }
            }
        }
    }

    public nb2() {
        wk2 wk2Var = new wk2();
        this.f9718a = wk2Var;
        this.b = new jy1(wk2Var);
        this.c = a();
    }

    private static uk2 a() {
        return new uk2(new f62(), "Extension", "Tracking", new wk2());
    }
}
