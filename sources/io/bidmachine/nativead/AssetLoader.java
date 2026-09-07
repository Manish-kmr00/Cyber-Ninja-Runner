package io.bidmachine.nativead;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import io.bidmachine.AdProcessCallback;
import io.bidmachine.ImageData;
import io.bidmachine.MediaAssetType;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.iab.vast.VastRequest;
import io.bidmachine.nativead.tasks.DownloadImageTask;
import io.bidmachine.nativead.tasks.DownloadVastVideoTask;
import io.bidmachine.nativead.tasks.DownloadVideoTask;
import io.bidmachine.nativead.utils.NativeNetworkExecutor;
import io.bidmachine.utils.BMError;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes11.dex */
class AssetLoader {
    private static final String DIR_NAME = "native_cache_image";
    private final NativeAdRequestParameters adRequestParameters;
    private final AdProcessCallback callback;
    private final NativeData nativeData;
    private final NativeMediaPrivateData nativeMediaData;
    private final List<Runnable> pendingTasks = new CopyOnWriteArrayList();

    AssetLoader(NativeAdRequestParameters nativeAdRequestParameters, AdProcessCallback adProcessCallback, NativeData nativeData, NativeMediaPrivateData nativeMediaPrivateData) {
        this.adRequestParameters = nativeAdRequestParameters;
        this.callback = adProcessCallback;
        this.nativeData = nativeData;
        this.nativeMediaData = nativeMediaPrivateData;
    }

    void downloadNativeAdsImages(Context context) {
        startDownloadTask(context);
        checkTasksCount();
    }

    private void startDownloadTask(Context context) {
        String videoUrl = this.nativeData.getVideoUrl();
        String videoAdm = this.nativeData.getVideoAdm();
        if (this.adRequestParameters.containsAssetType(MediaAssetType.Icon)) {
            createIconTask(context, this.nativeData.getIcon());
        }
        if (this.adRequestParameters.containsAssetType(MediaAssetType.Image)) {
            createImageTask(context, this.nativeData.getMainImage());
        }
        if (this.adRequestParameters.containsAssetType(MediaAssetType.Video)) {
            if (!TextUtils.isEmpty(videoUrl)) {
                createVideoTask(context, videoUrl);
            } else if (!TextUtils.isEmpty(videoAdm)) {
                createVastVideoTask(context, videoAdm);
            }
        }
        if (this.pendingTasks.isEmpty()) {
            checkTasksCount();
            return;
        }
        Iterator<Runnable> it = this.pendingTasks.iterator();
        while (it.hasNext()) {
            NativeNetworkExecutor.getInstance().execute(it.next());
        }
    }

    private void createIconTask(Context context, ImageData imageData) {
        if (imageData != null && imageData.getImage() == null) {
            String remoteUrl = imageData.getRemoteUrl();
            if (TextUtils.isEmpty(remoteUrl)) {
                return;
            }
            this.pendingTasks.add(DownloadImageTask.newBuilder(context, remoteUrl).setOnCacheImageListener(new DownloadImageTask.OnCacheImageListener() { // from class: io.bidmachine.nativead.AssetLoader.1
                @Override // io.bidmachine.nativead.tasks.DownloadImageTask.OnCacheImageListener
                public void onPathSuccess(DownloadImageTask downloadImageTask, Uri uri) {
                    AssetLoader.this.nativeMediaData.setIconUri(uri);
                    AssetLoader.this.removePendingTask(downloadImageTask);
                }

                @Override // io.bidmachine.nativead.tasks.DownloadImageTask.OnCacheImageListener
                public void onImageSuccess(DownloadImageTask downloadImageTask, Bitmap bitmap) {
                    AssetLoader.this.nativeMediaData.setIconBitmap(bitmap);
                    AssetLoader.this.removePendingTask(downloadImageTask);
                }

                @Override // io.bidmachine.nativead.tasks.DownloadImageTask.OnCacheImageListener
                public void onFail(DownloadImageTask downloadImageTask) {
                    AssetLoader.this.removePendingTask(downloadImageTask);
                }
            }).build());
        }
    }

