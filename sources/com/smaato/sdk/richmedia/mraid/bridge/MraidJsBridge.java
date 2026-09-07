package com.smaato.sdk.richmedia.mraid.bridge;

import android.net.Uri;
import android.webkit.WebView;
import com.safedk.android.internal.partials.SmaatoNetworkBridge;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.TextUtils;
import com.smaato.sdk.core.util.collections.Maps;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.richmedia.mraid.MraidUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class MraidJsBridge {
    private final Map handlers = Collections.synchronizedMap(new HashMap());
    private final Logger logger;
    private final WebView webView;

    public MraidJsBridge(WebView webView, Logger logger) {
        this.webView = (WebView) Objects.requireNonNull(webView);
        this.logger = (Logger) Objects.requireNonNull(logger);
    }

    public void handleMraidUrl(String str, final boolean z) {
        final Uri uri = Uri.parse(str);
        Objects.onNotNull(uri.getHost(), new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.bridge.MraidJsBridge$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5651x75b26a04(uri, z, (String) obj);
            }
        });
        fireNativeCallCompleteEvent();
    }

    /* JADX INFO: renamed from: lambda$handleMraidUrl$0$com-smaato-sdk-richmedia-mraid-bridge-MraidJsBridge, reason: not valid java name */
    /* synthetic */ void m5651x75b26a04(Uri uri, boolean z, String str) {
        handleCommand(str, getQueryParamMap(uri), z);
    }

    private Map getQueryParamMap(Uri uri) {
        HashMap map = new HashMap();
        for (String str : uri.getQueryParameterNames()) {
            String queryParameter = uri.getQueryParameter(str);
            if (queryParameter != null) {
                map.put(str, queryParameter);
            }
        }
        return Maps.toImmutableMap(map);
    }

    private void handleCommand(String str, Map map, boolean z) {
        MraidCommandHandler mraidCommandHandler = (MraidCommandHandler) this.handlers.get(str);
        if (mraidCommandHandler == null) {
            this.logger.debug(LogDomain.MRAID, "A handler for command \"" + str + "\" is not registered", new Object[0]);
        } else {
            mraidCommandHandler.handle(map, z);
        }
    }

    public void fireReadyEvent() {
        runScript("window.mraidbridge.fireReadyEvent();");
    }

    private void fireNativeCallCompleteEvent() {
        runScript("window.mraidbridge.nativeCallComplete();");
    }

    void addCommandHandler(String str, MraidCommandHandler mraidCommandHandler) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.handlers.put(str, mraidCommandHandler);
    }

    void runScript(String str) {
        this.logger.info(LogDomain.MRAID, "Running script: " + str, new Object[0]);
        SmaatoNetworkBridge.webviewLoadUrl(this.webView, MraidUtils.format("javascript:%s", str));
    }
}
