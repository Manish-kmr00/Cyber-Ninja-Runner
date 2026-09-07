package com.yandex.mobile.ads.impl;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes4.dex */
public final class wk2 {
    public static boolean a(XmlPullParser p) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(p, "p");
        return p.next() != 3;
    }

    public static boolean b(XmlPullParser p) throws XmlPullParserException {
        Intrinsics.checkNotNullParameter(p, "p");
        return p.getEventType() == 2;
    }

    public static String c(XmlPullParser p) throws XmlPullParserException, IOException {
        String text;
        Intrinsics.checkNotNullParameter(p, "p");
        if (p.next() == 4) {
            text = p.getText();
            Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
            p.nextTag();
        } else {
            text = "";
        }
        int length = text.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) text.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        return text.subSequence(i, length + 1).toString();
    }

    public static void d(XmlPullParser parser) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(parser, "parser");
        if (parser.getEventType() != 2) {
            throw new IllegalStateException("Check failed.".toString());
        }
        int i = 1;
        while (i != 0) {
            int next = parser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }
}