    private void createImageTask(Context context, ImageData imageData) {
        if (imageData != null && imageData.getImage() == null) {
            String remoteUrl = imageData.getRemoteUrl();
            if (TextUtils.isEmpty(remoteUrl)) {
                return;
            }
            this.pendingTasks.add(DownloadImageTask.newBuilder(context, remoteUrl).setOnCacheImageListener(new DownloadImageTask.OnCacheImageListener() { // from class: io.bidmachine.nativead.AssetLoader.2
                @Override // io.bidmachine.nativead.tasks.DownloadImageTask.OnCacheImageListener
                public void onPathSuccess(DownloadImageTask downloadImageTask, Uri uri) {
                    AssetLoader.this.nativeMediaData.setImageUri(uri);
                    AssetLoader.this.removePendingTask(downloadImageTask);
                }

                @Override // io.bidmachine.nativead.tasks.DownloadImageTask.OnCacheImageListener
                public void onImageSuccess(DownloadImageTask downloadImageTask, Bitmap bitmap) {
                    AssetLoader.this.nativeMediaData.setImageBitmap(bitmap);
                    AssetLoader.this.removePendingTask(downloadImageTask);
                }

                @Override // io.bidmachine.nativead.tasks.DownloadImageTask.OnCacheImageListener
                public void onFail(DownloadImageTask downloadImageTask) {
                    AssetLoader.this.removePendingTask(downloadImageTask);
                }
            }).build());
        }
    }

    private void createVideoTask(final Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.pendingTasks.add(new DownloadVideoTask(context, new DownloadVideoTask.OnLoadedListener() { // from class: io.bidmachine.nativead.AssetLoader.3
            @Override // io.bidmachine.nativead.tasks.DownloadVideoTask.OnLoadedListener
            public void onVideoLoaded(DownloadVideoTask downloadVideoTask, Uri uri) {
                AssetLoader.this.nativeMediaData.setVideoUri(uri);
                AssetLoader.this.retrieveAndSaveImageFrame(context, uri);
                AssetLoader.this.removePendingTask(downloadVideoTask);
            }

            @Override // io.bidmachine.nativead.tasks.DownloadVideoTask.OnLoadedListener
            public void onVideoLoadingError(DownloadVideoTask downloadVideoTask) {
                AssetLoader.this.removePendingTask(downloadVideoTask);
            }
        }, str));
    }

    private void createVastVideoTask(final Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.pendingTasks.add(new DownloadVastVideoTask(context, new DownloadVastVideoTask.OnLoadedListener() { // from class: io.bidmachine.nativead.AssetLoader.4
            @Override // io.bidmachine.nativead.tasks.DownloadVastVideoTask.OnLoadedListener
            public void onVideoLoaded(DownloadVastVideoTask downloadVastVideoTask, Uri uri, VastRequest vastRequest) {
                AssetLoader.this.nativeMediaData.setVideoUri(uri);
                AssetLoader.this.nativeMediaData.setVastRequest(vastRequest);
                AssetLoader.this.retrieveAndSaveImageFrame(context, uri);
                AssetLoader.this.removePendingTask(downloadVastVideoTask);
            }

            @Override // io.bidmachine.nativead.tasks.DownloadVastVideoTask.OnLoadedListener
            public void onVideoLoadingError(DownloadVastVideoTask downloadVastVideoTask) {
                AssetLoader.this.removePendingTask(downloadVastVideoTask);
            }
        }, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retrieveAndSaveImageFrame(Context context, Uri uri) {
        ImageData mainImage = this.nativeData.getMainImage();
        if (!TextUtils.isEmpty(mainImage != null ? mainImage.getRemoteUrl() : null) || uri == null || uri.getPath() == null || !new File(uri.getPath()).exists()) {
            return;
        }
        this.nativeMediaData.setImageUri(Uri.parse(Utils.retrieveAndSaveFrame(context, uri, DIR_NAME)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removePendingTask(Runnable runnable) {
        this.pendingTasks.remove(runnable);
        checkTasksCount();
    }

    private void checkTasksCount() {
        if (this.pendingTasks.isEmpty()) {
            notifyNativeCallback();
        }
    }

    private synchronized void notifyNativeCallback() {
        if (this.adRequestParameters.isValidateAssets() && !isAssetsValid()) {
            this.callback.processLoadFail(BMError.internal("Native assets are invalid"));
        } else {
            this.callback.processLoadSuccess();
        }
    }

    private boolean isAssetsValid() {
        try {
            return isIconValid() && isImageValid() && isVideoValid();
        } catch (Exception e) {
            Logger.w(e);
            return false;
        }
    }

    private boolean isIconValid() {
        return (this.adRequestParameters.containsAssetType(MediaAssetType.Icon) && this.nativeMediaData.getIconUri() == null && this.nativeMediaData.getIconDrawable() == null) ? false : true;
    }

    private boolean isImageValid() {
        return (this.adRequestParameters.containsAssetType(MediaAssetType.Image) && this.nativeMediaData.getImageUri() == null && this.nativeMediaData.getImageDrawable() == null) ? false : true;
    }

    private boolean isVideoValid() {
        if (this.adRequestParameters.containsAssetType(MediaAssetType.Video)) {
            return this.nativeData.hasVideo();
        }
        return true;
    }
}
