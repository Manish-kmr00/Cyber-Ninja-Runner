package com.bytedance.sdk.openadsdk.core.WV.pA.pA;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import net.pubnative.lite.sdk.vpaid.enums.EventConstants;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes10.dex */
public class KZx {
    public static void pA(XmlPullParser xmlPullParser, com.bytedance.sdk.openadsdk.core.WV.pA pAVar, int i, double d) throws XmlPullParserException, IOException {
        boolean z = false;
        while (true) {
            if (xmlPullParser.next() != 3 || !xmlPullParser.getName().equals("Linear")) {
                if (xmlPullParser.getEventType() == 2) {
                    if (z && TextUtils.isEmpty(pAVar.SD())) {
                        ML.pA(xmlPullParser);
                    }
                    String name = xmlPullParser.getName();
                    name.hashCode();
                    switch (name) {
                        case "VideoClicks":
                            pA(xmlPullParser, pAVar);
                            break;
                        case "Duration":
                            pAVar.pA(Og(xmlPullParser));
                            break;
                        case "MediaFiles":
                            pA(xmlPullParser, i, d, pAVar);
                            z = true;
                            break;
                        case "Icons":
                            com.bytedance.sdk.openadsdk.core.WV.Og ogPA = pA(xmlPullParser);
                            if (ogPA != null && pAVar.Og() == null) {
                                pAVar.pA(ogPA);
                                break;
                            } else {
                                break;
                            }
                            break;
                        case "TrackingEvents":
                            pA(xmlPullParser, pAVar.pA());
                            break;
                        default:
                            ML.pA(xmlPullParser);
                            break;
                    }
                }
            } else {
                return;
            }
        }
    }

    private static String pA(XmlPullParser xmlPullParser, int i, double d, com.bytedance.sdk.openadsdk.core.WV.pA pAVar) throws XmlPullParserException, IOException {
        double d2 = Double.NEGATIVE_INFINITY;
        String str = null;
        int i2 = Integer.MIN_VALUE;
        int i3 = Integer.MIN_VALUE;
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getName().equals("MediaFiles")) {
                break;
            }
            if (xmlPullParser.getEventType() == 2 && xmlPullParser.getName().equals("MediaFile")) {
                String attributeValue = xmlPullParser.getAttributeValue(ML.SD, "type");
                int iOg = ML.Og(xmlPullParser.getAttributeValue(ML.SD, "width"));
                int iOg2 = ML.Og(xmlPullParser.getAttributeValue(ML.SD, "height"));
                int iOg3 = ML.Og(xmlPullParser.getAttributeValue(ML.SD, "bitrate"));
                String strOg = ML.Og(xmlPullParser, "MediaFile");
                if (iOg > 0 && iOg2 > 0 && com.bytedance.sdk.openadsdk.core.WV.KZx.ZZv.pA.contains(attributeValue) && !TextUtils.isEmpty(strOg)) {
                    double dPA = com.bytedance.sdk.openadsdk.core.WV.KZx.ZZv.pA(i, d, iOg, iOg2, iOg3, attributeValue);
                    if (dPA > d2) {
                        str = strOg;
                        i2 = iOg;
                        d2 = dPA;
                        i3 = iOg2;
                    }
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            pAVar.ZZv(str);
            pAVar.pA(i2);
            pAVar.Og(i3);
        }
        return str;
    }

