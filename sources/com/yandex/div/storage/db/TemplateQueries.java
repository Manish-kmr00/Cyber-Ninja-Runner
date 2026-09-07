package com.yandex.div.storage.db;

import kotlin.Metadata;

/* JADX INFO: compiled from: DB.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/yandex/div/storage/db/TemplateQueries;", "", "()V", "DELETE_ALL_TEMPLATES_QUERY", "", "DELETE_UNUSED_TEMPLATES_QUERY_TEMPLATE", "GET_ALL_TEMPLATES_QUERY", "GET_TEMPLATES_BY_CARD_ID_QUERY_TEMPLATE", "GET_TEMPLATES_BY_IDS_QUERY_TEMPLATE_WITHOUT_PLACEHOLDER", "INSERT_TEMPLATE_QUERY_TEMPLATE", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TemplateQueries {
    public static final String DELETE_ALL_TEMPLATES_QUERY = "DELETE FROM templates";
    public static final String DELETE_UNUSED_TEMPLATES_QUERY_TEMPLATE = "DELETE FROM templates WHERE template_id NOT IN (SELECT DISTINCT template_id FROM template_usages)";
    public static final String GET_ALL_TEMPLATES_QUERY = "SELECT * FROM templates";
    public static final String GET_TEMPLATES_BY_CARD_ID_QUERY_TEMPLATE = "SELECT templates.template_id, templates.template_data FROM templates INNER JOIN template_usages ON templates.template_id = template_usages.template_id WHERE template_usages.card_id = ?";
    public static final String GET_TEMPLATES_BY_IDS_QUERY_TEMPLATE_WITHOUT_PLACEHOLDER = "SELECT template_id, template_data FROM templates WHERE template_id IN ";
    public static final String INSERT_TEMPLATE_QUERY_TEMPLATE = "INSERT OR IGNORE INTO `templates` (`template_id`,`template_data`) VALUES (?,?)";
    public static final TemplateQueries INSTANCE = new TemplateQueries();

    private TemplateQueries() {
    }
}
