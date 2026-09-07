package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.pm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4374pm extends AbstractC4473tm {
    @Override // io.appmetrica.analytics.impl.AbstractC4473tm
    public final ProtobufStateStorage a(Context context, IBinaryDataHelper iBinaryDataHelper) {
        byte[] bArrA;
        byte[] bArrA2;
        C4578y2 c4578y2 = new C4578y2();
        try {
            bArrA = Wi.a(context.getPackageName());
        } catch (Throwable unused) {
            bArrA = new byte[16];
        }
        try {
            bArrA2 = Wi.a(new StringBuilder(context.getPackageName()).reverse().toString());
        } catch (Throwable unused2) {
            bArrA2 = new byte[16];
        }
        return new C4616zf("auto_inapp_collecting_info_data", iBinaryDataHelper, new F8(c4578y2, new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, bArrA, bArrA2)), new C4503v2(new C4081e3()));
    }

    @Override // io.appmetrica.analytics.impl.AbstractC4473tm
    public final IBinaryDataHelper c(Context context) {
        C4305n3 c4305n3;
        C4135g7 c4135g7A = C4135g7.a(context);
        synchronized (c4135g7A) {
            if (c4135g7A.k == null) {
                c4135g7A.k = new C4305n3(c4135g7A.e());
            }
            c4305n3 = c4135g7A.k;
        }
        return c4305n3;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC4473tm
    public final IBinaryDataHelper d(Context context) {
        IBinaryDataHelper iBinaryDataHelperE;
        C4135g7 c4135g7A = C4135g7.a(context);
        synchronized (c4135g7A) {
            iBinaryDataHelperE = c4135g7A.e();
        }
        return iBinaryDataHelperE;
    }
}
