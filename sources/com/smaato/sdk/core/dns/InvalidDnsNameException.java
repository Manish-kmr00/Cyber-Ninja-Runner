package com.smaato.sdk.core.dns;

/* JADX INFO: loaded from: classes4.dex */
public abstract class InvalidDnsNameException extends IllegalStateException {
    final String ace;

    InvalidDnsNameException(String str) {
        this.ace = str;
    }

    public static class LabelTooLongException extends InvalidDnsNameException {
        private final String label;

        LabelTooLongException(String str, String str2) {
            super(str);
            this.label = str2;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return "The DNS name '" + this.ace + "' contains the label '" + this.label + "' which exceeds the maximum label length of 63 octets by " + (this.label.length() - 63) + " octets.";
        }
    }

    public static class DNSNameTooLongException extends InvalidDnsNameException {
        private final byte[] bytes;

        DNSNameTooLongException(String str, byte[] bArr) {
            super(str);
            this.bytes = bArr;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return "The DNS name '" + this.ace + "' exceeds the maximum name length of 255 octets by " + (this.bytes.length - 255) + " octets.";
        }
    }
}
