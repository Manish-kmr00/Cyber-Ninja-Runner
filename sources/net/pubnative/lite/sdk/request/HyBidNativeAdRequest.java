package net.pubnative.lite.sdk.request;

import android.graphics.Bitmap;
import android.text.TextUtils;
import net.pubnative.lite.sdk.HyBid;
import net.pubnative.lite.sdk.HyBidError;
import net.pubnative.lite.sdk.HyBidErrorCode;
import net.pubnative.lite.sdk.api.RequestManager;
import net.pubnative.lite.sdk.models.Ad;
import net.pubnative.lite.sdk.models.IntegrationType;
import net.pubnative.lite.sdk.models.NativeAd;
import net.pubnative.lite.sdk.utils.Logger;
import net.pubnative.lite.sdk.utils.PNBitmapDownloader;
import net.pubnative.lite.sdk.utils.SignalDataProcessor;

/* JADX INFO: loaded from: classes9.dex */
public class HyBidNativeAdRequest implements RequestManager.RequestListener {
    private static final String TAG = "HyBidNativeAdRequest";
    private PNBitmapDownloader mBitmapDownloader;
    private RequestListener mListener;
    private boolean mPreLoadMediaAssets;
    private final RequestManager mRequestManager;
    private String mScreenIabCategory;
    private String mScreenKeywords;
    private SignalDataProcessor mSignalDataProcessor;
    private String mUserIntent;

    public interface RequestListener {
        void onRequestFail(Throwable th);

        void onRequestSuccess(NativeAd nativeAd);
    }

    public HyBidNativeAdRequest() {
        NativeRequestManager nativeRequestManager = new NativeRequestManager();
        this.mRequestManager = nativeRequestManager;
        nativeRequestManager.setIntegrationType(IntegrationType.STANDALONE);
        nativeRequestManager.setRequestListener(this);
        this.mBitmapDownloader = new PNBitmapDownloader();
        this.mPreLoadMediaAssets = false;
    }

    public void load(String str, RequestListener requestListener) {
        load(null, str, requestListener);
    }

    public void load(String str, String str2, RequestListener requestListener) {
        this.mListener = requestListener;
        if (!TextUtils.isEmpty(str)) {
            this.mRequestManager.setAppToken(str);
        }
        this.mRequestManager.setZoneId(str2);
        this.mRequestManager.requestAd();
    }

    public void prepareAd(String str, RequestListener requestListener) {
        if (TextUtils.isEmpty(str)) {
            if (requestListener != null) {
                requestListener.onRequestFail(new HyBidError(HyBidErrorCode.INVALID_SIGNAL_DATA));
            }
        } else {
            this.mListener = requestListener;
            SignalDataProcessor signalDataProcessor = new SignalDataProcessor();
            this.mSignalDataProcessor = signalDataProcessor;
            signalDataProcessor.processSignalData(str, new SignalDataProcessor.Listener() { // from class: net.pubnative.lite.sdk.request.HyBidNativeAdRequest.1
                @Override // net.pubnative.lite.sdk.utils.SignalDataProcessor.Listener
                public void onProcessed(Ad ad) {
                    if (ad != null) {
                        HyBidNativeAdRequest.this.createNativeAd(ad);
                    } else if (HyBidNativeAdRequest.this.mListener != null) {
                        HyBidNativeAdRequest.this.mListener.onRequestFail(new HyBidError(HyBidErrorCode.NULL_AD));
                    }
                }

                @Override // net.pubnative.lite.sdk.utils.SignalDataProcessor.Listener
                public void onError(Throwable th) {
                    if (HyBidNativeAdRequest.this.mListener != null) {
                        HyBidNativeAdRequest.this.mListener.onRequestFail(th);
                    }
                }
            });
        }
    }

    @Override // net.pubnative.lite.sdk.api.RequestManager.RequestListener
    public void onRequestSuccess(Ad ad) {
        createNativeAd(ad);
    }

