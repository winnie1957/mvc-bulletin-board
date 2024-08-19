package com.mvc.homework.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AnnouncementDto {

	private Long id;
	private String title;
    
    // 公布內容
    private String content;
    
    // 公布者
    private String publishBy;
    
    // 發佈日期
    private String publishDate;
    
    // 截止日期
    private String closedDate;
	

    /** constructor */
    public AnnouncementDto() {}
    
    public AnnouncementDto(Long id, String title, String content, String publishBy, String publishDate, String closedDate) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.publishBy = publishBy;
		this.publishDate = publishDate;
		this.closedDate = closedDate;
	}
    
    public static AnnouncementDtoBuilder builder() {
    	return new AnnouncementDtoBuilder();
    }

	/** getter setter */


	/** toString */
	@Override
	public String toString() {
		return "AnnouncementDto [id=" + id + ", title=" + title + ", content=" + content + ", publishBy=" + publishBy
				+ ", publishDate=" + publishDate + ", closedDate=" + closedDate + "]";
	}
	
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

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getClosedDate() {
		return closedDate;
	}

	public void setClosedDate(String closedDate) {
		this.closedDate = closedDate;
	}

	/** builder */
	public static class AnnouncementDtoBuilder {
	    private Long id;
	    private String title;
	    private String content;
	    private String publishBy;
	    private String publishDate;
	    private String closedDate;
		
	    AnnouncementDtoBuilder() {};
	    
		public AnnouncementDtoBuilder id(Long id) {
			this.id = id;
	        return this;
	    }
		public AnnouncementDtoBuilder title(String title) {
	        this.title = title;
	        return this;
	    }
		public AnnouncementDtoBuilder content(String content) {
			this.content = content;
			return this;
		}
		public AnnouncementDtoBuilder publishBy(String publishBy) {
			this.publishBy = publishBy;
			return this;
		}
		public AnnouncementDtoBuilder publishDate(LocalDate publishDate) {
			this.publishDate = publishDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
			return this;
		}
		public AnnouncementDtoBuilder closedDate(LocalDate closedDate) {
			this.closedDate = closedDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
			return this;
		}

	    public AnnouncementDto build() {
	        return new AnnouncementDto(id, title, content, publishBy, publishDate, closedDate);
	    }
	    
	}
	
}
