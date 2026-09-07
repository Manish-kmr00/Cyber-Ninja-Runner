package com.yandex.div.core.view2.state;

import com.yandex.div.core.state.DivStatePath;
import com.yandex.div.core.state.StateConflictException;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivData;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: DivStateSwitcher.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/core/view2/state/DivStateSwitcher;", "", "switchStates", "", "state", "Lcom/yandex/div2/DivData$State;", "paths", "", "Lcom/yandex/div/core/state/DivStatePath;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface DivStateSwitcher {
    void switchStates(DivData.State state, List<DivStatePath> paths, ExpressionResolver resolver) throws StateConflictException;
}
