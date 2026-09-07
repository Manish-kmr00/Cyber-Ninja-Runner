package com.smaato.sdk.core.dns;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.IDN;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;

/* JADX INFO: loaded from: classes11.dex */
public final class DnsName {
    public static final String ESCAPED_DOT = "\\.";
    static final int MAX_DNSNAME_LENGTH_IN_OCTETS = 255;
    private static final DnsName ROOT = new DnsName(".");
    private final String ace;
    private byte[] bytes;
    private int hashCode;
    private DnsLabel[] labels;
    private final String rawAce;
    private DnsLabel[] rawLabels;
    private int size;

    private DnsName(String str) {
        this(str, true);
    }

    private DnsName(String str, boolean z) {
        this.size = -1;
        if (str.isEmpty()) {
            this.rawAce = ROOT.rawAce;
        } else {
            this.rawAce = z ? stripTrailingDot(str) : toASCII(str);
        }
        this.ace = this.rawAce.toLowerCase(Locale.US);
        validateMaxDnsnameLengthInOctets();
    }

    private DnsName(DnsLabel[] dnsLabelArr, boolean z) {
        this.size = -1;
        this.rawLabels = dnsLabelArr;
        this.labels = new DnsLabel[dnsLabelArr.length];
        int length = 0;
        for (int i = 0; i < dnsLabelArr.length; i++) {
            length += dnsLabelArr[i].length() + 1;
            this.labels[i] = dnsLabelArr[i].asLowercaseVariant();
        }
        this.rawAce = labelsToString(dnsLabelArr, length);
        this.ace = labelsToString(this.labels, length);
        if (z) {
            validateMaxDnsnameLengthInOctets();
        }
    }

    private String stripTrailingDot(String str) {
        int length = str.length();
        int i = length - 1;
        return (length < 2 || str.charAt(i) != '.') ? str : str.subSequence(0, i).toString();
    }

    private String toASCII(String str) {
        DnsName dnsName = ROOT;
        if (dnsName.ace.equals(str)) {
            return dnsName.ace;
        }
        return IDN.toASCII(str);
    }

