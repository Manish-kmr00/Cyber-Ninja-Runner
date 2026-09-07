package com.ogury.ad.internal;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class v7 {
    public static void a(String serializedProfigResponse) throws d9 {
        Intrinsics.checkNotNullParameter(serializedProfigResponse, "serializedProfigResponse");
        if (!new JSONObject(serializedProfigResponse).has("response")) {
            throw new d9(new y5("\"response\" key not found", 3), b9.PARSING_ERROR);
        }
    }

    /* JADX WARN: Code duplicated, block: B:110:0x0214  */
    public static z7 a(JSONObject jSONObject) {
        String str;
        String string;
        String string2;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("response");
        if (jSONObjectOptJSONObject != null) {
            z7 z7Var = new z7();
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("global");
            if (jSONObjectOptJSONObject2 != null) {
                z7.f fVar = z7Var.b;
                Integer numB = w7.b("request_timeout", jSONObjectOptJSONObject2);
                if (numB != null) {
                    fVar.f7468a = numB.intValue();
                }
                Integer numB2 = w7.b("children_request_permissions_filter", jSONObjectOptJSONObject2);
                if (numB2 != null) {
                    fVar.b = numB2.intValue();
                }
            }
            JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject("config_pull");
            if (jSONObjectOptJSONObject3 != null) {
                z7.c cVar = z7Var.c;
                Integer numB3 = w7.b("limit_per_day", jSONObjectOptJSONObject3);
                if (numB3 != null) {
                    cVar.f7466a = numB3.intValue();
                }
            }
            JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject.optJSONObject("ad_serving");
            if (jSONObjectOptJSONObject4 != null) {
                z7.b bVar = z7Var.d;
                Boolean boolA = w7.a("enabled", jSONObjectOptJSONObject4);
                if (boolA != null) {
                    bVar.f7465a = boolA.booleanValue();
                }
                Intrinsics.checkNotNullParameter(jSONObjectOptJSONObject4, "<this>");
                Intrinsics.checkNotNullParameter("disabling_reason", "name");
                if (jSONObjectOptJSONObject4.has("disabling_reason")) {
                    try {
                        string2 = jSONObjectOptJSONObject4.getString("disabling_reason");
                    } catch (Exception unused) {
                        string2 = null;
                    }
                } else {
                    string2 = null;
                }
                if (string2 != null) {
                    bVar.getClass();
                    Intrinsics.checkNotNullParameter(string2, "<set-?>");
                    bVar.c = string2;
                }
                Integer numB4 = w7.b("request_permissions", jSONObjectOptJSONObject4);
                if (numB4 != null) {
                    bVar.b = numB4.intValue();
                }
                Long lC = w7.c("ad_expiration_time", jSONObjectOptJSONObject4);
                if (lC != null) {
                    bVar.d = lC.longValue();
                }
                JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject4.optJSONObject(com.ironsource.b9.h.K);
                if (jSONObjectOptJSONObject5 != null) {
                    z7.o oVar = bVar.e;
                    Boolean boolA2 = w7.a("back_button_enabled", jSONObjectOptJSONObject5);
                    if (boolA2 != null) {
                        oVar.f7475a = boolA2.booleanValue();
                    }
                    Boolean boolA3 = w7.a("close_ad_when_leaving_app", jSONObjectOptJSONObject5);
                    if (boolA3 != null) {
                        oVar.b = boolA3.booleanValue();
                    }
                    Long lC2 = w7.c("webview_load_timeout", jSONObjectOptJSONObject5);
                    if (lC2 != null) {
                        oVar.c = lC2.longValue();
                    }
                    Long lC3 = w7.c("show_close_button_delay", jSONObjectOptJSONObject5);
                    if (lC3 != null) {
                        oVar.d = lC3.longValue();
                    }
                }
                JSONObject jSONObjectOptJSONObject6 = jSONObjectOptJSONObject4.optJSONObject("thumbnail");
                if (jSONObjectOptJSONObject6 != null) {
                    z7.j jVar = bVar.f;
                    JSONObject jSONObjectOptJSONObject7 = jSONObjectOptJSONObject6.optJSONObject("default");
                    if (jSONObjectOptJSONObject7 != null) {
                        z7.e eVar = jVar.f7472a;
                        Integer numB5 = w7.b("gravity", jSONObjectOptJSONObject7);
                        if (numB5 != null) {
                            eVar.f7467a = numB5.intValue();
                        }
                        Integer numB6 = w7.b("x_margin", jSONObjectOptJSONObject7);
                        if (numB6 != null) {
                            eVar.b = numB6.intValue();
                        }
                        Integer numB7 = w7.b("y_margin", jSONObjectOptJSONObject7);
                        if (numB7 != null) {
                            eVar.c = numB7.intValue();
                        }
                        Integer numB8 = w7.b("max_width", jSONObjectOptJSONObject7);
                        if (numB8 != null) {
                            eVar.d = numB8.intValue();
                        }
                        Integer numB9 = w7.b("max_height", jSONObjectOptJSONObject7);
                        if (numB9 != null) {
                            eVar.e = numB9.intValue();
                        }
                    }
                    JSONObject jSONObjectOptJSONObject8 = jSONObjectOptJSONObject6.optJSONObject("view");
                    if (jSONObjectOptJSONObject8 != null) {
                        z7.k kVar = jVar.c;
                        str = "name";
                        Boolean boolA4 = w7.a("multiactivity_enabled", jSONObjectOptJSONObject8);
                        if (boolA4 != null) {
                            kVar.f = boolA4.booleanValue();
                        }
                        Boolean boolA5 = w7.a("default_whitelist_enabled", jSONObjectOptJSONObject8);
                        if (boolA5 != null) {
                            kVar.f7474a = boolA5.booleanValue();
                        }
                        Boolean boolA6 = w7.a("publisher_whitelist_enabled", jSONObjectOptJSONObject8);
                        if (boolA6 != null) {
                            kVar.b = boolA6.booleanValue();
                        }
                        Boolean boolA7 = w7.a("publisher_blacklist_enabled", jSONObjectOptJSONObject8);
                        if (boolA7 != null) {
                            kVar.c = boolA7.booleanValue();
                        }
                        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject8.optJSONArray("whitelist");
                        if (jSONArrayOptJSONArray != null) {
                            List<String> listA = d3.a(jSONArrayOptJSONArray);
                            kVar.getClass();
                            Intrinsics.checkNotNullParameter(listA, "<set-?>");
                            kVar.d = listA;
                        }
                        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject8.optJSONArray("blacklist");
                        if (jSONArrayOptJSONArray2 != null) {
                            List<String> listA2 = d3.a(jSONArrayOptJSONArray2);
                            kVar.getClass();
                            Intrinsics.checkNotNullParameter(listA2, "<set-?>");
                            kVar.e = listA2;
                        }
                    } else {
                        str = "name";
                    }
                    JSONObject jSONObjectOptJSONObject9 = jSONObjectOptJSONObject6.optJSONObject("view_fragment");
                    if (jSONObjectOptJSONObject9 != null) {
                        z7.l lVar = jVar.b;
                        Boolean boolA8 = w7.a("fragment_filter_enabled", jSONObjectOptJSONObject9);
                        if (boolA8 != null) {
                            lVar.f = boolA8.booleanValue();
                        }
                        Boolean boolA9 = w7.a("default_whitelist_enabled", jSONObjectOptJSONObject9);
                        if (boolA9 != null) {
                            lVar.f7474a = boolA9.booleanValue();
                        }
                        Boolean boolA10 = w7.a("publisher_whitelist_enabled", jSONObjectOptJSONObject9);
                        if (boolA10 != null) {
                            lVar.b = boolA10.booleanValue();
                        }
                        Boolean boolA11 = w7.a("publisher_blacklist_enabled", jSONObjectOptJSONObject9);
                        if (boolA11 != null) {
                            lVar.c = boolA11.booleanValue();
                        }
                        JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject9.optJSONArray("whitelist");
                        if (jSONArrayOptJSONArray3 != null) {
                            List<String> listA3 = d3.a(jSONArrayOptJSONArray3);
                            lVar.getClass();
                            Intrinsics.checkNotNullParameter(listA3, "<set-?>");
                            lVar.d = listA3;
                        }
                        JSONArray jSONArrayOptJSONArray4 = jSONObjectOptJSONObject9.optJSONArray("blacklist");
                        if (jSONArrayOptJSONArray4 != null) {
                            List<String> listA4 = d3.a(jSONArrayOptJSONArray4);
                            lVar.getClass();
                            Intrinsics.checkNotNullParameter(listA4, "<set-?>");
                            lVar.e = listA4;
                        }
                    }
                } else {
                    str = "name";
                }
            } else {
                str = "name";
            }
            JSONObject jSONObjectOptJSONObject10 = jSONObjectOptJSONObject.optJSONObject("monitoring");
            if (jSONObjectOptJSONObject10 != null) {
                z7.g gVar = z7Var.e;
                Integer numB10 = w7.b("request_permissions", jSONObjectOptJSONObject10);
                if (numB10 != null) {
                    gVar.f7469a = numB10.intValue();
                }
                JSONObject jSONObjectOptJSONObject11 = jSONObjectOptJSONObject10.optJSONObject("tracks");
                if (jSONObjectOptJSONObject11 != null) {
                    z7.m mVar = gVar.b;
                    Boolean boolA12 = w7.a("enabled", jSONObjectOptJSONObject11);
                    if (boolA12 != null) {
                        mVar.f7473a = boolA12.booleanValue();
                    }
                }
                JSONObject jSONObjectOptJSONObject12 = jSONObjectOptJSONObject10.optJSONObject("precaching_logs");
                if (jSONObjectOptJSONObject12 != null) {
                    z7.i iVar = gVar.c;
                    Boolean boolA13 = w7.a("enabled", jSONObjectOptJSONObject12);
                    if (boolA13 != null) {
                        iVar.f7471a = boolA13.booleanValue();
                    }
                }
                JSONObject jSONObjectOptJSONObject13 = jSONObjectOptJSONObject10.optJSONObject("ad_life_cycle");
                if (jSONObjectOptJSONObject13 != null) {
                    z7.a aVar = gVar.d;
                    Boolean boolA14 = w7.a("enabled", jSONObjectOptJSONObject13);
                    if (boolA14 != null) {
                        aVar.f7464a = boolA14.booleanValue();
                    }
                    JSONArray jSONArrayOptJSONArray5 = jSONObjectOptJSONObject13.optJSONArray("blacklist");
                    if (jSONArrayOptJSONArray5 != null) {
                        List<String> listA5 = d3.a(jSONArrayOptJSONArray5);
                        aVar.getClass();
                        Intrinsics.checkNotNullParameter(listA5, "<set-?>");
                        aVar.b = listA5;
                    }
                }
            }
            JSONObject jSONObjectOptJSONObject14 = jSONObjectOptJSONObject.optJSONObject(CampaignEx.KEY_OMID);
            if (jSONObjectOptJSONObject14 != null) {
                z7.h hVar = z7Var.f;
                Boolean boolA15 = w7.a("enabled", jSONObjectOptJSONObject14);
                if (boolA15 != null) {
                    hVar.f7470a = boolA15.booleanValue();
                }
            }
            JSONObject jSONObjectOptJSONObject15 = jSONObjectOptJSONObject.optJSONObject("crash_report");
            if (jSONObjectOptJSONObject15 != null) {
                z7.d dVar = z7Var.g;
                Intrinsics.checkNotNullParameter(jSONObjectOptJSONObject15, "<this>");
                Intrinsics.checkNotNullParameter("url", str);
                if (jSONObjectOptJSONObject15.has("url")) {
                    try {
                        string = jSONObjectOptJSONObject15.getString("url");
                    } catch (Exception unused2) {
                        string = null;
                    }
                } else {
                    string = null;
                }
                if (string != null) {
                    dVar.getClass();
                    Intrinsics.checkNotNullParameter(string, "<set-?>");
                }
            }
            z7Var.f7463a = true;
            return z7Var;
        }
        return new z7();
    }
}
