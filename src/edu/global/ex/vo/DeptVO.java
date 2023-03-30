package edu.global.ex.vo;
//이름     널?       유형           

//------ -------- ------------ 
//DEPTNO NOT NULL NUMBER(2)    
//DNAME           VARCHAR2(14) 
//LOC             VARCHAR2(13) 

//DTO = VO(Value Object)
//순수하게 데이터를 담아 계층 간으로 전달하는 객체
//로직을 갖고 있지 않은 순수한 데이터 객체이며 메서드로는 getter/setter 만을 갖는다.

public class DeptVO { // 객체화시켜서 메모리에 올린다.
	private int deptno;
	private String dname;
	private String loc;

	public DeptVO() {
	} // default생성자는 반드시 만들어야된다.
	// 마우스 오른쪽 클릭->source란에서 getter,setter,생성자 자동완성 기능 사용

	public DeptVO(int deptno, String dname, String loc) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}
}
