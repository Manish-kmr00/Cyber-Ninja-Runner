package com.smaato.sdk.core.errorreport;

import com.smaato.sdk.core.remoteconfig.publisher.Param;
import com.smaato.sdk.core.util.collections.Lists;
import com.smaato.sdk.core.util.collections.Maps;
import com.smaato.sdk.core.util.fi.Function;
import com.smaato.sdk.core.util.fi.Predicate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: classes9.dex */
public final class Report {
    public static final Report EMPTY = new Report(Collections.emptyList(), 0);
    private final List params;
    private final Random random = new Random();
    private final int sampleRate;

    public Report(List<Param> list, int i) {
        this.params = Lists.toImmutableList((Collection) list);
        this.sampleRate = i;
    }

    public boolean canBeSent() {
        int i;
        if (!this.params.isEmpty() && (i = this.sampleRate) > 0) {
            return i >= 100 || i >= this.random.nextInt(100) + 1;
        }
        return false;
    }

    public Map<String, String> toQuery() {
        return Maps.toMap(Lists.filter(this.params, new Predicate() { // from class: com.smaato.sdk.core.errorreport.Report$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Predicate
            public final boolean test(Object obj) {
                return Report.lambda$toQuery$0((Param) obj);
            }
        }), new Function() { // from class: com.smaato.sdk.core.errorreport.Report$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Function
            public final Object apply(Object obj) {
                return ((Param) obj).getName();
            }
        }, new Function() { // from class: com.smaato.sdk.core.errorreport.Report$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.Function
            public final Object apply(Object obj) {
                return String.valueOf(((Param) obj).getValue());
            }
        });
    }

    static /* synthetic */ boolean lambda$toQuery$0(Param param) {
        return param.getValue() != null;
    }
}
