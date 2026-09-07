package io.bidmachine.iab.vast.tags;

import android.graphics.Color;
import android.text.TextUtils;
import io.bidmachine.iab.utils.IabElementStyle;
import io.bidmachine.iab.utils.Utils;
import io.bidmachine.iab.vast.VastLog;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes12.dex */
public class VastXmlTag implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f12314a;
    private HashMap b;

    public VastXmlTag() {
    }

    static Integer c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Color.parseColor(str));
        } catch (Exception e) {
            VastLog.e("VastXmlTag", e.getMessage(), new Object[0]);
            return null;
        }
    }

    private boolean d(String str) {
        for (String str2 : getSupportedAttributes()) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    static int e(String str) {
        if (str == null) {
            return -1;
        }
        int iIndexOf = str.indexOf(".");
        if (iIndexOf > 0) {
            str = str.substring(0, iIndexOf);
        }
        String[] strArrSplit = str.split(":");
        if (strArrSplit.length <= 2) {
            return -1;
        }
        try {
            return (Integer.parseInt(strArrSplit[0]) * 3600) + (Integer.parseInt(strArrSplit[1]) * 60) + Integer.parseInt(strArrSplit[2]);
        } catch (Exception e) {
            VastLog.e("VastXmlTag", e);
            return -1;
        }
    }

    static int f(String str) {
        if (str == null) {
            return -1;
        }
        String[] strArrSplit = str.split(":");
        if (strArrSplit.length <= 1) {
            return -1;
        }
        try {
            return (Integer.parseInt(strArrSplit[0]) * 60) + Integer.parseInt(strArrSplit[1]);
        } catch (Exception e) {
            VastLog.e("VastXmlTag", e);
            return -1;
        }
    }

    static Integer g(String str) {
        int i;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String lowerCase = str.toLowerCase();
        lowerCase.hashCode();
        if (lowerCase.equals("portrait")) {
            i = 1;
        } else {
            if (!lowerCase.equals("landscape")) {
                return null;
            }
            i = 2;
        }
        return Integer.valueOf(i);
    }

    static Integer h(String str) {
        int i;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String lowerCase = str.toLowerCase();
        lowerCase.hashCode();
        lowerCase.hashCode();
        switch (lowerCase) {
            case "center":
                return 1;
            case "left":
                i = 3;
                break;
            case "right":
                i = 5;
                break;
            default:
                return null;
        }
        return Integer.valueOf(i);
    }

    static Integer i(String str) {
        int i;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String lowerCase = str.toLowerCase();
        lowerCase.hashCode();
        lowerCase.hashCode();
        switch (lowerCase) {
            case "bottom":
                i = 80;
                break;
            case "center":
                i = 16;
                break;
            case "top":
                i = 48;
                break;
            default:
                return null;
        }
        return Integer.valueOf(i);
    }

    static boolean j(String str) {
        return str != null && (str.equalsIgnoreCase("false") || str.equalsIgnoreCase("0"));
    }

    static boolean k(String str) {
        return str != null && (str.equalsIgnoreCase("true") || str.equalsIgnoreCase("1"));
    }

    final String a(String str) {
        HashMap map = this.b;
        if (map != null) {
            return (String) map.get(str);
        }
        return null;
    }

    protected void a(XmlPullParser xmlPullParser) {
    }

    final int b(String str) {
        String strA = a(str);
        if (TextUtils.isEmpty(strA)) {
            VastLog.d("VastXmlTag", "Error parse attribute value - %s, by name - %s", strA, str);
            return -1;
        }
        try {
            return Integer.parseInt(strA);
        } catch (Exception unused) {
            VastLog.e("VastXmlTag", "Error parse attribute value - %s, by name - %s", strA, str);
            return -1;
        }
    }

    public final boolean getBooleanAttributeValueByName(String name, boolean defValue) {
        String strA = a(name);
        if (k(strA)) {
            return true;
        }
        if (j(strA)) {
            return false;
        }
        return defValue;
    }

    public String[] getSupportedAttributes() {
        return new String[0];
    }

    public final String getText() {
        return this.f12314a;
    }

    public boolean isTextSupported() {
        return false;
    }

    public boolean isValidTag() {
        return true;
    }

    public void parse(XmlPullParser xmlPullParser) {
        a(a(this, xmlPullParser));
        if (isTextSupported()) {
            setText(c(xmlPullParser));
        }
        a(xmlPullParser);
    }

    public final void setText(String text) {
        this.f12314a = text;
    }

    public VastXmlTag(XmlPullParser xmlPullParser) {
        parse(xmlPullParser);
    }

    static boolean a(String str, String str2) {
        return str != null && str.equalsIgnoreCase(str2);
    }

    static boolean b(XmlPullParser xmlPullParser) {
        return k(c(xmlPullParser));
    }

    static String c(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (xmlPullParser.next() != 4) {
            return null;
        }
        String text = xmlPullParser.getText();
        if (!TextUtils.isEmpty(text)) {
            text = text.trim();
        }
        xmlPullParser.nextTag();
        return text;
    }

    static void d(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
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

    private static HashMap a(VastXmlTag vastXmlTag, XmlPullParser xmlPullParser) {
        if (xmlPullParser.getAttributeCount() <= 0) {
            return null;
        }
        HashMap map = new HashMap();
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            if (vastXmlTag.d(xmlPullParser.getAttributeName(i))) {
                map.put(xmlPullParser.getAttributeName(i), xmlPullParser.getAttributeValue(i));
            }
        }
        return map;
    }

    static void a(XmlPullParser xmlPullParser, IabElementStyle iabElementStyle) {
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            if (!TextUtils.isEmpty(attributeValue)) {
                try {
                    if (VastAttributes.STROKE_COLOR.equals(attributeName)) {
                        iabElementStyle.setStrokeColor(c(attributeValue));
                    } else if ("fill".equals(attributeName)) {
                        iabElementStyle.setFillColor(c(attributeValue));
                    } else if (VastAttributes.OUTLINED.equals(attributeName)) {
                        iabElementStyle.setOutlined(Boolean.valueOf(k(attributeValue)));
                    } else if (VastAttributes.VISIBLE.equals(attributeName)) {
                        iabElementStyle.setVisible(Boolean.valueOf(k(attributeValue)));
                    } else if (VastAttributes.HORIZONTAL_POSITION.equals(attributeName)) {
                        iabElementStyle.setHorizontalPosition(h(attributeValue));
                    } else if (VastAttributes.VERTICAL_POSITION.equals(attributeName)) {
                        iabElementStyle.setVerticalPosition(i(attributeValue));
                    } else if ("style".equals(attributeName)) {
                        iabElementStyle.setStyle(attributeValue);
                    } else if (VastAttributes.OPACITY.equals(attributeName)) {
                        iabElementStyle.setOpacity(Float.valueOf(Float.parseFloat(attributeValue)));
                    } else if (VastAttributes.HIDE_AFTER.equals(attributeName)) {
                        iabElementStyle.setHideAfter(Float.valueOf(Float.parseFloat(attributeValue)));
                    } else if (VastAttributes.PADDING.equals(attributeName)) {
                        iabElementStyle.setPadding(attributeValue);
                    } else if (VastAttributes.MARGIN.equals(attributeName)) {
                        iabElementStyle.setMargin(attributeValue);
                    } else if (VastAttributes.STROKE_WIDTH.equals(attributeName)) {
                        iabElementStyle.setStrokeWidth(Utils.convertCssSizeToPx(attributeValue));
                    } else if ("width".equals(attributeName)) {
                        iabElementStyle.setWidth(Utils.convertCssSizeToPx(attributeValue));
                    } else if ("height".equals(attributeName)) {
                        iabElementStyle.setHeight(Utils.convertCssSizeToPx(attributeValue));
                    } else if (VastAttributes.FONT_STYLE.equals(attributeName)) {
                        iabElementStyle.setFontStyle(Integer.valueOf(Integer.parseInt(attributeValue)));
                    } else if (VastAttributes.FONT_SIZE.equals(attributeName)) {
                        iabElementStyle.setFontSize(Utils.convertCssSizeToPx(attributeValue));
                    }
                } catch (Throwable th) {
                    VastLog.e("VastXmlTag", th);
                }
            }
        }
        try {
            iabElementStyle.setContent(c(xmlPullParser));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            xmlPullParser.require(3, null, xmlPullParser.getName());
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
        }
    }

    private void a(HashMap map) {
        this.b = map;
    }
}
