package sam.ocr.escalade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import sam.ocr.escalade.config.ApplicationConfig;
import sam.ocr.escalade.dto.NavDTO;

public class TableNavigationHelper {

    protected ApplicationConfig applicationConfig;

    @Autowired
    public TableNavigationHelper(ApplicationConfig applicationConfig){
        this.applicationConfig = applicationConfig;
    }

    protected NavDTO buildNavInfo(int currentPage, int totalPages) {
        if (totalPages == 1)
            return null;

        NavDTO nav = new NavDTO();
        int pageLimitMin = 0;
        int pageLimitMax = totalPages - 1;

        int pageMin = currentPage - (applicationConfig.nbItemNavigation - 1) / 2;
        int pageMax = currentPage + (applicationConfig.nbItemNavigation - 1) / 2;

        for (int i = pageMin; i < currentPage; i++) {
            if (i < pageLimitMin)
                pageMax++;
        }
        for (int i = pageMax; i > currentPage; i--) {
            if (i > pageLimitMax)
                pageMin--;
        }
        pageMin = Math.max(pageMin, pageLimitMin);
        pageMax = Math.min(pageMax, pageLimitMax);

        for (int i = pageMin; i <= pageMax; i++) {
            if (currentPage == i)
                nav.addItem(i, true);
            else
                nav.addItem(i, false);
        }
        if (currentPage != pageLimitMin)
            nav.addPrevious(currentPage - 1);
        if (currentPage != pageLimitMax)
            nav.addNext(currentPage + 1);

        return nav;
    }
}
