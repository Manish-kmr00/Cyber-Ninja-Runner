package com.smaato.sdk.richmedia.util;

import android.content.Context;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.richmedia.mraid.dataprovider.MraidEnvironmentProperties;

/* JADX INFO: loaded from: classes9.dex */
public final class RichMediaHtmlUtils {
    private final boolean loggingEnabled;

    public RichMediaHtmlUtils(Boolean bool) {
        this.loggingEnabled = ((Boolean) Objects.requireNonNull(bool)).booleanValue();
    }

    public String createHtml(String str, Context context, MraidEnvironmentProperties mraidEnvironmentProperties) {
        Objects.requireNonNull(str);
        Objects.requireNonNull(context);
        Objects.requireNonNull(mraidEnvironmentProperties);
        return "<!DOCTYPE html><html style='margin: 0px; padding: 0px; width: 100%; height: 100%;'><head><meta name='viewport' content='initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no'/><style>body {margin: 0px; min-height: 100%%; position: relative; padding: 0px; width: 100%%; height: 100%%;}</style><script src=\"file:///android_asset/mraid.js\"></script><script>" + getMraidEnvironmentDetails(mraidEnvironmentProperties) + "</script></head><body><script src=\"file:///android_asset/omsdk-v1.js\"></script>" + str.replaceAll("mraid.js", "file:///android_asset/mraid.js") + "</body></html>";
    }

    private String getMraidEnvironmentDetails(MraidEnvironmentProperties mraidEnvironmentProperties) {
        final StringBuilder sb = new StringBuilder();
        sb.append("window.MRAID_ENV = {\n");
        sb.append(String.format("version:'%s',\n", MraidEnvironmentProperties.VERSION));
        sb.append(String.format("sdk: '%s',\n", MraidEnvironmentProperties.SDK));
        sb.append(String.format("sdkVersion: '%s',\n", mraidEnvironmentProperties.sdkVersion));
        sb.append(String.format("appId: '%s',\n", mraidEnvironmentProperties.appId));
        Objects.onNotNull(mraidEnvironmentProperties.googleAdId, new Consumer() { // from class: com.smaato.sdk.richmedia.util.RichMediaHtmlUtils$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                sb.append(String.format("ifa: '%s',\n", (String) obj));
            }
        });
        Objects.onNotNull(mraidEnvironmentProperties.googleDnt, new Consumer() { // from class: com.smaato.sdk.richmedia.util.RichMediaHtmlUtils$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                sb.append(String.format("limitAdTracking: %b,\n", (Boolean) obj));
            }
        });
        Objects.onNotNull(mraidEnvironmentProperties.coppa, new Consumer() { // from class: com.smaato.sdk.richmedia.util.RichMediaHtmlUtils$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                sb.append(String.format("coppa: %b,\n", Boolean.valueOf(((Integer) obj).intValue() == 1)));
            }
        });
        sb.append("};");
        return sb.toString();
    }

    public boolean isLoggingEnabled() {
        return this.loggingEnabled;
    }
}
