package net.pubnative.lite.sdk.vpaid.helpers;

import android.content.Context;
import java.util.Locale;
import net.pubnative.lite.sdk.models.EndCardData;
import net.pubnative.lite.sdk.utils.Logger;
import net.pubnative.lite.sdk.vpaid.PlayerInfo;
import net.pubnative.lite.sdk.vpaid.enums.VastError;
import net.pubnative.lite.sdk.vpaid.response.AdParams;

/* JADX INFO: loaded from: classes7.dex */
public class AssetsLoader {
    private static final String LOG_TAG = "AssetsLoader";
    private int endCardFileIndex;
    private AdParams mAdParams;
    private Context mContext;
    private FileLoader mFileLoader;
    private OnAssetsLoaded mListener;
    private String mVideoFilePath;
    private FileLoader mVideoLoader;
    private int videoFileIndex;

    public interface OnAssetsLoaded {
        void onAssetsLoaded(String str, EndCardData endCardData, String str2);

        void onError(PlayerInfo playerInfo);
    }

    public void load(AdParams adParams, Context context, OnAssetsLoaded onAssetsLoaded) {
        this.mContext = context;
        this.mAdParams = adParams;
        this.mListener = onAssetsLoaded;
        this.videoFileIndex = 0;
        this.endCardFileIndex = 0;
        this.mVideoFilePath = null;
        FileLoader.setUseMobileNetworkForCaching(true);
        if (adParams.isVpaid()) {
            loadEndCard();
        } else {
            loadVideoAndEndCard();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadVideoAndEndCard() {
        if (this.mAdParams.getVideoFileUrlsList() == null || this.mAdParams.getVideoFileUrlsList().isEmpty()) {
            this.mListener.onError(new PlayerInfo("No video file found"));
            return;
        }
        FileLoader fileLoader = new FileLoader(this.mAdParams.getVideoFileUrlsList().get(this.videoFileIndex), this.mContext, new FileLoader.Callback() { // from class: net.pubnative.lite.sdk.vpaid.helpers.AssetsLoader.1
            @Override // net.pubnative.lite.sdk.vpaid.helpers.FileLoader.Callback
            public void onFileLoaded(String str) {
                Logger.d(AssetsLoader.LOG_TAG, "onFullVideoLoaded");
                AssetsLoader.this.mVideoFilePath = str;
                AssetsLoader.this.loadEndCard();
            }

            @Override // net.pubnative.lite.sdk.vpaid.helpers.FileLoader.Callback
            public void onError(PlayerInfo playerInfo) {
                Logger.e(AssetsLoader.LOG_TAG, "Load video fail:" + playerInfo.getMessage());
                AssetsLoader.this.videoFileIndex++;
                if (AssetsLoader.this.videoFileIndex < AssetsLoader.this.mAdParams.getVideoFileUrlsList().size()) {
                    AssetsLoader.this.loadVideoAndEndCard();
                } else {
                    AssetsLoader.this.mListener.onError(playerInfo);
                }
            }

            @Override // net.pubnative.lite.sdk.vpaid.helpers.FileLoader.Callback
            public void onProgress(double d) {
                Logger.d(AssetsLoader.LOG_TAG, String.format(Locale.US, "Loaded: %.2f%%", Double.valueOf(d * 100.0d)));
            }
        }, false);
        this.mVideoLoader = fileLoader;
        fileLoader.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadEndCard() {
        if (this.mAdParams.getEndCardList() == null || this.mAdParams.getEndCardList().isEmpty()) {
            this.mListener.onAssetsLoaded(this.mVideoFilePath, null, null);
            return;
        }
        this.endCardFileIndex = this.mAdParams.getEndCardList().size() - 1;
        final EndCardData endCardData = this.mAdParams.getEndCardList().get(this.endCardFileIndex);
        if (endCardData != null && endCardData.getType() == EndCardData.Type.STATIC_RESOURCE) {
            FileLoader fileLoader = new FileLoader(endCardData.getContent(), this.mContext, new FileLoader.Callback() { // from class: net.pubnative.lite.sdk.vpaid.helpers.AssetsLoader.2
                @Override // net.pubnative.lite.sdk.vpaid.helpers.FileLoader.Callback
                public void onFileLoaded(String str) {
                    AssetsLoader.this.mListener.onAssetsLoaded(AssetsLoader.this.mVideoFilePath, endCardData, str);
                }

                @Override // net.pubnative.lite.sdk.vpaid.helpers.FileLoader.Callback
                public void onError(PlayerInfo playerInfo) {
                    ErrorLog.postError(AssetsLoader.this.mContext, VastError.COMPANION);
                    AssetsLoader.this.endCardFileIndex--;
                    if (AssetsLoader.this.endCardFileIndex >= 0) {
                        AssetsLoader.this.loadEndCard();
                    } else {
                        AssetsLoader.this.mListener.onAssetsLoaded(AssetsLoader.this.mVideoFilePath, null, null);
                    }
                }

                @Override // net.pubnative.lite.sdk.vpaid.helpers.FileLoader.Callback
                public void onProgress(double d) {
                    Logger.d(AssetsLoader.LOG_TAG, String.format(Locale.US, "Loaded: %.2f%%", Double.valueOf(d * 100.0d)));
                }
            }, true);
            this.mFileLoader = fileLoader;
            fileLoader.start();
            return;
        }
        this.mListener.onAssetsLoaded(this.mVideoFilePath, endCardData, null);
    }

    public void breakLoading() {
        FileLoader fileLoader = this.mVideoLoader;
        if (fileLoader != null) {
            fileLoader.stop();
        }
        FileLoader fileLoader2 = this.mFileLoader;
        if (fileLoader2 != null) {
            fileLoader2.stop();
        }
    }
}
