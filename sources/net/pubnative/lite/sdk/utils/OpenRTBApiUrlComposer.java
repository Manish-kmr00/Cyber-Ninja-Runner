package net.pubnative.lite.sdk.utils;

import android.net.Uri;
import android.text.TextUtils;
import net.pubnative.lite.sdk.models.request.OpenRTBAdRequest;

/* JADX INFO: loaded from: classes13.dex */
public final class OpenRTBApiUrlComposer {
    public static String buildUrl(String str, OpenRTBAdRequest openRTBAdRequest) {
        Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        builderBuildUpon.appendPath("bid");
        builderBuildUpon.appendPath("v1");
        builderBuildUpon.appendPath("request");
        if (!TextUtils.isEmpty(openRTBAdRequest.appToken)) {
            builderBuildUpon.appendQueryParameter("apptoken", openRTBAdRequest.appToken);
        }
        if (!TextUtils.isEmpty(openRTBAdRequest.zoneId)) {
            builderBuildUpon.appendQueryParameter("zoneid", openRTBAdRequest.zoneId);
        }
        return builderBuildUpon.build().toString();
    }
}
