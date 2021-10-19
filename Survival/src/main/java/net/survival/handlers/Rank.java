package net.survival.handlers;

public enum Rank {
	
	OWNER("OWNER", "&c", 9),
	ADMIN("ADMIN", "&c", 8),
	MOD("MOD", "&e", 7),
	HELPER("HELPER", "&9", 6),
	YT("YT", "&c", 5),
	MYTHIC("MYTHIC", "&5", 4),
	LEGEND("LEGEND", "&6", 3),
	EPIC("EPIC", "&b", 2),
	RARE("RARE", "&9", 1),
	MEMBER("MEMBER", "&7", 0);
	
	private String RankName;
	private String RankColor;
	private Integer RankID;
	
	private Rank(String RankName, String RankColor, Integer RankID){
		this.RankName = RankName;
		this.RankColor = RankColor;
		this.RankID = RankID;
	}
	
	public String getName(){
		return RankName;
	}
	
	public String getColor(){
		return RankColor;
	}
	
	public Integer getID(){
		return RankID;
	}
	
}
