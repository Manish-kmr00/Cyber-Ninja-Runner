package com.smaato.sdk.richmedia.util;

import android.content.SharedPreferences;
import com.smaato.sdk.core.dns.DnsResolver;
import com.smaato.sdk.core.dnsbasedresource.VersionBasedDnsResourceCache;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.rawresourceloader.RawResourceLoader;
import com.smaato.sdk.core.simplehttp.SimpleHttpClient;
import com.smaato.sdk.richmedia_light.R;

/* JADX INFO: loaded from: classes10.dex */
public class OutstreamAdTemplateResourceCache extends VersionBasedDnsResourceCache<String> {
    private final RawResourceLoader rawResourceLoader;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.smaato.sdk.core.dnsbasedresource.VersionBasedDnsResourceCache
    public String decodeResource(String str) {
        return str;
    }

    public OutstreamAdTemplateResourceCache(SharedPreferences sharedPreferences, DnsResolver dnsResolver, String str, RawResourceLoader rawResourceLoader, SimpleHttpClient simpleHttpClient, Logger logger) {
        super(sharedPreferences, dnsResolver, "outstream_ad_template", str, simpleHttpClient, logger);
        this.rawResourceLoader = rawResourceLoader;
        start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.smaato.sdk.core.dnsbasedresource.VersionBasedDnsResourceCache
    public String getInitialResource() {
        return this.rawResourceLoader.readRawTextFile(R.raw.html_player_vast);
    }

    @Override // com.smaato.sdk.core.dnsbasedresource.VersionBasedDnsResourceCache
    protected String getDomainForDnsQuery() {
        return "smaato_outstream_ad_template\\.txt.sdk-files.smaato.net";
    }

    @Override // com.smaato.sdk.core.dnsbasedresource.VersionBasedDnsResourceCache
    protected String getResourceUrl() {
        return "https://sdk-files.smaato.net/smaato_outstream_ad_template.txt";
    }
}
