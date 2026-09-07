package net.pubnative.lite.sdk.vpaid;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.iab.omid.library.pubnativenet.adsession.VerificationScriptResource;
import java.util.ArrayList;
import java.util.List;
import net.pubnative.lite.sdk.HyBidError;
import net.pubnative.lite.sdk.HyBidErrorCode;
import net.pubnative.lite.sdk.models.AdSize;
import net.pubnative.lite.sdk.models.EndCardData;
import net.pubnative.lite.sdk.utils.Logger;
import net.pubnative.lite.sdk.vpaid.helpers.AssetsLoader;
import net.pubnative.lite.sdk.vpaid.models.vpaid.AdSpotDimensions;
import net.pubnative.lite.sdk.vpaid.response.AdParams;
import net.pubnative.lite.sdk.vpaid.response.VastProcessor;

/* JADX INFO: loaded from: classes6.dex */
public class VideoAdProcessor {
    private static final String TAG = "VideoAdProcessor";

    public interface Listener {
        void onCacheError(Throwable th);

        void onCacheSuccess(AdParams adParams, String str, EndCardData endCardData, String str2, List<String> list);
    }

    public void process(final Context context, String str, AdSize adSize, final Listener listener) {
        new VastProcessor(context, getAdSpotDimensions(context, adSize)).parseResponse(str, new VastProcessor.Listener() { // from class: net.pubnative.lite.sdk.vpaid.VideoAdProcessor.1
            @Override // net.pubnative.lite.sdk.vpaid.response.VastProcessor.Listener
            public void onParseSuccess(AdParams adParams, String str2) {
                VideoAdProcessor.this.prepare(context, adParams, listener);
            }

            @Override // net.pubnative.lite.sdk.vpaid.response.VastProcessor.Listener
            public void onParseError(PlayerInfo playerInfo) {
                if (listener != null) {
                    Logger.e(VideoAdProcessor.TAG, playerInfo.getMessage());
                    listener.onCacheError(new HyBidError(HyBidErrorCode.VAST_PLAYER_ERROR, playerInfo.getMessage()));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void prepare(Context context, final AdParams adParams, final Listener listener) {
        new AssetsLoader().load(adParams, context, new AssetsLoader.OnAssetsLoaded() { // from class: net.pubnative.lite.sdk.vpaid.VideoAdProcessor.2
            @Override // net.pubnative.lite.sdk.vpaid.helpers.AssetsLoader.OnAssetsLoaded
            public void onAssetsLoaded(String str, EndCardData endCardData, String str2) {
                Listener listener2 = listener;
                if (listener2 != null) {
                    AdParams adParams2 = adParams;
                    listener2.onCacheSuccess(adParams2, str, endCardData, str2, VideoAdProcessor.this.getOmidVendors(adParams2));
                }
            }

            @Override // net.pubnative.lite.sdk.vpaid.helpers.AssetsLoader.OnAssetsLoaded
            public void onError(PlayerInfo playerInfo) {
                if (listener != null) {
                    Logger.e(VideoAdProcessor.TAG, playerInfo.getMessage());
                    listener.onCacheError(new HyBidError(HyBidErrorCode.VAST_PLAYER_ERROR, playerInfo.getMessage()));
                }
            }
        });
    }

    private AdSpotDimensions getAdSpotDimensions(Context context, AdSize adSize) {
        if (adSize != null && adSize != AdSize.SIZE_INTERSTITIAL) {
            return new AdSpotDimensions(adSize.getWidth(), adSize.getHeight());
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return new AdSpotDimensions(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> getOmidVendors(AdParams adParams) {
        ArrayList arrayList = new ArrayList();
        if (adParams != null && adParams.getVerificationScriptResources() != null && !adParams.getVerificationScriptResources().isEmpty()) {
            for (VerificationScriptResource verificationScriptResource : adParams.getVerificationScriptResources()) {
                if (!TextUtils.isEmpty(verificationScriptResource.getVendorKey())) {
                    arrayList.add(verificationScriptResource.getVendorKey());
                }
            }
        }
        return arrayList;
    }
}
