package com.cartola.group.Service;

import com.cartola.group.Entity.NoticeEntity;
import org.springframework.http.ResponseEntity;

public interface NoticeService {

    ResponseEntity newNotice(NoticeEntity body);

    ResponseEntity findNotices();

    ResponseEntity deleteNotice(long id);

}
