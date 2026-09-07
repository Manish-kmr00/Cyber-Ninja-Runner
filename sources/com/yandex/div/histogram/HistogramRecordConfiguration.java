package com.yandex.div.histogram;

import javax.inject.Provider;
import kotlin.Metadata;

/* JADX INFO: compiled from: HistogramRecordConfiguration.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0004R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0012\u0010\u0007\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0004R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/histogram/HistogramRecordConfiguration;", "", "isColdRecordingEnabled", "", "()Z", "isCoolRecordingEnabled", "isSizeRecordingEnabled", "isWarmRecordingEnabled", "renderConfiguration", "Ljavax/inject/Provider;", "Lcom/yandex/div/histogram/RenderConfiguration;", "getRenderConfiguration", "()Ljavax/inject/Provider;", "div-histogram_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface HistogramRecordConfiguration {
    Provider<RenderConfiguration> getRenderConfiguration();

    boolean isColdRecordingEnabled();

    boolean isCoolRecordingEnabled();

    boolean isSizeRecordingEnabled();

    boolean isWarmRecordingEnabled();
}
