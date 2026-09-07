package com.smaato.sdk.core.remoteconfig.global;

import android.content.SharedPreferences;
import com.smaato.sdk.core.BuildConfig;
import com.smaato.sdk.core.dns.DnsResolver;
import com.smaato.sdk.core.dnsbasedresource.VersionBasedDnsResourceCache;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.simplehttp.SimpleHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class GenericConfigResourceCache extends VersionBasedDnsResourceCache<GenericConfig> {
    public GenericConfigResourceCache(SharedPreferences sharedPreferences, DnsResolver dnsResolver, String str, Logger logger, SimpleHttpClient simpleHttpClient) {
        super(sharedPreferences, dnsResolver, "remote_config_url_template", str, simpleHttpClient, logger);
        if (getLocalVersionNumber().isEmpty()) {
            saveLocalVersionNumber(BuildConfig.SDK_REMOTE_CONFIG_VERSION);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.smaato.sdk.core.dnsbasedresource.VersionBasedDnsResourceCache
    public GenericConfig getInitialResource() {
        return GenericConfig.create();
    }

    @Override // com.smaato.sdk.core.dnsbasedresource.VersionBasedDnsResourceCache
    protected String getDomainForDnsQuery() {
        return "smaato_sdk_remote_config\\.json.sdk-files.smaato.net";
    }

    @Override // com.smaato.sdk.core.dnsbasedresource.VersionBasedDnsResourceCache
    protected String getResourceUrl() {
        return BuildConfig.SDK_REMOTE_CONFIG_URL;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.smaato.sdk.core.dnsbasedresource.VersionBasedDnsResourceCache
    public GenericConfig decodeResource(String str) throws JSONException {
        return GenericConfig.create(new JSONObject(str));
    }
}
