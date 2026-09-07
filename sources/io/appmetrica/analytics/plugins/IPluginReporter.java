package io.appmetrica.analytics.plugins;

/* JADX INFO: loaded from: classes6.dex */
public interface IPluginReporter {
    void reportError(PluginErrorDetails pluginErrorDetails, String str);

    void reportError(String str, String str2, PluginErrorDetails pluginErrorDetails);

    void reportUnhandledException(PluginErrorDetails pluginErrorDetails);
}
