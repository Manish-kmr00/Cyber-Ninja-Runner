package io.ktor.client.plugins;

import io.ktor.client.HttpClientConfig;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.call.SavedCallKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.util.AttributeKey;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import io.ktor.utils.io.charsets.MalformedInputException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Logger;

/* JADX INFO: compiled from: DefaultResponseValidation.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\n\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\u000b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"BODY_FAILED_DECODING", "", "DEPRECATED_EXCEPTION_CTOR", "LOGGER", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "NO_RESPONSE_TEXT", "ValidateMark", "Lio/ktor/util/AttributeKey;", "", "addDefaultResponseValidation", "Lio/ktor/client/HttpClientConfig;", "ktor-client-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DefaultResponseValidationKt {
    private static final String BODY_FAILED_DECODING = "<body failed decoding>";
    private static final String DEPRECATED_EXCEPTION_CTOR = "Please, provide response text in constructor";
    private static final String NO_RESPONSE_TEXT = "<no response text provided>";
    private static final AttributeKey<Unit> ValidateMark = new AttributeKey<>("ValidateMark");
    private static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.DefaultResponseValidation");

    public static final void addDefaultResponseValidation(final HttpClientConfig<?> httpClientConfig) {
        Intrinsics.checkNotNullParameter(httpClientConfig, "<this>");
        HttpCallValidatorKt.HttpResponseValidator(httpClientConfig, new Function1<HttpCallValidator.Config, Unit>() { // from class: io.ktor.client.plugins.DefaultResponseValidationKt.addDefaultResponseValidation.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HttpCallValidator.Config config) {
                invoke2(config);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HttpCallValidator.Config HttpResponseValidator) {
                Intrinsics.checkNotNullParameter(HttpResponseValidator, "$this$HttpResponseValidator");
                HttpResponseValidator.setExpectSuccess(httpClientConfig.getExpectSuccess());
                HttpResponseValidator.validateResponse(new C07961(null));
            }

            /* JADX INFO: renamed from: io.ktor.client.plugins.DefaultResponseValidationKt$addDefaultResponseValidation$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: DefaultResponseValidation.kt */
            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "response", "Lio/ktor/client/statement/HttpResponse;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "io.ktor.client.plugins.DefaultResponseValidationKt$addDefaultResponseValidation$1$1", f = "DefaultResponseValidation.kt", i = {0, 0, 1, 1, 1}, l = {42, 48}, m = "invokeSuspend", n = {"response", "statusCode", "response", "exceptionResponse", "statusCode"}, s = {"L$0", "I$0", "L$0", "L$1", "I$0"})
            static final class C07961 extends SuspendLambda implements Function2<HttpResponse, Continuation<? super Unit>, Object> {
                int I$0;
                /* synthetic */ Object L$0;
                Object L$1;
                int label;

                C07961(Continuation<? super C07961> continuation) {
                    super(2, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C07961 c07961 = new C07961(continuation);
                    c07961.L$0 = obj;
                    return c07961;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(HttpResponse httpResponse, Continuation<? super Unit> continuation) {
                    return ((C07961) create(httpResponse, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Code duplicated, block: B:39:0x00e8  */
                /* JADX WARN: Code duplicated, block: B:41:0x00ec A[ADDED_TO_REGION] */
                /* JADX WARN: Code duplicated, block: B:44:0x00f7 A[DONT_INVERT] */
                /* JADX WARN: Code duplicated, block: B:45:0x00f9  */
                /* JADX WARN: Code duplicated, block: B:48:0x0105  */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    int value;
                    HttpResponse httpResponse;
                    HttpResponse response;
                    int i;
                    HttpResponse httpResponse2;
                    HttpResponse httpResponse3;
                    String str;
                    ServerResponseException responseException;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i2 = this.label;
                    try {
                        if (i2 == 0) {
                            ResultKt.throwOnFailure(obj);
                            HttpResponse httpResponse4 = (HttpResponse) this.L$0;
                            if (!((Boolean) httpResponse4.getCall().getAttributes().get(HttpCallValidatorKt.getExpectSuccessAttributeKey())).booleanValue()) {
                                DefaultResponseValidationKt.LOGGER.trace("Skipping default response validation for " + httpResponse4.getCall().getRequest().getUrl());
                                return Unit.INSTANCE;
                            }
                            value = httpResponse4.getStatus().getValue();
                            HttpClientCall call = httpResponse4.getCall();
                            if (value < 300 || call.getAttributes().contains(DefaultResponseValidationKt.ValidateMark)) {
                                return Unit.INSTANCE;
                            }
                            this.L$0 = httpResponse4;
                            this.I$0 = value;
                            this.label = 1;
                            Object objSave = SavedCallKt.save(call, this);
                            if (objSave == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            httpResponse = httpResponse4;
                            obj = objSave;
                        } else {
                            if (i2 != 1) {
                                if (i2 != 2) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                i = this.I$0;
                                httpResponse3 = (HttpResponse) this.L$1;
                                httpResponse2 = (HttpResponse) this.L$0;
                                try {
                                    ResultKt.throwOnFailure(obj);
                                    str = (String) obj;
                                } catch (MalformedInputException unused) {
                                    str = DefaultResponseValidationKt.BODY_FAILED_DECODING;
                                }
                                if (300 > i && i < 400) {
                                    responseException = new RedirectResponseException(httpResponse3, str);
                                } else if (400 > i && i < 500) {
                                    responseException = new ClientRequestException(httpResponse3, str);
                                } else if (500 > i && i < 600) {
                                    responseException = new ServerResponseException(httpResponse3, str);
                                } else {
                                    responseException = new ResponseException(httpResponse3, str);
                                }
                                DefaultResponseValidationKt.LOGGER.trace("Default response validation for " + httpResponse2.getCall().getRequest().getUrl() + " failed with " + responseException);
                                throw responseException;
                            }
                            value = this.I$0;
                            httpResponse = (HttpResponse) this.L$0;
                            ResultKt.throwOnFailure(obj);
                        }
                        this.L$0 = httpResponse;
                        this.L$1 = response;
                        this.I$0 = value;
                        this.label = 2;
                        Object objBodyAsText$default = HttpResponseKt.bodyAsText$default(response, null, this, 1, null);
                        if (objBodyAsText$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i = value;
                        httpResponse3 = response;
                        obj = objBodyAsText$default;
                        httpResponse2 = httpResponse;
                        str = (String) obj;
                        if (300 > i) {
                            if (400 > i) {
                                if (500 > i) {
                                    responseException = new ResponseException(httpResponse3, str);
                                } else {
                                    responseException = new ResponseException(httpResponse3, str);
                                }
                            } else if (500 > i) {
                                responseException = new ResponseException(httpResponse3, str);
                            } else {
                                responseException = new ResponseException(httpResponse3, str);
                            }
                        } else if (400 > i) {
                            if (500 > i) {
                                responseException = new ResponseException(httpResponse3, str);
                            } else {
                                responseException = new ResponseException(httpResponse3, str);
                            }
                        } else if (500 > i) {
                            responseException = new ResponseException(httpResponse3, str);
                        } else {
                            responseException = new ResponseException(httpResponse3, str);
                        }
                        DefaultResponseValidationKt.LOGGER.trace("Default response validation for " + httpResponse2.getCall().getRequest().getUrl() + " failed with " + responseException);
                        throw responseException;
                    } catch (MalformedInputException unused2) {
                        i = value;
                        httpResponse2 = httpResponse;
                        httpResponse3 = response;
                        str = DefaultResponseValidationKt.BODY_FAILED_DECODING;
                    }
                    HttpClientCall httpClientCall = (HttpClientCall) obj;
                    httpClientCall.getAttributes().put(DefaultResponseValidationKt.ValidateMark, Unit.INSTANCE);
                    response = httpClientCall.getResponse();
                }
            }
        });
    }
}
