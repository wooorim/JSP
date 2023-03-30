package edu.global.ex.vo;
//�̸�     ��?       ����           

//------ -------- ------------ 
//DEPTNO NOT NULL NUMBER(2)    
//DNAME           VARCHAR2(14) 
//LOC             VARCHAR2(13) 

//DTO = VO(Value Object)
//�����ϰ� �����͸� ��� ���� ������ �����ϴ� ��ü
//������ ���� ���� ���� ������ ������ ��ü�̸� �޼���δ� getter/setter ���� ���´�.

public class DeptVO { // ��üȭ���Ѽ� �޸𸮿� �ø���.
	private int deptno;
	private String dname;
	private String loc;

	public DeptVO() {
	} // default�����ڴ� �ݵ�� �����ߵȴ�.
	// ���콺 ������ Ŭ��->source������ getter,setter,������ �ڵ��ϼ� ��� ���

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
