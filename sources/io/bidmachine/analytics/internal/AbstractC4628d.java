package io.bidmachine.analytics.internal;

import io.bidmachine.analytics.ReaderConfig;
import java.io.File;
import java.io.FileNotFoundException;
import kotlin.coroutines.Continuation;

/* JADX INFO: renamed from: io.bidmachine.analytics.internal.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public abstract class AbstractC4628d extends AbstractC4633i {
    public abstract File a(ReaderConfig.Rule rule);

    @Override // io.bidmachine.analytics.internal.AbstractC4633i
    public Object a(ReaderConfig.Rule rule, Continuation continuation) {
        return a(this, rule, continuation);
    }

    static /* synthetic */ Object a(AbstractC4628d abstractC4628d, ReaderConfig.Rule rule, Continuation continuation) throws FileNotFoundException {
        File fileA = abstractC4628d.a(rule);
        if (fileA.exists()) {
            return new StringBuilder().append(fileA.lastModified()).append('_').append(fileA.length()).toString();
        }
        throw new FileNotFoundException();
    }
}
