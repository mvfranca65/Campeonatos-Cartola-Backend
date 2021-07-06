package com.cartola.group.Service.Impl;

import com.cartola.group.Entity.NoticeEntity;
import com.cartola.group.Repository.NoticeRepository;
import com.cartola.group.Service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    NoticeRepository repository;

    @Override
    public ResponseEntity newNotice(NoticeEntity body) {
        Date date = new Date();
        body.setTimestamp(date);

        repository.save(body);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity findNotices() {
        List<NoticeEntity> result = repository.findAll();
        return buildResponse(result);
    }

    @Override
    public ResponseEntity deleteNotice(long id) {
        return repository.findById(id)
                .map(user -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    private ResponseEntity buildResponse(List result) {
        if(result.size() == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }
    }

}
