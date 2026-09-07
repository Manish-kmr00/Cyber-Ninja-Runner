package com.yandex.mobile.ads.impl;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class kr1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DecimalFormat f9444a;

    public final String a(String value) throws p61, IOException {
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < value.length(); i++) {
                char cCharAt = value.charAt(i);
                if (!CharsKt.isWhitespace(cCharAt)) {
                    sb.append(cCharAt);
                }
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            String str = this.f9444a.format(Long.parseLong(string));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        } catch (NumberFormatException e) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(String.format("Could not parse review count value. Review Count value is %s", Arrays.copyOf(new Object[]{value}, 1)), "format(...)");
            Object[] args = {e};
            int i2 = op0.b;
            Intrinsics.checkNotNullParameter(args, "args");
            throw new p61("Native Ad json has not required attributes");
        }
    }

    public kr1() {
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.US);
        decimalFormatSymbols.setGroupingSeparator(' ');
        this.f9444a = new DecimalFormat("#,###,###", decimalFormatSymbols);
    }
}
