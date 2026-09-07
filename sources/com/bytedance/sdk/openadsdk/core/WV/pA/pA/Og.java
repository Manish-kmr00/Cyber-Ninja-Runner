package com.bytedance.sdk.openadsdk.core.WV.pA.pA;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes5.dex */
public class Og {
    public static com.bytedance.sdk.openadsdk.core.WV.pA pA(Context context, XmlPullParser xmlPullParser, List<com.bytedance.sdk.openadsdk.core.WV.Og.KZx> list, int i, double d) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, ML.SD, "InLine");
        com.bytedance.sdk.openadsdk.core.WV.pA pAVar = new com.bytedance.sdk.openadsdk.core.WV.pA();
        while (true) {
            if (xmlPullParser.next() != 3 || !"InLine".equals(xmlPullParser.getName())) {
                if (xmlPullParser.getEventType() == 2) {
                    String name = xmlPullParser.getName();
                    name.hashCode();
                    switch (name) {
                        case "AdVerifications":
                            pAVar.pA(ZZv.pA(xmlPullParser));
                            continue;
                            break;
                        case "Creatives":
                            if (!TextUtils.isEmpty(pAVar.SD()) && pAVar.KZx() != null) {
                                break;
                            } else {
                                while (xmlPullParser.next() != 3) {
                                    if (xmlPullParser.getEventType() == 2) {
                                        if ("Creative".equals(xmlPullParser.getName())) {
                                            pA(context, xmlPullParser, pAVar, i, d);
                                        } else {
                                            ML.pA(xmlPullParser);
                                        }
                                    }
                                }
                                break;
                            }
                            break;
                        case "Description":
                            pAVar.Og(ML.Og(xmlPullParser, name));
                            continue;
                            break;
                        case "Error":
                            list.addAll(ML.pA(xmlPullParser, name));
                            continue;
                            break;
                        case "Extensions":
                            while (true) {
                                if (xmlPullParser.getEventType() == 3 && "Extensions".equals(xmlPullParser.getName())) {
                                    continue;
                                    break;
                                } else {
                                    xmlPullParser.next();
                                    if (xmlPullParser.getEventType() == 2 && "AdVerifications".equals(xmlPullParser.getName())) {
                                        pAVar.pA(ZZv.pA(xmlPullParser));
                                    }
                                }
                            }
                            break;
                        case "AdTitle":
                            pAVar.pA(ML.Og(xmlPullParser, name));
                            continue;
                            break;
                        case "Impression":
                            pAVar.pA().pA(ML.pA(xmlPullParser, name));
                            continue;
                            break;
                    }
                    ML.pA(xmlPullParser);
                }
            } else {
                pAVar.pA().SGo(list);
                return pAVar;
            }
        }
    }

    public static void pA(Context context, XmlPullParser xmlPullParser, com.bytedance.sdk.openadsdk.core.WV.pA pAVar, int i, double d) throws XmlPullParserException, IOException {
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if ("Linear".equals(xmlPullParser.getName()) && TextUtils.isEmpty(pAVar.SD())) {
                    KZx.pA(xmlPullParser, pAVar, i, d);
                } else if ("CompanionAds".equals(xmlPullParser.getName()) && pAVar.KZx() == null) {
                    pAVar.pA(pA.pA(context, xmlPullParser));
                } else {
                    ML.pA(xmlPullParser);
                }
            }
        }
    }
}
