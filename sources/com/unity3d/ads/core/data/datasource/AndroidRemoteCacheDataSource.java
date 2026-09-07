package com.unity3d.ads.core.data.datasource;

import com.facebook.share.internal.ShareConstants;
import com.json.uc;
import com.unity3d.ads.core.data.model.CacheError;
import com.unity3d.ads.core.data.model.CacheResult;
import com.unity3d.ads.core.data.model.CacheSource;
import com.unity3d.ads.core.data.model.CachedFile;
import com.unity3d.ads.core.domain.CreateFile;
import com.unity3d.ads.core.domain.GetFileExtensionFromUrl;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import com.unity3d.services.core.network.model.HttpResponseKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AndroidRemoteCacheDataSource.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ#\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J5\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J#\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001dR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lcom/unity3d/ads/core/data/datasource/AndroidRemoteCacheDataSource;", "Lcom/unity3d/ads/core/data/datasource/CacheDataSource;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "createFile", "Lcom/unity3d/ads/core/domain/CreateFile;", "getFileExtensionFromUrl", "Lcom/unity3d/ads/core/domain/GetFileExtensionFromUrl;", "httpClient", "Lcom/unity3d/services/core/network/core/HttpClient;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lcom/unity3d/ads/core/domain/CreateFile;Lcom/unity3d/ads/core/domain/GetFileExtensionFromUrl;Lcom/unity3d/services/core/network/core/HttpClient;)V", "downloadFile", "Lcom/unity3d/services/core/network/model/HttpResponse;", "url", "", HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, "", "(Ljava/lang/String;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFile", "Lcom/unity3d/ads/core/data/model/CacheResult;", "cachePath", "Ljava/io/File;", uc.c.b, "(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveToCache", "", "dest", "body", "", "(Ljava/io/File;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidRemoteCacheDataSource implements CacheDataSource {
    private final CreateFile createFile;
    private final GetFileExtensionFromUrl getFileExtensionFromUrl;
    private final HttpClient httpClient;
    private final CoroutineDispatcher ioDispatcher;

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.datasource.AndroidRemoteCacheDataSource$getFile$1, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidRemoteCacheDataSource.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.ads.core.data.datasource.AndroidRemoteCacheDataSource", f = "AndroidRemoteCacheDataSource.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {52, 60}, m = "getFile", n = {"this", "cachePath", uc.c.b, "url", HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, uc.c.b, "url", HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, "response", ShareConstants.MEDIA_EXTENSION, "file"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AndroidRemoteCacheDataSource.this.getFile(null, null, null, null, this);
        }
    }

    public AndroidRemoteCacheDataSource(CoroutineDispatcher ioDispatcher, CreateFile createFile, GetFileExtensionFromUrl getFileExtensionFromUrl, HttpClient httpClient) {
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        Intrinsics.checkNotNullParameter(createFile, "createFile");
        Intrinsics.checkNotNullParameter(getFileExtensionFromUrl, "getFileExtensionFromUrl");
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        this.ioDispatcher = ioDispatcher;
        this.createFile = createFile;
        this.getFileExtensionFromUrl = getFileExtensionFromUrl;
        this.httpClient = httpClient;
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.datasource.AndroidRemoteCacheDataSource$saveToCache$2, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidRemoteCacheDataSource.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.ads.core.data.datasource.AndroidRemoteCacheDataSource$saveToCache$2", f = "AndroidRemoteCacheDataSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
        final /* synthetic */ Object $body;
        final /* synthetic */ File $dest;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Object obj, File file, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$body = obj;
            this.$dest = file;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$body, this.$dest, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Object> continuation) {
            return invoke2(coroutineScope, (Continuation<Object>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<Object> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Object obj2 = this.$body;
            if (obj2 instanceof File) {
                FilesKt.copyTo$default((File) obj2, this.$dest, true, 0, 4, null);
                return Boxing.boxBoolean(((File) this.$body).delete());
            }
            if (obj2 instanceof byte[]) {
                this.$dest.createNewFile();
                FilesKt.writeBytes(this.$dest, (byte[]) this.$body);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("Unknown body type".toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object saveToCache(File file, Object obj, Continuation<? super Unit> continuation) throws Throwable {
        Object objWithContext = BuildersKt.withContext(this.ioDispatcher, new AnonymousClass2(obj, file, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x010c  */
    /* JADX WARN: Code duplicated, block: B:51:0x0116  */
    /* JADX WARN: Code duplicated, block: B:53:0x011a  */
    /* JADX WARN: Code duplicated, block: B:56:0x0127  */
    /* JADX WARN: Code duplicated, block: B:57:0x012c  */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    @Override // com.unity3d.ads.core.data.datasource.CacheDataSource
    public Object getFile(File file, String str, String str2, Integer num, Continuation<? super CacheResult> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        File file2;
        String str3;
        AndroidRemoteCacheDataSource androidRemoteCacheDataSource;
        String str4;
        Object obj;
        Integer num2;
        String str5;
        Integer num3;
        HttpResponse httpResponse;
        String str6;
        String str7;
        File file3;
        Object objM7904constructorimpl;
        HttpResponse httpResponse2;
        File file4;
        String str8;
        String str9;
        String str10;
        int iIntValue;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj2 = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj2);
                if (str2 == null) {
                    return new CacheResult.Failure(CacheError.MALFORMED_URL, CacheSource.REMOTE);
                }
                anonymousClass1.L$0 = this;
                file2 = file;
                anonymousClass1.L$1 = file2;
                str3 = str;
                anonymousClass1.L$2 = str3;
                anonymousClass1.L$3 = str2;
                anonymousClass1.L$4 = num;
                anonymousClass1.label = 1;
                Object objDownloadFile = downloadFile(str2, num, anonymousClass1);
                if (objDownloadFile == coroutine_suspended) {
                    return coroutine_suspended;
                }
                androidRemoteCacheDataSource = this;
                str4 = str2;
                obj = objDownloadFile;
                num2 = num;
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    file3 = (File) anonymousClass1.L$5;
                    str6 = (String) anonymousClass1.L$4;
                    httpResponse = (HttpResponse) anonymousClass1.L$3;
                    num3 = (Integer) anonymousClass1.L$2;
                    str7 = (String) anonymousClass1.L$1;
                    str5 = (String) anonymousClass1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        objM7904constructorimpl = Result.m7904constructorimpl(Unit.INSTANCE);
                    } catch (Throwable th) {
                        th = th;
                        Result.Companion companion = Result.INSTANCE;
                        objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
                    }
                    httpResponse2 = httpResponse;
                    file4 = file3;
                    str8 = str6;
                    str9 = str5;
                    str10 = str7;
                    if (Result.m7907exceptionOrNullimpl(objM7904constructorimpl) != null) {
                        return new CacheResult.Failure(CacheError.FILE_STATE_WRONG, CacheSource.REMOTE);
                    }
                    if (str8 == null) {
                        str8 = "";
                    }
                    String str11 = str8;
                    long contentSize = httpResponse2.getContentSize();
                    String protocol = httpResponse2.getProtocol();
                    if (num3 != null) {
                        iIntValue = num3.intValue();
                    } else {
                        iIntValue = Integer.MAX_VALUE;
                    }
                    return new CacheResult.Success(new CachedFile("", str10, str9, file4, str11, contentSize, protocol, iIntValue), CacheSource.REMOTE);
                }
                Integer num4 = (Integer) anonymousClass1.L$4;
                str4 = (String) anonymousClass1.L$3;
                str3 = (String) anonymousClass1.L$2;
                File file5 = (File) anonymousClass1.L$1;
                androidRemoteCacheDataSource = (AndroidRemoteCacheDataSource) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj2);
                num2 = num4;
                obj = obj2;
                file2 = file5;
            }
            HttpResponse httpResponse3 = (HttpResponse) obj;
            String strInvoke = str4.length() == 0 ? null : androidRemoteCacheDataSource.getFileExtensionFromUrl.invoke(str4);
            if (HttpResponseKt.isSuccessful(httpResponse3)) {
                File fileInvoke = androidRemoteCacheDataSource.createFile.invoke(file2, str3);
                try {
                    Result.Companion companion2 = Result.INSTANCE;
                    Object body = httpResponse3.getBody();
                    anonymousClass1.L$0 = str3;
                    anonymousClass1.L$1 = str4;
                    anonymousClass1.L$2 = num2;
                    anonymousClass1.L$3 = httpResponse3;
                    anonymousClass1.L$4 = strInvoke;
                    anonymousClass1.L$5 = fileInvoke;
                    anonymousClass1.label = 2;
                    if (androidRemoteCacheDataSource.saveToCache(fileInvoke, body, anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str5 = str3;
                    num3 = num2;
                    httpResponse = httpResponse3;
                    str6 = strInvoke;
                    str7 = str4;
                    file3 = fileInvoke;
                    objM7904constructorimpl = Result.m7904constructorimpl(Unit.INSTANCE);
                    httpResponse2 = httpResponse;
                    file4 = file3;
                    str8 = str6;
                    str9 = str5;
                    str10 = str7;
                    if (Result.m7907exceptionOrNullimpl(objM7904constructorimpl) != null) {
                        return new CacheResult.Failure(CacheError.FILE_STATE_WRONG, CacheSource.REMOTE);
                    }
                    if (str8 == null) {
                        str8 = "";
                    }
                    String str12 = str8;
                    long contentSize2 = httpResponse2.getContentSize();
                    String protocol2 = httpResponse2.getProtocol();
                    if (num3 != null) {
                        iIntValue = num3.intValue();
                    } else {
                        iIntValue = Integer.MAX_VALUE;
                    }
                    return new CacheResult.Success(new CachedFile("", str10, str9, file4, str12, contentSize2, protocol2, iIntValue), CacheSource.REMOTE);
                } catch (Throwable th2) {
                    th = th2;
                    str5 = str3;
                    num3 = num2;
                    httpResponse = httpResponse3;
                    str6 = strInvoke;
                    str7 = str4;
                    file3 = fileInvoke;
                    Result.Companion companion3 = Result.INSTANCE;
                    objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
                }
            } else {
                return new CacheResult.Failure(CacheError.NETWORK_ERROR, CacheSource.REMOTE);
            }
        } catch (Exception unused) {
            return new CacheResult.Failure(CacheError.NETWORK_ERROR, CacheSource.REMOTE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object downloadFile(String str, Integer num, Continuation<? super HttpResponse> continuation) {
        return this.httpClient.execute(new HttpRequest(str, null, null, null, null, null, null, null, null, 0, 0, 0, 0, false, null, null, num != null ? num.intValue() : Integer.MAX_VALUE, 65534, null), continuation);
    }
}
