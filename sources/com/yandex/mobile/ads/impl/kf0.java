package com.yandex.mobile.ads.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes7.dex */
public final class kf0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Charset f9410a = Charsets.ISO_8859_1;
    public static final /* synthetic */ int b = 0;

    public interface a<T> {
        T a(String str);
    }

    @JvmStatic
    public static final boolean a(Map<String, String> responseHeaders, sh0 httpHeader, boolean z) {
        Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
        Intrinsics.checkNotNullParameter(httpHeader, "httpHeader");
        String strA = a(responseHeaders, httpHeader);
        return strA == null ? z : Boolean.parseBoolean(strA);
    }

    @JvmStatic
    public static final ArrayList c(Map responseHeaders, sh0 header) {
        Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
        Intrinsics.checkNotNullParameter(header, "header");
        return a(responseHeaders, header, new lf0());
    }

    public static int b(Map map, sh0 httpHeader) {
        Intrinsics.checkNotNullParameter(httpHeader, "httpHeader");
        String strA = a(map, httpHeader);
        int i = oa.b;
        if (strA != null) {
            try {
                return Integer.parseInt(strA);
            } catch (NumberFormatException unused) {
            }
        }
        return 0;
    }

    @JvmStatic
    public static final String a(Map<String, String> map, sh0 httpHeader) {
        Intrinsics.checkNotNullParameter(httpHeader, "httpHeader");
        if (map != null) {
            return map.get(httpHeader.a());
        }
        return null;
    }

    @JvmStatic
    public static final ArrayList a(Map responseHeaders, sh0 header, a parser) {
        List listEmptyList;
        Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(parser, "parser");
        ArrayList arrayList = new ArrayList();
        String strA = a(responseHeaders, header);
        if (strA != null && strA.length() != 0) {
            List<String> listSplit = new Regex(StringUtils.COMMA).split(strA, 0);
            if (!listSplit.isEmpty()) {
                ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
                while (true) {
                    if (listIterator.hasPrevious()) {
                        if (listIterator.previous().length() != 0) {
                            listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                            break;
                        }
                    } else {
                        listEmptyList = CollectionsKt.emptyList();
                        break;
                    }
                }
            } else {
                listEmptyList = CollectionsKt.emptyList();
                break;
            }
            for (String str : (String[]) listEmptyList.toArray(new String[0])) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    int length = str.length() - 1;
                    int i = 0;
                    boolean z = false;
                    while (i <= length) {
                        boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i : length), 32) <= 0;
                        if (z) {
                            if (!z2) {
                                break;
                            }
                            length--;
                        } else if (z2) {
                            i++;
                        } else {
                            z = true;
                        }
                    }
                    String strDecode = URLDecoder.decode(str.subSequence(i, length + 1).toString(), "UTF-8");
                    Intrinsics.checkNotNull(strDecode);
                    Object objA = parser.a(strDecode);
                    if (objA != null) {
                        arrayList.add(objA);
                    } else {
                        objA = null;
                    }
                    Result.m7904constructorimpl(objA);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.m7904constructorimpl(ResultKt.createFailure(th));
                }
            }
        }
        return arrayList;
    }

    @JvmStatic
    public static final Charset a(Map<String, String> map) {
        List listEmptyList;
        List listEmptyList2;
        if (map == null) {
            return f9410a;
        }
        String str = map.get("Content-Type");
        if (str != null) {
            List<String> listSplit = new Regex(";").split(str, 0);
            if (!listSplit.isEmpty()) {
                ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
                while (true) {
                    if (listIterator.hasPrevious()) {
                        if (listIterator.previous().length() != 0) {
                            listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                            break;
                        }
                    } else {
                        listEmptyList = CollectionsKt.emptyList();
                        break;
                    }
                }
            } else {
                listEmptyList = CollectionsKt.emptyList();
                break;
            }
            String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
            int length = strArr.length;
            for (int i = 1; i < length; i++) {
                String str2 = strArr[i];
                int length2 = str2.length() - 1;
                int i2 = 0;
                boolean z = false;
                while (i2 <= length2) {
                    boolean z2 = Intrinsics.compare((int) str2.charAt(!z ? i2 : length2), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            break;
                        }
                        length2--;
                    } else if (z2) {
                        i2++;
                    } else {
                        z = true;
                    }
                }
                List<String> listSplit2 = new Regex("=").split(str2.subSequence(i2, length2 + 1).toString(), 0);
                if (!listSplit2.isEmpty()) {
                    ListIterator<String> listIterator2 = listSplit2.listIterator(listSplit2.size());
                    while (true) {
                        if (listIterator2.hasPrevious()) {
                            if (listIterator2.previous().length() != 0) {
                                listEmptyList2 = CollectionsKt.take(listSplit2, listIterator2.nextIndex() + 1);
                                break;
                            }
                        } else {
                            listEmptyList2 = CollectionsKt.emptyList();
                            break;
                        }
                    }
                } else {
                    listEmptyList2 = CollectionsKt.emptyList();
                    break;
                }
                String[] strArr2 = (String[]) listEmptyList2.toArray(new String[0]);
                if (strArr2.length == 2 && Intrinsics.areEqual(strArr2[0], "charset")) {
                    Charset charsetForName = Charset.forName(strArr2[1]);
                    Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
                    return charsetForName;
                }
            }
        }
        return f9410a;
    }
}
