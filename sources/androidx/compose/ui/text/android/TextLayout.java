package androidx.compose.ui.text.android;

import android.graphics.Canvas;
import android.graphics.Path;
import android.os.Build;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.compose.ui.text.android.style.BaselineShiftSpan;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextLayout.kt */
/* JADX INFO: loaded from: classes11.dex */
@InternalPlatformTextApi
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B±\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\t\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a¢\u0006\u0002\u0010\u001bJ&\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\t2\u0006\u0010F\u001a\u00020\t2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\tJ\u000e\u0010J\u001a\u00020\u00052\u0006\u0010K\u001a\u00020\tJ\u000e\u0010L\u001a\u00020\u00052\u0006\u0010K\u001a\u00020\tJ\u000e\u0010M\u001a\u00020\u00052\u0006\u0010K\u001a\u00020\tJ\u000e\u0010N\u001a\u00020\u00052\u0006\u0010K\u001a\u00020\tJ\u000e\u0010O\u001a\u00020\t2\u0006\u0010P\u001a\u00020\tJ\u000e\u0010Q\u001a\u00020\t2\u0006\u0010P\u001a\u00020\tJ\u000e\u0010R\u001a\u00020\t2\u0006\u0010P\u001a\u00020\tJ\u000e\u0010S\u001a\u00020\t2\u0006\u0010T\u001a\u00020\tJ\u000e\u0010U\u001a\u00020\t2\u0006\u0010V\u001a\u00020\tJ\u000e\u0010W\u001a\u00020\u00052\u0006\u0010P\u001a\u00020\tJ\u000e\u0010X\u001a\u00020\u00052\u0006\u0010P\u001a\u00020\tJ\u000e\u0010Y\u001a\u00020\u00052\u0006\u0010P\u001a\u00020\tJ\u000e\u0010Z\u001a\u00020\t2\u0006\u0010P\u001a\u00020\tJ\u000e\u0010[\u001a\u00020\u00052\u0006\u0010K\u001a\u00020\tJ\u000e\u0010\\\u001a\u00020\t2\u0006\u0010P\u001a\u00020\tJ\u000e\u0010]\u001a\u00020\u00052\u0006\u0010P\u001a\u00020\tJ\u0016\u0010^\u001a\u00020\t2\u0006\u0010K\u001a\u00020\t2\u0006\u0010_\u001a\u00020\u0005J\u000e\u0010`\u001a\u00020\t2\u0006\u0010K\u001a\u00020\tJ\u0018\u0010a\u001a\u00020\u00052\u0006\u0010T\u001a\u00020\t2\b\b\u0002\u0010b\u001a\u00020\u0010J\u0018\u0010c\u001a\u00020\u00052\u0006\u0010T\u001a\u00020\t2\b\b\u0002\u0010b\u001a\u00020\u0010J\u001e\u0010d\u001a\u00020D2\u0006\u0010e\u001a\u00020\t2\u0006\u0010f\u001a\u00020\t2\u0006\u0010g\u001a\u00020hJ\u000e\u0010i\u001a\u00020\u00102\u0006\u0010P\u001a\u00020\tJ\r\u0010j\u001a\u00020\u0010H\u0000¢\u0006\u0002\bkJ\u000e\u0010l\u001a\u00020\u00102\u0006\u0010P\u001a\u00020\tJ\u000e\u0010m\u001a\u00020\u00102\u0006\u0010T\u001a\u00020\tJ\u000e\u0010n\u001a\u00020D2\u0006\u0010o\u001a\u00020pR\u001c\u0010\u001c\u001a\u00020\t8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0011\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0011\u0010%\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b&\u0010 R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b'\u0010#R\u000e\u0010(\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010)\u001a\u00020*8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u001e\u001a\u0004\b,\u0010-R\u001b\u0010.\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b0\u00101R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0011\u00106\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b7\u0010 R\u0011\u00108\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0011\u0010;\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b<\u0010:R\u0011\u0010=\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b>\u0010?R\u001c\u0010@\u001a\u00020\t8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bA\u0010\u001e\u001a\u0004\bB\u0010 ¨\u0006q"}, d2 = {"Landroidx/compose/ui/text/android/TextLayout;", "", "charSequence", "", "width", "", "textPaint", "Landroid/text/TextPaint;", "alignment", "", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "textDirectionHeuristic", "lineSpacingMultiplier", "lineSpacingExtra", "includePadding", "", "fallbackLineSpacing", "maxLines", "breakStrategy", "hyphenationFrequency", "justificationMode", "leftIndents", "", "rightIndents", "layoutIntrinsics", "Landroidx/compose/ui/text/android/LayoutIntrinsics;", "(Ljava/lang/CharSequence;FLandroid/text/TextPaint;ILandroid/text/TextUtils$TruncateAt;IFFZZIIII[I[ILandroidx/compose/ui/text/android/LayoutIntrinsics;)V", "bottomPadding", "getBottomPadding$ui_text_release$annotations", "()V", "getBottomPadding$ui_text_release", "()I", "didExceedMaxLines", "getDidExceedMaxLines", "()Z", "getFallbackLineSpacing", "height", "getHeight", "getIncludePadding", "isBoringLayout", "layout", "Landroid/text/Layout;", "getLayout$annotations", "getLayout", "()Landroid/text/Layout;", "layoutHelper", "Landroidx/compose/ui/text/android/LayoutHelper;", "getLayoutHelper", "()Landroidx/compose/ui/text/android/LayoutHelper;", "layoutHelper$delegate", "Lkotlin/Lazy;", "getLayoutIntrinsics", "()Landroidx/compose/ui/text/android/LayoutIntrinsics;", "lineCount", "getLineCount", "maxIntrinsicWidth", "getMaxIntrinsicWidth", "()F", "minIntrinsicWidth", "getMinIntrinsicWidth", "text", "getText", "()Ljava/lang/CharSequence;", "topPadding", "getTopPadding$ui_text_release$annotations", "getTopPadding$ui_text_release", "fillBoundingBoxes", "", "startOffset", "endOffset", "array", "", "arrayStart", "getLineAscent", "line", "getLineBaseline", "getLineBottom", "getLineDescent", "getLineEllipsisCount", "lineIndex", "getLineEllipsisOffset", "getLineEnd", "getLineForOffset", "offset", "getLineForVertical", "vertical", "getLineHeight", "getLineLeft", "getLineRight", "getLineStart", "getLineTop", "getLineVisibleEnd", "getLineWidth", "getOffsetForHorizontal", "horizontal", "getParagraphDirection", "getPrimaryHorizontal", "upstream", "getSecondaryHorizontal", "getSelectionPath", "start", "end", "dest", "Landroid/graphics/Path;", "isEllipsisApplied", "isFallbackLinespacingApplied", "isFallbackLinespacingApplied$ui_text_release", "isLineEllipsized", "isRtlCharAt", "paint", "canvas", "Landroid/graphics/Canvas;", "ui-text_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TextLayout {
    private final int bottomPadding;
    private final boolean didExceedMaxLines;
    private final boolean fallbackLineSpacing;
    private final boolean includePadding;
    private final boolean isBoringLayout;
    private final Layout layout;

    /* JADX INFO: renamed from: layoutHelper$delegate, reason: from kotlin metadata */
    private final Lazy layoutHelper;
    private final LayoutIntrinsics layoutIntrinsics;
    private final int lineCount;
    private final int topPadding;

    public static /* synthetic */ void getBottomPadding$ui_text_release$annotations() {
    }

    public static /* synthetic */ void getLayout$annotations() {
    }

    public static /* synthetic */ void getTopPadding$ui_text_release$annotations() {
    }

    public TextLayout(CharSequence charSequence, float f, TextPaint textPaint, int i, TextUtils.TruncateAt truncateAt, int i2, float f2, float f3, boolean z, boolean z2, int i3, int i4, int i5, int i6, int[] iArr, int[] iArr2, LayoutIntrinsics layoutIntrinsics) {
        boolean z3;
        StaticLayout staticLayoutCreate;
        Intrinsics.checkNotNullParameter(charSequence, "charSequence");
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        Intrinsics.checkNotNullParameter(layoutIntrinsics, "layoutIntrinsics");
        this.includePadding = z;
        this.fallbackLineSpacing = z2;
        this.layoutIntrinsics = layoutIntrinsics;
        int length = charSequence.length();
        TextDirectionHeuristic textDirectionHeuristic = TextLayoutKt.getTextDirectionHeuristic(i2);
        Layout.Alignment alignment = TextAlignmentAdapter.INSTANCE.get(i);
        boolean z4 = (charSequence instanceof Spanned) && ((Spanned) charSequence).nextSpanTransition(-1, length, BaselineShiftSpan.class) < length;
        BoringLayout.Metrics boringMetrics = layoutIntrinsics.getBoringMetrics();
        double d = f;
        int iCeil = (int) Math.ceil(d);
        if (boringMetrics != null && layoutIntrinsics.getMaxIntrinsicWidth() <= f && !z4) {
            this.isBoringLayout = true;
            staticLayoutCreate = BoringLayoutFactory.INSTANCE.create(charSequence, textPaint, iCeil, boringMetrics, alignment, z, truncateAt, iCeil);
            z3 = false;
        } else {
            this.isBoringLayout = false;
            z3 = false;
            staticLayoutCreate = StaticLayoutFactory.INSTANCE.create(charSequence, 0, charSequence.length(), textPaint, iCeil, textDirectionHeuristic, alignment, i3, truncateAt, (int) Math.ceil(d), f2, f3, i6, z, z2, i4, i5, iArr, iArr2);
        }
        this.layout = staticLayoutCreate;
        int iMin = Math.min(staticLayoutCreate.getLineCount(), i3);
        this.lineCount = iMin;
        this.didExceedMaxLines = (iMin >= i3 && (staticLayoutCreate.getEllipsisCount(iMin + (-1)) > 0 || staticLayoutCreate.getLineEnd(iMin + (-1)) != charSequence.length())) ? true : z3;
        Pair verticalPaddings = TextLayoutKt.getVerticalPaddings(this);
        Pair lineHeightPaddings = TextLayoutKt.getLineHeightPaddings(this);
        this.topPadding = Math.max(((Number) verticalPaddings.getFirst()).intValue(), ((Number) lineHeightPaddings.getFirst()).intValue());
        this.bottomPadding = Math.max(((Number) verticalPaddings.getSecond()).intValue(), ((Number) lineHeightPaddings.getSecond()).intValue());
        this.layoutHelper = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<LayoutHelper>() { // from class: androidx.compose.ui.text.android.TextLayout$layoutHelper$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LayoutHelper invoke() {
                return new LayoutHelper(this.this$0.getLayout());
            }
        });
    }

    public final boolean getIncludePadding() {
        return this.includePadding;
    }

    public final boolean getFallbackLineSpacing() {
        return this.fallbackLineSpacing;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ TextLayout(CharSequence charSequence, float f, TextPaint textPaint, int i, TextUtils.TruncateAt truncateAt, int i2, float f2, float f3, boolean z, boolean z2, int i3, int i4, int i5, int i6, int[] iArr, int[] iArr2, LayoutIntrinsics layoutIntrinsics, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        float f4 = (i7 & 2) != 0 ? 0.0f : f;
        int i8 = (i7 & 8) != 0 ? 0 : i;
        TextUtils.TruncateAt truncateAt2 = (i7 & 16) != 0 ? null : truncateAt;
        int i9 = (i7 & 32) != 0 ? 2 : i2;
        this(charSequence, f4, textPaint, i8, truncateAt2, i9, (i7 & 64) != 0 ? 1.0f : f2, (i7 & 128) != 0 ? 0.0f : f3, (i7 & 256) != 0 ? false : z, (i7 & 512) != 0 ? true : z2, (i7 & 1024) != 0 ? Integer.MAX_VALUE : i3, (i7 & 2048) != 0 ? 0 : i4, (i7 & 4096) != 0 ? 0 : i5, (i7 & 8192) != 0 ? 0 : i6, (i7 & 16384) != 0 ? null : iArr, (32768 & i7) != 0 ? null : iArr2, (i7 & 65536) != 0 ? new LayoutIntrinsics(charSequence, textPaint, i9) : layoutIntrinsics);
    }

    public final LayoutIntrinsics getLayoutIntrinsics() {
        return this.layoutIntrinsics;
    }

    public final float getMaxIntrinsicWidth() {
        return this.layoutIntrinsics.getMaxIntrinsicWidth();
    }

    public final float getMinIntrinsicWidth() {
        return this.layoutIntrinsics.getMinIntrinsicWidth();
    }

    public final boolean getDidExceedMaxLines() {
        return this.didExceedMaxLines;
    }

    public final Layout getLayout() {
        return this.layout;
    }

    public final int getLineCount() {
        return this.lineCount;
    }

    /* JADX INFO: renamed from: getTopPadding$ui_text_release, reason: from getter */
    public final int getTopPadding() {
        return this.topPadding;
    }

    /* JADX INFO: renamed from: getBottomPadding$ui_text_release, reason: from getter */
    public final int getBottomPadding() {
        return this.bottomPadding;
    }

    private final LayoutHelper getLayoutHelper() {
        return (LayoutHelper) this.layoutHelper.getValue();
    }

    public final CharSequence getText() {
        CharSequence text = this.layout.getText();
        Intrinsics.checkNotNullExpressionValue(text, "layout.text");
        return text;
    }

    public final int getHeight() {
        int height;
        if (this.didExceedMaxLines) {
            height = this.layout.getLineBottom(this.lineCount - 1);
        } else {
            height = this.layout.getHeight();
        }
        return height + this.topPadding + this.bottomPadding;
    }

    public final float getLineLeft(int lineIndex) {
        return this.layout.getLineLeft(lineIndex);
    }

    public final float getLineRight(int lineIndex) {
        return this.layout.getLineRight(lineIndex);
    }

    public final float getLineTop(int line) {
        return this.layout.getLineTop(line) + (line == 0 ? 0 : this.topPadding);
    }

    public final float getLineBottom(int line) {
        return this.topPadding + this.layout.getLineBottom(line) + (line == this.lineCount + (-1) ? this.bottomPadding : 0);
    }

    public final float getLineAscent(int line) {
        return this.layout.getLineAscent(line);
    }

    public final float getLineBaseline(int line) {
        return this.topPadding + this.layout.getLineBaseline(line);
    }

    public final float getLineDescent(int line) {
        return this.layout.getLineDescent(line);
    }

    public final float getLineHeight(int lineIndex) {
        return getLineBottom(lineIndex) - getLineTop(lineIndex);
    }

    public final float getLineWidth(int lineIndex) {
        return this.layout.getLineWidth(lineIndex);
    }

    public final int getLineStart(int lineIndex) {
        return this.layout.getLineStart(lineIndex);
    }

    public final int getLineEnd(int lineIndex) {
        if (this.layout.getEllipsisStart(lineIndex) == 0) {
            return this.layout.getLineEnd(lineIndex);
        }
        return this.layout.getText().length();
    }

    public final int getLineVisibleEnd(int lineIndex) {
        if (this.layout.getEllipsisStart(lineIndex) == 0) {
            return this.layout.getLineVisibleEnd(lineIndex);
        }
        return this.layout.getEllipsisStart(lineIndex) + this.layout.getLineStart(lineIndex);
    }

    public final boolean isLineEllipsized(int lineIndex) {
        return this.layout.getEllipsisStart(lineIndex) != 0;
    }

    public final int getLineEllipsisOffset(int lineIndex) {
        return this.layout.getEllipsisStart(lineIndex);
    }

    public final int getLineEllipsisCount(int lineIndex) {
        return this.layout.getEllipsisCount(lineIndex);
    }

    public final int getLineForVertical(int vertical) {
        return this.layout.getLineForVertical(this.topPadding + vertical);
    }

    public final int getOffsetForHorizontal(int line, float horizontal) {
        return this.layout.getOffsetForHorizontal(line, horizontal);
    }

    public static /* synthetic */ float getPrimaryHorizontal$default(TextLayout textLayout, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return textLayout.getPrimaryHorizontal(i, z);
    }

    public final float getPrimaryHorizontal(int offset, boolean upstream) {
        return getLayoutHelper().getHorizontalPosition(offset, true, upstream);
    }

    public static /* synthetic */ float getSecondaryHorizontal$default(TextLayout textLayout, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return textLayout.getSecondaryHorizontal(i, z);
    }

    public final float getSecondaryHorizontal(int offset, boolean upstream) {
        return getLayoutHelper().getHorizontalPosition(offset, false, upstream);
    }

    public final int getLineForOffset(int offset) {
        return this.layout.getLineForOffset(offset);
    }

    public final boolean isRtlCharAt(int offset) {
        return this.layout.isRtlCharAt(offset);
    }

    public final int getParagraphDirection(int line) {
        return this.layout.getParagraphDirection(line);
    }

    public final void getSelectionPath(int start, int end, Path dest) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        this.layout.getSelectionPath(start, end, dest);
        if (this.topPadding == 0 || dest.isEmpty()) {
            return;
        }
        dest.offset(0.0f, this.topPadding);
    }

    public final boolean isEllipsisApplied(int lineIndex) {
        return this.layout.getEllipsisCount(lineIndex) > 0;
    }

    public final void fillBoundingBoxes(int startOffset, int endOffset, float[] array, int arrayStart) {
        float secondaryDownstream;
        float secondaryUpstream;
        Intrinsics.checkNotNullParameter(array, "array");
        int length = getText().length();
        if (startOffset < 0) {
            throw new IllegalArgumentException("startOffset must be > 0".toString());
        }
        if (startOffset >= length) {
            throw new IllegalArgumentException("startOffset must be less than text length".toString());
        }
        if (endOffset <= startOffset) {
            throw new IllegalArgumentException("endOffset must be greater than startOffset".toString());
        }
        if (endOffset > length) {
            throw new IllegalArgumentException("endOffset must be smaller or equal to text length".toString());
        }
        if (array.length - arrayStart < (endOffset - startOffset) * 4) {
            throw new IllegalArgumentException("array.size - arrayStart must be greater or equal than (endOffset - startOffset) * 4".toString());
        }
        int lineForOffset = getLineForOffset(startOffset);
        int lineForOffset2 = getLineForOffset(endOffset - 1);
        HorizontalPositionCache horizontalPositionCache = new HorizontalPositionCache(this);
        if (lineForOffset > lineForOffset2) {
            return;
        }
        while (true) {
            int lineStart = getLineStart(lineForOffset);
            int lineEnd = getLineEnd(lineForOffset);
            int iMin = Math.min(endOffset, lineEnd);
            float lineTop = getLineTop(lineForOffset);
            float lineBottom = getLineBottom(lineForOffset);
            boolean z = getParagraphDirection(lineForOffset) == 1;
            for (int iMax = Math.max(startOffset, lineStart); iMax < iMin; iMax++) {
                boolean zIsRtlCharAt = isRtlCharAt(iMax);
                if (z && !zIsRtlCharAt) {
                    secondaryDownstream = horizontalPositionCache.getPrimaryDownstream(iMax);
                    secondaryUpstream = horizontalPositionCache.getPrimaryUpstream(iMax + 1);
                } else if (z && zIsRtlCharAt) {
                    secondaryUpstream = horizontalPositionCache.getSecondaryDownstream(iMax);
                    secondaryDownstream = horizontalPositionCache.getSecondaryUpstream(iMax + 1);
                } else if (!z && zIsRtlCharAt) {
                    secondaryUpstream = horizontalPositionCache.getPrimaryDownstream(iMax);
                    secondaryDownstream = horizontalPositionCache.getPrimaryUpstream(iMax + 1);
                } else {
                    secondaryDownstream = horizontalPositionCache.getSecondaryDownstream(iMax);
                    secondaryUpstream = horizontalPositionCache.getSecondaryUpstream(iMax + 1);
                }
                array[arrayStart] = secondaryDownstream;
                array[arrayStart + 1] = lineTop;
                array[arrayStart + 2] = secondaryUpstream;
                array[arrayStart + 3] = lineBottom;
                arrayStart += 4;
            }
            if (lineForOffset == lineForOffset2) {
                return;
            } else {
                lineForOffset++;
            }
        }
    }

    public final void paint(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int i = this.topPadding;
        if (i != 0) {
            canvas.translate(0.0f, i);
        }
        this.layout.draw(canvas);
        int i2 = this.topPadding;
        if (i2 != 0) {
            canvas.translate(0.0f, (-1) * i2);
        }
    }

    public final boolean isFallbackLinespacingApplied$ui_text_release() {
        return this.fallbackLineSpacing && !this.isBoringLayout && Build.VERSION.SDK_INT >= 28;
    }
}
