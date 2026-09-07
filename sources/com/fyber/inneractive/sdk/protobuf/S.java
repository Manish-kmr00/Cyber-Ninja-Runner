package com.fyber.inneractive.sdk.protobuf;

/* JADX INFO: loaded from: classes13.dex */
public final class S implements C0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final S f2267a = new S();

    @Override // com.fyber.inneractive.sdk.protobuf.C0
    public final boolean a(Class cls) {
        return AbstractC3169a0.class.isAssignableFrom(cls);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.C0
    public final S0 b(Class cls) {
        if (!AbstractC3169a0.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
        try {
            return (S0) AbstractC3169a0.getDefaultInstance(cls.asSubclass(AbstractC3169a0.class)).buildMessageInfo();
        } catch (Exception e) {
            throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e);
        }
    }
}
