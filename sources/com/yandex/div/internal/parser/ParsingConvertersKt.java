package com.yandex.div.internal.parser;

import android.net.Uri;
import com.yandex.div.evaluable.types.Color;
import com.yandex.div.evaluable.types.Url;
import com.yandex.div.internal.util.ConvertUtilsKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ParsingConverters.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\u001a(\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003`\u0004H\u0007\u001a$\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006`\u0004H\u0007\u001a$\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0001j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\u0004H\u0007\u001a$\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u0001j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f`\u0004H\u0007\u001a$\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e0\u0001j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e`\u0004H\u0007\u001a,\u0010\u0017\u001a&\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0001j\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\b`\u0004H\u0007\u001a$\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\u0001j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006`\u0004H\u0007\u001a$\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0001j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t`\u0004H\u0007\u001aK\u0010\u001a\u001a\u0004\u0018\u0001H\u001b\"\u0004\b\u0000\u0010\u001c\"\u0004\b\u0001\u0010\u001b*\"\u0012\u0004\u0012\u0002H\u001c\u0012\u0006\u0012\u0004\u0018\u0001H\u001b0\u0001j\u0010\u0012\u0004\u0012\u0002H\u001c\u0012\u0006\u0012\u0004\u0018\u0001H\u001b`\u00042\u0006\u0010\u001d\u001a\u0002H\u001cH\u0081\bø\u0001\u0000¢\u0006\u0002\u0010\u001e\"0\u0010\u0000\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003`\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\",\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006`\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\",\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0001j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\",\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u0001j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f`\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\",\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e0\u0001j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e`\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"4\u0010\u000f\u001a&\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0001j\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\b`\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\",\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\u0001j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006`\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\",\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0001j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t`\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000*.\u0010\u001f\u001a\u0004\b\u0000\u0010\u001c\u001a\u0004\b\u0001\u0010\u001b\"\u000e\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u0002H\u001b0\u00012\u000e\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u0002H\u001b0\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006 "}, d2 = {"ANY_TO_BOOLEAN", "Lkotlin/Function1;", "", "", "Lcom/yandex/div/internal/parser/Converter;", "ANY_TO_URI", "Landroid/net/Uri;", "COLOR_INT_TO_STRING", "", "", "NUMBER_TO_DOUBLE", "", "", "NUMBER_TO_INT", "", "STRING_TO_COLOR_INT", "STRING_TO_URI", "URI_TO_STRING", "getANY_TO_BOOLEAN", "getANY_TO_URI", "getCOLOR_INT_TO_STRING", "getNUMBER_TO_DOUBLE", "getNUMBER_TO_INT", "getSTRING_TO_COLOR_INT", "getSTRING_TO_URI", "getURI_TO_STRING", "tryConvert", "R", "T", "value", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)Ljava/lang/Object;", "Converter", "div-data_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ParsingConvertersKt {
    public static final Function1<Integer, String> COLOR_INT_TO_STRING = new Function1<Integer, String>() { // from class: com.yandex.div.internal.parser.ParsingConvertersKt$COLOR_INT_TO_STRING$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ String invoke(Integer num) {
            return invoke(num.intValue());
        }

        public final String invoke(int i) {
            return Color.m6224toStringimpl(Color.m6218constructorimpl(i));
        }
    };
    public static final Function1<Object, Integer> STRING_TO_COLOR_INT = new Function1<Object, Integer>() { // from class: com.yandex.div.internal.parser.ParsingConvertersKt$STRING_TO_COLOR_INT$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Integer invoke(Object obj) {
            if (obj instanceof String) {
                return Integer.valueOf(Color.INSTANCE.m6227parseC4zCDoM((String) obj));
            }
            if (obj instanceof Color) {
                return Integer.valueOf(((Color) obj).m6225unboximpl());
            }
            if (obj == null) {
                return null;
            }
            throw new ClassCastException("Received value of wrong type");
        }
    };
    public static final Function1<Uri, String> URI_TO_STRING = new Function1<Uri, String>() { // from class: com.yandex.div.internal.parser.ParsingConvertersKt$URI_TO_STRING$1
        @Override // kotlin.jvm.functions.Function1
        public final String invoke(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            String string = uri.toString();
            Intrinsics.checkNotNullExpressionValue(string, "uri.toString()");
            return string;
        }
    };
    public static final Function1<String, Uri> STRING_TO_URI = new Function1<String, Uri>() { // from class: com.yandex.div.internal.parser.ParsingConvertersKt$STRING_TO_URI$1
        @Override // kotlin.jvm.functions.Function1
        public final Uri invoke(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            Uri uri = Uri.parse(value);
            Intrinsics.checkNotNullExpressionValue(uri, "parse(value)");
            return uri;
        }
    };
    public static final Function1<Object, Uri> ANY_TO_URI = new Function1<Object, Uri>() { // from class: com.yandex.div.internal.parser.ParsingConvertersKt$ANY_TO_URI$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Uri invoke(Object value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (value instanceof String) {
                Uri uri = Uri.parse((String) value);
                Intrinsics.checkNotNullExpressionValue(uri, "parse(value)");
                return uri;
            }
            if (!(value instanceof Url)) {
                throw new ClassCastException("Received value of wrong type");
            }
            Uri uri2 = Uri.parse(((Url) value).m6235unboximpl());
            Intrinsics.checkNotNullExpressionValue(uri2, "parse(value.value)");
            return uri2;
        }
    };
    public static final Function1<Object, Boolean> ANY_TO_BOOLEAN = new Function1<Object, Boolean>() { // from class: com.yandex.div.internal.parser.ParsingConvertersKt$ANY_TO_BOOLEAN$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Object value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (value instanceof Boolean) {
                return (Boolean) value;
            }
            if (value instanceof Number) {
                return ConvertUtilsKt.toBoolean((Number) value);
            }
            throw new ClassCastException("Received value of wrong type");
        }
    };
    public static final Function1<Number, Double> NUMBER_TO_DOUBLE = new Function1<Number, Double>() { // from class: com.yandex.div.internal.parser.ParsingConvertersKt$NUMBER_TO_DOUBLE$1
        @Override // kotlin.jvm.functions.Function1
        public final Double invoke(Number n) {
            Intrinsics.checkNotNullParameter(n, "n");
            return Double.valueOf(n.doubleValue());
        }
    };
    public static final Function1<Number, Long> NUMBER_TO_INT = new Function1<Number, Long>() { // from class: com.yandex.div.internal.parser.ParsingConvertersKt$NUMBER_TO_INT$1
        @Override // kotlin.jvm.functions.Function1
        public final Long invoke(Number n) {
            Intrinsics.checkNotNullParameter(n, "n");
            return Long.valueOf(n.longValue());
        }
    };

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> R tryConvert(Function1<? super T, ? extends R> function1, T t) {
        Intrinsics.checkNotNullParameter(function1, "<this>");
        try {
            return function1.invoke(t);
        } catch (Exception unused) {
            return null;
        }
    }

    @Deprecated(message = "Do not use internal API")
    public static final Function1<Integer, String> getCOLOR_INT_TO_STRING() {
        return COLOR_INT_TO_STRING;
    }

    @Deprecated(message = "Do not use internal API")
    public static final Function1<Object, Integer> getSTRING_TO_COLOR_INT() {
        return STRING_TO_COLOR_INT;
    }

    @Deprecated(message = "Do not use internal API")
    public static final Function1<Uri, String> getURI_TO_STRING() {
        return URI_TO_STRING;
    }

    @Deprecated(message = "Do not use internal API")
    public static final Function1<String, Uri> getSTRING_TO_URI() {
        return STRING_TO_URI;
    }

    @Deprecated(message = "Do not use internal API")
    public static final Function1<Object, Uri> getANY_TO_URI() {
        return ANY_TO_URI;
    }

    @Deprecated(message = "Do not use internal API")
    public static final Function1<Object, Boolean> getANY_TO_BOOLEAN() {
        return ANY_TO_BOOLEAN;
    }

    @Deprecated(message = "Do not use internal API")
    public static final Function1<Number, Double> getNUMBER_TO_DOUBLE() {
        return NUMBER_TO_DOUBLE;
    }

    @Deprecated(message = "Do not use internal API")
    public static final Function1<Number, Long> getNUMBER_TO_INT() {
        return NUMBER_TO_INT;
    }
}
