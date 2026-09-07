package com.yandex.div.core.view2.divs.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import androidx.compose.material.OutlinedTextFieldKt;
import com.android.billingclient.api.BillingClient;
import com.yandex.div.R;
import com.yandex.div.core.Disposable;
import com.yandex.div.core.extension.DivExtensionView;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.widget.LoadableImageView;
import com.yandex.div2.DivBorder;
import com.yandex.div2.DivImage;
import io.bidmachine.unified.UnifiedMediationParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivImageView.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0010\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004B%\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010(H\u0096\u0001J\u0010\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\nH\u0014J\t\u00100\u001a\u00020,H\u0096\u0001J\u0010\u00101\u001a\u00020,2\u0006\u00102\u001a\u000203H\u0014J\u0010\u00104\u001a\u00020,2\u0006\u00102\u001a\u000203H\u0016J\u000b\u00105\u001a\u0004\u0018\u000106H\u0096\u0001J\t\u00107\u001a\u00020,H\u0096\u0001J\u0019\u00108\u001a\u00020,2\u0006\u00109\u001a\u00020\n2\u0006\u0010:\u001a\u00020\nH\u0096\u0001J(\u0010;\u001a\u00020,2\u0006\u0010<\u001a\u00020\n2\u0006\u0010=\u001a\u00020\n2\u0006\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020\nH\u0014J\t\u0010@\u001a\u00020,H\u0096\u0001J\t\u0010A\u001a\u00020,H\u0096\u0001J\u0010\u0010B\u001a\u00020,2\u0006\u0010C\u001a\u00020\u001eH\u0016J#\u0010D\u001a\u00020,2\u0006\u0010\f\u001a\u00020\r2\b\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010G\u001a\u00020HH\u0096\u0001J\u0010\u0010I\u001a\u00020,2\u0006\u0010J\u001a\u00020\u001eH\u0016J\u0011\u0010K\u001a\u00020,2\u0006\u0010G\u001a\u00020HH\u0096\u0001J\u0011\u0010L\u001a\u00020,2\u0006\u0010G\u001a\u00020HH\u0096\u0001R\u001a\u0010\f\u001a\u0004\u0018\u00010\rX\u0096\u000f¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0096\u000f¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001d\u001a\u00020\u001eX\u0096\u000f¢\u0006\f\u001a\u0004\b\u001d\u0010\u001f\"\u0004\b \u0010!R\u0012\u0010\"\u001a\u00020\u001eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\"\u0010\u001fR\u0018\u0010#\u001a\u00020\u001eX\u0096\u000f¢\u0006\f\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R\u0018\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'X\u0096\u0005¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006M"}, d2 = {"Lcom/yandex/div/core/view2/divs/widgets/DivImageView;", "Lcom/yandex/div/core/widget/LoadableImageView;", "Lcom/yandex/div/core/view2/divs/widgets/DivHolderView;", "Lcom/yandex/div2/DivImage;", "Lcom/yandex/div/core/extension/DivExtensionView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bindingContext", "Lcom/yandex/div/core/view2/BindingContext;", "getBindingContext", "()Lcom/yandex/div/core/view2/BindingContext;", "setBindingContext", "(Lcom/yandex/div/core/view2/BindingContext;)V", "div", "getDiv", "()Lcom/yandex/div2/DivImage;", "setDiv", "(Lcom/yandex/div2/DivImage;)V", UnifiedMediationParams.KEY_IMAGE_URL, "Landroid/net/Uri;", "getImageUrl$div_release", "()Landroid/net/Uri;", "setImageUrl$div_release", "(Landroid/net/Uri;)V", "isDrawing", "", "()Z", "setDrawing", "(Z)V", "isTransient", "needClipping", "getNeedClipping", "setNeedClipping", BillingClient.FeatureType.SUBSCRIPTIONS, "", "Lcom/yandex/div/core/Disposable;", "getSubscriptions", "()Ljava/util/List;", "addSubscription", "", "subscription", "canResizeWidth", "widthMeasureSpec", "closeAllSubscription", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "draw", "getDivBorderDrawer", "Lcom/yandex/div/core/view2/divs/widgets/DivBorderDrawer;", "invalidateBorder", "onBoundsChanged", "width", "height", "onSizeChanged", "w", "h", "oldw", "oldh", "release", "releaseBorderDrawer", "setAdjustViewBounds", "adjustViewBounds", "setBorder", OutlinedTextFieldKt.BorderId, "Lcom/yandex/div2/DivBorder;", "view", "Landroid/view/View;", "setCropToPadding", "cropToPadding", "transitionFinished", "transitionStarted", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class DivImageView extends LoadableImageView implements DivHolderView<DivImage>, DivExtensionView {
    private final /* synthetic */ DivHolderViewMixin<DivImage> $$delegate_0;
    private Uri imageUrl;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DivImageView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DivImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.yandex.div.internal.core.ExpressionSubscriber
    public void addSubscription(Disposable subscription) {
        this.$$delegate_0.addSubscription(subscription);
    }

    @Override // com.yandex.div.internal.widget.AspectImageView
    protected boolean canResizeWidth(int widthMeasureSpec) {
        return false;
    }

    @Override // com.yandex.div.internal.core.ExpressionSubscriber
    public void closeAllSubscription() {
        this.$$delegate_0.closeAllSubscription();
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivHolderView
    public BindingContext getBindingContext() {
        return this.$$delegate_0.getBindingContext();
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivHolderView
    public DivImage getDiv() {
        return (DivImage) this.$$delegate_0.getDiv();
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivBorderSupports
    public DivBorderDrawer getDivBorderDrawer() {
        return this.$$delegate_0.getDivBorderDrawer();
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivBorderSupports
    public boolean getNeedClipping() {
        return this.$$delegate_0.getNeedClipping();
    }

    @Override // com.yandex.div.internal.core.ExpressionSubscriber
    public List<Disposable> getSubscriptions() {
        return this.$$delegate_0.getSubscriptions();
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivBorderSupports
    public void invalidateBorder() {
        this.$$delegate_0.invalidateBorder();
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivBorderSupports
    public boolean isDrawing() {
        return this.$$delegate_0.isDrawing();
    }

    @Override // com.yandex.div.internal.widget.TransientView
    public boolean isTransient() {
        return this.$$delegate_0.isTransient();
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivBorderSupports
    public void onBoundsChanged(int width, int height) {
        this.$$delegate_0.onBoundsChanged(width, height);
    }

    @Override // com.yandex.div.internal.core.ExpressionSubscriber, com.yandex.div.core.view2.Releasable
    public void release() {
        this.$$delegate_0.release();
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivBorderSupports
    public void releaseBorderDrawer() {
        this.$$delegate_0.releaseBorderDrawer();
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean adjustViewBounds) {
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivHolderView
    public void setBindingContext(BindingContext bindingContext) {
        this.$$delegate_0.setBindingContext(bindingContext);
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivBorderSupports
    public void setBorder(BindingContext bindingContext, DivBorder border, View view) {
        Intrinsics.checkNotNullParameter(bindingContext, "bindingContext");
        Intrinsics.checkNotNullParameter(view, "view");
        this.$$delegate_0.setBorder(bindingContext, border, view);
    }

    @Override // android.widget.ImageView
    public void setCropToPadding(boolean cropToPadding) {
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivHolderView
    public void setDiv(DivImage divImage) {
        this.$$delegate_0.setDiv(divImage);
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivBorderSupports
    public void setDrawing(boolean z) {
        this.$$delegate_0.setDrawing(z);
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivBorderSupports
    public void setNeedClipping(boolean z) {
        this.$$delegate_0.setNeedClipping(z);
    }

    @Override // com.yandex.div.internal.widget.TransientView
    public void transitionFinished(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.$$delegate_0.transitionFinished(view);
    }

    @Override // com.yandex.div.internal.widget.TransientView
    public void transitionStarted(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.$$delegate_0.transitionStarted(view);
    }

    public /* synthetic */ DivImageView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R.attr.divImageStyle : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DivImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.$$delegate_0 = new DivHolderViewMixin<>();
        super.setAdjustViewBounds(true);
        super.setCropToPadding(true);
    }

    /* JADX INFO: renamed from: getImageUrl$div_release, reason: from getter */
    public final Uri getImageUrl() {
        return this.imageUrl;
    }

    public final void setImageUrl$div_release(Uri uri) {
        this.imageUrl = uri;
    }

    @Override // com.yandex.div.internal.widget.AspectImageView, android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        onBoundsChanged(w, h);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Unit unit;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        DivImageView divImageView = this;
        divImageView.setDrawing(true);
        DivBorderDrawer divBorderDrawer = divImageView.getDivBorderDrawer();
        if (divBorderDrawer != null) {
            if (divBorderDrawer != null) {
                int iSave = canvas.save();
                try {
                    divBorderDrawer.clipCorners(canvas);
                    super.draw(canvas);
                    divBorderDrawer.drawBorder(canvas);
                    canvas.restoreToCount(iSave);
                } catch (Throwable th) {
                    canvas.restoreToCount(iSave);
                    throw th;
                }
            } else {
                super.draw(canvas);
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            super.draw(canvas);
        }
        divImageView.setDrawing(false);
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Unit unit;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        DivImageView divImageView = this;
        if (!divImageView.isDrawing()) {
            DivBorderDrawer divBorderDrawer = divImageView.getDivBorderDrawer();
            if (divBorderDrawer != null) {
                if (divBorderDrawer != null) {
                    int iSave = canvas.save();
                    try {
                        divBorderDrawer.clipCorners(canvas);
                        super.dispatchDraw(canvas);
                        divBorderDrawer.drawBorder(canvas);
                        canvas.restoreToCount(iSave);
                    } catch (Throwable th) {
                        canvas.restoreToCount(iSave);
                        throw th;
                    }
                } else {
                    super.dispatchDraw(canvas);
                }
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit != null) {
                return;
            }
        }
        super.dispatchDraw(canvas);
    }
}
