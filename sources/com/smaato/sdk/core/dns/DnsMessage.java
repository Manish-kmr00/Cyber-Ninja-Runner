package com.smaato.sdk.core.dns;

import com.google.common.base.Ascii;
import com.smaato.sdk.core.util.collections.Lists;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes10.dex */
final class DnsMessage {
    private final List answerSection;
    private final boolean authenticData;
    private final boolean authoritativeAnswer;
    private byte[] byteCache;
    private final boolean checkingDisabled;
    private transient Integer hashCodeCache;
    public final int id;
    private final Opcode opcode;
    private final boolean qr;
    private final long receiveTimestamp;
    private final boolean recursionAvailable;
    private final boolean recursionDesired;
    private final List requests;
    final ResponseCode responseCode;
    private String toStringCache;
    final boolean truncated;

    DnsMessage(byte[] bArr) throws IOException, IllegalArgumentException {
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.id = dataInputStream.readUnsignedShort();
        int unsignedShort = dataInputStream.readUnsignedShort();
        this.qr = ((unsignedShort >> 15) & 1) == 1;
        this.opcode = Opcode.getOpcode((unsignedShort >> 11) & 15);
        this.authoritativeAnswer = ((unsignedShort >> 10) & 1) == 1;
        this.truncated = ((unsignedShort >> 9) & 1) == 1;
        this.recursionDesired = ((unsignedShort >> 8) & 1) == 1;
        this.recursionAvailable = ((unsignedShort >> 7) & 1) == 1;
        this.authenticData = ((unsignedShort >> 5) & 1) == 1;
        this.checkingDisabled = ((unsignedShort >> 4) & 1) == 1;
        this.responseCode = ResponseCode.getResponseCode(unsignedShort & 15);
        this.receiveTimestamp = System.currentTimeMillis();
        int unsignedShort2 = dataInputStream.readUnsignedShort();
        int unsignedShort3 = dataInputStream.readUnsignedShort();
        dataInputStream.readUnsignedShort();
        dataInputStream.readUnsignedShort();
        this.requests = new ArrayList(unsignedShort2);
        for (int i = 0; i < unsignedShort2; i++) {
            this.requests.add(new Request(dataInputStream, bArr));
        }
        this.answerSection = new ArrayList(unsignedShort3);
        for (int i2 = 0; i2 < unsignedShort3; i2++) {
            this.answerSection.add(Record.parse(dataInputStream, bArr));
        }
    }

    private DnsMessage(Builder builder) {
        this.id = builder.id;
        this.opcode = builder.opcode;
        this.responseCode = builder.responseCode;
        this.receiveTimestamp = builder.receiveTimestamp;
        this.qr = builder.query;
        this.authoritativeAnswer = builder.authoritativeAnswer;
        this.truncated = builder.truncated;
        this.recursionDesired = builder.recursionDesired;
        this.recursionAvailable = builder.recursionAvailable;
        this.authenticData = builder.authenticData;
        this.checkingDisabled = builder.checkingDisabled;
        this.requests = Lists.toImmutableList((Collection) builder.requests);
        this.answerSection = Lists.toImmutableList((Collection) builder.answerSection);
    }

    DatagramPacket asDatagram(InetAddress inetAddress, int i) {
        byte[] bArrSerialize = serialize();
        return new DatagramPacket(bArrSerialize, bArrSerialize.length, inetAddress, i);
    }

    void writeTo(OutputStream outputStream) throws IOException {
        byte[] bArrSerialize = serialize();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeShort(bArrSerialize.length);
        dataOutputStream.write(bArrSerialize);
    }

