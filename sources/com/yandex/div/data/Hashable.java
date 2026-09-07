package com.yandex.div.data;

import kotlin.Metadata;

/* JADX INFO: compiled from: Hashable.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2 = {"Lcom/yandex/div/data/Hashable;", "", "hash", "", "propertiesHash", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface Hashable {
    int hash();

    default int propertiesHash() {
        return hash();
    }
}
