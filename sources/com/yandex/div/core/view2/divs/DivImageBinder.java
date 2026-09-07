package com.yandex.div.core.view2.divs;

import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.yandex.div.core.DivIdLoggingImageDownloadCallback;
import com.yandex.div.core.dagger.DivScope;
import com.yandex.div.core.images.BitmapSource;
import com.yandex.div.core.images.CachedBitmap;
import com.yandex.div.core.images.DivImageLoader;
import com.yandex.div.core.images.LoadReference;
import com.yandex.div.core.util.DivDataExtensionsKt;
import com.yandex.div.core.util.DivUtilKt;
import com.yandex.div.core.util.ImageRepresentation;
import com.yandex.div.core.util.ImageUtilsKt;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.DivPlaceholderLoader;
import com.yandex.div.core.view2.DivViewBinder;
import com.yandex.div.core.view2.divs.widgets.DivImageView;
import com.yandex.div.core.view2.errors.ErrorCollector;
import com.yandex.div.core.view2.errors.ErrorCollectors;
import com.yandex.div.core.widget.LoadableImageView;
import com.yandex.div.internal.widget.AspectImageView;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div.json.expressions.ExpressionsKt;
import com.yandex.div2.DivAlignmentHorizontal;
import com.yandex.div2.DivAlignmentVertical;
import com.yandex.div2.DivBlendMode;
import com.yandex.div2.DivFadeTransition;
import com.yandex.div2.DivFilter;
import com.yandex.div2.DivImage;
import com.yandex.div2.DivImageScale;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivImageBinder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\u0002J\u001c\u0010\u0017\u001a\u00020\u000e*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J$\u0010\u001d\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00102\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 H\u0002J$\u0010\"\u001a\u00020\u0014*\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010#\u001a\u00020$H\u0002J\u0014\u0010%\u001a\u00020\u000e*\u00020\u00032\u0006\u0010&\u001a\u00020'H\u0002J&\u0010(\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010)\u001a\u0004\u0018\u00010*H\u0002J,\u0010+\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u00142\u0006\u0010#\u001a\u00020$H\u0002J#\u0010-\u001a\u00020\u000e*\u00020.2\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u000202H\u0002¢\u0006\u0002\u00103J&\u00104\u001a\u00020\u000e*\u00020\u00032\u0006\u00105\u001a\u00020\u00022\b\u00106\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J&\u00107\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u00105\u001a\u00020\u00022\b\u00106\u001a\u0004\u0018\u00010\u0002H\u0002J&\u00108\u001a\u00020\u000e*\u00020\u00032\u0006\u00105\u001a\u00020\u00022\b\u00106\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J.\u00109\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u00105\u001a\u00020\u00022\b\u00106\u001a\u0004\u0018\u00010\u00022\u0006\u0010#\u001a\u00020$H\u0002J&\u0010:\u001a\u00020\u000e*\u00020\u00032\u0006\u00105\u001a\u00020\u00022\b\u00106\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\f\u0010;\u001a\u00020\u000e*\u00020<H\u0002J\f\u0010=\u001a\u00020\u0014*\u00020\u0002H\u0002J$\u0010>\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u00105\u001a\u00020\u00022\u0006\u0010#\u001a\u00020$H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivImageBinder;", "Lcom/yandex/div/core/view2/DivViewBinder;", "Lcom/yandex/div2/DivImage;", "Lcom/yandex/div/core/view2/divs/widgets/DivImageView;", "baseBinder", "Lcom/yandex/div/core/view2/divs/DivBaseBinder;", "imageLoader", "Lcom/yandex/div/core/images/DivImageLoader;", "placeholderLoader", "Lcom/yandex/div/core/view2/DivPlaceholderLoader;", "errorCollectors", "Lcom/yandex/div/core/view2/errors/ErrorCollectors;", "(Lcom/yandex/div/core/view2/divs/DivBaseBinder;Lcom/yandex/div/core/images/DivImageLoader;Lcom/yandex/div/core/view2/DivPlaceholderLoader;Lcom/yandex/div/core/view2/errors/ErrorCollectors;)V", "bindView", "", "context", "Lcom/yandex/div/core/view2/BindingContext;", "view", "div", "isHighPriorityShow", "", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "applyContentAlignment", "Lcom/yandex/div/internal/widget/AspectImageView;", "horizontalAlignment", "Lcom/yandex/div2/DivAlignmentHorizontal;", "verticalAlignment", "Lcom/yandex/div2/DivAlignmentVertical;", "applyFiltersAndSetBitmap", "bindingContext", "filters", "", "Lcom/yandex/div2/DivFilter;", "applyImage", "errorCollector", "Lcom/yandex/div/core/view2/errors/ErrorCollector;", "applyImageScale", "scale", "Lcom/yandex/div2/DivImageScale;", "applyLoadingFade", "bitmapSource", "Lcom/yandex/div/core/images/BitmapSource;", "applyPlaceholders", "synchronous", "applyTint", "Lcom/yandex/div/core/widget/LoadableImageView;", "tintColor", "", "tintMode", "Lcom/yandex/div2/DivBlendMode;", "(Lcom/yandex/div/core/widget/LoadableImageView;Ljava/lang/Integer;Lcom/yandex/div2/DivBlendMode;)V", "bindContentAlignment", "newDiv", "oldDiv", "bindFilters", "bindImageScale", "bindPreviewAndImage", "bindTint", "clearTint", "Landroid/widget/ImageView;", "isVectorCompatible", "observePlaceholders", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@DivScope
public final class DivImageBinder implements DivViewBinder<DivImage, DivImageView> {
    private final DivBaseBinder baseBinder;
    private final ErrorCollectors errorCollectors;
    private final DivImageLoader imageLoader;
    private final DivPlaceholderLoader placeholderLoader;

