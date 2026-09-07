package com.yandex.mobile.ads.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes12.dex */
public final class uk2<T> implements vk2<List<? extends T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final vk2<T> f10400a;
    private final String b;
    private final String c;
    private final wk2 d;

    @Override // com.yandex.mobile.ads.impl.vk2
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final ArrayList a(XmlPullParser parser, wj base64EncodingParameters) throws XmlPullParserException, JSONException, IOException {
        Intrinsics.checkNotNullParameter(parser, "parser");
        Intrinsics.checkNotNullParameter(base64EncodingParameters, "base64EncodingParameters");
        ArrayList arrayList = new ArrayList();
        wk2 wk2Var = this.d;
        String str = this.b;
        wk2Var.getClass();
        Intrinsics.checkNotNullParameter(parser, "parser");
        parser.require(2, null, str);
        while (true) {
            this.d.getClass();
            if (!wk2.a(parser)) {
                return arrayList;
            }
            this.d.getClass();
            if (wk2.b(parser)) {
                if (Intrinsics.areEqual(this.c, parser.getName())) {
                    T tA = this.f10400a.a(parser, base64EncodingParameters);
                    if (tA != null) {
                        arrayList.add(tA);
                    }
                } else {
                    this.d.getClass();
                    wk2.d(parser);
                }
            }
        }
    }

    public /* synthetic */ uk2(vk2 vk2Var, String str, String str2) {
        this(vk2Var, str, str2, new wk2());
    }

    public uk2(vk2<T> xmlElementParser, String elementsArrayTag, String elementTag, wk2 xmlHelper) {
        Intrinsics.checkNotNullParameter(xmlElementParser, "xmlElementParser");
        Intrinsics.checkNotNullParameter(elementsArrayTag, "elementsArrayTag");
        Intrinsics.checkNotNullParameter(elementTag, "elementTag");
        Intrinsics.checkNotNullParameter(xmlHelper, "xmlHelper");
        this.f10400a = xmlElementParser;
        this.b = elementsArrayTag;
        this.c = elementTag;
        this.d = xmlHelper;
    }
}
