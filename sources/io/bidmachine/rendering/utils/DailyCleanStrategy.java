package io.bidmachine.rendering.utils;

import java.io.File;
import java.util.Date;

/* JADX INFO: loaded from: classes13.dex */
public class DailyCleanStrategy extends CleanStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Date f12428a;

    public DailyCleanStrategy() {
        this(3);
    }

    @Override // io.bidmachine.rendering.utils.CleanStrategy
    protected boolean a(File file) {
        return FileUtils.isFileOlderThanDate(file, this.f12428a);
    }

    public DailyCleanStrategy(int n) {
        this.f12428a = Utils.getDate(n);
    }
}
