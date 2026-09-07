package com.moloco.sdk.acm.http;

import io.ktor.http.HeadersBuilder;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes13.dex */
public interface e {
    Object a(d dVar, Function1<? super HeadersBuilder, Unit> function1, Continuation<? super Result<String>> continuation);
}
