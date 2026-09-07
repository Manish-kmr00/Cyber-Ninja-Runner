package com.yandex.div.core.view2.divs;

import android.R;
import android.graphics.Bitmap;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.PictureDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.util.StateSet;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.yandex.div.core.DivIdLoggingImageDownloadCallback;
import com.yandex.div.core.dagger.DivScope;
import com.yandex.div.core.images.CachedBitmap;
import com.yandex.div.core.images.DivImageLoader;
import com.yandex.div.core.images.LoadReference;
import com.yandex.div.core.util.DivDataExtensionsKt;
import com.yandex.div.core.util.ExpressionSubscribersKt;
import com.yandex.div.core.util.ImageUtilsKt;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.internal.Assert;
import com.yandex.div.internal.KAssert;
import com.yandex.div.internal.core.ExpressionSubscriber;
import com.yandex.div.internal.drawable.LinearGradientDrawable;
import com.yandex.div.internal.drawable.NinePatchDrawable;
import com.yandex.div.internal.drawable.RadialGradientDrawable;
import com.yandex.div.internal.drawable.ScalingDrawable;
import com.yandex.div.internal.graphics.Colormap;
import com.yandex.div.internal.graphics.ColormapKt;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivAlignmentHorizontal;
import com.yandex.div2.DivAlignmentVertical;
import com.yandex.div2.DivBackground;
import com.yandex.div2.DivFilter;
import com.yandex.div2.DivImageBackground;
import com.yandex.div2.DivImageScale;
import com.yandex.div2.DivRadialGradientCenter;
import com.yandex.div2.DivRadialGradientRadius;
import com.yandex.div2.DivRadialGradientRelativeRadius;
import io.bidmachine.unified.UnifiedMediationParams;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivBackgroundBinder.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0011\u0018\u00002\u00020\u0001:\u0001BB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J<\u0010\u001a\u001a\u00020\u001b2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\r2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u001b0#H\u0012Jp\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\b2\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\r2\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\r2\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\r2\u0010\b\u0002\u0010+\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\r2\u0006\u0010 \u001a\u00020!2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016JJ\u0010,\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\b2\b\u0010-\u001a\u0004\u0018\u00010\u00062\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\r2\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\r2\u0006\u0010 \u001a\u00020!H\u0012Jh\u0010.\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\b2\b\u0010-\u001a\u0004\u0018\u00010\u00062\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\r2\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\r2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001d0\r2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\r2\u0006\u0010 \u001a\u00020!H\u0012J.\u0010/\u001a\u00020\u001b*\u00020\b2\u0006\u0010%\u001a\u00020&2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\rH\u0012J<\u00100\u001a\u00020\u001b*\u00020\b2\u0006\u0010%\u001a\u00020&2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\r2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u001d0\rH\u0012J\u0014\u00101\u001a\u000202*\u0002032\u0006\u0010\u001e\u001a\u00020\u001fH\u0012J$\u00104\u001a\u00020\u000e*\u00020\u001d2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u0010\u001e\u001a\u00020\u001fH\u0012J\u0014\u00104\u001a\u000209*\u00020:2\u0006\u0010\u001e\u001a\u00020\u001fH\u0012J\u001c\u00104\u001a\u00020;*\u00020<2\u0006\u00107\u001a\u0002082\u0006\u0010\u001e\u001a\u00020\u001fH\u0012J\u001c\u00104\u001a\u00020=*\u00020>2\u0006\u00107\u001a\u0002082\u0006\u0010\u001e\u001a\u00020\u001fH\u0012J0\u0010?\u001a\u0004\u0018\u00010\u0006*\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0012J\u0016\u0010@\u001a\u00020\u001b*\u00020\b2\b\u0010A\u001a\u0004\u0018\u00010\u0006H\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004¢\u0006\u0002\n\u0000R,\u0010\u0007\u001a\u0004\u0018\u00010\u0006*\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068R@RX\u0092\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR>\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r*\u00020\b2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8R@RX\u0092\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R>\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r*\u00020\b2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8R@RX\u0092\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015¨\u0006C"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivBackgroundBinder;", "", "imageLoader", "Lcom/yandex/div/core/images/DivImageLoader;", "(Lcom/yandex/div/core/images/DivImageLoader;)V", "value", "Landroid/graphics/drawable/Drawable;", "additionalLayer", "Landroid/view/View;", "getAdditionalLayer", "(Landroid/view/View;)Landroid/graphics/drawable/Drawable;", "setAdditionalLayer", "(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V", "", "Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState;", "defaultBackgroundList", "getDefaultBackgroundList$annotations", "(Landroid/view/View;)V", "getDefaultBackgroundList", "(Landroid/view/View;)Ljava/util/List;", "setDefaultBackgroundList", "(Landroid/view/View;Ljava/util/List;)V", "focusedBackgroundList", "getFocusedBackgroundList$annotations", "getFocusedBackgroundList", "setFocusedBackgroundList", "addBackgroundSubscriptions", "", "backgroundList", "Lcom/yandex/div2/DivBackground;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "subscriber", "Lcom/yandex/div/internal/core/ExpressionSubscriber;", "callback", "Lkotlin/Function1;", "bindBackground", "context", "Lcom/yandex/div/core/view2/BindingContext;", "view", "newDefaultBackgroundList", "oldDefaultBackgroundList", "newFocusedBackgroundList", "oldFocusedBackgroundList", "bindDefaultBackground", "newAdditionalLayer", "bindFocusBackground", "applyDefaultBackground", "applyFocusedBackground", "isVectorCompatible", "", "Lcom/yandex/div2/DivImageBackground;", "toBackgroundState", "divView", "Lcom/yandex/div/core/view2/Div2View;", "metrics", "Landroid/util/DisplayMetrics;", "Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState$Image$Filter;", "Lcom/yandex/div2/DivFilter;", "Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState$RadialGradient$Center;", "Lcom/yandex/div2/DivRadialGradientCenter;", "Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState$RadialGradient$Radius;", "Lcom/yandex/div2/DivRadialGradientRadius;", "toDrawable", "updateBackground", "drawable", "DivBackgroundState", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@DivScope
public class DivBackgroundBinder {
    private final DivImageLoader imageLoader;

    private static /* synthetic */ void getDefaultBackgroundList$annotations(View view) {
    }

    private static /* synthetic */ void getFocusedBackgroundList$annotations(View view) {
    }

    @Inject
    public DivBackgroundBinder(DivImageLoader imageLoader) {
        Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
        this.imageLoader = imageLoader;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void bindBackground$default(DivBackgroundBinder divBackgroundBinder, BindingContext bindingContext, View view, List list, List list2, List list3, List list4, ExpressionSubscriber expressionSubscriber, Drawable drawable, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindBackground");
        }
        divBackgroundBinder.bindBackground(bindingContext, view, list, (i & 8) != 0 ? null : list2, list3, (i & 32) != 0 ? null : list4, expressionSubscriber, (i & 128) != 0 ? null : drawable);
    }

