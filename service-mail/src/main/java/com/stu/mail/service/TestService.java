package com.stu.mail.service;

import com.stu.mail.common.ServerResponse;
import com.stu.mail.pojo.Mail;

public interface TestService {

    ServerResponse testIdempotence();

    ServerResponse accessLimit();

    ServerResponse send(Mail mail);
}
