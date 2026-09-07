package com.smaato.sdk.core.dns;

import com.smaato.sdk.core.util.Objects;
import java.net.InetAddress;

/* JADX INFO: loaded from: classes5.dex */
final class DnsQueryResult {
    public final int port;
    public final DnsMessage query;
    public final QueryMethod queryMethod;
    public final DnsMessage response;
    public final InetAddress serverAddress;

    public enum QueryMethod {
        UDP,
        TCP
    }

    DnsQueryResult(InetAddress inetAddress, QueryMethod queryMethod, DnsMessage dnsMessage, DnsMessage dnsMessage2, int i) {
        this.queryMethod = (QueryMethod) Objects.requireNonNull(queryMethod);
        this.query = (DnsMessage) Objects.requireNonNull(dnsMessage);
        this.response = (DnsMessage) Objects.requireNonNull(dnsMessage2);
        this.serverAddress = (InetAddress) Objects.requireNonNull(inetAddress);
        this.port = i;
    }

    public String toString() {
        return this.response.toString();
    }

    boolean wasSuccessful() {
        return this.response.responseCode == DnsMessage.ResponseCode.NO_ERROR;
    }
}
