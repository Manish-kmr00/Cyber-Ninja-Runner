package io.bidmachine.nativead.tasks;

import android.media.ThumbnailUtils;
import com.safedk.android.internal.partials.BidMachineFilesBridge;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes13.dex */
class CacheUtils {
    CacheUtils() {
    }

    static File cacheVideoFile(String str, File file, int i) throws Throwable {
        InputStream inputStream;
        InputStream inputStream2 = null;
        try {
            inputStream = ConnectionUtils.getInputStream(str, i);
            try {
                try {
                    File file2 = new File(file, Utils.generateFileName(str));
                    if (!file2.exists() || file2.length() <= 0 || !isVideoFileSupported(file2)) {
                        FileOutputStream fileOutputStreamFileOutputStreamCtor = BidMachineFilesBridge.fileOutputStreamCtor(file2);
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i2 = inputStream.read(bArr);
                            if (i2 <= 0) {
                                break;
                            }
                            fileOutputStreamFileOutputStreamCtor.write(bArr, 0, i2);
                        }
                        Utils.close(fileOutputStreamFileOutputStreamCtor);
                        if (isVideoFileSupported(file2)) {
                            Utils.close(inputStream);
                            return file2;
                        }
                    } else {
                        Utils.close(inputStream);
                        return file2;
                    }
                } catch (Throwable th) {
                    th = th;
                    inputStream2 = inputStream;
                    Utils.close(inputStream2);
                    throw th;
                }
            } catch (Exception e) {
                e = e;
                Logger.w(e);
            }
        } catch (Exception e2) {
            e = e2;
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            Utils.close(inputStream2);
            throw th;
        }
        Utils.close(inputStream);
        return null;
    }

    private static boolean isVideoFileSupported(File file) {
        return ThumbnailUtils.createVideoThumbnail(file.getPath(), 1) != null;
    }
}
