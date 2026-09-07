package com.yandex.mobile.ads.impl;

import android.text.Layout;
import com.google.common.base.Ascii;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: loaded from: classes11.dex */
public final class k72 extends ny1 {
    private static final Pattern n = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final Pattern o = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    private static final Pattern p = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    static final Pattern q = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");
    static final Pattern r = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    private static final Pattern s = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");
    private static final Pattern t = Pattern.compile("^(\\d+) (\\d+)$");
    private static final b u = new b(30.0f, 1, 1);
    private static final a v = new a(15);
    private final XmlPullParserFactory m;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f9386a;

        a(int i) {
            this.f9386a = i;
        }
    }

    public k72() {
        try {
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            this.m = xmlPullParserFactoryNewInstance;
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    private static o72 a(o72 o72Var) {
        return o72Var == null ? new o72() : o72Var;
    }

    private static Layout.Alignment b(String str) {
        String strB = fg.b(str);
        strB.getClass();
        strB.hashCode();
        switch (strB) {
            case "center":
                return Layout.Alignment.ALIGN_CENTER;
            case "end":
            case "right":
                return Layout.Alignment.ALIGN_OPPOSITE;
            case "left":
            case "start":
                return Layout.Alignment.ALIGN_NORMAL;
            default:
                return null;
        }
    }

    @Override // com.yandex.mobile.ads.impl.ny1
    protected final g32 a(byte[] bArr, int i, boolean z) throws i32 {
        b bVar;
        try {
            XmlPullParser xmlPullParserNewPullParser = this.m.newPullParser();
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            HashMap map3 = new HashMap();
            map2.put("", new m72("", -3.4028235E38f, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE));
            c cVarB = null;
            xmlPullParserNewPullParser.setInput(new ByteArrayInputStream(bArr, 0, i), null);
            ArrayDeque arrayDeque = new ArrayDeque();
            b bVarA = u;
            a aVarA = v;
            int i2 = 0;
            p72 p72Var = null;
            for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.getEventType()) {
                l72 l72Var = (l72) arrayDeque.peek();
                if (i2 == 0) {
                    String name = xmlPullParserNewPullParser.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            bVarA = a(xmlPullParserNewPullParser);
                            aVarA = a(xmlPullParserNewPullParser, v);
                            cVarB = b(xmlPullParserNewPullParser);
                        }
                        c cVar = cVarB;
                        b bVar2 = bVarA;
                        a aVar = aVarA;
                        if (!a(name)) {
                            at0.c("TtmlDecoder", "Ignoring unsupported tag: " + xmlPullParserNewPullParser.getName());
                            bVar = bVar2;
                        } else {
                            if ("head".equals(name)) {
                                bVar = bVar2;
                                a(xmlPullParserNewPullParser, map, aVar, cVar, map2, map3);
                            } else {
                                bVar = bVar2;
                                try {
                                    l72 l72VarA = a(xmlPullParserNewPullParser, l72Var, map2, bVar);
                                    arrayDeque.push(l72VarA);
                                    if (l72Var != null) {
                                        l72Var.a(l72VarA);
                                    }
                                } catch (i32 e) {
                                    at0.b("TtmlDecoder", "Suppressing parser error", e);
                                    bVarA = bVar;
                                    cVarB = cVar;
                                    aVarA = aVar;
                                    i2++;
                                }
                            }
                            bVarA = bVar;
                            cVarB = cVar;
                            aVarA = aVar;
                        }
                        bVarA = bVar;
                        cVarB = cVar;
                        aVarA = aVar;
                        i2++;
                    } else if (eventType == 4) {
                        l72Var.getClass();
                        l72Var.a(l72.a(xmlPullParserNewPullParser.getText()));
                    } else if (eventType == 3) {
                        if (xmlPullParserNewPullParser.getName().equals("tt")) {
                            l72 l72Var2 = (l72) arrayDeque.peek();
                            l72Var2.getClass();
                            p72Var = new p72(l72Var2, map, map2, map3);
                        }
                        arrayDeque.pop();
                    }
                } else if (eventType == 2) {
                    i2++;
                } else if (eventType == 3) {
                    i2--;
                }
                xmlPullParserNewPullParser.next();
            }
            if (p72Var != null) {
                return p72Var;
            }
            throw new i32("No TTML subtitles found");
        } catch (IOException e2) {
            throw new IllegalStateException("Unexpected error when reading input.", e2);
        } catch (XmlPullParserException e3) {
            throw new i32("Unable to decode source", e3);
        }
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final float f9387a;
        final int b;
        final int c;

        b(float f, int i, int i2) {
            this.f9387a = f;
            this.b = i;
            this.c = i2;
        }
    }

    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f9388a;
        final int b;

        c(int i, int i2) {
            this.f9388a = i;
            this.b = i2;
        }
    }

    private static c b(XmlPullParser xmlPullParser) {
        String strA = xk2.a(xmlPullParser, "extent");
        if (strA == null) {
            return null;
        }
        Matcher matcher = s.matcher(strA);
        if (!matcher.matches()) {
            at0.d("TtmlDecoder", "Ignoring non-pixel tts extent: ".concat(strA));
            return null;
        }
        try {
            String strGroup = matcher.group(1);
            strGroup.getClass();
            int i = Integer.parseInt(strGroup);
            String strGroup2 = matcher.group(2);
            strGroup2.getClass();
            return new c(i, Integer.parseInt(strGroup2));
        } catch (NumberFormatException unused) {
            at0.d("TtmlDecoder", "Ignoring malformed tts extent: ".concat(strA));
            return null;
        }
    }

    private static boolean a(String str) {
        return str.equals("tt") || str.equals("head") || str.equals("body") || str.equals("div") || str.equals("p") || str.equals("span") || str.equals("br") || str.equals("style") || str.equals("styling") || str.equals("layout") || str.equals("region") || str.equals("metadata") || str.equals("image") || str.equals("data") || str.equals("information");
    }

    private static a a(XmlPullParser xmlPullParser, a aVar) throws i32 {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
        if (attributeValue == null) {
            return aVar;
        }
        Matcher matcher = t.matcher(attributeValue);
        if (!matcher.matches()) {
            at0.d("TtmlDecoder", "Ignoring malformed cell resolution: ".concat(attributeValue));
            return aVar;
        }
        try {
            String strGroup = matcher.group(1);
            strGroup.getClass();
            int i = Integer.parseInt(strGroup);
            String strGroup2 = matcher.group(2);
            strGroup2.getClass();
            int i2 = Integer.parseInt(strGroup2);
            if (i != 0 && i2 != 0) {
                return new a(i2);
            }
            throw new i32("Invalid cell resolution " + i + " " + i2);
        } catch (NumberFormatException unused) {
            at0.d("TtmlDecoder", "Ignoring malformed cell resolution: ".concat(attributeValue));
            return aVar;
        }
    }

    private static void a(String str, o72 o72Var) throws i32 {
        Matcher matcher;
        int i = x82.f10629a;
        String[] strArrSplit = str.split("\\s+", -1);
        if (strArrSplit.length == 1) {
            matcher = p.matcher(str);
        } else if (strArrSplit.length == 2) {
            matcher = p.matcher(strArrSplit[1]);
            at0.d("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        } else {
            throw new i32("Invalid number of entries for fontSize: " + strArrSplit.length + ".");
        }
        if (matcher.matches()) {
            String strGroup = matcher.group(3);
            strGroup.getClass();
            strGroup.hashCode();
            switch (strGroup) {
                case "%":
                    o72Var.c(3);
                    break;
                case "em":
                    o72Var.c(2);
                    break;
                case "px":
                    o72Var.c(1);
                    break;
                default:
                    throw new i32("Invalid unit for fontSize: '" + strGroup + "'.");
            }
            String strGroup2 = matcher.group(1);
            strGroup2.getClass();
            o72Var.a(Float.parseFloat(strGroup2));
            return;
        }
        throw new i32("Invalid expression for fontSize: '" + str + "'.");
    }

    private static b a(XmlPullParser xmlPullParser) throws i32 {
        float f;
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        int i = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            int i2 = x82.f10629a;
            String[] strArrSplit = attributeValue2.split(" ", -1);
            if (strArrSplit.length == 2) {
                f = Integer.parseInt(strArrSplit[0]) / Integer.parseInt(strArrSplit[1]);
            } else {
                throw new i32("frameRateMultiplier doesn't have 2 parts");
            }
        } else {
            f = 1.0f;
        }
        b bVar = u;
        int i3 = bVar.b;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i3 = Integer.parseInt(attributeValue3);
        }
        int i4 = bVar.c;
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i4 = Integer.parseInt(attributeValue4);
        }
        return new b(i * f, i3, i4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:105:0x0133 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:109:0x00fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:43:0x0122  */
    /* JADX WARN: Code duplicated, block: B:45:0x0128 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:46:0x012a  */
    /* JADX WARN: Code duplicated, block: B:51:0x015d  */
    /* JADX WARN: Code duplicated, block: B:53:0x016c  */
    /* JADX WARN: Code duplicated, block: B:56:0x0175  */
    /* JADX WARN: Code duplicated, block: B:57:0x017a  */
    /* JADX WARN: Code duplicated, block: B:58:0x0184  */
    /* JADX WARN: Code duplicated, block: B:61:0x0196  */
    /* JADX WARN: Code duplicated, block: B:63:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:64:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:67:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:68:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:71:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:72:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:75:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:78:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:79:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:80:0x01d6 A[PHI: r3
  0x01d6: PHI (r3v10 int) = (r3v9 int), (r3v5 int) binds: [B:79:0x01d4, B:76:0x01cd] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:83:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:84:0x01f9  */
    private static void a(XmlPullParser xmlPullParser, HashMap map, a aVar, c cVar, HashMap map2, HashMap map3) throws XmlPullParserException, IOException {
        String strA;
        float f;
        float f2;
        String strA2;
        Matcher matcher;
        Matcher matcher2;
        float f3;
        float f4;
        String strA3;
        int i;
        String strA4;
        int i2;
        m72 m72Var;
        String strB;
        String strB2;
        String[] strArrSplit;
        do {
            xmlPullParser.next();
            if (xk2.c(xmlPullParser, "style")) {
                String strA5 = xk2.a(xmlPullParser, "style");
                o72 o72VarA = a(xmlPullParser, new o72());
                if (strA5 != null) {
                    String strTrim = strA5.trim();
                    if (strTrim.isEmpty()) {
                        strArrSplit = new String[0];
                    } else {
                        int i3 = x82.f10629a;
                        strArrSplit = strTrim.split("\\s+", -1);
                    }
                    for (String str : strArrSplit) {
                        o72VarA.a((o72) map.get(str));
                    }
                }
                String strF = o72VarA.f();
                if (strF != null) {
                    map.put(strF, o72VarA);
                }
            } else if (xk2.c(xmlPullParser, "region")) {
                String strA6 = xk2.a(xmlPullParser, "id");
                if (strA6 != null) {
                    String strA7 = xk2.a(xmlPullParser, "origin");
                    if (strA7 != null) {
                        Pattern pattern = r;
                        Matcher matcher3 = pattern.matcher(strA7);
                        Pattern pattern2 = s;
                        Matcher matcher4 = pattern2.matcher(strA7);
                        int i4 = 2;
                        if (matcher3.matches()) {
                            try {
                                String strGroup = matcher3.group(1);
                                strGroup.getClass();
                                float f5 = Float.parseFloat(strGroup) / 100.0f;
                                String strGroup2 = matcher3.group(2);
                                strGroup2.getClass();
                                f = Float.parseFloat(strGroup2) / 100.0f;
                                f2 = f5;
                                strA2 = xk2.a(xmlPullParser, "extent");
                                if (strA2 != null) {
                                    matcher = pattern.matcher(strA2);
                                    matcher2 = pattern2.matcher(strA2);
                                    if (matcher.matches()) {
                                        try {
                                            String strGroup3 = matcher.group(1);
                                            strGroup3.getClass();
                                            float f6 = Float.parseFloat(strGroup3) / 100.0f;
                                            String strGroup4 = matcher.group(2);
                                            strGroup4.getClass();
                                            f3 = Float.parseFloat(strGroup4) / 100.0f;
                                            f4 = f6;
                                        } catch (NumberFormatException unused) {
                                            at0.d("TtmlDecoder", "Ignoring region with malformed extent: ".concat(strA7));
                                            m72Var = null;
                                        }
                                    } else if (matcher2.matches()) {
                                        at0.d("TtmlDecoder", "Ignoring region with unsupported extent: ".concat(strA7));
                                    } else if (cVar == null) {
                                        at0.d("TtmlDecoder", "Ignoring region with missing tts:extent: ".concat(strA7));
                                    } else {
                                        try {
                                            String strGroup5 = matcher2.group(1);
                                            strGroup5.getClass();
                                            int i5 = Integer.parseInt(strGroup5);
                                            String strGroup6 = matcher2.group(2);
                                            strGroup6.getClass();
                                            float f7 = Integer.parseInt(strGroup6);
                                            f4 = i5 / cVar.f9388a;
                                            f3 = f7 / cVar.b;
                                        } catch (NumberFormatException unused2) {
                                            at0.d("TtmlDecoder", "Ignoring region with malformed extent: ".concat(strA7));
                                            m72Var = null;
                                        }
                                    }
                                    strA3 = xk2.a(xmlPullParser, "displayAlign");
                                    if (strA3 != null) {
                                        strB2 = fg.b(strA3);
                                        strB2.getClass();
                                        if (!strB2.equals("center")) {
                                            f = (f3 / 2.0f) + f;
                                            i = 1;
                                        } else if (strB2.equals("after")) {
                                            f += f3;
                                            i = 2;
                                        } else {
                                            i = 0;
                                        }
                                    } else {
                                        i = 0;
                                    }
                                    float f8 = 1.0f / aVar.f9386a;
                                    strA4 = xk2.a(xmlPullParser, "writingMode");
                                    if (strA4 != null) {
                                        strB = fg.b(strA4);
                                        strB.getClass();
                                        strB.hashCode();
                                        switch (strB) {
                                            case "tb":
                                            case "tblr":
                                                i2 = i4;
                                                break;
                                            case "tbrl":
                                                i2 = 1;
                                                break;
                                            default:
                                                i4 = Integer.MIN_VALUE;
                                                i2 = i4;
                                                break;
                                        }
                                    } else {
                                        i4 = Integer.MIN_VALUE;
                                        i2 = i4;
                                    }
                                    m72Var = new m72(strA6, f2, f, 0, i, f4, f3, 1, f8, i2);
                                } else {
                                    at0.d("TtmlDecoder", "Ignoring region without an extent");
                                }
                            } catch (NumberFormatException unused3) {
                                at0.d("TtmlDecoder", "Ignoring region with malformed origin: ".concat(strA7));
                            }
                        } else if (!matcher4.matches()) {
                            at0.d("TtmlDecoder", "Ignoring region with unsupported origin: ".concat(strA7));
                        } else if (cVar == null) {
                            at0.d("TtmlDecoder", "Ignoring region with missing tts:extent: ".concat(strA7));
                        } else {
                            try {
                                String strGroup7 = matcher4.group(1);
                                strGroup7.getClass();
                                int i6 = Integer.parseInt(strGroup7);
                                String strGroup8 = matcher4.group(2);
                                strGroup8.getClass();
                                int i7 = Integer.parseInt(strGroup8);
                                f2 = i6 / cVar.f9388a;
                                f = i7 / cVar.b;
                                strA2 = xk2.a(xmlPullParser, "extent");
                                if (strA2 != null) {
                                    matcher = pattern.matcher(strA2);
                                    matcher2 = pattern2.matcher(strA2);
                                    if (matcher.matches()) {
                                        String strGroup9 = matcher.group(1);
                                        strGroup9.getClass();
                                        float f9 = Float.parseFloat(strGroup9) / 100.0f;
                                        String strGroup10 = matcher.group(2);
                                        strGroup10.getClass();
                                        f3 = Float.parseFloat(strGroup10) / 100.0f;
                                        f4 = f9;
                                    } else if (matcher2.matches()) {
                                        at0.d("TtmlDecoder", "Ignoring region with unsupported extent: ".concat(strA7));
                                    } else if (cVar == null) {
                                        at0.d("TtmlDecoder", "Ignoring region with missing tts:extent: ".concat(strA7));
                                    } else {
                                        String strGroup11 = matcher2.group(1);
                                        strGroup11.getClass();
                                        int i8 = Integer.parseInt(strGroup11);
                                        String strGroup12 = matcher2.group(2);
                                        strGroup12.getClass();
                                        float f10 = Integer.parseInt(strGroup12);
                                        f4 = i8 / cVar.f9388a;
                                        f3 = f10 / cVar.b;
                                    }
                                    strA3 = xk2.a(xmlPullParser, "displayAlign");
                                    if (strA3 != null) {
                                        strB2 = fg.b(strA3);
                                        strB2.getClass();
                                        if (!strB2.equals("center")) {
                                            f = (f3 / 2.0f) + f;
                                            i = 1;
                                        } else if (strB2.equals("after")) {
                                            i = 0;
                                        } else {
                                            f += f3;
                                            i = 2;
                                        }
                                    } else {
                                        i = 0;
                                    }
                                    float f11 = 1.0f / aVar.f9386a;
                                    strA4 = xk2.a(xmlPullParser, "writingMode");
                                    if (strA4 != null) {
                                        strB = fg.b(strA4);
                                        strB.getClass();
                                        strB.hashCode();
                                        switch (strB) {
                                            case 3694:
                                                if (!strB.equals("tb")) {
                                                }
                                                break;
                                            case 3553396:
                                                if (!strB.equals("tblr")) {
                                                }
                                                break;
                                            case 3553576:
                                                if (!strB.equals("tbrl")) {
                                                }
                                                break;
                                            default:
                                                break;
                                        }
                                        /*  JADX ERROR: Method code generation error
                                            java.lang.NullPointerException: Switch insn not found in header
                                            	at java.base/java.util.Objects.requireNonNull(Unknown Source)
                                            	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:246)
                                            	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                            	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:320)
                                            	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                                            	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:157)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                                            	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:157)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                            	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:157)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                            	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:216)
                                            	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:173)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                                            	at java.base/java.util.ArrayList.forEach(Unknown Source)
                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                                            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
                                            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
                                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
                                            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
                                            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
                                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                                            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                                            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                                            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                                            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                                            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                                            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                                            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
                                            */
                                        /*
                                            Method dump skipped, instruction units count: 630
                                            To view this dump change 'Code comments level' option to 'DEBUG'
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.yandex.mobile.ads.impl.k72.a(org.xmlpull.v1.XmlPullParser, java.util.HashMap, com.yandex.mobile.ads.impl.k72$a, com.yandex.mobile.ads.impl.k72$c, java.util.HashMap, java.util.HashMap):void");
                                    }

                                    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                                    /* JADX WARN: Code duplicated, block: B:6:0x003c  */
                                    /* JADX WARN: Code duplicated, block: B:71:0x0106  */
                                    private static l72 a(XmlPullParser xmlPullParser, l72 l72Var, HashMap map, b bVar) throws i32 {
                                        long j;
                                        long j2;
                                        String[] strArrSplit;
                                        int attributeCount = xmlPullParser.getAttributeCount();
                                        o72 o72VarA = a(xmlPullParser, (o72) null);
                                        String[] strArr = null;
                                        String strSubstring = null;
                                        String str = "";
                                        long jA = -9223372036854775807L;
                                        long jA2 = -9223372036854775807L;
                                        long jA3 = -9223372036854775807L;
                                        for (int i = 0; i < attributeCount; i++) {
                                            String attributeName = xmlPullParser.getAttributeName(i);
                                            String attributeValue = xmlPullParser.getAttributeValue(i);
                                            attributeName.getClass();
                                            attributeName.hashCode();
                                            switch (attributeName) {
                                                case "region":
                                                    if (map.containsKey(attributeValue)) {
                                                        str = attributeValue;
                                                        break;
                                                    } else {
                                                        break;
                                                    }
                                                    break;
                                                case "dur":
                                                    jA3 = a(attributeValue, bVar);
                                                    break;
                                                case "end":
                                                    jA2 = a(attributeValue, bVar);
                                                    break;
                                                case "begin":
                                                    jA = a(attributeValue, bVar);
                                                    break;
                                                case "style":
                                                    String strTrim = attributeValue.trim();
                                                    if (strTrim.isEmpty()) {
                                                        strArrSplit = new String[0];
                                                    } else {
                                                        int i2 = x82.f10629a;
                                                        strArrSplit = strTrim.split("\\s+", -1);
                                                    }
                                                    if (strArrSplit.length > 0) {
                                                        strArr = strArrSplit;
                                                    }
                                                    break;
                                                case "backgroundImage":
                                                    if (attributeValue.startsWith("#")) {
                                                        strSubstring = attributeValue.substring(1);
                                                        break;
                                                    }
                                                default:
                                                    break;
                                            }
                                        }
                                        if (l72Var != null) {
                                            long j3 = l72Var.d;
                                            j = -9223372036854775807L;
                                            if (j3 != -9223372036854775807L) {
                                                if (jA != -9223372036854775807L) {
                                                    jA += j3;
                                                }
                                                if (jA2 != -9223372036854775807L) {
                                                    jA2 += j3;
                                                }
                                            }
                                        } else {
                                            j = -9223372036854775807L;
                                        }
                                        long j4 = jA;
                                        if (jA2 != j) {
                                            j2 = jA2;
                                        } else if (jA3 != j) {
                                            j2 = j4 + jA3;
                                        } else if (l72Var != null) {
                                            long j5 = l72Var.e;
                                            if (j5 != j) {
                                                j2 = j5;
                                            } else {
                                                j2 = jA2;
                                            }
                                        } else {
                                            j2 = jA2;
                                        }
                                        return l72.a(xmlPullParser.getName(), j4, j2, o72VarA, strArr, str, strSubstring, l72Var);
                                    }

                                    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
                                    private static o72 a(XmlPullParser xmlPullParser, o72 o72Var) {
                                        byte b2;
                                        int attributeCount = xmlPullParser.getAttributeCount();
                                        for (int i = 0; i < attributeCount; i++) {
                                            String attributeValue = xmlPullParser.getAttributeValue(i);
                                            String attributeName = xmlPullParser.getAttributeName(i);
                                            attributeName.getClass();
                                            attributeName.hashCode();
                                            attributeName.hashCode();
                                            switch (attributeName.hashCode()) {
                                                case -1550943582:
                                                    b2 = attributeName.equals("fontStyle") ? (byte) 0 : (byte) -1;
                                                    break;
                                                case -1224696685:
                                                    b2 = attributeName.equals("fontFamily") ? (byte) 1 : (byte) -1;
                                                    break;
                                                case -1065511464:
                                                    b2 = attributeName.equals("textAlign") ? (byte) 2 : (byte) -1;
                                                    break;
                                                case -879295043:
                                                    b2 = attributeName.equals("textDecoration") ? (byte) 3 : (byte) -1;
                                                    break;
                                                case -734428249:
                                                    b2 = attributeName.equals("fontWeight") ? (byte) 4 : (byte) -1;
                                                    break;
                                                case 3355:
                                                    b2 = attributeName.equals("id") ? (byte) 5 : (byte) -1;
                                                    break;
                                                case 3511770:
                                                    b2 = attributeName.equals("ruby") ? (byte) 6 : (byte) -1;
                                                    break;
                                                case 94842723:
                                                    b2 = attributeName.equals("color") ? (byte) 7 : (byte) -1;
                                                    break;
                                                case 109403361:
                                                    b2 = attributeName.equals("shear") ? (byte) 8 : (byte) -1;
                                                    break;
                                                case 110138194:
                                                    b2 = attributeName.equals("textCombine") ? (byte) 9 : (byte) -1;
                                                    break;
                                                case 365601008:
                                                    b2 = attributeName.equals("fontSize") ? (byte) 10 : (byte) -1;
                                                    break;
                                                case 921125321:
                                                    b2 = attributeName.equals("textEmphasis") ? Ascii.VT : (byte) -1;
                                                    break;
                                                case 1115953443:
                                                    b2 = attributeName.equals("rubyPosition") ? Ascii.FF : (byte) -1;
                                                    break;
                                                case 1287124693:
                                                    b2 = attributeName.equals("backgroundColor") ? Ascii.CR : (byte) -1;
                                                    break;
                                                case 1754920356:
                                                    b2 = attributeName.equals("multiRowAlign") ? Ascii.SO : (byte) -1;
                                                    break;
                                                default:
                                                    b2 = -1;
                                                    break;
                                            }
                                            switch (b2) {
                                                case 0:
                                                    o72Var = a(o72Var).b("italic".equalsIgnoreCase(attributeValue));
                                                    break;
                                                case 1:
                                                    o72Var = a(o72Var).a(attributeValue);
                                                    break;
                                                case 2:
                                                    o72Var = a(o72Var).b(b(attributeValue));
                                                    break;
                                                case 3:
                                                    String strB = fg.b(attributeValue);
                                                    strB.getClass();
                                                    strB.hashCode();
                                                    strB.hashCode();
                                                    switch (strB) {
                                                        case "nounderline":
                                                            o72Var = a(o72Var).e(false);
                                                            break;
                                                        case "underline":
                                                            o72Var = a(o72Var).e(true);
                                                            break;
                                                        case "nolinethrough":
                                                            o72Var = a(o72Var).c(false);
                                                            break;
                                                        case "linethrough":
                                                            o72Var = a(o72Var).c(true);
                                                            break;
                                                    }
                                                    break;
                                                case 4:
                                                    o72Var = a(o72Var).a("bold".equalsIgnoreCase(attributeValue));
                                                    break;
                                                case 5:
                                                    if ("style".equals(xmlPullParser.getName())) {
                                                        o72Var = a(o72Var).b(attributeValue);
                                                    }
                                                    break;
                                                case 6:
                                                    String strB2 = fg.b(attributeValue);
                                                    strB2.getClass();
                                                    strB2.hashCode();
                                                    strB2.hashCode();
                                                    switch (strB2) {
                                                        case "baseContainer":
                                                        case "base":
                                                            o72Var = a(o72Var).e(2);
                                                            break;
                                                        case "container":
                                                            o72Var = a(o72Var).e(1);
                                                            break;
                                                        case "delimiter":
                                                            o72Var = a(o72Var).e(4);
                                                            break;
                                                        case "textContainer":
                                                        case "text":
                                                            o72Var = a(o72Var).e(3);
                                                            break;
                                                    }
                                                    break;
                                                case 7:
                                                    o72Var = a(o72Var);
                                                    try {
                                                        o72Var.b(qq.b(attributeValue));
                                                    } catch (IllegalArgumentException unused) {
                                                        nv0.a("Failed parsing color value: ", attributeValue, "TtmlDecoder");
                                                    }
                                                    break;
                                                case 8:
                                                    o72 o72VarA = a(o72Var);
                                                    Matcher matcher = q.matcher(attributeValue);
                                                    float fMin = Float.MAX_VALUE;
                                                    if (!matcher.matches()) {
                                                        nv0.a("Invalid value for shear: ", attributeValue, "TtmlDecoder");
                                                    } else {
                                                        try {
                                                            String strGroup = matcher.group(1);
                                                            strGroup.getClass();
                                                            fMin = Math.min(100.0f, Math.max(-100.0f, Float.parseFloat(strGroup)));
                                                        } catch (NumberFormatException e) {
                                                            at0.b("TtmlDecoder", "Failed to parse shear: " + attributeValue, e);
                                                        }
                                                    }
                                                    o72Var = o72VarA.b(fMin);
                                                    break;
                                                case 9:
                                                    String strB3 = fg.b(attributeValue);
                                                    strB3.getClass();
                                                    if (strB3.equals("all")) {
                                                        o72Var = a(o72Var).d(true);
                                                    } else if (strB3.equals("none")) {
                                                        o72Var = a(o72Var).d(false);
                                                    }
                                                    break;
                                                case 10:
                                                    try {
                                                        o72Var = a(o72Var);
                                                        a(attributeValue, o72Var);
                                                    } catch (i32 unused2) {
                                                        nv0.a("Failed parsing fontSize value: ", attributeValue, "TtmlDecoder");
                                                    }
                                                    break;
                                                case 11:
                                                    o72Var = a(o72Var).a(k42.a(attributeValue));
                                                    break;
                                                case 12:
                                                    String strB4 = fg.b(attributeValue);
                                                    strB4.getClass();
                                                    if (strB4.equals("before")) {
                                                        o72Var = a(o72Var).d(1);
                                                    } else if (strB4.equals("after")) {
                                                        o72Var = a(o72Var).d(2);
                                                    }
                                                    break;
                                                case 13:
                                                    o72Var = a(o72Var);
                                                    try {
                                                        o72Var.a(qq.b(attributeValue));
                                                    } catch (IllegalArgumentException unused3) {
                                                        nv0.a("Failed parsing background value: ", attributeValue, "TtmlDecoder");
                                                    }
                                                    break;
                                                case 14:
                                                    o72Var = a(o72Var).a(b(attributeValue));
                                                    break;
                                            }
                                        }
                                        return o72Var;
                                    }

                                    private static long a(String str, b bVar) throws i32 {
                                        double d;
                                        double d2;
                                        Matcher matcher = n.matcher(str);
                                        if (matcher.matches()) {
                                            String strGroup = matcher.group(1);
                                            strGroup.getClass();
                                            double d3 = Long.parseLong(strGroup) * 3600;
                                            String strGroup2 = matcher.group(2);
                                            strGroup2.getClass();
                                            double d4 = d3 + (Long.parseLong(strGroup2) * 60);
                                            String strGroup3 = matcher.group(3);
                                            strGroup3.getClass();
                                            double d5 = d4 + Long.parseLong(strGroup3);
                                            String strGroup4 = matcher.group(4);
                                            double d6 = d5 + (strGroup4 != null ? Double.parseDouble(strGroup4) : 0.0d);
                                            String strGroup5 = matcher.group(5);
                                            double d7 = d6 + (strGroup5 != null ? Long.parseLong(strGroup5) / bVar.f9387a : 0.0d);
                                            String strGroup6 = matcher.group(6);
                                            return (long) ((d7 + (strGroup6 != null ? (Long.parseLong(strGroup6) / ((double) bVar.b)) / ((double) bVar.f9387a) : 0.0d)) * 1000000.0d);
                                        }
                                        Matcher matcher2 = o.matcher(str);
                                        if (matcher2.matches()) {
                                            String strGroup7 = matcher2.group(1);
                                            strGroup7.getClass();
                                            double d8 = Double.parseDouble(strGroup7);
                                            String strGroup8 = matcher2.group(2);
                                            strGroup8.getClass();
                                            strGroup8.hashCode();
                                            switch (strGroup8) {
                                                case "f":
                                                    d = bVar.f9387a;
                                                    d8 /= d;
                                                    return (long) (d8 * 1000000.0d);
                                                case "h":
                                                    d2 = 3600.0d;
                                                    break;
                                                case "m":
                                                    d2 = 60.0d;
                                                    break;
                                                case "t":
                                                    d = bVar.c;
                                                    d8 /= d;
                                                    return (long) (d8 * 1000000.0d);
                                                case "ms":
                                                    d = 1000.0d;
                                                    d8 /= d;
                                                    return (long) (d8 * 1000000.0d);
                                                default:
                                                    return (long) (d8 * 1000000.0d);
                                            }
                                            d8 *= d2;
                                            return (long) (d8 * 1000000.0d);
                                        }
                                        throw new i32("Malformed time expression: " + str);
                                    }
                                }
