package com.phone.controller;

import com.phone.model.Smartphone;
import com.phone.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/smartphones")
public class SmartphoneController {
    @Autowired
    private ISmartphoneService smartphoneService;

    @GetMapping("/list")
    public ResponseEntity<Page<Smartphone>> goPage(@PageableDefault(5) Pageable pageable,
                                                   @RequestParam Optional<String> name) {

        String keyName = name.orElse("");
        Page<Smartphone> smartphonePage = smartphoneService.findAll(pageable, keyName);
        if (!smartphonePage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(smartphonePage, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Page<Smartphone>> create(@RequestBody Smartphone smartphone) {
        smartphoneService.save(smartphone);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/update/{id}")
    public ResponseEntity<Smartphone> goUpdate(@PathVariable Integer id) {
        Smartphone smartphone = smartphoneService.findById(id);
        return new ResponseEntity<>(smartphone, HttpStatus.OK);
    }

    @PatchMapping("/update")
    public ResponseEntity<Void> update(@RequestBody Smartphone smartphone) {
        try {
            this.smartphoneService.save(smartphone);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Void> goDelete(@PathVariable Integer id) {
        smartphoneService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
