package edu.global.board.command; //����� ��Ű�� ���� ���� ����

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardController
 */

public interface BCommand {
	void execute(HttpServletRequest request, HttpServletResponse response); //void�տ� public abstract����
}
//���������� �����Ű�� ���ؼ� �������̽� ����
//���ϵ� �ڵ带 �ۼ��ϱ� ���ؼ�
