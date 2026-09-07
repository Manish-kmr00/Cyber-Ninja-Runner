package io.appmetrica.analytics.networktasks.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import io.appmetrica.analytics.coreapi.internal.io.IExecutionPolicy;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.network.internal.NetworkClient;
import io.appmetrica.analytics.network.internal.Request;
import io.appmetrica.analytics.network.internal.Response;
import io.appmetrica.analytics.networktasks.internal.ExponentialBackoffPolicy;
import io.appmetrica.analytics.networktasks.internal.NetworkTask;
import io.appmetrica.analytics.networktasks.internal.RequestDataHolder;
import io.appmetrica.analytics.networktasks.internal.ResponseDataHolder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NetworkTask f11938a;
    public final InterruptionSafeThread b;
    public final f c;

    public h(NetworkTask networkTask, InterruptionSafeThread interruptionSafeThread, f fVar) {
        this.f11938a = networkTask;
        this.b = interruptionSafeThread;
        this.c = fVar;
    }

    /* JADX WARN: Code duplicated, block: B:60:0x01bf  */
    @Override // java.lang.Runnable
    public final void run() {
        boolean zOnRequestComplete;
        byte[] postData;
        ExponentialBackoffPolicy exponentialBackoffPolicy = this.f11938a.getExponentialBackoffPolicy();
        IExecutionPolicy connectionExecutionPolicy = this.f11938a.getConnectionExecutionPolicy();
        if (!this.b.isRunning() || !connectionExecutionPolicy.canBeExecuted() || !exponentialBackoffPolicy.canBeExecuted(this.f11938a.getRetryPolicyConfig())) {
            this.f11938a.onShouldNotExecute();
            return;
        }
        boolean zOnCreateNetworkTask = this.f11938a.onCreateNetworkTask();
        Boolean boolValueOf = null;
        while (this.b.isRunning() && zOnCreateNetworkTask && exponentialBackoffPolicy.canBeExecuted(this.f11938a.getRetryPolicyConfig())) {
            f fVar = this.c;
            NetworkTask networkTask = this.f11938a;
            fVar.getClass();
            if (networkTask.onPerformRequest()) {
                String url = networkTask.getUrl();
                if (url == null || TextUtils.isEmpty(StringsKt.trim((CharSequence) url).toString())) {
                    StringBuilder sbAppend = new StringBuilder("Task ").append(networkTask.description()).append(" url is `").append(url).append("`. All hosts = ");
                    List<String> allHosts = networkTask.getUnderlyingTask().getFullUrlFormer().getAllHosts();
                    networkTask.onRequestError(new IllegalArgumentException(sbAppend.append(allHosts != null ? allHosts.toString() : null).toString()));
                } else {
                    Request.Builder builderAddHeader = new Request.Builder(url).addHeader("Accept", "application/json").addHeader("User-Agent", networkTask.getUserAgent());
                    RequestDataHolder requestDataHolder = networkTask.getRequestDataHolder();
                    Iterator<T> it = requestDataHolder.getHeaders().entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry entry = (Map.Entry) it.next();
                        builderAddHeader.addHeader((String) entry.getKey(), CollectionsKt.joinToString$default((Iterable) entry.getValue(), StringUtils.COMMA, null, null, 0, null, null, 62, null));
                    }
                    if (NetworkTask.Method.POST == requestDataHolder.getMethod() && (postData = requestDataHolder.getPostData()) != null) {
                        if (!(postData.length == 0)) {
                            builderAddHeader.post(postData);
                            Long sendTimestamp = requestDataHolder.getSendTimestamp();
                            if (sendTimestamp != null) {
                                builderAddHeader.addHeader("Send-Timestamp", String.valueOf(TimeUnit.MILLISECONDS.toSeconds(sendTimestamp.longValue())));
                            }
                            Integer sendTimezoneSec = requestDataHolder.getSendTimezoneSec();
                            if (sendTimezoneSec != null) {
                                builderAddHeader.addHeader("Send-Timezone", String.valueOf(sendTimezoneSec.intValue()));
                            }
                        }
                    }
                    NetworkClient.Builder builder = new NetworkClient.Builder();
                    int i = b.f11935a;
                    Response responseExecute = builder.withConnectTimeout(i).withReadTimeout(i).withSslSocketFactory(networkTask.getSslSocketFactory()).build().newCall(builderAddHeader.build()).execute();
                    int code = responseExecute.getCode();
                    ResponseDataHolder responseDataHolder = networkTask.getResponseDataHolder();
                    responseDataHolder.setResponseCode(code);
                    responseDataHolder.setResponseHeaders(CollectionUtils.convertMapKeysToLowerCase(responseExecute.getHeaders()));
                    if (responseDataHolder.isValidResponse()) {
                        responseDataHolder.setResponseData(responseExecute.getResponseData());
                    }
                    if (responseExecute.isCompleted()) {
                        zOnRequestComplete = networkTask.onRequestComplete();
                    } else {
                        networkTask.onRequestError(responseExecute.getException());
                    }
                    boolValueOf = Boolean.valueOf(zOnRequestComplete);
                    if (boolValueOf.booleanValue() && this.f11938a.shouldTryNextHost()) {
                        zOnCreateNetworkTask = true;
                    } else {
                        zOnCreateNetworkTask = false;
                    }
                    exponentialBackoffPolicy.onHostAttemptFinished(boolValueOf.booleanValue());
                }
            } else {
                networkTask.onRequestError(null);
            }
            zOnRequestComplete = false;
            boolValueOf = Boolean.valueOf(zOnRequestComplete);
            if (boolValueOf.booleanValue()) {
                zOnCreateNetworkTask = false;
            } else {
                zOnCreateNetworkTask = false;
            }
            exponentialBackoffPolicy.onHostAttemptFinished(boolValueOf.booleanValue());
        }
        if (boolValueOf != null) {
            exponentialBackoffPolicy.onAllHostsAttemptsFinished(boolValueOf.booleanValue());
        }
    }
}
