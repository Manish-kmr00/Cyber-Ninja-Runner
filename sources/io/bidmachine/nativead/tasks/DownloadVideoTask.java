package io.bidmachine.nativead.tasks;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import io.bidmachine.core.Utils;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadVideoTask implements Runnable {
    private static final String DIR_NAME = "native_video";
    private static final int RESULT_FAIL = 0;
    private static final int RESULT_SUCCESS = 1;
    private static final int SERVER_TIME_OUT = 20000;
    private File cacheDir;
    private final Handler handler = new Handler(Looper.getMainLooper()) { // from class: io.bidmachine.nativead.tasks.DownloadVideoTask.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (DownloadVideoTask.this.listener != null) {
                int i = message.what;
                if (i == 0) {
                    DownloadVideoTask.this.listener.onVideoLoadingError(DownloadVideoTask.this);
                } else {
                    if (i != 1) {
                        return;
                    }
                    DownloadVideoTask.this.listener.onVideoLoaded(DownloadVideoTask.this, (Uri) message.obj);
                }
            }
        }
    };
    private boolean initialized;
    private OnLoadedListener listener;
    private String videoUrl;

    public interface OnLoadedListener {
        void onVideoLoaded(DownloadVideoTask downloadVideoTask, Uri uri);

        void onVideoLoadingError(DownloadVideoTask downloadVideoTask);
    }

    public DownloadVideoTask(Context context, OnLoadedListener onLoadedListener, String str) {
        if (str == null || !Utils.canUseExternalFilesDir()) {
            onLoadedListener.onVideoLoadingError(this);
            return;
        }
        this.listener = onLoadedListener;
        this.videoUrl = str;
        if (Utils.canUseExternalFilesDir()) {
            this.cacheDir = Utils.getCacheDir(context, DIR_NAME);
            this.initialized = true;
        } else {
            onLoadedListener.onVideoLoadingError(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        if (!this.initialized) {
            sendFail();
            return;
        }
        File fileCacheVideoFile = CacheUtils.cacheVideoFile(this.videoUrl, this.cacheDir, 20000);
        if (fileCacheVideoFile != null) {
            sendSuccess(fileCacheVideoFile);
        } else {
            sendFail();
        }
    }

    private void sendSuccess(File file) {
        Handler handler = this.handler;
        if (handler != null) {
            this.handler.sendMessage(handler.obtainMessage(1, Uri.fromFile(file)));
        }
    }

    private void sendFail() {
        Handler handler = this.handler;
        if (handler != null) {
            handler.sendEmptyMessage(0);
        }
    }
}
