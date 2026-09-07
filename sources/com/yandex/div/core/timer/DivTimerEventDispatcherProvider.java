package com.yandex.div.core.timer;

import com.yandex.div.DivDataTag;
import com.yandex.div.core.dagger.DivScope;
import com.yandex.div.core.view2.divs.DivActionBinder;
import com.yandex.div.core.view2.errors.ErrorCollector;
import com.yandex.div.core.view2.errors.ErrorCollectors;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivData;
import com.yandex.div2.DivTimer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivTimerEventDispatcherProvider.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J'\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u0014J*\u0010\u0015\u001a\u00020\u0016*\u00020\u000b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001c\u0010\u001c\u001a\u00020\u001d*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002RN\u0010\u0007\u001aB\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t\u0012\f\u0012\n \n*\u0004\u0018\u00010\u000b0\u000b \n* \u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t\u0012\f\u0012\n \n*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010\f0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/yandex/div/core/timer/DivTimerEventDispatcherProvider;", "", "divActionBinder", "Lcom/yandex/div/core/view2/divs/DivActionBinder;", "errorCollectors", "Lcom/yandex/div/core/view2/errors/ErrorCollectors;", "(Lcom/yandex/div/core/view2/divs/DivActionBinder;Lcom/yandex/div/core/view2/errors/ErrorCollectors;)V", "controllers", "", "", "kotlin.jvm.PlatformType", "Lcom/yandex/div/core/timer/DivTimerEventDispatcher;", "", "getOrCreate", "dataTag", "Lcom/yandex/div/DivDataTag;", "data", "Lcom/yandex/div2/DivData;", "expressionResolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "getOrCreate$div_release", "invalidateTimersSet", "", "timers", "", "Lcom/yandex/div2/DivTimer;", "errorCollector", "Lcom/yandex/div/core/view2/errors/ErrorCollector;", "toTimerController", "Lcom/yandex/div/core/timer/TimerController;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@DivScope
public final class DivTimerEventDispatcherProvider {
    private final Map<String, DivTimerEventDispatcher> controllers;
    private final DivActionBinder divActionBinder;
    private final ErrorCollectors errorCollectors;

    @Inject
    public DivTimerEventDispatcherProvider(DivActionBinder divActionBinder, ErrorCollectors errorCollectors) {
        Intrinsics.checkNotNullParameter(divActionBinder, "divActionBinder");
        Intrinsics.checkNotNullParameter(errorCollectors, "errorCollectors");
        this.divActionBinder = divActionBinder;
        this.errorCollectors = errorCollectors;
        this.controllers = Collections.synchronizedMap(new LinkedHashMap());
    }

    public final DivTimerEventDispatcher getOrCreate$div_release(DivDataTag dataTag, DivData data, ExpressionResolver expressionResolver) {
        Intrinsics.checkNotNullParameter(dataTag, "dataTag");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(expressionResolver, "expressionResolver");
        List<DivTimer> list = data.timers;
        if (list == null) {
            return null;
        }
        ErrorCollector orCreate = this.errorCollectors.getOrCreate(dataTag, data);
        Map<String, DivTimerEventDispatcher> controllers = this.controllers;
        Intrinsics.checkNotNullExpressionValue(controllers, "controllers");
        String id = dataTag.getId();
        DivTimerEventDispatcher divTimerEventDispatcher = controllers.get(id);
        if (divTimerEventDispatcher == null) {
            divTimerEventDispatcher = new DivTimerEventDispatcher(orCreate);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                divTimerEventDispatcher.addTimerController(toTimerController((DivTimer) it.next(), orCreate, expressionResolver));
            }
            controllers.put(id, divTimerEventDispatcher);
        }
        DivTimerEventDispatcher divTimerEventDispatcher2 = divTimerEventDispatcher;
        invalidateTimersSet(divTimerEventDispatcher2, list, orCreate, expressionResolver);
        return divTimerEventDispatcher2;
    }

    private final TimerController toTimerController(DivTimer divTimer, ErrorCollector errorCollector, ExpressionResolver expressionResolver) {
        return new TimerController(divTimer, this.divActionBinder, errorCollector, expressionResolver);
    }

    private final void invalidateTimersSet(DivTimerEventDispatcher divTimerEventDispatcher, List<DivTimer> list, ErrorCollector errorCollector, ExpressionResolver expressionResolver) {
        List<DivTimer> list2 = list;
        for (DivTimer divTimer : list2) {
            if (divTimerEventDispatcher.getTimerController(divTimer.id) == null) {
                divTimerEventDispatcher.addTimerController(toTimerController(divTimer, errorCollector, expressionResolver));
            }
        }
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((DivTimer) it.next()).id);
        }
        divTimerEventDispatcher.setActiveTimerIds(arrayList);
    }
}
