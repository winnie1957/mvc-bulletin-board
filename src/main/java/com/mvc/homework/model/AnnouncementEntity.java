package com.mvc.homework.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 公告
 * @author winnie1957
 *
 */
@Entity
@Table(name = "announcements")
public class AnnouncementEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // 標題
    @Column(name = "title")
    private String title;
    
    // 公布內容
    @Column(name = "content")
    private String content;
    
    // 公布者
    @Column(name = "publish_by")
    private String publishBy;
    
    // 發佈日期
    @Column(name = "publish_at")
    private LocalDate publishAt;
    
    // 截止日期
    @Column(name = "closed_at")
    private LocalDate closedAt;

    public AnnouncementEntity() {}
    
    /** constructor */
    public AnnouncementEntity(Long id, String title, String content, String publishBy, LocalDate publishAt, LocalDate closedAt) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.publishBy = publishBy;
		this.publishAt = publishAt;
		this.closedAt = closedAt;
	}
    
    public AnnouncementEntity(Long id) {
		super();
		this.id = id;
	}
    
    public AnnouncementEntity(String title, String content, String publishBy, LocalDate publishAt, LocalDate closedAt) {
		super();
		this.title = title;
		this.content = content;
		this.publishBy = publishBy;
		this.publishAt = publishAt;
		this.closedAt = closedAt;
	}
    

	/** getter setter */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPublishBy() {
		return publishBy;
	}

	public void setPublishBy(String publishBy) {
		this.publishBy = publishBy;
	}

	public LocalDate getPublishAt() {
		return publishAt;
	}

	public void setPublishAt(LocalDate publishAt) {
		this.publishAt = publishAt;
	}

	public LocalDate getClosedAt() {
		return closedAt;
	}

	public void setClosedAt(LocalDate closedAt) {
		this.closedAt = closedAt;
	}

	/** toString */
	@Override
	public String toString() {
		return "AnnouncementEntity [id=" + id + ", title=" + title + ", content=" + content + ", publishBy=" + publishBy
				+ ", publishAt=" + publishAt + ", closedAt=" + closedAt + "]";
	}

    
}
