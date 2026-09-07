package com.yandex.div.storage;

import android.content.Context;
import com.vungle.ads.internal.protos.Sdk;
import com.yandex.div.histogram.DivParsingHistogramReporter;
import com.yandex.div.histogram.reporter.HistogramReporterDelegate;
import com.yandex.div.json.ParsingErrorLogger;
import com.yandex.div.storage.analytics.CardErrorLoggerFactory;
import com.yandex.div.storage.database.AndroidDatabaseOpenHelper;
import com.yandex.div.storage.database.DatabaseOpenHelper;
import com.yandex.div.storage.database.DatabaseOpenHelperProvider;
import com.yandex.div.storage.histogram.HistogramNameProvider;
import com.yandex.div.storage.histogram.HistogramRecorder;
import com.yandex.div.storage.templates.DivParsingHistogramProxy;
import com.yandex.div.storage.templates.TemplatesContainer;
import com.yandex.div.storage.util.CardErrorTransformer;
import com.yandex.div.storage.util.LazyProvider;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivStorageComponent.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/storage/DivStorageComponent;", "", "rawJsonRepository", "Lcom/yandex/div/storage/RawJsonRepository;", "getRawJsonRepository", "()Lcom/yandex/div/storage/RawJsonRepository;", "repository", "Lcom/yandex/div/storage/DivDataRepository;", "getRepository", "()Lcom/yandex/div/storage/DivDataRepository;", "Companion", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface DivStorageComponent {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    RawJsonRepository getRawJsonRepository();

    DivDataRepository getRepository();

    /* JADX INFO: compiled from: DivStorageComponent.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J^\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0012\b\u0002\u0010\r\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000f\u0018\u00010\u000e2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007Jc\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0012\b\u0002\u0010\r\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000f\u0018\u00010\u000e2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/yandex/div/storage/DivStorageComponent$Companion;", "", "()V", "create", "Lcom/yandex/div/storage/DivStorageComponent;", "context", "Landroid/content/Context;", "histogramReporter", "Lcom/yandex/div/histogram/reporter/HistogramReporterDelegate;", "histogramNameProvider", "Lcom/yandex/div/storage/histogram/HistogramNameProvider;", "errorLogger", "Lcom/yandex/div/json/ParsingErrorLogger;", "cardErrorTransformer", "Ljavax/inject/Provider;", "Lcom/yandex/div/storage/util/CardErrorTransformer;", "parsingHistogramReporter", "Lcom/yandex/div/histogram/DivParsingHistogramReporter;", "databaseNamePrefix", "", "createInternal", "Lcom/yandex/div/storage/InternalStorageComponent;", "createInternal$div_storage_release", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        public final DivStorageComponent create(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return create$default(this, context, null, null, null, null, null, null, 126, null);
        }

        public final DivStorageComponent create(Context context, HistogramReporterDelegate histogramReporter) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(histogramReporter, "histogramReporter");
            return create$default(this, context, histogramReporter, null, null, null, null, null, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE, null);
        }

        public final DivStorageComponent create(Context context, HistogramReporterDelegate histogramReporter, HistogramNameProvider histogramNameProvider) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(histogramReporter, "histogramReporter");
            return create$default(this, context, histogramReporter, histogramNameProvider, null, null, null, null, 120, null);
        }

        public final DivStorageComponent create(Context context, HistogramReporterDelegate histogramReporter, HistogramNameProvider histogramNameProvider, ParsingErrorLogger errorLogger) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(histogramReporter, "histogramReporter");
            Intrinsics.checkNotNullParameter(errorLogger, "errorLogger");
            return create$default(this, context, histogramReporter, histogramNameProvider, errorLogger, null, null, null, 112, null);
        }

        public final DivStorageComponent create(Context context, HistogramReporterDelegate histogramReporter, HistogramNameProvider histogramNameProvider, ParsingErrorLogger errorLogger, Provider<? extends CardErrorTransformer> provider) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(histogramReporter, "histogramReporter");
            Intrinsics.checkNotNullParameter(errorLogger, "errorLogger");
            return create$default(this, context, histogramReporter, histogramNameProvider, errorLogger, provider, null, null, 96, null);
        }

        public final DivStorageComponent create(Context context, HistogramReporterDelegate histogramReporter, HistogramNameProvider histogramNameProvider, ParsingErrorLogger errorLogger, Provider<? extends CardErrorTransformer> provider, Provider<DivParsingHistogramReporter> parsingHistogramReporter) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(histogramReporter, "histogramReporter");
            Intrinsics.checkNotNullParameter(errorLogger, "errorLogger");
            Intrinsics.checkNotNullParameter(parsingHistogramReporter, "parsingHistogramReporter");
            return create$default(this, context, histogramReporter, histogramNameProvider, errorLogger, provider, parsingHistogramReporter, null, 64, null);
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DivStorageComponent create$default(Companion companion, Context context, HistogramReporterDelegate histogramReporterDelegate, HistogramNameProvider histogramNameProvider, ParsingErrorLogger parsingErrorLogger, Provider provider, Provider provider2, String str, int i, Object obj) {
            ParsingErrorLogger LOG;
            HistogramReporterDelegate.NoOp noOp = (i & 2) != 0 ? HistogramReporterDelegate.NoOp.INSTANCE : histogramReporterDelegate;
            HistogramNameProvider histogramNameProvider2 = (i & 4) != 0 ? null : histogramNameProvider;
            if ((i & 8) != 0) {
                LOG = ParsingErrorLogger.LOG;
                Intrinsics.checkNotNullExpressionValue(LOG, "LOG");
            } else {
                LOG = parsingErrorLogger;
            }
            return companion.create(context, noOp, histogramNameProvider2, LOG, (i & 16) == 0 ? provider : null, (i & 32) != 0 ? new LazyProvider(new Function0<DivParsingHistogramReporter>() { // from class: com.yandex.div.storage.DivStorageComponent$Companion$create$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final DivParsingHistogramReporter invoke() {
                    return DivParsingHistogramReporter.INSTANCE.getDEFAULT();
                }
            }) : provider2, (i & 64) != 0 ? "" : str);
        }

        public final DivStorageComponent create(Context context, HistogramReporterDelegate histogramReporter, HistogramNameProvider histogramNameProvider, ParsingErrorLogger errorLogger, Provider<? extends CardErrorTransformer> cardErrorTransformer, Provider<DivParsingHistogramReporter> parsingHistogramReporter, String databaseNamePrefix) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(histogramReporter, "histogramReporter");
            Intrinsics.checkNotNullParameter(errorLogger, "errorLogger");
            Intrinsics.checkNotNullParameter(parsingHistogramReporter, "parsingHistogramReporter");
            Intrinsics.checkNotNullParameter(databaseNamePrefix, "databaseNamePrefix");
            return createInternal$div_storage_release(context, histogramReporter, histogramNameProvider, errorLogger, cardErrorTransformer, parsingHistogramReporter, databaseNamePrefix);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ InternalStorageComponent createInternal$div_storage_release$default(Companion companion, Context context, HistogramReporterDelegate histogramReporterDelegate, HistogramNameProvider histogramNameProvider, ParsingErrorLogger parsingErrorLogger, Provider provider, Provider provider2, String str, int i, Object obj) {
            ParsingErrorLogger LOG;
            HistogramReporterDelegate.NoOp noOp = (i & 2) != 0 ? HistogramReporterDelegate.NoOp.INSTANCE : histogramReporterDelegate;
            HistogramNameProvider histogramNameProvider2 = (i & 4) != 0 ? null : histogramNameProvider;
            if ((i & 8) != 0) {
                LOG = ParsingErrorLogger.LOG;
                Intrinsics.checkNotNullExpressionValue(LOG, "LOG");
            } else {
                LOG = parsingErrorLogger;
            }
            return companion.createInternal$div_storage_release(context, noOp, histogramNameProvider2, LOG, (i & 16) == 0 ? provider : null, (i & 32) != 0 ? new LazyProvider(new Function0<DivParsingHistogramReporter>() { // from class: com.yandex.div.storage.DivStorageComponent$Companion$createInternal$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final DivParsingHistogramReporter invoke() {
                    return DivParsingHistogramReporter.INSTANCE.getDEFAULT();
                }
            }) : provider2, (i & 64) != 0 ? "" : str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final DatabaseOpenHelper createInternal$lambda$0(Context c, String name, int i, DatabaseOpenHelper.CreateCallback ccb, DatabaseOpenHelper.UpgradeCallback ucb) {
            Intrinsics.checkNotNullParameter(c, "c");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(ccb, "ccb");
            Intrinsics.checkNotNullParameter(ucb, "ucb");
            return new AndroidDatabaseOpenHelper(c, name, i, ccb, ucb);
        }

        public final InternalStorageComponent createInternal$div_storage_release(Context context, HistogramReporterDelegate histogramReporter, HistogramNameProvider histogramNameProvider, ParsingErrorLogger errorLogger, Provider<? extends CardErrorTransformer> cardErrorTransformer, final Provider<DivParsingHistogramReporter> parsingHistogramReporter, String databaseNamePrefix) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(histogramReporter, "histogramReporter");
            Intrinsics.checkNotNullParameter(errorLogger, "errorLogger");
            Intrinsics.checkNotNullParameter(parsingHistogramReporter, "parsingHistogramReporter");
            Intrinsics.checkNotNullParameter(databaseNamePrefix, "databaseNamePrefix");
            DivStorageImpl divStorageImpl = new DivStorageImpl(context, new DatabaseOpenHelperProvider() { // from class: com.yandex.div.storage.DivStorageComponent$Companion$$ExternalSyntheticLambda0
                @Override // com.yandex.div.storage.database.DatabaseOpenHelperProvider
                public final DatabaseOpenHelper provide(Context context2, String str, int i, DatabaseOpenHelper.CreateCallback createCallback, DatabaseOpenHelper.UpgradeCallback upgradeCallback) {
                    return DivStorageComponent.Companion.createInternal$lambda$0(context2, str, i, createCallback, upgradeCallback);
                }
            }, databaseNamePrefix);
            LazyProvider lazyProvider = new LazyProvider(new Function0<DivParsingHistogramProxy>() { // from class: com.yandex.div.storage.DivStorageComponent$Companion$createInternal$parsingHistogramProxy$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final DivParsingHistogramProxy invoke() {
                    final Provider<DivParsingHistogramReporter> provider = parsingHistogramReporter;
                    return new DivParsingHistogramProxy(new Function0<DivParsingHistogramReporter>() { // from class: com.yandex.div.storage.DivStorageComponent$Companion$createInternal$parsingHistogramProxy$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final DivParsingHistogramReporter invoke() {
                            DivParsingHistogramReporter divParsingHistogramReporter = provider.get();
                            Intrinsics.checkNotNullExpressionValue(divParsingHistogramReporter, "parsingHistogramReporter.get()");
                            return divParsingHistogramReporter;
                        }
                    });
                }
            });
            HistogramRecorder histogramRecorder = new HistogramRecorder(histogramReporter, histogramNameProvider);
            DivStorageImpl divStorageImpl2 = divStorageImpl;
            LazyProvider lazyProvider2 = lazyProvider;
            TemplatesContainer templatesContainer = new TemplatesContainer(divStorageImpl2, errorLogger, histogramRecorder, lazyProvider2, histogramNameProvider);
            return new InternalStorageComponent(new DivDataRepositoryImpl(divStorageImpl2, templatesContainer, histogramRecorder, histogramNameProvider, lazyProvider2, new CardErrorLoggerFactory(cardErrorTransformer, templatesContainer, errorLogger)), new RawJsonRepositoryImpl(divStorageImpl2), divStorageImpl2);
        }
    }
}
