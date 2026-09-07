package com.yandex.div2;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivEvaluableType.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/yandex/div2/DivEvaluableType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "STRING", "INTEGER", "NUMBER", "BOOLEAN", "DATETIME", "COLOR", "URL", "DICT", "ARRAY", "Converter", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public enum DivEvaluableType {
    STRING("string"),
    INTEGER("integer"),
    NUMBER("number"),
    BOOLEAN("boolean"),
    DATETIME("datetime"),
    COLOR("color"),
    URL("url"),
    DICT("dict"),
    ARRAY("array");

    private final String value;

    /* JADX INFO: renamed from: Converter, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Function1<DivEvaluableType, String> TO_STRING = new Function1<DivEvaluableType, String>() { // from class: com.yandex.div2.DivEvaluableType$Converter$TO_STRING$1
        @Override // kotlin.jvm.functions.Function1
        public final String invoke(DivEvaluableType value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return DivEvaluableType.INSTANCE.toString(value);
        }
    };
    public static final Function1<String, DivEvaluableType> FROM_STRING = new Function1<String, DivEvaluableType>() { // from class: com.yandex.div2.DivEvaluableType$Converter$FROM_STRING$1
        @Override // kotlin.jvm.functions.Function1
        public final DivEvaluableType invoke(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return DivEvaluableType.INSTANCE.fromString(value);
        }
    };

    DivEvaluableType(String str) {
        this.value = str;
    }

    /* JADX INFO: renamed from: com.yandex.div2.DivEvaluableType$Converter, reason: from kotlin metadata */
    /* JADX INFO: compiled from: DivEvaluableType.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0006R\u001e\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/yandex/div2/DivEvaluableType$Converter;", "", "()V", "FROM_STRING", "Lkotlin/Function1;", "", "Lcom/yandex/div2/DivEvaluableType;", "TO_STRING", "fromString", "value", "toString", "obj", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String toString(DivEvaluableType obj) {
            Intrinsics.checkNotNullParameter(obj, "obj");
            return obj.value;
        }

        public final DivEvaluableType fromString(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (Intrinsics.areEqual(value, DivEvaluableType.STRING.value)) {
                return DivEvaluableType.STRING;
            }
            if (Intrinsics.areEqual(value, DivEvaluableType.INTEGER.value)) {
                return DivEvaluableType.INTEGER;
            }
            if (Intrinsics.areEqual(value, DivEvaluableType.NUMBER.value)) {
                return DivEvaluableType.NUMBER;
            }
            if (Intrinsics.areEqual(value, DivEvaluableType.BOOLEAN.value)) {
                return DivEvaluableType.BOOLEAN;
            }
            if (Intrinsics.areEqual(value, DivEvaluableType.DATETIME.value)) {
                return DivEvaluableType.DATETIME;
            }
            if (Intrinsics.areEqual(value, DivEvaluableType.COLOR.value)) {
                return DivEvaluableType.COLOR;
            }
            if (Intrinsics.areEqual(value, DivEvaluableType.URL.value)) {
                return DivEvaluableType.URL;
            }
            if (Intrinsics.areEqual(value, DivEvaluableType.DICT.value)) {
                return DivEvaluableType.DICT;
            }
            if (Intrinsics.areEqual(value, DivEvaluableType.ARRAY.value)) {
                return DivEvaluableType.ARRAY;
            }
            return null;
        }
    }
}
