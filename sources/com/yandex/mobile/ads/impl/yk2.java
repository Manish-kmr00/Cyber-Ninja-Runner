package com.yandex.mobile.ads.impl;

import java.io.IOException;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: loaded from: classes11.dex */
final class yk2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f10748a = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};
    private static final String[] b = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};
    private static final String[] c = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    private static u11 b(String str) throws XmlPullParserException, IOException {
        long j;
        XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
        xmlPullParserNewPullParser.setInput(new StringReader(str));
        xmlPullParserNewPullParser.next();
        if (!xk2.c(xmlPullParserNewPullParser, "x:xmpmeta")) {
            throw ag1.a("Couldn't find xmp metadata", (Exception) null);
        }
        hk0<u11.a> hk0VarH = hk0.h();
        long j2 = -9223372036854775807L;
        loop0: do {
            xmlPullParserNewPullParser.next();
            if (xk2.c(xmlPullParserNewPullParser, "rdf:Description")) {
                String[] strArr = f10748a;
                int i = 0;
                for (int i2 = 0; i2 < 4; i2++) {
                    String strA = xk2.a(xmlPullParserNewPullParser, strArr[i2]);
                    if (strA != null) {
                        if (Integer.parseInt(strA) != 1) {
                            break loop0;
                        }
                        String[] strArr2 = b;
                        int i3 = 0;
                        while (true) {
                            if (i3 < 4) {
                                String strA2 = xk2.a(xmlPullParserNewPullParser, strArr2[i3]);
                                if (strA2 != null) {
                                    j = Long.parseLong(strA2);
                                    if (j != -1) {
                                        break;
                                    }
                                    break;
                                }
                                i3++;
                            }
                            j = -9223372036854775807L;
                            break;
                        }
                        String[] strArr3 = c;
                        while (true) {
                            if (i >= 2) {
                                hk0VarH = hk0.h();
                                break;
                            }
                            String strA3 = xk2.a(xmlPullParserNewPullParser, strArr3[i]);
                            if (strA3 != null) {
                                hk0VarH = hk0.a(new u11.a("image/jpeg", 0L, 0L), new u11.a("video/mp4", Long.parseLong(strA3), 0L));
                                break;
                            }
                            i++;
                        }
                        j2 = j;
                    }
                }
                return null;
            }
            if (xk2.c(xmlPullParserNewPullParser, "Container:Directory")) {
                hk0VarH = a(xmlPullParserNewPullParser, "Container", "Item");
            } else if (xk2.c(xmlPullParserNewPullParser, "GContainer:Directory")) {
                hk0VarH = a(xmlPullParserNewPullParser, "GContainer", "GContainerItem");
            }
        } while (!xk2.b(xmlPullParserNewPullParser, "x:xmpmeta"));
        if (hk0VarH.isEmpty()) {
            return null;
        }
        return new u11(j2, hk0VarH);
    }

    public static u11 a(String str) throws IOException {
        try {
            return b(str);
        } catch (ag1 | NumberFormatException | XmlPullParserException unused) {
            at0.d("MotionPhotoXmpParser", "Ignoring unexpected XMP metadata");
            return null;
        }
    }

    private static hk0<u11.a> a(XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException, IOException {
        int i = hk0.d;
        hk0.a aVar = new hk0.a();
        String strConcat = str.concat(":Item");
        String strConcat2 = str.concat(":Directory");
        do {
            xmlPullParser.next();
            if (xk2.c(xmlPullParser, strConcat)) {
                String strConcat3 = str2.concat(":Mime");
                String strConcat4 = str2.concat(":Semantic");
                String strConcat5 = str2.concat(":Length");
                String strConcat6 = str2.concat(":Padding");
                String strA = xk2.a(xmlPullParser, strConcat3);
                String strA2 = xk2.a(xmlPullParser, strConcat4);
                String strA3 = xk2.a(xmlPullParser, strConcat5);
                String strA4 = xk2.a(xmlPullParser, strConcat6);
                if (strA != null && strA2 != null) {
                    aVar.b(new u11.a(strA, strA3 != null ? Long.parseLong(strA3) : 0L, strA4 != null ? Long.parseLong(strA4) : 0L));
                } else {
                    return hk0.h();
                }
            }
        } while (!xk2.b(xmlPullParser, strConcat2));
        return aVar.a();
    }
}
