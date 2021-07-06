package com.cartola.group.Controller;

import com.cartola.group.Entity.NoticeEntity;
import com.cartola.group.Service.NoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/notices"})
@Api(value = "Notice")
@CrossOrigin(origins = "*")
public class NoticeController {

    @Autowired
    NoticeService service;

    @PostMapping({"/new"})
    @ApiOperation(value = "Novo aviso")
    public ResponseEntity newNotice(@RequestBody NoticeEntity body) {
        return service.newNotice(body);
    }

    @GetMapping()
    @ApiOperation(value = "Buscar todos os avisos")
    public ResponseEntity findNotices() {
        return service.findNotices();
    }

    @DeleteMapping({"/{id}"})
    @ApiOperation(value = "Excluir aviso")
    public ResponseEntity deleteNotice(@PathVariable(value = "id") long id) {
        return service.deleteNotice(id);
    }

}
