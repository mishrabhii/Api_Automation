package com.bridgelabz.qa.api_automation;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Rest_Api_Automation_Testing_Test {


	String token;
	String userid;
	String playlistid;
	String trackid = "6nDJIzi6BezsTcCdw8fmMg";

	@BeforeTest 

	public void getToken() {
		token = "Bearer BQASElqCXBT2LySZ16bGlcy6f6mdOTsT6WuGIq7nnBYMbCqv--Vt0c-5vNndDs_wJmIuH-6YErZmqM8lT-xERmd3PMWkard6Q28D_ZcDt9uLPCZR6InmwovxOTyifTg60PvMp9x5yCo_Xbpt7uAQtCy3hV2TpKn4lgFjU3pd2cMFpoS0SDd88yerjDent42wXRr4kPXycBQabUIZTxJNGhBervBcTT8uHIS-ZvEUzCyEV-A_Kj-AYZU_yAQp4FL232Ag9QOS5WQLeezPHFX47_bvQY4XI-FEEwJPiFiu";
	}


	//**********************user profile *****************************
	@Test(priority = 2)

	public void get_Current_User_Profile() {

		Response response = RestAssured.given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("Authorization",token)
				.when()
				.get("https://api.spotify.com/v1/me");
		response.prettyPrint(); 
		response.then().assertThat().statusCode(200);
		userid = response.path("id");
		System.out.println("My current user id is = "+ userid);

	}


	@Test(priority = 1)

	public void get_User_Profile() {

		Response response = RestAssured.given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("Authorization",token)
				.when()
				.get("https://api.spotify.com/v1/users/"+userid+"");
		response.prettyPrint(); 
		response.then().assertThat().statusCode(200);
	}

	@Test(priority = 3)

	public void Create_Playlist() {

		Response response = RestAssured.given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("Authorization",token)
				.body("{\n"
						+ "  \"name\": \"Udit Narayan Hits\",\n"
						+ "  \"description\": \"New playlist description\",\n"
						+ "  \"public\": false\n"
						+ "}")
				.when()
				.post("https://api.spotify.com/v1/users/"+userid+"/playlists");
		response.prettyPrint(); 
		response.then().assertThat().statusCode(201);
		playlistid = response.path("id");
		System.out.println("My current playlist id is = "+ playlistid);
		//	
	}

	//******************** search **********************
	@Test(priority = 4)


	public void Search_for_item() {

		Response response = RestAssured.given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("Authorization",token)
				.queryParam("q", "udit narayan")
				.queryParam("type","track")
				.when()
				.get("https://api.spotify.com/v1/search");
		response.prettyPrint(); 
		response.then().assertThat().statusCode(200);
	}

	//************** playlists ******************
	@Test(priority = 5)


	public void Add_items_to_Playlist () {

		Response response = RestAssured.given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("Authorization",token)
				.queryParam("uris","spotify:track:6nDJIzi6BezsTcCdw8fmMg,spotify:track:4RixtPhUXlci9ad4qIMj23,spotify:track:1QwVVMQ6AglyGK6CgRzkbz")

				.when()
				.post("https://api.spotify.com/v1/playlists/"+playlistid+"/tracks");
		response.prettyPrint(); 
		response.then().assertThat().statusCode(201);

	}


	@Test(priority = 6)


	public void Get_Playlist_Items() {

		Response response = RestAssured.given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("Authorization",token)
				.when()
				.get("https://api.spotify.com/v1/playlists/"+playlistid+"/tracks");
		response.prettyPrint(); 
		response.then().assertThat().statusCode(200);


	}

	@Test(priority = 17)


	public void Remove_Playlist_Items () {

		Response response = RestAssured.given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("Authorization",token)
				.body("{\n"
						+ "    \"tracks\": [\n"
						+ "        {\n"
						+ "            \"uri\": \"spotify:track:6nDJIzi6BezsTcCdw8fmMg\",\n"
						+ "            \"positions\": [0]\n"
						+ "        }\n"
						+ "        \n"
						+ "    ]\n"
						+ "}")
				.when()
				.delete("https://api.spotify.com/v1/playlists/"+playlistid+"/tracks");
		response.prettyPrint();


	}

	@Test(priority = 8)


	public void Get_Playlist () {

		Response response = RestAssured.given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("Authorization",token)
				.when()
				.get("https://api.spotify.com/v1/playlists/"+playlistid+"");
		response.prettyPrint(); 
		response.then().assertThat().statusCode(200);



	}


	@Test(priority = 9)


	public void Get_Users_Playlists () {

		Response response = RestAssured.given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("Authorization",token)
				.when()
				.get("https://api.spotify.com/v1/users/"+userid+"/playlists");
		response.prettyPrint(); 
		response.then().assertThat().statusCode(200);

	}

	@Test(priority = 10)


	public void Get_Current_Users_Playlists () {

		Response response = RestAssured.given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("Authorization",token)
				.when()
				.get("https://api.spotify.com/v1/me/playlists");
		response.prettyPrint(); 
		response.then().assertThat().statusCode(200);


	}

	@Test(priority = 11)


	public void Get_Playlist_Cover_Image() {

		Response response = RestAssured.given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("Authorization",token)
				.when()
				.get("https://api.spotify.com/v1/playlists/"+playlistid+"/images");
		response.prettyPrint(); 
		response.then().assertThat().statusCode(200);


	}

	@Test(priority = 12)


	public void Update_Playlist_Items() {

		Response response = RestAssured.given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("Authorization",token)
				.body("{\n"
						+ "  \"range_start\": 1,\n"
						+ "  \"insert_before\": 3,\n"
						+ "  \"range_length\": 2\n"
						+ "}")

				.when()
				.put("https://api.spotify.com/v1/playlists/"+playlistid+"/tracks");
		response.prettyPrint(); 
		response.then().assertThat().statusCode(200);


	}

	@Test(priority = 13)


	public void Change_Playlist_Details() {

		Response response = RestAssured.given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("Authorization",token)
				.body("{\n"
						+ "  \"name\": \"udit ji\",\n"
						+ "  \"description\": \"Updated playlist description\",\n"
						+ "  \"public\": false\n"
						+ "}")

				.when()
				.put("	https://api.spotify.com/v1/playlists/"+playlistid+"");
		response.prettyPrint(); 
		response.then().assertThat().statusCode(200);



	}


	//***********************************tracks*****************************************


	@Test(priority = 14)


	public void Get_Tracks() {

		Response response = RestAssured.given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("Authorization",token)
				.when()
				.get("https://api.spotify.com/v1/tracks/"+trackid+"");
		response.prettyPrint(); 
		response.then().assertThat().statusCode(200);


	}

	@Test(priority = 15)


	public void Get_Tracks_Audio_Analysis() {

		Response response = RestAssured.given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("Authorization",token)
				.when()
				.get("	https://api.spotify.com/v1/audio-analysis/"+trackid+"");
		response.prettyPrint(); 
		response.then().assertThat().statusCode(200);


	}

	@Test(priority = 16)


	public void Get_Tracks_Audio_Features() {

		Response response = RestAssured.given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("Authorization",token)
				.queryParam("ids","4XEtEmnRgmNtDH9SayLCRR" )
				.when()
				.get("https://api.spotify.com/v1/audio-features");
		response.prettyPrint(); 
		response.then().assertThat().statusCode(200);


	}

	@Test(priority = 17)


	public void Get_Track_Audio_Features() {

		Response response = RestAssured.given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("Authorization",token)
				.when()
				.get("https://api.spotify.com/v1/audio-features/"+trackid+"");
		response.prettyPrint(); 
		response.then().assertThat().statusCode(200);

	}

	@Test(priority = 7)


	public void Get_Several_Tracks() {

		Response response = RestAssured.given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("Authorization",token)
				.queryParam("ids","4XEtEmnRgmNtDH9SayLCRR" )
				.when()
				.get("	https://api.spotify.com/v1/tracks");
		response.prettyPrint(); 
		response.then().assertThat().statusCode(200);

	}
}


