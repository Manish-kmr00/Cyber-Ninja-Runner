package io.bidmachine.rendering.utils;

import com.safedk.android.internal.partials.BidMachineFilesBridge;
import java.io.File;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes7.dex */
public class VideoUtils {
    public static void saveVideo(File file, byte[] byteVideo) throws Throwable {
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStreamFileOutputStreamCtor = BidMachineFilesBridge.fileOutputStreamCtor(file);
            try {
                fileOutputStreamFileOutputStreamCtor.write(byteVideo);
                io.bidmachine.iab.utils.Utils.flush(fileOutputStreamFileOutputStreamCtor);
                io.bidmachine.iab.utils.Utils.close(fileOutputStreamFileOutputStreamCtor);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStreamFileOutputStreamCtor;
                io.bidmachine.iab.utils.Utils.flush(fileOutputStream);
                io.bidmachine.iab.utils.Utils.close(fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
