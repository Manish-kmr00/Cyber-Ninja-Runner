package com.yandex.div.core.dagger;

import com.yandex.div.core.experiments.Experiment;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Qualifier;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: compiled from: ExperimentFlag.kt */
/* JADX INFO: loaded from: classes9.dex */
@Qualifier
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/core/dagger/ExperimentFlag;", "", "experiment", "Lcom/yandex/div/core/experiments/Experiment;", "()Lcom/yandex/div/core/experiments/Experiment;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Retention(RetentionPolicy.RUNTIME)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
public @interface ExperimentFlag {
    Experiment experiment();
}
