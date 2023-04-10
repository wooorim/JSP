package project.page.golf.vo;
//이름           널?       유형           
//------------ -------- ------------ 
//REGIST_MONTH NOT NULL VARCHAR2(6)  
//C_NO         NOT NULL CHAR(5)      
//CLASS_AREA            VARCHAR2(15) 
//TUITION               NUMBER(8)    
//TEACHER_CODE          CHAR(3)             

public class ClassVO {
	String regist_month;
	String c_name;
	String c_no;
	String class_name;
	String class_area;
	String class_price;
	
	public ClassVO() {}
	
	public ClassVO(String regist_month, String c_name, String c_no, String class_area, String class_name, String class_price) {
		super();
		this.regist_month = regist_month;
		this.c_name = c_name;
		this.c_no = c_no;
		this.class_area = class_area;
		this.class_name = class_name;
		this.class_price = class_price;
	}

	public String getRegist_month() {
		return regist_month;
	}

	public void setRegist_month(String regist_month) {
		this.regist_month = regist_month;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_no() {
		return c_no;
	}

	public void setC_no(String c_no) {
		this.c_no = c_no;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public String getClass_area() {
		return class_area;
	}

	public void setClass_area(String class_area) {
		this.class_area = class_area;
	}

	public String getClass_price() {
		return class_price;
	}

	public void setClass_price(String class_price) {
		this.class_price = class_price;
	}
	
	
}
