package sk.ukf.restapi.service;

import sk.ukf.restapi.entity.zamestanci;

import java.util.List;

public interface zamestanciService {

    List<zamestanci> findAll();
    zamestanci findById(int id);
    zamestanci save(zamestanci zamestanci);
    void deleteById(int id);

}
