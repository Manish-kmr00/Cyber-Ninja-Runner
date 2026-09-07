package io.bidmachine.iab.mraid;

import android.net.Uri;

/* JADX INFO: loaded from: classes11.dex */
final class b {
    b() {
    }

    String a(String str) {
        try {
            return new Uri.Builder().scheme("calendar").authority("mraid").appendQueryParameter("eventJson", str).build().toString();
        } catch (Exception e) {
            MraidLog.e("MraidNativeFeatureUrlFactory", e);
            return null;
        }
    }

    String b(String str) {
        try {
            return new Uri.Builder().scheme("storePicture").authority("mraid").appendQueryParameter("url", str).build().toString();
        } catch (Exception e) {
            MraidLog.e("MraidNativeFeatureUrlFactory", e);
            return null;
        }
    }
}
