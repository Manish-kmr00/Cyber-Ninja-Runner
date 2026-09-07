package net.pubnative.lite.sdk.vpaid.utils;

import android.content.Context;
import java.io.File;
import java.util.concurrent.Executors;
import net.pubnative.lite.sdk.utils.Logger;
import net.pubnative.lite.sdk.vpaid.VpaidConstants;

/* JADX INFO: loaded from: classes6.dex */
public class FileUtils {
    private static final String LOG_TAG = "FileUtils";
    private static File cachedParentDir;

    public static void deleteExpiredFiles(Context context) {
        File parentDir = getParentDir(context);
        if (parentDir == null) {
            return;
        }
        File[] fileArrListFiles = parentDir.listFiles();
        int i = 0;
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            int length = fileArrListFiles.length;
            int i2 = 0;
            while (i < length) {
                File file = fileArrListFiles[i];
                if (!file.isDirectory()) {
                    if (file.lastModified() + VpaidConstants.CACHED_VIDEO_LIFE_TIME < System.currentTimeMillis() || file.length() == 0) {
                        file.delete();
                        Logger.d(LOG_TAG, "Deleted cached file: " + file.getAbsolutePath());
                    } else {
                        i2++;
                    }
                }
                i++;
            }
            i = i2;
        }
        String str = LOG_TAG;
        Logger.d(str, "In cache " + i + " file(s)");
        Logger.d(str, "Cache time: 32 hours");
    }

    public static String obtainHashName(String str) {
        return Long.toString(((long) str.hashCode()) & 4294967295L);
    }

    public static File getParentDir(Context context) {
        File file = cachedParentDir;
        if (file != null) {
            return file;
        }
        if (context != null) {
            cachedParentDir = context.getExternalFilesDir(VpaidConstants.FILE_FOLDER);
        }
        return cachedParentDir;
    }

    public static void initParentDirAsync(final Context context) {
        if (context == null || cachedParentDir != null) {
            return;
        }
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: net.pubnative.lite.sdk.vpaid.utils.FileUtils$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                FileUtils.cachedParentDir = context.getExternalFilesDir(VpaidConstants.FILE_FOLDER);
            }
        });
    }

    public static void clearCache(Context context) {
        Logger.d(LOG_TAG, "Clear cache");
        File parentDir = getParentDir(context);
        if (parentDir == null) {
            return;
        }
        File[] fileArrListFiles = parentDir.listFiles();
        int i = 0;
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            int length = fileArrListFiles.length;
            int i2 = 0;
            while (i < length) {
                File file = fileArrListFiles[i];
                if (!file.isDirectory()) {
                    file.delete();
                    i2++;
                }
                i++;
            }
            i = i2;
        }
        Logger.d(LOG_TAG, "Deleted " + i + " file(s)");
    }
}