    public static com.bytedance.sdk.openadsdk.core.WV.Og pA(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        com.bytedance.sdk.openadsdk.core.WV.Og og;
        int i;
        ArrayList arrayList;
        int i2;
        int i3;
        int i4;
        com.bytedance.sdk.openadsdk.core.WV.KZx.pA.EnumC0233pA enumC0233pA;
        byte b;
        com.bytedance.sdk.openadsdk.core.WV.Og og2 = null;
        while (true) {
            int i5 = 3;
            if (xmlPullParser.getEventType() == 3 && xmlPullParser.getName().equals("Icons")) {
                return og2;
            }
            xmlPullParser.next();
            int i6 = 2;
            if (xmlPullParser.getEventType() == 2 && xmlPullParser.getName().equals("Icon")) {
                int iOg = ML.Og(xmlPullParser.getAttributeValue(ML.SD, "width"));
                int iOg2 = ML.Og(xmlPullParser.getAttributeValue(ML.SD, "height"));
                if (iOg <= 0 || iOg > 300 || iOg2 <= 0 || iOg2 > 300) {
                    ML.pA(xmlPullParser);
                    og2 = og2;
                } else {
                    int iPA = com.bytedance.sdk.openadsdk.core.WV.Og.pA.pA(xmlPullParser.getAttributeValue(ML.SD, "offset"));
                    int iPA2 = com.bytedance.sdk.openadsdk.core.WV.Og.pA.pA(xmlPullParser.getAttributeValue(ML.SD, "duration"));
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    ML.pA pAVar = null;
                    String strOg = null;
                    while (true) {
                        if (xmlPullParser.next() != i5 || !xmlPullParser.getName().equals("Icon")) {
                            ArrayList arrayList4 = arrayList3;
                            arrayList2 = arrayList2;
                            if (xmlPullParser.getEventType() == i6) {
                                String name = xmlPullParser.getName();
                                name.hashCode();
                                og = og2;
                                byte b2 = -1;
                                switch (name.hashCode()) {
                                    case -1044238411:
                                        if (name.equals("IconViewTracking")) {
                                            b = 0;
                                            b2 = b;
                                            break;
                                        }
                                        break;
                                    case -375340334:
                                        if (name.equals("IFrameResource")) {
                                            b = 1;
                                            b2 = b;
                                            break;
                                        }
                                        break;
                                    case 676623548:
                                        if (name.equals("StaticResource")) {
                                            b2 = 2;
                                        }
                                        break;
                                    case 1030746596:
                                        if (name.equals("IconClicks")) {
                                            b2 = 3;
                                        }
                                        break;
                                    case 1928285401:
                                        if (name.equals("HTMLResource")) {
                                            b = 4;
                                            b2 = b;
                                            break;
                                        }
                                        break;
                                }
                                switch (b2) {
                                    case 0:
                                        i2 = 3;
                                        i = 2;
                                        arrayList = arrayList4;
                                        arrayList.add(new com.bytedance.sdk.openadsdk.core.WV.Og.KZx.pA(ML.Og(xmlPullParser, "IconViewTracking")).pA());
                                        break;
                                    case 1:
                                        i3 = 3;
                                        i4 = 2;
                                        if (pAVar == null) {
                                            pAVar = new ML.pA(ML.Og(xmlPullParser, "IFrameResource"), com.bytedance.sdk.openadsdk.core.WV.KZx.pA.EnumC0233pA.NONE, com.bytedance.sdk.openadsdk.core.WV.KZx.pA.Og.IFRAME_RESOURCE);
                                        } else {
                                            ML.pA(xmlPullParser);
                                        }
                                        i5 = i3;
                                        i6 = i4;
                                        og2 = og;
                                        arrayList3 = arrayList4;
                                        break;
                                    case 2:
                                        i3 = 3;
                                        i4 = 2;
                                        com.bytedance.sdk.openadsdk.core.WV.KZx.pA.EnumC0233pA enumC0233pA2 = com.bytedance.sdk.openadsdk.core.WV.KZx.pA.EnumC0233pA.NONE;
                                        String lowerCase = xmlPullParser.getAttributeValue(ML.SD, "creativeType").toLowerCase();
                                        String strOg2 = (com.bytedance.sdk.openadsdk.core.WV.KZx.pA.pA.contains(lowerCase) || com.bytedance.sdk.openadsdk.core.WV.KZx.pA.Og.contains(lowerCase)) ? ML.Og(xmlPullParser, "StaticResource") : null;
                                        if (com.bytedance.sdk.openadsdk.core.WV.KZx.pA.pA.contains(lowerCase)) {
                                            enumC0233pA = com.bytedance.sdk.openadsdk.core.WV.KZx.pA.EnumC0233pA.IMAGE;
                                        } else {
                                            enumC0233pA = com.bytedance.sdk.openadsdk.core.WV.KZx.pA.EnumC0233pA.JAVASCRIPT;
                                        }
                                        pAVar = new ML.pA(strOg2, enumC0233pA, com.bytedance.sdk.openadsdk.core.WV.KZx.pA.Og.STATIC_RESOURCE);
                                        i5 = i3;
                                        i6 = i4;
                                        og2 = og;
                                        arrayList3 = arrayList4;
                                        break;
                                    case 3:
                                        while (true) {
                                            i3 = 3;
                                            if (xmlPullParser.next() == 3 && xmlPullParser.getName().equals("IconClicks")) {
                                                i4 = 2;
                                                i5 = i3;
                                                i6 = i4;
                                                og2 = og;
                                                arrayList3 = arrayList4;
                                                break;
                                            } else if (xmlPullParser.getEventType() == 2) {
                                                if (xmlPullParser.getName().equals("IconClickThrough")) {
                                                    strOg = ML.Og(xmlPullParser, "IconClickThrough");
                                                } else if (xmlPullParser.getName().equals("IconClickTracking")) {
                                                    arrayList2.add(new com.bytedance.sdk.openadsdk.core.WV.Og.KZx.pA(ML.Og(xmlPullParser, "IconClickTracking")).pA());
                                                }
                                            }
                                        }
                                        break;
                                    case 4:
                                        if (pAVar == null || pAVar.KZx == com.bytedance.sdk.openadsdk.core.WV.KZx.pA.Og.IFRAME_RESOURCE) {
                                            pAVar = new ML.pA(ML.Og(xmlPullParser, "HTMLResource"), com.bytedance.sdk.openadsdk.core.WV.KZx.pA.EnumC0233pA.NONE, com.bytedance.sdk.openadsdk.core.WV.KZx.pA.Og.HTML_RESOURCE);
                                            og2 = og;
                                            arrayList3 = arrayList4;
                                            i5 = 3;
                                            i6 = 2;
                                        } else {
                                            i3 = 3;
                                            i4 = 2;
                                            ML.pA(xmlPullParser);
                                            i5 = i3;
                                            i6 = i4;
                                            og2 = og;
                                            arrayList3 = arrayList4;
                                        }
                                        break;
                                    default:
                                        i3 = 3;
                                        i4 = 2;
                                        ML.pA(xmlPullParser);
                                        i5 = i3;
                                        i6 = i4;
                                        og2 = og;
                                        arrayList3 = arrayList4;
                                        break;
                                }
                            } else {
                                og = og2;
                                i = i6;
                                arrayList = arrayList4;
                                i2 = 3;
                            }
                            i5 = i2;
                            i6 = i;
                            arrayList3 = arrayList;
                            og2 = og;
                        } else if (pAVar != null && (og2 == null || TextUtils.isEmpty(og2.JG()))) {
                            og2 = new com.bytedance.sdk.openadsdk.core.WV.Og(iOg, iOg2, iPA, iPA2, pAVar.Og, pAVar.KZx, pAVar.pA, arrayList2, arrayList3, strOg);
                            ML.pA(xmlPullParser, "Icons", 3);
                        }
                    }
                }
            } else {
                og2 = og2;
            }
        }
    }

