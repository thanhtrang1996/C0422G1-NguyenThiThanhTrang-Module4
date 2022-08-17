package com.mailbox.repository;

import com.mailbox.model.Mailbox;

import java.util.List;

public interface IMailBoxRepository {

    List<String> languageAll();

    List<String> pageSizeAll();

    List<Mailbox> displayDetail(Mailbox mailbox);
}
