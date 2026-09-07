package com.yandex.div.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.yandex.div.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EllipsizedTextView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\r\n\u0002\b\u001c\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 V2\u00020\u0001:\u0001VB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010/\u001a\u00020\u0007H\u0004J\u0018\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0017H\u0002J\u0014\u00102\u001a\u0004\u0018\u00010\u00172\b\u00101\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u00020\u0017H\u0016J\b\u00106\u001a\u000204H\u0002J\u001a\u00107\u001a\u0002082\u0006\u00101\u001a\u00020\u00172\b\b\u0002\u00109\u001a\u00020\u0007H\u0002J\u001a\u0010:\u001a\u0002082\u0006\u00101\u001a\u00020\u00172\b\b\u0002\u00109\u001a\u00020\u0007H\u0003J\b\u0010;\u001a\u00020\nH\u0002J\b\u0010<\u001a\u000204H\u0014J\b\u0010=\u001a\u000204H\u0014J\u0010\u0010>\u001a\u0002042\u0006\u0010\u001c\u001a\u00020\u0017H\u0002J\u0018\u0010?\u001a\u0002042\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0007H\u0014J(\u0010B\u001a\u0002042\u0006\u0010C\u001a\u00020\u00072\u0006\u0010D\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\u00072\u0006\u0010F\u001a\u00020\u0007H\u0014J*\u0010G\u001a\u0002042\b\u00101\u001a\u0004\u0018\u00010\u00172\u0006\u0010H\u001a\u00020\u00072\u0006\u0010I\u001a\u00020\u00072\u0006\u0010J\u001a\u00020\u0007H\u0014J\b\u0010K\u001a\u000204H\u0002J\u0012\u0010L\u001a\u0002042\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J\u0010\u0010O\u001a\u0002042\u0006\u0010P\u001a\u00020\u0007H\u0016J\u001c\u0010Q\u001a\u0002042\b\u00101\u001a\u0004\u0018\u00010\u00172\b\u0010R\u001a\u0004\u0018\u00010SH\u0016J\u0012\u0010T\u001a\u0002042\b\u00101\u001a\u0004\u0018\u00010\u0017H\u0002J(\u0010U\u001a\u0002042\u0006\u0010C\u001a\u00020\u00072\u0006\u0010D\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\u00072\u0006\u0010F\u001a\u00020\u0007H\u0002R$\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006@BX\u0087\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u001bR$\u0010\u001c\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\u0017@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001b\"\u0004\b\u001e\u0010\u001fR0\u0010 \u001a\u0004\u0018\u00010\u00172\b\u0010\t\u001a\u0004\u0018\u00010\u00178\u0006@BX\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b!\u0010\u0013\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001fR\u000e\u0010$\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u00020\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\r\"\u0004\b&\u0010\u000fR\u000e\u0010'\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Lcom/yandex/div/internal/widget/EllipsizedTextView;", "Lcom/yandex/div/internal/widget/SuperLineHeightTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "", "autoEllipsize", "getAutoEllipsize", "()Z", "setAutoEllipsize", "(Z)V", "autoEllipsizeHelper", "Lcom/yandex/div/internal/widget/AutoEllipsizeHelper;", "getAutoEllipsizeHelper$annotations", "()V", "cachedEllipsisWidth", "", "<set-?>", "", "displayText", "getDisplayText$annotations", "getDisplayText", "()Ljava/lang/CharSequence;", "ellipsis", "getEllipsis", "setEllipsis", "(Ljava/lang/CharSequence;)V", "ellipsizedText", "getEllipsizedText$annotations", "getEllipsizedText", "setEllipsizedText", "isEllipsizeRequested", "isInternalTextChange", "setInternalTextChange", "isRemeasureNeeded", "lastMeasuredHeight", "getLastMeasuredHeight", "()I", "setLastMeasuredHeight", "(I)V", "lastMeasuredWidth", "originalText", "availableWidth", "calculateFittedSymbols", "text", "ellipsize", "ellipsizeIfNeeded", "", "getText", "invalidateEllipsis", "layoutText", "Landroid/text/Layout;", "textWidth", "layoutTextWithHyphenation", "noMaxLines", "onAttachedToWindow", "onDetachedFromWindow", "onEllipsisChanged", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "width", "height", "oldWidth", "oldHeight", "onTextChanged", "start", "lengthBefore", "lengthAfter", "requestEllipsize", "setEllipsize", "where", "Landroid/text/TextUtils$TruncateAt;", "setMaxLines", "maxLines", "setText", "type", "Landroid/widget/TextView$BufferType;", "setTextInternal", "sizeChangeInternal", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class EllipsizedTextView extends SuperLineHeightTextView {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final boolean DEBUG = false;
    public static final String DEFAULT_ELLIPSIS = "…";
    private static final float ELLIPSIS_WIDTH_UNKNOWN = -1.0f;
    public static final int NOT_SET = -1;
    private static final String TAG = "Ya:EllipsizedTextView";
    private boolean autoEllipsize;
    private final AutoEllipsizeHelper autoEllipsizeHelper;
    private float cachedEllipsisWidth;
    private CharSequence displayText;
    private CharSequence ellipsis;
    private CharSequence ellipsizedText;
    private boolean isEllipsizeRequested;
    private boolean isInternalTextChange;
    private boolean isRemeasureNeeded;
    private int lastMeasuredHeight;
    private int lastMeasuredWidth;
    private CharSequence originalText;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EllipsizedTextView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EllipsizedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private static /* synthetic */ void getAutoEllipsizeHelper$annotations() {
    }

    public static /* synthetic */ void getDisplayText$annotations() {
    }

    public static /* synthetic */ void getEllipsizedText$annotations() {
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt where) {
    }

    public /* synthetic */ EllipsizedTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EllipsizedTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.ellipsis = DEFAULT_ELLIPSIS;
        this.lastMeasuredWidth = -1;
        this.lastMeasuredHeight = -1;
        this.cachedEllipsisWidth = -1.0f;
        this.autoEllipsizeHelper = new AutoEllipsizeHelper(this);
        if (isInEditMode()) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EllipsizedTextView, i, 0);
            Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…extView, defStyleAttr, 0)");
            try {
                CharSequence text = typedArrayObtainStyledAttributes.getText(R.styleable.EllipsizedTextView_ellipsis);
                setEllipsis(text == null ? DEFAULT_ELLIPSIS : text);
                typedArrayObtainStyledAttributes.recycle();
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        }
        onEllipsisChanged(this.ellipsis);
    }

    public final CharSequence getEllipsis() {
        return this.ellipsis;
    }

    public final void setEllipsis(CharSequence value) {
        Intrinsics.checkNotNullParameter(value, "value");
        onEllipsisChanged(value);
        this.ellipsis = value;
    }

    public final boolean getAutoEllipsize() {
        return this.autoEllipsize;
    }

    public final void setAutoEllipsize(boolean z) {
        this.autoEllipsize = z;
        this.autoEllipsizeHelper.setEnabled(z);
    }

    public final CharSequence getEllipsizedText() {
        return this.ellipsizedText;
    }

    private final void setEllipsizedText(CharSequence charSequence) {
        this.ellipsizedText = charSequence;
        setTextInternal(charSequence);
    }

    public final CharSequence getDisplayText() {
        return this.displayText;
    }

    /* JADX INFO: renamed from: isInternalTextChange, reason: from getter */
    protected final boolean getIsInternalTextChange() {
        return this.isInternalTextChange;
    }

    protected final void setInternalTextChange(boolean z) {
        this.isInternalTextChange = z;
    }

    protected final int getLastMeasuredHeight() {
        return this.lastMeasuredHeight;
    }

    protected final void setLastMeasuredHeight(int i) {
        this.lastMeasuredHeight = i;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.autoEllipsizeHelper.onViewAttachedToWindow();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.autoEllipsizeHelper.onViewDetachedFromWindow();
    }

    private final void onEllipsisChanged(CharSequence ellipsis) {
        if (noMaxLines()) {
            super.setEllipsize(null);
        } else if (Intrinsics.areEqual(ellipsis, DEFAULT_ELLIPSIS)) {
            super.setEllipsize(TextUtils.TruncateAt.END);
        } else {
            super.setEllipsize(null);
            requestEllipsize();
            invalidateEllipsis();
        }
        requestLayout();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public CharSequence getText() {
        CharSequence charSequence = this.originalText;
        return charSequence == null ? "" : charSequence;
    }

    private final void setTextInternal(CharSequence text) {
        this.isInternalTextChange = true;
        super.setText(text);
        this.isInternalTextChange = false;
    }

    @Override // android.widget.TextView
    public void setText(CharSequence text, TextView.BufferType type) {
        this.displayText = text;
        super.setText(text, type);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int maxLines) {
        if (maxLines == getMaxLines()) {
            return;
        }
        super.setMaxLines(maxLines);
        onEllipsisChanged(this.ellipsis);
        requestEllipsize();
        invalidateEllipsis();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        if (this.isInternalTextChange) {
            return;
        }
        this.originalText = text;
        requestLayout();
        requestEllipsize();
    }

    @Override // com.yandex.div.internal.widget.SuperLineHeightTextView, androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        sizeChangeInternal(getMeasuredWidth(), getMeasuredHeight(), this.lastMeasuredWidth, this.lastMeasuredHeight);
        if (this.isEllipsizeRequested) {
            ellipsizeIfNeeded();
            CharSequence charSequence = this.ellipsizedText;
            if (charSequence != null) {
                if (!this.isRemeasureNeeded) {
                    charSequence = null;
                }
                if (charSequence != null) {
                    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                }
            }
        }
        this.lastMeasuredWidth = getMeasuredWidth();
    }

    @Override // android.view.View
    protected void onSizeChanged(int width, int height, int oldWidth, int oldHeight) {
        super.onSizeChanged(width, height, oldWidth, oldHeight);
        sizeChangeInternal(width, height, oldWidth, oldHeight);
    }

    private final void sizeChangeInternal(int width, int height, int oldWidth, int oldHeight) {
        if (width == oldWidth && height == oldHeight) {
            return;
        }
        requestEllipsize();
    }

    private final void requestEllipsize() {
        this.isEllipsizeRequested = true;
    }

    private final void invalidateEllipsis() {
        this.cachedEllipsisWidth = -1.0f;
        this.isRemeasureNeeded = false;
    }

    private final void ellipsizeIfNeeded() {
        CharSequence charSequence = this.ellipsizedText;
        boolean z = noMaxLines() || Intrinsics.areEqual(this.ellipsis, DEFAULT_ELLIPSIS);
        if (this.ellipsizedText != null || !z) {
            if (z) {
                CharSequence charSequence2 = this.originalText;
                if (charSequence2 != null) {
                    this.isRemeasureNeeded = !Intrinsics.areEqual(charSequence2, charSequence);
                } else {
                    charSequence2 = null;
                }
                setEllipsizedText(charSequence2);
            } else {
                setEllipsizedText(ellipsize(this.originalText));
            }
        }
        this.isEllipsizeRequested = false;
    }

    private final boolean noMaxLines() {
        return getMaxLines() < 0 || getMaxLines() == Integer.MAX_VALUE;
    }

    private final CharSequence ellipsize(CharSequence text) {
        CharSequence charSequence;
        int iCalculateFittedSymbols;
        if (text == null || text.length() == 0 || (iCalculateFittedSymbols = calculateFittedSymbols(text, (charSequence = this.ellipsis))) <= 0) {
            return null;
        }
        if (iCalculateFittedSymbols == text.length()) {
            return text;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text, 0, iCalculateFittedSymbols);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private final int calculateFittedSymbols(CharSequence text, CharSequence ellipsis) {
        int iAvailableWidth;
        Layout layoutLayoutText;
        if (text.length() == 0 || getMaxLines() == 0 || (iAvailableWidth = availableWidth()) <= 0) {
            return 0;
        }
        if (TextViewsKt.isHyphenationEnabled(this)) {
            layoutLayoutText = layoutTextWithHyphenation(text, iAvailableWidth);
        } else {
            layoutLayoutText = layoutText(text, iAvailableWidth);
        }
        int lineCount = layoutLayoutText.getLineCount();
        float lineWidth = layoutLayoutText.getLineWidth(lineCount - 1);
        if (lineCount < getMaxLines() || (lineCount == getMaxLines() && lineWidth <= iAvailableWidth)) {
            this.isRemeasureNeeded = true;
            return text.length();
        }
        if (this.cachedEllipsisWidth == -1.0f) {
            this.cachedEllipsisWidth = layoutText$default(this, ellipsis, 0, 2, null).getLineWidth(0);
        }
        this.isRemeasureNeeded = true;
        float f = iAvailableWidth - this.cachedEllipsisWidth;
        int offsetForHorizontal = layoutLayoutText.getOffsetForHorizontal(getMaxLines() - 1, f);
        while (layoutLayoutText.getPrimaryHorizontal(offsetForHorizontal) > f && offsetForHorizontal > 0) {
            offsetForHorizontal--;
        }
        return (offsetForHorizontal <= 0 || !Character.isHighSurrogate(text.charAt(offsetForHorizontal + (-1)))) ? offsetForHorizontal : offsetForHorizontal - 1;
    }

    protected final int availableWidth() {
        return (getMeasuredWidth() - getCompoundPaddingLeft()) - getCompoundPaddingRight();
    }

    static /* synthetic */ Layout layoutText$default(EllipsizedTextView ellipsizedTextView, CharSequence charSequence, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: layoutText");
        }
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        return ellipsizedTextView.layoutText(charSequence, i);
    }

    private final Layout layoutText(CharSequence text, int textWidth) {
        return new StaticLayout(text, getPaint(), textWidth, Layout.Alignment.ALIGN_NORMAL, getLineSpacingMultiplier(), getLineSpacingExtra(), true);
    }

    static /* synthetic */ Layout layoutTextWithHyphenation$default(EllipsizedTextView ellipsizedTextView, CharSequence charSequence, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: layoutTextWithHyphenation");
        }
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        return ellipsizedTextView.layoutTextWithHyphenation(charSequence, i);
    }

    private final Layout layoutTextWithHyphenation(CharSequence text, int textWidth) {
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(text, 0, text.length(), getPaint(), textWidth);
        Intrinsics.checkNotNullExpressionValue(builderObtain, "obtain(text, 0, text.length, paint, textWidth)");
        StaticLayout staticLayoutBuild = builderObtain.setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(getLineSpacingExtra(), getLineSpacingMultiplier()).setIncludePad(true).setHyphenationFrequency(getHyphenationFrequency()).build();
        Intrinsics.checkNotNullExpressionValue(staticLayoutBuild, "builder\n            .set…ncy)\n            .build()");
        return staticLayoutBuild;
    }

    /* JADX INFO: compiled from: EllipsizedTextView.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fH\u0082\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/yandex/div/internal/widget/EllipsizedTextView$Companion;", "", "()V", "DEBUG", "", "DEFAULT_ELLIPSIS", "", "ELLIPSIS_WIDTH_UNKNOWN", "", "NOT_SET", "", "TAG", "logDebug", "", "message", "Lkotlin/Function0;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void logDebug(Function0<String> message) {
        }

        private Companion() {
        }
    }
}
