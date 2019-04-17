package sam.ocr.escalade.service;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import sam.ocr.escalade.exception.StorageException;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileStorageService implements StorageService {

    ServletContext context;
    private Logger logger = LoggerFactory.logger(FileStorageService.class);
    private Path rootLocation;

    @Autowired
    public FileStorageService(ServletContext servletContext) {
        this.context = servletContext;
        rootLocation = Paths.get(context.getRealPath("/WEB-INF/classes/static"));
    }

    @Override
    public boolean store(MultipartFile file) {

        logger.debug("Sauvegarde du fichier dans " + context.getRealPath("/WEB-INF/classes/static"));
        //String uploadPath = context.getRealPath("");

        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (file.isEmpty()) {
                logger.error("Failed to store empty file " + filename);
                return false;
            }
            if (filename.contains("..")) {
                // This is a security check
                logger.error("Cannot store file with relative path outside current directory " + filename);
                return false;
            }
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, this.rootLocation.resolve(filename));
            }
        } catch (IOException e) {
            logger.error("Erreur en tentant de sauvegarder le fichier uploadé", e);
            return false;
        }
        return true;
    }
}
