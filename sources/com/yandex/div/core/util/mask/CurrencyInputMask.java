package com.yandex.div.core.util.mask;

import com.json.b9;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: CurrencyInputMask.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\u0010\tJ\u001f\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0002\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0015H\u0002J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001bH\u0002J\u0010\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020&H\u0002J\u0014\u0010'\u001a\u00020\b2\n\u0010(\u001a\u00060\u0006j\u0002`\u0007H\u0016J\u0010\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u0015H\u0016J\u000e\u0010+\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003J\f\u0010,\u001a\u00020\u000b*\u00020\u000bH\u0002J\u0014\u0010-\u001a\u00020\u0015*\u00020\u00152\u0006\u0010!\u001a\u00020\"H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0004\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0014\u001a\u00020\u0015*\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006."}, d2 = {"Lcom/yandex/div/core/util/mask/CurrencyInputMask;", "Lcom/yandex/div/core/util/mask/BaseInputMask;", CommonUrlParts.LOCALE, "Ljava/util/Locale;", "onError", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "(Ljava/util/Locale;Lkotlin/jvm/functions/Function1;)V", "currencyFormatter", "Ljava/text/NumberFormat;", "currencyKey", "", "decimalFormatSymbols", "Ljava/text/DecimalFormatSymbols;", "getDecimalFormatSymbols", "()Ljava/text/DecimalFormatSymbols;", "separators", "", "withNbsp", "", "getWithNbsp", "(Ljava/lang/String;)Ljava/lang/String;", "applyChangeFrom", "newValue", b9.h.L, "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "formatPattern", "pattern", "inDiff", "", "diff", "Lcom/yandex/div/core/util/mask/TextDiff;", "index", "invalidateMaskDataForFormatted", "forValue", "", "onException", "exception", "overrideRawValue", "newRawValue", "updateCurrencyParams", "clearFormatter", "toValidFormat", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CurrencyInputMask extends BaseInputMask {
    private NumberFormat currencyFormatter;
    private final char currencyKey;
    private final Function1<Exception, Unit> onError;
    private final List<Character> separators;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CurrencyInputMask(Locale locale, Function1<? super Exception, Unit> onError) {
        super(new BaseInputMask.MaskData("", CollectionsKt.emptyList(), false));
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.onError = onError;
        this.currencyKey = (char) 164;
        this.separators = CollectionsKt.listOf((Object[]) new Character[]{'.', Character.valueOf(AbstractJsonLexerKt.COMMA)});
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(locale);
        Intrinsics.checkNotNullExpressionValue(currencyInstance, "getCurrencyInstance(locale)");
        this.currencyFormatter = clearFormatter(currencyInstance);
    }

    private final DecimalFormatSymbols getDecimalFormatSymbols() {
        NumberFormat numberFormat = this.currencyFormatter;
        Intrinsics.checkNotNull(numberFormat, "null cannot be cast to non-null type java.text.DecimalFormat");
        DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) numberFormat).getDecimalFormatSymbols();
        Intrinsics.checkNotNullExpressionValue(decimalFormatSymbols, "currencyFormatter as Dec…mat).decimalFormatSymbols");
        return decimalFormatSymbols;
    }

    private final String getWithNbsp(String str) {
        return StringsKt.replace$default(str, ' ', Typography.nbsp, false, 4, (Object) null);
    }

    public final void updateCurrencyParams(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        String strReplace$default = StringsKt.replace$default(getRawValue(), getDecimalFormatSymbols().getDecimalSeparator(), '.', false, 4, (Object) null);
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(locale);
        Intrinsics.checkNotNullExpressionValue(currencyInstance, "getCurrencyInstance(locale)");
        this.currencyFormatter = clearFormatter(currencyInstance);
        BaseInputMask.applyChangeFrom$default(this, StringsKt.replace$default(strReplace$default, '.', getDecimalFormatSymbols().getDecimalSeparator(), false, 4, (Object) null), null, 2, null);
    }

    private final void invalidateMaskDataForFormatted(Number forValue) {
        String formatted = this.currencyFormatter.format(forValue);
        Intrinsics.checkNotNullExpressionValue(formatted, "formatted");
        updateMaskData(new BaseInputMask.MaskData(formatPattern(formatted), CollectionsKt.listOf((Object[]) new BaseInputMask.MaskKey[]{new BaseInputMask.MaskKey('#', "\\d", '0'), new BaseInputMask.MaskKey(getDecimalFormatSymbols().getDecimalSeparator(), b9.i.d + getDecimalFormatSymbols().getDecimalSeparator() + AbstractJsonLexerKt.END_LIST, getDecimalFormatSymbols().getDecimalSeparator())}), getMaskData().getAlwaysVisible()), false);
    }

    @Override // com.yandex.div.core.util.mask.BaseInputMask
    public void overrideRawValue(String newRawValue) throws ParseException {
        Intrinsics.checkNotNullParameter(newRawValue, "newRawValue");
        Number number = this.currencyFormatter.parse(newRawValue);
        if (number == null) {
            number = (Number) 0;
        }
        invalidateMaskDataForFormatted(number);
        super.overrideRawValue(newRawValue);
    }

    @Override // com.yandex.div.core.util.mask.BaseInputMask
    public void applyChangeFrom(String newValue, Integer position) throws ParseException {
        String strValueOf;
        int iAbs;
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        TextDiff textDiffBuild = TextDiff.INSTANCE.build(getValue(), getWithNbsp(newValue));
        char decimalSeparator = getDecimalFormatSymbols().getDecimalSeparator();
        String value = getValue();
        int length = value.length() - 1;
        if (length < 0) {
            length = -1;
            break;
        }
        while (true) {
            int i = length - 1;
            if (value.charAt(length) == decimalSeparator) {
                break;
            }
            if (i < 0) {
                length = -1;
                break;
            }
            length = i;
        }
        String str = newValue;
        int length2 = str.length() - 1;
        if (length2 < 0) {
            length2 = -1;
            break;
        }
        while (true) {
            int i2 = length2 - 1;
            if (str.charAt(length2) == decimalSeparator) {
                break;
            }
            if (i2 < 0) {
                length2 = -1;
                break;
            }
            length2 = i2;
        }
        boolean z = length != length2 || (length == -1 && length2 == -1);
        String validFormat = toValidFormat(newValue, textDiffBuild);
        NumberFormat numberFormat = this.currencyFormatter;
        String str2 = validFormat;
        if (StringsKt.startsWith$default((CharSequence) str2, decimalSeparator, false, 2, (Object) null)) {
            strValueOf = getDecimalFormatSymbols().getZeroDigit() + validFormat;
        } else {
            strValueOf = StringsKt.isBlank(str2) ? String.valueOf(getDecimalFormatSymbols().getZeroDigit()) : validFormat;
        }
        Number number = numberFormat.parse(strValueOf);
        if (number == null) {
            number = (Number) 0;
        }
        cleanup(textDiffBuild);
        if (z) {
            invalidateMaskDataForFormatted(number);
        }
        BaseInputMask.replaceChars$default(this, validFormat, 0, null, 4, null);
        if (getValue().length() <= textDiffBuild.getStart() || getValue().charAt(textDiffBuild.getStart()) != getDecimalFormatSymbols().getGroupingSeparator()) {
            iAbs = Math.abs(getValue().length() - (newValue.length() - (position != null ? position.intValue() : getCursorPosition())));
        } else {
            iAbs = position != null ? position.intValue() : getCursorPosition();
        }
        setCursorPosition(RangesKt.coerceAtMost(iAbs, getValue().length()));
    }

    private final NumberFormat clearFormatter(NumberFormat numberFormat) throws IOException {
        DecimalFormat decimalFormat = numberFormat instanceof DecimalFormat ? (DecimalFormat) numberFormat : null;
        if (decimalFormat != null) {
            String pattern = decimalFormat.toPattern();
            Intrinsics.checkNotNullExpressionValue(pattern, "toPattern()");
            String str = pattern;
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt != this.currencyKey) {
                    sb.append(cCharAt);
                }
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            decimalFormat.applyPattern(StringsKt.trim((CharSequence) string).toString());
        }
        return numberFormat;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x004e  */
    private final String toValidFormat(String str, TextDiff textDiff) {
        int i;
        int start;
        int i2;
        char decimalSeparator = getDecimalFormatSymbols().getDecimalSeparator();
        int i3 = 0;
        while (true) {
            i = -1;
            if (i3 >= str.length()) {
                i3 = -1;
                break;
            }
            if (str.charAt(i3) == decimalSeparator && !inDiff(textDiff, i3)) {
                break;
            }
            i3++;
        }
        if (textDiff.getAdded() != 1 || textDiff.getRemoved() != 0) {
            start = -1;
        } else if (this.separators.contains(Character.valueOf(str.charAt(textDiff.getStart())))) {
            start = textDiff.getStart();
        } else {
            start = -1;
        }
        int maximumFractionDigits = this.currencyFormatter.getMaximumFractionDigits();
        if (i3 != -1) {
            i2 = maximumFractionDigits;
            for (int i4 = i3; i4 < str.length(); i4++) {
                if (Character.isDigit(str.charAt(i4)) && !inDiff(textDiff, i4)) {
                    i2--;
                }
            }
        } else {
            String str2 = str;
            int i5 = 0;
            int i6 = 0;
            boolean z = false;
            i2 = maximumFractionDigits;
            while (i5 < str2.length()) {
                char cCharAt = str2.charAt(i5);
                int i7 = i6 + 1;
                boolean zInDiff = inDiff(textDiff, i6);
                if (cCharAt == decimalSeparator) {
                    z = true;
                } else if (!zInDiff && z && Character.isDigit(cCharAt)) {
                    i2--;
                }
                i5++;
                i6 = i7;
            }
        }
        boolean z2 = StringsKt.contains$default((CharSequence) str, decimalSeparator, false, 2, (Object) null) || start != -1;
        StringBuilder sb = new StringBuilder();
        boolean z3 = false;
        for (int length = str.length() - 1; length >= 0; length--) {
            char cCharAt2 = str.charAt(length);
            boolean z4 = sb.length() <= maximumFractionDigits;
            if (Character.isDigit(cCharAt2)) {
                if (!inDiff(textDiff, length) || z3 || !z2) {
                    sb.append(cCharAt2);
                } else if (i2 > 0) {
                    sb.append(cCharAt2);
                    i2--;
                }
            } else if (z4 && i3 == -1 && length == start) {
                sb.append(decimalSeparator);
                z3 = true;
            } else if (z4 && cCharAt2 == decimalSeparator && (i3 == length || i3 == -1)) {
                sb.append(decimalSeparator);
                z3 = true;
                i3 = length;
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        String string2 = StringsKt.reversed((CharSequence) string).toString();
        String str3 = string2;
        int length2 = str3.length();
        for (int i8 = 0; i8 < length2; i8++) {
            if (str3.charAt(i8) != getDecimalFormatSymbols().getZeroDigit()) {
                i = i8;
                break;
            }
        }
        if (i <= 0) {
            return string2;
        }
        if (string2.charAt(i) == getDecimalFormatSymbols().getDecimalSeparator()) {
            return StringsKt.drop(string2, i - 1);
        }
        return StringsKt.drop(string2, i);
    }

    private final boolean inDiff(TextDiff diff, int index) {
        return diff.getStart() <= index && index < diff.getStart() + diff.getAdded();
    }

    private final String formatPattern(String pattern) {
        StringBuilder sb = new StringBuilder();
        String str = pattern;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (Character.isDigit(cCharAt)) {
                sb.append('#');
            } else {
                sb.append(cCharAt);
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @Override // com.yandex.div.core.util.mask.BaseInputMask
    public void onException(Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        this.onError.invoke(exception);
    }
}
