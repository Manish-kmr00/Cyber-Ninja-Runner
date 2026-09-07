package com.yandex.div.core.view2.spannable;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.StrikethroughSpan;
import android.text.style.UnderlineSpan;
import android.util.DisplayMetrics;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.compose.material.OutlinedTextFieldKt;
import androidx.core.view.ViewCompat;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.json.b9;
import com.yandex.div.core.DivIdLoggingImageDownloadCallback;
import com.yandex.div.core.actions.DivActionTypedUtilsKt;
import com.yandex.div.core.dagger.DivScope;
import com.yandex.div.core.images.CachedBitmap;
import com.yandex.div.core.images.DivImageLoader;
import com.yandex.div.core.images.LoadReference;
import com.yandex.div.core.util.text.DivBackgroundSpan;
import com.yandex.div.core.util.text.DivTextRangesBackgroundHelper;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.DivTypefaceResolver;
import com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt;
import com.yandex.div.core.view2.divs.DivActionBinder;
import com.yandex.div.core.view2.divs.widgets.DivLineHeightTextView;
import com.yandex.div.core.view2.divs.widgets.DivLineHeightTextViewKt;
import com.yandex.div.internal.Assert;
import com.yandex.div.internal.KAssert;
import com.yandex.div.internal.spannable.LetterSpacingSpan;
import com.yandex.div.internal.spannable.NoStrikethroughSpan;
import com.yandex.div.internal.spannable.NoUnderlineSpan;
import com.yandex.div.internal.spannable.TextColorSpan;
import com.yandex.div.internal.spannable.TypefaceSpan;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivAction;
import com.yandex.div2.DivFixedSize;
import com.yandex.div2.DivFontWeight;
import com.yandex.div2.DivLineStyle;
import com.yandex.div2.DivShadow;
import com.yandex.div2.DivSizeUnit;
import com.yandex.div2.DivText;
import com.yandex.div2.DivTextAlignmentVertical;
import com.yandex.div2.DivTextRangeBackground;
import com.yandex.div2.DivTextRangeBorder;
import io.appmetrica.analytics.impl.J2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;

