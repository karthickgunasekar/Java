var myHeading = document.querySelector('h1');
myHeading.textContent= '';

var xhr = new XMLHttpRequest();
xhr.open('POST','https://localhost:8443/VolPayRest/rest/v2/accounts/readall');
xhr.setRequestHeader('Authorization','SessionToken:107b15d5-cb68-42c2-aa6a-0d21ddada827');
xhr.setRequestHeader('Content-Type','application/json');
xhr.send('{"start":0,"count":20,"sorts":[]}');
console.log("response status "+xhr.responseText)
