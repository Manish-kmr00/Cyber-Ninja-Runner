package io.appmetrica.analytics.plugins;

/* JADX INFO: loaded from: classes11.dex */
public interface AppMetricaPlugins {
    void reportError(PluginErrorDetails pluginErrorDetails, String str);

    void reportError(String str, String str2, PluginErrorDetails pluginErrorDetails);

    void reportUnhandledException(PluginErrorDetails pluginErrorDetails);
}
