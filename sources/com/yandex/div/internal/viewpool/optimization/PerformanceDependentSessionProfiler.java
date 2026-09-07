package com.yandex.div.internal.viewpool.optimization;

import com.yandex.div.core.dagger.DivScope;
import com.yandex.div.core.dagger.ExperimentFlag;
import com.yandex.div.core.experiments.Experiment;
import com.yandex.div.internal.KLog;
import com.yandex.div.logging.Severity;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PerformanceDependentSessionProfiler.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J.\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H\u0080\b¢\u0006\u0002\b\u0011J\u0006\u0010\u0012\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/yandex/div/internal/viewpool/optimization/PerformanceDependentSessionProfiler;", "", "isDebuggingViewPoolOptimization", "", "(Z)V", "session", "Lcom/yandex/div/internal/viewpool/optimization/PerformanceDependentSession;", "end", "onViewObtained", "", "viewName", "", "durationNs", "", "viewsLeft", "", "isObtainedWithBlock", "onViewObtained$div_release", "start", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@DivScope
public final class PerformanceDependentSessionProfiler {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String TAG = "PerformanceDependentSessionProfiler";
    private final boolean isDebuggingViewPoolOptimization;
    private PerformanceDependentSession session;

    @Inject
    public PerformanceDependentSessionProfiler(@ExperimentFlag(experiment = Experiment.VIEW_POOL_OPTIMIZATION_DEBUG) boolean z) {
        this.isDebuggingViewPoolOptimization = z;
    }

    public final void onViewObtained$div_release(String viewName, long durationNs, int viewsLeft, boolean isObtainedWithBlock) {
        Intrinsics.checkNotNullParameter(viewName, "viewName");
        PerformanceDependentSession performanceDependentSession = this.session;
        if (performanceDependentSession != null) {
            performanceDependentSession.viewObtained$div_release(viewName, durationNs, viewsLeft, isObtainedWithBlock);
        }
    }

    public final void start() {
        Unit unit;
        PerformanceDependentSession.Lightweight lightweight;
        PerformanceDependentSession performanceDependentSession = this.session;
        if (performanceDependentSession != null) {
            performanceDependentSession.clear$div_release();
            KLog kLog = KLog.INSTANCE;
            if (kLog.isAtLeast(Severity.WARNING)) {
                kLog.print(5, TAG, "PerformanceDependentSessionProfiler.start() was called, but session recording was already in progress, ignoring previous session");
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            if (this.isDebuggingViewPoolOptimization) {
                lightweight = new PerformanceDependentSession.Detailed();
            } else {
                lightweight = new PerformanceDependentSession.Lightweight();
            }
            this.session = lightweight;
        }
    }

    public final PerformanceDependentSession end() {
        PerformanceDependentSession performanceDependentSession = this.session;
        if (performanceDependentSession != null) {
            this.session = null;
            return performanceDependentSession;
        }
        KLog kLog = KLog.INSTANCE;
        if (kLog.isAtLeast(Severity.ERROR)) {
            kLog.print(6, TAG, "PerformanceDependentSessionProfiler.end() needs to be called after PerformanceDependentSessionProfiler.start()");
        }
        return null;
    }

    /* JADX INFO: compiled from: PerformanceDependentSessionProfiler.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/internal/viewpool/optimization/PerformanceDependentSessionProfiler$Companion;", "", "()V", "TAG", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
