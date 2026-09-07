package com.yandex.div.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.GravityCompat;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.bidmachine.iab.vast.tags.VastAttributes;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivViewGroup.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 )2\u00020\u0001:\u0002)*B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u001cH\u0014J\u0012\u0010\u001e\u001a\u00020\u001c2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u001e\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001cH\u0014J \u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0014J0\u0010&\u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0007H\u0014R*\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000eR\u0014\u0010\u0015\u001a\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u000eR\u0014\u0010\u0017\u001a\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u000e¨\u0006+"}, d2 = {"Lcom/yandex/div/internal/widget/DivViewGroup;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "gravity", "getGravity$annotations", "()V", "getGravity", "()I", "setGravity", "(I)V", "horizontalGravity", "getHorizontalGravity$div_release", "horizontalPaddings", "getHorizontalPaddings$div_release", "verticalGravity", "getVerticalGravity$div_release", "verticalPaddings", "getVerticalPaddings$div_release", "checkLayoutParams", "", "p", "Landroid/view/ViewGroup$LayoutParams;", "generateDefaultLayoutParams", "generateLayoutParams", "lp", "measureChild", "", "child", "Landroid/view/View;", "parentWidthMeasureSpec", "parentHeightMeasureSpec", "measureChildWithMargins", "widthUsed", "heightUsed", "Companion", "OffsetsHolder", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class DivViewGroup extends ViewGroup {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private int gravity;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DivViewGroup(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DivViewGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static /* synthetic */ void getGravity$annotations() {
    }

    public /* synthetic */ DivViewGroup(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DivViewGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.gravity = 8388659;
        setClipToPadding(false);
    }

    public final int getGravity() {
        return this.gravity;
    }

    public final void setGravity(int i) {
        if (this.gravity == i) {
            return;
        }
        Companion companion = INSTANCE;
        if (companion.toHorizontalGravity(i) == 0) {
            i |= GravityCompat.START;
        }
        if (companion.toVerticalGravity(i) == 0) {
            i |= 48;
        }
        this.gravity = i;
        requestLayout();
    }

    @Override // android.view.ViewGroup
    protected void measureChild(View child, int parentWidthMeasureSpec, int parentHeightMeasureSpec) {
        Intrinsics.checkNotNullParameter(child, "child");
        Companion companion = INSTANCE;
        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
        DivLayoutParams divLayoutParams = (DivLayoutParams) layoutParams;
        child.measure(companion.getChildMeasureSpec(parentWidthMeasureSpec, getHorizontalPaddings$div_release(), divLayoutParams.width, child.getMinimumWidth(), divLayoutParams.getMaxWidth()), companion.getChildMeasureSpec(parentHeightMeasureSpec, getVerticalPaddings$div_release(), divLayoutParams.height, child.getMinimumHeight(), divLayoutParams.getMaxHeight()));
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
        Intrinsics.checkNotNullParameter(child, "child");
        Companion companion = INSTANCE;
        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
        DivLayoutParams divLayoutParams = (DivLayoutParams) layoutParams;
        child.measure(companion.getChildMeasureSpec(parentWidthMeasureSpec, getHorizontalPaddings$div_release() + divLayoutParams.getHorizontalMargins$div_release() + widthUsed, divLayoutParams.width, child.getMinimumWidth(), divLayoutParams.getMaxWidth()), companion.getChildMeasureSpec(parentHeightMeasureSpec, getVerticalPaddings$div_release() + divLayoutParams.getVerticalMargins$div_release() + heightUsed, divLayoutParams.height, child.getMinimumHeight(), divLayoutParams.getMaxHeight()));
    }

    public final int getHorizontalGravity$div_release() {
        return INSTANCE.toHorizontalGravity(this.gravity);
    }

    public final int getVerticalGravity$div_release() {
        return INSTANCE.toVerticalGravity(this.gravity);
    }

    public final int getHorizontalPaddings$div_release() {
        return getPaddingLeft() + getPaddingRight();
    }

    public final int getVerticalPaddings$div_release() {
        return getPaddingTop() + getPaddingBottom();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof DivLayoutParams;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new DivLayoutParams(getContext(), attrs);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams lp) {
        if (lp instanceof DivLayoutParams) {
            return new DivLayoutParams((DivLayoutParams) lp);
        }
        return lp instanceof ViewGroup.MarginLayoutParams ? new DivLayoutParams((ViewGroup.MarginLayoutParams) lp) : new DivLayoutParams(lp);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new DivLayoutParams(-2, -2);
    }

    /* JADX INFO: compiled from: DivViewGroup.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\n\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tJ\u001d\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\tH\u0000¢\u0006\u0002\b\u0013J\u001d\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\tH\u0000¢\u0006\u0002\b\u0015J\u001d\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\tH\u0000¢\u0006\u0002\b\u0017J\f\u0010\u0018\u001a\u00020\t*\u00020\tH\u0007J\f\u0010\u0019\u001a\u00020\t*\u00020\tH\u0007R\u0016\u0010\u0003\u001a\u00020\u0004*\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/yandex/div/internal/widget/DivViewGroup$Companion;", "", "()V", "lp", "Lcom/yandex/div/internal/widget/DivLayoutParams;", "Landroid/view/View;", "getLp", "(Landroid/view/View;)Lcom/yandex/div/internal/widget/DivLayoutParams;", "getChildMeasureSpec", "", "parentMeasureSpec", VastAttributes.PADDING, "childDimension", SDKConstants.PARAM_CONTEXT_MIN_SIZE, SDKConstants.PARAM_CONTEXT_MAX_SIZE, "getSpaceAroundPart", "", "freeSpace", "childCount", "getSpaceAroundPart$div_release", "getSpaceBetweenPart", "getSpaceBetweenPart$div_release", "getSpaceEvenlyPart", "getSpaceEvenlyPart$div_release", "toHorizontalGravity", "toVerticalGravity", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final float getSpaceAroundPart$div_release(float freeSpace, int childCount) {
            return freeSpace / (childCount * 2);
        }

        public final float getSpaceBetweenPart$div_release(float freeSpace, int childCount) {
            if (childCount == 1) {
                return 0.0f;
            }
            return freeSpace / (childCount - 1);
        }

        public final float getSpaceEvenlyPart$div_release(float freeSpace, int childCount) {
            return freeSpace / (childCount + 1);
        }

        public final int toHorizontalGravity(int i) {
            return i & 125829127;
        }

        public final int toVerticalGravity(int i) {
            return i & 1879048304;
        }

        private Companion() {
        }

        public final DivLayoutParams getLp(View view) {
            Intrinsics.checkNotNullParameter(view, "<this>");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
            return (DivLayoutParams) layoutParams;
        }

        /* JADX WARN: Code duplicated, block: B:21:0x0040  */
        /* JADX WARN: Code duplicated, block: B:29:0x004e A[PHI: r10
  0x004e: PHI (r10v8 'childDimension' int) = (r10v0 'childDimension' int), (r10v0 'childDimension' int), (r10v10 'childDimension' int), (r10v0 'childDimension' int) binds: [B:28:0x004c, B:18:0x003b, B:11:0x0027, B:8:0x0022] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:36:0x005a  */
        /* JADX WARN: Code duplicated, block: B:39:0x0067  */
        public final int getChildMeasureSpec(int parentMeasureSpec, int padding, int childDimension, int minSize, int maxSize) {
            int mode = View.MeasureSpec.getMode(parentMeasureSpec);
            int size = View.MeasureSpec.getSize(parentMeasureSpec) - padding;
            int i = 0;
            int iMax = Math.max(0, size);
            if (mode != Integer.MIN_VALUE) {
                if (mode != 0) {
                    if (mode == 1073741824) {
                        if (childDimension < 0 || childDimension > Integer.MAX_VALUE) {
                            if (childDimension == -1) {
                                childDimension = iMax;
                            } else {
                                if (childDimension == -2) {
                                    if (maxSize == Integer.MAX_VALUE) {
                                        childDimension = iMax;
                                    } else {
                                        childDimension = maxSize;
                                    }
                                } else if (childDimension == -3) {
                                    childDimension = Math.min(Math.max(iMax, minSize), maxSize);
                                }
                                i = Integer.MIN_VALUE;
                            }
                        }
                        i = 1073741824;
                    }
                    childDimension = 0;
                } else if (childDimension < 0 || childDimension > Integer.MAX_VALUE) {
                    if (childDimension != -1) {
                        if (childDimension != -2 && childDimension != -3) {
                            childDimension = 0;
                        } else if (maxSize != Integer.MAX_VALUE) {
                            childDimension = maxSize;
                            i = Integer.MIN_VALUE;
                        }
                    }
                    childDimension = iMax;
                } else {
                    i = 1073741824;
                }
            } else if (childDimension < 0 || childDimension > Integer.MAX_VALUE) {
                if (childDimension == -1) {
                    childDimension = iMax;
                } else if (childDimension == -2) {
                    if (maxSize == Integer.MAX_VALUE) {
                        childDimension = iMax;
                    } else {
                        childDimension = maxSize;
                    }
                } else if (childDimension == -3) {
                    childDimension = Math.min(Math.max(iMax, minSize), maxSize);
                } else {
                    childDimension = 0;
                }
                i = Integer.MIN_VALUE;
            } else {
                i = 1073741824;
            }
            return View.MeasureSpec.makeMeasureSpec(childDimension, i);
        }
    }

    /* JADX INFO: compiled from: DivViewGroup.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0080\u0004\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/yandex/div/internal/widget/DivViewGroup$OffsetsHolder;", "", "firstChildOffset", "", "spaceBetweenChildren", "edgeDividerOffset", "", "(Lcom/yandex/div/internal/widget/DivViewGroup;FFI)V", "getEdgeDividerOffset", "()I", "setEdgeDividerOffset", "(I)V", "getFirstChildOffset", "()F", "setFirstChildOffset", "(F)V", "getSpaceBetweenChildren", "setSpaceBetweenChildren", "update", "", "freeSpace", "gravity", "childCount", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class OffsetsHolder {
        private int edgeDividerOffset;
        private float firstChildOffset;
        private float spaceBetweenChildren;

        public OffsetsHolder(float f, float f2, int i) {
            this.firstChildOffset = f;
            this.spaceBetweenChildren = f2;
            this.edgeDividerOffset = i;
        }

        public /* synthetic */ OffsetsHolder(DivViewGroup divViewGroup, float f, float f2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 0.0f : f, (i2 & 2) != 0 ? 0.0f : f2, (i2 & 4) != 0 ? 0 : i);
        }

        public final float getFirstChildOffset() {
            return this.firstChildOffset;
        }

        public final void setFirstChildOffset(float f) {
            this.firstChildOffset = f;
        }

        public final float getSpaceBetweenChildren() {
            return this.spaceBetweenChildren;
        }

        public final void setSpaceBetweenChildren(float f) {
            this.spaceBetweenChildren = f;
        }

        public final int getEdgeDividerOffset() {
            return this.edgeDividerOffset;
        }

        public final void setEdgeDividerOffset(int i) {
            this.edgeDividerOffset = i;
        }

        public final void update(float freeSpace, int gravity, int childCount) {
            this.firstChildOffset = 0.0f;
            this.spaceBetweenChildren = 0.0f;
            this.edgeDividerOffset = 0;
            switch (gravity) {
                case 1:
                case 16:
                    this.firstChildOffset = freeSpace / 2;
                    return;
                case 3:
                case 48:
                    return;
                case 5:
                case 80:
                    this.firstChildOffset = freeSpace;
                    return;
                case 16777216:
                case 268435456:
                    float spaceAroundPart$div_release = DivViewGroup.INSTANCE.getSpaceAroundPart$div_release(freeSpace, childCount);
                    this.firstChildOffset = spaceAroundPart$div_release;
                    float f = 2;
                    this.spaceBetweenChildren = spaceAroundPart$div_release * f;
                    this.edgeDividerOffset = (int) (spaceAroundPart$div_release / f);
                    return;
                case 33554432:
                case 536870912:
                    this.spaceBetweenChildren = DivViewGroup.INSTANCE.getSpaceBetweenPart$div_release(freeSpace, childCount);
                    return;
                case 67108864:
                case 1073741824:
                    float spaceEvenlyPart$div_release = DivViewGroup.INSTANCE.getSpaceEvenlyPart$div_release(freeSpace, childCount);
                    this.firstChildOffset = spaceEvenlyPart$div_release;
                    this.spaceBetweenChildren = spaceEvenlyPart$div_release;
                    this.edgeDividerOffset = (int) (spaceEvenlyPart$div_release / 2);
                    return;
                default:
                    throw new IllegalStateException("Invalid gravity is set: " + gravity);
            }
        }
    }
}
