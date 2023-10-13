package ru.enorezero.paste.and.share.pasteservice.controller;

import lombok.Data;
import org.springframework.web.bind.annotation.*;
import ru.enorezero.paste.and.share.pasteservice.api.request.PasteRequest;

@RestController
@Data
@RequestMapping("/paste-service")
public class Controller {

    @GetMapping("/{hash}")
    public String getByHash(@PathVariable String hash){
        return hash;
    }



    @PostMapping
    public String createPaste(@RequestBody PasteRequest request){
        return request.getData();
    }
}
