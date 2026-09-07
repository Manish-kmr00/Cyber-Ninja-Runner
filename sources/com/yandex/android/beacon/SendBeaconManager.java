package com.yandex.android.beacon;

import android.content.Context;
import android.net.Uri;
import com.safedk.android.utils.j;
import com.yandex.android.net.CookieStorage;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: SendBeaconManager.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010J2\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u00132\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/yandex/android/beacon/SendBeaconManager;", "", "context", "Landroid/content/Context;", j.c, "Lcom/yandex/android/beacon/SendBeaconConfiguration;", "(Landroid/content/Context;Lcom/yandex/android/beacon/SendBeaconConfiguration;)V", "sendBeaconWorker", "Lcom/yandex/android/beacon/SendBeaconWorkerImpl;", "addNonPersistentUrl", "", "url", "Landroid/net/Uri;", "cookieStorage", "Lcom/yandex/android/net/CookieStorage;", "payload", "Lorg/json/JSONObject;", "addUrl", "headers", "", "", "onStart", "", "callback", "Lcom/yandex/android/beacon/SendBeaconWorker$Callback;", "onStop", "Companion", "beacon_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SendBeaconManager {
    private static final Companion Companion = new Companion(null);
    private static final boolean TRY_IMMEDIATELY = true;
    private final SendBeaconWorkerImpl sendBeaconWorker;

    public final void addUrl(Uri url) {
        Intrinsics.checkNotNullParameter(url, "url");
        addUrl$default(this, url, null, null, 6, null);
    }

    public final void addUrl(Uri url, Map<String, String> headers) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        addUrl$default(this, url, headers, null, 4, null);
    }

    public SendBeaconManager(Context context, SendBeaconConfiguration configuration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.sendBeaconWorker = new SendBeaconWorkerImpl(context, configuration);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void addUrl$default(SendBeaconManager sendBeaconManager, Uri uri, Map map, JSONObject jSONObject, int i, Object obj) {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        if ((i & 4) != 0) {
            jSONObject = null;
        }
        sendBeaconManager.addUrl(uri, map, jSONObject);
    }

    public final void addUrl(Uri url, Map<String, String> headers, JSONObject payload) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.sendBeaconWorker.add(url, headers, payload, true);
    }

    public static /* synthetic */ void addNonPersistentUrl$default(SendBeaconManager sendBeaconManager, Uri uri, CookieStorage cookieStorage, JSONObject jSONObject, int i, Object obj) {
        if ((i & 4) != 0) {
            jSONObject = null;
        }
        sendBeaconManager.addNonPersistentUrl(uri, cookieStorage, jSONObject);
    }

    public final void addNonPersistentUrl(Uri url, CookieStorage cookieStorage, JSONObject payload) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(cookieStorage, "cookieStorage");
        this.sendBeaconWorker.addNonPersistentUrl(url, MapsKt.emptyMap(), cookieStorage, payload, true);
    }

    public final boolean onStart(SendBeaconWorker.Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        return this.sendBeaconWorker.onStart(callback);
    }

    public final boolean onStop() {
        return this.sendBeaconWorker.onStop();
    }

    /* JADX INFO: compiled from: SendBeaconManager.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/yandex/android/beacon/SendBeaconManager$Companion;", "", "()V", "TRY_IMMEDIATELY", "", "beacon_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
