package org.mql.Services;
import org.mql.dao.NotificationRepository;
import org.mql.models.Formation;
import org.mql.models.Member;
import org.mql.models.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class NotificationService  {
	
	@Autowired
	private NotificationRepository notificationRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);
	
	public NotificationService() {}

	public Map<String,Object> updateUserNotification(Notification notification,Member member){

		notification = save(notification);
		if(notification == null){
			return null;
		}
		 
		return updateUserNotification(notification, member);
	}
	
	public Notification save(Notification notification){
		try{
			return notificationRepository.save(notification);
		}catch (Exception e) {
			logger.error("Exception occur while save Notification ",e);
			return null;
		}
	}
	
	public Notification findByMember(Member member) {
		try {
			return notificationRepository.findByToMember(member);
		} catch (Exception e) {
			logger.error("Exception occur while fetch Notification by User ",e);
			return null;
		}
	}
	
	public List<Notification> findAllByMember(Member member) {
		try {
			return notificationRepository.findAllByToMember(member);
		} catch (Exception e) {
			logger.error("Exception occur while fetch Notification by User ",e);
			return null;
		}
	}
	
	/*
	public List<Notification> findByMember(Member member, Integer limit){
		try {
			return notificationRepository.userNotification(member.getId(), PageRequest.of(0, limit));
		} catch (Exception e) {
			logger.error("Exception occur while fetch Notification by User ",e);
			return null;
		}
	}
	*/
	
	public Notification createNotificationObject(String message,Member member){
		//message = "notif test";
		Notification notif =  new Notification(message,member, new Date());
		
		return notif;
		
	}
	
	public Notification createNotificationObject(String message,Formation formation){
		//members = new ArrayList()<>();
		//message = "notif test";
		Notification notif =  new Notification(message,formation.getMembers(), new Date());
		
		return notif;
		
	}
	
	public Notification findByMemberAndNotificationId(Member member,Integer notif_id) {
		try{
			return notificationRepository.findByToMemberAndId(member, notif_id);
		}catch (Exception e) { 
			logger.error("Exception occur while fetch Notification by User and Notification Id ",e);
			return null;
		}
	}
	
	
	
	
	
	
	
	
}
