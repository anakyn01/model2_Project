package v2.mvc.spring.vo;

public class CommentAddRequestVO {
    private int blgContSeq;
    private String cmtBdy;
    private String tmpPw;
 
    public int getBlgContSeq() {
        return blgContSeq;
    }
    public void setBlgContSeq(int blgContSeq) {
        this.blgContSeq = blgContSeq;
    }
    public String getCmtBdy() {
        return cmtBdy;
    }
    public void setCmtBdy(String cmtBdy) {
        this.cmtBdy = cmtBdy;
    }
    public String getTmpPw() {
        return tmpPw;
    }
    public void setTmpPw(String tmpPw) {
        this.tmpPw = tmpPw;
    }
}
