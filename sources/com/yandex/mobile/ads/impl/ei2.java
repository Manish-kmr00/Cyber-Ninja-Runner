package com.yandex.mobile.ads.impl;

import android.util.Xml;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes10.dex */
public final class ei2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wk2 f8804a;
    private final v70 b;
    private final t2 c;
    private final e3 d;
    private final s2 e;

    public final ci2 a(String data, vj base64EncodingParameters) throws XmlPullParserException, JSONException, IOException, di2 {
        Object next;
        Object next2;
        Object next3;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(base64EncodingParameters, "base64EncodingParameters");
        XmlPullParser parser = Xml.newPullParser();
        parser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        parser.setInput(new StringReader(data));
        parser.nextTag();
        Intrinsics.checkNotNull(parser);
        this.f8804a.getClass();
        Intrinsics.checkNotNullParameter(parser, "parser");
        parser.require(2, null, "VMAP");
        ArrayList adBreaks = new ArrayList();
        ArrayList extensions = new ArrayList();
        String version = parser.getAttributeValue(null, "version");
        while (true) {
            this.f8804a.getClass();
            if (!wk2.a(parser)) {
                break;
            }
            this.f8804a.getClass();
            if (wk2.b(parser)) {
                String name = parser.getName();
                if (Intrinsics.areEqual("AdBreak", name)) {
                    p2 p2VarA = this.c.a(parser, base64EncodingParameters);
                    if (p2VarA != null) {
                        adBreaks.add(p2VarA);
                    }
                } else if (Intrinsics.areEqual("Extensions", name)) {
                    extensions.addAll(this.b.a(parser, base64EncodingParameters));
                } else {
                    this.f8804a.getClass();
                    wk2.d(parser);
                }
            }
        }
        if (version == null || version.length() == 0) {
            throw new di2();
        }
        this.e.getClass();
        Intrinsics.checkNotNullParameter(extensions, "extensions");
        Iterator it = extensions.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((r70) next).a(), "PageID"));
        r70 r70Var = (r70) next;
        String strB = r70Var != null ? r70Var.b() : null;
        Iterator it2 = extensions.iterator();
        do {
            if (!it2.hasNext()) {
                next2 = null;
                break;
            }
            next2 = it2.next();
        } while (!Intrinsics.areEqual(((r70) next2).a(), "CategoryID"));
        r70 r70Var2 = (r70) next2;
        String strB2 = r70Var2 != null ? r70Var2.b() : null;
        Iterator it3 = extensions.iterator();
        do {
            if (!it3.hasNext()) {
                next3 = null;
                break;
            }
            next3 = it3.next();
        } while (!Intrinsics.areEqual(((r70) next3).a(), "SessionID"));
        r70 r70Var3 = (r70) next3;
        r2 adBreakParameters = new r2(strB, strB2, r70Var3 != null ? r70Var3.b() : null);
        this.d.getClass();
        Intrinsics.checkNotNullParameter(adBreaks, "adBreaks");
        Intrinsics.checkNotNullParameter(adBreakParameters, "adBreakParameters");
        Iterator it4 = adBreaks.iterator();
        while (it4.hasNext()) {
            ((p2) it4.next()).a(adBreakParameters);
        }
        Intrinsics.checkNotNull(version);
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(adBreaks, "adBreaks");
        Intrinsics.checkNotNullParameter(extensions, "extensions");
        return new ci2(version, adBreaks, extensions);
    }

    public /* synthetic */ ei2() {
        wk2 wk2Var = new wk2();
        v70 v70Var = new v70(wk2Var);
        this(wk2Var, v70Var, new t2(wk2Var, v70Var), new e3(), new s2());
    }

    public ei2(wk2 mXmlHelper, v70 extensionsParser, t2 adBreakParser, e3 adBreaksConfigurator, s2 adBreakParametersCreator) {
        Intrinsics.checkNotNullParameter(mXmlHelper, "mXmlHelper");
        Intrinsics.checkNotNullParameter(extensionsParser, "extensionsParser");
        Intrinsics.checkNotNullParameter(adBreakParser, "adBreakParser");
        Intrinsics.checkNotNullParameter(adBreaksConfigurator, "adBreaksConfigurator");
        Intrinsics.checkNotNullParameter(adBreakParametersCreator, "adBreakParametersCreator");
        this.f8804a = mXmlHelper;
        this.b = extensionsParser;
        this.c = adBreakParser;
        this.d = adBreaksConfigurator;
        this.e = adBreakParametersCreator;
    }
}
