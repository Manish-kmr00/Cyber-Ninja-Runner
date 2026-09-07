package com.bytedance.sdk.openadsdk.core.WV.pA.pA;

import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes6.dex */
public class pA {
    /* JADX WARN: Failed to find 'out' block for switch in B:63:0x0121. Please report as an issue. */
    public static com.bytedance.sdk.openadsdk.core.WV.KZx pA(Context context, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ML.pA pAVar;
        com.bytedance.sdk.openadsdk.core.WV.KZx.pA.EnumC0233pA enumC0233pA;
        int i;
        byte b;
        if (context == null) {
            ML.pA(xmlPullParser);
            return null;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i2 = displayMetrics.widthPixels;
        int i3 = displayMetrics.heightPixels;
        int i4 = (int) (i2 / displayMetrics.density);
        int i5 = (int) (i3 / displayMetrics.density);
        float f = Float.MIN_VALUE;
        com.bytedance.sdk.openadsdk.core.WV.KZx kZx = null;
        while (true) {
            int i6 = 3;
            if (xmlPullParser.getEventType() == 3 && xmlPullParser.getName().equals("CompanionAds")) {
                return kZx;
            }
            xmlPullParser.next();
            int i7 = 2;
            if (xmlPullParser.getEventType() == 2) {
                String str = "Companion";
                if (xmlPullParser.getName().equals("Companion")) {
                    int iOg = ML.Og(xmlPullParser.getAttributeValue(ML.SD, "width"));
                    int iOg2 = ML.Og(xmlPullParser.getAttributeValue(ML.SD, "height"));
                    if (iOg < 300 || iOg2 < 250) {
                        ML.pA(xmlPullParser);
                        kZx = kZx;
                    } else {
                        ML.pA pAVar2 = new ML.pA();
                        while (true) {
                            if (xmlPullParser.getEventType() != i6 || !xmlPullParser.getName().equals(str)) {
                                xmlPullParser.next();
                                if (xmlPullParser.getEventType() == i7) {
                                    String name = xmlPullParser.getName();
                                    name.hashCode();
                                    kZx = kZx;
                                    str = str;
                                    byte b2 = -1;
                                    switch (name.hashCode()) {
                                        case -375340334:
                                            if (name.equals("IFrameResource")) {
                                                b = 0;
                                                b2 = b;
                                                break;
                                            }
                                            break;
                                        case -348198615:
                                            if (name.equals("CompanionClickThrough")) {
                                                b = 1;
                                                b2 = b;
                                                break;
                                            }
                                            break;
                                        case 611554000:
                                            if (name.equals("TrackingEvents")) {
                                                b2 = 2;
                                            }
                                            break;
                                        case 676623548:
                                            if (name.equals("StaticResource")) {
                                                b2 = 3;
                                            }
                                            break;
                                        case 1877773523:
                                            if (name.equals("CompanionClickTracking")) {
                                                b = 4;
                                                b2 = b;
                                                break;
                                            }
                                            break;
                                        case 1928285401:
                                            if (name.equals("HTMLResource")) {
                                                b = 5;
                                                b2 = b;
                                                break;
                                            }
                                            break;
                                    }
                                    switch (b2) {
                                        case 0:
                                            ML.pA pAVar3 = pAVar2;
                                            int i8 = iOg2;
                                            int i9 = iOg;
                                            Point pointPA = com.bytedance.sdk.openadsdk.core.WV.KZx.pA.pA(context, i9, i8, com.bytedance.sdk.openadsdk.core.WV.KZx.pA.Og.HTML_RESOURCE);
                                            float fPA = com.bytedance.sdk.openadsdk.core.WV.KZx.pA(i4, i5, pointPA.x, pointPA.y, com.bytedance.sdk.openadsdk.core.WV.KZx.pA.Og.IFRAME_RESOURCE, com.bytedance.sdk.openadsdk.core.WV.KZx.pA.EnumC0233pA.NONE);
                                            String strOg = ML.Og(xmlPullParser, "IFrameResource");
                                            if (TextUtils.isEmpty(strOg) || fPA <= pAVar3.SD || fPA <= f) {
                                                i = 3;
                                                ML.pA(xmlPullParser, "IFrameResource", 3);
                                                pAVar2 = pAVar3;
                                                iOg2 = i8;
                                                iOg = i9;
                                                i7 = 2;
                                                i6 = i;
                                            } else {
                                                pAVar3.SD = fPA;
                                                pAVar3.pA(strOg, com.bytedance.sdk.openadsdk.core.WV.KZx.pA.EnumC0233pA.NONE, com.bytedance.sdk.openadsdk.core.WV.KZx.pA.Og.IFRAME_RESOURCE);
                                                pAVar2 = pAVar3;
                                                iOg2 = i8;
                                                iOg = i9;
                                                i7 = 2;
                                                kZx = kZx;
                                                str = str;
                                                i6 = 3;
                                            }
                                            break;
                                        case 1:
                                            pAVar2.ZZv = ML.Og(xmlPullParser, "CompanionClickThrough");
                                            i7 = 2;
                                            iOg = iOg;
                                            kZx = kZx;
                                            str = str;
                                            i6 = 3;
                                            break;
                                        case 2:
                                            pAVar = pAVar2;
                                            while (true) {
                                                if (xmlPullParser.next() == 3 && xmlPullParser.getName().equals("TrackingEvents")) {
                                                    iOg2 = iOg2;
                                                    iOg = iOg;
                                                    pAVar2 = pAVar;
                                                    i6 = 3;
                                                    i7 = 2;
                                                    break;
                                                } else if (xmlPullParser.getEventType() == 2 && xmlPullParser.getName().equals("Tracking")) {
                                                    pAVar.Og(ML.Og(xmlPullParser, "Tracking"));
                                                }
                                            }
                                            break;
                                        case 3:
                                            pAVar = pAVar2;
                                            int i10 = iOg2;
                                            iOg = iOg;
                                            com.bytedance.sdk.openadsdk.core.WV.KZx.pA.EnumC0233pA enumC0233pA2 = com.bytedance.sdk.openadsdk.core.WV.KZx.pA.EnumC0233pA.NONE;
                                            String lowerCase = xmlPullParser.getAttributeValue(ML.SD, "creativeType").toLowerCase();
                                            if (com.bytedance.sdk.openadsdk.core.WV.KZx.pA.pA.contains(lowerCase)) {
                                                enumC0233pA = com.bytedance.sdk.openadsdk.core.WV.KZx.pA.EnumC0233pA.IMAGE;
                                            } else {
                                                enumC0233pA = com.bytedance.sdk.openadsdk.core.WV.KZx.pA.EnumC0233pA.JAVASCRIPT;
                                            }
                                            com.bytedance.sdk.openadsdk.core.WV.KZx.pA.EnumC0233pA enumC0233pA3 = enumC0233pA;
                                            Point pointPA2 = com.bytedance.sdk.openadsdk.core.WV.KZx.pA.pA(context, iOg, i10, com.bytedance.sdk.openadsdk.core.WV.KZx.pA.Og.STATIC_RESOURCE);
                                            float fPA2 = com.bytedance.sdk.openadsdk.core.WV.KZx.pA(i4, i5, pointPA2.x, pointPA2.y, com.bytedance.sdk.openadsdk.core.WV.KZx.pA.Og.STATIC_RESOURCE, enumC0233pA3);
                                            String strOg2 = (com.bytedance.sdk.openadsdk.core.WV.KZx.pA.pA.contains(lowerCase) || com.bytedance.sdk.openadsdk.core.WV.KZx.pA.Og.contains(lowerCase)) ? ML.Og(xmlPullParser, "StaticResource") : null;
                                            if (fPA2 < pAVar.SD || fPA2 <= f || TextUtils.isEmpty(strOg2)) {
                                                i = 3;
                                                ML.pA(xmlPullParser, "StaticResource", 3);
                                                iOg2 = i10;
                                                iOg = iOg;
                                                pAVar2 = pAVar;
                                                i7 = 2;
                                                i6 = i;
                                            } else {
                                                pAVar.SD = fPA2;
                                                pAVar.pA(strOg2, enumC0233pA3, com.bytedance.sdk.openadsdk.core.WV.KZx.pA.Og.STATIC_RESOURCE);
                                                iOg2 = i10;
                                                iOg = iOg;
                                                pAVar2 = pAVar;
                                                i6 = 3;
                                                i7 = 2;
                                            }
                                            break;
                                        case 4:
                                            pAVar2.pA(ML.Og(xmlPullParser, "CompanionClickTracking"));
                                            i6 = 3;
                                            i7 = 2;
                                            break;
                                        case 5:
                                            Point pointPA3 = com.bytedance.sdk.openadsdk.core.WV.KZx.pA.pA(context, iOg, iOg2, com.bytedance.sdk.openadsdk.core.WV.KZx.pA.Og.HTML_RESOURCE);
                                            pAVar = pAVar2;
                                            int i11 = iOg2;
                                            int i12 = iOg;
                                            float fPA3 = com.bytedance.sdk.openadsdk.core.WV.KZx.pA(i4, i5, pointPA3.x, pointPA3.y, com.bytedance.sdk.openadsdk.core.WV.KZx.pA.Og.HTML_RESOURCE, com.bytedance.sdk.openadsdk.core.WV.KZx.pA.EnumC0233pA.NONE);
                                            String strOg3 = ML.Og(xmlPullParser, "HTMLResource");
                                            if (TextUtils.isEmpty(strOg3) || fPA3 <= pAVar.SD || fPA3 <= f) {
                                                ML.pA(xmlPullParser, "HTMLResource", 3);
                                                iOg2 = i11;
                                                i6 = 3;
                                                iOg = i12;
                                                pAVar2 = pAVar;
                                            } else {
                                                pAVar.SD = fPA3;
                                                pAVar.pA(strOg3, com.bytedance.sdk.openadsdk.core.WV.KZx.pA.EnumC0233pA.NONE, com.bytedance.sdk.openadsdk.core.WV.KZx.pA.Og.HTML_RESOURCE);
                                                iOg2 = i11;
                                                iOg = i12;
                                                pAVar2 = pAVar;
                                                i6 = 3;
                                            }
                                            i7 = 2;
                                            break;
                                        default:
                                            ML.pA(xmlPullParser);
                                            pAVar = pAVar2;
                                            iOg2 = iOg2;
                                            iOg = iOg;
                                            pAVar2 = pAVar;
                                            i6 = 3;
                                            i7 = 2;
                                            break;
                                    }
                                }
                            } else if (!TextUtils.isEmpty(pAVar2.pA) && pAVar2.SD >= f) {
                                kZx = new com.bytedance.sdk.openadsdk.core.WV.KZx(iOg, iOg2, pAVar2.Og, pAVar2.KZx, pAVar2.pA, pAVar2.ML, pAVar2.JG, pAVar2.ZZv);
                                f = pAVar2.SD;
                            }
                        }
                    }
                }
            }
            kZx = kZx;
        }
    }
}
