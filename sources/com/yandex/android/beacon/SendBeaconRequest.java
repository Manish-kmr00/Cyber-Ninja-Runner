package com.yandex.android.beacon;

import android.net.Uri;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.yandex.android.net.CookieStorage;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: SendBeaconRequest.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\nHÆ\u0003JA\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/yandex/android/beacon/SendBeaconRequest;", "", "url", "Landroid/net/Uri;", "headers", "", "", "payload", "Lorg/json/JSONObject;", "cookieStorage", "Lcom/yandex/android/net/CookieStorage;", "(Landroid/net/Uri;Ljava/util/Map;Lorg/json/JSONObject;Lcom/yandex/android/net/CookieStorage;)V", "getCookieStorage", "()Lcom/yandex/android/net/CookieStorage;", "getHeaders", "()Ljava/util/Map;", "getPayload", "()Lorg/json/JSONObject;", "getUrl", "()Landroid/net/Uri;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "beacon_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final /* data */ class SendBeaconRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final CookieStorage cookieStorage;
    private final Map<String, String> headers;
    private final JSONObject payload;
    private final Uri url;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SendBeaconRequest copy$default(SendBeaconRequest sendBeaconRequest, Uri uri, Map map, JSONObject jSONObject, CookieStorage cookieStorage, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = sendBeaconRequest.url;
        }
        if ((i & 2) != 0) {
            map = sendBeaconRequest.headers;
        }
        if ((i & 4) != 0) {
            jSONObject = sendBeaconRequest.payload;
        }
        if ((i & 8) != 0) {
            cookieStorage = sendBeaconRequest.cookieStorage;
        }
        return sendBeaconRequest.copy(uri, map, jSONObject, cookieStorage);
    }

    @JvmStatic
    public static final SendBeaconRequest from(BeaconItem beaconItem) {
        return INSTANCE.from(beaconItem);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Uri getUrl() {
        return this.url;
    }

    public final Map<String, String> component2() {
        return this.headers;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final JSONObject getPayload() {
        return this.payload;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final CookieStorage getCookieStorage() {
        return this.cookieStorage;
    }

    public final SendBeaconRequest copy(Uri url, Map<String, String> headers, JSONObject payload, CookieStorage cookieStorage) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        return new SendBeaconRequest(url, headers, payload, cookieStorage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SendBeaconRequest)) {
            return false;
        }
        SendBeaconRequest sendBeaconRequest = (SendBeaconRequest) other;
        return Intrinsics.areEqual(this.url, sendBeaconRequest.url) && Intrinsics.areEqual(this.headers, sendBeaconRequest.headers) && Intrinsics.areEqual(this.payload, sendBeaconRequest.payload) && Intrinsics.areEqual(this.cookieStorage, sendBeaconRequest.cookieStorage);
    }

    public int hashCode() {
        int iHashCode = ((this.url.hashCode() * 31) + this.headers.hashCode()) * 31;
        JSONObject jSONObject = this.payload;
        int iHashCode2 = (iHashCode + (jSONObject == null ? 0 : jSONObject.hashCode())) * 31;
        CookieStorage cookieStorage = this.cookieStorage;
        return iHashCode2 + (cookieStorage != null ? cookieStorage.hashCode() : 0);
    }

    public String toString() {
        return "SendBeaconRequest(url=" + this.url + ", headers=" + this.headers + ", payload=" + this.payload + ", cookieStorage=" + this.cookieStorage + ')';
    }

    public SendBeaconRequest(Uri url, Map<String, String> headers, JSONObject jSONObject, CookieStorage cookieStorage) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.url = url;
        this.headers = headers;
        this.payload = jSONObject;
        this.cookieStorage = cookieStorage;
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

    public final CookieStorage getCookieStorage() {
        return this.cookieStorage;
    }

    /* JADX INFO: compiled from: SendBeaconRequest.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/yandex/android/beacon/SendBeaconRequest$Companion;", "", "()V", TypedValues.TransitionType.S_FROM, "Lcom/yandex/android/beacon/SendBeaconRequest;", "beaconItem", "Lcom/yandex/android/beacon/BeaconItem;", "beacon_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SendBeaconRequest from(BeaconItem beaconItem) {
            Intrinsics.checkNotNullParameter(beaconItem, "beaconItem");
            return new SendBeaconRequest(beaconItem.getUrl(), beaconItem.getHeaders(), beaconItem.getPayload(), beaconItem.getCookieStorage());
        }
    }
}
