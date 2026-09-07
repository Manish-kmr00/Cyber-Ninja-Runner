package com.bytedance.sdk.openadsdk.core.WV.pA.pA;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.WV.SGo;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes11.dex */
public class ZZv {
    public static Set<SGo> pA(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        SGo sGoPA;
        if (xmlPullParser == null) {
            return new HashSet();
        }
        HashSet hashSet = new HashSet();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if ("Verification".equals(xmlPullParser.getName())) {
                    String attributeValue = xmlPullParser.getAttributeValue(ML.SD, "vendor");
                    String strOg = null;
                    String strOg2 = null;
                    String strOg3 = null;
                    while (true) {
                        if (xmlPullParser.getEventType() != 3 || !"Verification".equals(xmlPullParser.getName())) {
                            xmlPullParser.next();
                            if (xmlPullParser.getEventType() == 2) {
                                String name = xmlPullParser.getName();
                                name.hashCode();
                                switch (name) {
                                    case "Tracking":
                                        if (!"verificationNotExecuted".equals(xmlPullParser.getAttributeValue(ML.SD, "event"))) {
                                            break;
                                        } else {
                                            strOg3 = ML.Og(xmlPullParser, "Tracking");
                                            break;
                                        }
                                        break;
                                    case "JavaScriptResource":
                                        if (!CampaignEx.KEY_OMID.equals(xmlPullParser.getAttributeValue(ML.SD, "apiFramework"))) {
                                            break;
                                        } else {
                                            strOg = ML.Og(xmlPullParser, "JavaScriptResource");
                                            break;
                                        }
                                        break;
                                    case "VerificationParameters":
                                        strOg2 = ML.Og(xmlPullParser, "VerificationParameters");
                                        break;
                                }
                            }
                        } else if (!TextUtils.isEmpty(strOg) && (sGoPA = SGo.pA(CampaignEx.KEY_OMID, strOg, attributeValue, strOg2, strOg3)) != null) {
                            hashSet.add(sGoPA);
                        }
                    }
                } else {
                    ML.pA(xmlPullParser);
                }
            }
        }
        return hashSet;
    }
}
