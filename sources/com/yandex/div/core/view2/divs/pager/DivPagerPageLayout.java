package com.yandex.div.core.view2.divs.pager;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt;
import com.yandex.div.core.widget.DivViewWrapper;
import com.yandex.div.core.widget.ViewsKt;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivPagerPageLayout.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002J \u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rH\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/yandex/div/core/view2/divs/pager/DivPagerPageLayout;", "Lcom/yandex/div/core/widget/DivViewWrapper;", "context", "Landroid/content/Context;", "isHorizontal", "Lkotlin/Function0;", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;)V", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "getMinimumSize", "", "parentSpec", "getSpec", ContentDisposition.Parameters.Size, "alongScrollAxis", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivPagerPageLayout extends DivViewWrapper {
    private final Function0<Boolean> isHorizontal;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DivPagerPageLayout(Context context, Function0<Boolean> isHorizontal) {
        super(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(isHorizontal, "isHorizontal");
        this.isHorizontal = isHorizontal;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.yandex.div.internal.widget.FrameContainerLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (getChildCount() == 0) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        ViewGroup.LayoutParams layoutParams = getChildAt(0).getLayoutParams();
        boolean zBooleanValue = this.isHorizontal.invoke().booleanValue();
        if (zBooleanValue) {
            setMinimumHeight(getMinimumSize(heightMeasureSpec));
        } else {
            setMinimumWidth(getMinimumSize(widthMeasureSpec));
        }
        super.onMeasure(getSpec(layoutParams.width, widthMeasureSpec, zBooleanValue), getSpec(layoutParams.height, heightMeasureSpec, !zBooleanValue));
    }

    private final int getMinimumSize(int parentSpec) {
        if (ViewsKt.isUnspecified(parentSpec)) {
            return 0;
        }
        return View.MeasureSpec.getSize(parentSpec);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        BaseDivViewExtensionsKt.drawChildrenShadows(this, canvas);
        super.dispatchDraw(canvas);
    }

    private final int getSpec(int size, int parentSpec, boolean alongScrollAxis) {
        return (alongScrollAxis || size == -1 || size == -3) ? parentSpec : ViewsKt.makeUnspecifiedSpec();
    }
}
