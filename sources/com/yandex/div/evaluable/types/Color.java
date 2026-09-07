package com.yandex.div.evaluable.types;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Color.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\u0005J\r\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\u0005J\u001a\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b\u0012\u0010\u0005J\u0010\u0010\u0013\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0005J\r\u0010\u0015\u001a\u00020\u0003¢\u0006\u0004\b\u0016\u0010\u0005J\u000f\u0010\u0017\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lcom/yandex/div/evaluable/types/Color;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "alpha", "alpha-impl", "blue", "blue-impl", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "green", "green-impl", "hashCode", "hashCode-impl", "red", "red-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
@JvmInline
public final class Color {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int value;

    /* JADX INFO: renamed from: alpha-impl, reason: not valid java name */
    public static final int m6215alphaimpl(int i) {
        return i >>> 24;
    }

    /* JADX INFO: renamed from: blue-impl, reason: not valid java name */
    public static final int m6216blueimpl(int i) {
        return i & 255;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Color m6217boximpl(int i) {
        return new Color(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m6218constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m6219equalsimpl(int i, Object obj) {
        return (obj instanceof Color) && i == ((Color) obj).m6225unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m6220equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: green-impl, reason: not valid java name */
    public static final int m6221greenimpl(int i) {
        return (i >> 8) & 255;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m6222hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* JADX INFO: renamed from: red-impl, reason: not valid java name */
    public static final int m6223redimpl(int i) {
        return (i >> 16) & 255;
    }

    public boolean equals(Object obj) {
        return m6219equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m6222hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m6225unboximpl() {
        return this.value;
    }

    private /* synthetic */ Color(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }

    public String toString() {
        return m6224toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m6224toStringimpl(int i) {
        StringBuilder sb = new StringBuilder("#");
        String hexString = Integer.toHexString(i);
        Intrinsics.checkNotNullExpressionValue(hexString, "toHexString(value)");
        String upperCase = StringsKt.padStart(hexString, 8, '0').toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return sb.append(upperCase).toString();
    }

    /* JADX INFO: compiled from: Color.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u000f\u0010\u0010J.\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/yandex/div/evaluable/types/Color$Companion;", "", "()V", "argb", "Lcom/yandex/div/evaluable/types/Color;", "alpha", "", "red", "green", "blue", "argb-H0kstlE", "(IIII)I", "parse", "colorString", "", "parse-C4zCDoM", "(Ljava/lang/String;)I", "rgb", "rgb-B7-1Z8I", "(III)I", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: argb-H0kstlE, reason: not valid java name */
        public final int m6226argbH0kstlE(int alpha, int red, int green, int blue) {
            return Color.m6218constructorimpl((alpha << 24) | (red << 16) | (green << 8) | blue);
        }

        /* JADX INFO: renamed from: rgb-B7-1Z8I, reason: not valid java name */
        public final int m6228rgbB71Z8I(int red, int green, int blue) {
            return m6226argbH0kstlE(255, red, green, blue);
        }

        /* JADX INFO: renamed from: parse-C4zCDoM, reason: not valid java name */
        public final int m6227parseC4zCDoM(String colorString) throws IllegalArgumentException {
            String str;
            Intrinsics.checkNotNullParameter(colorString, "colorString");
            if (colorString.length() <= 0) {
                throw new IllegalArgumentException("Expected color string, actual string is empty".toString());
            }
            if (colorString.charAt(0) != '#') {
                throw new IllegalArgumentException(("Unknown color " + colorString).toString());
            }
            int length = colorString.length();
            if (length == 4) {
                char cCharAt = colorString.charAt(1);
                char cCharAt2 = colorString.charAt(2);
                char cCharAt3 = colorString.charAt(3);
                str = new String(new char[]{'f', 'f', cCharAt, cCharAt, cCharAt2, cCharAt2, cCharAt3, cCharAt3});
            } else if (length == 5) {
                char cCharAt4 = colorString.charAt(1);
                char cCharAt5 = colorString.charAt(2);
                char cCharAt6 = colorString.charAt(3);
                char cCharAt7 = colorString.charAt(4);
                str = new String(new char[]{cCharAt4, cCharAt4, cCharAt5, cCharAt5, cCharAt6, cCharAt6, cCharAt7, cCharAt7});
            } else if (length == 7) {
                StringBuilder sb = new StringBuilder("ff");
                String strSubstring = colorString.substring(1);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
                str = sb.append(strSubstring).toString();
            } else if (length == 9) {
                str = colorString.substring(1);
                Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).substring(startIndex)");
            } else {
                throw new IllegalArgumentException("Unknown color " + colorString);
            }
            return Color.m6218constructorimpl((int) Long.parseLong(str, CharsKt.checkRadix(16)));
        }
    }
}
