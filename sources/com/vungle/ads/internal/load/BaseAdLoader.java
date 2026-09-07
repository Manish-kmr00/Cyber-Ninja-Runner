package com.vungle.ads.internal.load;

import android.content.Context;
import com.json.nu;
import com.vungle.ads.AdExpiredError;
import com.vungle.ads.AdPayloadError;
import com.vungle.ads.AdResponseEmptyError;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.AssetDownloadError;
import com.vungle.ads.AssetRequestError;
import com.vungle.ads.AssetResponseDataError;
import com.vungle.ads.IndexHtmlError;
import com.vungle.ads.InvalidAssetUrlError;
import com.vungle.ads.InvalidEventIdError;
import com.vungle.ads.InvalidTemplateURLError;
import com.vungle.ads.MraidJsError;
import com.vungle.ads.NativeAssetError;
import com.vungle.ads.OmSdkJsError;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.SingleValueMetric;
import com.vungle.ads.TemplateUnzipError;
import com.vungle.ads.TimeIntervalMetric;
import com.vungle.ads.VungleError;
import com.vungle.ads.internal.ConfigManager;
import com.vungle.ads.internal.Constants;
import com.vungle.ads.internal.NativeAdInternal;
import com.vungle.ads.internal.downloader.AssetDownloadListener;
import com.vungle.ads.internal.downloader.DownloadRequest;
import com.vungle.ads.internal.downloader.Downloader;
import com.vungle.ads.internal.executor.Executors;
import com.vungle.ads.internal.model.AdAsset;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.model.ConfigPayload;
import com.vungle.ads.internal.network.TpatSender;
import com.vungle.ads.internal.network.VungleApiClient;
import com.vungle.ads.internal.omsdk.OMInjector;
import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.signals.SignalManager;
import com.vungle.ads.internal.util.FileUtility;
import com.vungle.ads.internal.util.LogEntry;
import com.vungle.ads.internal.util.Logger;
import com.vungle.ads.internal.util.PathProvider;
import com.vungle.ads.internal.util.UnzipUtility;
import com.vungle.ads.internal.util.Utils;
import com.yandex.div.core.timer.TimerController;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: BaseAdLoader.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\b&\u0018\u0000 b2\u00020\u0001:\u0001bB=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0006\u0010@\u001a\u00020AJ\b\u0010B\u001a\u00020AH\u0002J\u0018\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u0013H\u0002J\u0010\u0010H\u001a\u00020I2\u0006\u0010G\u001a\u00020\u0013H\u0002J\u0012\u0010J\u001a\u0004\u0018\u00010F2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\u001cH\u0002J\u0012\u0010N\u001a\u0004\u0018\u00010L2\u0006\u0010M\u001a\u00020\u001cH\u0002J!\u0010O\u001a\u00020A2\u0006\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010P\u001a\u0004\u0018\u000104H\u0000¢\u0006\u0002\bQJ\u0010\u0010R\u001a\u00020D2\u0006\u0010S\u001a\u00020FH\u0002J\u000e\u0010T\u001a\u00020A2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010U\u001a\u00020A2\u0006\u0010V\u001a\u00020LJ\b\u0010W\u001a\u00020AH&J\b\u0010X\u001a\u00020AH\u0002J\u0010\u0010Y\u001a\u00020A2\u0006\u0010Z\u001a\u00020\u000fH\u0003J\b\u0010[\u001a\u00020AH\u0002J\u001a\u0010\\\u001a\u00020D2\u0006\u0010]\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\b\u0010^\u001a\u00020AH$J\u0018\u0010_\u001a\u00020D2\u0006\u0010`\u001a\u00020F2\u0006\u0010S\u001a\u00020FH\u0002J\u0012\u0010a\u001a\u0004\u0018\u00010L2\u0006\u0010M\u001a\u00020\u001cH\u0002R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u00020#8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u000e\u00109\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u000e\u0010<\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?¨\u0006c²\u0006\n\u0010d\u001a\u00020eX\u008a\u0084\u0002"}, d2 = {"Lcom/vungle/ads/internal/load/BaseAdLoader;", "", "context", "Landroid/content/Context;", "vungleApiClient", "Lcom/vungle/ads/internal/network/VungleApiClient;", "sdkExecutors", "Lcom/vungle/ads/internal/executor/Executors;", "omInjector", "Lcom/vungle/ads/internal/omsdk/OMInjector;", "downloader", "Lcom/vungle/ads/internal/downloader/Downloader;", "pathProvider", "Lcom/vungle/ads/internal/util/PathProvider;", "adRequest", "Lcom/vungle/ads/internal/load/AdRequest;", "(Landroid/content/Context;Lcom/vungle/ads/internal/network/VungleApiClient;Lcom/vungle/ads/internal/executor/Executors;Lcom/vungle/ads/internal/omsdk/OMInjector;Lcom/vungle/ads/internal/downloader/Downloader;Lcom/vungle/ads/internal/util/PathProvider;Lcom/vungle/ads/internal/load/AdRequest;)V", "adAssets", "", "Lcom/vungle/ads/internal/model/AdAsset;", "adLoaderCallback", "Lcom/vungle/ads/internal/load/AdLoaderCallback;", "adOptionalDownloadDurationMetric", "Lcom/vungle/ads/TimeIntervalMetric;", "getAdRequest", "()Lcom/vungle/ads/internal/load/AdRequest;", "adRequiredDownloadDurationMetric", "advertisement", "Lcom/vungle/ads/internal/model/AdPayload;", "getAdvertisement$vungle_ads_release", "()Lcom/vungle/ads/internal/model/AdPayload;", "setAdvertisement$vungle_ads_release", "(Lcom/vungle/ads/internal/model/AdPayload;)V", "assetDownloadDurationMetric", "assetDownloadListener", "Lcom/vungle/ads/internal/downloader/AssetDownloadListener;", "getAssetDownloadListener", "()Lcom/vungle/ads/internal/downloader/AssetDownloadListener;", "getContext", "()Landroid/content/Context;", "downloadCount", "Ljava/util/concurrent/atomic/AtomicLong;", "downloadRequiredCount", "fullyDownloaded", "Ljava/util/concurrent/atomic/AtomicBoolean;", "logEntry", "Lcom/vungle/ads/internal/util/LogEntry;", "getLogEntry$vungle_ads_release", "()Lcom/vungle/ads/internal/util/LogEntry;", "setLogEntry$vungle_ads_release", "(Lcom/vungle/ads/internal/util/LogEntry;)V", "mainVideoSizeMetric", "Lcom/vungle/ads/SingleValueMetric;", "notifyFailed", "notifySuccess", "getPathProvider", "()Lcom/vungle/ads/internal/util/PathProvider;", "requiredAssetDownloaded", "getSdkExecutors", "()Lcom/vungle/ads/internal/executor/Executors;", "templateHtmlSizeMetric", "templateSizeMetric", "getVungleApiClient", "()Lcom/vungle/ads/internal/network/VungleApiClient;", TimerController.CANCEL_COMMAND, "", "downloadAssets", "fileIsValid", "", "file", "Ljava/io/File;", "adAsset", "getAssetPriority", "Lcom/vungle/ads/internal/downloader/DownloadRequest$Priority;", "getDestinationDir", "getErrorInfo", "Lcom/vungle/ads/VungleError;", "adPayload", "getTemplateError", "handleAdMetaData", "metric", "handleAdMetaData$vungle_ads_release", "injectMraidJS", "destinationDir", "loadAd", nu.b, "error", "onAdLoadReady", nu.f4097a, "onDownloadCompleted", "request", "onRequiredDownloadCompleted", "processVmTemplate", "asset", "requestAd", "unzipFile", "downloadedFile", "validateAdMetadata", "Companion", "vungle-ads_release", "signalManager", "Lcom/vungle/ads/internal/signals/SignalManager;"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class BaseAdLoader {
    private static final String DOWNLOADED_FILE_NOT_FOUND = "Downloaded file not found!";
    private static final String TAG = "BaseAdLoader";
    private final List<AdAsset> adAssets;
    private AdLoaderCallback adLoaderCallback;
    private TimeIntervalMetric adOptionalDownloadDurationMetric;
    private final AdRequest adRequest;
    private TimeIntervalMetric adRequiredDownloadDurationMetric;
    private AdPayload advertisement;
    private TimeIntervalMetric assetDownloadDurationMetric;
    private final Context context;
    private final AtomicLong downloadCount;
    private final AtomicLong downloadRequiredCount;
    private final Downloader downloader;
    private AtomicBoolean fullyDownloaded;
    private LogEntry logEntry;
    private SingleValueMetric mainVideoSizeMetric;
    private AtomicBoolean notifyFailed;
    private AtomicBoolean notifySuccess;
    private final OMInjector omInjector;
    private final PathProvider pathProvider;
    private AtomicBoolean requiredAssetDownloaded;
    private final Executors sdkExecutors;
    private SingleValueMetric templateHtmlSizeMetric;
    private SingleValueMetric templateSizeMetric;
    private final VungleApiClient vungleApiClient;

    public abstract void onAdLoadReady();

    protected abstract void requestAd();

    public BaseAdLoader(Context context, VungleApiClient vungleApiClient, Executors sdkExecutors, OMInjector omInjector, Downloader downloader, PathProvider pathProvider, AdRequest adRequest) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(vungleApiClient, "vungleApiClient");
        Intrinsics.checkNotNullParameter(sdkExecutors, "sdkExecutors");
        Intrinsics.checkNotNullParameter(omInjector, "omInjector");
        Intrinsics.checkNotNullParameter(downloader, "downloader");
        Intrinsics.checkNotNullParameter(pathProvider, "pathProvider");
        Intrinsics.checkNotNullParameter(adRequest, "adRequest");
        this.context = context;
        this.vungleApiClient = vungleApiClient;
        this.sdkExecutors = sdkExecutors;
        this.omInjector = omInjector;
        this.downloader = downloader;
        this.pathProvider = pathProvider;
        this.adRequest = adRequest;
        this.downloadCount = new AtomicLong(0L);
        this.downloadRequiredCount = new AtomicLong(0L);
        this.notifySuccess = new AtomicBoolean(false);
        this.notifyFailed = new AtomicBoolean(false);
        this.adAssets = new ArrayList();
        this.fullyDownloaded = new AtomicBoolean(true);
        this.requiredAssetDownloaded = new AtomicBoolean(true);
        this.mainVideoSizeMetric = new SingleValueMetric(Sdk.SDKMetric.SDKMetricType.ASSET_FILE_SIZE);
        this.templateSizeMetric = new SingleValueMetric(Sdk.SDKMetric.SDKMetricType.TEMPLATE_ZIP_SIZE);
        this.templateHtmlSizeMetric = new SingleValueMetric(Sdk.SDKMetric.SDKMetricType.TEMPLATE_HTML_SIZE);
        this.assetDownloadDurationMetric = new TimeIntervalMetric(Sdk.SDKMetric.SDKMetricType.ASSET_DOWNLOAD_DURATION_MS);
        this.adRequiredDownloadDurationMetric = new TimeIntervalMetric(Sdk.SDKMetric.SDKMetricType.AD_REQUIRED_DOWNLOAD_DURATION_MS);
        this.adOptionalDownloadDurationMetric = new TimeIntervalMetric(Sdk.SDKMetric.SDKMetricType.AD_OPTIONAL_DOWNLOAD_DURATION_MS);
    }

    public final Context getContext() {
        return this.context;
    }

    public final VungleApiClient getVungleApiClient() {
        return this.vungleApiClient;
    }

    public final Executors getSdkExecutors() {
        return this.sdkExecutors;
    }

    public final PathProvider getPathProvider() {
        return this.pathProvider;
    }

    public final AdRequest getAdRequest() {
        return this.adRequest;
    }

    /* JADX INFO: renamed from: getAdvertisement$vungle_ads_release, reason: from getter */
    public final AdPayload getAdvertisement() {
        return this.advertisement;
    }

    public final void setAdvertisement$vungle_ads_release(AdPayload adPayload) {
        this.advertisement = adPayload;
    }

    /* JADX INFO: renamed from: getLogEntry$vungle_ads_release, reason: from getter */
    public final LogEntry getLogEntry() {
        return this.logEntry;
    }

    public final void setLogEntry$vungle_ads_release(LogEntry logEntry) {
        this.logEntry = logEntry;
    }

    private final AssetDownloadListener getAssetDownloadListener() {
        return new BaseAdLoader$assetDownloadListener$1(this);
    }

    public final void loadAd(AdLoaderCallback adLoaderCallback) {
        Intrinsics.checkNotNullParameter(adLoaderCallback, "adLoaderCallback");
        this.adLoaderCallback = adLoaderCallback;
        this.sdkExecutors.getBACKGROUND_EXECUTOR().execute(new Runnable() { // from class: com.vungle.ads.internal.load.BaseAdLoader$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BaseAdLoader.m6043loadAd$lambda0(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadAd$lambda-0, reason: not valid java name */
    public static final void m6043loadAd$lambda0(BaseAdLoader this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.requestAd();
    }

    public final void cancel() {
        this.downloader.cancelAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void downloadAssets() {
        this.assetDownloadDurationMetric.markStart();
        this.adRequiredDownloadDurationMetric.markStart();
        this.adOptionalDownloadDurationMetric.markStart();
        this.downloadCount.set(this.adAssets.size());
        AtomicLong atomicLong = this.downloadRequiredCount;
        List<AdAsset> list = this.adAssets;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((AdAsset) obj).getIsRequired()) {
                arrayList.add(obj);
            }
        }
        atomicLong.set(arrayList.size());
        for (AdAsset adAsset : this.adAssets) {
            DownloadRequest downloadRequest = new DownloadRequest(getAssetPriority(adAsset), adAsset, this.logEntry);
            if (downloadRequest.isTemplate()) {
                downloadRequest.startRecord();
            }
            this.downloader.download(downloadRequest, getAssetDownloadListener());
        }
    }

    public final void onAdLoadFailed(VungleError error) {
        AdLoaderCallback adLoaderCallback;
        Intrinsics.checkNotNullParameter(error, "error");
        if (this.notifySuccess.get() || !this.notifyFailed.compareAndSet(false, true) || (adLoaderCallback = this.adLoaderCallback) == null) {
            return;
        }
        adLoaderCallback.onFailure(error);
    }

    private final void onAdReady() {
        AdPayload adPayload = this.advertisement;
        if (adPayload == null || this.notifyFailed.get() || !this.notifySuccess.compareAndSet(false, true)) {
            return;
        }
        onAdLoadReady();
        AdLoaderCallback adLoaderCallback = this.adLoaderCallback;
        if (adLoaderCallback != null) {
            adLoaderCallback.onSuccess(adPayload);
        }
    }

    private final boolean fileIsValid(File file, AdAsset adAsset) {
        return file.exists() && file.length() == adAsset.getFileSize();
    }

    private final boolean unzipFile(File downloadedFile, File destinationDir) throws Throwable {
        final ArrayList arrayList = new ArrayList();
        for (AdAsset adAsset : this.adAssets) {
            if (adAsset.getFileType() == AdAsset.FileType.ASSET) {
                arrayList.add(adAsset.getLocalPath());
            }
        }
        try {
            UnzipUtility unzipUtility = UnzipUtility.INSTANCE;
            String path = downloadedFile.getPath();
            String path2 = destinationDir.getPath();
            Intrinsics.checkNotNullExpressionValue(path2, "destinationDir.path");
            unzipUtility.unzip(path, path2, new UnzipUtility.Filter() { // from class: com.vungle.ads.internal.load.BaseAdLoader.unzipFile.1
                @Override // com.vungle.ads.internal.util.UnzipUtility.Filter
                public boolean matches(String extractPath) {
                    String str = extractPath;
                    if (str != null && str.length() != 0) {
                        File file = new File(extractPath);
                        Iterator<String> it = arrayList.iterator();
                        while (it.hasNext()) {
                            File file2 = new File(it.next());
                            if (Intrinsics.areEqual(file2, file)) {
                                return false;
                            }
                            String path3 = file.getPath();
                            Intrinsics.checkNotNullExpressionValue(path3, "toExtract.path");
                            if (StringsKt.startsWith$default(path3, file2.getPath() + File.separator, false, 2, (Object) null)) {
                                return false;
                            }
                        }
                    }
                    return true;
                }
            });
            if (!new File(destinationDir.getPath(), Constants.AD_INDEX_FILE_NAME).exists()) {
                new IndexHtmlError(Sdk.SDKError.Reason.INVALID_INDEX_URL, "Failed to retrieve indexFileUrl from the Ad").setLogEntry$vungle_ads_release(this.logEntry).logErrorNoReturnValue$vungle_ads_release();
                return false;
            }
            FileUtility.delete(downloadedFile);
            return true;
        } catch (Exception e) {
            new TemplateUnzipError("Unzip failed: " + e.getMessage()).setLogEntry$vungle_ads_release(this.logEntry).logErrorNoReturnValue$vungle_ads_release();
            return false;
        }
    }

    private final File getDestinationDir(AdPayload advertisement) {
        return this.pathProvider.getDownloadsDirForAd(advertisement.eventId());
    }

    private final boolean injectMraidJS(File destinationDir) {
        try {
            File file = new File(destinationDir.getPath(), "mraid.js");
            File file2 = new File(this.pathProvider.getJsAssetDir(ConfigManager.INSTANCE.getMraidJsVersion()), Constants.MRAID_JS_FILE_NAME);
            if (file2.exists()) {
                FilesKt.copyTo$default(file2, file, true, 0, 4, null);
                return true;
            }
            new MraidJsError(Sdk.SDKError.Reason.MRAID_JS_DOES_NOT_EXIST, "mraid js source file not exist.").setLogEntry$vungle_ads_release(this.logEntry).logErrorNoReturnValue$vungle_ads_release();
            return false;
        } catch (Exception e) {
            Logger.INSTANCE.e(TAG, "Failed to inject mraid.js: " + e.getMessage());
            new MraidJsError(Sdk.SDKError.Reason.MRAID_JS_COPY_FAILED, "Failed to copy mraid js to ad folder: " + e.getMessage()).setLogEntry$vungle_ads_release(this.logEntry).logErrorNoReturnValue$vungle_ads_release();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean processVmTemplate(AdAsset asset, AdPayload advertisement) {
        if (advertisement == null || asset.getStatus() != AdAsset.Status.DOWNLOAD_SUCCESS || asset.getLocalPath().length() == 0) {
            return false;
        }
        File file = new File(asset.getLocalPath());
        if (!fileIsValid(file, asset)) {
            return false;
        }
        File destinationDir = getDestinationDir(advertisement);
        if (destinationDir == null || !destinationDir.isDirectory()) {
            Logger.INSTANCE.e(TAG, "Unable to access Destination Directory");
            return false;
        }
        if (asset.getFileType() == AdAsset.FileType.ZIP && !unzipFile(file, destinationDir)) {
            return false;
        }
        if (advertisement.omEnabled()) {
            try {
                this.omInjector.injectJsFiles$vungle_ads_release(destinationDir);
            } catch (Exception e) {
                Logger.INSTANCE.e(TAG, "Failed to inject OMSDK: " + e.getMessage());
                new OmSdkJsError(Sdk.SDKError.Reason.OMSDK_JS_WRITE_FAILED, "Failed to inject OMSDK: " + e.getMessage()).setLogEntry$vungle_ads_release(this.logEntry).logErrorNoReturnValue$vungle_ads_release();
            }
        }
        boolean zInjectMraidJS = injectMraidJS(destinationDir);
        FileUtility.printDirectoryTree(destinationDir);
        return zInjectMraidJS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onRequiredDownloadCompleted() {
        this.adRequiredDownloadDurationMetric.markEnd();
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, this.adRequiredDownloadDurationMetric, this.logEntry, (String) null, 4, (Object) null);
        onAdReady();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onDownloadCompleted(AdRequest request) {
        Logger.INSTANCE.d(TAG, "All download completed " + request);
        AdPayload adPayload = this.advertisement;
        if (adPayload != null) {
            adPayload.setAssetFullyDownloaded();
        }
        onAdReady();
        this.assetDownloadDurationMetric.markEnd();
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, this.assetDownloadDurationMetric, this.logEntry, (String) null, 4, (Object) null);
        this.adOptionalDownloadDurationMetric.markEnd();
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, this.adOptionalDownloadDurationMetric, this.logEntry, (String) null, 4, (Object) null);
    }

    public static /* synthetic */ void handleAdMetaData$vungle_ads_release$default(BaseAdLoader baseAdLoader, AdPayload adPayload, SingleValueMetric singleValueMetric, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleAdMetaData");
        }
        if ((i & 2) != 0) {
            singleValueMetric = null;
        }
        baseAdLoader.handleAdMetaData$vungle_ads_release(adPayload, singleValueMetric);
    }

    public final void handleAdMetaData$vungle_ads_release(AdPayload advertisement, SingleValueMetric metric) {
        List<String> loadAdUrls;
        Intrinsics.checkNotNullParameter(advertisement, "advertisement");
        this.advertisement = advertisement;
        advertisement.setLogEntry$vungle_ads_release(this.logEntry);
        LogEntry logEntry = this.logEntry;
        if (logEntry != null) {
            logEntry.setEventId$vungle_ads_release(advertisement.eventId());
        }
        LogEntry logEntry2 = this.logEntry;
        if (logEntry2 != null) {
            logEntry2.setCreativeId$vungle_ads_release(advertisement.getCreativeId());
        }
        LogEntry logEntry3 = this.logEntry;
        if (logEntry3 != null) {
            logEntry3.setAdSource$vungle_ads_release(advertisement.getAdSource());
        }
        ConfigPayload config = advertisement.getConfig();
        if (config != null) {
            ConfigManager.INSTANCE.initWithConfig$vungle_ads_release(this.context, config, false, metric);
        }
        VungleError vungleErrorValidateAdMetadata = validateAdMetadata(advertisement);
        if (vungleErrorValidateAdMetadata != null) {
            onAdLoadFailed(vungleErrorValidateAdMetadata.setLogEntry$vungle_ads_release(this.logEntry).logError$vungle_ads_release());
            return;
        }
        File destinationDir = getDestinationDir(advertisement);
        if (destinationDir == null || !destinationDir.isDirectory() || !destinationDir.exists()) {
            onAdLoadFailed(new AssetDownloadError(Sdk.SDKError.Reason.ASSET_WRITE_ERROR, "Invalid directory. " + destinationDir).setLogEntry$vungle_ads_release(this.logEntry).logError$vungle_ads_release());
            return;
        }
        ServiceLocator.Companion companion = ServiceLocator.INSTANCE;
        final Context context = this.context;
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<SignalManager>() { // from class: com.vungle.ads.internal.load.BaseAdLoader$handleAdMetaData$$inlined$inject$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.signals.SignalManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SignalManager invoke() {
                return ServiceLocator.INSTANCE.getInstance(context).getService(SignalManager.class);
            }
        });
        AdPayload.AdUnit adUnit = advertisement.adUnit();
        if (adUnit != null && (loadAdUrls = adUnit.getLoadAdUrls()) != null) {
            TpatSender tpatSender = new TpatSender(this.vungleApiClient, this.logEntry, this.sdkExecutors.getIO_EXECUTOR(), this.pathProvider, m6042handleAdMetaData$lambda5(lazy));
            Iterator<T> it = loadAdUrls.iterator();
            while (it.hasNext()) {
                tpatSender.sendTpat((String) it.next(), this.sdkExecutors.getJOB_EXECUTOR());
            }
        }
        if (!this.adAssets.isEmpty()) {
            this.adAssets.clear();
        }
        this.adAssets.addAll(advertisement.getDownloadableAssets(destinationDir));
        if (this.adAssets.isEmpty()) {
            onAdLoadFailed(new AssetDownloadError(Sdk.SDKError.Reason.INVALID_ASSET_URL, "No assets to download.").setLogEntry$vungle_ads_release(this.logEntry).logError$vungle_ads_release());
        } else {
            MraidJsLoader.INSTANCE.downloadJs(this.pathProvider, this.downloader, this.sdkExecutors.getBACKGROUND_EXECUTOR(), new MraidJsLoader.DownloadResultListener() { // from class: com.vungle.ads.internal.load.BaseAdLoader$handleAdMetaData$3
                @Override // com.vungle.ads.internal.load.MraidJsLoader.DownloadResultListener
                public void onDownloadResult(int downloadResult) {
                    if (downloadResult == 10 || downloadResult == 13) {
                        if (downloadResult == 10) {
                            AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, Sdk.SDKMetric.SDKMetricType.MRAID_DOWNLOAD_JS_RETRY_SUCCESS, 0L, this.this$0.getLogEntry(), null, 10, null);
                        }
                        this.this$0.downloadAssets();
                    } else {
                        AdLoaderCallback adLoaderCallback = this.this$0.adLoaderCallback;
                        if (adLoaderCallback != null) {
                            adLoaderCallback.onFailure(new MraidJsError(Sdk.SDKError.Reason.MRAID_DOWNLOAD_JS_ERROR, "Failed to download mraid.js."));
                        }
                    }
                }
            }, advertisement);
        }
    }

    /* JADX INFO: renamed from: handleAdMetaData$lambda-5, reason: not valid java name */
    private static final SignalManager m6042handleAdMetaData$lambda5(Lazy<SignalManager> lazy) {
        return lazy.getValue();
    }

    private final DownloadRequest.Priority getAssetPriority(AdAsset adAsset) {
        if (adAsset.getIsRequired()) {
            return DownloadRequest.Priority.CRITICAL;
        }
        return DownloadRequest.Priority.HIGHEST;
    }

    private final VungleError validateAdMetadata(AdPayload adPayload) {
        Integer sleep;
        AdPayload.AdUnit adUnit = adPayload.adUnit();
        if (adUnit != null && (sleep = adUnit.getSleep()) != null) {
            sleep.intValue();
            return getErrorInfo(adPayload);
        }
        String referenceId = this.adRequest.getPlacement().getReferenceId();
        AdPayload adPayload2 = this.advertisement;
        if (!Intrinsics.areEqual(referenceId, adPayload2 != null ? adPayload2.placementId() : null)) {
            StringBuilder sb = new StringBuilder("Requests and responses don't match ");
            AdPayload adPayload3 = this.advertisement;
            return new AdResponseEmptyError(sb.append(adPayload3 != null ? adPayload3.placementId() : null).append('.').toString());
        }
        VungleError templateError = getTemplateError(adPayload);
        if (templateError != null) {
            return templateError;
        }
        if (adPayload.hasExpired()) {
            return new AdExpiredError("The ad markup has expired for playback.");
        }
        String strEventId = adPayload.eventId();
        if (strEventId == null || strEventId.length() == 0) {
            return new InvalidEventIdError("Event id is invalid.");
        }
        return null;
    }

    private final VungleError getTemplateError(AdPayload adPayload) {
        String str;
        AdPayload.AdUnit adUnit = adPayload.adUnit();
        AdPayload.TemplateSettings templateSettings = adUnit != null ? adUnit.getTemplateSettings() : null;
        if (templateSettings == null) {
            return new AssetResponseDataError("Missing template settings");
        }
        Map<String, AdPayload.CacheableReplacement> cacheableReplacements = templateSettings.getCacheableReplacements();
        if (!adPayload.isNativeTemplateType()) {
            AdPayload.AdUnit adUnit2 = adPayload.adUnit();
            String templateURL = adUnit2 != null ? adUnit2.getTemplateURL() : null;
            AdPayload.AdUnit adUnit3 = adPayload.adUnit();
            String vmURL = adUnit3 != null ? adUnit3.getVmURL() : null;
            String str2 = templateURL;
            if ((str2 == null || str2.length() == 0) && ((str = vmURL) == null || str.length() == 0)) {
                return new InvalidTemplateURLError("Failed to prepare null vmURL or templateURL for downloading.");
            }
            if (str2 != null && str2.length() != 0 && !Utils.INSTANCE.isUrlValid(templateURL)) {
                return new AssetRequestError("Failed to load template: " + templateURL);
            }
            String str3 = vmURL;
            if (str3 != null && str3.length() != 0 && !Utils.INSTANCE.isUrlValid(vmURL)) {
                return new AssetRequestError("Failed to load vm url: " + vmURL);
            }
        } else if (cacheableReplacements != null) {
            AdPayload.CacheableReplacement cacheableReplacement = cacheableReplacements.get(NativeAdInternal.TOKEN_MAIN_IMAGE);
            if ((cacheableReplacement != null ? cacheableReplacement.getUrl() : null) == null) {
                return new NativeAssetError("Unable to load null main image.");
            }
            AdPayload.CacheableReplacement cacheableReplacement2 = cacheableReplacements.get(NativeAdInternal.TOKEN_VUNGLE_PRIVACY_ICON_URL);
            if ((cacheableReplacement2 != null ? cacheableReplacement2.getUrl() : null) == null) {
                return new NativeAssetError("Unable to load null privacy image.");
            }
        }
        if (cacheableReplacements != null) {
            Iterator<Map.Entry<String, AdPayload.CacheableReplacement>> it = cacheableReplacements.entrySet().iterator();
            while (it.hasNext()) {
                String url = it.next().getValue().getUrl();
                String str4 = url;
                if (str4 == null || str4.length() == 0) {
                    return new InvalidAssetUrlError("Invalid asset URL " + url);
                }
                if (!Utils.INSTANCE.isUrlValid(url)) {
                    return new AssetRequestError("Invalid asset URL " + url);
                }
            }
        }
        return null;
    }

    private final VungleError getErrorInfo(AdPayload adPayload) {
        AdPayload.AdUnit adUnit = adPayload.adUnit();
        Integer errorCode = adUnit != null ? adUnit.getErrorCode() : null;
        AdPayload.AdUnit adUnit2 = adPayload.adUnit();
        Integer sleep = adUnit2 != null ? adUnit2.getSleep() : null;
        AdPayload.AdUnit adUnit3 = adPayload.adUnit();
        String str = "Response error: " + sleep + ", Request failed with error: " + errorCode + ", " + (adUnit3 != null ? adUnit3.getInfo() : null);
        if ((errorCode != null && errorCode.intValue() == 10001) || ((errorCode != null && errorCode.intValue() == 10002) || ((errorCode != null && errorCode.intValue() == 20001) || ((errorCode != null && errorCode.intValue() == 30001) || (errorCode != null && errorCode.intValue() == 30002))))) {
            Sdk.SDKError.Reason reasonForNumber = Sdk.SDKError.Reason.forNumber(errorCode.intValue());
            Intrinsics.checkNotNullExpressionValue(reasonForNumber, "forNumber(errorCode)");
            return new AdPayloadError(reasonForNumber, str);
        }
        return new AdPayloadError(Sdk.SDKError.Reason.PLACEMENT_SLEEP, str);
    }
}
