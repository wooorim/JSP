package project.page.golf.vo;
//이름                  널?       유형           
//------------------- -------- ------------ 
//TEACHER_CODE        NOT NULL CHAR(3)      
//TEACHER_NAME                 VARCHAR2(15) 
//CLASS_NAME                   VARCHAR2(20) 
//CLASS_PRICE                  NUMBER(8)    
//TEACHER_REGIST_DATE          DATE   

public class TeacherVO {
	String teacher_code;
	String teacher_name;
	String class_name;
	String class_price;
	String teacher_regist_date;
	
	public TeacherVO() {}
	
	public TeacherVO(String teacher_code, String teacher_name, String class_name, String class_price,
			String teacher_regist_date) {
		this.teacher_code = teacher_code;
		this.teacher_name = teacher_name;
		this.class_name = class_name;
		this.class_price = class_price;
		this.teacher_regist_date = teacher_regist_date;
	}
	
	public String getTeacher_code() {
		return teacher_code;
	}
	public void setTeacher_code(String teacher_code) {
		this.teacher_code = teacher_code;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getClass_price() {
		return class_price;
	}
	public void setClass_price(String class_price) {
		this.class_price = class_price;
	}
	public String getTeacher_regist_date() {
		return teacher_regist_date;
	}
	public void setTeacher_regist_date(String teacher_regist_date) {
		this.teacher_regist_date = teacher_regist_date;
	}
	
}
