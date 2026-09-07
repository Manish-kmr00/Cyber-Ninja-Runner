package com.yandex.div.internal.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.yandex.div.core.util.AccessibilityStateProvider;
import com.yandex.div.core.view2.spannable.ImageSpan;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextViewWithAccessibleSpans.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001-B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\rH\u0000¢\u0006\u0002\b\u0014J\r\u0010\u0015\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0014J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0012H\u0002J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 H\u0014J\"\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\u0012\u0010&\u001a\u00020\u00122\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u001c\u0010)\u001a\u00020\u00122\b\u0010*\u001a\u0004\u0018\u00010(2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0018\u00010\u0010R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/yandex/div/internal/widget/TextViewWithAccessibleSpans;", "Lcom/yandex/div/internal/widget/EllipsizedTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "_contentDescription", "", "accessibleImageSpans", "", "Lcom/yandex/div/core/view2/spannable/ImageSpan;", "imageSpans", "spanHelper", "Lcom/yandex/div/internal/widget/TextViewWithAccessibleSpans$SpanHelper;", "addImageSpan", "", "span", "addImageSpan$div_release", "clearImageSpans", "clearImageSpans$div_release", "dispatchHoverEvent", "", "event", "Landroid/view/MotionEvent;", "dispatchKeyEvent", "Landroid/view/KeyEvent;", "evaluateAndSetContentDescription", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onFocusChanged", "gainFocus", "direction", "previouslyFocusedRect", "Landroid/graphics/Rect;", "setContentDescription", "contentDescription", "", "setText", "text", "type", "Landroid/widget/TextView$BufferType;", "SpanHelper", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class TextViewWithAccessibleSpans extends EllipsizedTextView {
    private String _contentDescription;
    private final List<ImageSpan> accessibleImageSpans;
    private final List<ImageSpan> imageSpans;
    private final SpanHelper spanHelper;

    public /* synthetic */ TextViewWithAccessibleSpans(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextViewWithAccessibleSpans(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.accessibleImageSpans = new ArrayList();
        this.imageSpans = new ArrayList();
        AccessibilityStateProvider.INSTANCE.evaluateTouchModeEnabled(context);
        if (Intrinsics.areEqual((Object) AccessibilityStateProvider.INSTANCE.getTouchModeEnabled(), (Object) true)) {
            SpanHelper spanHelper = new SpanHelper();
            this.spanHelper = spanHelper;
            ViewCompat.setAccessibilityDelegate(this, spanHelper);
            setAccessibilityLiveRegion(1);
            return;
        }
        this.spanHelper = null;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0036  */
    public final void addImageSpan$div_release(ImageSpan span) {
        Intrinsics.checkNotNullParameter(span, "span");
        if (Intrinsics.areEqual((Object) AccessibilityStateProvider.INSTANCE.getTouchModeEnabled(), (Object) true)) {
            this.imageSpans.add(span);
            ImageSpan.Accessibility accessibility = span.getAccessibility();
            if ((accessibility != null ? accessibility.getContentDescription() : null) != null) {
                this.accessibleImageSpans.add(span);
            } else {
                ImageSpan.Accessibility accessibility2 = span.getAccessibility();
                if ((accessibility2 != null ? accessibility2.getOnClickAction() : null) != null) {
                    this.accessibleImageSpans.add(span);
                }
            }
            SpanHelper spanHelper = this.spanHelper;
            if (spanHelper != null) {
                spanHelper.invalidateVirtualView(this.accessibleImageSpans.size() - 1);
            }
        }
    }

    public final void clearImageSpans$div_release() {
        this.accessibleImageSpans.clear();
        this.imageSpans.clear();
        SpanHelper spanHelper = this.spanHelper;
        if (spanHelper != null) {
            spanHelper.invalidateRoot();
        }
        evaluateAndSetContentDescription();
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00c4  */
    private final void evaluateAndSetContentDescription() {
        String string;
        if (!Intrinsics.areEqual((Object) AccessibilityStateProvider.INSTANCE.getTouchModeEnabled(), (Object) true)) {
            super.setContentDescription(this._contentDescription);
            return;
        }
        List<ImageSpan> list = this.imageSpans;
        if (list == null || this._contentDescription != null) {
            string = this._contentDescription;
        } else {
            string = null;
            string = null;
            if (list.size() != 0 && getText().length() != 0) {
                CharSequence text = getText();
                SpannableString spannableString = text instanceof SpannableString ? (SpannableString) text : null;
                if (spannableString != null) {
                    List<ImageSpan> list2 = this.imageSpans;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                    Iterator<T> it = list2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(Integer.valueOf(spannableString.getSpanStart((ImageSpan) it.next())));
                    }
                    List listSortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.yandex.div.internal.widget.TextViewWithAccessibleSpans$evaluateAndSetContentDescription$lambda$3$$inlined$sortedByDescending$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            return ComparisonsKt.compareValues(Integer.valueOf(((Number) t2).intValue()), Integer.valueOf(((Number) t).intValue()));
                        }
                    });
                    StringBuilder sb = new StringBuilder();
                    Iterator it2 = listSortedWith.iterator();
                    int i = 0;
                    while (it2.hasNext()) {
                        int iIntValue = ((Number) it2.next()).intValue();
                        sb.append(getText().subSequence(i, iIntValue));
                        i = iIntValue + 1;
                    }
                    sb.append(getText().subSequence(i, getText().length()));
                    string = sb.toString();
                    if (string == null) {
                        string = getText().toString();
                    }
                } else {
                    string = getText().toString();
                }
            }
        }
        super.setContentDescription(string);
    }

    @Override // com.yandex.div.internal.widget.EllipsizedTextView, android.widget.TextView
    public void setText(CharSequence text, TextView.BufferType type) {
        super.setText(text, type);
        evaluateAndSetContentDescription();
    }

    @Override // android.view.View
    public void setContentDescription(CharSequence contentDescription) {
        this._contentDescription = contentDescription != null ? contentDescription.toString() : null;
        super.setContentDescription(contentDescription);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        int i = 0;
        for (Object obj : this.accessibleImageSpans) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            SpanHelper spanHelper = this.spanHelper;
            if (spanHelper != null) {
                spanHelper.invalidateVirtualView(i);
            }
            i = i2;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        SpanHelper spanHelper = this.spanHelper;
        if (spanHelper != null) {
            spanHelper.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        }
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        SpanHelper spanHelper = this.spanHelper;
        return (spanHelper != null && spanHelper.dispatchHoverEvent(event)) || super.dispatchHoverEvent(event);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        SpanHelper spanHelper = this.spanHelper;
        return (spanHelper != null && spanHelper.dispatchKeyEvent(event)) || super.dispatchKeyEvent(event);
    }

    /* JADX INFO: compiled from: TextViewWithAccessibleSpans.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0014J\u0016\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0014J\"\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017H\u0014¨\u0006\u0018"}, d2 = {"Lcom/yandex/div/internal/widget/TextViewWithAccessibleSpans$SpanHelper;", "Landroidx/customview/widget/ExploreByTouchHelper;", "(Lcom/yandex/div/internal/widget/TextViewWithAccessibleSpans;)V", "getSpanForId", "Lcom/yandex/div/core/view2/spannable/ImageSpan;", "id", "", "getVirtualViewAt", VastAttributes.HORIZONTAL_POSITION, "", VastAttributes.VERTICAL_POSITION, "getVisibleVirtualViews", "", "virtualViewIds", "", "onPerformActionForVirtualView", "", "virtualViewId", "action", "arguments", "Landroid/os/Bundle;", "onPopulateNodeForVirtualView", "node", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private final class SpanHelper extends ExploreByTouchHelper {
        public SpanHelper() {
            super(TextViewWithAccessibleSpans.this);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected int getVirtualViewAt(float x, float y) {
            RectF rectF = new RectF();
            List list = TextViewWithAccessibleSpans.this.accessibleImageSpans;
            TextViewWithAccessibleSpans textViewWithAccessibleSpans = TextViewWithAccessibleSpans.this;
            int i = 0;
            for (Object obj : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ((ImageSpan) obj).getBoundsInText(rectF).offset(textViewWithAccessibleSpans.getPaddingLeft(), textViewWithAccessibleSpans.getPaddingTop());
                if (rectF.contains(x, y)) {
                    return i;
                }
                i = i2;
            }
            return -1;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void getVisibleVirtualViews(List<Integer> virtualViewIds) {
            Intrinsics.checkNotNullParameter(virtualViewIds, "virtualViewIds");
            int i = 0;
            for (Object obj : TextViewWithAccessibleSpans.this.accessibleImageSpans) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                virtualViewIds.add(Integer.valueOf(i));
                i = i2;
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onPopulateNodeForVirtualView(int virtualViewId, AccessibilityNodeInfoCompat node) {
            String accessibilityType;
            Intrinsics.checkNotNullParameter(node, "node");
            ImageSpan spanForId = getSpanForId(virtualViewId);
            if (spanForId == null) {
                return;
            }
            ImageSpan.Accessibility accessibility = spanForId.getAccessibility();
            if (accessibility == null || (accessibilityType = accessibility.getAccessibilityType()) == null) {
                accessibilityType = "";
            }
            node.setClassName(accessibilityType);
            node.setPackageName(TextViewWithAccessibleSpans.this.getContext().getPackageName());
            Rect boundsInText = spanForId.getBoundsInText(new Rect());
            TextViewWithAccessibleSpans textViewWithAccessibleSpans = TextViewWithAccessibleSpans.this;
            boundsInText.offset(textViewWithAccessibleSpans.getPaddingLeft(), textViewWithAccessibleSpans.getPaddingTop());
            ImageSpan.Accessibility accessibility2 = spanForId.getAccessibility();
            node.setContentDescription(accessibility2 != null ? accessibility2.getContentDescription() : null);
            ImageSpan.Accessibility accessibility3 = spanForId.getAccessibility();
            if ((accessibility3 != null ? accessibility3.getOnClickAction() : null) == null) {
                node.setClickable(false);
            } else {
                node.setClickable(true);
                node.addAction(16);
            }
            node.setBoundsInParent(boundsInText);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected boolean onPerformActionForVirtualView(int virtualViewId, int action, Bundle arguments) {
            ImageSpan.Accessibility accessibility;
            ImageSpan.OnAccessibilityClickAction onClickAction;
            ImageSpan spanForId = getSpanForId(virtualViewId);
            if (spanForId == null || (accessibility = spanForId.getAccessibility()) == null || (onClickAction = accessibility.getOnClickAction()) == null || action != 16) {
                return false;
            }
            onClickAction.perform();
            return true;
        }

        private final ImageSpan getSpanForId(int id) {
            if (id != -1 && TextViewWithAccessibleSpans.this.accessibleImageSpans.size() != 0 && id < TextViewWithAccessibleSpans.this.accessibleImageSpans.size() && id >= 0) {
                return (ImageSpan) TextViewWithAccessibleSpans.this.accessibleImageSpans.get(id);
            }
            return null;
        }
    }
}
