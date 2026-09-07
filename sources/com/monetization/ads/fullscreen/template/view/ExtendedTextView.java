package com.monetization.ads.fullscreen.template.view;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;
import com.yandex.mobile.ads.impl.ky1;
import com.yandex.mobile.ads.impl.me;
import com.yandex.mobile.ads.impl.ne;
import com.yandex.mobile.ads.impl.ou0;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B;\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/monetization/ads/fullscreen/template/view/ExtendedTextView;", "Landroid/widget/TextView;", "Lcom/yandex/mobile/ads/impl/ou0;", "measureSpecProvider", "", "setMeasureSpecProvider", "(Lcom/yandex/mobile/ads/impl/ou0;)V", "", "autoSizeTextType", "setAutoSizeTextType", "(I)V", "unit", "", ContentDisposition.Parameters.Size, "setTextSize", "(IF)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "defStyleAttr", "Lcom/yandex/mobile/ads/impl/ne;", "appCompatAutoSizeControllerFactory", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/yandex/mobile/ads/impl/ou0;Lcom/yandex/mobile/ads/impl/ne;)V", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
public final class ExtendedTextView extends TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ou0 f7213a;
    private final me b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExtendedTextView(Context context) {
        this(context, null, 0, null, null, 30, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        me meVar;
        super.onLayout(z, i, i2, i3, i4);
        if (Build.VERSION.SDK_INT < 27 && (meVar = this.b) != null) {
            meVar.a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i, int i2) {
        ou0.a aVarA = this.f7213a.a(i, i2);
        super.onMeasure(aVarA.f9859a, aVarA.b);
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence text, int i, int i2, int i3) {
        me meVar;
        Intrinsics.checkNotNullParameter(text, "text");
        super.onTextChanged(text, i, i2, i3);
        if (Build.VERSION.SDK_INT < 27 && (meVar = this.b) != null) {
            meVar.b();
        }
    }

    public final void setAutoSizeTextType(int autoSizeTextType) {
        if (Build.VERSION.SDK_INT >= 27) {
            setAutoSizeTextTypeWithDefaults(autoSizeTextType);
            return;
        }
        me meVar = this.b;
        if (meVar != null) {
            meVar.a(autoSizeTextType);
        }
    }

    public final void setMeasureSpecProvider(ou0 measureSpecProvider) {
        Intrinsics.checkNotNullParameter(measureSpecProvider, "measureSpecProvider");
        this.f7213a = measureSpecProvider;
        requestLayout();
        invalidate();
    }

    @Override // android.widget.TextView
    public void setTextSize(int unit, float size) {
        if (Build.VERSION.SDK_INT >= 27) {
            super.setTextSize(unit, size);
            return;
        }
        me meVar = this.b;
        if (meVar != null) {
            meVar.a(unit, size);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExtendedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, null, null, 28, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExtendedTextView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null, null, 24, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExtendedTextView(Context context, AttributeSet attributeSet, int i, ou0 measureSpecProvider) {
        this(context, attributeSet, i, measureSpecProvider, null, 16, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(measureSpecProvider, "measureSpecProvider");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExtendedTextView(Context context, AttributeSet attributeSet, int i, ou0 measureSpecProvider, ne appCompatAutoSizeControllerFactory) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(measureSpecProvider, "measureSpecProvider");
        Intrinsics.checkNotNullParameter(appCompatAutoSizeControllerFactory, "appCompatAutoSizeControllerFactory");
        this.f7213a = measureSpecProvider;
        appCompatAutoSizeControllerFactory.getClass();
        this.b = ne.a(this);
    }

    public /* synthetic */ ExtendedTextView(Context context, AttributeSet attributeSet, int i, ou0 ou0Var, ne neVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? new ky1() : ou0Var, (i2 & 16) != 0 ? new ne() : neVar);
    }
}
