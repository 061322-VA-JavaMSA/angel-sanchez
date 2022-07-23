## Social Media Website centered around Art of the Institute of Chicago API

4 basic functions:
- Roles for Login
- Query Art, search 
- Favorite Art
- User profile creation

Stretch goals:
- User to delete own account
- Implement JWT for authorization

- User Functions
    - Login
    - Logout
    - Register User
    - Update User
    - User has showcase Art in their profile

- Admin functions
    - Get list of users
    - Remove users

- Art API
    - Get Art attributes(API)
    - Get Art by Category(API)
    - View pictures(API)

*POSTMAN URL:* https://www.artic.edu/iiif/2/1adf2696-8489-499b-cad2-821d7fde4b33/full/843,/0/default.jpg
^ Will return picture of a piece of art called: La Grande Jatte

- bind showcase art method in user repository
- all info from API
- when an user clicks on an art it takes the image id, build like passing in the image id and add it to user, add the imageID to the user;s showcase_art
- worry about given image id and add it to user showcase

- PUT method in order to assign the art to a user's imageID

git merge --strategy-abort theirs to fix merge conflicts

insert the hexa string to the imageID from the chicago api

La Grande picture example:
- start with the base image API in the config.iiif_url field
    - https://www.artic.edu/iiif/2, leads to the website
- Next, append the image ID of the artwork as a segment to the url
    - https://www.artic.edu/iiif/2/1adf2696-8489-499b-cad2-821d7fde4b33,  the "1adf2696-8489-499b-cad2-821d7fde4b33" is the image ID, we want to append this to the user "showcase_art" in JAVA/SPRING, returns  details of the image
- Finally, append the "/full/843,/0/default.jpg" to the url
    - https://www.artic.edu/iiif/2/1adf2696-8489-499b-cad2-821d7fde4b33/full/843,/0/default.jpg, this will return the image itself, .jpg format, we want the user showcase_art(imageID) to show the art itself
- Append this whole link and many others to the user's showcase using the PUT Http method