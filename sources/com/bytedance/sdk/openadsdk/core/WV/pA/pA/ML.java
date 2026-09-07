package com.bytedance.sdk.openadsdk.core.WV.pA.pA;

import android.content.Context;
import android.text.TextUtils;
import android.util.Xml;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes13.dex */
public class ML extends com.bytedance.sdk.openadsdk.core.WV.pA.Og {
    public static final String SD = null;

    public ML(Context context, int i, int i2) {
        super(context, i, i2);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x004e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.bytedance.sdk.openadsdk.core.WV.pA.Og
    public com.bytedance.sdk.openadsdk.core.WV.pA pA(String str, List<com.bytedance.sdk.openadsdk.core.WV.Og.KZx> list) throws Throwable {
        ByteArrayInputStream byteArrayInputStream;
        this.ML = 0;
        ByteArrayInputStream byteArrayInputStream2 = null;
        if (this.Og == null) {
            this.ML = -1;
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            this.ML = -2;
            return null;
        }
        try {
            byteArrayInputStream = new ByteArrayInputStream(str.getBytes("UTF-8"));
            try {
                try {
                    XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                    xmlPullParserNewPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
                    xmlPullParserNewPullParser.setInput(byteArrayInputStream, "UTF-8");
                    xmlPullParserNewPullParser.nextTag();
                    com.bytedance.sdk.openadsdk.core.WV.pA pAVarPA = pA(xmlPullParserNewPullParser, list);
                    pA(pAVarPA);
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException unused) {
                    }
                    return pAVarPA;
                } catch (Throwable th) {
                    th = th;
                    byteArrayInputStream2 = byteArrayInputStream;
                    if (byteArrayInputStream2 != null) {
                        try {
                            byteArrayInputStream2.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused3) {
                this.ML = -3;
                pA((com.bytedance.sdk.openadsdk.core.WV.pA) null);
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                return null;
            }
        } catch (Exception unused5) {
            byteArrayInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (byteArrayInputStream2 != null) {
                byteArrayInputStream2.close();
            }
            throw th;
        }
    }

    private void pA(com.bytedance.sdk.openadsdk.core.WV.pA pAVar) {
        if (this.JG == null) {
            this.JG = new com.bytedance.sdk.openadsdk.core.WV.pA.Og.pA();
        }
        this.JG.pA = this.ML;
        this.JG.Og = this.pA;
        if (pAVar != null) {
            this.JG.KZx = pAVar.pA().Og.size() <= 0;
        }
    }

    private com.bytedance.sdk.openadsdk.core.WV.pA pA(XmlPullParser xmlPullParser, List<com.bytedance.sdk.openadsdk.core.WV.Og.KZx> list) throws Throwable {
        xmlPullParser.require(2, SD, "VAST");
        boolean z = false;
        String strOg = null;
        while (xmlPullParser.next() != 1) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if ("Error".equals(name)) {
                    strOg = Og(xmlPullParser, name);
                } else if ("Ad".equals(name)) {
                    if (pA(xmlPullParser.getAttributeValue(SD, "sequence"))) {
                        while (true) {
                            if (xmlPullParser.next() == 3 && "Ad".equals(xmlPullParser.getName())) {
                                break;
                            }
                            if (xmlPullParser.getEventType() == 2) {
                                String name2 = xmlPullParser.getName();
                                if ("InLine".equals(name2)) {
                                    com.bytedance.sdk.openadsdk.core.WV.pA pAVarPA = Og.pA(this.Og, xmlPullParser, list, this.KZx, this.ZZv);
                                    if (pAVarPA != null) {
                                        if (!TextUtils.isEmpty(pAVarPA.SD())) {
                                            return pAVarPA;
                                        }
                                        this.ML = -6;
                                        return null;
                                    }
                                } else if ("Wrapper".equals(name2)) {
                                    com.bytedance.sdk.openadsdk.core.WV.pA pAVarOg = Og(xmlPullParser, list);
                                    if (pAVarOg != null) {
                                        return pAVarOg;
                                    }
                                } else {
                                    pA(xmlPullParser);
                                }
                            }
                        }
                    } else {
                        pA(xmlPullParser);
                    }
                    z = true;
                } else {
                    pA(xmlPullParser);
                }
            }
        }
        if (!z) {
            this.ML = -4;
            KZx(strOg);
        }
        if (this.ML == 0) {
            this.ML = -5;
        }
        return null;
    }

    private void KZx(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.WV.Og.KZx.pA(com.bytedance.sdk.openadsdk.core.WV.Og.KZx.pA(Collections.singletonList(new com.bytedance.sdk.openadsdk.core.WV.Og.KZx.pA(str).pA()), this.pA > 0 ? com.bytedance.sdk.openadsdk.core.WV.pA.pA.NO_ADS_VAST_RESPONSE : com.bytedance.sdk.openadsdk.core.WV.pA.pA.UNDEFINED_ERROR, -1L, null), (com.bytedance.sdk.openadsdk.core.WV.Og.KZx.Og) null);
    }

    static class pA {
        com.bytedance.sdk.openadsdk.core.WV.KZx.pA.Og KZx;
        com.bytedance.sdk.openadsdk.core.WV.KZx.pA.EnumC0233pA Og;
        String ZZv;
        String pA;
        final List<com.bytedance.sdk.openadsdk.core.WV.Og.KZx> ML = new ArrayList();
        final List<com.bytedance.sdk.openadsdk.core.WV.Og.KZx> JG = new ArrayList();
        float SD = Float.MIN_VALUE;

        public pA() {
        }

        public pA(String str, com.bytedance.sdk.openadsdk.core.WV.KZx.pA.EnumC0233pA enumC0233pA, com.bytedance.sdk.openadsdk.core.WV.KZx.pA.Og og) {
            pA(str, enumC0233pA, og);
        }

        public void pA(String str, com.bytedance.sdk.openadsdk.core.WV.KZx.pA.EnumC0233pA enumC0233pA, com.bytedance.sdk.openadsdk.core.WV.KZx.pA.Og og) {
            this.pA = str;
            this.Og = enumC0233pA;
            this.KZx = og;
        }

        public void pA(String str) {
            this.ML.add(new com.bytedance.sdk.openadsdk.core.WV.Og.KZx.pA(str).pA());
        }

        public void Og(String str) {
            this.JG.add(new com.bytedance.sdk.openadsdk.core.WV.Og.KZx.pA(str).pA());
        }
    }

    public static List<com.bytedance.sdk.openadsdk.core.WV.Og.KZx> pA(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        return ZZv(Og(xmlPullParser, str));
    }

    public static int Og(String str) {
        if (TextUtils.isEmpty(str)) {
            return Integer.MIN_VALUE;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return Integer.MIN_VALUE;
        }
    }

    public static String Og(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String strTrim;
        String str2 = SD;
        xmlPullParser.require(2, str2, str);
        if (xmlPullParser.next() != 4) {
            strTrim = "";
        } else {
            strTrim = xmlPullParser.getText().trim();
            xmlPullParser.nextTag();
        }
        xmlPullParser.require(3, str2, str);
        return strTrim;
    }

    public static void pA(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (xmlPullParser.getEventType() != 2) {
            throw new IllegalStateException();
        }
        int i = 1;
        while (i != 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }

    public static void pA(XmlPullParser xmlPullParser, String str, int i) throws XmlPullParserException, IOException {
        while (xmlPullParser.getEventType() != 1) {
            if (str.equals(xmlPullParser.getName()) && xmlPullParser.getEventType() == i) {
                return;
            } else {
                xmlPullParser.next();
            }
        }
    }

    private com.bytedance.sdk.openadsdk.core.WV.pA Og(XmlPullParser xmlPullParser, List<com.bytedance.sdk.openadsdk.core.WV.Og.KZx> list) throws Throwable {
        if (this.pA >= 5) {
            pA(xmlPullParser);
            return null;
        }
        com.bytedance.sdk.openadsdk.core.WV.ZZv zZv = new com.bytedance.sdk.openadsdk.core.WV.ZZv(null);
        String strOg = null;
        com.bytedance.sdk.openadsdk.core.WV.KZx kZxPA = null;
        while (true) {
            if (xmlPullParser.getEventType() != 3 || !"Wrapper".equals(xmlPullParser.getName())) {
                xmlPullParser.next();
                if (xmlPullParser.getEventType() == 2) {
                    String name = xmlPullParser.getName();
                    name.hashCode();
                    switch (name) {
                        case "VASTAdTagURI":
                            strOg = Og(Og(xmlPullParser, "VASTAdTagURI"), list);
                            if (!TextUtils.isEmpty(strOg)) {
                                break;
                            } else {
                                pA(xmlPullParser, "Wrapper", 3);
                                this.ML = -2;
                                return null;
                            }
                            break;
                        case "Error":
                            list.add(new com.bytedance.sdk.openadsdk.core.WV.Og.KZx.pA(Og(xmlPullParser, "Error")).pA());
                            break;
                        case "TrackingEvents":
                            KZx.pA(xmlPullParser, zZv);
                            break;
                        case "CompanionAds":
                            kZxPA = com.bytedance.sdk.openadsdk.core.WV.pA.pA.pA.pA(this.Og, xmlPullParser);
                            break;
                        case "ClickTracking":
                            zZv.SD(pA(xmlPullParser, "ClickTracking"));
                            break;
                        case "Impression":
                            zZv.pA(pA(xmlPullParser, name));
                            break;
                    }
                }
            } else {
                com.bytedance.sdk.openadsdk.core.WV.pA pAVarPA = pA(strOg, list);
                if (pAVarPA != null) {
                    if (pAVarPA.KZx() == null) {
                        pAVarPA.pA(kZxPA);
                    }
                    pAVarPA.pA().pA(zZv);
                }
                return pAVarPA;
            }
        }
    }

    private static List<com.bytedance.sdk.openadsdk.core.WV.Og.KZx> pA(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return new ArrayList();
        }
        return Collections.singletonList(new com.bytedance.sdk.openadsdk.core.WV.Og.KZx.pA(str).pA(z).pA());
    }

    private static List<com.bytedance.sdk.openadsdk.core.WV.Og.KZx> ZZv(String str) {
        return pA(str, false);
    }
}
