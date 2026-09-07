package com.smaato.sdk.core.dnsbasedresource;

import com.smaato.sdk.core.dns.DnsResolver;
import com.smaato.sdk.core.dns.ResolverResult;
import com.smaato.sdk.core.dns.TXT;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.util.TextUtils;
import com.smaato.sdk.core.util.fi.Predicate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public class DnsBasedKeyValuePairLoader {
    private final String dnsDomain;
    private final DnsResolver dnsResolver;
    private final Logger logger;
    private final Predicate recordFilter;

    DnsBasedKeyValuePairLoader(DnsResolver dnsResolver, String str, Predicate<Map<String, String>> predicate, Logger logger) {
        this.dnsResolver = dnsResolver;
        this.dnsDomain = str;
        this.recordFilter = predicate;
        this.logger = logger;
    }

    public Map<String, String> getKeyValuePairs() {
        try {
            ResolverResult resolverResultResolve = this.dnsResolver.resolve(this.dnsDomain, TXT.class);
            if (resolverResultResolve.getAnswers().isEmpty()) {
                return new HashMap();
            }
            HashMap map = new HashMap();
            Iterator it = resolverResultResolve.getAnswers().iterator();
            while (it.hasNext()) {
                Map keyValuePairs = getKeyValuePairs(((TXT) it.next()).getText());
                if (this.recordFilter.test(keyValuePairs)) {
                    map.putAll(keyValuePairs);
                }
            }
            return map;
        } catch (Exception e) {
            this.logger.error(LogDomain.CORE, "Error while parsing key-value pairs from DNS record for domain " + this.dnsDomain, e);
            return new HashMap();
        }
    }

    private Map getKeyValuePairs(String str) {
        int i;
        if (str == null || TextUtils.isEmpty(str)) {
            return new HashMap();
        }
        String[] strArrSplit = str.split(";");
        HashMap map = new HashMap();
        for (String str2 : strArrSplit) {
            int iIndexOf = str2.indexOf("=");
            map.put(iIndexOf > 0 ? str2.substring(0, iIndexOf) : str2, (iIndexOf <= 0 || str2.length() <= (i = iIndexOf + 1)) ? null : str2.substring(i));
        }
        return map;
    }
}
