package com.cc.webcrawler.bean;

/**
 * @author ccarrillo
 *
 */
public class Entry {
	private Integer order;
	private String title;
	private String point;
	private String comment;
	private Integer amountPoint;
	private Integer amountComment;
	
	private Entry(Builder builder) {
		setOrder(builder.order);
		setTitle(builder.title);
		setPoint(builder.point);
		setComment(builder.comment);
		setAmountPoint(builder.amountPoint);
		setAmountComment(builder.amountComment);
	}
	
	public static Builder newEntry() {
		return new Builder();
	}
	
	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getAmountPoint() {
		return amountPoint;
	}

	public void setAmountPoint(Integer amountPoint) {
		this.amountPoint = amountPoint;
	}

	public Integer getAmountComment() {
		return amountComment;
	}

	public void setAmountComment(Integer amountComment) {
		this.amountComment = amountComment;
	}



	public static final class Builder {
		private Integer order;
		private String title;
		private String point;
		private String comment;	
		private Integer amountPoint;
		private Integer amountComment;
		
		private Builder() {}
		
		public Builder order(Integer order) {
			this.order = order;
			return this;
		}
		
		public Builder title(String title) {
			this.title = title;
			return this;
		}
		
		public Builder point(String point) {
			this.point = point;
			return this;
		}
		
		public Builder comment(String comment) {
			this.comment = comment;
			return this;
		}
		
		public Builder amountPoint(Integer amountPoint) {
			this.amountPoint = amountPoint;
			return this;
		}
		
		public Builder amountComment(Integer amountComment) {
			this.amountComment = amountComment;
			return this;
		}
		
		public Entry build() {
			return new Entry(this);
		}
		
	}

}
