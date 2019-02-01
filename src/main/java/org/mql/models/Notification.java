package org.mql.models;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.mql.models.Member;

@Entity
@Table(name="notification")
public class Notification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "notif_id")
	private int id;
	
	@Column(name = "content")
	private String content;
//	
	@OneToMany(mappedBy = "notification", cascade = CascadeType.ALL)
	private List<Member> ToMembers;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "memb_id")
	private Member toMember;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "isRead")
	private String isRead;
	
//	@ManyToOne
//	private Member user;
	
	public Notification() {
		
	}


	public Notification(int id, String content, Member tomember, List<Member> tomembers,Date date, String isRead,
			Member user) {
		super();
		this.id = id;
		this.content = content;
		this.ToMembers = tomembers;
		this.toMember = tomember;
		this.date = date;
		this.isRead = isRead;
		//this.user = user;
	}

	


	public Notification(String content, Member tomember, Date date) {
		super();
		this.content = content;
		this.toMember = tomember;
		this.date = date;
	}

	

	public Notification(String content, List<Member> tomembers, Date date) {
		super();
		this.content = content;
		this.ToMembers = tomembers;
		this.date = date;
	}


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public List<Member> getTomembers() {
		return ToMembers;
	}


	public void setTomembers(List<Member> tomembers) {
		ToMembers = tomembers;
	}


	public Member getTomember() {
		return toMember;
	}


	public void setTomember(Member tomember) {
		this.toMember = tomember;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String isRead() {
		return isRead;
	}


	public void setRead(String isRead) {
		this.isRead = isRead;
	}
	
	public void addMember(Member membr) {
		if (ToMembers == null) {

			ToMembers = new ArrayList<Member>();

		}
		ToMembers.add(membr);
	}



}
