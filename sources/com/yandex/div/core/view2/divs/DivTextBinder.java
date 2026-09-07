package com.yandex.div.core.view2.divs;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;
import com.yandex.div.core.Disposable;
import com.yandex.div.core.dagger.DivScope;
import com.yandex.div.core.dagger.ExperimentFlag;
import com.yandex.div.core.experiments.Experiment;
import com.yandex.div.core.util.DivDataExtensionsKt;
import com.yandex.div.core.util.ExpressionSubscribersKt;
import com.yandex.div.core.util.ViewsKt;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.DivTypefaceResolver;
import com.yandex.div.core.view2.DivTypefaceResolverKt;
import com.yandex.div.core.view2.DivViewBinder;
import com.yandex.div.core.view2.divs.widgets.DivLineHeightTextView;
import com.yandex.div.core.view2.spannable.ShadowData;
import com.yandex.div.core.view2.spannable.SpannedTextBuilder;
import com.yandex.div.core.widget.AdaptiveMaxLines;
import com.yandex.div.core.widget.DivViewWrapper;
import com.yandex.div.internal.Assert;
import com.yandex.div.internal.KAssert;
import com.yandex.div.internal.drawable.LinearGradientDrawable;
import com.yandex.div.internal.drawable.RadialGradientDrawable;
import com.yandex.div.internal.graphics.Colormap;
import com.yandex.div.internal.graphics.ColormapKt;
import com.yandex.div.internal.widget.EllipsizedTextView;
import com.yandex.div.internal.widget.TextViewsKt;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionList;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div.json.expressions.ExpressionsKt;
import com.yandex.div2.DivAlignmentHorizontal;
import com.yandex.div2.DivAlignmentVertical;
import com.yandex.div2.DivDimension;
import com.yandex.div2.DivFontWeight;
import com.yandex.div2.DivLineStyle;
import com.yandex.div2.DivLinearGradient;
import com.yandex.div2.DivPoint;
import com.yandex.div2.DivRadialGradient;
import com.yandex.div2.DivRadialGradientCenter;
import com.yandex.div2.DivRadialGradientRadius;
import com.yandex.div2.DivRadialGradientRelativeRadius;
import com.yandex.div2.DivShadow;
import com.yandex.div2.DivSizeUnit;
import com.yandex.div2.DivSolidBackground;
import com.yandex.div2.DivStroke;
import com.yandex.div2.DivText;
import com.yandex.div2.DivTextAlignmentVertical;
import com.yandex.div2.DivTextGradient;
import com.yandex.div2.DivTextRangeBackground;
import com.yandex.div2.DivTextRangeBorder;
import io.ktor.http.ContentDisposition;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DivTextBinder.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B)\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\u0014\u0010\u0018\u001a\u00020\u0013*\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u000bH\u0002J\u0016\u0010\u001a\u001a\u00020\u0013*\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J$\u0010\u001d\u001a\u00020\u0013*\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u0014\u0010$\u001a\u00020\u0013*\u00020\u000f2\u0006\u0010%\u001a\u00020\u001cH\u0002J\u001c\u0010&\u001a\u00020\u0013*\u00020\u000f2\u0006\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)H\u0002J%\u0010*\u001a\u00020\u0013*\u00020\u00032\b\u0010+\u001a\u0004\u0018\u00010\u001f2\b\u0010,\u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0002\u0010-J\u0016\u0010.\u001a\u00020\u0013*\u00020\u00032\b\u0010/\u001a\u0004\u0018\u00010\u001cH\u0002J\u001c\u00100\u001a\u00020\u0013*\u00020\u000f2\u0006\u00101\u001a\u00020\u00152\u0006\u00102\u001a\u00020\u0002H\u0002J2\u00103\u001a\u00020\u0013*\u00020\u000f2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002072\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u000e0:H\u0002J\u001c\u0010;\u001a\u00020\u0013*\u00020<2\u0006\u00101\u001a\u00020\u00152\u0006\u0010=\u001a\u00020\u0002H\u0002J\u001c\u0010>\u001a\u00020\u0013*\u00020\u000f2\u0006\u00101\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0002H\u0002J\u0014\u0010?\u001a\u00020\u0013*\u00020\u000f2\u0006\u0010@\u001a\u00020\u000bH\u0002J\u0014\u0010A\u001a\u00020\u0013*\u00020\u000f2\u0006\u0010B\u001a\u00020CH\u0002J\u001c\u0010D\u001a\u00020\u0013*\u00020\u000f2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020HH\u0002J#\u0010I\u001a\u00020\u0013*\u00020\u000f2\u0006\u0010J\u001a\u00020\u000e2\b\u0010K\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0002\u0010LJ\u0016\u0010M\u001a\u00020\u0013*\u00020\u000f2\b\u0010N\u001a\u0004\u0018\u00010OH\u0002J\u0014\u0010P\u001a\u00020\u0013*\u00020\u00032\u0006\u0010Q\u001a\u00020\u000bH\u0002J-\u0010R\u001a\u00020\u0013*\u00020\u000f2\b\u0010S\u001a\u0004\u0018\u00010\u001c2\u0006\u0010T\u001a\u00020U2\b\u0010V\u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0002\u0010WJ\u0014\u0010X\u001a\u00020\u0013*\u00020\u000f2\u0006\u0010Y\u001a\u00020CH\u0002J&\u0010Z\u001a\u00020\u0013*\u00020\u00032\u0006\u0010=\u001a\u00020\u00022\b\u0010[\u001a\u0004\u0018\u00010\u00022\u0006\u0010\\\u001a\u00020]H\u0002J&\u0010^\u001a\u00020\u0013*\u00020\u00032\u0006\u00101\u001a\u00020\u00152\u0006\u0010=\u001a\u00020\u00022\b\u0010[\u001a\u0004\u0018\u00010\u0002H\u0002J&\u0010_\u001a\u00020\u0013*\u00020\u00032\u0006\u0010=\u001a\u00020\u00022\b\u0010[\u001a\u0004\u0018\u00010\u00022\u0006\u0010\\\u001a\u00020]H\u0002J&\u0010`\u001a\u00020\u0013*\u00020\u00032\u0006\u0010=\u001a\u00020\u00022\b\u0010[\u001a\u0004\u0018\u00010\u00022\u0006\u0010\\\u001a\u00020]H\u0002J.\u0010a\u001a\u00020\u0013*\u00020\u00032\u0006\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020e2\b\u0010f\u001a\u0004\u0018\u00010g2\u0006\u0010\\\u001a\u00020]H\u0002J&\u0010h\u001a\u00020\u0013*\u00020\u00032\u0006\u0010=\u001a\u00020\u00022\b\u0010[\u001a\u0004\u0018\u00010\u00022\u0006\u0010\\\u001a\u00020]H\u0002J(\u0010i\u001a\u00020\u0013*\u00020\u00032\b\u0010j\u001a\u0004\u0018\u00010k2\b\u0010l\u001a\u0004\u0018\u00010k2\u0006\u0010\\\u001a\u00020]H\u0002J&\u0010m\u001a\u00020\u0013*\u00020\u00032\u0006\u00101\u001a\u00020\u00152\u0006\u0010=\u001a\u00020\u00022\b\u0010[\u001a\u0004\u0018\u00010\u0002H\u0002J&\u0010n\u001a\u00020\u0013*\u00020\u00032\u0006\u0010d\u001a\u00020o2\b\u0010f\u001a\u0004\u0018\u00010g2\u0006\u0010\\\u001a\u00020]H\u0002J\u001c\u0010p\u001a\u00020\u0013*\u00020\u00032\u0006\u00101\u001a\u00020\u00152\u0006\u0010=\u001a\u00020\u0002H\u0002J\u001c\u0010q\u001a\u00020\u0013*\u00020\u00032\u0006\u00101\u001a\u00020\u00152\u0006\u0010=\u001a\u00020\u0002H\u0002J&\u0010r\u001a\u00020\u0013*\u00020\u00032\u0006\u0010=\u001a\u00020\u00022\b\u0010[\u001a\u0004\u0018\u00010\u00022\u0006\u0010\\\u001a\u00020]H\u0002J&\u0010s\u001a\u00020\u0013*\u00020\u00032\u0006\u0010=\u001a\u00020\u00022\b\u0010[\u001a\u0004\u0018\u00010\u00022\u0006\u0010\\\u001a\u00020]H\u0002J&\u0010t\u001a\u00020\u0013*\u00020\u00032\u0006\u00101\u001a\u00020\u00152\u0006\u0010=\u001a\u00020\u00022\b\u0010[\u001a\u0004\u0018\u00010\u0002H\u0002J&\u0010u\u001a\u00020\u0013*\u00020\u00032\u0006\u0010=\u001a\u00020\u00022\b\u0010[\u001a\u0004\u0018\u00010\u00022\u0006\u0010\\\u001a\u00020]H\u0002J&\u0010v\u001a\u00020\u0013*\u00020\u00032\u0006\u0010=\u001a\u00020\u00022\b\u0010[\u001a\u0004\u0018\u00010\u00022\u0006\u0010\\\u001a\u00020]H\u0002J.\u0010w\u001a\u00020\u0013*\u00020\u00032\u0006\u0010b\u001a\u00020c2\u0006\u0010=\u001a\u00020\u00022\b\u0010[\u001a\u0004\u0018\u00010\u00022\u0006\u0010\\\u001a\u00020]H\u0002J&\u0010x\u001a\u00020\u0013*\u00020\u00032\u0006\u0010=\u001a\u00020\u00022\b\u0010[\u001a\u0004\u0018\u00010\u00022\u0006\u0010\\\u001a\u00020]H\u0002J&\u0010y\u001a\u00020\u0013*\u00020\u00032\u0006\u0010=\u001a\u00020\u00022\b\u0010[\u001a\u0004\u0018\u00010\u00022\u0006\u0010\\\u001a\u00020]H\u0002J&\u0010z\u001a\u00020\u0013*\u00020\u00032\u0006\u0010=\u001a\u00020\u00022\b\u0010[\u001a\u0004\u0018\u00010\u00022\u0006\u0010\\\u001a\u00020]H\u0002J&\u0010{\u001a\u00020\u0013*\u00020\u00032\u0006\u0010=\u001a\u00020\u00022\b\u0010[\u001a\u0004\u0018\u00010\u00022\u0006\u0010\\\u001a\u00020]H\u0002J%\u0010|\u001a\u00020O*\u00020}2\u0006\u0010\\\u001a\u00020]2\u0006\u0010~\u001a\u00020\u007f2\u0007\u0010\u0080\u0001\u001a\u00020\u000eH\u0002J\u001f\u0010\u0081\u0001\u001a\u000207*\u00030\u0082\u00012\u0007\u0010\u0083\u0001\u001a\u00020\u007f2\u0006\u0010\\\u001a\u00020]H\u0002J\u001f\u0010\u0084\u0001\u001a\u000205*\u00030\u0085\u00012\u0007\u0010\u0083\u0001\u001a\u00020\u007f2\u0006\u0010\\\u001a\u00020]H\u0002J\u0016\u0010\u0086\u0001\u001a\u00020\u0013*\u00030\u0087\u00012\u0006\u0010\u0017\u001a\u00020\u0002H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\u00020\u000e*\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0088\u0001"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivTextBinder;", "Lcom/yandex/div/core/view2/DivViewBinder;", "Lcom/yandex/div2/DivText;", "Lcom/yandex/div/core/view2/divs/widgets/DivLineHeightTextView;", "baseBinder", "Lcom/yandex/div/core/view2/divs/DivBaseBinder;", "typefaceResolver", "Lcom/yandex/div/core/view2/DivTypefaceResolver;", "spannedTextBuilder", "Lcom/yandex/div/core/view2/spannable/SpannedTextBuilder;", "isHyphenationEnabled", "", "(Lcom/yandex/div/core/view2/divs/DivBaseBinder;Lcom/yandex/div/core/view2/DivTypefaceResolver;Lcom/yandex/div/core/view2/spannable/SpannedTextBuilder;Z)V", "realTextWidth", "", "Landroid/widget/TextView;", "getRealTextWidth", "(Landroid/widget/TextView;)I", "bindView", "", "context", "Lcom/yandex/div/core/view2/BindingContext;", "view", "div", "applyAutoEllipsize", "ellipsize", "applyFontFeatureSettings", "settings", "", "applyFontSize", ContentDisposition.Parameters.Size, "", "unit", "Lcom/yandex/div2/DivSizeUnit;", "letterSpacing", "", "applyHyphenation", "text", "applyLinearTextGradientColor", "angle", "colormap", "Lcom/yandex/div/internal/graphics/Colormap;", "applyMaxLines", "maxLines", "minHiddenLines", "(Lcom/yandex/div/core/view2/divs/widgets/DivLineHeightTextView;Ljava/lang/Long;Ljava/lang/Long;)V", "applyPlainEllipsis", "ellipsis", "applyPlainText", "bindingContext", "divText", "applyRadialTextGradientColor", "radius", "Lcom/yandex/div/internal/drawable/RadialGradientDrawable$Radius;", "centerX", "Lcom/yandex/div/internal/drawable/RadialGradientDrawable$Center;", "centerY", "colors", "", "applyRichEllipsis", "Lcom/yandex/div/internal/widget/EllipsizedTextView;", "newDiv", "applyRichText", "applySelectable", "selectable", "applyStrikethrough", "strikethrough", "Lcom/yandex/div2/DivLineStyle;", "applyTextAlignment", "horizontalAlignment", "Lcom/yandex/div2/DivAlignmentHorizontal;", "verticalAlignment", "Lcom/yandex/div2/DivAlignmentVertical;", "applyTextColor", "textColor", "focusedTextColor", "(Landroid/widget/TextView;ILjava/lang/Integer;)V", "applyTextShadow", "shadowParams", "Lcom/yandex/div/core/view2/spannable/ShadowData;", "applyTightenWidth", "tight", "applyTypeface", "fontFamily", "fontWeight", "Lcom/yandex/div2/DivFontWeight;", "fontWeightValue", "(Landroid/widget/TextView;Ljava/lang/String;Lcom/yandex/div2/DivFontWeight;Ljava/lang/Long;)V", "applyUnderline", "underline", "bindAutoEllipsize", "oldDiv", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "bindEllipsis", "bindFontFeatureSettings", "bindFontSize", "bindLinearTextGradient", "divView", "Lcom/yandex/div/core/view2/Div2View;", "newTextGradient", "Lcom/yandex/div2/DivLinearGradient;", "oldTextGradient", "Lcom/yandex/div2/DivTextGradient;", "bindMaxLines", "bindPlainEllipsis", "newEllipsis", "Lcom/yandex/div2/DivText$Ellipsis;", "oldEllipsis", "bindPlainText", "bindRadialTextGradient", "Lcom/yandex/div2/DivRadialGradient;", "bindRichEllipsis", "bindRichText", "bindSelectable", "bindStrikethrough", "bindText", "bindTextAlignment", "bindTextColor", "bindTextGradient", "bindTextShadow", "bindTightenWidth", "bindTypeface", "bindUnderline", "getShadowData", "Lcom/yandex/div2/DivShadow;", "displayMetrics", "Landroid/util/DisplayMetrics;", "fontColor", "toRadialGradientDrawableCenter", "Lcom/yandex/div2/DivRadialGradientCenter;", "metrics", "toRadialGradientDrawableRadius", "Lcom/yandex/div2/DivRadialGradientRadius;", "updateFocusableState", "Landroid/view/View;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@DivScope
public final class DivTextBinder implements DivViewBinder<DivText, DivLineHeightTextView> {
    private final DivBaseBinder baseBinder;
    private final boolean isHyphenationEnabled;
    private final SpannedTextBuilder spannedTextBuilder;
    private final DivTypefaceResolver typefaceResolver;

