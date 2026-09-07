package com.yandex.div.internal.viewpool;

import android.view.View;
import com.yandex.div.internal.util.UtilsKt;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PseudoViewPool.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001f\u0010\r\u001a\u0002H\u000e\"\b\b\u0000\u0010\u000e*\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000fJ0\u0010\u0010\u001a\u00020\t\"\b\b\u0000\u0010\u000e*\u00020\u00072\u0006\u0010\n\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00062\u0006\u0010\u0012\u001a\u00020\fH\u0016J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016R\"\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/yandex/div/internal/viewpool/PseudoViewPool;", "Lcom/yandex/div/internal/viewpool/ViewPool;", "()V", "factoryMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/yandex/div/internal/viewpool/ViewFactory;", "Landroid/view/View;", "changeCapacity", "", "tag", "newCapacity", "", "obtain", "T", "(Ljava/lang/String;)Landroid/view/View;", "register", "factory", "capacity", "unregister", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PseudoViewPool implements ViewPool {
    private final ConcurrentHashMap<String, ViewFactory<? extends View>> factoryMap = new ConcurrentHashMap<>();

    @Override // com.yandex.div.internal.viewpool.ViewPool
    public void changeCapacity(String tag, int newCapacity) {
        Intrinsics.checkNotNullParameter(tag, "tag");
    }

    @Override // com.yandex.div.internal.viewpool.ViewPool
    public <T extends View> void register(String tag, ViewFactory<T> factory, int capacity) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(factory, "factory");
        this.factoryMap.put(tag, factory);
    }

    @Override // com.yandex.div.internal.viewpool.ViewPool
    public void unregister(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.factoryMap.remove(tag);
    }

    @Override // com.yandex.div.internal.viewpool.ViewPool
    public <T extends View> T obtain(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        T t = (T) ((ViewFactory) UtilsKt.getOrThrow$default(this.factoryMap, tag, null, 2, null)).createView();
        Intrinsics.checkNotNull(t, "null cannot be cast to non-null type T of com.yandex.div.internal.viewpool.PseudoViewPool.obtain");
        return t;
    }
}
