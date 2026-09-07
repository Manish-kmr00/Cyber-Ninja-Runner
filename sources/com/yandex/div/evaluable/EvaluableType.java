package com.yandex.div.evaluable;

import androidx.exifinterface.media.ExifInterface;
import com.yandex.div.evaluable.types.Color;
import com.yandex.div.evaluable.types.DateTime;
import com.yandex.div.evaluable.types.Url;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: EvaluableType.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/yandex/div/evaluable/EvaluableType;", "", "typeName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTypeName$div_evaluable", "()Ljava/lang/String;", "toString", "INTEGER", "NUMBER", "BOOLEAN", "STRING", "DATETIME", "COLOR", "URL", "DICT", "ARRAY", "Companion", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
public enum EvaluableType {
    INTEGER("Integer"),
    NUMBER("Number"),
    BOOLEAN("Boolean"),
    STRING("String"),
    DATETIME(ExifInterface.TAG_DATETIME),
    COLOR("Color"),
    URL("Url"),
    DICT("Dict"),
    ARRAY("Array");


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String typeName;

    EvaluableType(String str) {
        this.typeName = str;
    }

    /* JADX INFO: renamed from: getTypeName$div_evaluable, reason: from getter */
    public final String getTypeName() {
        return this.typeName;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.typeName;
    }

    /* JADX INFO: compiled from: EvaluableType.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u0004\"\u0006\b\u0000\u0010\u0005\u0018\u00012\u0006\u0010\u0006\u001a\u0002H\u0005H\u0087\b¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/yandex/div/evaluable/EvaluableType$Companion;", "", "()V", "of", "Lcom/yandex/div/evaluable/EvaluableType;", "T", "value", "(Ljava/lang/Object;)Lcom/yandex/div/evaluable/EvaluableType;", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final /* synthetic */ <T> EvaluableType of(T value) {
            if (value instanceof Long) {
                return EvaluableType.INTEGER;
            }
            if (value instanceof Double) {
                return EvaluableType.NUMBER;
            }
            if (value instanceof Boolean) {
                return EvaluableType.BOOLEAN;
            }
            if (value instanceof String) {
                return EvaluableType.STRING;
            }
            if (value instanceof DateTime) {
                return EvaluableType.DATETIME;
            }
            if (value instanceof Color) {
                return EvaluableType.COLOR;
            }
            if (value instanceof Url) {
                return EvaluableType.URL;
            }
            if (value instanceof JSONObject) {
                return EvaluableType.DICT;
            }
            if (value instanceof JSONArray) {
                return EvaluableType.ARRAY;
            }
            if (value == null) {
                throw new EvaluableException("Unable to find type for null", null, 2, null);
            }
            StringBuilder sb = new StringBuilder("Unable to find type for ");
            Intrinsics.checkNotNull(value);
            throw new EvaluableException(sb.append(value.getClass().getName()).toString(), null, 2, null);
        }
    }
}
