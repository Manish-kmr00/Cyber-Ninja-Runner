package com.yandex.div.core.view2.divs.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.NinePatch;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.compose.material.OutlinedTextFieldKt;
import com.android.billingclient.api.BillingClient;
import com.yandex.div.R;
import com.yandex.div.core.Disposable;
import com.yandex.div.core.util.DivDataExtensionsKt;
import com.yandex.div.core.util.DivUtilKt;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.ShadowCache;
import com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt;
import com.yandex.div.core.view2.divs.widgets.DivBorderDrawer.BorderParams;
import com.yandex.div.core.view2.divs.widgets.DivBorderDrawer.ShadowParams;
import com.yandex.div.internal.KLog;
import com.yandex.div.internal.core.ExpressionSubscriber;
import com.yandex.div.internal.widget.TransientViewKt;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div.logging.Severity;
import com.yandex.div2.DivBorder;
import com.yandex.div2.DivCornersRadius;
import com.yandex.div2.DivDimension;
import com.yandex.div2.DivPoint;
import com.yandex.div2.DivShadow;
import com.yandex.div2.DivSizeUnit;
import com.yandex.div2.DivStroke;
import com.yandex.div2.DivStrokeStyle;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: DivBorderDrawer.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\n\b\u0000\u0018\u0000 J2\u00020\u0001:\u0005HIJKLB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u00103\u001a\u0002042\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u00105\u001a\u000206H\u0002J\u001a\u00107\u001a\u0002042\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u00105\u001a\u000206H\u0002J\u000e\u00108\u001a\u0002042\u0006\u00109\u001a\u00020:J\u000e\u0010;\u001a\u0002042\u0006\u00109\u001a\u00020:J\u000e\u0010<\u001a\u0002042\u0006\u00109\u001a\u00020:J\u0006\u0010=\u001a\u000204J\b\u0010>\u001a\u000204H\u0002J\b\u0010?\u001a\u000204H\u0002J\u001a\u0010@\u001a\u0002042\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u00105\u001a\u000206H\u0002J\u0016\u0010A\u001a\u0002042\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020CJ\u0018\u0010E\u001a\u0002042\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u00105\u001a\u000206J\b\u0010F\u001a\u00020\u001bH\u0002J\b\u0010G\u001a\u00020\u001bH\u0002R\"\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001f\u0010\f\u001a\u00060\rR\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0012\u001a\u00060\u0013R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010 \u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010'\u001a\u00060(R\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0011\u001a\u0004\b)\u0010*R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u0002000/X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/yandex/div/core/view2/divs/widgets/DivBorderDrawer;", "Lcom/yandex/div/internal/core/ExpressionSubscriber;", "divView", "Lcom/yandex/div/core/view2/Div2View;", "view", "Landroid/view/View;", "(Lcom/yandex/div/core/view2/Div2View;Landroid/view/View;)V", "<set-?>", "Lcom/yandex/div2/DivBorder;", OutlinedTextFieldKt.BorderId, "getBorder", "()Lcom/yandex/div2/DivBorder;", "borderParams", "Lcom/yandex/div/core/view2/divs/widgets/DivBorderDrawer$BorderParams;", "getBorderParams", "()Lcom/yandex/div/core/view2/divs/widgets/DivBorderDrawer$BorderParams;", "borderParams$delegate", "Lkotlin/Lazy;", "clipParams", "Lcom/yandex/div/core/view2/divs/widgets/DivBorderDrawer$ClipParams;", "cornerRadii", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "getDisplayMetrics", "()Landroid/util/DisplayMetrics;", "hasBorder", "", "hasCustomShadow", "hasDifferentCornerRadii", "hasShadow", "value", "needClipping", "getNeedClipping", "()Z", "setNeedClipping", "(Z)V", "outlineProvider", "Lcom/yandex/div/core/view2/divs/widgets/DivBorderDrawer$RoundedRectOutlineProvider;", "shadowParams", "Lcom/yandex/div/core/view2/divs/widgets/DivBorderDrawer$ShadowParams;", "getShadowParams", "()Lcom/yandex/div/core/view2/divs/widgets/DivBorderDrawer$ShadowParams;", "shadowParams$delegate", "strokeWidth", "", BillingClient.FeatureType.SUBSCRIPTIONS, "", "Lcom/yandex/div/core/Disposable;", "getSubscriptions", "()Ljava/util/List;", "applyBorder", "", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "bindBorder", "clipCorners", "canvas", "Landroid/graphics/Canvas;", "drawBorder", "drawShadow", "invalidateBorder", "invalidateOutline", "invalidatePaths", "observeBorder", "onBoundsChanged", "width", "", "height", "setBorder", "shouldUseCanvasClipping", "shouldUseNinePatchShadows", "BorderParams", "ClipParams", "Companion", "RoundedRectOutlineProvider", "ShadowParams", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivBorderDrawer implements ExpressionSubscriber {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final float DEFAULT_CORNER_RADIUS = 0.0f;
    private static final float DEFAULT_DX = 0.0f;
    private static final float DEFAULT_DY = 0.5f;
    private static final float DEFAULT_SHADOW_ALPHA = 0.14f;
    private static final int DEFAULT_SHADOW_COLOR = -16777216;
    private static final float DEFAULT_STROKE_WIDTH = 0.0f;
    public static final float NO_ELEVATION = 0.0f;
    private DivBorder border;

    /* JADX INFO: renamed from: borderParams$delegate, reason: from kotlin metadata */
    private final Lazy borderParams;
    private final ClipParams clipParams;
    private float[] cornerRadii;
    private final Div2View divView;
    private boolean hasBorder;
    private boolean hasCustomShadow;
    private boolean hasDifferentCornerRadii;
    private boolean hasShadow;
    private boolean needClipping;
    private final RoundedRectOutlineProvider outlineProvider;

    /* JADX INFO: renamed from: shadowParams$delegate, reason: from kotlin metadata */
    private final Lazy shadowParams;
    private float strokeWidth;
    private final List<Disposable> subscriptions;
    private final View view;

    public DivBorderDrawer(Div2View divView, View view) {
        Intrinsics.checkNotNullParameter(divView, "divView");
        Intrinsics.checkNotNullParameter(view, "view");
        this.divView = divView;
        this.view = view;
        this.clipParams = new ClipParams();
        this.borderParams = LazyKt.lazy(new Function0<BorderParams>() { // from class: com.yandex.div.core.view2.divs.widgets.DivBorderDrawer$borderParams$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DivBorderDrawer.BorderParams invoke() {
                return this.this$0.new BorderParams();
            }
        });
        this.shadowParams = LazyKt.lazy(new Function0<ShadowParams>() { // from class: com.yandex.div.core.view2.divs.widgets.DivBorderDrawer$shadowParams$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DivBorderDrawer.ShadowParams invoke() {
                return this.this$0.new ShadowParams();
            }
        });
        this.outlineProvider = new RoundedRectOutlineProvider(0.0f, 1, null);
        this.needClipping = true;
        this.subscriptions = new ArrayList();
    }

    public final DivBorder getBorder() {
        return this.border;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DisplayMetrics getDisplayMetrics() {
        DisplayMetrics displayMetrics = this.view.getResources().getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "view.resources.displayMetrics");
        return displayMetrics;
    }

    private final BorderParams getBorderParams() {
        return (BorderParams) this.borderParams.getValue();
    }

    private final ShadowParams getShadowParams() {
        return (ShadowParams) this.shadowParams.getValue();
    }

    public final boolean getNeedClipping() {
        return this.needClipping;
    }

    public final void setNeedClipping(boolean z) {
        if (this.needClipping == z) {
            return;
        }
        this.needClipping = z;
        invalidateOutline();
        this.view.invalidate();
    }

    @Override // com.yandex.div.internal.core.ExpressionSubscriber
    public List<Disposable> getSubscriptions() {
        return this.subscriptions;
    }

    public final void setBorder(DivBorder border, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        if (DivDataExtensionsKt.equalsToConstant(border, this.border)) {
            return;
        }
        release();
        this.border = border;
        bindBorder(border, resolver);
    }

    private final void bindBorder(DivBorder border, ExpressionResolver resolver) {
        applyBorder(border, resolver);
        observeBorder(border, resolver);
    }

    private final void observeBorder(final DivBorder border, final ExpressionResolver resolver) {
        DivPoint divPoint;
        DivDimension divDimension;
        Expression<Double> expression;
        DivPoint divPoint2;
        DivDimension divDimension2;
        Expression<DivSizeUnit> expression2;
        DivPoint divPoint3;
        DivDimension divDimension3;
        Expression<Double> expression3;
        DivPoint divPoint4;
        DivDimension divDimension4;
        Expression<DivSizeUnit> expression4;
        Expression<Integer> expression5;
        Expression<Long> expression6;
        Expression<Double> expression7;
        Expression<DivSizeUnit> expression8;
        Expression<Double> expression9;
        Expression<Integer> expression10;
        Expression<Long> expression11;
        Expression<Long> expression12;
        Expression<Long> expression13;
        Expression<Long> expression14;
        if (border == null || DivDataExtensionsKt.isConstant(border)) {
            return;
        }
        Function1<? super Long, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.widgets.DivBorderDrawer$observeBorder$callback$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                Intrinsics.checkNotNullParameter(obj, "<anonymous parameter 0>");
                this.this$0.applyBorder(border, resolver);
                this.this$0.view.invalidate();
            }
        };
        Expression<Long> expression15 = border.cornerRadius;
        Disposable disposableObserve = null;
        addSubscription(expression15 != null ? expression15.observe(resolver, function1) : null);
        DivCornersRadius divCornersRadius = border.cornersRadius;
        addSubscription((divCornersRadius == null || (expression14 = divCornersRadius.topLeft) == null) ? null : expression14.observe(resolver, function1));
        DivCornersRadius divCornersRadius2 = border.cornersRadius;
        addSubscription((divCornersRadius2 == null || (expression13 = divCornersRadius2.topRight) == null) ? null : expression13.observe(resolver, function1));
        DivCornersRadius divCornersRadius3 = border.cornersRadius;
        addSubscription((divCornersRadius3 == null || (expression12 = divCornersRadius3.bottomRight) == null) ? null : expression12.observe(resolver, function1));
        DivCornersRadius divCornersRadius4 = border.cornersRadius;
        addSubscription((divCornersRadius4 == null || (expression11 = divCornersRadius4.bottomLeft) == null) ? null : expression11.observe(resolver, function1));
        addSubscription(border.hasShadow.observe(resolver, function1));
        DivStroke divStroke = border.stroke;
        addSubscription((divStroke == null || (expression10 = divStroke.color) == null) ? null : expression10.observe(resolver, function1));
        DivStroke divStroke2 = border.stroke;
        addSubscription((divStroke2 == null || (expression9 = divStroke2.width) == null) ? null : expression9.observe(resolver, function1));
        DivStroke divStroke3 = border.stroke;
        addSubscription((divStroke3 == null || (expression8 = divStroke3.unit) == null) ? null : expression8.observe(resolver, function1));
        DivShadow divShadow = border.shadow;
        addSubscription((divShadow == null || (expression7 = divShadow.alpha) == null) ? null : expression7.observe(resolver, function1));
        DivShadow divShadow2 = border.shadow;
        addSubscription((divShadow2 == null || (expression6 = divShadow2.blur) == null) ? null : expression6.observe(resolver, function1));
        DivShadow divShadow3 = border.shadow;
        addSubscription((divShadow3 == null || (expression5 = divShadow3.color) == null) ? null : expression5.observe(resolver, function1));
        DivShadow divShadow4 = border.shadow;
        addSubscription((divShadow4 == null || (divPoint4 = divShadow4.offset) == null || (divDimension4 = divPoint4.x) == null || (expression4 = divDimension4.unit) == null) ? null : expression4.observe(resolver, function1));
        DivShadow divShadow5 = border.shadow;
        addSubscription((divShadow5 == null || (divPoint3 = divShadow5.offset) == null || (divDimension3 = divPoint3.x) == null || (expression3 = divDimension3.value) == null) ? null : expression3.observe(resolver, function1));
        DivShadow divShadow6 = border.shadow;
        addSubscription((divShadow6 == null || (divPoint2 = divShadow6.offset) == null || (divDimension2 = divPoint2.y) == null || (expression2 = divDimension2.unit) == null) ? null : expression2.observe(resolver, function1));
        DivShadow divShadow7 = border.shadow;
        if (divShadow7 != null && (divPoint = divShadow7.offset) != null && (divDimension = divPoint.y) != null && (expression = divDimension.value) != null) {
            disposableObserve = expression.observe(resolver, function1);
        }
        addSubscription(disposableObserve);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:57:0x00cf  */
    public final void applyBorder(DivBorder border, ExpressionResolver resolver) {
        boolean z;
        Expression<Boolean> expression;
        boolean z2;
        DivStroke divStroke;
        DivStroke divStroke2;
        Expression<Integer> expression2;
        DivStroke divStroke3;
        DisplayMetrics displayMetrics = getDisplayMetrics();
        float dimension = 0.0f;
        float fWidthPx = (border == null || (divStroke3 = border.stroke) == null) ? 0.0f : DivBorderDrawerKt.widthPx(divStroke3, resolver, displayMetrics);
        this.strokeWidth = fWidthPx;
        boolean z3 = true;
        boolean z4 = fWidthPx > 0.0f;
        this.hasBorder = z4;
        if (z4) {
            getBorderParams().setPaintParams(this.strokeWidth, (border == null || (divStroke2 = border.stroke) == null || (expression2 = divStroke2.color) == null) ? 0 : expression2.evaluate(resolver).intValue());
            getBorderParams().setDashed(((border == null || (divStroke = border.stroke) == null) ? null : divStroke.style) instanceof DivStrokeStyle.Dashed);
        }
        float[] cornerRadii = border != null ? DivUtilKt.getCornerRadii(border, BaseDivViewExtensionsKt.dpToPx(Integer.valueOf(this.view.getWidth()), displayMetrics), BaseDivViewExtensionsKt.dpToPx(Integer.valueOf(this.view.getHeight()), displayMetrics), displayMetrics, resolver) : null;
        this.cornerRadii = cornerRadii;
        if (cornerRadii != null) {
            float fFirst = ArraysKt.first(cornerRadii);
            int length = cornerRadii.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z2 = true;
                    break;
                } else {
                    if (!Float.valueOf(cornerRadii[i]).equals(Float.valueOf(fFirst))) {
                        z2 = false;
                        break;
                    }
                    i++;
                }
            }
            z = !z2;
        } else {
            z = false;
        }
        this.hasDifferentCornerRadii = z;
        boolean z5 = this.hasCustomShadow;
        boolean zBooleanValue = (border == null || (expression = border.hasShadow) == null) ? false : expression.evaluate(resolver).booleanValue();
        this.hasShadow = zBooleanValue;
        if (zBooleanValue) {
            if ((border != null ? border.shadow : null) == null && !(this.view.getParent() instanceof DivFrameLayout)) {
                z3 = false;
            }
        } else {
            z3 = false;
        }
        this.hasCustomShadow = z3;
        View view = this.view;
        if (this.hasShadow && !z3) {
            dimension = view.getContext().getResources().getDimension(R.dimen.div_shadow_elevation);
        }
        view.setElevation(dimension);
        if (this.hasCustomShadow) {
            getShadowParams().set(border != null ? border.shadow : null, resolver);
        }
        invalidateBorder();
        if (this.hasCustomShadow || z5) {
            Object parent = this.view.getParent();
            View view2 = parent instanceof View ? (View) parent : null;
            if (view2 != null) {
                view2.invalidate();
            }
        }
    }

    public final void onBoundsChanged(int width, int height) {
        invalidateBorder();
    }

    public final void invalidateBorder() {
        invalidatePaths();
        invalidateOutline();
    }

    private final void invalidatePaths() {
        float[] fArr;
        float[] fArr2 = this.cornerRadii;
        if (fArr2 == null || (fArr = (float[]) fArr2.clone()) == null) {
            return;
        }
        this.clipParams.invalidatePath(fArr);
        float f = this.strokeWidth / 2.0f;
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            fArr[i] = Math.max(0.0f, fArr[i] - f);
        }
        if (this.hasBorder) {
            getBorderParams().invalidate(fArr);
        }
        if (this.hasCustomShadow) {
            getShadowParams().invalidateShadow(fArr);
        }
    }

    private final void invalidateOutline() {
        if (shouldUseCanvasClipping()) {
            this.view.setClipToOutline(false);
            this.view.setOutlineProvider(shouldUseNinePatchShadows() ? null : ViewOutlineProvider.BACKGROUND);
            return;
        }
        float[] fArr = this.cornerRadii;
        float fFirst = fArr != null ? ArraysKt.first(fArr) : 0.0f;
        if (fFirst == 0.0f) {
            this.view.setClipToOutline(false);
            this.view.setOutlineProvider(shouldUseNinePatchShadows() ? null : ViewOutlineProvider.BACKGROUND);
        } else {
            this.outlineProvider.setCornerRadius(fFirst);
            this.view.setOutlineProvider(this.outlineProvider);
            this.view.setClipToOutline(this.needClipping);
        }
    }

    private final boolean shouldUseCanvasClipping() {
        return this.needClipping && (this.divView.getForceCanvasClipping() || this.hasCustomShadow || ((!this.hasShadow && (this.hasDifferentCornerRadii || this.hasBorder)) || TransientViewKt.isInTransientHierarchy(this.view)));
    }

    private final boolean shouldUseNinePatchShadows() {
        return this.hasCustomShadow || TransientViewKt.isInTransientHierarchy(this.view);
    }

    public final void clipCorners(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (shouldUseCanvasClipping()) {
            canvas.clipPath(this.clipParams.getPath());
        }
    }

    public final void drawBorder(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.hasBorder) {
            canvas.drawPath(getBorderParams().getPath(), getBorderParams().getPaint());
        }
    }

    public final void drawShadow(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (TransientViewKt.isInTransientHierarchy(this.view) || !this.hasCustomShadow) {
            return;
        }
        float offsetX = getShadowParams().getOffsetX();
        float offsetY = getShadowParams().getOffsetY();
        int iSave = canvas.save();
        canvas.translate(offsetX, offsetY);
        try {
            NinePatch cachedShadow = getShadowParams().getCachedShadow();
            if (cachedShadow != null) {
                cachedShadow.draw(canvas, getShadowParams().getRect(), getShadowParams().getPaint());
            }
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    /* JADX INFO: compiled from: DivBorderDrawer.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div/core/view2/divs/widgets/DivBorderDrawer$ClipParams;", "", "(Lcom/yandex/div/core/view2/divs/widgets/DivBorderDrawer;)V", "path", "Landroid/graphics/Path;", "getPath", "()Landroid/graphics/Path;", "rect", "Landroid/graphics/RectF;", "invalidatePath", "", "radii", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private final class ClipParams {
        private final Path path = new Path();
        private final RectF rect = new RectF();

        public ClipParams() {
        }

        public final Path getPath() {
            return this.path;
        }

        public final void invalidatePath(float[] radii) {
            this.rect.set(0.0f, 0.0f, DivBorderDrawer.this.view.getWidth(), DivBorderDrawer.this.view.getHeight());
            this.path.reset();
            if (radii != null) {
                this.path.addRoundRect(this.rect, (float[]) radii.clone(), Path.Direction.CW);
                this.path.close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: DivBorderDrawer.kt */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0004H\u0002J\u000e\u0010!\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020&R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006'"}, d2 = {"Lcom/yandex/div/core/view2/divs/widgets/DivBorderDrawer$BorderParams;", "", "(Lcom/yandex/div/core/view2/divs/widgets/DivBorderDrawer;)V", "defaultDashWidth", "", "defaultGapWidth", "halfDp", "isDashed", "", "()Z", "setDashed", "(Z)V", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "path", "Landroid/graphics/Path;", "getPath", "()Landroid/graphics/Path;", "rect", "Landroid/graphics/RectF;", "strokeOffset", "getStrokeOffset", "()F", "calculatePerimeter", "width", "height", "radii", "", "createDashPathEffect", "Landroid/graphics/DashPathEffect;", "perimeter", "invalidate", "", "setPaintParams", "strokeWidth", "borderColor", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    final class BorderParams {
        private final float defaultDashWidth;
        private final float defaultGapWidth;
        private final float halfDp;
        private boolean isDashed;
        private final Paint paint;
        private final Path path;
        private final RectF rect;

        public BorderParams() {
            Paint paint = new Paint();
            this.paint = paint;
            this.path = new Path();
            this.halfDp = BaseDivViewExtensionsKt.dpToPxF(Double.valueOf(0.5d), DivBorderDrawer.this.getDisplayMetrics());
            this.defaultDashWidth = BaseDivViewExtensionsKt.dpToPxF((Number) 6, DivBorderDrawer.this.getDisplayMetrics());
            this.defaultGapWidth = BaseDivViewExtensionsKt.dpToPxF((Number) 2, DivBorderDrawer.this.getDisplayMetrics());
            this.rect = new RectF();
            paint.setStyle(Paint.Style.STROKE);
            paint.setAntiAlias(true);
        }

        public final Paint getPaint() {
            return this.paint;
        }

        public final Path getPath() {
            return this.path;
        }

        /* JADX INFO: renamed from: isDashed, reason: from getter */
        public final boolean getIsDashed() {
            return this.isDashed;
        }

        public final void setDashed(boolean z) {
            this.isDashed = z;
        }

        private final float getStrokeOffset() {
            return Math.min(this.halfDp, Math.max(1.0f, DivBorderDrawer.this.strokeWidth * 0.1f));
        }

        public final void setPaintParams(float strokeWidth, int borderColor) {
            this.paint.setStrokeWidth(strokeWidth + getStrokeOffset());
            this.paint.setColor(borderColor);
        }

        public final void invalidate(float[] radii) {
            Intrinsics.checkNotNullParameter(radii, "radii");
            float strokeOffset = (DivBorderDrawer.this.strokeWidth - getStrokeOffset()) / 2.0f;
            this.rect.set(strokeOffset, strokeOffset, DivBorderDrawer.this.view.getWidth() - strokeOffset, DivBorderDrawer.this.view.getHeight() - strokeOffset);
            this.path.reset();
            this.path.addRoundRect(this.rect, radii, Path.Direction.CW);
            this.path.close();
            this.paint.setPathEffect(this.isDashed ? createDashPathEffect(calculatePerimeter(this.rect.width(), this.rect.height(), radii)) : null);
        }

        private final float calculatePerimeter(float width, float height, float[] radii) {
            float f = 2;
            float fSqrt = (width * f) + (f * height);
            if (radii.length != 8) {
                KLog kLog = KLog.INSTANCE;
                if (kLog.isAtLeast(Severity.ERROR)) {
                    kLog.print(6, "DivBorderDrawer", "Wrong corner radii count " + radii.length + ". Expected 8");
                }
                return fSqrt;
            }
            int i = 0;
            int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, radii.length - 1, 2);
            if (progressionLastElement >= 0) {
                while (true) {
                    float f2 = radii[i];
                    float f3 = radii[i + 1];
                    fSqrt = ((fSqrt - f2) - f3) + ((float) (Math.sqrt(((double) ((f2 * f2) + (f3 * f3))) / 8.0d) * 3.141592653589793d));
                    if (i == progressionLastElement) {
                        break;
                    }
                    i += 2;
                }
            }
            return RangesKt.coerceAtLeast(fSqrt, 0.0f);
        }

        private final DashPathEffect createDashPathEffect(float perimeter) {
            float f;
            float f2;
            if (perimeter > 0.0f) {
                float f3 = this.defaultDashWidth;
                float f4 = this.defaultGapWidth;
                float f5 = f3 + f4;
                float f6 = (int) (perimeter / f5);
                float f7 = perimeter - (f5 * f6);
                f = f3 + (((f7 * f3) / f5) / f6);
                f2 = f4 + (((f7 * f4) / f5) / f6);
            } else {
                f = this.defaultDashWidth;
                f2 = this.defaultGapWidth;
            }
            return new DashPathEffect(new float[]{f, f2}, 0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: DivBorderDrawer.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u0018\u0010#\u001a\u00020 2\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006("}, d2 = {"Lcom/yandex/div/core/view2/divs/widgets/DivBorderDrawer$ShadowParams;", "", "(Lcom/yandex/div/core/view2/divs/widgets/DivBorderDrawer;)V", "alpha", "", "cachedShadow", "Landroid/graphics/NinePatch;", "getCachedShadow", "()Landroid/graphics/NinePatch;", "setCachedShadow", "(Landroid/graphics/NinePatch;)V", "color", "", "defaultRadius", "offsetX", "getOffsetX", "()F", "setOffsetX", "(F)V", "offsetY", "getOffsetY", "setOffsetY", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "radius", "rect", "Landroid/graphics/Rect;", "getRect", "()Landroid/graphics/Rect;", "invalidateShadow", "", "radii", "", "set", "shadow", "Lcom/yandex/div2/DivShadow;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    final class ShadowParams {
        private float alpha;
        private NinePatch cachedShadow;
        private int color;
        private final float defaultRadius;
        private float offsetX;
        private float offsetY;
        private final Paint paint;
        private float radius;
        private final Rect rect;

        public ShadowParams() {
            float dimension = DivBorderDrawer.this.view.getContext().getResources().getDimension(R.dimen.div_shadow_elevation);
            this.defaultRadius = dimension;
            this.radius = dimension;
            this.color = -16777216;
            this.alpha = DivBorderDrawer.DEFAULT_SHADOW_ALPHA;
            this.paint = new Paint();
            this.rect = new Rect();
            this.offsetY = 0.5f;
        }

        public final Paint getPaint() {
            return this.paint;
        }

        public final Rect getRect() {
            return this.rect;
        }

        public final NinePatch getCachedShadow() {
            return this.cachedShadow;
        }

        public final void setCachedShadow(NinePatch ninePatch) {
            this.cachedShadow = ninePatch;
        }

        public final float getOffsetX() {
            return this.offsetX;
        }

        public final void setOffsetX(float f) {
            this.offsetX = f;
        }

        public final float getOffsetY() {
            return this.offsetY;
        }

        public final void setOffsetY(float f) {
            this.offsetY = f;
        }

        public final void set(DivShadow shadow, ExpressionResolver resolver) {
            DivPoint divPoint;
            DivDimension divDimension;
            DivPoint divPoint2;
            DivDimension divDimension2;
            Expression<Double> expression;
            Expression<Integer> expression2;
            Expression<Long> expression3;
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            DisplayMetrics displayMetrics = DivBorderDrawer.this.getDisplayMetrics();
            this.radius = (shadow == null || (expression3 = shadow.blur) == null) ? this.defaultRadius : BaseDivViewExtensionsKt.dpToPxF(Long.valueOf(expression3.evaluate(resolver).longValue()), displayMetrics);
            this.color = (shadow == null || (expression2 = shadow.color) == null) ? -16777216 : expression2.evaluate(resolver).intValue();
            this.alpha = (shadow == null || (expression = shadow.alpha) == null) ? DivBorderDrawer.DEFAULT_SHADOW_ALPHA : (float) expression.evaluate(resolver).doubleValue();
            this.offsetX = ((shadow == null || (divPoint2 = shadow.offset) == null || (divDimension2 = divPoint2.x) == null) ? BaseDivViewExtensionsKt.dpToPx(Float.valueOf(0.0f), displayMetrics) : BaseDivViewExtensionsKt.toPx(divDimension2, displayMetrics, resolver)) - this.radius;
            this.offsetY = ((shadow == null || (divPoint = shadow.offset) == null || (divDimension = divPoint.y) == null) ? BaseDivViewExtensionsKt.dpToPx(Float.valueOf(0.5f), displayMetrics) : BaseDivViewExtensionsKt.toPx(divDimension, displayMetrics, resolver)) - this.radius;
        }

        public final void invalidateShadow(float[] radii) {
            Intrinsics.checkNotNullParameter(radii, "radii");
            float f = 2;
            this.rect.set(0, 0, (int) (DivBorderDrawer.this.view.getWidth() + (this.radius * f)), (int) (DivBorderDrawer.this.view.getHeight() + (this.radius * f)));
            this.paint.setColor(this.color);
            this.paint.setAlpha((int) (this.alpha * DivBorderDrawer.this.view.getAlpha() * 255));
            ShadowCache shadowCache = ShadowCache.INSTANCE;
            Context context = DivBorderDrawer.this.view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            this.cachedShadow = shadowCache.getShadow(context, radii, this.radius);
        }
    }

    /* JADX INFO: compiled from: DivBorderDrawer.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u000e"}, d2 = {"Lcom/yandex/div/core/view2/divs/widgets/DivBorderDrawer$RoundedRectOutlineProvider;", "Landroid/view/ViewOutlineProvider;", "cornerRadius", "", "(F)V", "getCornerRadius", "()F", "setCornerRadius", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class RoundedRectOutlineProvider extends ViewOutlineProvider {
        private float cornerRadius;

        public RoundedRectOutlineProvider() {
            this(0.0f, 1, null);
        }

        public /* synthetic */ RoundedRectOutlineProvider(float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 0.0f : f);
        }

        public final float getCornerRadius() {
            return this.cornerRadius;
        }

        public final void setCornerRadius(float f) {
            this.cornerRadius = f;
        }

        public RoundedRectOutlineProvider(float f) {
            this.cornerRadius = f;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), DivBorderDrawer.INSTANCE.clampCornerRadius(this.cornerRadius, view.getWidth(), view.getHeight()));
        }
    }

    /* JADX INFO: compiled from: DivBorderDrawer.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/yandex/div/core/view2/divs/widgets/DivBorderDrawer$Companion;", "", "()V", "DEFAULT_CORNER_RADIUS", "", "DEFAULT_DX", "DEFAULT_DY", "DEFAULT_SHADOW_ALPHA", "DEFAULT_SHADOW_COLOR", "", "DEFAULT_STROKE_WIDTH", "NO_ELEVATION", "clampCornerRadius", "cornerRadius", "width", "height", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float clampCornerRadius(float cornerRadius, float width, float height) {
            if (height <= 0.0f || width <= 0.0f) {
                return 0.0f;
            }
            float fMin = Math.min(height, width) / 2;
            if (cornerRadius > fMin) {
                KLog kLog = KLog.INSTANCE;
                if (kLog.isAtLeast(Severity.WARNING)) {
                    kLog.print(5, "DivBorderDrawer", "Corner radius " + cornerRadius + " is greater than half of the smallest side " + fMin);
                }
            }
            return Math.min(cornerRadius, fMin);
        }
    }
}