    @Override // net.pubnative.lite.sdk.api.RequestManager.RequestListener
    public void onRequestFail(Throwable th) {
        if (th instanceof HyBidError) {
            if (((HyBidError) th).getErrorCode() == HyBidErrorCode.NO_FILL) {
                Logger.w(TAG, th.getMessage());
            } else {
                Logger.e(TAG, th.getMessage());
            }
        }
        RequestListener requestListener = this.mListener;
        if (requestListener != null) {
            requestListener.onRequestFail(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createNativeAd(Ad ad) {
        NativeAd nativeAd = new NativeAd(ad);
        if (this.mPreLoadMediaAssets) {
            fetchBanner(nativeAd);
            return;
        }
        RequestListener requestListener = this.mListener;
        if (requestListener != null) {
            requestListener.onRequestSuccess(nativeAd);
        }
    }

    private void fetchBanner(final NativeAd nativeAd) {
        if (TextUtils.isEmpty(nativeAd.getBannerUrl())) {
            fetchIcon(nativeAd);
        } else {
            this.mBitmapDownloader.download(nativeAd.getBannerUrl(), new PNBitmapDownloader.DownloadListener() { // from class: net.pubnative.lite.sdk.request.HyBidNativeAdRequest.2
                @Override // net.pubnative.lite.sdk.utils.PNBitmapDownloader.DownloadListener
                public void onDownloadFinish(String str, Bitmap bitmap) {
                    if (bitmap != null) {
                        nativeAd.setBannerBitmap(bitmap);
                    }
                    HyBidNativeAdRequest.this.fetchIcon(nativeAd);
                }

                @Override // net.pubnative.lite.sdk.utils.PNBitmapDownloader.DownloadListener
                public void onDownloadFailed(String str, Exception exc) {
                    HyBid.reportException(exc);
                    HyBidNativeAdRequest.this.fetchIcon(nativeAd);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fetchIcon(final NativeAd nativeAd) {
        if (TextUtils.isEmpty(nativeAd.getIconUrl())) {
            RequestListener requestListener = this.mListener;
            if (requestListener != null) {
                requestListener.onRequestSuccess(nativeAd);
                return;
            }
            return;
        }
        this.mBitmapDownloader.download(nativeAd.getIconUrl(), new PNBitmapDownloader.DownloadListener() { // from class: net.pubnative.lite.sdk.request.HyBidNativeAdRequest.3
            @Override // net.pubnative.lite.sdk.utils.PNBitmapDownloader.DownloadListener
            public void onDownloadFinish(String str, Bitmap bitmap) {
                if (bitmap != null) {
                    nativeAd.setIconBitmap(bitmap);
                }
                if (HyBidNativeAdRequest.this.mListener != null) {
                    HyBidNativeAdRequest.this.mListener.onRequestSuccess(nativeAd);
                }
            }

            @Override // net.pubnative.lite.sdk.utils.PNBitmapDownloader.DownloadListener
            public void onDownloadFailed(String str, Exception exc) {
                HyBid.reportException(exc);
                if (HyBidNativeAdRequest.this.mListener != null) {
                    HyBidNativeAdRequest.this.mListener.onRequestSuccess(nativeAd);
                }
            }
        });
    }

    public void setMediationVendor(String str) {
        RequestManager requestManager = this.mRequestManager;
        if (requestManager != null) {
            requestManager.setMediationVendor(str);
        }
    }

    public void setMediation(boolean z) {
        RequestManager requestManager = this.mRequestManager;
        if (requestManager != null) {
            requestManager.setIntegrationType(z ? IntegrationType.MEDIATION : IntegrationType.STANDALONE);
        }
    }

    public void setPreLoadMediaAssets(boolean z) {
        this.mPreLoadMediaAssets = z;
    }

    public void setScreenIabCategory(String str) {
        this.mScreenIabCategory = str;
    }

    public void setScreenKeywords(String str) {
        this.mScreenKeywords = str;
    }

    public void setUserIntent(String str) {
        this.mUserIntent = str;
    }
}
