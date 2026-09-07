package io.bidmachine.rendering.utils;

import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class PrefixCleanStrategy extends CleanStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12434a;

    public PrefixCleanStrategy(String prefix) {
        this.f12434a = prefix;
    }

    @Override // io.bidmachine.rendering.utils.CleanStrategy
    protected boolean a(File file) {
        return FileUtils.startWith(file, this.f12434a);
    }
}
