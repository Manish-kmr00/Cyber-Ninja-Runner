package com.smaato.sdk.core.locationaware;

import android.content.Context;
import android.text.TextUtils;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes6.dex */
public class ConsentCountryChecker {
    private final Context context;
    private final DnsLookup dns;
    private volatile List dnsRecords;
    private volatile Boolean isGeoDns;
    private final Logger logger;
    private volatile String networkCountryIso;
    private volatile String simCountryIso;
    private final SimInfo simInfo;
    private final TzSettings tzSettings;

    public ConsentCountryChecker(Context context, SimInfo simInfo, TzSettings tzSettings, DnsLookup dnsLookup, Logger logger) {
        this.logger = logger;
        this.dns = dnsLookup;
        this.context = context;
        this.simInfo = simInfo;
        this.tzSettings = tzSettings;
    }

    public boolean isGeoDns(String str, String str2) {
        synchronized (this) {
            try {
                this.isGeoDns = Boolean.FALSE;
                List<TxtRecord> dNSRecords = getDNSRecords(str);
                if (dNSRecords != null) {
                    for (TxtRecord txtRecord : dNSRecords) {
                        if (txtRecord != null && txtRecord.data() != null) {
                            String[] strArrSplit = txtRecord.data().split(":");
                            if (strArrSplit.length > 1 && str2.equalsIgnoreCase(strArrSplit[1].trim())) {
                                this.isGeoDns = Boolean.TRUE;
                            }
                        }
                    }
                }
            } catch (IOException e) {
                this.logger.error(LogDomain.NETWORK, e, "Error when checking geo dns", new Object[0]);
            }
        }
        return this.isGeoDns != null && this.isGeoDns.booleanValue();
    }

    private List getDNSRecords(String str) {
        if (this.dnsRecords == null || this.dnsRecords.isEmpty()) {
            this.dnsRecords = this.dns.blockingTxt(str);
        }
        return this.dnsRecords;
    }

    public String getPackageName() {
        return this.context.getPackageName();
    }

    public boolean isConsentCountryBySIM(Set<String> set) {
        boolean z;
        synchronized (this) {
            z = isConsentCountry(getSimCountryIso(), set) || isConsentCountry(getNetworkCountryIso(), set);
        }
        return z;
    }

    private String getSimCountryIso() {
        if (this.simCountryIso == null) {
            this.simCountryIso = this.simInfo.getSimCountryIso();
        }
        return this.simCountryIso;
    }

    private String getNetworkCountryIso() {
        if (this.networkCountryIso == null) {
            this.networkCountryIso = this.simInfo.getNetworkCountryIso();
        }
        return this.networkCountryIso;
    }

    public boolean isConsentCountryByTimeZone(Map<String, String> map) {
        synchronized (this) {
            if (!this.tzSettings.isAutoTimeZoneEnabled()) {
                return false;
            }
            return map.containsKey(TimeZone.getDefault().getID());
        }
    }

    private boolean isConsentCountry(String str, Set set) {
        return !TextUtils.isEmpty(str) && set.contains(str.toUpperCase(Locale.US));
    }
}
