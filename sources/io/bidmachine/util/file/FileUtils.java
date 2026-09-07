package io.bidmachine.util.file;

import android.content.Context;
import android.net.Uri;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.json.uc;
import io.bidmachine.util.Utils;
import io.bidmachine.util.UtilsKt;
import java.io.File;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: FileUtils.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u0004H\u0007J\u001c\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u001c\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u0004H\u0007J\u0012\u0010\u000e\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007J\u001c\u0010\u000e\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000f\u001a\u00020\u0004H\u0007J\u0012\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0007J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0004H\u0007J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\bH\u0007J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0012\u0010\u001b\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\bH\u0007J\u0018\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\bH\u0007J\u0018\u0010 \u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u0004H\u0007J\u0014\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0007J\u0018\u0010$\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lio/bidmachine/util/file/FileUtils;", "", "()V", "TEMP_PREFIX", "", "canUseExternalFilesDir", "", "createFile", "Ljava/io/File;", "dir", "childPathname", "createFileByUrl", "url", "createSubDir", "createTempFile", "tempFilePrefix", uc.b.b, "file", "deleteFiles", "", "filePrefix", "deleteTempFiles", "generateFileName", "getExternalDir", "context", "Landroid/content/Context;", "getExternalDirDirty", "isNullOrEmpty", "readSafely", "renameToSafely", TypedValues.TransitionType.S_FROM, "to", "startWith", "prefix", "toUri", "Landroid/net/Uri;", "writeSafely", "text", "bidmachine-android-util_d_0_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FileUtils {
    public static final FileUtils INSTANCE = new FileUtils();
    public static final String TEMP_PREFIX = "temp";

    private FileUtils() {
    }

    @JvmStatic
    public static final boolean isNullOrEmpty(File file) {
        return FileUtilsKt.isNullOrEmpty(file);
    }

    @JvmStatic
    public static final boolean startWith(File file, String prefix) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return FileUtilsKt.startWith(file, prefix);
    }

    @JvmStatic
    public static final String readSafely(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return FileUtilsKt.readSafely(file);
    }

    @JvmStatic
    public static final boolean writeSafely(File file, String text) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(text, "text");
        return FileUtilsKt.writeSafely(file, text);
    }

    @JvmStatic
    public static final Uri toUri(File file) {
        return FileUtilsKt.toUri(file);
    }

    @JvmStatic
    public static final File createFile(File dir, String childPathname) {
        Intrinsics.checkNotNullParameter(childPathname, "childPathname");
        return FileUtilsKt.createFile(dir, childPathname);
    }

    @JvmStatic
    public static final File createSubDir(File dir, String childPathname) {
        Intrinsics.checkNotNullParameter(childPathname, "childPathname");
        return FileUtilsKt.createSubDir(dir, childPathname);
    }

    @JvmStatic
    public static final File createTempFile(File dir) {
        return createTempFile(dir, "temp");
    }

    @JvmStatic
    public static final File createTempFile(File dir, String tempFilePrefix) {
        Intrinsics.checkNotNullParameter(tempFilePrefix, "tempFilePrefix");
        return FileUtilsKt.createTempFile(dir, tempFilePrefix);
    }

    public static /* synthetic */ File createTempFile$default(File file, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "temp";
        }
        return createTempFile(file, str);
    }

    @JvmStatic
    public static final File createFileByUrl(File dir, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return FileUtilsKt.createFileByUrl(dir, url);
    }

    @JvmStatic
    public static final String generateFileName(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        byte[] bytes = url.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] bArrApplyMD5 = UtilsKt.applyMD5(bytes);
        if (bArrApplyMD5 == null) {
            return null;
        }
        return new BigInteger(bArrApplyMD5).abs().toString(36);
    }

    @JvmStatic
    public static final boolean renameToSafely(File from, File to) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        return FileUtilsKt.renameToSafely(from, to);
    }

    @JvmStatic
    public static final void deleteFiles(File dir, String filePrefix) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        Intrinsics.checkNotNullParameter(filePrefix, "filePrefix");
        FileUtilsKt.deleteFiles(dir, filePrefix);
    }

    @JvmStatic
    public static final void deleteTempFiles(File dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        FileUtilsKt.deleteTempFiles(dir);
    }

    @JvmStatic
    public static final boolean deleteFile(File file) {
        return FileUtilsKt.deleteFile(file);
    }

    @JvmStatic
    public static final boolean canUseExternalFilesDir() {
        return Utils.isExternalMemoryAvailable();
    }

    @JvmStatic
    public static final File getExternalDir(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return FileUtilsKt.getExternalDir(context);
    }

    @JvmStatic
    public static final File getExternalDirDirty(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return FileUtilsKt.getExternalDirDirty(context);
    }
}
