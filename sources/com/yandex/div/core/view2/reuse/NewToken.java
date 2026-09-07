package com.yandex.div.core.view2.reuse;

import com.yandex.div.core.util.DivUtilKt;
import com.yandex.div.internal.core.DivCollectionExtensionsKt;
import com.yandex.div.internal.core.DivItemBuilderResult;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.Div;
import com.yandex.div2.DivState;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NewToken.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00000\u000eJ\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00000\u000e*\b\u0012\u0004\u0012\u00020\u00030\u000eH\u0002R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/yandex/div/core/view2/reuse/NewToken;", "Lcom/yandex/div/core/view2/reuse/Token;", "item", "Lcom/yandex/div/internal/core/DivItemBuilderResult;", "childIndex", "", "lastExistingParent", "Lcom/yandex/div/core/view2/reuse/ExistingToken;", "(Lcom/yandex/div/internal/core/DivItemBuilderResult;ILcom/yandex/div/core/view2/reuse/ExistingToken;)V", "getLastExistingParent", "()Lcom/yandex/div/core/view2/reuse/ExistingToken;", "setLastExistingParent", "(Lcom/yandex/div/core/view2/reuse/ExistingToken;)V", "getChildrenTokens", "", "itemsToNewTokenList", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class NewToken extends Token {
    private ExistingToken lastExistingParent;

    public final ExistingToken getLastExistingParent() {
        return this.lastExistingParent;
    }

    public final void setLastExistingParent(ExistingToken existingToken) {
        this.lastExistingParent = existingToken;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewToken(DivItemBuilderResult item, int i, ExistingToken existingToken) {
        super(item, i);
        Intrinsics.checkNotNullParameter(item, "item");
        this.lastExistingParent = existingToken;
    }

    public final List<NewToken> getChildrenTokens() {
        Div div;
        ExpressionResolver expressionResolver = getItem().getExpressionResolver();
        Div div2 = getItem().getDiv();
        if (!(div2 instanceof Div.Text) && !(div2 instanceof Div.Image) && !(div2 instanceof Div.GifImage) && !(div2 instanceof Div.Separator) && !(div2 instanceof Div.Indicator) && !(div2 instanceof Div.Slider) && !(div2 instanceof Div.Input) && !(div2 instanceof Div.Select) && !(div2 instanceof Div.Video) && !(div2 instanceof Div.Switch)) {
            if (div2 instanceof Div.Container) {
                return itemsToNewTokenList(DivCollectionExtensionsKt.buildItems(((Div.Container) div2).getValue(), expressionResolver));
            }
            if (div2 instanceof Div.Custom) {
                return itemsToNewTokenList(DivCollectionExtensionsKt.toDivItemBuilderResult(DivCollectionExtensionsKt.getNonNullItems(((Div.Custom) div2).getValue()), expressionResolver));
            }
            if (div2 instanceof Div.Grid) {
                return itemsToNewTokenList(DivCollectionExtensionsKt.itemsToDivItemBuilderResult(((Div.Grid) div2).getValue(), expressionResolver));
            }
            if (div2 instanceof Div.Gallery) {
                return itemsToNewTokenList(DivCollectionExtensionsKt.buildItems(((Div.Gallery) div2).getValue(), expressionResolver));
            }
            if (div2 instanceof Div.Pager) {
                return itemsToNewTokenList(DivCollectionExtensionsKt.buildItems(((Div.Pager) div2).getValue(), expressionResolver));
            }
            if (div2 instanceof Div.Tabs) {
                return itemsToNewTokenList(DivCollectionExtensionsKt.itemsToDivItemBuilderResult(((Div.Tabs) div2).getValue(), expressionResolver));
            }
            if (div2 instanceof Div.State) {
                DivState.State defaultState = DivUtilKt.getDefaultState(((Div.State) div2).getValue(), expressionResolver);
                if (defaultState == null || (div = defaultState.div) == null) {
                    return CollectionsKt.emptyList();
                }
                return itemsToNewTokenList(CollectionsKt.listOf(DivCollectionExtensionsKt.toItemBuilderResult(div, expressionResolver)));
            }
            throw new NoWhenBranchMatchedException();
        }
        return CollectionsKt.emptyList();
    }

    private final List<NewToken> itemsToNewTokenList(List<DivItemBuilderResult> list) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(new NewToken((DivItemBuilderResult) obj, i, this.lastExistingParent));
            i = i2;
        }
        return arrayList;
    }
}