    private byte[] serialize() {
        byte[] bArr = this.byteCache;
        if (bArr != null) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        int iCalculateHeaderBitmap = calculateHeaderBitmap();
        try {
            dataOutputStream.writeShort((short) this.id);
            dataOutputStream.writeShort((short) iCalculateHeaderBitmap);
            List list = this.requests;
            if (list == null) {
                dataOutputStream.writeShort(0);
            } else {
                dataOutputStream.writeShort((short) list.size());
            }
            List list2 = this.answerSection;
            if (list2 == null) {
                dataOutputStream.writeShort(0);
            } else {
                dataOutputStream.writeShort((short) list2.size());
            }
            dataOutputStream.writeShort(0);
            dataOutputStream.writeShort(0);
            List list3 = this.requests;
            if (list3 != null) {
                Iterator it = list3.iterator();
                while (it.hasNext()) {
                    dataOutputStream.write(((Request) it.next()).toByteArray());
                }
            }
            List list4 = this.answerSection;
            if (list4 != null) {
                Iterator it2 = list4.iterator();
                while (it2.hasNext()) {
                    dataOutputStream.write(((Record) it2.next()).toByteArray());
                }
            }
            dataOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            this.byteCache = byteArray;
            return byteArray;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    private int calculateHeaderBitmap() {
        int value = this.qr ? 32768 : 0;
        Opcode opcode = this.opcode;
        if (opcode != null) {
            value += opcode.getValue() << Ascii.VT;
        }
        if (this.authoritativeAnswer) {
            value += 1024;
        }
        if (this.truncated) {
            value += 512;
        }
        if (this.recursionDesired) {
            value += 256;
        }
        if (this.recursionAvailable) {
            value += 128;
        }
        if (this.authenticData) {
            value += 32;
        }
        if (this.checkingDisabled) {
            value += 16;
        }
        return value + this.responseCode.getValue();
    }

    public String toString() {
        String str = this.toStringCache;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder("DnsMessage");
        asBuilder().writeToStringBuilder(sb);
        String string = sb.toString();
        this.toStringCache = string;
        return string;
    }

    <D extends Data> Set<D> getAnswersFor(Request request) {
        if (this.responseCode != ResponseCode.NO_ERROR || this.answerSection == null) {
            return null;
        }
        HashSet hashSet = new HashSet(this.answerSection.size());
        for (Record record : this.answerSection) {
            if (record.isAnswer(request)) {
                hashSet.add(record.getPayload());
            }
        }
        return hashSet;
    }

    private Builder asBuilder() {
        return new Builder();
    }

    public int hashCode() {
        if (this.hashCodeCache == null) {
            this.hashCodeCache = Integer.valueOf(Arrays.hashCode(serialize()));
        }
        return this.hashCodeCache.intValue();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DnsMessage)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return Arrays.equals(serialize(), ((DnsMessage) obj).serialize());
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private List answerSection;
        private boolean authenticData;
        private boolean authoritativeAnswer;
        private boolean checkingDisabled;
        private int id;
        private Opcode opcode;
        private boolean query;
        private long receiveTimestamp;
        private boolean recursionAvailable;
        private boolean recursionDesired;
        private List requests;
        private ResponseCode responseCode;
        private boolean truncated;

        private Builder() {
            this.opcode = Opcode.QUERY;
            this.responseCode = ResponseCode.NO_ERROR;
            this.receiveTimestamp = -1L;
        }

        private Builder(DnsMessage dnsMessage) {
            this.opcode = Opcode.QUERY;
            this.responseCode = ResponseCode.NO_ERROR;
            this.receiveTimestamp = -1L;
            this.id = dnsMessage.id;
            this.opcode = dnsMessage.opcode;
            this.responseCode = dnsMessage.responseCode;
            this.query = dnsMessage.qr;
            this.authoritativeAnswer = dnsMessage.authoritativeAnswer;
            this.truncated = dnsMessage.truncated;
            this.recursionDesired = dnsMessage.recursionDesired;
            this.recursionAvailable = dnsMessage.recursionAvailable;
            this.authenticData = dnsMessage.authenticData;
            this.checkingDisabled = dnsMessage.checkingDisabled;
            this.receiveTimestamp = dnsMessage.receiveTimestamp;
            List list = dnsMessage.requests;
            ArrayList arrayList = new ArrayList();
            this.requests = arrayList;
            if (list != null) {
                arrayList.addAll(list);
            }
            List list2 = dnsMessage.answerSection;
            ArrayList arrayList2 = new ArrayList();
            this.answerSection = arrayList2;
            if (list2 != null) {
                arrayList2.addAll(list2);
            }
        }

        public Builder setId(int i) {
            this.id = i & 65535;
            return this;
        }

        public Builder setRecursionDesired(boolean z) {
            this.recursionDesired = z;
            return this;
        }

        public Builder setQuestion(Request request) {
            ArrayList arrayList = new ArrayList(1);
            this.requests = arrayList;
            arrayList.add(request);
            return this;
        }

        public DnsMessage build() {
            return new DnsMessage(this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void writeToStringBuilder(StringBuilder sb) {
            sb.append('(').append(this.id).append(' ').append(this.opcode).append(' ').append(this.responseCode).append(' ');
            if (this.query) {
                sb.append("resp[qr=1]");
            } else {
                sb.append("query[qr=0]");
            }
            if (this.authoritativeAnswer) {
                sb.append(" aa");
            }
            if (this.truncated) {
                sb.append(" tr");
            }
            if (this.recursionDesired) {
                sb.append(" rd");
            }
            if (this.recursionAvailable) {
                sb.append(" ra");
            }
            if (this.authenticData) {
                sb.append(" ad");
            }
            if (this.checkingDisabled) {
                sb.append(" cd");
            }
            sb.append(")\n");
            List list = this.requests;
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    sb.append("[Q: ").append((Request) it.next()).append("]\n");
                }
            }
            List list2 = this.answerSection;
            if (list2 != null) {
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    sb.append("[A: ").append((Record) it2.next()).append("]\n");
                }
            }
            if (sb.charAt(sb.length() - 1) == '\n') {
                sb.setLength(sb.length() - 1);
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Builder of DnsMessage");
            writeToStringBuilder(sb);
            return sb.toString();
        }
    }

    public enum ResponseCode {
        NO_ERROR(0),
        FORMAT_ERR(1),
        SERVER_FAIL(2),
        NX_DOMAIN(3),
        NO_IMP(4),
        REFUSED(5),
        YXDOMAIN(6),
        YXRRSET(7),
        NXRRSET(8),
        NOT_AUTH(9),
        NOT_ZONE(10),
        BADVERS_BADSIG(16),
        BADKEY(17),
        BADTIME(18),
        BADMODE(19),
        BADNAME(20),
        BADALG(21),
        BADTRUNC(22),
        BADCOOKIE(23);

        private static final Map INVERSE_LUT = new HashMap(values().length);
        private final byte value;

        static {
            for (ResponseCode responseCode : values()) {
                INVERSE_LUT.put(Integer.valueOf(responseCode.value), responseCode);
            }
        }

        ResponseCode(int i) {
            this.value = (byte) i;
        }

        public byte getValue() {
            return this.value;
        }

        public static ResponseCode getResponseCode(int i) throws IllegalArgumentException {
            if (i < 0 || i > 65535) {
                throw new IllegalArgumentException();
            }
            ResponseCode responseCode = (ResponseCode) INVERSE_LUT.get(Integer.valueOf(i));
            if (responseCode != null) {
                return responseCode;
            }
            throw new IllegalArgumentException();
        }
    }

    public enum Opcode {
        QUERY,
        INVERSE_QUERY,
        STATUS,
        UNASSIGNED3,
        NOTIFY,
        UPDATE;

        private static final Opcode[] INVERSE_LUT = new Opcode[values().length];
        private final byte value = (byte) ordinal();

        static {
            for (Opcode opcode : values()) {
                Opcode[] opcodeArr = INVERSE_LUT;
                if (opcodeArr[opcode.getValue()] != null) {
                    throw new IllegalStateException();
                }
                opcodeArr[opcode.getValue()] = opcode;
            }
        }

        Opcode() {
        }

        public byte getValue() {
            return this.value;
        }

        public static Opcode getOpcode(int i) throws IllegalArgumentException {
            if (i < 0 || i > 15) {
                throw new IllegalArgumentException();
            }
            Opcode[] opcodeArr = INVERSE_LUT;
            if (i >= opcodeArr.length) {
                return null;
            }
            return opcodeArr[i];
        }
    }
}
