package com.yandex.div.core.view2.divs;

import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewGroupKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.json.b9;
import com.yandex.div.core.Disposable;
import com.yandex.div.core.dagger.DivScope;
import com.yandex.div.core.downloader.DivPatchManager;
import com.yandex.div.core.state.DivStatePath;
import com.yandex.div.core.util.DivDataExtensionsKt;
import com.yandex.div.core.util.DivUtilKt;
import com.yandex.div.core.util.ExpressionSubscribersKt;
import com.yandex.div.core.util.ReleasablesKt;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.DivBinder;
import com.yandex.div.core.view2.DivViewBinder;
import com.yandex.div.core.view2.DivViewCreator;
import com.yandex.div.core.view2.animations.DivComparator;
import com.yandex.div.core.view2.divs.widgets.DivCollectionHolder;
import com.yandex.div.core.view2.divs.widgets.DivFrameLayout;
import com.yandex.div.core.view2.divs.widgets.DivHolderView;
import com.yandex.div.core.view2.divs.widgets.DivLinearLayout;
import com.yandex.div.core.view2.divs.widgets.DivViewVisitorKt;
import com.yandex.div.core.view2.divs.widgets.DivWrapLayout;
import com.yandex.div.core.view2.errors.ErrorCollector;
import com.yandex.div.core.view2.errors.ErrorCollectors;
import com.yandex.div.core.view2.reuse.util.RebindUtilsKt;
import com.yandex.div.internal.core.DivCollectionExtensionsKt;
import com.yandex.div.internal.core.DivItemBuilderResult;
import com.yandex.div.internal.core.ExpressionSubscriber;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div.json.expressions.ExpressionsKt;
import com.yandex.div2.Div;
import com.yandex.div2.DivAlignmentHorizontal;
import com.yandex.div2.DivAlignmentVertical;
import com.yandex.div2.DivAspect;
import com.yandex.div2.DivBase;
import com.yandex.div2.DivCollectionItemBuilder;
import com.yandex.div2.DivContainer;
import com.yandex.div2.DivContentAlignmentHorizontal;
import com.yandex.div2.DivContentAlignmentVertical;
import com.yandex.div2.DivDrawable;
import com.yandex.div2.DivEdgeInsets;
import com.yandex.div2.DivSize;
import com.yandex.div2.DivSizeUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.SequencesKt;
import org.json.JSONException;

