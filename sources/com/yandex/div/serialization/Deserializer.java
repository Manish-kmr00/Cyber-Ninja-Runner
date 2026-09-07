package com.yandex.div.serialization;

import androidx.exifinterface.media.ExifInterface;
import com.yandex.div.core.annotations.ExperimentalApi;
import kotlin.Metadata;

/* JADX INFO: compiled from: Deserializer.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J\u001d\u0010\u0004\u001a\u00028\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0002\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/serialization/Deserializer;", "D", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "(Lcom/yandex/div/serialization/ParsingContext;Ljava/lang/Object;)Ljava/lang/Object;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@ExperimentalApi
public interface Deserializer<D, V> {
    V deserialize(ParsingContext context, D data);
}