    private static String labelsToString(DnsLabel[] dnsLabelArr, int i) {
        StringBuilder sb = new StringBuilder(i);
        for (int length = dnsLabelArr.length - 1; length >= 0; length--) {
            sb.append((CharSequence) dnsLabelArr[length]).append('.');
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    private void validateMaxDnsnameLengthInOctets() {
        setBytesIfRequired();
        if (this.bytes.length > 255) {
            throw new InvalidDnsNameException.DNSNameTooLongException(this.ace, this.bytes);
        }
    }

    void writeToStream(OutputStream outputStream) throws IOException {
        setBytesIfRequired();
        outputStream.write(this.bytes);
    }

    private void setBytesIfRequired() {
        if (this.bytes != null) {
            return;
        }
        setLabelsIfRequired();
        DnsLabel[] dnsLabelArr = this.labels;
        if (dnsLabelArr == null) {
            return;
        }
        this.bytes = toBytes(dnsLabelArr);
    }

    private static byte[] toBytes(DnsLabel[] dnsLabelArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(64);
        for (int length = dnsLabelArr.length - 1; length >= 0; length--) {
            dnsLabelArr[length].writeToBoas(byteArrayOutputStream);
        }
        byteArrayOutputStream.write(0);
        return byteArrayOutputStream.toByteArray();
    }

    private void setLabelsIfRequired() {
        if (this.labels == null || this.rawLabels == null) {
            if (isRootLabel()) {
                this.rawLabels = new DnsLabel[0];
                this.labels = new DnsLabel[0];
            } else {
                this.labels = getLabels(this.ace);
                this.rawLabels = getLabels(this.rawAce);
            }
        }
    }

    private static DnsLabel[] getLabels(String str) {
        String[] strArrSplit = str.replace(ESCAPED_DOT, "ä").split("[.。．｡]", 128);
        for (int i = 0; i < strArrSplit.length; i++) {
            strArrSplit[i] = strArrSplit[i].replace("ä", ".");
        }
        for (int i2 = 0; i2 < strArrSplit.length / 2; i2++) {
            String str2 = strArrSplit[i2];
            int length = (strArrSplit.length - i2) - 1;
            strArrSplit[i2] = strArrSplit[length];
            strArrSplit[length] = str2;
        }
        try {
            return DnsLabel.from(strArrSplit);
        } catch (DnsLabel.LabelToLongException e) {
            throw new InvalidDnsNameException.LabelTooLongException(str, e.label);
        }
    }

    String getRawAce() {
        return this.rawAce;
    }

    public int size() {
        if (this.size < 0) {
            if (isRootLabel()) {
                this.size = 1;
            } else {
                this.size = this.ace.length() + 2;
            }
        }
        return this.size;
    }

    public String toString() {
        return this.ace;
    }

    public static DnsName from(String str) {
        return new DnsName(str, false);
    }

    public static DnsName from(DnsName dnsName, DnsName dnsName2) {
        DnsLabel[] dnsLabelArr;
        dnsName.setLabelsIfRequired();
        dnsName2.setLabelsIfRequired();
        DnsLabel[] dnsLabelArr2 = dnsName.rawLabels;
        if (dnsLabelArr2 == null || (dnsLabelArr = dnsName2.rawLabels) == null) {
            throw new IllegalStateException("Child & parent rawLabels should not be null");
        }
        DnsLabel[] dnsLabelArr3 = new DnsLabel[dnsLabelArr2.length + dnsLabelArr.length];
        System.arraycopy(dnsLabelArr, 0, dnsLabelArr3, 0, dnsLabelArr.length);
        DnsLabel[] dnsLabelArr4 = dnsName.rawLabels;
        System.arraycopy(dnsLabelArr4, 0, dnsLabelArr3, dnsName2.rawLabels.length, dnsLabelArr4.length);
        return new DnsName(dnsLabelArr3, true);
    }

    public static DnsName parse(DataInputStream dataInputStream, byte[] bArr) throws IOException {
        int unsignedByte = dataInputStream.readUnsignedByte();
        if ((unsignedByte & 192) == 192) {
            int unsignedByte2 = ((unsignedByte & 63) << 8) + dataInputStream.readUnsignedByte();
            HashSet hashSet = new HashSet();
            hashSet.add(Integer.valueOf(unsignedByte2));
            return parse(bArr, unsignedByte2, hashSet);
        }
        if (unsignedByte == 0) {
            return ROOT;
        }
        byte[] bArr2 = new byte[unsignedByte];
        dataInputStream.readFully(bArr2);
        return from(new DnsName(new String(bArr2, Charset.forName("US-ASCII"))), parse(dataInputStream, bArr));
    }

    private static DnsName parse(byte[] bArr, int i, HashSet hashSet) {
        int i2 = bArr[i];
        int i3 = i2 & 255;
        if ((i2 & 192) != 192) {
            if (i3 == 0) {
                return ROOT;
            }
            int i4 = i + 1;
            return from(new DnsName(new String(bArr, i4, i3, Charset.forName("US-ASCII"))), parse(bArr, i4 + i3, hashSet));
        }
        int i5 = ((i2 & 63) << 8) + (bArr[i + 1] & 255);
        if (hashSet.contains(Integer.valueOf(i5))) {
            throw new IllegalStateException("Cyclic offsets detected.");
        }
        hashSet.add(Integer.valueOf(i5));
        return parse(bArr, i5, hashSet);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof DnsName)) {
            return Arrays.equals(getBytesForEscapedName(), ((DnsName) obj).getBytesForEscapedName());
        }
        return false;
    }

    public int hashCode() {
        if (this.hashCode == 0 && !isRootLabel()) {
            this.hashCode = Arrays.hashCode(getBytesForEscapedName());
        }
        return this.hashCode;
    }

    private boolean isRootLabel() {
        return this.ace.isEmpty() || this.ace.equals(".");
    }

    private byte[] getBytesForEscapedName() {
        DnsName dnsName = new DnsName(this.ace.replace(ESCAPED_DOT, "."));
        dnsName.setBytesIfRequired();
        return dnsName.bytes;
    }
}
