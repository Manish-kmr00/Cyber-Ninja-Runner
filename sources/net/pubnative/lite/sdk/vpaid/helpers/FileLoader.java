package net.pubnative.lite.sdk.vpaid.helpers;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.safedk.android.internal.partials.VerveNetworkBridge;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import net.pubnative.lite.sdk.utils.Logger;
import net.pubnative.lite.sdk.vpaid.PlayerInfo;
import net.pubnative.lite.sdk.vpaid.enums.VastError;
import net.pubnative.lite.sdk.vpaid.utils.FileUtils;
import net.pubnative.lite.sdk.vpaid.utils.Utils;

/* JADX INFO: loaded from: classes11.dex */
public class FileLoader {
    private static final int CONNECT_TIMEOUT = 10000;
    private static final String LOG_TAG = "FileLoader";
    private static final int READ_TIMEOUT = 10000;
    private static boolean useMobileNetworkForCaching;
    private boolean firstQuartile;
    private final Callback mCallback;
    private volatile HttpURLConnection mConnection;
    private final Context mContext;
    private boolean mIsEndCard;
    private volatile boolean mIsFileFullyDownloaded;
    private final File mLoadingFile;
    private final String mRemoteFileUrl;
    private volatile boolean mStop;
    private boolean midpoint;
    private boolean thirdQuartile;

    public interface Callback {
        void onError(PlayerInfo playerInfo);

        void onFileLoaded(String str);

        void onProgress(double d);
    }

    private static class FileHeaders {
        final Bitmap bitmap;
        final String eTag;
        final int fileLength;

        FileHeaders(String str, int i) {
            this.eTag = str;
            this.fileLength = i;
            this.bitmap = null;
        }

        FileHeaders(String str, int i, Bitmap bitmap) {
            this.eTag = str;
            this.fileLength = i;
            this.bitmap = bitmap;
        }
    }

    public FileLoader(String str, Context context, Callback callback, Boolean bool) {
        this.mCallback = callback;
        this.mContext = context;
        this.mRemoteFileUrl = str;
        this.mIsEndCard = bool.booleanValue();
        this.mLoadingFile = new File(FileUtils.getParentDir(context), FileUtils.obtainHashName(str));
    }

    public void start() {
        String str = LOG_TAG;
        Logger.d(str, "start");
        handleEmulator();
        Logger.d(str, "Use mobile network for caching: " + useMobileNetworkForCaching);
        if (TextUtils.isEmpty(this.mRemoteFileUrl)) {
            this.mCallback.onError(new PlayerInfo("FileUrl is empty"));
        } else if (this.mLoadingFile.exists()) {
            Logger.d(str, "File already exists");
            handleFileFullDownloaded();
        } else {
            maybeLoadFile();
        }
    }

