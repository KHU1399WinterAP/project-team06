package main.java.models;

public class User {
	public String username;
	public int password;
	public int profilePicture;
	public int settingId=1;
	public int coins;
	public int recordEnglish;
	public int recordMath;
	public int recordFood;
	public int recordScience;
	public int recordCommon;
	public int recordGeography;
	
	public User(String username, int password,int settingId) {
		this(username, password,settingId, 1, 100, 0, 0, 0, 0, 0, 0);
	}
	
	public User(String username, int password ,int settingId ,int profilePicture, int coins,
	            int recordEnglish, int recordMath, int recordFood, int recordScience, int recordCommon, int recordGeography) {
		this.settingId=settingId;
		this.username = username;
		this.password = password;
		this.profilePicture = profilePicture;
		this.coins = coins;
		this.recordEnglish = recordEnglish;
		this.recordMath = recordMath;
		this.recordFood = recordFood;
		this.recordScience = recordScience;
		this.recordCommon = recordCommon;
		this.recordGeography = recordGeography;
	}

	@Override
	public String toString() {
		return "User{" +
				"username='" + username + '\'' +
				", password=" + password +
				", profilePicture=" + profilePicture +
				", settingId=" + settingId +
				", coins=" + coins +
				", recordEnglish=" + recordEnglish +
				", recordMath=" + recordMath +
				", recordFood=" + recordFood +
				", recordScience=" + recordScience +
				", recordCommon=" + recordCommon +
				", recordGeography=" + recordGeography +
				'}';
	}
}
