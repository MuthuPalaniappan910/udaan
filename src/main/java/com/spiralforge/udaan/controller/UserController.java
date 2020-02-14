package com.spiralforge.udaan.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spiralforge.udaan.entity.User;
import com.spiralforge.udaan.helper.GeneratePdfReport;
import com.spiralforge.udaan.helper.MailService;
import com.spiralforge.udaan.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private GeneratePdfReport generatePdfReport;

	@Autowired
	private MailService mailService;

	@GetMapping(value = "{userId}/download", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> download(@PathVariable("userId") Long userId) throws IOException {

		Optional<User> user = userService.getUser(userId);

		if (!user.isPresent()) {
			return ResponseEntity.badRequest().build();
		} else {

			byte[] b = generatePdfReport.generatePdf(user.get());
			ByteArrayInputStream bis = new ByteArrayInputStream(b);
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

			return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
					.body(new InputStreamResource(bis));
		}
	}

	@GetMapping(value = "{userId}/email", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> email(@PathVariable("userId") Long userId) throws IOException {

		Optional<User> user = userService.getUser(userId);

		if (!user.isPresent()) {
			return ResponseEntity.badRequest().build();
		} else {
			byte[] b = generatePdfReport.generatePdf(user.get());
			ByteArrayInputStream bis = new ByteArrayInputStream(b);

			mailService.sendMail("sujalshaikhsk@gmail.com", "Test", "Kuch", b );
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "inline; filename=udaan.pdf");

			return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
					.body(new InputStreamResource(bis));
		}
	}
}
