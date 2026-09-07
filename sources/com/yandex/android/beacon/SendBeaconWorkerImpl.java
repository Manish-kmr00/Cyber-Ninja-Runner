package com.yandex.android.beacon;

import android.content.Context;
import android.net.Uri;
import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import com.adjust.sdk.Constants;
import com.facebook.appevents.UserDataStore;
import com.safedk.android.analytics.brandsafety.l;
import com.safedk.android.utils.j;
import com.yandex.android.net.CookieStorage;
import com.yandex.div.internal.Assert;
import com.yandex.div.internal.Log;
import com.yandex.div.internal.util.Clock;
import com.yandex.div.internal.util.SingleThreadExecutor;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.json.JSONObject;

/* JADX INFO: compiled from: SendBeaconWorkerImpl.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 .2\u00020\u0001:\u0005./012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J4\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#0\"2\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\fJ<\u0010'\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#0\"2\u0006\u0010(\u001a\u00020)2\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\fJ\u0010\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00060\u0013R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/yandex/android/beacon/SendBeaconWorkerImpl;", "Lcom/yandex/android/beacon/SendBeaconWorker;", "context", "Landroid/content/Context;", j.c, "Lcom/yandex/android/beacon/SendBeaconConfiguration;", "(Landroid/content/Context;Lcom/yandex/android/beacon/SendBeaconConfiguration;)V", "extraLogger", "Lcom/yandex/android/beacon/SendBeaconPerWorkerLogger;", "getExtraLogger", "()Lcom/yandex/android/beacon/SendBeaconPerWorkerLogger;", "hasMoreWork", "", "Ljava/lang/Boolean;", "hostCallback", "Lcom/yandex/android/beacon/SendBeaconWorkerScheduler;", "getHostCallback", "()Lcom/yandex/android/beacon/SendBeaconWorkerScheduler;", "implThread", "Lcom/yandex/android/beacon/SendBeaconWorkerImpl$ImplThread;", "requestExecutor", "Lcom/yandex/android/beacon/SendBeaconRequestExecutor;", "getRequestExecutor", "()Lcom/yandex/android/beacon/SendBeaconRequestExecutor;", "runningJob", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/yandex/android/beacon/SendBeaconWorkerImpl$RunningJob;", "workerThreadExecutor", "Lcom/yandex/android/beacon/SendBeaconWorkerImpl$WorkerThreadExecutor;", l.l, "", "url", "Landroid/net/Uri;", "headers", "", "", "payload", "Lorg/json/JSONObject;", "tryImmediately", "addNonPersistentUrl", "cookieStorage", "Lcom/yandex/android/net/CookieStorage;", "onStart", "callback", "Lcom/yandex/android/beacon/SendBeaconWorker$Callback;", "onStop", "Companion", "ImplThread", "RunningJob", "WorkerData", "WorkerThreadExecutor", "beacon_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SendBeaconWorkerImpl implements SendBeaconWorker {
    private static final String TAG = "SendBeaconWorker";
    private final SendBeaconConfiguration configuration;
    private final Context context;
    private volatile Boolean hasMoreWork;
    private final ImplThread implThread;
    private final AtomicReference<RunningJob> runningJob;
    private final WorkerThreadExecutor workerThreadExecutor;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final long URL_EXPIRE_PERIOD_MS = TimeUnit.DAYS.toMillis(1);

    public SendBeaconWorkerImpl(Context context, SendBeaconConfiguration configuration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.context = context;
        this.configuration = configuration;
        this.workerThreadExecutor = new WorkerThreadExecutor(configuration.getExecutor());
        this.implThread = new ImplThread();
        this.runningJob = new AtomicReference<>(null);
        Log.d(TAG, "SendBeaconWorker created");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SendBeaconRequestExecutor getRequestExecutor() {
        return this.configuration.getRequestExecutor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SendBeaconWorkerScheduler getHostCallback() {
        return this.configuration.getWorkerScheduler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SendBeaconPerWorkerLogger getExtraLogger() {
        return this.configuration.getPerWorkerLogger();
    }

    public final void add(final Uri url, final Map<String, String> headers, final JSONObject payload, final boolean tryImmediately) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Log.d(TAG, "Adding url " + url);
        this.workerThreadExecutor.post(new Runnable() { // from class: com.yandex.android.beacon.SendBeaconWorkerImpl$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                SendBeaconWorkerImpl.add$lambda$0(this.f$0, url, headers, payload, tryImmediately);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void add$lambda$0(SendBeaconWorkerImpl this$0, Uri url, Map headers, JSONObject jSONObject, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(url, "$url");
        Intrinsics.checkNotNullParameter(headers, "$headers");
        this$0.implThread.addUrl(url, headers, jSONObject, z);
    }

    public final void addNonPersistentUrl(final Uri url, final Map<String, String> headers, final CookieStorage cookieStorage, final JSONObject payload, final boolean tryImmediately) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(cookieStorage, "cookieStorage");
        Log.d(TAG, "Adding non persistent url " + url);
        this.workerThreadExecutor.post(new Runnable() { // from class: com.yandex.android.beacon.SendBeaconWorkerImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                SendBeaconWorkerImpl.addNonPersistentUrl$lambda$1(this.f$0, url, headers, cookieStorage, payload, tryImmediately);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addNonPersistentUrl$lambda$1(SendBeaconWorkerImpl this$0, Uri url, Map headers, CookieStorage cookieStorage, JSONObject jSONObject, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(url, "$url");
        Intrinsics.checkNotNullParameter(headers, "$headers");
        Intrinsics.checkNotNullParameter(cookieStorage, "$cookieStorage");
        this$0.implThread.addNonPersistentUrl(url, headers, cookieStorage, jSONObject, z);
    }

    @Override // com.yandex.android.beacon.SendBeaconWorker
    public boolean onStart(SendBeaconWorker.Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Log.d(TAG, "Starting job");
        if (Intrinsics.areEqual((Object) this.hasMoreWork, (Object) false)) {
            Log.d(TAG, "Starting job, return false");
            return false;
        }
        final RunningJob runningJob = new RunningJob(callback);
        Assert.assertNull(this.runningJob.getAndSet(runningJob));
        this.workerThreadExecutor.post(new Runnable() { // from class: com.yandex.android.beacon.SendBeaconWorkerImpl$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                SendBeaconWorkerImpl.onStart$lambda$2(this.f$0, runningJob);
            }
        });
        Log.d(TAG, "Starting job, return true");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onStart$lambda$2(SendBeaconWorkerImpl this$0, RunningJob newJob) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(newJob, "$newJob");
        this$0.implThread.executeJob(newJob);
    }

    @Override // com.yandex.android.beacon.SendBeaconWorker
    public boolean onStop() {
        Log.d(TAG, "Stopping job");
        this.runningJob.set(null);
        boolean z = !Intrinsics.areEqual((Object) this.hasMoreWork, (Object) false);
        Log.d(TAG, "Stopping job: " + z);
        return z;
    }

    /* JADX INFO: compiled from: SendBeaconWorkerImpl.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u00060\bj\u0002`\tH\u0014¨\u0006\n"}, d2 = {"Lcom/yandex/android/beacon/SendBeaconWorkerImpl$WorkerThreadExecutor;", "Lcom/yandex/div/internal/util/SingleThreadExecutor;", "executor", "Ljava/util/concurrent/Executor;", "(Ljava/util/concurrent/Executor;)V", "handleError", "", "e", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "beacon_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class WorkerThreadExecutor extends SingleThreadExecutor {
        @Override // com.yandex.div.internal.util.SingleThreadExecutor
        protected void handleError(RuntimeException e) {
            Intrinsics.checkNotNullParameter(e, "e");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WorkerThreadExecutor(Executor executor) {
            super(executor, "SendBeacon");
            Intrinsics.checkNotNullParameter(executor, "executor");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: SendBeaconWorkerImpl.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yandex/android/beacon/SendBeaconWorkerImpl$RunningJob;", "", "callback", "Lcom/yandex/android/beacon/SendBeaconWorker$Callback;", "(Lcom/yandex/android/beacon/SendBeaconWorker$Callback;)V", "sendFinishToCallback", "", "backingOff", "", "beacon_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    static final class RunningJob {
        private final SendBeaconWorker.Callback callback;

        public RunningJob(SendBeaconWorker.Callback callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.callback = callback;
        }

        public final void sendFinishToCallback(boolean backingOff) {
            this.callback.finish(backingOff);
        }
    }

    /* JADX INFO: compiled from: SendBeaconWorkerImpl.kt */
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0083\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\n\u0010\u0003\u001a\u00060\u0004R\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J<\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\f\u001a\u00020\rJ4\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\u000bH\u0002J\u0010\u0010\"\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u001f\u0010\u0003\u001a\u00060\u0004R\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006#"}, d2 = {"Lcom/yandex/android/beacon/SendBeaconWorkerImpl$ImplThread;", "", "(Lcom/yandex/android/beacon/SendBeaconWorkerImpl;)V", "workerData", "Lcom/yandex/android/beacon/SendBeaconWorkerImpl$WorkerData;", "Lcom/yandex/android/beacon/SendBeaconWorkerImpl;", "getWorkerData", "()Lcom/yandex/android/beacon/SendBeaconWorkerImpl$WorkerData;", "workerData$delegate", "Lkotlin/Lazy;", "addBeaconItem", "", "tryImmediately", "", "beaconData", "Lcom/yandex/android/beacon/BeaconItem;", "addNonPersistentUrl", "url", "Landroid/net/Uri;", "headers", "", "", "cookieStorage", "Lcom/yandex/android/net/CookieStorage;", "payload", "Lorg/json/JSONObject;", "addUrl", "executeJob", "job", "Lcom/yandex/android/beacon/SendBeaconWorkerImpl$RunningJob;", "is5xxHttpCode", "response", "Lcom/yandex/android/beacon/SendBeaconResponse;", "proceedJobImpl", "sendItem", "beacon_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private final class ImplThread {

        /* JADX INFO: renamed from: workerData$delegate, reason: from kotlin metadata */
        private final Lazy workerData;

        public ImplThread() {
            this.workerData = LazyKt.lazy(new Function0<WorkerData>() { // from class: com.yandex.android.beacon.SendBeaconWorkerImpl$ImplThread$workerData$2
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final SendBeaconWorkerImpl.WorkerData invoke() {
                    SendBeaconWorkerImpl sendBeaconWorkerImpl = sendBeaconWorkerImpl;
                    return new SendBeaconWorkerImpl.WorkerData(sendBeaconWorkerImpl, sendBeaconWorkerImpl.context, sendBeaconWorkerImpl.configuration.getDatabaseName());
                }
            });
        }

        private final WorkerData getWorkerData() {
            return (WorkerData) this.workerData.getValue();
        }

        public final void addUrl(Uri url, Map<String, String> headers, JSONObject payload, boolean tryImmediately) throws IOException {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(headers, "headers");
            addBeaconItem(tryImmediately, getWorkerData(), getWorkerData().push(url, headers, Clock.get().getCurrentTimeMs(), payload));
        }

        public final void addNonPersistentUrl(Uri url, Map<String, String> headers, CookieStorage cookieStorage, JSONObject payload, boolean tryImmediately) throws IOException {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(headers, "headers");
            Intrinsics.checkNotNullParameter(cookieStorage, "cookieStorage");
            addBeaconItem(tryImmediately, getWorkerData(), getWorkerData().pushNonPersistent(url, headers, Clock.get().getCurrentTimeMs(), cookieStorage, payload));
        }

        private final void addBeaconItem(boolean tryImmediately, WorkerData workerData, BeaconItem beaconData) throws IOException {
            if (!tryImmediately || !sendItem(beaconData)) {
                if (((RunningJob) SendBeaconWorkerImpl.this.runningJob.get()) == null) {
                    SendBeaconWorkerImpl.this.getHostCallback().schedule(SendBeaconWorkerImpl.this);
                    return;
                }
                return;
            }
            workerData.pop();
        }

        public final void executeJob(RunningJob job) {
            Intrinsics.checkNotNullParameter(job, "job");
            boolean z = true;
            try {
                proceedJobImpl();
            } finally {
                if (MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(SendBeaconWorkerImpl.this.runningJob, job, null)) {
                    if (Intrinsics.areEqual((Object) SendBeaconWorkerImpl.this.hasMoreWork, (Object) false)) {
                        Log.d(SendBeaconWorkerImpl.TAG, "Finishing job");
                        z = false;
                    } else {
                        Log.d(SendBeaconWorkerImpl.TAG, "Giving up in the end");
                    }
                    job.sendFinishToCallback(z);
                }
            }
        }

        private final void proceedJobImpl() {
            long currentTimeMs = Clock.get().getCurrentTimeMs();
            Iterator<BeaconItem> it = getWorkerData().iterator();
            while (it.hasNext()) {
                BeaconItem next = it.next();
                if (SendBeaconWorkerImpl.this.runningJob.get() == null) {
                    return;
                }
                if (next.getAddTimestamp() + SendBeaconWorkerImpl.URL_EXPIRE_PERIOD_MS < currentTimeMs) {
                    Log.w(SendBeaconWorkerImpl.TAG, "Drop outdated url: " + next.getUrl());
                    it.remove();
                } else {
                    Log.d(SendBeaconWorkerImpl.TAG, "Trying to send " + next.getUrl());
                    boolean zSendItem = sendItem(next);
                    Log.d(SendBeaconWorkerImpl.TAG, "Trying to send, result " + zSendItem);
                    if (zSendItem) {
                        it.remove();
                    }
                }
            }
        }

        private final boolean sendItem(BeaconItem beaconData) {
            SendBeaconRequest sendBeaconRequestFrom = SendBeaconRequest.INSTANCE.from(beaconData);
            Uri url = beaconData.getUrl();
            String string = sendBeaconRequestFrom.getUrl().toString();
            Intrinsics.checkNotNullExpressionValue(string, "request.url.toString()");
            SendBeaconWorkerImpl.this.getExtraLogger().onTrySendUrl(string);
            try {
                SendBeaconResponse sendBeaconResponseExecute = SendBeaconWorkerImpl.this.getRequestExecutor().execute(sendBeaconRequestFrom);
                if (sendBeaconResponseExecute.isValid()) {
                    SendBeaconWorkerImpl.this.getExtraLogger().onSuccessSendUrl(string);
                    Log.d(SendBeaconWorkerImpl.TAG, "Sent url ok " + url);
                } else {
                    if (!is5xxHttpCode(sendBeaconResponseExecute)) {
                        SendBeaconWorkerImpl.this.getExtraLogger().onFailedSendUrl(string, false);
                        Log.e(SendBeaconWorkerImpl.TAG, "Failed to send url " + url);
                        return false;
                    }
                    SendBeaconWorkerImpl.this.getExtraLogger().onFailedSendUrlDueServerError(string);
                    Log.e(SendBeaconWorkerImpl.TAG, "Failed to send url " + url + ", but treat as sent.");
                }
                return true;
            } catch (IOException e) {
                SendBeaconWorkerImpl.this.getExtraLogger().onFailedSendUrl(string, true);
                Log.e(SendBeaconWorkerImpl.TAG, "Failed to send url " + url, e);
                return false;
            }
        }

        private final boolean is5xxHttpCode(SendBeaconResponse response) {
            return response.getResponseCode() / 100 == 5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: SendBeaconWorkerImpl.kt */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0083\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0096\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ4\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J<\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\b\u0010\u001c\u001a\u00020\u000fH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/yandex/android/beacon/SendBeaconWorkerImpl$WorkerData;", "", "Lcom/yandex/android/beacon/BeaconItem;", "context", "Landroid/content/Context;", "databaseName", "", "(Lcom/yandex/android/beacon/SendBeaconWorkerImpl;Landroid/content/Context;Ljava/lang/String;)V", UserDataStore.DATE_OF_BIRTH, "Lcom/yandex/android/beacon/SendBeaconDb;", "itemCache", "Ljava/util/Deque;", "iterator", "", "pop", "", Constants.PUSH, "url", "Landroid/net/Uri;", "headers", "", "nowMs", "", "payload", "Lorg/json/JSONObject;", "pushNonPersistent", "cookieStorage", "Lcom/yandex/android/net/CookieStorage;", "updateHasMoreWork", "beacon_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    final class WorkerData implements Iterable<BeaconItem>, KMappedMarker {
        private final SendBeaconDb db;
        private final Deque<BeaconItem> itemCache;
        final /* synthetic */ SendBeaconWorkerImpl this$0;

        public WorkerData(SendBeaconWorkerImpl sendBeaconWorkerImpl, Context context, String databaseName) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(databaseName, "databaseName");
            this.this$0 = sendBeaconWorkerImpl;
            SendBeaconDb sendBeaconDbCreate = SendBeaconDb.factory.create(context, databaseName);
            this.db = sendBeaconDbCreate;
            ArrayDeque arrayDeque = new ArrayDeque(sendBeaconDbCreate.allItems());
            this.itemCache = arrayDeque;
            Log.e(SendBeaconWorkerImpl.TAG, "Reading from database, items count: " + arrayDeque.size());
            updateHasMoreWork();
        }

        public final BeaconItem push(Uri url, Map<String, String> headers, long nowMs, JSONObject payload) throws IOException {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(headers, "headers");
            BeaconItem.Persistent persistentAdd = this.db.add(url, headers, nowMs, payload);
            this.itemCache.push(persistentAdd);
            updateHasMoreWork();
            return persistentAdd;
        }

        public final BeaconItem pushNonPersistent(Uri url, Map<String, String> headers, long nowMs, CookieStorage cookieStorage, JSONObject payload) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(headers, "headers");
            Intrinsics.checkNotNullParameter(cookieStorage, "cookieStorage");
            BeaconItem.NonPersistent nonPersistent = new BeaconItem.NonPersistent(url, headers, payload, nowMs, cookieStorage);
            this.itemCache.push(nonPersistent);
            updateHasMoreWork();
            return nonPersistent;
        }

        public final void pop() throws IOException {
            this.db.remove(this.itemCache.pop().asPersistent());
            updateHasMoreWork();
        }

        @Override // java.lang.Iterable
        public Iterator<BeaconItem> iterator() {
            Iterator<BeaconItem> it = this.itemCache.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "itemCache.iterator()");
            return new SendBeaconWorkerImpl$WorkerData$iterator$1(it, this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void updateHasMoreWork() {
            this.this$0.hasMoreWork = Boolean.valueOf(!this.itemCache.isEmpty());
        }
    }

    /* JADX INFO: compiled from: SendBeaconWorkerImpl.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u00020\u00068\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002¨\u0006\b"}, d2 = {"Lcom/yandex/android/beacon/SendBeaconWorkerImpl$Companion;", "", "()V", "TAG", "", "URL_EXPIRE_PERIOD_MS", "", "getURL_EXPIRE_PERIOD_MS$beacon_release$annotations", "beacon_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getURL_EXPIRE_PERIOD_MS$beacon_release$annotations() {
        }

        private Companion() {
        }
    }
}
