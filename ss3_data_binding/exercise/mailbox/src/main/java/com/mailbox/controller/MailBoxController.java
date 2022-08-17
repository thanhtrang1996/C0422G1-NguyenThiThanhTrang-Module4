package com.mailbox.controller;

import com.mailbox.model.Mailbox;
import com.mailbox.service.IMailboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MailBoxController {
    @Autowired
    private IMailboxService mailboxService;

    @GetMapping("/check")
    public String goMailbox(Model model) {
        List<String> languageList = mailboxService.languageAll();
        model.addAttribute("languageList", languageList);
        List<String> pageSizeList = mailboxService.pageSizeAll();
        model.addAttribute("pageSizeList", pageSizeList);
        model.addAttribute("mailbox", new Mailbox());
        return "mailbox";
    }

    @PostMapping("/check")
    public String mailbox(@ModelAttribute Mailbox mailbox, Model model) {
        List<Mailbox> mailboxList = mailboxService.displayDetail(mailbox);
        model.addAttribute("mailboxList", mailboxList);
        return "displayDetail";
    }

}
