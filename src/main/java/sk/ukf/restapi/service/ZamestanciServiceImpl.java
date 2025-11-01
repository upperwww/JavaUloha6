package sk.ukf.restapi.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.ukf.restapi.dao.ZamestanciRepository;
import sk.ukf.restapi.entity.zamestanci;

import java.util.List;

@Service
public class ZamestanciServiceImpl implements zamestanciService {

    private final ZamestanciRepository zamestanciRepository;

    public ZamestanciServiceImpl(ZamestanciRepository zamestanciRepository) {
        this.zamestanciRepository = zamestanciRepository;
    }

    @Override
    public List<zamestanci> findAll() {
        return zamestanciRepository.findAll();
    }

    @Override
    public zamestanci findById(int id) {
        return zamestanciRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public zamestanci save(zamestanci entity) {
        return zamestanciRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        zamestanciRepository.deleteById(id);
    }
}
