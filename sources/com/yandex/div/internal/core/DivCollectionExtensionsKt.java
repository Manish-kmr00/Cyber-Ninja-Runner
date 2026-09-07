package com.yandex.div.internal.core;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.yandex.div.core.expression.ExpressionResolverImpl;
import com.yandex.div.core.expression.variables.ConstantsProvider;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.Div;
import com.yandex.div2.DivCollectionItemBuilder;
import com.yandex.div2.DivContainer;
import com.yandex.div2.DivCustom;
import com.yandex.div2.DivGallery;
import com.yandex.div2.DivGifImage;
import com.yandex.div2.DivGrid;
import com.yandex.div2.DivImage;
import com.yandex.div2.DivIndicator;
import com.yandex.div2.DivInput;
import com.yandex.div2.DivPager;
import com.yandex.div2.DivSelect;
import com.yandex.div2.DivSeparator;
import com.yandex.div2.DivSlider;
import com.yandex.div2.DivState;
import com.yandex.div2.DivSwitch;
import com.yandex.div2.DivTabs;
import com.yandex.div2.DivText;
import com.yandex.div2.DivVideo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivCollectionExtensions.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a0\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002\u001a\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0000\u001a&\u0010\u0018\u001a\u0004\u0018\u00010\u0011*\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002\u001a\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003*\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0007\u001a\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003*\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007\u001a\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003*\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007\u001a\u0018\u0010\u001d\u001a\u00020\u0004*\u00020\u00042\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u0014\u0010\u001f\u001a\u00020\u0016*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0000\u001a&\u0010\u001f\u001a\u0004\u0018\u00010\u0016*\u00020\u00142\u0006\u0010 \u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002\u001a\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003*\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0000\u001a\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003*\u00020\"2\u0006\u0010\u0015\u001a\u00020\u0016H\u0000\u001a\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003*\u00020$2\u0006\u0010\u0015\u001a\u00020\u0016H\u0000\u001a \u0010%\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003*\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0015\u001a\u00020\u0016H\u0000\u001a\u0014\u0010&\u001a\u00020\u0011*\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001b\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u001b\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\t\"\u001b\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u000b\"\u001b\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\r\"\u001b\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u000f¨\u0006'"}, d2 = {"INDEX_VARIABLE_NAME", "", "nonNullItems", "", "Lcom/yandex/div2/Div;", "Lcom/yandex/div2/DivContainer;", "getNonNullItems", "(Lcom/yandex/div2/DivContainer;)Ljava/util/List;", "Lcom/yandex/div2/DivCustom;", "(Lcom/yandex/div2/DivCustom;)Ljava/util/List;", "Lcom/yandex/div2/DivGallery;", "(Lcom/yandex/div2/DivGallery;)Ljava/util/List;", "Lcom/yandex/div2/DivGrid;", "(Lcom/yandex/div2/DivGrid;)Ljava/util/List;", "Lcom/yandex/div2/DivPager;", "(Lcom/yandex/div2/DivPager;)Ljava/util/List;", "buildItems", "Lcom/yandex/div/internal/core/DivItemBuilderResult;", FirebaseAnalytics.Param.ITEMS, "itemBuilder", "Lcom/yandex/div2/DivCollectionItemBuilder;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "build", "buildItem", "data", "", "index", "", "copy", "id", "getItemResolver", "dataElement", "itemsToDivItemBuilderResult", "Lcom/yandex/div2/DivTabs;", "statesToDivItemBuilderResult", "Lcom/yandex/div2/DivState;", "toDivItemBuilderResult", "toItemBuilderResult", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DivCollectionExtensionsKt {
    private static final String INDEX_VARIABLE_NAME = "index";

    public static final List<DivItemBuilderResult> buildItems(DivContainer divContainer, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(divContainer, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        return buildItems(divContainer.items, divContainer.itemBuilder, resolver);
    }

    public static final List<DivItemBuilderResult> buildItems(DivGallery divGallery, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(divGallery, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        return buildItems(divGallery.items, divGallery.itemBuilder, resolver);
    }

    public static final List<DivItemBuilderResult> buildItems(DivPager divPager, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(divPager, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        return buildItems(divPager.items, divPager.itemBuilder, resolver);
    }

    private static final List<DivItemBuilderResult> buildItems(List<? extends Div> list, DivCollectionItemBuilder divCollectionItemBuilder, ExpressionResolver expressionResolver) {
        List<DivItemBuilderResult> divItemBuilderResult;
        if (list == null || (divItemBuilderResult = toDivItemBuilderResult(list, expressionResolver)) == null) {
            return divCollectionItemBuilder != null ? build(divCollectionItemBuilder, expressionResolver) : CollectionsKt.emptyList();
        }
        return divItemBuilderResult;
    }

    public static final List<DivItemBuilderResult> build(DivCollectionItemBuilder divCollectionItemBuilder, ExpressionResolver resolver) throws JSONException {
        Intrinsics.checkNotNullParameter(divCollectionItemBuilder, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        JSONArray jSONArrayEvaluate = divCollectionItemBuilder.data.evaluate(resolver);
        int length = jSONArrayEvaluate.length();
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            Object obj = jSONArrayEvaluate.get(i);
            Intrinsics.checkNotNullExpressionValue(obj, "get(i)");
            DivItemBuilderResult divItemBuilderResultBuildItem = buildItem(divCollectionItemBuilder, obj, i, resolver);
            if (divItemBuilderResultBuildItem != null) {
                arrayList.add(divItemBuilderResultBuildItem);
            }
        }
        return arrayList;
    }

    private static final DivItemBuilderResult buildItem(DivCollectionItemBuilder divCollectionItemBuilder, Object obj, int i, ExpressionResolver expressionResolver) {
        Object next;
        ExpressionResolver itemResolver = getItemResolver(divCollectionItemBuilder, obj, i, expressionResolver);
        if (itemResolver == null) {
            return null;
        }
        Iterator<T> it = divCollectionItemBuilder.prototypes.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((DivCollectionItemBuilder.Prototype) next).selector.evaluate(itemResolver).booleanValue());
        DivCollectionItemBuilder.Prototype prototype = (DivCollectionItemBuilder.Prototype) next;
        if (prototype == null) {
            return null;
        }
        Div div = prototype.div;
        Expression<String> expression = prototype.id;
        return toItemBuilderResult(copy(div, expression != null ? expression.evaluate(itemResolver) : null), itemResolver);
    }

    public static final ExpressionResolver getItemResolver(DivCollectionItemBuilder divCollectionItemBuilder, ExpressionResolver resolver) {
        ExpressionResolver itemResolver;
        Intrinsics.checkNotNullParameter(divCollectionItemBuilder, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        JSONArray jSONArrayEvaluate = divCollectionItemBuilder.data.evaluate(resolver);
        int length = jSONArrayEvaluate.length();
        for (int i = 0; i < length; i++) {
            Object obj = jSONArrayEvaluate.get(i);
            if ((obj instanceof Object) && (itemResolver = getItemResolver(divCollectionItemBuilder, obj, i, resolver)) != null) {
                return itemResolver;
            }
        }
        return resolver;
    }

    private static final ExpressionResolver getItemResolver(DivCollectionItemBuilder divCollectionItemBuilder, Object obj, int i, ExpressionResolver expressionResolver) {
        ExpressionResolverImpl expressionResolverImpl = expressionResolver instanceof ExpressionResolverImpl ? (ExpressionResolverImpl) expressionResolver : null;
        if (expressionResolverImpl == null) {
            return expressionResolver;
        }
        JSONObject jSONObjectValidateItemBuilderDataElement = expressionResolverImpl.validateItemBuilderDataElement(obj, i);
        if (jSONObjectValidateItemBuilderDataElement == null) {
            return null;
        }
        return expressionResolverImpl.plus(new ConstantsProvider(MapsKt.mapOf(TuplesKt.to(divCollectionItemBuilder.dataElementName, jSONObjectValidateItemBuilderDataElement), TuplesKt.to("index", Long.valueOf(i)))));
    }

    static /* synthetic */ Div copy$default(Div div, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = div.value().getId();
        }
        return copy(div, str);
    }

    private static final Div copy(Div div, String str) {
        if (div instanceof Div.Image) {
            return new Div.Image(DivImage.copy$default(((Div.Image) div).getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -33554433, 4194303, null));
        }
        if (div instanceof Div.GifImage) {
            return new Div.GifImage(DivGifImage.copy$default(((Div.GifImage) div).getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -8388609, 131071, null));
        }
        if (div instanceof Div.Text) {
            return new Div.Text(DivText.copy$default(((Div.Text) div).getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -268435457, -1, 3, null));
        }
        if (div instanceof Div.Separator) {
            return new Div.Separator(DivSeparator.copy$default(((Div.Separator) div).getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1048577, 1023, null));
        }
        ArrayList arrayList = null;
        if (div instanceof Div.Container) {
            Div.Container container = (Div.Container) div;
            DivContainer value = container.getValue();
            List<Div> list = container.getValue().items;
            if (list != null) {
                List<Div> list2 = list;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList2.add(copy$default((Div) it.next(), null, 1, null));
                }
                arrayList = arrayList2;
            }
            return new Div.Container(DivContainer.copy$default(value, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, str, null, arrayList, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -41943041, 524287, null));
        }
        if (div instanceof Div.Grid) {
            Div.Grid grid = (Div.Grid) div;
            DivGrid value2 = grid.getValue();
            List<Div> list3 = grid.getValue().items;
            if (list3 != null) {
                List<Div> list4 = list3;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
                Iterator<T> it2 = list4.iterator();
                while (it2.hasNext()) {
                    arrayList3.add(copy$default((Div) it2.next(), null, 1, null));
                }
                arrayList = arrayList3;
            }
            return new Div.Grid(DivGrid.copy$default(value2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, str, arrayList, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -12582913, 8191, null));
        }
        if (div instanceof Div.Gallery) {
            Div.Gallery gallery = (Div.Gallery) div;
            DivGallery value3 = gallery.getValue();
            List<Div> list5 = gallery.getValue().items;
            if (list5 != null) {
                List<Div> list6 = list5;
                ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
                Iterator<T> it3 = list6.iterator();
                while (it3.hasNext()) {
                    arrayList4.add(copy$default((Div) it3.next(), null, 1, null));
                }
                arrayList = arrayList4;
            }
            return new Div.Gallery(DivGallery.copy$default(value3, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, str, null, null, arrayList, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1179649, 2047, null));
        }
        if (div instanceof Div.Pager) {
            Div.Pager pager = (Div.Pager) div;
            DivPager value4 = pager.getValue();
            List<Div> list7 = pager.getValue().items;
            if (list7 != null) {
                List<Div> list8 = list7;
                ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list8, 10));
                Iterator<T> it4 = list8.iterator();
                while (it4.hasNext()) {
                    arrayList5.add(copy$default((Div) it4.next(), null, 1, null));
                }
                arrayList = arrayList5;
            }
            return new Div.Pager(DivPager.copy$default(value4, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, str, null, null, null, arrayList, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -557057, 2047, null));
        }
        if (div instanceof Div.Tabs) {
            Div.Tabs tabs = (Div.Tabs) div;
            DivTabs value5 = tabs.getValue();
            List<DivTabs.Item> list9 = tabs.getValue().items;
            ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list9, 10));
            for (DivTabs.Item item : list9) {
                arrayList6.add(DivTabs.Item.copy$default(item, copy$default(item.div, null, 1, null), null, null, 6, null));
            }
            return new Div.Tabs(DivTabs.copy$default(value5, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, str, arrayList6, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -98305, 2047, null));
        }
        if (div instanceof Div.State) {
            Div.State state = (Div.State) div;
            DivState value6 = state.getValue();
            List<DivState.State> list10 = state.getValue().states;
            ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list10, 10));
            for (DivState.State state2 : list10) {
                Div div2 = state2.div;
                arrayList7.add(DivState.State.copy$default(state2, null, null, div2 != null ? copy$default(div2, null, 1, null) : null, null, null, 27, null));
            }
            return new Div.State(DivState.copy$default(value6, null, null, null, null, null, null, null, null, null, null, null, str, null, null, null, null, str, null, null, null, null, null, null, null, arrayList7, null, null, null, null, null, null, null, null, null, null, null, null, null, -16844801, 63, null));
        }
        if (!(div instanceof Div.Custom)) {
            if (div instanceof Div.Indicator) {
                return new Div.Indicator(DivIndicator.copy$default(((Div.Indicator) div).getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -131073, 4095, null));
            }
            if (div instanceof Div.Slider) {
                return new Div.Slider(DivSlider.copy$default(((Div.Slider) div).getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -8193, 32767, null));
            }
            if (div instanceof Div.Input) {
                return new Div.Input(DivInput.copy$default(((Div.Input) div).getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -33554433, 67108863, null));
            }
            if (div instanceof Div.Select) {
                return new Div.Select(DivSelect.copy$default(((Div.Select) div).getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1048577, 4095, null));
            }
            if (div instanceof Div.Video) {
                return new Div.Video(DivVideo.copy$default(((Div.Video) div).getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -524289, 32767, null));
            }
            if (!(div instanceof Div.Switch)) {
                throw new NoWhenBranchMatchedException();
            }
            DivSwitch value7 = ((Div.Switch) div).getValue();
            return new Div.Switch(value7.copy(((-8193) & 1) != 0 ? value7.getAccessibility() : null, ((-8193) & 2) != 0 ? value7.getAlignmentHorizontal() : null, ((-8193) & 4) != 0 ? value7.getAlignmentVertical() : null, ((-8193) & 8) != 0 ? value7.getAlpha() : null, ((-8193) & 16) != 0 ? value7.getAnimators() : null, ((-8193) & 32) != 0 ? value7.getBackground() : null, ((-8193) & 64) != 0 ? value7.getBorder() : null, ((-8193) & 128) != 0 ? value7.getColumnSpan() : null, ((-8193) & 256) != 0 ? value7.getDisappearActions() : null, ((-8193) & 512) != 0 ? value7.getExtensions() : null, ((-8193) & 1024) != 0 ? value7.getFocus() : null, ((-8193) & 2048) != 0 ? value7.getFunctions() : null, ((-8193) & 4096) != 0 ? value7.getHeight() : null, ((-8193) & 8192) != 0 ? value7.getId() : str, ((-8193) & 16384) != 0 ? value7.isEnabled : null, ((-8193) & 32768) != 0 ? value7.isOnVariable : null, ((-8193) & 65536) != 0 ? value7.getLayoutProvider() : null, ((-8193) & 131072) != 0 ? value7.getMargins() : null, ((-8193) & 262144) != 0 ? value7.onColor : null, ((-8193) & 524288) != 0 ? value7.getPaddings() : null, ((-8193) & 1048576) != 0 ? value7.getReuseId() : null, ((-8193) & 2097152) != 0 ? value7.getRowSpan() : null, ((-8193) & 4194304) != 0 ? value7.getSelectedActions() : null, ((-8193) & 8388608) != 0 ? value7.getTooltips() : null, ((-8193) & 16777216) != 0 ? value7.getTransform() : null, ((-8193) & 33554432) != 0 ? value7.getTransitionChange() : null, ((-8193) & 67108864) != 0 ? value7.getTransitionIn() : null, ((-8193) & 134217728) != 0 ? value7.getTransitionOut() : null, ((-8193) & 268435456) != 0 ? value7.getTransitionTriggers() : null, ((-8193) & 536870912) != 0 ? value7.getVariableTriggers() : null, ((-8193) & 1073741824) != 0 ? value7.getVariables() : null, ((-8193) & Integer.MIN_VALUE) != 0 ? value7.getVisibility() : null, (7 & 1) != 0 ? value7.getVisibilityAction() : null, (7 & 2) != 0 ? value7.getVisibilityActions() : null, (7 & 4) != 0 ? value7.getWidth() : null));
        }
        DivCustom value8 = ((Div.Custom) div).getValue();
        return new Div.Custom(value8.copy(((-32769) & 1) != 0 ? value8.getAccessibility() : null, ((-32769) & 2) != 0 ? value8.getAlignmentHorizontal() : null, ((-32769) & 4) != 0 ? value8.getAlignmentVertical() : null, ((-32769) & 8) != 0 ? value8.getAlpha() : null, ((-32769) & 16) != 0 ? value8.getAnimators() : null, ((-32769) & 32) != 0 ? value8.getBackground() : null, ((-32769) & 64) != 0 ? value8.getBorder() : null, ((-32769) & 128) != 0 ? value8.getColumnSpan() : null, ((-32769) & 256) != 0 ? value8.customProps : null, ((-32769) & 512) != 0 ? value8.customType : null, ((-32769) & 1024) != 0 ? value8.getDisappearActions() : null, ((-32769) & 2048) != 0 ? value8.getExtensions() : null, ((-32769) & 4096) != 0 ? value8.getFocus() : null, ((-32769) & 8192) != 0 ? value8.getFunctions() : null, ((-32769) & 16384) != 0 ? value8.getHeight() : null, ((-32769) & 32768) != 0 ? value8.getId() : str, ((-32769) & 65536) != 0 ? value8.items : null, ((-32769) & 131072) != 0 ? value8.getLayoutProvider() : null, ((-32769) & 262144) != 0 ? value8.getMargins() : null, ((-32769) & 524288) != 0 ? value8.getPaddings() : null, ((-32769) & 1048576) != 0 ? value8.getReuseId() : null, ((-32769) & 2097152) != 0 ? value8.getRowSpan() : null, ((-32769) & 4194304) != 0 ? value8.getSelectedActions() : null, ((-32769) & 8388608) != 0 ? value8.getTooltips() : null, ((-32769) & 16777216) != 0 ? value8.getTransform() : null, ((-32769) & 33554432) != 0 ? value8.getTransitionChange() : null, ((-32769) & 67108864) != 0 ? value8.getTransitionIn() : null, ((-32769) & 134217728) != 0 ? value8.getTransitionOut() : null, ((-32769) & 268435456) != 0 ? value8.getTransitionTriggers() : null, ((-32769) & 536870912) != 0 ? value8.getVariableTriggers() : null, ((-32769) & 1073741824) != 0 ? value8.getVariables() : null, ((-32769) & Integer.MIN_VALUE) != 0 ? value8.getVisibility() : null, (7 & 1) != 0 ? value8.getVisibilityAction() : null, (7 & 2) != 0 ? value8.getVisibilityActions() : null, (7 & 4) != 0 ? value8.getWidth() : null));
    }

    public static final List<Div> getNonNullItems(DivContainer divContainer) {
        Intrinsics.checkNotNullParameter(divContainer, "<this>");
        List<Div> list = divContainer.items;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public static final List<Div> getNonNullItems(DivCustom divCustom) {
        Intrinsics.checkNotNullParameter(divCustom, "<this>");
        List<Div> list = divCustom.items;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public static final List<Div> getNonNullItems(DivGallery divGallery) {
        Intrinsics.checkNotNullParameter(divGallery, "<this>");
        List<Div> list = divGallery.items;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public static final List<Div> getNonNullItems(DivGrid divGrid) {
        Intrinsics.checkNotNullParameter(divGrid, "<this>");
        List<Div> list = divGrid.items;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public static final List<DivItemBuilderResult> itemsToDivItemBuilderResult(DivGrid divGrid, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(divGrid, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        return toDivItemBuilderResult(getNonNullItems(divGrid), resolver);
    }

    public static final List<Div> getNonNullItems(DivPager divPager) {
        Intrinsics.checkNotNullParameter(divPager, "<this>");
        List<Div> list = divPager.items;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public static final List<DivItemBuilderResult> itemsToDivItemBuilderResult(DivTabs divTabs, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(divTabs, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        List<DivTabs.Item> list = divTabs.items;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(toItemBuilderResult(((DivTabs.Item) it.next()).div, resolver));
        }
        return arrayList;
    }

    public static final List<DivItemBuilderResult> statesToDivItemBuilderResult(DivState divState, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(divState, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        List<DivState.State> list = divState.states;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Div div = ((DivState.State) it.next()).div;
            DivItemBuilderResult itemBuilderResult = div != null ? toItemBuilderResult(div, resolver) : null;
            if (itemBuilderResult != null) {
                arrayList.add(itemBuilderResult);
            }
        }
        return arrayList;
    }

    public static final List<DivItemBuilderResult> toDivItemBuilderResult(List<? extends Div> list, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        List<? extends Div> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toItemBuilderResult((Div) it.next(), resolver));
        }
        return arrayList;
    }

    public static final DivItemBuilderResult toItemBuilderResult(Div div, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(div, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        return new DivItemBuilderResult(div, resolver);
    }
}
