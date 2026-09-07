package io.ktor.utils.io;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.json.mediationsdk.logger.IronSourceError;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.safedk.android.analytics.brandsafety.FileUploadManager;
import com.vungle.ads.internal.protos.Sdk;
import com.yandex.div.core.timer.TimerController;
import io.ktor.http.ContentDisposition;
import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.BuffersKt;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.Input;
import io.ktor.utils.io.core.InputArraysKt;
import io.ktor.utils.io.core.InputPrimitivesKt;
import io.ktor.utils.io.core.Output;
import io.ktor.utils.io.core.OutputKt;
import io.ktor.utils.io.core.OutputPrimitivesKt;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UTF8Kt;
import io.ktor.utils.io.core.internal.UnsafeKt;
import io.ktor.utils.io.internal.AwaitingSlot;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: ByteChannelSequential.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b<\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b&\u0018\u00002\u00030Ö\u00012\u00030×\u00012\u00030Ø\u00012\u00020{2\u00030Ù\u00012\u00030Ú\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0004¢\u0006\u0004\b\u000f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0004¢\u0006\u0004\b\u0010\u0010\rJ\u001b\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0080@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0013J\u001b\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0080@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0013J\u0013\u0010\u0018\u001a\u00020\u000bH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u000bH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0019J\u0013\u0010\u001c\u001a\u00020\u0003H\u0080@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0019J\u001b\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\tH\u0084@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0013J\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010#\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b#\u0010$J#\u0010(\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\t2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&H\u0002¢\u0006\u0004\b(\u0010)J\u0019\u0010*\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b*\u0010$J\u000f\u0010+\u001a\u00020\u000bH\u0002¢\u0006\u0004\b+\u0010,J\u0017\u0010.\u001a\u00020\t2\u0006\u0010-\u001a\u00020\tH\u0016¢\u0006\u0004\b.\u0010/J\u001b\u0010.\u001a\u0002002\u0006\u00101\u001a\u000200H\u0096@ø\u0001\u0000¢\u0006\u0004\b.\u00102J#\u00104\u001a\u0002002\u0006\u00101\u001a\u0002002\u0006\u00103\u001a\u000200H\u0082@ø\u0001\u0000¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u000bH\u0016¢\u0006\u0004\b6\u0010,J\u0017\u00108\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\tH\u0016¢\u0006\u0004\b8\u0010\rJ\u000f\u00109\u001a\u00020\u000bH\u0002¢\u0006\u0004\b9\u0010,J\u000f\u0010:\u001a\u00020\u000bH\u0002¢\u0006\u0004\b:\u0010,J\u0017\u0010:\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u000bH\u0016¢\u0006\u0004\b<\u0010,J\u000f\u0010=\u001a\u00020\u0003H\u0002¢\u0006\u0004\b=\u0010>J\u000f\u0010?\u001a\u00020\u000bH\u0002¢\u0006\u0004\b?\u0010,JA\u0010G\u001a\u0002002\u0006\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u0002002\u0006\u0010C\u001a\u0002002\u0006\u0010D\u001a\u0002002\u0006\u00101\u001a\u000200H\u0086@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\bE\u0010FJ\u000f\u0010H\u001a\u00020\u000bH\u0004¢\u0006\u0004\bH\u0010,J\u001b\u0010M\u001a\u00020\t2\u0006\u0010J\u001a\u00020IH\u0080@ø\u0001\u0000¢\u0006\u0004\bK\u0010LJ\u001b\u0010M\u001a\u00020\t2\u0006\u0010J\u001a\u00020\u0001H\u0096@ø\u0001\u0000¢\u0006\u0004\bM\u0010NJ+\u0010M\u001a\u00020\t2\u0006\u0010J\u001a\u00020O2\u0006\u0010C\u001a\u00020\t2\u0006\u0010P\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0004\bM\u0010QJ\u000f\u0010R\u001a\u00020\tH\u0004¢\u0006\u0004\bR\u0010SJ\u0013\u0010T\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\bT\u0010\u0019J\u0013\u0010U\u001a\u00020\u0003H\u0082@ø\u0001\u0000¢\u0006\u0004\bU\u0010\u0019J\u0013\u0010W\u001a\u00020VH\u0096@ø\u0001\u0000¢\u0006\u0004\bW\u0010\u0019J\u0013\u0010X\u001a\u00020VH\u0082@ø\u0001\u0000¢\u0006\u0004\bX\u0010\u0019J\u0013\u0010Z\u001a\u00020YH\u0096@ø\u0001\u0000¢\u0006\u0004\bZ\u0010\u0019J\u0013\u0010[\u001a\u00020YH\u0082@ø\u0001\u0000¢\u0006\u0004\b[\u0010\u0019J\u0013\u0010]\u001a\u00020\\H\u0096@ø\u0001\u0000¢\u0006\u0004\b]\u0010\u0019J\u0013\u0010^\u001a\u00020\\H\u0082@ø\u0001\u0000¢\u0006\u0004\b^\u0010\u0019J#\u0010_\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020I2\u0006\u0010-\u001a\u00020\tH\u0082@ø\u0001\u0000¢\u0006\u0004\b_\u0010`J#\u0010_\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020\u00012\u0006\u0010-\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0004\b_\u0010aJ+\u0010_\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020O2\u0006\u0010C\u001a\u00020\t2\u0006\u0010P\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0004\b_\u0010QJ#\u0010b\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020I2\u0006\u0010-\u001a\u00020\tH\u0082@ø\u0001\u0000¢\u0006\u0004\bb\u0010`J+\u0010b\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020O2\u0006\u0010C\u001a\u00020\t2\u0006\u0010P\u001a\u00020\tH\u0082@ø\u0001\u0000¢\u0006\u0004\bb\u0010QJ\u0013\u0010c\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0004\bc\u0010\u0019J\u0013\u0010d\u001a\u00020\tH\u0082@ø\u0001\u0000¢\u0006\u0004\bd\u0010\u0019J\u0013\u0010e\u001a\u000200H\u0096@ø\u0001\u0000¢\u0006\u0004\be\u0010\u0019J\u0013\u0010f\u001a\u000200H\u0082@ø\u0001\u0000¢\u0006\u0004\bf\u0010\u0019J\u001b\u0010i\u001a\u00020h2\u0006\u0010g\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0004\bi\u0010\u0013J#\u0010k\u001a\u00020h2\u0006\u0010j\u001a\u00020&2\u0006\u0010g\u001a\u00020\tH\u0082@ø\u0001\u0000¢\u0006\u0004\bk\u0010lJ\u001b\u0010n\u001a\u00020h2\u0006\u0010m\u001a\u000200H\u0096@ø\u0001\u0000¢\u0006\u0004\bn\u00102J#\u0010o\u001a\u00020h2\u0006\u0010j\u001a\u00020&2\u0006\u0010m\u001a\u000200H\u0082@ø\u0001\u0000¢\u0006\u0004\bo\u0010pJ(\u0010u\u001a\u00020\u000b2\u0017\u0010t\u001a\u0013\u0012\u0004\u0012\u00020r\u0012\u0004\u0012\u00020\u000b0q¢\u0006\u0002\bsH\u0017¢\u0006\u0004\bu\u0010vJ\u0013\u0010x\u001a\u00020wH\u0096@ø\u0001\u0000¢\u0006\u0004\bx\u0010\u0019J\u0013\u0010y\u001a\u00020wH\u0082@ø\u0001\u0000¢\u0006\u0004\by\u0010\u0019J<\u0010~\u001a\u00020\u000b2'\u0010t\u001a#\b\u0001\u0012\u0004\u0012\u00020{\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0|\u0012\u0006\u0012\u0004\u0018\u00010}0z¢\u0006\u0002\bsH\u0097@ø\u0001\u0000¢\u0006\u0004\b~\u0010\u007fJ \u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0080\u00012\u0006\u0010m\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0005\b\u0081\u0001\u0010\u0013J8\u0010\u0086\u0001\u001a\u00020\u0003\"\u000f\b\u0000\u0010\u0084\u0001*\b0\u0082\u0001j\u0003`\u0083\u00012\u0007\u0010\u0085\u0001\u001a\u00028\u00002\u0006\u0010m\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\u001c\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0011\u001a\u00020\tH\u0016¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J\u001c\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0011\u001a\u00020\tH\u0002¢\u0006\u0006\b\u008a\u0001\u0010\u0089\u0001J\u0012\u0010\u008b\u0001\u001a\u00020{H\u0016¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\"\u0010\u008f\u0001\u001a\u0002002\u0006\u0010J\u001a\u00020\u00002\u0006\u0010m\u001a\u000200H\u0000¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J\u001e\u0010\u0091\u0001\u001a\u00020\t2\u0007\u0010\u0090\u0001\u001a\u00020\u0001H\u0096@ø\u0001\u0000¢\u0006\u0005\b\u0091\u0001\u0010NJ.\u0010\u0091\u0001\u001a\u00020\t2\u0007\u0010\u0090\u0001\u001a\u00020O2\u0006\u0010C\u001a\u00020\t2\u0006\u0010P\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0005\b\u0091\u0001\u0010QJ\u001e\u0010\u0092\u0001\u001a\u00020\t2\u0007\u0010\u0090\u0001\u001a\u00020\u0001H\u0082@ø\u0001\u0000¢\u0006\u0005\b\u0092\u0001\u0010NJ.\u0010\u0092\u0001\u001a\u00020\t2\u0007\u0010\u0090\u0001\u001a\u00020O2\u0006\u0010C\u001a\u00020\t2\u0006\u0010P\u001a\u00020\tH\u0082@ø\u0001\u0000¢\u0006\u0005\b\u0092\u0001\u0010QJ\u001f\u0010\u0094\u0001\u001a\u00020\u000b2\u0007\u0010\u0093\u0001\u001a\u00020VH\u0096@ø\u0001\u0000¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J\u001f\u0010\u0097\u0001\u001a\u00020\u000b2\u0007\u0010\u0096\u0001\u001a\u00020YH\u0096@ø\u0001\u0000¢\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001J\u001f\u0010\u009a\u0001\u001a\u00020\u000b2\u0007\u0010\u0099\u0001\u001a\u00020\\H\u0096@ø\u0001\u0000¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J7\u0010¡\u0001\u001a\u00020\u000b2\u0007\u0010\u009c\u0001\u001a\u00020@2\u0007\u0010\u009d\u0001\u001a\u00020\t2\u0007\u0010\u009e\u0001\u001a\u00020\tH\u0096@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0006\b\u009f\u0001\u0010 \u0001J\u001e\u0010¡\u0001\u001a\u00020\u000b2\u0007\u0010\u0090\u0001\u001a\u00020IH\u0096@ø\u0001\u0000¢\u0006\u0005\b¡\u0001\u0010LJ.\u0010¡\u0001\u001a\u00020\u000b2\u0007\u0010\u0090\u0001\u001a\u00020O2\u0006\u0010C\u001a\u00020\t2\u0006\u0010P\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0005\b¡\u0001\u0010QJ\u001e\u0010£\u0001\u001a\u00020\u000b2\u0007\u0010¢\u0001\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0005\b£\u0001\u0010\u0013J\u001e\u0010¥\u0001\u001a\u00020\u000b2\u0007\u0010¤\u0001\u001a\u000200H\u0096@ø\u0001\u0000¢\u0006\u0005\b¥\u0001\u00102J\u001f\u0010§\u0001\u001a\u00020\u000b2\u0007\u0010¦\u0001\u001a\u00020hH\u0096@ø\u0001\u0000¢\u0006\u0006\b§\u0001\u0010¨\u0001J\u001f\u0010ª\u0001\u001a\u00020\u000b2\u0007\u0010©\u0001\u001a\u00020wH\u0096@ø\u0001\u0000¢\u0006\u0006\bª\u0001\u0010«\u0001J?\u0010\u00ad\u0001\u001a\u00020\u000b2(\u0010¬\u0001\u001a#\b\u0001\u0012\u0004\u0012\u00020\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0|\u0012\u0006\u0012\u0004\u0018\u00010}0z¢\u0006\u0002\bsH\u0097@ø\u0001\u0000¢\u0006\u0005\b\u00ad\u0001\u0010\u007fR\u001c\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\u000e\n\u0005\b\u0004\u0010®\u0001\u001a\u0005\b¯\u0001\u0010>R\u0016\u0010±\u0001\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b°\u0001\u0010SR\u0016\u0010³\u0001\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b²\u0001\u0010SR)\u0010¸\u0001\u001a\u00020\u00032\u0007\u0010´\u0001\u001a\u00020\u00038D@DX\u0084\u000e¢\u0006\u000f\u001a\u0005\bµ\u0001\u0010>\"\u0006\b¶\u0001\u0010·\u0001R.\u0010½\u0001\u001a\u0004\u0018\u00010!2\t\u0010´\u0001\u001a\u0004\u0018\u00010!8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b¹\u0001\u0010º\u0001\"\u0006\b»\u0001\u0010¼\u0001R\u0017\u0010¾\u0001\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¾\u0001\u0010¿\u0001R\u001c\u0010Á\u0001\u001a\u00070}j\u0003`À\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÁ\u0001\u0010Â\u0001R\u0016\u0010Ã\u0001\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bÃ\u0001\u0010>R\u0016\u0010Ä\u0001\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÄ\u0001\u0010>R\u0016\u0010Å\u0001\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÅ\u0001\u0010>R\u001f\u0010Æ\u0001\u001a\u00020h8\u0004X\u0084\u0004¢\u0006\u0010\n\u0006\bÆ\u0001\u0010Ç\u0001\u001a\u0006\bÈ\u0001\u0010É\u0001R\u0018\u0010Ë\u0001\u001a\u00030Ê\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bË\u0001\u0010Ì\u0001R\u0017\u0010Ï\u0001\u001a\u0002008VX\u0096\u0004¢\u0006\b\u001a\u0006\bÍ\u0001\u0010Î\u0001R\u0017\u0010Ñ\u0001\u001a\u0002008VX\u0096\u0004¢\u0006\b\u001a\u0006\bÐ\u0001\u0010Î\u0001R\u001f\u0010Ò\u0001\u001a\u00020&8\u0004X\u0084\u0004¢\u0006\u0010\n\u0006\bÒ\u0001\u0010¿\u0001\u001a\u0006\bÓ\u0001\u0010Ô\u0001\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006Õ\u0001"}, d2 = {"Lio/ktor/utils/io/ByteChannelSequentialBase;", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "initial", "", "autoFlush", "Lio/ktor/utils/io/pool/ObjectPool;", "pool", "<init>", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;ZLio/ktor/utils/io/pool/ObjectPool;)V", "", "count", "", "addBytesRead", "(I)V", "addBytesWritten", "afterRead", "afterWrite", "atLeast", "await", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitAtLeastNBytesAvailableForRead$ktor_io", "awaitAtLeastNBytesAvailableForRead", "awaitAtLeastNBytesAvailableForWrite$ktor_io", "awaitAtLeastNBytesAvailableForWrite", "awaitContent", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFreeSpace", "awaitInternalAtLeast1$ktor_io", "awaitInternalAtLeast1", "awaitSuspend", "Lio/ktor/utils/io/WriterSuspendSession;", "beginWriteSession", "()Lio/ktor/utils/io/WriterSuspendSession;", "", "cause", TimerController.CANCEL_COMMAND, "(Ljava/lang/Throwable;)Z", "remaining", "Lio/ktor/utils/io/core/BytePacketBuilder;", "closeable", "checkClosed", "(ILio/ktor/utils/io/core/BytePacketBuilder;)V", "close", "completeReading", "()V", "n", FileUploadManager.m, "(I)I", "", "max", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "discarded0", "discardSuspend", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "endReadSession", "written", "endWriteSession", "ensureNotClosed", "ensureNotFailed", "(Lio/ktor/utils/io/core/BytePacketBuilder;)V", "flush", "flushImpl", "()Z", "flushWrittenBytes", "Lio/ktor/utils/io/bits/Memory;", "destination", "destinationOffset", "offset", "min", "peekTo-lBXzO7A", "(Ljava/nio/ByteBuffer;JJJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "peekTo", "prepareFlushedBytes", "Lio/ktor/utils/io/core/Buffer;", "dst", "readAvailable$ktor_io", "(Lio/ktor/utils/io/core/Buffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readAvailable", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", SessionDescription.ATTR_LENGTH, "([BIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readAvailableClosed", "()I", "readBoolean", "readBooleanSlow", "", "readByte", "readByteSlow", "", "readDouble", "readDoubleSlow", "", "readFloat", "readFloatSlow", "readFully", "(Lio/ktor/utils/io/core/Buffer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readFullySuspend", "readInt", "readIntSlow", "readLong", "readLongSlow", ContentDisposition.Parameters.Size, "Lio/ktor/utils/io/core/ByteReadPacket;", "readPacket", "builder", "readPacketSuspend", "(Lio/ktor/utils/io/core/BytePacketBuilder;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "limit", "readRemaining", "readRemainingSuspend", "(Lio/ktor/utils/io/core/BytePacketBuilder;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function1;", "Lio/ktor/utils/io/ReadSession;", "Lkotlin/ExtensionFunctionType;", "consumer", "readSession", "(Lkotlin/jvm/functions/Function1;)V", "", "readShort", "readShortSlow", "Lkotlin/Function2;", "Lio/ktor/utils/io/SuspendableReadSession;", "Lkotlin/coroutines/Continuation;", "", "readSuspendableSession", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "readUTF8Line", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "out", "readUTF8LineTo", "(Ljava/lang/Appendable;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "request", "(I)Lio/ktor/utils/io/core/internal/ChunkBuffer;", "requestNextView", "startReadSession", "()Lio/ktor/utils/io/SuspendableReadSession;", "transferTo$ktor_io", "(Lio/ktor/utils/io/ByteChannelSequentialBase;J)J", "transferTo", "src", "writeAvailable", "writeAvailableSuspend", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "writeByte", "(BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "writeDouble", "(DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", InneractiveMediationDefs.GENDER_FEMALE, "writeFloat", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "memory", "startIndex", "endIndex", "writeFully-JT6ljtQ", "(Ljava/nio/ByteBuffer;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeFully", "i", "writeInt", "l", "writeLong", "packet", "writePacket", "(Lio/ktor/utils/io/core/ByteReadPacket;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "s", "writeShort", "(SLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "visitor", "writeSuspendSession", "Z", "getAutoFlush", "getAvailableForRead", "availableForRead", "getAvailableForWrite", "availableForWrite", "<anonymous parameter 0>", "getClosed", "setClosed", "(Z)V", "closed", "getClosedCause", "()Ljava/lang/Throwable;", "setClosedCause", "(Ljava/lang/Throwable;)V", "closedCause", "flushBuffer", "Lio/ktor/utils/io/core/BytePacketBuilder;", "Lkotlinx/atomicfu/locks/SynchronizedObject;", "flushMutex", "Ljava/lang/Object;", "isCancelled", "isClosedForRead", "isClosedForWrite", "readable", "Lio/ktor/utils/io/core/ByteReadPacket;", "getReadable", "()Lio/ktor/utils/io/core/ByteReadPacket;", "Lio/ktor/utils/io/internal/AwaitingSlot;", "slot", "Lio/ktor/utils/io/internal/AwaitingSlot;", "getTotalBytesRead", "()J", "totalBytesRead", "getTotalBytesWritten", "totalBytesWritten", "writable", "getWritable", "()Lio/ktor/utils/io/core/BytePacketBuilder;", "ktor-io", "Lio/ktor/utils/io/ByteChannel;", "Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/utils/io/ByteWriteChannel;", "Lio/ktor/utils/io/HasReadSession;", "Lio/ktor/utils/io/HasWriteSession;"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ByteChannelSequentialBase implements ByteChannel, ByteReadChannel, ByteWriteChannel, SuspendableReadSession, HasReadSession, HasWriteSession {
    private volatile /* synthetic */ int _availableForRead;
    private volatile /* synthetic */ Object _closed;
    private volatile /* synthetic */ Object _lastReadView;
    private volatile /* synthetic */ long _totalBytesRead;
    private volatile /* synthetic */ long _totalBytesWritten;
    private final boolean autoFlush;
    private volatile /* synthetic */ int channelSize;
    private final BytePacketBuilder flushBuffer;
    private final Object flushMutex;
    private volatile /* synthetic */ int lastReadAvailable$delegate;
    private volatile /* synthetic */ Object lastReadView$delegate;
    private final ByteReadPacket readable;
    private final AwaitingSlot slot;
    private final BytePacketBuilder writable;
    private static final /* synthetic */ AtomicLongFieldUpdater _totalBytesRead$FU = AtomicLongFieldUpdater.newUpdater(ByteChannelSequentialBase.class, "_totalBytesRead");
    private static final /* synthetic */ AtomicLongFieldUpdater _totalBytesWritten$FU = AtomicLongFieldUpdater.newUpdater(ByteChannelSequentialBase.class, "_totalBytesWritten");
    private static final /* synthetic */ AtomicIntegerFieldUpdater _availableForRead$FU = AtomicIntegerFieldUpdater.newUpdater(ByteChannelSequentialBase.class, "_availableForRead");
    private static final /* synthetic */ AtomicIntegerFieldUpdater channelSize$FU = AtomicIntegerFieldUpdater.newUpdater(ByteChannelSequentialBase.class, "channelSize");
    private static final /* synthetic */ AtomicReferenceFieldUpdater _closed$FU = AtomicReferenceFieldUpdater.newUpdater(ByteChannelSequentialBase.class, Object.class, "_closed");

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$awaitFreeSpace$1, reason: invalid class name */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0}, l = {799}, m = "awaitFreeSpace$suspendImpl", n = {"$this"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.awaitFreeSpace$suspendImpl(ByteChannelSequentialBase.this, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$awaitSuspend$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0}, l = {611}, m = "awaitSuspend", n = {"this", "atLeast"}, s = {"L$0", "I$0"})
    static final class C47941 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C47941(Continuation<? super C47941> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.awaitSuspend(0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$discardSuspend$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0, 0}, l = {673}, m = "discardSuspend", n = {"this", "max", "discarded"}, s = {"L$0", "J$0", "J$1"})
    static final class C47961 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C47961(Continuation<? super C47961> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.discardSuspend(0L, 0L, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$2, reason: invalid class name */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0}, l = {486}, m = "readAvailable$ktor_io", n = {"this", "dst"}, s = {"L$0", "L$1"})
    static final class AnonymousClass2 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.readAvailable$ktor_io(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$4, reason: invalid class name */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0, 0, 0}, l = {IronSourceError.ERROR_AD_UNIT_CAPPED}, m = "readAvailable$suspendImpl", n = {"$this", "dst", "offset", SessionDescription.ATTR_LENGTH}, s = {"L$0", "L$1", "I$0", "I$1"})
    static final class AnonymousClass4 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass4(Continuation<? super AnonymousClass4> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.readAvailable$suspendImpl(ByteChannelSequentialBase.this, null, 0, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readBooleanSlow$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0}, l = {570, 572}, m = "readBooleanSlow", n = {"this"}, s = {"L$0"})
    static final class C47971 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C47971(Continuation<? super C47971> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.readBooleanSlow(this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readByteSlow$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0}, l = {313}, m = "readByteSlow", n = {"this"}, s = {"L$0"})
    static final class C47981 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C47981(Continuation<? super C47981> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.readByteSlow(this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readDoubleSlow$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0}, l = {390}, m = "readDoubleSlow", n = {"this"}, s = {"L$0"})
    static final class C47991 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C47991(Continuation<? super C47991> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.readDoubleSlow(this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readFloatSlow$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0}, l = {377}, m = "readFloatSlow", n = {"this"}, s = {"L$0"})
    static final class C48001 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C48001(Continuation<? super C48001> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.readFloatSlow(this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readFully$6, reason: invalid class name */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0, 0, 0}, l = {544, 548}, m = "readFully$suspendImpl", n = {"$this", "dst", "offset", SessionDescription.ATTR_LENGTH}, s = {"L$0", "L$1", "I$0", "I$1"})
    static final class AnonymousClass6 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass6(Continuation<? super AnonymousClass6> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.readFully$suspendImpl(ByteChannelSequentialBase.this, null, 0, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0, 0}, l = {519, IronSourceError.ERROR_NO_INTERNET_CONNECTION}, m = "readFullySuspend", n = {"this", "dst", "n"}, s = {"L$0", "L$1", "I$0"})
    static final class C48011 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C48011(Continuation<? super C48011> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.readFullySuspend(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0, 0, 0, 0}, l = {555}, m = "readFullySuspend", n = {"this", "dst", "offset", SessionDescription.ATTR_LENGTH, "written"}, s = {"L$0", "L$1", "I$0", "I$1", "I$2"})
    static final class C48022 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C48022(Continuation<? super C48022> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.readFullySuspend(null, 0, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readIntSlow$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0}, l = {349}, m = "readIntSlow", n = {"this"}, s = {"L$0"})
    static final class C48031 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C48031(Continuation<? super C48031> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.readIntSlow(this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readLongSlow$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0}, l = {364}, m = "readLongSlow", n = {"this"}, s = {"L$0"})
    static final class C48041 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C48041(Continuation<? super C48041> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.readLongSlow(this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readPacketSuspend$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0, 0}, l = {459}, m = "readPacketSuspend", n = {"this", "builder", "remaining"}, s = {"L$0", "L$1", "I$0"})
    static final class C48051 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C48051(Continuation<? super C48051> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.readPacketSuspend(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readRemainingSuspend$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0, 0}, l = {TypedValues.CycleType.TYPE_WAVE_PHASE}, m = "readRemainingSuspend", n = {"this", "builder", "limit"}, s = {"L$0", "L$1", "J$0"})
    static final class C48061 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C48061(Continuation<? super C48061> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.readRemainingSuspend(null, 0L, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readShortSlow$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0}, l = {329}, m = "readShortSlow", n = {"this"}, s = {"L$0"})
    static final class C48071 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C48071(Continuation<? super C48071> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.readShortSlow(this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readSuspendableSession$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0}, l = {704}, m = "readSuspendableSession$suspendImpl", n = {"$this"}, s = {"L$0"})
    static final class C48081 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C48081(Continuation<? super C48081> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.readSuspendableSession$suspendImpl(ByteChannelSequentialBase.this, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readUTF8Line$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0}, l = {731}, m = "readUTF8Line$suspendImpl", n = {"builder"}, s = {"L$0"})
    static final class C48091 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C48091(Continuation<? super C48091> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.readUTF8Line$suspendImpl(ByteChannelSequentialBase.this, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$writeAvailableSuspend$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0}, l = {776, 777}, m = "writeAvailableSuspend", n = {"this", "src"}, s = {"L$0", "L$1"})
    static final class C48111 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C48111(Continuation<? super C48111> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.writeAvailableSuspend(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$writeAvailableSuspend$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0, 0, 0}, l = {781, 782}, m = "writeAvailableSuspend", n = {"this", "src", "offset", SessionDescription.ATTR_LENGTH}, s = {"L$0", "L$1", "I$0", "I$1"})
    static final class C48122 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C48122(Continuation<? super C48122> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.writeAvailableSuspend(null, 0, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$writeByte$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0}, l = {150}, m = "writeByte$suspendImpl", n = {"$this", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B}, s = {"L$0", "B$0"})
    static final class C48131 extends ContinuationImpl {
        byte B$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C48131(Continuation<? super C48131> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.writeByte$suspendImpl(ByteChannelSequentialBase.this, (byte) 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$writeDouble$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0}, l = {180}, m = "writeDouble$suspendImpl", n = {"$this", "d"}, s = {"L$0", "D$0"})
    static final class C48141 extends ContinuationImpl {
        double D$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C48141(Continuation<? super C48141> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.writeDouble$suspendImpl(ByteChannelSequentialBase.this, 0.0d, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$writeFloat$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0}, l = {174}, m = "writeFloat$suspendImpl", n = {"$this", InneractiveMediationDefs.GENDER_FEMALE}, s = {"L$0", "F$0"})
    static final class C48151 extends ContinuationImpl {
        float F$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C48151(Continuation<? super C48151> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.writeFloat$suspendImpl(ByteChannelSequentialBase.this, 0.0f, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$writeFully$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0}, l = {193}, m = "writeFully$suspendImpl", n = {"$this", "src"}, s = {"L$0", "L$1"})
    static final class C48161 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C48161(Continuation<? super C48161> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.writeFully$suspendImpl(ByteChannelSequentialBase.this, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$writeFully$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0, 0, 0}, l = {204}, m = "writeFully$suspendImpl", n = {"$this", "src", "currentIndex", "endIndex"}, s = {"L$0", "L$1", "I$0", "I$1"})
    static final class C48172 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C48172(Continuation<? super C48172> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.writeFully$suspendImpl(ByteChannelSequentialBase.this, null, 0, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$writeFully$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0, 0, 0}, l = {Sdk.SDKError.Reason.MRAID_JS_DOES_NOT_EXIST_VALUE}, m = "writeFully-JT6ljtQ$suspendImpl", n = {"$this", "memory", "endIndex", "currentIndex"}, s = {"L$0", "L$1", "I$0", "I$1"})
    static final class C48183 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C48183(Continuation<? super C48183> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.m7620writeFullyJT6ljtQ$suspendImpl(ByteChannelSequentialBase.this, null, 0, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$writeInt$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0}, l = {162}, m = "writeInt$suspendImpl", n = {"$this", "i"}, s = {"L$0", "I$0"})
    static final class C48191 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C48191(Continuation<? super C48191> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.writeInt$suspendImpl(ByteChannelSequentialBase.this, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$writeLong$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0}, l = {168}, m = "writeLong$suspendImpl", n = {"$this", "l"}, s = {"L$0", "J$0"})
    static final class C48201 extends ContinuationImpl {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C48201(Continuation<? super C48201> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.writeLong$suspendImpl(ByteChannelSequentialBase.this, 0L, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$writePacket$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0}, l = {186}, m = "writePacket$suspendImpl", n = {"$this", "packet"}, s = {"L$0", "L$1"})
    static final class C48211 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C48211(Continuation<? super C48211> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.writePacket$suspendImpl(ByteChannelSequentialBase.this, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$writeShort$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0}, l = {156}, m = "writeShort$suspendImpl", n = {"$this", "s"}, s = {"L$0", "S$0"})
    static final class C48221 extends ContinuationImpl {
        Object L$0;
        short S$0;
        int label;
        /* synthetic */ Object result;

        C48221(Continuation<? super C48221> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.writeShort$suspendImpl(ByteChannelSequentialBase.this, (short) 0, this);
        }
    }

    @Override // io.ktor.utils.io.SuspendableReadSession
    public Object await(int i, Continuation<? super Boolean> continuation) {
        return await$suspendImpl(this, i, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object awaitContent(Continuation<? super Unit> continuation) {
        return awaitContent$suspendImpl(this, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object awaitFreeSpace(Continuation<? super Unit> continuation) {
        return awaitFreeSpace$suspendImpl(this, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object discard(long j, Continuation<? super Long> continuation) {
        return discard$suspendImpl(this, j, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readAvailable(ChunkBuffer chunkBuffer, Continuation<? super Integer> continuation) {
        return readAvailable$suspendImpl(this, chunkBuffer, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readAvailable(byte[] bArr, int i, int i2, Continuation<? super Integer> continuation) {
        return readAvailable$suspendImpl(this, bArr, i, i2, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readBoolean(Continuation<? super Boolean> continuation) {
        return readBoolean$suspendImpl(this, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readByte(Continuation<? super Byte> continuation) {
        return readByte$suspendImpl(this, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readDouble(Continuation<? super Double> continuation) {
        return readDouble$suspendImpl(this, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readFloat(Continuation<? super Float> continuation) {
        return readFloat$suspendImpl(this, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readFully(ChunkBuffer chunkBuffer, int i, Continuation<? super Unit> continuation) {
        return readFully$suspendImpl(this, chunkBuffer, i, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readFully(byte[] bArr, int i, int i2, Continuation<? super Unit> continuation) {
        return readFully$suspendImpl(this, bArr, i, i2, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readInt(Continuation<? super Integer> continuation) {
        return readInt$suspendImpl(this, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readLong(Continuation<? super Long> continuation) {
        return readLong$suspendImpl(this, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readPacket(int i, Continuation<? super ByteReadPacket> continuation) {
        return readPacket$suspendImpl(this, i, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readRemaining(long j, Continuation<? super ByteReadPacket> continuation) {
        return readRemaining$suspendImpl(this, j, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readShort(Continuation<? super Short> continuation) {
        return readShort$suspendImpl(this, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    @Deprecated(message = "Use read instead.")
    public Object readSuspendableSession(Function2<? super SuspendableReadSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        return readSuspendableSession$suspendImpl(this, function2, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readUTF8Line(int i, Continuation<? super String> continuation) {
        return readUTF8Line$suspendImpl(this, i, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public <A extends Appendable> Object readUTF8LineTo(A a2, int i, Continuation<? super Boolean> continuation) {
        return readUTF8LineTo$suspendImpl(this, a2, i, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object writeAvailable(ChunkBuffer chunkBuffer, Continuation<? super Integer> continuation) {
        return writeAvailable$suspendImpl(this, chunkBuffer, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object writeAvailable(byte[] bArr, int i, int i2, Continuation<? super Integer> continuation) {
        return writeAvailable$suspendImpl(this, bArr, i, i2, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object writeByte(byte b, Continuation<? super Unit> continuation) {
        return writeByte$suspendImpl(this, b, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object writeDouble(double d, Continuation<? super Unit> continuation) {
        return writeDouble$suspendImpl(this, d, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object writeFloat(float f, Continuation<? super Unit> continuation) {
        return writeFloat$suspendImpl(this, f, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object writeFully(Buffer buffer, Continuation<? super Unit> continuation) {
        return writeFully$suspendImpl(this, buffer, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object writeFully(byte[] bArr, int i, int i2, Continuation<? super Unit> continuation) {
        return writeFully$suspendImpl(this, bArr, i, i2, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    /* JADX INFO: renamed from: writeFully-JT6ljtQ */
    public Object mo7619writeFullyJT6ljtQ(ByteBuffer byteBuffer, int i, int i2, Continuation<? super Unit> continuation) {
        return m7620writeFullyJT6ljtQ$suspendImpl(this, byteBuffer, i, i2, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object writeInt(int i, Continuation<? super Unit> continuation) {
        return writeInt$suspendImpl(this, i, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object writeLong(long j, Continuation<? super Unit> continuation) {
        return writeLong$suspendImpl(this, j, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object writePacket(ByteReadPacket byteReadPacket, Continuation<? super Unit> continuation) {
        return writePacket$suspendImpl(this, byteReadPacket, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object writeShort(short s, Continuation<? super Unit> continuation) {
        return writeShort$suspendImpl(this, s, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    @Deprecated(message = "Use write { } instead.")
    public Object writeSuspendSession(Function2<? super WriterSuspendSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        return writeSuspendSession$suspendImpl(this, function2, continuation);
    }

    public ByteChannelSequentialBase(ChunkBuffer initial, boolean z, ObjectPool<ChunkBuffer> pool) throws Throwable {
        Intrinsics.checkNotNullParameter(initial, "initial");
        Intrinsics.checkNotNullParameter(pool, "pool");
        this.autoFlush = z;
        this._lastReadView = ChunkBuffer.INSTANCE.getEmpty();
        this._totalBytesRead = 0L;
        this._totalBytesWritten = 0L;
        this._availableForRead = 0;
        this.channelSize = 0;
        this._closed = null;
        this.writable = new BytePacketBuilder(pool);
        this.readable = new ByteReadPacket(initial, pool);
        this.lastReadAvailable$delegate = 0;
        this.lastReadView$delegate = ChunkBuffer.INSTANCE.getEmpty();
        this.slot = new AwaitingSlot();
        this.flushMutex = new Object();
        this.flushBuffer = new BytePacketBuilder(null, 1, null);
        int iRemainingAll = (int) BuffersKt.remainingAll(initial);
        afterWrite(iRemainingAll);
        _availableForRead$FU.addAndGet(this, iRemainingAll);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public boolean getAutoFlush() {
        return this.autoFlush;
    }

    public /* synthetic */ ByteChannelSequentialBase(ChunkBuffer chunkBuffer, boolean z, ObjectPool objectPool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(chunkBuffer, z, (i & 4) != 0 ? ChunkBuffer.INSTANCE.getPool() : objectPool);
    }

    private final boolean isCancelled() {
        CloseElement closeElement = (CloseElement) this._closed;
        return (closeElement != null ? closeElement.getCause() : null) != null;
    }

    protected final boolean getClosed() {
        return this._closed != null;
    }

    protected final void setClosed(boolean z) {
        throw new IllegalStateException("Setting is not allowed for closed".toString());
    }

    protected final BytePacketBuilder getWritable() {
        return this.writable;
    }

    protected final ByteReadPacket getReadable() {
        return this.readable;
    }

    /* JADX INFO: renamed from: getLastReadAvailable, reason: from getter */
    private final int getLastReadAvailable$delegate() {
        return this.lastReadAvailable$delegate;
    }

    private final void setLastReadAvailable(int i) {
        this.lastReadAvailable$delegate = i;
    }

    private final ChunkBuffer getLastReadView() {
        return (ChunkBuffer) this.lastReadView$delegate;
    }

    private final void setLastReadView(ChunkBuffer chunkBuffer) {
        this.lastReadView$delegate = chunkBuffer;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    /* JADX INFO: renamed from: getAvailableForRead, reason: from getter */
    public int get_availableForRead() {
        return this._availableForRead;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public int getAvailableForWrite() {
        return Math.max(0, 4088 - this.channelSize);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public boolean isClosedForRead() {
        return isCancelled() || (getClosed() && this.channelSize == 0);
    }

    @Override // io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel
    public boolean isClosedForWrite() {
        return getClosed();
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    /* JADX INFO: renamed from: getTotalBytesRead, reason: from getter */
    public long get_totalBytesRead() {
        return this._totalBytesRead;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    /* JADX INFO: renamed from: getTotalBytesWritten, reason: from getter */
    public long get_totalBytesWritten() {
        return this._totalBytesWritten;
    }

    @Override // io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel
    public final Throwable getClosedCause() {
        CloseElement closeElement = (CloseElement) this._closed;
        if (closeElement != null) {
            return closeElement.getCause();
        }
        return null;
    }

    public final void setClosedCause(Throwable th) {
        throw new IllegalStateException("Closed cause shouldn't be changed directly".toString());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object awaitAtLeastNBytesAvailableForWrite$ktor_io(final int i, Continuation<? super Unit> continuation) throws Throwable {
        ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1 byteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1;
        final ByteChannelSequentialBase byteChannelSequentialBase;
        if (continuation instanceof ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1) {
            byteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1 = (ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1) continuation;
            if ((byteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1.label & Integer.MIN_VALUE) != 0) {
                byteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1.label -= Integer.MIN_VALUE;
            } else {
                byteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1 = new ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1(this, continuation);
            }
        } else {
            byteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1 = new ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1(this, continuation);
        }
        Object obj = byteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = byteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            byteChannelSequentialBase = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = byteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1.I$0;
            byteChannelSequentialBase = (ByteChannelSequentialBase) byteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        while (byteChannelSequentialBase.getAvailableForWrite() < i && !byteChannelSequentialBase.getClosed()) {
            if (!byteChannelSequentialBase.flushImpl()) {
                AwaitingSlot awaitingSlot = byteChannelSequentialBase.slot;
                Function0<Boolean> function0 = new Function0<Boolean>() { // from class: io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        return Boolean.valueOf(this.this$0.getAvailableForWrite() < i && !this.this$0.getClosed());
                    }
                };
                byteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1.L$0 = byteChannelSequentialBase;
                byteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1.I$0 = i;
                byteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1.label = 1;
                if (awaitingSlot.sleep(function0, byteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object awaitAtLeastNBytesAvailableForRead$ktor_io(final int i, Continuation<? super Unit> continuation) throws Throwable {
        ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1 byteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1;
        final ByteChannelSequentialBase byteChannelSequentialBase;
        if (continuation instanceof ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1) {
            byteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1 = (ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1) continuation;
            if ((byteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1.label & Integer.MIN_VALUE) != 0) {
                byteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1.label -= Integer.MIN_VALUE;
            } else {
                byteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1 = new ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1(this, continuation);
            }
        } else {
            byteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1 = new ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1(this, continuation);
        }
        Object obj = byteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = byteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            byteChannelSequentialBase = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = byteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1.I$0;
            byteChannelSequentialBase = (ByteChannelSequentialBase) byteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        while (byteChannelSequentialBase.get_availableForRead() < i && !byteChannelSequentialBase.isClosedForRead()) {
            AwaitingSlot awaitingSlot = byteChannelSequentialBase.slot;
            Function0<Boolean> function0 = new Function0<Boolean>() { // from class: io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.valueOf(this.this$0.get_availableForRead() < i && !this.this$0.isClosedForRead());
                }
            };
            byteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1.L$0 = byteChannelSequentialBase;
            byteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1.I$0 = i;
            byteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1.label = 1;
            if (awaitingSlot.sleep(function0, byteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public void flush() {
        flushImpl();
    }

    private final boolean flushImpl() {
        if (this.writable.isEmpty()) {
            this.slot.resume();
            return false;
        }
        flushWrittenBytes();
        this.slot.resume();
        return true;
    }

    private final void flushWrittenBytes() {
        synchronized (this.flushMutex) {
            int size = this.writable.getSize();
            ChunkBuffer chunkBufferStealAll$ktor_io = this.writable.stealAll$ktor_io();
            Intrinsics.checkNotNull(chunkBufferStealAll$ktor_io);
            this.flushBuffer.writeChunkBuffer$ktor_io(chunkBufferStealAll$ktor_io);
            _availableForRead$FU.addAndGet(this, size);
        }
    }

    protected final void prepareFlushedBytes() {
        synchronized (this.flushMutex) {
            UnsafeKt.unsafeAppend(this.readable, this.flushBuffer);
        }
    }

    private final void ensureNotClosed() throws Throwable {
        if (getClosed()) {
            Throwable closedCause = getClosedCause();
            if (closedCause != null) {
                throw closedCause;
            }
            throw new ClosedWriteChannelException("Channel " + this + " is already closed");
        }
    }

    private final void ensureNotFailed() throws Throwable {
        Throwable closedCause = getClosedCause();
        if (closedCause != null) {
            throw closedCause;
        }
    }

    private final void ensureNotFailed(BytePacketBuilder closeable) throws Throwable {
        Throwable closedCause = getClosedCause();
        if (closedCause == null) {
            return;
        }
        closeable.release();
        throw closedCause;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    static /* synthetic */ Object writeByte$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, byte b, Continuation<? super Unit> continuation) throws Throwable {
        C48131 c48131;
        if (continuation instanceof C48131) {
            c48131 = (C48131) continuation;
            if ((c48131.label & Integer.MIN_VALUE) != 0) {
                c48131.label -= Integer.MIN_VALUE;
            } else {
                c48131 = byteChannelSequentialBase.new C48131(continuation);
            }
        } else {
            c48131 = byteChannelSequentialBase.new C48131(continuation);
        }
        Object obj = c48131.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c48131.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            c48131.L$0 = byteChannelSequentialBase;
            c48131.B$0 = b;
            c48131.label = 1;
            if (byteChannelSequentialBase.awaitAtLeastNBytesAvailableForWrite$ktor_io(1, c48131) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b = c48131.B$0;
            byteChannelSequentialBase = (ByteChannelSequentialBase) c48131.L$0;
            ResultKt.throwOnFailure(obj);
        }
        byteChannelSequentialBase.writable.writeByte(b);
        byteChannelSequentialBase.afterWrite(1);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    static /* synthetic */ Object writeShort$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, short s, Continuation<? super Unit> continuation) throws Throwable {
        C48221 c48221;
        if (continuation instanceof C48221) {
            c48221 = (C48221) continuation;
            if ((c48221.label & Integer.MIN_VALUE) != 0) {
                c48221.label -= Integer.MIN_VALUE;
            } else {
                c48221 = byteChannelSequentialBase.new C48221(continuation);
            }
        } else {
            c48221 = byteChannelSequentialBase.new C48221(continuation);
        }
        Object obj = c48221.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c48221.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            c48221.L$0 = byteChannelSequentialBase;
            c48221.S$0 = s;
            c48221.label = 1;
            if (byteChannelSequentialBase.awaitAtLeastNBytesAvailableForWrite$ktor_io(2, c48221) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            s = c48221.S$0;
            byteChannelSequentialBase = (ByteChannelSequentialBase) c48221.L$0;
            ResultKt.throwOnFailure(obj);
        }
        OutputPrimitivesKt.writeShort(byteChannelSequentialBase.writable, s);
        byteChannelSequentialBase.afterWrite(2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    static /* synthetic */ Object writeInt$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, int i, Continuation<? super Unit> continuation) throws Throwable {
        C48191 c48191;
        if (continuation instanceof C48191) {
            c48191 = (C48191) continuation;
            if ((c48191.label & Integer.MIN_VALUE) != 0) {
                c48191.label -= Integer.MIN_VALUE;
            } else {
                c48191 = byteChannelSequentialBase.new C48191(continuation);
            }
        } else {
            c48191 = byteChannelSequentialBase.new C48191(continuation);
        }
        Object obj = c48191.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c48191.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            c48191.L$0 = byteChannelSequentialBase;
            c48191.I$0 = i;
            c48191.label = 1;
            if (byteChannelSequentialBase.awaitAtLeastNBytesAvailableForWrite$ktor_io(4, c48191) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = c48191.I$0;
            byteChannelSequentialBase = (ByteChannelSequentialBase) c48191.L$0;
            ResultKt.throwOnFailure(obj);
        }
        OutputPrimitivesKt.writeInt(byteChannelSequentialBase.writable, i);
        byteChannelSequentialBase.afterWrite(4);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    static /* synthetic */ Object writeLong$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, long j, Continuation<? super Unit> continuation) throws Throwable {
        C48201 c48201;
        if (continuation instanceof C48201) {
            c48201 = (C48201) continuation;
            if ((c48201.label & Integer.MIN_VALUE) != 0) {
                c48201.label -= Integer.MIN_VALUE;
            } else {
                c48201 = byteChannelSequentialBase.new C48201(continuation);
            }
        } else {
            c48201 = byteChannelSequentialBase.new C48201(continuation);
        }
        Object obj = c48201.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c48201.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            c48201.L$0 = byteChannelSequentialBase;
            c48201.J$0 = j;
            c48201.label = 1;
            if (byteChannelSequentialBase.awaitAtLeastNBytesAvailableForWrite$ktor_io(8, c48201) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j = c48201.J$0;
            byteChannelSequentialBase = (ByteChannelSequentialBase) c48201.L$0;
            ResultKt.throwOnFailure(obj);
        }
        OutputPrimitivesKt.writeLong(byteChannelSequentialBase.writable, j);
        byteChannelSequentialBase.afterWrite(8);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    static /* synthetic */ Object writeFloat$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, float f, Continuation<? super Unit> continuation) throws Throwable {
        C48151 c48151;
        if (continuation instanceof C48151) {
            c48151 = (C48151) continuation;
            if ((c48151.label & Integer.MIN_VALUE) != 0) {
                c48151.label -= Integer.MIN_VALUE;
            } else {
                c48151 = byteChannelSequentialBase.new C48151(continuation);
            }
        } else {
            c48151 = byteChannelSequentialBase.new C48151(continuation);
        }
        Object obj = c48151.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c48151.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            c48151.L$0 = byteChannelSequentialBase;
            c48151.F$0 = f;
            c48151.label = 1;
            if (byteChannelSequentialBase.awaitAtLeastNBytesAvailableForWrite$ktor_io(4, c48151) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f = c48151.F$0;
            byteChannelSequentialBase = (ByteChannelSequentialBase) c48151.L$0;
            ResultKt.throwOnFailure(obj);
        }
        OutputPrimitivesKt.writeFloat(byteChannelSequentialBase.writable, f);
        byteChannelSequentialBase.afterWrite(4);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    static /* synthetic */ Object writeDouble$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, double d, Continuation<? super Unit> continuation) throws Throwable {
        C48141 c48141;
        if (continuation instanceof C48141) {
            c48141 = (C48141) continuation;
            if ((c48141.label & Integer.MIN_VALUE) != 0) {
                c48141.label -= Integer.MIN_VALUE;
            } else {
                c48141 = byteChannelSequentialBase.new C48141(continuation);
            }
        } else {
            c48141 = byteChannelSequentialBase.new C48141(continuation);
        }
        Object obj = c48141.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c48141.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            c48141.L$0 = byteChannelSequentialBase;
            c48141.D$0 = d;
            c48141.label = 1;
            if (byteChannelSequentialBase.awaitAtLeastNBytesAvailableForWrite$ktor_io(8, c48141) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d = c48141.D$0;
            byteChannelSequentialBase = (ByteChannelSequentialBase) c48141.L$0;
            ResultKt.throwOnFailure(obj);
        }
        OutputPrimitivesKt.writeDouble(byteChannelSequentialBase.writable, d);
        byteChannelSequentialBase.afterWrite(8);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    static /* synthetic */ Object writePacket$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, ByteReadPacket byteReadPacket, Continuation<? super Unit> continuation) throws Throwable {
        C48211 c48211;
        if (continuation instanceof C48211) {
            c48211 = (C48211) continuation;
            if ((c48211.label & Integer.MIN_VALUE) != 0) {
                c48211.label -= Integer.MIN_VALUE;
            } else {
                c48211 = byteChannelSequentialBase.new C48211(continuation);
            }
        } else {
            c48211 = byteChannelSequentialBase.new C48211(continuation);
        }
        Object obj = c48211.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c48211.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            c48211.L$0 = byteChannelSequentialBase;
            c48211.L$1 = byteReadPacket;
            c48211.label = 1;
            if (byteChannelSequentialBase.awaitAtLeastNBytesAvailableForWrite$ktor_io(1, c48211) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            byteReadPacket = (ByteReadPacket) c48211.L$1;
            byteChannelSequentialBase = (ByteChannelSequentialBase) c48211.L$0;
            ResultKt.throwOnFailure(obj);
        }
        int remaining = (int) byteReadPacket.getRemaining();
        byteChannelSequentialBase.writable.writePacket(byteReadPacket);
        byteChannelSequentialBase.afterWrite(remaining);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    static /* synthetic */ Object writeFully$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Buffer buffer, Continuation<? super Unit> continuation) throws Throwable {
        C48161 c48161;
        if (continuation instanceof C48161) {
            c48161 = (C48161) continuation;
            if ((c48161.label & Integer.MIN_VALUE) != 0) {
                c48161.label -= Integer.MIN_VALUE;
            } else {
                c48161 = byteChannelSequentialBase.new C48161(continuation);
            }
        } else {
            c48161 = byteChannelSequentialBase.new C48161(continuation);
        }
        Object obj = c48161.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c48161.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            c48161.L$0 = byteChannelSequentialBase;
            c48161.L$1 = buffer;
            c48161.label = 1;
            if (byteChannelSequentialBase.awaitAtLeastNBytesAvailableForWrite$ktor_io(1, c48161) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            buffer = (Buffer) c48161.L$1;
            byteChannelSequentialBase = (ByteChannelSequentialBase) c48161.L$0;
            ResultKt.throwOnFailure(obj);
        }
        int writePosition = buffer.getWritePosition() - buffer.getReadPosition();
        OutputKt.writeFully$default(byteChannelSequentialBase.writable, buffer, 0, 2, null);
        byteChannelSequentialBase.afterWrite(writePosition);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x004c  */
    /* JADX WARN: Code duplicated, block: B:18:0x005c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x005a -> B:19:0x005d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    static /* synthetic */ java.lang.Object writeFully$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase r5, byte[] r6, int r7, int r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            boolean r0 = r9 instanceof io.ktor.utils.io.ByteChannelSequentialBase.C48172
            if (r0 == 0) goto L14
            r0 = r9
            io.ktor.utils.io.ByteChannelSequentialBase$writeFully$2 r0 = (io.ktor.utils.io.ByteChannelSequentialBase.C48172) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$writeFully$2 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeFully$2
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L41
            if (r2 != r3) goto L39
            int r5 = r0.I$1
            int r6 = r0.I$0
            java.lang.Object r7 = r0.L$1
            byte[] r7 = (byte[]) r7
            java.lang.Object r8 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r8 = (io.ktor.utils.io.ByteChannelSequentialBase) r8
            kotlin.ResultKt.throwOnFailure(r9)
            r4 = r8
            r8 = r6
            r6 = r4
            goto L5d
        L39:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L41:
            kotlin.ResultKt.throwOnFailure(r9)
            int r8 = r8 + r7
            r4 = r6
            r6 = r5
            r5 = r8
            r8 = r7
            r7 = r4
        L4a:
            if (r8 >= r5) goto L73
            r0.L$0 = r6
            r0.L$1 = r7
            r0.I$0 = r8
            r0.I$1 = r5
            r0.label = r3
            java.lang.Object r9 = r6.awaitAtLeastNBytesAvailableForWrite$ktor_io(r3, r0)
            if (r9 != r1) goto L5d
            return r1
        L5d:
            int r9 = r6.getAvailableForWrite()
            int r2 = r5 - r8
            int r9 = java.lang.Math.min(r9, r2)
            io.ktor.utils.io.core.BytePacketBuilder r2 = r6.writable
            io.ktor.utils.io.core.Output r2 = (io.ktor.utils.io.core.Output) r2
            io.ktor.utils.io.core.OutputKt.writeFully(r2, r7, r8, r9)
            int r8 = r8 + r9
            r6.afterWrite(r9)
            goto L4a
        L73:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.writeFully$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0048  */
    /* JADX WARN: Code duplicated, block: B:18:0x0058 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0056 -> B:19:0x0059). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: writeFully-JT6ljtQ$suspendImpl, reason: not valid java name */
    static /* synthetic */ java.lang.Object m7620writeFullyJT6ljtQ$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase r5, java.nio.ByteBuffer r6, int r7, int r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            boolean r0 = r9 instanceof io.ktor.utils.io.ByteChannelSequentialBase.C48183
            if (r0 == 0) goto L14
            r0 = r9
            io.ktor.utils.io.ByteChannelSequentialBase$writeFully$3 r0 = (io.ktor.utils.io.ByteChannelSequentialBase.C48183) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$writeFully$3 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeFully$3
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L43
            if (r2 != r3) goto L3b
            int r5 = r0.I$1
            int r6 = r0.I$0
            java.lang.Object r7 = r0.L$1
            java.nio.ByteBuffer r7 = (java.nio.ByteBuffer) r7
            java.lang.Object r8 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r8 = (io.ktor.utils.io.ByteChannelSequentialBase) r8
            kotlin.ResultKt.throwOnFailure(r9)
            r4 = r7
            r7 = r5
            r5 = r8
            r8 = r6
            r6 = r4
            goto L59
        L3b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L43:
            kotlin.ResultKt.throwOnFailure(r9)
        L46:
            if (r7 >= r8) goto L6f
            r0.L$0 = r5
            r0.L$1 = r6
            r0.I$0 = r8
            r0.I$1 = r7
            r0.label = r3
            java.lang.Object r9 = r5.awaitAtLeastNBytesAvailableForWrite$ktor_io(r3, r0)
            if (r9 != r1) goto L59
            return r1
        L59:
            int r9 = r5.getAvailableForWrite()
            int r2 = r8 - r7
            int r9 = java.lang.Math.min(r9, r2)
            io.ktor.utils.io.core.BytePacketBuilder r2 = r5.writable
            io.ktor.utils.io.core.Output r2 = (io.ktor.utils.io.core.Output) r2
            io.ktor.utils.io.core.OutputKt.m7845writeFullyUAd2zVI(r2, r6, r7, r9)
            int r7 = r7 + r9
            r5.afterWrite(r9)
            goto L46
        L6f:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.m7620writeFullyJT6ljtQ$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, java.nio.ByteBuffer, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object writeAvailable$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, ChunkBuffer chunkBuffer, Continuation<? super Integer> continuation) throws Throwable {
        ChunkBuffer chunkBuffer2 = chunkBuffer;
        int writePosition = chunkBuffer2.getWritePosition() - chunkBuffer2.getReadPosition();
        if (writePosition == 0) {
            return Boxing.boxInt(0);
        }
        int iMin = Math.min(writePosition, byteChannelSequentialBase.getAvailableForWrite());
        if (iMin == 0) {
            return byteChannelSequentialBase.writeAvailableSuspend(chunkBuffer, continuation);
        }
        OutputKt.writeFully(byteChannelSequentialBase.writable, chunkBuffer2, iMin);
        byteChannelSequentialBase.afterWrite(iMin);
        return Boxing.boxInt(iMin);
    }

    static /* synthetic */ Object writeAvailable$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, byte[] bArr, int i, int i2, Continuation<? super Integer> continuation) throws Throwable {
        if (i2 == 0) {
            return Boxing.boxInt(0);
        }
        int iMin = Math.min(i2, byteChannelSequentialBase.getAvailableForWrite());
        if (iMin == 0) {
            return byteChannelSequentialBase.writeAvailableSuspend(bArr, i, i2, continuation);
        }
        OutputKt.writeFully((Output) byteChannelSequentialBase.writable, bArr, i, iMin);
        byteChannelSequentialBase.afterWrite(iMin);
        return Boxing.boxInt(iMin);
    }

    @Deprecated(message = "Use write { } instead.")
    static /* synthetic */ Object writeSuspendSession$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Function2<? super WriterSuspendSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object objInvoke = function2.invoke(byteChannelSequentialBase.beginWriteSession(), continuation);
        return objInvoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInvoke : Unit.INSTANCE;
    }

    @Override // io.ktor.utils.io.HasWriteSession
    public WriterSuspendSession beginWriteSession() {
        return new WriterSuspendSession() { // from class: io.ktor.utils.io.ByteChannelSequentialBase.beginWriteSession.1
            @Override // io.ktor.utils.io.WriterSession
            public ChunkBuffer request(int min) {
                if (ByteChannelSequentialBase.this.getAvailableForWrite() == 0) {
                    return null;
                }
                return ByteChannelSequentialBase.this.getWritable().prepareWriteHead(min);
            }

            @Override // io.ktor.utils.io.WriterSession
            public void written(int n) throws Throwable {
                ByteChannelSequentialBase.this.getWritable().afterHeadWrite();
                ByteChannelSequentialBase.this.afterWrite(n);
            }

            @Override // io.ktor.utils.io.WriterSession
            public void flush() {
                ByteChannelSequentialBase.this.flush();
            }

            @Override // io.ktor.utils.io.WriterSuspendSession
            public Object tryAwait(int i, Continuation<? super Unit> continuation) throws Throwable {
                if (ByteChannelSequentialBase.this.getAvailableForWrite() < i) {
                    Object objAwaitAtLeastNBytesAvailableForWrite$ktor_io = ByteChannelSequentialBase.this.awaitAtLeastNBytesAvailableForWrite$ktor_io(i, continuation);
                    return objAwaitAtLeastNBytesAvailableForWrite$ktor_io == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitAtLeastNBytesAvailableForWrite$ktor_io : Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            }
        };
    }

    @Override // io.ktor.utils.io.HasWriteSession
    public void endWriteSession(int written) throws Throwable {
        this.writable.afterHeadWrite();
        afterWrite(written);
    }

    static /* synthetic */ Object readByte$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Continuation<? super Byte> continuation) {
        if (!byteChannelSequentialBase.readable.getEndOfInput()) {
            byte b = byteChannelSequentialBase.readable.readByte();
            byteChannelSequentialBase.afterRead(1);
            return Boxing.boxByte(b);
        }
        return byteChannelSequentialBase.readByteSlow(continuation);
    }

    static /* synthetic */ void checkClosed$default(ByteChannelSequentialBase byteChannelSequentialBase, int i, BytePacketBuilder bytePacketBuilder, int i2, Object obj) throws Throwable {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkClosed");
        }
        if ((i2 & 2) != 0) {
            bytePacketBuilder = null;
        }
        byteChannelSequentialBase.checkClosed(i, bytePacketBuilder);
    }

    private final void checkClosed(int remaining, BytePacketBuilder closeable) throws Throwable {
        Throwable closedCause = getClosedCause();
        if (closedCause != null) {
            if (closeable != null) {
                closeable.close();
                throw closedCause;
            }
            throw closedCause;
        }
        if (!getClosed() || get_availableForRead() >= remaining) {
            return;
        }
        if (closeable != null) {
            closeable.close();
        }
        throw new EOFException(remaining + " bytes required but EOF reached");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:17:0x0044 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x004d  */
    /* JADX WARN: Code duplicated, block: B:22:0x0061  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0042 -> B:18:0x0045). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object readByteSlow(kotlin.coroutines.Continuation<? super java.lang.Byte> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase.C47981
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$readByteSlow$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase.C47981) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$readByteSlow$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readByteSlow$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r2 = (io.ktor.utils.io.ByteChannelSequentialBase) r2
            kotlin.ResultKt.throwOnFailure(r6)
            goto L45
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L36:
            kotlin.ResultKt.throwOnFailure(r6)
            r2 = r5
        L3a:
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r6 = r2.awaitSuspend(r3, r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            io.ktor.utils.io.core.ByteReadPacket r6 = r2.readable
            boolean r6 = r6.getEndOfInput()
            if (r6 != 0) goto L61
            io.ktor.utils.io.core.ByteReadPacket r6 = r2.readable
            byte r6 = r6.readByte()
            java.lang.Byte r6 = kotlin.coroutines.jvm.internal.Boxing.boxByte(r6)
            r0 = r6
            java.lang.Number r0 = (java.lang.Number) r0
            r0.byteValue()
            r2.afterRead(r3)
            return r6
        L61:
            r6 = 2
            r4 = 0
            checkClosed$default(r2, r3, r4, r6, r4)
            goto L3a
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.readByteSlow(kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object readShort$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Continuation<? super Short> continuation) {
        if (byteChannelSequentialBase.readable.hasBytes(2)) {
            short s = InputPrimitivesKt.readShort(byteChannelSequentialBase.readable);
            byteChannelSequentialBase.afterRead(2);
            return Boxing.boxShort(s);
        }
        return byteChannelSequentialBase.readShortSlow(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object readShortSlow(Continuation<? super Short> continuation) throws Throwable {
        C48071 c48071;
        ByteChannelSequentialBase byteChannelSequentialBase;
        if (continuation instanceof C48071) {
            c48071 = (C48071) continuation;
            if ((c48071.label & Integer.MIN_VALUE) != 0) {
                c48071.label -= Integer.MIN_VALUE;
            } else {
                c48071 = new C48071(continuation);
            }
        } else {
            c48071 = new C48071(continuation);
        }
        Object obj = c48071.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c48071.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            c48071.L$0 = this;
            c48071.label = 1;
            if (awaitSuspend(2, c48071) == coroutine_suspended) {
                return coroutine_suspended;
            }
            byteChannelSequentialBase = this;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            byteChannelSequentialBase = (ByteChannelSequentialBase) c48071.L$0;
            ResultKt.throwOnFailure(obj);
        }
        short s = InputPrimitivesKt.readShort(byteChannelSequentialBase.readable);
        byteChannelSequentialBase.afterRead(2);
        return Boxing.boxShort(s);
    }

    protected final void afterRead(int count) {
        addBytesRead(count);
        this.slot.resume();
    }

    static /* synthetic */ Object readInt$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Continuation<? super Integer> continuation) {
        if (byteChannelSequentialBase.readable.hasBytes(4)) {
            int i = InputPrimitivesKt.readInt(byteChannelSequentialBase.readable);
            byteChannelSequentialBase.afterRead(4);
            return Boxing.boxInt(i);
        }
        return byteChannelSequentialBase.readIntSlow(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object readIntSlow(Continuation<? super Integer> continuation) throws Throwable {
        C48031 c48031;
        ByteChannelSequentialBase byteChannelSequentialBase;
        if (continuation instanceof C48031) {
            c48031 = (C48031) continuation;
            if ((c48031.label & Integer.MIN_VALUE) != 0) {
                c48031.label -= Integer.MIN_VALUE;
            } else {
                c48031 = new C48031(continuation);
            }
        } else {
            c48031 = new C48031(continuation);
        }
        Object obj = c48031.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c48031.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            c48031.L$0 = this;
            c48031.label = 1;
            if (awaitSuspend(4, c48031) == coroutine_suspended) {
                return coroutine_suspended;
            }
            byteChannelSequentialBase = this;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            byteChannelSequentialBase = (ByteChannelSequentialBase) c48031.L$0;
            ResultKt.throwOnFailure(obj);
        }
        int i2 = InputPrimitivesKt.readInt(byteChannelSequentialBase.readable);
        byteChannelSequentialBase.afterRead(4);
        return Boxing.boxInt(i2);
    }

    static /* synthetic */ Object readLong$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Continuation<? super Long> continuation) {
        if (byteChannelSequentialBase.readable.hasBytes(8)) {
            long j = InputPrimitivesKt.readLong(byteChannelSequentialBase.readable);
            byteChannelSequentialBase.afterRead(8);
            return Boxing.boxLong(j);
        }
        return byteChannelSequentialBase.readLongSlow(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object readLongSlow(Continuation<? super Long> continuation) throws Throwable {
        C48041 c48041;
        ByteChannelSequentialBase byteChannelSequentialBase;
        if (continuation instanceof C48041) {
            c48041 = (C48041) continuation;
            if ((c48041.label & Integer.MIN_VALUE) != 0) {
                c48041.label -= Integer.MIN_VALUE;
            } else {
                c48041 = new C48041(continuation);
            }
        } else {
            c48041 = new C48041(continuation);
        }
        Object obj = c48041.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c48041.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            c48041.L$0 = this;
            c48041.label = 1;
            if (awaitSuspend(8, c48041) == coroutine_suspended) {
                return coroutine_suspended;
            }
            byteChannelSequentialBase = this;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            byteChannelSequentialBase = (ByteChannelSequentialBase) c48041.L$0;
            ResultKt.throwOnFailure(obj);
        }
        long j = InputPrimitivesKt.readLong(byteChannelSequentialBase.readable);
        byteChannelSequentialBase.afterRead(8);
        return Boxing.boxLong(j);
    }

    static /* synthetic */ Object readFloat$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Continuation<? super Float> continuation) {
        if (byteChannelSequentialBase.readable.hasBytes(4)) {
            float f = InputPrimitivesKt.readFloat(byteChannelSequentialBase.readable);
            byteChannelSequentialBase.afterRead(4);
            return Boxing.boxFloat(f);
        }
        return byteChannelSequentialBase.readFloatSlow(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object readFloatSlow(Continuation<? super Float> continuation) throws Throwable {
        C48001 c48001;
        ByteChannelSequentialBase byteChannelSequentialBase;
        if (continuation instanceof C48001) {
            c48001 = (C48001) continuation;
            if ((c48001.label & Integer.MIN_VALUE) != 0) {
                c48001.label -= Integer.MIN_VALUE;
            } else {
                c48001 = new C48001(continuation);
            }
        } else {
            c48001 = new C48001(continuation);
        }
        Object obj = c48001.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c48001.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            c48001.L$0 = this;
            c48001.label = 1;
            if (awaitSuspend(4, c48001) == coroutine_suspended) {
                return coroutine_suspended;
            }
            byteChannelSequentialBase = this;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            byteChannelSequentialBase = (ByteChannelSequentialBase) c48001.L$0;
            ResultKt.throwOnFailure(obj);
        }
        float f = InputPrimitivesKt.readFloat(byteChannelSequentialBase.readable);
        byteChannelSequentialBase.afterRead(4);
        return Boxing.boxFloat(f);
    }

    static /* synthetic */ Object readDouble$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Continuation<? super Double> continuation) {
        if (byteChannelSequentialBase.readable.hasBytes(8)) {
            double d = InputPrimitivesKt.readDouble(byteChannelSequentialBase.readable);
            byteChannelSequentialBase.afterRead(8);
            return Boxing.boxDouble(d);
        }
        return byteChannelSequentialBase.readDoubleSlow(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object readDoubleSlow(Continuation<? super Double> continuation) throws Throwable {
        C47991 c47991;
        ByteChannelSequentialBase byteChannelSequentialBase;
        if (continuation instanceof C47991) {
            c47991 = (C47991) continuation;
            if ((c47991.label & Integer.MIN_VALUE) != 0) {
                c47991.label -= Integer.MIN_VALUE;
            } else {
                c47991 = new C47991(continuation);
            }
        } else {
            c47991 = new C47991(continuation);
        }
        Object obj = c47991.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c47991.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            c47991.L$0 = this;
            c47991.label = 1;
            if (awaitSuspend(8, c47991) == coroutine_suspended) {
                return coroutine_suspended;
            }
            byteChannelSequentialBase = this;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            byteChannelSequentialBase = (ByteChannelSequentialBase) c47991.L$0;
            ResultKt.throwOnFailure(obj);
        }
        double d = InputPrimitivesKt.readDouble(byteChannelSequentialBase.readable);
        byteChannelSequentialBase.afterRead(8);
        return Boxing.boxDouble(d);
    }

    static /* synthetic */ Object readRemaining$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, long j, Continuation<? super ByteReadPacket> continuation) throws Throwable {
        byteChannelSequentialBase.ensureNotFailed();
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(null, 1, null);
        long jMin = Math.min(j, byteChannelSequentialBase.readable.getRemaining());
        bytePacketBuilder.writePacket(byteChannelSequentialBase.readable, jMin);
        byteChannelSequentialBase.afterRead((int) jMin);
        if (j - ((long) bytePacketBuilder.getSize()) == 0 || byteChannelSequentialBase.isClosedForRead()) {
            byteChannelSequentialBase.ensureNotFailed(bytePacketBuilder);
            return bytePacketBuilder.build();
        }
        return byteChannelSequentialBase.readRemainingSuspend(bytePacketBuilder, j, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object readRemainingSuspend(BytePacketBuilder bytePacketBuilder, long j, Continuation<? super ByteReadPacket> continuation) throws Throwable {
        C48061 c48061;
        ByteChannelSequentialBase byteChannelSequentialBase;
        if (continuation instanceof C48061) {
            c48061 = (C48061) continuation;
            if ((c48061.label & Integer.MIN_VALUE) != 0) {
                c48061.label -= Integer.MIN_VALUE;
            } else {
                c48061 = new C48061(continuation);
            }
        } else {
            c48061 = new C48061(continuation);
        }
        Object obj = c48061.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c48061.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            byteChannelSequentialBase = this;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long j2 = c48061.J$0;
            BytePacketBuilder bytePacketBuilder2 = (BytePacketBuilder) c48061.L$1;
            byteChannelSequentialBase = (ByteChannelSequentialBase) c48061.L$0;
            ResultKt.throwOnFailure(obj);
            bytePacketBuilder = bytePacketBuilder2;
            j = j2;
        }
        while (bytePacketBuilder.getSize() < j) {
            long jMin = Math.min(j - ((long) bytePacketBuilder.getSize()), byteChannelSequentialBase.readable.getRemaining());
            bytePacketBuilder.writePacket(byteChannelSequentialBase.readable, jMin);
            byteChannelSequentialBase.afterRead((int) jMin);
            byteChannelSequentialBase.ensureNotFailed(bytePacketBuilder);
            if (byteChannelSequentialBase.isClosedForRead() || bytePacketBuilder.getSize() == ((int) j)) {
                break;
            }
            c48061.L$0 = byteChannelSequentialBase;
            c48061.L$1 = bytePacketBuilder;
            c48061.J$0 = j;
            c48061.label = 1;
            if (byteChannelSequentialBase.awaitSuspend(1, c48061) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        byteChannelSequentialBase.ensureNotFailed(bytePacketBuilder);
        return bytePacketBuilder.build();
    }

    static /* synthetic */ Object readPacket$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, int i, Continuation<? super ByteReadPacket> continuation) throws Throwable {
        checkClosed$default(byteChannelSequentialBase, i, null, 2, null);
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(null, 1, null);
        int iMin = (int) Math.min(i, byteChannelSequentialBase.readable.getRemaining());
        int i2 = i - iMin;
        bytePacketBuilder.writePacket(byteChannelSequentialBase.readable, iMin);
        byteChannelSequentialBase.afterRead(iMin);
        byteChannelSequentialBase.checkClosed(i2, bytePacketBuilder);
        if (i2 > 0) {
            return byteChannelSequentialBase.readPacketSuspend(bytePacketBuilder, i2, continuation);
        }
        return bytePacketBuilder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object readPacketSuspend(BytePacketBuilder bytePacketBuilder, int i, Continuation<? super ByteReadPacket> continuation) throws Throwable {
        C48051 c48051;
        ByteChannelSequentialBase byteChannelSequentialBase;
        if (continuation instanceof C48051) {
            c48051 = (C48051) continuation;
            if ((c48051.label & Integer.MIN_VALUE) != 0) {
                c48051.label -= Integer.MIN_VALUE;
            } else {
                c48051 = new C48051(continuation);
            }
        } else {
            c48051 = new C48051(continuation);
        }
        Object obj = c48051.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c48051.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            byteChannelSequentialBase = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i3 = c48051.I$0;
            BytePacketBuilder bytePacketBuilder2 = (BytePacketBuilder) c48051.L$1;
            byteChannelSequentialBase = (ByteChannelSequentialBase) c48051.L$0;
            ResultKt.throwOnFailure(obj);
            i = i3;
            bytePacketBuilder = bytePacketBuilder2;
        }
        while (i > 0) {
            int iMin = (int) Math.min(i, byteChannelSequentialBase.readable.getRemaining());
            i -= iMin;
            bytePacketBuilder.writePacket(byteChannelSequentialBase.readable, iMin);
            byteChannelSequentialBase.afterRead(iMin);
            byteChannelSequentialBase.checkClosed(i, bytePacketBuilder);
            if (i > 0) {
                c48051.L$0 = byteChannelSequentialBase;
                c48051.L$1 = bytePacketBuilder;
                c48051.I$0 = i;
                c48051.label = 1;
                if (byteChannelSequentialBase.awaitSuspend(1, c48051) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        byteChannelSequentialBase.checkClosed(i, bytePacketBuilder);
        return bytePacketBuilder.build();
    }

    protected final int readAvailableClosed() throws Throwable {
        Throwable closedCause = getClosedCause();
        if (closedCause != null) {
            throw closedCause;
        }
        if (get_availableForRead() <= 0) {
            return -1;
        }
        prepareFlushedBytes();
        return -1;
    }

    static /* synthetic */ Object readAvailable$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, ChunkBuffer chunkBuffer, Continuation<? super Integer> continuation) {
        Intrinsics.checkNotNull(chunkBuffer, "null cannot be cast to non-null type io.ktor.utils.io.core.Buffer");
        return byteChannelSequentialBase.readAvailable$ktor_io(chunkBuffer, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object readAvailable$ktor_io(Buffer buffer, Continuation<? super Integer> continuation) throws Throwable {
        AnonymousClass2 anonymousClass2;
        ByteChannelSequentialBase byteChannelSequentialBase;
        if (continuation instanceof AnonymousClass2) {
            anonymousClass2 = (AnonymousClass2) continuation;
            if ((anonymousClass2.label & Integer.MIN_VALUE) != 0) {
                anonymousClass2.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass2 = new AnonymousClass2(continuation);
            }
        } else {
            anonymousClass2 = new AnonymousClass2(continuation);
        }
        Object obj = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Throwable closedCause = getClosedCause();
            if (closedCause != null) {
                throw closedCause;
            }
            if (getClosed() && get_availableForRead() == 0) {
                return Boxing.boxInt(-1);
            }
            if (buffer.getLimit() - buffer.getWritePosition() == 0) {
                return Boxing.boxInt(0);
            }
            if (get_availableForRead() == 0) {
                anonymousClass2.L$0 = this;
                anonymousClass2.L$1 = buffer;
                anonymousClass2.label = 1;
                if (awaitSuspend(1, anonymousClass2) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            byteChannelSequentialBase = this;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            buffer = (Buffer) anonymousClass2.L$1;
            byteChannelSequentialBase = (ByteChannelSequentialBase) anonymousClass2.L$0;
            ResultKt.throwOnFailure(obj);
        }
        if (!byteChannelSequentialBase.readable.canRead()) {
            byteChannelSequentialBase.prepareFlushedBytes();
        }
        int iMin = (int) Math.min(buffer.getLimit() - buffer.getWritePosition(), byteChannelSequentialBase.readable.getRemaining());
        InputArraysKt.readFully(byteChannelSequentialBase.readable, buffer, iMin);
        byteChannelSequentialBase.afterRead(iMin);
        return Boxing.boxInt(iMin);
    }

    static /* synthetic */ Object readFully$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, ChunkBuffer chunkBuffer, int i, Continuation<? super Unit> continuation) throws Throwable {
        Intrinsics.checkNotNull(chunkBuffer, "null cannot be cast to non-null type io.ktor.utils.io.core.Buffer");
        Object fully = byteChannelSequentialBase.readFully((Buffer) chunkBuffer, i, continuation);
        return fully == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? fully : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object readFullySuspend(Buffer buffer, int i, Continuation<? super Unit> continuation) throws Throwable {
        C48011 c48011;
        ByteChannelSequentialBase byteChannelSequentialBase;
        if (continuation instanceof C48011) {
            c48011 = (C48011) continuation;
            if ((c48011.label & Integer.MIN_VALUE) != 0) {
                c48011.label -= Integer.MIN_VALUE;
            } else {
                c48011 = new C48011(continuation);
            }
        } else {
            c48011 = new C48011(continuation);
        }
        Object obj = c48011.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c48011.label;
        if (i2 != 0) {
            if (i2 == 1) {
                i = c48011.I$0;
                buffer = (Buffer) c48011.L$1;
                byteChannelSequentialBase = (ByteChannelSequentialBase) c48011.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        c48011.L$0 = this;
        c48011.L$1 = buffer;
        c48011.I$0 = i;
        c48011.label = 1;
        if (awaitSuspend(i, c48011) == coroutine_suspended) {
            return coroutine_suspended;
        }
        byteChannelSequentialBase = this;
        c48011.L$0 = null;
        c48011.L$1 = null;
        c48011.label = 2;
        if (byteChannelSequentialBase.readFully(buffer, i, c48011) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    static /* synthetic */ Object readAvailable$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, byte[] bArr, int i, int i2, Continuation<? super Integer> continuation) throws Throwable {
        AnonymousClass4 anonymousClass4;
        if (continuation instanceof AnonymousClass4) {
            anonymousClass4 = (AnonymousClass4) continuation;
            if ((anonymousClass4.label & Integer.MIN_VALUE) != 0) {
                anonymousClass4.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass4 = byteChannelSequentialBase.new AnonymousClass4(continuation);
            }
        } else {
            anonymousClass4 = byteChannelSequentialBase.new AnonymousClass4(continuation);
        }
        Object obj = anonymousClass4.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = anonymousClass4.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Throwable closedCause = byteChannelSequentialBase.getClosedCause();
            if (closedCause != null) {
                throw closedCause;
            }
            if (byteChannelSequentialBase.getClosed() && byteChannelSequentialBase.get_availableForRead() == 0) {
                return Boxing.boxInt(-1);
            }
            if (i2 == 0) {
                return Boxing.boxInt(0);
            }
            if (byteChannelSequentialBase.get_availableForRead() == 0) {
                anonymousClass4.L$0 = byteChannelSequentialBase;
                anonymousClass4.L$1 = bArr;
                anonymousClass4.I$0 = i;
                anonymousClass4.I$1 = i2;
                anonymousClass4.label = 1;
                if (byteChannelSequentialBase.awaitSuspend(1, anonymousClass4) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i4 = anonymousClass4.I$1;
            int i5 = anonymousClass4.I$0;
            byte[] bArr2 = (byte[]) anonymousClass4.L$1;
            ByteChannelSequentialBase byteChannelSequentialBase2 = (ByteChannelSequentialBase) anonymousClass4.L$0;
            ResultKt.throwOnFailure(obj);
            i2 = i4;
            byteChannelSequentialBase = byteChannelSequentialBase2;
            i = i5;
            bArr = bArr2;
        }
        if (!byteChannelSequentialBase.readable.canRead()) {
            byteChannelSequentialBase.prepareFlushedBytes();
        }
        int iMin = (int) Math.min(i2, byteChannelSequentialBase.readable.getRemaining());
        InputArraysKt.readFully((Input) byteChannelSequentialBase.readable, bArr, i, iMin);
        byteChannelSequentialBase.afterRead(iMin);
        return Boxing.boxInt(iMin);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    static /* synthetic */ Object readFully$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, byte[] bArr, int i, int i2, Continuation<? super Unit> continuation) throws Throwable {
        AnonymousClass6 anonymousClass6;
        if (continuation instanceof AnonymousClass6) {
            anonymousClass6 = (AnonymousClass6) continuation;
            if ((anonymousClass6.label & Integer.MIN_VALUE) != 0) {
                anonymousClass6.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass6 = byteChannelSequentialBase.new AnonymousClass6(continuation);
            }
        } else {
            anonymousClass6 = byteChannelSequentialBase.new AnonymousClass6(continuation);
        }
        Object available = anonymousClass6.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = anonymousClass6.label;
        if (i3 != 0) {
            if (i3 == 1) {
                i2 = anonymousClass6.I$1;
                i = anonymousClass6.I$0;
                bArr = (byte[]) anonymousClass6.L$1;
                byteChannelSequentialBase = (ByteChannelSequentialBase) anonymousClass6.L$0;
                ResultKt.throwOnFailure(available);
            } else {
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(available);
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(available);
        anonymousClass6.L$0 = byteChannelSequentialBase;
        anonymousClass6.L$1 = bArr;
        anonymousClass6.I$0 = i;
        anonymousClass6.I$1 = i2;
        anonymousClass6.label = 1;
        available = byteChannelSequentialBase.readAvailable(bArr, i, i2, anonymousClass6);
        if (available == coroutine_suspended) {
            return coroutine_suspended;
        }
        int iIntValue = ((Number) available).intValue();
        if (iIntValue == i2) {
            return Unit.INSTANCE;
        }
        if (iIntValue == -1) {
            throw new EOFException("Unexpected end of stream");
        }
        anonymousClass6.L$0 = null;
        anonymousClass6.L$1 = null;
        anonymousClass6.label = 2;
        if (byteChannelSequentialBase.readFullySuspend(bArr, i + iIntValue, i2 - iIntValue, anonymousClass6) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:17:0x0050  */
    /* JADX WARN: Code duplicated, block: B:19:0x0066 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x0067  */
    /* JADX WARN: Code duplicated, block: B:23:0x0074  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0067 -> B:12:0x003a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object readFullySuspend(byte[] r8, int r9, int r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof io.ktor.utils.io.ByteChannelSequentialBase.C48022
            if (r0 == 0) goto L14
            r0 = r11
            io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$2 r0 = (io.ktor.utils.io.ByteChannelSequentialBase.C48022) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$2 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$2
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L44
            if (r2 != r3) goto L3c
            int r8 = r0.I$2
            int r9 = r0.I$1
            int r10 = r0.I$0
            java.lang.Object r2 = r0.L$1
            byte[] r2 = (byte[]) r2
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r4 = (io.ktor.utils.io.ByteChannelSequentialBase) r4
            kotlin.ResultKt.throwOnFailure(r11)
            r6 = r0
            r0 = r9
            r9 = r2
        L3a:
            r2 = r6
            goto L6b
        L3c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L44:
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = 0
            r4 = r7
            r6 = r9
            r9 = r8
            r8 = r11
            r11 = r10
            r10 = r6
        L4e:
            if (r8 >= r11) goto L80
            int r2 = r10 + r8
            int r5 = r11 - r8
            r0.L$0 = r4
            r0.L$1 = r9
            r0.I$0 = r10
            r0.I$1 = r11
            r0.I$2 = r8
            r0.label = r3
            java.lang.Object r2 = r4.readAvailable(r9, r2, r5, r0)
            if (r2 != r1) goto L67
            return r1
        L67:
            r6 = r0
            r0 = r11
            r11 = r2
            goto L3a
        L6b:
            java.lang.Number r11 = (java.lang.Number) r11
            int r11 = r11.intValue()
            r5 = -1
            if (r11 == r5) goto L78
            int r8 = r8 + r11
            r11 = r0
            r0 = r2
            goto L4e
        L78:
            java.io.EOFException r8 = new java.io.EOFException
            java.lang.String r9 = "Unexpected end of stream"
            r8.<init>(r9)
            throw r8
        L80:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.readFullySuspend(byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object readBoolean$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Continuation<? super Boolean> continuation) {
        if (byteChannelSequentialBase.readable.canRead()) {
            boolean z = byteChannelSequentialBase.readable.readByte() == 1;
            byteChannelSequentialBase.afterRead(1);
            return Boxing.boxBoolean(z);
        }
        return byteChannelSequentialBase.readBooleanSlow(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object readBooleanSlow(Continuation<? super Boolean> continuation) throws Throwable {
        C47971 c47971;
        ByteChannelSequentialBase byteChannelSequentialBase;
        if (continuation instanceof C47971) {
            c47971 = (C47971) continuation;
            if ((c47971.label & Integer.MIN_VALUE) != 0) {
                c47971.label -= Integer.MIN_VALUE;
            } else {
                c47971 = new C47971(continuation);
            }
        } else {
            c47971 = new C47971(continuation);
        }
        Object obj = c47971.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c47971.label;
        if (i != 0) {
            if (i == 1) {
                byteChannelSequentialBase = (ByteChannelSequentialBase) c47971.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
        }
        ResultKt.throwOnFailure(obj);
        c47971.L$0 = this;
        c47971.label = 1;
        if (awaitSuspend(1, c47971) == coroutine_suspended) {
            return coroutine_suspended;
        }
        byteChannelSequentialBase = this;
        checkClosed$default(byteChannelSequentialBase, 1, null, 2, null);
        c47971.L$0 = null;
        c47971.label = 2;
        obj = byteChannelSequentialBase.readBoolean(c47971);
        return obj == coroutine_suspended ? coroutine_suspended : obj;
    }

    private final void completeReading() {
        ChunkBuffer lastReadView = getLastReadView();
        int lastReadAvailable$delegate = getLastReadAvailable$delegate() - (lastReadView.getWritePosition() - lastReadView.getReadPosition());
        if (getLastReadView() != Buffer.INSTANCE.getEmpty()) {
            UnsafeKt.completeReadHead(this.readable, getLastReadView());
        }
        if (lastReadAvailable$delegate > 0) {
            afterRead(lastReadAvailable$delegate);
        }
        setLastReadAvailable(0);
        setLastReadView(ChunkBuffer.INSTANCE.getEmpty());
    }

    static /* synthetic */ Object await$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, int i, Continuation<? super Boolean> continuation) {
        if (i < 0) {
            throw new IllegalArgumentException(("atLeast parameter shouldn't be negative: " + i).toString());
        }
        long j = i;
        if (j > 4088) {
            throw new IllegalArgumentException(("atLeast parameter shouldn't be larger than max buffer size of 4088: " + i).toString());
        }
        byteChannelSequentialBase.completeReading();
        if (i == 0) {
            return Boxing.boxBoolean(!byteChannelSequentialBase.isClosedForRead());
        }
        return byteChannelSequentialBase.readable.getRemaining() >= j ? Boxing.boxBoolean(true) : byteChannelSequentialBase.awaitSuspend(i, continuation);
    }

    public final Object awaitInternalAtLeast1$ktor_io(Continuation<? super Boolean> continuation) {
        if (this.readable.getEndOfInput()) {
            return awaitSuspend(1, continuation);
        }
        return Boxing.boxBoolean(true);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    protected final Object awaitSuspend(int i, Continuation<? super Boolean> continuation) throws Throwable {
        C47941 c47941;
        ByteChannelSequentialBase byteChannelSequentialBase;
        if (continuation instanceof C47941) {
            c47941 = (C47941) continuation;
            if ((c47941.label & Integer.MIN_VALUE) != 0) {
                c47941.label -= Integer.MIN_VALUE;
            } else {
                c47941 = new C47941(continuation);
            }
        } else {
            c47941 = new C47941(continuation);
        }
        Object obj = c47941.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c47941.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (i < 0) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            c47941.L$0 = this;
            c47941.I$0 = i;
            c47941.label = 1;
            if (awaitAtLeastNBytesAvailableForRead$ktor_io(i, c47941) == coroutine_suspended) {
                return coroutine_suspended;
            }
            byteChannelSequentialBase = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = c47941.I$0;
            byteChannelSequentialBase = (ByteChannelSequentialBase) c47941.L$0;
            ResultKt.throwOnFailure(obj);
        }
        byteChannelSequentialBase.prepareFlushedBytes();
        Throwable closedCause = byteChannelSequentialBase.getClosedCause();
        if (closedCause == null) {
            return Boxing.boxBoolean(!byteChannelSequentialBase.isClosedForRead() && byteChannelSequentialBase.get_availableForRead() >= i);
        }
        throw closedCause;
    }

    @Override // io.ktor.utils.io.ReadSession
    public int discard(int n) throws Throwable {
        Throwable closedCause = getClosedCause();
        if (closedCause != null) {
            throw closedCause;
        }
        if (n == 0) {
            return 0;
        }
        int iDiscard = this.readable.discard(n);
        afterRead(n);
        requestNextView(1);
        return iDiscard;
    }

    @Override // io.ktor.utils.io.ReadSession
    public ChunkBuffer request(int atLeast) throws Throwable {
        Throwable closedCause = getClosedCause();
        if (closedCause != null) {
            throw closedCause;
        }
        completeReading();
        return requestNextView(atLeast);
    }

    private final ChunkBuffer requestNextView(int atLeast) {
        if (this.readable.getEndOfInput()) {
            prepareFlushedBytes();
        }
        ChunkBuffer chunkBufferPrepareReadHead$ktor_io = this.readable.prepareReadHead$ktor_io(atLeast);
        if (chunkBufferPrepareReadHead$ktor_io == null) {
            setLastReadView(ChunkBuffer.INSTANCE.getEmpty());
            setLastReadAvailable(0);
        } else {
            setLastReadView(chunkBufferPrepareReadHead$ktor_io);
            ChunkBuffer chunkBuffer = chunkBufferPrepareReadHead$ktor_io;
            setLastReadAvailable(chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition());
        }
        return chunkBufferPrepareReadHead$ktor_io;
    }

    static /* synthetic */ Object discard$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, long j, Continuation<? super Long> continuation) throws Throwable {
        long jDiscard = byteChannelSequentialBase.readable.discard(j);
        byteChannelSequentialBase.afterRead((int) jDiscard);
        if (jDiscard == j || byteChannelSequentialBase.isClosedForRead()) {
            byteChannelSequentialBase.ensureNotFailed();
            return Boxing.boxLong(jDiscard);
        }
        return byteChannelSequentialBase.discardSuspend(j, jDiscard, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006d, code lost:
    
        if (r2.isClosedForRead() == false) goto L15;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004d -> B:18:0x0050). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object discardSuspend(long r9, long r11, kotlin.coroutines.Continuation<? super java.lang.Long> r13) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r13 instanceof io.ktor.utils.io.ByteChannelSequentialBase.C47961
            if (r0 == 0) goto L14
            r0 = r13
            io.ktor.utils.io.ByteChannelSequentialBase$discardSuspend$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase.C47961) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$discardSuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$discardSuspend$1
            r0.<init>(r13)
        L19:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            long r9 = r0.J$1
            long r11 = r0.J$0
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r2 = (io.ktor.utils.io.ByteChannelSequentialBase) r2
            kotlin.ResultKt.throwOnFailure(r13)
            r6 = r9
            r9 = r11
            r11 = r6
            goto L50
        L35:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3d:
            kotlin.ResultKt.throwOnFailure(r13)
            r2 = r8
        L41:
            r0.L$0 = r2
            r0.J$0 = r9
            r0.J$1 = r11
            r0.label = r3
            java.lang.Object r13 = r2.await(r3, r0)
            if (r13 != r1) goto L50
            return r1
        L50:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 == 0) goto L6f
            io.ktor.utils.io.core.ByteReadPacket r13 = r2.readable
            long r4 = r9 - r11
            long r4 = r13.discard(r4)
            int r13 = (int) r4
            r2.afterRead(r13)
            long r11 = r11 + r4
            int r13 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r13 >= 0) goto L6f
            boolean r13 = r2.isClosedForRead()
            if (r13 == 0) goto L41
        L6f:
            r2.ensureNotFailed()
            java.lang.Long r9 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r11)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.discardSuspend(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    @Deprecated(message = "Use read instead.")
    public void readSession(Function1<? super ReadSession, Unit> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        try {
            consumer.invoke(this);
        } finally {
            completeReading();
        }
    }

    @Override // io.ktor.utils.io.HasReadSession
    public SuspendableReadSession startReadSession() {
        return this;
    }

    @Override // io.ktor.utils.io.HasReadSession
    public void endReadSession() {
        completeReading();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [io.ktor.utils.io.ByteChannelSequentialBase, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v1, types: [io.ktor.utils.io.ByteChannelSequentialBase] */
    /* JADX WARN: Type inference failed for: r4v2, types: [io.ktor.utils.io.ByteChannelSequentialBase] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object, kotlin.Unit] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    @Deprecated(message = "Use read instead.")
    static /* synthetic */ Object readSuspendableSession$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Function2<? super SuspendableReadSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) throws Throwable {
        C48081 c48081;
        ?? r4;
        if (continuation instanceof C48081) {
            c48081 = (C48081) continuation;
            if ((c48081.label & Integer.MIN_VALUE) != 0) {
                c48081.label -= Integer.MIN_VALUE;
            } else {
                c48081 = new C48081(continuation);
            }
        } else {
            c48081 = new C48081(continuation);
        }
        Object obj = c48081.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c48081.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                c48081.L$0 = byteChannelSequentialBase;
                c48081.label = 1;
                Object objInvoke = function2.invoke(byteChannelSequentialBase, c48081);
                r4 = byteChannelSequentialBase;
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ByteChannelSequentialBase byteChannelSequentialBase2 = (ByteChannelSequentialBase) c48081.L$0;
                ResultKt.throwOnFailure(obj);
                r4 = byteChannelSequentialBase2;
            }
            r4.completeReading();
            byteChannelSequentialBase = Unit.INSTANCE;
            return byteChannelSequentialBase;
        } catch (Throwable th) {
            byteChannelSequentialBase.completeReading();
            throw th;
        }
    }

    static /* synthetic */ <A extends Appendable> Object readUTF8LineTo$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, A a2, int i, Continuation<? super Boolean> continuation) throws Throwable {
        if (byteChannelSequentialBase.isClosedForRead()) {
            Throwable closedCause = byteChannelSequentialBase.getClosedCause();
            if (closedCause != null) {
                throw closedCause;
            }
            return Boxing.boxBoolean(false);
        }
        return UTF8Kt.decodeUTF8LineLoopSuspend(a2, i, byteChannelSequentialBase.new C48102(null), new Function1<Integer, Unit>() { // from class: io.ktor.utils.io.ByteChannelSequentialBase.readUTF8LineTo.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i2) {
                ByteChannelSequentialBase.this.afterRead(i2);
            }
        }, continuation);
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readUTF8LineTo$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\f\b\u0000\u0010\u0002*\u00060\u0003j\u0002`\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u008a@"}, d2 = {"<anonymous>", "Lio/ktor/utils/io/core/Input;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", ContentDisposition.Parameters.Size, ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase$readUTF8LineTo$2", f = "ByteChannelSequential.kt", i = {}, l = {721}, m = "invokeSuspend", n = {}, s = {})
    static final class C48102 extends SuspendLambda implements Function2<Integer, Continuation<? super Input>, Object> {
        /* synthetic */ int I$0;
        int label;

        C48102(Continuation<? super C48102> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C48102 c48102 = ByteChannelSequentialBase.this.new C48102(continuation);
            c48102.I$0 = ((Number) obj).intValue();
            return c48102;
        }

        public final Object invoke(int i, Continuation<? super Input> continuation) {
            return ((C48102) create(Integer.valueOf(i), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Integer num, Continuation<? super Input> continuation) {
            return invoke(num.intValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                int i2 = this.I$0;
                this.label = 1;
                obj = ByteChannelSequentialBase.this.await(i2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (((Boolean) obj).booleanValue()) {
                return ByteChannelSequentialBase.this.getReadable();
            }
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    static /* synthetic */ Object readUTF8Line$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, int i, Continuation<? super String> continuation) throws Throwable {
        C48091 c48091;
        StringBuilder sb;
        if (continuation instanceof C48091) {
            c48091 = (C48091) continuation;
            if ((c48091.label & Integer.MIN_VALUE) != 0) {
                c48091.label -= Integer.MIN_VALUE;
            } else {
                c48091 = byteChannelSequentialBase.new C48091(continuation);
            }
        } else {
            c48091 = byteChannelSequentialBase.new C48091(continuation);
        }
        Object obj = c48091.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c48091.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            StringBuilder sb2 = new StringBuilder();
            c48091.L$0 = sb2;
            c48091.label = 1;
            Object uTF8LineTo = byteChannelSequentialBase.readUTF8LineTo(sb2, i, c48091);
            if (uTF8LineTo == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = uTF8LineTo;
            sb = sb2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            sb = (StringBuilder) c48091.L$0;
            ResultKt.throwOnFailure(obj);
        }
        if (((Boolean) obj).booleanValue()) {
            return sb.toString();
        }
        return null;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public boolean cancel(Throwable cause) {
        if (getClosedCause() != null || getClosed()) {
            return false;
        }
        if (cause == null) {
            cause = new CancellationException("Channel cancelled");
        }
        return close(cause);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public boolean close(Throwable cause) {
        if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_closed$FU, this, null, cause == null ? CloseElementKt.getCLOSED_SUCCESS() : new CloseElement(cause))) {
            return false;
        }
        if (cause != null) {
            this.readable.release();
            this.writable.release();
            this.flushBuffer.release();
        } else {
            flush();
            this.writable.release();
        }
        this.slot.cancel(cause);
        return true;
    }

    public final long transferTo$ktor_io(ByteChannelSequentialBase dst, long limit) throws Throwable {
        Intrinsics.checkNotNullParameter(dst, "dst");
        long remaining = this.readable.getRemaining();
        if (remaining > limit) {
            return 0L;
        }
        dst.writable.writePacket(this.readable);
        int i = (int) remaining;
        dst.afterWrite(i);
        afterRead(i);
        return remaining;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object writeAvailableSuspend(ChunkBuffer chunkBuffer, Continuation<? super Integer> continuation) throws Throwable {
        C48111 c48111;
        ByteChannelSequentialBase byteChannelSequentialBase;
        if (continuation instanceof C48111) {
            c48111 = (C48111) continuation;
            if ((c48111.label & Integer.MIN_VALUE) != 0) {
                c48111.label -= Integer.MIN_VALUE;
            } else {
                c48111 = new C48111(continuation);
            }
        } else {
            c48111 = new C48111(continuation);
        }
        Object objWriteAvailable = c48111.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c48111.label;
        if (i != 0) {
            if (i == 1) {
                chunkBuffer = (ChunkBuffer) c48111.L$1;
                byteChannelSequentialBase = (ByteChannelSequentialBase) c48111.L$0;
                ResultKt.throwOnFailure(objWriteAvailable);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objWriteAvailable);
            }
        }
        ResultKt.throwOnFailure(objWriteAvailable);
        c48111.L$0 = this;
        c48111.L$1 = chunkBuffer;
        c48111.label = 1;
        if (awaitAtLeastNBytesAvailableForWrite$ktor_io(1, c48111) == coroutine_suspended) {
            return coroutine_suspended;
        }
        byteChannelSequentialBase = this;
        c48111.L$0 = null;
        c48111.L$1 = null;
        c48111.label = 2;
        objWriteAvailable = byteChannelSequentialBase.writeAvailable(chunkBuffer, c48111);
        return objWriteAvailable == coroutine_suspended ? coroutine_suspended : objWriteAvailable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object writeAvailableSuspend(byte[] bArr, int i, int i2, Continuation<? super Integer> continuation) throws Throwable {
        C48122 c48122;
        ByteChannelSequentialBase byteChannelSequentialBase;
        if (continuation instanceof C48122) {
            c48122 = (C48122) continuation;
            if ((c48122.label & Integer.MIN_VALUE) != 0) {
                c48122.label -= Integer.MIN_VALUE;
            } else {
                c48122 = new C48122(continuation);
            }
        } else {
            c48122 = new C48122(continuation);
        }
        Object objWriteAvailable = c48122.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c48122.label;
        if (i3 != 0) {
            if (i3 == 1) {
                i2 = c48122.I$1;
                i = c48122.I$0;
                bArr = (byte[]) c48122.L$1;
                byteChannelSequentialBase = (ByteChannelSequentialBase) c48122.L$0;
                ResultKt.throwOnFailure(objWriteAvailable);
            } else {
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objWriteAvailable);
            }
        }
        ResultKt.throwOnFailure(objWriteAvailable);
        c48122.L$0 = this;
        c48122.L$1 = bArr;
        c48122.I$0 = i;
        c48122.I$1 = i2;
        c48122.label = 1;
        if (awaitAtLeastNBytesAvailableForWrite$ktor_io(1, c48122) == coroutine_suspended) {
            return coroutine_suspended;
        }
        byteChannelSequentialBase = this;
        c48122.L$0 = null;
        c48122.L$1 = null;
        c48122.label = 2;
        objWriteAvailable = byteChannelSequentialBase.writeAvailable(bArr, i, i2, c48122);
        return objWriteAvailable == coroutine_suspended ? coroutine_suspended : objWriteAvailable;
    }

    protected final void afterWrite(int count) throws Throwable {
        addBytesWritten(count);
        if (getClosed()) {
            this.writable.release();
            ensureNotClosed();
        }
        if (getAutoFlush() || getAvailableForWrite() == 0) {
            flush();
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    static /* synthetic */ Object awaitFreeSpace$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Continuation<? super Unit> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = byteChannelSequentialBase.new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = byteChannelSequentialBase.new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            byteChannelSequentialBase.flush();
            anonymousClass1.L$0 = byteChannelSequentialBase;
            anonymousClass1.label = 1;
            if (byteChannelSequentialBase.awaitAtLeastNBytesAvailableForWrite$ktor_io(1, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            byteChannelSequentialBase = (ByteChannelSequentialBase) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        byteChannelSequentialBase.ensureNotClosed();
        return Unit.INSTANCE;
    }

    static /* synthetic */ Object awaitContent$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Continuation<? super Unit> continuation) {
        Object objAwait = byteChannelSequentialBase.await(1, continuation);
        return objAwait == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwait : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Override // io.ktor.utils.io.ByteReadChannel
    /* JADX INFO: renamed from: peekTo-lBXzO7A */
    public final Object mo7618peekTolBXzO7A(ByteBuffer byteBuffer, long j, long j2, long j3, long j4, Continuation<? super Long> continuation) throws Throwable {
        ByteChannelSequentialBase$peekTo$1 byteChannelSequentialBase$peekTo$1;
        Ref.LongRef longRef;
        if (continuation instanceof ByteChannelSequentialBase$peekTo$1) {
            byteChannelSequentialBase$peekTo$1 = (ByteChannelSequentialBase$peekTo$1) continuation;
            if ((byteChannelSequentialBase$peekTo$1.label & Integer.MIN_VALUE) != 0) {
                byteChannelSequentialBase$peekTo$1.label -= Integer.MIN_VALUE;
            } else {
                byteChannelSequentialBase$peekTo$1 = new ByteChannelSequentialBase$peekTo$1(this, continuation);
            }
        } else {
            byteChannelSequentialBase$peekTo$1 = new ByteChannelSequentialBase$peekTo$1(this, continuation);
        }
        Object obj = byteChannelSequentialBase$peekTo$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = byteChannelSequentialBase$peekTo$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.LongRef longRef2 = new Ref.LongRef();
            Function2<? super SuspendableReadSession, ? super Continuation<? super Unit>, ? extends Object> byteChannelSequentialBase$peekTo$2 = new ByteChannelSequentialBase$peekTo$2(j3, j2, longRef2, j4, byteBuffer, j, null);
            byteChannelSequentialBase$peekTo$1.L$0 = longRef2;
            byteChannelSequentialBase$peekTo$1.label = 1;
            if (readSuspendableSession(byteChannelSequentialBase$peekTo$2, byteChannelSequentialBase$peekTo$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            longRef = longRef2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            longRef = (Ref.LongRef) byteChannelSequentialBase$peekTo$1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxLong(longRef.element);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object readFully(Buffer buffer, int i, Continuation<? super Unit> continuation) throws Throwable {
        if (i > buffer.getLimit() - buffer.getWritePosition()) {
            throw new IllegalArgumentException(("Not enough space in the destination buffer to write " + i + " bytes").toString());
        }
        if (i < 0) {
            throw new IllegalArgumentException("n shouldn't be negative".toString());
        }
        if (getClosedCause() != null) {
            Throwable closedCause = getClosedCause();
            Intrinsics.checkNotNull(closedCause);
            throw closedCause;
        }
        if (this.readable.getRemaining() < i) {
            if (getClosed()) {
                throw new EOFException("Channel is closed and not enough bytes available: required " + i + " but " + get_availableForRead() + " available");
            }
            Object fullySuspend = readFullySuspend(buffer, i, continuation);
            return fullySuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? fullySuspend : Unit.INSTANCE;
        }
        InputArraysKt.readFully(this.readable, buffer, i);
        Unit unit = Unit.INSTANCE;
        afterRead(i);
        return Unit.INSTANCE;
    }

    private final void addBytesRead(int count) {
        if (count < 0) {
            throw new IllegalArgumentException(("Can't read negative amount of bytes: " + count).toString());
        }
        int i = -count;
        channelSize$FU.getAndAdd(this, i);
        _totalBytesRead$FU.addAndGet(this, count);
        _availableForRead$FU.getAndAdd(this, i);
        if (this.channelSize < 0) {
            throw new IllegalStateException(("Readable bytes count is negative: " + get_availableForRead() + ", " + count + " in " + this).toString());
        }
        if (get_availableForRead() < 0) {
            throw new IllegalStateException(("Readable bytes count is negative: " + get_availableForRead() + ", " + count + " in " + this).toString());
        }
    }

    private final void addBytesWritten(int count) {
        if (count < 0) {
            throw new IllegalArgumentException(("Can't write negative amount of bytes: " + count).toString());
        }
        channelSize$FU.getAndAdd(this, count);
        _totalBytesWritten$FU.addAndGet(this, count);
        if (this.channelSize < 0) {
            throw new IllegalStateException(("Readable bytes count is negative: " + this.channelSize + ", " + count + " in " + this).toString());
        }
    }
}
