package com.yandex.div.core.view2;

import com.yandex.div.DivDataTag;
import com.yandex.div.core.dagger.DivViewScope;
import com.yandex.div2.DivData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewBindingProvider.kt */
/* JADX INFO: loaded from: classes11.dex */
@DivViewScope
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u001a\u0010\t\u001a\u00020\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/yandex/div/core/view2/ViewBindingProvider;", "", "()V", "current", "Lcom/yandex/div/core/view2/Binding;", "observers", "", "Lkotlin/Function1;", "", "observeAndGet", "observer", "update", "tag", "Lcom/yandex/div/DivDataTag;", "data", "Lcom/yandex/div2/DivData;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ViewBindingProvider {
    private Binding current;
    private final List<Function1<Binding, Unit>> observers;

    @Inject
    public ViewBindingProvider() {
        DivDataTag INVALID = DivDataTag.INVALID;
        Intrinsics.checkNotNullExpressionValue(INVALID, "INVALID");
        this.current = new Binding(INVALID, null);
        this.observers = new ArrayList();
    }

    public final void update(DivDataTag tag, DivData data) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (Intrinsics.areEqual(tag, this.current.getTag()) && this.current.getData() == data) {
            return;
        }
        this.current = new Binding(tag, data);
        Iterator<T> it = this.observers.iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(this.current);
        }
    }

    public final void observeAndGet(Function1<? super Binding, Unit> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        observer.invoke(this.current);
        this.observers.add(observer);
    }
}
