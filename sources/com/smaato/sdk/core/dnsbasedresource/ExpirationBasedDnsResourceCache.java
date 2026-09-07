package com.smaato.sdk.core.dnsbasedresource;

import android.content.SharedPreferences;
import com.smaato.sdk.core.dns.DnsResolver;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.network.NetworkStateMonitor;
import com.smaato.sdk.core.simplehttp.SimpleHttpClient;
import com.smaato.sdk.core.util.TextUtils;
import com.smaato.sdk.core.util.Threads;
import com.smaato.sdk.core.util.fi.Predicate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ExpirationBasedDnsResourceCache<T> {
    private final DnsBasedKeyValuePairLoader dnsBasedKeyValuePairLoader;
    private Object inMemoryCache;
    Logger logger;
    private final NetworkStateMonitor networkStateMonitor;
    private final String publisherId;
    private int resourceDownloadRetryCount;
    private final String resourceKey;
    private final SharedPreferences sharedPreferences;
    private final SimpleHttpClient simpleHttpClient;
    private static final SimpleDateFormat TIMESTAMP_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
    private static final long MILLIS_IN_A_DAY = TimeUnit.DAYS.toMillis(1);

    static /* synthetic */ boolean lambda$new$0(Map map) {
        return true;
    }

    protected abstract T decodeResource(String str) throws Exception;

    protected abstract T getDefaultResource();

    protected abstract String getDomainForDnsQuery();

    protected abstract String getResourceUrl();

    protected abstract long getTtl(T t);

    protected abstract void onResourceDownloadFailed(long j, Exception exc);

    protected ExpirationBasedDnsResourceCache(SharedPreferences sharedPreferences, DnsResolver dnsResolver, String str, SimpleHttpClient simpleHttpClient, NetworkStateMonitor networkStateMonitor, Logger logger, String str2) {
        this.sharedPreferences = sharedPreferences;
        this.resourceKey = str;
        this.simpleHttpClient = simpleHttpClient;
        this.networkStateMonitor = networkStateMonitor;
        this.publisherId = str2;
        this.dnsBasedKeyValuePairLoader = new DnsBasedKeyValuePairLoader(dnsResolver, getDomainForDnsQuery(), new Predicate() { // from class: com.smaato.sdk.core.dnsbasedresource.ExpirationBasedDnsResourceCache$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Predicate
            public final boolean test(Object obj) {
                return ExpirationBasedDnsResourceCache.lambda$new$0((Map) obj);
            }
        }, logger);
        this.logger = logger;
    }

    public void start() {
        this.resourceDownloadRetryCount = 5;
        update();
    }

    public T get() {
        T t = (T) this.inMemoryCache;
        return t != null ? t : getDefaultResource();
    }

    private void update() {
        Threads.runOnBackgroundThread(new Runnable() { // from class: com.smaato.sdk.core.dnsbasedresource.ExpirationBasedDnsResourceCache$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.updateLocalResource();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void updateLocalResource() {
        Object cachedResource = getCachedResource();
        long timeOfLastDownload = getTimeOfLastDownload();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (cachedResource != null && jCurrentTimeMillis <= getTtl(cachedResource) + timeOfLastDownload) {
            this.inMemoryCache = cachedResource;
            return;
        }
        long lastResourceUpdateTimeFromDns = getLastResourceUpdateTimeFromDns();
        if (lastResourceUpdateTimeFromDns == -1) {
            this.inMemoryCache = getDefaultResource();
            return;
        }
        if (cachedResource == null) {
            downloadAndSaveResource();
        } else if (timeOfLastDownload < lastResourceUpdateTimeFromDns) {
            downloadAndSaveResource();
        } else {
            this.inMemoryCache = cachedResource;
        }
    }

    private Object getCachedResource() {
        String string = this.sharedPreferences.getString(this.resourceKey, null);
        try {
            if (string == null) {
                throw new NullPointerException();
            }
            return decodeResource(string);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadAndSaveResource() {
        if (!Threads.isMainThread()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            HashMap map = new HashMap();
            long j = MILLIS_IN_A_DAY;
            map.put("tv", Collections.singletonList(String.valueOf(((jCurrentTimeMillis / j) * j) / 1000)));
            try {
                String stringOrThrowNetworkException = this.simpleHttpClient.readStringOrThrowNetworkException(getResourceUrl(), map);
                if (TextUtils.isEmpty(stringOrThrowNetworkException)) {
                    throw new IllegalStateException("Downloaded resource is empty");
                }
                saveLocalResource(stringOrThrowNetworkException);
                saveTimeOfLastDownload(jCurrentTimeMillis);
                this.inMemoryCache = decodeResource(stringOrThrowNetworkException);
                return;
            } catch (Exception e) {
                this.logger.debug(LogDomain.CORE, "Download of resource failed", e);
                handleResourceDownloadFailure(jCurrentTimeMillis, e);
                return;
            }
        }
        Threads.runOnBackgroundThread(new Runnable() { // from class: com.smaato.sdk.core.dnsbasedresource.ExpirationBasedDnsResourceCache$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.downloadAndSaveResource();
            }
        });
    }

    private void handleResourceDownloadFailure(long j, Exception exc) {
        int i = this.resourceDownloadRetryCount;
        this.resourceDownloadRetryCount = i - 1;
        if (i != 0) {
            tryResourceDownloadAgain();
        } else {
            this.inMemoryCache = getDefaultResource();
            onResourceDownloadFailed(j, exc);
        }
    }

    private void tryResourceDownloadAgain() {
        if (this.networkStateMonitor.isOnline()) {
            downloadAndSaveResource();
        } else {
            scheduleNewDownloadWhenAppOnline();
        }
    }

    private void scheduleNewDownloadWhenAppOnline() {
        this.networkStateMonitor.addCallback(new NetworkStateMonitor.Callback() { // from class: com.smaato.sdk.core.dnsbasedresource.ExpirationBasedDnsResourceCache.1
            @Override // com.smaato.sdk.core.network.NetworkStateMonitor.Callback
            public void onNetworkStateChanged(boolean z) {
                if (z) {
                    ExpirationBasedDnsResourceCache.this.networkStateMonitor.removeCallback(this);
                    ExpirationBasedDnsResourceCache.this.downloadAndSaveResource();
                }
            }
        });
    }

    protected long getTimeOfLastDownload() {
        return Long.parseLong(this.sharedPreferences.getString(this.resourceKey + ".expiration", "0"));
    }

    protected void saveTimeOfLastDownload(long j) {
        this.sharedPreferences.edit().putString(this.resourceKey + ".expiration", String.valueOf(j)).apply();
    }

    private void saveLocalResource(String str) {
        this.sharedPreferences.edit().putString(this.resourceKey, str).apply();
    }

    private long getLastResourceUpdateTimeFromDns() {
        Map<String, String> keyValuePairs = this.dnsBasedKeyValuePairLoader.getKeyValuePairs();
        if (keyValuePairs.containsKey("noconf")) {
            return -1L;
        }
        Long timestamp = parseTimestamp(keyValuePairs.get("timestamp"));
        if (timestamp == null) {
            return 0L;
        }
        return timestamp.longValue();
    }

    private static Long parseTimestamp(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Date date = TIMESTAMP_FORMAT.parse(str);
            if (date != null) {
                return Long.valueOf(date.getTime());
            }
        } catch (ParseException unused) {
        }
        return null;
    }

    protected String getPublisherId() {
        return this.publisherId;
    }
}
