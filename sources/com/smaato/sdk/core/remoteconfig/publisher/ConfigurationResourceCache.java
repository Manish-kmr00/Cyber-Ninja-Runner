package com.smaato.sdk.core.remoteconfig.publisher;

import android.content.SharedPreferences;
import com.smaato.sdk.core.BuildConfig;
import com.smaato.sdk.core.dns.DnsResolver;
import com.smaato.sdk.core.dnsbasedresource.ExpirationBasedDnsResourceCache;
import com.smaato.sdk.core.errorreport.ErrorReportFactory;
import com.smaato.sdk.core.errorreport.ErrorReporter;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.network.NetworkStateMonitor;
import com.smaato.sdk.core.simplehttp.SimpleHttpClient;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class ConfigurationResourceCache extends ExpirationBasedDnsResourceCache<Configuration> {
    private static final String DNS_QUERY_URL_FORMATTER = "%s." + BuildConfig.PUBLISHER_CONFIGURATION_DNS_URL;
    private final String configurationUrl;
    private final ErrorReportFactory errorReportFactory;
    private final ErrorReporter errorReporter;
    private final Logger logger;

    protected ConfigurationResourceCache(SharedPreferences sharedPreferences, DnsResolver dnsResolver, String str, SimpleHttpClient simpleHttpClient, NetworkStateMonitor networkStateMonitor, String str2, String str3, ErrorReportFactory errorReportFactory, ErrorReporter errorReporter, Logger logger) {
        super(sharedPreferences, dnsResolver, str, simpleHttpClient, networkStateMonitor, logger, str2);
        this.logger = logger;
        this.errorReportFactory = errorReportFactory;
        this.errorReporter = errorReporter;
        this.configurationUrl = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.smaato.sdk.core.dnsbasedresource.ExpirationBasedDnsResourceCache
    public Configuration getDefaultResource() {
        return Configuration.create();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.smaato.sdk.core.dnsbasedresource.ExpirationBasedDnsResourceCache
    public long getTtl(Configuration configuration) {
        return configuration.getTtlMillis();
    }

    @Override // com.smaato.sdk.core.dnsbasedresource.ExpirationBasedDnsResourceCache
    protected String getDomainForDnsQuery() {
        return String.format(DNS_QUERY_URL_FORMATTER, getPublisherId());
    }

    @Override // com.smaato.sdk.core.dnsbasedresource.ExpirationBasedDnsResourceCache
    protected String getResourceUrl() {
        return String.format("%s/%s.cfg1", this.configurationUrl, getPublisherId());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.smaato.sdk.core.dnsbasedresource.ExpirationBasedDnsResourceCache
    public Configuration decodeResource(String str) throws Exception {
        return Configuration.create(new JSONObject(str));
    }

    @Override // com.smaato.sdk.core.dnsbasedresource.ExpirationBasedDnsResourceCache
    protected void onResourceDownloadFailed(long j, Exception exc) {
        String str = "Provider_Configuration_Download_Failure_" + exc.getClass();
        this.logger.error(LogDomain.CORE, "Provider Configuration Download Failure", exc);
        this.errorReporter.report(this.errorReportFactory.create(str, getPublisherId(), j));
    }
}
