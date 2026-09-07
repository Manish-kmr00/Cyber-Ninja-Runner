package com.smaato.sdk.core.dns;

import com.smaato.sdk.core.dns.Data;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.collections.Sets;
import java.util.Set;

/* JADX INFO: loaded from: classes11.dex */
public final class ResolverResult<D extends Data> {
    private final Set data;
    private final Request request;
    private final DnsMessage.ResponseCode responseCode;

    ResolverResult(Request request, DnsQueryResult dnsQueryResult) {
        Objects.requireNonNull(dnsQueryResult);
        DnsMessage dnsMessage = dnsQueryResult.response;
        this.request = (Request) Objects.requireNonNull(request);
        this.responseCode = dnsMessage.responseCode;
        this.data = Sets.toImmutableSet(dnsMessage.getAnswersFor(request));
    }

    public Set<D> getAnswers() {
        return this.data;
    }

    public final String toString() {
        return ResolverResult.class.getName() + "\nQuestion: " + this.request + "\nResponse Code: " + this.responseCode + '\n';
    }
}
