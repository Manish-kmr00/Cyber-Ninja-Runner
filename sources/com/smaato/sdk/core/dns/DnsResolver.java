package com.smaato.sdk.core.dns;

import com.smaato.sdk.core.util.Objects;

/* JADX INFO: loaded from: classes8.dex */
public final class DnsResolver {
    private final DnsClient dnsClient;

    DnsResolver(DnsClient dnsClient) {
        this.dnsClient = (DnsClient) Objects.requireNonNull(dnsClient);
    }

    public final <D extends Data> ResolverResult<D> resolve(String str, Class<D> cls) throws DnsException {
        Request request = new Request(DnsName.from(str), Record.Type.getType(cls));
        return new ResolverResult<>(request, this.dnsClient.query(request));
    }
}
