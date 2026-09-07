package com.yandex.android.net;

import android.net.Uri;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CookieStorage.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u000bJ\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Lcom/yandex/android/net/CookieStorage;", "", "getCookies", "", "uri", "Landroid/net/Uri;", "processCookies", "", "cookieValues", "", "url", "NoOp", "beacon_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface CookieStorage {
    String getCookies(Uri uri);

    void processCookies(List<String> cookieValues, String url);

    /* JADX INFO: compiled from: CookieStorage.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¨\u0006\f"}, d2 = {"Lcom/yandex/android/net/CookieStorage$NoOp;", "Lcom/yandex/android/net/CookieStorage;", "()V", "getCookies", "", "uri", "Landroid/net/Uri;", "processCookies", "", "cookieValues", "", "url", "beacon_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class NoOp implements CookieStorage {
        public static final NoOp INSTANCE = new NoOp();

        @Override // com.yandex.android.net.CookieStorage
        public String getCookies(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            return null;
        }

        @Override // com.yandex.android.net.CookieStorage
        public void processCookies(List<String> cookieValues, String url) {
            Intrinsics.checkNotNullParameter(url, "url");
        }

        private NoOp() {
        }
    }
}
