package com.bykv.vk.openvk.preload.geckox.utils;

import java.io.File;
import java.io.FileFilter;

/* JADX INFO: compiled from: ResVersionUtils.java */
/* JADX INFO: loaded from: classes9.dex */
public final class g {
    public static Long a(File file) {
        File[] fileArrListFiles = file.listFiles(new FileFilter() { // from class: com.bykv.vk.openvk.preload.geckox.utils.g.1
            @Override // java.io.FileFilter
            public final boolean accept(File file2) {
                return file2.isDirectory();
            }
        });
        Long lValueOf = null;
        if (fileArrListFiles != null && fileArrListFiles.length != 0) {
            for (File file2 : fileArrListFiles) {
                try {
                    long jLongValue = Long.valueOf(file2.getName()).longValue();
                    if (lValueOf == null) {
                        lValueOf = Long.valueOf(jLongValue);
                    } else if (jLongValue > lValueOf.longValue()) {
                        lValueOf = Long.valueOf(jLongValue);
                    }
                } catch (Exception unused) {
                }
            }
        }
        return lValueOf;
    }
}
