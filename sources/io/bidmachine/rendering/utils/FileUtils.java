package io.bidmachine.rendering.utils;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import io.bidmachine.rendering.internal.m;
import java.io.File;
import java.math.BigInteger;
import java.util.Date;

/* JADX INFO: loaded from: classes9.dex */
public class FileUtils {
    public static void clearTempFiles(Context context) {
        new PrefixCleanStrategy("temp").clean(getExternalDir(context));
    }

    public static boolean deleteFile(File file) {
        try {
            return file.delete();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String generateFileName(String url) {
        byte[] md5 = Utils.getMD5(url.getBytes());
        if (md5 == null) {
            return null;
        }
        return new BigInteger(md5).abs().toString(36);
    }

    public static File getExternalDir(Context context) {
        File externalFilesDir;
        if (!Utils.canUseExternalFilesDir(context) || (externalFilesDir = context.getExternalFilesDir(null)) == null) {
            return null;
        }
        File file = new File(externalFilesDir, "Rendering");
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    public static File getExternalFile(Context context, String fileName) {
        File externalDir;
        if (TextUtils.isEmpty(fileName) || (externalDir = getExternalDir(context)) == null) {
            return null;
        }
        return new File(externalDir, fileName);
    }

    public static File getFileByUrl(Context context, String url) {
        return getExternalFile(context, generateFileName(url));
    }

    public static boolean isEmpty(File file) {
        return file == null || !file.exists() || file.length() <= 0;
    }

    public static boolean isFileOlderThanDate(File file, Date date) {
        return new Date(file.lastModified()).before(date);
    }

    public static boolean startWith(File file, String prefix) {
        return file.getName().startsWith(prefix);
    }

    public static Uri toUri(File file) {
        if (file == null) {
            return null;
        }
        try {
            return Uri.fromFile(file);
        } catch (Throwable th) {
            m.b(th);
            return null;
        }
    }
}
