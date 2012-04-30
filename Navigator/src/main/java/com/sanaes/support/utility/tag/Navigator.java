package com.sanaes.support.utility.tag;



import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;



public class Navigator extends BodyTagSupport{

	private static final long serialVersionUID = 1L;
	/**
	 * 전체 리스트의 카운터
	 */
	private Long totalRecordCount;
	/**
	 * 
	 */
	private Long countPerPage;
	/**
	 * 
	 */
	private Long pagePerBlock;
	/**
	 * 선택된 페이지 
	 */
	private Long currentPage;
	/**
	 * 호출할 스크립트 function name
	 */
	private String href;
	/**
	 * 처음으로 보내는 버튼 이미지
	 */
	private String firstButton;
	/**
	 * 앞으로 보내는 버튼 이미지
	 */
	private String prevButton;
	/**
	 * 다음으로 보내는 버튼 이미지
	 */
	private String nextButton;
	/**
	 * 마지막으로 보내는 버튼 이미지
	 */
	private String lastButton;
	/**
	 * 처음으로 보는건지 구분
	 */
	private String isStartFinishView;
	private Long currentBlock;
	private Long startPageOfBlock;
	private Long pageCount;
	private Long blockCount;
	private Long firstPage;
	private Long lastPage;
	private Long prevPage;
	private Long nextPage;

	public Navigator(){
	    this.href = "";
	    this.firstButton = "";
	    this.prevButton = "";
	    this.nextButton = "";
	    this.lastButton = "";
	    this.isStartFinishView = "true";
	}
	
