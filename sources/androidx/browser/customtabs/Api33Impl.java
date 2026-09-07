package androidx.browser.customtabs;

import android.os.Bundle;

/* JADX INFO: loaded from: classes13.dex */
class Api33Impl {
    private Api33Impl() {
    }

    static <T> T getParcelable(Bundle bundle, String str, Class<T> cls) {
        return (T) bundle.getParcelable(str, cls);
    }
}
