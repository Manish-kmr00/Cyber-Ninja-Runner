package net.pubnative.lite.sdk.views.shape.path.parser;

import android.util.Log;
import java.io.IOException;
import java.util.HashMap;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
class IdHandler {
    private static final String TAG = SvgToPath.TAG;
    private final XmlPullParser atts;
    final HashMap<String, String> idXml = new HashMap<>();
    private final Stack<IdRecording> idRecordingStack = new Stack<>();

    IdHandler(XmlPullParser xmlPullParser) {
        this.atts = xmlPullParser;
    }

    public void processIds() throws XmlPullParserException, IOException {
        int eventType = this.atts.getEventType();
        do {
            if (eventType != 0 && eventType != 1) {
                if (eventType == 2) {
                    startElement();
                } else if (eventType == 3) {
                    endElement();
                }
            }
            eventType = this.atts.next();
        } while (eventType != 1);
    }

    private void appendElementString(StringBuilder sb, String str, XmlPullParser xmlPullParser) {
        sb.append("<");
        sb.append(str);
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            sb.append(" ");
            sb.append(xmlPullParser.getAttributeName(i));
            sb.append("='");
            sb.append(ParseUtil.escape(xmlPullParser.getAttributeValue(i)));
            sb.append("'");
        }
        sb.append(">");
    }

    void startElement() {
        String name = this.atts.getName();
        String stringAttr = ParseUtil.getStringAttr("id", this.atts);
        if (stringAttr != null) {
            this.idRecordingStack.push(new IdRecording(stringAttr));
        }
        if (this.idRecordingStack.size() > 0) {
            IdRecording idRecordingLastElement = this.idRecordingStack.lastElement();
            idRecordingLastElement.level++;
            appendElementString(idRecordingLastElement.sb, name, this.atts);
        }
    }

    void endElement() {
        String name = this.atts.getName();
        if (this.idRecordingStack.size() > 0) {
            IdRecording idRecordingLastElement = this.idRecordingStack.lastElement();
            idRecordingLastElement.sb.append("</");
            idRecordingLastElement.sb.append(name);
            idRecordingLastElement.sb.append(">");
            idRecordingLastElement.level--;
            if (idRecordingLastElement.level == 0) {
                String string = idRecordingLastElement.sb.toString();
                this.idXml.put(idRecordingLastElement.id, string);
                this.idRecordingStack.pop();
                if (this.idRecordingStack.size() > 0) {
                    this.idRecordingStack.lastElement().sb.append(string);
                }
                Log.w(TAG, string);
            }
        }
    }

    class IdRecording {
        final String id;
        int level = 0;
        final StringBuilder sb = new StringBuilder();

        public IdRecording(String str) {
            this.id = str;
        }
    }
}
