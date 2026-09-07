package net.pubnative.lite.sdk.utils.string;

import com.json.b9;
import com.safedk.android.analytics.brandsafety.l;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: loaded from: classes12.dex */
public class StringEscapeUtils {
    public static final String EMPTY = "";
    public static final CharSequenceTranslator ESCAPE_JAVA;
    public static final CharSequenceTranslator ESCAPE_XSI;
    public static final CharSequenceTranslator UNESCAPE_JAVA;

    public static final class Builder {
        private final StringBuilder sb;
        private final CharSequenceTranslator translator;

        private Builder(CharSequenceTranslator charSequenceTranslator) {
            this.sb = new StringBuilder();
            this.translator = charSequenceTranslator;
        }

        public Builder append(String str) {
            this.sb.append(str);
            return this;
        }

        public Builder escape(String str) {
            this.sb.append(this.translator.translate(str));
            return this;
        }

        public String toString() {
            return this.sb.toString();
        }
    }

    static {
        HashMap map = new HashMap();
        map.put("\"", "\\\"");
        map.put("\\", "\\\\");
        ESCAPE_JAVA = new AggregateTranslator(new LookupTranslator(Collections.unmodifiableMap(map)), new LookupTranslator(EntityArrays.JAVA_CTRL_CHARS_ESCAPE), JavaUnicodeEscaper.outsideOf(32, 127));
        HashMap map2 = new HashMap();
        map2.put(l.ad, "\\|");
        map2.put(b9.i.c, "\\&");
        map2.put(";", "\\;");
        map2.put("<", "\\<");
        map2.put(">", "\\>");
        map2.put("(", "\\(");
        map2.put(")", "\\)");
        map2.put("$", "\\$");
        map2.put("`", "\\`");
        map2.put("\\", "\\\\");
        map2.put("\"", "\\\"");
        map2.put("'", "\\'");
        map2.put(" ", "\\ ");
        map2.put("\t", "\\\t");
        map2.put("\r\n", "");
        map2.put("\n", "");
        map2.put("*", "\\*");
        map2.put("?", "\\?");
        map2.put(b9.i.d, "\\[");
        map2.put("#", "\\#");
        map2.put("~", "\\~");
        map2.put("=", "\\=");
        map2.put("%", "\\%");
        ESCAPE_XSI = new LookupTranslator(Collections.unmodifiableMap(map2));
        HashMap map3 = new HashMap();
        map3.put("\\\\", "\\");
        map3.put("\\\"", "\"");
        map3.put("\\'", "'");
        map3.put("\\", "");
        UNESCAPE_JAVA = new AggregateTranslator(new OctalUnescaper(), new UnicodeUnescaper(), new LookupTranslator(EntityArrays.JAVA_CTRL_CHARS_UNESCAPE), new LookupTranslator(Collections.unmodifiableMap(map3)));
    }

    public static Builder builder(CharSequenceTranslator charSequenceTranslator) {
        return new Builder(charSequenceTranslator);
    }

    public static final String escapeJava(String str) {
        return ESCAPE_JAVA.translate(str);
    }

    public static final String unescapeJava(String str) {
        return UNESCAPE_JAVA.translate(str);
    }
}
