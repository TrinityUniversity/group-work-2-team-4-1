'use strict';

const csrfToken = document.getElementById("csrfToken").value;
const usersRoute = document.getElementById("usersRoute").value;

const userlist = document.getElementById("userlist");

fetch(usersRoute, { 
    method: 'GET',
    headers: {'Content-Type': 'application/json', 'Csrf-Token': csrfToken }
}).then(res => res.json()).then(data => {
if(data) {
  for(const user of data) {
      const listitem = document.createElement("li");
      listitem.innerHTML = user.username;
      userlist.appendChild(listitem);
  }
} else {
}
});

