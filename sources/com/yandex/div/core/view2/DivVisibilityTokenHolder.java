package com.yandex.div.core.view2;

import com.safedk.android.analytics.brandsafety.l;
import com.yandex.div2.DivSightAction;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivVisibilityTokenHolder.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u0006J.\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00062\u001e\u0010\u000f\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0011\u0012\u0004\u0012\u00020\u000e0\u0010R \u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/yandex/div/core/view2/DivVisibilityTokenHolder;", "", "()V", "tokens", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "", "Lcom/yandex/div/core/view2/CompositeLogId;", "Lcom/yandex/div2/DivSightAction;", l.l, "", "logIds", "getLogId", "logId", "remove", "", "emptyTokenCallback", "Lkotlin/Function1;", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivVisibilityTokenHolder {
    private final ConcurrentLinkedQueue<Map<CompositeLogId, DivSightAction>> tokens = new ConcurrentLinkedQueue<>();

    public final void remove(CompositeLogId logId, Function1<? super Map<CompositeLogId, ? extends DivSightAction>, Unit> emptyTokenCallback) {
        Object next;
        Intrinsics.checkNotNullParameter(logId, "logId");
        Intrinsics.checkNotNullParameter(emptyTokenCallback, "emptyTokenCallback");
        Iterator<T> it = this.tokens.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((Map) next).remove(logId) == null);
        Map map = (Map) next;
        if (map != null && map.isEmpty()) {
            emptyTokenCallback.invoke(map);
            this.tokens.remove(map);
        }
    }

    public final boolean add(Map<CompositeLogId, DivSightAction> logIds) {
        Intrinsics.checkNotNullParameter(logIds, "logIds");
        return this.tokens.add(logIds);
    }

    public final CompositeLogId getLogId(CompositeLogId logId) {
        Object next;
        Set setKeySet;
        Intrinsics.checkNotNullParameter(logId, "logId");
        Iterator<T> it = this.tokens.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((Map) next).containsKey(logId));
        Map map = (Map) next;
        if (map == null || (setKeySet = map.keySet()) == null) {
            return null;
        }
        CompositeLogId[] compositeLogIdArr = (CompositeLogId[]) setKeySet.toArray(new CompositeLogId[0]);
        if (compositeLogIdArr == null) {
            return null;
        }
        for (CompositeLogId compositeLogId : compositeLogIdArr) {
            if (Intrinsics.areEqual(compositeLogId, logId)) {
                return compositeLogId;
            }
        }
        return null;
    }
}
