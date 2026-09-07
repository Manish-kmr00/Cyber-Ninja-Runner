package com.smaato.sdk.core.dnsbasedresource;

import android.content.SharedPreferences;
import com.smaato.sdk.core.dns.DnsResolver;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.simplehttp.SimpleHttpClient;
import com.smaato.sdk.core.util.TextUtils;
import com.smaato.sdk.core.util.Threads;
import com.smaato.sdk.core.util.fi.Predicate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;

/* JADX INFO: loaded from: classes12.dex */
public abstract class VersionBasedDnsResourceCache<T> {
    private static final Pattern PATTERN = Pattern.compile("[a-f0-9]{32}");
    private final DnsBasedKeyValuePairLoader dnsBasedKeyValuePairLoader;
    private Object inMemoryCache;
    private Object initialResource;
    private final String resourceKey;
    private final SharedPreferences sharedPreferences;
    private final SimpleHttpClient simpleHttpClient;

    protected abstract T decodeResource(String str) throws JSONException;

    protected abstract String getDomainForDnsQuery();

    protected abstract T getInitialResource();

    protected abstract String getResourceUrl();

    protected VersionBasedDnsResourceCache(SharedPreferences sharedPreferences, DnsResolver dnsResolver, String str, final String str2, SimpleHttpClient simpleHttpClient, Logger logger) {
        this.sharedPreferences = sharedPreferences;
        this.resourceKey = str;
        this.simpleHttpClient = simpleHttpClient;
        this.dnsBasedKeyValuePairLoader = new DnsBasedKeyValuePairLoader(dnsResolver, getDomainForDnsQuery(), new Predicate() { // from class: com.smaato.sdk.core.dnsbasedresource.VersionBasedDnsResourceCache$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.Predicate
            public final boolean test(Object obj) {
                return str2.equals(((Map) obj).get("v"));
            }
        }, logger);
    }

    public void start() {
        this.initialResource = getInitialResource();
        update();
    }

    public T get() {
        T t = (T) this.inMemoryCache;
        return t != null ? t : (T) this.initialResource;
    }

    private void update() {
        Threads.runOnBackgroundThread(new Runnable() { // from class: com.smaato.sdk.core.dnsbasedresource.VersionBasedDnsResourceCache$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.updateLocalResource();
            }
        });
        Threads.runOnBackgroundThread(new Runnable() { // from class: com.smaato.sdk.core.dnsbasedresource.VersionBasedDnsResourceCache$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.readLocalResource();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLocalResource() {
        synchronized (this) {
            String actualVersionNumberFromDns = getActualVersionNumberFromDns();
            String localVersionNumber = getLocalVersionNumber();
            if (actualVersionNumberFromDns != null && !actualVersionNumberFromDns.equals(localVersionNumber)) {
                HashMap map = new HashMap();
                String string = this.simpleHttpClient.readString(getResourceUrl(), map);
                String versionNumberFromHeaderFields = getVersionNumberFromHeaderFields(map);
                if (string != null && actualVersionNumberFromDns.equals(versionNumberFromHeaderFields)) {
                    saveLocalVersionNumber(versionNumberFromHeaderFields);
                    saveLocalResource(string);
                    try {
                        this.inMemoryCache = decodeResource(string);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readLocalResource() {
        synchronized (this) {
            if (this.inMemoryCache == null) {
                String string = this.sharedPreferences.getString(this.resourceKey, null);
                if (!TextUtils.isEmpty(string)) {
                    try {
                        this.inMemoryCache = decodeResource(string);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    protected String getLocalVersionNumber() {
        return this.sharedPreferences.getString(this.resourceKey + ".version", "");
    }

    protected void saveLocalVersionNumber(String str) {
        this.sharedPreferences.edit().putString(this.resourceKey + ".version", str).apply();
    }

    private void saveLocalResource(String str) {
        this.sharedPreferences.edit().putString(this.resourceKey, str).apply();
    }

    private String getActualVersionNumberFromDns() {
        return this.dnsBasedKeyValuePairLoader.getKeyValuePairs().get("ETAG");
    }

    private String getVersionNumberFromHeaderFields(Map map) {
        List list = (List) map.get("ETag");
        if (list != null && list.size() > 0) {
            Matcher matcher = PATTERN.matcher((CharSequence) list.get(0));
            if (matcher.find()) {
                return matcher.group();
            }
        }
        return null;
    }
}
