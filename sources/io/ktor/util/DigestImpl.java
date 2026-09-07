package io.ktor.util;

import com.yandex.div.core.timer.TimerController;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CryptoJvm.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0083@\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\tH\u0096\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lio/ktor/util/DigestImpl;", "Lio/ktor/util/Digest;", "delegate", "Ljava/security/MessageDigest;", "constructor-impl", "(Ljava/security/MessageDigest;)Ljava/security/MessageDigest;", "getDelegate", "()Ljava/security/MessageDigest;", "build", "", "build-impl", "(Ljava/security/MessageDigest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "equals", "", "other", "", "equals-impl", "(Ljava/security/MessageDigest;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/security/MessageDigest;)I", "plusAssign", "", "bytes", "plusAssign-impl", "(Ljava/security/MessageDigest;[B)V", TimerController.RESET_COMMAND, "reset-impl", "(Ljava/security/MessageDigest;)V", "toString", "", "toString-impl", "(Ljava/security/MessageDigest;)Ljava/lang/String;", "ktor-utils"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
final class DigestImpl implements Digest {
    private final MessageDigest delegate;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DigestImpl m7602boximpl(MessageDigest messageDigest) {
        return new DigestImpl(messageDigest);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static MessageDigest m7604constructorimpl(MessageDigest delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        return delegate;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m7605equalsimpl(MessageDigest messageDigest, Object obj) {
        return (obj instanceof DigestImpl) && Intrinsics.areEqual(messageDigest, ((DigestImpl) obj).m7611unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m7606equalsimpl0(MessageDigest messageDigest, MessageDigest messageDigest2) {
        return Intrinsics.areEqual(messageDigest, messageDigest2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m7607hashCodeimpl(MessageDigest messageDigest) {
        return messageDigest.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m7610toStringimpl(MessageDigest messageDigest) {
        return "DigestImpl(delegate=" + messageDigest + ')';
    }

    public boolean equals(Object obj) {
        return m7605equalsimpl(this.delegate, obj);
    }

    public int hashCode() {
        return m7607hashCodeimpl(this.delegate);
    }

    public String toString() {
        return m7610toStringimpl(this.delegate);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ MessageDigest m7611unboximpl() {
        return this.delegate;
    }

    private /* synthetic */ DigestImpl(MessageDigest messageDigest) {
        this.delegate = messageDigest;
    }

    public final MessageDigest getDelegate() {
        return this.delegate;
    }

    @Override // io.ktor.util.Digest
    public void plusAssign(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        m7608plusAssignimpl(this.delegate, bytes);
    }

    /* JADX INFO: renamed from: plusAssign-impl, reason: not valid java name */
    public static void m7608plusAssignimpl(MessageDigest messageDigest, byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        messageDigest.update(bytes);
    }

    @Override // io.ktor.util.Digest
    public void reset() {
        m7609resetimpl(this.delegate);
    }

    /* JADX INFO: renamed from: reset-impl, reason: not valid java name */
    public static void m7609resetimpl(MessageDigest messageDigest) {
        messageDigest.reset();
    }

    /* JADX INFO: renamed from: build-impl, reason: not valid java name */
    public static Object m7603buildimpl(MessageDigest messageDigest, Continuation<? super byte[]> continuation) {
        byte[] bArrDigest = messageDigest.digest();
        Intrinsics.checkNotNullExpressionValue(bArrDigest, "delegate.digest()");
        return bArrDigest;
    }

    @Override // io.ktor.util.Digest
    public Object build(Continuation<? super byte[]> continuation) {
        return m7603buildimpl(this.delegate, continuation);
    }
}
