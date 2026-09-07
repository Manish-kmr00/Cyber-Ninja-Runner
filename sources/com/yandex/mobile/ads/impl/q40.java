package com.yandex.mobile.ads.impl;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes13.dex */
public final class q40 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wk2 f9980a;

    public final int a(XmlPullParser parser) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(parser, "parser");
        this.f9980a.getClass();
        Intrinsics.checkNotNullParameter(parser, "parser");
        parser.require(2, null, "Duration");
        this.f9980a.getClass();
        Long lA = ud2.a(wk2.c(parser));
        if (lA != null) {
            return (int) lA.longValue();
        }
        return 0;
    }

    public /* synthetic */ q40() {
        this(new wk2());
    }

    public q40(wk2 xmlHelper) {
        Intrinsics.checkNotNullParameter(xmlHelper, "xmlHelper");
        this.f9980a = xmlHelper;
    }
}
