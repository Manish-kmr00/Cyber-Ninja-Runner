package com.yandex.android.beacon;

import com.yandex.div.internal.KLog;
import com.yandex.div.logging.Severity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SendBeaconPerWorkerLogger.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\bf\u0018\u0000 \u000b2\u00020\u0001:\u0003\u000b\f\rJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Lcom/yandex/android/beacon/SendBeaconPerWorkerLogger;", "", "onFailedSendUrl", "", "url", "", "exceptionCaught", "", "onFailedSendUrlDueServerError", "onSuccessSendUrl", "onTrySendUrl", "Companion", "Logcat", "NoOp", "beacon_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface SendBeaconPerWorkerLogger {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final /* synthetic */ Companion INSTANCE = Companion.$$INSTANCE;

    void onFailedSendUrl(String url, boolean exceptionCaught);

    void onFailedSendUrlDueServerError(String url);

    void onSuccessSendUrl(String url);

    void onTrySendUrl(String url);

    /* JADX INFO: compiled from: SendBeaconPerWorkerLogger.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\f"}, d2 = {"Lcom/yandex/android/beacon/SendBeaconPerWorkerLogger$NoOp;", "Lcom/yandex/android/beacon/SendBeaconPerWorkerLogger;", "()V", "onFailedSendUrl", "", "url", "", "exceptionCaught", "", "onFailedSendUrlDueServerError", "onSuccessSendUrl", "onTrySendUrl", "beacon_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class NoOp implements SendBeaconPerWorkerLogger {
        public static final NoOp INSTANCE = new NoOp();

        @Override // com.yandex.android.beacon.SendBeaconPerWorkerLogger
        public void onFailedSendUrl(String url, boolean exceptionCaught) {
            Intrinsics.checkNotNullParameter(url, "url");
        }

        @Override // com.yandex.android.beacon.SendBeaconPerWorkerLogger
        public void onFailedSendUrlDueServerError(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
        }

        @Override // com.yandex.android.beacon.SendBeaconPerWorkerLogger
        public void onSuccessSendUrl(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
        }

        @Override // com.yandex.android.beacon.SendBeaconPerWorkerLogger
        public void onTrySendUrl(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
        }

        private NoOp() {
        }
    }

    /* JADX INFO: compiled from: SendBeaconPerWorkerLogger.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\f"}, d2 = {"Lcom/yandex/android/beacon/SendBeaconPerWorkerLogger$Logcat;", "Lcom/yandex/android/beacon/SendBeaconPerWorkerLogger;", "()V", "onFailedSendUrl", "", "url", "", "exceptionCaught", "", "onFailedSendUrlDueServerError", "onSuccessSendUrl", "onTrySendUrl", "beacon_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Logcat implements SendBeaconPerWorkerLogger {
        public static final Logcat INSTANCE = new Logcat();

        private Logcat() {
        }

        @Override // com.yandex.android.beacon.SendBeaconPerWorkerLogger
        public void onTrySendUrl(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            KLog kLog = KLog.INSTANCE;
            if (kLog.isAtLeast(Severity.INFO)) {
                kLog.print(4, "SendBeaconPerWorkerLogger", "onTrySendUrl: " + url);
            }
        }

        @Override // com.yandex.android.beacon.SendBeaconPerWorkerLogger
        public void onSuccessSendUrl(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            KLog kLog = KLog.INSTANCE;
            if (kLog.isAtLeast(Severity.INFO)) {
                kLog.print(4, "SendBeaconPerWorkerLogger", "onSuccessSendUrl: " + url);
            }
        }

        @Override // com.yandex.android.beacon.SendBeaconPerWorkerLogger
        public void onFailedSendUrl(String url, boolean exceptionCaught) {
            Intrinsics.checkNotNullParameter(url, "url");
            KLog kLog = KLog.INSTANCE;
            if (kLog.isAtLeast(Severity.INFO)) {
                kLog.print(4, "SendBeaconPerWorkerLogger", "onFailedSendUrl: " + url);
            }
        }

        @Override // com.yandex.android.beacon.SendBeaconPerWorkerLogger
        public void onFailedSendUrlDueServerError(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            KLog kLog = KLog.INSTANCE;
            if (kLog.isAtLeast(Severity.INFO)) {
                kLog.print(4, "SendBeaconPerWorkerLogger", "onFailedSendUrlDueServerError: " + url);
            }
        }
    }

    /* JADX INFO: compiled from: SendBeaconPerWorkerLogger.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/yandex/android/beacon/SendBeaconPerWorkerLogger$Companion;", "", "()V", "TAG", "", "beacon_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final String TAG = "SendBeaconPerWorkerLogger";

        private Companion() {
        }
    }
}
