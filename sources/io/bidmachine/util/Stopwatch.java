package io.bidmachine.util;

import com.json.b9;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: Stopwatch.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\u0007J\r\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\nJ\u0006\u0010\u000b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eJ\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lio/bidmachine/util/Stopwatch;", "", "()V", "startTimeMs", "Ljava/util/concurrent/atomic/AtomicLong;", "timeMsList", "", "", "getLastTimeMs", "getLastTimeMsOrNull", "()Ljava/lang/Long;", "getStartTimeMs", "getTimeMs", b9.h.L, "", "getTimeMsOrNull", "(I)Ljava/lang/Long;", "getTrackCount", "start", "", "track", "bidmachine-android-util_d_0_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Stopwatch {
    private final List<Long> timeMsList = new CopyOnWriteArrayList();
    private final AtomicLong startTimeMs = new AtomicLong(System.currentTimeMillis());

    public final long getStartTimeMs() {
        return this.startTimeMs.get();
    }

    public final void start() {
        this.startTimeMs.set(System.currentTimeMillis());
        this.timeMsList.clear();
    }

    public final void track() {
        this.timeMsList.add(Long.valueOf(System.currentTimeMillis() - getStartTimeMs()));
        CollectionsKt.sort(this.timeMsList);
    }

    public final int getTrackCount() {
        return this.timeMsList.size();
    }

    public final long getTimeMs(int position) {
        Long l = (Long) CollectionsKt.getOrNull(this.timeMsList, position);
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    public final Long getTimeMsOrNull(int position) {
        return (Long) CollectionsKt.getOrNull(this.timeMsList, position);
    }

    public final long getLastTimeMs() {
        Long lastTimeMsOrNull = getLastTimeMsOrNull();
        if (lastTimeMsOrNull != null) {
            return lastTimeMsOrNull.longValue();
        }
        return 0L;
    }

    public final Long getLastTimeMsOrNull() {
        return (Long) CollectionsKt.lastOrNull((List) this.timeMsList);
    }
}
