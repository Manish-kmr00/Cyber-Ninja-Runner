package com.yandex.div.storage.db;

import com.yandex.div.storage.entity.Template;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: TemplateDao.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\t\u001a\u00020\nH&J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\u0006H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/storage/db/TemplateDao;", "", "deleteAllTemplates", "", "deleteUnusedTemplates", "getAllTemplates", "", "Lcom/yandex/div/storage/entity/Template;", "getTemplates", "cardId", "", "getTemplatesByIds", "templateIds", "insertTemplate", "template", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface TemplateDao {
    void deleteAllTemplates();

    void deleteUnusedTemplates();

    List<Template> getAllTemplates();

    List<Template> getTemplates(String cardId);

    List<Template> getTemplatesByIds(List<String> templateIds);

    void insertTemplate(Template template);
}
