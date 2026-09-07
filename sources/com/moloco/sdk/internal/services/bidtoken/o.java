package com.moloco.sdk.internal.services.bidtoken;

import com.moloco.sdk.BidToken;

/* JADX INFO: loaded from: classes5.dex */
public interface o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6327a = a.f6328a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f6328a = new a();

        public final o a() {
            com.moloco.sdk.service_locator.a.e eVar = com.moloco.sdk.service_locator.a.e.f6462a;
            return new p(eVar.f(), eVar.g());
        }
    }

    BidToken.ClientBidToken a(byte[] bArr);

    BidToken.ClientBidTokenComponents a(com.moloco.sdk.internal.services.bidtoken.providers.k kVar, f fVar);

    byte[] a(byte[] bArr, byte[] bArr2);

    BidToken.ClientBidTokenComponents b(byte[] bArr);
}
