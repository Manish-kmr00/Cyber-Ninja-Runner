package io.bidmachine.tracking;

import android.text.TextUtils;
import com.explorestack.protobuf.StringValue;
import com.explorestack.protobuf.Struct;
import io.bidmachine.AdsType;
import io.bidmachine.ApiRequest;
import io.bidmachine.TrackEventType;
import io.bidmachine.core.Logger;
import io.bidmachine.core.NetworkRequest;
import io.bidmachine.protobuf.AdExtension;
import io.bidmachine.protobuf.analytics.events.SDKEvent;
import io.bidmachine.protobuf.sdk.Error;
import io.bidmachine.utils.BMError;
import io.bidmachine.utils.ProtoUtils;
import io.bidmachine.utils.lazy.LazyValue;

/* JADX INFO: loaded from: classes9.dex */
public class EventTrackerImpl implements EventTracker {
    private AdExtension.EventConfiguration defaultEventConfiguration;

    public EventTrackerImpl() {
        this(null);
    }

    public EventTrackerImpl(AdExtension.EventConfiguration eventConfiguration) {
        setDefaultEventConfiguration(eventConfiguration);
    }

    public void setDefaultEventConfiguration(AdExtension.EventConfiguration eventConfiguration) {
        if (eventConfiguration != null && eventConfiguration.equals(AdExtension.EventConfiguration.getDefaultInstance())) {
            eventConfiguration = null;
        }
        this.defaultEventConfiguration = eventConfiguration;
    }

    @Override // io.bidmachine.tracking.EventTracker
    public void trackEvent(TrackingObject trackingObject, TrackEventType trackEventType, TrackEventInfo trackEventInfo, AdsType adsType, BMError bMError, EventData eventData) {
        long jCurrentTimeMillis;
        long finishTimeMs;
        String networkName;
        Double price;
        Struct customParams;
        if (bMError == null || bMError.isTrackError()) {
            if (trackEventInfo != null) {
                jCurrentTimeMillis = trackEventInfo.getStartTimeMs();
                finishTimeMs = trackEventInfo.getFinishTimeMs();
            } else {
                jCurrentTimeMillis = System.currentTimeMillis();
                finishTimeMs = jCurrentTimeMillis;
            }
            if (eventData != null) {
                networkName = eventData.getNetworkName();
                price = eventData.getPrice();
                customParams = eventData.getCustomParams();
            } else {
                networkName = null;
                price = null;
                customParams = null;
            }
            int actionValue = trackEventType.getActionValue();
            if (trySendEvent(trackingObject.getEventConfiguration(), actionValue, jCurrentTimeMillis, finishTimeMs, adsType, networkName, price, customParams, bMError)) {
                return;
            }
            trySendEvent(this.defaultEventConfiguration, actionValue, jCurrentTimeMillis, finishTimeMs, adsType, networkName, price, customParams, bMError);
        }
    }

    private static boolean trySendEvent(AdExtension.EventConfiguration eventConfiguration, final int i, long j, long j2, AdsType adsType, String str, Double d, Struct struct, final BMError bMError) {
        if (eventConfiguration != null) {
            try {
                if (eventConfiguration.getActionsList().contains(Integer.valueOf(i))) {
                    String url = eventConfiguration.getUrl();
                    if (TextUtils.isEmpty(url)) {
                        return false;
                    }
                    if (bMError == null) {
                        Logger.d((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.tracking.EventTrackerImpl$$ExternalSyntheticLambda0
                            @Override // io.bidmachine.utils.lazy.LazyValue
                            public final Object get() {
                                return String.format("Sending event to server - %s", Integer.valueOf(i));
                            }
                        });
                    } else {
                        Logger.d((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.tracking.EventTrackerImpl$$ExternalSyntheticLambda1
                            @Override // io.bidmachine.utils.lazy.LazyValue
                            public final Object get() {
                                return String.format("Sending error event to server - %s, error - %s", Integer.valueOf(i), bMError);
                            }
                        });
                    }
                    SDKEvent.Builder finishTime = SDKEvent.newBuilder().setAction(i).setContext(eventConfiguration.getContext()).setStartTime(ProtoUtils.msToProtobufTimestamp(j)).setFinishTime(ProtoUtils.msToProtobufTimestamp(j2));
                    if (adsType != null) {
                        finishTime.setAdType(StringValue.newBuilder().setValue(adsType.getName()).build());
                    }
                    if (!TextUtils.isEmpty(str)) {
                        finishTime.setNetwork(StringValue.newBuilder().setValue(str).build());
                    }
                    if (d != null) {
                        finishTime.setPrice(d.doubleValue());
                    }
                    if (struct != null) {
                        finishTime.setCustomParams(struct);
                    }
                    if (bMError != null) {
                        Error.Builder error = Error.newBuilder().setError(toErrorData(bMError));
                        BMError errorExtension = bMError.getErrorExtension();
                        if (errorExtension != null) {
                            error.setReason(toErrorData(errorExtension));
                        }
                        finishTime.setError(error);
                    }
                    new ApiRequest.Builder().url(url).setMethod(NetworkRequest.Method.Post).setDataBinder(new ApiRequest.ApiEventDataBinder()).setRequestData(finishTime.build()).request();
                    return true;
                }
            } catch (Throwable th) {
                Logger.w(th);
            }
        }
        return false;
    }

    private static Error.Data toErrorData(BMError bMError) {
        return Error.Data.newBuilder().setCode(bMError.getCode()).setDescription(bMError.getMessage()).build();
    }
}