    /* JADX INFO: compiled from: DivTextBinder.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[DivAlignmentHorizontal.values().length];
            try {
                iArr[DivAlignmentHorizontal.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DivAlignmentHorizontal.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DivAlignmentHorizontal.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DivAlignmentHorizontal.START.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DivAlignmentHorizontal.END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[DivLineStyle.values().length];
            try {
                iArr2[DivLineStyle.SINGLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[DivLineStyle.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[DivRadialGradientRelativeRadius.Value.values().length];
            try {
                iArr3[DivRadialGradientRelativeRadius.Value.FARTHEST_CORNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[DivRadialGradientRelativeRadius.Value.NEAREST_CORNER.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[DivRadialGradientRelativeRadius.Value.FARTHEST_SIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[DivRadialGradientRelativeRadius.Value.NEAREST_SIDE.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    @Inject
    public DivTextBinder(DivBaseBinder baseBinder, DivTypefaceResolver typefaceResolver, SpannedTextBuilder spannedTextBuilder, @ExperimentFlag(experiment = Experiment.HYPHENATION_SUPPORT_ENABLED) boolean z) {
        Intrinsics.checkNotNullParameter(baseBinder, "baseBinder");
        Intrinsics.checkNotNullParameter(typefaceResolver, "typefaceResolver");
        Intrinsics.checkNotNullParameter(spannedTextBuilder, "spannedTextBuilder");
        this.baseBinder = baseBinder;
        this.typefaceResolver = typefaceResolver;
        this.spannedTextBuilder = spannedTextBuilder;
        this.isHyphenationEnabled = z;
    }

    @Override // com.yandex.div.core.view2.DivViewBinder
    public void bindView(BindingContext context, DivLineHeightTextView view, DivText div) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(div, "div");
        DivText div2 = view.getDiv();
        if (div == div2) {
            return;
        }
        DivLineHeightTextView divLineHeightTextView = view;
        this.baseBinder.bindView(context, divLineHeightTextView, div, div2);
        BaseDivViewExtensionsKt.applyDivActions(divLineHeightTextView, context, div.action, div.actions, div.longtapActions, div.doubletapActions, div.hoverStartActions, div.hoverEndActions, div.pressStartActions, div.pressEndActions, div.actionAnimation, div.getAccessibility());
        ExpressionResolver expressionResolver = context.getExpressionResolver();
        bindTypeface(view, div, div2, expressionResolver);
        bindTextAlignment(view, div, div2, expressionResolver);
        bindFontSize(view, div, div2, expressionResolver);
        bindFontFeatureSettings(view, div, div2, expressionResolver);
        bindTextColor(view, div, div2, expressionResolver);
        bindUnderline(view, div, div2, expressionResolver);
        bindStrikethrough(view, div, div2, expressionResolver);
        bindMaxLines(view, div, div2, expressionResolver);
        bindText(view, context, div, div2);
        bindEllipsis(view, context, div, div2);
        bindAutoEllipsize(view, div, div2, expressionResolver);
        bindTextGradient(view, context.getDivView(), div, div2, expressionResolver);
        bindTextShadow(view, div, div2, expressionResolver);
        bindSelectable(view, div, div2, expressionResolver);
        bindTightenWidth(view, div, div2, expressionResolver);
        updateFocusableState(divLineHeightTextView, div);
    }

    private final void bindTextAlignment(final DivLineHeightTextView divLineHeightTextView, final DivText divText, DivText divText2, final ExpressionResolver expressionResolver) {
        if (ExpressionsKt.equalsToConstant(divText.textAlignmentHorizontal, divText2 != null ? divText2.textAlignmentHorizontal : null)) {
            if (ExpressionsKt.equalsToConstant(divText.textAlignmentVertical, divText2 != null ? divText2.textAlignmentVertical : null)) {
                return;
            }
        }
        applyTextAlignment(divLineHeightTextView, divText.textAlignmentHorizontal.evaluate(expressionResolver), divText.textAlignmentVertical.evaluate(expressionResolver));
        if (ExpressionsKt.isConstant(divText.textAlignmentHorizontal) && ExpressionsKt.isConstant(divText.textAlignmentVertical)) {
            return;
        }
        Function1<? super DivAlignmentHorizontal, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivTextBinder$bindTextAlignment$callback$1
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
                this.this$0.applyTextAlignment(divLineHeightTextView, divText.textAlignmentHorizontal.evaluate(expressionResolver), divText.textAlignmentVertical.evaluate(expressionResolver));
            }
        };
        divLineHeightTextView.addSubscription(divText.textAlignmentHorizontal.observe(expressionResolver, function1));
        divLineHeightTextView.addSubscription(divText.textAlignmentVertical.observe(expressionResolver, function1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyTextAlignment(TextView textView, DivAlignmentHorizontal divAlignmentHorizontal, DivAlignmentVertical divAlignmentVertical) {
        textView.setGravity(BaseDivViewExtensionsKt.evaluateGravity(divAlignmentHorizontal, divAlignmentVertical));
        int i = WhenMappings.$EnumSwitchMapping$0[divAlignmentHorizontal.ordinal()];
        int i2 = 5;
        if (i != 1) {
            if (i == 2) {
                i2 = 4;
            } else if (i == 3 || (i != 4 && i == 5)) {
                i2 = 6;
            }
        }
        textView.setTextAlignment(i2);
    }

    private final void bindMaxLines(final DivLineHeightTextView divLineHeightTextView, final DivText divText, DivText divText2, final ExpressionResolver expressionResolver) {
        if (ExpressionsKt.equalsToConstant(divText.maxLines, divText2 != null ? divText2.maxLines : null)) {
            if (ExpressionsKt.equalsToConstant(divText.minHiddenLines, divText2 != null ? divText2.minHiddenLines : null)) {
                return;
            }
        }
        Expression<Long> expression = divText.maxLines;
        Long lEvaluate = expression != null ? expression.evaluate(expressionResolver) : null;
        Expression<Long> expression2 = divText.minHiddenLines;
        applyMaxLines(divLineHeightTextView, lEvaluate, expression2 != null ? expression2.evaluate(expressionResolver) : null);
        if (ExpressionsKt.isConstantOrNull(divText.maxLines) && ExpressionsKt.isConstantOrNull(divText.minHiddenLines)) {
            return;
        }
        Function1<? super Long, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivTextBinder$bindMaxLines$callback$1
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
                DivTextBinder divTextBinder = this.this$0;
                DivLineHeightTextView divLineHeightTextView2 = divLineHeightTextView;
                Expression<Long> expression3 = divText.maxLines;
                Long lEvaluate2 = expression3 != null ? expression3.evaluate(expressionResolver) : null;
                Expression<Long> expression4 = divText.minHiddenLines;
                divTextBinder.applyMaxLines(divLineHeightTextView2, lEvaluate2, expression4 != null ? expression4.evaluate(expressionResolver) : null);
            }
        };
        Expression<Long> expression3 = divText.maxLines;
        divLineHeightTextView.addSubscription(expression3 != null ? expression3.observe(expressionResolver, function1) : null);
        Expression<Long> expression4 = divText.minHiddenLines;
        divLineHeightTextView.addSubscription(expression4 != null ? expression4.observe(expressionResolver, function1) : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyMaxLines(DivLineHeightTextView divLineHeightTextView, Long l, Long l2) {
        int i;
        AdaptiveMaxLines adaptiveMaxLines = divLineHeightTextView.getAdaptiveMaxLines();
        if (adaptiveMaxLines != null) {
            adaptiveMaxLines.reset();
        }
        int i2 = Integer.MIN_VALUE;
        int i3 = Integer.MAX_VALUE;
        if (l != null && l2 != null) {
            AdaptiveMaxLines adaptiveMaxLines2 = new AdaptiveMaxLines(divLineHeightTextView);
            long jLongValue = l.longValue();
            long j = jLongValue >> 31;
            if (j == 0 || j == -1) {
                i = (int) jLongValue;
            } else {
                KAssert kAssert = KAssert.INSTANCE;
                if (Assert.isEnabled()) {
                    Assert.fail("Unable convert '" + jLongValue + "' to Int");
                }
                i = jLongValue > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            long jLongValue2 = l2.longValue();
            long j2 = jLongValue2 >> 31;
            if (j2 == 0 || j2 == -1) {
                i2 = (int) jLongValue2;
            } else {
                KAssert kAssert2 = KAssert.INSTANCE;
                if (Assert.isEnabled()) {
                    Assert.fail("Unable convert '" + jLongValue2 + "' to Int");
                }
                if (jLongValue2 > 0) {
                    i2 = Integer.MAX_VALUE;
                }
            }
            adaptiveMaxLines2.apply(new AdaptiveMaxLines.Params(i, i2));
            divLineHeightTextView.setAdaptiveMaxLines$div_release(adaptiveMaxLines2);
            return;
        }
        if (l != null) {
            long jLongValue3 = l.longValue();
            long j3 = jLongValue3 >> 31;
            if (j3 == 0 || j3 == -1) {
                i2 = (int) jLongValue3;
            } else {
                KAssert kAssert3 = KAssert.INSTANCE;
                if (Assert.isEnabled()) {
                    Assert.fail("Unable convert '" + jLongValue3 + "' to Int");
                }
                if (jLongValue3 > 0) {
                    i2 = Integer.MAX_VALUE;
                }
            }
            i3 = i2;
        }
        divLineHeightTextView.setMaxLines(i3);
    }

    private final void bindFontSize(final DivLineHeightTextView divLineHeightTextView, final DivText divText, DivText divText2, final ExpressionResolver expressionResolver) {
        if (ExpressionsKt.equalsToConstant(divText.fontSize, divText2 != null ? divText2.fontSize : null)) {
            if (ExpressionsKt.equalsToConstant(divText.fontSizeUnit, divText2 != null ? divText2.fontSizeUnit : null)) {
                if (ExpressionsKt.equalsToConstant(divText.letterSpacing, divText2 != null ? divText2.letterSpacing : null)) {
                    return;
                }
            }
        }
        applyFontSize(divLineHeightTextView, divText.fontSize.evaluate(expressionResolver).longValue(), divText.fontSizeUnit.evaluate(expressionResolver), divText.letterSpacing.evaluate(expressionResolver).doubleValue());
        if (ExpressionsKt.isConstant(divText.fontSize) && ExpressionsKt.isConstant(divText.fontSizeUnit) && ExpressionsKt.isConstant(divText.letterSpacing)) {
            return;
        }
        Function1<? super Long, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivTextBinder$bindFontSize$callback$1
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
                this.this$0.applyFontSize(divLineHeightTextView, divText.fontSize.evaluate(expressionResolver).longValue(), divText.fontSizeUnit.evaluate(expressionResolver), divText.letterSpacing.evaluate(expressionResolver).doubleValue());
            }
        };
        divLineHeightTextView.addSubscription(divText.fontSize.observe(expressionResolver, function1));
        divLineHeightTextView.addSubscription(divText.fontSizeUnit.observe(expressionResolver, function1));
        divLineHeightTextView.addSubscription(divText.letterSpacing.observe(expressionResolver, function1));
    }

    private final void bindFontFeatureSettings(final DivLineHeightTextView divLineHeightTextView, final DivText divText, DivText divText2, final ExpressionResolver expressionResolver) {
        if (ExpressionsKt.equalsToConstant(divText.fontFeatureSettings, divText2 != null ? divText2.fontFeatureSettings : null)) {
            return;
        }
        DivLineHeightTextView divLineHeightTextView2 = divLineHeightTextView;
        Expression<String> expression = divText.fontFeatureSettings;
        applyFontFeatureSettings(divLineHeightTextView2, expression != null ? expression.evaluate(expressionResolver) : null);
        if (ExpressionsKt.isConstantOrNull(divText.fontFeatureSettings)) {
            return;
        }
        Function1<? super String, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivTextBinder$bindFontFeatureSettings$callback$1
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
                DivTextBinder divTextBinder = this.this$0;
                DivLineHeightTextView divLineHeightTextView3 = divLineHeightTextView;
                Expression<String> expression2 = divText.fontFeatureSettings;
                divTextBinder.applyFontFeatureSettings(divLineHeightTextView3, expression2 != null ? expression2.evaluate(expressionResolver) : null);
            }
        };
        Expression<String> expression2 = divText.fontFeatureSettings;
        divLineHeightTextView.addSubscription(expression2 != null ? expression2.observe(expressionResolver, function1) : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:6:0x0013  */
    public final void applyFontFeatureSettings(TextView textView, String it) {
        if (it != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (!(!StringsKt.isBlank(it))) {
                it = null;
            }
        } else {
            it = null;
        }
        textView.setFontFeatureSettings(it);
    }

