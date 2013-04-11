package cn.djel.manage.utils;

import cn.djel.manage.domain.user.Right;
import cn.djel.manage.domain.user.User;

public class RightUtil {
	public static boolean hasRight(User currentUser, Right right){
		int curbit = currentUser.getRightbit();
		long curcode = currentUser.getRightcode();
		if((curbit & right.getRightBit()) !=0){
			if((curcode & right.getRightCode())!= 0){
				return true;
			}
		}
		return false;
	}
}
