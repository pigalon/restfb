restfb
======

I create this little project to grab all movie links on FB group feeds.
This is just a beginning and it could be customized much more.

See the pom.xml to see all dependencies
The API RestFB is needed : www.restfb.com 

Architecture :
============

	Group -> a feed : Connection<Post> -> all the post of the Group
	
	Every Post have : 
	  - "message":
      - "picture":  
      - "link": "https://soundcloud.com/wearsthetrousers/kim-deal-solo-dirty-hessians", 
      - "source":  
      - "name": "Kim Deal (solo) - Dirty Hessians", 
      - "caption":  
      - "description":  
      - "icon":
      
      I keep just link and name to analyze every post.
      link permit to determine : type of link between Youtube, bandcamp, etc... 
 	  and name give us information about Band or artiste -- and the song title  
      

all the steps : 
=============
1. First we need to connect you on the page : https://developers.facebook.com/tools/explorer
   generate your access token with the good options (I don"t check yet the minimum level to grab the feed a group)
   and try to use the Graph API explorer to ssee the feed of the group where you want grab all tracks
   
2. Look at the Constants file to param this client
com.pigalon.restfb.Constantes :
 - the first : MY_ACCESS_TOKEN : set your token here (becareful with expiration time 2 hours it seems)
 - ID_GROUP : the group id
 - the last : EXPORT_FILE : the name of the export file

3. No main class yet, just JUnit Test
 -> Run RapidTest : To see the correct use of this program
 -> Run FinalTest : To export in the csv file all movie references

4. You get a csv with :
id of the post | creation Date | link type | link id | artist - title | user who posted this movie | Likes number

about link type : 
	- B -> Bandcamp
	- S -> Soundcloud
	- V -> Vimeo 
	- Y -> Youtube

about link id, you have to complete the url to retrieve the movie : 
	- B -> you have to add .bandcamp.com after
	- S -> you have to add soundcloud.com/ before 
	- V -> you have to add vimeo.com/ before
	- Y -> you have to add http://youtube.com?v= before the id
	   
