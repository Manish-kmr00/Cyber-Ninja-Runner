package com.moloco.sdk.internal.services.proto;

import com.moloco.sdk.UserIntent;

/* JADX INFO: loaded from: classes12.dex */
public interface a {

    /* JADX INFO: renamed from: com.moloco.sdk.internal.services.proto.a$a, reason: collision with other inner class name */
    public static final class C0562a {
        public static /* synthetic */ String a(a aVar, UserIntent.UserAdInteractionExt userAdInteractionExt, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeUserAdInteractionExt");
            }
            if ((i2 & 2) != 0) {
                i = 10;
            }
            return aVar.a(userAdInteractionExt, i);
        }
    }

    String a(UserIntent.UserAdInteractionExt userAdInteractionExt, int i);
}