	public int doStartTag() throws JspException {
	    try {
	        JspWriter out = pageContext.getOut();
	        out.println(makeNavigator().toString());
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	    return SKIP_BODY;
	}    
	
	/**
	 * 처음 페이징 변수를 셋팅한다.
	 */
	private void init(){
	    if(totalRecordCount.longValue() % countPerPage.longValue() == 0)
	        pageCount = Long.valueOf(totalRecordCount.longValue() / countPerPage.longValue());
	    else
	        pageCount = Long.valueOf(totalRecordCount.longValue() / countPerPage.longValue() + 1);
	    if(pageCount.longValue() % pagePerBlock.longValue() == 0)
	        blockCount = Long.valueOf(pageCount.longValue() / pagePerBlock.longValue());
	    else
	        blockCount = Long.valueOf(pageCount.longValue() / pagePerBlock.longValue() + 1);
	    currentBlock = Long.valueOf((currentPage.longValue() - 1) / pagePerBlock.longValue() + 1);
	    startPageOfBlock = Long.valueOf((currentBlock.longValue() - 1) * pagePerBlock.longValue() + 1);
	    firstPage =  Long.valueOf("1");
	    lastPage = pageCount;
	    prevPage = Long.valueOf(startPageOfBlock.longValue() != 1 ? startPageOfBlock.longValue() - 1 : 1);
	    nextPage = Long.valueOf(currentBlock != blockCount ? startPageOfBlock.longValue() + pagePerBlock.longValue() : lastPage.longValue());
	    if(totalRecordCount.longValue() == 0)
	        nextPage = Long.valueOf("0");
	}
	
	/**
	 *  페이지를 받아서 링크를 생성 시킨다
	 * @param page
	 * @return
	 */
	private String makeLink(Long page){
	    StringBuffer rtn = new StringBuffer();
	    rtn.append("<span class=\"current\">").append(page).append("</span>");
	    return rtn.toString();
	}
	
	/**
	 *  페이지와 버튼이미지를 받아서 이미지를 생성 시킨다.
	 * @param page
	 * @param button
	 * @param classStr
	 * @return 버튼 String
	 */
	private String makeButton(Long page, String button, String classStr) {
	    StringBuffer rtn = new StringBuffer();
	    rtn.append("<a class=\""+classStr+"\" href=\"javascript:").append(href).append("(").append(page).append(");\">");
	    rtn.append(button);
	    rtn.append("</a>");
	    return rtn.toString();
	}
	
	
	/**
	 * 
	 * 해당 디자인의 페이지 네이게이션을 리턴한다.
	 * 
	 * <div class="pageNavigation">
	 *		<a class="goToFirst" href="#"><img src="../../docs/common/img/list_first.gif" alt="처음" /></a>
	 *		<a class="goToPrev" href="#"><img src="../../docs/common/img/list_prev.gif" alt="이전" /></a>
	 *		<span class="current">1</span>
	 *		<a href="#">2</a>
	 *		<a href="#">3</a>
	 *		<a href="#">4</a>
	 *		<a href="#">5</a>
	 * 	<a href="#">6</a>
	 * 	<a href="#">7</a>
	 * 	<a href="#">8</a>
	 * 	<a href="#">9</a>
	 * 	<a href="#">10</a>
	 * 	<a class="goToNext" href="#"><img src="../../docs/common/img/list_next.gif" alt="다음" /></a>
	 * 	<a class="goToLast" href="#"><img src="../../docs/common/img/list_last.gif" alt="마지막" /></a>
	 * </div>
	 * 
	 * 
	 * @return pageNavigation String
	 */
	private StringBuffer makeNavigator(){
	    StringBuffer buffer = new StringBuffer();
	    init();
	    buffer.append("<div class=\"pageNavigation\">");
	    if(isStartFinishView.toLowerCase().equals("true"))
	        if(firstPage.longValue() == startPageOfBlock.longValue())
	            buffer.append(firstButton).append("\r\n");
	        else
	            buffer.append(makeButton(firstPage, firstButton ,"goToFirst")).append("\r\n");
	    if(prevPage.longValue() == startPageOfBlock.longValue())
	        buffer.append(prevButton).append("\r\n");
	    else
	        buffer.append(makeButton(prevPage, prevButton, "goToPrev")).append("\r\n");
	
	    Long showPage = startPageOfBlock;
	    for(int i = 0; (long)i < pagePerBlock.longValue(); i++) {        	
	        buffer.append((new StringBuilder()).append(makeLink(showPage)).append("\r\n").toString());
	        if(totalRecordCount.longValue() == 0)
	            break;
	        if(showPage.longValue() == pageCount.longValue()) {
	            showPage = Long.valueOf(showPage.longValue() + 1);
	            break;
	        }
	        showPage = Long.valueOf(showPage.longValue() + 1);
	    }
	
	    showPage = Long.valueOf(showPage.longValue() - 1);
	    if(showPage.longValue() == nextPage.longValue())
	        buffer.append(nextButton).append("\r\n");
	    else
	        buffer.append(makeButton(nextPage, nextButton, "goToNext")).append("\r\n");
	    if(isStartFinishView.toLowerCase().equals("true"))
	        if(showPage.longValue() == lastPage.longValue())
	            buffer.append(lastButton).append("\r\n");
	        else
	            buffer.append(makeButton(lastPage, lastButton, "goToLast")).append("\r\n");
	    buffer.append("</div>\r\n");
	    return buffer;
	}
	
	public void setTotalRecordCount(Long value) {
	    totalRecordCount = value;
	}
	
	public Long getTotalRecordCount() {
	    return totalRecordCount;
	}
	
	public void setCountPerPage(Long value) {
	    countPerPage = value;
	}
	
	public Long getCountPerPage() {
	    return countPerPage;
	}
	
	public void setPagePerBlock(Long value) {
	    pagePerBlock = value;
	}
	
	public Long getPagePerBlock(){
	    return pagePerBlock;
	}
	
	public void setCurrentPage(Long value){
	    currentPage = value;
	}
	
	public Long getCurrentPage(){
	    return currentPage;
	}
	
	public void setHref(String value){
	    href = value;
	}
	
	public String getHref(){
	    return href;
	}
	
	public void setFirstButton(String value){
	    firstButton = value;
	}
	
	public String getFirstButton(){
	    return firstButton;
	}
	
	public void setPrevButton(String value){
	    prevButton = value;
	}
	
	public String getPrevButton(){
	    return prevButton;
	}
	
	public void setNextButton(String value){
	    nextButton = value;
	}
	
	public String getNextButton(){
	    return nextButton;
	}
	
	public void setLastButton(String value){
	    lastButton = value;
	}
	
	public String getLastButton(){
	    return lastButton;
	}
	
	public void setIsStartFinishView(String value){
	    isStartFinishView = value;
	}
	
	public String getIsStartFinishView(){
	    return isStartFinishView;
	}
	
    
}
