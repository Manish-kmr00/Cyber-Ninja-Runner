package com.yandex.div.storage.database;

import com.yandex.div.storage.DivDataRepository;
import com.yandex.div.storage.RawDataAndMetadata;
import com.yandex.div.storage.rawjson.RawJson;
import com.yandex.div.storage.templates.Template;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SingleTransactionDataSavePerformer.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0016\u0010\f\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\nH\u0002J1\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u001d\u0010\u0013\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0015\u0012\u0004\u0012\u00020\u00160\u0014¢\u0006\u0002\b\u0017H\u0002J2\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\n2\u0006\u0010\u0011\u001a\u00020\u0012J\u001c\u0010\u001b\u001a\u00020\u00102\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\n2\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/yandex/div/storage/database/SingleTransactionDataSavePerformer;", "", "storageStatementsExecutor", "Lcom/yandex/div/storage/database/StorageStatementExecutor;", "(Lcom/yandex/div/storage/database/StorageStatementExecutor;)V", "createCardsSaveStatement", "Lcom/yandex/div/storage/database/StorageStatement;", "groupId", "", StorageSchema.TABLE_CARDS, "", "Lcom/yandex/div/storage/RawDataAndMetadata;", "createRawJsonsSaveStatement", "rawJsons", "Lcom/yandex/div/storage/rawjson/RawJson;", "executeStatements", "Lcom/yandex/div/storage/database/ExecutionResult;", "actionOnError", "Lcom/yandex/div/storage/DivDataRepository$ActionOnError;", "statementsBuilder", "Lkotlin/Function1;", "", "", "Lkotlin/ExtensionFunctionType;", "saveDivData", "templatesByHash", "Lcom/yandex/div/storage/templates/Template;", "saveRawJsons", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SingleTransactionDataSavePerformer {
    private final StorageStatementExecutor storageStatementsExecutor;

    @Inject
    public SingleTransactionDataSavePerformer(StorageStatementExecutor storageStatementsExecutor) {
        Intrinsics.checkNotNullParameter(storageStatementsExecutor, "storageStatementsExecutor");
        this.storageStatementsExecutor = storageStatementsExecutor;
    }

    public final ExecutionResult saveDivData(final String groupId, final List<? extends RawDataAndMetadata> cards, final List<Template> templatesByHash, DivDataRepository.ActionOnError actionOnError) throws IOException {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(cards, "cards");
        Intrinsics.checkNotNullParameter(templatesByHash, "templatesByHash");
        Intrinsics.checkNotNullParameter(actionOnError, "actionOnError");
        return executeStatements(actionOnError, new Function1<List<StorageStatement>, Unit>() { // from class: com.yandex.div.storage.database.SingleTransactionDataSavePerformer.saveDivData.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<StorageStatement> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<StorageStatement> executeStatements) {
                Intrinsics.checkNotNullParameter(executeStatements, "$this$executeStatements");
                executeStatements.add(StorageStatements.INSTANCE.writeTemplatesUsages(groupId, templatesByHash));
                executeStatements.add(this.createCardsSaveStatement(groupId, cards));
                executeStatements.add(StorageStatements.INSTANCE.writeTemplates(templatesByHash));
                executeStatements.add(StorageStatements.INSTANCE.deleteTemplatesWithoutLinksToCards());
            }
        });
    }

    public final ExecutionResult saveRawJsons(final List<? extends RawJson> rawJsons, DivDataRepository.ActionOnError actionOnError) throws IOException {
        Intrinsics.checkNotNullParameter(rawJsons, "rawJsons");
        Intrinsics.checkNotNullParameter(actionOnError, "actionOnError");
        return executeStatements(actionOnError, new Function1<List<StorageStatement>, Unit>() { // from class: com.yandex.div.storage.database.SingleTransactionDataSavePerformer.saveRawJsons.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<StorageStatement> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<StorageStatement> executeStatements) {
                Intrinsics.checkNotNullParameter(executeStatements, "$this$executeStatements");
                executeStatements.add(SingleTransactionDataSavePerformer.this.createRawJsonsSaveStatement(rawJsons));
            }
        });
    }

    static /* synthetic */ ExecutionResult executeStatements$default(SingleTransactionDataSavePerformer singleTransactionDataSavePerformer, DivDataRepository.ActionOnError actionOnError, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            actionOnError = DivDataRepository.ActionOnError.ABORT_TRANSACTION;
        }
        return singleTransactionDataSavePerformer.executeStatements(actionOnError, function1);
    }

    private final ExecutionResult executeStatements(DivDataRepository.ActionOnError actionOnError, Function1<? super List<StorageStatement>, Unit> statementsBuilder) {
        ArrayList arrayList = new ArrayList();
        statementsBuilder.invoke(arrayList);
        StorageStatementExecutor storageStatementExecutor = this.storageStatementsExecutor;
        StorageStatement[] storageStatementArr = (StorageStatement[]) arrayList.toArray(new StorageStatement[0]);
        return storageStatementExecutor.execute(actionOnError, (StorageStatement[]) Arrays.copyOf(storageStatementArr, storageStatementArr.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StorageStatement createCardsSaveStatement(String groupId, List<? extends RawDataAndMetadata> cards) {
        return StorageStatements.replaceCards$default(StorageStatements.INSTANCE, groupId, cards, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StorageStatement createRawJsonsSaveStatement(List<? extends RawJson> rawJsons) {
        return StorageStatements.replaceRawJsons$default(StorageStatements.INSTANCE, rawJsons, null, 2, null);
    }
}