    public void bindBackground(BindingContext context, View view, List<? extends DivBackground> newDefaultBackgroundList, List<? extends DivBackground> oldDefaultBackgroundList, List<? extends DivBackground> newFocusedBackgroundList, List<? extends DivBackground> oldFocusedBackgroundList, ExpressionSubscriber subscriber, Drawable additionalLayer) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        if (newFocusedBackgroundList == null) {
            bindDefaultBackground(context, view, additionalLayer, newDefaultBackgroundList, oldDefaultBackgroundList, subscriber);
        } else {
            bindFocusBackground(context, view, additionalLayer, newDefaultBackgroundList, oldDefaultBackgroundList, newFocusedBackgroundList, oldFocusedBackgroundList, subscriber);
        }
    }

    private void bindDefaultBackground(final BindingContext context, final View view, final Drawable newAdditionalLayer, final List<? extends DivBackground> newDefaultBackgroundList, List<? extends DivBackground> oldDefaultBackgroundList, ExpressionSubscriber subscriber) {
        List<? extends DivBackground> listEmptyList = newDefaultBackgroundList == null ? CollectionsKt.emptyList() : newDefaultBackgroundList;
        if (oldDefaultBackgroundList == null) {
            oldDefaultBackgroundList = CollectionsKt.emptyList();
        }
        Drawable additionalLayer = getAdditionalLayer(view);
        if (listEmptyList.size() == oldDefaultBackgroundList.size()) {
            Iterator<T> it = listEmptyList.iterator();
            int i = 0;
            while (true) {
                if (it.hasNext()) {
                    Object next = it.next();
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    if (!DivDataExtensionsKt.equalsToConstant((DivBackground) next, oldDefaultBackgroundList.get(i))) {
                        break;
                    } else {
                        i = i2;
                    }
                } else if (!Intrinsics.areEqual(newAdditionalLayer, additionalLayer)) {
                    break;
                } else {
                    return;
                }
            }
        }
        applyDefaultBackground(view, context, newAdditionalLayer, newDefaultBackgroundList);
        List<? extends DivBackground> list = listEmptyList;
        if ((list instanceof Collection) && list.isEmpty()) {
            return;
        }
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            if (!DivDataExtensionsKt.isConstant((DivBackground) it2.next())) {
                addBackgroundSubscriptions(newDefaultBackgroundList, context.getExpressionResolver(), subscriber, new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivBackgroundBinder$bindDefaultBackground$callback$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
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
                        this.this$0.applyDefaultBackground(view, context, newAdditionalLayer, newDefaultBackgroundList);
                    }
                });
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyDefaultBackground(View view, BindingContext bindingContext, Drawable drawable, List<? extends DivBackground> list) {
        ArrayList arrayListEmptyList;
        DisplayMetrics metrics = view.getResources().getDisplayMetrics();
        ExpressionResolver expressionResolver = bindingContext.getExpressionResolver();
        if (list != null) {
            List<? extends DivBackground> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (DivBackground divBackground : list2) {
                Div2View divView = bindingContext.getDivView();
                Intrinsics.checkNotNullExpressionValue(metrics, "metrics");
                arrayList.add(toBackgroundState(divBackground, divView, metrics, expressionResolver));
            }
            arrayListEmptyList = arrayList;
        } else {
            arrayListEmptyList = CollectionsKt.emptyList();
        }
        List<DivBackgroundState> defaultBackgroundList = getDefaultBackgroundList(view);
        Drawable additionalLayer = getAdditionalLayer(view);
        if (Intrinsics.areEqual(defaultBackgroundList, arrayListEmptyList) && Intrinsics.areEqual(additionalLayer, drawable)) {
            return;
        }
        updateBackground(view, toDrawable(arrayListEmptyList, bindingContext, view, drawable));
        setDefaultBackgroundList(view, arrayListEmptyList);
        setFocusedBackgroundList(view, null);
        setAdditionalLayer(view, drawable);
    }

    /* JADX WARN: Code duplicated, block: B:57:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:66:0x00e1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:? A[LOOP:2: B:55:0x00cf->B:67:?, LOOP_END, SYNTHETIC] */
    private void bindFocusBackground(final BindingContext context, final View view, final Drawable newAdditionalLayer, final List<? extends DivBackground> newDefaultBackgroundList, List<? extends DivBackground> oldDefaultBackgroundList, final List<? extends DivBackground> newFocusedBackgroundList, List<? extends DivBackground> oldFocusedBackgroundList, ExpressionSubscriber subscriber) {
        List<? extends DivBackground> list;
        Iterator<T> it;
        List<? extends DivBackground> listEmptyList = newDefaultBackgroundList == null ? CollectionsKt.emptyList() : newDefaultBackgroundList;
        if (oldDefaultBackgroundList == null) {
            oldDefaultBackgroundList = CollectionsKt.emptyList();
        }
        if (oldFocusedBackgroundList == null) {
            oldFocusedBackgroundList = CollectionsKt.emptyList();
        }
        Drawable additionalLayer = getAdditionalLayer(view);
        if (listEmptyList.size() == oldDefaultBackgroundList.size()) {
            Iterator<T> it2 = listEmptyList.iterator();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (it2.hasNext()) {
                    Object next = it2.next();
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    if (!DivDataExtensionsKt.equalsToConstant((DivBackground) next, oldDefaultBackgroundList.get(i2))) {
                        break;
                    } else {
                        i2 = i3;
                    }
                } else {
                    if (newFocusedBackgroundList.size() != oldFocusedBackgroundList.size()) {
                        break;
                    }
                    Iterator<T> it3 = newFocusedBackgroundList.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            Object next2 = it3.next();
                            int i4 = i + 1;
                            if (i < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            if (!DivDataExtensionsKt.equalsToConstant((DivBackground) next2, oldFocusedBackgroundList.get(i))) {
                                break;
                            } else {
                                i = i4;
                            }
                        } else if (!Intrinsics.areEqual(newAdditionalLayer, additionalLayer)) {
                            break;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
        applyFocusedBackground(view, context, newAdditionalLayer, newDefaultBackgroundList, newFocusedBackgroundList);
        List<? extends DivBackground> list2 = listEmptyList;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            list = newFocusedBackgroundList;
            if (list instanceof Collection) {
            }
            it = list.iterator();
            while (it.hasNext()) {
                if (!DivDataExtensionsKt.isConstant((DivBackground) it.next())) {
                }
            }
            return;
        }
        Iterator<T> it4 = list2.iterator();
        while (it4.hasNext()) {
            if (!DivDataExtensionsKt.isConstant((DivBackground) it4.next())) {
            }
        }
        list = newFocusedBackgroundList;
        if ((list instanceof Collection) || !list.isEmpty()) {
            it = list.iterator();
            while (it.hasNext()) {
                if (!DivDataExtensionsKt.isConstant((DivBackground) it.next())) {
                }
            }
            return;
        }
        return;
        Function1<Object, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivBackgroundBinder$bindFocusBackground$callback$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                this.this$0.applyFocusedBackground(view, context, newAdditionalLayer, newDefaultBackgroundList, newFocusedBackgroundList);
            }
        };
        ExpressionResolver expressionResolver = context.getExpressionResolver();
        addBackgroundSubscriptions(newDefaultBackgroundList, expressionResolver, subscriber, function1);
        addBackgroundSubscriptions(newFocusedBackgroundList, expressionResolver, subscriber, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyFocusedBackground(View view, BindingContext bindingContext, Drawable drawable, List<? extends DivBackground> list, List<? extends DivBackground> list2) {
        ArrayList arrayListEmptyList;
        DisplayMetrics metrics = view.getResources().getDisplayMetrics();
        Div2View divView = bindingContext.getDivView();
        ExpressionResolver expressionResolver = bindingContext.getExpressionResolver();
        if (list == null) {
            arrayListEmptyList = CollectionsKt.emptyList();
        } else {
            List<? extends DivBackground> list3 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            for (DivBackground divBackground : list3) {
                Intrinsics.checkNotNullExpressionValue(metrics, "metrics");
                arrayList.add(toBackgroundState(divBackground, divView, metrics, expressionResolver));
            }
            arrayListEmptyList = arrayList;
        }
        List<? extends DivBackground> list4 = list2;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
        for (DivBackground divBackground2 : list4) {
            Intrinsics.checkNotNullExpressionValue(metrics, "metrics");
            arrayList2.add(toBackgroundState(divBackground2, divView, metrics, expressionResolver));
        }
        ArrayList arrayList3 = arrayList2;
        List<DivBackgroundState> defaultBackgroundList = getDefaultBackgroundList(view);
        List<DivBackgroundState> focusedBackgroundList = getFocusedBackgroundList(view);
        Drawable additionalLayer = getAdditionalLayer(view);
        if (Intrinsics.areEqual(defaultBackgroundList, arrayListEmptyList) && Intrinsics.areEqual(focusedBackgroundList, arrayList3) && Intrinsics.areEqual(additionalLayer, drawable)) {
            return;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_focused}, toDrawable(arrayList3, bindingContext, view, drawable));
        if (list != null || drawable != null) {
            stateListDrawable.addState(StateSet.WILD_CARD, toDrawable(arrayListEmptyList, bindingContext, view, drawable));
        }
        updateBackground(view, stateListDrawable);
        setDefaultBackgroundList(view, arrayListEmptyList);
        setFocusedBackgroundList(view, arrayList3);
        setAdditionalLayer(view, drawable);
    }

    private void updateBackground(View view, Drawable drawable) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        if (drawable != null) {
            arrayList.add(drawable);
        }
        Drawable background = view.getBackground();
        LayerDrawable layerDrawable = background instanceof LayerDrawable ? (LayerDrawable) background : null;
        if ((layerDrawable != null ? layerDrawable.findDrawableByLayerId(com.yandex.div.R.drawable.native_animation_background) : null) != null) {
            Drawable drawable2 = ContextCompat.getDrawable(view.getContext(), com.yandex.div.R.drawable.native_animation_background);
            if (drawable2 != null) {
                arrayList.add(drawable2);
            }
            z = true;
        } else {
            z = false;
        }
        view.setBackground(new LayerDrawable((Drawable[]) arrayList.toArray(new Drawable[0])));
        if (z) {
            Drawable background2 = view.getBackground();
            Intrinsics.checkNotNull(background2, "null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
            Drawable background3 = view.getBackground();
            Intrinsics.checkNotNull(background3, "null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
            ((LayerDrawable) background2).setId(((LayerDrawable) background3).getNumberOfLayers() - 1, com.yandex.div.R.drawable.native_animation_background);
        }
    }

    private void addBackgroundSubscriptions(List<? extends DivBackground> backgroundList, ExpressionResolver resolver, ExpressionSubscriber subscriber, Function1<Object, Unit> callback) {
        if (backgroundList != null) {
            Iterator<T> it = backgroundList.iterator();
            while (it.hasNext()) {
                ExpressionSubscribersKt.observeBackground(subscriber, (DivBackground) it.next(), resolver, callback);
            }
        }
    }

    private Drawable toDrawable(List<? extends DivBackgroundState> list, BindingContext bindingContext, View view, Drawable drawable) {
        if (drawable != null) {
            drawable.mutate();
        }
        if (list == null) {
            return drawable != null ? new LayerDrawable(new Drawable[]{drawable}) : null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Drawable drawableMutate = ((DivBackgroundState) it.next()).toDrawable(bindingContext, view, this.imageLoader).mutate();
            if (drawableMutate != null) {
                arrayList.add(drawableMutate);
            }
        }
        List mutableList = CollectionsKt.toMutableList((Collection) arrayList);
        if (drawable != null) {
            mutableList.add(drawable);
        }
        List list2 = mutableList;
        if (list2.isEmpty()) {
            return null;
        }
        return new LayerDrawable((Drawable[]) list2.toArray(new Drawable[0]));
    }

    private DivBackgroundState toBackgroundState(DivBackground divBackground, Div2View div2View, DisplayMetrics displayMetrics, ExpressionResolver expressionResolver) {
        int i;
        int i2;
        int i3;
        int i4;
        ArrayList arrayList;
        int i5;
        if (divBackground instanceof DivBackground.LinearGradient) {
            DivBackground.LinearGradient linearGradient = (DivBackground.LinearGradient) divBackground;
            long jLongValue = linearGradient.getValue().angle.evaluate(expressionResolver).longValue();
            long j = jLongValue >> 31;
            if (j == 0 || j == -1) {
                i5 = (int) jLongValue;
            } else {
                KAssert kAssert = KAssert.INSTANCE;
                if (Assert.isEnabled()) {
                    Assert.fail("Unable convert '" + jLongValue + "' to Int");
                }
                i5 = jLongValue > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            return new DivBackgroundState.LinearGradient(i5, ColormapKt.checkIsNotEmpty(DivDataExtensionsKt.toColormap(linearGradient.getValue(), expressionResolver), div2View));
        }
        if (divBackground instanceof DivBackground.RadialGradient) {
            DivBackground.RadialGradient radialGradient = (DivBackground.RadialGradient) divBackground;
            return new DivBackgroundState.RadialGradient(toBackgroundState(radialGradient.getValue().centerX, displayMetrics, expressionResolver), toBackgroundState(radialGradient.getValue().centerY, displayMetrics, expressionResolver), radialGradient.getValue().colors.evaluate(expressionResolver), toBackgroundState(radialGradient.getValue().radius, displayMetrics, expressionResolver));
        }
        if (divBackground instanceof DivBackground.Image) {
            DivBackground.Image image = (DivBackground.Image) divBackground;
            double dDoubleValue = image.getValue().alpha.evaluate(expressionResolver).doubleValue();
            DivAlignmentHorizontal divAlignmentHorizontalEvaluate = image.getValue().contentAlignmentHorizontal.evaluate(expressionResolver);
            DivAlignmentVertical divAlignmentVerticalEvaluate = image.getValue().contentAlignmentVertical.evaluate(expressionResolver);
            Uri uriEvaluate = image.getValue().imageUrl.evaluate(expressionResolver);
            boolean zBooleanValue = image.getValue().preloadRequired.evaluate(expressionResolver).booleanValue();
            DivImageScale divImageScaleEvaluate = image.getValue().scale.evaluate(expressionResolver);
            List<DivFilter> list = image.getValue().filters;
            if (list != null) {
                List<DivFilter> list2 = list;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList2.add(toBackgroundState((DivFilter) it.next(), expressionResolver));
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            return new DivBackgroundState.Image(dDoubleValue, divAlignmentHorizontalEvaluate, divAlignmentVerticalEvaluate, uriEvaluate, zBooleanValue, divImageScaleEvaluate, arrayList, isVectorCompatible(image.getValue(), expressionResolver));
        }
        if (divBackground instanceof DivBackground.Solid) {
            return new DivBackgroundState.Solid(((DivBackground.Solid) divBackground).getValue().color.evaluate(expressionResolver).intValue());
        }
        if (!(divBackground instanceof DivBackground.NinePatch)) {
            throw new NoWhenBranchMatchedException();
        }
        DivBackground.NinePatch ninePatch = (DivBackground.NinePatch) divBackground;
        Uri uriEvaluate2 = ninePatch.getValue().imageUrl.evaluate(expressionResolver);
        long jLongValue2 = ninePatch.getValue().insets.left.evaluate(expressionResolver).longValue();
        long j2 = jLongValue2 >> 31;
        if (j2 == 0 || j2 == -1) {
            i = (int) jLongValue2;
        } else {
            KAssert kAssert2 = KAssert.INSTANCE;
            if (Assert.isEnabled()) {
                Assert.fail("Unable convert '" + jLongValue2 + "' to Int");
            }
            i = jLongValue2 > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        long jLongValue3 = ninePatch.getValue().insets.top.evaluate(expressionResolver).longValue();
        long j3 = jLongValue3 >> 31;
        if (j3 == 0 || j3 == -1) {
            i2 = (int) jLongValue3;
        } else {
            KAssert kAssert3 = KAssert.INSTANCE;
            if (Assert.isEnabled()) {
                Assert.fail("Unable convert '" + jLongValue3 + "' to Int");
            }
            i2 = jLongValue3 > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        long jLongValue4 = ninePatch.getValue().insets.right.evaluate(expressionResolver).longValue();
        long j4 = jLongValue4 >> 31;
        if (j4 == 0 || j4 == -1) {
            i3 = (int) jLongValue4;
        } else {
            KAssert kAssert4 = KAssert.INSTANCE;
            if (Assert.isEnabled()) {
                Assert.fail("Unable convert '" + jLongValue4 + "' to Int");
            }
            i3 = jLongValue4 > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        long jLongValue5 = ninePatch.getValue().insets.bottom.evaluate(expressionResolver).longValue();
        long j5 = jLongValue5 >> 31;
        if (j5 == 0 || j5 == -1) {
            i4 = (int) jLongValue5;
        } else {
            KAssert kAssert5 = KAssert.INSTANCE;
            if (Assert.isEnabled()) {
                Assert.fail("Unable convert '" + jLongValue5 + "' to Int");
            }
            i4 = jLongValue5 > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return new DivBackgroundState.NinePatch(uriEvaluate2, new Rect(i, i2, i3, i4));
    }

    private boolean isVectorCompatible(DivImageBackground divImageBackground, ExpressionResolver expressionResolver) {
        List<DivFilter> list;
        return divImageBackground.alpha.evaluate(expressionResolver).doubleValue() == 1.0d && ((list = divImageBackground.filters) == null || list.isEmpty());
    }

    private DivBackgroundState.RadialGradient.Center toBackgroundState(DivRadialGradientCenter divRadialGradientCenter, DisplayMetrics displayMetrics, ExpressionResolver expressionResolver) {
        if (divRadialGradientCenter instanceof DivRadialGradientCenter.Fixed) {
            return new DivBackgroundState.RadialGradient.Center.Fixed(BaseDivViewExtensionsKt.toPxF(((DivRadialGradientCenter.Fixed) divRadialGradientCenter).getValue(), displayMetrics, expressionResolver));
        }
        if (divRadialGradientCenter instanceof DivRadialGradientCenter.Relative) {
            return new DivBackgroundState.RadialGradient.Center.Relative((float) ((DivRadialGradientCenter.Relative) divRadialGradientCenter).getValue().value.evaluate(expressionResolver).doubleValue());
        }
        throw new NoWhenBranchMatchedException();
    }

    private DivBackgroundState.RadialGradient.Radius toBackgroundState(DivRadialGradientRadius divRadialGradientRadius, DisplayMetrics displayMetrics, ExpressionResolver expressionResolver) {
        if (divRadialGradientRadius instanceof DivRadialGradientRadius.FixedSize) {
            return new DivBackgroundState.RadialGradient.Radius.Fixed(BaseDivViewExtensionsKt.toPxF(((DivRadialGradientRadius.FixedSize) divRadialGradientRadius).getValue(), displayMetrics, expressionResolver));
        }
        if (divRadialGradientRadius instanceof DivRadialGradientRadius.Relative) {
            return new DivBackgroundState.RadialGradient.Radius.Relative(((DivRadialGradientRadius.Relative) divRadialGradientRadius).getValue().value.evaluate(expressionResolver));
        }
        throw new NoWhenBranchMatchedException();
    }

    private DivBackgroundState.Image.Filter toBackgroundState(DivFilter divFilter, ExpressionResolver expressionResolver) {
        int i;
        if (divFilter instanceof DivFilter.Blur) {
            DivFilter.Blur blur = (DivFilter.Blur) divFilter;
            long jLongValue = blur.getValue().radius.evaluate(expressionResolver).longValue();
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
            return new DivBackgroundState.Image.Filter.Blur(i, blur);
        }
        if (divFilter instanceof DivFilter.RtlMirror) {
            return new DivBackgroundState.Image.Filter.RtlMirror((DivFilter.RtlMirror) divFilter);
        }
        throw new NoWhenBranchMatchedException();
    }

    private List<DivBackgroundState> getDefaultBackgroundList(View view) {
        Object tag = view.getTag(com.yandex.div.R.id.div_default_background_list_tag);
        if (tag instanceof List) {
            return (List) tag;
        }
        return null;
    }

    private void setDefaultBackgroundList(View view, List<? extends DivBackgroundState> list) {
        view.setTag(com.yandex.div.R.id.div_default_background_list_tag, list);
    }

    private List<DivBackgroundState> getFocusedBackgroundList(View view) {
        Object tag = view.getTag(com.yandex.div.R.id.div_focused_background_list_tag);
        if (tag instanceof List) {
            return (List) tag;
        }
        return null;
    }

    private void setFocusedBackgroundList(View view, List<? extends DivBackgroundState> list) {
        view.setTag(com.yandex.div.R.id.div_focused_background_list_tag, list);
    }

    private Drawable getAdditionalLayer(View view) {
        Object tag = view.getTag(com.yandex.div.R.id.div_additional_background_layer_tag);
        if (tag instanceof Drawable) {
            return (Drawable) tag;
        }
        return null;
    }

    private void setAdditionalLayer(View view, Drawable drawable) {
        view.setTag(com.yandex.div.R.id.div_additional_background_layer_tag, drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: DivBackgroundBinder.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0005\u000b\f\r\u000e\u000fB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n\u0082\u0001\u0005\u0010\u0011\u0012\u0013\u0014¨\u0006\u0015"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState;", "", "()V", "toDrawable", "Landroid/graphics/drawable/Drawable;", "context", "Lcom/yandex/div/core/view2/BindingContext;", TypedValues.AttributesType.S_TARGET, "Landroid/view/View;", "imageLoader", "Lcom/yandex/div/core/images/DivImageLoader;", "Image", "LinearGradient", "NinePatch", "RadialGradient", "Solid", "Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState$Image;", "Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState$LinearGradient;", "Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState$NinePatch;", "Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState$RadialGradient;", "Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState$Solid;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    static abstract class DivBackgroundState {
        public /* synthetic */ DivBackgroundState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private DivBackgroundState() {
        }

        /* JADX INFO: compiled from: DivBackgroundBinder.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState$LinearGradient;", "Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState;", "angle", "", "colormap", "Lcom/yandex/div/internal/graphics/Colormap;", "(ILcom/yandex/div/internal/graphics/Colormap;)V", "getAngle", "()I", "getColormap", "()Lcom/yandex/div/internal/graphics/Colormap;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final /* data */ class LinearGradient extends DivBackgroundState {
            private final int angle;
            private final Colormap colormap;

            public static /* synthetic */ LinearGradient copy$default(LinearGradient linearGradient, int i, Colormap colormap, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = linearGradient.angle;
                }
                if ((i2 & 2) != 0) {
                    colormap = linearGradient.colormap;
                }
                return linearGradient.copy(i, colormap);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getAngle() {
                return this.angle;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Colormap getColormap() {
                return this.colormap;
            }

            public final LinearGradient copy(int angle, Colormap colormap) {
                Intrinsics.checkNotNullParameter(colormap, "colormap");
                return new LinearGradient(angle, colormap);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LinearGradient)) {
                    return false;
                }
                LinearGradient linearGradient = (LinearGradient) other;
                return this.angle == linearGradient.angle && Intrinsics.areEqual(this.colormap, linearGradient.colormap);
            }

            public int hashCode() {
                return (Integer.hashCode(this.angle) * 31) + this.colormap.hashCode();
            }

            public String toString() {
                return "LinearGradient(angle=" + this.angle + ", colormap=" + this.colormap + ')';
            }

            public final int getAngle() {
                return this.angle;
            }

            public final Colormap getColormap() {
                return this.colormap;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public LinearGradient(int i, Colormap colormap) {
                super(null);
                Intrinsics.checkNotNullParameter(colormap, "colormap");
                this.angle = i;
                this.colormap = colormap;
            }
        }

        /* JADX INFO: compiled from: DivBackgroundBinder.kt */
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\tHÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006 "}, d2 = {"Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState$RadialGradient;", "Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState;", "centerX", "Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState$RadialGradient$Center;", "centerY", "colors", "", "", "radius", "Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState$RadialGradient$Radius;", "(Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState$RadialGradient$Center;Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState$RadialGradient$Center;Ljava/util/List;Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState$RadialGradient$Radius;)V", "getCenterX", "()Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState$RadialGradient$Center;", "getCenterY", "getColors", "()Ljava/util/List;", "getRadius", "()Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState$RadialGradient$Radius;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "", "Center", "Radius", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final /* data */ class RadialGradient extends DivBackgroundState {
            private final Center centerX;
            private final Center centerY;
            private final List<Integer> colors;
            private final Radius radius;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ RadialGradient copy$default(RadialGradient radialGradient, Center center, Center center2, List list, Radius radius, int i, Object obj) {
                if ((i & 1) != 0) {
                    center = radialGradient.centerX;
                }
                if ((i & 2) != 0) {
                    center2 = radialGradient.centerY;
                }
                if ((i & 4) != 0) {
                    list = radialGradient.colors;
                }
                if ((i & 8) != 0) {
                    radius = radialGradient.radius;
                }
                return radialGradient.copy(center, center2, list, radius);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Center getCenterX() {
                return this.centerX;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Center getCenterY() {
                return this.centerY;
            }

            public final List<Integer> component3() {
                return this.colors;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final Radius getRadius() {
                return this.radius;
            }

            public final RadialGradient copy(Center centerX, Center centerY, List<Integer> colors, Radius radius) {
                Intrinsics.checkNotNullParameter(centerX, "centerX");
                Intrinsics.checkNotNullParameter(centerY, "centerY");
                Intrinsics.checkNotNullParameter(colors, "colors");
                Intrinsics.checkNotNullParameter(radius, "radius");
                return new RadialGradient(centerX, centerY, colors, radius);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RadialGradient)) {
                    return false;
                }
                RadialGradient radialGradient = (RadialGradient) other;
                return Intrinsics.areEqual(this.centerX, radialGradient.centerX) && Intrinsics.areEqual(this.centerY, radialGradient.centerY) && Intrinsics.areEqual(this.colors, radialGradient.colors) && Intrinsics.areEqual(this.radius, radialGradient.radius);
            }

            public int hashCode() {
                return (((((this.centerX.hashCode() * 31) + this.centerY.hashCode()) * 31) + this.colors.hashCode()) * 31) + this.radius.hashCode();
            }

            public String toString() {
                return "RadialGradient(centerX=" + this.centerX + ", centerY=" + this.centerY + ", colors=" + this.colors + ", radius=" + this.radius + ')';
            }

            public final Center getCenterX() {
                return this.centerX;
            }

            public final Center getCenterY() {
                return this.centerY;
            }

            public final List<Integer> getColors() {
                return this.colors;
            }

            public final Radius getRadius() {
                return this.radius;
            }

            /* JADX INFO: compiled from: DivBackgroundBinder.kt */
            @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u0082\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState$RadialGradient$Center;", "", "()V", "toRadialGradientDrawableCenter", "Lcom/yandex/div/internal/drawable/RadialGradientDrawable$Center;", "Fixed", "Relative", "Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState$RadialGradient$Center$Fixed;", "Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState$RadialGradient$Center$Relative;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
            public static abstract class Center {
                public /* synthetic */ Center(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                /* JADX INFO: compiled from: DivBackgroundBinder.kt */
                @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState$RadialGradient$Center$Relative;", "Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState$RadialGradient$Center;", "value", "", "(F)V", "getValue", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
                public static final /* data */ class Relative extends Center {
                    private final float value;

                    public static /* synthetic */ Relative copy$default(Relative relative, float f, int i, Object obj) {
                        if ((i & 1) != 0) {
                            f = relative.value;
                        }
                        return relative.copy(f);
                    }

                    /* JADX INFO: renamed from: component1, reason: from getter */
                    public final float getValue() {
                        return this.value;
                    }

                    public final Relative copy(float value) {
                        return new Relative(value);
                    }

                    public boolean equals(Object other) {
                        if (this == other) {
                            return true;
                        }
                        return (other instanceof Relative) && Float.compare(this.value, ((Relative) other).value) == 0;
                    }

                    public int hashCode() {
                        return Float.hashCode(this.value);
                    }

                    public String toString() {
                        return "Relative(value=" + this.value + ')';
                    }

                    public Relative(float f) {
                        super(null);
                        this.value = f;
                    }

                    public final float getValue() {
                        return this.value;
                    }
                }

                private Center() {
                }

                /* JADX INFO: compiled from: DivBackgroundBinder.kt */
                @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState$RadialGradient$Center$Fixed;", "Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState$RadialGradient$Center;", "valuePx", "", "(F)V", "getValuePx", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
                public static final /* data */ class Fixed extends Center {
                    private final float valuePx;

                    public static /* synthetic */ Fixed copy$default(Fixed fixed, float f, int i, Object obj) {
                        if ((i & 1) != 0) {
                            f = fixed.valuePx;
                        }
                        return fixed.copy(f);
                    }

                    /* JADX INFO: renamed from: component1, reason: from getter */
                    public final float getValuePx() {
                        return this.valuePx;
                    }

                    public final Fixed copy(float valuePx) {
                        return new Fixed(valuePx);
                    }

                    public boolean equals(Object other) {
                        if (this == other) {
                            return true;
                        }
                        return (other instanceof Fixed) && Float.compare(this.valuePx, ((Fixed) other).valuePx) == 0;
                    }

                    public int hashCode() {
                        return Float.hashCode(this.valuePx);
                    }

                    public String toString() {
                        return "Fixed(valuePx=" + this.valuePx + ')';
                    }

                    public Fixed(float f) {
                        super(null);
                        this.valuePx = f;
                    }

                    public final float getValuePx() {
                        return this.valuePx;
                    }
                }

                public final RadialGradientDrawable.Center toRadialGradientDrawableCenter() {
                    if (this instanceof Fixed) {
                        return new RadialGradientDrawable.Center.Fixed(((Fixed) this).getValuePx());
                    }
                    if (this instanceof Relative) {
                        return new RadialGradientDrawable.Center.Relative(((Relative) this).getValue());
                    }
                    throw new NoWhenBranchMatchedException();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RadialGradient(Center centerX, Center centerY, List<Integer> colors, Radius radius) {
                super(null);
                Intrinsics.checkNotNullParameter(centerX, "centerX");
                Intrinsics.checkNotNullParameter(centerY, "centerY");
                Intrinsics.checkNotNullParameter(colors, "colors");
                Intrinsics.checkNotNullParameter(radius, "radius");
                this.centerX = centerX;
                this.centerY = centerY;
                this.colors = colors;
                this.radius = radius;
            }

            /* JADX INFO: compiled from: DivBackgroundBinder.kt */
            @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u0082\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState$RadialGradient$Radius;", "", "()V", "toRadialGradientDrawableRadius", "Lcom/yandex/div/internal/drawable/RadialGradientDrawable$Radius;", "Fixed", "Relative", "Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState$RadialGradient$Radius$Fixed;", "Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState$RadialGradient$Radius$Relative;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
            public static abstract class Radius {

                /* JADX INFO: compiled from: DivBackgroundBinder.kt */
                @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[DivRadialGradientRelativeRadius.Value.values().length];
                        try {
                            iArr[DivRadialGradientRelativeRadius.Value.FARTHEST_CORNER.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[DivRadialGradientRelativeRadius.Value.NEAREST_CORNER.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        try {
                            iArr[DivRadialGradientRelativeRadius.Value.FARTHEST_SIDE.ordinal()] = 3;
                        } catch (NoSuchFieldError unused3) {
                        }
                        try {
                            iArr[DivRadialGradientRelativeRadius.Value.NEAREST_SIDE.ordinal()] = 4;
                        } catch (NoSuchFieldError unused4) {
                        }
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                public /* synthetic */ Radius(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                /* JADX INFO: compiled from: DivBackgroundBinder.kt */
                @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState$RadialGradient$Radius$Relative;", "Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState$RadialGradient$Radius;", "value", "Lcom/yandex/div2/DivRadialGradientRelativeRadius$Value;", "(Lcom/yandex/div2/DivRadialGradientRelativeRadius$Value;)V", "getValue", "()Lcom/yandex/div2/DivRadialGradientRelativeRadius$Value;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
                public static final /* data */ class Relative extends Radius {
                    private final DivRadialGradientRelativeRadius.Value value;

                    public static /* synthetic */ Relative copy$default(Relative relative, DivRadialGradientRelativeRadius.Value value, int i, Object obj) {
                        if ((i & 1) != 0) {
                            value = relative.value;
                        }
                        return relative.copy(value);
                    }

                    /* JADX INFO: renamed from: component1, reason: from getter */
                    public final DivRadialGradientRelativeRadius.Value getValue() {
                        return this.value;
                    }

                    public final Relative copy(DivRadialGradientRelativeRadius.Value value) {
                        Intrinsics.checkNotNullParameter(value, "value");
                        return new Relative(value);
                    }

                    public boolean equals(Object other) {
                        if (this == other) {
                            return true;
                        }
                        return (other instanceof Relative) && this.value == ((Relative) other).value;
                    }

                    public int hashCode() {
                        return this.value.hashCode();
                    }

                    public String toString() {
                        return "Relative(value=" + this.value + ')';
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public Relative(DivRadialGradientRelativeRadius.Value value) {
                        super(null);
                        Intrinsics.checkNotNullParameter(value, "value");
                        this.value = value;
                    }

                    public final DivRadialGradientRelativeRadius.Value getValue() {
                        return this.value;
                    }
                }

                private Radius() {
                }

                /* JADX INFO: compiled from: DivBackgroundBinder.kt */
                @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState$RadialGradient$Radius$Fixed;", "Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState$RadialGradient$Radius;", "valuePx", "", "(F)V", "getValuePx", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
                public static final /* data */ class Fixed extends Radius {
                    private final float valuePx;

                    public static /* synthetic */ Fixed copy$default(Fixed fixed, float f, int i, Object obj) {
                        if ((i & 1) != 0) {
                            f = fixed.valuePx;
                        }
                        return fixed.copy(f);
                    }

                    /* JADX INFO: renamed from: component1, reason: from getter */
                    public final float getValuePx() {
                        return this.valuePx;
                    }

                    public final Fixed copy(float valuePx) {
                        return new Fixed(valuePx);
                    }

                    public boolean equals(Object other) {
                        if (this == other) {
                            return true;
                        }
                        return (other instanceof Fixed) && Float.compare(this.valuePx, ((Fixed) other).valuePx) == 0;
                    }

                    public int hashCode() {
                        return Float.hashCode(this.valuePx);
                    }

                    public String toString() {
                        return "Fixed(valuePx=" + this.valuePx + ')';
                    }

                    public Fixed(float f) {
                        super(null);
                        this.valuePx = f;
                    }

                    public final float getValuePx() {
                        return this.valuePx;
                    }
                }

                public final RadialGradientDrawable.Radius toRadialGradientDrawableRadius() {
                    RadialGradientDrawable.Radius.Relative.Type type;
                    if (this instanceof Fixed) {
                        return new RadialGradientDrawable.Radius.Fixed(((Fixed) this).getValuePx());
                    }
                    if (!(this instanceof Relative)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    int i = WhenMappings.$EnumSwitchMapping$0[((Relative) this).getValue().ordinal()];
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
            }
        }

        /* JADX INFO: compiled from: DivBackgroundBinder.kt */
        @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u00019BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000b¢\u0006\u0002\u0010\u0012J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\t\u0010$\u001a\u00020\tHÆ\u0003J\t\u0010%\u001a\u00020\u000bHÆ\u0003J\t\u0010&\u001a\u00020\rHÆ\u0003J\u0011\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fHÆ\u0003J\t\u0010(\u001a\u00020\u000bHÆ\u0003Ja\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000bHÆ\u0001J\u0013\u0010*\u001a\u00020\u000b2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\u001e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204J\t\u00105\u001a\u000206HÖ\u0001J\t\u00107\u001a\u000208HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0011\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u001dR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006:"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState$Image;", "Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState;", "alpha", "", "contentAlignmentHorizontal", "Lcom/yandex/div2/DivAlignmentHorizontal;", "contentAlignmentVertical", "Lcom/yandex/div2/DivAlignmentVertical;", UnifiedMediationParams.KEY_IMAGE_URL, "Landroid/net/Uri;", "preloadRequired", "", "scale", "Lcom/yandex/div2/DivImageScale;", "filters", "", "Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState$Image$Filter;", "isVectorCompatible", "(DLcom/yandex/div2/DivAlignmentHorizontal;Lcom/yandex/div2/DivAlignmentVertical;Landroid/net/Uri;ZLcom/yandex/div2/DivImageScale;Ljava/util/List;Z)V", "getAlpha", "()D", "getContentAlignmentHorizontal", "()Lcom/yandex/div2/DivAlignmentHorizontal;", "getContentAlignmentVertical", "()Lcom/yandex/div2/DivAlignmentVertical;", "getFilters", "()Ljava/util/List;", "getImageUrl", "()Landroid/net/Uri;", "()Z", "getPreloadRequired", "getScale", "()Lcom/yandex/div2/DivImageScale;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "getDivImageBackground", "Landroid/graphics/drawable/Drawable;", "context", "Lcom/yandex/div/core/view2/BindingContext;", TypedValues.AttributesType.S_TARGET, "Landroid/view/View;", "imageLoader", "Lcom/yandex/div/core/images/DivImageLoader;", "hashCode", "", "toString", "", "Filter", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final /* data */ class Image extends DivBackgroundState {
            private final double alpha;
            private final DivAlignmentHorizontal contentAlignmentHorizontal;
            private final DivAlignmentVertical contentAlignmentVertical;
            private final List<Filter> filters;
            private final Uri imageUrl;
            private final boolean isVectorCompatible;
            private final boolean preloadRequired;
            private final DivImageScale scale;

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final double getAlpha() {
                return this.alpha;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final DivAlignmentHorizontal getContentAlignmentHorizontal() {
                return this.contentAlignmentHorizontal;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final DivAlignmentVertical getContentAlignmentVertical() {
                return this.contentAlignmentVertical;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final Uri getImageUrl() {
                return this.imageUrl;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final boolean getPreloadRequired() {
                return this.preloadRequired;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final DivImageScale getScale() {
                return this.scale;
            }

            public final List<Filter> component7() {
                return this.filters;
            }

            /* JADX INFO: renamed from: component8, reason: from getter */
            public final boolean getIsVectorCompatible() {
                return this.isVectorCompatible;
            }

            public final Image copy(double alpha, DivAlignmentHorizontal contentAlignmentHorizontal, DivAlignmentVertical contentAlignmentVertical, Uri imageUrl, boolean preloadRequired, DivImageScale scale, List<? extends Filter> filters, boolean isVectorCompatible) {
                Intrinsics.checkNotNullParameter(contentAlignmentHorizontal, "contentAlignmentHorizontal");
                Intrinsics.checkNotNullParameter(contentAlignmentVertical, "contentAlignmentVertical");
                Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
                Intrinsics.checkNotNullParameter(scale, "scale");
                return new Image(alpha, contentAlignmentHorizontal, contentAlignmentVertical, imageUrl, preloadRequired, scale, filters, isVectorCompatible);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Image)) {
                    return false;
                }
                Image image = (Image) other;
                return Double.compare(this.alpha, image.alpha) == 0 && this.contentAlignmentHorizontal == image.contentAlignmentHorizontal && this.contentAlignmentVertical == image.contentAlignmentVertical && Intrinsics.areEqual(this.imageUrl, image.imageUrl) && this.preloadRequired == image.preloadRequired && this.scale == image.scale && Intrinsics.areEqual(this.filters, image.filters) && this.isVectorCompatible == image.isVectorCompatible;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v15, types: [int] */
            /* JADX WARN: Type inference failed for: r0v9, types: [int] */
            /* JADX WARN: Type inference failed for: r1v15 */
            /* JADX WARN: Type inference failed for: r1v16 */
            /* JADX WARN: Type inference failed for: r1v7, types: [int] */
            /* JADX WARN: Type inference failed for: r2v0 */
            /* JADX WARN: Type inference failed for: r2v1, types: [int] */
            /* JADX WARN: Type inference failed for: r2v2 */
            public int hashCode() {
                int iHashCode = ((((((Double.hashCode(this.alpha) * 31) + this.contentAlignmentHorizontal.hashCode()) * 31) + this.contentAlignmentVertical.hashCode()) * 31) + this.imageUrl.hashCode()) * 31;
                boolean z = this.preloadRequired;
                ?? r1 = z;
                if (z) {
                    r1 = 1;
                }
                int iHashCode2 = (((iHashCode + r1) * 31) + this.scale.hashCode()) * 31;
                List<Filter> list = this.filters;
                int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
                boolean z2 = this.isVectorCompatible;
                return iHashCode3 + (z2 ? 1 : z2);
            }

            public String toString() {
                return "Image(alpha=" + this.alpha + ", contentAlignmentHorizontal=" + this.contentAlignmentHorizontal + ", contentAlignmentVertical=" + this.contentAlignmentVertical + ", imageUrl=" + this.imageUrl + ", preloadRequired=" + this.preloadRequired + ", scale=" + this.scale + ", filters=" + this.filters + ", isVectorCompatible=" + this.isVectorCompatible + ')';
            }

            public final double getAlpha() {
                return this.alpha;
            }

            public final DivAlignmentHorizontal getContentAlignmentHorizontal() {
                return this.contentAlignmentHorizontal;
            }

            public final DivAlignmentVertical getContentAlignmentVertical() {
                return this.contentAlignmentVertical;
            }

            public final Uri getImageUrl() {
                return this.imageUrl;
            }

            public final boolean getPreloadRequired() {
                return this.preloadRequired;
            }

            public final DivImageScale getScale() {
                return this.scale;
            }

            public final List<Filter> getFilters() {
                return this.filters;
            }

            public final boolean isVectorCompatible() {
                return this.isVectorCompatible;
            }

            /* JADX INFO: compiled from: DivBackgroundBinder.kt */
            @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u0082\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState$Image$Filter;", "", "()V", "toDiv", "Lcom/yandex/div2/DivFilter;", "Blur", "RtlMirror", "Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState$Image$Filter$Blur;", "Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState$Image$Filter$RtlMirror;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
            public static abstract class Filter {
                public /* synthetic */ Filter(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                /* JADX INFO: compiled from: DivBackgroundBinder.kt */
                @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState$Image$Filter$Blur;", "Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState$Image$Filter;", "radius", "", "div", "Lcom/yandex/div2/DivFilter$Blur;", "(ILcom/yandex/div2/DivFilter$Blur;)V", "getDiv", "()Lcom/yandex/div2/DivFilter$Blur;", "getRadius", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
                public static final /* data */ class Blur extends Filter {
                    private final DivFilter.Blur div;
                    private final int radius;

                    public static /* synthetic */ Blur copy$default(Blur blur, int i, DivFilter.Blur blur2, int i2, Object obj) {
                        if ((i2 & 1) != 0) {
                            i = blur.radius;
                        }
                        if ((i2 & 2) != 0) {
                            blur2 = blur.div;
                        }
                        return blur.copy(i, blur2);
                    }

                    /* JADX INFO: renamed from: component1, reason: from getter */
                    public final int getRadius() {
                        return this.radius;
                    }

                    /* JADX INFO: renamed from: component2, reason: from getter */
                    public final DivFilter.Blur getDiv() {
                        return this.div;
                    }

                    public final Blur copy(int radius, DivFilter.Blur div) {
                        Intrinsics.checkNotNullParameter(div, "div");
                        return new Blur(radius, div);
                    }

                    public boolean equals(Object other) {
                        if (this == other) {
                            return true;
                        }
                        if (!(other instanceof Blur)) {
                            return false;
                        }
                        Blur blur = (Blur) other;
                        return this.radius == blur.radius && Intrinsics.areEqual(this.div, blur.div);
                    }

                    public int hashCode() {
                        return (Integer.hashCode(this.radius) * 31) + this.div.hashCode();
                    }

                    public String toString() {
                        return "Blur(radius=" + this.radius + ", div=" + this.div + ')';
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public Blur(int i, DivFilter.Blur div) {
                        super(null);
                        Intrinsics.checkNotNullParameter(div, "div");
                        this.radius = i;
                        this.div = div;
                    }

                    public final DivFilter.Blur getDiv() {
                        return this.div;
                    }

                    public final int getRadius() {
                        return this.radius;
                    }
                }

                private Filter() {
                }

                /* JADX INFO: compiled from: DivBackgroundBinder.kt */
                @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState$Image$Filter$RtlMirror;", "Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState$Image$Filter;", "div", "Lcom/yandex/div2/DivFilter$RtlMirror;", "(Lcom/yandex/div2/DivFilter$RtlMirror;)V", "getDiv", "()Lcom/yandex/div2/DivFilter$RtlMirror;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
                public static final /* data */ class RtlMirror extends Filter {
                    private final DivFilter.RtlMirror div;

                    public static /* synthetic */ RtlMirror copy$default(RtlMirror rtlMirror, DivFilter.RtlMirror rtlMirror2, int i, Object obj) {
                        if ((i & 1) != 0) {
                            rtlMirror2 = rtlMirror.div;
                        }
                        return rtlMirror.copy(rtlMirror2);
                    }

                    /* JADX INFO: renamed from: component1, reason: from getter */
                    public final DivFilter.RtlMirror getDiv() {
                        return this.div;
                    }

                    public final RtlMirror copy(DivFilter.RtlMirror div) {
                        Intrinsics.checkNotNullParameter(div, "div");
                        return new RtlMirror(div);
                    }

                    public boolean equals(Object other) {
                        if (this == other) {
                            return true;
                        }
                        return (other instanceof RtlMirror) && Intrinsics.areEqual(this.div, ((RtlMirror) other).div);
                    }

                    public int hashCode() {
                        return this.div.hashCode();
                    }

                    public String toString() {
                        return "RtlMirror(div=" + this.div + ')';
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public RtlMirror(DivFilter.RtlMirror div) {
                        super(null);
                        Intrinsics.checkNotNullParameter(div, "div");
                        this.div = div;
                    }

                    public final DivFilter.RtlMirror getDiv() {
                        return this.div;
                    }
                }

                public final DivFilter toDiv() {
                    if (this instanceof Blur) {
                        return ((Blur) this).getDiv();
                    }
                    if (this instanceof RtlMirror) {
                        return ((RtlMirror) this).getDiv();
                    }
                    throw new NoWhenBranchMatchedException();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Image(double d, DivAlignmentHorizontal contentAlignmentHorizontal, DivAlignmentVertical contentAlignmentVertical, Uri imageUrl, boolean z, DivImageScale scale, List<? extends Filter> list, boolean z2) {
                super(null);
                Intrinsics.checkNotNullParameter(contentAlignmentHorizontal, "contentAlignmentHorizontal");
                Intrinsics.checkNotNullParameter(contentAlignmentVertical, "contentAlignmentVertical");
                Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
                Intrinsics.checkNotNullParameter(scale, "scale");
                this.alpha = d;
                this.contentAlignmentHorizontal = contentAlignmentHorizontal;
                this.contentAlignmentVertical = contentAlignmentVertical;
                this.imageUrl = imageUrl;
                this.preloadRequired = z;
                this.scale = scale;
                this.filters = list;
                this.isVectorCompatible = z2;
            }

            public final Drawable getDivImageBackground(final BindingContext context, final View target, DivImageLoader imageLoader) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(target, "target");
                Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
                final ScalingDrawable scalingDrawable = new ScalingDrawable();
                scalingDrawable.setAlpha((int) (this.alpha * ((double) 255)));
                scalingDrawable.setCustomScaleType(BaseDivViewExtensionsKt.toScaleType(this.scale));
                scalingDrawable.setAlignmentHorizontal(BaseDivViewExtensionsKt.toHorizontalAlignment(this.contentAlignmentHorizontal));
                scalingDrawable.setAlignmentVertical(BaseDivViewExtensionsKt.toVerticalAlignment(this.contentAlignmentVertical));
                String string = this.imageUrl.toString();
                Intrinsics.checkNotNullExpressionValue(string, "imageUrl.toString()");
                final Div2View divView = context.getDivView();
                LoadReference loadReferenceLoadImage = imageLoader.loadImage(string, new DivIdLoggingImageDownloadCallback(divView) { // from class: com.yandex.div.core.view2.divs.DivBackgroundBinder$DivBackgroundState$Image$getDivImageBackground$loadReference$1
                    @Override // com.yandex.div.core.images.DivImageDownloadCallback
                    public void onSuccess(CachedBitmap cachedBitmap) {
                        ArrayList arrayList;
                        Intrinsics.checkNotNullParameter(cachedBitmap, "cachedBitmap");
                        View view = target;
                        BindingContext bindingContext = context;
                        Bitmap bitmap = cachedBitmap.getBitmap();
                        Intrinsics.checkNotNullExpressionValue(bitmap, "cachedBitmap.bitmap");
                        List<DivBackgroundBinder.DivBackgroundState.Image.Filter> filters = this.getFilters();
                        if (filters != null) {
                            List<DivBackgroundBinder.DivBackgroundState.Image.Filter> list = filters;
                            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                            Iterator<T> it = list.iterator();
                            while (it.hasNext()) {
                                arrayList2.add(((DivBackgroundBinder.DivBackgroundState.Image.Filter) it.next()).toDiv());
                            }
                            arrayList = arrayList2;
                        } else {
                            arrayList = null;
                        }
                        final ScalingDrawable scalingDrawable2 = scalingDrawable;
                        BaseDivViewExtensionsKt.applyBitmapFilters(view, bindingContext, bitmap, arrayList, new Function1<Bitmap, Unit>() { // from class: com.yandex.div.core.view2.divs.DivBackgroundBinder$DivBackgroundState$Image$getDivImageBackground$loadReference$1$onSuccess$2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap2) {
                                invoke2(bitmap2);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Bitmap it2) {
                                Intrinsics.checkNotNullParameter(it2, "it");
                                scalingDrawable2.setBitmap(it2);
                            }
                        });
                    }

                    @Override // com.yandex.div.core.images.DivImageDownloadCallback
                    public void onSuccess(PictureDrawable pictureDrawable) {
                        Intrinsics.checkNotNullParameter(pictureDrawable, "pictureDrawable");
                        if (!this.isVectorCompatible()) {
                            onSuccess(ImageUtilsKt.toCachedBitmap$default(pictureDrawable, this.getImageUrl(), null, 2, null));
                            return;
                        }
                        ScalingDrawable scalingDrawable2 = scalingDrawable;
                        Picture picture = pictureDrawable.getPicture();
                        Intrinsics.checkNotNullExpressionValue(picture, "pictureDrawable.picture");
                        scalingDrawable2.setPicture(picture);
                    }
                });
                Intrinsics.checkNotNullExpressionValue(loadReferenceLoadImage, "fun getDivImageBackgroun…aleDrawable\n            }");
                context.getDivView().addLoadReference(loadReferenceLoadImage, target);
                return scalingDrawable;
            }
        }

        /* JADX INFO: compiled from: DivBackgroundBinder.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState$Solid;", "Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState;", "color", "", "(I)V", "getColor", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final /* data */ class Solid extends DivBackgroundState {
            private final int color;

            public static /* synthetic */ Solid copy$default(Solid solid, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = solid.color;
                }
                return solid.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getColor() {
                return this.color;
            }

            public final Solid copy(int color) {
                return new Solid(color);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Solid) && this.color == ((Solid) other).color;
            }

            public int hashCode() {
                return Integer.hashCode(this.color);
            }

            public String toString() {
                return "Solid(color=" + this.color + ')';
            }

            public final int getColor() {
                return this.color;
            }

            public Solid(int i) {
                super(null);
                this.color = i;
            }
        }

        /* JADX INFO: compiled from: DivBackgroundBinder.kt */
        @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001e"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState$NinePatch;", "Lcom/yandex/div/core/view2/divs/DivBackgroundBinder$DivBackgroundState;", UnifiedMediationParams.KEY_IMAGE_URL, "Landroid/net/Uri;", "insets", "Landroid/graphics/Rect;", "(Landroid/net/Uri;Landroid/graphics/Rect;)V", "getImageUrl", "()Landroid/net/Uri;", "getInsets", "()Landroid/graphics/Rect;", "component1", "component2", "copy", "equals", "", "other", "", "getNinePatchDrawable", "Landroid/graphics/drawable/Drawable;", "divView", "Lcom/yandex/div/core/view2/Div2View;", TypedValues.AttributesType.S_TARGET, "Landroid/view/View;", "imageLoader", "Lcom/yandex/div/core/images/DivImageLoader;", "hashCode", "", "toString", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final /* data */ class NinePatch extends DivBackgroundState {
            private final Uri imageUrl;
            private final Rect insets;

            public static /* synthetic */ NinePatch copy$default(NinePatch ninePatch, Uri uri, Rect rect, int i, Object obj) {
                if ((i & 1) != 0) {
                    uri = ninePatch.imageUrl;
                }
                if ((i & 2) != 0) {
                    rect = ninePatch.insets;
                }
                return ninePatch.copy(uri, rect);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Uri getImageUrl() {
                return this.imageUrl;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Rect getInsets() {
                return this.insets;
            }

            public final NinePatch copy(Uri imageUrl, Rect insets) {
                Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
                Intrinsics.checkNotNullParameter(insets, "insets");
                return new NinePatch(imageUrl, insets);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof NinePatch)) {
                    return false;
                }
                NinePatch ninePatch = (NinePatch) other;
                return Intrinsics.areEqual(this.imageUrl, ninePatch.imageUrl) && Intrinsics.areEqual(this.insets, ninePatch.insets);
            }

            public int hashCode() {
                return (this.imageUrl.hashCode() * 31) + this.insets.hashCode();
            }

            public String toString() {
                return "NinePatch(imageUrl=" + this.imageUrl + ", insets=" + this.insets + ')';
            }

            public final Uri getImageUrl() {
                return this.imageUrl;
            }

            public final Rect getInsets() {
                return this.insets;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NinePatch(Uri imageUrl, Rect insets) {
                super(null);
                Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
                Intrinsics.checkNotNullParameter(insets, "insets");
                this.imageUrl = imageUrl;
                this.insets = insets;
            }

            public final Drawable getNinePatchDrawable(final Div2View divView, View target, DivImageLoader imageLoader) {
                Intrinsics.checkNotNullParameter(divView, "divView");
                Intrinsics.checkNotNullParameter(target, "target");
                Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
                final NinePatchDrawable ninePatchDrawable = new NinePatchDrawable();
                String string = this.imageUrl.toString();
                Intrinsics.checkNotNullExpressionValue(string, "imageUrl.toString()");
                LoadReference loadReferenceLoadImage = imageLoader.loadImage(string, new DivIdLoggingImageDownloadCallback(divView) { // from class: com.yandex.div.core.view2.divs.DivBackgroundBinder$DivBackgroundState$NinePatch$getNinePatchDrawable$loadReference$1
                    @Override // com.yandex.div.core.images.DivImageDownloadCallback
                    public void onSuccess(CachedBitmap cachedBitmap) {
                        Intrinsics.checkNotNullParameter(cachedBitmap, "cachedBitmap");
                        NinePatchDrawable ninePatchDrawable2 = ninePatchDrawable;
                        DivBackgroundBinder.DivBackgroundState.NinePatch ninePatch = this;
                        ninePatchDrawable2.setBottom(ninePatch.getInsets().bottom);
                        ninePatchDrawable2.setLeft(ninePatch.getInsets().left);
                        ninePatchDrawable2.setRight(ninePatch.getInsets().right);
                        ninePatchDrawable2.setTop(ninePatch.getInsets().top);
                        ninePatchDrawable2.setBitmap(cachedBitmap.getBitmap());
                    }
                });
                Intrinsics.checkNotNullExpressionValue(loadReferenceLoadImage, "fun getNinePatchDrawable…tchDrawable\n            }");
                divView.addLoadReference(loadReferenceLoadImage, target);
                return ninePatchDrawable;
            }
        }

        public final Drawable toDrawable(BindingContext context, View target, DivImageLoader imageLoader) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(target, "target");
            Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
            if (this instanceof Image) {
                return ((Image) this).getDivImageBackground(context, target, imageLoader);
            }
            if (this instanceof NinePatch) {
                return ((NinePatch) this).getNinePatchDrawable(context.getDivView(), target, imageLoader);
            }
            if (this instanceof Solid) {
                return new ColorDrawable(((Solid) this).getColor());
            }
            if (this instanceof LinearGradient) {
                LinearGradient linearGradient = (LinearGradient) this;
                return new LinearGradientDrawable(linearGradient.getAngle(), linearGradient.getColormap());
            }
            if (!(this instanceof RadialGradient)) {
                throw new NoWhenBranchMatchedException();
            }
            RadialGradient radialGradient = (RadialGradient) this;
            return new RadialGradientDrawable(radialGradient.getRadius().toRadialGradientDrawableRadius(), radialGradient.getCenterX().toRadialGradientDrawableCenter(), radialGradient.getCenterY().toRadialGradientDrawableCenter(), CollectionsKt.toIntArray(radialGradient.getColors()));
        }
    }
}
