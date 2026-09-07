package io.bidmachine.util.file;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import com.json.uc;
import java.io.File;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FileUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0016\u0010\u0007\u001a\u00020\u0001*\u0004\u0018\u00010\u00012\b\b\u0002\u0010\b\u001a\u00020\u0003\u001a\f\u0010\t\u001a\u00020\n*\u0004\u0018\u00010\u0001\u001a\u0012\u0010\u000b\u001a\u00020\f*\u00020\u00012\u0006\u0010\r\u001a\u00020\u0003\u001a\n\u0010\u000e\u001a\u00020\f*\u00020\u0001\u001a\f\u0010\u000f\u001a\u0004\u0018\u00010\u0001*\u00020\u0010\u001a\f\u0010\u0011\u001a\u0004\u0018\u00010\u0001*\u00020\u0010\u001a\f\u0010\u0012\u001a\u00020\n*\u0004\u0018\u00010\u0001\u001a\f\u0010\u0013\u001a\u0004\u0018\u00010\u0003*\u00020\u0001\u001a\u0012\u0010\u0014\u001a\u00020\n*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0001\u001a\u0012\u0010\u0016\u001a\u00020\n*\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0003\u001a\u000e\u0010\u0018\u001a\u0004\u0018\u00010\u0019*\u0004\u0018\u00010\u0001\u001a\u0012\u0010\u001a\u001a\u00020\n*\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u0003¨\u0006\u001c"}, d2 = {"createFile", "Ljava/io/File;", "childPathname", "", "createFileByUrl", "url", "createSubDir", "createTempFile", "tempFilePrefix", uc.b.b, "", "deleteFiles", "", "filePrefix", "deleteTempFiles", "getExternalDir", "Landroid/content/Context;", "getExternalDirDirty", "isNullOrEmpty", "readSafely", "renameToSafely", "to", "startWith", "prefix", "toUri", "Landroid/net/Uri;", "writeSafely", "text", "bidmachine-android-util_d_0_4_0"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class FileUtilsKt {
    public static final boolean isNullOrEmpty(File file) {
        return file == null || !file.exists() || file.length() <= 0;
    }

    public static final boolean startWith(File file, String prefix) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "name");
        return StringsKt.startsWith$default(name, prefix, false, 2, (Object) null);
    }

    public static final String readSafely(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        try {
            return FilesKt.readText$default(file, null, 1, null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final boolean writeSafely(File file, String text) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Boolean bool = null;
        try {
            FilesKt.writeText$default(file, text, null, 2, null);
            bool = true;
        } catch (Throwable unused) {
        }
        return Intrinsics.areEqual((Object) bool, (Object) true);
    }

    public static final Uri toUri(File file) {
        if (file == null) {
            return null;
        }
        try {
            return Uri.fromFile(file);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final File createFile(File file, String childPathname) {
        Intrinsics.checkNotNullParameter(childPathname, "childPathname");
        return new File(file, childPathname);
    }

    public static final File createSubDir(File file, String childPathname) {
        Intrinsics.checkNotNullParameter(childPathname, "childPathname");
        File fileCreateFile = createFile(file, childPathname);
        if (fileCreateFile.exists() || fileCreateFile.mkdirs()) {
            return fileCreateFile;
        }
        return null;
    }

    public static final File createTempFile(File file, String tempFilePrefix) {
        Intrinsics.checkNotNullParameter(tempFilePrefix, "tempFilePrefix");
        return createFile(file, tempFilePrefix + System.nanoTime());
    }

    public static /* synthetic */ File createTempFile$default(File file, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "temp";
        }
        return createTempFile(file, str);
    }

    public static final File createFileByUrl(File file, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        String strGenerateFileName = FileUtils.generateFileName(url);
        if (strGenerateFileName != null) {
            return createFile(file, strGenerateFileName);
        }
        return null;
    }

    public static final boolean renameToSafely(File file, File to) {
        Boolean boolValueOf;
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(to, "to");
        try {
            boolValueOf = Boolean.valueOf(file.renameTo(to));
        } catch (Throwable unused) {
            boolValueOf = null;
        }
        return Intrinsics.areEqual((Object) boolValueOf, (Object) true);
    }

    public static final void deleteFiles(File file, String filePrefix) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(filePrefix, "filePrefix");
        new PrefixCleanStrategy(filePrefix).clean(file);
    }

    public static final void deleteTempFiles(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        deleteFiles(file, "temp");
    }

    public static final boolean deleteFile(File file) {
        Boolean boolValueOf;
        File[] fileArrListFiles;
        if (file == null || !file.exists()) {
            return true;
        }
        try {
            if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                Intrinsics.checkNotNullExpressionValue(fileArrListFiles, "listFiles()");
                for (File file2 : fileArrListFiles) {
                    FileUtils.deleteFile(file2);
                }
            }
            boolValueOf = Boolean.valueOf(file.delete());
        } catch (Throwable unused) {
            boolValueOf = null;
        }
        return Intrinsics.areEqual((Object) boolValueOf, (Object) true);
    }

    public static final File getExternalDir(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (FileUtils.canUseExternalFilesDir()) {
            return context.getExternalFilesDir(null);
        }
        return null;
    }

    public static final File getExternalDirDirty(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        try {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory == null) {
                return null;
            }
            Intrinsics.checkNotNullExpressionValue(externalStorageDirectory, "Environment.getExternalS…irectory() ?: return null");
            return new File(externalStorageDirectory, "/Android/data/" + context.getPackageName() + "/files");
        } catch (Throwable unused) {
            return null;
        }
    }
}
