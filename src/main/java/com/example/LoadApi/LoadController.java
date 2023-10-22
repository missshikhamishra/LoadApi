package com.example.LoadApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/load")
public class LoadController {
    private final LoadService loadService;

    @Autowired
    public LoadController(LoadService loadService) {
        this.loadService = loadService;
    }

    @PostMapping("/add-load")
    public ResponseEntity<String> addLoad(@RequestBody Load load) {
        String response = loadService.addLoad(load);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/get-load-by-shiperid")
    public ResponseEntity<List<Load>> getLoadsByShipperId(@RequestParam("shipperId") String shipperId) {
        List<Load> loads = loadService.getLoadsByShipperId(shipperId);
        return new ResponseEntity<>(loads, HttpStatus.OK);
    }

    @GetMapping("/{loadId}")
    public ResponseEntity<Load> getLoadById(@PathVariable Long loadId) {
        Load load = loadService.getLoadById(loadId);
        if (load != null) {
            return new ResponseEntity<>(load, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{loadId}")
    public ResponseEntity<Load> updateLoad(@PathVariable Long loadId, @RequestBody Load updatedLoad) {
        Load updated = loadService.updateLoad(loadId, updatedLoad);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{loadId}")
    public ResponseEntity<String> deleteLoad(@PathVariable Long loadId) {
        String response = loadService.deleteLoad(loadId);
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }
}