package io.bidmachine.rendering.utils;

import java.io.File;

/* JADX INFO: loaded from: classes10.dex */
public abstract class CleanStrategy {
    protected abstract boolean a(File file);

    public void clean(File dir) {
        File[] fileArrListFiles;
        if (dir == null || (fileArrListFiles = dir.listFiles()) == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            if (file != null && a(file)) {
                FileUtils.deleteFile(file);
            }
        }
    }
}
