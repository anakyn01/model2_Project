package v2.mvc.spring.vo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BlogListResponseVO {

	private int blgContSeq;
	private String title;
	private String contBdy;
	private LocalDateTime insertDt;
	
	public int getBlgContSeq() {return blgContSeq;}
	public String getTitle() {return title;}
	public String getContBdy() {return contBdy;}
	public LocalDateTime getInsertDt() {return insertDt;}
	//add
	public String getInsertDtFormat(){
		return this.insertDt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}
	
	public void setBlgContSeq(int blgContSeq) {this.blgContSeq = blgContSeq;}
	public void setTitle(String title) {this.title = title;}
	public void setContBdy(String contBdy) {this.contBdy = contBdy;}
	public void setInsertDt(LocalDateTime insertDt) {this.insertDt = insertDt;}
	
	
}
