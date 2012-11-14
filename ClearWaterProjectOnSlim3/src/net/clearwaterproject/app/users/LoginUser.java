package net.clearwaterproject.app.users;

import java.io.Serializable;

import net.clearwaterproject.model.User;

public class LoginUser extends User implements Serializable, Comparable<User>{

	private static final long serialVersionUID = 9105902714317033491L;
	
	public LoginUser() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	}

    public int compareTo(User o) {
        // TODO 自動生成されたメソッド・スタブ
        return 0;
    }


	
	
}
