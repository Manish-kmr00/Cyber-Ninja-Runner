package net.pubnative.lite.sdk.views.shape.path.parser;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.json.b9;
import com.unity3d.services.ads.gmascar.utils.ScarConstants;
import io.bidmachine.iab.vast.tags.VastAttributes;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes13.dex */
class ParseUtil {
    ParseUtil() {
    }

    static final String escape(String str) {
        return str.replaceAll("\"", "&quot;").replaceAll("'", "&apos").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll(b9.i.c, "&amp;");
    }

    static final String getStringAttr(String str, XmlPullParser xmlPullParser) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            if (xmlPullParser.getAttributeName(i).equals(str)) {
                return xmlPullParser.getAttributeValue(i);
            }
        }
        return null;
    }

    static final Float convertUnits(String str, XmlPullParser xmlPullParser, float f, float f2, float f3) {
        float f4;
        String stringAttr = getStringAttr(str, xmlPullParser);
        if (stringAttr == null) {
            return null;
        }
        if (stringAttr.endsWith("px")) {
            return Float.valueOf(Float.parseFloat(stringAttr.substring(0, stringAttr.length() - 2)));
        }
        if (stringAttr.endsWith("pt")) {
            return Float.valueOf((Float.parseFloat(stringAttr.substring(0, stringAttr.length() - 2)) * f) / 72.0f);
        }
        if (stringAttr.endsWith(ApsMetricsDataMap.APSMETRICS_FIELD_PLATFORMCATEGORY)) {
            return Float.valueOf((Float.parseFloat(stringAttr.substring(0, stringAttr.length() - 2)) * f) / 6.0f);
        }
        if (stringAttr.endsWith("cm")) {
            return Float.valueOf((Float.parseFloat(stringAttr.substring(0, stringAttr.length() - 2)) * f) / 2.54f);
        }
        if (stringAttr.endsWith("mm")) {
            return Float.valueOf((Float.parseFloat(stringAttr.substring(0, stringAttr.length() - 2)) * f) / 254.0f);
        }
        if (stringAttr.endsWith(ScarConstants.IN_SIGNAL_KEY)) {
            return Float.valueOf(Float.parseFloat(stringAttr.substring(0, stringAttr.length() - 2)) * f);
        }
        if (stringAttr.endsWith("%")) {
            Float fValueOf = Float.valueOf(stringAttr.substring(0, stringAttr.length() - 1));
            if (str.contains(VastAttributes.HORIZONTAL_POSITION) || str.equals("width")) {
                f4 = f2 / 100.0f;
            } else {
                f4 = (str.contains(VastAttributes.VERTICAL_POSITION) || str.equals("height")) ? f3 / 100.0f : (f3 + f2) / 2.0f;
            }
            return Float.valueOf(fValueOf.floatValue() * f4);
        }
        return Float.valueOf(stringAttr);
    }
}
