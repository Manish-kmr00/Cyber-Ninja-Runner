package com.yandex.div.histogram.util;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: JSONUtf8BytesCalculator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0000H\u0002J\u0010\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\u0000H\u0002J\b\u0010\f\u001a\u00020\u0000H\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nH\u0002J\u0012\u0010\u000f\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/yandex/div/histogram/util/JSONUtf8BytesCalculator;", "", "()V", "bytesSize", "", "array", "entriesSeparator", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "key", "name", "", "keyValueSeparator", "object", "string", "", "value", "Companion", "div-histogram_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class JSONUtf8BytesCalculator {
    private static final int ARRAY_BRACKETS_BYTES = 2;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int ENTRIES_SEPARATOR_BYTES = 1;
    private static final int ESCAPED_CHARACTERS_BYTES = 2;
    private static final int FALSE_BYTES = 5;
    private static final int KEY_VALUE_SEPARATOR_BYTES = 1;
    private static final int NULL_BYTES = 4;
    private static final int OBJECT_BRACES_BYTES = 2;
    private static final int QUOTES_BYTES = 2;
    private static final int TRUE_BYTES = 4;
    private int bytesSize;

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONUtf8BytesCalculator array() {
        this.bytesSize += 2;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONUtf8BytesCalculator object() {
        this.bytesSize += 2;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONUtf8BytesCalculator value(Object value) throws JSONException {
        if (!(value instanceof JSONArray)) {
            if (!(value instanceof JSONObject)) {
                if (value == null || value == JSONObject.NULL) {
                    this.bytesSize += 4;
                } else if (value instanceof Boolean) {
                    this.bytesSize += ((Boolean) value).booleanValue() ? 4 : 5;
                } else if (value instanceof Number) {
                    int i = this.bytesSize;
                    HistogramUtils histogramUtils = HistogramUtils.INSTANCE;
                    String strNumberToString = JSONObject.numberToString((Number) value);
                    Intrinsics.checkNotNullExpressionValue(strNumberToString, "numberToString(value)");
                    this.bytesSize = i + histogramUtils.calculateUtf8StringByteSize(strNumberToString);
                } else {
                    string(value.toString());
                }
                return this;
            }
            INSTANCE.calculateUtf8JsonBytes((JSONObject) value, this);
            return this;
        }
        INSTANCE.calculateUtf8JsonArrayBytes((JSONArray) value, this);
        return this;
    }

    private final void string(String value) {
        int utf8CharByteSize;
        this.bytesSize += 2;
        int length = value.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = value.charAt(i);
            int i2 = this.bytesSize;
            if (cCharAt == '\"' || cCharAt == '\\' || cCharAt == '/' || cCharAt == '\t' || cCharAt == '\b' || cCharAt == '\n' || cCharAt == '\r') {
                utf8CharByteSize = 2;
            } else if (cCharAt <= 31) {
                HistogramUtils histogramUtils = HistogramUtils.INSTANCE;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = String.format("\\u%04x", Arrays.copyOf(new Object[]{Integer.valueOf(cCharAt)}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                utf8CharByteSize = histogramUtils.calculateUtf8StringByteSize(str);
            } else {
                utf8CharByteSize = HistogramUtils.INSTANCE.getUtf8CharByteSize(cCharAt);
            }
            this.bytesSize = i2 + utf8CharByteSize;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONUtf8BytesCalculator key(String name) {
        string(name);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONUtf8BytesCalculator keyValueSeparator() {
        this.bytesSize++;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONUtf8BytesCalculator entriesSeparator(int entries) {
        if (entries <= 1) {
            return this;
        }
        this.bytesSize += entries - 1;
        return this;
    }

    /* JADX INFO: compiled from: JSONUtf8BytesCalculator.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0014J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/yandex/div/histogram/util/JSONUtf8BytesCalculator$Companion;", "", "()V", "ARRAY_BRACKETS_BYTES", "", "ENTRIES_SEPARATOR_BYTES", "ESCAPED_CHARACTERS_BYTES", "FALSE_BYTES", "KEY_VALUE_SEPARATOR_BYTES", "NULL_BYTES", "OBJECT_BRACES_BYTES", "QUOTES_BYTES", "TRUE_BYTES", "calculateUtf8JsonArrayBytes", "", "json", "Lorg/json/JSONArray;", "jsonUtf8BytesCalculator", "Lcom/yandex/div/histogram/util/JSONUtf8BytesCalculator;", "calculateUtf8JsonBytes", "Lorg/json/JSONObject;", "div-histogram_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int calculateUtf8JsonBytes(JSONObject json) {
            Intrinsics.checkNotNullParameter(json, "json");
            JSONUtf8BytesCalculator jSONUtf8BytesCalculator = new JSONUtf8BytesCalculator();
            calculateUtf8JsonBytes(json, jSONUtf8BytesCalculator);
            return jSONUtf8BytesCalculator.bytesSize;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void calculateUtf8JsonBytes(JSONObject json, JSONUtf8BytesCalculator jsonUtf8BytesCalculator) {
            jsonUtf8BytesCalculator.object().entriesSeparator(json.length());
            Iterator<String> itKeys = json.keys();
            Intrinsics.checkNotNullExpressionValue(itKeys, "json.keys()");
            while (itKeys.hasNext()) {
                String it = itKeys.next();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                jsonUtf8BytesCalculator.key(it).keyValueSeparator().value(json.get(it));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void calculateUtf8JsonArrayBytes(JSONArray json, JSONUtf8BytesCalculator jsonUtf8BytesCalculator) throws JSONException {
            jsonUtf8BytesCalculator.array().entriesSeparator(json.length());
            int length = json.length();
            for (int i = 0; i < length; i++) {
                jsonUtf8BytesCalculator.value(json.get(i));
            }
        }
    }
}