    public static double Og(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String[] strArrSplit = ML.Og(xmlPullParser, "Duration").split(":");
        if (strArrSplit.length != 3) {
            return 0.0d;
        }
        try {
            return (Integer.parseInt(strArrSplit[0].trim()) * 3600) + (Integer.parseInt(strArrSplit[1].trim()) * 60) + Float.parseFloat(strArrSplit[2].trim());
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static void pA(XmlPullParser xmlPullParser, com.bytedance.sdk.openadsdk.core.WV.ZZv zZv) throws XmlPullParserException, IOException {
        while (true) {
            byte b = 3;
            if (xmlPullParser.next() == 3 && xmlPullParser.getName().equals("TrackingEvents")) {
                return;
            }
            if (xmlPullParser.getEventType() == 2) {
                if ("Tracking".equals(xmlPullParser.getName())) {
                    String attributeValue = xmlPullParser.getAttributeValue(ML.SD, "event");
                    if (TextUtils.isEmpty(attributeValue)) {
                        ML.pA(xmlPullParser, "Tracking", 3);
                    } else {
                        attributeValue.hashCode();
                        switch (attributeValue.hashCode()) {
                            case -1638835128:
                                b = !attributeValue.equals("midpoint") ? (byte) -1 : (byte) 0;
                                break;
                            case -1337830390:
                                b = !attributeValue.equals(EventConstants.THIRD_QUARTILE) ? (byte) -1 : (byte) 1;
                                break;
                            case -934426579:
                                b = !attributeValue.equals("resume") ? (byte) -1 : (byte) 2;
                                break;
                            case -840405966:
                                if (!attributeValue.equals("unmute")) {
                                    b = -1;
                                }
                                break;
                            case -599445191:
                                b = !attributeValue.equals("complete") ? (byte) -1 : (byte) 4;
                                break;
                            case 3363353:
                                b = !attributeValue.equals("mute") ? (byte) -1 : (byte) 5;
                                break;
                            case 3532159:
                                b = !attributeValue.equals(EventConstants.SKIP) ? (byte) -1 : (byte) 6;
                                break;
                            case 94756344:
                                b = !attributeValue.equals("close") ? (byte) -1 : (byte) 7;
                                break;
                            case 106440182:
                                b = !attributeValue.equals("pause") ? (byte) -1 : (byte) 8;
                                break;
                            case 109757538:
                                b = !attributeValue.equals("start") ? (byte) -1 : (byte) 9;
                                break;
                            case 560220243:
                                b = !attributeValue.equals(EventConstants.FIRST_QUARTILE) ? (byte) -1 : (byte) 10;
                                break;
                            case 1778167540:
                                b = !attributeValue.equals(EventConstants.CREATIVE_VIEW) ? (byte) -1 : Ascii.VT;
                                break;
                            default:
                                b = -1;
                                break;
                        }
                        switch (b) {
                            case 0:
                                zZv.pA(ML.Og(xmlPullParser, "Tracking"), 0.5f);
                                break;
                            case 1:
                                zZv.pA(ML.Og(xmlPullParser, "Tracking"), 0.75f);
                                break;
                            case 2:
                                zZv.KZx(KZx(xmlPullParser));
                                break;
                            case 3:
                                zZv.WV(KZx(xmlPullParser));
                                break;
                            case 4:
                                zZv.ZZv(KZx(xmlPullParser));
                                break;
                            case 5:
                                zZv.BSW(KZx(xmlPullParser));
                                break;
                            case 6:
                                zZv.JG(KZx(xmlPullParser));
                                break;
                            case 7:
                                zZv.ML(KZx(xmlPullParser));
                                break;
                            case 8:
                                zZv.Og(KZx(xmlPullParser));
                                break;
                            case 9:
                            case 11:
                                zZv.pA(ML.Og(xmlPullParser, "Tracking"), 0L);
                                break;
                            case 10:
                                zZv.pA(ML.Og(xmlPullParser, "Tracking"), 0.25f);
                                break;
                        }
                    }
                } else if (xmlPullParser.getEventType() == 4) {
                    xmlPullParser.nextTag();
                } else {
                    ML.pA(xmlPullParser);
                }
            }
        }
    }

    private static void pA(XmlPullParser xmlPullParser, com.bytedance.sdk.openadsdk.core.WV.pA pAVar) throws XmlPullParserException, IOException {
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getName().equals("VideoClicks")) {
                return;
            }
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals("ClickThrough")) {
                    pAVar.KZx(ML.Og(xmlPullParser, "ClickThrough"));
                } else if (name.equals("ClickTracking")) {
                    pAVar.pA().SD(ML.pA(xmlPullParser, "ClickTracking"));
                } else {
                    ML.pA(xmlPullParser);
                }
            }
        }
    }

    private static List<com.bytedance.sdk.openadsdk.core.WV.Og.KZx> KZx(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return ML.pA(xmlPullParser, "Tracking");
    }
}
