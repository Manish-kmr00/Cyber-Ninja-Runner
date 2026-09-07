package com.yandex.div.histogram;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RenderConfiguration.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B/\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/yandex/div/histogram/RenderConfiguration;", "", "measureFilter", "Lcom/yandex/div/histogram/HistogramFilter;", "layoutFilter", "drawFilter", "totalFilter", "(Lcom/yandex/div/histogram/HistogramFilter;Lcom/yandex/div/histogram/HistogramFilter;Lcom/yandex/div/histogram/HistogramFilter;Lcom/yandex/div/histogram/HistogramFilter;)V", "getDrawFilter", "()Lcom/yandex/div/histogram/HistogramFilter;", "getLayoutFilter", "getMeasureFilter", "getTotalFilter", "div-histogram_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RenderConfiguration {
    private final HistogramFilter drawFilter;
    private final HistogramFilter layoutFilter;
    private final HistogramFilter measureFilter;
    private final HistogramFilter totalFilter;

    public RenderConfiguration() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RenderConfiguration(HistogramFilter measureFilter) {
        this(measureFilter, null, null, null, 14, null);
        Intrinsics.checkNotNullParameter(measureFilter, "measureFilter");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RenderConfiguration(HistogramFilter measureFilter, HistogramFilter layoutFilter) {
        this(measureFilter, layoutFilter, null, null, 12, null);
        Intrinsics.checkNotNullParameter(measureFilter, "measureFilter");
        Intrinsics.checkNotNullParameter(layoutFilter, "layoutFilter");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RenderConfiguration(HistogramFilter measureFilter, HistogramFilter layoutFilter, HistogramFilter drawFilter) {
        this(measureFilter, layoutFilter, drawFilter, null, 8, null);
        Intrinsics.checkNotNullParameter(measureFilter, "measureFilter");
        Intrinsics.checkNotNullParameter(layoutFilter, "layoutFilter");
        Intrinsics.checkNotNullParameter(drawFilter, "drawFilter");
    }

    public RenderConfiguration(HistogramFilter measureFilter, HistogramFilter layoutFilter, HistogramFilter drawFilter, HistogramFilter totalFilter) {
        Intrinsics.checkNotNullParameter(measureFilter, "measureFilter");
        Intrinsics.checkNotNullParameter(layoutFilter, "layoutFilter");
        Intrinsics.checkNotNullParameter(drawFilter, "drawFilter");
        Intrinsics.checkNotNullParameter(totalFilter, "totalFilter");
        this.measureFilter = measureFilter;
        this.layoutFilter = layoutFilter;
        this.drawFilter = drawFilter;
        this.totalFilter = totalFilter;
    }

    public /* synthetic */ RenderConfiguration(HistogramFilter histogramFilter, HistogramFilter histogramFilter2, HistogramFilter histogramFilter3, HistogramFilter histogramFilter4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? HistogramFilter.INSTANCE.getOFF() : histogramFilter, (i & 2) != 0 ? HistogramFilter.INSTANCE.getOFF() : histogramFilter2, (i & 4) != 0 ? HistogramFilter.INSTANCE.getOFF() : histogramFilter3, (i & 8) != 0 ? HistogramFilter.INSTANCE.getON() : histogramFilter4);
    }

    public final HistogramFilter getMeasureFilter() {
        return this.measureFilter;
    }

    public final HistogramFilter getLayoutFilter() {
        return this.layoutFilter;
    }

    public final HistogramFilter getDrawFilter() {
        return this.drawFilter;
    }

    public final HistogramFilter getTotalFilter() {
        return this.totalFilter;
    }
}
