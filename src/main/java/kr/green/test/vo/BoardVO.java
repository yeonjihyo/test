package kr.green.test.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BoardVO {
	private int num;
	private String title;
	private String contents;
	private String writer;
	private String valid;
	private String file;
	private Date registered;
	private int views;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getValid() {
		return valid;
	}
	public void setValid(String valid) {
		this.valid = valid;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getRegistered() {
		//날자와 시간을 원하는 형식으로 보이게 하기위한 방법
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return f.format(registered);
	}
	public String getRegisteredUntilDay() {//컨트롤러에서 jsp로 보낼때는 getter가 호출 
		//날자와 시간을 원하는 형식으로 보이게 하기위한 방법
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		return f.format(registered);
	}
	public void setRegistered(Date registered) {//jsp에서 컨트롤러로 보낼때 setter가 호출 
		this.registered = registered;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	@Override
	public String toString() {
		return "BoardVO [num=" + num + ", title=" + title + ", contents=" + contents + ", writer=" + writer + ", valid="
				+ valid + ", file=" + file + ", registered=" + registered + ", views=" + views + "]";
	}
	
	
}
