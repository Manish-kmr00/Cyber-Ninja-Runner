package io.appmetrica.analytics.networktasks.internal;

import io.appmetrica.analytics.coreapi.internal.io.IExecutionPolicy;
import io.appmetrica.analytics.networktasks.impl.e;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes8.dex */
public class NetworkTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11950a = 1;
    private final Executor b;
    private final IExecutionPolicy c;
    private final ExponentialBackoffPolicy d;
    private final UnderlyingNetworkTask e;
    private final List f;
    private final String g;

    public enum Method {
        GET,
        POST
    }

    public interface ShouldTryNextHostCondition {
        boolean shouldTryNextHost(int i);
    }

    public NetworkTask(Executor executor, IExecutionPolicy iExecutionPolicy, ExponentialBackoffPolicy exponentialBackoffPolicy, UnderlyingNetworkTask underlyingNetworkTask, List<ShouldTryNextHostCondition> list, String str) {
        this.b = executor;
        this.c = iExecutionPolicy;
        this.d = exponentialBackoffPolicy;
        this.e = underlyingNetworkTask;
        this.f = list;
        this.g = str;
    }

    private synchronized boolean a(int i) {
        if (!a(i)) {
            return false;
        }
        this.f11950a = i;
        return true;
    }

    public String description() {
        return this.e.description();
    }

    public IExecutionPolicy getConnectionExecutionPolicy() {
        return this.c;
    }

    public Executor getExecutor() {
        return this.b;
    }

    public ExponentialBackoffPolicy getExponentialBackoffPolicy() {
        return this.d;
    }

    public RequestDataHolder getRequestDataHolder() {
        return this.e.getRequestDataHolder();
    }

    public ResponseDataHolder getResponseDataHolder() {
        return this.e.getResponseDataHolder();
    }

    public RetryPolicyConfig getRetryPolicyConfig() {
        return this.e.getRetryPolicyConfig();
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.e.getSslSocketFactory();
    }

    public UnderlyingNetworkTask getUnderlyingTask() {
        return this.e;
    }

    public String getUrl() {
        return this.e.getFullUrlFormer().getUrl();
    }

    public String getUserAgent() {
        return this.g;
    }

    public boolean isRemoved() {
        return this.f11950a == 9;
    }

    public boolean onCreateNetworkTask() {
        if (a(3)) {
            return this.e.onCreateTask();
        }
        return false;
    }

    public boolean onPerformRequest() {
        boolean zA = a(4);
        if (zA) {
            this.e.getFullUrlFormer().incrementAttemptNumber();
            this.e.getFullUrlFormer().buildAndSetFullHostUrl();
            this.e.onPerformRequest();
        }
        return zA;
    }

    public boolean onRequestComplete() {
        boolean zOnRequestComplete;
        boolean z;
        synchronized (this) {
            if (a(5, 6)) {
                zOnRequestComplete = this.e.onRequestComplete();
                if (zOnRequestComplete) {
                    this.f11950a = 5;
                } else {
                    this.f11950a = 6;
                }
                z = true;
            } else {
                zOnRequestComplete = false;
                z = false;
            }
        }
        if (z) {
            this.e.onPostRequestComplete(zOnRequestComplete);
        }
        return zOnRequestComplete;
    }

    public void onRequestError(Throwable th) {
        if (a(6)) {
            this.e.onRequestError(th);
        }
    }

    public void onShouldNotExecute() {
        if (a(7)) {
            this.e.onShouldNotExecute();
        }
    }

    public boolean onTaskAdded() {
        boolean zA = a(2);
        if (zA) {
            this.e.onTaskAdded();
        }
        return zA;
    }

    public void onTaskFinished() {
        int i;
        boolean zA;
        synchronized (this) {
            i = this.f11950a;
            zA = a(8);
        }
        if (zA) {
            this.e.onTaskFinished();
            if (i == 5) {
                this.e.onSuccessfulTaskFinished();
            } else if (i == 6 || i == 7) {
                this.e.onUnsuccessfulTaskFinished();
            }
        }
    }

    public void onTaskRemoved() {
        if (a(9)) {
            this.e.onTaskRemoved();
        }
    }

    public synchronized boolean shouldTryNextHost() {
        boolean z;
        boolean z2;
        boolean zHasMoreHosts = this.e.getFullUrlFormer().hasMoreHosts();
        int responseCode = this.e.getResponseDataHolder().getResponseCode();
        Iterator it = this.f.iterator();
        while (true) {
            z = false;
            if (!it.hasNext()) {
                z2 = true;
                break;
            }
            if (!((ShouldTryNextHostCondition) it.next()).shouldTryNextHost(responseCode)) {
                z2 = false;
                break;
            }
        }
        int i = this.f11950a;
        if (i != 9 && i != 8 && zHasMoreHosts && z2) {
            z = true;
        }
        return z;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:44:0x006d  */
    private synchronized boolean a(int... iArr) {
        Boolean bool;
        Boolean bool2;
        Boolean boolValueOf;
        bool = Boolean.TRUE;
        int i = this.f11950a;
        for (int i2 : iArr) {
            boolean z = true;
            switch (e.a(i2)) {
                case 0:
                    boolValueOf = null;
                    break;
                case 1:
                    if (i != 1) {
                        z = false;
                    }
                    boolValueOf = Boolean.valueOf(z);
                    break;
                case 2:
                case 6:
                    if (i == 2) {
                        boolValueOf = Boolean.TRUE;
                    } else if (i == 9) {
                        boolValueOf = Boolean.FALSE;
                    } else {
                        boolValueOf = null;
                    }
                    break;
                case 3:
                    if (i == 3 || i == 5 || i == 6) {
                        boolValueOf = Boolean.TRUE;
                    } else if (i == 9) {
                        boolValueOf = Boolean.FALSE;
                    } else {
                        boolValueOf = null;
                    }
                    break;
                case 4:
                case 5:
                    if (i == 4) {
                        boolValueOf = Boolean.TRUE;
                    } else if (i == 9) {
                        boolValueOf = Boolean.FALSE;
                    } else {
                        boolValueOf = null;
                    }
                    break;
                case 7:
                    if (i == 5 || i == 6 || i == 7 || i == 2 || i == 3 || i == 4) {
                        boolValueOf = Boolean.TRUE;
                    } else if (i == 9) {
                        boolValueOf = Boolean.FALSE;
                    } else {
                        boolValueOf = null;
                    }
                    break;
                case 8:
                    if (i == 1) {
                        boolValueOf = null;
                    } else {
                        if (i == 9) {
                            z = false;
                        }
                        boolValueOf = Boolean.valueOf(z);
                    }
                    break;
                default:
                    boolValueOf = Boolean.FALSE;
                    break;
            }
            if (!Boolean.TRUE.equals(boolValueOf)) {
                bool = boolValueOf;
                bool2 = Boolean.TRUE;
                bool2.equals(bool);
            }
        }
        bool2 = Boolean.TRUE;
        bool2.equals(bool);
        return bool2.equals(bool);
    }
}
