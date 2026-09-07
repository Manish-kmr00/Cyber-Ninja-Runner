package com.yandex.div.internal.viewpool.optimization;

import com.safedk.android.analytics.events.CrashEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PerformanceDependentSession.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/yandex/div/internal/viewpool/optimization/MutableViewObtainmentStatistics;", "Lcom/yandex/div/internal/viewpool/optimization/PerformanceDependentSession$ViewObtainmentStatistics;", "()V", "currentSuccessiveBlocked", "", "maxSuccessiveBlocked", "getMaxSuccessiveBlocked", "()I", "setMaxSuccessiveBlocked", "(I)V", "minUnused", "getMinUnused", "()Ljava/lang/Integer;", "setMinUnused", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "clear", "", CrashEvent.e, "availableViews", "isObtainedWithBlock", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class MutableViewObtainmentStatistics extends PerformanceDependentSession.ViewObtainmentStatistics {
    private int currentSuccessiveBlocked;
    private int maxSuccessiveBlocked;
    private Integer minUnused;

    public MutableViewObtainmentStatistics() {
        super(null);
    }

    @Override // com.yandex.div.internal.viewpool.optimization.PerformanceDependentSession.ViewObtainmentStatistics
    public int getMaxSuccessiveBlocked() {
        return this.maxSuccessiveBlocked;
    }

    public void setMaxSuccessiveBlocked(int i) {
        this.maxSuccessiveBlocked = i;
    }

    @Override // com.yandex.div.internal.viewpool.optimization.PerformanceDependentSession.ViewObtainmentStatistics
    public Integer getMinUnused() {
        return this.minUnused;
    }

    public void setMinUnused(Integer num) {
        this.minUnused = num;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002b A[Catch: all -> 0x0036, TryCatch #0 {all -> 0x0036, blocks: (B:4:0x0003, B:6:0x000f, B:12:0x0032, B:7:0x0015, B:9:0x001e, B:11:0x002b), top: B:18:0x0001 }] */
    public final void report(int availableViews, boolean isObtainedWithBlock) {
        synchronized (this) {
            try {
                if (isObtainedWithBlock) {
                    int i = this.currentSuccessiveBlocked + 1;
                    this.currentSuccessiveBlocked = i;
                    if (i > getMaxSuccessiveBlocked()) {
                        setMaxSuccessiveBlocked(this.currentSuccessiveBlocked);
                    }
                } else {
                    this.currentSuccessiveBlocked = 0;
                    if (getMinUnused() != null) {
                        Integer minUnused = getMinUnused();
                        Intrinsics.checkNotNull(minUnused);
                        if (availableViews < minUnused.intValue()) {
                            setMinUnused(Integer.valueOf(availableViews));
                        }
                    } else {
                        setMinUnused(Integer.valueOf(availableViews));
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void clear() {
        synchronized (this) {
            setMaxSuccessiveBlocked(0);
            this.currentSuccessiveBlocked = 0;
            setMinUnused(0);
            Unit unit = Unit.INSTANCE;
        }
    }
}
