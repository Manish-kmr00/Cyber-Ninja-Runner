package com.smaato.sdk.core.dns;

import com.smaato.sdk.core.di.ClassFactory;
import com.smaato.sdk.core.di.DiConstructor;
import com.smaato.sdk.core.di.DiRegistry;
import com.smaato.sdk.core.util.collections.Sets;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.core.util.fi.Supplier;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class DiDns {
    private static final Set DNS_SERVERS = Sets.of(InetAddressUtil.ipv4From("8.8.8.8"), InetAddressUtil.ipv6From("[2001:4860:4860::8888]"));

    public static DiRegistry createRegistry() {
        return DiRegistry.of(new Consumer() { // from class: com.smaato.sdk.core.dns.DiDns$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                DiDns.lambda$createRegistry$4((DiRegistry) obj);
            }
        });
    }

    static /* synthetic */ void lambda$createRegistry$4(DiRegistry diRegistry) {
        diRegistry.registerFactory(DnsResolver.class, new ClassFactory() { // from class: com.smaato.sdk.core.dns.DiDns$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiDns.lambda$createRegistry$0(diConstructor);
            }
        });
        diRegistry.registerFactory(DnsClient.class, new ClassFactory() { // from class: com.smaato.sdk.core.dns.DiDns$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiDns.lambda$createRegistry$2(diConstructor);
            }
        });
        diRegistry.registerFactory(DnsDataSource.class, new ClassFactory() { // from class: com.smaato.sdk.core.dns.DiDns$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiDns.lambda$createRegistry$3(diConstructor);
            }
        });
    }

    static /* synthetic */ DnsResolver lambda$createRegistry$0(DiConstructor diConstructor) {
        return new DnsResolver((DnsClient) diConstructor.get(DnsClient.class));
    }

    static /* synthetic */ DnsClient lambda$createRegistry$2(DiConstructor diConstructor) {
        return new DnsClient((DnsDataSource) diConstructor.get(DnsDataSource.class), new Supplier() { // from class: com.smaato.sdk.core.dns.DiDns$$ExternalSyntheticLambda4
            @Override // com.smaato.sdk.core.util.fi.Supplier
            public final Object get() {
                return Integer.valueOf(DiDns.IdGenerator.generateViewId());
            }
        }, DNS_SERVERS);
    }

    static /* synthetic */ DnsDataSource lambda$createRegistry$3(DiConstructor diConstructor) {
        return new DnsDataSource();
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class IdGenerator {
        private static final AtomicInteger nextGeneratedId = new AtomicInteger(1);

        /* JADX INFO: Access modifiers changed from: private */
        public static int generateViewId() {
            AtomicInteger atomicInteger;
            int i;
            int i2;
            do {
                atomicInteger = nextGeneratedId;
                i = atomicInteger.get();
                i2 = i + 1;
                if (i2 > 16777215) {
                    i2 = 1;
                }
            } while (!atomicInteger.compareAndSet(i, i2));
            return i;
        }
    }
}
