package io.bidmachine.iab.mraid;

import android.net.Uri;

/* JADX INFO: loaded from: classes5.dex */
public final class MraidNativeFeatureUrlParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f12205a = new a();

    public MraidCalendarEvent parseCalendarEvent(Uri uri) {
        try {
            return this.f12205a.a(Uri.decode(uri.getQueryParameter("eventJson")));
        } catch (Exception e) {
            MraidLog.e("MraidNativeFeatureUrlParser", e);
            return null;
        }
    }

    public Uri parseStorePictureUri(Uri uri) {
        try {
            return Uri.parse(Uri.decode(uri.getQueryParameter("url")));
        } catch (Exception e) {
            MraidLog.e("MraidNativeFeatureUrlParser", e);
            return null;
        }
    }

    public MraidCalendarEvent parseCalendarEvent(String url) {
        try {
            return parseCalendarEvent(Uri.parse(url));
        } catch (Exception e) {
            MraidLog.e("MraidNativeFeatureUrlParser", e);
            return null;
        }
    }

    public Uri parseStorePictureUri(String url) {
        try {
            return parseStorePictureUri(Uri.parse(url));
        } catch (Exception e) {
            MraidLog.e("MraidNativeFeatureUrlParser", e);
            return null;
        }
    }
}
