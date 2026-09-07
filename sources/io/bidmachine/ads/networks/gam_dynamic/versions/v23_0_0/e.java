package io.bidmachine.ads.networks.gam_dynamic.versions.v23_0_0;

import android.text.TextUtils;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.explorestack.protobuf.DoubleValue;
import com.explorestack.protobuf.StringValue;
import com.explorestack.protobuf.UInt32Value;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.BaseAdView;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import io.bidmachine.ads.networks.gam_dynamic.InternalAdLoadData;
import io.bidmachine.protobuf.Waterfall;
import io.bidmachine.utils.BMError;
import io.bidmachine.utils.ReflectionUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
class e {
    static AdManagerAdRequest a(Waterfall.Configuration.AdUnit adUnit) {
        AdManagerAdRequest.Builder builder = new AdManagerAdRequest.Builder();
        String requestAgent = adUnit.getRequestAgent();
        if (!TextUtils.isEmpty(requestAgent)) {
            builder.setRequestAgent(requestAgent);
        }
        for (Map.Entry<String, String> entry : adUnit.getCustomTargetingMap().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                builder.addCustomTargeting(key, value);
            }
        }
        return builder.build();
    }

    static BMError a(BMError bMError, AdError adError) {
        return new BMError(bMError, adError.getCode(), adError.getMessage());
    }

    static InternalAdLoadData a(BaseAdView baseAdView) {
        if (baseAdView == null) {
            return null;
        }
        Waterfall.Result.EstimatedPrice estimatedPriceA = a(baseAdView, new String[]{"zza", "zzj", "zza", "a", "a", CampaignEx.JSON_KEY_AD_K, ApsMetricsDataMap.APSMETRICS_FIELD_ADAPTEREVENT});
        ResponseInfo responseInfo = baseAdView.getResponseInfo();
        String string = responseInfo != null ? responseInfo.toString() : null;
        if (estimatedPriceA == null && string == null) {
            return null;
        }
        return new InternalAdLoadData(estimatedPriceA, string);
    }

    static InternalAdLoadData a(InterstitialAd interstitialAd) {
        if (interstitialAd == null) {
            return null;
        }
        return new InternalAdLoadData(a(interstitialAd, new String[]{"zzc", "zza", "a", "a", CampaignEx.JSON_KEY_AD_K, ApsMetricsDataMap.APSMETRICS_FIELD_ADAPTEREVENT}), interstitialAd.getResponseInfo().toString());
    }

    static InternalAdLoadData a(RewardedAd rewardedAd) {
        if (rewardedAd == null) {
            return null;
        }
        return new InternalAdLoadData(a(rewardedAd, new String[]{"zzb", "zza", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, CampaignEx.JSON_KEY_AD_K, ApsMetricsDataMap.APSMETRICS_FIELD_ADAPTEREVENT}), rewardedAd.getResponseInfo().toString());
    }

    static Waterfall.Result.EstimatedPrice a(AdValue adValue) {
        return Waterfall.Result.EstimatedPrice.newBuilder().setValue(DoubleValue.newBuilder().setValue(adValue.getValueMicros()).build()).setCurrency(StringValue.newBuilder().setValue(adValue.getCurrencyCode()).build()).setPrecision(UInt32Value.newBuilder().setValue(adValue.getPrecisionType()).build()).build();
    }

    static Waterfall.Result.EstimatedPrice a(Object obj, String[] strArr) {
        try {
            Object objFindValueByPath = ReflectionUtils.findValueByPath(obj, strArr);
            if (objFindValueByPath == null) {
                return null;
            }
            Integer num = (Integer) ReflectionUtils.findValue(objFindValueByPath, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
            String str = (String) ReflectionUtils.findValue(objFindValueByPath, ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM);
            Number number = (Number) ReflectionUtils.findValue(objFindValueByPath, "d");
            Double dValueOf = number != null ? Double.valueOf(number.doubleValue()) : null;
            if (num == null && str == null && dValueOf == null) {
                return null;
            }
            Waterfall.Result.EstimatedPrice.Builder builderNewBuilder = Waterfall.Result.EstimatedPrice.newBuilder();
            if (dValueOf != null) {
                builderNewBuilder.setValue(DoubleValue.newBuilder().setValue(dValueOf.doubleValue()).build());
            }
            if (str != null) {
                builderNewBuilder.setCurrency(StringValue.newBuilder().setValue(str).build());
            }
            if (num != null) {
                builderNewBuilder.setPrecision(UInt32Value.newBuilder().setValue(num.intValue()).build());
            }
            return builderNewBuilder.build();
        } catch (Throwable unused) {
            return null;
        }
    }
}
