package com.yandex.div.internal.viewpool;

import androidx.collection.ArrayMap;
import com.safedk.android.analytics.brandsafety.l;
import com.yandex.div.core.timer.TimerController;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProfilingSession.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0002\u0015\u0016B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/yandex/div/internal/viewpool/ProfilingSession;", "", "()V", "mBlockedViewAccumulators", "Landroidx/collection/ArrayMap;", "", "Lcom/yandex/div/internal/viewpool/ProfilingSession$Accumulator;", "mLongRequestAccumulator", "mOverallTimeAccumulator", "clear", "", "flush", "", "hasLongEvents", "", "viewObtainedWithBlock", "viewName", "durationNs", "", "viewObtainedWithoutBlock", "viewRequested", "Accumulator", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ProfilingSession {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long LONG_OPERATION_THRESHOLD_NS = 1000000;
    private final Accumulator mOverallTimeAccumulator = new Accumulator();
    private final Accumulator mLongRequestAccumulator = new Accumulator();
    private final ArrayMap<String, Accumulator> mBlockedViewAccumulators = new ArrayMap<>();

    /* JADX INFO: compiled from: ProfilingSession.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/yandex/div/internal/viewpool/ProfilingSession$Companion;", "", "()V", "LONG_OPERATION_THRESHOLD_NS", "", "toMicroseconds", "timeNs", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final long toMicroseconds(long timeNs) {
            return timeNs / 1000;
        }
    }

    public final void viewObtainedWithoutBlock(long durationNs) {
        this.mOverallTimeAccumulator.addAndIncrement(durationNs);
    }

    public final void viewObtainedWithBlock(String viewName, long durationNs) {
        Intrinsics.checkNotNullParameter(viewName, "viewName");
        this.mOverallTimeAccumulator.addAndIncrement(durationNs);
        ArrayMap<String, Accumulator> arrayMap = this.mBlockedViewAccumulators;
        Accumulator accumulator = arrayMap.get(viewName);
        if (accumulator == null) {
            accumulator = new Accumulator();
            arrayMap.put(viewName, accumulator);
        }
        accumulator.addAndIncrement(durationNs);
    }

    public final void viewRequested(long durationNs) {
        this.mOverallTimeAccumulator.add(durationNs);
        if (durationNs >= 1000000) {
            this.mLongRequestAccumulator.addAndIncrement(durationNs);
        }
    }

    public final boolean hasLongEvents() {
        if (this.mLongRequestAccumulator.getCount() > 0) {
            return true;
        }
        Iterator<Map.Entry<String, Accumulator>> it = this.mBlockedViewAccumulators.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().getCount() > 0) {
                return true;
            }
        }
        return false;
    }

    public final Map<String, Object> flush() {
        HashMap map = new HashMap();
        map.put("view obtaining - total count", Integer.valueOf(this.mOverallTimeAccumulator.getCount()));
        map.put("view obtaining - total time (µs)", Long.valueOf(ProfilingSessionKt.roundRoughly(INSTANCE.toMicroseconds(this.mOverallTimeAccumulator.getAccumulated()))));
        for (Map.Entry<String, Accumulator> entry : this.mBlockedViewAccumulators.entrySet()) {
            String key = entry.getKey();
            Accumulator value = entry.getValue();
            if (value.getCount() > 0) {
                map.put("blocking view obtaining for " + key + " - count", Integer.valueOf(value.getCount()));
                map.put("blocking view obtaining for " + key + " - avg time (µs)", Long.valueOf(ProfilingSessionKt.roundRoughly(INSTANCE.toMicroseconds(value.getAvg()))));
            }
        }
        if (this.mLongRequestAccumulator.getCount() > 0) {
            map.put("long view requests - count", Integer.valueOf(this.mLongRequestAccumulator.getCount()));
            map.put("long view requests - avg time (µs)", Long.valueOf(ProfilingSessionKt.roundRoughly(INSTANCE.toMicroseconds(this.mLongRequestAccumulator.getAvg()))));
        }
        return map;
    }

    public final void clear() {
        this.mOverallTimeAccumulator.reset();
        this.mLongRequestAccumulator.reset();
        Iterator<Map.Entry<String, Accumulator>> it = this.mBlockedViewAccumulators.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().reset();
        }
    }

    /* JADX INFO: compiled from: ProfilingSession.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u000fR\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/yandex/div/internal/viewpool/ProfilingSession$Accumulator;", "", "()V", "<set-?>", "", "accumulated", "getAccumulated", "()J", "avg", "getAvg", "", "count", "getCount", "()I", l.l, "", "value", "addAndIncrement", TimerController.RESET_COMMAND, "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Accumulator {
        private long accumulated;
        private int count;

        public final long getAccumulated() {
            return this.accumulated;
        }

        public final int getCount() {
            return this.count;
        }

        public final long getAvg() {
            int i = this.count;
            if (i == 0) {
                return 0L;
            }
            return this.accumulated / ((long) i);
        }

        public final void add(long value) {
            this.accumulated += value;
        }

        public final void addAndIncrement(long value) {
            add(value);
            this.count++;
        }

        public final void reset() {
            this.accumulated = 0L;
            this.count = 0;
        }
    }
}
