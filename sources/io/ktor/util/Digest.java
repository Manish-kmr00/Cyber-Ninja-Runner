package io.ktor.util;

import com.yandex.div.core.timer.TimerController;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: Crypto.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H¦\u0002J\b\u0010\b\u001a\u00020\u0006H&\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lio/ktor/util/Digest;", "", "build", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plusAssign", "", "bytes", TimerController.RESET_COMMAND, "ktor-utils"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface Digest {
    Object build(Continuation<? super byte[]> continuation);

    void plusAssign(byte[] bytes);

    void reset();
}