    @Inject
    public DivImageBinder(DivBaseBinder baseBinder, DivImageLoader imageLoader, DivPlaceholderLoader placeholderLoader, ErrorCollectors errorCollectors) {
        Intrinsics.checkNotNullParameter(baseBinder, "baseBinder");
        Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
        Intrinsics.checkNotNullParameter(placeholderLoader, "placeholderLoader");
        Intrinsics.checkNotNullParameter(errorCollectors, "errorCollectors");
        this.baseBinder = baseBinder;
        this.imageLoader = imageLoader;
        this.placeholderLoader = placeholderLoader;
        this.errorCollectors = errorCollectors;
    }

    @Override // com.yandex.div.core.view2.DivViewBinder
    public void bindView(BindingContext context, DivImageView view, DivImage div) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(div, "div");
        DivImage div2 = view.getDiv();
        if (div == div2) {
            return;
        }
        DivImageView divImageView = view;
        this.baseBinder.bindView(context, divImageView, div, div2);
        BaseDivViewExtensionsKt.applyDivActions(divImageView, context, div.action, div.actions, div.longtapActions, div.doubletapActions, div.hoverStartActions, div.hoverEndActions, div.pressStartActions, div.pressEndActions, div.actionAnimation, div.getAccessibility());
        Div2View divView = context.getDivView();
        ExpressionResolver expressionResolver = context.getExpressionResolver();
        ErrorCollector orCreate = this.errorCollectors.getOrCreate(divView.getDataTag(), divView.getDivData());
        BaseDivViewExtensionsKt.bindAspectRatio(divImageView, div.aspect, div2 != null ? div2.aspect : null, expressionResolver);
        bindImageScale(view, div, div2, expressionResolver);
        bindContentAlignment(view, div, div2, expressionResolver);
        bindPreviewAndImage(view, context, div, div2, orCreate);
        bindTint(view, div, div2, expressionResolver);
        bindFilters(view, context, div, div2);
    }

    private final void bindImageScale(final DivImageView divImageView, DivImage divImage, DivImage divImage2, ExpressionResolver expressionResolver) {
        if (ExpressionsKt.equalsToConstant(divImage.scale, divImage2 != null ? divImage2.scale : null)) {
            return;
        }
        applyImageScale(divImageView, divImage.scale.evaluate(expressionResolver));
        if (ExpressionsKt.isConstant(divImage.scale)) {
            return;
        }
        divImageView.addSubscription(divImage.scale.observe(expressionResolver, new Function1<DivImageScale, Unit>() { // from class: com.yandex.div.core.view2.divs.DivImageBinder.bindImageScale.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DivImageScale divImageScale) {
                invoke2(divImageScale);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DivImageScale scale) {
                Intrinsics.checkNotNullParameter(scale, "scale");
                DivImageBinder.this.applyImageScale(divImageView, scale);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyImageScale(DivImageView divImageView, DivImageScale divImageScale) {
        divImageView.setImageScale(BaseDivViewExtensionsKt.toImageScale(divImageScale));
    }

    private final void bindContentAlignment(final DivImageView divImageView, final DivImage divImage, DivImage divImage2, final ExpressionResolver expressionResolver) {
        if (ExpressionsKt.equalsToConstant(divImage.contentAlignmentHorizontal, divImage2 != null ? divImage2.contentAlignmentHorizontal : null)) {
            if (ExpressionsKt.equalsToConstant(divImage.contentAlignmentVertical, divImage2 != null ? divImage2.contentAlignmentVertical : null)) {
                return;
            }
        }
        applyContentAlignment(divImageView, divImage.contentAlignmentHorizontal.evaluate(expressionResolver), divImage.contentAlignmentVertical.evaluate(expressionResolver));
        if (ExpressionsKt.isConstant(divImage.contentAlignmentHorizontal) && ExpressionsKt.isConstant(divImage.contentAlignmentVertical)) {
            return;
        }
        Function1<? super DivAlignmentHorizontal, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivImageBinder$bindContentAlignment$callback$1
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
                this.this$0.applyContentAlignment(divImageView, divImage.contentAlignmentHorizontal.evaluate(expressionResolver), divImage.contentAlignmentVertical.evaluate(expressionResolver));
            }
        };
        divImageView.addSubscription(divImage.contentAlignmentHorizontal.observe(expressionResolver, function1));
        divImageView.addSubscription(divImage.contentAlignmentVertical.observe(expressionResolver, function1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyContentAlignment(AspectImageView aspectImageView, DivAlignmentHorizontal divAlignmentHorizontal, DivAlignmentVertical divAlignmentVertical) {
        aspectImageView.setGravity(BaseDivViewExtensionsKt.evaluateGravity(divAlignmentHorizontal, divAlignmentVertical));
    }

    /* JADX WARN: Code duplicated, block: B:31:0x005e  */
    private final void bindFilters(final DivImageView divImageView, final BindingContext bindingContext, final DivImage divImage, DivImage divImage2) {
        boolean z;
        List<DivFilter> list;
        List<DivFilter> list2;
        List<DivFilter> list3 = divImage.filters;
        Boolean boolValueOf = null;
        boolean z2 = true;
        if (Intrinsics.areEqual(list3 != null ? Integer.valueOf(list3.size()) : null, (divImage2 == null || (list2 = divImage2.filters) == null) ? null : Integer.valueOf(list2.size()))) {
            List<DivFilter> list4 = divImage.filters;
            if (list4 != null) {
                int i = 0;
                z = true;
                for (Object obj : list4) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    DivFilter divFilter = (DivFilter) obj;
                    if (!z) {
                        z = false;
                    } else if (DivDataExtensionsKt.equalsToConstant(divFilter, (divImage2 == null || (list = divImage2.filters) == null) ? null : list.get(i))) {
                        z = true;
                    } else {
                        z = false;
                    }
                    i = i2;
                }
            } else {
                z = true;
            }
            if (z) {
                return;
            }
        }
        applyFiltersAndSetBitmap(divImageView, bindingContext, divImage.filters);
        List<DivFilter> list5 = divImage.filters;
        if (list5 != null) {
            List<DivFilter> list6 = list5;
            if (!(list6 instanceof Collection) || !list6.isEmpty()) {
                Iterator<T> it = list6.iterator();
                while (it.hasNext()) {
                    if (!DivDataExtensionsKt.isConstant((DivFilter) it.next())) {
                        z2 = false;
                        break;
                    }
                }
            }
            boolValueOf = Boolean.valueOf(z2);
        }
        if (Intrinsics.areEqual((Object) boolValueOf, (Object) false)) {
            Function1<? super Long, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivImageBinder$bindFilters$callback$1
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
                    this.this$0.applyFiltersAndSetBitmap(divImageView, bindingContext, divImage.filters);
                }
            };
            List<DivFilter> list7 = divImage.filters;
            if (list7 != null) {
                for (DivFilter divFilter2 : list7) {
                    if (divFilter2 instanceof DivFilter.Blur) {
                        divImageView.addSubscription(((DivFilter.Blur) divFilter2).getValue().radius.observe(bindingContext.getExpressionResolver(), function1));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyFiltersAndSetBitmap(final DivImageView divImageView, BindingContext bindingContext, List<? extends DivFilter> list) {
        Bitmap currentBitmapWithoutFilters$div_release = divImageView.getCurrentBitmapWithoutFilters();
        if (currentBitmapWithoutFilters$div_release == null) {
            divImageView.setImageBitmap(null);
        } else {
            BaseDivViewExtensionsKt.applyBitmapFilters(divImageView, bindingContext, currentBitmapWithoutFilters$div_release, list, new Function1<Bitmap, Unit>() { // from class: com.yandex.div.core.view2.divs.DivImageBinder.applyFiltersAndSetBitmap.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
                    invoke2(bitmap);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Bitmap it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    divImageView.setImageBitmap(it);
                }
            });
        }
    }

    private final void observePlaceholders(final DivImageView divImageView, final BindingContext bindingContext, final DivImage divImage, final ErrorCollector errorCollector) {
        final ExpressionResolver expressionResolver = bindingContext.getExpressionResolver();
        Function1<? super String, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivImageBinder$observePlaceholders$callback$1
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
                if (divImageView.isImageLoaded()) {
                    return;
                }
                DivImageBinder divImageBinder = this;
                DivImageView divImageView2 = divImageView;
                BindingContext bindingContext2 = bindingContext;
                DivImage divImage2 = divImage;
                divImageBinder.applyPlaceholders(divImageView2, bindingContext2, divImage2, divImageBinder.isHighPriorityShow(expressionResolver, divImageView2, divImage2), errorCollector);
            }
        };
        Expression<String> expression = divImage.preview;
        divImageView.addSubscription(expression != null ? expression.observe(expressionResolver, function1) : null);
        divImageView.addSubscription(divImage.placeholderColor.observe(expressionResolver, function1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyPlaceholders(final DivImageView divImageView, final BindingContext bindingContext, final DivImage divImage, boolean z, ErrorCollector errorCollector) {
        final ExpressionResolver expressionResolver = bindingContext.getExpressionResolver();
        DivPlaceholderLoader divPlaceholderLoader = this.placeholderLoader;
        DivImageView divImageView2 = divImageView;
        Expression<String> expression = divImage.preview;
        divPlaceholderLoader.applyPlaceholder(divImageView2, errorCollector, expression != null ? expression.evaluate(expressionResolver) : null, divImage.placeholderColor.evaluate(expressionResolver).intValue(), z, new Function1<Drawable, Unit>() { // from class: com.yandex.div.core.view2.divs.DivImageBinder.applyPlaceholders.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Drawable drawable) {
                invoke2(drawable);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Drawable drawable) {
                if (divImageView.isImageLoaded() || divImageView.isImagePreview()) {
                    return;
                }
                divImageView.setPlaceholder(drawable);
            }
        }, new Function1<ImageRepresentation, Unit>() { // from class: com.yandex.div.core.view2.divs.DivImageBinder.applyPlaceholders.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ImageRepresentation imageRepresentation) {
                invoke2(imageRepresentation);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ImageRepresentation imageRepresentation) {
                if (divImageView.isImageLoaded()) {
                    return;
                }
                if (imageRepresentation instanceof ImageRepresentation.Bitmap) {
                    divImageView.setCurrentBitmapWithoutFilters$div_release(((ImageRepresentation.Bitmap) imageRepresentation).m6129unboximpl());
                    this.applyFiltersAndSetBitmap(divImageView, bindingContext, divImage.filters);
                    divImageView.previewLoaded();
                    DivImageBinder divImageBinder = this;
                    DivImageView divImageView3 = divImageView;
                    Expression<Integer> expression2 = divImage.tintColor;
                    divImageBinder.applyTint(divImageView3, expression2 != null ? expression2.evaluate(expressionResolver) : null, divImage.tintMode.evaluate(expressionResolver));
                    return;
                }
                if (imageRepresentation instanceof ImageRepresentation.PictureDrawable) {
                    divImageView.previewLoaded();
                    divImageView.setImageDrawable(((ImageRepresentation.PictureDrawable) imageRepresentation).m6136unboximpl());
                }
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:19:0x002c  */
    private final void bindPreviewAndImage(final DivImageView divImageView, final BindingContext bindingContext, final DivImage divImage, DivImage divImage2, final ErrorCollector errorCollector) {
        boolean z;
        boolean zEqualsToConstant = ExpressionsKt.equalsToConstant(divImage.imageUrl, divImage2 != null ? divImage2.imageUrl : null);
        boolean z2 = false;
        if (ExpressionsKt.equalsToConstant(divImage.preview, divImage2 != null ? divImage2.preview : null)) {
            if (ExpressionsKt.equalsToConstant(divImage.placeholderColor, divImage2 != null ? divImage2.placeholderColor : null)) {
                z = false;
            } else {
                z = true;
            }
        } else {
            z = true;
        }
        boolean z3 = ExpressionsKt.isConstantOrNull(divImage.preview) && ExpressionsKt.isConstant(divImage.placeholderColor);
        if (!divImageView.isImageLoaded() && z) {
            z2 = true;
        }
        if (z2 && !z3) {
            observePlaceholders(divImageView, bindingContext, divImage, errorCollector);
        }
        if (!zEqualsToConstant && !ExpressionsKt.isConstantOrNull(divImage.imageUrl)) {
            divImageView.addSubscription(divImage.imageUrl.observe(bindingContext.getExpressionResolver(), new Function1<Uri, Unit>() { // from class: com.yandex.div.core.view2.divs.DivImageBinder.bindPreviewAndImage.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Uri uri) {
                    invoke2(uri);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Uri it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    DivImageBinder.this.applyImage(divImageView, bindingContext, divImage, errorCollector);
                }
            }));
        }
        if (applyImage(divImageView, bindingContext, divImage, errorCollector) || !z2) {
            return;
        }
        applyPlaceholders(divImageView, bindingContext, divImage, isHighPriorityShow(bindingContext.getExpressionResolver(), divImageView, divImage), errorCollector);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean applyImage(final DivImageView divImageView, final BindingContext bindingContext, final DivImage divImage, ErrorCollector errorCollector) {
        final ExpressionResolver expressionResolver = bindingContext.getExpressionResolver();
        final Uri uriEvaluate = divImage.imageUrl.evaluate(expressionResolver);
        if (Intrinsics.areEqual(uriEvaluate, divImageView.getImageUrl())) {
            return false;
        }
        boolean zIsHighPriorityShow = isHighPriorityShow(expressionResolver, divImageView, divImage);
        divImageView.resetImageLoaded();
        clearTint(divImageView);
        LoadReference loadReference$div_release = divImageView.getLoadReference();
        if (loadReference$div_release != null) {
            loadReference$div_release.cancel();
        }
        applyPlaceholders(divImageView, bindingContext, divImage, zIsHighPriorityShow, errorCollector);
        divImageView.setImageUrl$div_release(uriEvaluate);
        DivImageLoader divImageLoader = this.imageLoader;
        String string = uriEvaluate.toString();
        final Div2View divView = bindingContext.getDivView();
        LoadReference loadReferenceLoadImage = divImageLoader.loadImage(string, new DivIdLoggingImageDownloadCallback(divView) { // from class: com.yandex.div.core.view2.divs.DivImageBinder$applyImage$reference$1
            @Override // com.yandex.div.core.images.DivImageDownloadCallback
            public void onSuccess(CachedBitmap cachedBitmap) {
                Intrinsics.checkNotNullParameter(cachedBitmap, "cachedBitmap");
                super.onSuccess(cachedBitmap);
                divImageView.setCurrentBitmapWithoutFilters$div_release(cachedBitmap.getBitmap());
                this.applyFiltersAndSetBitmap(divImageView, bindingContext, divImage.filters);
                this.applyLoadingFade(divImageView, divImage, expressionResolver, cachedBitmap.getFrom());
                divImageView.imageLoaded();
                DivImageBinder divImageBinder = this;
                DivImageView divImageView2 = divImageView;
                Expression<Integer> expression = divImage.tintColor;
                divImageBinder.applyTint(divImageView2, expression != null ? expression.evaluate(expressionResolver) : null, divImage.tintMode.evaluate(expressionResolver));
                divImageView.invalidate();
            }

            @Override // com.yandex.div.core.images.DivImageDownloadCallback
            public void onSuccess(PictureDrawable pictureDrawable) {
                Intrinsics.checkNotNullParameter(pictureDrawable, "pictureDrawable");
                if (!this.isVectorCompatible(divImage)) {
                    onSuccess(ImageUtilsKt.toCachedBitmap$default(pictureDrawable, uriEvaluate, null, 2, null));
                    return;
                }
                super.onSuccess(pictureDrawable);
                divImageView.setImageDrawable(pictureDrawable);
                this.applyLoadingFade(divImageView, divImage, expressionResolver, null);
                divImageView.imageLoaded();
                divImageView.invalidate();
            }

            @Override // com.yandex.div.core.images.DivImageDownloadCallback
            public void onError() {
                super.onError();
                divImageView.setImageUrl$div_release(null);
            }
        });
        Intrinsics.checkNotNullExpressionValue(loadReferenceLoadImage, "private fun DivImageView…        return true\n    }");
        bindingContext.getDivView().addLoadReference(loadReferenceLoadImage, divImageView);
        divImageView.setLoadReference$div_release(loadReferenceLoadImage);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isVectorCompatible(DivImage divImage) {
        List<DivFilter> list;
        return divImage.tintColor == null && ((list = divImage.filters) == null || list.isEmpty());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyLoadingFade(DivImageView divImageView, DivImage divImage, ExpressionResolver expressionResolver, BitmapSource bitmapSource) {
        divImageView.animate().cancel();
        DivFadeTransition divFadeTransition = divImage.appearanceAnimation;
        float fDoubleValue = (float) divImage.getAlpha().evaluate(expressionResolver).doubleValue();
        if (divFadeTransition == null || bitmapSource == BitmapSource.MEMORY) {
            divImageView.setAlpha(fDoubleValue);
            return;
        }
        long jLongValue = divFadeTransition.getDuration().evaluate(expressionResolver).longValue();
        Interpolator androidInterpolator = DivUtilKt.getAndroidInterpolator(divFadeTransition.getInterpolator().evaluate(expressionResolver));
        divImageView.setAlpha((float) divFadeTransition.alpha.evaluate(expressionResolver).doubleValue());
        divImageView.animate().alpha(fDoubleValue).setDuration(jLongValue).setInterpolator(androidInterpolator).setStartDelay(divFadeTransition.getStartDelay().evaluate(expressionResolver).longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isHighPriorityShow(ExpressionResolver resolver, DivImageView view, DivImage div) {
        return !view.isImageLoaded() && div.highPriorityPreviewShow.evaluate(resolver).booleanValue();
    }

    private final void bindTint(final DivImageView divImageView, final DivImage divImage, DivImage divImage2, final ExpressionResolver expressionResolver) {
        if (ExpressionsKt.equalsToConstant(divImage.tintColor, divImage2 != null ? divImage2.tintColor : null)) {
            if (ExpressionsKt.equalsToConstant(divImage.tintMode, divImage2 != null ? divImage2.tintMode : null)) {
                return;
            }
        }
        DivImageView divImageView2 = divImageView;
        Expression<Integer> expression = divImage.tintColor;
        applyTint(divImageView2, expression != null ? expression.evaluate(expressionResolver) : null, divImage.tintMode.evaluate(expressionResolver));
        if (ExpressionsKt.isConstantOrNull(divImage.tintColor) && ExpressionsKt.isConstant(divImage.tintMode)) {
            return;
        }
        Function1<? super Integer, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivImageBinder$bindTint$callback$1
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
                DivImageBinder divImageBinder = this.this$0;
                DivImageView divImageView3 = divImageView;
                Expression<Integer> expression2 = divImage.tintColor;
                divImageBinder.applyTint(divImageView3, expression2 != null ? expression2.evaluate(expressionResolver) : null, divImage.tintMode.evaluate(expressionResolver));
            }
        };
        Expression<Integer> expression2 = divImage.tintColor;
        divImageView.addSubscription(expression2 != null ? expression2.observe(expressionResolver, function1) : null);
        divImageView.addSubscription(divImage.tintMode.observe(expressionResolver, function1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyTint(LoadableImageView loadableImageView, Integer num, DivBlendMode divBlendMode) {
        if ((loadableImageView.isImageLoaded() || loadableImageView.isImagePreview()) && num != null) {
            loadableImageView.setColorFilter(num.intValue(), BaseDivViewExtensionsKt.toPorterDuffMode(divBlendMode));
        } else {
            clearTint(loadableImageView);
        }
    }

    private final void clearTint(ImageView imageView) {
        imageView.setColorFilter((ColorFilter) null);
    }
}
