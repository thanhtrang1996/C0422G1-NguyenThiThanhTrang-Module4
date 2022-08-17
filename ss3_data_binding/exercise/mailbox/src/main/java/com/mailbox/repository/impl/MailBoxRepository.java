package com.mailbox.repository.impl;

import com.mailbox.model.Mailbox;
import com.mailbox.repository.IMailBoxRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MailBoxRepository implements IMailBoxRepository {
    private static List<Mailbox> mailboxList = new ArrayList<>();
    private static List<String> language = new ArrayList<>();
    private static List<String> pageSize = new ArrayList<>();

    static {
        language.add("English");
        language.add("Vietnamese");
        language.add("Japanese");
        language.add("Chinese");
    }
    static {
        pageSize.add("5");
        pageSize.add("10");
        pageSize.add("15");
        pageSize.add("25");
        pageSize.add("50");
        pageSize.add("100");
    }

    @Override
    public List<String> languageAll() {
        return language;
    }

    @Override
    public List<String> pageSizeAll() {
        return pageSize;
    }

    @Override
    public List<Mailbox> displayDetail(Mailbox mailbox) {
        mailboxList.add(mailbox);
        return mailboxList;
    }
}
