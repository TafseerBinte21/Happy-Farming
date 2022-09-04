package com.tafa.farmer.controllers.dto;

public class cropdto {

	private Long id;
	private String name;
	private String genre;
	private String description;
	private String price;
	private String image;
	private String video;
	private String time;
	private String temperature;
	private String pH;
	private String waterLevel;
	private String fertilizer;

	public cropdto () {

	}

	public cropdto(Long id, String name, String genre, String description, String price, String image, String video, String time, String temperature, String pH,
			String waterLevel, String fertilizer) {
		super();
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.description = description;
		this.price = price;
		this.image = image;
		this.video = video;
		this.time = time;
		this.temperature = temperature;
		this.pH = pH;
		this.waterLevel = waterLevel;
		this.fertilizer = fertilizer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getpH() {
		return pH;
	}

	public void setpH(String pH) {
		this.pH = pH;
	}

	public String getWaterLevel() {
		return waterLevel;
	}

	public void setWaterLevel(String waterLevel) {
		this.waterLevel = waterLevel;
	}

	public String getFertilizer() {
		return fertilizer;
	}

	public void setFertilizer(String fertilizer) {
		this.fertilizer = fertilizer;
	}

}
