package com.smaato.sdk.core.log;

import com.smaato.sdk.core.di.ClassFactory;
import com.smaato.sdk.core.di.DiConstructor;
import com.smaato.sdk.core.di.DiRegistry;
import com.smaato.sdk.core.util.fi.Consumer;

/* JADX INFO: loaded from: classes12.dex */
public final class DiLogLayer {
    private static final Logger EMPTY = new EmptyLogger();

    public static DiRegistry createRegistry(final boolean z, final LogLevel logLevel) {
        return DiRegistry.of(new Consumer() { // from class: com.smaato.sdk.core.log.DiLogLayer$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((DiRegistry) obj).registerSingletonFactory(Logger.class, new ClassFactory() { // from class: com.smaato.sdk.core.log.DiLogLayer$$ExternalSyntheticLambda0
                    @Override // com.smaato.sdk.core.di.ClassFactory
                    /* JADX INFO: renamed from: get */
                    public final Object get2(DiConstructor diConstructor) {
                        return DiLogLayer.lambda$createRegistry$0(z, logLevel, diConstructor);
                    }
                });
            }
        });
    }

    static /* synthetic */ Logger lambda$createRegistry$0(boolean z, LogLevel logLevel, DiConstructor diConstructor) {
        if (z) {
            LoggerFactory.initializeLogger(logLevel);
            return LoggerFactory.getLogger();
        }
        return EMPTY;
    }

    public static Logger getLoggerFrom(DiConstructor diConstructor) {
        return (Logger) diConstructor.get(Logger.class);
    }
}
