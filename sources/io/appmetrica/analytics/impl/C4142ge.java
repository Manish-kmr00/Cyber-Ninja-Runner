package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.ge, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4142ge implements InterfaceC4161h8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4216je f11569a;
    public final D3 b;
    public final C4611za c;
    public final C4541wf d;

    public C4142ge() {
        this(new C4216je(), new D3(), new C4611za(100), new C4541wf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final List<C4469ti> fromModel(C4117fe c4117fe) {
        C4469ti c4469tiFromModel;
        A8 a8 = new A8();
        a8.f11056a = c4117fe.f11550a;
        a8.f = new C4360p8();
        C4167he c4167he = c4117fe.b;
        C4310n8 c4310n8 = new C4310n8();
        c4310n8.f11682a = StringUtils.getUTF8Bytes(c4167he.f11585a);
        C4225jn c4225jnA = this.c.a(c4167he.b);
        c4310n8.b = StringUtils.getUTF8Bytes((String) c4225jnA.f11624a);
        c4310n8.e = c4167he.c.size();
        Map<String, String> map = c4167he.d;
        if (map != null) {
            c4469tiFromModel = this.f11569a.fromModel(map);
            c4310n8.c = (C4409r8) c4469tiFromModel.f11783a;
        } else {
            c4469tiFromModel = null;
        }
        a8.f.f11716a = c4310n8;
        C4479u3 c4479u3 = new C4479u3(C4479u3.b(c4225jnA, c4469tiFromModel));
        List list = c4167he.c;
        ArrayList arrayList = new ArrayList();
        this.d.getClass();
        int iComputeInt32Size = a8.f11056a != new A8().f11056a ? CodedOutputByteBufferNano.computeInt32Size(1, a8.f11056a) : 0;
        C4609z8 c4609z8 = a8.b;
        if (c4609z8 != null) {
            iComputeInt32Size += CodedOutputByteBufferNano.computeMessageSize(2, c4609z8);
        }
        C4559x8 c4559x8 = a8.c;
        if (c4559x8 != null) {
            iComputeInt32Size += CodedOutputByteBufferNano.computeMessageSize(3, c4559x8);
        }
        C4584y8 c4584y8 = a8.d;
        int i = 4;
        if (c4584y8 != null) {
            iComputeInt32Size += CodedOutputByteBufferNano.computeMessageSize(4, c4584y8);
        }
        C4210j8 c4210j8 = a8.e;
        if (c4210j8 != null) {
            iComputeInt32Size += CodedOutputByteBufferNano.computeMessageSize(5, c4210j8);
        }
        C4360p8 c4360p8 = a8.f;
        if (c4360p8 != null) {
            iComputeInt32Size += CodedOutputByteBufferNano.computeMessageSize(6, c4360p8);
        }
        ArrayList arrayList2 = new ArrayList();
        A8 a9 = new A8();
        a9.f11056a = a8.f11056a;
        C4360p8 c4360p9 = new C4360p8();
        a9.f = c4360p9;
        c4360p9.f11716a = new C4310n8();
        C4310n8 c4310n9 = a9.f.f11716a;
        C4310n8 c4310n10 = a8.f.f11716a;
        c4310n9.b = c4310n10.b;
        c4310n9.f11682a = c4310n10.f11682a;
        c4310n9.e = c4310n10.e;
        c4310n9.c = c4310n10.c;
        C4479u3 c4479u4 = c4479u3;
        int i2 = 0;
        int i3 = iComputeInt32Size;
        while (i2 < list.size()) {
            E3 e3 = (E3) list.get(i2);
            C4335o8 c4335o8 = new C4335o8();
            c4335o8.f11699a = i2;
            C4469ti c4469tiFromModel2 = this.b.fromModel(e3);
            c4335o8.b = (C4235k8) c4469tiFromModel2.f11783a;
            c4469tiFromModel2.b.getBytesTruncated();
            C4469ti c4469ti = new C4469ti(c4335o8, c4469tiFromModel2);
            C4541wf c4541wf = this.d;
            C4335o8 c4335o9 = (C4335o8) c4469ti.f11783a;
            c4541wf.getClass();
            int iComputeTagSize = CodedOutputByteBufferNano.computeTagSize(i);
            int iComputeMessageSizeNoTag = CodedOutputByteBufferNano.computeMessageSizeNoTag(c4335o9);
            int iComputeRawVarint32Size = iComputeTagSize + iComputeMessageSizeNoTag + ((iComputeMessageSizeNoTag & (-128)) == 0 ? 0 : CodedOutputByteBufferNano.computeRawVarint32Size(iComputeMessageSizeNoTag));
            if (arrayList2.size() != 0 && i3 + iComputeRawVarint32Size > 204800) {
                a9.f.f11716a.d = (C4335o8[]) arrayList2.toArray(new C4335o8[arrayList2.size()]);
                ArrayList arrayList3 = new ArrayList();
                arrayList.add(new C4469ti(a9, c4479u4));
                A8 a10 = new A8();
                a10.f11056a = a8.f11056a;
                C4360p8 c4360p10 = new C4360p8();
                a10.f = c4360p10;
                c4360p10.f11716a = new C4310n8();
                C4310n8 c4310n11 = a10.f.f11716a;
                C4310n8 c4310n12 = a8.f.f11716a;
                c4310n11.b = c4310n12.b;
                c4310n11.f11682a = c4310n12.f11682a;
                c4310n11.e = c4310n12.e;
                c4310n11.c = c4310n12.c;
                c4479u4 = c4479u3;
                i3 = iComputeInt32Size;
                a9 = a10;
                arrayList2 = arrayList3;
            }
            arrayList2.add((C4335o8) c4469ti.f11783a);
            c4479u4 = new C4479u3(C4479u3.b(c4479u4, c4469ti.b));
            i3 += iComputeRawVarint32Size;
            i2++;
            i = 4;
        }
        a9.f.f11716a.d = (C4335o8[]) arrayList2.toArray(new C4335o8[arrayList2.size()]);
        arrayList.add(new C4469ti(a9, c4479u4));
        return arrayList;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public C4142ge(C4216je c4216je, D3 d3, C4611za c4611za, C4541wf c4541wf) {
        this.f11569a = c4216je;
        this.b = d3;
        this.c = c4611za;
        this.d = c4541wf;
    }

    public final C4117fe a(List<C4469ti> list) {
        throw new UnsupportedOperationException();
    }
}
