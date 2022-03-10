package rough.JacksonDaaBindPkg;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Post {

	private Long id;
	private String title;
	private String description;
	private String content;
	
	private Date postDt = new Date();
	private Date lastUpdateDate = new Date();
	private Set<Tag> tags = new  HashSet<Tag>();
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPostDt() {
		return postDt;
	}
	public void setPostDt(Date postDt) {
		this.postDt = postDt;
	}
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	public Set<Tag> getTags() {
		return tags;
	}
	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
	public Post(Long id, String title, String description, String content, Date postDt, Date lastUpdateDate,
			Set<Tag> tags) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.content = content;
		this.postDt = postDt;
		this.lastUpdateDate = lastUpdateDate;
		this.tags = tags;
	}
	public Post() {
		super();
	}
	
	
	
}
