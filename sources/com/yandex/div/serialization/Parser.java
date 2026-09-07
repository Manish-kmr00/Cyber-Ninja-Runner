package com.yandex.div.serialization;

import androidx.exifinterface.media.ExifInterface;
import com.yandex.div.core.annotations.ExperimentalApi;
import kotlin.Metadata;

/* JADX INFO: compiled from: Parser.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2 = {"Lcom/yandex/div/serialization/Parser;", "D", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/yandex/div/serialization/Serializer;", "Lcom/yandex/div/serialization/Deserializer;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@ExperimentalApi
public interface Parser<D, V> extends Serializer<D, V>, Deserializer<D, V> {
}
