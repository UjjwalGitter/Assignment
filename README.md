# fampay

Link to the App : https://drive.google.com/file/d/1_eq1STBBD9hU6xNJLD-s7KkExrQeE5Ym/view?usp=sharing
- Created an android app to display a list of `Contextual Cards`
- A Contextual Card is used to refer to a view that is rendered using json from an API.
- App will handle all the changes These views are dynamic and their properties like images, color, texts, buttons (CTAs) etc. can be changed from backend at anytime

Languages Used: JAVA, XML
1. Used AsyncTask for retrieving data from the API that used a background Thread to fetch the data.
-> Retrieved data using doInBackground method 
-> Updated UI inside onPostExecute() method that ensures the successful retrieval of the data from the API.
2. Used Glide Library for loading Images into views from the API.
3. Added SwipeRefreshLayout Widget for refreshing the UI.

<img src="https://user-images.githubusercontent.com/43453065/94270149-456c7a80-ff5d-11ea-8c86-166974782105.png" alt="alt text" width="20%" height="20%">
<img src="https://user-images.githubusercontent.com/43453065/94270182-4f8e7900-ff5d-11ea-81f5-21bebb5f4321.png" alt="alt text" width="20%" height="20%">

