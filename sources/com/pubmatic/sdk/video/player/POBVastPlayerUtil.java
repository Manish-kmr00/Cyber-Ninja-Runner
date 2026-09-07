package com.pubmatic.sdk.video.player;

import android.content.Context;
import com.pubmatic.sdk.common.OpenWrapSDK;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.pubmatic.sdk.common.POBInstanceProvider;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.models.POBDeviceInfo;
import com.pubmatic.sdk.common.utility.POBUtils;
import com.pubmatic.sdk.video.POBVastPlayerConfig;
import com.pubmatic.sdk.video.POBVideoConstant;
import com.pubmatic.sdk.video.vastmodels.POBCompanion;
import com.pubmatic.sdk.video.vastmodels.POBMediaFile;
import com.pubmatic.sdk.video.vastmodels.POBVastAd;
import com.safedk.android.internal.SafeDKWebAppInterface;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public class POBVastPlayerUtil {
    private static List a(List list, POBVideoPlayer.SupportedMediaType[] supportedMediaTypeArr) {
        ArrayList arrayList;
        ArrayList arrayList2;
        if (list != null) {
            arrayList = new ArrayList();
            arrayList2 = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                POBMediaFile pOBMediaFile = (POBMediaFile) it.next();
                for (POBVideoPlayer.SupportedMediaType supportedMediaType : supportedMediaTypeArr) {
                    String type = pOBMediaFile.getType();
                    if (type != null && type.contains(supportedMediaType.getValue())) {
                        arrayList.add(pOBMediaFile);
                        if (supportedMediaType == POBVideoPlayer.SupportedMediaType.MEDIA_WEBM) {
                            break;
                        }
                        arrayList2.add(pOBMediaFile);
                        break;
                    }
                }
            }
        } else {
            arrayList = null;
            arrayList2 = null;
        }
        return (arrayList2 == null || !arrayList2.isEmpty()) ? arrayList2 : arrayList;
    }

    public static POBMediaFile filterMediaFiles(List<POBMediaFile> list, POBVideoPlayer.SupportedMediaType[] supportedMediaTypeArr, int i, int i2, int i3) {
        List listA = a(list, supportedMediaTypeArr);
        if (listA == null || listA.size() <= 0) {
            return null;
        }
        if (listA.size() == 1) {
            return (POBMediaFile) listA.get(0);
        }
        float f = i;
        float fA = a((POBMediaFile) listA.get(0), f, i2, i3);
        POBMediaFile pOBMediaFile = (POBMediaFile) listA.get(0);
        for (int i4 = 1; i4 < listA.size(); i4++) {
            POBMediaFile pOBMediaFile2 = (POBMediaFile) listA.get(i4);
            float fA2 = a(pOBMediaFile2, f, i2, i3);
            if (fA2 < fA) {
                pOBMediaFile = pOBMediaFile2;
                fA = fA2;
            }
        }
        return pOBMediaFile;
    }

    public static Map<String, String> generateErrorQueryParams(Context context, POBDeviceInfo pOBDeviceInfo, POBMediaFile pOBMediaFile) {
        HashMap map = new HashMap();
        if (pOBDeviceInfo != null) {
            String make = pOBDeviceInfo.getMake();
            if (make != null) {
                map.put(POBVideoConstant.ERROR_TRACKER_KEY_MAKE, make);
            }
            String model = pOBDeviceInfo.getModel();
            if (model != null) {
                map.put(POBVideoConstant.ERROR_TRACKER_KEY_MODEL, model);
            }
            String osVersion = pOBDeviceInfo.getOsVersion();
            if (osVersion != null) {
                map.put("osv", osVersion);
            }
        }
        map.put(POBVideoConstant.TRACKER_KEY_OW_VERSION, OpenWrapSDK.getVersion());
        map.put(POBVideoConstant.ERROR_TRACKER_KEY_CONNECTION_TYPE, String.valueOf(POBInstanceProvider.getNetworkMonitor(context.getApplicationContext()).getConnectionType().getValue()));
        if (pOBMediaFile != null) {
            int bitrate = pOBMediaFile.getBitrate();
            if (bitrate != 0) {
                map.put("br", String.valueOf(bitrate));
            }
            int width = pOBMediaFile.getWidth();
            int height = pOBMediaFile.getHeight();
            if (width != 0 && height != 0) {
                map.put(POBVideoConstant.ERROR_TRACKER_KEY_CREATIVE_SIZE, width + VastAttributes.HORIZONTAL_POSITION + height);
            }
            String type = pOBMediaFile.getType();
            if (type != null) {
                map.put("mt", type);
            }
        }
        return map;
    }

    public static int getBitRate(boolean z, boolean z2) {
        if (!z || z2) {
            if (z) {
                return 1000;
            }
            if (z2) {
                return 2000;
            }
        }
        return 600;
    }

    public static String getCustomProductPageClickUrl(POBVastAd pOBVastAd, String str) {
        if (pOBVastAd == null) {
            return null;
        }
        String closestClickThroughURL = pOBVastAd.getClosestClickThroughURL();
        if (POBUtils.isValidPlayStoreUrl(closestClickThroughURL)) {
            return closestClickThroughURL;
        }
        if (POBUtils.isNullOrEmpty(str)) {
            return null;
        }
        return String.format(POBCommonConstants.PLAY_STORE_URL, str);
    }

    public static int getScaleFactor(Context context) {
        return context.getResources().getDisplayMetrics().density >= 2.0f ? 2 : 1;
    }

    public static double getSkipOffset(double d, POBVastPlayerConfig pOBVastPlayerConfig, long j) {
        int skipAfter;
        if (pOBVastPlayerConfig.getSkip() == 0) {
            if (d < 0.0d || d > pOBVastPlayerConfig.getMaxDuration()) {
                skipAfter = pOBVastPlayerConfig.getMaxDuration();
                d = skipAfter;
            }
        } else if (pOBVastPlayerConfig.getSkip() != 1) {
            d = 0.0d;
        } else if (j > pOBVastPlayerConfig.getSkipMin()) {
            d = pOBVastPlayerConfig.getMaxDuration() > 0 ? pOBVastPlayerConfig.getMaxDuration() : j;
            if (!pOBVastPlayerConfig.isSkipAfterCompletionEnabled()) {
                skipAfter = pOBVastPlayerConfig.getSkipAfter();
                d = skipAfter;
            }
        } else {
            d = j;
        }
        return Math.floor(d > 0.0d ? Math.min(j, d) : 0.0d);
    }

    public static POBCompanion getSuitableEndCardCompanion(List<POBCompanion> list, float f, float f2) {
        ArrayList<POBCompanion> arrayList = new ArrayList();
        float f3 = f / f2;
        for (POBCompanion pOBCompanion : list) {
            if (SafeDKWebAppInterface.e.equals(pOBCompanion.getRenderingMode())) {
                arrayList.add(pOBCompanion);
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(list);
        }
        float f4 = 9999.0f;
        float f5 = 2.1474836E9f;
        POBCompanion pOBCompanion2 = null;
        for (POBCompanion pOBCompanion3 : arrayList) {
            int width = pOBCompanion3.getWidth();
            int height = pOBCompanion3.getHeight();
            float fConvertDpToPixelWithFloatPrecession = POBUtils.convertDpToPixelWithFloatPrecession(width);
            float fConvertDpToPixelWithFloatPrecession2 = POBUtils.convertDpToPixelWithFloatPrecession(height);
            POBLog.debug("POBVastPlayerUtil", String.format(Locale.getDefault(), "Companion: Width x Height dp = %d x %d px = %.3f x %.3f", Integer.valueOf(width), Integer.valueOf(height), Float.valueOf(fConvertDpToPixelWithFloatPrecession), Float.valueOf(fConvertDpToPixelWithFloatPrecession2)), new Object[0]);
            float fAbs = Math.abs(1.0f - ((fConvertDpToPixelWithFloatPrecession / fConvertDpToPixelWithFloatPrecession2) / f3));
            float fAbs2 = Math.abs(fConvertDpToPixelWithFloatPrecession - f);
            if (fAbs < f4 || (fAbs == f4 && fAbs2 <= f5)) {
                pOBCompanion2 = pOBCompanion3;
                f4 = fAbs;
                f5 = fAbs2;
            }
        }
        return pOBCompanion2;
    }

    private static float a(POBMediaFile pOBMediaFile, float f, int i, int i2) {
        return Math.abs((pOBMediaFile.getBitrate() - f) / f) + Math.abs((pOBMediaFile.getWidth() - i) / i) + Math.abs((pOBMediaFile.getHeight() - i2) / i2);
    }
}