    private void maybeLoadFile() {
        if (RequestParametersProvider.getConnectionType(this.mContext) != 2 && !useMobileNetworkForCaching) {
            Callback callback = this.mCallback;
            if (callback != null) {
                callback.onError(new PlayerInfo("Mobile network. File will not be cached"));
                return;
            }
            return;
        }
        ExecutorHelper.getExecutor().submit(new Runnable() { // from class: net.pubnative.lite.sdk.vpaid.helpers.FileLoader$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f$0.load();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void load() throws Throwable {
        try {
            if (this.mStop) {
                return;
            }
            FileHeaders fileHeadersObtainHeaders = obtainHeaders(this.mRemoteFileUrl);
            if (fileHeadersObtainHeaders == null) {
                Callback callback = this.mCallback;
                if (callback != null) {
                    callback.onError(new PlayerInfo("Error during loading file"));
                    return;
                }
                return;
            }
            Logger.d(LOG_TAG, "File length: " + fileHeadersObtainHeaders.fileLength);
            long jCurrentTimeMillis = System.currentTimeMillis();
            int iAppendFile = 0;
            int i = 0;
            while (!this.mStop && iAppendFile < fileHeadersObtainHeaders.fileLength) {
                iAppendFile = appendFile(this.mLoadingFile, this.mRemoteFileUrl, iAppendFile, fileHeadersObtainHeaders);
                i++;
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            String str = LOG_TAG;
            Logger.d(str, "Load time: " + (jCurrentTimeMillis2 / 1000.0d));
            Logger.d(str, "AttemptsCount: " + i);
            if (iAppendFile == fileHeadersObtainHeaders.fileLength) {
                handleFileFullDownloaded();
                return;
            }
            if (fileHeadersObtainHeaders.bitmap != null) {
                saveBitmapIntoFile(fileHeadersObtainHeaders.bitmap);
                handleFileFullDownloaded();
            } else {
                Callback callback2 = this.mCallback;
                if (callback2 != null) {
                    callback2.onError(new PlayerInfo("Error during file loading, attemptsCount: " + i));
                }
            }
        } catch (Exception e) {
            Logger.e(LOG_TAG, "Unexpected FileLoader error: " + e.getMessage());
        }
    }

    private void saveBitmapIntoFile(Bitmap bitmap) {
        new AndroidBmpUtil().save(bitmap, this.mLoadingFile.getAbsolutePath());
    }

    private int appendFile(File file, String str, int i, FileHeaders fileHeaders) throws Throwable {
        FileOutputStream fileOutputStream;
        InputStream inputStream = null;
        try {
            this.mConnection = obtainGetConnection(str, i, fileHeaders);
            InputStream inputStreamUrlConnectionGetInputStream = VerveNetworkBridge.urlConnectionGetInputStream(this.mConnection);
            try {
                fileOutputStream = new FileOutputStream(file, true);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i2 = inputStreamUrlConnectionGetInputStream.read(bArr);
                        if (i2 == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, i2);
                        i += i2;
                        handelProgress(((double) i) / ((double) fileHeaders.fileLength));
                    }
                    closeStream(inputStreamUrlConnectionGetInputStream);
                } catch (Exception e) {
                    e = e;
                    inputStream = inputStreamUrlConnectionGetInputStream;
                    try {
                        Logger.e(LOG_TAG, "appendFile interrupted: " + e.getMessage());
                        closeStream(inputStream);
                    } catch (Throwable th) {
                        th = th;
                        closeStream(inputStream);
                        closeStream(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = inputStreamUrlConnectionGetInputStream;
                    closeStream(inputStream);
                    closeStream(fileOutputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
        closeStream(fileOutputStream);
        return i;
    }

    private FileHeaders obtainHeaders(String str) {
        try {
            this.mConnection = (HttpURLConnection) new URL(str).openConnection();
            if (this.mConnection != null && this.mConnection.getHeaderFields() != null && this.mConnection.getHeaderFields().get("content-Length") != null && this.mConnection.getHeaderFields().get("content-Length").isEmpty()) {
                Logger.e(LOG_TAG, "File not found by URL: " + this.mRemoteFileUrl);
                ErrorLog.postError(this.mContext, VastError.TRAFFICKING);
                return null;
            }
            this.mConnection.setRequestMethod("GET");
            if (VerveNetworkBridge.httpUrlConnectionGetResponseCode(this.mConnection) == 200) {
                String headerField = this.mConnection.getHeaderField("ETag");
                int contentLength = this.mConnection.getContentLength();
                return new FileHeaders(headerField, contentLength, (contentLength == -1 && this.mIsEndCard) ? EndCardFileDownloader.mLoad(this.mRemoteFileUrl) : null);
            }
            if (VerveNetworkBridge.httpUrlConnectionGetResponseCode(this.mConnection) != 403 && VerveNetworkBridge.httpUrlConnectionGetResponseCode(this.mConnection) != 206 && VerveNetworkBridge.httpUrlConnectionGetResponseCode(this.mConnection) != 404) {
                return null;
            }
            Logger.e(LOG_TAG, "File not found by URL: " + this.mRemoteFileUrl);
            ErrorLog.postError(this.mContext, VastError.TRAFFICKING);
            return null;
        } catch (SocketTimeoutException unused) {
            Logger.e(LOG_TAG, "Timeout by URL: " + this.mRemoteFileUrl);
            ErrorLog.postError(this.mContext, VastError.TIMEOUT);
            return null;
        } catch (IOException unused2) {
            Logger.e(LOG_TAG, "File not found by URL: " + this.mRemoteFileUrl);
            ErrorLog.postError(this.mContext, VastError.FILE_NOT_FOUND);
            return null;
        } finally {
            if (this.mConnection != null) {
                VerveNetworkBridge.httpUrlConnectionDisconnect(this.mConnection);
            }
        }
    }

    private HttpURLConnection obtainGetConnection(String str, int i, FileHeaders fileHeaders) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setReadTimeout(10000);
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setRequestMethod("GET");
        return httpURLConnection;
    }

    private void handelProgress(double d) {
        Callback callback = this.mCallback;
        if (callback != null) {
            if (!this.firstQuartile) {
                if (d > 0.25d) {
                    this.firstQuartile = true;
                    callback.onProgress(0.25d);
                    return;
                }
                return;
            }
            if (!this.midpoint) {
                if (d > 0.5d) {
                    this.midpoint = true;
                    callback.onProgress(0.5d);
                    return;
                }
                return;
            }
            if (this.thirdQuartile || d <= 0.75d) {
                return;
            }
            this.thirdQuartile = true;
            callback.onProgress(0.75d);
        }
    }

    private void handleFileFullDownloaded() {
        this.mIsFileFullyDownloaded = true;
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: net.pubnative.lite.sdk.vpaid.helpers.FileLoader$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m9896x162a336a();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$handleFileFullDownloaded$0$net-pubnative-lite-sdk-vpaid-helpers-FileLoader, reason: not valid java name */
    /* synthetic */ void m9896x162a336a() {
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onFileLoaded(this.mLoadingFile.getAbsolutePath());
        }
    }

    public void stop() {
        File file;
        String str = LOG_TAG;
        Logger.e(str, "stop()");
        this.mStop = true;
        if (this.mConnection != null) {
            ExecutorHelper.getExecutor().submit(new Runnable() { // from class: net.pubnative.lite.sdk.vpaid.helpers.FileLoader$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m9897lambda$stop$1$netpubnativelitesdkvpaidhelpersFileLoader();
                }
            });
        }
        if (this.mIsFileFullyDownloaded || (file = this.mLoadingFile) == null || !file.exists()) {
            return;
        }
        Logger.e(str, "remove bad file");
        this.mLoadingFile.delete();
    }

    /* JADX INFO: renamed from: lambda$stop$1$net-pubnative-lite-sdk-vpaid-helpers-FileLoader, reason: not valid java name */
    /* synthetic */ void m9897lambda$stop$1$netpubnativelitesdkvpaidhelpersFileLoader() {
        Logger.e(LOG_TAG, "disconnect()");
        VerveNetworkBridge.httpUrlConnectionDisconnect(this.mConnection);
    }

    private void handleEmulator() {
        if (Utils.isEmulator()) {
            Logger.e(LOG_TAG, "running on emulator");
            useMobileNetworkForCaching = true;
        }
    }

    private static void closeStream(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                Logger.e(LOG_TAG, "Can't close stream");
            }
        }
    }

    public static void setUseMobileNetworkForCaching(boolean z) {
        useMobileNetworkForCaching = z;
    }
}
