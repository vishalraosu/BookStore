package com.softvision.BO;
public class BookBO
{
	private String bookid;
	private String bookname;
	private String authorname;
	private String category;
	private String status;
	
	public void setBookId(String bookid)
	{
		this.bookid = bookid;
	}
	public String getBookId()
	{
		return bookid;
	}
	public void setBookName(String bookname)
	{
		this.bookname = bookname;
	}
	public String getBookName()
	{
		return bookname;
	}
	public void setAuthorName(String authorname)
	{
		this.authorname = authorname;
	}
	public String getAuthorName()
	{
		return authorname;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	public String getStatus()
	{
		return status;
	}
} 