/* JADX INFO: compiled from: DivContainerBinder.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B;\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ(\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001e\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0002J,\u0010\u001c\u001a\u00020\u0013*\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0002JT\u0010#\u001a\u00020\u0013*\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00022\b\u0010$\u001a\u0004\u0018\u00010\u00022\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&2\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010)\u001a\u00020*H\u0002J*\u0010+\u001a\b\u0012\u0004\u0012\u00020,0&*\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0002JP\u0010/\u001a\u00020\u0013*\u00020\u001d2\u0006\u00100\u001a\u00020\u00022\b\u0010$\u001a\u0004\u0018\u00010\u00022\u0006\u00101\u001a\u00020\u001f2\b\u00102\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0002J=\u00107\u001a\u00020\u0013\"\u0010\b\u0000\u00108*\u00020\u0003*\u0006\u0012\u0002\b\u000309*\u0002H82\u0006\u00100\u001a\u00020\u00022\b\u0010$\u001a\u0004\u0018\u00010\u00022\u0006\u0010 \u001a\u00020!H\u0002¢\u0006\u0002\u0010:J\\\u0010;\u001a\u00020\u0013\"\u0012\b\u0000\u00108*\u00020\u0003*\b\u0012\u0004\u0012\u00020\u000209*\u0002H82\u0006\u00100\u001a\u00020\u00022\b\u0010$\u001a\u0004\u0018\u00010\u00022\u0006\u0010 \u001a\u00020!2\u001a\b\u0004\u0010<\u001a\u0014\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020\u00130=H\u0082\b¢\u0006\u0002\u0010@J,\u0010A\u001a\u00020\u0013*\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010)\u001a\u00020*H\u0002J>\u0010B\u001a\u00020\u0013*\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00022\b\u0010$\u001a\u0004\u0018\u00010\u00022\u0006\u0010C\u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010)\u001a\u00020*H\u0002J&\u0010D\u001a\u00020\u0013*\u00020E2\u0006\u00100\u001a\u00020\u00022\b\u0010$\u001a\u0004\u0018\u00010\u00022\u0006\u0010 \u001a\u00020!H\u0002Je\u0010F\u001a\u00020\u0013\"\u0012\b\u0000\u00108*\u00020\u0003*\b\u0012\u0004\u0012\u00020\u000209*\u0002H82\u0006\u00100\u001a\u00020\u00022\b\u0010$\u001a\u0004\u0018\u00010\u00022\u0006\u0010 \u001a\u00020!2#\b\u0004\u0010G\u001a\u001d\u0012\u0013\u0012\u00110I¢\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(L\u0012\u0004\u0012\u00020\u00130HH\u0082\b¢\u0006\u0002\u0010MJ&\u0010N\u001a\u00020\u0013*\u00020O2\u0006\u00100\u001a\u00020\u00022\b\u0010$\u001a\u0004\u0018\u00010\u00022\u0006\u0010 \u001a\u00020!H\u0002J&\u0010N\u001a\u00020\u0013*\u00020E2\u0006\u00100\u001a\u00020\u00022\b\u0010$\u001a\u0004\u0018\u00010\u00022\u0006\u0010 \u001a\u00020!H\u0002J&\u0010P\u001a\u00020\u0013*\u00020O2\u0006\u00100\u001a\u00020\u00022\b\u0010$\u001a\u0004\u0018\u00010\u00022\u0006\u0010 \u001a\u00020!H\u0002J&\u0010P\u001a\u00020\u0013*\u00020E2\u0006\u00100\u001a\u00020\u00022\b\u0010$\u001a\u0004\u0018\u00010\u00022\u0006\u0010 \u001a\u00020!H\u0002J`\u0010Q\u001a\u00020\u0013\"\u0012\b\u0000\u00108*\u00020\u0003*\b\u0012\u0004\u0012\u00020\u000209*\u0002H82\b\u0010R\u001a\u0004\u0018\u00010S2\b\u0010T\u001a\u0004\u0018\u00010S2\u0006\u0010 \u001a\u00020!2\u001c\b\u0004\u0010U\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010V\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00130=H\u0082\b¢\u0006\u0002\u0010WJ`\u0010X\u001a\u00020\u0013\"\u0012\b\u0000\u00108*\u00020\u0003*\b\u0012\u0004\u0012\u00020\u000209*\u0002H82\b\u0010R\u001a\u0004\u0018\u00010S2\b\u0010T\u001a\u0004\u0018\u00010S2\u0006\u0010 \u001a\u00020!2\u001c\b\u0004\u0010Y\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010S\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00130=H\u0082\b¢\u0006\u0002\u0010WJ`\u0010Z\u001a\u00020\u0013\"\u0012\b\u0000\u00108*\u00020\u0003*\b\u0012\u0004\u0012\u00020\u000209*\u0002H82\b\u0010R\u001a\u0004\u0018\u00010S2\b\u0010T\u001a\u0004\u0018\u00010S2\u0006\u0010 \u001a\u00020!2\u001c\b\u0004\u0010[\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\\\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00130=H\u0082\b¢\u0006\u0002\u0010WJ$\u0010]\u001a\u00020\u0013*\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010)\u001a\u00020*H\u0002J\u001c\u0010]\u001a\u00020\u0013*\u00020^2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020*H\u0002J$\u0010_\u001a\u00020\u0013*\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010)\u001a\u00020*H\u0002J\u001c\u0010_\u001a\u00020\u0013*\u00020^2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020*H\u0002J,\u0010`\u001a\u00020\u0013*\u00020^2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020*2\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020bH\u0002JB\u0010d\u001a\b\u0012\u0004\u0012\u00020'0&*\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u00100\u001a\u00020\u00022\b\u0010$\u001a\u0004\u0018\u00010\u00022\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J0\u0010e\u001a\u00020\u0013*\u00020\u00032\u0006\u00105\u001a\u0002062\f\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020'0&H\u0002J\f\u0010g\u001a\u00020.*\u00020IH\u0002J\u001e\u0010h\u001a\u00020\u0011*\u0004\u0018\u00010V2\u0006\u0010i\u001a\u00020j2\u0006\u0010 \u001a\u00020!H\u0002J\u0016\u0010k\u001a\u00020.*\u0004\u0018\u00010S2\u0006\u0010 \u001a\u00020!H\u0002J\f\u0010l\u001a\u00020.*\u00020IH\u0002J2\u0010m\u001a\u00020\u0013*\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00022\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&2\u0006\u0010 \u001a\u00020!2\u0006\u0010)\u001a\u00020*H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006n"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivContainerBinder;", "Lcom/yandex/div/core/view2/DivViewBinder;", "Lcom/yandex/div2/DivContainer;", "Landroid/view/ViewGroup;", "baseBinder", "Lcom/yandex/div/core/view2/divs/DivBaseBinder;", "divViewCreator", "Ljavax/inject/Provider;", "Lcom/yandex/div/core/view2/DivViewCreator;", "divPatchManager", "Lcom/yandex/div/core/downloader/DivPatchManager;", "divBinder", "Lcom/yandex/div/core/view2/DivBinder;", "errorCollectors", "Lcom/yandex/div/core/view2/errors/ErrorCollectors;", "(Lcom/yandex/div/core/view2/divs/DivBaseBinder;Ljavax/inject/Provider;Lcom/yandex/div/core/downloader/DivPatchManager;Ljavax/inject/Provider;Lcom/yandex/div/core/view2/errors/ErrorCollectors;)V", "tempRect", "Landroid/graphics/Rect;", "bindView", "", "context", "Lcom/yandex/div/core/view2/BindingContext;", "view", "div", "path", "Lcom/yandex/div/core/state/DivStatePath;", "setDataWithoutBinding", "bindingContext", "applyChildAlignment", "Landroid/view/View;", "childDiv", "Lcom/yandex/div2/DivBase;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "childResolver", "applyItems", "oldDiv", FirebaseAnalytics.Param.ITEMS, "", "Lcom/yandex/div/internal/core/DivItemBuilderResult;", "oldItems", "errorCollector", "Lcom/yandex/div/core/view2/errors/ErrorCollector;", "applyPatchToChild", "Lcom/yandex/div2/Div;", "childIndex", "", "bindChildAlignment", "newDiv", "newChildDiv", "oldChildDiv", "subscriber", "Lcom/yandex/div/internal/core/ExpressionSubscriber;", "divView", "Lcom/yandex/div/core/view2/Div2View;", "bindClipChildren", "T", "Lcom/yandex/div/core/view2/divs/widgets/DivHolderView;", "(Landroid/view/ViewGroup;Lcom/yandex/div2/DivContainer;Lcom/yandex/div2/DivContainer;Lcom/yandex/div/json/expressions/ExpressionResolver;)V", "bindContentAlignment", "applyContentAlignment", "Lkotlin/Function2;", "Lcom/yandex/div2/DivContentAlignmentHorizontal;", "Lcom/yandex/div2/DivContentAlignmentVertical;", "(Landroid/view/ViewGroup;Lcom/yandex/div2/DivContainer;Lcom/yandex/div2/DivContainer;Lcom/yandex/div/json/expressions/ExpressionResolver;Lkotlin/jvm/functions/Function2;)V", "bindItemBuilder", "bindItems", "oldResolver", "bindLineSeparator", "Lcom/yandex/div/core/view2/divs/widgets/DivWrapLayout;", "bindOrientation", "applyOrientation", "Lkotlin/Function1;", "Lcom/yandex/div2/DivContainer$Orientation;", "Lkotlin/ParameterName;", "name", "orientation", "(Landroid/view/ViewGroup;Lcom/yandex/div2/DivContainer;Lcom/yandex/div2/DivContainer;Lcom/yandex/div/json/expressions/ExpressionResolver;Lkotlin/jvm/functions/Function1;)V", "bindProperties", "Lcom/yandex/div/core/view2/divs/widgets/DivLinearLayout;", "bindSeparator", "bindSeparatorMargins", "newSeparator", "Lcom/yandex/div2/DivContainer$Separator;", "oldSeparator", "applySeparatorMargins", "Lcom/yandex/div2/DivEdgeInsets;", "(Landroid/view/ViewGroup;Lcom/yandex/div2/DivContainer$Separator;Lcom/yandex/div2/DivContainer$Separator;Lcom/yandex/div/json/expressions/ExpressionResolver;Lkotlin/jvm/functions/Function2;)V", "bindSeparatorShowMode", "applySeparatorShowMode", "bindSeparatorStyle", "applySeparatorStyle", "Lcom/yandex/div2/DivDrawable;", "checkCrossAxisSize", "Lcom/yandex/div2/DivSize;", "checkMainAxisSize", "checkSize", b9.a.t, "", "axis", "dispatchBinding", "replaceWithReuse", "newItems", "toOrientationMode", "toRect", "resources", "Landroid/content/res/Resources;", "toSeparatorMode", "toWrapDirection", "validateChildren", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@DivScope
public final class DivContainerBinder implements DivViewBinder<DivContainer, ViewGroup> {
    private final DivBaseBinder baseBinder;
    private final Provider<DivBinder> divBinder;
    private final DivPatchManager divPatchManager;
    private final Provider<DivViewCreator> divViewCreator;
    private final ErrorCollectors errorCollectors;
    private final Rect tempRect;

    /* JADX INFO: compiled from: DivContainerBinder.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DivContainer.Orientation.values().length];
            try {
                iArr[DivContainer.Orientation.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public DivContainerBinder(DivBaseBinder baseBinder, Provider<DivViewCreator> divViewCreator, DivPatchManager divPatchManager, Provider<DivBinder> divBinder, ErrorCollectors errorCollectors) {
        Intrinsics.checkNotNullParameter(baseBinder, "baseBinder");
        Intrinsics.checkNotNullParameter(divViewCreator, "divViewCreator");
        Intrinsics.checkNotNullParameter(divPatchManager, "divPatchManager");
        Intrinsics.checkNotNullParameter(divBinder, "divBinder");
        Intrinsics.checkNotNullParameter(errorCollectors, "errorCollectors");
        this.baseBinder = baseBinder;
        this.divViewCreator = divViewCreator;
        this.divPatchManager = divPatchManager;
        this.divBinder = divBinder;
        this.errorCollectors = errorCollectors;
        this.tempRect = new Rect();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yandex.div.core.view2.DivViewBinder
    public void bindView(BindingContext context, ViewGroup view, DivContainer div, DivStatePath path) {
        ExpressionResolver oldExpressionResolver$div_release;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(div, "div");
        Intrinsics.checkNotNullParameter(path, "path");
        DivHolderView divHolderView = (DivHolderView) view;
        DivContainer divContainer = (DivContainer) divHolderView.getDiv();
        Div2View divView = context.getDivView();
        BindingContext bindingContext = divHolderView.getBindingContext();
        if (bindingContext == null || (oldExpressionResolver$div_release = bindingContext.getExpressionResolver()) == null) {
            oldExpressionResolver$div_release = divView.getOldExpressionResolver$div_release();
        }
        ExpressionResolver expressionResolver = oldExpressionResolver$div_release;
        ViewGroup viewGroup = view;
        this.baseBinder.bindView(context, viewGroup, div, divContainer);
        BaseDivViewExtensionsKt.applyDivActions(viewGroup, context, div.action, div.actions, div.longtapActions, div.doubletapActions, div.hoverStartActions, div.hoverEndActions, div.pressStartActions, div.pressEndActions, div.actionAnimation, div.getAccessibility());
        ExpressionResolver expressionResolver2 = context.getExpressionResolver();
        ErrorCollector orCreate = this.errorCollectors.getOrCreate(divView.getDataTag(), divView.getDivData());
        BaseDivViewExtensionsKt.bindAspectRatio(viewGroup, div.aspect, divContainer != null ? divContainer.aspect : null, expressionResolver2);
        if (view instanceof DivLinearLayout) {
            bindProperties((DivLinearLayout) view, div, divContainer, expressionResolver2);
        } else if (view instanceof DivWrapLayout) {
            bindProperties((DivWrapLayout) view, div, divContainer, expressionResolver2);
        }
        bindClipChildren(view, div, divContainer, expressionResolver2);
        Iterator<View> it = ViewGroupKt.getChildren(view).iterator();
        while (it.hasNext()) {
            divView.unbindViewFromDiv$div_release(it.next());
        }
        bindItems(view, context, div, divContainer, expressionResolver, path, orCreate);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void bindItems(ViewGroup viewGroup, BindingContext bindingContext, DivContainer divContainer, DivContainer divContainer2, ExpressionResolver expressionResolver, DivStatePath divStatePath, ErrorCollector errorCollector) {
        List<DivItemBuilderResult> list;
        Div2View divView = bindingContext.getDivView();
        List<DivItemBuilderResult> listBuildItems = DivCollectionExtensionsKt.buildItems(divContainer, bindingContext.getExpressionResolver());
        Intrinsics.checkNotNull(viewGroup, "null cannot be cast to non-null type com.yandex.div.core.view2.divs.widgets.DivCollectionHolder");
        List<DivItemBuilderResult> items = ((DivCollectionHolder) viewGroup).getItems();
        if (items != null) {
            if (divContainer != divContainer2) {
                if (!divView.getComplexRebindInProgress$div_release()) {
                    if (divContainer2 == null || !DivComparator.areValuesReplaceable$default(DivComparator.INSTANCE, divContainer2, divContainer, expressionResolver, bindingContext.getExpressionResolver(), null, 16, null) || !DivComparator.areChildrenReplaceable$default(DivComparator.INSTANCE, items, listBuildItems, null, 4, null)) {
                        replaceWithReuse(viewGroup, divView, items, listBuildItems);
                    }
                }
                list = null;
            }
            bindItemBuilder(viewGroup, bindingContext, divContainer, divStatePath, errorCollector);
            applyItems(viewGroup, bindingContext, divContainer, divContainer2, listBuildItems, list, divStatePath, errorCollector);
        }
        for (DivItemBuilderResult divItemBuilderResult : listBuildItems) {
            viewGroup.addView(this.divViewCreator.get().create(divItemBuilderResult.getDiv(), divItemBuilderResult.getExpressionResolver()));
        }
        list = items;
        bindItemBuilder(viewGroup, bindingContext, divContainer, divStatePath, errorCollector);
        applyItems(viewGroup, bindingContext, divContainer, divContainer2, listBuildItems, list, divStatePath, errorCollector);
    }

    private final void bindItemBuilder(final ViewGroup viewGroup, final BindingContext bindingContext, final DivContainer divContainer, final DivStatePath divStatePath, final ErrorCollector errorCollector) {
        final DivCollectionItemBuilder divCollectionItemBuilder = divContainer.itemBuilder;
        if (divCollectionItemBuilder == null) {
            return;
        }
        BaseDivViewExtensionsKt.bindItemBuilder(divCollectionItemBuilder, bindingContext.getExpressionResolver(), new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder.bindItemBuilder.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) throws JSONException {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object it) throws JSONException {
                Intrinsics.checkNotNullParameter(it, "it");
                List<DivItemBuilderResult> listBuild = DivCollectionExtensionsKt.build(divCollectionItemBuilder, bindingContext.getExpressionResolver());
                ViewParent viewParent = viewGroup;
                Intrinsics.checkNotNull(viewParent, "null cannot be cast to non-null type com.yandex.div.core.view2.divs.widgets.DivCollectionHolder");
                List<DivItemBuilderResult> items = ((DivCollectionHolder) viewParent).getItems();
                if (items == null) {
                    items = CollectionsKt.emptyList();
                }
                List<DivItemBuilderResult> list = items;
                this.replaceWithReuse(viewGroup, bindingContext.getDivView(), list, listBuild);
                DivContainerBinder divContainerBinder = this;
                ViewGroup viewGroup2 = viewGroup;
                BindingContext bindingContext2 = bindingContext;
                DivContainer divContainer2 = divContainer;
                divContainerBinder.applyItems(viewGroup2, bindingContext2, divContainer2, divContainer2, listBuild, list, divStatePath, errorCollector);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void applyItems(ViewGroup viewGroup, BindingContext bindingContext, DivContainer divContainer, DivContainer divContainer2, List<DivItemBuilderResult> list, List<DivItemBuilderResult> list2, DivStatePath divStatePath, ErrorCollector errorCollector) {
        Div2View divView = bindingContext.getDivView();
        RebindUtilsKt.tryRebindPlainContainerChildren(viewGroup, divView, list, this.divViewCreator);
        validateChildren(viewGroup, divContainer, list, bindingContext.getExpressionResolver(), errorCollector);
        List<DivItemBuilderResult> listDispatchBinding = dispatchBinding(viewGroup, bindingContext, divContainer, divContainer2, list, divStatePath);
        int i = 0;
        for (Object obj : listDispatchBinding) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            DivItemBuilderResult divItemBuilderResult = (DivItemBuilderResult) obj;
            if (BaseDivViewExtensionsKt.getHasSightActions(divItemBuilderResult.getDiv().value())) {
                View childAt = viewGroup.getChildAt(i);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(i)");
                divView.bindViewToDiv$div_release(childAt, divItemBuilderResult.getDiv());
            }
            i = i2;
        }
        Intrinsics.checkNotNull(viewGroup, "null cannot be cast to non-null type com.yandex.div.core.view2.divs.widgets.DivCollectionHolder");
        ((DivCollectionHolder) viewGroup).setItems(listDispatchBinding);
        BaseDivViewExtensionsKt.trackVisibilityActions(viewGroup, divView, listDispatchBinding, list2);
    }

    private final void validateChildren(ViewGroup viewGroup, DivContainer divContainer, List<DivItemBuilderResult> list, ExpressionResolver expressionResolver, ErrorCollector errorCollector) {
        if (viewGroup instanceof DivFrameLayout) {
            return;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            DivBase divBaseValue = ((DivItemBuilderResult) it.next()).getDiv().value();
            if (viewGroup instanceof DivWrapLayout) {
                checkCrossAxisSize(divContainer, divBaseValue, expressionResolver, errorCollector);
            } else if (viewGroup instanceof DivLinearLayout) {
                checkMainAxisSize(divContainer, divBaseValue, expressionResolver, errorCollector);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<DivItemBuilderResult> dispatchBinding(ViewGroup viewGroup, BindingContext bindingContext, DivContainer divContainer, DivContainer divContainer2, List<DivItemBuilderResult> list, DivStatePath divStatePath) {
        List listListOf;
        DivBinder divBinder = this.divBinder.get();
        ExpressionSubscriber expressionSubscriber = ReleasablesKt.getExpressionSubscriber(viewGroup);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int size = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            DivItemBuilderResult divItemBuilderResult = (DivItemBuilderResult) obj;
            if (divContainer.itemBuilder != null) {
                listListOf = CollectionsKt.listOf(divItemBuilderResult);
            } else {
                List<Div> listApplyPatchToChild = applyPatchToChild(viewGroup, bindingContext, divItemBuilderResult.getDiv(), i + size);
                List arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listApplyPatchToChild, 10));
                Iterator<T> it = listApplyPatchToChild.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new DivItemBuilderResult((Div) it.next(), divItemBuilderResult.getExpressionResolver()));
                }
                listListOf = arrayList2;
                size += listListOf.size() - 1;
            }
            CollectionsKt.addAll(arrayList, listListOf);
            i = i2;
        }
        ArrayList arrayList3 = arrayList;
        int i3 = 0;
        for (Object obj2 : arrayList3) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            DivItemBuilderResult divItemBuilderResult2 = (DivItemBuilderResult) obj2;
            View childView = viewGroup.getChildAt(i3);
            DivBase divBaseValue = divItemBuilderResult2.getDiv().value();
            DivHolderView divHolderView = childView instanceof DivHolderView ? (DivHolderView) childView : null;
            DivBase div = divHolderView != null ? divHolderView.getDiv() : null;
            DivStatePath divStatePathResolvePath = BaseDivViewExtensionsKt.resolvePath(divBaseValue, i3, divStatePath);
            if (!Intrinsics.areEqual(bindingContext.getExpressionResolver(), divItemBuilderResult2.getExpressionResolver())) {
                BaseDivViewExtensionsKt.resolveRuntime(bindingContext.getRuntimeStore(), divBaseValue, divStatePathResolvePath.getFullPath$div_release(), divItemBuilderResult2.getExpressionResolver(), bindingContext.getExpressionResolver());
            }
            BindingContext bindingContext2 = bindingContext.getFor(divItemBuilderResult2.getExpressionResolver());
            Intrinsics.checkNotNullExpressionValue(childView, "childView");
            divBinder.bind(bindingContext2, childView, divItemBuilderResult2.getDiv(), divStatePathResolvePath);
            bindChildAlignment(childView, divContainer, divContainer2, divBaseValue, div, bindingContext.getExpressionResolver(), divItemBuilderResult2.getExpressionResolver(), expressionSubscriber, bindingContext.getDivView());
            if (BaseDivViewExtensionsKt.getHasSightActions(divBaseValue)) {
                bindingContext.getDivView().bindViewToDiv$div_release(childView, divItemBuilderResult2.getDiv());
            } else {
                bindingContext.getDivView().unbindViewFromDiv$div_release(childView);
            }
            i3 = i4;
        }
        return arrayList3;
    }

    private final List<Div> applyPatchToChild(ViewGroup viewGroup, BindingContext bindingContext, Div div, int i) {
        Div2View divView = bindingContext.getDivView();
        String id = div.value().getId();
        if (id != null) {
            Map<Div, View> mapCreateViewsForId = this.divPatchManager.createViewsForId(bindingContext, id);
            if (mapCreateViewsForId == null) {
                return CollectionsKt.listOf(div);
            }
            viewGroup.removeViewAt(i);
            int i2 = 0;
            for (Map.Entry<Div, View> entry : mapCreateViewsForId.entrySet()) {
                Div key = entry.getKey();
                View value = entry.getValue();
                int i3 = i2 + 1;
                viewGroup.addView(value, i2 + i);
                if (BaseDivViewExtensionsKt.getHasSightActions(key.value())) {
                    divView.bindViewToDiv$div_release(value, key);
                }
                i2 = i3;
            }
            return CollectionsKt.toList(mapCreateViewsForId.keySet());
        }
        return CollectionsKt.listOf(div);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void replaceWithReuse(ViewGroup viewGroup, Div2View div2View, List<DivItemBuilderResult> list, List<DivItemBuilderResult> list2) {
        Object next;
        boolean zCanBeReused;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List<DivItemBuilderResult> list3 = list;
        List list4 = SequencesKt.toList(ViewGroupKt.getChildren(viewGroup));
        Iterator<T> it = list3.iterator();
        Iterator it2 = list4.iterator();
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(list3, 10), CollectionsKt.collectionSizeOrDefault(list4, 10)));
        while (it.hasNext() && it2.hasNext()) {
            linkedHashMap.put(((DivItemBuilderResult) it.next()).getDiv(), (View) it2.next());
            arrayList.add(Unit.INSTANCE);
        }
        viewGroup.removeAllViews();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it3 = list2.iterator();
        int i = 0;
        while (true) {
            Object obj = null;
            if (!it3.hasNext()) {
                break;
            }
            Object next2 = it3.next();
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            DivItemBuilderResult divItemBuilderResult = (DivItemBuilderResult) next2;
            for (Object obj2 : linkedHashMap.keySet()) {
                Div div = (Div) obj2;
                if (DivUtilKt.isBranch(div)) {
                    zCanBeReused = Intrinsics.areEqual(DivUtilKt.getType(divItemBuilderResult.getDiv()), DivUtilKt.getType(div));
                } else {
                    zCanBeReused = DivUtilKt.canBeReused(div, divItemBuilderResult.getDiv(), divItemBuilderResult.getExpressionResolver());
                }
                if (zCanBeReused) {
                    obj = obj2;
                    break;
                }
            }
            View view = (View) TypeIntrinsics.asMutableMap(linkedHashMap).remove((Div) obj);
            if (view != null) {
                viewGroup.addView(view);
            } else {
                arrayList2.add(Integer.valueOf(i));
            }
            i = i2;
        }
        Iterator it4 = arrayList2.iterator();
        while (it4.hasNext()) {
            int iIntValue = ((Number) it4.next()).intValue();
            DivItemBuilderResult divItemBuilderResult2 = list2.get(iIntValue);
            Iterator it5 = linkedHashMap.keySet().iterator();
            do {
                if (!it5.hasNext()) {
                    next = null;
                    break;
                }
                next = it5.next();
            } while (!Intrinsics.areEqual(DivUtilKt.getType((Div) next), DivUtilKt.getType(divItemBuilderResult2.getDiv())));
            View viewCreate = (View) TypeIntrinsics.asMutableMap(linkedHashMap).remove((Div) next);
            if (viewCreate == null) {
                viewCreate = this.divViewCreator.get().create(divItemBuilderResult2.getDiv(), divItemBuilderResult2.getExpressionResolver());
            }
            viewGroup.addView(viewCreate, iIntValue);
        }
        Iterator it6 = linkedHashMap.values().iterator();
        while (it6.hasNext()) {
            DivViewVisitorKt.visitViewTree(div2View.getReleaseViewVisitor$div_release(), (View) it6.next());
        }
    }

    private final <T extends ViewGroup & DivHolderView<?>> void bindClipChildren(T t, DivContainer divContainer, DivContainer divContainer2, ExpressionResolver expressionResolver) {
        BaseDivViewExtensionsKt.bindClipChildren(t, divContainer.clipToBounds, divContainer2 != null ? divContainer2.clipToBounds : null, expressionResolver);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0059  */
    /* JADX WARN: Code duplicated, block: B:30:0x0081  */
    private final void bindProperties(final DivLinearLayout divLinearLayout, final DivContainer divContainer, DivContainer divContainer2, final ExpressionResolver expressionResolver) {
        DivLinearLayout divLinearLayout2 = divLinearLayout;
        if (!ExpressionsKt.equalsToConstant(divContainer.orientation, divContainer2 != null ? divContainer2.orientation : null)) {
            divLinearLayout.setOrientation(toOrientationMode(divContainer.orientation.evaluate(expressionResolver)));
            if (!ExpressionsKt.isConstant(divContainer.orientation)) {
                divLinearLayout2.addSubscription(divContainer.orientation.observe(expressionResolver, new Function1<DivContainer.Orientation, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindProperties$$inlined$bindOrientation$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DivContainer.Orientation orientation) {
                        invoke2(orientation);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DivContainer.Orientation orientation) {
                        Intrinsics.checkNotNullParameter(orientation, "orientation");
                        divLinearLayout.setOrientation(this.toOrientationMode(orientation));
                    }
                }));
            }
        }
        if (ExpressionsKt.equalsToConstant(divContainer.contentAlignmentHorizontal, divContainer2 != null ? divContainer2.contentAlignmentHorizontal : null)) {
            if (!ExpressionsKt.equalsToConstant(divContainer.contentAlignmentVertical, divContainer2 != null ? divContainer2.contentAlignmentVertical : null)) {
                divLinearLayout.setGravity(BaseDivViewExtensionsKt.evaluateGravity(divContainer.contentAlignmentHorizontal.evaluate(expressionResolver), divContainer.contentAlignmentVertical.evaluate(expressionResolver)));
                if (ExpressionsKt.isConstant(divContainer.contentAlignmentHorizontal) || !ExpressionsKt.isConstant(divContainer.contentAlignmentVertical)) {
                    Function1<? super DivContentAlignmentHorizontal, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindProperties$$inlined$bindContentAlignment$1
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
                            divLinearLayout.setGravity(BaseDivViewExtensionsKt.evaluateGravity(divContainer.contentAlignmentHorizontal.evaluate(expressionResolver), divContainer.contentAlignmentVertical.evaluate(expressionResolver)));
                        }
                    };
                    DivLinearLayout divLinearLayout3 = divLinearLayout2;
                    divLinearLayout3.addSubscription(divContainer.contentAlignmentHorizontal.observe(expressionResolver, function1));
                    divLinearLayout3.addSubscription(divContainer.contentAlignmentVertical.observe(expressionResolver, function1));
                }
            }
        } else {
            divLinearLayout.setGravity(BaseDivViewExtensionsKt.evaluateGravity(divContainer.contentAlignmentHorizontal.evaluate(expressionResolver), divContainer.contentAlignmentVertical.evaluate(expressionResolver)));
            if (ExpressionsKt.isConstant(divContainer.contentAlignmentHorizontal)) {
                Function1<? super DivContentAlignmentHorizontal, Unit> function2 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindProperties$$inlined$bindContentAlignment$1
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
                        divLinearLayout.setGravity(BaseDivViewExtensionsKt.evaluateGravity(divContainer.contentAlignmentHorizontal.evaluate(expressionResolver), divContainer.contentAlignmentVertical.evaluate(expressionResolver)));
                    }
                };
                DivLinearLayout divLinearLayout4 = divLinearLayout2;
                divLinearLayout4.addSubscription(divContainer.contentAlignmentHorizontal.observe(expressionResolver, function2));
                divLinearLayout4.addSubscription(divContainer.contentAlignmentVertical.observe(expressionResolver, function2));
            } else {
                Function1<? super DivContentAlignmentHorizontal, Unit> function3 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindProperties$$inlined$bindContentAlignment$1
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
                        divLinearLayout.setGravity(BaseDivViewExtensionsKt.evaluateGravity(divContainer.contentAlignmentHorizontal.evaluate(expressionResolver), divContainer.contentAlignmentVertical.evaluate(expressionResolver)));
                    }
                };
                DivLinearLayout divLinearLayout5 = divLinearLayout2;
                divLinearLayout5.addSubscription(divContainer.contentAlignmentHorizontal.observe(expressionResolver, function3));
                divLinearLayout5.addSubscription(divContainer.contentAlignmentVertical.observe(expressionResolver, function3));
            }
        }
        bindSeparator(divLinearLayout, divContainer, divContainer2, expressionResolver);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0044  */
    /* JADX WARN: Code duplicated, block: B:33:0x004d  */
    /* JADX WARN: Code duplicated, block: B:34:0x0050  */
    /* JADX WARN: Code duplicated, block: B:37:0x0057 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:38:0x0059  */
    /* JADX WARN: Code duplicated, block: B:39:0x005c  */
    /* JADX WARN: Code duplicated, block: B:42:0x0063 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:43:0x0065  */
    /* JADX WARN: Code duplicated, block: B:44:0x0068  */
    /* JADX WARN: Code duplicated, block: B:48:0x0070  */
    /* JADX WARN: Code duplicated, block: B:50:0x0082  */
    /* JADX WARN: Code duplicated, block: B:53:0x008b  */
    /* JADX WARN: Code duplicated, block: B:56:0x0091  */
    /* JADX WARN: Code duplicated, block: B:59:0x009a  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:65:0x00a9  */
    private final void bindSeparator(final DivLinearLayout divLinearLayout, DivContainer divContainer, DivContainer divContainer2, final ExpressionResolver expressionResolver) {
        Expression<Boolean> expression;
        Disposable disposableObserve;
        Disposable disposableObserve2;
        Disposable disposableObserve3;
        Expression<Boolean> expression2;
        Expression<Boolean> expression3;
        Expression<Boolean> expression4;
        Expression<Boolean> expression5;
        Expression<Boolean> expression6;
        Drawable drawable;
        DivLinearLayout divLinearLayout2 = divLinearLayout;
        final DivContainer.Separator separator = divContainer.separator;
        DivContainer.Separator separator2 = divContainer2 != null ? divContainer2.separator : null;
        if (ExpressionsKt.equalsToConstant(separator != null ? separator.showAtStart : null, separator2 != null ? separator2.showAtStart : null)) {
            if (ExpressionsKt.equalsToConstant(separator != null ? separator.showBetween : null, separator2 != null ? separator2.showBetween : null)) {
                if (!ExpressionsKt.equalsToConstant(separator != null ? separator.showAtEnd : null, separator2 != null ? separator2.showAtEnd : null)) {
                    divLinearLayout.setShowDividers(toSeparatorMode(separator, expressionResolver));
                    if (separator != null) {
                        expression = separator.showAtStart;
                    } else {
                        expression = null;
                    }
                    if (ExpressionsKt.isConstantOrNull(expression)) {
                        if (separator != null) {
                            expression5 = separator.showBetween;
                        } else {
                            expression5 = null;
                        }
                        if (ExpressionsKt.isConstantOrNull(expression5)) {
                            if (separator != null) {
                                expression6 = separator.showAtEnd;
                            } else {
                                expression6 = null;
                            }
                            if (!ExpressionsKt.isConstantOrNull(expression6)) {
                                Function1<? super Boolean, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindSeparator$$inlined$bindSeparatorShowMode$1
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
                                    public final void invoke2(Object it) {
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        divLinearLayout.setShowDividers(this.toSeparatorMode(separator, expressionResolver));
                                    }
                                };
                                DivLinearLayout divLinearLayout3 = divLinearLayout2;
                                if (separator != null) {
                                    disposableObserve = null;
                                } else {
                                    disposableObserve = null;
                                }
                                divLinearLayout3.addSubscription(disposableObserve);
                                if (separator != null) {
                                    disposableObserve2 = null;
                                } else {
                                    disposableObserve2 = null;
                                }
                                divLinearLayout3.addSubscription(disposableObserve2);
                                if (separator != null) {
                                    disposableObserve3 = null;
                                } else {
                                    disposableObserve3 = null;
                                }
                                divLinearLayout3.addSubscription(disposableObserve3);
                            }
                        } else {
                            Function1<? super Boolean, Unit> function2 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindSeparator$$inlined$bindSeparatorShowMode$1
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
                                public final void invoke2(Object it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    divLinearLayout.setShowDividers(this.toSeparatorMode(separator, expressionResolver));
                                }
                            };
                            DivLinearLayout divLinearLayout4 = divLinearLayout2;
                            if (separator != null) {
                                disposableObserve = null;
                            } else {
                                disposableObserve = null;
                            }
                            divLinearLayout4.addSubscription(disposableObserve);
                            if (separator != null) {
                                disposableObserve2 = null;
                            } else {
                                disposableObserve2 = null;
                            }
                            divLinearLayout4.addSubscription(disposableObserve2);
                            if (separator != null) {
                                disposableObserve3 = null;
                            } else {
                                disposableObserve3 = null;
                            }
                            divLinearLayout4.addSubscription(disposableObserve3);
                        }
                    } else {
                        Function1<? super Boolean, Unit> function3 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindSeparator$$inlined$bindSeparatorShowMode$1
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
                            public final void invoke2(Object it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                divLinearLayout.setShowDividers(this.toSeparatorMode(separator, expressionResolver));
                            }
                        };
                        DivLinearLayout divLinearLayout5 = divLinearLayout2;
                        if (separator != null) {
                            disposableObserve = null;
                        } else {
                            disposableObserve = null;
                        }
                        divLinearLayout5.addSubscription(disposableObserve);
                        if (separator != null) {
                            disposableObserve2 = null;
                        } else {
                            disposableObserve2 = null;
                        }
                        divLinearLayout5.addSubscription(disposableObserve2);
                        if (separator != null) {
                            disposableObserve3 = null;
                        } else {
                            disposableObserve3 = null;
                        }
                        divLinearLayout5.addSubscription(disposableObserve3);
                    }
                }
            } else {
                divLinearLayout.setShowDividers(toSeparatorMode(separator, expressionResolver));
                if (separator != null) {
                    expression = separator.showAtStart;
                } else {
                    expression = null;
                }
                if (ExpressionsKt.isConstantOrNull(expression)) {
                    Function1<? super Boolean, Unit> function4 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindSeparator$$inlined$bindSeparatorShowMode$1
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
                        public final void invoke2(Object it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            divLinearLayout.setShowDividers(this.toSeparatorMode(separator, expressionResolver));
                        }
                    };
                    DivLinearLayout divLinearLayout6 = divLinearLayout2;
                    if (separator != null) {
                        disposableObserve = null;
                    } else {
                        disposableObserve = null;
                    }
                    divLinearLayout6.addSubscription(disposableObserve);
                    if (separator != null) {
                        disposableObserve2 = null;
                    } else {
                        disposableObserve2 = null;
                    }
                    divLinearLayout6.addSubscription(disposableObserve2);
                    if (separator != null) {
                        disposableObserve3 = null;
                    } else {
                        disposableObserve3 = null;
                    }
                    divLinearLayout6.addSubscription(disposableObserve3);
                } else {
                    if (separator != null) {
                        expression5 = separator.showBetween;
                    } else {
                        expression5 = null;
                    }
                    if (ExpressionsKt.isConstantOrNull(expression5)) {
                        Function1<? super Boolean, Unit> function5 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindSeparator$$inlined$bindSeparatorShowMode$1
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
                            public final void invoke2(Object it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                divLinearLayout.setShowDividers(this.toSeparatorMode(separator, expressionResolver));
                            }
                        };
                        DivLinearLayout divLinearLayout7 = divLinearLayout2;
                        if (separator != null) {
                            disposableObserve = null;
                        } else {
                            disposableObserve = null;
                        }
                        divLinearLayout7.addSubscription(disposableObserve);
                        if (separator != null) {
                            disposableObserve2 = null;
                        } else {
                            disposableObserve2 = null;
                        }
                        divLinearLayout7.addSubscription(disposableObserve2);
                        if (separator != null) {
                            disposableObserve3 = null;
                        } else {
                            disposableObserve3 = null;
                        }
                        divLinearLayout7.addSubscription(disposableObserve3);
                    } else {
                        if (separator != null) {
                            expression6 = separator.showAtEnd;
                        } else {
                            expression6 = null;
                        }
                        if (!ExpressionsKt.isConstantOrNull(expression6)) {
                            Function1<? super Boolean, Unit> function6 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindSeparator$$inlined$bindSeparatorShowMode$1
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
                                public final void invoke2(Object it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    divLinearLayout.setShowDividers(this.toSeparatorMode(separator, expressionResolver));
                                }
                            };
                            DivLinearLayout divLinearLayout8 = divLinearLayout2;
                            if (separator != null) {
                                disposableObserve = null;
                            } else {
                                disposableObserve = null;
                            }
                            divLinearLayout8.addSubscription(disposableObserve);
                            if (separator != null) {
                                disposableObserve2 = null;
                            } else {
                                disposableObserve2 = null;
                            }
                            divLinearLayout8.addSubscription(disposableObserve2);
                            if (separator != null) {
                                disposableObserve3 = null;
                            } else {
                                disposableObserve3 = null;
                            }
                            divLinearLayout8.addSubscription(disposableObserve3);
                        }
                    }
                }
            }
        } else {
            divLinearLayout.setShowDividers(toSeparatorMode(separator, expressionResolver));
            if (separator != null) {
                expression = separator.showAtStart;
            } else {
                expression = null;
            }
            if (ExpressionsKt.isConstantOrNull(expression)) {
                Function1<? super Boolean, Unit> function7 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindSeparator$$inlined$bindSeparatorShowMode$1
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
                    public final void invoke2(Object it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        divLinearLayout.setShowDividers(this.toSeparatorMode(separator, expressionResolver));
                    }
                };
                DivLinearLayout divLinearLayout9 = divLinearLayout2;
                if (separator != null || (expression4 = separator.showAtStart) == null) {
                    disposableObserve = null;
                } else {
                    disposableObserve = expression4.observe(expressionResolver, function7);
                }
                divLinearLayout9.addSubscription(disposableObserve);
                if (separator != null || (expression3 = separator.showBetween) == null) {
                    disposableObserve2 = null;
                } else {
                    disposableObserve2 = expression3.observe(expressionResolver, function7);
                }
                divLinearLayout9.addSubscription(disposableObserve2);
                if (separator != null || (expression2 = separator.showAtEnd) == null) {
                    disposableObserve3 = null;
                } else {
                    disposableObserve3 = expression2.observe(expressionResolver, function7);
                }
                divLinearLayout9.addSubscription(disposableObserve3);
            } else {
                if (separator != null) {
                    expression5 = separator.showBetween;
                } else {
                    expression5 = null;
                }
                if (ExpressionsKt.isConstantOrNull(expression5)) {
                    Function1<? super Boolean, Unit> function8 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindSeparator$$inlined$bindSeparatorShowMode$1
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
                        public final void invoke2(Object it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            divLinearLayout.setShowDividers(this.toSeparatorMode(separator, expressionResolver));
                        }
                    };
                    DivLinearLayout divLinearLayout10 = divLinearLayout2;
                    if (separator != null) {
                        disposableObserve = null;
                    } else {
                        disposableObserve = null;
                    }
                    divLinearLayout10.addSubscription(disposableObserve);
                    if (separator != null) {
                        disposableObserve2 = null;
                    } else {
                        disposableObserve2 = null;
                    }
                    divLinearLayout10.addSubscription(disposableObserve2);
                    if (separator != null) {
                        disposableObserve3 = null;
                    } else {
                        disposableObserve3 = null;
                    }
                    divLinearLayout10.addSubscription(disposableObserve3);
                } else {
                    if (separator != null) {
                        expression6 = separator.showAtEnd;
                    } else {
                        expression6 = null;
                    }
                    if (!ExpressionsKt.isConstantOrNull(expression6)) {
                        Function1<? super Boolean, Unit> function9 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindSeparator$$inlined$bindSeparatorShowMode$1
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
                            public final void invoke2(Object it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                divLinearLayout.setShowDividers(this.toSeparatorMode(separator, expressionResolver));
                            }
                        };
                        DivLinearLayout divLinearLayout11 = divLinearLayout2;
                        if (separator != null) {
                            disposableObserve = null;
                        } else {
                            disposableObserve = null;
                        }
                        divLinearLayout11.addSubscription(disposableObserve);
                        if (separator != null) {
                            disposableObserve2 = null;
                        } else {
                            disposableObserve2 = null;
                        }
                        divLinearLayout11.addSubscription(disposableObserve2);
                        if (separator != null) {
                            disposableObserve3 = null;
                        } else {
                            disposableObserve3 = null;
                        }
                        divLinearLayout11.addSubscription(disposableObserve3);
                    }
                }
            }
        }
        final DivContainer.Separator separator3 = divContainer.separator;
        DivContainer.Separator separator4 = divContainer2 != null ? divContainer2.separator : null;
        if (!DivDataExtensionsKt.equalsToConstant(separator3 != null ? separator3.style : null, separator4 != null ? separator4.style : null)) {
            DivDrawable divDrawable = separator3 != null ? separator3.style : null;
            if (divDrawable != null) {
                DisplayMetrics displayMetrics = divLinearLayout.getResources().getDisplayMetrics();
                Intrinsics.checkNotNullExpressionValue(displayMetrics, "resources.displayMetrics");
                drawable = BaseDivViewExtensionsKt.toDrawable(divDrawable, displayMetrics, expressionResolver);
            } else {
                drawable = null;
            }
            divLinearLayout.setDividerDrawable(drawable);
            if (!DivDataExtensionsKt.isConstant(separator3 != null ? separator3.style : null)) {
                ExpressionSubscribersKt.observeDrawable(divLinearLayout2, separator3 != null ? separator3.style : null, expressionResolver, new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindSeparator$$inlined$bindSeparatorStyle$1
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
                    public final void invoke2(Object it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        DivContainer.Separator separator5 = separator3;
                        Drawable drawable2 = null;
                        DivDrawable divDrawable2 = separator5 != null ? separator5.style : null;
                        DivLinearLayout divLinearLayout12 = divLinearLayout;
                        if (divDrawable2 != null) {
                            DisplayMetrics displayMetrics2 = divLinearLayout12.getResources().getDisplayMetrics();
                            Intrinsics.checkNotNullExpressionValue(displayMetrics2, "resources.displayMetrics");
                            drawable2 = BaseDivViewExtensionsKt.toDrawable(divDrawable2, displayMetrics2, expressionResolver);
                        }
                        divLinearLayout12.setDividerDrawable(drawable2);
                    }
                });
            }
        }
        DivContainer.Separator separator5 = divContainer.separator;
        DivContainer.Separator separator6 = divContainer2 != null ? divContainer2.separator : null;
        if (DivDataExtensionsKt.equalsToConstant(separator5 != null ? separator5.margins : null, separator6 != null ? separator6.margins : null)) {
            return;
        }
        DivEdgeInsets divEdgeInsets = separator5 != null ? separator5.margins : null;
        Resources resources = divLinearLayout.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        Rect rect = toRect(divEdgeInsets, resources, expressionResolver);
        divLinearLayout.setDividerMargins(rect.left, rect.top, rect.right, rect.bottom);
        DivEdgeInsets divEdgeInsets2 = separator5 != null ? separator5.margins : null;
        if (divEdgeInsets2 == null || DivDataExtensionsKt.isConstant(divEdgeInsets2)) {
            return;
        }
        final DivEdgeInsets divEdgeInsets3 = divEdgeInsets2;
        Function1<? super Long, Unit> function10 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindSeparator$$inlined$bindSeparatorMargins$1
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
                DivEdgeInsets divEdgeInsets4 = divEdgeInsets3;
                DivContainerBinder divContainerBinder = this;
                Resources resources2 = divLinearLayout.getResources();
                Intrinsics.checkNotNullExpressionValue(resources2, "resources");
                Rect rect2 = divContainerBinder.toRect(divEdgeInsets4, resources2, expressionResolver);
                divLinearLayout.setDividerMargins(rect2.left, rect2.top, rect2.right, rect2.bottom);
            }
        };
        DivLinearLayout divLinearLayout12 = divLinearLayout2;
        divLinearLayout12.addSubscription(divEdgeInsets2.top.observe(expressionResolver, function10));
        divLinearLayout12.addSubscription(divEdgeInsets2.bottom.observe(expressionResolver, function10));
        if (divEdgeInsets2.start != null || divEdgeInsets2.end != null) {
            Expression<Long> expression7 = divEdgeInsets2.start;
            divLinearLayout12.addSubscription(expression7 != null ? expression7.observe(expressionResolver, function10) : null);
            Expression<Long> expression8 = divEdgeInsets2.end;
            divLinearLayout12.addSubscription(expression8 != null ? expression8.observe(expressionResolver, function10) : null);
            return;
        }
        divLinearLayout12.addSubscription(divEdgeInsets2.left.observe(expressionResolver, function10));
        divLinearLayout12.addSubscription(divEdgeInsets2.right.observe(expressionResolver, function10));
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0059  */
    /* JADX WARN: Code duplicated, block: B:30:0x0081  */
    private final void bindProperties(final DivWrapLayout divWrapLayout, final DivContainer divContainer, DivContainer divContainer2, final ExpressionResolver expressionResolver) {
        DivWrapLayout divWrapLayout2 = divWrapLayout;
        if (!ExpressionsKt.equalsToConstant(divContainer.orientation, divContainer2 != null ? divContainer2.orientation : null)) {
            divWrapLayout.setWrapDirection(toWrapDirection(divContainer.orientation.evaluate(expressionResolver)));
            if (!ExpressionsKt.isConstant(divContainer.orientation)) {
                divWrapLayout2.addSubscription(divContainer.orientation.observe(expressionResolver, new Function1<DivContainer.Orientation, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindProperties$$inlined$bindOrientation$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DivContainer.Orientation orientation) {
                        invoke2(orientation);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DivContainer.Orientation orientation) {
                        Intrinsics.checkNotNullParameter(orientation, "orientation");
                        divWrapLayout.setWrapDirection(this.toWrapDirection(orientation));
                    }
                }));
            }
        }
        if (ExpressionsKt.equalsToConstant(divContainer.contentAlignmentHorizontal, divContainer2 != null ? divContainer2.contentAlignmentHorizontal : null)) {
            if (!ExpressionsKt.equalsToConstant(divContainer.contentAlignmentVertical, divContainer2 != null ? divContainer2.contentAlignmentVertical : null)) {
                divWrapLayout.setGravity(BaseDivViewExtensionsKt.evaluateGravity(divContainer.contentAlignmentHorizontal.evaluate(expressionResolver), divContainer.contentAlignmentVertical.evaluate(expressionResolver)));
                if (ExpressionsKt.isConstant(divContainer.contentAlignmentHorizontal) || !ExpressionsKt.isConstant(divContainer.contentAlignmentVertical)) {
                    Function1<? super DivContentAlignmentHorizontal, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindProperties$$inlined$bindContentAlignment$2
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
                            divWrapLayout.setGravity(BaseDivViewExtensionsKt.evaluateGravity(divContainer.contentAlignmentHorizontal.evaluate(expressionResolver), divContainer.contentAlignmentVertical.evaluate(expressionResolver)));
                        }
                    };
                    DivWrapLayout divWrapLayout3 = divWrapLayout2;
                    divWrapLayout3.addSubscription(divContainer.contentAlignmentHorizontal.observe(expressionResolver, function1));
                    divWrapLayout3.addSubscription(divContainer.contentAlignmentVertical.observe(expressionResolver, function1));
                }
            }
        } else {
            divWrapLayout.setGravity(BaseDivViewExtensionsKt.evaluateGravity(divContainer.contentAlignmentHorizontal.evaluate(expressionResolver), divContainer.contentAlignmentVertical.evaluate(expressionResolver)));
            if (ExpressionsKt.isConstant(divContainer.contentAlignmentHorizontal)) {
                Function1<? super DivContentAlignmentHorizontal, Unit> function2 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindProperties$$inlined$bindContentAlignment$2
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
                        divWrapLayout.setGravity(BaseDivViewExtensionsKt.evaluateGravity(divContainer.contentAlignmentHorizontal.evaluate(expressionResolver), divContainer.contentAlignmentVertical.evaluate(expressionResolver)));
                    }
                };
                DivWrapLayout divWrapLayout4 = divWrapLayout2;
                divWrapLayout4.addSubscription(divContainer.contentAlignmentHorizontal.observe(expressionResolver, function2));
                divWrapLayout4.addSubscription(divContainer.contentAlignmentVertical.observe(expressionResolver, function2));
            } else {
                Function1<? super DivContentAlignmentHorizontal, Unit> function3 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindProperties$$inlined$bindContentAlignment$2
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
                        divWrapLayout.setGravity(BaseDivViewExtensionsKt.evaluateGravity(divContainer.contentAlignmentHorizontal.evaluate(expressionResolver), divContainer.contentAlignmentVertical.evaluate(expressionResolver)));
                    }
                };
                DivWrapLayout divWrapLayout5 = divWrapLayout2;
                divWrapLayout5.addSubscription(divContainer.contentAlignmentHorizontal.observe(expressionResolver, function3));
                divWrapLayout5.addSubscription(divContainer.contentAlignmentVertical.observe(expressionResolver, function3));
            }
        }
        bindSeparator(divWrapLayout, divContainer, divContainer2, expressionResolver);
        bindLineSeparator(divWrapLayout, divContainer, divContainer2, expressionResolver);
    }

    private final <T extends ViewGroup & DivHolderView<DivContainer>> void bindOrientation(T t, DivContainer divContainer, DivContainer divContainer2, ExpressionResolver expressionResolver, final Function1<? super DivContainer.Orientation, Unit> function1) {
        if (ExpressionsKt.equalsToConstant(divContainer.orientation, divContainer2 != null ? divContainer2.orientation : null)) {
            return;
        }
        function1.invoke(divContainer.orientation.evaluate(expressionResolver));
        if (ExpressionsKt.isConstant(divContainer.orientation)) {
            return;
        }
        ((DivHolderView) t).addSubscription(divContainer.orientation.observe(expressionResolver, new Function1<DivContainer.Orientation, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder.bindOrientation.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DivContainer.Orientation orientation) {
                invoke2(orientation);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DivContainer.Orientation orientation) {
                Intrinsics.checkNotNullParameter(orientation, "orientation");
                function1.invoke(orientation);
            }
        }));
    }

    private final <T extends ViewGroup & DivHolderView<DivContainer>> void bindContentAlignment(T t, final DivContainer divContainer, DivContainer divContainer2, final ExpressionResolver expressionResolver, final Function2<? super DivContentAlignmentHorizontal, ? super DivContentAlignmentVertical, Unit> function2) {
        if (ExpressionsKt.equalsToConstant(divContainer.contentAlignmentHorizontal, divContainer2 != null ? divContainer2.contentAlignmentHorizontal : null)) {
            if (ExpressionsKt.equalsToConstant(divContainer.contentAlignmentVertical, divContainer2 != null ? divContainer2.contentAlignmentVertical : null)) {
                return;
            }
        }
        function2.invoke(divContainer.contentAlignmentHorizontal.evaluate(expressionResolver), divContainer.contentAlignmentVertical.evaluate(expressionResolver));
        if (ExpressionsKt.isConstant(divContainer.contentAlignmentHorizontal) && ExpressionsKt.isConstant(divContainer.contentAlignmentVertical)) {
            return;
        }
        Function1<? super DivContentAlignmentHorizontal, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindContentAlignment$callback$1
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
                function2.invoke(divContainer.contentAlignmentHorizontal.evaluate(expressionResolver), divContainer.contentAlignmentVertical.evaluate(expressionResolver));
            }
        };
        DivHolderView divHolderView = (DivHolderView) t;
        divHolderView.addSubscription(divContainer.contentAlignmentHorizontal.observe(expressionResolver, function1));
        divHolderView.addSubscription(divContainer.contentAlignmentVertical.observe(expressionResolver, function1));
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0044  */
    /* JADX WARN: Code duplicated, block: B:33:0x004d  */
    /* JADX WARN: Code duplicated, block: B:34:0x0050  */
    /* JADX WARN: Code duplicated, block: B:37:0x0057 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:38:0x0059  */
    /* JADX WARN: Code duplicated, block: B:39:0x005c  */
    /* JADX WARN: Code duplicated, block: B:42:0x0063 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:43:0x0065  */
    /* JADX WARN: Code duplicated, block: B:44:0x0068  */
    /* JADX WARN: Code duplicated, block: B:48:0x0070  */
    /* JADX WARN: Code duplicated, block: B:50:0x0082  */
    /* JADX WARN: Code duplicated, block: B:53:0x008b  */
    /* JADX WARN: Code duplicated, block: B:56:0x0091  */
    /* JADX WARN: Code duplicated, block: B:59:0x009a  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:65:0x00a9  */
    private final void bindSeparator(final DivWrapLayout divWrapLayout, DivContainer divContainer, DivContainer divContainer2, final ExpressionResolver expressionResolver) {
        Expression<Boolean> expression;
        Disposable disposableObserve;
        Disposable disposableObserve2;
        Disposable disposableObserve3;
        Expression<Boolean> expression2;
        Expression<Boolean> expression3;
        Expression<Boolean> expression4;
        Expression<Boolean> expression5;
        Expression<Boolean> expression6;
        Drawable drawable;
        DivWrapLayout divWrapLayout2 = divWrapLayout;
        final DivContainer.Separator separator = divContainer.separator;
        DivContainer.Separator separator2 = divContainer2 != null ? divContainer2.separator : null;
        if (ExpressionsKt.equalsToConstant(separator != null ? separator.showAtStart : null, separator2 != null ? separator2.showAtStart : null)) {
            if (ExpressionsKt.equalsToConstant(separator != null ? separator.showBetween : null, separator2 != null ? separator2.showBetween : null)) {
                if (!ExpressionsKt.equalsToConstant(separator != null ? separator.showAtEnd : null, separator2 != null ? separator2.showAtEnd : null)) {
                    divWrapLayout.setShowSeparators(toSeparatorMode(separator, expressionResolver));
                    if (separator != null) {
                        expression = separator.showAtStart;
                    } else {
                        expression = null;
                    }
                    if (ExpressionsKt.isConstantOrNull(expression)) {
                        if (separator != null) {
                            expression5 = separator.showBetween;
                        } else {
                            expression5 = null;
                        }
                        if (ExpressionsKt.isConstantOrNull(expression5)) {
                            if (separator != null) {
                                expression6 = separator.showAtEnd;
                            } else {
                                expression6 = null;
                            }
                            if (!ExpressionsKt.isConstantOrNull(expression6)) {
                                Function1<? super Boolean, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindSeparator$$inlined$bindSeparatorShowMode$2
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
                                    public final void invoke2(Object it) {
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        divWrapLayout.setShowSeparators(this.toSeparatorMode(separator, expressionResolver));
                                    }
                                };
                                DivWrapLayout divWrapLayout3 = divWrapLayout2;
                                if (separator != null) {
                                    disposableObserve = null;
                                } else {
                                    disposableObserve = null;
                                }
                                divWrapLayout3.addSubscription(disposableObserve);
                                if (separator != null) {
                                    disposableObserve2 = null;
                                } else {
                                    disposableObserve2 = null;
                                }
                                divWrapLayout3.addSubscription(disposableObserve2);
                                if (separator != null) {
                                    disposableObserve3 = null;
                                } else {
                                    disposableObserve3 = null;
                                }
                                divWrapLayout3.addSubscription(disposableObserve3);
                            }
                        } else {
                            Function1<? super Boolean, Unit> function2 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindSeparator$$inlined$bindSeparatorShowMode$2
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
                                public final void invoke2(Object it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    divWrapLayout.setShowSeparators(this.toSeparatorMode(separator, expressionResolver));
                                }
                            };
                            DivWrapLayout divWrapLayout4 = divWrapLayout2;
                            if (separator != null) {
                                disposableObserve = null;
                            } else {
                                disposableObserve = null;
                            }
                            divWrapLayout4.addSubscription(disposableObserve);
                            if (separator != null) {
                                disposableObserve2 = null;
                            } else {
                                disposableObserve2 = null;
                            }
                            divWrapLayout4.addSubscription(disposableObserve2);
                            if (separator != null) {
                                disposableObserve3 = null;
                            } else {
                                disposableObserve3 = null;
                            }
                            divWrapLayout4.addSubscription(disposableObserve3);
                        }
                    } else {
                        Function1<? super Boolean, Unit> function3 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindSeparator$$inlined$bindSeparatorShowMode$2
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
                            public final void invoke2(Object it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                divWrapLayout.setShowSeparators(this.toSeparatorMode(separator, expressionResolver));
                            }
                        };
                        DivWrapLayout divWrapLayout5 = divWrapLayout2;
                        if (separator != null) {
                            disposableObserve = null;
                        } else {
                            disposableObserve = null;
                        }
                        divWrapLayout5.addSubscription(disposableObserve);
                        if (separator != null) {
                            disposableObserve2 = null;
                        } else {
                            disposableObserve2 = null;
                        }
                        divWrapLayout5.addSubscription(disposableObserve2);
                        if (separator != null) {
                            disposableObserve3 = null;
                        } else {
                            disposableObserve3 = null;
                        }
                        divWrapLayout5.addSubscription(disposableObserve3);
                    }
                }
            } else {
                divWrapLayout.setShowSeparators(toSeparatorMode(separator, expressionResolver));
                if (separator != null) {
                    expression = separator.showAtStart;
                } else {
                    expression = null;
                }
                if (ExpressionsKt.isConstantOrNull(expression)) {
                    Function1<? super Boolean, Unit> function4 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindSeparator$$inlined$bindSeparatorShowMode$2
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
                        public final void invoke2(Object it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            divWrapLayout.setShowSeparators(this.toSeparatorMode(separator, expressionResolver));
                        }
                    };
                    DivWrapLayout divWrapLayout6 = divWrapLayout2;
                    if (separator != null) {
                        disposableObserve = null;
                    } else {
                        disposableObserve = null;
                    }
                    divWrapLayout6.addSubscription(disposableObserve);
                    if (separator != null) {
                        disposableObserve2 = null;
                    } else {
                        disposableObserve2 = null;
                    }
                    divWrapLayout6.addSubscription(disposableObserve2);
                    if (separator != null) {
                        disposableObserve3 = null;
                    } else {
                        disposableObserve3 = null;
                    }
                    divWrapLayout6.addSubscription(disposableObserve3);
                } else {
                    if (separator != null) {
                        expression5 = separator.showBetween;
                    } else {
                        expression5 = null;
                    }
                    if (ExpressionsKt.isConstantOrNull(expression5)) {
                        Function1<? super Boolean, Unit> function5 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindSeparator$$inlined$bindSeparatorShowMode$2
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
                            public final void invoke2(Object it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                divWrapLayout.setShowSeparators(this.toSeparatorMode(separator, expressionResolver));
                            }
                        };
                        DivWrapLayout divWrapLayout7 = divWrapLayout2;
                        if (separator != null) {
                            disposableObserve = null;
                        } else {
                            disposableObserve = null;
                        }
                        divWrapLayout7.addSubscription(disposableObserve);
                        if (separator != null) {
                            disposableObserve2 = null;
                        } else {
                            disposableObserve2 = null;
                        }
                        divWrapLayout7.addSubscription(disposableObserve2);
                        if (separator != null) {
                            disposableObserve3 = null;
                        } else {
                            disposableObserve3 = null;
                        }
                        divWrapLayout7.addSubscription(disposableObserve3);
                    } else {
                        if (separator != null) {
                            expression6 = separator.showAtEnd;
                        } else {
                            expression6 = null;
                        }
                        if (!ExpressionsKt.isConstantOrNull(expression6)) {
                            Function1<? super Boolean, Unit> function6 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindSeparator$$inlined$bindSeparatorShowMode$2
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
                                public final void invoke2(Object it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    divWrapLayout.setShowSeparators(this.toSeparatorMode(separator, expressionResolver));
                                }
                            };
                            DivWrapLayout divWrapLayout8 = divWrapLayout2;
                            if (separator != null) {
                                disposableObserve = null;
                            } else {
                                disposableObserve = null;
                            }
                            divWrapLayout8.addSubscription(disposableObserve);
                            if (separator != null) {
                                disposableObserve2 = null;
                            } else {
                                disposableObserve2 = null;
                            }
                            divWrapLayout8.addSubscription(disposableObserve2);
                            if (separator != null) {
                                disposableObserve3 = null;
                            } else {
                                disposableObserve3 = null;
                            }
                            divWrapLayout8.addSubscription(disposableObserve3);
                        }
                    }
                }
            }
        } else {
            divWrapLayout.setShowSeparators(toSeparatorMode(separator, expressionResolver));
            if (separator != null) {
                expression = separator.showAtStart;
            } else {
                expression = null;
            }
            if (ExpressionsKt.isConstantOrNull(expression)) {
                Function1<? super Boolean, Unit> function7 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindSeparator$$inlined$bindSeparatorShowMode$2
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
                    public final void invoke2(Object it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        divWrapLayout.setShowSeparators(this.toSeparatorMode(separator, expressionResolver));
                    }
                };
                DivWrapLayout divWrapLayout9 = divWrapLayout2;
                if (separator != null || (expression4 = separator.showAtStart) == null) {
                    disposableObserve = null;
                } else {
                    disposableObserve = expression4.observe(expressionResolver, function7);
                }
                divWrapLayout9.addSubscription(disposableObserve);
                if (separator != null || (expression3 = separator.showBetween) == null) {
                    disposableObserve2 = null;
                } else {
                    disposableObserve2 = expression3.observe(expressionResolver, function7);
                }
                divWrapLayout9.addSubscription(disposableObserve2);
                if (separator != null || (expression2 = separator.showAtEnd) == null) {
                    disposableObserve3 = null;
                } else {
                    disposableObserve3 = expression2.observe(expressionResolver, function7);
                }
                divWrapLayout9.addSubscription(disposableObserve3);
            } else {
                if (separator != null) {
                    expression5 = separator.showBetween;
                } else {
                    expression5 = null;
                }
                if (ExpressionsKt.isConstantOrNull(expression5)) {
                    Function1<? super Boolean, Unit> function8 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindSeparator$$inlined$bindSeparatorShowMode$2
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
                        public final void invoke2(Object it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            divWrapLayout.setShowSeparators(this.toSeparatorMode(separator, expressionResolver));
                        }
                    };
                    DivWrapLayout divWrapLayout10 = divWrapLayout2;
                    if (separator != null) {
                        disposableObserve = null;
                    } else {
                        disposableObserve = null;
                    }
                    divWrapLayout10.addSubscription(disposableObserve);
                    if (separator != null) {
                        disposableObserve2 = null;
                    } else {
                        disposableObserve2 = null;
                    }
                    divWrapLayout10.addSubscription(disposableObserve2);
                    if (separator != null) {
                        disposableObserve3 = null;
                    } else {
                        disposableObserve3 = null;
                    }
                    divWrapLayout10.addSubscription(disposableObserve3);
                } else {
                    if (separator != null) {
                        expression6 = separator.showAtEnd;
                    } else {
                        expression6 = null;
                    }
                    if (!ExpressionsKt.isConstantOrNull(expression6)) {
                        Function1<? super Boolean, Unit> function9 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindSeparator$$inlined$bindSeparatorShowMode$2
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
                            public final void invoke2(Object it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                divWrapLayout.setShowSeparators(this.toSeparatorMode(separator, expressionResolver));
                            }
                        };
                        DivWrapLayout divWrapLayout11 = divWrapLayout2;
                        if (separator != null) {
                            disposableObserve = null;
                        } else {
                            disposableObserve = null;
                        }
                        divWrapLayout11.addSubscription(disposableObserve);
                        if (separator != null) {
                            disposableObserve2 = null;
                        } else {
                            disposableObserve2 = null;
                        }
                        divWrapLayout11.addSubscription(disposableObserve2);
                        if (separator != null) {
                            disposableObserve3 = null;
                        } else {
                            disposableObserve3 = null;
                        }
                        divWrapLayout11.addSubscription(disposableObserve3);
                    }
                }
            }
        }
        final DivContainer.Separator separator3 = divContainer.separator;
        DivContainer.Separator separator4 = divContainer2 != null ? divContainer2.separator : null;
        if (!DivDataExtensionsKt.equalsToConstant(separator3 != null ? separator3.style : null, separator4 != null ? separator4.style : null)) {
            DivDrawable divDrawable = separator3 != null ? separator3.style : null;
            if (divDrawable != null) {
                DisplayMetrics displayMetrics = divWrapLayout.getResources().getDisplayMetrics();
                Intrinsics.checkNotNullExpressionValue(displayMetrics, "resources.displayMetrics");
                drawable = BaseDivViewExtensionsKt.toDrawable(divDrawable, displayMetrics, expressionResolver);
            } else {
                drawable = null;
            }
            divWrapLayout.setSeparatorDrawable(drawable);
            if (!DivDataExtensionsKt.isConstant(separator3 != null ? separator3.style : null)) {
                ExpressionSubscribersKt.observeDrawable(divWrapLayout2, separator3 != null ? separator3.style : null, expressionResolver, new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindSeparator$$inlined$bindSeparatorStyle$2
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
                    public final void invoke2(Object it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        DivContainer.Separator separator5 = separator3;
                        Drawable drawable2 = null;
                        DivDrawable divDrawable2 = separator5 != null ? separator5.style : null;
                        DivWrapLayout divWrapLayout12 = divWrapLayout;
                        if (divDrawable2 != null) {
                            DisplayMetrics displayMetrics2 = divWrapLayout12.getResources().getDisplayMetrics();
                            Intrinsics.checkNotNullExpressionValue(displayMetrics2, "resources.displayMetrics");
                            drawable2 = BaseDivViewExtensionsKt.toDrawable(divDrawable2, displayMetrics2, expressionResolver);
                        }
                        divWrapLayout12.setSeparatorDrawable(drawable2);
                    }
                });
            }
        }
        DivContainer.Separator separator5 = divContainer.separator;
        DivContainer.Separator separator6 = divContainer2 != null ? divContainer2.separator : null;
        if (DivDataExtensionsKt.equalsToConstant(separator5 != null ? separator5.margins : null, separator6 != null ? separator6.margins : null)) {
            return;
        }
        DivEdgeInsets divEdgeInsets = separator5 != null ? separator5.margins : null;
        Resources resources = divWrapLayout.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        Rect rect = toRect(divEdgeInsets, resources, expressionResolver);
        divWrapLayout.setSeparatorMargins(rect.left, rect.top, rect.right, rect.bottom);
        DivEdgeInsets divEdgeInsets2 = separator5 != null ? separator5.margins : null;
        if (divEdgeInsets2 == null || DivDataExtensionsKt.isConstant(divEdgeInsets2)) {
            return;
        }
        final DivEdgeInsets divEdgeInsets3 = divEdgeInsets2;
        Function1<? super Long, Unit> function10 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindSeparator$$inlined$bindSeparatorMargins$2
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
                DivEdgeInsets divEdgeInsets4 = divEdgeInsets3;
                DivContainerBinder divContainerBinder = this;
                Resources resources2 = divWrapLayout.getResources();
                Intrinsics.checkNotNullExpressionValue(resources2, "resources");
                Rect rect2 = divContainerBinder.toRect(divEdgeInsets4, resources2, expressionResolver);
                divWrapLayout.setSeparatorMargins(rect2.left, rect2.top, rect2.right, rect2.bottom);
            }
        };
        DivWrapLayout divWrapLayout12 = divWrapLayout2;
        divWrapLayout12.addSubscription(divEdgeInsets2.top.observe(expressionResolver, function10));
        divWrapLayout12.addSubscription(divEdgeInsets2.bottom.observe(expressionResolver, function10));
        if (divEdgeInsets2.start != null || divEdgeInsets2.end != null) {
            Expression<Long> expression7 = divEdgeInsets2.start;
            divWrapLayout12.addSubscription(expression7 != null ? expression7.observe(expressionResolver, function10) : null);
            Expression<Long> expression8 = divEdgeInsets2.end;
            divWrapLayout12.addSubscription(expression8 != null ? expression8.observe(expressionResolver, function10) : null);
            return;
        }
        divWrapLayout12.addSubscription(divEdgeInsets2.left.observe(expressionResolver, function10));
        divWrapLayout12.addSubscription(divEdgeInsets2.right.observe(expressionResolver, function10));
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0044  */
    /* JADX WARN: Code duplicated, block: B:33:0x004d  */
    /* JADX WARN: Code duplicated, block: B:34:0x0050  */
    /* JADX WARN: Code duplicated, block: B:37:0x0057 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:38:0x0059  */
    /* JADX WARN: Code duplicated, block: B:39:0x005c  */
    /* JADX WARN: Code duplicated, block: B:42:0x0063 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:43:0x0065  */
    /* JADX WARN: Code duplicated, block: B:44:0x0068  */
    /* JADX WARN: Code duplicated, block: B:48:0x0070  */
    /* JADX WARN: Code duplicated, block: B:50:0x0082  */
    /* JADX WARN: Code duplicated, block: B:53:0x008b  */
    /* JADX WARN: Code duplicated, block: B:56:0x0091  */
    /* JADX WARN: Code duplicated, block: B:59:0x009a  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:65:0x00a9  */
    private final void bindLineSeparator(final DivWrapLayout divWrapLayout, DivContainer divContainer, DivContainer divContainer2, final ExpressionResolver expressionResolver) {
        Expression<Boolean> expression;
        Disposable disposableObserve;
        Disposable disposableObserve2;
        Disposable disposableObserve3;
        Expression<Boolean> expression2;
        Expression<Boolean> expression3;
        Expression<Boolean> expression4;
        Expression<Boolean> expression5;
        Expression<Boolean> expression6;
        Drawable drawable;
        DivWrapLayout divWrapLayout2 = divWrapLayout;
        final DivContainer.Separator separator = divContainer.lineSeparator;
        DivContainer.Separator separator2 = divContainer2 != null ? divContainer2.lineSeparator : null;
        if (ExpressionsKt.equalsToConstant(separator != null ? separator.showAtStart : null, separator2 != null ? separator2.showAtStart : null)) {
            if (ExpressionsKt.equalsToConstant(separator != null ? separator.showBetween : null, separator2 != null ? separator2.showBetween : null)) {
                if (!ExpressionsKt.equalsToConstant(separator != null ? separator.showAtEnd : null, separator2 != null ? separator2.showAtEnd : null)) {
                    divWrapLayout.setShowLineSeparators(toSeparatorMode(separator, expressionResolver));
                    if (separator != null) {
                        expression = separator.showAtStart;
                    } else {
                        expression = null;
                    }
                    if (ExpressionsKt.isConstantOrNull(expression)) {
                        if (separator != null) {
                            expression5 = separator.showBetween;
                        } else {
                            expression5 = null;
                        }
                        if (ExpressionsKt.isConstantOrNull(expression5)) {
                            if (separator != null) {
                                expression6 = separator.showAtEnd;
                            } else {
                                expression6 = null;
                            }
                            if (!ExpressionsKt.isConstantOrNull(expression6)) {
                                Function1<? super Boolean, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindLineSeparator$$inlined$bindSeparatorShowMode$1
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
                                    public final void invoke2(Object it) {
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        divWrapLayout.setShowLineSeparators(this.toSeparatorMode(separator, expressionResolver));
                                    }
                                };
                                DivWrapLayout divWrapLayout3 = divWrapLayout2;
                                if (separator != null) {
                                    disposableObserve = null;
                                } else {
                                    disposableObserve = null;
                                }
                                divWrapLayout3.addSubscription(disposableObserve);
                                if (separator != null) {
                                    disposableObserve2 = null;
                                } else {
                                    disposableObserve2 = null;
                                }
                                divWrapLayout3.addSubscription(disposableObserve2);
                                if (separator != null) {
                                    disposableObserve3 = null;
                                } else {
                                    disposableObserve3 = null;
                                }
                                divWrapLayout3.addSubscription(disposableObserve3);
                            }
                        } else {
                            Function1<? super Boolean, Unit> function2 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindLineSeparator$$inlined$bindSeparatorShowMode$1
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
                                public final void invoke2(Object it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    divWrapLayout.setShowLineSeparators(this.toSeparatorMode(separator, expressionResolver));
                                }
                            };
                            DivWrapLayout divWrapLayout4 = divWrapLayout2;
                            if (separator != null) {
                                disposableObserve = null;
                            } else {
                                disposableObserve = null;
                            }
                            divWrapLayout4.addSubscription(disposableObserve);
                            if (separator != null) {
                                disposableObserve2 = null;
                            } else {
                                disposableObserve2 = null;
                            }
                            divWrapLayout4.addSubscription(disposableObserve2);
                            if (separator != null) {
                                disposableObserve3 = null;
                            } else {
                                disposableObserve3 = null;
                            }
                            divWrapLayout4.addSubscription(disposableObserve3);
                        }
                    } else {
                        Function1<? super Boolean, Unit> function3 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindLineSeparator$$inlined$bindSeparatorShowMode$1
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
                            public final void invoke2(Object it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                divWrapLayout.setShowLineSeparators(this.toSeparatorMode(separator, expressionResolver));
                            }
                        };
                        DivWrapLayout divWrapLayout5 = divWrapLayout2;
                        if (separator != null) {
                            disposableObserve = null;
                        } else {
                            disposableObserve = null;
                        }
                        divWrapLayout5.addSubscription(disposableObserve);
                        if (separator != null) {
                            disposableObserve2 = null;
                        } else {
                            disposableObserve2 = null;
                        }
                        divWrapLayout5.addSubscription(disposableObserve2);
                        if (separator != null) {
                            disposableObserve3 = null;
                        } else {
                            disposableObserve3 = null;
                        }
                        divWrapLayout5.addSubscription(disposableObserve3);
                    }
                }
            } else {
                divWrapLayout.setShowLineSeparators(toSeparatorMode(separator, expressionResolver));
                if (separator != null) {
                    expression = separator.showAtStart;
                } else {
                    expression = null;
                }
                if (ExpressionsKt.isConstantOrNull(expression)) {
                    Function1<? super Boolean, Unit> function4 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindLineSeparator$$inlined$bindSeparatorShowMode$1
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
                        public final void invoke2(Object it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            divWrapLayout.setShowLineSeparators(this.toSeparatorMode(separator, expressionResolver));
                        }
                    };
                    DivWrapLayout divWrapLayout6 = divWrapLayout2;
                    if (separator != null) {
                        disposableObserve = null;
                    } else {
                        disposableObserve = null;
                    }
                    divWrapLayout6.addSubscription(disposableObserve);
                    if (separator != null) {
                        disposableObserve2 = null;
                    } else {
                        disposableObserve2 = null;
                    }
                    divWrapLayout6.addSubscription(disposableObserve2);
                    if (separator != null) {
                        disposableObserve3 = null;
                    } else {
                        disposableObserve3 = null;
                    }
                    divWrapLayout6.addSubscription(disposableObserve3);
                } else {
                    if (separator != null) {
                        expression5 = separator.showBetween;
                    } else {
                        expression5 = null;
                    }
                    if (ExpressionsKt.isConstantOrNull(expression5)) {
                        Function1<? super Boolean, Unit> function5 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindLineSeparator$$inlined$bindSeparatorShowMode$1
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
                            public final void invoke2(Object it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                divWrapLayout.setShowLineSeparators(this.toSeparatorMode(separator, expressionResolver));
                            }
                        };
                        DivWrapLayout divWrapLayout7 = divWrapLayout2;
                        if (separator != null) {
                            disposableObserve = null;
                        } else {
                            disposableObserve = null;
                        }
                        divWrapLayout7.addSubscription(disposableObserve);
                        if (separator != null) {
                            disposableObserve2 = null;
                        } else {
                            disposableObserve2 = null;
                        }
                        divWrapLayout7.addSubscription(disposableObserve2);
                        if (separator != null) {
                            disposableObserve3 = null;
                        } else {
                            disposableObserve3 = null;
                        }
                        divWrapLayout7.addSubscription(disposableObserve3);
                    } else {
                        if (separator != null) {
                            expression6 = separator.showAtEnd;
                        } else {
                            expression6 = null;
                        }
                        if (!ExpressionsKt.isConstantOrNull(expression6)) {
                            Function1<? super Boolean, Unit> function6 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindLineSeparator$$inlined$bindSeparatorShowMode$1
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
                                public final void invoke2(Object it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    divWrapLayout.setShowLineSeparators(this.toSeparatorMode(separator, expressionResolver));
                                }
                            };
                            DivWrapLayout divWrapLayout8 = divWrapLayout2;
                            if (separator != null) {
                                disposableObserve = null;
                            } else {
                                disposableObserve = null;
                            }
                            divWrapLayout8.addSubscription(disposableObserve);
                            if (separator != null) {
                                disposableObserve2 = null;
                            } else {
                                disposableObserve2 = null;
                            }
                            divWrapLayout8.addSubscription(disposableObserve2);
                            if (separator != null) {
                                disposableObserve3 = null;
                            } else {
                                disposableObserve3 = null;
                            }
                            divWrapLayout8.addSubscription(disposableObserve3);
                        }
                    }
                }
            }
        } else {
            divWrapLayout.setShowLineSeparators(toSeparatorMode(separator, expressionResolver));
            if (separator != null) {
                expression = separator.showAtStart;
            } else {
                expression = null;
            }
            if (ExpressionsKt.isConstantOrNull(expression)) {
                Function1<? super Boolean, Unit> function7 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindLineSeparator$$inlined$bindSeparatorShowMode$1
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
                    public final void invoke2(Object it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        divWrapLayout.setShowLineSeparators(this.toSeparatorMode(separator, expressionResolver));
                    }
                };
                DivWrapLayout divWrapLayout9 = divWrapLayout2;
                if (separator != null || (expression4 = separator.showAtStart) == null) {
                    disposableObserve = null;
                } else {
                    disposableObserve = expression4.observe(expressionResolver, function7);
                }
                divWrapLayout9.addSubscription(disposableObserve);
                if (separator != null || (expression3 = separator.showBetween) == null) {
                    disposableObserve2 = null;
                } else {
                    disposableObserve2 = expression3.observe(expressionResolver, function7);
                }
                divWrapLayout9.addSubscription(disposableObserve2);
                if (separator != null || (expression2 = separator.showAtEnd) == null) {
                    disposableObserve3 = null;
                } else {
                    disposableObserve3 = expression2.observe(expressionResolver, function7);
                }
                divWrapLayout9.addSubscription(disposableObserve3);
            } else {
                if (separator != null) {
                    expression5 = separator.showBetween;
                } else {
                    expression5 = null;
                }
                if (ExpressionsKt.isConstantOrNull(expression5)) {
                    Function1<? super Boolean, Unit> function8 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindLineSeparator$$inlined$bindSeparatorShowMode$1
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
                        public final void invoke2(Object it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            divWrapLayout.setShowLineSeparators(this.toSeparatorMode(separator, expressionResolver));
                        }
                    };
                    DivWrapLayout divWrapLayout10 = divWrapLayout2;
                    if (separator != null) {
                        disposableObserve = null;
                    } else {
                        disposableObserve = null;
                    }
                    divWrapLayout10.addSubscription(disposableObserve);
                    if (separator != null) {
                        disposableObserve2 = null;
                    } else {
                        disposableObserve2 = null;
                    }
                    divWrapLayout10.addSubscription(disposableObserve2);
                    if (separator != null) {
                        disposableObserve3 = null;
                    } else {
                        disposableObserve3 = null;
                    }
                    divWrapLayout10.addSubscription(disposableObserve3);
                } else {
                    if (separator != null) {
                        expression6 = separator.showAtEnd;
                    } else {
                        expression6 = null;
                    }
                    if (!ExpressionsKt.isConstantOrNull(expression6)) {
                        Function1<? super Boolean, Unit> function9 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindLineSeparator$$inlined$bindSeparatorShowMode$1
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
                            public final void invoke2(Object it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                divWrapLayout.setShowLineSeparators(this.toSeparatorMode(separator, expressionResolver));
                            }
                        };
                        DivWrapLayout divWrapLayout11 = divWrapLayout2;
                        if (separator != null) {
                            disposableObserve = null;
                        } else {
                            disposableObserve = null;
                        }
                        divWrapLayout11.addSubscription(disposableObserve);
                        if (separator != null) {
                            disposableObserve2 = null;
                        } else {
                            disposableObserve2 = null;
                        }
                        divWrapLayout11.addSubscription(disposableObserve2);
                        if (separator != null) {
                            disposableObserve3 = null;
                        } else {
                            disposableObserve3 = null;
                        }
                        divWrapLayout11.addSubscription(disposableObserve3);
                    }
                }
            }
        }
        final DivContainer.Separator separator3 = divContainer.lineSeparator;
        DivContainer.Separator separator4 = divContainer2 != null ? divContainer2.lineSeparator : null;
        if (!DivDataExtensionsKt.equalsToConstant(separator3 != null ? separator3.style : null, separator4 != null ? separator4.style : null)) {
            DivDrawable divDrawable = separator3 != null ? separator3.style : null;
            if (divDrawable != null) {
                DisplayMetrics displayMetrics = divWrapLayout.getResources().getDisplayMetrics();
                Intrinsics.checkNotNullExpressionValue(displayMetrics, "resources.displayMetrics");
                drawable = BaseDivViewExtensionsKt.toDrawable(divDrawable, displayMetrics, expressionResolver);
            } else {
                drawable = null;
            }
            divWrapLayout.setLineSeparatorDrawable(drawable);
            if (!DivDataExtensionsKt.isConstant(separator3 != null ? separator3.style : null)) {
                ExpressionSubscribersKt.observeDrawable(divWrapLayout2, separator3 != null ? separator3.style : null, expressionResolver, new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindLineSeparator$$inlined$bindSeparatorStyle$1
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
                    public final void invoke2(Object it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        DivContainer.Separator separator5 = separator3;
                        Drawable drawable2 = null;
                        DivDrawable divDrawable2 = separator5 != null ? separator5.style : null;
                        DivWrapLayout divWrapLayout12 = divWrapLayout;
                        if (divDrawable2 != null) {
                            DisplayMetrics displayMetrics2 = divWrapLayout12.getResources().getDisplayMetrics();
                            Intrinsics.checkNotNullExpressionValue(displayMetrics2, "resources.displayMetrics");
                            drawable2 = BaseDivViewExtensionsKt.toDrawable(divDrawable2, displayMetrics2, expressionResolver);
                        }
                        divWrapLayout12.setLineSeparatorDrawable(drawable2);
                    }
                });
            }
        }
        DivContainer.Separator separator5 = divContainer.lineSeparator;
        DivContainer.Separator separator6 = divContainer2 != null ? divContainer2.lineSeparator : null;
        if (DivDataExtensionsKt.equalsToConstant(separator5 != null ? separator5.margins : null, separator6 != null ? separator6.margins : null)) {
            return;
        }
        DivEdgeInsets divEdgeInsets = separator5 != null ? separator5.margins : null;
        Resources resources = divWrapLayout.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        Rect rect = toRect(divEdgeInsets, resources, expressionResolver);
        divWrapLayout.setLineSeparatorMargins(rect.left, rect.top, rect.right, rect.bottom);
        DivEdgeInsets divEdgeInsets2 = separator5 != null ? separator5.margins : null;
        if (divEdgeInsets2 == null || DivDataExtensionsKt.isConstant(divEdgeInsets2)) {
            return;
        }
        final DivEdgeInsets divEdgeInsets3 = divEdgeInsets2;
        Function1<? super Long, Unit> function10 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindLineSeparator$$inlined$bindSeparatorMargins$1
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
                DivEdgeInsets divEdgeInsets4 = divEdgeInsets3;
                DivContainerBinder divContainerBinder = this;
                Resources resources2 = divWrapLayout.getResources();
                Intrinsics.checkNotNullExpressionValue(resources2, "resources");
                Rect rect2 = divContainerBinder.toRect(divEdgeInsets4, resources2, expressionResolver);
                divWrapLayout.setLineSeparatorMargins(rect2.left, rect2.top, rect2.right, rect2.bottom);
            }
        };
        DivWrapLayout divWrapLayout12 = divWrapLayout2;
        divWrapLayout12.addSubscription(divEdgeInsets2.top.observe(expressionResolver, function10));
        divWrapLayout12.addSubscription(divEdgeInsets2.bottom.observe(expressionResolver, function10));
        if (divEdgeInsets2.start != null || divEdgeInsets2.end != null) {
            Expression<Long> expression7 = divEdgeInsets2.start;
            divWrapLayout12.addSubscription(expression7 != null ? expression7.observe(expressionResolver, function10) : null);
            Expression<Long> expression8 = divEdgeInsets2.end;
            divWrapLayout12.addSubscription(expression8 != null ? expression8.observe(expressionResolver, function10) : null);
            return;
        }
        divWrapLayout12.addSubscription(divEdgeInsets2.left.observe(expressionResolver, function10));
        divWrapLayout12.addSubscription(divEdgeInsets2.right.observe(expressionResolver, function10));
    }

    private final <T extends ViewGroup & DivHolderView<DivContainer>> void bindSeparatorShowMode(T t, final DivContainer.Separator separator, DivContainer.Separator separator2, final ExpressionResolver expressionResolver, final Function2<? super DivContainer.Separator, ? super ExpressionResolver, Unit> function2) {
        Expression<Boolean> expression;
        Expression<Boolean> expression2;
        Expression<Boolean> expression3;
        Disposable disposableObserve = null;
        if (ExpressionsKt.equalsToConstant(separator != null ? separator.showAtStart : null, separator2 != null ? separator2.showAtStart : null)) {
            if (ExpressionsKt.equalsToConstant(separator != null ? separator.showBetween : null, separator2 != null ? separator2.showBetween : null)) {
                if (ExpressionsKt.equalsToConstant(separator != null ? separator.showAtEnd : null, separator2 != null ? separator2.showAtEnd : null)) {
                    return;
                }
            }
        }
        function2.invoke(separator, expressionResolver);
        if (ExpressionsKt.isConstantOrNull(separator != null ? separator.showAtStart : null)) {
            if (ExpressionsKt.isConstantOrNull(separator != null ? separator.showBetween : null)) {
                if (ExpressionsKt.isConstantOrNull(separator != null ? separator.showAtEnd : null)) {
                    return;
                }
            }
        }
        Function1<? super Boolean, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindSeparatorShowMode$callback$1
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
            public final void invoke2(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                function2.invoke(separator, expressionResolver);
            }
        };
        DivHolderView divHolderView = (DivHolderView) t;
        divHolderView.addSubscription((separator == null || (expression3 = separator.showAtStart) == null) ? null : expression3.observe(expressionResolver, function1));
        divHolderView.addSubscription((separator == null || (expression2 = separator.showBetween) == null) ? null : expression2.observe(expressionResolver, function1));
        if (separator != null && (expression = separator.showAtEnd) != null) {
            disposableObserve = expression.observe(expressionResolver, function1);
        }
        divHolderView.addSubscription(disposableObserve);
    }

    private final <T extends ViewGroup & DivHolderView<DivContainer>> void bindSeparatorStyle(T t, final DivContainer.Separator separator, DivContainer.Separator separator2, final ExpressionResolver expressionResolver, final Function2<? super DivDrawable, ? super ExpressionResolver, Unit> function2) {
        if (DivDataExtensionsKt.equalsToConstant(separator != null ? separator.style : null, separator2 != null ? separator2.style : null)) {
            return;
        }
        function2.invoke(separator != null ? separator.style : null, expressionResolver);
        if (DivDataExtensionsKt.isConstant(separator != null ? separator.style : null)) {
            return;
        }
        ExpressionSubscribersKt.observeDrawable((ExpressionSubscriber) t, separator != null ? separator.style : null, expressionResolver, new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindSeparatorStyle$callback$1
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
            public final void invoke2(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Function2<DivDrawable, ExpressionResolver, Unit> function3 = function2;
                DivContainer.Separator separator3 = separator;
                function3.invoke(separator3 != null ? separator3.style : null, expressionResolver);
            }
        });
    }

    private final <T extends ViewGroup & DivHolderView<DivContainer>> void bindSeparatorMargins(T t, DivContainer.Separator separator, DivContainer.Separator separator2, final ExpressionResolver expressionResolver, final Function2<? super DivEdgeInsets, ? super ExpressionResolver, Unit> function2) {
        if (DivDataExtensionsKt.equalsToConstant(separator != null ? separator.margins : null, separator2 != null ? separator2.margins : null)) {
            return;
        }
        function2.invoke(separator != null ? separator.margins : null, expressionResolver);
        final DivEdgeInsets divEdgeInsets = separator != null ? separator.margins : null;
        if (divEdgeInsets == null || DivDataExtensionsKt.isConstant(divEdgeInsets)) {
            return;
        }
        Function1<? super Long, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindSeparatorMargins$callback$1
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
                function2.invoke(divEdgeInsets, expressionResolver);
            }
        };
        DivHolderView divHolderView = (DivHolderView) t;
        divHolderView.addSubscription(divEdgeInsets.top.observe(expressionResolver, function1));
        divHolderView.addSubscription(divEdgeInsets.bottom.observe(expressionResolver, function1));
        if (divEdgeInsets.start != null || divEdgeInsets.end != null) {
            Expression<Long> expression = divEdgeInsets.start;
            divHolderView.addSubscription(expression != null ? expression.observe(expressionResolver, function1) : null);
            Expression<Long> expression2 = divEdgeInsets.end;
            divHolderView.addSubscription(expression2 != null ? expression2.observe(expressionResolver, function1) : null);
            return;
        }
        divHolderView.addSubscription(divEdgeInsets.left.observe(expressionResolver, function1));
        divHolderView.addSubscription(divEdgeInsets.right.observe(expressionResolver, function1));
    }

    private final void bindChildAlignment(final View view, final DivContainer divContainer, DivContainer divContainer2, final DivBase divBase, DivBase divBase2, final ExpressionResolver expressionResolver, final ExpressionResolver expressionResolver2, ExpressionSubscriber expressionSubscriber, Div2View div2View) {
        if (!div2View.getComplexRebindInProgress$div_release()) {
            if (ExpressionsKt.equalsToConstant(divContainer.contentAlignmentHorizontal, divContainer2 != null ? divContainer2.contentAlignmentHorizontal : null)) {
                if (ExpressionsKt.equalsToConstant(divContainer.contentAlignmentVertical, divContainer2 != null ? divContainer2.contentAlignmentVertical : null)) {
                    if (ExpressionsKt.equalsToConstant(divBase.getAlignmentHorizontal(), divBase2 != null ? divBase2.getAlignmentHorizontal() : null)) {
                        if (ExpressionsKt.equalsToConstant(divBase.getAlignmentVertical(), divBase2 != null ? divBase2.getAlignmentVertical() : null)) {
                            return;
                        }
                    }
                }
            }
        }
        applyChildAlignment(view, divContainer, divBase, expressionResolver, expressionResolver2);
        if (ExpressionsKt.isConstant(divContainer.contentAlignmentHorizontal) && ExpressionsKt.isConstant(divContainer.contentAlignmentVertical) && ExpressionsKt.isConstantOrNull(divBase.getAlignmentHorizontal()) && ExpressionsKt.isConstantOrNull(divBase.getAlignmentVertical())) {
            return;
        }
        Function1<? super DivAlignmentHorizontal, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivContainerBinder$bindChildAlignment$callback$1
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
                this.this$0.applyChildAlignment(view, divContainer, divBase, expressionResolver, expressionResolver2);
            }
        };
        expressionSubscriber.addSubscription(divContainer.contentAlignmentHorizontal.observe(expressionResolver, function1));
        expressionSubscriber.addSubscription(divContainer.contentAlignmentVertical.observe(expressionResolver, function1));
        Expression<DivAlignmentHorizontal> alignmentHorizontal = divBase.getAlignmentHorizontal();
        expressionSubscriber.addSubscription(alignmentHorizontal != null ? alignmentHorizontal.observe(expressionResolver2, function1) : null);
        Expression<DivAlignmentVertical> alignmentVertical = divBase.getAlignmentVertical();
        expressionSubscriber.addSubscription(alignmentVertical != null ? alignmentVertical.observe(expressionResolver2, function1) : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyChildAlignment(View view, DivContainer divContainer, DivBase divBase, ExpressionResolver expressionResolver, ExpressionResolver expressionResolver2) {
        DivAlignmentHorizontal alignmentHorizontal;
        Expression<DivAlignmentHorizontal> alignmentHorizontal2 = divBase.getAlignmentHorizontal();
        DivAlignmentVertical alignmentVertical = null;
        if (alignmentHorizontal2 != null) {
            alignmentHorizontal = alignmentHorizontal2.evaluate(expressionResolver2);
        } else {
            alignmentHorizontal = BaseDivViewExtensionsKt.isWrapContainer(divContainer, expressionResolver) ? null : BaseDivViewExtensionsKt.toAlignmentHorizontal(divContainer.contentAlignmentHorizontal.evaluate(expressionResolver));
        }
        Expression<DivAlignmentVertical> alignmentVertical2 = divBase.getAlignmentVertical();
        if (alignmentVertical2 != null) {
            alignmentVertical = alignmentVertical2.evaluate(expressionResolver2);
        } else if (!BaseDivViewExtensionsKt.isWrapContainer(divContainer, expressionResolver)) {
            alignmentVertical = BaseDivViewExtensionsKt.toAlignmentVertical(divContainer.contentAlignmentVertical.evaluate(expressionResolver));
        }
        BaseDivViewExtensionsKt.applyAlignment(view, alignmentHorizontal, alignmentVertical);
    }

    private final void checkCrossAxisSize(DivContainer divContainer, DivBase divBase, ExpressionResolver expressionResolver, ErrorCollector errorCollector) {
        if (BaseDivViewExtensionsKt.isHorizontal(divContainer, expressionResolver)) {
            checkCrossAxisSize(divBase.getHeight(), divBase, errorCollector);
        } else {
            checkCrossAxisSize(divBase.getWidth(), divBase, errorCollector);
        }
    }

    private final void checkCrossAxisSize(DivSize divSize, DivBase divBase, ErrorCollector errorCollector) {
        checkSize(divSize, divBase, errorCollector, "wrap layout mode", "cross");
    }

    private final void checkMainAxisSize(DivContainer divContainer, DivBase divBase, ExpressionResolver expressionResolver, ErrorCollector errorCollector) {
        if (BaseDivViewExtensionsKt.isHorizontal(divContainer, expressionResolver)) {
            if (divContainer.getWidth() instanceof DivSize.WrapContent) {
                checkMainAxisSize(divBase.getWidth(), divBase, errorCollector);
            }
        } else if (divContainer.getHeight() instanceof DivSize.WrapContent) {
            DivAspect divAspect = divContainer.aspect;
            if (divAspect == null || ((float) divAspect.ratio.evaluate(expressionResolver).doubleValue()) == 0.0f) {
                checkMainAxisSize(divBase.getHeight(), divBase, errorCollector);
            }
        }
    }

    private final void checkMainAxisSize(DivSize divSize, DivBase divBase, ErrorCollector errorCollector) {
        checkSize(divSize, divBase, errorCollector, "wrap_content size", b9.h.Z);
    }

    private final void checkSize(DivSize divSize, DivBase divBase, ErrorCollector errorCollector, String str, String str2) {
        String str3;
        if (divSize instanceof DivSize.MatchParent) {
            String id = divBase.getId();
            if (id == null || (str3 = " with id='" + id + '\'') == null) {
                str3 = "";
            }
            String str4 = String.format("Incorrect child size. Container with %s contains child%s with match_parent size along the %s axis.", Arrays.copyOf(new Object[]{str, str3, str2}, 3));
            Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
            errorCollector.logWarning(new Throwable(str4));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setDataWithoutBinding(BindingContext bindingContext, ViewGroup view, DivContainer div) {
        Intrinsics.checkNotNullParameter(bindingContext, "bindingContext");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(div, "div");
        ((DivHolderView) view).setDiv(div);
        DivBinder divBinder = this.divBinder.get();
        int i = 0;
        for (Object obj : DivCollectionExtensionsKt.buildItems(div, bindingContext.getExpressionResolver())) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            DivItemBuilderResult divItemBuilderResult = (DivItemBuilderResult) obj;
            View childView = view.getChildAt(i);
            Intrinsics.checkNotNullExpressionValue(childView, "childView");
            BindingContext bindingContext2 = BaseDivViewExtensionsKt.getBindingContext(childView);
            if (bindingContext2 == null) {
                bindingContext2 = bindingContext;
            }
            divBinder.setDataWithoutBinding(bindingContext2, childView, divItemBuilderResult.getDiv());
            i = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Rect toRect(DivEdgeInsets divEdgeInsets, Resources resources, ExpressionResolver expressionResolver) {
        if (divEdgeInsets == null) {
            this.tempRect.set(0, 0, 0, 0);
            return this.tempRect;
        }
        DisplayMetrics metrics = resources.getDisplayMetrics();
        DivSizeUnit divSizeUnitEvaluate = divEdgeInsets.unit.evaluate(expressionResolver);
        if (divEdgeInsets.start != null || divEdgeInsets.end != null) {
            if (resources.getConfiguration().getLayoutDirection() == 0) {
                Rect rect = this.tempRect;
                Expression<Long> expression = divEdgeInsets.start;
                Long lEvaluate = expression != null ? expression.evaluate(expressionResolver) : null;
                Intrinsics.checkNotNullExpressionValue(metrics, "metrics");
                rect.left = BaseDivViewExtensionsKt.unitToPx(lEvaluate, metrics, divSizeUnitEvaluate);
                Rect rect2 = this.tempRect;
                Expression<Long> expression2 = divEdgeInsets.end;
                rect2.right = BaseDivViewExtensionsKt.unitToPx(expression2 != null ? expression2.evaluate(expressionResolver) : null, metrics, divSizeUnitEvaluate);
            } else {
                Rect rect3 = this.tempRect;
                Expression<Long> expression3 = divEdgeInsets.end;
                Long lEvaluate2 = expression3 != null ? expression3.evaluate(expressionResolver) : null;
                Intrinsics.checkNotNullExpressionValue(metrics, "metrics");
                rect3.left = BaseDivViewExtensionsKt.unitToPx(lEvaluate2, metrics, divSizeUnitEvaluate);
                Rect rect4 = this.tempRect;
                Expression<Long> expression4 = divEdgeInsets.start;
                rect4.right = BaseDivViewExtensionsKt.unitToPx(expression4 != null ? expression4.evaluate(expressionResolver) : null, metrics, divSizeUnitEvaluate);
            }
        } else {
            Rect rect5 = this.tempRect;
            Long lEvaluate3 = divEdgeInsets.left.evaluate(expressionResolver);
            Intrinsics.checkNotNullExpressionValue(metrics, "metrics");
            rect5.left = BaseDivViewExtensionsKt.unitToPx(lEvaluate3, metrics, divSizeUnitEvaluate);
            this.tempRect.right = BaseDivViewExtensionsKt.unitToPx(divEdgeInsets.right.evaluate(expressionResolver), metrics, divSizeUnitEvaluate);
        }
        this.tempRect.top = BaseDivViewExtensionsKt.unitToPx(divEdgeInsets.top.evaluate(expressionResolver), metrics, divSizeUnitEvaluate);
        this.tempRect.bottom = BaseDivViewExtensionsKt.unitToPx(divEdgeInsets.bottom.evaluate(expressionResolver), metrics, divSizeUnitEvaluate);
        return this.tempRect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int toOrientationMode(DivContainer.Orientation orientation) {
        return WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()] == 1 ? 0 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int toWrapDirection(DivContainer.Orientation orientation) {
        return WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()] == 1 ? 0 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final int toSeparatorMode(DivContainer.Separator separator, ExpressionResolver expressionResolver) {
        ?? r0;
        if (separator == null) {
            return 0;
        }
        boolean zBooleanValue = separator.showAtStart.evaluate(expressionResolver).booleanValue();
        if (separator.showBetween.evaluate(expressionResolver).booleanValue()) {
            r0 = zBooleanValue;
            r0 = (zBooleanValue ? 1 : 0) | 2;
        }
        r0 = zBooleanValue;
        return separator.showAtEnd.evaluate(expressionResolver).booleanValue() ? r0 | 4 : r0;
    }
}
