package io.bidmachine.iab.bridge;

import io.bidmachine.iab.mraid.MraidJsValidator;
import io.bidmachine.iab.mraid.MraidWebView;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public interface JsBridge {
    String getJs();

    MraidJsValidator getJsValidator();

    boolean isHandled(String url);

    void runJsCommand(MraidWebView mraidWebView, String command, Map<String, String> commandMap);
}
