package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.qm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4399qm extends AbstractC4473tm {
    @Override // io.appmetrica.analytics.impl.AbstractC4473tm
    public final ProtobufStateStorage a(Context context, IBinaryDataHelper iBinaryDataHelper) {
        byte[] bArrA;
        byte[] bArrA2;
        S3 s3 = new S3();
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
        return new C4616zf("clids_info", iBinaryDataHelper, new F8(s3, new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, bArrA, bArrA2)), new N3());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC4473tm
    public final IBinaryDataHelper c(Context context) {
        C4305n3 c4305n3;
        C4135g7 c4135g7A = C4135g7.a(context);
        synchronized (c4135g7A) {
            if (c4135g7A.i == null) {
                c4135g7A.i = new C4305n3(c4135g7A.g());
            }
            c4305n3 = c4135g7A.i;
        }
        return c4305n3;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC4473tm
    public final IBinaryDataHelper d(Context context) {
        IBinaryDataHelper iBinaryDataHelperG;
        C4135g7 c4135g7A = C4135g7.a(context);
        synchronized (c4135g7A) {
            iBinaryDataHelperG = c4135g7A.g();
        }
        return iBinaryDataHelperG;
    }
}
