package net.pubnative.lite.sdk.utils;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes10.dex */
public class PNAsyncUtils {
    private static final String TAG = "PNAsyncUtils";
    private static final Executor sExecutor = AsyncTask.THREAD_POOL_EXECUTOR;
    private static final Handler sUiThreadHandler = new Handler(Looper.getMainLooper());

    @SafeVarargs
    public static <P> void safeExecuteOnExecutor(final AsyncTask<P, ?, ?> asyncTask, final P... pArr) {
        if (asyncTask != null) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                asyncTask.executeOnExecutor(sExecutor, pArr);
                return;
            } else {
                Logger.d(TAG, "Posting task for execution on main thread.");
                sUiThreadHandler.post(new Runnable() { // from class: net.pubnative.lite.sdk.utils.PNAsyncUtils.1
                    @Override // java.lang.Runnable
                    public void run() {
                        asyncTask.executeOnExecutor(PNAsyncUtils.sExecutor, pArr);
                    }
                });
                return;
            }
        }
        Logger.e(TAG, "Error executing an AsyncTask that is null.");
    }
}
