package io.bidmachine.util.file;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PrefixCleanStrategy.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lio/bidmachine/util/file/PrefixCleanStrategy;", "Lio/bidmachine/util/file/CleanStrategy;", "prefix", "", "(Ljava/lang/String;)V", "canDelete", "", "file", "Ljava/io/File;", "bidmachine-android-util_d_0_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PrefixCleanStrategy implements CleanStrategy {
    private final String prefix;

    public PrefixCleanStrategy(String prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        this.prefix = prefix;
    }

    @Override // io.bidmachine.util.file.CleanStrategy
    public boolean canDelete(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return FileUtils.startWith(file, this.prefix);
    }
}
