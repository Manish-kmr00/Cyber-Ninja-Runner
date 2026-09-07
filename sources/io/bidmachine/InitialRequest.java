package io.bidmachine;

import android.content.Context;
import android.text.TextUtils;
import com.explorestack.protobuf.ListValue;
import com.explorestack.protobuf.Struct;
import com.explorestack.protobuf.Value;
import com.explorestack.protobuf.adcom.ConnectionType;
import com.explorestack.protobuf.adcom.DeviceType;
import com.explorestack.protobuf.adcom.OS;
import io.bidmachine.ads.networks.adaptiverendering.AdaptiveRenderingAdapter;
import io.bidmachine.ads.networks.nast.NastAdapter;
import io.bidmachine.core.Logger;
import io.bidmachine.core.NetworkRequest;
import io.bidmachine.core.Utils;
import io.bidmachine.protobuf.InitRequest;
import io.bidmachine.protobuf.InitResponse;
import io.bidmachine.tracking.TrackingObject;
import io.bidmachine.utils.BMError;
import io.bidmachine.utils.DeviceUtils;
import io.bidmachine.utils.ProtoUtils;
import io.bidmachine.utils.lazy.LazyValue;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
class InitialRequest {
    private final Context applicationContext;
    private final Queue<String> baseUrlQueue;
    private ApiRequest<InitRequest, InitResponse> currentInitRequest;
    private final Queue<String> currentUrlQueue;
    private Listener listener;
    private final String sellerId;
    private static final long MIN_INIT_REQUEST_DELAY_MS = TimeUnit.SECONDS.toMillis(2);
    private static final long MAX_INIT_REQUEST_DELAY_MS = TimeUnit.SECONDS.toMillis(128);
    private long initRequestDelayMs = 0;
    private final TrackingObject trackingObject = new BidMachineTrackingObject();
    private final Runnable initialRunnable = new InitialRunnable(this);

    interface Listener extends NetworkRequest.Callback<InitResponse, BMError> {
    }

    public InitialRequest(Context context, String str, Queue<String> queue) {
        this.applicationContext = context;
        this.sellerId = str;
        this.baseUrlQueue = new LinkedList(queue);
        this.currentUrlQueue = new LinkedList(queue);
    }

    void setListener(Listener listener) {
        this.listener = listener;
    }

    void request() {
        this.trackingObject.eventStart(TrackEventType.InitLoading, null);
        Utils.onBackgroundThread(new Runnable() { // from class: io.bidmachine.InitialRequest.1
            @Override // java.lang.Runnable
            public void run() {
                InitialRequest.this.currentInitRequest = new ApiRequest.Builder().url(InitialRequest.this.pollUrl()).setDataBinder(new ApiRequest.ApiInitDataBinder()).setRequestData(InitialRequest.this.createInitRequest()).setCallback(new C07641()).request();
            }

            /* JADX INFO: renamed from: io.bidmachine.InitialRequest$1$1, reason: invalid class name and collision with other inner class name */
            class C07641 implements NetworkRequest.Callback<InitResponse, BMError> {
                C07641() {
                }

                @Override // io.bidmachine.core.NetworkRequest.Callback
                public void onSuccess(InitResponse initResponse) {
                    InitialRequest.this.currentInitRequest = null;
                    InitialRequest.this.initRequestDelayMs = 0L;
                    Utils.cancelBackgroundThreadTask(InitialRequest.this.initialRunnable);
                    if (InitialRequest.this.listener != null) {
                        InitialRequest.this.listener.onSuccess(initResponse);
                    }
                    InitialRequest.this.trackingObject.eventFinish(TrackEventType.InitLoading, null, null, null);
                }

                @Override // io.bidmachine.core.NetworkRequest.Callback
                public void onFail(BMError bMError) {
                    final long jCalculateDelay;
                    InitialRequest.this.currentInitRequest = null;
                    if (InitialRequest.this.currentUrlQueue.isEmpty()) {
                        jCalculateDelay = InitialRequest.this.calculateDelay();
                        Logger.d((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.InitialRequest$1$1$$ExternalSyntheticLambda0
                            @Override // io.bidmachine.utils.lazy.LazyValue
                            public final Object get() {
                                return String.format("reschedule init request (%s)", Long.valueOf(jCalculateDelay));
                            }
                        });
                        if (InitialRequest.this.listener != null) {
                            InitialRequest.this.listener.onFail(bMError);
                        }
                    } else {
                        jCalculateDelay = 0;
                    }
                    Utils.onBackgroundThread(InitialRequest.this.initialRunnable, jCalculateDelay);
                    InitialRequest.this.trackingObject.eventFinish(TrackEventType.InitLoading, null, null, bMError);
                }
            }
        });
    }

