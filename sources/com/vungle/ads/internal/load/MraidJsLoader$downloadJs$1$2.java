package com.vungle.ads.internal.load;

import com.vungle.ads.MraidJsError;
import com.vungle.ads.internal.downloader.AssetDownloadListener;
import com.vungle.ads.internal.downloader.DownloadRequest;
import com.vungle.ads.internal.executor.VungleThreadPoolExecutor;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.util.FileUtility;
import com.vungle.ads.internal.util.Logger;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MraidJsLoader.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"com/vungle/ads/internal/load/MraidJsLoader$downloadJs$1$2", "Lcom/vungle/ads/internal/downloader/AssetDownloadListener;", "onError", "", "error", "Lcom/vungle/ads/internal/downloader/AssetDownloadListener$DownloadError;", "downloadRequest", "Lcom/vungle/ads/internal/downloader/DownloadRequest;", "onSuccess", "file", "Ljava/io/File;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MraidJsLoader$downloadJs$1$2 implements AssetDownloadListener {
    final /* synthetic */ AdPayload $advertisement;
    final /* synthetic */ VungleThreadPoolExecutor $executor;
    final /* synthetic */ File $jsPath;
    final /* synthetic */ File $mraidJsFile;

    MraidJsLoader$downloadJs$1$2(VungleThreadPoolExecutor vungleThreadPoolExecutor, AdPayload adPayload, File file, File file2) {
        this.$executor = vungleThreadPoolExecutor;
        this.$advertisement = adPayload;
        this.$jsPath = file;
        this.$mraidJsFile = file2;
    }

    @Override // com.vungle.ads.internal.downloader.AssetDownloadListener
    public void onError(final AssetDownloadListener.DownloadError error, final DownloadRequest downloadRequest) {
        Intrinsics.checkNotNullParameter(downloadRequest, "downloadRequest");
        VungleThreadPoolExecutor vungleThreadPoolExecutor = this.$executor;
        final AdPayload adPayload = this.$advertisement;
        final File file = this.$jsPath;
        vungleThreadPoolExecutor.execute(new Runnable() { // from class: com.vungle.ads.internal.load.MraidJsLoader$downloadJs$1$2$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                MraidJsLoader$downloadJs$1$2.m6051onError$lambda0(error, downloadRequest, adPayload, file);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onError$lambda-0, reason: not valid java name */
    public static final void m6051onError$lambda0(AssetDownloadListener.DownloadError downloadError, DownloadRequest downloadRequest, AdPayload adPayload, File jsPath) {
        Throwable cause;
        Intrinsics.checkNotNullParameter(downloadRequest, "$downloadRequest");
        Intrinsics.checkNotNullParameter(jsPath, "$jsPath");
        try {
            try {
                String str = "download mraid js error: " + (downloadError != null ? Integer.valueOf(downloadError.getServerCode()) : null) + ". Failed to load " + downloadRequest.getAsset().getServerPath() + ", reason: " + ((downloadError == null || (cause = downloadError.getCause()) == null) ? null : cause.getMessage());
                Logger.INSTANCE.d("MraidJsLoader", str);
                new MraidJsError(Sdk.SDKError.Reason.MRAID_DOWNLOAD_JS_ERROR, str).setLogEntry$vungle_ads_release(adPayload != null ? adPayload.getLogEntry() : null).logErrorNoReturnValue$vungle_ads_release();
                FileUtility.deleteContents(jsPath);
            } catch (Exception e) {
                Logger.INSTANCE.e("MraidJsLoader", "Failed to delete js assets", e);
            }
        } finally {
            MraidJsLoader.INSTANCE.notifyListeners(12);
        }
    }

    @Override // com.vungle.ads.internal.downloader.AssetDownloadListener
    public void onSuccess(final File file, DownloadRequest downloadRequest) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(downloadRequest, "downloadRequest");
        VungleThreadPoolExecutor vungleThreadPoolExecutor = this.$executor;
        final File file2 = this.$mraidJsFile;
        final AdPayload adPayload = this.$advertisement;
        final File file3 = this.$jsPath;
        vungleThreadPoolExecutor.execute(new Runnable() { // from class: com.vungle.ads.internal.load.MraidJsLoader$downloadJs$1$2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MraidJsLoader$downloadJs$1$2.m6052onSuccess$lambda1(file, file2, adPayload, file3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onSuccess$lambda-1, reason: not valid java name */
    public static final void m6052onSuccess$lambda1(File file, File mraidJsFile, AdPayload adPayload, File jsPath) {
        Intrinsics.checkNotNullParameter(file, "$file");
        Intrinsics.checkNotNullParameter(mraidJsFile, "$mraidJsFile");
        Intrinsics.checkNotNullParameter(jsPath, "$jsPath");
        try {
            if (file.exists() && file.length() > 0) {
                MraidJsLoader.INSTANCE.notifyListeners(10);
                return;
            }
            new MraidJsError(Sdk.SDKError.Reason.MRAID_JS_WRITE_FAILED, "Mraid js downloaded but write failure: " + mraidJsFile.getAbsolutePath()).setLogEntry$vungle_ads_release(adPayload != null ? adPayload.getLogEntry() : null).logErrorNoReturnValue$vungle_ads_release();
            FileUtility.deleteContents(jsPath);
            MraidJsLoader.INSTANCE.notifyListeners(12);
        } catch (Exception e) {
            Logger.INSTANCE.e("MraidJsLoader", "Failed to delete js assets", e);
            MraidJsLoader.INSTANCE.notifyListeners(12);
        }
    }
}
