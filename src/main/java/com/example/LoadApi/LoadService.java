package com.example.LoadApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class LoadService {
    private final LoadRepository loadRepository;

    @Autowired
    public LoadService(LoadRepository loadRepository) {
        this.loadRepository = loadRepository;
    }

    public String addLoad(Load load) {
        loadRepository.save(load);
        return "Load details added successfully";
    }

    public List<Load> getLoadsByShipperId(String shipperId) {
        return loadRepository.findByShipperId(shipperId);
    }

    public Load getLoadById(Long loadId) {
        return loadRepository.findById(loadId).orElse(null);
    }

    public Load updateLoad(Long loadId, Load updatedLoad) {
        Load existingLoad = loadRepository.findById(loadId).orElse(null);
        if (existingLoad != null) {
            // Update the load data here
            existingLoad.setLoadingPoint(updatedLoad.getLoadingPoint());
            existingLoad.setUnloadingPoint(updatedLoad.getUnloadingPoint());
            existingLoad.setProductType(updatedLoad.getProductType());
            existingLoad.setTruckType(updatedLoad.getTruckType());
            existingLoad.setNoOfTrucks(updatedLoad.getNoOfTrucks());
            existingLoad.setWeight(updatedLoad.getWeight());
            existingLoad.setComment(updatedLoad.getComment());
            existingLoad.setDate(updatedLoad.getDate());

            loadRepository.save(existingLoad);
        }
        return existingLoad;
    }

    public String deleteLoad(Long loadId) {
        loadRepository.deleteById(loadId);
        return "Load deleted successfully";
    }
}
