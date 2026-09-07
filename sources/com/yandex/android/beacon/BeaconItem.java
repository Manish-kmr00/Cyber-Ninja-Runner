package com.yandex.android.beacon;

import android.net.Uri;
import com.yandex.android.net.CookieStorage;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: BeaconItem.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0002\u001b\u001cB5\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H&J\b\u0010\u001a\u001a\u00020\u0006H\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/yandex/android/beacon/BeaconItem;", "", "url", "Landroid/net/Uri;", "headers", "", "", "payload", "Lorg/json/JSONObject;", "addTimestamp", "", "(Landroid/net/Uri;Ljava/util/Map;Lorg/json/JSONObject;J)V", "getAddTimestamp", "()J", "cookieStorage", "Lcom/yandex/android/net/CookieStorage;", "getCookieStorage", "()Lcom/yandex/android/net/CookieStorage;", "getHeaders", "()Ljava/util/Map;", "getPayload", "()Lorg/json/JSONObject;", "getUrl", "()Landroid/net/Uri;", "asPersistent", "Lcom/yandex/android/beacon/BeaconItem$Persistent;", "toString", "NonPersistent", "Persistent", "beacon_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class BeaconItem {
    private final long addTimestamp;
    private final Map<String, String> headers;
    private final JSONObject payload;
    private final Uri url;

    public abstract Persistent asPersistent();

    public abstract CookieStorage getCookieStorage();

    public BeaconItem(Uri url, Map<String, String> headers, JSONObject jSONObject, long j) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.url = url;
        this.headers = headers;
        this.payload = jSONObject;
        this.addTimestamp = j;
    }

    public final Uri getUrl() {
        return this.url;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final JSONObject getPayload() {
        return this.payload;
    }

    public final long getAddTimestamp() {
        return this.addTimestamp;
    }

    public String toString() {
        return "BeaconItem{url=" + this.url + ", headers=" + this.headers + ", addTimestamp=" + this.addTimestamp;
    }

    /* JADX INFO: compiled from: BeaconItem.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/yandex/android/beacon/BeaconItem$NonPersistent;", "Lcom/yandex/android/beacon/BeaconItem;", "url", "Landroid/net/Uri;", "headers", "", "", "payload", "Lorg/json/JSONObject;", "addTimestamp", "", "cookieStorage", "Lcom/yandex/android/net/CookieStorage;", "(Landroid/net/Uri;Ljava/util/Map;Lorg/json/JSONObject;JLcom/yandex/android/net/CookieStorage;)V", "getCookieStorage", "()Lcom/yandex/android/net/CookieStorage;", "asPersistent", "Lcom/yandex/android/beacon/BeaconItem$Persistent;", "beacon_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class NonPersistent extends BeaconItem {
        private final CookieStorage cookieStorage;

        @Override // com.yandex.android.beacon.BeaconItem
        public Persistent asPersistent() {
            return null;
        }

        @Override // com.yandex.android.beacon.BeaconItem
        public CookieStorage getCookieStorage() {
            return this.cookieStorage;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NonPersistent(Uri url, Map<String, String> headers, JSONObject jSONObject, long j, CookieStorage cookieStorage) {
            super(url, headers, jSONObject, j);
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(headers, "headers");
            Intrinsics.checkNotNullParameter(cookieStorage, "cookieStorage");
            this.cookieStorage = cookieStorage;
        }
    }

    /* JADX INFO: compiled from: BeaconItem.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0002\u0010\fJ\b\u0010\u0013\u001a\u00020\u0000H\u0016R\u0016\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/yandex/android/beacon/BeaconItem$Persistent;", "Lcom/yandex/android/beacon/BeaconItem;", "url", "Landroid/net/Uri;", "headers", "", "", "payload", "Lorg/json/JSONObject;", "addTimestamp", "", "rowId", "(Landroid/net/Uri;Ljava/util/Map;Lorg/json/JSONObject;JJ)V", "cookieStorage", "Lcom/yandex/android/net/CookieStorage;", "getCookieStorage", "()Lcom/yandex/android/net/CookieStorage;", "getRowId", "()J", "asPersistent", "beacon_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Persistent extends BeaconItem {
        private final CookieStorage cookieStorage;
        private final long rowId;

        @Override // com.yandex.android.beacon.BeaconItem
        public Persistent asPersistent() {
            return this;
        }

        public final long getRowId() {
            return this.rowId;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Persistent(Uri url, Map<String, String> headers, JSONObject jSONObject, long j, long j2) {
            super(url, headers, jSONObject, j);
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(headers, "headers");
            this.rowId = j2;
        }

        @Override // com.yandex.android.beacon.BeaconItem
        public CookieStorage getCookieStorage() {
            return this.cookieStorage;
        }
    }
}
