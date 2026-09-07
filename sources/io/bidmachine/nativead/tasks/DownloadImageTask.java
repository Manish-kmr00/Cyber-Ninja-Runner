package io.bidmachine.nativead.tasks;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.safedk.android.internal.partials.BidMachineFilesBridge;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.nativead.utils.ImageHelper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadImageTask implements Runnable {
    private static final String DIR_NAME = "native_cache_image";
    private static final int RESULT_FAIL = 0;
    private static final int RESULT_IMAGE_SUCCESS = 2;
    private static final int RESULT_PATH_SUCCESS = 1;
    private static final int SERVER_TIME_OUT = 20000;
    private File cacheDir;
    private Context context;
    private final Handler handler = new Handler(Looper.getMainLooper()) { // from class: io.bidmachine.nativead.tasks.DownloadImageTask.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (DownloadImageTask.this.listener != null) {
                int i = message.what;
                if (i == 0) {
                    DownloadImageTask.this.listener.onFail(DownloadImageTask.this);
                } else if (i == 1) {
                    DownloadImageTask.this.listener.onPathSuccess(DownloadImageTask.this, (Uri) message.obj);
                } else {
                    if (i != 2) {
                        return;
                    }
                    DownloadImageTask.this.listener.onImageSuccess(DownloadImageTask.this, (Bitmap) message.obj);
                }
            }
        }
    };
    private OnCacheImageListener listener;
    private String url;

    public interface OnCacheImageListener {
        void onFail(DownloadImageTask downloadImageTask);

        void onImageSuccess(DownloadImageTask downloadImageTask, Bitmap bitmap);

        void onPathSuccess(DownloadImageTask downloadImageTask, Uri uri);
    }

    public static Builder newBuilder(Context context, String str) {
        return new DownloadImageTask().new Builder(context, str);
    }

    public class Builder {
        public Builder(Context context, String str) {
            DownloadImageTask.this.context = context;
            DownloadImageTask.this.url = str;
        }

        public Builder setOnCacheImageListener(OnCacheImageListener onCacheImageListener) {
            DownloadImageTask.this.listener = onCacheImageListener;
            return this;
        }

        public DownloadImageTask build() {
            try {
                return DownloadImageTask.this;
            } finally {
                if (DownloadImageTask.this.context == null) {
                    if (DownloadImageTask.this.listener != null) {
                        DownloadImageTask.this.listener.onFail(DownloadImageTask.this);
                    }
                } else if (Utils.canUseExternalFilesDir()) {
                    DownloadImageTask downloadImageTask = DownloadImageTask.this;
                    downloadImageTask.cacheDir = Utils.getCacheDir(downloadImageTask.context, DownloadImageTask.DIR_NAME);
                }
            }
        }
    }

    private DownloadImageTask() {
    }

    @Override // java.lang.Runnable
    public void run() {
        if (TextUtils.isEmpty(this.url) || !Utils.isHttpUrl(this.url)) {
            sendFail();
            return;
        }
        String strReplace = this.url.replace(" ", "%20");
        this.url = strReplace;
        downloadImage(this.context, strReplace);
    }

    private void sendPathSuccess(Uri uri) {
        Handler handler = this.handler;
        if (handler != null) {
            this.handler.sendMessage(handler.obtainMessage(1, uri));
        }
    }

    private void sendImageSuccess(Bitmap bitmap) {
        Handler handler = this.handler;
        if (handler != null) {
            this.handler.sendMessage(handler.obtainMessage(2, bitmap));
        }
    }

    private void sendFail() {
        Handler handler = this.handler;
        if (handler != null) {
            handler.sendEmptyMessage(0);
        }
    }

    private void downloadImage(Context context, String str) {
        File file;
        ByteArrayOutputStream byteArrayOutputStream;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inJustDecodeBounds = true;
        InputStream inputStream = null;
        if (this.cacheDir != null) {
            file = new File(this.cacheDir, Utils.generateFileName(str));
            if (file.exists() && file.length() > 0) {
                sendPathSuccess(Uri.fromFile(file));
                return;
            }
        } else {
            file = null;
        }
        try {
            InputStream inputStream2 = ConnectionUtils.getInputStream(str, 20000);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(inputStream2.available());
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i = inputStream2.read(bArr);
                        if (i == -1) {
                            break;
                        } else {
                            byteArrayOutputStream.write(bArr, 0, i);
                        }
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
                    if (file != null) {
                        saveImage(file, byteArray, options);
                        sendPathSuccess(Uri.fromFile(file));
                    } else {
                        int iCalculateReqWidth = ImageHelper.calculateReqWidth(context);
                        options.inSampleSize = ImageHelper.calculateInSamplesSize(options, iCalculateReqWidth, ImageHelper.calculateReqHeight(iCalculateReqWidth));
                        Bitmap bitmapConvert = convert(byteArray, options);
                        if (bitmapConvert != null) {
                            sendImageSuccess(bitmapConvert);
                        } else {
                            sendFail();
                        }
                    }
                    Utils.flush(byteArrayOutputStream);
                    Utils.close(byteArrayOutputStream);
                    Utils.close(inputStream2);
                } catch (Throwable th) {
                    th = th;
                    inputStream = inputStream2;
                    try {
                        Logger.w(th);
                        sendFail();
                    } finally {
                        Utils.flush(byteArrayOutputStream);
                        Utils.close(byteArrayOutputStream);
                        Utils.close(inputStream);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
        }
    }

    private void saveImage(File file, byte[] bArr, BitmapFactory.Options options) throws Throwable {
        options.inJustDecodeBounds = false;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStreamFileOutputStreamCtor = BidMachineFilesBridge.fileOutputStreamCtor(file);
                try {
                    writeBitmap(bArr, options, fileOutputStreamFileOutputStreamCtor);
                    Utils.flush(fileOutputStreamFileOutputStreamCtor);
                    Utils.close(fileOutputStreamFileOutputStreamCtor);
                } catch (Exception e) {
                    e = e;
                    fileOutputStream = fileOutputStreamFileOutputStreamCtor;
                    Logger.w(e);
                    Utils.flush(fileOutputStream);
                    Utils.close(fileOutputStream);
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStreamFileOutputStreamCtor;
                    Utils.flush(fileOutputStream);
                    Utils.close(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0032: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:17:0x0032 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.Closeable, java.io.Flushable] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r3v0, types: [io.bidmachine.nativead.tasks.DownloadImageTask] */
    private Bitmap convert(byte[] bArr, BitmapFactory.Options options) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        Object obj;
        options.inJustDecodeBounds = false;
        ?? r0 = 0;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
                try {
                    writeBitmap(bArr, options, byteArrayOutputStream);
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
                    Utils.flush(byteArrayOutputStream);
                    Utils.close(byteArrayOutputStream);
                    return bitmapDecodeStream;
                } catch (Exception e) {
                    e = e;
                    Logger.w(e);
                    Utils.flush(byteArrayOutputStream);
                    Utils.close(byteArrayOutputStream);
                    return null;
                }
            } catch (Exception e2) {
                e = e2;
                byteArrayOutputStream = null;
            } catch (Throwable th) {
                th = th;
                Utils.flush(r0);
                Utils.close(r0);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            r0 = obj;
            Utils.flush(r0);
            Utils.close(r0);
            throw th;
        }
    }

    private void writeBitmap(byte[] bArr, BitmapFactory.Options options, OutputStream outputStream) {
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        bitmapDecodeByteArray.compress(Bitmap.CompressFormat.PNG, 85, outputStream);
        bitmapDecodeByteArray.recycle();
    }
}
