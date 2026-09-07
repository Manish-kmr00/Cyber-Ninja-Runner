package com.yandex.mobile.ads.impl;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes10.dex */
public final class ra2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wk2 f10090a;

    public final String a(XmlPullParser parser) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(parser, "parser");
        this.f10090a.getClass();
        Intrinsics.checkNotNullParameter(parser, "parser");
        parser.require(2, null, "VerificationParameters");
        this.f10090a.getClass();
        String strC = wk2.c(parser);
        if (strC.length() == 0) {
            return null;
        }
        return strC;
    }

    public /* synthetic */ ra2() {
        this(new wk2());
    }

    public ra2(wk2 xmlHelper) {
        Intrinsics.checkNotNullParameter(xmlHelper, "xmlHelper");
        this.f10090a = xmlHelper;
    }
}
