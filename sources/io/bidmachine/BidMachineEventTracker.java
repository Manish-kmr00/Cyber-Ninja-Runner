package io.bidmachine;

import android.text.TextUtils;
import io.bidmachine.core.Logger;
import io.bidmachine.core.NetworkRequest;
import io.bidmachine.tracking.EventData;
import io.bidmachine.tracking.EventTracker;
import io.bidmachine.tracking.TrackEventInfo;
import io.bidmachine.tracking.TrackingObject;
import io.bidmachine.utils.BMError;
import io.bidmachine.utils.lazy.LazyValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class BidMachineEventTracker implements EventTracker {
    BidMachineEventTracker() {
    }

    @Override // io.bidmachine.tracking.EventTracker
    public void trackEvent(TrackingObject trackingObject, TrackEventType trackEventType, TrackEventInfo trackEventInfo, AdsType adsType, BMError bMError, EventData eventData) {
        if (bMError != null) {
            trackError(collectTrackingUrls(trackingObject, TrackEventType.Error), collectTrackingUrls(trackingObject, TrackEventType.TrackingError), trackEventInfo, trackEventType.getActionValue(), bMError);
        } else {
            trackEvent(collectTrackingUrls(trackingObject, trackEventType), collectTrackingUrls(trackingObject, TrackEventType.TrackingError), trackEventInfo, trackEventType, eventData);
        }
    }

    private static List<String> collectTrackingUrls(TrackingObject trackingObject, TrackEventType trackEventType) {
        List<String> trackingUrls = BidMachineImpl.get().getTrackingUrls(trackEventType);
        ArrayList arrayList = trackingUrls != null ? new ArrayList(trackingUrls) : null;
        List<String> trackingUrls2 = trackingObject.getTrackingUrls(trackEventType);
        if (trackingUrls2 == null) {
            return arrayList;
        }
        if (arrayList == null) {
            return new ArrayList(trackingUrls2);
        }
        arrayList.addAll(trackingUrls2);
        return arrayList;
    }

    private static void trackEvent(List<String> list, final List<String> list2, final TrackEventInfo trackEventInfo, final TrackEventType trackEventType, EventData eventData) {
        if (list == null) {
            return;
        }
        Logger.d((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.BidMachineEventTracker$$ExternalSyntheticLambda2
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return String.format("Dispatching event to server - %s", trackEventType);
            }
        });
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            executeNotify(replaceMacros(it.next(), trackEventInfo, trackEventType.getActionValue(), -1, eventData), new NetworkRequest.Callback<String, BMError>() { // from class: io.bidmachine.BidMachineEventTracker.1
                @Override // io.bidmachine.core.NetworkRequest.Callback
                public void onSuccess(String str) {
                }

                @Override // io.bidmachine.core.NetworkRequest.Callback
                public void onFail(BMError bMError) {
                    if (bMError == null) {
                        bMError = BMError.internal("Failed to track URL");
                    }
                    BidMachineEventTracker.trackTrackingError(list2, trackEventInfo, trackEventType.getActionValue(), bMError);
                }
            });
        }
    }

    private static void trackError(List<String> list, final List<String> list2, final TrackEventInfo trackEventInfo, final int i, final BMError bMError) {
        if (list != null && bMError.isTrackError()) {
            Logger.d((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.BidMachineEventTracker$$ExternalSyntheticLambda1
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    int i2 = i;
                    BMError bMError2 = bMError;
                    return String.format("Dispatching error event to server - (%s-%s) - %s", Integer.valueOf(i2), Integer.valueOf(bMError2.getCode()), bMError2.getMessage());
                }
            });
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                executeNotify(replaceMacros(it.next(), trackEventInfo, i, bMError.getCode(), null), new NetworkRequest.Callback<String, BMError>() { // from class: io.bidmachine.BidMachineEventTracker.2
                    @Override // io.bidmachine.core.NetworkRequest.Callback
                    public void onSuccess(String str) {
                    }

                    @Override // io.bidmachine.core.NetworkRequest.Callback
                    public void onFail(BMError bMError2) {
                        if (bMError2 == null) {
                            bMError2 = BMError.internal("Failed to track URL");
                        }
                        BidMachineEventTracker.trackTrackingError(list2, trackEventInfo, TrackEventType.Error.getActionValue(), bMError2);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void trackTrackingError(List<String> list, TrackEventInfo trackEventInfo, int i, final BMError bMError) {
        if (list != null && bMError.isTrackError()) {
            Logger.d((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.BidMachineEventTracker$$ExternalSyntheticLambda0
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    return String.format("Dispatching tracking fail to server - %s", bMError);
                }
            });
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                executeNotify(replaceMacros(it.next(), trackEventInfo, i, bMError.getCode(), null), null);
            }
        }
    }

    static String replaceMacros(String str, TrackEventInfo trackEventInfo, int i, int i2, EventData eventData) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String strReplaceMacros = replaceMacros(replaceMacros(replaceMacros(str, Constants.URL_MACROS_BM_EVENT_CODE, Integer.valueOf(i)), Constants.URL_MACROS_BM_ACTION_CODE, Integer.valueOf(i)), Constants.URL_MACROS_BM_ERROR_REASON, Integer.valueOf(i2));
        if (eventData != null) {
            String networkName = eventData.getNetworkName();
            if (networkName != null) {
                strReplaceMacros = replaceMacros(strReplaceMacros, Constants.URL_MACROS_AUCTION_SEAT_ID, networkName);
            }
            Double price = eventData.getPrice();
            if (price != null) {
                strReplaceMacros = replaceMacros(strReplaceMacros, Constants.URL_MACROS_AUCTION_PRICE, price);
            }
        }
        return trackEventInfo != null ? replaceMacros(replaceMacros(replaceMacros(strReplaceMacros, Constants.URL_MACROS_BM_ACTION_START, Long.valueOf(trackEventInfo.getStartTimeMs())), Constants.URL_MACROS_BM_ACTION_FINISH, Long.valueOf(trackEventInfo.getFinishTimeMs())), trackEventInfo.getEventParameters()) : strReplaceMacros;
    }

    private static String replaceMacros(String str, Map<String, Object> map) {
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (!TextUtils.isEmpty(key) && value != null) {
                    str = replaceMacros(str, key, value);
                }
            }
        }
        return str;
    }

    private static String replaceMacros(String str, String str2, Object obj) {
        return str.replace("${" + str2 + "}", String.valueOf(obj)).replace("%24%7B" + str2 + "%7D", String.valueOf(obj));
    }

    private static void executeNotify(String str, NetworkRequest.Callback<String, BMError> callback) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        new ApiRequest.Builder().url(str).setMethod(NetworkRequest.Method.Get).setDataBinder(new ApiRequest.ApiTrackerDataBinder()).setCallback(callback).request();
    }
}
