package com.yandex.div.histogram;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HistogramCallTypeChecker.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005R'\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/yandex/div/histogram/HistogramCallTypeChecker;", "", "()V", "reportedHistograms", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "getReportedHistograms", "()Ljava/util/concurrent/ConcurrentHashMap;", "reportedHistograms$delegate", "Lkotlin/Lazy;", "addReported", "", "histogramName", "div-histogram_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class HistogramCallTypeChecker {

    /* JADX INFO: renamed from: reportedHistograms$delegate, reason: from kotlin metadata */
    private final Lazy reportedHistograms = LazyKt.lazy(new Function0<ConcurrentHashMap<String, Unit>>() { // from class: com.yandex.div.histogram.HistogramCallTypeChecker$reportedHistograms$2
        @Override // kotlin.jvm.functions.Function0
        public final ConcurrentHashMap<String, Unit> invoke() {
            return new ConcurrentHashMap<>();
        }
    });

    private final ConcurrentHashMap<String, Unit> getReportedHistograms() {
        return (ConcurrentHashMap) this.reportedHistograms.getValue();
    }

    public final boolean addReported(String histogramName) {
        Intrinsics.checkNotNullParameter(histogramName, "histogramName");
        return !getReportedHistograms().containsKey(histogramName) && getReportedHistograms().putIfAbsent(histogramName, Unit.INSTANCE) == null;
    }
}
