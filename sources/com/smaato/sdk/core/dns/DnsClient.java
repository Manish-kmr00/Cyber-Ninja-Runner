package com.smaato.sdk.core.dns;

import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.collections.Sets;
import com.smaato.sdk.core.util.fi.Supplier;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
final class DnsClient {
    private final DnsDataSource dataSource;
    private final Supplier dnsIdSupplier;
    private final Set dnsServers;

    DnsClient(DnsDataSource dnsDataSource, Supplier<Integer> supplier, Set<InetAddress> set) {
        this.dataSource = (DnsDataSource) Objects.requireNonNull(dnsDataSource);
        this.dnsIdSupplier = (Supplier) Objects.requireNonNull(supplier);
        this.dnsServers = Sets.toImmutableSet(set);
    }

    public DnsQueryResult query(Request request) throws DnsException {
        DnsMessage dnsMessageBuildMessage = buildMessage(request);
        ArrayList arrayList = new ArrayList(this.dnsServers.size());
        Iterator it = this.dnsServers.iterator();
        while (it.hasNext()) {
            try {
                DnsQueryResult dnsQueryResultQuery = this.dataSource.query(dnsMessageBuildMessage, (InetAddress) it.next(), 53);
                if (dnsQueryResultQuery.wasSuccessful()) {
                    return dnsQueryResultQuery;
                }
                arrayList.add(new DnsException.ErrorResponseException(dnsMessageBuildMessage, dnsQueryResultQuery));
            } catch (DnsException e) {
                arrayList.add(e);
            }
        }
        if (arrayList.isEmpty()) {
            throw new DnsException.NoQueryPossibleException(dnsMessageBuildMessage);
        }
        throw new DnsException.MultipleDnsException(arrayList);
    }

    private DnsMessage buildMessage(Request request) {
        return DnsMessage.builder().setQuestion(request).setId(((Integer) this.dnsIdSupplier.get()).intValue()).setRecursionDesired(true).build();
    }
}
