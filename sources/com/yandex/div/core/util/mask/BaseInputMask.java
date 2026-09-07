package com.yandex.div.core.util.mask;

import com.json.b9;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.PatternSyntaxException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: BaseInputMask.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b \u0018\u00002\u00020\u0001:\u0003GHIB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J!\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001f2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010(J\u0018\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020+2\u0006\u0010&\u001a\u00020\u001fH\u0002J\u0010\u0010,\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020+H\u0002J\u0018\u0010-\u001a\u00020%2\u0006\u0010*\u001a\u00020+2\u0006\u0010.\u001a\u00020\u0006H\u0004J\u0018\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u0006H\u0004J\u0018\u00102\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u0006H\u0002J\u0010\u00104\u001a\u00020%2\u0006\u0010*\u001a\u00020+H\u0004J\u0018\u00105\u001a\u00020%2\u0006\u00101\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u0006H\u0004J\u0018\u00107\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u0006H\u0004J\u0010\u00108\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006H\u0004J\u0014\u00109\u001a\u00020%2\n\u0010:\u001a\u00060;j\u0002`<H&J\u0010\u0010=\u001a\u00020%2\u0006\u0010>\u001a\u00020\u001fH\u0016J\u0018\u0010?\u001a\u00020\u00062\u0006\u0010*\u001a\u00020+2\u0006\u0010&\u001a\u00020\u001fH\u0004J)\u0010@\u001a\u00020%2\u0006\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u00062\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u0006H\u0004¢\u0006\u0002\u0010BJ\u001a\u0010C\u001a\u00020%2\u0006\u0010D\u001a\u00020\u00032\b\b\u0002\u0010E\u001a\u00020FH\u0016R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00068DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\tR\u001e\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b#\u0010!¨\u0006J"}, d2 = {"Lcom/yandex/div/core/util/mask/BaseInputMask;", "", "initialMaskData", "Lcom/yandex/div/core/util/mask/BaseInputMask$MaskData;", "(Lcom/yandex/div/core/util/mask/BaseInputMask$MaskData;)V", "<set-?>", "", "cursorPosition", "getCursorPosition", "()I", "setCursorPosition", "(I)V", "destructedValue", "", "Lcom/yandex/div/core/util/mask/BaseInputMask$MaskChar;", "getDestructedValue", "()Ljava/util/List;", "setDestructedValue", "(Ljava/util/List;)V", "filters", "", "", "Lkotlin/text/Regex;", "getFilters", "()Ljava/util/Map;", "firstEmptyHolderIndex", "getFirstEmptyHolderIndex", "maskData", "getMaskData", "()Lcom/yandex/div/core/util/mask/BaseInputMask$MaskData;", "rawValue", "", "getRawValue", "()Ljava/lang/String;", "value", "getValue", "applyChangeFrom", "", "newValue", b9.h.L, "(Ljava/lang/String;Ljava/lang/Integer;)V", "buildBodySubstring", "textDiff", "Lcom/yandex/div/core/util/mask/TextDiff;", "buildTailSubstring", "calculateCursorPosition", "tailStart", "calculateInsertableSubstring", "substring", "start", "calculateMaxShift", "string", "cleanup", "clearRange", "end", "collectValueRange", "firstHolderAfter", "onException", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "overrideRawValue", "newRawValue", "replaceBodyTail", "replaceChars", "count", "(Ljava/lang/String;ILjava/lang/Integer;)V", "updateMaskData", "newMaskData", "restoreValue", "", "MaskChar", "MaskData", "MaskKey", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class BaseInputMask {
    private int cursorPosition;
    protected List<? extends MaskChar> destructedValue;
    private final Map<Character, Regex> filters;
    private MaskData maskData;

    public abstract void onException(Exception exception);

    public BaseInputMask(MaskData initialMaskData) {
        Intrinsics.checkNotNullParameter(initialMaskData, "initialMaskData");
        this.maskData = initialMaskData;
        this.filters = new LinkedHashMap();
        updateMaskData$default(this, initialMaskData, false, 2, null);
    }

    protected final MaskData getMaskData() {
        return this.maskData;
    }

    protected final Map<Character, Regex> getFilters() {
        return this.filters;
    }

    protected final List<MaskChar> getDestructedValue() {
        List list = this.destructedValue;
        if (list != null) {
            return list;
        }
        Intrinsics.throwUninitializedPropertyAccessException("destructedValue");
        return null;
    }

    protected final void setDestructedValue(List<? extends MaskChar> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.destructedValue = list;
    }

    public final int getCursorPosition() {
        return this.cursorPosition;
    }

    protected final void setCursorPosition(int i) {
        this.cursorPosition = i;
    }

    public final String getRawValue() {
        return collectValueRange(0, getDestructedValue().size() - 1);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0044  */
    /* JADX WARN: Code duplicated, block: B:15:0x004c  */
    /* JADX WARN: Code duplicated, block: B:20:0x005e A[EDGE_INSN: B:20:0x005e->B:17:0x005e BREAK  A[LOOP:0: B:3:0x0014->B:16:0x005a], SYNTHETIC] */
    public final String getValue() {
        StringBuilder sb = new StringBuilder();
        List<MaskChar> destructedValue = getDestructedValue();
        ArrayList arrayList = new ArrayList();
        for (Object obj : destructedValue) {
            MaskChar maskChar = (MaskChar) obj;
            if (maskChar instanceof MaskChar.Static) {
                sb.append(((MaskChar.Static) maskChar).getChar());
            } else if (!(maskChar instanceof MaskChar.Dynamic)) {
                if (this.maskData.getAlwaysVisible()) {
                    break;
                    break;
                }
                Intrinsics.checkNotNull(maskChar, "null cannot be cast to non-null type com.yandex.div.core.util.mask.BaseInputMask.MaskChar.Dynamic");
                sb.append(((MaskChar.Dynamic) maskChar).getPlaceholder());
            } else {
                MaskChar.Dynamic dynamic = (MaskChar.Dynamic) maskChar;
                if (dynamic.getChar() != null) {
                    sb.append(dynamic.getChar());
                } else {
                    if (this.maskData.getAlwaysVisible()) {
                        break;
                    }
                    Intrinsics.checkNotNull(maskChar, "null cannot be cast to non-null type com.yandex.div.core.util.mask.BaseInputMask.MaskChar.Dynamic");
                    sb.append(((MaskChar.Dynamic) maskChar).getPlaceholder());
                }
            }
            arrayList.add(obj);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "stringBuilder.toString()");
        return string;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002a  */
    /* JADX WARN: Code duplicated, block: B:20:? A[RETURN, SYNTHETIC] */
    protected final int getFirstEmptyHolderIndex() {
        int i = 0;
        for (MaskChar maskChar : getDestructedValue()) {
            if ((maskChar instanceof MaskChar.Dynamic) && ((MaskChar.Dynamic) maskChar).getChar() == null) {
                if (i != -1) {
                    return i;
                }
                return getDestructedValue().size();
            }
            i++;
        }
        i = -1;
        if (i != -1) {
            return i;
        }
        return getDestructedValue().size();
    }

    public static /* synthetic */ void updateMaskData$default(BaseInputMask baseInputMask, MaskData maskData, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateMaskData");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        baseInputMask.updateMaskData(maskData, z);
    }

    public void updateMaskData(MaskData newMaskData, boolean restoreValue) {
        Object next;
        MaskChar dynamic;
        Intrinsics.checkNotNullParameter(newMaskData, "newMaskData");
        String rawValue = (Intrinsics.areEqual(this.maskData, newMaskData) || !restoreValue) ? null : getRawValue();
        this.maskData = newMaskData;
        this.filters.clear();
        for (MaskKey maskKey : this.maskData.getDecoding()) {
            try {
                String filter = maskKey.getFilter();
                if (filter != null) {
                    this.filters.put(Character.valueOf(maskKey.getKey()), new Regex(filter));
                }
            } catch (PatternSyntaxException e) {
                onException(e);
            }
        }
        String pattern = this.maskData.getPattern();
        ArrayList arrayList = new ArrayList(pattern.length());
        for (int i = 0; i < pattern.length(); i++) {
            char cCharAt = pattern.charAt(i);
            Iterator<T> it = this.maskData.getDecoding().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (((MaskKey) next).getKey() != cCharAt);
            MaskKey maskKey2 = (MaskKey) next;
            if (maskKey2 != null) {
                dynamic = new MaskChar.Dynamic(null, this.filters.get(Character.valueOf(maskKey2.getKey())), maskKey2.getPlaceholder());
            } else {
                dynamic = new MaskChar.Static(cCharAt);
            }
            arrayList.add(dynamic);
        }
        setDestructedValue(arrayList);
        if (rawValue != null) {
            overrideRawValue(rawValue);
        }
    }

    public void overrideRawValue(String newRawValue) {
        Intrinsics.checkNotNullParameter(newRawValue, "newRawValue");
        clearRange(0, getDestructedValue().size());
        replaceChars$default(this, newRawValue, 0, null, 4, null);
        this.cursorPosition = Math.min(this.cursorPosition, getValue().length());
    }

    public static /* synthetic */ void applyChangeFrom$default(BaseInputMask baseInputMask, String str, Integer num, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyChangeFrom");
        }
        if ((i & 2) != 0) {
            num = null;
        }
        baseInputMask.applyChangeFrom(str, num);
    }

    public void applyChangeFrom(String newValue, Integer position) {
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        TextDiff textDiffBuild = TextDiff.INSTANCE.build(getValue(), newValue);
        if (position != null) {
            textDiffBuild = new TextDiff(RangesKt.coerceAtLeast(position.intValue() - textDiffBuild.getAdded(), 0), textDiffBuild.getAdded(), textDiffBuild.getRemoved());
        }
        calculateCursorPosition(textDiffBuild, replaceBodyTail(textDiffBuild, newValue));
    }

    protected final int replaceBodyTail(TextDiff textDiff, String newValue) {
        Intrinsics.checkNotNullParameter(textDiff, "textDiff");
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        String strBuildBodySubstring = buildBodySubstring(textDiff, newValue);
        String strBuildTailSubstring = buildTailSubstring(textDiff);
        cleanup(textDiff);
        int firstEmptyHolderIndex = getFirstEmptyHolderIndex();
        replaceChars(strBuildBodySubstring, firstEmptyHolderIndex, strBuildTailSubstring.length() == 0 ? null : Integer.valueOf(calculateMaxShift(strBuildTailSubstring, firstEmptyHolderIndex)));
        int firstEmptyHolderIndex2 = getFirstEmptyHolderIndex();
        replaceChars$default(this, strBuildTailSubstring, firstEmptyHolderIndex2, null, 4, null);
        return firstEmptyHolderIndex2;
    }

    private final String buildBodySubstring(TextDiff textDiff, String newValue) {
        String strSubstring = newValue.substring(textDiff.getStart(), textDiff.getStart() + textDiff.getAdded());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    private final String buildTailSubstring(TextDiff textDiff) {
        return collectValueRange(textDiff.getStart() + textDiff.getRemoved(), getDestructedValue().size() - 1);
    }

    private final int calculateMaxShift(String string, int start) {
        int length;
        if (this.filters.size() <= 1) {
            int i = 0;
            while (start < getDestructedValue().size()) {
                if (getDestructedValue().get(start) instanceof MaskChar.Dynamic) {
                    i++;
                }
                start++;
            }
            length = i - string.length();
        } else {
            String strCalculateInsertableSubstring = calculateInsertableSubstring(string, start);
            int i2 = 0;
            while (i2 < getDestructedValue().size() && Intrinsics.areEqual(strCalculateInsertableSubstring, calculateInsertableSubstring(string, start + i2))) {
                i2++;
            }
            length = i2 - 1;
        }
        return RangesKt.coerceAtLeast(length, 0);
    }

    protected final void cleanup(TextDiff textDiff) {
        Intrinsics.checkNotNullParameter(textDiff, "textDiff");
        if (textDiff.getAdded() == 0 && textDiff.getRemoved() == 1) {
            for (int start = textDiff.getStart(); start >= 0; start--) {
                MaskChar maskChar = getDestructedValue().get(start);
                if (maskChar instanceof MaskChar.Dynamic) {
                    MaskChar.Dynamic dynamic = (MaskChar.Dynamic) maskChar;
                    if (dynamic.getChar() != null) {
                        dynamic.setChar(null);
                        break;
                    }
                }
            }
        }
        clearRange(textDiff.getStart(), getDestructedValue().size());
    }

    protected final void clearRange(int start, int end) {
        while (start < end && start < getDestructedValue().size()) {
            MaskChar maskChar = getDestructedValue().get(start);
            if (maskChar instanceof MaskChar.Dynamic) {
                ((MaskChar.Dynamic) maskChar).setChar(null);
            }
            start++;
        }
    }

    protected final void calculateCursorPosition(TextDiff textDiff, int tailStart) {
        Intrinsics.checkNotNullParameter(textDiff, "textDiff");
        int firstEmptyHolderIndex = getFirstEmptyHolderIndex();
        if (textDiff.getStart() < firstEmptyHolderIndex) {
            firstEmptyHolderIndex = Math.min(firstHolderAfter(tailStart), getValue().length());
        }
        this.cursorPosition = firstEmptyHolderIndex;
    }

    protected final String calculateInsertableSubstring(String substring, int start) {
        Intrinsics.checkNotNullParameter(substring, "substring");
        StringBuilder sb = new StringBuilder();
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = start;
        Function0<Regex> function0 = new Function0<Regex>() { // from class: com.yandex.div.core.util.mask.BaseInputMask$calculateInsertableSubstring$moveToAndGetNextHolderFilter$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Regex invoke() {
                while (intRef.element < this.getDestructedValue().size() && !(this.getDestructedValue().get(intRef.element) instanceof BaseInputMask.MaskChar.Dynamic)) {
                    intRef.element++;
                }
                Object orNull = CollectionsKt.getOrNull(this.getDestructedValue(), intRef.element);
                BaseInputMask.MaskChar.Dynamic dynamic = orNull instanceof BaseInputMask.MaskChar.Dynamic ? (BaseInputMask.MaskChar.Dynamic) orNull : null;
                if (dynamic != null) {
                    return dynamic.getFilter();
                }
                return null;
            }
        };
        String str = substring;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            Regex regexInvoke = function0.invoke();
            if (regexInvoke != null && regexInvoke.matches(String.valueOf(cCharAt))) {
                sb.append(cCharAt);
                intRef.element++;
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "charsCanBeInsertedStringBuilder.toString()");
        return string;
    }

    protected final String collectValueRange(int start, int end) {
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            MaskChar maskChar = getDestructedValue().get(start);
            if (maskChar instanceof MaskChar.Dynamic) {
                MaskChar.Dynamic dynamic = (MaskChar.Dynamic) maskChar;
                if (dynamic.getChar() != null) {
                    sb.append(dynamic.getChar());
                }
            }
            start++;
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "tailStringBuilder.toString()");
        return string;
    }

    public static /* synthetic */ void replaceChars$default(BaseInputMask baseInputMask, String str, int i, Integer num, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: replaceChars");
        }
        if ((i2 & 4) != 0) {
            num = null;
        }
        baseInputMask.replaceChars(str, i, num);
    }

    protected final void replaceChars(String substring, int start, Integer count) {
        Intrinsics.checkNotNullParameter(substring, "substring");
        String strCalculateInsertableSubstring = calculateInsertableSubstring(substring, start);
        if (count != null) {
            strCalculateInsertableSubstring = StringsKt.take(strCalculateInsertableSubstring, count.intValue());
        }
        int i = 0;
        while (start < getDestructedValue().size() && i < strCalculateInsertableSubstring.length()) {
            MaskChar maskChar = getDestructedValue().get(start);
            char cCharAt = strCalculateInsertableSubstring.charAt(i);
            if (maskChar instanceof MaskChar.Dynamic) {
                ((MaskChar.Dynamic) maskChar).setChar(Character.valueOf(cCharAt));
                i++;
            }
            start++;
        }
    }

    protected final int firstHolderAfter(int start) {
        while (start < getDestructedValue().size() && !(getDestructedValue().get(start) instanceof MaskChar.Dynamic)) {
            start++;
        }
        return start;
    }

    /* JADX INFO: compiled from: BaseInputMask.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/yandex/div/core/util/mask/BaseInputMask$MaskKey;", "", "key", "", "filter", "", "placeholder", "(CLjava/lang/String;C)V", "getFilter", "()Ljava/lang/String;", "getKey", "()C", "getPlaceholder", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class MaskKey {
        private final String filter;
        private final char key;
        private final char placeholder;

        public MaskKey(char c, String str, char c2) {
            this.key = c;
            this.filter = str;
            this.placeholder = c2;
        }

        public final char getKey() {
            return this.key;
        }

        public final String getFilter() {
            return this.filter;
        }

        public final char getPlaceholder() {
            return this.placeholder;
        }
    }

    /* JADX INFO: compiled from: BaseInputMask.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/yandex/div/core/util/mask/BaseInputMask$MaskData;", "", "pattern", "", "decoding", "", "Lcom/yandex/div/core/util/mask/BaseInputMask$MaskKey;", "alwaysVisible", "", "(Ljava/lang/String;Ljava/util/List;Z)V", "getAlwaysVisible", "()Z", "getDecoding", "()Ljava/util/List;", "getPattern", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class MaskData {
        private final boolean alwaysVisible;
        private final List<MaskKey> decoding;
        private final String pattern;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MaskData copy$default(MaskData maskData, String str, List list, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = maskData.pattern;
            }
            if ((i & 2) != 0) {
                list = maskData.decoding;
            }
            if ((i & 4) != 0) {
                z = maskData.alwaysVisible;
            }
            return maskData.copy(str, list, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getPattern() {
            return this.pattern;
        }

        public final List<MaskKey> component2() {
            return this.decoding;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getAlwaysVisible() {
            return this.alwaysVisible;
        }

        public final MaskData copy(String pattern, List<MaskKey> decoding, boolean alwaysVisible) {
            Intrinsics.checkNotNullParameter(pattern, "pattern");
            Intrinsics.checkNotNullParameter(decoding, "decoding");
            return new MaskData(pattern, decoding, alwaysVisible);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MaskData)) {
                return false;
            }
            MaskData maskData = (MaskData) other;
            return Intrinsics.areEqual(this.pattern, maskData.pattern) && Intrinsics.areEqual(this.decoding, maskData.decoding) && this.alwaysVisible == maskData.alwaysVisible;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v5 */
        public int hashCode() {
            int iHashCode = ((this.pattern.hashCode() * 31) + this.decoding.hashCode()) * 31;
            boolean z = this.alwaysVisible;
            ?? r1 = z;
            if (z) {
                r1 = 1;
            }
            return iHashCode + r1;
        }

        public String toString() {
            return "MaskData(pattern=" + this.pattern + ", decoding=" + this.decoding + ", alwaysVisible=" + this.alwaysVisible + ')';
        }

        public MaskData(String pattern, List<MaskKey> decoding, boolean z) {
            Intrinsics.checkNotNullParameter(pattern, "pattern");
            Intrinsics.checkNotNullParameter(decoding, "decoding");
            this.pattern = pattern;
            this.decoding = decoding;
            this.alwaysVisible = z;
        }

        public final String getPattern() {
            return this.pattern;
        }

        public final List<MaskKey> getDecoding() {
            return this.decoding;
        }

        public final boolean getAlwaysVisible() {
            return this.alwaysVisible;
        }
    }

    /* JADX INFO: compiled from: BaseInputMask.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div/core/util/mask/BaseInputMask$MaskChar;", "", "()V", "Dynamic", "Static", "Lcom/yandex/div/core/util/mask/BaseInputMask$MaskChar$Dynamic;", "Lcom/yandex/div/core/util/mask/BaseInputMask$MaskChar$Static;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static abstract class MaskChar {
        public /* synthetic */ MaskChar(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: BaseInputMask.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/yandex/div/core/util/mask/BaseInputMask$MaskChar$Static;", "Lcom/yandex/div/core/util/mask/BaseInputMask$MaskChar;", "char", "", "(C)V", "getChar", "()C", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final /* data */ class Static extends MaskChar {
            private final char char;

            public static /* synthetic */ Static copy$default(Static r0, char c, int i, Object obj) {
                if ((i & 1) != 0) {
                    c = r0.char;
                }
                return r0.copy(c);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final char getChar() {
                return this.char;
            }

            public final Static copy(char c) {
                return new Static(c);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Static) && this.char == ((Static) other).char;
            }

            public int hashCode() {
                return Character.hashCode(this.char);
            }

            public String toString() {
                return "Static(char=" + this.char + ')';
            }

            public Static(char c) {
                super(null);
                this.char = c;
            }

            public final char getChar() {
                return this.char;
            }
        }

        private MaskChar() {
        }

        /* JADX INFO: compiled from: BaseInputMask.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J0\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/yandex/div/core/util/mask/BaseInputMask$MaskChar$Dynamic;", "Lcom/yandex/div/core/util/mask/BaseInputMask$MaskChar;", "char", "", "filter", "Lkotlin/text/Regex;", "placeholder", "(Ljava/lang/Character;Lkotlin/text/Regex;C)V", "getChar", "()Ljava/lang/Character;", "setChar", "(Ljava/lang/Character;)V", "Ljava/lang/Character;", "getFilter", "()Lkotlin/text/Regex;", "getPlaceholder", "()C", "component1", "component2", "component3", "copy", "(Ljava/lang/Character;Lkotlin/text/Regex;C)Lcom/yandex/div/core/util/mask/BaseInputMask$MaskChar$Dynamic;", "equals", "", "other", "", "hashCode", "", "toString", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final /* data */ class Dynamic extends MaskChar {
            private Character char;
            private final Regex filter;
            private final char placeholder;

            public static /* synthetic */ Dynamic copy$default(Dynamic dynamic, Character ch, Regex regex, char c, int i, Object obj) {
                if ((i & 1) != 0) {
                    ch = dynamic.char;
                }
                if ((i & 2) != 0) {
                    regex = dynamic.filter;
                }
                if ((i & 4) != 0) {
                    c = dynamic.placeholder;
                }
                return dynamic.copy(ch, regex, c);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Character getChar() {
                return this.char;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Regex getFilter() {
                return this.filter;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final char getPlaceholder() {
                return this.placeholder;
            }

            public final Dynamic copy(Character ch, Regex filter, char placeholder) {
                return new Dynamic(ch, filter, placeholder);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Dynamic)) {
                    return false;
                }
                Dynamic dynamic = (Dynamic) other;
                return Intrinsics.areEqual(this.char, dynamic.char) && Intrinsics.areEqual(this.filter, dynamic.filter) && this.placeholder == dynamic.placeholder;
            }

            public int hashCode() {
                Character ch = this.char;
                int iHashCode = (ch == null ? 0 : ch.hashCode()) * 31;
                Regex regex = this.filter;
                return ((iHashCode + (regex != null ? regex.hashCode() : 0)) * 31) + Character.hashCode(this.placeholder);
            }

            public String toString() {
                return "Dynamic(char=" + this.char + ", filter=" + this.filter + ", placeholder=" + this.placeholder + ')';
            }

            public Dynamic(Character ch, Regex regex, char c) {
                super(null);
                this.char = ch;
                this.filter = regex;
                this.placeholder = c;
            }

            public final Character getChar() {
                return this.char;
            }

            public final Regex getFilter() {
                return this.filter;
            }

            public final char getPlaceholder() {
                return this.placeholder;
            }

            public final void setChar(Character ch) {
                this.char = ch;
            }
        }
    }
}
