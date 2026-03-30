package com.eco.platform.controller;

import com.eco.platform.model.*;
import com.eco.platform.repository.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/forms")
@CrossOrigin(origins = "*")
public class FormController {

    private final NewsletterRepository newsletterRepo;
    private final ProjectMessageRepository projectMsgRepo;
    private final ContactInquiryRepository contactRepo;
    private final HelpRequestRepository helpRepo;

    public FormController(NewsletterRepository newsletterRepo,
                          ProjectMessageRepository projectMsgRepo,
                          ContactInquiryRepository contactRepo,
                          HelpRequestRepository helpRepo) {
        this.newsletterRepo = newsletterRepo;
        this.projectMsgRepo =projectMsgRepo;
        this.contactRepo = contactRepo;
        this.helpRepo = helpRepo;
    }

    @PostMapping("/newsletter")
    public ResponseEntity<?> subscribe(@RequestBody Newsletter sub) {
        return ResponseEntity.ok(newsletterRepo.save(sub));
    }

    @PostMapping("/project-message")
    public ResponseEntity<?> sendProjectMessage(@RequestBody ProjectMessage msg) {
        return ResponseEntity.ok(projectMsgRepo.save(msg));
    }

    @PostMapping("/contact")
    public ResponseEntity<?> sendContactInquiry(@RequestBody ContactInquiry inquiry) {
        return ResponseEntity.ok(contactRepo.save(inquiry));
    }

    @PostMapping("/help")
    public ResponseEntity<?> requestHelp(@RequestBody HelpRequest help) {
        return ResponseEntity.ok(helpRepo.save(help));
    }
}
