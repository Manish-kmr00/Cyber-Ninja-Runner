package com.yandex.div.core.util;

import com.yandex.div.internal.core.DivCollectionExtensionsKt;
import com.yandex.div.internal.core.DivItemBuilderResult;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.Div;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivTreeWalk.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0014\u0010\u0006\u001a\u00020\u0007*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\b"}, d2 = {"getItems", "", "Lcom/yandex/div/internal/core/DivItemBuilderResult;", "Lcom/yandex/div2/Div;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "walk", "Lcom/yandex/div/core/util/DivTreeWalk;", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DivTreeWalkKt {
    public static final DivTreeWalk walk(Div div, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(div, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        return new DivTreeWalk(div, resolver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<DivItemBuilderResult> getItems(Div div, ExpressionResolver expressionResolver) {
        if (!(div instanceof Div.Text) && !(div instanceof Div.Image) && !(div instanceof Div.GifImage) && !(div instanceof Div.Separator) && !(div instanceof Div.Indicator) && !(div instanceof Div.Slider) && !(div instanceof Div.Input) && !(div instanceof Div.Custom) && !(div instanceof Div.Select) && !(div instanceof Div.Video) && !(div instanceof Div.Switch)) {
            if (div instanceof Div.Container) {
                return DivCollectionExtensionsKt.buildItems(((Div.Container) div).getValue(), expressionResolver);
            }
            if (div instanceof Div.Grid) {
                return DivCollectionExtensionsKt.itemsToDivItemBuilderResult(((Div.Grid) div).getValue(), expressionResolver);
            }
            if (div instanceof Div.Gallery) {
                return DivCollectionExtensionsKt.buildItems(((Div.Gallery) div).getValue(), expressionResolver);
            }
            if (div instanceof Div.Pager) {
                return DivCollectionExtensionsKt.buildItems(((Div.Pager) div).getValue(), expressionResolver);
            }
            if (div instanceof Div.Tabs) {
                return DivCollectionExtensionsKt.itemsToDivItemBuilderResult(((Div.Tabs) div).getValue(), expressionResolver);
            }
            if (div instanceof Div.State) {
                return DivCollectionExtensionsKt.statesToDivItemBuilderResult(((Div.State) div).getValue(), expressionResolver);
            }
            throw new NoWhenBranchMatchedException();
        }
        return CollectionsKt.emptyList();
    }
}
