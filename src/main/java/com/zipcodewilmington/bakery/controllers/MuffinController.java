package com.zipcodewilmington.bakery.controllers;

import com.zipcodewilmington.bakery.models.Muffin;
import com.zipcodewilmington.bakery.services.MuffinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class MuffinController {
    private MuffinService service;

    @Autowired
    public MuffinController(MuffinService service) {
        this.service = service;
    }

    @RequestMapping(value = "/muffins/", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Iterable<Muffin>> index() {
        return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }

    @RequestMapping(value = "/muffins/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Muffin> show(@PathVariable Long id) {
        return new ResponseEntity<>(service.show(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/muffins/", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Muffin> create(@RequestBody Muffin baker) {
        return new ResponseEntity<>(service.create(baker), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/muffins/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Muffin> update(@PathVariable Long id, @RequestBody Muffin baker) {
        return new ResponseEntity<>(service.update(id, baker), HttpStatus.OK);
    }

    @RequestMapping(value = "/muffins/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Boolean> destroy(@PathVariable Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
