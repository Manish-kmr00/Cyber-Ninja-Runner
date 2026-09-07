package com.smaato.sdk.core.webview;

import com.smaato.sdk.core.di.ClassFactory;
import com.smaato.sdk.core.di.DiConstructor;
import com.smaato.sdk.core.di.DiRegistry;
import com.smaato.sdk.core.util.fi.Consumer;

/* JADX INFO: loaded from: classes14.dex */
public final class DiWebViewLayer {
    public static DiRegistry createRegistry() {
        return DiRegistry.of(new Consumer() { // from class: com.smaato.sdk.core.webview.DiWebViewLayer$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                DiWebViewLayer.lambda$createRegistry$2((DiRegistry) obj);
            }
        });
    }

    static /* synthetic */ void lambda$createRegistry$2(DiRegistry diRegistry) {
        diRegistry.registerFactory(BaseWebViewClient.class, new ClassFactory() { // from class: com.smaato.sdk.core.webview.DiWebViewLayer$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiWebViewLayer.lambda$createRegistry$0(diConstructor);
            }
        });
        diRegistry.registerFactory(BaseWebChromeClient.class, new ClassFactory() { // from class: com.smaato.sdk.core.webview.DiWebViewLayer$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiWebViewLayer.lambda$createRegistry$1(diConstructor);
            }
        });
    }

    static /* synthetic */ BaseWebViewClient lambda$createRegistry$0(DiConstructor diConstructor) {
        return new BaseWebViewClient();
    }

    static /* synthetic */ BaseWebChromeClient lambda$createRegistry$1(DiConstructor diConstructor) {
        return new BaseWebChromeClient();
    }

    public static BaseWebViewClient getBaseWebViewClientFrom(DiConstructor diConstructor) {
        return (BaseWebViewClient) diConstructor.get(BaseWebViewClient.class);
    }

    public static BaseWebChromeClient getBaseWebChromeClientFrom(DiConstructor diConstructor) {
        return (BaseWebChromeClient) diConstructor.get(BaseWebChromeClient.class);
    }
}