    private final void bindTypeface(final DivLineHeightTextView divLineHeightTextView, final DivText divText, DivText divText2, final ExpressionResolver expressionResolver) {
        if (ExpressionsKt.equalsToConstant(divText.fontFamily, divText2 != null ? divText2.fontFamily : null)) {
            if (ExpressionsKt.equalsToConstant(divText.fontWeight, divText2 != null ? divText2.fontWeight : null)) {
                return;
            }
        }
        DivLineHeightTextView divLineHeightTextView2 = divLineHeightTextView;
        Expression<String> expression = divText.fontFamily;
        String strEvaluate = expression != null ? expression.evaluate(expressionResolver) : null;
        DivFontWeight divFontWeightEvaluate = divText.fontWeight.evaluate(expressionResolver);
        Expression<Long> expression2 = divText.fontWeightValue;
        applyTypeface(divLineHeightTextView2, strEvaluate, divFontWeightEvaluate, expression2 != null ? expression2.evaluate(expressionResolver) : null);
        if (ExpressionsKt.isConstantOrNull(divText.fontFamily) && ExpressionsKt.isConstant(divText.fontWeight) && ExpressionsKt.isConstantOrNull(divText.fontWeightValue)) {
            return;
        }
        Function1<? super String, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivTextBinder$bindTypeface$callback$1
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
                DivTextBinder divTextBinder = this.this$0;
                DivLineHeightTextView divLineHeightTextView3 = divLineHeightTextView;
                Expression<String> expression3 = divText.fontFamily;
                String strEvaluate2 = expression3 != null ? expression3.evaluate(expressionResolver) : null;
                DivFontWeight divFontWeightEvaluate2 = divText.fontWeight.evaluate(expressionResolver);
                Expression<Long> expression4 = divText.fontWeightValue;
                divTextBinder.applyTypeface(divLineHeightTextView3, strEvaluate2, divFontWeightEvaluate2, expression4 != null ? expression4.evaluate(expressionResolver) : null);
            }
        };
        Expression<String> expression3 = divText.fontFamily;
        divLineHeightTextView.addSubscription(expression3 != null ? expression3.observe(expressionResolver, function1) : null);
        divLineHeightTextView.addSubscription(divText.fontWeight.observe(expressionResolver, function1));
        Expression<Long> expression4 = divText.fontWeightValue;
        divLineHeightTextView.addSubscription(expression4 != null ? expression4.observe(expressionResolver, function1) : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyTypeface(TextView textView, String str, DivFontWeight divFontWeight, Long l) {
        textView.setTypeface(DivTypefaceResolverKt.getTypeface(this.typefaceResolver, str, divFontWeight, l));
    }

    private final void bindTextColor(final DivLineHeightTextView divLineHeightTextView, final DivText divText, DivText divText2, final ExpressionResolver expressionResolver) {
        if (ExpressionsKt.equalsToConstant(divText.textColor, divText2 != null ? divText2.textColor : null)) {
            if (ExpressionsKt.equalsToConstant(divText.focusedTextColor, divText2 != null ? divText2.focusedTextColor : null)) {
                return;
            }
        }
        DivLineHeightTextView divLineHeightTextView2 = divLineHeightTextView;
        int iIntValue = divText.textColor.evaluate(expressionResolver).intValue();
        Expression<Integer> expression = divText.focusedTextColor;
        applyTextColor(divLineHeightTextView2, iIntValue, expression != null ? expression.evaluate(expressionResolver) : null);
        if (ExpressionsKt.isConstant(divText.textColor) && ExpressionsKt.isConstantOrNull(divText.focusedTextColor)) {
            return;
        }
        Function1<? super Integer, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivTextBinder$bindTextColor$callback$1
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
                DivTextBinder divTextBinder = this.this$0;
                DivLineHeightTextView divLineHeightTextView3 = divLineHeightTextView;
                int iIntValue2 = divText.textColor.evaluate(expressionResolver).intValue();
                Expression<Integer> expression2 = divText.focusedTextColor;
                divTextBinder.applyTextColor(divLineHeightTextView3, iIntValue2, expression2 != null ? expression2.evaluate(expressionResolver) : null);
            }
        };
        divLineHeightTextView.addSubscription(divText.textColor.observe(expressionResolver, function1));
        Expression<Integer> expression2 = divText.focusedTextColor;
        divLineHeightTextView.addSubscription(expression2 != null ? expression2.observe(expressionResolver, function1) : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyTextColor(TextView textView, int i, Integer num) {
        textView.setTextColor(new ColorStateList(new int[][]{new int[]{R.attr.state_focused}, new int[0]}, new int[]{num != null ? num.intValue() : i, i}));
    }

    private final void bindUnderline(final DivLineHeightTextView divLineHeightTextView, DivText divText, DivText divText2, ExpressionResolver expressionResolver) {
        if (ExpressionsKt.equalsToConstant(divText.underline, divText2 != null ? divText2.underline : null)) {
            return;
        }
        applyUnderline(divLineHeightTextView, divText.underline.evaluate(expressionResolver));
        if (ExpressionsKt.isConstant(divText.underline)) {
            return;
        }
        divLineHeightTextView.addSubscription(divText.underline.observe(expressionResolver, new Function1<DivLineStyle, Unit>() { // from class: com.yandex.div.core.view2.divs.DivTextBinder.bindUnderline.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DivLineStyle divLineStyle) {
                invoke2(divLineStyle);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DivLineStyle underline) {
                Intrinsics.checkNotNullParameter(underline, "underline");
                DivTextBinder.this.applyUnderline(divLineHeightTextView, underline);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyUnderline(TextView textView, DivLineStyle divLineStyle) {
        int i = WhenMappings.$EnumSwitchMapping$1[divLineStyle.ordinal()];
        if (i == 1) {
            textView.setPaintFlags(textView.getPaintFlags() | 8);
        } else {
            if (i != 2) {
                return;
            }
            textView.setPaintFlags(textView.getPaintFlags() & (-9));
        }
    }

    private final void bindStrikethrough(final DivLineHeightTextView divLineHeightTextView, DivText divText, DivText divText2, ExpressionResolver expressionResolver) {
        if (ExpressionsKt.equalsToConstant(divText.strike, divText2 != null ? divText2.strike : null)) {
            return;
        }
        applyStrikethrough(divLineHeightTextView, divText.strike.evaluate(expressionResolver));
        if (ExpressionsKt.isConstant(divText.strike)) {
            return;
        }
        divLineHeightTextView.addSubscription(divText.strike.observe(expressionResolver, new Function1<DivLineStyle, Unit>() { // from class: com.yandex.div.core.view2.divs.DivTextBinder.bindStrikethrough.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DivLineStyle divLineStyle) {
                invoke2(divLineStyle);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DivLineStyle strikethrough) {
                Intrinsics.checkNotNullParameter(strikethrough, "strikethrough");
                DivTextBinder.this.applyStrikethrough(divLineHeightTextView, strikethrough);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyStrikethrough(TextView textView, DivLineStyle divLineStyle) {
        int i = WhenMappings.$EnumSwitchMapping$1[divLineStyle.ordinal()];
        if (i == 1) {
            textView.setPaintFlags(textView.getPaintFlags() | 16);
        } else {
            if (i != 2) {
                return;
            }
            textView.setPaintFlags(textView.getPaintFlags() & (-17));
        }
    }

    private final void bindSelectable(final DivLineHeightTextView divLineHeightTextView, DivText divText, DivText divText2, ExpressionResolver expressionResolver) {
        if (ExpressionsKt.equalsToConstant(divText.selectable, divText2 != null ? divText2.selectable : null)) {
            return;
        }
        applySelectable(divLineHeightTextView, divText.selectable.evaluate(expressionResolver).booleanValue());
        if (ExpressionsKt.isConstant(divText.selectable)) {
            return;
        }
        divLineHeightTextView.addSubscription(divText.selectable.observe(expressionResolver, new Function1<Boolean, Unit>() { // from class: com.yandex.div.core.view2.divs.DivTextBinder.bindSelectable.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                DivTextBinder.this.applySelectable(divLineHeightTextView, z);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applySelectable(TextView textView, boolean z) {
        textView.setTextIsSelectable(z);
    }

    private final void bindTightenWidth(final DivLineHeightTextView divLineHeightTextView, DivText divText, DivText divText2, ExpressionResolver expressionResolver) {
        if (ExpressionsKt.equalsToConstant(divText.tightenWidth, divText2 != null ? divText2.tightenWidth : null)) {
            return;
        }
        applyTightenWidth(divLineHeightTextView, divText.tightenWidth.evaluate(expressionResolver).booleanValue());
        if (ExpressionsKt.isConstant(divText.tightenWidth)) {
            return;
        }
        divLineHeightTextView.addSubscription(divText.tightenWidth.observe(expressionResolver, new Function1<Boolean, Unit>() { // from class: com.yandex.div.core.view2.divs.DivTextBinder.bindTightenWidth.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                DivTextBinder.this.applyTightenWidth(divLineHeightTextView, z);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyTightenWidth(DivLineHeightTextView divLineHeightTextView, boolean z) {
        divLineHeightTextView.setTightenWidth(z);
    }

    private final void bindTextGradient(DivLineHeightTextView divLineHeightTextView, Div2View div2View, DivText divText, DivText divText2, ExpressionResolver expressionResolver) {
        DivTextGradient divTextGradient = divText.textGradient;
        if (divTextGradient != null) {
            if (divTextGradient instanceof DivTextGradient.Linear) {
                bindLinearTextGradient(divLineHeightTextView, div2View, ((DivTextGradient.Linear) divTextGradient).getValue(), divText2 != null ? divText2.textGradient : null, expressionResolver);
            } else if (divTextGradient instanceof DivTextGradient.Radial) {
                bindRadialTextGradient(divLineHeightTextView, ((DivTextGradient.Radial) divTextGradient).getValue(), divText2 != null ? divText2.textGradient : null, expressionResolver);
            }
        }
    }

    private final void bindLinearTextGradient(final DivLineHeightTextView divLineHeightTextView, final Div2View div2View, final DivLinearGradient divLinearGradient, DivTextGradient divTextGradient, final ExpressionResolver expressionResolver) {
        if (divTextGradient instanceof DivTextGradient.Linear) {
            DivTextGradient.Linear linear = (DivTextGradient.Linear) divTextGradient;
            if (ExpressionsKt.equalsToConstant(divLinearGradient.angle, linear.getValue().angle) && ExpressionsKt.equalsToConstant(divLinearGradient.colors, linear.getValue().colors)) {
                List<DivLinearGradient.ColorPoint> list = divLinearGradient.colorMap;
                List<DivLinearGradient.ColorPoint> list2 = linear.getValue().colorMap;
                if (list == null && list2 == null) {
                    return;
                }
                if (list != null && list2 != null && list.size() == list2.size()) {
                    int i = 0;
                    for (Object obj : list) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (DivDataExtensionsKt.equalsToConstant((DivLinearGradient.ColorPoint) obj, list2.get(i))) {
                            i = i2;
                        }
                    }
                    return;
                }
            }
        }
        applyLinearTextGradientColor(divLineHeightTextView, divLinearGradient.angle.evaluate(expressionResolver).longValue(), ColormapKt.checkIsNotEmpty(DivDataExtensionsKt.toColormap(divLinearGradient, expressionResolver), div2View));
        if (ExpressionsKt.isConstant(divLinearGradient.angle) && ExpressionsKt.isConstantOrNull(divLinearGradient.colors)) {
            List<DivLinearGradient.ColorPoint> list3 = divLinearGradient.colorMap;
            if (list3 != null) {
                List<DivLinearGradient.ColorPoint> list4 = list3;
                if ((list4 instanceof Collection) && list4.isEmpty()) {
                    return;
                }
                Iterator<T> it = list4.iterator();
                while (it.hasNext()) {
                    if (!DivDataExtensionsKt.isConstant((DivLinearGradient.ColorPoint) it.next())) {
                    }
                }
                return;
            }
            return;
        }
        Function1<? super Long, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivTextBinder$bindLinearTextGradient$callback$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj2) {
                invoke2(obj2);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj2) {
                Intrinsics.checkNotNullParameter(obj2, "<anonymous parameter 0>");
                this.this$0.applyLinearTextGradientColor(divLineHeightTextView, divLinearGradient.angle.evaluate(expressionResolver).longValue(), ColormapKt.checkIsNotEmpty(DivDataExtensionsKt.toColormap(divLinearGradient, expressionResolver), div2View));
            }
        };
        divLineHeightTextView.addSubscription(divLinearGradient.angle.observe(expressionResolver, function1));
        ExpressionList<Integer> expressionList = divLinearGradient.colors;
        divLineHeightTextView.addSubscription(expressionList != null ? expressionList.observe(expressionResolver, function1) : null);
        List<DivLinearGradient.ColorPoint> list5 = divLinearGradient.colorMap;
        if (list5 != null) {
            Iterator<T> it2 = list5.iterator();
            while (it2.hasNext()) {
                ExpressionSubscribersKt.observeColorPoint(divLineHeightTextView, (DivLinearGradient.ColorPoint) it2.next(), expressionResolver, function1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyLinearTextGradientColor(final TextView textView, final long j, final Colormap colormap) {
        TextView textView2 = textView;
        if (ViewsKt.isActuallyLaidOut(textView2) && !textView2.isLayoutRequested()) {
            textView.getPaint().setShader(LinearGradientDrawable.INSTANCE.createLinearGradient(j, colormap.getColors(), colormap.getPositions(), getRealTextWidth(textView), (textView.getHeight() - textView.getPaddingBottom()) - textView.getPaddingTop()));
        } else {
            textView2.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.yandex.div.core.view2.divs.DivTextBinder$applyLinearTextGradientColor$$inlined$doOnActualLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                    view.removeOnLayoutChangeListener(this);
                    textView.getPaint().setShader(LinearGradientDrawable.INSTANCE.createLinearGradient(j, colormap.getColors(), colormap.getPositions(), this.getRealTextWidth(textView), (textView.getHeight() - textView.getPaddingBottom()) - textView.getPaddingTop()));
                }
            });
        }
    }

    private final void bindRadialTextGradient(final DivLineHeightTextView divLineHeightTextView, final DivRadialGradient divRadialGradient, DivTextGradient divTextGradient, final ExpressionResolver expressionResolver) {
        if (divTextGradient instanceof DivTextGradient.Radial) {
            DivTextGradient.Radial radial = (DivTextGradient.Radial) divTextGradient;
            if (Intrinsics.areEqual(divRadialGradient.radius, radial.getValue().radius) && Intrinsics.areEqual(divRadialGradient.centerX, radial.getValue().centerX) && Intrinsics.areEqual(divRadialGradient.centerY, radial.getValue().centerY) && ExpressionsKt.equalsToConstant(divRadialGradient.colors, radial.getValue().colors)) {
                return;
            }
        }
        final DisplayMetrics displayMetrics = divLineHeightTextView.getResources().getDisplayMetrics();
        DivRadialGradientRadius divRadialGradientRadius = divRadialGradient.radius;
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "displayMetrics");
        applyRadialTextGradientColor(divLineHeightTextView, toRadialGradientDrawableRadius(divRadialGradientRadius, displayMetrics, expressionResolver), toRadialGradientDrawableCenter(divRadialGradient.centerX, displayMetrics, expressionResolver), toRadialGradientDrawableCenter(divRadialGradient.centerY, displayMetrics, expressionResolver), divRadialGradient.colors.evaluate(expressionResolver));
        if (ExpressionsKt.isConstant(divRadialGradient.colors)) {
            return;
        }
        divLineHeightTextView.addSubscription(divRadialGradient.colors.observe(expressionResolver, new Function1<List<? extends Integer>, Unit>() { // from class: com.yandex.div.core.view2.divs.DivTextBinder.bindRadialTextGradient.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends Integer> list) {
                invoke2((List<Integer>) list);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<Integer> colors) {
                Intrinsics.checkNotNullParameter(colors, "colors");
                DivTextBinder divTextBinder = DivTextBinder.this;
                DivLineHeightTextView divLineHeightTextView2 = divLineHeightTextView;
                DivRadialGradientRadius divRadialGradientRadius2 = divRadialGradient.radius;
                DisplayMetrics displayMetrics2 = displayMetrics;
                Intrinsics.checkNotNullExpressionValue(displayMetrics2, "displayMetrics");
                RadialGradientDrawable.Radius radialGradientDrawableRadius = divTextBinder.toRadialGradientDrawableRadius(divRadialGradientRadius2, displayMetrics2, expressionResolver);
                DivTextBinder divTextBinder2 = DivTextBinder.this;
                DivRadialGradientCenter divRadialGradientCenter = divRadialGradient.centerX;
                DisplayMetrics displayMetrics3 = displayMetrics;
                Intrinsics.checkNotNullExpressionValue(displayMetrics3, "displayMetrics");
                RadialGradientDrawable.Center radialGradientDrawableCenter = divTextBinder2.toRadialGradientDrawableCenter(divRadialGradientCenter, displayMetrics3, expressionResolver);
                DivTextBinder divTextBinder3 = DivTextBinder.this;
                DivRadialGradientCenter divRadialGradientCenter2 = divRadialGradient.centerY;
                DisplayMetrics displayMetrics4 = displayMetrics;
                Intrinsics.checkNotNullExpressionValue(displayMetrics4, "displayMetrics");
                divTextBinder.applyRadialTextGradientColor(divLineHeightTextView2, radialGradientDrawableRadius, radialGradientDrawableCenter, divTextBinder3.toRadialGradientDrawableCenter(divRadialGradientCenter2, displayMetrics4, expressionResolver), colors);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyRadialTextGradientColor(final TextView textView, final RadialGradientDrawable.Radius radius, final RadialGradientDrawable.Center center, final RadialGradientDrawable.Center center2, final List<Integer> list) {
        TextView textView2 = textView;
        if (ViewsKt.isActuallyLaidOut(textView2) && !textView2.isLayoutRequested()) {
            textView.getPaint().setShader(RadialGradientDrawable.INSTANCE.createRadialGradient(radius, center, center2, CollectionsKt.toIntArray(list), getRealTextWidth(textView), (textView.getHeight() - textView.getPaddingBottom()) - textView.getPaddingTop()));
        } else {
            textView2.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.yandex.div.core.view2.divs.DivTextBinder$applyRadialTextGradientColor$$inlined$doOnActualLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                    view.removeOnLayoutChangeListener(this);
                    textView.getPaint().setShader(RadialGradientDrawable.INSTANCE.createRadialGradient(radius, center, center2, CollectionsKt.toIntArray(list), this.getRealTextWidth(textView), (textView.getHeight() - textView.getPaddingBottom()) - textView.getPaddingTop()));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getRealTextWidth(TextView textView) {
        return Math.min((textView.getWidth() - textView.getPaddingRight()) - textView.getPaddingLeft(), (int) textView.getPaint().measureText(textView.getText().toString()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RadialGradientDrawable.Radius toRadialGradientDrawableRadius(DivRadialGradientRadius divRadialGradientRadius, DisplayMetrics displayMetrics, ExpressionResolver expressionResolver) {
        RadialGradientDrawable.Radius.Relative.Type type;
        if (divRadialGradientRadius instanceof DivRadialGradientRadius.FixedSize) {
            return new RadialGradientDrawable.Radius.Fixed(BaseDivViewExtensionsKt.dpToPxF(((DivRadialGradientRadius.FixedSize) divRadialGradientRadius).getValue().value.evaluate(expressionResolver), displayMetrics));
        }
        if (!(divRadialGradientRadius instanceof DivRadialGradientRadius.Relative)) {
            throw new NoWhenBranchMatchedException();
        }
        int i = WhenMappings.$EnumSwitchMapping$2[((DivRadialGradientRadius.Relative) divRadialGradientRadius).getValue().value.evaluate(expressionResolver).ordinal()];
        if (i == 1) {
            type = RadialGradientDrawable.Radius.Relative.Type.FARTHEST_CORNER;
        } else if (i == 2) {
            type = RadialGradientDrawable.Radius.Relative.Type.NEAREST_CORNER;
        } else if (i == 3) {
            type = RadialGradientDrawable.Radius.Relative.Type.FARTHEST_SIDE;
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            type = RadialGradientDrawable.Radius.Relative.Type.NEAREST_SIDE;
        }
        return new RadialGradientDrawable.Radius.Relative(type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RadialGradientDrawable.Center toRadialGradientDrawableCenter(DivRadialGradientCenter divRadialGradientCenter, DisplayMetrics displayMetrics, ExpressionResolver expressionResolver) {
        if (divRadialGradientCenter instanceof DivRadialGradientCenter.Fixed) {
            return new RadialGradientDrawable.Center.Fixed(BaseDivViewExtensionsKt.dpToPxF(((DivRadialGradientCenter.Fixed) divRadialGradientCenter).getValue().value.evaluate(expressionResolver), displayMetrics));
        }
        if (divRadialGradientCenter instanceof DivRadialGradientCenter.Relative) {
            return new RadialGradientDrawable.Center.Relative((float) ((DivRadialGradientCenter.Relative) divRadialGradientCenter).getValue().value.evaluate(expressionResolver).doubleValue());
        }
        throw new NoWhenBranchMatchedException();
    }

    private final void bindText(DivLineHeightTextView divLineHeightTextView, BindingContext bindingContext, DivText divText, DivText divText2) {
        if (divText.ranges == null && divText.images == null) {
            bindPlainText(divLineHeightTextView, bindingContext, divText, divText2);
        } else {
            bindRichText(divLineHeightTextView, bindingContext, divText);
        }
    }

    private final void bindRichText(final DivLineHeightTextView divLineHeightTextView, final BindingContext bindingContext, final DivText divText) {
        ExpressionResolver expressionResolver = bindingContext.getExpressionResolver();
        DivLineHeightTextView divLineHeightTextView2 = divLineHeightTextView;
        applyRichText(divLineHeightTextView2, bindingContext, divText);
        applyHyphenation(divLineHeightTextView2, divText.text.evaluate(expressionResolver));
        divLineHeightTextView.addSubscription(divText.text.observe(expressionResolver, new Function1<String, Unit>() { // from class: com.yandex.div.core.view2.divs.DivTextBinder.bindRichText.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String text) {
                Intrinsics.checkNotNullParameter(text, "text");
                DivTextBinder.this.applyRichText(divLineHeightTextView, bindingContext, divText);
                DivTextBinder.this.applyHyphenation(divLineHeightTextView, text);
            }
        }));
        Function1<? super Long, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivTextBinder$bindRichText$callback$1
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
                this.this$0.applyRichText(divLineHeightTextView, bindingContext, divText);
            }
        };
        divLineHeightTextView.addSubscription(divText.fontSize.observe(expressionResolver, function1));
        divLineHeightTextView.addSubscription(divText.fontSizeUnit.observe(expressionResolver, function1));
        Expression<String> expression = divText.fontFamily;
        divLineHeightTextView.addSubscription(expression != null ? expression.observe(expressionResolver, function1) : null);
        Expression<Long> expression2 = divText.lineHeight;
        divLineHeightTextView.addSubscription(expression2 != null ? expression2.observe(expressionResolver, function1) : null);
        List<DivText.Range> list = divText.ranges;
        if (list != null) {
            for (DivText.Range range : list) {
                divLineHeightTextView.addSubscription(range.start.observe(expressionResolver, function1));
                Expression<Long> expression3 = range.end;
                divLineHeightTextView.addSubscription(expression3 != null ? expression3.observe(expressionResolver, function1) : null);
                Expression<DivTextAlignmentVertical> expression4 = range.alignmentVertical;
                divLineHeightTextView.addSubscription(expression4 != null ? expression4.observe(expressionResolver, function1) : null);
                Expression<Long> expression5 = range.fontSize;
                divLineHeightTextView.addSubscription(expression5 != null ? expression5.observe(expressionResolver, function1) : null);
                divLineHeightTextView.addSubscription(range.fontSizeUnit.observe(expressionResolver, function1));
                Expression<DivFontWeight> expression6 = range.fontWeight;
                divLineHeightTextView.addSubscription(expression6 != null ? expression6.observe(expressionResolver, function1) : null);
                Expression<Long> expression7 = range.fontWeightValue;
                divLineHeightTextView.addSubscription(expression7 != null ? expression7.observe(expressionResolver, function1) : null);
                Expression<Double> expression8 = range.letterSpacing;
                divLineHeightTextView.addSubscription(expression8 != null ? expression8.observe(expressionResolver, function1) : null);
                Expression<Long> expression9 = range.lineHeight;
                divLineHeightTextView.addSubscription(expression9 != null ? expression9.observe(expressionResolver, function1) : null);
                Expression<DivLineStyle> expression10 = range.strike;
                divLineHeightTextView.addSubscription(expression10 != null ? expression10.observe(expressionResolver, function1) : null);
                Expression<Integer> expression11 = range.textColor;
                divLineHeightTextView.addSubscription(expression11 != null ? expression11.observe(expressionResolver, function1) : null);
                Expression<Long> expression12 = range.topOffset;
                divLineHeightTextView.addSubscription(expression12 != null ? expression12.observe(expressionResolver, function1) : null);
                Expression<DivLineStyle> expression13 = range.underline;
                divLineHeightTextView.addSubscription(expression13 != null ? expression13.observe(expressionResolver, function1) : null);
            }
        }
        List<DivText.Image> list2 = divText.images;
        if (list2 != null) {
            for (DivText.Image image : list2) {
                divLineHeightTextView.addSubscription(image.start.observe(expressionResolver, function1));
                divLineHeightTextView.addSubscription(image.indexingDirection.observe(expressionResolver, function1));
                divLineHeightTextView.addSubscription(image.url.observe(expressionResolver, function1));
                divLineHeightTextView.addSubscription(image.alignmentVertical.observe(expressionResolver, function1));
                Expression<Integer> expression14 = image.tintColor;
                divLineHeightTextView.addSubscription(expression14 != null ? expression14.observe(expressionResolver, function1) : null);
                divLineHeightTextView.addSubscription(image.width.value.observe(expressionResolver, function1));
                divLineHeightTextView.addSubscription(image.width.unit.observe(expressionResolver, function1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyRichText(final TextView textView, BindingContext bindingContext, DivText divText) {
        this.spannedTextBuilder.buildText(bindingContext, textView, divText, new Function1<Spanned, Unit>() { // from class: com.yandex.div.core.view2.divs.DivTextBinder.applyRichText.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Spanned spanned) {
                invoke2(spanned);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Spanned spannedText) {
                Intrinsics.checkNotNullParameter(spannedText, "spannedText");
                textView.setText(spannedText, TextView.BufferType.NORMAL);
            }
        });
    }

    private final void bindPlainText(final DivLineHeightTextView divLineHeightTextView, final BindingContext bindingContext, final DivText divText, DivText divText2) {
        if (ExpressionsKt.equalsToConstant(divText.text, divText2 != null ? divText2.text : null)) {
            if (ExpressionsKt.equalsToConstant(divText.lineHeight, divText2 != null ? divText2.lineHeight : null)) {
                if (ExpressionsKt.equalsToConstant(divText.fontSizeUnit, divText2 != null ? divText2.fontSizeUnit : null)) {
                    return;
                }
            }
        }
        final ExpressionResolver expressionResolver = bindingContext.getExpressionResolver();
        String strEvaluate = divText.text.evaluate(expressionResolver);
        DivLineHeightTextView divLineHeightTextView2 = divLineHeightTextView;
        applyPlainText(divLineHeightTextView2, bindingContext, divText);
        applyHyphenation(divLineHeightTextView2, strEvaluate);
        if (ExpressionsKt.isConstant(divText.text) && ExpressionsKt.isConstantOrNull(divText.lineHeight) && ExpressionsKt.isConstantOrNull(divText.fontSizeUnit)) {
            return;
        }
        Function1<? super String, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivTextBinder$bindPlainText$callback$1
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
                String strEvaluate2 = divText.text.evaluate(expressionResolver);
                this.applyPlainText(divLineHeightTextView, bindingContext, divText);
                this.applyHyphenation(divLineHeightTextView, strEvaluate2);
            }
        };
        divLineHeightTextView.addSubscription(divText.text.observe(expressionResolver, function1));
        Expression<Long> expression = divText.lineHeight;
        divLineHeightTextView.addSubscription(expression != null ? expression.observe(expressionResolver, function1) : null);
        divLineHeightTextView.addSubscription(divText.fontSizeUnit.observe(expressionResolver, function1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyPlainText(TextView textView, BindingContext bindingContext, DivText divText) {
        textView.setText(this.spannedTextBuilder.buildPlainText(bindingContext, textView, divText));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyHyphenation(TextView textView, String str) {
        if (TextViewsKt.checkHyphenationSupported()) {
            int hyphenationFrequency = textView.getHyphenationFrequency();
            int i = 0;
            if (this.isHyphenationEnabled && TextUtils.indexOf((CharSequence) str, (char) 173, 0, Math.min(str.length(), 10)) > 0) {
                i = 1;
            }
            if (hyphenationFrequency != i) {
                textView.setHyphenationFrequency(i);
            }
        }
    }

    private final void bindEllipsis(DivLineHeightTextView divLineHeightTextView, BindingContext bindingContext, DivText divText, DivText divText2) {
        DivText.Ellipsis ellipsis = divText.ellipsis;
        if ((ellipsis != null ? ellipsis.ranges : null) == null) {
            if ((ellipsis != null ? ellipsis.images : null) == null) {
                if ((ellipsis != null ? ellipsis.actions : null) == null) {
                    bindPlainEllipsis(divLineHeightTextView, divText.ellipsis, divText2 != null ? divText2.ellipsis : null, bindingContext.getExpressionResolver());
                    return;
                }
            }
        }
        bindRichEllipsis(divLineHeightTextView, bindingContext, divText);
    }

    private final void bindPlainEllipsis(final DivLineHeightTextView divLineHeightTextView, DivText.Ellipsis ellipsis, DivText.Ellipsis ellipsis2, ExpressionResolver expressionResolver) {
        Expression<String> expression;
        Expression<String> expression2;
        Disposable disposableObserve = null;
        if (ExpressionsKt.equalsToConstant(ellipsis != null ? ellipsis.text : null, ellipsis2 != null ? ellipsis2.text : null)) {
            return;
        }
        applyPlainEllipsis(divLineHeightTextView, (ellipsis == null || (expression2 = ellipsis.text) == null) ? null : expression2.evaluate(expressionResolver));
        if (ExpressionsKt.isConstantOrNull(ellipsis != null ? ellipsis.text : null)) {
            if (ExpressionsKt.isConstantOrNull(ellipsis != null ? ellipsis.text : null)) {
                return;
            }
        }
        if (ellipsis != null && (expression = ellipsis.text) != null) {
            disposableObserve = expression.observe(expressionResolver, new Function1<String, Unit>() { // from class: com.yandex.div.core.view2.divs.DivTextBinder.bindPlainEllipsis.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String ellipsis3) {
                    Intrinsics.checkNotNullParameter(ellipsis3, "ellipsis");
                    DivTextBinder.this.applyPlainEllipsis(divLineHeightTextView, ellipsis3);
                }
            });
        }
        divLineHeightTextView.addSubscription(disposableObserve);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyPlainEllipsis(DivLineHeightTextView divLineHeightTextView, String str) {
        if (str == null) {
            str = EllipsizedTextView.DEFAULT_ELLIPSIS;
        }
        divLineHeightTextView.setEllipsis(str);
    }

    private final void bindRichEllipsis(final DivLineHeightTextView divLineHeightTextView, final BindingContext bindingContext, final DivText divText) {
        DivStroke divStroke;
        Expression<Double> expression;
        DivStroke divStroke2;
        Expression<Integer> expression2;
        applyRichEllipsis(divLineHeightTextView, bindingContext, divText);
        DivText.Ellipsis ellipsis = divText.ellipsis;
        if (ellipsis == null) {
            return;
        }
        ExpressionResolver expressionResolver = bindingContext.getExpressionResolver();
        Function1<? super String, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivTextBinder$bindRichEllipsis$callback$1
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
                this.this$0.applyRichEllipsis(divLineHeightTextView, bindingContext, divText);
            }
        };
        divLineHeightTextView.addSubscription(ellipsis.text.observe(expressionResolver, function1));
        List<DivText.Range> list = ellipsis.ranges;
        if (list != null) {
            for (DivText.Range range : list) {
                divLineHeightTextView.addSubscription(range.start.observe(expressionResolver, function1));
                Expression<Long> expression3 = range.end;
                divLineHeightTextView.addSubscription(expression3 != null ? expression3.observe(expressionResolver, function1) : null);
                Expression<Long> expression4 = range.fontSize;
                divLineHeightTextView.addSubscription(expression4 != null ? expression4.observe(expressionResolver, function1) : null);
                divLineHeightTextView.addSubscription(range.fontSizeUnit.observe(expressionResolver, function1));
                Expression<DivFontWeight> expression5 = range.fontWeight;
                divLineHeightTextView.addSubscription(expression5 != null ? expression5.observe(expressionResolver, function1) : null);
                Expression<Long> expression6 = range.fontWeightValue;
                divLineHeightTextView.addSubscription(expression6 != null ? expression6.observe(expressionResolver, function1) : null);
                Expression<Double> expression7 = range.letterSpacing;
                divLineHeightTextView.addSubscription(expression7 != null ? expression7.observe(expressionResolver, function1) : null);
                Expression<Long> expression8 = range.lineHeight;
                divLineHeightTextView.addSubscription(expression8 != null ? expression8.observe(expressionResolver, function1) : null);
                Expression<DivLineStyle> expression9 = range.strike;
                divLineHeightTextView.addSubscription(expression9 != null ? expression9.observe(expressionResolver, function1) : null);
                Expression<Integer> expression10 = range.textColor;
                divLineHeightTextView.addSubscription(expression10 != null ? expression10.observe(expressionResolver, function1) : null);
                Expression<Long> expression11 = range.topOffset;
                divLineHeightTextView.addSubscription(expression11 != null ? expression11.observe(expressionResolver, function1) : null);
                Expression<DivLineStyle> expression12 = range.underline;
                divLineHeightTextView.addSubscription(expression12 != null ? expression12.observe(expressionResolver, function1) : null);
                DivTextRangeBackground divTextRangeBackground = range.background;
                Object objValue = divTextRangeBackground != null ? divTextRangeBackground.value() : null;
                if (objValue instanceof DivSolidBackground) {
                    divLineHeightTextView.addSubscription(((DivSolidBackground) objValue).color.observe(expressionResolver, function1));
                }
                DivTextRangeBorder divTextRangeBorder = range.border;
                divLineHeightTextView.addSubscription((divTextRangeBorder == null || (divStroke2 = divTextRangeBorder.stroke) == null || (expression2 = divStroke2.color) == null) ? null : expression2.observe(expressionResolver, function1));
                DivTextRangeBorder divTextRangeBorder2 = range.border;
                divLineHeightTextView.addSubscription((divTextRangeBorder2 == null || (divStroke = divTextRangeBorder2.stroke) == null || (expression = divStroke.width) == null) ? null : expression.observe(expressionResolver, function1));
            }
        }
        List<DivText.Image> list2 = ellipsis.images;
        if (list2 != null) {
            for (DivText.Image image : list2) {
                divLineHeightTextView.addSubscription(image.start.observe(expressionResolver, function1));
                divLineHeightTextView.addSubscription(image.url.observe(expressionResolver, function1));
                Expression<Integer> expression13 = image.tintColor;
                divLineHeightTextView.addSubscription(expression13 != null ? expression13.observe(expressionResolver, function1) : null);
                divLineHeightTextView.addSubscription(image.width.value.observe(expressionResolver, function1));
                divLineHeightTextView.addSubscription(image.width.unit.observe(expressionResolver, function1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyRichEllipsis(final EllipsizedTextView ellipsizedTextView, BindingContext bindingContext, DivText divText) {
        DivText.Ellipsis ellipsis = divText.ellipsis;
        if (ellipsis == null) {
            ellipsizedTextView.setEllipsis(EllipsizedTextView.DEFAULT_ELLIPSIS);
        } else {
            this.spannedTextBuilder.buildEllipsis(bindingContext, ellipsizedTextView, divText, ellipsis, new Function1<Spanned, Unit>() { // from class: com.yandex.div.core.view2.divs.DivTextBinder.applyRichEllipsis.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Spanned spanned) {
                    invoke2(spanned);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Spanned ellipsis2) {
                    Intrinsics.checkNotNullParameter(ellipsis2, "ellipsis");
                    ellipsizedTextView.setEllipsis(ellipsis2);
                }
            });
        }
    }

    private final void bindTextShadow(final DivLineHeightTextView divLineHeightTextView, final DivText divText, DivText divText2, final ExpressionResolver expressionResolver) {
        ShadowData shadowData;
        DivPoint divPoint;
        DivDimension divDimension;
        Expression<DivSizeUnit> expression;
        DivPoint divPoint2;
        DivDimension divDimension2;
        Expression<Double> expression2;
        DivPoint divPoint3;
        DivDimension divDimension3;
        Expression<DivSizeUnit> expression3;
        DivPoint divPoint4;
        DivDimension divDimension4;
        Expression<Double> expression4;
        Expression<Long> expression5;
        Expression<Integer> expression6;
        Expression<Double> expression7;
        DivPoint divPoint5;
        DivDimension divDimension5;
        DivPoint divPoint6;
        DivDimension divDimension6;
        DivPoint divPoint7;
        DivDimension divDimension7;
        DivPoint divPoint8;
        DivDimension divDimension8;
        DivShadow divShadow;
        DivPoint divPoint9;
        DivDimension divDimension9;
        DivPoint divPoint10;
        DivDimension divDimension10;
        DivShadow divShadow2;
        DivPoint divPoint11;
        DivDimension divDimension11;
        DivPoint divPoint12;
        DivDimension divDimension12;
        DivShadow divShadow3;
        DivPoint divPoint13;
        DivDimension divDimension13;
        DivPoint divPoint14;
        DivDimension divDimension14;
        DivShadow divShadow4;
        DivPoint divPoint15;
        DivDimension divDimension15;
        DivPoint divPoint16;
        DivDimension divDimension16;
        DivShadow divShadow5;
        DivShadow divShadow6;
        DivShadow divShadow7;
        DivShadow divShadow8 = divText.textShadow;
        Disposable disposableObserve = null;
        if (ExpressionsKt.equalsToConstant(divShadow8 != null ? divShadow8.alpha : null, (divText2 == null || (divShadow7 = divText2.textShadow) == null) ? null : divShadow7.alpha)) {
            DivShadow divShadow9 = divText.textShadow;
            if (ExpressionsKt.equalsToConstant(divShadow9 != null ? divShadow9.blur : null, (divText2 == null || (divShadow6 = divText2.textShadow) == null) ? null : divShadow6.blur)) {
                DivShadow divShadow10 = divText.textShadow;
                if (ExpressionsKt.equalsToConstant(divShadow10 != null ? divShadow10.color : null, (divText2 == null || (divShadow5 = divText2.textShadow) == null) ? null : divShadow5.color)) {
                    DivShadow divShadow11 = divText.textShadow;
                    if (ExpressionsKt.equalsToConstant((divShadow11 == null || (divPoint16 = divShadow11.offset) == null || (divDimension16 = divPoint16.x) == null) ? null : divDimension16.value, (divText2 == null || (divShadow4 = divText2.textShadow) == null || (divPoint15 = divShadow4.offset) == null || (divDimension15 = divPoint15.x) == null) ? null : divDimension15.value)) {
                        DivShadow divShadow12 = divText.textShadow;
                        if (ExpressionsKt.equalsToConstant((divShadow12 == null || (divPoint14 = divShadow12.offset) == null || (divDimension14 = divPoint14.x) == null) ? null : divDimension14.unit, (divText2 == null || (divShadow3 = divText2.textShadow) == null || (divPoint13 = divShadow3.offset) == null || (divDimension13 = divPoint13.x) == null) ? null : divDimension13.unit)) {
                            DivShadow divShadow13 = divText.textShadow;
                            if (ExpressionsKt.equalsToConstant((divShadow13 == null || (divPoint12 = divShadow13.offset) == null || (divDimension12 = divPoint12.y) == null) ? null : divDimension12.value, (divText2 == null || (divShadow2 = divText2.textShadow) == null || (divPoint11 = divShadow2.offset) == null || (divDimension11 = divPoint11.y) == null) ? null : divDimension11.value)) {
                                DivShadow divShadow14 = divText.textShadow;
                                if (ExpressionsKt.equalsToConstant((divShadow14 == null || (divPoint10 = divShadow14.offset) == null || (divDimension10 = divPoint10.y) == null) ? null : divDimension10.unit, (divText2 == null || (divShadow = divText2.textShadow) == null || (divPoint9 = divShadow.offset) == null || (divDimension9 = divPoint9.y) == null) ? null : divDimension9.unit)) {
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        final DivShadow divShadow15 = divText.textShadow;
        final DisplayMetrics displayMetrics = divLineHeightTextView.getResources().getDisplayMetrics();
        DivLineHeightTextView divLineHeightTextView2 = divLineHeightTextView;
        if (divShadow15 != null) {
            Intrinsics.checkNotNullExpressionValue(displayMetrics, "displayMetrics");
            shadowData = getShadowData(divShadow15, expressionResolver, displayMetrics, divText.textColor.evaluate(expressionResolver).intValue());
        } else {
            shadowData = null;
        }
        applyTextShadow(divLineHeightTextView2, shadowData);
        DivShadow divShadow16 = divText.textShadow;
        if (ExpressionsKt.isConstantOrNull(divShadow16 != null ? divShadow16.alpha : null)) {
            DivShadow divShadow17 = divText.textShadow;
            if (ExpressionsKt.isConstantOrNull(divShadow17 != null ? divShadow17.blur : null)) {
                DivShadow divShadow18 = divText.textShadow;
                if (ExpressionsKt.isConstantOrNull(divShadow18 != null ? divShadow18.color : null)) {
                    DivShadow divShadow19 = divText.textShadow;
                    if (ExpressionsKt.isConstantOrNull((divShadow19 == null || (divPoint8 = divShadow19.offset) == null || (divDimension8 = divPoint8.x) == null) ? null : divDimension8.value)) {
                        DivShadow divShadow20 = divText.textShadow;
                        if (ExpressionsKt.isConstantOrNull((divShadow20 == null || (divPoint7 = divShadow20.offset) == null || (divDimension7 = divPoint7.x) == null) ? null : divDimension7.unit)) {
                            DivShadow divShadow21 = divText.textShadow;
                            if (ExpressionsKt.isConstantOrNull((divShadow21 == null || (divPoint6 = divShadow21.offset) == null || (divDimension6 = divPoint6.y) == null) ? null : divDimension6.value)) {
                                DivShadow divShadow22 = divText.textShadow;
                                if (ExpressionsKt.isConstantOrNull((divShadow22 == null || (divPoint5 = divShadow22.offset) == null || (divDimension5 = divPoint5.y) == null) ? null : divDimension5.unit)) {
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        Function1<? super DivSizeUnit, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivTextBinder$bindTextShadow$callback$1
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
                ShadowData shadowData2;
                Intrinsics.checkNotNullParameter(obj, "<anonymous parameter 0>");
                DivTextBinder divTextBinder = this.this$0;
                DivLineHeightTextView divLineHeightTextView3 = divLineHeightTextView;
                DivShadow divShadow23 = divShadow15;
                if (divShadow23 != null) {
                    ExpressionResolver expressionResolver2 = expressionResolver;
                    DisplayMetrics displayMetrics2 = displayMetrics;
                    Intrinsics.checkNotNullExpressionValue(displayMetrics2, "displayMetrics");
                    shadowData2 = divTextBinder.getShadowData(divShadow23, expressionResolver2, displayMetrics2, divText.textColor.evaluate(expressionResolver).intValue());
                } else {
                    shadowData2 = null;
                }
                divTextBinder.applyTextShadow(divLineHeightTextView3, shadowData2);
            }
        };
        divLineHeightTextView.addSubscription((divShadow15 == null || (expression7 = divShadow15.alpha) == null) ? null : expression7.observe(expressionResolver, function1));
        divLineHeightTextView.addSubscription((divShadow15 == null || (expression6 = divShadow15.color) == null) ? null : expression6.observe(expressionResolver, function1));
        divLineHeightTextView.addSubscription((divShadow15 == null || (expression5 = divShadow15.blur) == null) ? null : expression5.observe(expressionResolver, function1));
        divLineHeightTextView.addSubscription((divShadow15 == null || (divPoint4 = divShadow15.offset) == null || (divDimension4 = divPoint4.x) == null || (expression4 = divDimension4.value) == null) ? null : expression4.observe(expressionResolver, function1));
        divLineHeightTextView.addSubscription((divShadow15 == null || (divPoint3 = divShadow15.offset) == null || (divDimension3 = divPoint3.x) == null || (expression3 = divDimension3.unit) == null) ? null : expression3.observe(expressionResolver, function1));
        divLineHeightTextView.addSubscription((divShadow15 == null || (divPoint2 = divShadow15.offset) == null || (divDimension2 = divPoint2.y) == null || (expression2 = divDimension2.value) == null) ? null : expression2.observe(expressionResolver, function1));
        if (divShadow15 != null && (divPoint = divShadow15.offset) != null && (divDimension = divPoint.y) != null && (expression = divDimension.unit) != null) {
            disposableObserve = expression.observe(expressionResolver, function1);
        }
        divLineHeightTextView.addSubscription(disposableObserve);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyTextShadow(TextView textView, ShadowData shadowData) {
        DivViewWrapper divViewWrapper;
        if (shadowData == null) {
            ViewParent parent = textView.getParent();
            divViewWrapper = parent instanceof DivViewWrapper ? (DivViewWrapper) parent : null;
            if (divViewWrapper != null) {
                divViewWrapper.setClipChildren(true);
                divViewWrapper.setClipToPadding(true);
            }
            textView.setClipToOutline(true);
            textView.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            return;
        }
        ViewParent parent2 = textView.getParent();
        divViewWrapper = parent2 instanceof DivViewWrapper ? (DivViewWrapper) parent2 : null;
        if (divViewWrapper != null) {
            divViewWrapper.setClipChildren(false);
            divViewWrapper.setClipToPadding(false);
        }
        textView.setClipToOutline(false);
        textView.setShadowLayer(shadowData.getRadius(), shadowData.getOffsetX(), shadowData.getOffsetY(), shadowData.getColor());
    }

    private final void bindAutoEllipsize(DivLineHeightTextView divLineHeightTextView, DivText divText, DivText divText2, ExpressionResolver expressionResolver) {
        if (ExpressionsKt.equalsToConstant(divText.autoEllipsize, divText2 != null ? divText2.autoEllipsize : null)) {
            return;
        }
        Expression<Boolean> expression = divText.autoEllipsize;
        applyAutoEllipsize(divLineHeightTextView, expression != null ? expression.evaluate(expressionResolver).booleanValue() : false);
    }

    private final void applyAutoEllipsize(DivLineHeightTextView divLineHeightTextView, boolean z) {
        divLineHeightTextView.setAutoEllipsize(z);
    }

    private final void updateFocusableState(View view, DivText divText) {
        view.setFocusable(view.isFocusable() || divText.focusedTextColor != null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ShadowData getShadowData(DivShadow divShadow, ExpressionResolver expressionResolver, DisplayMetrics displayMetrics, int i) {
        float fDpToPxF = BaseDivViewExtensionsKt.dpToPxF(divShadow.blur.evaluate(expressionResolver), displayMetrics);
        float px = BaseDivViewExtensionsKt.toPx(divShadow.offset.x, displayMetrics, expressionResolver);
        float px2 = BaseDivViewExtensionsKt.toPx(divShadow.offset.y, displayMetrics, expressionResolver);
        Paint paint = new Paint();
        paint.setColor(divShadow.color.evaluate(expressionResolver).intValue());
        paint.setAlpha((int) (divShadow.alpha.evaluate(expressionResolver).doubleValue() * ((double) (i >>> 24))));
        return new ShadowData(px, px2, fDpToPxF, paint.getColor());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyFontSize(TextView textView, long j, DivSizeUnit divSizeUnit, double d) {
        int i;
        long j2 = j >> 31;
        if (j2 == 0 || j2 == -1) {
            i = (int) j;
        } else {
            KAssert kAssert = KAssert.INSTANCE;
            if (Assert.isEnabled()) {
                Assert.fail("Unable convert '" + j + "' to Int");
            }
            i = j > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        BaseDivViewExtensionsKt.applyFontSize(textView, i, divSizeUnit);
        BaseDivViewExtensionsKt.applyLetterSpacing(textView, d, i);
    }
}
