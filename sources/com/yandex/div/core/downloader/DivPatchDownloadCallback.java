package com.yandex.div.core.downloader;

import com.yandex.div.core.DivActionHandler;
import com.yandex.div2.DivPatch;
import kotlin.Metadata;

/* JADX INFO: compiled from: DivPatchDownloadCallback.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Lcom/yandex/div/core/downloader/DivPatchDownloadCallback;", "", "onFail", "", "onSuccess", DivActionHandler.DivActionReason.PATCH, "Lcom/yandex/div2/DivPatch;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface DivPatchDownloadCallback {
    void onFail();

    void onSuccess(DivPatch patch);
}
