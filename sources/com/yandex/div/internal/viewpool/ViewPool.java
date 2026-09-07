package com.yandex.div.internal.viewpool;

import android.view.View;
import kotlin.Metadata;

/* JADX INFO: compiled from: ViewPool.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001f\u0010\b\u001a\u0002H\t\"\b\b\u0000\u0010\t*\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u000bJ0\u0010\f\u001a\u00020\u0003\"\b\b\u0000\u0010\t*\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\t0\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Lcom/yandex/div/internal/viewpool/ViewPool;", "", "changeCapacity", "", "tag", "", "newCapacity", "", "obtain", "T", "Landroid/view/View;", "(Ljava/lang/String;)Landroid/view/View;", "register", "factory", "Lcom/yandex/div/internal/viewpool/ViewFactory;", "capacity", "unregister", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface ViewPool {
    void changeCapacity(String tag, int newCapacity);

    <T extends View> T obtain(String tag);

    <T extends View> void register(String tag, ViewFactory<T> factory, int capacity);

    void unregister(String tag);
}
