package com.mailbox.service.impl;

import com.mailbox.model.Mailbox;
import com.mailbox.repository.IMailBoxRepository;
import com.mailbox.service.IMailboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailBoxService implements IMailboxService {
    @Autowired
    private IMailBoxRepository mailBoxRepository;

    @Override
    public List<String> languageAll() {
        return mailBoxRepository.languageAll();
    }

    @Override
    public List<String> pageSizeAll() {
        return mailBoxRepository.pageSizeAll();
    }

    @Override
    public List<Mailbox> displayDetail(Mailbox mailbox) {
        return  mailBoxRepository.displayDetail( mailbox);

    }
}
