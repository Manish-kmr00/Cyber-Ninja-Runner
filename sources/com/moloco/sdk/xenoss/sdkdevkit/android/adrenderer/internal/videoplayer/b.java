package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes10.dex */
public final class b implements DataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7114a;
    public final i b;
    public final String c;
    public RandomAccessFile d;
    public long e;
    public boolean f;
    public boolean g;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.ProgressiveMediaFileDataSource$open$1", f = "ProgressiveMediaFileDataSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7115a;
        public final /* synthetic */ DataSpec c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(DataSpec dataSpec, Continuation<? super a> continuation) {
            super(2, continuation);
            this.c = dataSpec;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Long> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return b.this.new a(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            File fileC;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f7115a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                b bVar = b.this;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c cVarA = bVar.a(bVar.f7114a);
                if (cVarA instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.a) {
                    fileC = ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.a) cVarA).b();
                } else {
                    if (!(cVarA instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.C0605c)) {
                        b.this.g = true;
                        MolocoLogger.error$default(MolocoLogger.INSTANCE, b.this.c, "Failed to download file: " + b.this.f7114a, null, false, 12, null);
                        throw new IOException("Cannot read file: " + b.this.f7114a);
                    }
                    fileC = ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.C0605c) cVarA).c();
                }
                if (!fileC.exists()) {
                    throw new IOException("Cannot read file, does not exist yet: " + b.this.f7114a);
                }
                b bVar2 = b.this;
                RandomAccessFile randomAccessFile = new RandomAccessFile(fileC, "r");
                randomAccessFile.seek(this.c.position);
                bVar2.a(randomAccessFile);
                b bVar3 = b.this;
                long length = this.c.length;
                if (length == -1) {
                    length = fileC.length() - this.c.position;
                }
                bVar3.e = length;
                if (b.this.e == 0 && b.this.a(cVarA)) {
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, b.this.c, "Streaming error likely detected", null, false, 12, null);
                    b.this.g = true;
                }
                return Boxing.boxLong(b.this.e);
            } catch (IOException e) {
                MolocoLogger.error$default(MolocoLogger.INSTANCE, b.this.c, "Failed to open file: " + b.this.f7114a, e, false, 8, null);
                throw e;
            }
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.b$b, reason: collision with other inner class name */
    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.ProgressiveMediaFileDataSource$streamingStatus$1", f = "ProgressiveMediaFileDataSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C0688b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7116a;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0688b(String str, Continuation<? super C0688b> continuation) {
            super(2, continuation);
            this.c = str;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> continuation) {
            return ((C0688b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return b.this.new C0688b(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f7116a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return b.this.b.a(this.c);
        }
    }

    public b(String url, i mediaCacheRepository) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(mediaCacheRepository, "mediaCacheRepository");
        this.f7114a = url;
        this.b = mediaCacheRepository;
        this.c = "ProgressiveMediaFileDataSource";
    }

    public static /* synthetic */ void c() {
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void addTransferListener(TransferListener transferListener) {
        Intrinsics.checkNotNullParameter(transferListener, "transferListener");
        MolocoLogger.info$default(MolocoLogger.INSTANCE, this.c, "addTransferListener", null, false, 12, null);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        try {
            RandomAccessFile randomAccessFile = this.d;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
        } finally {
            this.d = null;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Uri getUri() {
        return Uri.parse(this.f7114a);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) {
        Intrinsics.checkNotNullParameter(dataSpec, "dataSpec");
        return ((Number) BuildersKt__BuildersKt.runBlocking$default(null, new a(dataSpec, null), 1, null)).longValue();
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] buffer, int i, int i2) {
        IOException iOException;
        int i3;
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int i4 = 0;
        try {
            if (i2 == 0) {
                MolocoLogger.info$default(MolocoLogger.INSTANCE, this.c, "Read length is 0", null, false, 12, null);
                return 0;
            }
            if (this.e == 0 && (a(this.f7114a) instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.a)) {
                MolocoLogger.info$default(MolocoLogger.INSTANCE, this.c, "Media stream is complete", null, false, 12, null);
                return -1;
            }
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c cVarA = a(this.f7114a);
            if (cVarA instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.b) {
                MolocoLogger.error$default(MolocoLogger.INSTANCE, this.c, "Streaming failed: " + this.f7114a, null, false, 12, null);
                this.g = true;
                return 0;
            }
            if (cVarA instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.a) {
                RandomAccessFile randomAccessFile = this.d;
                i4 = randomAccessFile != null ? randomAccessFile.read(buffer, i, i2) : 0;
                if (i4 <= 0) {
                    return i4;
                }
                this.f = true;
                this.e -= (long) i4;
                return i4;
            }
            loop0: while (true) {
                i3 = 0;
                while (true) {
                    if (i3 > 0) {
                        break loop0;
                    }
                    try {
                        if (!(a(this.f7114a) instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.C0605c)) {
                            break loop0;
                        }
                        RandomAccessFile randomAccessFile2 = this.d;
                        if (randomAccessFile2 != null) {
                            i3 = randomAccessFile2.read(buffer, i, i2);
                        }
                    } catch (IOException e) {
                        iOException = e;
                        i4 = i3;
                        MolocoLogger.error$default(MolocoLogger.INSTANCE, this.c, "Waiting for more data", iOException, false, 8, null);
                        return i4;
                    }
                }
            }
            if (i3 <= 0) {
                return i3;
            }
            this.f = true;
            this.e -= (long) i3;
            return i3;
        } catch (IOException e2) {
            iOException = e2;
        }
    }

    public final RandomAccessFile b() {
        return this.d;
    }

    public final void a(RandomAccessFile randomAccessFile) {
        this.d = randomAccessFile;
    }

    public final boolean a() {
        return this.g;
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c a(String str) {
        return (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c) BuildersKt__BuildersKt.runBlocking$default(null, new C0688b(str, null), 1, null);
    }

    public final boolean a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c cVar) {
        return this.f && (cVar instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.C0605c) && Intrinsics.areEqual(((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.C0605c) cVar).d(), com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.d.a());
    }
}
