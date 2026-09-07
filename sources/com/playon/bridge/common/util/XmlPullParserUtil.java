package com.playon.bridge.common.util;

import android.util.Patterns;
import com.playon.bridge.common.Log;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes13.dex */
public final class XmlPullParserUtil {
    private static final String TAG = Log.makeTag("XmlPullParserUtil");

    private XmlPullParserUtil() {
    }

    public static int readInt(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, IOException {
        String text = readText(xmlPullParser);
        if (text != null) {
            try {
                return Integer.parseInt(text);
            } catch (NumberFormatException e) {
                Log.w(TAG, e, "readInt: \"" + text + "\"");
            }
        }
        return i;
    }

    public static float readFloat(XmlPullParser xmlPullParser, float f) throws XmlPullParserException, IOException {
        String text = readText(xmlPullParser);
        if (text != null) {
            try {
                return Float.parseFloat(text);
            } catch (NumberFormatException e) {
                Log.w(TAG, e, "readFloat: \"" + text + "\"");
            }
        }
        return f;
    }

    public static double readDouble(XmlPullParser xmlPullParser, double d) throws XmlPullParserException, IOException {
        String text = readText(xmlPullParser);
        if (text != null) {
            try {
                return Double.parseDouble(text);
            } catch (NumberFormatException e) {
                Log.w(TAG, e, "readDouble: \"" + text + "\"");
            }
        }
        return d;
    }

    public static long readLong(XmlPullParser xmlPullParser, long j) throws XmlPullParserException, IOException {
        String text = readText(xmlPullParser);
        if (text != null) {
            try {
                return Long.parseLong(text);
            } catch (NumberFormatException e) {
                Log.w(TAG, e, "readLong: \"" + text + "\"");
            }
        }
        return j;
    }

    public static String readText(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String text;
        if (xmlPullParser.next() == 4) {
            text = xmlPullParser.getText();
            xmlPullParser.nextTag();
        } else {
            text = null;
        }
        if (text == null) {
            return null;
        }
        return text.trim();
    }

    public static String readUrlText(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String text = readText(xmlPullParser);
        if (text == null || !Patterns.WEB_URL.matcher(text).matches()) {
            return null;
        }
        return text;
    }

    public static void skip(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
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
}
