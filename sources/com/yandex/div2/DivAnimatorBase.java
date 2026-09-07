package com.yandex.div2;

import com.yandex.div.json.expressions.Expression;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: DivAnimatorBase.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0006R\u0012\u0010\u0011\u001a\u00020\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000bR\u0012\u0010\u0018\u001a\u00020\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u000bR\u0012\u0010\u001e\u001a\u00020\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0014ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006 À\u0006\u0001"}, d2 = {"Lcom/yandex/div2/DivAnimatorBase;", "", "cancelActions", "", "Lcom/yandex/div2/DivAction;", "getCancelActions", "()Ljava/util/List;", "direction", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivAnimationDirection;", "getDirection", "()Lcom/yandex/div/json/expressions/Expression;", "duration", "", "getDuration", "endActions", "getEndActions", "id", "", "getId", "()Ljava/lang/String;", "interpolator", "Lcom/yandex/div2/DivAnimationInterpolator;", "getInterpolator", "repeatCount", "Lcom/yandex/div2/DivCount;", "getRepeatCount", "()Lcom/yandex/div2/DivCount;", "startDelay", "getStartDelay", "variableName", "getVariableName", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface DivAnimatorBase {
    List<DivAction> getCancelActions();

    Expression<DivAnimationDirection> getDirection();

    Expression<Long> getDuration();

    List<DivAction> getEndActions();

    String getId();

    Expression<DivAnimationInterpolator> getInterpolator();

    DivCount getRepeatCount();

    Expression<Long> getStartDelay();

    String getVariableName();
}
