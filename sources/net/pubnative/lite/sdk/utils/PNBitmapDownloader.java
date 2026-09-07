package net.pubnative.lite.sdk.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import com.safedk.android.internal.partials.VerveNetworkBridge;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.RejectedExecutionException;
import net.pubnative.lite.sdk.utils.svgparser.SVG;

/* JADX INFO: loaded from: classes3.dex */
public class PNBitmapDownloader {
    private static final String TAG = "PNBitmapDownloader";
    private final Runnable downloadTask = new Runnable() { // from class: net.pubnative.lite.sdk.utils.PNBitmapDownloader.1
        HttpURLConnection connection = null;

        @Override // java.lang.Runnable
        public void run() {
            HttpURLConnection httpURLConnection;
            Bitmap bitmapDecodeStream;
            try {
                try {
                    try {
                        URL url = new URL(PNBitmapDownloader.this.mURL);
                        this.connection = (HttpURLConnection) url.openConnection();
                        InputStream inputStreamUrlConnectionGetInputStream = VerveNetworkBridge.urlConnectionGetInputStream(url.openConnection());
                        BitmapFactory.decodeStream(inputStreamUrlConnectionGetInputStream, new Rect(), PNBitmapDownloader.this.getBitmapOptionsDecodingBounds(true));
                        inputStreamUrlConnectionGetInputStream.close();
                        InputStream inputStreamUrlConnectionGetInputStream2 = VerveNetworkBridge.urlConnectionGetInputStream(url.openConnection());
                        if (url.openConnection().getContentType().equals("image/svg+xml")) {
                            Picture pictureRenderToPicture = SVG.getFromInputStream(inputStreamUrlConnectionGetInputStream2).renderToPicture();
                            bitmapDecodeStream = Bitmap.createBitmap(pictureRenderToPicture.getWidth(), pictureRenderToPicture.getHeight(), Bitmap.Config.ARGB_8888);
                            new Canvas(bitmapDecodeStream).drawPicture(pictureRenderToPicture);
                        } else {
                            bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamUrlConnectionGetInputStream2, null, PNBitmapDownloader.this.getBitmapOptionsDecodingBounds(false));
                        }
                        inputStreamUrlConnectionGetInputStream2.close();
                        PNBitmapLruCache.addBitmapToMemoryCache(PNBitmapDownloader.this.mURL, bitmapDecodeStream);
                        PNBitmapDownloader.this.invokeLoad(bitmapDecodeStream);
                        httpURLConnection = this.connection;
                        if (httpURLConnection == null) {
                            return;
                        }
                    } catch (RuntimeException e) {
                        PNBitmapDownloader.this.invokeFail(e);
                        httpURLConnection = this.connection;
                        if (httpURLConnection == null) {
                            return;
                        }
                    } catch (Exception e2) {
                        PNBitmapDownloader.this.invokeFail(e2);
                        httpURLConnection = this.connection;
                        if (httpURLConnection == null) {
                            return;
                        }
                    }
                } catch (Error e3) {
                    PNBitmapDownloader.this.invokeFail(new Exception(e3.toString()));
                    httpURLConnection = this.connection;
                    if (httpURLConnection == null) {
                        return;
                    }
                }
                VerveNetworkBridge.httpUrlConnectionDisconnect(httpURLConnection);
            } catch (Throwable th) {
                HttpURLConnection httpURLConnection2 = this.connection;
                if (httpURLConnection2 != null) {
                    VerveNetworkBridge.httpUrlConnectionDisconnect(httpURLConnection2);
                }
                throw th;
            }
        }
    };
    private final Runnable loadFromFileSystemTask = new Runnable() { // from class: net.pubnative.lite.sdk.utils.PNBitmapDownloader.2
        @Override // java.lang.Runnable
        public void run() {
            try {
                Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(Uri.parse(PNBitmapDownloader.this.mURL).getEncodedPath(), PNBitmapDownloader.this.getBitmapOptionsDecodingBounds(false));
                PNBitmapLruCache.addBitmapToMemoryCache(PNBitmapDownloader.this.mURL, bitmapDecodeFile);
                PNBitmapDownloader.this.invokeLoad(bitmapDecodeFile);
            } catch (Error e) {
                PNBitmapDownloader.this.invokeFail(new Exception(e.toString()));
            } catch (RuntimeException e2) {
                PNBitmapDownloader.this.invokeFail(e2);
            } catch (Exception e3) {
                PNBitmapDownloader.this.invokeFail(e3);
            }
        }
    };
    private DownloadListener mDownloadListener;
    private Handler mHandler;
    private int mHeight;
    private String mURL;
    private int mWidth;

    public interface DownloadListener {
        void onDownloadFailed(String str, Exception exc);

        void onDownloadFinish(String str, Bitmap bitmap);
    }

    public synchronized void download(String str, DownloadListener downloadListener) {
        download(str, 0, 0, downloadListener);
    }

    public synchronized void download(String str, int i, int i2, DownloadListener downloadListener) {
        this.mHandler = new Handler(Looper.getMainLooper());
        if (downloadListener == null) {
            Log.w(TAG, "download won't start since there is no assigned listener to It");
        } else {
            this.mDownloadListener = downloadListener;
            this.mURL = str;
            this.mWidth = i;
            this.mHeight = i2;
            if (TextUtils.isEmpty(str)) {
                invokeFail(new Exception("Image URL is empty"));
            } else if (URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) {
                downloadImage();
            } else if (URLUtil.isFileUrl(str)) {
                loadCachedImage();
            } else {
                invokeFail(new Exception("Wrong file URL!"));
            }
        }
    }

    private synchronized void downloadImage() {
        try {
            BitmapDownloaderExecutor.getExecutor().submit(this.downloadTask);
        } catch (RejectedExecutionException e) {
            Logger.e(TAG, "Task submission rejected: " + e.getMessage());
            invokeFail(e);
        }
    }

    private void loadCachedImage() {
        BitmapDownloaderExecutor.getExecutor().submit(this.loadFromFileSystemTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BitmapFactory.Options getBitmapOptionsDecodingBounds(boolean z) {
        int i;
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i2 = this.mWidth;
        if (i2 > 0 && (i = this.mHeight) > 0 && !z) {
            options.inSampleSize = calculateInSampleSize(options, i2, i);
        }
        options.inJustDecodeBounds = z;
        return options;
    }

    protected int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            int i6 = i3 / 2;
            int i7 = i4 / 2;
            while (i6 / i5 >= i2 && i7 / i5 >= i) {
                i5 *= 2;
            }
        }
        return i5;
    }

    protected void invokeLoad(final Bitmap bitmap) {
        this.mHandler.post(new Runnable() { // from class: net.pubnative.lite.sdk.utils.PNBitmapDownloader$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m9750x845d54aa(bitmap);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$invokeLoad$0$net-pubnative-lite-sdk-utils-PNBitmapDownloader, reason: not valid java name */
    /* synthetic */ void m9750x845d54aa(Bitmap bitmap) {
        DownloadListener downloadListener = this.mDownloadListener;
        this.mDownloadListener = null;
        if (downloadListener != null) {
            downloadListener.onDownloadFinish(this.mURL, bitmap);
        }
    }

    protected void invokeFail(final Exception exc) {
        this.mHandler.post(new Runnable() { // from class: net.pubnative.lite.sdk.utils.PNBitmapDownloader$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m9749xb92a02e3(exc);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$invokeFail$1$net-pubnative-lite-sdk-utils-PNBitmapDownloader, reason: not valid java name */
    /* synthetic */ void m9749xb92a02e3(Exception exc) {
        DownloadListener downloadListener = this.mDownloadListener;
        this.mDownloadListener = null;
        if (downloadListener != null) {
            downloadListener.onDownloadFailed(this.mURL, exc);
        }
    }
}
