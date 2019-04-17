package sam.ocr.escalade.service;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

    boolean store(MultipartFile file);
}
