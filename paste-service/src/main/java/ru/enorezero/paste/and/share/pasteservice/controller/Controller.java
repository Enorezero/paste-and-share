package ru.enorezero.paste.and.share.pasteservice.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.enorezero.paste.and.share.pasteservice.api.request.PasteRequest;
import ru.enorezero.paste.and.share.pasteservice.api.responce.PasteResponce;
import ru.enorezero.paste.and.share.pasteservice.service.PasteService;

import java.util.List;

@RestController
@Data
@RequestMapping("/paste")
public class Controller {

    @Autowired
    PasteService service;

    @GetMapping("/test")
    public String test(){
        return "succesfully!";
    }

//    @GetMapping("/{hash}")
//    public String getByHash(@PathVariable String hash){
//
//        return service.deHashURLByBase64(hash);
//    }

    @GetMapping("/")
    public List<PasteResponce> getLastPublic(){
        return null;
    }

    @PostMapping
    public String createPaste(@RequestBody PasteRequest request){
        return service.createPaste(request);
    }
}