    void destroy() {
        this.listener = null;
        this.currentInitRequest = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String pollUrl() {
        if (this.currentUrlQueue.isEmpty()) {
            this.currentUrlQueue.addAll(this.baseUrlQueue);
        }
        return this.currentUrlQueue.poll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InitRequest createInitRequest() throws Throwable {
        DeviceType deviceType;
        ConnectionType connectionType;
        AdvertisingDataManager.updateInfo(this.applicationContext);
        BidMachineImpl bidMachineImpl = BidMachineImpl.get();
        UserRestrictionParams userRestrictionParams = bidMachineImpl.getUserRestrictionParams();
        TargetingParams targetingParams = bidMachineImpl.getTargetingParams();
        InitRequest.Builder builderNewBuilder = InitRequest.newBuilder();
        String packageName = this.applicationContext.getPackageName();
        if (packageName != null) {
            builderNewBuilder.setBundle(packageName);
        }
        builderNewBuilder.setSellerId(this.sellerId);
        builderNewBuilder.setOs(OS.OS_ANDROID);
        builderNewBuilder.setOsv(DeviceUtils.getOsVersion());
        String appVersion = Utils.getAppVersion(this.applicationContext);
        if (appVersion != null) {
            builderNewBuilder.setAppVer(appVersion);
        }
        builderNewBuilder.setSdk(BidMachine.NAME);
        builderNewBuilder.setSdkver("3.2.1");
        builderNewBuilder.setIfa(AdvertisingDataManager.getAdvertisingId(this.applicationContext, !userRestrictionParams.canSendIfa()));
        String ifv = bidMachineImpl.getIFV();
        if (!TextUtils.isEmpty(ifv)) {
            builderNewBuilder.setIfv(ifv);
        }
        builderNewBuilder.setBmIfv(bidMachineImpl.obtainBMIFV(this.applicationContext));
        builderNewBuilder.setSessionId(SessionManager.get().getSessionId());
        DeviceInfo deviceInfoObtain = DeviceInfo.obtain(this.applicationContext);
        String str = deviceInfoObtain.manufacturer;
        if (str != null) {
            builderNewBuilder.setMake(str);
        }
        String str2 = deviceInfoObtain.model;
        if (str2 != null) {
            builderNewBuilder.setModel(str2);
        }
        String hwv = deviceInfoObtain.getHWV();
        if (hwv != null) {
            builderNewBuilder.setHwv(hwv);
        }
        if (deviceInfoObtain.isTablet) {
            deviceType = DeviceType.DEVICE_TYPE_TABLET;
        } else {
            deviceType = DeviceType.DEVICE_TYPE_PHONE_DEVICE;
        }
        builderNewBuilder.setDeviceType(deviceType);
        if (userRestrictionParams.canSendDeviceInfo()) {
            ConnectionType connectionType2 = DeviceUtils.getConnectionType(this.applicationContext);
            builderNewBuilder.setContype(connectionType2);
            connectionType = connectionType2;
        } else {
            connectionType = null;
        }
        if (userRestrictionParams.canSendGeoPosition()) {
            com.explorestack.protobuf.adcom.Context.Geo.Builder builderCreateGeoBuilderWithLocation = ProtoUtils.createGeoBuilderWithLocation(this.applicationContext, targetingParams.getDeviceLocation(), null, true);
            targetingParams.build(builderCreateGeoBuilderWithLocation);
            builderNewBuilder.setGeo(builderCreateGeoBuilderWithLocation);
        }
        builderNewBuilder.setContext(RequestDataRetriever.collectContext(this.applicationContext, bidMachineImpl, userRestrictionParams, targetingParams, null, connectionType, null));
        builderNewBuilder.setExt(createExtension(this.applicationContext));
        return builderNewBuilder.build();
    }

    private Struct createExtension(Context context) {
        Struct.Builder builderNewBuilder = Struct.newBuilder();
        builderNewBuilder.putFields("networks_info", Value.newBuilder().setListValue(createNetworkInfoListValue(context)).build());
        return builderNewBuilder.build();
    }

    private ListValue.Builder createNetworkInfoListValue(Context context) {
        ListValue.Builder builderNewBuilder = ListValue.newBuilder();
        for (NetworkAssetParams networkAssetParams : NetworkAssetManager.getNetworkAssetParamsMap(context).values()) {
            builderNewBuilder.addValues(createNetworkInfoValue(networkAssetParams.getName(), networkAssetParams.getSdkVersion(), networkAssetParams.getAdapterVersion()));
        }
        builderNewBuilder.addValues(createNetworkInfoValue("mraid", "2.4.0", "3.2.1.1"));
        builderNewBuilder.addValues(createNetworkInfoValue("vast", "2.4.0", "3.2.1.1"));
        builderNewBuilder.addValues(createNetworkInfoValue(NastAdapter.KEY, "1.0", "3.2.1.1"));
        builderNewBuilder.addValues(createNetworkInfoValue(AdaptiveRenderingAdapter.KEY, "2.4.0", "3.2.1.1"));
        return builderNewBuilder;
    }

    private Value createNetworkInfoValue(String str, String str2, String str3) {
        Value valueBuild = Value.newBuilder().setStringValue(str).build();
        Value valueBuild2 = Value.newBuilder().setStringValue(str2).build();
        return Value.newBuilder().setStructValue(Struct.newBuilder().putFields("network", valueBuild).putFields("network_version", valueBuild2).putFields("network_adapter_version", Value.newBuilder().setStringValue(str3).build()).build()).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long calculateDelay() {
        long j = this.initRequestDelayMs;
        if (j <= 0) {
            this.initRequestDelayMs = MIN_INIT_REQUEST_DELAY_MS;
        } else {
            long j2 = j * 2;
            this.initRequestDelayMs = j2;
            long j3 = MAX_INIT_REQUEST_DELAY_MS;
            if (j2 >= j3) {
                this.initRequestDelayMs = j3;
            }
        }
        return this.initRequestDelayMs;
    }

    private static class InitialRunnable implements Runnable {
        private final WeakReference<InitialRequest> weakInitialRequest;

        public InitialRunnable(InitialRequest initialRequest) {
            this.weakInitialRequest = new WeakReference<>(initialRequest);
        }

        @Override // java.lang.Runnable
        public void run() {
            InitialRequest initialRequest = this.weakInitialRequest.get();
            if (initialRequest != null) {
                initialRequest.request();
            }
        }
    }
}
