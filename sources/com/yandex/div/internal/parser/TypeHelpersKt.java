package com.yandex.div.internal.parser;

import android.net.Uri;
import androidx.core.view.ViewCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: compiled from: TypeHelpers.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\"\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"TYPE_HELPER_BOOLEAN", "Lcom/yandex/div/internal/parser/TypeHelper;", "", "TYPE_HELPER_COLOR", "", "TYPE_HELPER_DOUBLE", "", "TYPE_HELPER_INT", "", "TYPE_HELPER_JSON_ARRAY", "Lorg/json/JSONArray;", "TYPE_HELPER_STRING", "", "TYPE_HELPER_URI", "Landroid/net/Uri;", "div-data_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class TypeHelpersKt {
    public static final TypeHelper<Boolean> TYPE_HELPER_BOOLEAN = new TypeHelper<Boolean>() { // from class: com.yandex.div.internal.parser.TypeHelpersKt$TYPE_HELPER_BOOLEAN$1
        private final boolean typeDefault;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.yandex.div.internal.parser.TypeHelper
        public Boolean getTypeDefault() {
            return Boolean.valueOf(this.typeDefault);
        }

        @Override // com.yandex.div.internal.parser.TypeHelper
        public boolean isTypeValid(Object value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return value instanceof Boolean;
        }
    };
    public static final TypeHelper<Long> TYPE_HELPER_INT = new TypeHelper<Long>() { // from class: com.yandex.div.internal.parser.TypeHelpersKt$TYPE_HELPER_INT$1
        private final long typeDefault;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.yandex.div.internal.parser.TypeHelper
        public Long getTypeDefault() {
            return Long.valueOf(this.typeDefault);
        }

        @Override // com.yandex.div.internal.parser.TypeHelper
        public boolean isTypeValid(Object value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return value instanceof Long;
        }
    };
    public static final TypeHelper<String> TYPE_HELPER_STRING = new TypeHelper<String>() { // from class: com.yandex.div.internal.parser.TypeHelpersKt$TYPE_HELPER_STRING$1
        private final String typeDefault = "";

        @Override // com.yandex.div.internal.parser.TypeHelper
        public String getTypeDefault() {
            return this.typeDefault;
        }

        @Override // com.yandex.div.internal.parser.TypeHelper
        public boolean isTypeValid(Object value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return value instanceof String;
        }
    };
    public static final TypeHelper<Double> TYPE_HELPER_DOUBLE = new TypeHelper<Double>() { // from class: com.yandex.div.internal.parser.TypeHelpersKt$TYPE_HELPER_DOUBLE$1
        private final double typeDefault;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.yandex.div.internal.parser.TypeHelper
        public Double getTypeDefault() {
            return Double.valueOf(this.typeDefault);
        }

        @Override // com.yandex.div.internal.parser.TypeHelper
        public boolean isTypeValid(Object value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return value instanceof Double;
        }
    };
    public static final TypeHelper<Uri> TYPE_HELPER_URI = new TypeHelper<Uri>() { // from class: com.yandex.div.internal.parser.TypeHelpersKt$TYPE_HELPER_URI$1
        private final Uri typeDefault = Uri.EMPTY;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.yandex.div.internal.parser.TypeHelper
        public Uri getTypeDefault() {
            return this.typeDefault;
        }

        @Override // com.yandex.div.internal.parser.TypeHelper
        public boolean isTypeValid(Object value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return value instanceof Uri;
        }
    };
    public static final TypeHelper<Integer> TYPE_HELPER_COLOR = new TypeHelper<Integer>() { // from class: com.yandex.div.internal.parser.TypeHelpersKt$TYPE_HELPER_COLOR$1
        private final int typeDefault = ViewCompat.MEASURED_STATE_MASK;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.yandex.div.internal.parser.TypeHelper
        public Integer getTypeDefault() {
            return Integer.valueOf(this.typeDefault);
        }

        @Override // com.yandex.div.internal.parser.TypeHelper
        public boolean isTypeValid(Object value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return value instanceof Integer;
        }
    };
    public static final TypeHelper<JSONArray> TYPE_HELPER_JSON_ARRAY = new TypeHelper<JSONArray>() { // from class: com.yandex.div.internal.parser.TypeHelpersKt$TYPE_HELPER_JSON_ARRAY$1
        private final JSONArray typeDefault = new JSONArray();

        @Override // com.yandex.div.internal.parser.TypeHelper
        public JSONArray getTypeDefault() {
            return this.typeDefault;
        }

        @Override // com.yandex.div.internal.parser.TypeHelper
        public boolean isTypeValid(Object value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return value instanceof JSONArray;
        }
    };
}
