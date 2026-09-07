package com.safedk.android.internal.partials;

import com.safedk.android.SafeDK;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.n;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/* JADX INFO: compiled from: LINESourceFile */
/* JADX INFO: loaded from: classes4.dex */
public class LINEFilesBridge {
    public static FileOutputStream fileOutputStreamCtor(File file) throws FileNotFoundException {
        Logger.d("LINEFiles|SafeDK: Partial-Files> Lcom/safedk/android/internal/partials/LINEFilesBridge;->fileOutputStreamCtor(Ljava/io/File;)Ljava/io/FileOutputStream;");
        if (!SafeDK.ae()) {
            Logger.d("SafeDKFiles", "fileOutputStreamCtor started SafeDK not initialized");
            return new FileOutputStream(file);
        }
        try {
            Logger.d("SafeDKFiles", new StringBuilder().append("fileOutputStreamCtor started, file = ").append(file).toString() != null ? file.getPath() : "NA, isOnUiThread = " + n.c());
        } catch (Throwable th) {
            Logger.d("SafeDKFiles", "fileOutputStreamCtor Exception : " + th.getMessage());
        }
        return CreativeInfoManager.a("com.five_corp.ad", file.getPath(), new FileOutputStream(file));
    }
}
