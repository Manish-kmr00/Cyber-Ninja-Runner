package com.smaato.sdk.core.dns;

import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.Locale;

/* JADX INFO: loaded from: classes9.dex */
final class DnsLabel implements CharSequence {
    static final int MAX_LABEL_LENGTH_IN_OCTETS = 63;
    private byte[] byteCache;
    private final String label;
    private DnsLabel lowercasedVariant;

    private DnsLabel(String str) {
        this.label = str;
        setBytesIfRequired();
        if (this.byteCache.length > 63) {
            throw new LabelToLongException(str);
        }
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.label.length();
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i) {
        return this.label.charAt(i);
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i, int i2) {
        return this.label.subSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.label;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof DnsLabel) {
            return this.label.equals(((DnsLabel) obj).label);
        }
        return false;
    }

    public final int hashCode() {
        return this.label.hashCode();
    }

    final DnsLabel asLowercaseVariant() {
        if (this.lowercasedVariant == null) {
            this.lowercasedVariant = from(this.label.toLowerCase(Locale.US));
        }
        return this.lowercasedVariant;
    }

    private void setBytesIfRequired() {
        if (this.byteCache == null) {
            this.byteCache = this.label.getBytes(Charset.forName("US-ASCII"));
        }
    }

    final void writeToBoas(ByteArrayOutputStream byteArrayOutputStream) {
        setBytesIfRequired();
        byteArrayOutputStream.write(this.byteCache.length);
        byte[] bArr = this.byteCache;
        byteArrayOutputStream.write(bArr, 0, bArr.length);
    }

    public static DnsLabel from(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Label is null or empty");
        }
        return new DnsLabel(str);
    }

    public static DnsLabel[] from(String[] strArr) {
        DnsLabel[] dnsLabelArr = new DnsLabel[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            dnsLabelArr[i] = from(strArr[i]);
        }
        return dnsLabelArr;
    }

    static class LabelToLongException extends IllegalArgumentException {
        final String label;

        LabelToLongException(String str) {
            this.label = str;
        }
    }
}
