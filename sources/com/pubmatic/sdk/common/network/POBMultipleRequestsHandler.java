package com.pubmatic.sdk.common.network;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.pubmatic.sdk.common.POBError;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J5\u0010\u000f\u001a\u00020\u000e2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0018\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n0\t¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/pubmatic/sdk/common/network/POBMultipleRequestsHandler;", "", "Lcom/pubmatic/sdk/common/network/POBNetworkHandler;", "networkHandler", "<init>", "(Lcom/pubmatic/sdk/common/network/POBNetworkHandler;)V", "", "Lcom/pubmatic/sdk/common/network/POBHttpRequest;", "requests", "Lcom/pubmatic/sdk/common/network/POBNetworkHandler$POBNetworkListener;", "", "", "Lcom/pubmatic/sdk/common/network/POBResponse;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "sendRequests", "(Ljava/util/List;Lcom/pubmatic/sdk/common/network/POBNetworkHandler$POBNetworkListener;)V", "a", "Lcom/pubmatic/sdk/common/network/POBNetworkHandler;", "common_release"}, k = 1, mv = {1, 7, 1})
public final class POBMultipleRequestsHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final POBNetworkHandler networkHandler;

    public POBMultipleRequestsHandler(POBNetworkHandler networkHandler) {
        Intrinsics.checkNotNullParameter(networkHandler, "networkHandler");
        this.networkHandler = networkHandler;
    }

    public final void sendRequests(List<? extends POBHttpRequest> requests, final POBNetworkHandler.POBNetworkListener<Map<String, POBResponse>> listener) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(requests, "requests");
        Intrinsics.checkNotNullParameter(listener, "listener");
        final AtomicInteger atomicInteger = new AtomicInteger(requests.size());
        final ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (final POBHttpRequest pOBHttpRequest : requests) {
            String requestTag = pOBHttpRequest.getRequestTag();
            if (requestTag == null || requestTag.length() == 0) {
                throw new IllegalArgumentException("Request tag cannot be null or empty");
            }
            this.networkHandler.sendRequest(pOBHttpRequest, new POBNetworkHandler.POBNetworkListener<String>() { // from class: com.pubmatic.sdk.common.network.POBMultipleRequestsHandler.sendRequests.1
                @Override // com.pubmatic.sdk.common.network.POBNetworkHandler.POBNetworkListener
                public void onFailure(POBError error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    ConcurrentHashMap concurrentHashMap2 = concurrentHashMap;
                    String requestTag2 = pOBHttpRequest.getRequestTag();
                    Intrinsics.checkNotNull(requestTag2);
                    concurrentHashMap2.put(requestTag2, new POBResponse.Error(error));
                    if (atomicInteger.decrementAndGet() == 0) {
                        listener.onSuccess(concurrentHashMap);
                    }
                }

                @Override // com.pubmatic.sdk.common.network.POBNetworkHandler.POBNetworkListener
                public void onSuccess(String response) {
                    ConcurrentHashMap concurrentHashMap2 = concurrentHashMap;
                    String requestTag2 = pOBHttpRequest.getRequestTag();
                    Intrinsics.checkNotNull(requestTag2);
                    concurrentHashMap2.put(requestTag2, (response == null || response.length() == 0) ? new POBResponse.Error(new POBError(1007, "Response is null or empty")) : new POBResponse.Success(response));
                    if (atomicInteger.decrementAndGet() == 0) {
                        listener.onSuccess(concurrentHashMap);
                    }
                }
            });
        }
    }
}
