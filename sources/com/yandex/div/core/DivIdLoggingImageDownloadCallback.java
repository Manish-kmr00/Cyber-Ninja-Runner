package com.yandex.div.core;

import com.yandex.div.core.images.DivImageDownloadCallback;
import com.yandex.div.core.view2.Div2View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivIdLoggingImageDownloadCallback.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yandex/div/core/DivIdLoggingImageDownloadCallback;", "Lcom/yandex/div/core/images/DivImageDownloadCallback;", "divView", "Lcom/yandex/div/core/view2/Div2View;", "(Lcom/yandex/div/core/view2/Div2View;)V", "divId", "", "(Ljava/lang/String;)V", "getAdditionalLogInfo", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class DivIdLoggingImageDownloadCallback extends DivImageDownloadCallback {
    private final String divId;

    public DivIdLoggingImageDownloadCallback(String divId) {
        Intrinsics.checkNotNullParameter(divId, "divId");
        this.divId = divId;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DivIdLoggingImageDownloadCallback(Div2View divView) {
        this(divView.getLogId());
        Intrinsics.checkNotNullParameter(divView, "divView");
    }

    @Override // com.yandex.div.core.images.DivImageDownloadCallback
    /* JADX INFO: renamed from: getAdditionalLogInfo, reason: from getter */
    public String getDivId() {
        return this.divId;
    }
}
