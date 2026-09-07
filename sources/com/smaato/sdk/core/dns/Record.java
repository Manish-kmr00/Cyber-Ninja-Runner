package com.smaato.sdk.core.dns;

import com.smaato.sdk.core.dns.Data;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class Record<D extends Data> {
    private byte[] bytes;
    private final Class clazz;
    private final int clazzValue;
    private Integer hashCodeCache;
    public final DnsName name;
    private final Data payloadData;
    private final long ttl;
    public final Type type;
    private final boolean unicastQuery;

    public enum Type {
        UNKNOWN(-1),
        TXT(16, TXT.class);

        private final java.lang.Class dataClass;
        private final int value;
        private static final Map INVERSE_LUT = new HashMap();
        private static final Map DATA_LUT = new HashMap();

        static {
            for (Type type : values()) {
                INVERSE_LUT.put(Integer.valueOf(type.getValue()), type);
                java.lang.Class cls = type.dataClass;
                if (cls != null) {
                    DATA_LUT.put(cls, type);
                }
            }
        }

        Type(int i) {
            this(i, null);
        }

        Type(int i, java.lang.Class cls) {
            this.value = i;
            this.dataClass = cls;
        }

        public int getValue() {
            return this.value;
        }

        public static Type getType(int i) {
            Type type = (Type) INVERSE_LUT.get(Integer.valueOf(i));
            return type == null ? UNKNOWN : type;
        }

        public static <D extends Data> Type getType(java.lang.Class<D> cls) {
            Type type = (Type) DATA_LUT.get(cls);
            return type == null ? UNKNOWN : type;
        }
    }

    public enum Class {
        IN(1),
        CH(3),
        HS(4),
        NONE(254),
        ANY(255);

        private static final HashMap INVERSE_LUT = new HashMap();
        private final int value;

        static {
            for (Class r3 : values()) {
                INVERSE_LUT.put(Integer.valueOf(r3.getValue()), r3);
            }
        }

        Class(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }

        public static Class getClass(int i) {
            return (Class) INVERSE_LUT.get(Integer.valueOf(i));
        }
    }

    private Record(DnsName dnsName, Type type, Class r3, int i, long j, Data data, boolean z) {
        this.name = dnsName;
        this.type = type;
        this.clazz = r3;
        this.clazzValue = i;
        this.ttl = j;
        this.payloadData = data;
        this.unicastQuery = z;
    }

    public static Record<Data> parse(DataInputStream dataInputStream, byte[] bArr) throws IOException {
        Data data;
        DnsName dnsName = DnsName.parse(dataInputStream, bArr);
        Type type = Type.getType(dataInputStream.readUnsignedShort());
        int unsignedShort = dataInputStream.readUnsignedShort();
        Class r3 = Class.getClass(unsignedShort & 32767);
        boolean z = (32768 & unsignedShort) > 0;
        long unsignedShort2 = (((long) dataInputStream.readUnsignedShort()) << 16) + ((long) dataInputStream.readUnsignedShort());
        int unsignedShort3 = dataInputStream.readUnsignedShort();
        if (AnonymousClass1.$SwitchMap$com$smaato$sdk$core$dns$Record$Type[type.ordinal()] == 1) {
            data = TXT.parse(dataInputStream, unsignedShort3);
        } else {
            data = UNKNOWN.parse(dataInputStream, unsignedShort3, type);
        }
        return new Record<>(dnsName, type, r3, unsignedShort, unsignedShort2, data, z);
    }

    /* JADX INFO: renamed from: com.smaato.sdk.core.dns.Record$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$smaato$sdk$core$dns$Record$Type;

        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$com$smaato$sdk$core$dns$Record$Type = iArr;
            try {
                iArr[Type.TXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$smaato$sdk$core$dns$Record$Type[Type.UNKNOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private void toOutputStream(OutputStream outputStream) throws IOException {
        if (this.payloadData == null) {
            throw new IllegalStateException("Empty Record has no byte representation");
        }
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        this.name.writeToStream(dataOutputStream);
        dataOutputStream.writeShort(this.type.getValue());
        dataOutputStream.writeShort(this.clazzValue);
        dataOutputStream.writeInt((int) this.ttl);
        dataOutputStream.writeShort(this.payloadData.length());
        this.payloadData.toOutputStream(dataOutputStream);
    }

    byte[] toByteArray() {
        if (this.bytes == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(this.name.size() + 10 + this.payloadData.length());
            try {
                toOutputStream(new DataOutputStream(byteArrayOutputStream));
                this.bytes = byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }
        return (byte[]) this.bytes.clone();
    }

    public String toString() {
        return this.name.getRawAce() + ".\t" + this.ttl + '\t' + this.clazz + '\t' + this.type + '\t' + this.payloadData;
    }

    boolean isAnswer(Request request) {
        Class r0;
        return request.type == this.type && ((r0 = request.clazz) == this.clazz || r0 == Class.ANY) && request.name.equals(this.name);
    }

    D getPayload() {
        return (D) this.payloadData;
    }

    public int hashCode() {
        if (this.hashCodeCache == null) {
            this.hashCodeCache = Integer.valueOf(((((((this.name.hashCode() + 37) * 37) + this.type.hashCode()) * 37) + this.clazz.hashCode()) * 37) + this.payloadData.hashCode());
        }
        return this.hashCodeCache.intValue();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Record)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        Record record = (Record) obj;
        return this.name.equals(record.name) && this.type == record.type && this.clazz == record.clazz && this.payloadData.equals(record.payloadData);
    }

    private Record ifPossibleAs(java.lang.Class cls) {
        if (this.type.dataClass == cls) {
            return this;
        }
        return null;
    }

    public <E extends Data> Record<E> as(java.lang.Class<E> cls) {
        Record<E> recordIfPossibleAs = ifPossibleAs(cls);
        if (recordIfPossibleAs != null) {
            return recordIfPossibleAs;
        }
        throw new IllegalArgumentException("The instance " + this + " can not be cast to a Record with" + cls);
    }
}
