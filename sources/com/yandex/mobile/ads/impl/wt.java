package com.yandex.mobile.ads.impl;

import android.R;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.monetization.ads.nativeads.CustomizableMediaView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes6.dex */
public abstract class wt extends FrameLayout {
    private ImageView A;
    private LinearLayout B;
    private CustomizableMediaView C;
    private LinearLayout D;
    private ot E;
    private i91 F;
    private x81 G;
    private y51 H;
    private m61 I;
    private final b J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l10 f10588a;
    private final xt b;
    private final lp1 c;
    private final int d;
    private final int e;
    private final int f;
    private cu g;
    private TextView h;
    private TextView i;
    private Button j;
    private TextView k;
    private ImageView l;
    private final ImageView m;
    private x12 n;
    private TextView o;
    private TextView p;
    private ImageView q;
    private in1 r;
    private TextView s;
    private ImageView t;
    private ImageView u;
    private LinearLayout v;
    private FrameLayout w;
    private LinearLayout x;
    private LinearLayout y;
    private LinearLayout z;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10589a;

        static {
            int[] iArr = new int[ha1.a.values().length];
            try {
                ha1.a aVar = ha1.a.b;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                ha1.a aVar2 = ha1.a.b;
                iArr[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                ha1.a aVar3 = ha1.a.b;
                iArr[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f10589a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public wt(Context context, AttributeSet attributeSet, int i, cu defaultTemplateAppearance, l92 varioqubAdapterProvider, ie appAdAnalyticsActivator) {
        this(context, attributeSet, i, defaultTemplateAppearance, varioqubAdapterProvider, appAdAnalyticsActivator, null, null, null, 448, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(defaultTemplateAppearance, "defaultTemplateAppearance");
        Intrinsics.checkNotNullParameter(varioqubAdapterProvider, "varioqubAdapterProvider");
        Intrinsics.checkNotNullParameter(appAdAnalyticsActivator, "appAdAnalyticsActivator");
    }

    private final ImageView c() {
        ImageView imageView = new ImageView(getContext());
        imageView.setAdjustViewBounds(true);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return imageView;
    }

    public final void applyAppearance(cu templateAppearance) {
        Intrinsics.checkNotNullParameter(templateAppearance, "templateAppearance");
        if (Intrinsics.areEqual(templateAppearance, this.g)) {
            return;
        }
        this.g = templateAppearance;
        a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.y, this, me);
        return super.dispatchTouchEvent(me);
    }

    public final void setAd(m61 nativeAd) {
        Intrinsics.checkNotNullParameter(nativeAd, "nativeAd");
        m61 m61Var = this.I;
        if (m61Var != nativeAd) {
            if (m61Var != null) {
                try {
                    m61Var.a(this.J);
                } catch (a61 e) {
                    op0.b(new Object[0]);
                    this.c.reportError("Failed to set Native Ad", e);
                    return;
                }
            }
            nativeAd.b(this.J);
            zq1 adType = nativeAd.getAdType();
            ot adAssets = nativeAd.getAdAssets();
            this.F = new i91(adAssets, adType);
            this.G = new x81(adAssets, adType);
            this.E = adAssets;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            oa0 oa0Var = new oa0(context, adAssets, new pa0(adAssets, new ki()));
            ImageView feedbackView = getFeedbackView();
            FrameLayout frameLayout = this.w;
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedbackContainer");
                frameLayout = null;
            }
            oa0Var.a(feedbackView, frameLayout, this.f);
            this.b.getClass();
            nativeAd.b(xt.a(this));
            showContent();
            this.I = nativeAd;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public wt(Context context, AttributeSet attributeSet, int i, cu defaultTemplateAppearance, l92 varioqubAdapterProvider, ie appAdAnalyticsActivator, l10 dimensionConverter) {
        this(context, attributeSet, i, defaultTemplateAppearance, varioqubAdapterProvider, appAdAnalyticsActivator, dimensionConverter, null, null, 384, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(defaultTemplateAppearance, "defaultTemplateAppearance");
        Intrinsics.checkNotNullParameter(varioqubAdapterProvider, "varioqubAdapterProvider");
        Intrinsics.checkNotNullParameter(appAdAnalyticsActivator, "appAdAnalyticsActivator");
        Intrinsics.checkNotNullParameter(dimensionConverter, "dimensionConverter");
    }

    private final void a() {
        float borderWidth = this.g.getBannerAppearance().getBorderWidth();
        l10 l10Var = this.f10588a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        l10Var.getClass();
        int iA = l10.a(context, borderWidth);
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setShape(new RectShape());
        Paint paint = shapeDrawable.getPaint();
        paint.setColor(this.g.getBannerAppearance().getBackgroundColor());
        paint.setStyle(Paint.Style.FILL);
        ShapeDrawable shapeDrawable2 = new ShapeDrawable();
        shapeDrawable2.setShape(new RectShape());
        Paint paint2 = shapeDrawable2.getPaint();
        paint2.setColor(this.g.getBannerAppearance().getBorderColor());
        paint2.setStrokeWidth(iA * 2.0f);
        Paint.Style style = Paint.Style.STROKE;
        paint2.setStyle(style);
        setBackground(new LayerDrawable(new Drawable[]{shapeDrawable, shapeDrawable2}));
        setPadding(iA, iA, iA, iA);
        ea1 contentPadding = this.g.getBannerAppearance().getContentPadding();
        x12 x12Var = null;
        if (contentPadding != null) {
            l10 l10Var2 = this.f10588a;
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            float left = contentPadding.getLeft();
            l10Var2.getClass();
            int iA2 = l10.a(context2, left);
            l10 l10Var3 = this.f10588a;
            Context context3 = getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
            float right = contentPadding.getRight();
            l10Var3.getClass();
            int iA3 = l10.a(context3, right);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(iA2, this.e, iA3, this.d);
            LinearLayout linearLayout = this.x;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topContainer");
                linearLayout = null;
            }
            linearLayout.setLayoutParams(layoutParams);
            LinearLayout linearLayout2 = this.x;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topContainer");
                linearLayout2 = null;
            }
            linearLayout2.invalidate();
        }
        ea1 contentPadding2 = this.g.getBannerAppearance().getContentPadding();
        if (contentPadding2 != null) {
            l10 l10Var4 = this.f10588a;
            Context context4 = getContext();
            Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
            float left2 = contentPadding2.getLeft();
            l10Var4.getClass();
            int iA4 = l10.a(context4, left2);
            l10 l10Var5 = this.f10588a;
            Context context5 = getContext();
            Intrinsics.checkNotNullExpressionValue(context5, "getContext(...)");
            float right2 = contentPadding2.getRight();
            l10Var5.getClass();
            int iA5 = l10.a(context5, right2);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.leftMargin = iA4;
            layoutParams2.rightMargin = iA5;
            layoutParams2.bottomMargin = this.d;
            LinearLayout linearLayout3 = this.y;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
                linearLayout3 = null;
            }
            linearLayout3.setLayoutParams(layoutParams2);
            LinearLayout linearLayout4 = this.y;
            if (linearLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
                linearLayout4 = null;
            }
            linearLayout4.invalidate();
        }
        ea1 contentPadding3 = this.g.getBannerAppearance().getContentPadding();
        if (contentPadding3 != null) {
            l10 l10Var6 = this.f10588a;
            Context context6 = getContext();
            Intrinsics.checkNotNullExpressionValue(context6, "getContext(...)");
            float left3 = contentPadding3.getLeft();
            l10Var6.getClass();
            int iA6 = l10.a(context6, left3);
            l10 l10Var7 = this.f10588a;
            Context context7 = getContext();
            Intrinsics.checkNotNullExpressionValue(context7, "getContext(...)");
            float right3 = contentPadding3.getRight();
            l10Var7.getClass();
            int iA7 = l10.a(context7, right3);
            TextView warningView = getWarningView();
            int i = this.d;
            warningView.setPadding(iA6, i, iA7, i);
            getWarningView().invalidate();
        }
        ia1 textAppearance = this.g.getCallToActionAppearance().getTextAppearance();
        if (textAppearance != null) {
            getCallToActionView().setTextColor(textAppearance.getTextColor());
        }
        ia1 textAppearance2 = this.g.getCallToActionAppearance().getTextAppearance();
        if (textAppearance2 != null) {
            getCallToActionView().setTextSize(textAppearance2.getTextSize());
            Button callToActionView = getCallToActionView();
            ia1 textAppearance3 = this.g.getCallToActionAppearance().getTextAppearance();
            callToActionView.setTypeface(Typeface.create(textAppearance3 != null ? textAppearance3.getFontFamilyName() : null, textAppearance2.getFontStyle()));
        }
        l10 l10Var8 = this.f10588a;
        Context context8 = getContext();
        Intrinsics.checkNotNullExpressionValue(context8, "getContext(...)");
        l10Var8.getClass();
        float fA = l10.a(context8, 5.0f);
        float[] fArr = new float[8];
        Arrays.fill(fArr, fA);
        RoundRectShape roundRectShape = new RoundRectShape(fArr, null, fArr);
        ShapeDrawable shapeDrawable3 = new ShapeDrawable(roundRectShape);
        shapeDrawable3.getPaint().setColor(this.g.getCallToActionAppearance().getPressedColor());
        ShapeDrawable shapeDrawable4 = new ShapeDrawable(roundRectShape);
        shapeDrawable4.getPaint().setColor(this.g.getCallToActionAppearance().getNormalColor());
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_selected}, shapeDrawable3);
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, shapeDrawable3);
        stateListDrawable.addState(new int[0], shapeDrawable4);
        l10 l10Var9 = this.f10588a;
        Context context9 = getContext();
        Intrinsics.checkNotNullExpressionValue(context9, "getContext(...)");
        float borderWidth2 = this.g.getCallToActionAppearance().getBorderWidth();
        l10Var9.getClass();
        int iA8 = l10.a(context9, borderWidth2);
        ShapeDrawable shapeDrawable5 = new ShapeDrawable();
        shapeDrawable5.setShape(roundRectShape);
        Paint paint3 = shapeDrawable5.getPaint();
        paint3.setColor(this.g.getCallToActionAppearance().getBorderColor());
        paint3.setStrokeWidth(iA8);
        paint3.setStyle(style);
        getCallToActionView().setBackground(new LayerDrawable(new Drawable[]{stateListDrawable, shapeDrawable5}));
        in1 in1Var = this.r;
        if (in1Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_ratingView");
            in1Var = null;
        }
        Drawable progressDrawable = in1Var.getProgressDrawable();
        Intrinsics.checkNotNull(progressDrawable, "null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
        LayerDrawable layerDrawable = (LayerDrawable) progressDrawable;
        Drawable drawable = layerDrawable.getDrawable(2);
        int progressStarColor = this.g.getRatingAppearance().getProgressStarColor();
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_ATOP;
        drawable.setColorFilter(progressStarColor, mode);
        layerDrawable.getDrawable(1).setColorFilter(this.g.getRatingAppearance().getBackgroundStarColor(), mode);
        layerDrawable.getDrawable(0).setColorFilter(this.g.getRatingAppearance().getBackgroundStarColor(), mode);
        getAgeView().setTypeface(Typeface.create(this.g.getAgeAppearance().getFontFamilyName(), this.g.getAgeAppearance().getFontStyle()));
        getAgeView().setTextColor(this.g.getAgeAppearance().getTextColor());
        getAgeView().setTextSize(2, this.g.getAgeAppearance().getTextSize());
        getBodyView().setTypeface(Typeface.create(this.g.getBodyAppearance().getFontFamilyName(), this.g.getBodyAppearance().getFontStyle()));
        getBodyView().setTextColor(this.g.getBodyAppearance().getTextColor());
        getBodyView().setTextSize(2, this.g.getBodyAppearance().getTextSize());
        getDomainView().setTypeface(Typeface.create(this.g.getDomainAppearance().getFontFamilyName(), this.g.getDomainAppearance().getFontStyle()));
        getDomainView().setTextColor(this.g.getDomainAppearance().getTextColor());
        getDomainView().setTextSize(2, this.g.getDomainAppearance().getTextSize());
        getReviewCountView().setTypeface(Typeface.create(this.g.getReviewCountAppearance().getFontFamilyName(), this.g.getReviewCountAppearance().getFontStyle()));
        getReviewCountView().setTextColor(this.g.getReviewCountAppearance().getTextColor());
        getReviewCountView().setTextSize(2, this.g.getReviewCountAppearance().getTextSize());
        x12 x12Var2 = this.n;
        if (x12Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_sponsoredView");
            x12Var2 = null;
        }
        x12Var2.setTypeface(Typeface.create(this.g.getSponsoredAppearance().getFontFamilyName(), this.g.getSponsoredAppearance().getFontStyle()));
        x12 x12Var3 = this.n;
        if (x12Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_sponsoredView");
            x12Var3 = null;
        }
        x12Var3.setTextColor(this.g.getSponsoredAppearance().getTextColor());
        x12 x12Var4 = this.n;
        if (x12Var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_sponsoredView");
        } else {
            x12Var = x12Var4;
        }
        x12Var.setTextSize(2, this.g.getSponsoredAppearance().getTextSize());
        getTitleView().setTypeface(Typeface.create(this.g.getTitleAppearance().getFontFamilyName(), this.g.getTitleAppearance().getFontStyle()));
        getTitleView().setTextColor(this.g.getTitleAppearance().getTextColor());
        getTitleView().setTextSize(2, this.g.getTitleAppearance().getTextSize());
        getWarningView().setTypeface(Typeface.create(this.g.getWarningAppearance().getFontFamilyName(), this.g.getWarningAppearance().getFontStyle()));
        getWarningView().setTextColor(this.g.getWarningAppearance().getTextColor());
        getWarningView().setTextSize(2, this.g.getWarningAppearance().getTextSize());
        invalidate();
        requestLayout();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public wt(Context context, AttributeSet attributeSet, int i, cu defaultTemplateAppearance, l92 varioqubAdapterProvider, ie appAdAnalyticsActivator, l10 dimensionConverter, xt coreNativeBannerViewAdapter) {
        this(context, attributeSet, i, defaultTemplateAppearance, varioqubAdapterProvider, appAdAnalyticsActivator, dimensionConverter, coreNativeBannerViewAdapter, null, 256, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(defaultTemplateAppearance, "defaultTemplateAppearance");
        Intrinsics.checkNotNullParameter(varioqubAdapterProvider, "varioqubAdapterProvider");
        Intrinsics.checkNotNullParameter(appAdAnalyticsActivator, "appAdAnalyticsActivator");
        Intrinsics.checkNotNullParameter(dimensionConverter, "dimensionConverter");
        Intrinsics.checkNotNullParameter(coreNativeBannerViewAdapter, "coreNativeBannerViewAdapter");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wt(Context context, AttributeSet attributeSet, int i, cu defaultTemplateAppearance, l92 varioqubAdapterProvider, ie appAdAnalyticsActivator, l10 dimensionConverter, xt coreNativeBannerViewAdapter, lp1 reporter) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(defaultTemplateAppearance, "defaultTemplateAppearance");
        Intrinsics.checkNotNullParameter(varioqubAdapterProvider, "varioqubAdapterProvider");
        Intrinsics.checkNotNullParameter(appAdAnalyticsActivator, "appAdAnalyticsActivator");
        Intrinsics.checkNotNullParameter(dimensionConverter, "dimensionConverter");
        Intrinsics.checkNotNullParameter(coreNativeBannerViewAdapter, "coreNativeBannerViewAdapter");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        this.f10588a = dimensionConverter;
        this.b = coreNativeBannerViewAdapter;
        this.c = reporter;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        dimensionConverter.getClass();
        this.d = l10.a(context2, 4.0f);
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
        this.e = l10.a(context3, 8.0f);
        Context context4 = getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
        this.f = l10.a(context4, 12.0f);
        this.g = defaultTemplateAppearance;
        this.m = c();
        this.J = new b();
        b();
    }

    public final TextView getAgeView() {
        TextView textView = this.h;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ageView");
        return null;
    }

    public final TextView getBodyView() {
        TextView textView = this.i;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bodyView");
        return null;
    }

    public final Button getCallToActionView() {
        Button button = this.j;
        if (button != null) {
            return button;
        }
        Intrinsics.throwUninitializedPropertyAccessException("callToActionView");
        return null;
    }

    public final TextView getDomainView() {
        TextView textView = this.k;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("domainView");
        return null;
    }

    public final ImageView getFeedbackView() {
        ImageView imageView = this.l;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("feedbackView");
        return null;
    }

    public final ImageView getImageView() {
        ot otVar;
        qt image;
        ImageView imageView = this.m;
        if (this.G == null || (otVar = this.E) == null || (image = otVar.h()) == null) {
            return imageView;
        }
        Intrinsics.checkNotNullParameter(image, "image");
        if (Intrinsics.areEqual("fill", image.c())) {
            ImageView imageView2 = this.u;
            if (imageView2 != null) {
                return imageView2;
            }
            Intrinsics.throwUninitializedPropertyAccessException("adFoxView");
        } else {
            if (!x81.a(image)) {
                return imageView;
            }
            ImageView imageView3 = this.A;
            if (imageView3 != null) {
                return imageView3;
            }
            Intrinsics.throwUninitializedPropertyAccessException("largeImageView");
        }
        return null;
    }

    public final TextView getSponsoredView() {
        x12 x12Var = this.n;
        if (x12Var != null) {
            return x12Var;
        }
        Intrinsics.throwUninitializedPropertyAccessException("_sponsoredView");
        return null;
    }

    public final TextView getTitleView() {
        TextView textView = this.o;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
        return null;
    }

    public final TextView getWarningView() {
        TextView textView = this.p;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("warningView");
        return null;
    }

    public final ImageView getIconView() {
        ImageView imageView = this.q;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        return null;
    }

    public final View getRatingView() {
        in1 in1Var = this.r;
        if (in1Var != null) {
            return in1Var;
        }
        Intrinsics.throwUninitializedPropertyAccessException("_ratingView");
        return null;
    }

    public final TextView getReviewCountView() {
        TextView textView = this.s;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("reviewCountView");
        return null;
    }

    public final ImageView getFaviconView() {
        ImageView imageView = this.t;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("faviconView");
        return null;
    }

    public final CustomizableMediaView getMediaView() {
        CustomizableMediaView customizableMediaView = this.C;
        if (customizableMediaView != null) {
            return customizableMediaView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mediaView");
        return null;
    }

    public static final class b implements rt {
        b() {
        }

        @Override // com.yandex.mobile.ads.impl.rt
        public final void onFinishLoadingImages() {
            m61 m61Var = wt.this.I;
            if (m61Var != null) {
                m61Var.a(this);
            }
            y51 y51Var = wt.this.H;
            if (y51Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nativeAdImagesAnimator");
                y51Var = null;
            }
            y51Var.a();
        }
    }

    private static fj0 a(ha1 ha1Var) {
        ha1.a b2 = ha1Var.getSizeConstraintType().getB();
        int i = b2 == null ? -1 : a.f10589a[b2.ordinal()];
        if (i == 1) {
            return new fj0.a(ha1Var.getValue());
        }
        if (i == 2) {
            return new fj0.b(ha1Var.getValue());
        }
        if (i != 3) {
            return new fj0.c(ha1Var.getValue());
        }
        return new fj0.c(ha1Var.getValue());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m61 m61Var = this.I;
        if (m61Var != null) {
            m61Var.b(this.J);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        m61 m61Var = this.I;
        if (m61Var != null) {
            m61Var.a(this.J);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected final void onMeasure(int i, int i2) {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout linearLayout;
        qt image;
        int iRoundToInt;
        int iRoundToInt2;
        i91 i91Var;
        ot otVar;
        qt qtVarH;
        ot otVar2;
        qt qtVarG;
        ot otVar3;
        qt qtVarE;
        int size = View.MeasureSpec.getSize(i);
        float borderWidth = this.g.getBannerAppearance().getBorderWidth();
        l10 l10Var = this.f10588a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        l10Var.getClass();
        int iA = size - (l10.a(context, borderWidth) * 2);
        if (iA < 0) {
            iA = 0;
        }
        x81 x81Var = this.G;
        if (x81Var != null) {
            ea1 contentPadding = this.g.getBannerAppearance().getContentPadding();
            if (contentPadding != null) {
                Context context2 = getContext();
                l10 l10Var2 = this.f10588a;
                Intrinsics.checkNotNull(context2);
                float left = contentPadding.getLeft();
                l10Var2.getClass();
                int iA2 = l10.a(context2, left);
                l10 l10Var3 = this.f10588a;
                float right = contentPadding.getRight();
                l10Var3.getClass();
                Intrinsics.checkNotNullParameter(context2, "context");
                int iRoundToInt3 = MathKt.roundToInt(TypedValue.applyDimension(1, right, context2.getResources().getDisplayMetrics()));
                ea1 imageMargins = this.g.getBannerAppearance().getImageMargins();
                if (imageMargins != null) {
                    if (!x81Var.a() && !x81Var.b() && !x81Var.e()) {
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(0, 0);
                        getFaviconView().setLayoutParams(layoutParams2);
                        getIconView().setLayoutParams(layoutParams2);
                        this.m.setLayoutParams(layoutParams2);
                        LinearLayout linearLayout2 = this.y;
                        if (linearLayout2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
                            linearLayout2 = null;
                        }
                        ViewGroup.LayoutParams layoutParams3 = linearLayout2.getLayoutParams();
                        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams3;
                        layoutParams4.leftMargin = iA2;
                        LinearLayout linearLayout3 = this.y;
                        if (linearLayout3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
                            linearLayout3 = null;
                        }
                        linearLayout3.setLayoutParams(layoutParams4);
                    } else {
                        int iRoundToInt4 = MathKt.roundToInt((iA - iA2) - iRoundToInt3);
                        float left2 = imageMargins.getLeft();
                        l10 l10Var4 = this.f10588a;
                        Context context3 = getContext();
                        Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
                        l10Var4.getClass();
                        int iA3 = l10.a(context3, left2);
                        this.f10588a.getClass();
                        Intrinsics.checkNotNullParameter(context2, "context");
                        int iRoundToInt5 = MathKt.roundToInt(TypedValue.applyDimension(1, iA2, context2.getResources().getDisplayMetrics())) + iA3;
                        float right2 = imageMargins.getRight();
                        l10 l10Var5 = this.f10588a;
                        Context context4 = getContext();
                        Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
                        l10Var5.getClass();
                        int iA4 = l10.a(context4, right2);
                        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(0, 0);
                        if (x81Var.a() && (otVar3 = this.E) != null && (qtVarE = otVar3.e()) != null) {
                            int iD = qtVarE.d();
                            int iB = qtVarE.b();
                            ha1 widthConstraint = this.g.getFaviconAppearance().getWidthConstraint();
                            if (widthConstraint != null) {
                                fj0 fj0VarA = a(widthConstraint);
                                Context context5 = getContext();
                                Intrinsics.checkNotNullExpressionValue(context5, "getContext(...)");
                                fj0.d dVarA = fj0VarA.a(context5, iRoundToInt4, iD, iB);
                                l10 l10Var6 = this.f10588a;
                                Context context6 = getContext();
                                Intrinsics.checkNotNullExpressionValue(context6, "getContext(...)");
                                l10Var6.getClass();
                                int iA5 = l10.a(context6, 5.0f);
                                FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(dVarA.b(), dVarA.a());
                                layoutParams6.leftMargin = iRoundToInt5;
                                layoutParams6.rightMargin = iA5;
                                layoutParams5 = layoutParams6;
                            }
                        }
                        getFaviconView().setLayoutParams(layoutParams5);
                        FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(0, 0);
                        if (x81Var.b() && (otVar2 = this.E) != null && (qtVarG = otVar2.g()) != null) {
                            layoutParams7 = new FrameLayout.LayoutParams(0, 0);
                            ha1 widthConstraint2 = this.g.getImageAppearance().getWidthConstraint();
                            if (widthConstraint2 != null) {
                                int iD2 = qtVarG.d();
                                int iB2 = qtVarG.b();
                                fj0 fj0VarA2 = a(widthConstraint2);
                                Context context7 = getContext();
                                Intrinsics.checkNotNullExpressionValue(context7, "getContext(...)");
                                fj0.d dVarA2 = fj0VarA2.a(context7, iRoundToInt4, iD2, iB2);
                                FrameLayout.LayoutParams layoutParams8 = new FrameLayout.LayoutParams(dVarA2.b(), dVarA2.a());
                                layoutParams8.leftMargin = iRoundToInt5;
                                layoutParams8.rightMargin = iA4;
                                layoutParams7 = layoutParams8;
                            }
                        }
                        getIconView().setLayoutParams(layoutParams7);
                        FrameLayout.LayoutParams layoutParams9 = new FrameLayout.LayoutParams(0, 0);
                        if (x81Var.e() && (otVar = this.E) != null && (qtVarH = otVar.h()) != null) {
                            layoutParams9 = new FrameLayout.LayoutParams(0, 0);
                            ha1 widthConstraint3 = this.g.getImageAppearance().getWidthConstraint();
                            if (widthConstraint3 != null) {
                                int iD3 = qtVarH.d();
                                int iB3 = qtVarH.b();
                                fj0 fj0VarA3 = a(widthConstraint3);
                                Context context8 = getContext();
                                Intrinsics.checkNotNullExpressionValue(context8, "getContext(...)");
                                fj0.d dVarA3 = fj0VarA3.a(context8, iRoundToInt4, iD3, iB3);
                                layoutParams9 = new FrameLayout.LayoutParams(dVarA3.b(), dVarA3.a());
                                layoutParams9.leftMargin = iRoundToInt5;
                                layoutParams9.rightMargin = iA4;
                            }
                        }
                        this.m.setLayoutParams(layoutParams9);
                        LinearLayout linearLayout4 = this.y;
                        if (linearLayout4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
                            linearLayout4 = null;
                        }
                        ViewGroup.LayoutParams layoutParams10 = linearLayout4.getLayoutParams();
                        Intrinsics.checkNotNull(layoutParams10, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                        LinearLayout.LayoutParams layoutParams11 = (LinearLayout.LayoutParams) layoutParams10;
                        layoutParams11.leftMargin = 0;
                        LinearLayout linearLayout5 = this.y;
                        if (linearLayout5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
                            linearLayout5 = null;
                        }
                        linearLayout5.setLayoutParams(layoutParams11);
                    }
                }
            }
            LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(0, 0);
            if (x81Var.c()) {
                layoutParams12 = new LinearLayout.LayoutParams(0, 0);
                ot otVar4 = this.E;
                if (otVar4 != null && (image = otVar4.h()) != null) {
                    int iD4 = image.d();
                    int iB4 = image.b();
                    Intrinsics.checkNotNullParameter(image, "image");
                    float fD = image.d();
                    float fB = image.b();
                    if (fB != 0.0f && fD / fB < 1.0f) {
                        iRoundToInt2 = MathKt.roundToInt(iA * 0.75f);
                        iRoundToInt = MathKt.roundToInt((iRoundToInt2 / iB4) * iD4);
                    } else {
                        if (iD4 != 0) {
                            iB4 = MathKt.roundToInt(iB4 * (iA / iD4));
                        }
                        iRoundToInt = iA;
                        iRoundToInt2 = iB4;
                    }
                    Intrinsics.checkNotNullParameter(image, "image");
                    float fD2 = image.d();
                    float fB2 = image.b();
                    if (fB2 == 0.0f || fD2 / fB2 <= 1.5f) {
                        iRoundToInt2 = MathKt.roundToInt(iRoundToInt2 * 0.8f);
                    }
                    LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(iRoundToInt, iRoundToInt2);
                    i91 i91Var2 = this.F;
                    layoutParams13.topMargin = ((i91Var2 == null || !i91Var2.a()) && ((i91Var = this.F) == null || !i91Var.e())) ? 0 : this.d;
                    layoutParams13.gravity = 1;
                    layoutParams12 = layoutParams13;
                }
            }
            LinearLayout linearLayout6 = this.B;
            if (linearLayout6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("largeImageContainer");
                linearLayout6 = null;
            }
            linearLayout6.setLayoutParams(layoutParams12);
        }
        x81 x81Var2 = this.G;
        if (x81Var2 != null) {
            LinearLayout.LayoutParams layoutParams14 = new LinearLayout.LayoutParams(0, 0);
            ot otVar5 = this.E;
            ut utVarI = otVar5 != null ? otVar5.i() : null;
            if (utVarI != null && x81Var2.d()) {
                layoutParams14 = new LinearLayout.LayoutParams(iA, new gg(utVarI.a()).a(iA));
            }
            LinearLayout linearLayout7 = this.D;
            if (linearLayout7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaContainer");
                linearLayout7 = null;
            }
            linearLayout7.setLayoutParams(layoutParams14);
        }
        i91 i91Var3 = this.F;
        if (i91Var3 != null && i91Var3.f()) {
            i91 i91Var4 = this.F;
            if (i91Var4 != null && i91Var4.h()) {
                LinearLayout linearLayout8 = this.z;
                if (linearLayout8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("callToActionContainer");
                    linearLayout8 = null;
                }
                ViewParent parent = linearLayout8.getParent();
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewManager");
                ViewManager viewManager = (ViewManager) parent;
                LinearLayout linearLayout9 = this.z;
                if (linearLayout9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("callToActionContainer");
                    linearLayout9 = null;
                }
                viewManager.removeView(linearLayout9);
                LinearLayout.LayoutParams layoutParams15 = new LinearLayout.LayoutParams(-1, -2);
                i91 i91Var5 = this.F;
                if (i91Var5 != null && i91Var5.c()) {
                    layoutParams15.topMargin = this.f;
                } else {
                    layoutParams15.topMargin = this.d;
                }
                layoutParams15.bottomMargin = this.e;
                LinearLayout linearLayout10 = this.z;
                if (linearLayout10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("callToActionContainer");
                    linearLayout10 = null;
                }
                linearLayout10.setLayoutParams(layoutParams15);
                ea1 contentPadding2 = this.g.getBannerAppearance().getContentPadding();
                if (contentPadding2 != null) {
                    l10 l10Var7 = this.f10588a;
                    Context context9 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context9, "getContext(...)");
                    float left3 = contentPadding2.getLeft();
                    l10Var7.getClass();
                    int iA6 = l10.a(context9, left3);
                    l10 l10Var8 = this.f10588a;
                    Context context10 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context10, "getContext(...)");
                    float right3 = contentPadding2.getRight();
                    l10Var8.getClass();
                    int iA7 = l10.a(context10, right3);
                    LinearLayout linearLayout11 = this.z;
                    if (linearLayout11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("callToActionContainer");
                        linearLayout11 = null;
                    }
                    linearLayout11.setPadding(iA6, 0, iA7, 0);
                    LinearLayout linearLayout12 = this.v;
                    if (linearLayout12 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mainContainer");
                        linearLayout12 = null;
                    }
                    LinearLayout linearLayout13 = this.z;
                    if (linearLayout13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("callToActionContainer");
                        linearLayout13 = null;
                    }
                    LinearLayout linearLayout14 = this.v;
                    if (linearLayout14 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mainContainer");
                        linearLayout = null;
                    } else {
                        linearLayout = linearLayout14;
                    }
                    linearLayout12.addView(linearLayout13, linearLayout.getChildCount() - 1);
                }
            } else {
                LinearLayout linearLayout15 = this.z;
                if (linearLayout15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("callToActionContainer");
                    linearLayout15 = null;
                }
                ViewParent parent2 = linearLayout15.getParent();
                Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type android.view.ViewManager");
                ViewManager viewManager2 = (ViewManager) parent2;
                LinearLayout linearLayout16 = this.z;
                if (linearLayout16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("callToActionContainer");
                    linearLayout16 = null;
                }
                viewManager2.removeView(linearLayout16);
                LinearLayout linearLayout17 = this.z;
                if (linearLayout17 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("callToActionContainer");
                    linearLayout17 = null;
                }
                linearLayout17.setPadding(0, 0, 0, 0);
                LinearLayout.LayoutParams layoutParams16 = new LinearLayout.LayoutParams(-1, -2);
                int i3 = this.e;
                layoutParams16.topMargin = i3;
                layoutParams16.bottomMargin = i3;
                ViewParent parent3 = getDomainView().getParent();
                Intrinsics.checkNotNull(parent3, "null cannot be cast to non-null type android.view.ViewManager");
                ViewManager viewManager3 = (ViewManager) parent3;
                LinearLayout linearLayout18 = this.z;
                if (linearLayout18 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("callToActionContainer");
                    linearLayout18 = null;
                }
                viewManager3.addView(linearLayout18, layoutParams16);
            }
            i91 i91Var6 = this.F;
            if (i91Var6 != null && i91Var6.g()) {
                layoutParams = new LinearLayout.LayoutParams(-1, -2);
            } else {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            getCallToActionView().setLayoutParams(layoutParams);
        } else {
            LinearLayout linearLayout19 = this.z;
            if (linearLayout19 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("callToActionContainer");
                linearLayout19 = null;
            }
            linearLayout19.setLayoutParams(new LinearLayout.LayoutParams(0, 0));
        }
        int iRoundToInt6 = MathKt.roundToInt(iA * 0.4f);
        getCallToActionView().setMinWidth(iRoundToInt6);
        getCallToActionView().setMinimumWidth(iRoundToInt6);
        i91 i91Var7 = this.F;
        if (i91Var7 != null && i91Var7.i()) {
            TextView warningView = getWarningView();
            i91 i91Var8 = this.F;
            if (i91Var8 != null && i91Var8.j()) {
                warningView.setBackgroundColor(0);
            } else {
                warningView.setBackgroundColor(oh2.a(warningView.getCurrentTextColor(), 92.0f));
            }
            getWarningView().setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        super.onMeasure(i, i2);
    }

    public final void hideContent() {
        ImageView imageView = this.u;
        LinearLayout linearLayout = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adFoxView");
            imageView = null;
        }
        imageView.setVisibility(8);
        LinearLayout linearLayout2 = this.v;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainContainer");
        } else {
            linearLayout = linearLayout2;
        }
        linearLayout.setVisibility(8);
    }

    public final void showContent() {
        qt image;
        ot otVar = this.E;
        LinearLayout linearLayout = null;
        int i = 0;
        if (otVar != null && (image = otVar.h()) != null) {
            if (this.G != null) {
                Intrinsics.checkNotNullParameter(image, "image");
                if (Intrinsics.areEqual("fill", image.c())) {
                    ImageView imageView = this.u;
                    if (imageView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adFoxView");
                        imageView = null;
                    }
                    imageView.setVisibility(0);
                    i = 8;
                }
            }
            if (this.G != null && x81.a(image)) {
                i91 i91Var = this.F;
                if (i91Var != null && !i91Var.a()) {
                    LinearLayout linearLayout2 = this.y;
                    if (linearLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
                        linearLayout2 = null;
                    }
                    linearLayout2.setVisibility(8);
                }
                i91 i91Var2 = this.F;
                if (i91Var2 != null && !i91Var2.e()) {
                    LinearLayout linearLayout3 = this.x;
                    if (linearLayout3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("topContainer");
                        linearLayout3 = null;
                    }
                    linearLayout3.setVisibility(8);
                }
            }
        }
        LinearLayout linearLayout4 = this.v;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainContainer");
        } else {
            linearLayout = linearLayout4;
        }
        linearLayout.setVisibility(i);
    }

    public /* synthetic */ wt(Context context, AttributeSet attributeSet, int i, cu cuVar, l92 l92Var, ie ieVar, l10 l10Var, xt xtVar, lp1 lp1Var, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, attributeSet, i, cuVar, l92Var, ieVar, (i2 & 64) != 0 ? new l10() : l10Var, (i2 & 128) != 0 ? new xt() : xtVar, (i2 & 256) != 0 ? nd.a(context, l92Var, ieVar) : lp1Var);
    }

    private final void b() {
        ImageView imageView;
        this.u = c();
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        this.x = linearLayout2;
        linearLayout2.setOrientation(0);
        LinearLayout linearLayout3 = this.x;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topContainer");
            linearLayout3 = null;
        }
        linearLayout3.setGravity(17);
        LinearLayout linearLayout4 = this.x;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topContainer");
            linearLayout4 = null;
        }
        linearLayout4.setWeightSum(4.0f);
        View view = new View(getContext());
        view.setLayoutParams(new LinearLayout.LayoutParams(0, 0, 1.0f));
        LinearLayout linearLayout5 = new LinearLayout(getContext());
        linearLayout5.setGravity(17);
        linearLayout5.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 2.0f));
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        x12 x12Var = new x12(context);
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        x12Var.setEllipsize(truncateAt);
        x12Var.setMaxLines(1);
        x12Var.setGravity(17);
        l10 l10Var = this.f10588a;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        l10Var.getClass();
        x12Var.setPadding(0, 0, 0, l10.a(context2, 4.0f));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        x12Var.setLayoutParams(layoutParams);
        this.n = x12Var;
        linearLayout5.addView(x12Var);
        LinearLayout linearLayout6 = new LinearLayout(getContext());
        linearLayout6.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView textView = new TextView(getContext());
        textView.setEllipsize(truncateAt);
        textView.setMaxLines(1);
        textView.setGravity(GravityCompat.START);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.rightMargin = this.d;
        textView.setLayoutParams(layoutParams2);
        this.h = textView;
        linearLayout6.addView(getAgeView());
        LinearLayout linearLayout7 = this.x;
        if (linearLayout7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topContainer");
            linearLayout7 = null;
        }
        linearLayout7.addView(linearLayout6);
        ViewGroup viewGroup = this.x;
        ViewGroup viewGroup2 = viewGroup;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topContainer");
            viewGroup2 = null;
        }
        viewGroup2.addView(linearLayout5);
        LinearLayout linearLayout8 = this.x;
        if (linearLayout8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topContainer");
            linearLayout8 = null;
        }
        linearLayout8.addView(view);
        LinearLayout linearLayout9 = this.x;
        if (linearLayout9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topContainer");
            linearLayout9 = null;
        }
        LinearLayout linearLayout10 = new LinearLayout(getContext());
        this.y = linearLayout10;
        linearLayout10.setOrientation(0);
        LinearLayout linearLayout11 = this.y;
        if (linearLayout11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
            linearLayout11 = null;
        }
        linearLayout11.setBaselineAligned(false);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = this.d;
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setLayoutParams(layoutParams3);
        this.q = c();
        ImageView imageView2 = new ImageView(getContext());
        imageView2.setAdjustViewBounds(true);
        ImageView.ScaleType scaleType = ImageView.ScaleType.CENTER_CROP;
        imageView2.setScaleType(scaleType);
        this.t = imageView2;
        frameLayout.addView(getIconView());
        frameLayout.addView(this.m);
        frameLayout.addView(getFaviconView());
        LinearLayout linearLayout12 = new LinearLayout(getContext());
        linearLayout12.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout12.setOrientation(1);
        TextView textView2 = new TextView(getContext());
        textView2.setEllipsize(truncateAt);
        textView2.setMaxLines(2);
        textView2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.o = textView2;
        TextView textView3 = new TextView(getContext());
        textView3.setEllipsize(truncateAt);
        textView3.setMaxLines(3);
        textView3.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.i = textView3;
        TextView textView4 = new TextView(getContext());
        textView4.setEllipsize(truncateAt);
        textView4.setMaxLines(1);
        textView4.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.k = textView4;
        linearLayout12.addView(getTitleView());
        linearLayout12.addView(getBodyView());
        linearLayout12.addView(getDomainView());
        LinearLayout linearLayout13 = new LinearLayout(getContext());
        this.z = linearLayout13;
        linearLayout13.setOrientation(0);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.topMargin = this.e;
        LinearLayout linearLayout14 = this.z;
        if (linearLayout14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callToActionContainer");
            linearLayout14 = null;
        }
        linearLayout14.setLayoutParams(layoutParams4);
        LinearLayout linearLayout15 = new LinearLayout(getContext());
        linearLayout15.setOrientation(1);
        linearLayout15.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
        in1 in1Var = new in1(context3, null, R.attr.ratingBarStyleSmall);
        in1Var.setNumStars(5);
        in1Var.setStepSize(0.5f);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.rightMargin = this.e;
        in1Var.setLayoutParams(layoutParams5);
        this.r = in1Var;
        TextView textView5 = new TextView(getContext());
        textView5.setEllipsize(truncateAt);
        textView5.setMaxLines(1);
        textView5.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.s = textView5;
        in1 in1Var2 = this.r;
        if (in1Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_ratingView");
            in1Var2 = null;
        }
        linearLayout15.addView(in1Var2);
        linearLayout15.addView(getReviewCountView());
        LinearLayout linearLayout16 = new LinearLayout(getContext());
        linearLayout16.setOrientation(0);
        linearLayout16.setGravity(5);
        linearLayout16.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        Button button = new Button(getContext(), null, R.attr.borderlessButtonStyle);
        button.setEllipsize(truncateAt);
        button.setMaxLines(1);
        button.setTransformationMethod(null);
        l10 l10Var2 = this.f10588a;
        Context context4 = getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
        l10Var2.getClass();
        int iA = l10.a(context4, 26.0f);
        button.setMinimumHeight(iA);
        button.setMinHeight(iA);
        button.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.j = button;
        linearLayout16.addView(getCallToActionView());
        LinearLayout linearLayout17 = this.z;
        if (linearLayout17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callToActionContainer");
            linearLayout17 = null;
        }
        linearLayout17.addView(linearLayout15);
        LinearLayout linearLayout18 = this.z;
        if (linearLayout18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callToActionContainer");
            linearLayout18 = null;
        }
        linearLayout18.addView(linearLayout16);
        LinearLayout linearLayout19 = this.z;
        if (linearLayout19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callToActionContainer");
            linearLayout19 = null;
        }
        linearLayout12.addView(linearLayout19);
        LinearLayout linearLayout20 = this.y;
        if (linearLayout20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
            linearLayout20 = null;
        }
        linearLayout20.addView(frameLayout);
        LinearLayout linearLayout21 = this.y;
        if (linearLayout21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
            linearLayout21 = null;
        }
        linearLayout21.addView(linearLayout12);
        LinearLayout linearLayout22 = this.y;
        if (linearLayout22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
            linearLayout22 = null;
        }
        LinearLayout linearLayout23 = new LinearLayout(getContext());
        linearLayout23.setOrientation(0);
        linearLayout23.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.B = linearLayout23;
        ImageView imageView3 = new ImageView(getContext());
        imageView3.setAdjustViewBounds(true);
        imageView3.setScaleType(scaleType);
        imageView3.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.A = imageView3;
        LinearLayout linearLayout24 = this.B;
        if (linearLayout24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("largeImageContainer");
            linearLayout24 = null;
        }
        ImageView imageView4 = this.A;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("largeImageView");
            imageView4 = null;
        }
        linearLayout24.addView(imageView4);
        LinearLayout linearLayout25 = this.B;
        if (linearLayout25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("largeImageContainer");
            linearLayout25 = null;
        }
        LinearLayout linearLayout26 = new LinearLayout(getContext());
        linearLayout26.setOrientation(0);
        linearLayout26.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.D = linearLayout26;
        Context context5 = getContext();
        Intrinsics.checkNotNullExpressionValue(context5, "getContext(...)");
        CustomizableMediaView customizableMediaView = new CustomizableMediaView(context5);
        customizableMediaView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.C = customizableMediaView;
        LinearLayout linearLayout27 = this.D;
        if (linearLayout27 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaContainer");
            linearLayout27 = null;
        }
        linearLayout27.addView(getMediaView());
        LinearLayout linearLayout28 = this.D;
        if (linearLayout28 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaContainer");
            linearLayout28 = null;
        }
        TextView textView6 = new TextView(getContext());
        textView6.setEllipsize(truncateAt);
        this.p = textView6;
        TextView warningView = getWarningView();
        linearLayout.addView(linearLayout9);
        linearLayout.addView(linearLayout22);
        linearLayout.addView(linearLayout25);
        linearLayout.addView(linearLayout28);
        linearLayout.addView(warningView);
        this.v = linearLayout;
        ea1 contentPadding = this.g.getBannerAppearance().getContentPadding();
        if (contentPadding != null) {
            l10 l10Var3 = this.f10588a;
            Context context6 = getContext();
            Intrinsics.checkNotNullExpressionValue(context6, "getContext(...)");
            float right = contentPadding.getRight();
            l10Var3.getClass();
            int iA2 = l10.a(context6, right) - this.e;
            Context context7 = getContext();
            Intrinsics.checkNotNullExpressionValue(context7, "getContext(...)");
            ab0 ab0Var = new ab0(context7);
            Context context8 = getContext();
            Intrinsics.checkNotNullExpressionValue(context8, "getContext(...)");
            this.w = new sa0(context8).a();
            this.l = ab0Var.a(iA2, this.d);
            FrameLayout frameLayout2 = this.w;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedbackContainer");
                frameLayout2 = null;
            }
            frameLayout2.addView(getFeedbackView());
            FrameLayout frameLayout3 = this.w;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedbackContainer");
                frameLayout3 = null;
            }
            frameLayout3.setVisibility(8);
        }
        ImageView imageView5 = this.u;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adFoxView");
            imageView5 = null;
        }
        addView(imageView5, new ViewGroup.LayoutParams(-1, -2));
        LinearLayout linearLayout29 = this.v;
        if (linearLayout29 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainContainer");
            linearLayout29 = null;
        }
        addView(linearLayout29, new ViewGroup.LayoutParams(-1, -1));
        FrameLayout frameLayout4 = this.w;
        if (frameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedbackContainer");
            frameLayout4 = null;
        }
        addView(frameLayout4);
        hideContent();
        ImageView[] imageViewArr = new ImageView[5];
        imageViewArr[0] = getFaviconView();
        imageViewArr[1] = getIconView();
        imageViewArr[2] = this.m;
        ImageView imageView6 = this.A;
        if (imageView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("largeImageView");
            imageView6 = null;
        }
        imageViewArr[3] = imageView6;
        ImageView imageView7 = this.u;
        if (imageView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adFoxView");
            imageView = null;
        } else {
            imageView = imageView7;
        }
        imageViewArr[4] = imageView;
        this.H = new y51(imageViewArr);
        a();
    }
}
