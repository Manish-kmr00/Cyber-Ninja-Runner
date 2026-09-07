package com.yandex.div.core.downloader;

import kotlin.Metadata;

/* JADX INFO: compiled from: PersistentDivDataObserver.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2 = {"Lcom/yandex/div/core/downloader/PersistentDivDataObserver;", "", "onAfterDivDataChanged", "", "onBeforeDivDataChanged", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface PersistentDivDataObserver {
    default void onAfterDivDataChanged() {
    }

    default void onBeforeDivDataChanged() {
    }
}
