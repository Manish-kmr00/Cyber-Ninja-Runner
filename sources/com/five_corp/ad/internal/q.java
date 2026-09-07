package com.five_corp.ad.internal;

import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: loaded from: classes10.dex */
public final class q implements FilenameFilter {
    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        return str.startsWith("adcfg-") && !str.endsWith("_SUCCESS");
    }
}
