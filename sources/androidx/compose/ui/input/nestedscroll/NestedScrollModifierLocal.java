package androidx.compose.ui.input.nestedscroll;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: NestedScrollModifierLocal.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J)\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#H\u0096@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010'J-\u0010(\u001a\u00020)2\u0006\u0010$\u001a\u00020)2\u0006\u0010%\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010-J!\u0010.\u001a\u00020#2\u0006\u0010%\u001a\u00020#H\u0096@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u00100J%\u00101\u001a\u00020)2\u0006\u0010%\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u00103R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R/\u0010\u0015\u001a\u0004\u0018\u00010\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u00008B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0017\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00064"}, d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollModifierLocal;", "Landroidx/compose/ui/modifier/ModifierLocalConsumer;", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "dispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "connection", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;)V", "getConnection", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getDispatcher", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "nestedCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getNestedCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "<set-?>", "parent", "getParent", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollModifierLocal;", "setParent", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollModifierLocal;)V", "parent$delegate", "Landroidx/compose/runtime/MutableState;", "value", "getValue", "onModifierLocalsUpdated", "", "scope", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NestedScrollModifierLocal implements ModifierLocalConsumer, ModifierLocalProvider<NestedScrollModifierLocal>, NestedScrollConnection {
    private final NestedScrollConnection connection;
    private final NestedScrollDispatcher dispatcher;

    /* JADX INFO: renamed from: parent$delegate, reason: from kotlin metadata */
    private final MutableState parent;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    public NestedScrollModifierLocal getValue() {
        return this;
    }

    public NestedScrollModifierLocal(NestedScrollDispatcher dispatcher, NestedScrollConnection connection) {
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(connection, "connection");
        this.dispatcher = dispatcher;
        this.connection = connection;
        dispatcher.setCalculateNestedScrollScope$ui_release(new Function0<CoroutineScope>() { // from class: androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final CoroutineScope invoke() {
                return NestedScrollModifierLocal.this.getNestedCoroutineScope();
            }
        });
        this.parent = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    }

    public final NestedScrollDispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final NestedScrollConnection getConnection() {
        return this.connection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final NestedScrollModifierLocal getParent() {
        return (NestedScrollModifierLocal) this.parent.getValue();
    }

    private final void setParent(NestedScrollModifierLocal nestedScrollModifierLocal) {
        this.parent.setValue(nestedScrollModifierLocal);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoroutineScope getNestedCoroutineScope() {
        CoroutineScope originNestedScrollScope;
        NestedScrollModifierLocal parent = getParent();
        if ((parent == null || (originNestedScrollScope = parent.getNestedCoroutineScope()) == null) && (originNestedScrollScope = this.dispatcher.getOriginNestedScrollScope()) == null) {
            throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
        }
        return originNestedScrollScope;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    public ProvidableModifierLocal<NestedScrollModifierLocal> getKey() {
        return NestedScrollModifierLocalKt.getModifierLocalNestedScroll();
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalConsumer
    public void onModifierLocalsUpdated(ModifierLocalReadScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        setParent((NestedScrollModifierLocal) scope.getCurrent(NestedScrollModifierLocalKt.getModifierLocalNestedScroll()));
        this.dispatcher.setParent$ui_release(getParent());
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    public long mo486onPreScrollOzD1aCk(long available, int source) {
        NestedScrollModifierLocal parent = getParent();
        long jMo486onPreScrollOzD1aCk = parent != null ? parent.mo486onPreScrollOzD1aCk(available, source) : Offset.INSTANCE.m1411getZeroF1C5BW0();
        return Offset.m1400plusMKHz9U(jMo486onPreScrollOzD1aCk, this.connection.mo486onPreScrollOzD1aCk(Offset.m1399minusMKHz9U(available, jMo486onPreScrollOzD1aCk), source));
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public long mo324onPostScrollDzOQY0M(long consumed, long available, int source) {
        long jMo324onPostScrollDzOQY0M = this.connection.mo324onPostScrollDzOQY0M(consumed, available, source);
        NestedScrollModifierLocal parent = getParent();
        return Offset.m1400plusMKHz9U(jMo324onPostScrollDzOQY0M, parent != null ? parent.mo324onPostScrollDzOQY0M(Offset.m1400plusMKHz9U(consumed, jMo324onPostScrollDzOQY0M), Offset.m1399minusMKHz9U(available, jMo324onPostScrollDzOQY0M), source) : Offset.INSTANCE.m1411getZeroF1C5BW0());
    }

    /* JADX WARN: Code duplicated, block: B:26:0x007c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreFling-QWom1Mo */
    public Object mo485onPreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation) throws Throwable {
        NestedScrollModifierLocal$onPreFling$1 nestedScrollModifierLocal$onPreFling$1;
        long jM4079getZero9UxMQ8M;
        NestedScrollModifierLocal nestedScrollModifierLocal;
        long j2;
        if (continuation instanceof NestedScrollModifierLocal$onPreFling$1) {
            nestedScrollModifierLocal$onPreFling$1 = (NestedScrollModifierLocal$onPreFling$1) continuation;
            if ((nestedScrollModifierLocal$onPreFling$1.label & Integer.MIN_VALUE) != 0) {
                nestedScrollModifierLocal$onPreFling$1.label -= Integer.MIN_VALUE;
            } else {
                nestedScrollModifierLocal$onPreFling$1 = new NestedScrollModifierLocal$onPreFling$1(this, continuation);
            }
        } else {
            nestedScrollModifierLocal$onPreFling$1 = new NestedScrollModifierLocal$onPreFling$1(this, continuation);
        }
        Object objMo485onPreFlingQWom1Mo = nestedScrollModifierLocal$onPreFling$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = nestedScrollModifierLocal$onPreFling$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objMo485onPreFlingQWom1Mo);
            NestedScrollModifierLocal parent = getParent();
            if (parent != null) {
                nestedScrollModifierLocal$onPreFling$1.L$0 = this;
                nestedScrollModifierLocal$onPreFling$1.J$0 = j;
                nestedScrollModifierLocal$onPreFling$1.label = 1;
                objMo485onPreFlingQWom1Mo = parent.mo485onPreFlingQWom1Mo(j, nestedScrollModifierLocal$onPreFling$1);
                if (objMo485onPreFlingQWom1Mo == coroutine_suspended) {
                    return coroutine_suspended;
                }
                nestedScrollModifierLocal = this;
            } else {
                jM4079getZero9UxMQ8M = Velocity.INSTANCE.m4079getZero9UxMQ8M();
                nestedScrollModifierLocal = this;
            }
            long j3 = j;
            j2 = jM4079getZero9UxMQ8M;
            NestedScrollConnection nestedScrollConnection = nestedScrollModifierLocal.connection;
            long jM4071minusAH228Gc = Velocity.m4071minusAH228Gc(j3, j2);
            nestedScrollModifierLocal$onPreFling$1.L$0 = null;
            nestedScrollModifierLocal$onPreFling$1.J$0 = j2;
            nestedScrollModifierLocal$onPreFling$1.label = 2;
            objMo485onPreFlingQWom1Mo = nestedScrollConnection.mo485onPreFlingQWom1Mo(jM4071minusAH228Gc, nestedScrollModifierLocal$onPreFling$1);
            if (objMo485onPreFlingQWom1Mo == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Velocity.m4059boximpl(Velocity.m4072plusAH228Gc(j2, ((Velocity) objMo485onPreFlingQWom1Mo).getPackedValue()));
        }
        if (i == 1) {
            j = nestedScrollModifierLocal$onPreFling$1.J$0;
            nestedScrollModifierLocal = (NestedScrollModifierLocal) nestedScrollModifierLocal$onPreFling$1.L$0;
            ResultKt.throwOnFailure(objMo485onPreFlingQWom1Mo);
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j2 = nestedScrollModifierLocal$onPreFling$1.J$0;
            ResultKt.throwOnFailure(objMo485onPreFlingQWom1Mo);
        }
        return Velocity.m4059boximpl(Velocity.m4072plusAH228Gc(j2, ((Velocity) objMo485onPreFlingQWom1Mo).getPackedValue()));
        jM4079getZero9UxMQ8M = ((Velocity) objMo485onPreFlingQWom1Mo).getPackedValue();
        long j4 = j;
        j2 = jM4079getZero9UxMQ8M;
        NestedScrollConnection nestedScrollConnection2 = nestedScrollModifierLocal.connection;
        long jM4071minusAH228Gc2 = Velocity.m4071minusAH228Gc(j4, j2);
        nestedScrollModifierLocal$onPreFling$1.L$0 = null;
        nestedScrollModifierLocal$onPreFling$1.J$0 = j2;
        nestedScrollModifierLocal$onPreFling$1.label = 2;
        objMo485onPreFlingQWom1Mo = nestedScrollConnection2.mo485onPreFlingQWom1Mo(jM4071minusAH228Gc2, nestedScrollModifierLocal$onPreFling$1);
        if (objMo485onPreFlingQWom1Mo == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Velocity.m4059boximpl(Velocity.m4072plusAH228Gc(j2, ((Velocity) objMo485onPreFlingQWom1Mo).getPackedValue()));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    public Object mo323onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) throws Throwable {
        NestedScrollModifierLocal$onPostFling$1 nestedScrollModifierLocal$onPostFling$1;
        long j3;
        long j4;
        NestedScrollModifierLocal nestedScrollModifierLocal;
        long j5;
        long jM4079getZero9UxMQ8M;
        long j6;
        if (continuation instanceof NestedScrollModifierLocal$onPostFling$1) {
            nestedScrollModifierLocal$onPostFling$1 = (NestedScrollModifierLocal$onPostFling$1) continuation;
            if ((nestedScrollModifierLocal$onPostFling$1.label & Integer.MIN_VALUE) != 0) {
                nestedScrollModifierLocal$onPostFling$1.label -= Integer.MIN_VALUE;
            } else {
                nestedScrollModifierLocal$onPostFling$1 = new NestedScrollModifierLocal$onPostFling$1(this, continuation);
            }
        } else {
            nestedScrollModifierLocal$onPostFling$1 = new NestedScrollModifierLocal$onPostFling$1(this, continuation);
        }
        Object objMo323onPostFlingRZ2iAVY = nestedScrollModifierLocal$onPostFling$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = nestedScrollModifierLocal$onPostFling$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objMo323onPostFlingRZ2iAVY);
            NestedScrollConnection nestedScrollConnection = this.connection;
            nestedScrollModifierLocal$onPostFling$1.L$0 = this;
            j3 = j;
            nestedScrollModifierLocal$onPostFling$1.J$0 = j3;
            j4 = j2;
            nestedScrollModifierLocal$onPostFling$1.J$1 = j4;
            nestedScrollModifierLocal$onPostFling$1.label = 1;
            objMo323onPostFlingRZ2iAVY = nestedScrollConnection.mo323onPostFlingRZ2iAVY(j, j2, nestedScrollModifierLocal$onPostFling$1);
            if (objMo323onPostFlingRZ2iAVY == coroutine_suspended) {
                return coroutine_suspended;
            }
            nestedScrollModifierLocal = this;
        } else {
            if (i == 1) {
                long j7 = nestedScrollModifierLocal$onPostFling$1.J$1;
                long j8 = nestedScrollModifierLocal$onPostFling$1.J$0;
                nestedScrollModifierLocal = (NestedScrollModifierLocal) nestedScrollModifierLocal$onPostFling$1.L$0;
                ResultKt.throwOnFailure(objMo323onPostFlingRZ2iAVY);
                j4 = j7;
                j3 = j8;
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j6 = nestedScrollModifierLocal$onPostFling$1.J$0;
                ResultKt.throwOnFailure(objMo323onPostFlingRZ2iAVY);
            }
            jM4079getZero9UxMQ8M = ((Velocity) objMo323onPostFlingRZ2iAVY).getPackedValue();
            j5 = j6;
            return Velocity.m4059boximpl(Velocity.m4072plusAH228Gc(j5, jM4079getZero9UxMQ8M));
        }
        long packedValue = ((Velocity) objMo323onPostFlingRZ2iAVY).getPackedValue();
        NestedScrollModifierLocal parent = nestedScrollModifierLocal.getParent();
        if (parent != null) {
            long jM4072plusAH228Gc = Velocity.m4072plusAH228Gc(j3, packedValue);
            long jM4071minusAH228Gc = Velocity.m4071minusAH228Gc(j4, packedValue);
            nestedScrollModifierLocal$onPostFling$1.L$0 = null;
            nestedScrollModifierLocal$onPostFling$1.J$0 = packedValue;
            nestedScrollModifierLocal$onPostFling$1.label = 2;
            objMo323onPostFlingRZ2iAVY = parent.mo323onPostFlingRZ2iAVY(jM4072plusAH228Gc, jM4071minusAH228Gc, nestedScrollModifierLocal$onPostFling$1);
            if (objMo323onPostFlingRZ2iAVY == coroutine_suspended) {
                return coroutine_suspended;
            }
            j6 = packedValue;
            jM4079getZero9UxMQ8M = ((Velocity) objMo323onPostFlingRZ2iAVY).getPackedValue();
            j5 = j6;
        } else {
            j5 = packedValue;
            jM4079getZero9UxMQ8M = Velocity.INSTANCE.m4079getZero9UxMQ8M();
        }
        return Velocity.m4059boximpl(Velocity.m4072plusAH228Gc(j5, jM4079getZero9UxMQ8M));
    }
}
