package com.yandex.div.histogram.metrics;

import com.yandex.div.core.timer.TimerController;
import kotlin.Metadata;

/* JADX INFO: compiled from: RenderMetrics.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\u0013R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u001e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u001e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u001e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/yandex/div/histogram/metrics/RenderMetrics;", "", "()V", "<set-?>", "", "bindingMs", "getBindingMs", "()J", "drawMs", "getDrawMs", "layoutMs", "getLayoutMs", "measureMs", "getMeasureMs", "rebindingMs", "getRebindingMs", "totalMs", "getTotalMs", "addDraw", "", "duration", "addLayout", "addMeasure", "binding", "rebinding", TimerController.RESET_COMMAND, "div-histogram_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RenderMetrics {
    private long bindingMs;
    private long drawMs;
    private long layoutMs;
    private long measureMs;
    private long rebindingMs;

    public final long getBindingMs() {
        return this.bindingMs;
    }

    public final long getRebindingMs() {
        return this.rebindingMs;
    }

    public final long getMeasureMs() {
        return this.measureMs;
    }

    public final long getLayoutMs() {
        return this.layoutMs;
    }

    public final long getDrawMs() {
        return this.drawMs;
    }

    public final long getTotalMs() {
        return Math.max(this.bindingMs, this.rebindingMs) + this.measureMs + this.layoutMs + this.drawMs;
    }

    public final void binding(long duration) {
        this.bindingMs = duration;
    }

    public final void rebinding(long duration) {
        this.rebindingMs = duration;
    }

    public final void addMeasure(long duration) {
        this.measureMs += duration;
    }

    public final void addLayout(long duration) {
        this.layoutMs += duration;
    }

    public final void addDraw(long duration) {
        this.drawMs += duration;
    }

    public final void reset() {
        this.measureMs = 0L;
        this.layoutMs = 0L;
        this.drawMs = 0L;
        this.bindingMs = 0L;
        this.rebindingMs = 0L;
    }
}
