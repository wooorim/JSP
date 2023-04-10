package project.page.golf.vo;
//이름           널?       유형           
//------------ -------- ------------ 
//REGIST_MONTH NOT NULL VARCHAR2(6)  
//C_NO         NOT NULL CHAR(5)      
//CLASS_AREA            VARCHAR2(15) 
//TUITION               NUMBER(8)    
//TEACHER_CODE          CHAR(3)             

public class TeacherSalesVO {
	String teacher_code;
	String class_name;
	String teacher_name;
	String tuition;
	
	
	public TeacherSalesVO() {}
	
	public TeacherSalesVO(String teacher_code, String class_name, String teacher_name, String tuition) {
		this.teacher_code = teacher_code;
		this.class_name = class_name;
		this.teacher_name = teacher_name;
		this.tuition = tuition;
	}
	public String getTeacher_code() {
		return teacher_code;
	}
	public void setTeacher_code(String teacher_code) {
		this.teacher_code = teacher_code;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public String getTuition() {
		return tuition;
	}
	public void setTuition(String tuition) {
		this.tuition = tuition;
	}
	
	
}
