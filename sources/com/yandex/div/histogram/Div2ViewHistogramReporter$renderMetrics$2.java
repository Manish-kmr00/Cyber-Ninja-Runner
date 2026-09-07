package com.yandex.div.histogram;

import com.yandex.div.histogram.metrics.RenderMetrics;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: Div2ViewHistogramReporter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
/* synthetic */ class Div2ViewHistogramReporter$renderMetrics$2 extends FunctionReferenceImpl implements Function0<RenderMetrics> {
    public static final Div2ViewHistogramReporter$renderMetrics$2 INSTANCE = new Div2ViewHistogramReporter$renderMetrics$2();

    Div2ViewHistogramReporter$renderMetrics$2() {
        super(0, RenderMetrics.class, "<init>", "<init>()V", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final RenderMetrics invoke() {
        return new RenderMetrics();
    }
}
