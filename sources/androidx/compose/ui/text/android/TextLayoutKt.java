package androidx.compose.ui.text.android;

import android.graphics.Rect;
import android.text.Spanned;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import androidx.compose.ui.text.android.style.LineHeightStyleSpan;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextLayout.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0000\u001a\u0018\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0007H\u0002\u001a\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t*\u00020\u0007H\u0002¢\u0006\u0002\u0010\u000b\u001a\u0018\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0007H\u0002\"\u001a\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"EmptyPair", "Lkotlin/Pair;", "", "getTextDirectionHeuristic", "Landroid/text/TextDirectionHeuristic;", "textDirectionHeuristic", "getLineHeightPaddings", "Landroidx/compose/ui/text/android/TextLayout;", "getLineHeightSpans", "", "Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;", "(Landroidx/compose/ui/text/android/TextLayout;)[Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;", "getVerticalPaddings", "ui-text_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TextLayoutKt {
    private static final Pair<Integer, Integer> EmptyPair = new Pair<>(0, 0);

    public static final TextDirectionHeuristic getTextDirectionHeuristic(int i) {
        if (i == 0) {
            TextDirectionHeuristic LTR = TextDirectionHeuristics.LTR;
            Intrinsics.checkNotNullExpressionValue(LTR, "LTR");
            return LTR;
        }
        if (i == 1) {
            TextDirectionHeuristic RTL = TextDirectionHeuristics.RTL;
            Intrinsics.checkNotNullExpressionValue(RTL, "RTL");
            return RTL;
        }
        if (i == 2) {
            TextDirectionHeuristic FIRSTSTRONG_LTR = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            Intrinsics.checkNotNullExpressionValue(FIRSTSTRONG_LTR, "FIRSTSTRONG_LTR");
            return FIRSTSTRONG_LTR;
        }
        if (i == 3) {
            TextDirectionHeuristic FIRSTSTRONG_RTL = TextDirectionHeuristics.FIRSTSTRONG_RTL;
            Intrinsics.checkNotNullExpressionValue(FIRSTSTRONG_RTL, "FIRSTSTRONG_RTL");
            return FIRSTSTRONG_RTL;
        }
        if (i == 4) {
            TextDirectionHeuristic ANYRTL_LTR = TextDirectionHeuristics.ANYRTL_LTR;
            Intrinsics.checkNotNullExpressionValue(ANYRTL_LTR, "ANYRTL_LTR");
            return ANYRTL_LTR;
        }
        if (i == 5) {
            TextDirectionHeuristic LOCALE = TextDirectionHeuristics.LOCALE;
            Intrinsics.checkNotNullExpressionValue(LOCALE, "LOCALE");
            return LOCALE;
        }
        TextDirectionHeuristic FIRSTSTRONG_LTR2 = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        Intrinsics.checkNotNullExpressionValue(FIRSTSTRONG_LTR2, "FIRSTSTRONG_LTR");
        return FIRSTSTRONG_LTR2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair<Integer, Integer> getVerticalPaddings(TextLayout textLayout) {
        int topPadding;
        int bottomPadding;
        if (textLayout.getIncludePadding() || textLayout.isFallbackLinespacingApplied$ui_text_release()) {
            return new Pair<>(0, 0);
        }
        TextPaint paint = textLayout.getLayout().getPaint();
        CharSequence text = textLayout.getLayout().getText();
        Intrinsics.checkNotNullExpressionValue(paint, "paint");
        Intrinsics.checkNotNullExpressionValue(text, "text");
        Rect charSequenceBounds = PaintExtensionsKt.getCharSequenceBounds(paint, text, textLayout.getLayout().getLineStart(0), textLayout.getLayout().getLineEnd(0));
        int lineAscent = textLayout.getLayout().getLineAscent(0);
        if (charSequenceBounds.top < lineAscent) {
            topPadding = lineAscent - charSequenceBounds.top;
        } else {
            topPadding = textLayout.getLayout().getTopPadding();
        }
        if (textLayout.getLineCount() != 1) {
            int lineCount = textLayout.getLayout().getLineCount() - 1;
            charSequenceBounds = PaintExtensionsKt.getCharSequenceBounds(paint, text, textLayout.getLayout().getLineStart(lineCount), textLayout.getLayout().getLineEnd(lineCount));
        }
        int lineDescent = textLayout.getLayout().getLineDescent(textLayout.getLayout().getLineCount() - 1);
        if (charSequenceBounds.bottom > lineDescent) {
            bottomPadding = charSequenceBounds.bottom - lineDescent;
        } else {
            bottomPadding = textLayout.getLayout().getBottomPadding();
        }
        if (topPadding == 0 && bottomPadding == 0) {
            return EmptyPair;
        }
        return new Pair<>(Integer.valueOf(topPadding), Integer.valueOf(bottomPadding));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair<Integer, Integer> getLineHeightPaddings(TextLayout textLayout) {
        int iMax = 0;
        int iMax2 = 0;
        for (LineHeightStyleSpan lineHeightStyleSpan : getLineHeightSpans(textLayout)) {
            if (lineHeightStyleSpan.getFirstAscentDiff() < 0) {
                iMax = Math.max(iMax, Math.abs(lineHeightStyleSpan.getFirstAscentDiff()));
            }
            if (lineHeightStyleSpan.getLastDescentDiff() < 0) {
                iMax2 = Math.max(iMax, Math.abs(lineHeightStyleSpan.getLastDescentDiff()));
            }
        }
        if (iMax == 0 && iMax2 == 0) {
            return EmptyPair;
        }
        return new Pair<>(Integer.valueOf(iMax), Integer.valueOf(iMax2));
    }

    private static final LineHeightStyleSpan[] getLineHeightSpans(TextLayout textLayout) {
        if (textLayout.getText() instanceof Spanned) {
            LineHeightStyleSpan[] lineHeightStyleSpans = (LineHeightStyleSpan[]) ((Spanned) textLayout.getText()).getSpans(0, textLayout.getText().length(), LineHeightStyleSpan.class);
            Intrinsics.checkNotNullExpressionValue(lineHeightStyleSpans, "lineHeightStyleSpans");
            return lineHeightStyleSpans.length == 0 ? new LineHeightStyleSpan[0] : lineHeightStyleSpans;
        }
        return new LineHeightStyleSpan[0];
    }
}
