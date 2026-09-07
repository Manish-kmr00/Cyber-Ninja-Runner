package com.yandex.div.core.downloader;

import com.yandex.div2.DivData;
import kotlin.Metadata;

/* JADX INFO: compiled from: DivDataChangedObserver.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Lcom/yandex/div/core/downloader/DivDataChangedObserver;", "", "onDivPatchApplied", "", "divData", "Lcom/yandex/div2/DivData;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface DivDataChangedObserver {
    void onDivPatchApplied(DivData divData);
}
