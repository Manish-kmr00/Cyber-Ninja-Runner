package com.smaato.sdk.core.remoteconfig.publisher;

import android.content.SharedPreferences;
import com.smaato.sdk.core.dns.DnsResolver;
import com.smaato.sdk.core.errorreport.ErrorReportFactory;
import com.smaato.sdk.core.errorreport.ErrorReporter;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.network.NetworkStateMonitor;
import com.smaato.sdk.core.simplehttp.SimpleHttpClient;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public class ConfigurationProvider {
    String configurationUrl;
    DnsResolver dnsResolver;
    ErrorReportFactory errorReportFactory;
    ErrorReporter errorReporter;
    Logger logger;
    NetworkStateMonitor networkStateMonitor;
    private final Map resourceCacheMap = new HashMap();
    String resourceKey;
    SharedPreferences sharedPreferences;
    SimpleHttpClient simpleHttpClient;

    public ConfigurationProvider(SharedPreferences sharedPreferences, DnsResolver dnsResolver, String str, SimpleHttpClient simpleHttpClient, NetworkStateMonitor networkStateMonitor, String str2, ErrorReportFactory errorReportFactory, ErrorReporter errorReporter, Logger logger) {
        this.sharedPreferences = sharedPreferences;
        this.dnsResolver = dnsResolver;
        this.resourceKey = str;
        this.simpleHttpClient = simpleHttpClient;
        this.networkStateMonitor = networkStateMonitor;
        this.configurationUrl = str2;
        this.errorReportFactory = errorReportFactory;
        this.errorReporter = errorReporter;
        this.logger = logger;
    }

    public void fetchConfiguration(String str) {
        ConfigurationResourceCache configurationResourceCache = new ConfigurationResourceCache(this.sharedPreferences, this.dnsResolver, String.format("%s.%s", this.resourceKey, str), this.simpleHttpClient, this.networkStateMonitor, str, this.configurationUrl, this.errorReportFactory, this.errorReporter, this.logger);
        this.resourceCacheMap.put(str, configurationResourceCache);
        configurationResourceCache.start();
    }

    public Configuration getConfiguration(String str) {
        ConfigurationResourceCache configurationResourceCache = (ConfigurationResourceCache) this.resourceCacheMap.get(str);
        if (configurationResourceCache == null) {
            this.logger.error(LogDomain.CORE, "Publisher Configuration request from uninitialized resource cache, returning default configuration", new Object[0]);
            return Configuration.create();
        }
        return configurationResourceCache.get();
    }
}
