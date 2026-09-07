package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.jh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4219jh implements Mm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C4361p9 f11620a;
    public final /* synthetic */ C4294mh b;

    public C4219jh(C4294mh c4294mh, C4361p9 c4361p9) {
        this.b = c4294mh;
        this.f11620a = c4361p9;
    }

    @Override // io.appmetrica.analytics.impl.Mm
    public final void a(Object obj) {
        List list = (List) obj;
        C4361p9 c4361p9 = this.f11620a;
        if (In.a((Collection) list)) {
            return;
        }
        c4361p9.d = new C4311n9[list.size()];
        for (int i = 0; i < list.size(); i++) {
            Kk kk = (Kk) list.get(i);
            C4311n9[] c4311n9Arr = c4361p9.d;
            Map map = Cf.f11090a;
            C4311n9 c4311n9 = new C4311n9();
            Integer num = kk.f11229a;
            if (num != null) {
                c4311n9.f11683a = num.intValue();
            }
            Integer num2 = kk.b;
            if (num2 != null) {
                c4311n9.b = num2.intValue();
            }
            if (!TextUtils.isEmpty(kk.d)) {
                c4311n9.c = kk.d;
            }
            c4311n9.d = kk.c;
            c4311n9Arr[i] = c4311n9;
            this.b.g += CodedOutputByteBufferNano.computeMessageSizeNoTag(c4361p9.d[i]);
            this.b.g += CodedOutputByteBufferNano.computeTagSize(10);
        }
    }
}
