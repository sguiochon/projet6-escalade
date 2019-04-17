package sam.ocr.escalade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sam.ocr.escalade.model.Topo;
import sam.ocr.escalade.model.User;
import sam.ocr.escalade.repository.TopoRepository;
import sam.ocr.escalade.repository.UserRepository;

import java.util.Optional;

@Service
public class PretService {

    TopoRepository topoRepository;
    UserRepository userRepository;
    StorageService storageService;

    @Autowired
    public PretService(TopoRepository topoRepository, UserRepository userRepository, StorageService storageService) {
        this.topoRepository = topoRepository;
        this.userRepository = userRepository;
        this.storageService = storageService;
    }

    public Page<Topo> getTopoPrets(int pageSize, int pageNumber, String emailPreteur) {
        PageRequest pageIn = PageRequest.of(pageNumber, pageSize);
        return topoRepository.findByPreteurEmailIgnoreCase(pageIn, emailPreteur);
    }

    public boolean createTopo(String titre, String description, MultipartFile file, String emailPreteur) {
        Optional<User> user = userRepository.findByEmailIgnoreCase(emailPreteur);
        if (!user.isPresent())
            return false;

        Topo topo = new Topo();
        topo.setTitre(titre);
        topo.setDescription(description);
        topo.setPreteur(user.get());
        boolean result = storageService.store(file);
        if (result){
            topo.setImage1(file.getOriginalFilename());
        }
        else{
            topo.setImage1("generic_topo.jpg");
        }
        topoRepository.save(topo);

        return true;
    }

}