/* JADX INFO: compiled from: SpannedTextBuilder.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 I2\u00020\u0001:\u0002IJB\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J@\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0002JD\u0010\u0019\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J0\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J(\u0010$\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!2\u0006\u0010%\u001a\u00020&H\u0002JD\u0010'\u001a\u00020(2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u001c\b\u0002\u0010-\u001a\u0016\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\f\u0018\u00010.j\u0004\u0018\u0001`/J\u001e\u00100\u001a\u00020(2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010)\u001a\u00020*J<\u00101\u001a\u00020(2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010)\u001a\u00020*2\u001c\b\u0002\u0010-\u001a\u0016\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\f\u0018\u00010.j\u0004\u0018\u0001`/Jv\u00101\u001a\u00020(2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010)\u001a\u00020*2\u0006\u00102\u001a\u0002032\u000e\u00104\u001a\n\u0012\u0004\u0012\u000205\u0018\u00010\u00172\u000e\u00106\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u00172\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00172\u001c\b\u0002\u0010-\u001a\u0016\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\f\u0018\u00010.j\u0004\u0018\u0001`/H\u0002Jl\u00101\u001a\u00020(2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010)\u001a\u00020*2\u000e\u00104\u001a\n\u0012\u0004\u0012\u000205\u0018\u00010\u00172\u000e\u00106\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u00172\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00172\u001c\b\u0002\u0010-\u001a\u0016\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\f\u0018\u00010.j\u0004\u0018\u0001`/J.\u00107\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u00020:2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010;\u001a\u0004\u0018\u00010<2\b\b\u0001\u0010=\u001a\u00020\u0014H\u0002J8\u0010>\u001a\u00020&2\u0006\u00109\u001a\u00020:2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020!2\u0006\u0010?\u001a\u0002052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J(\u0010@\u001a\u00020!2\u0006\u00109\u001a\u00020:2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020*2\u0006\u00102\u001a\u000203H\u0002J(\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00172\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010B\u001a\u00020\u0014H\u0002J \u0010C\u001a\u00020\u00142\u0006\u0010D\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#2\u0006\u0010E\u001a\u00020FH\u0002J.\u0010G\u001a\b\u0012\u0004\u0012\u00020#0\u00172\u0006\u0010 \u001a\u00020!2\u000e\u00106\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u00172\u0006\u0010E\u001a\u00020FH\u0002J6\u0010H\u001a\b\u0012\u0004\u0012\u00020&0\u00172\u0006\u00109\u001a\u00020:2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020!2\u000e\u00104\u001a\n\u0012\u0004\u0012\u000205\u0018\u00010\u0017H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/yandex/div/core/view2/spannable/SpannedTextBuilder;", "", "typefaceResolver", "Lcom/yandex/div/core/view2/DivTypefaceResolver;", "imageLoader", "Lcom/yandex/div/core/images/DivImageLoader;", "(Lcom/yandex/div/core/view2/DivTypefaceResolver;Lcom/yandex/div/core/images/DivImageLoader;)V", "debugFontMetrics", "", "tempPaint", "Landroid/graphics/Paint;", "addActionSpan", "", "bindingContext", "Lcom/yandex/div/core/view2/BindingContext;", "textView", "Landroid/widget/TextView;", "spannedText", "Landroid/text/Spannable;", "start", "", "end", "actions", "", "Lcom/yandex/div2/DivAction;", "addDecorationSpan", OutlinedTextFieldKt.BorderId, "Lcom/yandex/div2/DivTextRangeBorder;", J2.g, "Lcom/yandex/div2/DivTextRangeBackground;", "addImageSpan", "Lcom/yandex/div/core/view2/spannable/ImageSpan;", "textData", "Lcom/yandex/div/core/view2/spannable/TextData;", "image", "Lcom/yandex/div2/DivText$Image;", "addSpan", "span", "Lcom/yandex/div/core/view2/spannable/SpanData;", "buildEllipsis", "Landroid/text/Spanned;", "divText", "Lcom/yandex/div2/DivText;", "ellipsis", "Lcom/yandex/div2/DivText$Ellipsis;", "textConsumer", "Lkotlin/Function1;", "Lcom/yandex/div/core/view2/spannable/TextConsumer;", "buildPlainText", "buildText", "text", "", "ranges", "Lcom/yandex/div2/DivText$Range;", "images", "createShadowData", "Lcom/yandex/div/core/view2/spannable/ShadowData;", "context", "Landroid/content/Context;", "shadow", "Lcom/yandex/div2/DivShadow;", "textColor", "createSpanData", SessionDescription.ATTR_RANGE, "createTextData", "getActionsForPosition", b9.h.L, "imagePosition", "textLength", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "preprocessImages", "preprocessSpans", "Companion", "ImageDownloadCallbackImpl", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@DivScope
public final class SpannedTextBuilder {
    private static final Companion Companion = new Companion(null);
    private static final String IMAGE_PLACEHOLDER = "#";
    private static final String WORD_JOINER = "\u2060";
    private static final String ZWSP = "\u200b";
    private final boolean debugFontMetrics;
    private final DivImageLoader imageLoader;
    private final Paint tempPaint;
    private final DivTypefaceResolver typefaceResolver;

    /* JADX INFO: compiled from: SpannedTextBuilder.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[DivText.Image.IndexingDirection.values().length];
            try {
                iArr[DivText.Image.IndexingDirection.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DivText.Image.IndexingDirection.REVERSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[DivLineStyle.values().length];
            try {
                iArr2[DivLineStyle.SINGLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[DivLineStyle.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[DivText.Image.Accessibility.Type.values().length];
            try {
                iArr3[DivText.Image.Accessibility.Type.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr3[DivText.Image.Accessibility.Type.BUTTON.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr3[DivText.Image.Accessibility.Type.IMAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr3[DivText.Image.Accessibility.Type.TEXT.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[DivText.Image.Accessibility.Type.AUTO.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    @Inject
    public SpannedTextBuilder(DivTypefaceResolver typefaceResolver, DivImageLoader imageLoader) {
        Intrinsics.checkNotNullParameter(typefaceResolver, "typefaceResolver");
        Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
        this.typefaceResolver = typefaceResolver;
        this.imageLoader = imageLoader;
        this.tempPaint = new Paint();
    }

    public final Spanned buildPlainText(BindingContext bindingContext, TextView textView, DivText divText) {
        Intrinsics.checkNotNullParameter(bindingContext, "bindingContext");
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(divText, "divText");
        return buildText(bindingContext, textView, divText, divText.text.evaluate(bindingContext.getExpressionResolver()), null, null, null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Spanned buildText$default(SpannedTextBuilder spannedTextBuilder, BindingContext bindingContext, TextView textView, DivText divText, Function1 function1, int i, Object obj) {
        if ((i & 8) != 0) {
            function1 = null;
        }
        return spannedTextBuilder.buildText(bindingContext, textView, divText, function1);
    }

    public final Spanned buildText(BindingContext bindingContext, TextView textView, DivText divText, Function1<? super Spanned, Unit> textConsumer) {
        Intrinsics.checkNotNullParameter(bindingContext, "bindingContext");
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(divText, "divText");
        return buildText(bindingContext, textView, divText, divText.text.evaluate(bindingContext.getExpressionResolver()), divText.ranges, divText.images, divText.actions, textConsumer);
    }

    public final Spanned buildText(BindingContext bindingContext, TextView textView, DivText divText, List<DivText.Range> ranges, List<DivText.Image> images, List<DivAction> actions, Function1<? super Spanned, Unit> textConsumer) {
        Intrinsics.checkNotNullParameter(bindingContext, "bindingContext");
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(divText, "divText");
        return buildText(bindingContext, textView, divText, divText.text.evaluate(bindingContext.getExpressionResolver()), ranges, images, actions, textConsumer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Spanned buildEllipsis$default(SpannedTextBuilder spannedTextBuilder, BindingContext bindingContext, TextView textView, DivText divText, DivText.Ellipsis ellipsis, Function1 function1, int i, Object obj) {
        if ((i & 16) != 0) {
            function1 = null;
        }
        return spannedTextBuilder.buildEllipsis(bindingContext, textView, divText, ellipsis, function1);
    }

    public final Spanned buildEllipsis(BindingContext bindingContext, TextView textView, DivText divText, DivText.Ellipsis ellipsis, Function1<? super Spanned, Unit> textConsumer) {
        Intrinsics.checkNotNullParameter(bindingContext, "bindingContext");
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(divText, "divText");
        Intrinsics.checkNotNullParameter(ellipsis, "ellipsis");
        return buildText(bindingContext, textView, divText, ellipsis.text.evaluate(bindingContext.getExpressionResolver()), ellipsis.ranges, ellipsis.images, ellipsis.actions, textConsumer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:27:0x0092  */
    public final Spanned buildText(BindingContext bindingContext, TextView textView, DivText divText, String text, List<DivText.Range> ranges, List<DivText.Image> images, List<DivAction> actions, Function1<? super Spanned, Unit> textConsumer) {
        boolean z;
        int i;
        int iCoerceAtMost;
        int i2;
        Context context = textView.getContext();
        Div2View divView = bindingContext.getDivView();
        ExpressionResolver expressionResolver = bindingContext.getExpressionResolver();
        String str = text;
        if (str.length() == 0) {
            str = ZWSP;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        Intrinsics.checkNotNullExpressionValue(context, "context");
        TextData textDataCreateTextData = createTextData(context, bindingContext, divText, text);
        int textLength = textDataCreateTextData.getTextLength();
        List<SpanData> listPreprocessSpans = preprocessSpans(context, bindingContext, textDataCreateTextData, ranges);
        List<DivText.Image> listPreprocessImages = preprocessImages(textDataCreateTextData, images, expressionResolver);
        if (this.debugFontMetrics) {
            spannableStringBuilder.setSpan(new LineMetricsSpan(), 0, spannableStringBuilder.length(), 33);
        }
        if (ranges != null) {
            List<DivText.Range> list = ranges;
            if ((list instanceof Collection) && list.isEmpty()) {
                z = false;
            } else {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        DivText.Range range = (DivText.Range) it.next();
                        if (range.actions != null || range.background != null || range.border != null) {
                            z = true;
                        }
                    } else {
                        z = false;
                    }
                }
            }
        } else {
            z = false;
        }
        if (listPreprocessSpans.isEmpty() && listPreprocessImages.isEmpty() && !z) {
            if (textConsumer != null) {
                textConsumer.invoke(spannableStringBuilder);
            }
            return spannableStringBuilder;
        }
        DivLineHeightTextView divLineHeightTextView = textView instanceof DivLineHeightTextView ? (DivLineHeightTextView) textView : null;
        if (divLineHeightTextView != null) {
            divLineHeightTextView.clearImageSpans$div_release();
            DivTextRangesBackgroundHelper textRoundedBgHelper = divLineHeightTextView.getTextRoundedBgHelper();
            if (textRoundedBgHelper != null) {
                textRoundedBgHelper.invalidateSpansCache$div_release();
            }
        }
        Iterator<T> it2 = listPreprocessSpans.iterator();
        while (it2.hasNext()) {
            addSpan(textView, spannableStringBuilder, textDataCreateTextData, (SpanData) it2.next());
        }
        if (z && ranges != null) {
            for (DivText.Range range2 : ranges) {
                long jLongValue = range2.start.evaluate(expressionResolver).longValue();
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
                int iCoerceAtMost2 = RangesKt.coerceAtMost(i, textLength);
                Expression<Long> expression = range2.end;
                if (expression != null) {
                    long jLongValue2 = expression.evaluate(expressionResolver).longValue();
                    long j2 = jLongValue2 >> 31;
                    if (j2 == 0 || j2 == -1) {
                        i2 = (int) jLongValue2;
                    } else {
                        KAssert kAssert2 = KAssert.INSTANCE;
                        if (Assert.isEnabled()) {
                            Assert.fail("Unable convert '" + jLongValue2 + "' to Int");
                        }
                        i2 = jLongValue2 <= 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                    }
                    iCoerceAtMost = RangesKt.coerceAtMost(i2, textLength);
                } else {
                    iCoerceAtMost = textLength;
                }
                SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
                List<DivText.Image> list2 = listPreprocessImages;
                int i3 = iCoerceAtMost;
                addActionSpan(bindingContext, textView, spannableStringBuilder2, iCoerceAtMost2, i3, range2.actions);
                addDecorationSpan(bindingContext, textView, spannableStringBuilder2, iCoerceAtMost2, i3, range2.border, range2.background);
                listPreprocessImages = list2;
                textDataCreateTextData = textDataCreateTextData;
                textLength = textLength;
            }
        }
        List<DivText.Image> list3 = listPreprocessImages;
        TextData textData = textDataCreateTextData;
        if (actions != null) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            spannableStringBuilder.setSpan(new PerformActionSpan(bindingContext, actions), 0, spannableStringBuilder.length(), 33);
        }
        int size = list3.size() - 1;
        if (size >= 0) {
            while (true) {
                int i4 = size - 1;
                List<DivText.Image> list4 = list3;
                DivText.Image image = list4.get(size);
                int iImagePosition = imagePosition(textData.getTextLength(), image, expressionResolver);
                int iImagePosition2 = size > 0 ? imagePosition(textData.getTextLength(), list4.get(size - 1), expressionResolver) : Integer.MIN_VALUE;
                spannableStringBuilder.insert(iImagePosition, (CharSequence) IMAGE_PLACEHOLDER);
                ImageSpan imageSpanAddImageSpan = addImageSpan(bindingContext, textView, spannableStringBuilder, textData, image);
                boolean z2 = iImagePosition2 + 1 == iImagePosition;
                boolean z3 = iImagePosition > 0 && !CharsKt.isWhitespace(spannableStringBuilder.charAt(iImagePosition + (-1)));
                if (!z2 && z3) {
                    spannableStringBuilder.insert(iImagePosition, (CharSequence) WORD_JOINER);
                }
                LoadReference loadReferenceLoadImage = this.imageLoader.loadImage(image.url.evaluate(expressionResolver).toString(), new ImageDownloadCallbackImpl(bindingContext, image, imageSpanAddImageSpan, spannableStringBuilder, textConsumer));
                Intrinsics.checkNotNullExpressionValue(loadReferenceLoadImage, "imageLoader.loadImage(\n …xtConsumer)\n            )");
                Div2View div2View = divView;
                div2View.addLoadReference(loadReferenceLoadImage, textView);
                if (i4 < 0) {
                    break;
                }
                divView = div2View;
                size = i4;
                list3 = list4;
            }
        }
        if (textConsumer != null) {
            textConsumer.invoke(spannableStringBuilder);
        }
        return spannableStringBuilder;
    }

    private final List<SpanData> preprocessSpans(Context context, BindingContext bindingContext, TextData textData, List<DivText.Range> ranges) {
        int i;
        int i2;
        int iCoerceAtMost;
        int i3;
        List<DivText.Range> list;
        if (textData.getLineHeight() == null && ((list = ranges) == null || list.isEmpty())) {
            return CollectionsKt.emptyList();
        }
        ExpressionResolver expressionResolver = bindingContext.getExpressionResolver();
        int textLength = textData.getTextLength();
        int size = ranges != null ? ranges.size() : 0;
        TreeSet treeSetSortedSetOf = SetsKt.sortedSetOf(new Integer[0]);
        ArrayList arrayList = new ArrayList(size + 1);
        if (ranges != null) {
            for (DivText.Range range : ranges) {
                long jLongValue = range.start.evaluate(expressionResolver).longValue();
                long j = jLongValue >> 31;
                if (j == 0 || j == -1) {
                    i2 = (int) jLongValue;
                } else {
                    KAssert kAssert = KAssert.INSTANCE;
                    if (Assert.isEnabled()) {
                        Assert.fail("Unable convert '" + jLongValue + "' to Int");
                    }
                    i2 = jLongValue > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                int iCoerceAtMost2 = RangesKt.coerceAtMost(i2, textLength);
                Expression<Long> expression = range.end;
                if (expression != null) {
                    long jLongValue2 = expression.evaluate(expressionResolver).longValue();
                    long j2 = jLongValue2 >> 31;
                    if (j2 == 0 || j2 == -1) {
                        i3 = (int) jLongValue2;
                    } else {
                        KAssert kAssert2 = KAssert.INSTANCE;
                        if (Assert.isEnabled()) {
                            Assert.fail("Unable convert '" + jLongValue2 + "' to Int");
                        }
                        i3 = jLongValue2 <= 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                    }
                    iCoerceAtMost = RangesKt.coerceAtMost(i3, textLength);
                } else {
                    iCoerceAtMost = textLength;
                }
                if (iCoerceAtMost2 < iCoerceAtMost) {
                    SpanData spanDataCreateSpanData = createSpanData(context, bindingContext, textData, range, iCoerceAtMost2, iCoerceAtMost);
                    if (!spanDataCreateSpanData.isEmpty()) {
                        TreeSet treeSet = treeSetSortedSetOf;
                        treeSet.add(Integer.valueOf(iCoerceAtMost2));
                        treeSet.add(Integer.valueOf(iCoerceAtMost));
                        arrayList.add(spanDataCreateSpanData);
                    }
                }
            }
        }
        CollectionsKt.sort(arrayList);
        Integer lineHeight = textData.getLineHeight();
        if (lineHeight != null) {
            int iIntValue = lineHeight.intValue();
            TreeSet treeSet2 = treeSetSortedSetOf;
            i = 0;
            treeSet2.add(0);
            treeSet2.add(Integer.valueOf(textLength));
            arrayList.add(0, SpanData.INSTANCE.lineHeight$div_release(0, textLength, iIntValue));
        } else {
            i = 0;
        }
        if (arrayList.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        List list2 = CollectionsKt.toList(treeSetSortedSetOf);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int iIntValue2 = ((Number) CollectionsKt.first(list2)).intValue();
        int i4 = 1;
        if (list2.size() == 1) {
            ArrayList arrayList4 = arrayList2;
            SpanData spanDataEmpty$div_release = SpanData.INSTANCE.empty$div_release(iIntValue2, iIntValue2);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                spanDataEmpty$div_release = spanDataEmpty$div_release.mergeWith((SpanData) it.next(), iIntValue2, iIntValue2);
            }
            arrayList4.add(spanDataEmpty$div_release);
            return arrayList2;
        }
        int size2 = list2.size();
        while (i4 < size2) {
            int iIntValue3 = ((Number) list2.get(i4)).intValue();
            int size3 = arrayList.size();
            for (int i5 = i; i5 < size3; i5++) {
                Object obj = arrayList.get(i5);
                Intrinsics.checkNotNullExpressionValue(obj, "overlappingSpans[j]");
                SpanData spanData = (SpanData) obj;
                if (iIntValue3 < spanData.getStart()) {
                    break;
                }
                if (iIntValue3 > spanData.getStart() && iIntValue3 <= spanData.getEnd()) {
                    arrayList3.add(spanData);
                }
            }
            if (!arrayList3.isEmpty()) {
                ArrayList arrayList5 = arrayList2;
                SpanData spanDataEmpty$div_release2 = SpanData.INSTANCE.empty$div_release(iIntValue2, iIntValue3);
                Iterator it2 = arrayList3.iterator();
                while (it2.hasNext()) {
                    spanDataEmpty$div_release2 = spanDataEmpty$div_release2.mergeWith((SpanData) it2.next(), iIntValue2, iIntValue3);
                }
                arrayList5.add(spanDataEmpty$div_release2);
            }
            arrayList3.clear();
            i4++;
            iIntValue2 = iIntValue3;
        }
        return arrayList2;
    }

    private final List<DivText.Image> preprocessImages(final TextData textData, List<DivText.Image> images, final ExpressionResolver resolver) {
        if (images != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : images) {
                if (((DivText.Image) obj).start.evaluate(resolver).longValue() <= textData.getTextLength()) {
                    arrayList.add(obj);
                }
            }
            List<DivText.Image> listSortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.yandex.div.core.view2.spannable.SpannedTextBuilder$preprocessImages$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(this.this$0.imagePosition(textData.getTextLength(), (DivText.Image) t, resolver)), Integer.valueOf(this.this$0.imagePosition(textData.getTextLength(), (DivText.Image) t2, resolver)));
                }
            });
            if (listSortedWith != null) {
                return listSortedWith;
            }
        }
        return CollectionsKt.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int imagePosition(int textLength, DivText.Image image, ExpressionResolver resolver) {
        long jLongValue = image.start.evaluate(resolver).longValue();
        int i = WhenMappings.$EnumSwitchMapping$0[image.indexingDirection.evaluate(resolver).ordinal()];
        if (i == 1) {
            long j = jLongValue >> 31;
            if (j == 0 || j == -1) {
                return (int) jLongValue;
            }
            KAssert kAssert = KAssert.INSTANCE;
            if (Assert.isEnabled()) {
                Assert.fail("Unable convert '" + jLongValue + "' to Int");
            }
            if (jLongValue > 0) {
                return Integer.MAX_VALUE;
            }
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            long j2 = ((long) textLength) - jLongValue;
            long j3 = j2 >> 31;
            if (j3 == 0 || j3 == -1) {
                return (int) j2;
            }
            KAssert kAssert2 = KAssert.INSTANCE;
            if (Assert.isEnabled()) {
                Assert.fail("Unable convert '" + j2 + "' to Int");
            }
            if (j2 > 0) {
                return Integer.MAX_VALUE;
            }
        }
        return Integer.MIN_VALUE;
    }

    private final void addSpan(final TextView textView, Spannable spannedText, TextData textData, SpanData span) {
        int typefaceValue;
        int start = span.getStart();
        int end = span.getEnd();
        if (start > end) {
            return;
        }
        DivTextAlignmentVertical alignmentVertical = span.getAlignmentVertical();
        if (alignmentVertical == null) {
            alignmentVertical = DivTextAlignmentVertical.BASELINE;
        }
        int baselineOffset = span.getBaselineOffset();
        if (baselineOffset != 0) {
            Integer lineHeight = span.getLineHeight();
            spannedText.setSpan(new BaselineShiftSpan(baselineOffset, (lineHeight == null && (lineHeight = textData.getLineHeight()) == null) ? 0 : lineHeight.intValue()), start, end, 33);
        } else if (alignmentVertical != DivTextAlignmentVertical.BASELINE) {
            Integer fontSize = span.getFontSize();
            spannedText.setSpan(new VerticalAlignmentSpan(fontSize != null ? fontSize.intValue() : 0, BaseDivViewExtensionsKt.toTextVerticalAlignment(alignmentVertical), new Provider() { // from class: com.yandex.div.core.view2.spannable.SpannedTextBuilder$$ExternalSyntheticLambda0
                @Override // javax.inject.Provider
                public final Object get() {
                    return SpannedTextBuilder.addSpan$lambda$12(textView);
                }
            }), start, end, 33);
        }
        Integer fontSize2 = span.getFontSize();
        if (fontSize2 != null) {
            int iIntValue = fontSize2.intValue();
            Integer lineHeight2 = span.getLineHeight();
            spannedText.setSpan(new FontSizeSpan(iIntValue, (lineHeight2 == null && (lineHeight2 = textData.getLineHeight()) == null) ? 0 : lineHeight2.intValue()), start, end, 33);
        }
        String fontFeatureSettings = span.getFontFeatureSettings();
        if (fontFeatureSettings != null) {
            spannedText.setSpan(new FontFeatureSpan(fontFeatureSettings), start, end, 33);
        }
        Integer textColor = span.getTextColor();
        if (textColor != null) {
            spannedText.setSpan(new TextColorSpan(textColor.intValue()), start, end, 33);
        }
        Double letterSpacing = span.getLetterSpacing();
        if (letterSpacing != null) {
            spannedText.setSpan(new LetterSpacingSpan((float) letterSpacing.doubleValue()), start, end, 33);
        }
        DivLineStyle strike = span.getStrike();
        if (strike != null) {
            int i = WhenMappings.$EnumSwitchMapping$1[strike.ordinal()];
            if (i == 1) {
                spannedText.setSpan(new StrikethroughSpan(), start, end, 33);
            } else if (i == 2) {
                spannedText.setSpan(new NoStrikethroughSpan(), start, end, 33);
            }
        }
        DivLineStyle underline = span.getUnderline();
        if (underline != null) {
            int i2 = WhenMappings.$EnumSwitchMapping$1[underline.ordinal()];
            if (i2 == 1) {
                spannedText.setSpan(new UnderlineSpan(), start, end, 33);
            } else if (i2 == 2) {
                spannedText.setSpan(new NoUnderlineSpan(), start, end, 33);
            }
        }
        if (span.getFontFamily() != null || span.getFontWeight() != null || span.getFontWeightValue() != null) {
            if (span.getFontWeight() != null || span.getFontWeightValue() != null) {
                typefaceValue = BaseDivViewExtensionsKt.getTypefaceValue(span.getFontWeight(), span.getFontWeightValue());
            } else {
                typefaceValue = BaseDivViewExtensionsKt.getTypefaceValue(textData.getFontWeight(), textData.getFontWeightValue());
            }
            DivTypefaceResolver divTypefaceResolver = this.typefaceResolver;
            String fontFamily = span.getFontFamily();
            if (fontFamily == null) {
                fontFamily = textData.getFontFamily();
            }
            spannedText.setSpan(new TypefaceSpan(divTypefaceResolver.getTypeface$div_release(fontFamily, typefaceValue)), start, end, 33);
        }
        if (span.getLineHeight() != null || span.getTopOffset() != null) {
            int i3 = Intrinsics.areEqual(span.getLineHeight(), textData.getLineHeight()) ? 18 : 33;
            Integer topOffset = span.getTopOffset();
            int iIntValue2 = topOffset != null ? topOffset.intValue() : 0;
            Integer lineHeight3 = span.getLineHeight();
            int iIntValue3 = lineHeight3 != null ? lineHeight3.intValue() : 0;
            Integer topOffsetStart = span.getTopOffsetStart();
            int iIntValue4 = topOffsetStart != null ? topOffsetStart.intValue() : start;
            Integer topOffsetEnd = span.getTopOffsetEnd();
            spannedText.setSpan(new LineHeightWithTopOffsetSpan(iIntValue2, iIntValue3, iIntValue4, topOffsetEnd != null ? topOffsetEnd.intValue() : end), start, end, i3);
        }
        ShadowData textShadow = span.getTextShadow();
        if (textShadow != null) {
            spannedText.setSpan(new ShadowSpan(textShadow), start, end, 33);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Layout addSpan$lambda$12(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "$textView");
        return textView.getLayout();
    }

    private final void addActionSpan(BindingContext bindingContext, TextView textView, Spannable spannedText, int start, int end, List<DivAction> actions) {
        List<DivAction> list = actions;
        if (list == null || list.isEmpty()) {
            return;
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        spannedText.setSpan(new PerformActionSpan(bindingContext, actions), start, end, 33);
        ViewCompat.enableAccessibleClickableSpanSupport(textView);
    }

    private final void addDecorationSpan(BindingContext bindingContext, TextView textView, Spannable spannedText, int start, int end, DivTextRangeBorder border, DivTextRangeBackground background) {
        if (border == null && background == null) {
            return;
        }
        ExpressionResolver expressionResolver = bindingContext.getExpressionResolver();
        DivBackgroundSpan divBackgroundSpan = new DivBackgroundSpan(border, background);
        if (textView instanceof DivLineHeightTextView) {
            DivLineHeightTextView divLineHeightTextView = (DivLineHeightTextView) textView;
            if (DivLineHeightTextViewKt.hasBackgroundSpan(divLineHeightTextView, spannedText, divBackgroundSpan, start, end, expressionResolver)) {
                return;
            }
            spannedText.setSpan(divBackgroundSpan, start, end, 33);
            DivTextRangesBackgroundHelper textRoundedBgHelper = divLineHeightTextView.getTextRoundedBgHelper();
            if (textRoundedBgHelper != null) {
                textRoundedBgHelper.addBackgroundSpan$div_release(divBackgroundSpan);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0097  */
    private final ImageSpan addImageSpan(final BindingContext bindingContext, final TextView textView, Spannable spannedText, TextData textData, DivText.Image image) {
        ImageSpan.Accessibility accessibility;
        String qualifiedName;
        DisplayMetrics displayMetrics = textView.getResources().getDisplayMetrics();
        final Div2View divView = bindingContext.getDivView();
        ExpressionResolver expressionResolver = bindingContext.getExpressionResolver();
        int iImagePosition = imagePosition(textData.getTextLength(), image, expressionResolver);
        DivFixedSize divFixedSize = image.width;
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "displayMetrics");
        int px = BaseDivViewExtensionsKt.toPx(divFixedSize, displayMetrics, expressionResolver);
        int px2 = BaseDivViewExtensionsKt.toPx(image.height, displayMetrics, expressionResolver);
        Integer lineHeight = textData.getLineHeight();
        int iIntValue = lineHeight != null ? lineHeight.intValue() : 0;
        TextVerticalAlignment textVerticalAlignment = BaseDivViewExtensionsKt.toTextVerticalAlignment(image.alignmentVertical.evaluate(expressionResolver));
        DivText.Image.Accessibility accessibility2 = image.accessibility;
        if (accessibility2 != null) {
            int i = WhenMappings.$EnumSwitchMapping$2[accessibility2.type.ordinal()];
            if (i == 1) {
                qualifiedName = null;
            } else if (i == 2) {
                qualifiedName = Reflection.getOrCreateKotlinClass(Button.class).getQualifiedName();
            } else if (i == 3) {
                qualifiedName = Reflection.getOrCreateKotlinClass(ImageView.class).getQualifiedName();
            } else if (i == 4) {
                qualifiedName = Reflection.getOrCreateKotlinClass(TextView.class).getQualifiedName();
            } else if (i != 5) {
                qualifiedName = null;
            } else {
                qualifiedName = Reflection.getOrCreateKotlinClass(ImageView.class).getQualifiedName();
            }
            Expression<String> expression = accessibility2.description;
            String strEvaluate = expression != null ? expression.evaluate(expressionResolver) : null;
            final List<DivAction> actionsForPosition = getActionsForPosition(bindingContext, spannedText, iImagePosition);
            accessibility = new ImageSpan.Accessibility(qualifiedName, strEvaluate, actionsForPosition != null ? new ImageSpan.OnAccessibilityClickAction() { // from class: com.yandex.div.core.view2.spannable.SpannedTextBuilder$$ExternalSyntheticLambda1
                @Override // com.yandex.div.core.view2.spannable.ImageSpan.OnAccessibilityClickAction
                public final void perform() {
                    SpannedTextBuilder.addImageSpan$lambda$22$lambda$21$lambda$20(divView, bindingContext, textView, actionsForPosition);
                }
            } : null);
        } else {
            accessibility = null;
        }
        ImageSpan imageSpan = new ImageSpan(null, px, px2, iIntValue, textVerticalAlignment, accessibility);
        spannedText.setSpan(imageSpan, iImagePosition, iImagePosition + 1, 33);
        DivLineHeightTextView divLineHeightTextView = textView instanceof DivLineHeightTextView ? (DivLineHeightTextView) textView : null;
        if (divLineHeightTextView != null) {
            divLineHeightTextView.addImageSpan$div_release(imageSpan);
        }
        return imageSpan;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addImageSpan$lambda$22$lambda$21$lambda$20(Div2View divView, BindingContext bindingContext, TextView textView, List actions) {
        Intrinsics.checkNotNullParameter(divView, "$divView");
        Intrinsics.checkNotNullParameter(bindingContext, "$bindingContext");
        Intrinsics.checkNotNullParameter(textView, "$textView");
        Intrinsics.checkNotNullParameter(actions, "$actions");
        DivActionBinder actionBinder = divView.getDiv2Component().getActionBinder();
        Intrinsics.checkNotNullExpressionValue(actionBinder, "divView.div2Component.actionBinder");
        actionBinder.handleTapClick$div_release(bindingContext, textView, actions);
    }

    private final List<DivAction> getActionsForPosition(BindingContext bindingContext, Spannable spannedText, int position) {
        PerformActionSpan[] performActionSpanArr = (PerformActionSpan[]) spannedText.getSpans(position, position + 1, PerformActionSpan.class);
        if (performActionSpanArr.length > 1) {
            DivActionTypedUtilsKt.logWarning(bindingContext.getDivView(), new Throwable("Two or more clickable ranges intersect."));
        }
        PerformActionSpan performActionSpan = (PerformActionSpan) ArraysKt.firstOrNull(performActionSpanArr);
        if (performActionSpan != null) {
            return performActionSpan.getActions();
        }
        return null;
    }

    private final TextData createTextData(Context context, BindingContext bindingContext, DivText divText, String text) {
        int i;
        Integer numValueOf;
        Integer numValueOf2;
        int i2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        ExpressionResolver expressionResolver = bindingContext.getExpressionResolver();
        long jLongValue = divText.fontSize.evaluate(expressionResolver).longValue();
        long j = jLongValue >> 31;
        int i3 = Integer.MAX_VALUE;
        if (j == 0 || j == -1) {
            i = (int) jLongValue;
        } else {
            KAssert kAssert = KAssert.INSTANCE;
            if (Assert.isEnabled()) {
                Assert.fail("Unable convert '" + jLongValue + "' to Int");
            }
            i = jLongValue > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        int i4 = i;
        DivSizeUnit divSizeUnitEvaluate = divText.fontSizeUnit.evaluate(expressionResolver);
        Integer numValueOf3 = Integer.valueOf(i4);
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "displayMetrics");
        int iUnitToPx = BaseDivViewExtensionsKt.unitToPx(numValueOf3, displayMetrics, divSizeUnitEvaluate);
        DivFontWeight divFontWeightEvaluate = divText.fontWeight.evaluate(expressionResolver);
        Expression<Long> expression = divText.fontWeightValue;
        if (expression != null) {
            long jLongValue2 = expression.evaluate(expressionResolver).longValue();
            long j2 = jLongValue2 >> 31;
            if (j2 == 0 || j2 == -1) {
                i2 = (int) jLongValue2;
            } else {
                KAssert kAssert2 = KAssert.INSTANCE;
                if (Assert.isEnabled()) {
                    Assert.fail("Unable convert '" + jLongValue2 + "' to Int");
                }
                i2 = jLongValue2 > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            numValueOf = Integer.valueOf(i2);
        } else {
            numValueOf = null;
        }
        Expression<String> expression2 = divText.fontFamily;
        String strEvaluate = expression2 != null ? expression2.evaluate(expressionResolver) : null;
        Expression<Long> expression3 = divText.lineHeight;
        if (expression3 != null) {
            long jLongValue3 = expression3.evaluate(expressionResolver).longValue();
            long j3 = jLongValue3 >> 31;
            if (j3 == 0 || j3 == -1) {
                i3 = (int) jLongValue3;
            } else {
                KAssert kAssert3 = KAssert.INSTANCE;
                if (Assert.isEnabled()) {
                    Assert.fail("Unable convert '" + jLongValue3 + "' to Int");
                }
                if (jLongValue3 <= 0) {
                    i3 = Integer.MIN_VALUE;
                }
            }
            numValueOf2 = Integer.valueOf(BaseDivViewExtensionsKt.unitToPx(Integer.valueOf(i3), displayMetrics, divSizeUnitEvaluate));
        } else {
            numValueOf2 = null;
        }
        return new TextData(text, iUnitToPx, i4, divSizeUnitEvaluate, strEvaluate, divFontWeightEvaluate, numValueOf, numValueOf2, divText.textColor.evaluate(expressionResolver).intValue());
    }

    private final SpanData createSpanData(Context context, BindingContext bindingContext, TextData textData, DivText.Range range, int start, int end) {
        Integer numValueOf;
        Integer numValueOf2;
        Double dValueOf;
        Integer numValueOf3;
        int i;
        int i2;
        int i3;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        ExpressionResolver expressionResolver = bindingContext.getExpressionResolver();
        int fontSizeValue = textData.getFontSizeValue();
        Expression<Long> expression = range.fontSize;
        if (expression != null) {
            long jLongValue = expression.evaluate(expressionResolver).longValue();
            long j = jLongValue >> 31;
            if (j == 0 || j == -1) {
                i3 = (int) jLongValue;
            } else {
                KAssert kAssert = KAssert.INSTANCE;
                if (Assert.isEnabled()) {
                    Assert.fail("Unable convert '" + jLongValue + "' to Int");
                }
                i3 = jLongValue > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            numValueOf = Integer.valueOf(i3);
        } else {
            numValueOf = null;
        }
        DivSizeUnit divSizeUnitEvaluate = range.fontSizeUnit.evaluate(expressionResolver);
        Expression<DivTextAlignmentVertical> expression2 = range.alignmentVertical;
        DivTextAlignmentVertical divTextAlignmentVerticalEvaluate = expression2 != null ? expression2.evaluate(expressionResolver) : null;
        Double dEvaluate = range.baselineOffset.evaluate(expressionResolver);
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "displayMetrics");
        int iUnitToPx = BaseDivViewExtensionsKt.unitToPx(dEvaluate, displayMetrics, divSizeUnitEvaluate);
        Expression<String> expression3 = range.fontFamily;
        String strEvaluate = expression3 != null ? expression3.evaluate(expressionResolver) : null;
        Expression<String> expression4 = range.fontFeatureSettings;
        String strEvaluate2 = expression4 != null ? expression4.evaluate(expressionResolver) : null;
        Integer numValueOf4 = numValueOf != null ? Integer.valueOf(BaseDivViewExtensionsKt.unitToPx(numValueOf, displayMetrics, divSizeUnitEvaluate)) : null;
        Expression<DivFontWeight> expression5 = range.fontWeight;
        DivFontWeight divFontWeightEvaluate = expression5 != null ? expression5.evaluate(expressionResolver) : null;
        Expression<Long> expression6 = range.fontWeightValue;
        if (expression6 != null) {
            long jLongValue2 = expression6.evaluate(expressionResolver).longValue();
            long j2 = jLongValue2 >> 31;
            if (j2 == 0 || j2 == -1) {
                i2 = (int) jLongValue2;
            } else {
                KAssert kAssert2 = KAssert.INSTANCE;
                if (Assert.isEnabled()) {
                    Assert.fail("Unable convert '" + jLongValue2 + "' to Int");
                }
                i2 = jLongValue2 > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            numValueOf2 = Integer.valueOf(i2);
        } else {
            numValueOf2 = null;
        }
        Expression<Double> expression7 = range.letterSpacing;
        if (expression7 != null) {
            double dDoubleValue = expression7.evaluate(expressionResolver).doubleValue();
            if (numValueOf != null) {
                fontSizeValue = numValueOf.intValue();
            }
            dValueOf = Double.valueOf(dDoubleValue / ((double) fontSizeValue));
        } else {
            dValueOf = null;
        }
        Expression<Long> expression8 = range.lineHeight;
        Integer numValueOf5 = expression8 != null ? Integer.valueOf(BaseDivViewExtensionsKt.unitToPx(Long.valueOf(expression8.evaluate(expressionResolver).longValue()), displayMetrics, divSizeUnitEvaluate)) : null;
        Expression<DivLineStyle> expression9 = range.strike;
        DivLineStyle divLineStyleEvaluate = expression9 != null ? expression9.evaluate(expressionResolver) : null;
        Expression<Integer> expression10 = range.textColor;
        Integer numEvaluate = expression10 != null ? expression10.evaluate(expressionResolver) : null;
        ShadowData shadowDataCreateShadowData = createShadowData(context, bindingContext, range.textShadow, textData.getTextColor());
        Expression<Long> expression11 = range.topOffset;
        if (expression11 != null) {
            long jLongValue3 = expression11.evaluate(expressionResolver).longValue();
            long j3 = jLongValue3 >> 31;
            if (j3 == 0 || j3 == -1) {
                i = (int) jLongValue3;
            } else {
                KAssert kAssert3 = KAssert.INSTANCE;
                if (Assert.isEnabled()) {
                    Assert.fail("Unable convert '" + jLongValue3 + "' to Int");
                }
                i = jLongValue3 > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            numValueOf3 = Integer.valueOf(BaseDivViewExtensionsKt.unitToPx(Integer.valueOf(i), displayMetrics, divSizeUnitEvaluate));
        } else {
            numValueOf3 = null;
        }
        Integer numValueOf6 = range.topOffset != null ? Integer.valueOf(start) : null;
        Integer numValueOf7 = range.topOffset != null ? Integer.valueOf(end) : null;
        Expression<DivLineStyle> expression12 = range.underline;
        return new SpanData(start, end, divTextAlignmentVerticalEvaluate, iUnitToPx, strEvaluate, strEvaluate2, numValueOf4, divSizeUnitEvaluate, divFontWeightEvaluate, numValueOf2, dValueOf, numValueOf5, divLineStyleEvaluate, numEvaluate, shadowDataCreateShadowData, numValueOf3, numValueOf6, numValueOf7, expression12 != null ? expression12.evaluate(expressionResolver) : null);
    }

    private final ShadowData createShadowData(Context context, BindingContext bindingContext, DivShadow shadow, int textColor) {
        if (shadow == null) {
            return null;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        ExpressionResolver expressionResolver = bindingContext.getExpressionResolver();
        Long lEvaluate = shadow.blur.evaluate(expressionResolver);
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "displayMetrics");
        float fDpToPxF = BaseDivViewExtensionsKt.dpToPxF(lEvaluate, displayMetrics);
        float px = BaseDivViewExtensionsKt.toPx(shadow.offset.x, displayMetrics, expressionResolver);
        float px2 = BaseDivViewExtensionsKt.toPx(shadow.offset.y, displayMetrics, expressionResolver);
        Paint paint = this.tempPaint;
        paint.setColor(shadow.color.evaluate(expressionResolver).intValue());
        paint.setAlpha((int) (shadow.alpha.evaluate(expressionResolver).doubleValue() * ((double) (textColor >>> 24))));
        return new ShadowData(px, px2, fDpToPxF, paint.getColor());
    }

    /* JADX INFO: compiled from: SpannedTextBuilder.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u001c\b\u0002\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\u0004\u0018\u0001`\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\u0004\u0018\u0001`\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/yandex/div/core/view2/spannable/SpannedTextBuilder$ImageDownloadCallbackImpl;", "Lcom/yandex/div/core/DivIdLoggingImageDownloadCallback;", "bindingContext", "Lcom/yandex/div/core/view2/BindingContext;", "image", "Lcom/yandex/div2/DivText$Image;", "imageSpan", "Lcom/yandex/div/core/view2/spannable/ImageSpan;", "spannedText", "Landroid/text/Spanned;", "textConsumer", "Lkotlin/Function1;", "", "Lcom/yandex/div/core/view2/spannable/TextConsumer;", "(Lcom/yandex/div/core/view2/BindingContext;Lcom/yandex/div2/DivText$Image;Lcom/yandex/div/core/view2/spannable/ImageSpan;Landroid/text/Spanned;Lkotlin/jvm/functions/Function1;)V", "onSuccess", "cachedBitmap", "Lcom/yandex/div/core/images/CachedBitmap;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class ImageDownloadCallbackImpl extends DivIdLoggingImageDownloadCallback {
        private final BindingContext bindingContext;
        private final DivText.Image image;
        private final ImageSpan imageSpan;
        private final Spanned spannedText;
        private final Function1<Spanned, Unit> textConsumer;

        public /* synthetic */ ImageDownloadCallbackImpl(BindingContext bindingContext, DivText.Image image, ImageSpan imageSpan, Spanned spanned, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(bindingContext, image, imageSpan, spanned, (i & 16) != 0 ? null : function1);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ImageDownloadCallbackImpl(BindingContext bindingContext, DivText.Image image, ImageSpan imageSpan, Spanned spannedText, Function1<? super Spanned, Unit> function1) {
            super(bindingContext.getDivView());
            Intrinsics.checkNotNullParameter(bindingContext, "bindingContext");
            Intrinsics.checkNotNullParameter(image, "image");
            Intrinsics.checkNotNullParameter(imageSpan, "imageSpan");
            Intrinsics.checkNotNullParameter(spannedText, "spannedText");
            this.bindingContext = bindingContext;
            this.image = image;
            this.imageSpan = imageSpan;
            this.spannedText = spannedText;
            this.textConsumer = function1;
        }

        @Override // com.yandex.div.core.images.DivImageDownloadCallback
        public void onSuccess(CachedBitmap cachedBitmap) {
            Intrinsics.checkNotNullParameter(cachedBitmap, "cachedBitmap");
            super.onSuccess(cachedBitmap);
            Resources resources = this.bindingContext.getDivView().getResources();
            ExpressionResolver expressionResolver = this.bindingContext.getExpressionResolver();
            Expression<Integer> expression = this.image.tintColor;
            Integer numEvaluate = expression != null ? expression.evaluate(expressionResolver) : null;
            PorterDuff.Mode porterDuffMode = BaseDivViewExtensionsKt.toPorterDuffMode(this.image.tintMode.evaluate(expressionResolver));
            BitmapDrawable bitmapDrawable = new BitmapDrawable(resources, cachedBitmap.getBitmap());
            if (numEvaluate != null) {
                bitmapDrawable.setColorFilter(new PorterDuffColorFilter(numEvaluate.intValue(), porterDuffMode));
            }
            this.imageSpan.setImage(bitmapDrawable);
            Function1<Spanned, Unit> function1 = this.textConsumer;
            if (function1 != null) {
                function1.invoke(this.spannedText);
            }
        }
    }

    /* JADX INFO: compiled from: SpannedTextBuilder.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/yandex/div/core/view2/spannable/SpannedTextBuilder$Companion;", "", "()V", "IMAGE_PLACEHOLDER", "", "WORD_JOINER", "ZWSP", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
