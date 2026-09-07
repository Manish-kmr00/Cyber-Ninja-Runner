package io.appmetrica.analytics.impl;

import com.json.mediationsdk.utils.IronSourceConstants;
import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.h9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C4162h9 extends MessageNano {
    public static volatile C4162h9[] n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f11582a;
    public String b;
    public String c;
    public int d;
    public String e;
    public String f;
    public boolean g;
    public int h;
    public String i;
    public String j;
    public int k;
    public C4137g9[] l;
    public String m;

    public C4162h9() {
        a();
    }

    public static C4162h9[] b() {
        if (n == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (n == null) {
                    n = new C4162h9[0];
                }
            }
        }
        return n;
    }

    public final C4162h9 a() {
        this.f11582a = "";
        this.b = "";
        this.c = "";
        this.d = 0;
        this.e = "";
        this.f = "";
        this.g = false;
        this.h = 0;
        this.i = "";
        this.j = "";
        this.k = 0;
        this.l = C4137g9.b();
        this.m = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.f11582a.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f11582a);
        }
        if (!this.b.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.b);
        }
        if (!this.c.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.c);
        }
        int i = this.d;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i);
        }
        if (!this.e.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.e);
        }
        if (!this.f.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(15, this.f);
        }
        boolean z = this.g;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(17, z);
        }
        int i2 = this.h;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(18, i2);
        }
        if (!this.i.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(19, this.i);
        }
        if (!this.j.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(21, this.j);
        }
        int i3 = this.k;
        if (i3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(22, i3);
        }
        C4137g9[] c4137g9Arr = this.l;
        if (c4137g9Arr != null && c4137g9Arr.length > 0) {
            int i4 = 0;
            while (true) {
                C4137g9[] c4137g9Arr2 = this.l;
                if (i4 >= c4137g9Arr2.length) {
                    break;
                }
                C4137g9 c4137g9 = c4137g9Arr2[i4];
                if (c4137g9 != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(23, c4137g9);
                }
                i4++;
            }
        }
        return !this.m.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(24, this.m) : iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f11582a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f11582a);
        }
        if (!this.b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.b);
        }
        if (!this.c.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.c);
        }
        int i = this.d;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i);
        }
        if (!this.e.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.e);
        }
        if (!this.f.equals("")) {
            codedOutputByteBufferNano.writeString(15, this.f);
        }
        boolean z = this.g;
        if (z) {
            codedOutputByteBufferNano.writeBool(17, z);
        }
        int i2 = this.h;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(18, i2);
        }
        if (!this.i.equals("")) {
            codedOutputByteBufferNano.writeString(19, this.i);
        }
        if (!this.j.equals("")) {
            codedOutputByteBufferNano.writeString(21, this.j);
        }
        int i3 = this.k;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(22, i3);
        }
        C4137g9[] c4137g9Arr = this.l;
        if (c4137g9Arr != null && c4137g9Arr.length > 0) {
            int i4 = 0;
            while (true) {
                C4137g9[] c4137g9Arr2 = this.l;
                if (i4 >= c4137g9Arr2.length) {
                    break;
                }
                C4137g9 c4137g9 = c4137g9Arr2[i4];
                if (c4137g9 != null) {
                    codedOutputByteBufferNano.writeMessage(23, c4137g9);
                }
                i4++;
            }
        }
        if (!this.m.equals("")) {
            codedOutputByteBufferNano.writeString(24, this.m);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static C4162h9 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C4162h9().mergeFrom(codedInputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4162h9 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 10:
                    this.f11582a = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.b = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.c = codedInputByteBufferNano.readString();
                    break;
                case 40:
                    this.d = codedInputByteBufferNano.readUInt32();
                    break;
                case IronSourceConstants.TROUBLESHOOTING_AD_QUALITY_SDK_WAS_ALREADY_INITIALIZED_EVENT /* 82 */:
                    this.e = codedInputByteBufferNano.readString();
                    break;
                case INVALID_ADS_ENDPOINT_VALUE:
                    this.f = codedInputByteBufferNano.readString();
                    break;
                case 136:
                    this.g = codedInputByteBufferNano.readBool();
                    break;
                case 144:
                    this.h = codedInputByteBufferNano.readUInt32();
                    break;
                case 154:
                    this.i = codedInputByteBufferNano.readString();
                    break;
                case 170:
                    this.j = codedInputByteBufferNano.readString();
                    break;
                case 176:
                    this.k = codedInputByteBufferNano.readUInt32();
                    break;
                case 186:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 186);
                    C4137g9[] c4137g9Arr = this.l;
                    int length = c4137g9Arr == null ? 0 : c4137g9Arr.length;
                    int i = repeatedFieldArrayLength + length;
                    C4137g9[] c4137g9Arr2 = new C4137g9[i];
                    if (length != 0) {
                        System.arraycopy(c4137g9Arr, 0, c4137g9Arr2, 0, length);
                    }
                    while (length < i - 1) {
                        C4137g9 c4137g9 = new C4137g9();
                        c4137g9Arr2[length] = c4137g9;
                        codedInputByteBufferNano.readMessage(c4137g9);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    C4137g9 c4137g10 = new C4137g9();
                    c4137g9Arr2[length] = c4137g10;
                    codedInputByteBufferNano.readMessage(c4137g10);
                    this.l = c4137g9Arr2;
                    break;
                case 194:
                    this.m = codedInputByteBufferNano.readString();
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
                    break;
            }
        }
    }

    public static C4162h9 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C4162h9) MessageNano.mergeFrom(new C4162h9(), bArr);
    }
}
