package com.yandex.div.histogram;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HistogramCallTypeProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0007R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yandex/div/histogram/HistogramCallTypeProvider;", "Lcom/yandex/div/histogram/HistogramCallTypeChecker;", "histogramColdTypeChecker", "Lkotlin/Function0;", "Lcom/yandex/div/histogram/HistogramColdTypeChecker;", "(Lkotlin/jvm/functions/Function0;)V", "getHistogramCallType", "", "histogramName", "div-histogram_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class HistogramCallTypeProvider extends HistogramCallTypeChecker {
    private final Function0<HistogramColdTypeChecker> histogramColdTypeChecker;

    public HistogramCallTypeProvider(Function0<HistogramColdTypeChecker> histogramColdTypeChecker) {
        Intrinsics.checkNotNullParameter(histogramColdTypeChecker, "histogramColdTypeChecker");
        this.histogramColdTypeChecker = histogramColdTypeChecker;
    }

    @HistogramCallType
    public final String getHistogramCallType(String histogramName) {
        Intrinsics.checkNotNullParameter(histogramName, "histogramName");
        if (this.histogramColdTypeChecker.invoke().addReported(histogramName)) {
            addReported(histogramName);
            return "Cold";
        }
        if (addReported(histogramName)) {
            return "Cool";
        }
        return "Warm";
    }
}
