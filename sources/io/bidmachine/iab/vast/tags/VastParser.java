package io.bidmachine.iab.vast.tags;

import android.text.TextUtils;
import android.util.Xml;
import io.bidmachine.iab.vast.VastLog;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes7.dex */
public class VastParser {
    public static VastTag parseVast(InputStream inputStream) throws Exception {
        if (inputStream == null) {
            throw new Exception();
        }
        XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
        xmlPullParserNewPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
        xmlPullParserNewPullParser.setInput(inputStream, null);
        int next = xmlPullParserNewPullParser.next();
        if (next == 1) {
            throw new Exception();
        }
        while (next != 3 && next != 1) {
            if (xmlPullParserNewPullParser.getEventType() == 2 && VastXmlTag.a(xmlPullParserNewPullParser.getName(), "VAST")) {
                return new VastTag(xmlPullParserNewPullParser);
            }
            next = xmlPullParserNewPullParser.next();
        }
        return null;
    }

    public static VastTag parseVast(String xmlData) throws Exception {
        ByteArrayInputStream byteArrayInputStream;
        if (TextUtils.isEmpty(xmlData)) {
            throw new Exception();
        }
        ByteArrayInputStream byteArrayInputStream2 = null;
        try {
            try {
                byteArrayInputStream = new ByteArrayInputStream(xmlData.getBytes(Charset.defaultCharset().name()));
                try {
                    VastTag vast = parseVast(byteArrayInputStream);
                    try {
                        byteArrayInputStream.close();
                    } catch (Exception e) {
                        VastLog.e("VastXmlParser", e);
                    }
                    return vast;
                } catch (Exception e2) {
                    e = e2;
                    byteArrayInputStream2 = byteArrayInputStream;
                    VastLog.e("VastXmlParser", e);
                    throw new Exception();
                } catch (Throwable th) {
                    th = th;
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (Exception e3) {
                            VastLog.e("VastXmlParser", e3);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                byteArrayInputStream = byteArrayInputStream2;
            }
        } catch (Exception e4) {
            e = e4;
        }
    }
}
