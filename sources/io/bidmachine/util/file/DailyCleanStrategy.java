package io.bidmachine.util.file;

import io.bidmachine.util.DateUtils;
import java.io.File;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DailyCleanStrategy.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lio/bidmachine/util/file/DailyCleanStrategy;", "Lio/bidmachine/util/file/CleanStrategy;", "()V", "daysCount", "", "(I)V", "date", "Ljava/util/Date;", "canDelete", "", "file", "Ljava/io/File;", "Companion", "bidmachine-android-util_d_0_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DailyCleanStrategy implements CleanStrategy {
    private static final int DEFAULT_DAYS_COUNT = 3;
    private final Date date;

    public DailyCleanStrategy(int i) {
        this.date = DateUtils.getDateDaysAgo(i);
    }

    public /* synthetic */ DailyCleanStrategy(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 3 : i);
    }

    public DailyCleanStrategy() {
        this(3);
    }

    @Override // io.bidmachine.util.file.CleanStrategy
    public boolean canDelete(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return DateUtils.isOlderThanDate(file.lastModified(), this.date);
    }
}
