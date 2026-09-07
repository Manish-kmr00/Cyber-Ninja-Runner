package com.yandex.div.internal.viewpool;

import android.view.View;
import kotlin.Metadata;

/* JADX INFO: compiled from: ViewFactory.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\r\u0010\u0004\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Lcom/yandex/div/internal/viewpool/ViewFactory;", "T", "Landroid/view/View;", "", "createView", "()Landroid/view/View;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface ViewFactory<T extends View> {
    T createView();
}
