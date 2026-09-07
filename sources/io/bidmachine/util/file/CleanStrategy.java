package io.bidmachine.util.file;

import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: compiled from: CleanStrategy.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Lio/bidmachine/util/file/CleanStrategy;", "", "canDelete", "", "file", "Ljava/io/File;", "clean", "", "dir", "bidmachine-android-util_d_0_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface CleanStrategy {
    boolean canDelete(File file);

    default void clean(File dir) {
        File[] fileArrListFiles;
        try {
            CleanStrategy cleanStrategy = this;
            if (dir == null || (fileArrListFiles = dir.listFiles()) == null) {
                return;
            }
            for (File file : fileArrListFiles) {
                if (file != null && canDelete(file)) {
                    FileUtils.deleteFile(file);
                }
            }
            Unit unit = Unit.INSTANCE;
        } catch (Throwable unused) {
        }
    }
}
