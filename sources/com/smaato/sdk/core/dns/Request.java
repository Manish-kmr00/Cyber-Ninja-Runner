package com.smaato.sdk.core.dns;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes13.dex */
final class Request {
    private byte[] byteArray;
    final Record.Class clazz;
    public final DnsName name;
    public final Record.Type type;
    private final boolean unicastQuery;

    private Request(DnsName dnsName, Record.Type type, Record.Class r3, boolean z) {
        this.name = (DnsName) Objects.requireNonNull(dnsName);
        this.type = (Record.Type) Objects.requireNonNull(type);
        this.clazz = (Record.Class) Objects.requireNonNull(r3);
        this.unicastQuery = z;
    }

    private Request(DnsName dnsName, Record.Type type, Record.Class r4) {
        this(dnsName, type, r4, false);
    }

    Request(DnsName dnsName, Record.Type type) {
        this(dnsName, type, Record.Class.IN);
    }

    Request(DataInputStream dataInputStream, byte[] bArr) throws IOException {
        this.name = DnsName.parse(dataInputStream, bArr);
        this.type = Record.Type.getType(dataInputStream.readUnsignedShort());
        this.clazz = Record.Class.getClass(dataInputStream.readUnsignedShort());
        this.unicastQuery = false;
    }

    byte[] toByteArray() {
        if (this.byteArray == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                this.name.writeToStream(dataOutputStream);
                dataOutputStream.writeShort(this.type.getValue());
                dataOutputStream.writeShort(this.clazz.getValue() | (this.unicastQuery ? 32768 : 0));
                dataOutputStream.flush();
                this.byteArray = byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return this.byteArray;
    }

    public int hashCode() {
        return Arrays.hashCode(toByteArray());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Request) {
            return Arrays.equals(toByteArray(), ((Request) obj).toByteArray());
        }
        return false;
    }

    public String toString() {
        return this.name.getRawAce() + ".\t" + this.clazz + '\t' + this.type;
    }
}
