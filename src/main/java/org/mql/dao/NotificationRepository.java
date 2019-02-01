package org.mql.dao;

import java.util.List;

import org.mql.models.Member;
import org.mql.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {
	
	Notification findByToMember(Member membr);
	List<Notification> findAllByToMember(Member membr);
	//@Query("select n from Notification n where n.memb_id=:memb_id ORDER BY n.date DESC")
	//List<Notification> userNotification(@Param("memb_id") Integer memb_id,Pageable pageSize);
	Notification findByToMemberAndId(Member member,Integer notif_id);
	@SuppressWarnings("unchecked")
	Notification save(Notification notification);
	
}
