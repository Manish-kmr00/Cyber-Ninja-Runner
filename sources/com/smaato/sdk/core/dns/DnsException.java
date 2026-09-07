package com.smaato.sdk.core.dns;

import com.smaato.sdk.core.util.Joiner;
import com.smaato.sdk.core.util.Objects;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public abstract class DnsException extends IOException {
    DnsException(String str) {
        super(str);
    }

    public static class IdMismatch extends DnsException {
        private final DnsMessage request;
        private final DnsMessage response;

        IdMismatch(DnsMessage dnsMessage, DnsMessage dnsMessage2) {
            super("The response's ID doesn't matches the request ID. Request: " + dnsMessage.id + ". Response: " + dnsMessage2.id);
            this.request = (DnsMessage) Objects.requireNonNull(dnsMessage);
            this.response = (DnsMessage) Objects.requireNonNull(dnsMessage2);
        }

        public DnsMessage getRequest() {
            return this.request;
        }

        public DnsMessage getResponse() {
            return this.response;
        }
    }

    public static class ErrorResponseException extends DnsException {
        private final DnsMessage request;
        private final DnsQueryResult result;

        ErrorResponseException(DnsMessage dnsMessage, DnsQueryResult dnsQueryResult) {
            super("Received " + dnsQueryResult.response.responseCode + " error response\n" + dnsQueryResult);
            this.request = (DnsMessage) Objects.requireNonNull(dnsMessage);
            this.result = (DnsQueryResult) Objects.requireNonNull(dnsQueryResult);
        }

        public DnsMessage getRequest() {
            return this.request;
        }

        public DnsQueryResult getResult() {
            return this.result;
        }
    }

    public static class NoQueryPossibleException extends DnsException {
        private final DnsMessage request;

        NoQueryPossibleException(DnsMessage dnsMessage) {
            super("No DNS server could be queried");
            this.request = (DnsMessage) Objects.requireNonNull(dnsMessage);
        }

        public DnsMessage getRequest() {
            return this.request;
        }
    }

    static class MultipleDnsException extends DnsException {
        MultipleDnsException(List<? extends IOException> list) {
            super(Joiner.join(", ", list));
        }
    }
}
