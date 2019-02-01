package org.mql.controllers;

import java.util.List;
import java.util.ArrayList;
import java.util.Vector;

import org.mql.Services.NotificationService;
import org.mql.dao.FormationRepository;
import org.mql.dao.MemberRepository;
import org.mql.models.Member;
import org.mql.models.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NotificationController {
	
	List<Notification> notifs = new ArrayList<>();
	
	@Autowired
	private NotificationService notificationService;
	
	@Autowired MemberRepository memberRepository;
	@Autowired FormationRepository formationRepository ;
	
	private static Logger logger = LoggerFactory.getLogger(NotificationController.class);

	@GetMapping(value = "/notification")
	public @ResponseBody String generNotif() {
		Notification notification = notificationService.createNotificationObject("Test",memberRepository.findById(2).get());
		notificationService.save(notification);
		System.out.println(notification);
		return "Notification Added";
	}
	
	
	@GetMapping(value = "/notificationmembers")
	public @ResponseBody String generNotiftomembers() {
		Notification notification = notificationService.createNotificationObject("tests",formationRepository.findById(1).get());
		notificationService.save(notification);
		System.out.println(notification);
		return "Notification Added";
	}
	
	
	@GetMapping("/showNotifications")
	public String getNotificationsByMember(Model model) {
		
		
		
		logger.debug("inside getNotificationsByUser api for fetch user notification ");
		//Notification notification = notificationService.findByMember(memberRepository.findById(1).get());
		notifs = notificationService.findAllByMember(memberRepository.findById(2).get());
		
		model.addAttribute("list_ofNotifications", notifs);
		return "test/memberNotifications";

	}

}
