# Sprint 2: Databases. Data Structure - MySQL

<br/>

We will model several Entity-Relationship diagrams.

<br/>

### Level 2. Exercise 1 - YouTube:

We will create a simple model for the database of a reduced version of YouTube.

For each user, store a unique identifier:

	Email
	Password
	Username
	Date of birth
	Gender
	Country
	Postal code

A user publishes videos. For each video, store a unique identifier:
 
 	A title
	A description
	A size
	The name of the video file
	Video duration
	A thumbnail
	The number of views
	The number of likes
	The number of dislikes

A video can have three different states: public, hidden, and private. A video can have many tags. A tag is identified by a unique identifier and a tag name. It is important to store who published the video and the date/time it was published.

A user can create a channel. A channel has a unique identifier:
 
	A name
	A description
	A creation date
 
A user can subscribe to the channels of other users. A user can like or dislike a video only once. A record must be kept of the users who liked or disliked a particular video and the date/time they did so.

A user can create playlists with their favorite videos. Each playlist has a unique identifier:

	A name
	A creation date
	A state indicating whether it is public or private

A user can write comments on a specific video. Each comment is identified by a unique identifier:
	The text of the comment
	The date/time it was made

A user can mark a comment as like or dislike. A record must be kept of the users who marked a comment as like/dislike and the date/time they did so.