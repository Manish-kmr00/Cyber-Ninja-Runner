package io.bidmachine.models;

import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public interface ICustomParams<SelfType> {
    SelfType addParam(String str, String str2);

    SelfType addParams(Map<String, String> map);
}
