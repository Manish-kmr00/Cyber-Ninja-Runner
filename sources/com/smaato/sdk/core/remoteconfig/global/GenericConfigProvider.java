package com.smaato.sdk.core.remoteconfig.global;

import android.content.SharedPreferences;
import com.smaato.sdk.core.dns.DnsResolver;
import com.smaato.sdk.core.errorreport.ErrorReportFactory;
import com.smaato.sdk.core.errorreport.ErrorReporter;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.network.NetworkStateMonitor;
import com.smaato.sdk.core.simplehttp.SimpleHttpClient;

/* JADX INFO: loaded from: classes12.dex */
public class GenericConfigProvider {
    String configurationUrl;
    DnsResolver dnsResolver;
    ErrorReportFactory errorReportFactory;
    ErrorReporter errorReporter;
    Logger logger;
    NetworkStateMonitor networkStateMonitor;
    private GenericConfigResourceCache resourceCache;
    String resourceKey;
    SharedPreferences sharedPreferences;
    SimpleHttpClient simpleHttpClient;

    public GenericConfigProvider(SharedPreferences sharedPreferences, DnsResolver dnsResolver, String str, SimpleHttpClient simpleHttpClient, Logger logger) {
        this.sharedPreferences = sharedPreferences;
        this.dnsResolver = dnsResolver;
        this.resourceKey = str;
        this.simpleHttpClient = simpleHttpClient;
        this.logger = logger;
    }

    public void fetchConfiguration() {
        GenericConfigResourceCache genericConfigResourceCache = new GenericConfigResourceCache(this.sharedPreferences, this.dnsResolver, "1", this.logger, this.simpleHttpClient);
        this.resourceCache = genericConfigResourceCache;
        genericConfigResourceCache.start();
    }

    public GenericConfig getConfiguration() {
        GenericConfigResourceCache genericConfigResourceCache = this.resourceCache;
        if (genericConfigResourceCache == null) {
            this.logger.error(LogDomain.CORE, "Publisher Configuration request from uninitialized resource cache, returning default configuration", new Object[0]);
            return GenericConfig.create();
        }
        return genericConfigResourceCache.get();
    }
}
